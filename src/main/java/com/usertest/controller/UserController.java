package com.usertest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usertest.pojo.CreateUsuario;
import com.usertest.pojo.userresponse.UserResponse;
import com.usertest.process.IUserProcess;

@RestController
public class UserController {
	private IUserProcess process;
	
	public UserController(IUserProcess process) {
		this.process = process;
	}
	
	@PostMapping("{config.endpoints.usuarios.save}")
	public UserResponse saveUser(
			@RequestBody CreateUsuario createUsuario) {
		return process.saveUser(createUsuario);
		};
}
