package com.usertest.data.usuario;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.usertest.entity.Usuarios;
import com.usertest.repository.UsuariosRepository;

@Service("UserDataBase")
public class UserDataBase implements IUserData{
	private UsuariosRepository repo;
	private Logger log;
	
	public UserDataBase(UsuariosRepository repo) {
		this.repo = repo;
		this.log =  LoggerFactory.getLogger("com.loyalty.logger");
	}

	@Override
	public Boolean saveUsuario(Usuarios usuario) {
		try {
			repo.save(usuario);
			return true;
		} catch (Exception e) {
			log.error("Error creating user");
			return false;
		}		
	}

	@Override
	public Boolean findUsuario(String usuario) {
		try {
			Optional<Usuarios> findUser = repo.findById(usuario);
			if(findUser.isPresent())
				return true;
			else
				return false;
		} catch (Exception e) {
			log.error("Error al buscar el usuario en la base de datos: {}", e.getMessage(), e);
			return false;
		}		
	}

}
