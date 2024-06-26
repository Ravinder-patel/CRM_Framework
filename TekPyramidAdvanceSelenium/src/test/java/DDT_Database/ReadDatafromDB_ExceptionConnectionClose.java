package DDT_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDatafromDB_ExceptionConnectionClose {
// WA script to connect DB and read the data from DB and close the connection even though any exception occured ?
//Optimized script
		public static void main(String[] args) throws Throwable {	
			// expected condition
			String Emp_Name = "Ravi";
			boolean flag = false;
			
			//register driver
			Driver drivRef = new Driver();
			DriverManager.registerDriver(drivRef);
			//connect to db
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			System.out.println("====Connected to Database====");
		
		try {
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
		} 
		catch (Exception e) 
		{
			System.out.println("====Exception Handled====");
		}
			
		//even though is any exception is occured or not finally block will execute and close the connection 
		finally 
			{
			// close connection
			connect.close();
			System.out.println("====Connection Closed====");
			}
			
		}

}
