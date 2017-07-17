package jdbc;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustData cd = new CustData();
		try{
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/b6", "postgres", "abcd12345");
				System.out.println("Got the Connection");
				Statement st = con.createStatement();
				String sql = "SELECt name, password FROM cust_info";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					String name = rs.getString(1);
					String pass = rs.getString(2);
					System.out.println("Credentials Stored :"+name+ " "+ pass);
				}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		}

}

class CustData{
	
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}