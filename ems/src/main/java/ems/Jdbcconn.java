//comment section use only if you don't have database
//while using create table method 1st pass database name then table which you want to create

package ems;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcconn {
	
	private static final String url="jdbc:postgresql://localhost:5432/";
	private static final String user="postgres";
	private static final String pass="Enter_your_password";

	public static void main(String[] args) {
		//createdb("employes");
		craeteTable("employes","employee");
		
	}
	
//	static void createdb(String DBName){
//		try {
//			Connection con= DriverManager.getConnection(url,user,pass);
//			String query=("Create Database "+DBName);
//			Statement stmt=con.createStatement();
//			stmt.execute(query);
//			System.out.println("Database "+DBName+" Created...");
//			stmt.close();
//			con.close();
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//	}
	
	static void craeteTable(String DBName, String TBName) {
		try {
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+DBName,"postgres","7576");
			String createTableQuery = "CREATE TABLE IF NOT EXISTS "+TBName+" ("
                    + "id SERIAL PRIMARY KEY,"
                    + "name VARCHAR(100) NOT NULL,"
                    + "age INT NOT NULL,"
                    + "department VARCHAR(50) NOT NULL,"
                    + "salary decimal(10,2) NOT NULL"
                    + ");";
			
			Statement stmt=con.createStatement();
			stmt.execute(createTableQuery);
			System.out.println("Table "+TBName+" is Created In "+DBName+" Database ");
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
}
