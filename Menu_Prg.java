package swing_prg;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
//import javax.swing.JToolBar;

public class Menu_Prg implements KeyListener
{
	JFrame frm;
	JMenuBar mb;
	JMenu m1,m2,m3,sub;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7;
	JMenuItem s1,s2;
	JLabel bglb;
	Image imic,bg;
	ImageIcon bg1;
	//Image im1,im2,im3,im4,im5,im6;
	//ImageIcon imi1,imi2,imi3,imi4,imi5,imi6;
	//JButton b1,b2,b3;
	//JToolBar tb;
	
	public void setObj()
	{
		imic=Toolkit.getDefaultToolkit().getImage("D://Photos//img1.jpg");
		
		mb=new JMenuBar();
		
		m1=new JMenu("File");
		m1.setMnemonic(KeyEvent.VK_F);
		m1.addKeyListener(this);
				
		mi1=new JMenuItem("New");
		mi2=new JMenuItem("Open");
		mi3=new JMenuItem("Exit");
		
		//mi1.addKeyListener(this);
		//mi2.addKeyListener(this);
		m1.add(mi1);
		m1.add(mi2);
		m1.addSeparator();
		m1.add(mi3);
		
		mb.add(m1);
		
		m2=new JMenu("Edit");
		m2.setMnemonic(KeyEvent.VK_E);
		m2.addKeyListener(this);
		
		mi4=new JMenuItem("Select");
		//mi4.addKeyListener(this);
		mi5=new JMenuItem("Copy");
		//mi5.addKeyListener(this);
		m2.add(mi4);
		m2.add(mi5);
		
		mb.add(m2);
		
		sub=new JMenu("Users");
		
		s1=new JMenuItem("Durga");
		s2=new JMenuItem("Soumi");
		sub.add(s1);
		sub.add(s2);
		
		m3=new JMenu("Sub Menu");
		mi6=new JMenuItem("Calculator");
		mi7=new JMenuItem("Notepad");
		
		m3.add(mi6);
		m3.add(mi7);
		m3.add(sub);
		
		mb.add(Box.createHorizontalGlue());
		mb.add(m3);
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int x=size.width;
		int y=size.height;
		
		bg=Toolkit.getDefaultToolkit().getImage("D://Photos//img2.jpg");
		bg=bg.getScaledInstance(x, y,Image.SCALE_SMOOTH);
		bg1=new ImageIcon(bg);
		bglb=new JLabel(bg1);
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		frm=new JFrame("Swing Components");
		frm.setSize(x,y);
		frm.setExtendedState(frm.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		frm.setDefaultCloseOperation(3);
		frm.setLayout(new BorderLayout());
		frm.setIconImage(imic);
		
		frm.setJMenuBar(mb);
		frm.add(bglb,BorderLayout.CENTER);
		frm.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		Menu_Prg sp=new Menu_Prg();
		sp.setObj();
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getSource()==m1 && e.getKeyCode()==KeyEvent.VK_F)
		{
			JOptionPane.showMessageDialog(null,"Key");
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
