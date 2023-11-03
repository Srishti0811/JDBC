
//https://www.youtube.com/watch?v=DyTEu08x3o0&list=PLsyeobzWxl7rU7Jz3zDRpqB-EODzBbHOI&index=4

import java.sql.*; //1. Import

//Java Database Connectivity - JDBC
/*

1. Import --> java.sql.* 
2. Register and Load the drivers -> oracle - oracle driver or mysql - mysql drivers (download the jar - maven repository - MySQL Connector/J » 8.0.33)(com.mysql.jdbc.Driver)
3. Establish the connection --> Object of Connection Interface
4. Create a Statement--> Object of Statement Interface
5. Execute the query
6. Process the results
7. Close Connection

*/


//DDL, DML, DQL
//DDL - Data definition language - Changing the structure of data 
//DML - Data Manipulation Language - change value in the table - update	existing value,insert data etc - use: int count = st.executeUpdate(query) - gives an int value (Number of rows affected)
//DQL - Data Query Language - fire a query to fetch data  - use: ResultSet rs = st.executeQuery(query) - Returns an object of the result set. 


public class JDBCConnectivity {
	
	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/student";
		String username = "root";
		String password = "root123$";
		
		//String query = "select * from student where id = 10"; - a
		
		//String query = "select * from student"; - b
		
		int id = 50;
		String name = "Krish";
		int age = 43;
		
		String query = "insert into student values(" + id + ",'" + name + "'," + age + ")"; //Difficult when values are coming dynamically. So avoid use PreparedStatements
		//OR String query = "insert into student values(40, 'Khloe', 20)";
		
		
		//Class.forName just loads the driver -> registration of driver is done by static block of the class which is called by loading the driver - https://www.youtube.com/watch?v=me9CcSXLHHc&list=PLsyeobzWxl7rU7Jz3zDRpqB-EODzBbHOI&index=5
		Class.forName("com.mysql.cj.jdbc.Driver"); //2. driver 
		Connection con = DriverManager.getConnection(url, username, password); //3. Establish the connection
		Statement st = con.createStatement(); //4. Create a statement
		
		int count = st.executeUpdate(query);
		
		System.out.println(count + " : No of rows affected");
		
		//ResultSet rs = st.executeQuery(query); //5. Execute Query //DQL - a,b 
		
		
		//rs.next(); - a //6. Process the result set - used to iterate through the table
		//String name = rs.getString("Name"); - a
		
		/* - b
		 * while(rs.next()) { String userData = rs.getInt(1) + " : " + rs.getString(2);
		 * System.out.println(userData); }
		 */
		
		st.close();
		con.close(); //7. Close the connection
		
	}
	
	

}
