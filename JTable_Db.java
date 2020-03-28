package app_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTable_Db implements ActionListener
{
	JFrame frm;
	JTable tab;
	JScrollPane jp1;
	JButton bt1,bt2; 
	JPanel p1,p2;
	BorderLayout bl;
	String[] a= {"Rno","Sname","Average"};
	Object[] []d;
	
	public void setObj()
	 {
		try
		{
			Connection con;
			Statement st;
			ResultSet rs,rs1;
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
			st=con.createStatement();
			rs=st.executeQuery("Select* from new_data");
			int i=0;
			while(rs.next())
			{
				i++;
			}
			d= new Object[i][3];
			int k=0;
			rs1=st.executeQuery("Select* from new_data");
			while(rs1.next())
			{
				d[k][0]=rs1.getString(1);
				d[k][1]=rs1.getString(2);
				d[k][2]=rs1.getString(3);
				k++;
			}
			
			con.close();
			st.close();	
		   }
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		
		tab=new JTable(d,a);
		jp1=new JScrollPane(tab);
		jp1.setPreferredSize(new Dimension(300,300));
					
		p1=new JPanel();
		p1.setBackground(Color.lightGray);
		p1.setVisible(true);
		
		bt1=new JButton("View");
		bt1.setPreferredSize(new Dimension(100,30));
		
		bt2=new JButton("Exit");
		bt2.setPreferredSize(new Dimension(60,30));
					
		p1.add(bt1);
		p1.add(bt2);
		
		p2=new JPanel();
		p2.setBackground(Color.pink);
		p2.add(jp1);
		p2.setPreferredSize(new Dimension (300,300));
		p2.setVisible(false);
		
		frm=new JFrame("Student Table");
		frm.setSize(600,600);
		bl=new BorderLayout(10,10); 
		frm.setLayout(bl);
		frm.getContentPane().setBackground(Color.lightGray);
		frm.setDefaultCloseOperation(3);
		frm.setLocationRelativeTo(frm);
		frm.add(p1,BorderLayout.NORTH);
		frm.add(p2,BorderLayout.CENTER);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
		frm.setVisible(true);
	 }
	public static void main(String[] args) 
	{
		JTable_Db jt=new JTable_Db();
		jt.setObj();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==bt1)
		{
			p2.setVisible(true);
		}
		
		if(e.getSource()==bt2)
		{
			System.exit(0);
		}
   }
}
