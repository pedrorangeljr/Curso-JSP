package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conection.SingleConnection;
import model.ModelLogin;

public class DaoUsuarioRepository  {

	private Connection connection;
	
	public DaoUsuarioRepository() {
		
		connection = SingleConnection.getConnection();
	}
	
	
	/*Metodo para Salvar Usuário no banco*/
	
	public void gravarUsuario(ModelLogin objeto) {
		
		try {
			
			String sql = "insert into model_login(login,senha,nome,email)values(?,?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, objeto.getLogin());
			insert.setString(2, objeto.getSenha());
			insert.setString(3, objeto.getNome());
			insert.setString(4, objeto.getEmail());
			insert.execute();
			
			connection.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace(); /*Imprime a pilha de erro no console*/
		}
		
		
	}

}
