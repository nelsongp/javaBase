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
	private String usuario;
	private String password;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String direccion;
}
