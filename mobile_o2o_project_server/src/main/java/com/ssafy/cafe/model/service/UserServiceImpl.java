package com.ssafy.cafe.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.cafe.model.dao.UserDao;
import com.ssafy.cafe.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User login(String email, String password) {
		User user = userDao.login(email, password);
		if (user == null) {
			throw new RuntimeException("Invalid email or password");
		}
		return user;
	}

	@Override
	public boolean isUsedEmail(String email) {
		return userDao.getUserByEmail(email) != null;
	}

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.deleteUser(userId);
	}

	@Override
	public User getUserById(Long userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public int getStamps(Long userId) {
		return userDao.getStamps(userId);
	}

	@Override
	public void updateStamps(Long userId, int stamps) {
		userDao.updateStamps(userId, stamps);
	}

	@Override
	public int getPoints(Long userId) {
		return userDao.getPoints(userId);
	}

	@Override
	public void updatePoints(Long userId, int points) {
		userDao.updatePoints(userId, points);
	}

}
