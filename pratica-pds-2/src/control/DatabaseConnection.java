package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection connection;
	private static DatabaseConnection instance;
	private static final String DATABASE = "aula_pds";
	private static final String USER = "root";
	private static final String PSW = "aluno";

	private DatabaseConnection() {

	}

	public static DatabaseConnection getInstance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	public Connection connect() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER,
					PSW);
			System.out.println("Conectado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public boolean closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}