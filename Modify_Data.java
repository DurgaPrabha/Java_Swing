package mysql_eclip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class Modify_Data 
{
	public static void main(String[] args) 
	{
		Connection con;
		Statement st;
		String sql;
		Scanner sc;
		int rn,tot;
		try
		{
			sc= new Scanner(System.in);
			System.out.println("Enter the Rno");
			rn=sc.nextInt();
			System.out.println("Enter the new total");
			tot=sc.nextInt();
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
			st=con.createStatement();
			sql="Update student set Total="+tot+" where Rno="+rn+" ";
			int r=st.executeUpdate(sql);
			if(r==0)
			{
				System.out.println("Record not found");
			}
			else
			{
				System.out.println("Record Modified");
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
