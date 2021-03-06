package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import bean.CustomerBean;
import util.Connections;



public class CustomerDAO {
	
	public static boolean CusExist(String ID){
		// This Function Returns if a customer exists in a database, Used for Error Handling in later functions.
		Connection conn = null; // Defines a Variable for Connecting
		try {
			conn = Connections.Connect(); // Connects to Database, Calls the Util Package and Connections.
			String sql="select customerid from customer where customerID=?"; // Prepared Statement, ? represents replacement value.
			PreparedStatement pst=conn.prepareStatement(sql); // Passes above into variables
			pst.setString(1, ID); // replaces ? with Variable 'ID'
			
			int count=pst.executeUpdate(); // Executes Command, then counts the output
			

			if (count>=1){ // If Greater than 1 then customer exists, returns True to Function
				return true;
			}
			else{ // If Not greater than 1, and 'No Rows are shown' then retuns false
				return false;
			}
			
		} catch (SQLException e1) { // This Catches any SQL Exceptions that Might occur.
			//e1.printStackTrace();
			System.out.println("SQL Error"); // Shows an easy error message.
			return false; // Returns false to the Function.
		}
	}
	
	public static boolean CusExist(String fname,String lname){
		// Function the same as above but overrides when passed two strings.
		Connection conn = null;
		try {
			conn = Connections.Connect();
			String sql="select * from customer where firstname=? and lastname=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, fname);
			pst.setString(2, lname);
			
			int count=pst.executeUpdate();
			

			if (count>0){
				return true;
			}
			else{
				return false;
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	
	public static boolean insertCustomer(CustomerBean e){
		Connection conn = null;
		
		try {
			conn = Connections.Connect();
			String sql = "insert into customer values(?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			// Insert Statements
			pst.setString(1,e.getCusID());
			pst.setString(2,e.getfName());
			pst.setString(3,e.getlName());
			pst.setString(4,e.getAddress());
			pst.setString(5,e.getEmail());
			pst.setString(6,e.getTel());

			int count=pst.executeUpdate();
			
			if (count==1){ // Statement to check if it was inserted
				System.out.println("\nCustomer " + e.getfName() + " " + e.getlName() + " Successfully Inserted"); // Display confirmation
				return true;
			}
			else{
				System.out.println("\nCustomer Insert Error"); // Outputs error if failure
				return false;
			}
		} catch (SQLException e1) {
			if(CusExist(e.getCusID())==true){
				System.out.println("\nCustomer Insert Error;\n Entry Already Exists at ID: " + e.getCusID());
			} // Exception to catch if Customer Already exists at that ID.
			//e1.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteCustomer(String CusID){
		Connection conn = null;
		
		try {

			conn = Connections.Connect();
			String sql = "delete from customer where CUSTOMERID=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, CusID);
			
			int count=pst.executeUpdate();
			
			if (count==1){
				conn.commit();
				System.out.println("Customer Successfully Removed");
				return true;
			}
			else{
				System.out.println("\nCustomer Remove Error;");
				if(CusExist(CusID)==false){
					System.out.println("No Entry In Databse of ID: " + CusID );
				}
				return false;
			}
		}  catch (SQLException e1) {
			if(CusExist(CusID)==false){
				System.out.println("No Entry In Databse of ID:  " + CusID );
			}
			e1.printStackTrace();
			return false;
		}
	}
	
	public static Integer NextID(){
		Connection conn = null;
		try{
			conn = Connections.Connect();
			// This SQL Command casts the VARCHAR CustomerID as INT, then looks for the highest value
			String sql="select max(cast(customerid as Int)) as highID from customer";
			PreparedStatement pst=conn.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				// Returns the Highest Value, +1, so the Next ID in the Sequence is returned.
				return rs.getInt("highid") + 1;
			}
			
			return 0;
			
		}catch (SQLException e1) {
			System.out.println("Error In Getting Next ID in Customer Table");
			//e1.printStackTrace();
			return 0;
		}
	}
	
	public static ArrayList<CustomerBean> displayCustomerID(String CusID){
		ArrayList<CustomerBean> list=new ArrayList<CustomerBean>();
		Connection conn = null;
		try {
				conn = Connections.Connect();
				String sql="select * from customer where customerid=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, CusID);
			
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					CustomerBean bean=new CustomerBean();
					bean.setCusID(rs.getString("CustomerID"));
					bean.setfName(rs.getString("firstName"));
					bean.setlName(rs.getString("lastName"));
					bean.setAddress(rs.getString("address"));
					bean.setEmail(rs.getString("email"));
					bean.setTel(rs.getString("TelNumber"));
					list.add(bean);
					
					 System.out.println("Customer ID: " + bean.getCusID() + "\nFirst Name: " + bean.getfName() +
                             "\nLast Name: " + bean.getlName() + "\nAddress: " + bean.getAddress() +
                             "\nEmail: " + bean.getEmail() + "\nTelephone Number: " + bean.getTel());
					
				}
				
				if(CusExist(CusID)==false){
					System.out.println("\nCustomer Display Error;\n No Customer Exists at ID: " + CusID);
				}
				
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
		return list;

	}

	public static ArrayList<CustomerBean> displayCustomerName(String fname, String lname){
		ArrayList<CustomerBean> list=new ArrayList<CustomerBean>();
		Connection conn = null;
		try {
				conn = Connections.Connect();
				String sql="select * from customer where firstname=? AND lastname=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, fname);
				pst.setString(2, lname);
			
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					CustomerBean bean=new CustomerBean();
					bean.setCusID(rs.getString("CustomerID"));
					bean.setfName(rs.getString("firstName"));
					bean.setlName(rs.getString("lastName"));
					bean.setAddress(rs.getString("address"));
					bean.setEmail(rs.getString("email"));
					bean.setTel(rs.getString("TelNumber"));
					list.add(bean);
					
					 System.out.println("Customer ID: " + bean.getCusID() + "\nFirst Name: " + bean.getfName() +
                             "\nLast Name: " + bean.getlName() + "\nAddress: " + bean.getAddress() +
                             "\nEmail: " + bean.getEmail() + "\nTelephone Number: " + bean.getTel() + "\n");
					
				}
				
				if(CusExist(fname,lname)==false){
					System.out.println("\nCustomer Display Error;\n No Customer Exists with name: " + fname + " " + lname);
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
		return list;

	}
	
	public static void updateCustomerFirstName(String cid, String fname) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		
		String updateFirstNameSQL = "UPDATE customer SET FIRSTNAME = ? "
				+ "WHERE CUSTOMERID = ?";
		
		try {
			con = Connections.Connect();
			pst = con.prepareStatement(updateFirstNameSQL);
			pst.setString(1, fname); 
			pst.setString(2,cid);
			pst.executeUpdate();
			int count=pst.executeUpdate();
			if (count==1) {
				System.out.println("Successful");
			} else {
				System.out.println("Fail");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public static void updateCustomerLastName(String cid, String lname) throws SQLException {
		Connection con =  null;
		PreparedStatement pst = null;
		String updateLastNameSQL = "UPDATE customer SET LASTNAME = ? "
				+ "WHERE CUSTOMERID = ?";
		con = Connections.Connect();
		pst = con.prepareStatement(updateLastNameSQL);
		pst.setString(1, lname);
		pst.setString(2, cid);
		pst.executeUpdate();
		int count=pst.executeUpdate();
		if (count==1) {
			System.out.println("Successful");
		} else {
			System.out.println("Fail");
		}
		}
	
	public static void updateCustomerAddress(String cid, String add) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		String updateAddressSQL = "UPDATE customer SET ADDRESS = ? "
				+ "WHERE CUSTOMERID = ?";
		con = Connections.Connect();
		pst = con.prepareStatement(updateAddressSQL);
		pst.setString(1, add);
		pst.setString(2, cid);
		pst.executeUpdate();
		int count = pst.executeUpdate();
		if (count ==1) {
			System.out.println("Successfull");
		}else {
				System.out.println("Fail");
			}
		}
	
	public static void updateCustomerEmail(String cid, String email) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		String updateEmailSQL = "UPDATE customer SET EMAIL = ? " +
		"WHERE CUSTOMERID = ?";
		con = Connections.Connect();
		pst = con.prepareStatement(updateEmailSQL);
		pst.setString(1, email);
		pst.setString(2, cid);
		pst.executeUpdate();
		int count = pst.executeUpdate();
		if (count ==1) {
			System.out.println("Successfull");
		}else {
				System.out.println("Fail");
			}
	}
	
	public static void updateCustomerTel(String cid, String tel) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		String updateTelSQL = "UPDATE customer SET TELNUMBER = ? " + ""
				+ "WHERE CUSTOMERID = ?";
		con = Connections.Connect();
		pst = con.prepareStatement(updateTelSQL);
		pst.setString(1, tel);
		pst.setString(2, cid);
		pst.executeUpdate();
		int count = pst.executeUpdate();
		if (count ==1) {
			System.out.println("Successfull");
		}else {
				System.out.println("Fail");
			}		
	}
	
	public static void main(String[] args) throws SQLException {
		// TESTER MAIN MENU REMOVE BEFORE USE!!!!	
		// USED TO SHOW EXAMPLE OF HOW TO PARSE.
		// REMOVE ONCE IMPLEMENTED OR COMMENT OUT.
		boolean menu = true;
		while(menu == true){
			System.out.println("\n\n##############################\n# Phil's Awesome Tester Menu #\n##############################");
			System.out.println("1). Insert Customer\n2). Delete Customer\n3). Display Customer Using ID\n4). Display Customer using Name\n5). Update Customer Details\n6). Exit");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			if( in.equals("1"))
			{
				
				String IDnum = NextID().toString();
				
				System.out.println("Using Next Available Unique ID of " + IDnum);

				//System.out.println("Please Insert Unique ID: ");
				String CID = IDnum;
				System.out.println("Please Insert First Name: ");
				String Fname = scanner.nextLine();
				Fname.trim();
				System.out.println("Please Insert Last Name: ");
				String Lname = scanner.nextLine();
				Lname.trim();
				System.out.println("Please Insert Address: ");
				String Address = scanner.nextLine();
				Address.trim();
				//scanner.next();
				System.out.println("Please Insert Email: ");
				String Email = scanner.nextLine();
				Email.trim();
				//scanner.next();
				System.out.println("Please Insert Tel No: ");
				String TelNo = scanner.nextLine();
				TelNo.trim();

				CustomerBean TESTER = new CustomerBean(CID,Fname,Lname,Address,Email,TelNo);
				insertCustomer(TESTER);
				
			}
			
			else if (in.equals("2")){
				
				System.out.println("Please Enter Customer ID");
				String CID = scanner.nextLine();
				deleteCustomer(CID);

			}
			
			else if ( in.equals("3")){
				System.out.println("Please Enter Customer ID");
				String CID = scanner.nextLine();
				displayCustomerID(CID);
				
			}
			
			else if ( in.equals("4")){
				System.out.println("Please Insert First Name: ");
				String Fname = scanner.nextLine();
				System.out.println("Please Insert Last Name: ");
				String Lname = scanner.nextLine();
				
				displayCustomerName(Fname,Lname);
			}
			else if ( in.equals("6")){
				System.out.println("Phil's Awesome Menu Closed, GoodBye!");
				menu = false;
				break;
			}
			else if (in.equals("5")){
				int result = 0;
				System.out.println("\nTuss's Awesome Update Menu\nEnter 1 to change F name \n" + "Enter 2 to change L Name\nEnter 3 to change Address\nEnter 4 to change Email\nEnter 5 to change Tel No.");
				result = Integer.parseInt(scanner.nextLine());
				if (result == 1) {
					//Update Customer First Name
					System.out.println("Enter the CustomerID of the Customer");
					String cid = scanner.nextLine();
					System.out.println("Enter what you would like to change the First Name to");
					String fname = scanner.nextLine();
					updateCustomerFirstName(cid, fname);
					
				}  if (result == 2) {
					//Update Customer Last Name
					System.out.println("Enter the CustomerID of the Customer");
					String cid = scanner.nextLine();
					System.out.println("Enter what you would like to change the Last Name to");
					String lname = scanner.nextLine();
					updateCustomerLastName(cid, lname);
					
				} if (result == 3) {
					//Update Customer Address
					System.out.println("Enter the CustomerID of the Customer");
					String cid = scanner.nextLine();
					System.out.println("Enter what you would like to change the Address to");
					String add = scanner.nextLine();
					updateCustomerAddress(cid, add);
					
				} if (result == 4) {
					//Update Customer Email
					System.out.println("Enter the CustomerID of the Customer");
					String cid = scanner.nextLine();
					System.out.println("Enter what you would like to change the Email to");
					String email = scanner.nextLine();
					updateCustomerEmail(cid, email);
					
				} if (result == 5) {
					//Update Customer Telephone Number
					System.out.println("Enter the CustomerID of the Customer");
					String cid = scanner.nextLine();
					System.out.println("Enter what you would like to change the Telephone Number to");
					String tel = scanner.nextLine();
					updateCustomerTel(cid, tel);
					
				}
				
			else
				System.out.println("Error, Please select valid Option.");
		}
	}

}
}