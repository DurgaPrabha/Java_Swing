package swing_prg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FileDia implements ActionListener, KeyListener 
{
	JFrame frm;
	JButton b1;
	JLabel l1;
	JTextField t1,t2,t3;
	FileDialog dia;
	
	public void setObj()
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		frm=new JFrame("File Dialog");
		frm.setLayout(new FlowLayout());
		frm.setSize(800,800);
		frm.setLocationRelativeTo(null);
		frm.setResizable(false);
		
		l1=new JLabel("File Name");
		t1=new JTextField(20);
		t2=new JTextField(20);
		b1=new JButton("Choose");
		
		dia=new FileDialog(frm,"Select a File");
		
		frm.add(l1);
		frm.add(b1);
		frm.add(t1);
		frm.add(t2);
		
		b1.addActionListener(this);
		t1.addKeyListener(this);
		t2.addKeyListener(this);
		
		frm.setVisible(true);
	}
	public static void main(String[] args) 
	{
		FileDia fd=new FileDia();
		fd.setObj();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String s1;
		if(e.getSource()==b1)
		{
			dia.setVisible(true);
			s1=dia.getDirectory()+dia.getFile();
			t1.setText(s1);
		}
	}
	@Override
	public void keyPressed(KeyEvent k1)
	{
		if(k1.getKeyCode()==KeyEvent.VK_ENTER && k1.getSource()==t1);
		{
			t2.setText(t1.getText());
			t2.requestFocus();
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
