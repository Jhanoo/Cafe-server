package com.ssafy.cafe.model.dao;

import java.util.List;

import com.ssafy.cafe.model.dto.User;

public interface UserDao {

	List<User> getAllUsers(); // 필요한가?

	User getUserByEmail(String email);
	
    User getUserById(Long userId);

	int insertUser(User user);
	
	void updateUser(User user);

	void deleteUser(Long userId);

	User login(String email, String password);

	User isUsedEmail(String email);

	// 스탬프, 포인트
	int getStamps(Long userId);
	
	void updateStamps(Long userId, int stamps);

	int getPoints(Long userId);
	
    void updatePoints(Long userId, int points);

    // 알러지
	List<String> getAllergensByUserId(Long userId);

	void addUserAllergen(Long userId, Long allergenId);

	void deleteUserAllergen(Long userId, Long allergenId);
}
