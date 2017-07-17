package telephoneRepository;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.attribute.standard.NumberUpSupported;

import org.postgresql.util.PSQLException;

import telephoneModel.TeleInfo;
import telephoneModel.TeleLogin;

public class TeleRegRepo {

	private static final String CREATE_QUERY = "CREATE Table tele_register (name character varying(40) NOT NULL, phone character varying(40) NOT NULL, email character varying(40) NOT NULL, password character varying(40) NOT NULL, date character varying(50) NOT NULL, gender character varying(50) NOT NULL, carrier character varying(50) NOT NULL, zip character varying(50) NOT NULL)";
	private static final String INSERT_QUERY = "INSERT INTO tele_register (name, phone, email, password, date, gender, carrier, zip) values(?,?,?,?,?,?,?,?)";
	private static final String LOGIN_QUERY = "Select email, password From tele_register";
	private static final String PHONE_QUERY = "Select email, password, phone From tele_register";
	static String num="";
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
		boolean status = false;
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT EXISTS (SELECT 1 FROM pg_tables where schemaname='public' AND tablename='tele_register')");
		
			while(rs.next()){
				status= rs.getBoolean(1);
			}
			if(status){
				System.out.println("Table already created...skiping it");
			}else{
				ps = con.prepareStatement(CREATE_QUERY);
				result = ps.execute();
				System.out.println("successfully created");
			}
			
		} catch (SQLException e) {
			System.out.println("exception in creation");
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				st.close();
				if(!status){
					ps.close();
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
		
	}
	public int insertTeleInfo(TeleInfo info) throws PSQLException{
		int result = 0;
		PreparedStatement ps = null;
		createRegistration();
		getConnection();

		try {
			ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, info.getName());
			ps.setString(2, info.getPhone());
			ps.setString(3, info.getEmail());
			ps.setString(4, info.getPassword());
			ps.setString(5, info.getDofb());
			ps.setString(6, info.getGender());
			ps.setString(7, info.getCarrier());
			ps.setString(8, info.getZip());
			
			result = ps.executeUpdate();
			System.out.println("inserted successfully");
		} catch (SQLException e) {
			System.out.println("exception in insertion");
			e.printStackTrace();
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
	public boolean validateLogin(TeleLogin tl){
		boolean result = false;
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs1 = null;
		ResultSet rs = null;
		getConnection();
		String f = "",p = "";
		try {
			
			ps = con.prepareStatement(LOGIN_QUERY);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(((tl.getEmail()).equals(rs.getString(1))) && ((tl.getPassword()).equals(rs.getObject(2)))){
					result = true;
					f=rs.getString(1);
					p=rs.getString(2);
					break;
				}
			 }
			if(result == true){
				System.out.println("User Logged in Sucessfully");
				st = con.createStatement();
				rs1 = st.executeQuery(PHONE_QUERY);
				while (rs1.next()) {
					if(f.equals(rs1.getString(1)) && (p.equals(rs1.getObject(2)))){
						num = rs1.getString(3);
						break;
					}
				 }
				
			}else{
				System.out.println("Sorry user Name and password mismatch. Try again, Thank you");
				
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

}
