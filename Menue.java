
package Spielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menue extends JPanel
{
	private static final long serialVersionUID = 1L;

	public Menue()
	{
		this.setLocation(470, 10);
		this.setSize(106, 230);
		this.setLayout(null);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JButton exit = new JButton();
		exit.setLocation(10, 10);
		exit.setSize(86, 20);
		exit.setText("Aufgeben!");
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
	}
}