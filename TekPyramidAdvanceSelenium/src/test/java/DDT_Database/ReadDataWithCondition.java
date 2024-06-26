package DDT_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataWithCondition {
	// WA script if employee name is available in DB return his emp id
	public static void main(String[] args) throws Throwable {
		
		// expected condition
		String Emp_Name = "Ravi";
		boolean flag = false;
		//register ddriver
		Driver drivRef = new Driver();
		DriverManager.registerDriver(drivRef);
		//connect to db
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		//create sql statement
		Statement statement = connect.createStatement();
		//Execute the Query
		ResultSet resultset = statement.executeQuery("select * from employee");

		String actualName = null;
		
		while (resultset.next()) {
			actualName = resultset.getString(2); // everytime go to new row fetch the name in 2nd column
			//CONDITION
			if (Emp_Name.equals(actualName)) //compare expected name with actualName in DB with 
			{
				flag = true;
				System.out.println(resultset.getString(1)); // print id
				System.out.println(Emp_Name + " is available in DB");
			}
		}
		if (flag == false) {
			System.out.println(Emp_Name + " is not available in DB");
		}
		
		// close connection
		connect.close();

	}

}
