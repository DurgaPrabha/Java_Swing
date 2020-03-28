package mysql_eclip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Disp_Data 
{
	public static void main(String[] args) 
	{
		Connection con;
		Statement st;
		ResultSet rs;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
			st=con.createStatement();
			rs=st.executeQuery("Select* from student");
		while(rs.next())
		{
			System.out.print(rs.getString(1)+" ");
			System.out.print(rs.getString(2)+" ");
			System.out.println(rs.getString(3));
		}
		con.close();
		st.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
