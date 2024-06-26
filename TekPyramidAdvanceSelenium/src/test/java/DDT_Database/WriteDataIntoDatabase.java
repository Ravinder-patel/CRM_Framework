package DDT_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class WriteDataIntoDatabase {

	// WA script to write/insert data into data base
	public static void main(String[] args) throws Throwable {

		// register driver
		Driver drivRef = new Driver();
		DriverManager.registerDriver(drivRef);
		// connect to db
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		// create sql statement
		Statement statement = connect.createStatement();
		// Execute non select query to insert/update the DB======write query in executeUpdate() only 
		int updatedRows = statement.executeUpdate(
				"insert into employee values(887,'qwerty','8888 DEV','852-963-741','D088','QA engineer','10000');");

		System.out.println(updatedRows + " rows are updated");

		// close connection
		connect.close();

	}

}
