package objects;

public class User {
	String email;
	String password;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Integer getID() {
		DBmanager db = new DBmanager();
		return db.getID(this.email, this.password);
	}

}
