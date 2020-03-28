package awt_prg;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Data_Store implements ActionListener,KeyListener
{
	JFrame frm;
	Label l1,l2,l3;
	Button b1,b2,b3;
	TextField t1,t2,t3;
	
	public void setObj()
	{
	 Font fs=new Font("Andalus",Font.BOLD,12);
	 JFrame.setDefaultLookAndFeelDecorated(true);
	 frm=new JFrame("AWT Components");
	 frm.setLocationRelativeTo(frm);
	 frm.setSize(600,600);
	 frm.setLayout(null);
	 frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frm.getContentPane().setBackground(Color.pink);
	 
	 l1=new Label("Roll No");
	 l1.setFont(fs);
	 l1.setBounds(100,100,80,30);
	 
	 t1=new TextField(20);
	 t1.setBounds(180,100,80,30);
	 
	 l2=new Label("Name");
	 l2.setFont(fs);
	 l2.setBounds(100,150,80,30);
	 
	 t2=new TextField(20);
	 t2.setBounds(180,150,80,30);
	 
	 l3=new Label("Average");
	 l3.setBounds(100,200,80,30);
	 l3.setFont(fs);
	 
	 t3=new TextField(20);
	 t3.setBounds(180,200,80,30);

	 b1=new Button("Clear");
	 b1.setForeground(Color.BLACK);
	 b1.setBounds(100,250,50,30);
	 b2=new Button("Save");
	 b2.setForeground(Color.BLACK);
	 b2.setBounds(180,250,50,30);
	 b3=new Button("Exit");
	 b3.setForeground(Color.BLACK);
	 b3.setBounds(250,250,50,30);
	 
	 
	 frm.add(l1);
	 frm.add(l2);
	 frm.add(l3);
	 frm.add(t1);
	 frm.add(t2);
	 frm.add(t3);
	 frm.add(b1);
	 frm.add(b2);
	 frm.add(b3);
	 
	 frm.setVisible(true);
	 
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	 
	 t1.addKeyListener(this);
	 t2.addKeyListener(this);
	 t3.addKeyListener(this);
	
	}
	
	public static void main(String[] args) 
	{
		Data_Store ds=new Data_Store();
		ds.setObj();
	}
		 
	 public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t1.requestFocus();
		}
		if(e.getSource()==b2)
		{
			try
			{
				String a,b,c,sql;
				a=t1.getText();
				b=t2.getText();
				c=t3.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
				Statement st=con.createStatement();
				sql="insert into new_data(Rno,Sname,Avg) values('"+a+"','"+b+"','"+c+"')";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"Record Saved");
				st.close();
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		if(e.getSource()==b3)
		{
			frm.dispose();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent aa) 
	{
		if(aa.getSource()==t1 && aa.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t2.requestFocus();
		}
		if(aa.getSource()==t2 && aa.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t3.requestFocus();
		}
		if(aa.getSource()==b2 || aa.getKeyCode()==KeyEvent.VK_S)
		{
			try
			{
				String a,b,c,sql;
				a=t1.getText();
				b=t2.getText();
				c=t3.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/durgadb","root","");
				Statement st=con.createStatement();
				sql="insert into new_data(Rno,Sname,Avg) values('"+a+"','"+b+"','"+c+"')";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"Record Saved");
				st.close();
				con.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		if(aa.getSource()==b1 || aa.getKeyCode()==KeyEvent.VK_C)
		{
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t1.requestFocus();
		}
		if(aa.getSource()==b3 || aa.getKeyCode()==KeyEvent.VK_E)
		{
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
