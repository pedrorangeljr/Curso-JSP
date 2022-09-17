package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conection.SingleConnection;
import model.ModelLogin;

public class DaoUsuarioRepository {

	private Connection connection;

	public DaoUsuarioRepository() {

		connection = SingleConnection.getConnection();
	}

	/* Metodo para Salvar Usuario no banco */

	public ModelLogin gravarUsuario(ModelLogin objeto) throws Exception {

		try {

			if (objeto.isNovo()) { // grava um novo.

				String sql = "insert into model_login(login,senha,nome,email)values(?,?,?,?)";
				PreparedStatement insert = connection.prepareStatement(sql);

				insert.setString(1, objeto.getLogin());
				insert.setString(2, objeto.getSenha());
				insert.setString(3, objeto.getNome());
				insert.setString(4, objeto.getEmail());
				insert.execute();

				connection.commit();

			} else {

				String sql = "update model_login set login = ?, senha = ?, nome = ?, email = ? where id = "
						+ objeto.getId() + "";
				PreparedStatement update = connection.prepareStatement(sql);

				update.setString(1, objeto.getLogin());
				update.setString(2, objeto.getSenha());
				update.setString(3, objeto.getNome());
				update.setString(4, objeto.getEmail());

				update.executeUpdate();

				connection.commit();
			}

		} catch (Exception e) {

			e.printStackTrace(); /* Imprime a pilha de erro no console */
		}

		return this.consultaUsuario(objeto.getLogin());
	}

	public ModelLogin consultaUsuario(String login) throws Exception {

		ModelLogin modelLogin = new ModelLogin();

		String sql = "select * from model_login where upper(login) = upper('" + login + "')";

		PreparedStatement select = connection.prepareStatement(sql);

		ResultSet resultado = select.executeQuery();

		while (resultado.next()) {

			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setNome(resultado.getString("nome"));
			modelLogin.setLogin(resultado.getString("login"));
			modelLogin.setSenha(resultado.getString("senha"));
			modelLogin.setEmail(resultado.getString("email"));

		}

		return modelLogin;
	}

	/* Não deixa gravar login repitido ou duplicado */

	public boolean validarLogin(String login) throws Exception {

		String sql = "select count(1) > 0 as existe from model_login where upper(login) = upper('" + login + "')";
		PreparedStatement validar = connection.prepareStatement(sql);

		ResultSet resultado = validar.executeQuery();

		resultado.next(); // Para entrar nos resultados do sql.

		return resultado.getBoolean("existe");

	}
	
	public void deletaruser(String idUser)throws Exception {
		
		String sql = "delete from model_login where id = ?";
		PreparedStatement deletar = connection.prepareStatement(sql);
		deletar.setLong(1, Long.parseLong(idUser));
		deletar.executeUpdate();
		
		connection.commit();
		
	}
}
