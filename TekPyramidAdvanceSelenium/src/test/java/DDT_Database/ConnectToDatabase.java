package DDT_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ConnectToDatabase {

	public static void main(String[] args) throws Throwable {
		// Step 1: Load or register the Database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		// Step 2: connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
												//drivername(jar):DatabaseHostName:url:Portnumber/TAblename(db)
		System.out.println("Connection Established");

		// Step 3: create sql statement
		Statement stat = conn.createStatement();

		// Step 4: Execute select query and get result
		ResultSet result = stat.executeQuery("select * from employee");
		while (result.next()) {
			System.out.println(result.getString(2));
		}
		// Step 5: close the connection

		conn.close();
		System.out.println("Connection closed");
	}
}
