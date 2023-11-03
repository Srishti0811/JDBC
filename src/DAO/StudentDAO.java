package DAO;

import java.sql.*;

public class StudentDAO {
	
	Connection con = null;
	
	public void getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/student","root","root123$");
	}
	
	public Student getStudent(int id) throws Exception
	{
		Student stu = new Student();
		stu.id = id;
		
		getConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select name from student where id = " + id);
		rs.next();
		
		String name = rs.getString(1);
		stu.name = name;
	
		
		return stu;
	}
	
	
	public void addStudent(Student s) throws Exception{
		
		getConnection();
		PreparedStatement ps = con.prepareStatement("insert into student values (?,?,?)");
		ps.setInt(1, s.id);
		ps.setString(2, s.name);
		ps.setInt(3, s.age);
		
		ps.executeUpdate();
	}
	

}
