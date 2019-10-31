package net.javaguides.electionmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.electionmanagement.model.election;

public class electionDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcelectionname = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_electionS_SQL = "INSERT INTO elections" + "  (name, email, country) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_election_BY_ID = "select id,name,email,country from elections where id =?";
	private static final String SELECT_ALL_electionS = "select * from elections";
	private static final String DELETE_electionS_SQL = "delete from elections where id = ?;";
	private static final String UPDATE_electionS_SQL = "update elections set name = ?,email= ?, country =? where id = ?;";

	public electionDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcelectionname, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertelection(election election) throws SQLException {
		System.out.println(INSERT_electionS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_electionS_SQL)) {
			preparedStatement.setString(1, election.getName());
			preparedStatement.setString(2, election.getEmail());
			preparedStatement.setString(3, election.getCountry());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public election selectelection(int id) {
		election election = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_election_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				election = new election(id, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return election;
	}

	public List<election> selectAllelections() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<election> elections = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_electionS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				elections.add(new election(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return elections;
	}

	public boolean deleteelection(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_electionS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateelection(election election) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_electionS_SQL);) {
			statement.setString(1, election.getName());
			statement.setString(2, election.getEmail());
			statement.setString(3, election.getCountry());
			statement.setInt(4, election.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
