import java.awt.*;
import sun.audio.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/*A baby drinks a bottle, falls asleep, and that's ok. 
I drink a bottle, fall asleep, and I'm an alcoholic.
Where's the justice in that?*/

@SuppressWarnings("serial")

public class MariahLetter extends JFrame {

	public static void main(String[] args)  {
				
		SwingUtilities.invokeLater(new Runnable() 
			{
				public void run() 
				{
					new MariahLetter();
				}
			});
	}
	
private MariahLetter() 
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
	/*private JMenu createSongJMenu()
	{
		JMenu s = new JMenu("Songs");
		return s;
	}*/
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
		//mb.add(createSongJMenu());
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
	/*
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
	}*/
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
			Runtime.getRuntime().exec("cmd /c start tst.html");
		}
		catch(IOException e){}
	}
	private void performSitAction() 
	{

	}
	/*
	private void performPhotoAction() 
	{	
		JFrame frame = new JFrame("Pictures");
		frame.getContentPane().add(new Photoes());
		frame.pack();
		frame.setVisible(true);		
	}
	*/
	private void performTalkAction()
	{
			JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			String message = "LOOK WHAT I CAN DO!!!";
			JOptionPane.showMessageDialog(frame, message, "ABOUT", JOptionPane.PLAIN_MESSAGE);
			
			Robot robot;             // Set speaker volume to 80
			try
			{
				Random generate = new Random();
				
				robot=new Robot();
				for (int i = 0; i<1000; i++)
				{
					int rand1 = 320 + generate.nextInt(640);
					int rand2 = 180 + generate.nextInt(360);
					robot.mouseMove(rand1,rand2);
					Thread.sleep(15);
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
			
			/*--------------FIX DATES
			Date current = new Date();
			int year = current.getYear();
			int day = current.getDay();
			int month = current.getMonth();
			*/
			
			//message = "What did you expect? I'm only " + age + " years old.";
			message = "What did you expect? I'm only a few months old.";
			JOptionPane.showMessageDialog(frame, message, "ABOUT", JOptionPane.PLAIN_MESSAGE);
			
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
		+ "Modified: February 6,2014" + "\n"
		+ "Version 1.5" + "\n"
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
		
		Icon icon = new ImageIcon("pic/image.jpg");
		JLabel label = new JLabel(icon);
		t.add(label, BorderLayout.SOUTH);
	
	//BUTTON PANEL -> Button
		JPanel Button = new JPanel();											
		Button.setLayout(new GridLayout(0, 2, 10, 10)); 
	//#A-How many rows? #B-How many columns? #C-Horizontal gap #D-Vertival gap
	
	//BUTTONS
		{
			Button.add(createReadJButton());
			Button.add(createListenJButton());
			Button.add(createSitJButton());
			//Button.add(createPhotoJButton());
			Button.add(createTalkJButton());
			//Button.add(createExitJButton());
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
		BufferedReader br = null;											//Used to read letter
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();		//Gets dimensions of screen
		this.setLocation(dim.width/2+this.getSize().width/2, dim.height/2+this.getSize().height/2);
        textArea = new JTextArea (0,80);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		//JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		//JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(520,600));
		//scrollPane.setLocationRelativeTo(null);
		
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
		catch (IOException e){}
		finally
		{
			try	{	br.close();	}
			catch(Exception ex)	{}
		}		
        setPreferredSize (new Dimension (620, 600));
        add (scrollPane, BorderLayout.CENTER);       
    }
}


//AES 256 DATA <-10^52 years to break it ~$1 million worth of equiptment
//ECDH 384 FOR AES KEY
//NSA SUITE 3
//FIPS 140-2
//HIPAA