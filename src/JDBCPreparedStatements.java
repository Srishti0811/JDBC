
import java.sql.*; //1. Import

public class JDBCPreparedStatements {
	
	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // 2. Drivers
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root123$"); //3. Connection
		
		PreparedStatement st = con.prepareStatement("Insert into student values (?,?,?)"); //4. Statement
		st.setInt(1, 60);
		st.setString(2,  "Jake");
		st.setInt(3, 27);
		
		int count = st.executeUpdate(); //5. Execute
		
		System.out.println(count);
		
		st.close(); //7. Close connection
		con.close();
		
	}
	
	

}
