package conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url="jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true"; /*Static por sempre vai ser a mesma URL. N?o vai mudar. */
	private static String user = "postgres";
	private static String password = "admin";
	private static  Connection connection = null;
	
	static {
		
		conectar();
	}

	public SingleConnection() {
		
		conectar();
		
	}
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				
				Class.forName("org.postgresql.Driver"); /*Carrega o driver de Conex?o*/
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		return connection;
	}
}
