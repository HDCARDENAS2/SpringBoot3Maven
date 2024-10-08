package com.learn.springb3.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.learn.springb3.dto.UserDTO;
import com.learn.springb3.entity.UserEntity;

@Mapper
public interface UserMapper {

	UserEntity toEntity(UserDTO userDTO);

	UserDTO toDTO(UserEntity userEntity);
	
	List<UserEntity> toEntityList(List<UserDTO> userDTOList);
	
	List<UserDTO> toDTOList(List<UserEntity> userEntityList);
	
}
