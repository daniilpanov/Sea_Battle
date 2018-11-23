package play;

import res.Ship;

import javax.swing.*;

public class You
    implements Player
{
    private JFrame frame;
	private Ship[] ships;
	private YourArea yourArea;
	
	public You(JFrame f, JPanel enemyArea)
    {
        frame = f;
        frame.add(enemyArea);
    }
    
    @Override
    public JPanel getArea() {
        return yourArea;
    }
}
