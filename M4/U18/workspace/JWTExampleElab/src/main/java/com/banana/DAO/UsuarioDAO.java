package com.banana.DAO;

import com.banana.modelos.Usuario;

public abstract class UsuarioDAO extends DAO {
	public abstract Usuario getUsuario(String username, String password) throws Exception;
	public abstract Usuario getUsuarioByMail(String email) throws Exception;
}
