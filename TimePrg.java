package app_package;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TimePrg 
{
   JFrame frm;
   JButton bt;
   Boolean tt=true;
   String a;
   public void setObj() throws InterruptedException
   {
	   frm=new JFrame("Displays Time");
	   frm.setSize(300,300);
	   frm.setLayout(null);
	   frm.setResizable(false);
	   frm.getContentPane().setBackground(Color.lightGray);
	   frm.setLocationRelativeTo(frm);
	   bt=new JButton("Time");
	   bt.setPreferredSize(new Dimension(100,100));
	   bt.setBackground(Color.pink);
	   frm.add(bt);
	   bt.setBounds(50, 80, 100, 50);
	   frm.setDefaultCloseOperation(3);
	   frm.setVisible(true);
	   Time();
	   
   }
   
	public void Time() throws InterruptedException 
	{
	  while(tt)
	  {
		  /* Date Format
		   * java.sql.Date dd=new java.sql.Date(System.currentTimeMillis();
		   * 
		   * SimpleDateFormat formatter=new SimpleDateFormat("dd:MM:yyyy");
		   * String a=formatter.format(dd);
		   */

		  /* Time Format */
		  java.sql.Time tt=new java.sql.Time(System.currentTimeMillis());
		  SimpleDateFormat formatter=new SimpleDateFormat("HH:mm:ss");
		  Thread.sleep(1000);
		  String a=formatter.format(tt);
		  
		  bt.setText(a);
	  }
	}

	public static void main(String[] args) throws InterruptedException 
	{
		TimePrg tp=new TimePrg();
		tp.setObj();
	}
}
