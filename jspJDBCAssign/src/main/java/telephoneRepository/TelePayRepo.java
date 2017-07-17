package telephoneRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

import telephoneModel.TeleInfo;
import telephoneModel.TelePayment;

public class TelePayRepo {

	private static final String CREATE_QUERY = "CREATE Table tele_carddetails (phone character varying(40) NOT NULL, name character varying(40) NOT NULL, card character varying(40) NOT NULL, month character varying(40) NOT NULL, year character varying(50) NOT NULL, cvv character varying(50) NOT NULL, amount character varying(50) NOT NULL)";
	private static final String INSERT_QUERY = "INSERT INTO tele_carddetails (phone, name, card, month, year, cvv, amount) values(?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_QUERY = "Select * From tele_carddetails";
	
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
			rs = st.executeQuery("SELECT EXISTS (SELECT 1 FROM pg_tables where schemaname='public' AND tablename='tele_carddetails')");
		
			while(rs.next()){
				status= rs.getBoolean(1);
			}
			System.out.println(status);
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
	public int insertTelePay(TelePayment info) throws PSQLException{
		int result = 0;
		PreparedStatement ps = null;

		createRegistration();
		getConnection();

		try {
			if((TeleRegRepo.num).equals(info.getPhone())){
				ps = con.prepareStatement(INSERT_QUERY);
				ps.setString(1, info.getPhone());
				ps.setString(2, info.getName());
				ps.setString(3, info.getCardNum());
				ps.setString(4, info.getMm());
				ps.setString(5, info.getYy());
				ps.setString(6, info.getCvv());
				ps.setString(7, info.getAmount());
				
				result = ps.executeUpdate();
				System.out.println("inserted successfully");
			}
			else{
				System.out.println("Your entered phone number is not registered with this account.");
			}
			
		} catch (SQLException e) {
			System.out.println("You can bill's only to the registered phone numbers. Soory for inconvinence please register.");
			e.printStackTrace();
		}finally{
		
			try {
				if(((TeleRegRepo.num).equals(info.getPhone()))){
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

	public ResultSet selectAllData(List ltp){
		String phone = "",name = "",cardNum = "",mm = "",yy= "",cvv= "",amount = " ";
		ResultSet rs = null;
		PreparedStatement ps = null;
		System.out.println("first");
		getConnection();
		try {
			ps = con.prepareStatement(SELECT_ALL_QUERY);
			rs = ps.executeQuery();
//			ResultSetMetaData rsmd = rs.getMetaData();
//
//			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {     
				TelePayment tps = new TelePayment(phone, name, cardNum, mm, yy, cvv, amount);
				      tps.setPhone(rs.getString(1));
				      tps.setName(rs.getString(2));
				      tps.setCardNum(rs.getString(3));
				      tps.setMm(rs.getString(4));
				      tps.setYy(rs.getString(5));
				      tps.setCvv(rs.getString(6));
				      tps.setAmount(rs.getString(7));
				      if((TeleRegRepo.num).equals(tps.getPhone())){
				      ltp.add(tps);
				}
//				  System.out.println();//Move to the next line to print the next row.           
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
		return rs;
	}
}
