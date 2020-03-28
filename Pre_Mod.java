package mysql_eclip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Pre_Mod 
{
	public static void main(String[] args) 
	{
		Connection con;
		PreparedStatement st;
		String sql,na;
		Scanner sc;
		int tot;
		try
		{
			sql="update student set Total=? where Sname=?";
			sc= new Scanner(System.in);
			System.out.println("Enter the Sname");
			na=sc.next();
			System.out.println("Enter the Total");
			tot=sc.nextInt();
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://local host:3306/durgadb","root"," ");
			st=con.prepareStatement(sql);
			sql="Update student set Total "+tot+" where Sname='"+na+"' ";
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
