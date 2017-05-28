package com.algodaodoce.easybook.utils;

public class Path {

	///////////////////////////////////////////////////////////////
	// ROOT PATH
	///////////////////////////////////////////////////////////////

	public static final String ALL = "/**";

	public static final String PUBLICO_ROOT_PATH =  "/publico";

	public static final String PRIVADO_ROOT_PATH =  "/privado";

	///////////////////////////////////////////////////////////////
	// PRIVATE PATHS
	///////////////////////////////////////////////////////////////

	public static final String LIVRO_PATH = PRIVADO_ROOT_PATH + "/livro";

	public static final String USUARIO_PATH = PRIVADO_ROOT_PATH + "/usuario";

	///////////////////////////////////////////////////////////////
	// PUBLIC PATHS
	///////////////////////////////////////////////////////////////
	
	public static final String HOME_PATH = PUBLICO_ROOT_PATH + "/";

	public static final String LOGIN_PATH = PUBLICO_ROOT_PATH + "/login";

	public static final String LOGOUT_PATH = PUBLICO_ROOT_PATH + "/logout";
	
	public static final String CADASTRO_PATH = PUBLICO_ROOT_PATH + "/cadastro";
}