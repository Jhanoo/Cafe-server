package com.ssafy.cafe.controller.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.Allergen;
import com.ssafy.cafe.model.dto.CartItem;
import com.ssafy.cafe.model.dto.LoginRequest;
import com.ssafy.cafe.model.dto.User;
import com.ssafy.cafe.model.service.AllergenService;
import com.ssafy.cafe.model.service.FileStorageService;
import com.ssafy.cafe.model.service.OrderService;
import com.ssafy.cafe.model.service.ShoppingCartService;
import com.ssafy.cafe.model.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;
	
	@Autowired
	ShoppingCartService cartService;

	@Autowired
	AllergenService allergenService;

	@Autowired
	FileStorageService fileStorageService;

	@PostMapping
	@Operation(summary = "사용자 정보 추가", description = "<pre>사용자를 추가하는 샘플코드\n" + "{\r\n"
			+ "  \"email\": \"ssaf@ssafy.com\",\r\n" + "  \"name\": \"쌉쌉이\",\r\n" + "  \"password\": \"ssaf\",\r\n"
			+ "  \"birthday\": \"2024-11-20T15:00:00.000+00:00\"\r\n" + "}" + "</pre>")
	public ResponseEntity<Void> insertUser(@RequestBody User user) {
		logger.debug("user.insert", user);
		userService.insertUser(user);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/isUsedEmail")
	@Operation(summary = "이메일 사용 여부 확인", description = "request parameter로 전달된 email이 이미 사용 중인지 여부를 반환합니다.")
	public ResponseEntity<Boolean> isUsedEmail(String email) {
		boolean isUsed = userService.isUsedEmail(email);
		return ResponseEntity.ok(isUsed);
	}

	@PostMapping("/login")
	@Operation(summary = "로그인 처리", description = "<pre>아래는 email, password만 입력한 샘플코드\n" + "{\r\n"
			+ "  \"email\": \"ssaf@ssafy.com\",\r\n" + "  \"password\": \"ssafssaf\"\r\n" + "}"
			+ "</pre>로그인 성공 시 loginEmail라는 쿠키를 내려보냅니다.")
	public ResponseEntity<User> login(@RequestBody LoginRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		User user = userService.login(request.getEmail(), request.getPassword());
		if (user != null) {
			Cookie cookie = new Cookie("loginEmail", URLEncoder.encode(user.getEmail(), "utf-8"));
			cookie.setMaxAge(60 * 60 * 24 * 30); // 30일
			response.addCookie(cookie);

			List<Allergen> allergens = allergenService.getAllergensByUserId(user.getUserId());
			user.setAllergens(allergens);

			List<CartItem> shoppingCart = cartService.getCartByUserId(user.getUserId());
			user.setShoppingCart(shoppingCart);
		}
		return ResponseEntity.ok(user);
	}

	@GetMapping("/info")
	@Operation(summary = "사용자의 정보 조회", description = "로그인 성공 후 쿠키 정보를 이용해 사용자의 정보를 반환합니다. 로그인 정보가 없으면 null을 반환합니다.")
	public Map<String, Object> getInfo(HttpServletRequest request, String email) {
		String emailInCookie = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				try {
					if ("loginEmail".equals(cookie.getName())) {
						emailInCookie = URLDecoder.decode(cookie.getValue(), "utf-8");
						System.out.println("value : " + URLDecoder.decode(cookie.getValue(), "utf-8"));
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}

		User user = userService.getUserByEmail(email);

		if (!email.equals(emailInCookie)) {
			logger.info("different cookie value : inputValue : {}, inCookie:{}", email, emailInCookie);
			user = null; // 사용자 정보 삭제.
		} else {
			logger.info("valid cookie value : inputValue : {}, inCookie:{}", email, emailInCookie);
		}

		if (user == null) {
			Map<String, Object> map = new HashMap<>();
			map.put("user", new User());
			return map;
		} else {
			Map<String, Object> info = new HashMap<>();

			List<Allergen> allergens = allergenService.getAllergensByUserId(user.getUserId());
			user.setAllergens(allergens);

			List<CartItem> shoppingCart = cartService.getCartByUserId(user.getUserId());
			user.setShoppingCart(shoppingCart);
			
			info.put("user", user);
			return info;
		}
	}

	@PutMapping
	@Operation(summary = "사용자 정보 업데이트", description = "사용자의 정보를 업데이트합니다.")
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		allergenService.deleteAllAllergenByUser(user.getUserId());
		for (Allergen allergen : user.getAllergens()) {
			allergenService.insertAllergenToUser(user.getUserId(), allergen.getAllergenId());
		}
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{userId}/image")
	@Operation(summary = "사용자 이미지 삭제", description = "userId에 해당하는 사용자의 이미지를 삭제합니다. 삭제된 파일의 이름을 반환합니다.")
	public ResponseEntity<String> deleteImage(@PathVariable Long userId) {
		User user = userService.getUserById(userId);
		String filename = user.getImage();
		user.setImage(null);
		try {
			// 파일 저장 경로
			Path filePath = Paths.get(fileStorageService.getUploadDir(), filename);

			// 파일이 존재하는지 확인
			if (!Files.exists(filePath)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found: " + filename);
			}

			// 파일 삭제
			Files.delete(filePath);

			return ResponseEntity.ok("File deleted successfully: " + filename);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error deleting file: " + e.getMessage());
		}
	}

	@PutMapping("/{userId}/points")
	@Operation(summary = "사용자 포인트 업데이트", description = "사용자의 포인트를 업데이트합니다. userId와 업데이트할 포인트를 전달합니다.")
	public ResponseEntity<Void> updatePoints(@PathVariable Long userId, int points) {
		userService.updatePoints(userId, points);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{userId}/stamps")
	@Operation(summary = "사용자 스탬프 업데이트", description = "사용자의 스탬프 개수를 업데이트합니다. userId와 업데이트할 스탬프 수를 전달합니다.")
	public ResponseEntity<Void> updateStamps(@PathVariable Long userId, int stamps) {
		userService.updateStamps(userId, stamps);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{userId}/cart")
	@Operation(summary = "장바구니 조회", description = "해당 userId에 대한 장바구니 정보를 조회합니다.")
	public ResponseEntity<List<CartItem>> getCartByUserId(@PathVariable Long userId) {
		return ResponseEntity.ok(cartService.getCartByUserId(userId));
	}

	@PostMapping("/{userId}/cart")
	@Operation(summary = "장바구니에 아이템 추가", description = "userId에 해당하는 사용자의 장바구니에 아이템을 추가합니다.")
	public ResponseEntity<Void> addToCart(@RequestBody CartItem cartItem) {
		cartService.addToCart(cartItem);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{userId}/cart/{cartId}")
	@Operation(summary = "장바구니 아이템 삭제", description = "userId에 해당하는 사용자의 장바구니에서 특정 cartId의 아이템을 삭제합니다.")
	public ResponseEntity<Void> removeFromCart(@PathVariable Long cartId) {
		cartService.removeFromCart(cartId);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{userId}/cart/clear")
	@Operation(summary = "장바구니 전체 삭제", description = "userId에 해당하는 사용자의 장바구니를 모두 삭제합니다.")
	public ResponseEntity<Void> clearCartByUserId(@PathVariable Long userId) {
		cartService.clearCartByUserId(userId);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/{userId}/allergen/{allergenId}")
	@Operation(summary = "사용자 알레르기 유발 성분 추가", description = "userId에 해당하는 사용자의 알레르기 유발 성분 목록에 allergenId를 추가합니다.")
	public ResponseEntity<Void> insertAllergenToUser(@PathVariable Long userId, @PathVariable Long allergenId) {
		allergenService.insertAllergenToUser(userId, allergenId);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{userId}/allergen/{allergenId}")
	@Operation(summary = "사용자 알레르기 유발 성분 삭제", description = "userId에 해당하는 사용자의 알레르기 유발 성분 목록에서 allergenId를 삭제합니다.")
	public ResponseEntity<Void> deleteAllergenMappingByUser(@PathVariable Long userId, @PathVariable Long allergenId) {
		allergenService.deleteAllergenMappingByUser(userId, allergenId);
		return ResponseEntity.ok().build();
	}

}
