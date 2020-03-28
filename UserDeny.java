package app_package;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class UserDeny implements ActionListener 
{
	JFrame frm;
	JLabel l1,l2;
	JTextField t1;
	JPasswordField pw;
	JButton b1,b2,b3;
	JTextArea ta;
	JPanel jp1,jp2;
	JScrollPane scp;
	Connection con;
	Statement st;
	ResultSet rs;
	int f=0;
	 public UserDeny()
	 {
		 try
		 {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
			st=con.createStatement();
		 }
		 catch(Exception a)
		 {
			 a.getLocalizedMessage();
		 }
	 }
	public void setObj()
	{
		Font fs=new Font("Aries",Font.BOLD,20);
		
		frm=new JFrame("Login Page");
		JFrame.setDefaultLookAndFeelDecorated(true);
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		int x=size.width;
		int y=size.height;
		frm.setSize(x,y);
		frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frm.setLayout(new FlowLayout());
		frm.getContentPane().setBackground(Color.lightGray);
		frm.setDefaultCloseOperation(3);
		frm.setLocationRelativeTo(frm);
		
						
		l1=new JLabel("Username");
		l1.setPreferredSize(new Dimension(450,30));
		l1.setFont(fs);
		
		t1=new JTextField(20);
		t1.setPreferredSize(new Dimension(180,30));
		
		l2=new JLabel("Password");
		l2.setPreferredSize(new Dimension(450,30));
		l2.setFont(fs);
		
		pw=new JPasswordField(20);
		pw.setPreferredSize(new Dimension(100,30));
		
		b1=new JButton("Enter");
		b1.setPreferredSize(new Dimension(120,30));
		
		b2=new JButton("Clear");
		b2.setPreferredSize(new Dimension(80,30));
		
		b3=new JButton("Exit");
		b3.setPreferredSize(new Dimension(80,30));
		
		jp1=new JPanel();
		jp1.setBackground(Color.pink);
		jp1.setPreferredSize(new Dimension(800,800));
		jp1.add(l1);
		jp1.add(t1);
		jp1.add(l2);
		jp1.add(pw);
		jp1.add(b1);
		jp1.add(b2);
		jp1.add(b3);
		
		jp1.setVisible(true);
		
		jp2=new JPanel();
		jp2.setBackground(Color.cyan);
		jp2.setVisible(false);
		
		ta=new JTextArea(600,600);
		scp=new JScrollPane(ta);
		scp.setPreferredSize(new Dimension(300,300));
	
		jp2.add(scp);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		frm.add(jp1);
		frm.add(jp2);
		frm.setVisible(true);	
	}
	
	public static void main(String[] args) 
	{
		UserDeny us=new UserDeny();
		us.setObj();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent a)
	{		
		
		if(a.getSource()==b1)
		{	
			try
			{
				String p="",q="",r="";
				rs=st.executeQuery("Select * from login where name='"+t1.getText()+"' and pass='"+pw.getText()+"'");
				boolean tt = rs.next();
				if(tt) 
				{
					jp2.setVisible(true);																			
					ResultSet rs1;
					rs1=st.executeQuery("Select * from new_data");
					while(rs1.next())
					{
					 p=rs1.getString(1);
					 q=rs1.getString(2);
					 r=rs1.getString(3);
					 ta.append("Reg No."+"\t"+p+"\n"+"Sname"+"\t"+q+"\n"+"Avg"+"\t"+r+"\n"); 
					}
					
				  }
				else if(f==3)
				{
					System.exit(0);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid User");
					t1.setText("");
					pw.setText("");
					t1.requestFocus();
					f++;
					System.out.println(f);
				}
								}
			catch(Exception e)
			{
				e.getLocalizedMessage();
			}
		}
	if(a.getSource()==b2)
		{
			t1.setText("");
			pw.setText("");
			t1.requestFocus();
		}
		if(a.getSource()==b3)
		{
			System.exit(0);
		}
	}
}
