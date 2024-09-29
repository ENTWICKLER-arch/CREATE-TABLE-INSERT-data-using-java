package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class Assignment {
	
	public static final String driverClassName = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/batch_10";
	public static final String username = "root";
	public static final String password = "1234";
	public static final String query = "CREATE TABLE lo (ID INT , NAME VARCHAR(50) , DESIGNATION VARCHAR(50) , BSAL FLOAT , totalSAL FLOAT )";
	public static final String insert = "INSERT INTO   lo VALUES(?,?,?,?,?)";
	public static void main (String [] args)throws Exception {
		
		Class.forName(driverClassName);
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement ps1= con.prepareStatement(insert);
		Statement stm = con.createStatement();
		stm.executeUpdate(query);
		System.out.println("Table Created");
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader br = new BufferedReader (isr);
	
		loop:while(true ) {
			System.out.println("1. Insert Employee Details");
			
			System.out.println("Enter Your Choice  :  ");
			String Choice = br. readLine();
			
			switch(Choice) {
     case "1" :{
				
				System.out.println("Enter Employee id : ");
				Integer id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter Employee Name :");
				String name = br.readLine();
				
				System.out.println("Enter Employee Designation :");
				String designation = br.readLine();
				
				System.out.println("Enter Employee bsal :");
				Float  bsal = Float.parseFloat(br.readLine());
				
				System.out.println("Enter Employee total salary :");
				Float  totalSal = Float.parseFloat(br.readLine());
				
				
				ps1.setInt(1,id);
				ps1.setString(2, name);
				
				ps1.setString(3,designation);
				
				ps1.setFloat(4,bsal);
				
				ps1.setFloat(5, totalSal);
				
				int k =ps1.executeUpdate();
				if (k>0) {
					System.out.println("Record Inserted");
				} else {
					System.out.println("Failed to Insert");
				}
				
				
			} break ;
     case "2": {
			System.err.println("Good bye");
			
		    break loop ;}
		default : {
			System.err.println("Invalid option");
		}
		
	}

	

		}}}
