package mysql_eclip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Pre_Delete 
{
	public static void main(String[] args) 
	{
		Connection con;
		PreparedStatement st;
		int rn;
		Scanner sc;
		String sql;
		try
		{
			sql="delete from student where Rno=?";
			sc=new Scanner(System.in);
			System.out.println("Enter the Rno to be deleted");
			rn=sc.nextInt();
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://local host:3306/durgadb","root"," ");
			st=con.prepareStatement(sql);
			sql="delete from student where Rno='"+rn+"' ";
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
