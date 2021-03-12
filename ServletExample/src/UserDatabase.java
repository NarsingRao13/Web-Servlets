import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabase {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/narsing?characterEncoding=latin1", "root",
					"root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(UserDetails ob) {
		int status = 0;
		try {
			Connection con = UserDatabase.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into registration values(?,?)");
			ps.setString(1, ob.getUserName());
			ps.setString(2, ob.getUserPass());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return status;
	}

	public static UserDetails getUser(String n) {
		UserDetails user = new UserDetails();

		try {
			Connection con = UserDatabase.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from registration where userName=?");
			ps.setString(1, n);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserName(rs.getString(1));
				user.setUserPass(rs.getString(2));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public static boolean loginValidate(String name, String pass) {
		boolean status = false;
		try {
			Connection con = UserDatabase.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from registration where userName=? and userPassword=?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	
	public static int updatePassword(UserDetails user)
	{
		int stat = 0;
		String query = "update registration set userPassword=? where userName = ?";
		try {
			Connection con = UserDatabase.getConnection();
			/*PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPass());*/
			
			PreparedStatement ps = con
					.prepareStatement(query);
			ps.setString(1, user.getUserPass());
			ps.setString(2, user.getUserName());
			
		
			
			stat = ps.executeUpdate();
			System.out.println("\n"+stat);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return stat;
	}

}