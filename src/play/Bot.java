package play;

import res.Ship;

import javax.swing.*;
import static res.Math_op.getRandomN;

public class Bot
    implements Player
{
    private Timer timer;
    private EnemyArea enemyArea;
    
    public Bot()
    {
        for (int i = 4, type = 1, s = 0; s<10; type++, i--)
        {
            for (int j = 0; j < i; j++, s++)
            {
                new Ship(type);
            }
        }
    
        enemyArea = new EnemyArea();
    }
    
    /*private void shoot()
    {
        timer = new Timer(getRandomN(1000, 5000), e -> {
            
            int shoot_x = getRandomN(0, 10),
                    shoot_y = getRandomN(0, 10);
            
            if (checkShoot(shoot_x, shoot_y))
            {
                enemyArea.updateArea(new Shoots(Shoots.BOT, shoot_x, shoot_y));
            }
            
            timer.stop();
        });
        
        timer.start();
    }*/
    private boolean checkShoot(int x, int y)
    {
        boolean can = true;
    
        for (Shoots shoot : Shoots.botShoots)
        {
            if (shoot.x == x && shoot.y == y)
            {
                can = false;
            }
        }
        
        return can;
    }
    
    public JPanel getArea()
    {
        return enemyArea;
    }
}
