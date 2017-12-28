package objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBmanager {

	private Connection conn;

	public DBmanager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://localhost/QuizMe?user=root&password=21003Nat!&useSSL=false");
		} catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out.println("ClassNotFoundException: " + cnfe.getMessage());
		}
	}

	public void addUser(String email, String password) {
		String deptQuery = "INSERT INTO User (email, password) VALUES (?, ?)";
		try {
			PreparedStatement deptStmt = conn.prepareStatement(deptQuery);
			deptStmt.setString(1, email);
			deptStmt.setString(2, password);
			deptStmt.addBatch();
			deptStmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Boolean checkEmail(String email) {
		Boolean found = false;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM User WHERE email=" + "'" + email + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				found = true;
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		return found;
	}

	public Boolean checkPass(String email, String pass) {
		Boolean valid = false;
		Statement stmt = null;
		String password = "";
		try {
			stmt = conn.createStatement();
			String query = "SELECT password FROM User WHERE email=" + "'" + email + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				password = rs.getString("password");
			}
			if (pass.equals(password)) {
				valid = true;
			}
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		}
		return valid;
	}

	public ArrayList<Deck> getDecks(Integer user_id) {
		ArrayList<Deck> decks = new ArrayList<Deck>();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String query = "SELECT name, description FROM Deck WHERE user_id=" + "'" + user_id + "'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Deck temp = new Deck();
				// Name
				temp.setName(rs.getString("name"));
				// Description
				temp.setDescription(rs.getString("description"));
				decks.add(temp);
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
		}
		return decks;
	}

	public void addCard(String front, String back, String deck_name) {
		Integer id = getDeckID(deck_name);
		String query = "INSERT INTO Card (front, back, deck_id) VALUES (?, ?, ?)";
		try {
			PreparedStatement deptStmt = conn.prepareStatement(query);
			deptStmt.setString(1, front);
			deptStmt.setString(2, back);
			deptStmt.setInt(3, id);
			deptStmt.addBatch();
			deptStmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addDeck(String name, String desc, Integer user_id) {
		String query = "INSERT INTO Deck (name, description, user_id) VALUES (?, ?, ?)";
		try {
			PreparedStatement deptStmt = conn.prepareStatement(query);
			deptStmt.setString(1, name);
			deptStmt.setString(2, desc);
			deptStmt.setInt(3, user_id);
			deptStmt.addBatch();
			deptStmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Integer getID(String email, String password) {
		Statement stmt = null;
		Integer id = 0;
		try {
			stmt = conn.createStatement();
			String query = "SELECT user_id FROM User WHERE email=" + "'" + email + "'" + " AND password=" + "'"
					+ password + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				id = rs.getInt("user_id");
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
		}
		return id;
	}

	public Integer getDeckID(String name) {
		Statement stmt = null;
		Integer id = 0;
		try {
			stmt = conn.createStatement();
			String query = "SELECT deck_id FROM Deck WHERE name=" + "'" + name + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				id = rs.getInt("deck_id");
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
		}
		return id;
	}

	public ArrayList<Card> getCards(Integer deck_id) {
		ArrayList<Card> cards = new ArrayList<Card>();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			String query = "SELECT front, back FROM Card WHERE deck_id=" + deck_id;
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Card temp = new Card();
				temp.setTerm(rs.getString("front"));
				System.out.println(temp.getTerm());
				temp.setDefinition(rs.getString("back"));
				System.out.println(temp.getDefinition());
				cards.add(temp);
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
		}
		return cards;
	}
}
