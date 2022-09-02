package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conection.SingleConnection;
import model.ModelLogin;

public class DaoUsuarioRepository  {

	private Connection connection;
	
	public DaoUsuarioRepository() {
		
		connection = SingleConnection.getConnection();
	}
	
	
	/*Metodo para Salvar Usuário no banco*/
	
	public ModelLogin gravarUsuario(ModelLogin objeto) throws Exception {
		
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
		
		return this.consultaUsuario(objeto.getLogin());
	}
	
	public ModelLogin consultaUsuario(String login) throws Exception{
		
		ModelLogin modelLogin = new ModelLogin();
		
		String sql = "select * from model_login where upper(login) = upper('"+login+"')";
		
		PreparedStatement select = connection.prepareStatement(sql);
		
		ResultSet resultado = select.executeQuery();
		
		while(resultado.next()) {
			
			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setNome(resultado.getString("nome"));
			modelLogin.setLogin(resultado.getString("login"));
			modelLogin.setSenha(resultado.getString("senha"));
			modelLogin.setEmail(resultado.getString("email"));
			
			
		}
		
		
		return modelLogin;
	}

}
