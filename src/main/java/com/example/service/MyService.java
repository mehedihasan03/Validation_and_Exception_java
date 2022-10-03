package com.example.service;

import com.example.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class MyService {

	private final UserRepository userRepo;

	public MyService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public User saveUser(User user) {
		user = userRepo.save(user);
		return user;
	}

	public User updateUser(User payload) {
		User userbyId = userRepo.findByUserId(payload.getUserId());
		userbyId.setPassword(payload.getPassword());
		User user = userRepo.save(userbyId);
		return user;
	}

	public User getUserByUserId(String userId) throws UserNotFoundException {

		User user = userRepo.findByUserId(userId);
		if(user != null){
			return user;
		}
		else {
			throw new UserNotFoundException("User not found with id: " + userId);
		}
	}

//
//	public User updateUser(User payload) throws UserNotFoundException {
//		User userbyId = userRepo.findByUserId(payload.getUserId()).orElseThrow(()-> new UserNotFoundException("User ID not found"));
//		userbyId.setPassword(payload.getPassword());
//		User user = userRepo.save(userbyId);
//		return user;
//	}
//
//	public User getUserByUserId(String userId) throws UserNotFoundException {
//
//		return userRepo.findByUserId(userId).orElseThrow(() -> new UserNotFoundException("User ID not found"));
//	}
//
//


}
