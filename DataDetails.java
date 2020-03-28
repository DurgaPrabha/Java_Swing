package app_package;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class DataDetails implements ActionListener 
{
	JFrame frm;
	JLabel l1,l2,l3;
	JButton b1,b2,b3,b4,b5;
	JTextField t1,t2,t3;
	TextArea ta;
	Statement st;
	ResultSet rs;
	String rs1;
	Connection con;
	public DataDetails()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
		st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs1="Select * from new_data";
		rs=st.executeQuery(rs1);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
	}
	
	
	public void setObj()
	{
		Font fs=new Font("Andalus",Font.BOLD,15);
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		frm=new JFrame("Rank Holder");
		frm.getContentPane().setBackground(Color.pink);
		frm.setLocationRelativeTo(frm);
		frm.setSize(600,600);
		frm.setLayout(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1=new JLabel("Roll No");
		l1.setFont(fs);
		l1.setBounds(100,100,80,30);
		 
		t1=new JTextField(20);
		t1.setBounds(180,100,80,30);
		 
		l2=new JLabel("Name");
		l2.setFont(fs);
		l2.setBounds(100,150,80,30);
		 
		t2=new JTextField(20);
		t2.setBounds(180,150,80,30);
		 
		l3=new JLabel("Average");
		l3.setBounds(100,200,80,30);
		l3.setFont(fs);
		 
		t3=new JTextField(20);
		t3.setBounds(180,200,80,30);
		
		b1=new JButton("First");
		b1.setBounds(50,250,80,30);
		
		b2=new JButton("Last");
		b2.setBounds(150,250,80,30);
		
		b3=new JButton("Previous");
		b3.setBounds(250,250,100,30);

		b4=new JButton("Next");
		b4.setBounds(100,300,80,30);
		
		b5=new JButton("Exit");
		b5.setBounds(200,300,80,30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		frm.add(l1);
		frm.add(l2);
		frm.add(l3);
		frm.add(t1);
		frm.add(t2);
		frm.add(t3);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		frm.add(b4);
		frm.add(b5);
		
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		
		
		
	}
	
	
	
	public static void main(String[] args) 
	{
		DataDetails hm=new DataDetails();
		hm.setObj();
	}

	@Override
	public void actionPerformed(ActionEvent a) 
	{
		if(a.getSource()==b1)
		{
			
			try
				{
					rs.first();
					
					t1.setText(rs.getString(1));
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					
			}
			catch(Exception e)
			{
				e.getLocalizedMessage();
			}
		}
		if(a.getSource()==b2)
		{
			 try
				{
					 rs.last();
					
					t1.setText(rs.getString(1));
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					
					 
				}
			catch(Exception e)
			{
				e.getLocalizedMessage();
				JOptionPane.showMessageDialog(null,e);
			}
		}
		if(a.getSource()==b3)
		{
			 try
				{
					 rs.previous();
					
					t1.setText(rs.getString(1));
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					
					 
				}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e);
				e.getLocalizedMessage();
			}
		}
		if(a.getSource()==b4)
		{
			 try
				{
					 rs.next();
					
					t1.setText(rs.getString(1));
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					
					 }
			catch(Exception e)
			{
				e.getLocalizedMessage();
			}
		}
		if(a.getSource()==b5)
		{
			System.exit(0);
		}
   }
}

