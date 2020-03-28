package swing_prg;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class lay_prg extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5;
	JFrame frm;
	GridBagLayout gb;
	GridBagConstraints gbc;
	CardLayout cl;
	Container c;
	public void card()
	{
		cl=new CardLayout(20,20);
		c=getContentPane();
		c.setLayout(cl);
		
		b1=new JButton("card 1");
		b2=new JButton("card 2");
		b3=new JButton("card 3");
		b4=new JButton("card 4");
		b5=new JButton("card 5");
		
		c.add(b1);
		c.add(b2);
		c.add("s",b3);
		c.add(b4);
		c.add(b5);
		
		setSize(600,600);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setVisible(true);
	}
	
	public void grid()
	{
		setTitle("Grid Layout");
		setLayout(new GridLayout(2,3));
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		setSize(600,600);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		pack();
		setVisible(true);
		
	}
	public void gridHor()
	{
	b1=new JButton("one");
	b2=new JButton("Two");
	b3=new JButton("Three");
	b4=new JButton("Four");
	b5=new JButton("Five");
	
	gb=new GridBagLayout();
	gbc=new GridBagConstraints();
	gbc.insets=new Insets(30,20,20,30);
	gbc.fill=GridBagConstraints.HORIZONTAL;
	
	frm=new JFrame("Gridbag Layout...!");
	frm.setSize(800,800);
	frm.setLayout(gb);
	frm.setLocationRelativeTo(null);
	frm.setDefaultCloseOperation(3);
	
	gbc.gridx=0;
	gbc.gridy=0;
	gb.setConstraints(b1,gbc);
	
	gbc.gridx=1;
	gbc.gridy=0;
	gb.setConstraints(b2,gbc);
	
	gbc.gridx=2;
	gbc.gridy=0;
	//gbc.gridwidth=2;
	gb.setConstraints(b3,gbc);
	
	gbc.gridx=0;
	gbc.gridy=1;
	//gbc.gridwidth=2;
	gb.setConstraints(b4,gbc);
	
	gbc.gridx=1;
	gbc.gridy=1;
	gbc.gridwidth=2;
	gb.setConstraints(b5,gbc);
	
	frm.add(b1);
	frm.add(b2);
	frm.add(b3);
	frm.add(b4);
	frm.add(b5);
	frm.pack();
	frm.setVisible(true);
	}
		public void gridVer()
		{
		b1=new JButton("one");
		b2=new JButton("Two");
		b3=new JButton("Three");
		b4=new JButton("Four");
		b5=new JButton("Five");
		
		gb=new GridBagLayout();
		gbc=new GridBagConstraints();
		gbc.insets=new Insets(10,20,20,20);
		gbc.fill=GridBagConstraints.VERTICAL;
		
		frm=new JFrame("Gridbag Layout...!");
		frm.setSize(800,800);
		frm.setLayout(gb);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(3);
		
		gbc.ipadx=40;
		gbc.ipady=30;
		
		gbc.gridx=0;
		gbc.gridy=0;
		gb.setConstraints(b1,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gb.setConstraints(b2,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gb.setConstraints(b3,gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridheight=3;
		gb.setConstraints(b4,gbc);
		
		gbc.gridx=2;
		gbc.gridy=0;
		//gbc.gridheight=3;
		gb.setConstraints(b5,gbc);
		
		frm.add(b1);
		frm.add(b2);
		frm.add(b3);
		frm.add(b4);
		frm.add(b5);
		frm.pack();
		frm.setVisible(true);
		}

	public static void main(String[] args) 
	{
	lay_prg gl=new lay_prg();
	gl.gridHor();
//	gl.gridVer();
//	gl.grid();
//	gl.card();
	}
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==b1)
		{
			//cl.last(c);
			cl.show(c,"s");
			//cl.next(c);
		}
		if(ae.getSource()==b2)
		{
			cl.previous(c);
		}
	}

}
