package play;

import javax.swing.*;
import static res.Math_op.getRandomN;

public class Bot
{
    private Timer timer;
    
    public Bot()
    {
    
    }
    
    public void shoot()
    {
        timer = new Timer(getRandomN(1000, 5000), e -> {
            
            int shoot_x = getRandomN(0, 10),
                    shoot_y = getRandomN(0, 10);
            
            timer.stop();
        });
        
        timer.start();
    }
}
