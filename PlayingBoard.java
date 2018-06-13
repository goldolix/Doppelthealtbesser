package Spielen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PlayingBoard extends JPanel
{
	private static final long serialVersionUID = 1L;

	public PlayingBoard()
	{
		super();
		
		this.setLocation(10, 10);
		this.setSize(450, 230);
		this.setLayout(null);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
	
		List<MemoryCards> shuffleList = new ArrayList<MemoryCards>();
		shuffleList.add(new MemoryCards(0, shuffleList, this));
		shuffleList.add(new MemoryCards(0, shuffleList, this));
		shuffleList.add(new MemoryCards(1, shuffleList, this));
		shuffleList.add(new MemoryCards(1, shuffleList, this));
		shuffleList.add(new MemoryCards(2, shuffleList, this));
		shuffleList.add(new MemoryCards(2, shuffleList, this));
		shuffleList.add(new MemoryCards(3, shuffleList, this));
		shuffleList.add(new MemoryCards(3, shuffleList, this));
		
		Collections.shuffle(shuffleList);
		
		for(int x = 10, y = 10, i = 0; i < shuffleList.size(); i++)
		{
			MemoryCards karten = shuffleList.get(i);
			karten.setLocation(x, y);
			
			x+= 110;
			if(i == 3)
			{
				y+= 110;
				x = 10;
			}
		}
		
		

		
	}
}