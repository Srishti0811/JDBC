package DAO;

public class JDBCDAOClass
{
	public static void main(String[] args) throws Exception {
		StudentDAO studentDAO = new StudentDAO();
		Student stu = new Student();
		stu.id = 70;
		stu.name = "Mindy";
		stu.age = 55;
		//Student stu = studentDAO.getStudent(50); - select
		//System.out.println(stu.name);
		
		studentDAO.addStudent(stu); // insert
		
	}
}