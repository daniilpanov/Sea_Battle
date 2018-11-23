package play;

import res.Ship;

import javax.swing.*;

public class Player
{
    private JFrame frame;
	private Ship[] ships;
	
	public Player(JFrame f, JPanel enemyArea)
    {
        frame = f;
        frame.add(enemyArea);
    }
}
