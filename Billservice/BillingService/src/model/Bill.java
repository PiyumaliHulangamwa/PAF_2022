package model;

import java.sql.*;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

public class Bill {
	//A common method to connect to the DB
	private Connection connect()
	{
		Connection con = null;
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				//Provide the correct details: DBServer/DBName, username, password
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/lab", "root", "");
			}
		catch (Exception e)
			{
				e.printStackTrace();
			}
			return con;
	}
	
	//POST part
	public String insertItem(String code, String name, String price)
	{
	   String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
		{
			
			return "Error while connecting to the database for inserting."; 
		}
	
		  // create a prepared statement
			String query = " insert into bills(`billID`,`userID`,`date`,`reading`)"+ " values (?, ?, ?, ?)";
	        PreparedStatement preparedStmt = con.prepareStatement(query);
	       
	      // binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, code);
			preparedStmt.setString(3, name);
			preparedStmt.setDouble(4, Double.parseDouble(price));
	
	
		  // execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		}
		catch (Exception e)
		{
			output = "Error while inserting the item.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	//GET part
	public String readItems()
	{
		String output = "";
		  try
		  {
			  Connection con = connect();
			  if (con == null)
		  {	
			  return "Error while connecting to the database for reading."; 
	      }
			  
		  	// Prepare the html table to be displayed
			  output = "<table border='1'><th>Bill ID</th><th>userID</th><th>Total Amount</th>" +
					  "<th>reading</th>" 
					  
					 ;
			  String query = "select  r.billID,r.userID ,(r.reading * u.unitp)item, r.reading  from bills r ,units u Where r.billID=u.unitID ";
			  Statement stmt = con.createStatement();
			  ResultSet rs = stmt.executeQuery(query);
		
		   // iterate through the rows in the result set
		  
		  while (rs.next())
		  {
				String billID = Integer.toString(rs.getInt("r.billID"));
				String userID = rs.getString("r.userID");
				String date = rs.getString("item");
				String reading = Double.toString(rs.getDouble("r.reading"));
			
				// Add into the html table
				output += "<tr><td>" + billID + "</td>";
				output += "<td>" + userID + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + reading + "</td>";
		
			
		  }
				con.close();
				// Complete the html table
				output += "</table>";
		  }
		  catch (Exception e)
		  {
				output = "Error while reading the bills.";
				System.err.println(e.getMessage());
		  }
		return output;
	}
	
	//PUT part
	public String updateItem(String ID, String code, String name, String price)
	{
		String output = "";
		  try
		  {
			  Connection con = connect();
			  if (con == null)
		  {
			  return "Error while connecting to the database for updating."; 
		  }
			  
			  // create a prepared statement
				  String query = "UPDATE bills SET userID=?,date=?,reading=? WHERE billID=?";
				  PreparedStatement preparedStmt = con.prepareStatement(query);
			  
			  // binding values
				preparedStmt.setString(1, code);
				preparedStmt.setString(2, name);
				preparedStmt.setDouble(3, Double.parseDouble(price));
				preparedStmt.setInt(4, Integer.parseInt(ID));
			 
			  // execute the statement
				preparedStmt.execute();
				con.close();
				output = "Updated successfully";
		  }
		  catch (Exception e)
		  {
				output = "Error while updating the item.";
				System.err.println(e.getMessage());
		  }
		return output;
	}
		
	//DEL part
	public String deleteItem(String billID)
	{
		String output = "";
		  try
		  {
			  	Connection con = connect();
			  	if (con == null)
		  {
				return "Error while connecting to the database for deleting."; 
		  }
			  	
			// create a prepared statement
			  	String query = "delete from bills where billID=?";
			  	PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			  	preparedStmt.setInt(1, Integer.parseInt(billID));
			
			// execute the statement
			  	preparedStmt.execute();
			  	con.close();
			  	output = "Deleted successfully";
		  }
		  catch (Exception e)
		  {
			  	output = "Error while deleting the item.";
			  	System.err.println(e.getMessage());
		  }
		  return output;
			}
	}
