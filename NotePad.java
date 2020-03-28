package app_package;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class NotePad implements ActionListener 
{
	JFrame frm;
	JButton b1,b2,b3,b4;
	JLabel l1;
	JTextField t1;
	JTextArea ta;
	JScrollPane scp;
	Choice cho,cho1;
	JFileChooser fc;
		
	public void setObj()
	{
		frm=new JFrame("NotePad");
		JFrame.setDefaultLookAndFeelDecorated(true);
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		int x=size.width;
		int y=size.height;
		frm.setSize(x,y);
		frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frm.setLocationRelativeTo(null);
		frm.getContentPane().setBackground(Color.PINK);
		frm.setLayout(null);
		frm.setResizable(false);
		
		ta=new JTextArea(300,300);
		ta.setBounds(100,100,300,300);
		scp=new JScrollPane(ta);
		scp.setBounds(100,100,300,300);
			
		l1=new JLabel("File Name/Directory");
		l1.setBounds(50,450,130,30);
		
		t1=new JTextField(20);
		t1.setBounds(200,450,200,30);
		
		cho=new Choice();
		cho.add(".txt");
		cho.add(".dat");
		cho.add(".html");
		cho.add(".java");
		cho.setBounds(450,450,80,30);
		
		cho1=new Choice();
		cho1.setBounds(250,600,80,30);
		String a;
		File[] f=File.listRoots(); 
		for(File k:f)
		{
			a=k.toString();
			cho1.add(a);
		}
		b1=new JButton("New");
		b1.setBounds(50,500,80,30);
		
		b2=new JButton("View");
		b2.setBounds(150,500,80,30);
		
		b3=new JButton("Save");
		b3.setBounds(250,500,80,30);
		
		b4=new JButton("Exit");
		b4.setBounds(350,500,80,30);
		
		fc=new JFileChooser();

		frm.add(scp);
		//frm.add(ta);
		frm.add(l1);
		frm.add(t1);
		frm.add(cho);
		frm.add(cho1);
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		frm.add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	
		frm.setDefaultCloseOperation(3);
		frm.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		NotePad np=new NotePad();
		np.setObj();
	}

	@Override
	public void actionPerformed(ActionEvent d)
	{
		if(d.getSource()==b1)
		{
			t1.setText("");
			ta.setText("");
			t1.requestFocus();		
		}
		
		if(d.getSource()==b2)
		{
			String a,b,c,f,s1="";
			a=cho1.getSelectedItem();
			b=t1.getText();
			c=cho.getSelectedItem();
			f=a+b+c;
			File fi=new File(f);
			try
			{
			Scanner sc=new Scanner(fi);
			while(sc.hasNext())
			{
				s1=s1+sc.nextLine()+"\n";
			}
			
				ta.setText(s1);
				sc.close();
				
			}
			catch(Exception e)
				{
					e.getLocalizedMessage();
				}
			
		}
		if(d.getSource()==b3)
		{
			try
			{
			String s1;
			s1=ta.getText();
			
			File fi=new File("D//"+t1.getText()+"."+cho.getSelectedItem());
			FileWriter fw=new FileWriter(fi);
			fw.write(s1);
			//fc.showSaveDialog(frm);
			System.out.println("Record Saved");
			fw.close();
			}
			catch(Exception e)
			{
				System.exit(0);
			}
			
		}
		if(d.getSource()==b4)
		{
			frm.dispose();
		}
	}
}
