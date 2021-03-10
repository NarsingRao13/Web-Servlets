import java.sql.*;

import javax.swing.SpinnerListModel;

public class MysqlCon {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");  //load driver
			Connection conob = DriverManager.getConnection("jdbc:mysql://localhost:3306/narsing","root","root");
			Statement stm = conob.createStatement();
			ResultSet rs = stm.executeQuery("select * from table1");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
			}
			conob.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
