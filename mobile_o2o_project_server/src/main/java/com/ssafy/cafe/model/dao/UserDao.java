package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.User;

public interface UserDao {

	List<User> getAllUsers();

	User getUserByEmail(String email);
	
    User getUserById(Long userId);

	int insertUser(User user);

	void deleteUser(Long userId);

	User login(String email, String password);

	User isUsedEmail(String email);

	void updateStamps(Long userId, int stamps);
	
    void updatePoints(Long userId, int points);

	// 특정 사용자의 알레르기 정보 가져오기
	List<String> getAllergensByUserId(Long userId);

	// 사용자의 알레르기 추가
	void addUserAllergen(Long userId, Long allergenId);

	// 사용자의 특정 알레르기 제거
	void deleteUserAllergen(Long userId, Long allergenId);
}
