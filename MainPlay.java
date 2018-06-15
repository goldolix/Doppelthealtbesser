/** @author  **/

package Spielen;


import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.UIManager;


public class MainPlay extends Object
{
	//Designaspekte
	private static final int LOOK_AND_FEEL_ID = 1;
	private static final String[] LOOK_AND_FEEL_CLASSES = {
		"javax.swing.plaf.metal.MetalLookAndFeel",
		"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel",
		"com.sun.java.swing.plaf.motif.MotifLookAndFeel",
		"com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
		"com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel"
	};

	public MainPlay()
	{
		//Oberklassen, Konstruktor Aufruf
		super();
		
		//Spielfeld-Design aufrufen
		try
		{
			UIManager.setLookAndFeel(
					MainPlay.LOOK_AND_FEEL_CLASSES[MainPlay.LOOK_AND_FEEL_ID]);
		}catch(Exception e){}
		
		JFrame jframe = new JFrame();
		jframe.setTitle("Uni-Memory");
		jframe.setSize(600, 275);
		jframe.setResizable(false);
		jframe.setLayout(null); 
		
		//Spielfeld erzeugen
		PlayingBoard gamePanel = new PlayingBoard();
		jframe.add(gamePanel);
		
		//Menü erzeugen
		Menue menuPanel = new Menue();
		jframe.add(menuPanel);
		
		jframe.setVisible(true);
	}
	public static void main(String[] args)
	{
		new MainPlay();
	}
}