package DDT_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadTheDataFromDatabase {

	public static void main(String[] args) throws Throwable {
		// Step 1: Load or register the Database driver
		Driver drivRef = new Driver();
		DriverManager.registerDriver(drivRef);

		// Step 2: connect to database
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		
		// Step 3: create sql statement
		Statement statement = connect.createStatement();

		// Step 4: Execute select query and get result
		ResultSet result = statement.executeQuery("Select * from employee");
		
		while (result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(6)+"\t"+result.getString(7));
			
		}

		// Step 5: close the connection
		connect.close();
	}

}
