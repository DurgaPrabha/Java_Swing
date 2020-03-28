package mysql_eclip;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Pre_Add 
{
	public static void main(String[] args) 
	{
		Connection con;
		PreparedStatement st;
		int rn;
		String na;
		double tot;
		Scanner sc;
		String sql;
		try
		{
			sql="insert into student(Rno,Sname,Total) values(?,?,?)";
			sc=new Scanner(System.in);
			System.out.println("Enter the Roll no");
			rn=sc.nextInt();
			System.out.println("Enter the Student Name");
			na=sc.next();
			System.out.println("Enter the Total marks");
			tot=sc.nextDouble();
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
			st=con.prepareStatement(sql);
			st.setInt(1,rn);
			st.setString(2,na);
			st.setDouble(3,tot);
			st.executeUpdate();
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
