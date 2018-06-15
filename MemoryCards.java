/** @Babithan Satkunanandam  **/

package Spielen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MemoryCards extends JLabel implements MouseListener
{
	//Versionsnummer
	private static final long serialVersionUID = 1L;

	//Variablen
	private int typ;
	private ImageIcon[] image; 
	private List<MemoryCards> cardSummary;
	private MemoryCards choosenCards;
	private JPanel jpanel;
	
	public MemoryCards(int typ, List<MemoryCards> cardSummary, JPanel jpanel)
	{
		//Oberklassen, Konstruktor Aufruf
		super();
		
		this.setSize(100, 100);
		this.addMouseListener(this);
		
		
		//Bilder für Karten laden
		/////////Funktioniert noch nicht richtig///////
		/** @author Diana Schumacher **/
		try
		{
			this.image = new ImageIcon[2];
			this.image[0] = new ImageIcon(ImageIO.read(new File("img\\memeorycard"+typ+".jpeg")));
			this.image[1] = new ImageIcon(ImageIO.read(new File("img\\memorycardback.jpeg")));
			this.setIcon(this.image[1]);
		}
		catch(Exception e)
		{
			//Ort des Fehlers ausgeben lassen
			e.printStackTrace();
		}
		
		this.typ = typ;
		this.cardSummary = cardSummary;
		this.jpanel = jpanel; 
		
		jpanel.add(this);
	}
	
	//Methode zum Karten merken
	//welche Karte wird gewählt
	public void setChoosenCard(MemoryCards karten)
	{
		this.choosenCards = karten;
	}
	
	public void mouseClicked(MouseEvent arg0)
	{
		if(this.choosenCards == null)
		{
			this.setIcon(this.image[0]);
			
			for(MemoryCards karten:this.cardSummary)
				karten.setChoosenCard(this);
		}
		
		//Karten vergleichen
		else if(this.choosenCards.equals(this))
			return;
		else
		{
			new Thread(new Runnable(){
				public void run()
				{
					setIcon(image[0]);
					jpanel.repaint();
				}				
			}).start();
			try
			{
				Thread.sleep(200L);
			}
			catch(Exception e)
			{
				//Ort des Fehlers ausgeben
				e.printStackTrace();
			}
			
			//wenn Karten gleich, dann vom Spielfeld entfernen
			if(this.typ == this.choosenCards.getTyp())
			{
				this.jpanel.remove(this);
				this.jpanel.remove(this.choosenCards);
				
				for(MemoryCards card:this.cardSummary)
					card.setChoosenCard(null);
				this.jpanel.repaint();
			}
			else
			{
				this.setIcon(this.image[1]);
				this.choosenCards.setIcon(this.image[1]);
				
				for(MemoryCards card:this.cardSummary)
					card.setChoosenCard(null);
			}
		}
	}
	public int getTyp()
	{
		return(this.typ);
	}
	
	//Mausbewegungen/klicken feststellen
	public void mouseEntered(MouseEvent arg0){}
	public void mouseExited(MouseEvent arg0){}
	public void mousePressed(MouseEvent arg0){}
	public void mouseReleased(MouseEvent arg0){}
}