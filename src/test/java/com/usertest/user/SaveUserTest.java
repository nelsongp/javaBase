package com.usertest.user;

import org.junit.Assert;
import org.junit.Test;

import com.usertest.data.usuario.UserDataStatic;
import com.usertest.entity.Usuarios;

public class SaveUserTest {
	
	UserDataStatic data = new UserDataStatic();
	
	@Test
	public void saveUser() {		
		Usuarios user = new Usuarios();
		user.setUsername("134215655");
		user.setUsername("123456789");
		Boolean val = data.saveUsuario(user);
		Assert.assertEquals(true, val);
	}
}
