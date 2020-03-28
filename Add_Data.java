package mysql_eclip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class Add_Data 
{
	public static void main(String[] args) 
	{
		Connection con;
		Statement st;
		int rn;
		String na;
		double tot;
		Scanner sc;
		String sql;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter the roll number");
			rn=sc.nextInt();
			System.out.println("Enter the student Name");
			na=sc.next();
			System.out.println("Enter the total marks");
			tot=sc.nextDouble();
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
			st=con.createStatement();
			sql="insert into student(Rno,Sname,Total) values('"+rn+"','"+na+"','"+tot+"')";
			st.executeUpdate(sql);
			System.out.println("Record Saved");
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
