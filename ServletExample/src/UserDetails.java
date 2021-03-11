
public class UserDetails {
	String userName;
	String userPass;

	public UserDetails() {
		super();
	}

	public UserDetails(String userName, String userPass) {
		super();
		this.userName = userName;
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

}
