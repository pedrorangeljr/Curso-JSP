package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conection.SingleConnection;
import model.ModelLogin;

public class DaoLogin {

	private Connection connection;
	
	public DaoLogin() {
		
		connection = SingleConnection.getConnection();
	}
	
	/*Metodo para validar Login e Senha*/
	public boolean validarAutenticacao(ModelLogin modelLogin) throws Exception {
		
		String sql = "select * from model_login where upper(login) = upper(?) and upper(senha) = upper(?)";
		PreparedStatement validar = connection.prepareStatement(sql);
		
		validar.setString(1, modelLogin.getLogin());
		validar.setString(2, modelLogin.getSenha());
		
		ResultSet resultado = validar.executeQuery();
		
		if(resultado.next()) {
			
			return true; /*Autenticado*/
		}
		
		return false; /*Não Autenticado*/
	} 
}
