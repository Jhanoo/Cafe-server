package com.ssafy.cafe.model.service;

import java.util.List;

import com.ssafy.cafe.model.dto.User;

public interface UserService {
	public int insertUser(User user);

	public User login(String email, String password);

	public boolean isUsedEmail(String email);

	public User getUserByEmail(String email);

	public User getUserById(Long userId);

	public List<User> getAllUsers();

	public void deleteUser(Long userId);

	public void updatePoints(Long userId, int points);

	public void updateStamps(Long userId, int stamps);
}
