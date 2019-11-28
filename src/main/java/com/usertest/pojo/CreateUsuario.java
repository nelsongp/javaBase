package com.usertest.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUsuario {
	private String userName;
	private String password;
	private String userFirstName;
	private String userLastName;
	private Integer userAge;
	private String userAddress;
}
