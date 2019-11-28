package com.usertest.data.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usertest.entity.Usuarios;


/**
 * @author nguardado
 * @param usuario recibe la informacion del usuario a guardar
 */
@Service("UserDataStatic")
public class UserDataStatic implements IUserData{

	@Override
	public Boolean saveUsuario(Usuarios usuario) {
		List<Usuarios> lstUsuarios = new ArrayList<>();
		lstUsuarios.add(usuario);
		Optional<Usuarios> findUser = lstUsuarios.stream().filter(x -> usuario.getUsername().equals(x.getUsername())).findFirst();
		if(findUser.isPresent())			
			return true;
		else 
			return false;
	}

	@Override
	public Boolean findUsuario(String usuario) {
		
		return null;
	}

}
