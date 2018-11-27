package play;

import javax.swing.*;

public class You
    implements Player
{
    private JFrame frame;
	private YourArea yourArea;
	
	public You(JFrame f, JPanel enemyArea)
    {
        frame = f;
        frame.add(enemyArea);
        
        yourArea = new YourArea();
    }
    
    @Override
    public JPanel getArea()
    {
        return yourArea;
    }
}
