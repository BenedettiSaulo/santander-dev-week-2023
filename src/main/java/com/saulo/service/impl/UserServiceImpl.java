package com.saulo.service.impl;

import com.saulo.domain.model.User;
import com.saulo.domain.repository.UserRepository;
import com.saulo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User user) {
		validateUser(user);

		return userRepository.save(user);
	}

	private void validateUser(User user) {
		if (user.getId() != null && userRepository.existsById(user.getId())) {
			throw new IllegalArgumentException("User already exists");
		}

		if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
			throw new IllegalArgumentException("Account already exists");
		}
	}
}
