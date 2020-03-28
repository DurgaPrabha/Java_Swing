package mysql_eclip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Pre_Disp 
{
	public static void main(String[] args) 
	{
		Connection con;
		PreparedStatement st;
		ResultSet rs;
		try
		{
			String sql="select *from student values(Rno,Sname,Total)";
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
			st=con.prepareStatement(sql);
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
