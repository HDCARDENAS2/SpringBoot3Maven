package com.learn.springb3.service;

import com.learn.springb3.dto.UserDTO;
import com.learn.springb3.exception.BussinesException;
import com.learn.springb3.exception.NotExistsException;

public interface UserManagerService {
	
    UserDTO create(UserDTO userDTO) throws BussinesException;
	void delete(Integer id) throws NotExistsException;
}