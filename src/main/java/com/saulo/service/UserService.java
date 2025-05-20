package com.saulo.service;

import com.saulo.domain.model.User;

public interface UserService {

	User findById(Long id);

	User create(User user);

}
