package com.learn.springb3.service;

import java.util.List;

import com.learn.springb3.dto.UserDTO;

public interface UserService {
    UserDTO save(UserDTO userDTO);
    UserDTO findById(Integer id);
    List<UserDTO> findAll();
    List<UserDTO> findUsersCreatedToday();
	List<UserDTO> findUsersCreatedByYear(Integer year);
	UserDTO findByEmail(String email);
	void delete(UserDTO userDTO);
}