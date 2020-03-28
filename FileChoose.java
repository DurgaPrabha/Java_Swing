package swing_prg;
import java.awt.*;
import javax.swing.*;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileChoose implements ActionListener 
{
	 JFrame frm;
	 JTextArea t1;
	 JScrollPane sp;
	 JButton bt1,bt2;
	 JFileChooser cho;
	 
	 public void setObj()
	 {
		 JFrame.setDefaultLookAndFeelDecorated(true);
		 
		 frm=new JFrame("File Chooser");
		 frm.setSize(600,600);
		 frm.setLayout(new FlowLayout());
		 frm.setLocationRelativeTo(null);
		 frm.setResizable(false);
		 
		 t1=new JTextArea(15,20);
		 sp=new JScrollPane(t1);
		 
		 bt1=new JButton("Click");
		 bt1.setPreferredSize(new Dimension(120,30));
		 
		 bt2=new JButton("Exit");
		 bt2.setPreferredSize(new Dimension(120,30));
		 
		 cho=new JFileChooser();
		 frm.add(bt1);
		 frm.add(bt2);
		 frm.add(sp);
		 
		 bt1.addActionListener(this);
		 bt2.addActionListener(this);
		 
		 frm.setVisible(true);
		 frm.setDefaultCloseOperation(3);
	 }
	public static void main(String[] args)
	{
		FileChoose fc=new FileChoose();
		fc.setObj();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		File fi;
		String pa,s1=" ",s2=" ";
		if(e.getSource()==bt1)
		{
			cho.showOpenDialog(frm);
			fi=cho.getSelectedFile();
			pa=fi.getPath();
			
			try
			{
			BufferedReader bb=new BufferedReader(new FileReader(pa));
			while((s1=bb.readLine())!=null)
			{
				s2=s2+s1+"\n";
			}
			t1.setText(s2);
			bb.close();			
	        }
			catch(Exception a)
			{
				System.exit(0);
			}
		}
		if(e.getSource()==bt2)
		{
			System.exit(0);
		}
	}
}
