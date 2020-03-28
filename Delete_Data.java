package mysql_eclip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class Delete_Data 
{
	public static void main(String[] args) 
	{
		Connection con;
		Statement st;
		int rn;
		Scanner sc;
		String sql;
		try
		{
			sc=new Scanner(System.in);
			System.out.println("Enter the Rno to be deleted");
			rn=sc.nextInt();
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
			st=con.createStatement();
			sql="delete from student where Rno= '"+rn+"' ";
			int r=st.executeUpdate(sql);
			if(r==0)
			{
				System.out.println("Record not Found");
			}
			else
			{
				System.out.println("Record Deleted");
			}
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
