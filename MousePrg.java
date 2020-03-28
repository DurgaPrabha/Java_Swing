package swing_prg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MousePrg implements MouseListener, AdjustmentListener 
{
	JFrame frm;
	JTextField txt1;
	JPasswordField pwd;
	JButton b1,b2;
	JPopupMenu pop;
	JMenuItem m1,m2,m3,m4;
	Scrollbar scb;
	
	public void setObj()
	{
		scb=new Scrollbar(Scrollbar.HORIZONTAL);
		scb.setPreferredSize(new Dimension(200,30));
		scb.setMinimum(0);
		scb.setMaximum(100);
		scb.setUnitIncrement(5);
		
		pop=new JPopupMenu();
		
		m1=new JMenuItem("Durga");
		m3=new JMenuItem("Akshiya");
		m2=new JMenuItem("Soumi");
		m4=new JMenuItem("Aarthi");
		
		pop.add(m1);
		pop.add(m2);
		pop.add(m3);
		pop.add(m4);
		
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		int x=size.width;
		int y=size.height;
		
		txt1=new JTextField(20);
		pwd=new JPasswordField(20);
		
		b1=new JButton("Show");
		b2=new JButton("Click");
		
		frm=new JFrame("Mouse Program");
		frm.setLayout(new FlowLayout());
		frm.setLocationRelativeTo(null);
		frm.setSize(x,y);
		frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frm.add(b1);
		frm.add(b2);
		frm.add(txt1);
		frm.add(pwd);
		frm.add(pop);
		frm.add(scb);
		
		txt1.addMouseListener(this);
		pwd.addMouseListener(this);
		b1.addMouseListener(this);
		frm.addMouseListener(this);
		scb.addAdjustmentListener(this);
		
		txt1.setEnabled(false);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(3);
	}
	
	public static void main(String[] args) 
	{
		MousePrg mp=new MousePrg();
		mp.setObj();
	}

	@Override
	public void mouseClicked(MouseEvent mo1) 
	{
		if(mo1.getSource()==frm && mo1.getButton()==3)
		{
			pop.show(frm,mo1.getX(),mo1.getY());
		}
	}
	@Override
	public void mouseEntered(MouseEvent mo2) 
	{
		if(mo2.getSource()==txt1)
		{
			txt1.setText("Welcome");
		}
	}
	@Override
	public void mouseExited(MouseEvent mo3) 
	{
		if(mo3.getSource()==txt1)
		{
			txt1.setText(" ");
		}
	}
	@Override
	public void mousePressed(MouseEvent mo4) 
	{
		if(mo4.getSource()==b1)
		{
			pwd.setEchoChar((char)0);
		}
	}
	@Override
	public void mouseReleased(MouseEvent mo5) 
	{
		if(mo5.getSource()==b2)
		{
			pwd.setEchoChar('*');
		}
	}
	@Override
	public void adjustmentValueChanged(AdjustmentEvent ad) 
	{
		if(ad.getSource()==scb)
		{
			String s=Integer.toString(scb.getValue());
			txt1.setText(s);
		}
	}
}
