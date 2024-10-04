package com.learn.springb3.helper;
import java.util.Date;
import com.learn.springb3.dto.UserDTO;
import com.learn.springb3.entity.UserEntity;
import java.util.List;

public class UserHelper {

	private UserHelper() {
		
	}

	public static UserDTO newUserDTO() {
		return UserDTO.builder().name("test").email("test").build();
	}

	public static UserDTO newUserDTOTag() {
		return UserDTO.builder().name("test").email("test").tags("SALES").build();
	}
	
	public static UserDTO createdUserDTO() {
		return UserDTO.builder().id(1).name("test").email("test").createdAt(new Date()).build();	
	}

	public static UserEntity newUserEntity() {
		return UserEntity.builder().name("test").email("test").build();
	}
	
	public static UserEntity createdUserEntity() {
		return UserEntity.builder().id(1).name("test").email("test").createdAt(new Date()).build();	
	}
	
	public static List<UserEntity> createdUserEntityList() {
        return List.of(createdUserEntity());
    }

    public static List<UserDTO> createdUserDTOList() {
        return List.of(createdUserDTO());
    }


	
}