package awt_prg;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Database implements ActionListener
{
	JFrame frm;
	Label l2,l3,l4,l5,l6,l7,l8;
	Button b1,b2,b3;
	TextField t1,t2,t3,t4,t5,t6,t7;
	Choice cho;
	
	public void setObj()
	{
		Font fs=new Font("Andalus",Font.BOLD,15);
		

		frm=new JFrame("Marksheet");
		frm.getContentPane().setBackground(Color.pink);
		frm.setLocationRelativeTo(frm);
		frm.setSize(600,600);
		frm.setLayout(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				
		l2=new Label("Register Number");
		l2.setBounds(100,150,100,30);
		l2.setFont(fs);
		
		t1=new TextField(20);
		t1.setBounds(300,150,80,30);
		
		l3=new Label("Math Mark");
		l3.setBounds(100,200,100,30);
		l3.setFont(fs);
		
		t2=new TextField(20);
		t2.setBounds(300,200,80,30);
		
		l4=new Label("Science Mark");
		l4.setBounds(100,250,100,30);
		l4.setFont(fs);
		
		t3=new TextField(20);
		t3.setBounds(300,250,80,30);
		
		l5=new Label("English Mark");
		l5.setBounds(100,300,100,30);
		l5.setFont(fs);
		
		t4=new TextField(20);
		t4.setBounds(300,300,80,30);
		
		l6=new Label("Tamil Mark");
		l6.setBounds(100,350,100,30);
		l6.setFont(fs);
		
		t5=new TextField(20);
		t5.setBounds(300,350,80,30);
		
		l7=new Label("Total");
		l7.setBounds(100,400,80,30);
		l7.setFont(fs);
		
		t6=new TextField(20);
		t6.setBounds(300,400,80,30);
		
		l8=new Label("Percentage");
		l8.setBounds(100,450,100,30);
		l8.setFont(fs);
		
		t7=new TextField(20);
		t7.setBounds(300,450,80,30);
		
		b1=new Button("Clear");
		b1.setBounds(450,200,50,30);

		b2=new Button("View");
		b2.setBounds(450,250,50,30);
		
		b3=new Button("Exit");
		b3.setBounds(450,300,50,30);
		
		frm.add(l2);
		frm.add(l3);
		frm.add(l4);
		frm.add(l5);
		frm.add(l6);
		frm.add(l7);
		frm.add(l8);
		frm.add(t1);
		frm.add(t2);
		frm.add(t3);
		frm.add(t4);
		frm.add(t5);
		frm.add(t6);
		frm.add(t7);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
			
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		Database d1=new Database();
		d1.setObj();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
			t6.setText(" ");
			t7.setText(" ");
			
			t1.requestFocus();
		}
		if(e.getSource()==b2)
		{
			Connection con;
			Statement st;
			ResultSet rs;
			try
				{
				  
				    String rn = t1.getText();
				    
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
					st=con.createStatement();
					rs=st.executeQuery("Select* from marksheet where regno='"+rn+"'");
					boolean rr = rs.next();
					System.out.println(rr);
					 
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					t6.setText(rs.getString(6));
					t7.setText(rs.getString(7));
					 
					con.close();
					st.close();
				}
			
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
				JOptionPane.showMessageDialog(null,"Invalid register number");
				
				t1.setText(" ");
				t2.setText(" ");
				t3.setText(" ");
				t4.setText(" ");
				t5.setText(" ");
				t6.setText(" ");
				t7.setText(" ");
				
				t1.requestFocus();
			}
		}
			if(e.getSource()==b3)
			{
				frm.dispose();
			}
		}
	
}
