package com.netmind.db;

import com.netmind.models.Usuario;

public abstract class UsuarioDAO extends DAO {
	public abstract Usuario getUsuario(String email, String pass);
	public abstract Usuario getUsuario(int uid);
	public abstract boolean delUsuario(int uid);
	public abstract boolean insertUsuario(Usuario user);
	public abstract boolean updateUsuario(Usuario user);
}
