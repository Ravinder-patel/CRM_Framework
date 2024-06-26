package DDT_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ConnectToRemoteDB {
	// connect to remote DB and fetch the data
	public static void main(String[] args) throws Throwable {
		// register driver
		Driver drivRef = new Driver();
		DriverManager.registerDriver(drivRef); //without registering the driver also we can execute the script by getConnectioin()
		// connect to to Remote DB using URL ,Username,Password
		Connection connect = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("====Connected to Database====");

		try {
			// create sql statement
			Statement statement = connect.createStatement();
			// Execute the Query
			ResultSet resultset = statement.executeQuery("select * from project");

			while (resultset.next()) {
				System.out.println(resultset.getString(1) + "\t" + resultset.getString(2) + "\t"
						+ resultset.getString(3) + "\t" + resultset.getString(4) + "\t" + resultset.getString(5)+ "\t" + resultset.getString(6));

			}

		} catch (Exception e) 
		{
			System.out.println("====Exception Handled====");
		}

		// even though is any exception is occured or not finally block will execute and
		// close the connection
		finally 
		{
			// close connection
			connect.close();
			System.out.println("====Connection Closed====");
		}

	}
}
