package student.conyersb.csc180.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SamplDBOP {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String mysqlString = "jdbc:mysql://localhost:3306/csc180_student?useSSL=false";
		String sqlserverString = "jdbc:mysql://localhost:3306/csc180_student?useSSL=false";
		
		try(Connection mysqlconnection = DriverManager.getConnection(mysqlString, "root", "mooba"))
		{
		
		try(Statement statement = mysqlconnection.createStatement())
				{
				int PatID = 2;
				for(int i=1; i < 15; i++)
				{
					statement.execute("update student set age = " + i + " where id = " + PatID);
				}
				
			try(ResultSet results = statement.executeQuery("select * from student"))
			{
				
			
		
		while(results.next())
		{
			String name = results.getString("name");
			System.out.println("name=" + name);
			double gpa = results.getDouble("gpa");
			System.out.println("gpa=" + gpa);
		}
		
			}
		System.out.println("Success");
	}
		}
	}
}
