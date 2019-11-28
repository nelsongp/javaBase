package com.usertest.process;

import com.usertest.pojo.CreateUsuario;
import com.usertest.pojo.userresponse.UserResponse;

public interface IUserProcess {
	public UserResponse saveUser(CreateUsuario createUsuario);

}
