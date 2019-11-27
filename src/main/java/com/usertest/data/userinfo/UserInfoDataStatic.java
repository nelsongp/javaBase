package com.usertest.data.userinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usertest.entity.UserInfo;
import com.usertest.entity.Usuarios;

@Service("UserInfoStatic")
public class UserInfoDataStatic implements IUserInfoData{
	List<Usuarios> lstUsuario = new ArrayList<>();
	
	public UserInfoDataStatic() {
		Usuarios usuario = new Usuarios();
		usuario.setUsername("13225566");
		usuario.setUserpassword("test1234");		
		lstUsuario.add(usuario);
	}

	@Override
	public Boolean saveUserInfoData(UserInfo userInfo) {
		Optional<Usuarios> opt = lstUsuario.stream().filter(x->x.getUsername().equals(userInfo.getId())).findFirst();
		if(opt.isPresent())			
			return true;
		else
			return false;
	}

}
