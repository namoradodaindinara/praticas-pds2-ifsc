package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Person;

public class PersonDAO {

	private DatabaseConnection connection;

	public boolean insert(Person pessoa) {
		connection = DatabaseConnection.getInstance();
		Connection c = connection.connect();
		try {
			String query = "INSERT INTO person_information(cpf, name)values(?,?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, 123);
			stm.setString(2, "Enzo");
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.closeConnection();
		return false;
	}

	public boolean update(Person pessoa) {
		connection = DatabaseConnection.getInstance();
		connection.connect();
		connection.closeConnection();
		return false;
	}

	public boolean delete(Person pessoa) {
		connection = DatabaseConnection.getInstance();
		connection.connect();
		connection.closeConnection();
		return false;
	}

	public ArrayList<Person> selectAll() {
		ArrayList<Person> pessoas = new ArrayList<>();
		connection = DatabaseConnection.getInstance();
		Connection c = connection.connect();
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM person_information";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int cpf = rs.getInt("cpf");
				String name = rs.getString("name");
				Person p = new Person(name, cpf);
				p.setCpf(cpf);
				p.setName(name);
				pessoas.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.closeConnection();
		return pessoas;
	}

}