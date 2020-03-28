package swing_prg;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.JFrame;

public class Win_Prg 
{
	JFrame frm;
	Window win;
	
	public void setObj()
	{
		frm= new JFrame("Dialog Components");
		win=new Window(frm);
		win.setSize(400,200);
		win.setLayout(new FlowLayout());
		win.setBackground(Color.CYAN);
		win.setLocationRelativeTo(frm);
		System.out.println("Window Box");
		win.setVisible(true);
	}

	public static void main(String[] args) 
	{
		Win_Prg wp=new Win_Prg();
		wp.setObj();
	}
}
