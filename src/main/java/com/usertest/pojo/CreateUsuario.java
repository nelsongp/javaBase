package com.usertest.pojo;

import com.usertest.entity.UserInfo;
import com.usertest.entity.Usuarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUsuario {
	private UserInfo userInfo;
	private Usuarios usuario;
}
