  
package start;

import javax.swing.border.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.*;
import sun.audio.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")

public class JLetter extends JFrame {

	public static void main(String[] args) {
				
		SwingUtilities.invokeLater(new Runnable() 
			{
				public void run() 
				{
					new JLetter();
				}
			});
	}
	
private JLetter() 
{
	super("L.E.T.T.E.R.");
	launch();
}

//-----------------------------------------------TO PLACE IN MENU BAR
	private JMenu createFileJMenu()
	{
		JMenu f = new JMenu("File");	
		
		f.setMnemonic(KeyEvent.VK_C);
		f.add(createQuitAction());
		
		return f;
	}
	
	private JMenu createExtraJMenu()
	{
		JMenu h = new JMenu("Extra");
		h.add(createAboutAction());
		h.add(createHelpAction());
		return h;
	}
	//-----------------------------------------------TO PLACE IN MENU BAR
	
	//-----------------------------------------------FOR EACH ELEMENT IN MENU BAR
	
	
	private Action createQuitAction()
	{	
		if(quitAction == null)
		{
			quitAction = new AbstractAction("Quit")
			{
				public void actionPerformed(ActionEvent e)
				{
					performQuitAction();
				}
				{
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
					putValue(MNEMONIC_KEY, KeyEvent.VK_Q);
				}
			};
		}
		return quitAction;
	} 
	private Action createAboutAction()
	{
		if(aboutAction == null)
		{
			aboutAction = new AbstractAction("About")
			{
				public void actionPerformed(ActionEvent e)
				{
					performAboutAction();
				}
				{
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
					putValue(MNEMONIC_KEY, KeyEvent.VK_A);
				}
			};
		}
		return aboutAction;
	}
	private Action createHelpAction()
	{
		if(helpAction == null)
		{
			helpAction = new AbstractAction("Help")
			{
				public void actionPerformed(ActionEvent e)
				{
					performHelpAction();
				}
			{
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_MASK));
				putValue(MNEMONIC_KEY, KeyEvent.VK_H);
			}
			};
		}
		return helpAction;
	}
//-----------------------------------------------FOR EACH ELEMENT IN MENU BAR
	
	private JMenuBar createJMenuBar() //MENU TOOLBAR {FILE SONGS HELP} 
	{
		JMenuBar mb = new JMenuBar();
		mb.add(createFileJMenu());
		mb.add(createExtraJMenu());
		return mb;
	}
	
	
	//-----------------------------------------------BUTTONS
	private JButton createReadJButton() //READ A LETTER
	{
		JButton b = new JButton("Read a letter?");
		b.setFont(new Font(b.getFont().getName(), Font.PLAIN, b.getFont().getSize()));
		b.addActionListener(new ActionListener() //Links the button to what it's supposed to do
		{
			public void actionPerformed(ActionEvent e) 
			{
				performReadAction();
			}
		});
		return b;
	}
	private JButton createListenJButton() //LISTEN TO MUSIC
	{
		JButton b = new JButton("Listen to music?");
		b.setFont(new Font(b.getFont().getName(), Font.PLAIN, b.getFont().getSize()));
		b.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				performListenAction();
			}
		}
		);
		return b;
	}
	private JButton createSitJButton() //SIT IN SILENCE 
	{	
		JButton b = new JButton("Sit in silence?");
		b.setFont(new Font(b.getFont().getName(), Font.PLAIN, b.getFont().getSize()));
		b.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				performSitAction();
			}
		});
		return b;
	}
	private JButton createPhotoJButton() //CALL MY CREATOR
	{
		JButton b = new JButton("Look at photos?");
		b.setFont(new Font(b.getFont().getName(), Font.PLAIN, b.getFont().getSize()));
		b.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				performPhotoAction();
			}
		});
		return b;
	}
	private JButton createTalkJButton() //TALK TO ME
	{	
		JButton b = new JButton("Talk to me?");
		b.setFont(new Font(b.getFont().getName(), Font.PLAIN, b.getFont().getSize()));
		b.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				performTalkAction();
			}
		});
		return b;
	}
	private JButton createExitJButton() //EXIT
	{
		JButton b = new JButton("Exit?"); //Generates new button graphic
		b.setFont(new Font(b.getFont().getName(), Font.PLAIN, b.getFont().getSize())); //Sets font variables for text displayed on button
		b.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				performQuitAction();
			}
		});
		return b;
	}
	//-----------------------------------------------BUTTONS
	

//-----------------------------------------------ACTIONS FOR BUTTONS
	private void performReadAction() 
	{
		JFrame frame = new JFrame("L.E.T.T.E.R");
		frame.getContentPane().add(new ActualLetter());
		frame.pack();
		frame.setVisible(true);
	}
	private void performListenAction() 
	{
		try
		{
			Runtime.getRuntime().exec("cmd /c start songs.html");
		}
		catch(IOException e){}
	}
	private void performSitAction() 
	{
			
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			String message = "Ok. I'll be here if you need me";
			JOptionPane.showMessageDialog(frame, message, "Take it easy", JOptionPane.PLAIN_MESSAGE);
			
	}
	private void performPhotoAction() 
	{
	
		JFrame frame = new JFrame("Pictures");
		frame.getContentPane().add(new Photoes());
		frame.pack();
		frame.setVisible(true);	
	
	}
	private void performTalkAction()
	{
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			String message = "LOOK WHAT I CAN DO!!!";
			JOptionPane.showMessageDialog(frame, message, "HEY!", JOptionPane.PLAIN_MESSAGE);
			
			Robot robot;
			try
			{
				Random generate = new Random();
				
				robot=new Robot();
				for (int i = 0; i < 600; i++)
				{
					int rand1 = 320 + generate.nextInt(640);
					int rand2 = 180 + generate.nextInt(360);
					robot.mouseMove(rand1,rand2);
					Thread.sleep(25);
				}
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
			catch (AWTException ex)
			{
				System.err.println("Can't start Robot: " + ex);
				System.exit(0);
			}
			
			//message = "What did you expect? I'm only " + age + " years old.";
			message = "What did you expect? I'm only a few months old.";
			JOptionPane.showMessageDialog(frame, message, "Sorry", JOptionPane.PLAIN_MESSAGE);
			
	}
	private void performQuitAction() 
	{
		System.exit(0);
	}
//DONE
	private void performAboutAction()
	{
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		
		String message = "I AM L.E.T.T.E.R." 
		+ "\n"
		+ "\n"
		+ "-> Letter" + "\n"
		+ "-> Emulating" + "\n"
		+ "-> Through" + "\n"
		+ "-> Terminal" + "\n"
		+ "-> Extremely" + "\n"
		+ "-> Radically" 
		+ "\n"
		+ "\n"
		+ "Build Start: March 28,2013" + "\n"
		+ "Build End: August 8,2013" + "\n"
		+ "Version 1.0" + "\n"
		+ "AUTHOR: Dmytro Malaniouk" + "\n"
		+ "SOURCE CODE AT:"+ "\n"
		+ "web.njit.edu/~dm282" + "\n"
		+ "This software is not licensed." + "\n";
			
		JOptionPane.showMessageDialog(frame, message, "ABOUT", JOptionPane.PLAIN_MESSAGE);
	}  
//DONE
	private void performHelpAction()
	{
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		
		String message = "The program is fairly self explanatory. " 
		+ "\n"
		+"If you are in possession of this 	 " + "\n"
		+"program, then the following options are" + "\n"
		+"catered to your specific category. 	 " + "\n"
		+"There are however extra features that  " + "\n"
		+"can be accessed. Play around. See what " + "\n"
		+"happens." + "\n" + "-DM";
		
		JOptionPane.showMessageDialog(frame, message, "HELP", JOptionPane.PLAIN_MESSAGE);
	}
//-----------------------------------------------ACTIONS FOR BUTTONS




//-----------------------------------------------Creme de la creme ENGINE
	private void launch() 
	{
	
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;	//GET HEIGHT OF SCREEN
		int width  = Toolkit.getDefaultToolkit().getScreenSize().width;		//GET WIDTH OF SCREEN
		
		setBounds(width / 2 - 300, height / 2 - 300, 500, 400); 			//SETS WIDTH AND HEIGHT OF PROGRAM
		//Last two value set x and y
		setDefaultCloseOperation(EXIT_ON_CLOSE);							//SETS DEFAULT CLOSE OPERATION
		setJMenuBar(createJMenuBar());										//CREATES THE {FILE, SONGS, HELP} BAR
		setResizable(true);													//LETS USER RESIZE WINDOWS
		
//-----------------------------------------------PANELS
	//MAIN PANEL -> MainPanel
		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.white);
		MainPanel.setLayout(new GridLayout(2,0,10,10));
	
	//IMAGE PANEL -> t
		JPanel t = new JPanel();				
		t.setBackground(Color.white);	
		t.setLayout(new GridLayout(0, 1, 5, 5));
	
		ImageIcon icon = new ImageIcon("pic/image.jpg", "Image");
		JLabel label = new JLabel(icon);
	
		t.add(label, BorderLayout.SOUTH);
	
	//BUTTON PANEL -> Button
		JPanel Button = new JPanel();											
		Button.setLayout(new GridLayout(0, 3, 10, 10)); 
	//#A-How many rows? #B-How many columns? #C-Horizontal gap #D-Vertival gap
	
	//BUTTONS
		{
			Button.add(createReadJButton());
			Button.add(createListenJButton());
			Button.add(createSitJButton());
			Button.add(createPhotoJButton());
			Button.add(createTalkJButton());
			Button.add(createExitJButton());
		}
	
		MainPanel.add(t, BorderLayout.NORTH);
		MainPanel.add(Button,BorderLayout.CENTER);
		
		add(MainPanel, BorderLayout.CENTER);
	
//-----------------------------------------------PANELS
		setVisible(true);
	}
//-----------------------------------------------Creme de la creme ENGINE

//-----------------------------------------------ADDITIONAL GLOBAL VARIABLES
private Action quitAction;
private Action aboutAction;
private Action helpAction;
//-----------------------------------------------ADDITIONAL GLOBAL VARIABLES		
		
} 

//CLASS FOR INITIATING SEPERATE LETTER WINDOW
class ActualLetter extends JPanel {
    private JTextArea textArea;
	
    public ActualLetter() {
		BufferedReader br = null;
        //construct components
        textArea = new JTextArea (5,20);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(650,600));
		
		try
		{
			FileReader reader = new FileReader("letter.txt");
			br = new BufferedReader(reader);
			String str;
			while((str = br.readLine()) != null)
			{
				textArea.append(str + "\n");
			}
			textArea.setCaretPosition(0);
		}
		catch (IOException e)
		{}
		finally
		{
			try
			{
				br.close();
			}
			catch(Exception ex)
			{}
		}
		
        setPreferredSize (new Dimension (650, 600));

        add (scrollPane, BorderLayout.CENTER);       
    }
}

//CLASS FOR VIEWING PHOTOS
class Photoes extends JFrame {
  
   static int x = 0;
  
   JButton bNext = new JButton();
   JButton bPrevious = new JButton();
   TitledBorder titledBorder1 = new TitledBorder("");
   JLabel lblPhoto = new JLabel();
   TitledBorder titledBorder2 = new TitledBorder("");
  
  
   public Photoes() 
   {
      try 
	  {
         jbInit();
      }
      catch (Exception e) 
	  {}
   }
  
  
   private void jbInit() throws Exception {
   
      getContentPane().setLayout(null);
      this.setResizable(true);
      this.setTitle("Photo Viewer");
      this.setBounds(50,10,810,840);
      this.setVisible(true);
      this.addWindowListener(new Photoes_this_windowAdapter(this));
   
      lblPhoto.setFont(new java.awt.Font("Arial", Font.BOLD, 30));
      lblPhoto.setHorizontalAlignment(JLabel.CENTER);
      lblPhoto.setBorder(titledBorder2);
      lblPhoto.setBounds(new Rectangle(2, 0, 800, 600));
   
      bNext.setBounds(new Rectangle(610, 736, 118, 30));
      bNext.setToolTipText("Show next image");
      bNext.setText("Next");
      bNext.addMouseListener(new Photoes_bNext_mouseAdapter(this));
      bNext.addActionListener(new Photoes_bNext_actionAdapter(this));
      bNext.setMnemonic('N');
   
      bPrevious.setBounds(new Rectangle(371, 736, 118, 30));
      bPrevious.setToolTipText("Show Previous Photo");
      bPrevious.setText("Previous");
      bPrevious.addActionListener(new Photoes_bPrevious_actionAdapter(this));
      bPrevious.setMnemonic('P');
   
      this.getContentPane().add(lblPhoto);
      this.getContentPane().add(bNext,BorderLayout.CENTER);
      this.getContentPane().add(bPrevious,BorderLayout.CENTER);
      this.viewPhotoes();
   }
    
   public void viewPhotoes()
   {
      String file = "output/" + Integer.toString(x) + ".png";
      File f = new File(file);
      if (!f.exists()) 
	  {
         x = -1;
      }

      ImageIcon i = new ImageIcon(file);
	  //ImageIcon newi = i.getImageIcon().getScaledInstance(600, 800, Image.SCALE_DEFAULT);
      lblPhoto.setIcon(i);
   }
  
  
   public void bPrevious_actionPerformed(ActionEvent e) 
   {
      if(x>0) 
	  {
         x--;
         this.viewPhotoes();
      }
   }
  
  
   public void bNext_actionPerformed(ActionEvent e) 
   {
      x++;
      this.viewPhotoes();
   }  

}
    
  
class Photoes_this_windowAdapter extends WindowAdapter 
{
   private Photoes adaptee;
    
   Photoes_this_windowAdapter(Photoes adaptee) 
   {
      this.adaptee = adaptee;
   }  
}

class Photoes_bNext_mouseAdapter extends MouseAdapter 
{
   private Photoes adaptee;
   Photoes_bNext_mouseAdapter(Photoes adaptee) 
   {
      this.adaptee = adaptee;
   }
}

class Photoes_bNext_actionAdapter implements ActionListener 
{
   private Photoes adaptee;  
   Photoes_bNext_actionAdapter(Photoes adaptee) 
   {
      this.adaptee = adaptee;
   }
   
   public void actionPerformed(ActionEvent e) 
   {
      adaptee.bNext_actionPerformed(e);
   }
}
  
class Photoes_bPrevious_actionAdapter implements ActionListener 
{
   private Photoes adaptee;
   Photoes_bPrevious_actionAdapter(Photoes adaptee) 
   {
      this.adaptee = adaptee;
   }
  
  
   public void actionPerformed(ActionEvent e) 
   {
      adaptee.bPrevious_actionPerformed(e);
   }
}
