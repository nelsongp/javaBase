package com.usertest.data.usuario;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.usertest.entity.Usuarios;
import com.usertest.repository.UsuariosRepository;

@Service("UserDataBase")
public class UserDataBase implements IUserData{
	private UsuariosRepository repo;
	private Logger log;

	@Override
	public Boolean saveUsuario(Usuarios usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
