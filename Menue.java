/** @author Diana Schumacher **/
package Spielen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Menue extends JPanel
{
	//Versionsnummer
	private static final long serialVersionUID = 1L;

	//Menü Grundeinstellungen
	public Menue()
	{
		this.setLocation(470, 10);
		this.setSize(106, 230);
		this.setLayout(null);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		
		//Methode exit, mit erneuter Abfrage
		JButton exit = new JButton();
		exit.setLocation(10, 10);
		exit.setSize(86, 20);
		exit.setText("Beenden");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				int i = JOptionPane.showConfirmDialog(null,
						"Möchtest du wirklich nicht mehr spielen?", null,
						JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		this.add(exit);
		
		
		 //Methode start, mit erneuter Abfrage
				JButton start = new JButton();
				start.setLocation(10, 60);
				start.setSize(86, 20);
				start.setText("Starten");
				start.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0)
					{
						int i = JOptionPane.showConfirmDialog(null,
								"Möchtest du ein neues Spiel laden?", null,
								JOptionPane.YES_NO_OPTION);
						if(i == JOptionPane.YES_OPTION)
							new PlayingBoard();
					}
				});
				this.add(start);
	
	/**				
	//Methode name, Spielername
			JButton name = new JButton();
			exit.setLocation(10, 10);
			exit.setSize(86, 20);
			exit.setText("Spieler");
			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				{
					  JTextField tfName = new JTextField("Gib deinen Namen ein!", 1);
				        Container panel;
						// Textfeld wird unserem Panel hinzugefügt
				        panel.add(tfName);
				 
				        JButton buttonOK = new JButton("OK");
				        panel.add(buttonOK);
				 
				        gamePanel.add(panel);
				        gamePanel.setVisible(true);
				 
				    };
			
		});  **/
}
}