package jdbc;

import java.sql.*;
import java.util.Scanner;

public class RegistrationRespository {
	Scanner scan = new Scanner(System.in);
	private static final String CREATE_QUERY = "create table register(name character varying(40) NOT NULL, password character varying(40) NOT NULL, gender character varying(40) NOT NULL, age character varying(40) NOT NULL, email character varying(50) NOT NULL)";
	private static final String INSERT_QUERY = "INSERT INTO register (name, password, gender, age, email) values(?,?,?,?,?)";
	private static final String DELETE_QUERY = "DELETE FROM register Where name = ?";
	private static final String UPDATE_QUERY = "UPDATE register SET name = ?, password = ?, gender = ?, age = ? Where email = ?";
    private static final String SELECT_ALL_QUERY = "Select * From register";
    private static final String LOGIN_QUERY = "Select name, password From register";
	
	private Connection con = null;
	
	private void getConnection(){
		try {		
			Class.forName("org.postgresql.Driver");
			con  = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "Nikhil@4192");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Couldn't able to connect 1");
		} catch (SQLException e) {
		    e.printStackTrace();
		    System.out.println("Couldn't able to connect 2");
		}	
	}
	
	public boolean createRegistration(){
		boolean result = false;
		PreparedStatement ps = null;
		Statement st = null;
		getConnection();
		try {
			st = con.createStatement();
			boolean istableexist = st.execute("SELECT EXISTS (SELECT 1 FROM pg_tables where schemaname='public' AND tablename='register')");
			if(istableexist){
				System.out.println("Table already created...skiping it");
			}else{
				ps = con.prepareStatement(CREATE_QUERY);
				result = ps.execute();
				System.out.println("successfully created");
			}
			
		} catch (SQLException e) {
			System.out.println("exception in creation");
			e.printStackTrace();
		}
		return result;
		
	}
	
	public boolean validateLogin(String uName, String pwd){
		boolean result = false;
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		getConnection();
		try {
			ps = con.prepareStatement(LOGIN_QUERY);
			rs = ps.executeQuery();
			Boolean b = false;
			while (rs.next()) {        
				if((uName.equals(rs.getString(1))) && (pwd.equals(rs.getObject(2)))){
					result = true;
					break;
				}
			 }
			if(result == true){
				System.out.println("User Logged in Sucessfully");
			}else{
				System.out.println("Sorry user Name and password mismatch. Try again, Thank you");
				System.out.println("Do you want change the pasword: yes or no");
				String s = scan.next();
				if(s.contains("yes")){
					System.out.println("Confirm the user details :");
					System.out.println("Enter the name:");
					String name = scan.nextLine();
					System.out.println("Enter the gender of the user:");
					String g = scan.next();
					System.out.println("Enter the age of the user:");
					int a = scan.nextInt();
					System.out.println();
					System.out.println("Enter the mail id of the user:");
					String m = scan.nextLine();
					
					st = con.createStatement();
					rs1 = st.executeQuery(SELECT_ALL_QUERY);
					while(rs.next()){
						if((name.equals(rs.getObject(1))) && 
								(g.equals(rs.getObject(3))) && (a == rs.getInt(4))
								&& (m.equals(rs.getObject(5)))){
							b = true; 
							break;
						}
					}
					if(b == true){
						deleteCustinfo(m);
						System.out.println("Account deleted sucessfully");
						System.out.println("Kindly provide the user details to register");
						System.out.println("Enter the name:");
						String name1 = scan.nextLine();
						System.out.println("Enter the password for the user name:");
						String pas1 = scan.nextLine();
						System.out.println("Enter the gender of the user:");
						String g1 = scan.next();
						System.out.println("Enter the age of the user:");
						int a1 = scan.nextInt();
						System.out.println();
						System.out.println("Enter the mail id of the user:");
						String m1 = scan.nextLine();
						CustInfo c = new CustInfo(name1, pas1, g1, a1, m1);
						insertCustInfo(c);
					}
					else{
						System.out.println("No account exist with the following details. Kindly register once again");
					}
					
				}if(s.equals("no")){
					System.out.println("Try login once again");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	
	public int insertCustInfo(CustInfo info){
		int result = 0;
		boolean b = false;
		
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(SELECT_ALL_QUERY);
			while(rs.next()){
				if((info.getName().equals(rs.getObject(1))) || (info.getEmail().equals(rs.getObject(5)))){
					b = true; 
					break;
				}
			}
			if(b != true){
			ps = con.prepareStatement(INSERT_QUERY);
			
			ps.setString(1, info.getName());
			ps.setString(2, info.getPassword());
			ps.setString(3, info.getGender());
			ps.setInt(4, info.getAge());
			ps.setString(5, info.getEmail());
			result = ps.executeUpdate();
			System.out.println("inserted successfully");
			}else{
				System.out.println("This record already exixts in the database.");
			}
		} catch (SQLException e) {
			System.out.println("exception in insertion");
		}finally{
		
			try {
				ps.close();
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block\
				System.out.println("statement not closed properly");
			}
		}
		
		
		return result;
	}
	
	public void deleteCustinfo(String nameN){
		Boolean result = false;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pre = null;
		getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery(SELECT_ALL_QUERY);
			while(rs.next()){
				if((nameN.equals(rs.getObject(1)))){
					result = true; 
					break;
				}
			}
			if(result == true){
			pre = con.prepareStatement(DELETE_QUERY);
			pre.setString(1, nameN);
			pre.execute();
			System.out.println("Record deleted sucessfully");
			}else{
				System.out.println("No record exists with this name");
			}
		} catch (SQLException e) {
			System.out.println("No record found with that name:");
		}finally{
			try {
				pre.close();
				rs.close();
				st.close();
				con.close();
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("");
			}
		}
		//return result;
		
	}
	
	public int updateCustInfo(String n,String p,String g, int a,String mail){
		int result =0;
		PreparedStatement ps = null;
		getConnection();
		try {
			ps = con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, g);
			ps.setInt(4, a);
			ps.setString(5, mail);
			result = ps.executeUpdate();
			System.out.println("updated sucessfully");
		} catch (SQLException e) {
			System.out.println("update was not sucessful");
		}finally{
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return result;
	}
	
	public void selectAllData(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		getConnection();
		try {
			ps = con.prepareStatement(SELECT_ALL_QUERY);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {        
				for(int i = 1 ; i <= columnsNumber; i++){
				      System.out.print(rs.getString(i) + " "); //Print one element of a row
				}
				  System.out.println();//Move to the next line to print the next row.           
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
