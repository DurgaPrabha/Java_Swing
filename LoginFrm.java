package pec_ece_student;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class LoginFrm implements ActionListener, KeyListener
{
	String[] type= {"Admin","User"};
	
	JFrame logfrm;
	JLabel hlbl,ulbl,plbl,tlbl,ilbl;
	Image img1,img2;
	ImageIcon imc1;
	JTextField utxt;
	JPasswordField ptxt;
	JComboBox<String> ttxt;
	JButton rbtn,sbtn,lbtn;
	Font fs1,fs2;
	Connection con;
	Statement st;
	ResultSet rs;
		
	public LoginFrm()
	 {
		 try
		 {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecestudentsdb","root","");
			st=con.createStatement();
		 }
		 catch(Exception a)
		 {
			 JOptionPane.showMessageDialog(null, "Database not connected");
		 }
	 }
	
	public void setObj()
	{
		fs1=new Font("Arial", Font.BOLD, 20);
		fs2=new Font("Arial",Font.BOLD,14);
		
		img1=Toolkit.getDefaultToolkit().getImage("d:\\Photos\\peclogo.png");
		img2=Toolkit.getDefaultToolkit().getImage("d:\\Photos\\im5.png");
		img2=img2.getScaledInstance(120, 110, Image.SCALE_SMOOTH);
		imc1=new ImageIcon(img2);
		JFrame.setDefaultLookAndFeelDecorated(true);
		logfrm=new JFrame("Paavai Engineering College welcomes you!");
		logfrm.setSize(500,290);
		logfrm.setLayout(null);
		logfrm.getContentPane().setBackground(Color.DARK_GRAY);
		logfrm.setDefaultCloseOperation(3);
		logfrm.setLocationRelativeTo(null);
		logfrm.setIconImage(img1);
		
		hlbl=new JLabel("Login Screen");
		hlbl.setFont(fs1);
		
		ulbl=new JLabel("User Name : ");
		plbl=new JLabel("Password  : ");
		tlbl=new JLabel("         Type : ");
		ilbl=new JLabel(imc1);
		
		ulbl.setFont(fs2);
		plbl.setFont(fs2);
		tlbl.setFont(fs2);
				
		utxt=new JTextField(20);
		ptxt=new JPasswordField(10);
		ttxt=new JComboBox<>(type);
		
		rbtn=new JButton("Reset");
		sbtn=new JButton("SignIn");
		lbtn=new JButton("Logout");
		
		logfrm.add(hlbl);
		logfrm.add(ulbl);
		logfrm.add(utxt);
		logfrm.add(plbl);
		logfrm.add(ptxt);
		logfrm.add(tlbl);
		logfrm.add(ttxt);
		logfrm.add(ilbl);
		logfrm.add(rbtn);
		logfrm.add(sbtn);
		logfrm.add(lbtn);
		
		hlbl.setBounds(185, 20, 130, 30);
		hlbl.setForeground(Color.WHITE);
		 
		ulbl.setBounds(30, 70, 90, 30);
		ulbl.setForeground(Color.white);
		plbl.setBounds(30, 110, 90, 30);
		plbl.setForeground(Color.white);
		
		tlbl.setBounds(30, 150, 90, 30);
		tlbl.setForeground(Color.white);
		
		utxt.setBounds(130, 70, 150, 25);
		ptxt.setBounds(130, 110, 150, 25);
		ttxt.setBounds(130, 150, 150, 25);
		
		ilbl.setBounds(300, 70, 170,110);
		
		rbtn.setBounds(60, 200, 110,30);
		sbtn.setBounds(180, 200, 110,30);
		lbtn.setBounds(300, 200, 110,30);
		
		rbtn.addActionListener(this);
		sbtn.addActionListener(this);
		lbtn.addActionListener(this);
		
		utxt.addKeyListener(this);
		ptxt.addKeyListener(this);
		logfrm.setVisible(true);
		
	}
	
	public static void main(String[] args) 
	{
		LoginFrm lp=new LoginFrm();
		lp.setObj();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==rbtn)
		{
			utxt.setText("");
			ptxt.setText("");
			ttxt.setSelectedItem("Admin");
			ttxt.setRequestFocusEnabled(true);
		}
		if(a.getSource()==sbtn)
		{
			try
			{
				rs=st.executeQuery("Select * from login_details where Name='"+utxt.getText()+"' and Password='"+ptxt.getText()+"' and Type='"+ttxt.getSelectedItem()+"'");
				boolean tt = rs.next();
				if(tt) 
				{
					Welcome_pg wp=new Welcome_pg();
					wp.setObj();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid User");
					utxt.setText("");
					ptxt.setText("");
					ttxt.setSelectedItem("Admin");
					utxt.requestFocus();
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Database not connected");
			}
		}
		if(a.getSource()==lbtn)
		{
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent b)
	{
		if(b.getSource()==utxt && b.getKeyCode()==KeyEvent.VK_ENTER)
		{
			ptxt.requestFocus();
		}
		
		if(b.getSource()==ptxt && b.getKeyCode()==KeyEvent.VK_ENTER)
		{
			ttxt.requestFocus();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
