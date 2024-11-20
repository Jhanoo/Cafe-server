package com.ssafy.cafe.controller.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.cafe.model.dto.LoginRequest;
import com.ssafy.cafe.model.dto.User;
import com.ssafy.cafe.model.service.OrderService;
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

	@PostMapping
	@Operation(summary = "사용자 정보를 추가한다. 성공하면 true를 리턴한다. "
		, description = "<pre>사용자를 추가하는 샘플코드\n" 
			+ "{\r\n"
			+ "  \"email\": \"sample@sample.com\",\r\n" 
			+ "  \"username\": \"쌉쌉이\",\r\n"
			+ "  \"password\": \"ssafssaf\",\r\n" 
			+ "  \"birthday\": \"???\"\r\n" + "}" 
			+ "</pre>")
	public ResponseEntity<Void> insertUser(@RequestBody User user) {
		logger.debug("user.insert", user);
        userService.insertUser(user);
        return ResponseEntity.ok().build();
	}

	@GetMapping("/isUsedEmail")
	@Operation(summary = "request parameter로 전달된 email이 이미 사용중인지 반환한다.")
	public ResponseEntity<Boolean> isUsedEmail(String email) {
		boolean isUsed = userService.isUsedEmail(email);
		return ResponseEntity.ok(isUsed);
	}

	@PostMapping("/login")
	@Operation(summary = "로그인 처리 후 성공적으로 로그인 되었다면 loginId라는 쿠키를 내려보낸다."
		, description = "<pre>아래는 email, password만 입력한 샘플코드\n"
			+ "{\r\n" 
			+ "  \"email\": \"sample@sample.com\",\r\n" 
			+ "  \"password\": \"ssafssaf\"\r\n" 
			+ "}" 
			+ "</pre>")
	public ResponseEntity<User> login(@RequestBody LoginRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		User selected = userService.login(request.getEmail(), request.getPassword());
		if (selected != null) {
			Cookie cookie = new Cookie("loginEmail", URLEncoder.encode(selected.getEmail(), "utf-8"));
			cookie.setMaxAge(60 * 60 * 24 * 30); // 30일
			response.addCookie(cookie);
		}
		return ResponseEntity.ok(selected);
	}

	// password를 sharedpreference에 저장하면 안되니, id만 받는데,
	// 이 id와 쿠키에 있는 id가 같은지 확인해서 로그인 사용자를 조회해서 리턴함.
	@GetMapping("/info")
	@Operation(summary = "사용자의 정보를 반환한다."
		, description = "로그인 성공한 cookie 정보가 없으면 null 리턴")
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

		User selected = userService.getUserByEmail(email);

		if (!email.equals(emailInCookie)) {
			logger.info("different cookie value : inputValue : {}, inCookie:{}", email, emailInCookie);
			selected = null; // 사용자 정보 삭제.
		} else {
			logger.info("valid cookie value : inputValue : {}, inCookie:{}", email, emailInCookie);
		}

		if (selected == null) {
			Map<String, Object> map = new HashMap<>();
			map.put("user", new User());
			return map;
		} else {
			Map<String, Object> info = new HashMap<>();
			info.put("user", selected);
			return info;
		}
	}
	

    @PutMapping("/{userId}/points")
    public ResponseEntity<Void> updateUserPoints(@PathVariable Long userId, int points) {
        userService.updatePoints(userId, points);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/stamps")
    public ResponseEntity<Void> updateUserStamps(@PathVariable Long userId, int stamps) {
        userService.updateStamps(userId, stamps);
        return ResponseEntity.ok().build();
    }

}
