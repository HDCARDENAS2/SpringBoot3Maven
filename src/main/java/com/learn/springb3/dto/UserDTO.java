package com.learn.springb3.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9123736654067852735L;
	
	private Integer id;
	@NotEmpty
	@Size(max=30)
	private String name;
	@NotEmpty
	@Size(max=30)
	private String email;
	@JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
	@NotEmpty
	@Size(max=200)
	private String tags;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
	
}
