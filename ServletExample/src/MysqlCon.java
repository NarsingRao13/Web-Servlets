import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlCon {

	
	public void callDataBase(String n, String p) {
		try{
			Class.forName("com.mysql.jdbc.Driver");  //load driver
			Connection conob = DriverManager.getConnection("jdbc:mysql://localhost:3306/narsing?characterEncoding=latin1","root","n@rsingK#13");
			
			
			PreparedStatement ps=conob.prepareStatement(  
					"insert into registration values(?,?)");  
			ps.setString(1, n);
			ps.setString(2, p);
			
			int i=ps.executeUpdate();  
			if(i>0)  
			System.out.print("You are successfully registered...");  
			
			Statement stm = conob.createStatement();
			
			// ResultSet rs = stm.executeQuery("select * from table1");
			/*
			 * while(rs.next()){
			 * System.out.println(rs.getInt(1)+"  "+rs.getString(2)); }
			 */	
			MysqlCon.getUsers("rao", conob);
			conob.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void getUsers(String n,Connection ob){
		try{  
            //Connection con=EmpDao.getConnection();  
            PreparedStatement ps=ob.prepareStatement("select * from registration where userName=?");  
            ps.setString(1, n);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
            	System.out.println("data: "+rs.getString(1)+"  "+rs.getString(2)); 
            }  
          //  con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
	}
	
	public void login() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conob = DriverManager.getConnection("jdbc:mysql://localhost:3306/narsing?characterEncoding=latin1","root","n@rsingK#13");
			Statement stm = conob.createStatement();
			//List<UserDetails> loginCredentials = new ArrayList<UserDetails>();
			ResultSet rs1 = stm.executeQuery("select * from registration");
			while(rs1.next()){
				System.out.println(rs1.getString(1)+"  "+rs1.getString(2));  
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}  //load driver
		
		
	}

}
