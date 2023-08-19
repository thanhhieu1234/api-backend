package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Long id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private Boolean status;
	private List<String> roles;

}
