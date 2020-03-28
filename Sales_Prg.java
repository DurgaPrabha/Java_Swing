package awt_prg;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Sales_Prg implements ActionListener
{
	JFrame frm;
	Label l1,l2,l3,l4,l5;
	Button b1,b2,b3,b4;
	TextField t1,t2,t3,t4,t5;
	public void setObj()
	{
		Font fs=new Font("Arial",Font.BOLD,15);
		frm=new JFrame("Sales Calculation");
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(600,500);
		
		frm.getContentPane().setBackground(Color.pink);
		frm.setLayout(null);
		frm.setLocationRelativeTo(frm);
		l1=new Label("Basic Salary");
		l1.setFont(fs);
		l1.setBounds(100,150,100,30);
		
		t1=new TextField(20);
		t1.setBounds(250,150,100,30);
		 
		l2=new Label("Sales Percentage");
		l2.setFont(fs);
		l2.setBounds(90,200,130,30);
		 
		t2=new TextField(20);
		t2.setBounds(250,200,100,30);
		 
		l3=new Label("Your salary");
		l3.setBounds(100,250,100,30);
		l3.setFont(fs);
		 
		t3=new TextField(20);
		t3.setBounds(250,250,100,30);

		l4=new Label("Username");
		l4.setBounds(100,100,100,30);
		l4.setFont(fs);
		
		t4=new TextField(20);
		t4.setBounds(250,100,100,30);
		 
		b1=new Button("Clear");
		b1.setForeground(Color.BLACK);
		b1.setBounds(80,300,100,30);
		b2=new Button("Calculate");
		b2.setForeground(Color.BLACK);
		b2.setBounds(200,300,100,30);
		b3=new Button("Save Details");
		b3.setForeground(Color.BLACK);
		b3.setBounds(330,300,100,30);
		b4=new Button("Exit");
		b4.setForeground(Color.BLACK);
		b4.setBounds(440,300,80,30);
		
		 
		frm.add(l1);
		frm.add(l2);
		frm.add(l3);
		frm.add(l4);
		frm.add(t1);
		frm.add(t2);
		frm.add(t3);
		frm.add(t4);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		frm.add(b4);
		 
		frm.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

	}
	
	public static void main(String[] args) 
	{
		Sales_Prg sp=new Sales_Prg();
		sp.setObj();
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
			t4.requestFocus();
		}
		if(e.getSource()==b2)
		{
			try
			{
				int a,b,c;
				a=Integer.parseInt(t1.getText());
				b=Integer.parseInt(t2.getText());
				c=a*b/100;
				t3.setText(Integer.toString(c));
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(frm,"Invalid data");
				t4.requestFocus();
			}
		}
		if(e.getSource()==b3)
		{
			try
			{
				String a,b,c,d,sql;
				a=t1.getText();
				b=t2.getText();
				c=t3.getText();
				d=t4.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
				Statement st=con.createStatement();
				sql="insert into sales(Name,BaSal,SaPer,Salary) values('"+d+"','"+a+"','"+b+"','"+c+"')";
				st.executeUpdate(sql);
				System.out.println("Record Saved");
				st.close();
				con.close();
			}
		catch(Exception e2)
			{
				JOptionPane.showMessageDialog(frm,"Invalid Data");
			}
		}
		if(e.getSource()==b4)
		{
			frm.dispose();
		}
	}
}
