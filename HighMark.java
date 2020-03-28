package app_package;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class HighMark implements ActionListener 
{
	JFrame frm;
	JLabel l1,l2,l3;
	JButton b1,b2;
	JTextField t1,t2,t3;
	TextArea ta;
	
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
		
		b1=new JButton("First Rank");
		b1.setBounds(100,250,150,30);
		
		b2=new JButton("Exit");
		b2.setBounds(300,250,80,30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		frm.add(l1);
		frm.add(l2);
		frm.add(l3);
		frm.add(t1);
		frm.add(t2);
		frm.add(t3);
		frm.add(b1);
		frm.add(b2);
		
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		
	}
	
	public static void main(String[] args) 
	{
		HighMark hm=new HighMark();
		hm.setObj();
	}

	@Override
	public void actionPerformed(ActionEvent a) 
	{
		if(a.getSource()==b1)
		{
			Statement st;
			ResultSet rs;
			String rs1;
			try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
					st=con.createStatement();
					//rs1="select * from data";
					rs1="Select rno,sname,avg from new_data where avg=(select max(avg) from new_data)";
					rs=st.executeQuery(rs1);
					while(rs.next())
					{
						t1.setText(rs.getString(1));
						t2.setText(rs.getString(2));
						t3.setText(rs.getString(3));
					}
					JOptionPane.showMessageDialog(null, "Congratulations");
					t1.setText(" ");
					t2.setText(" ");
					t3.setText(" ");
					t1.requestFocus();
					
					con.close();
					st.close();
				}
			catch(Exception e)
			{
				e.getLocalizedMessage();
			}
		}
		if(a.getSource()==b2)
		{
			System.exit(0);
		}
   }
}
