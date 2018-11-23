package res;

import java.awt.*;
import static res.Math_op.getRandomN;

public class Ship
{
    public static final int// ONE = 1, TWO = 2, THREE = 3, FOUR = 4,
                VERTICAL = 1, HORIZONTAL = 0;
    
    public int x, y, type, direction;
    public int[] hits = null;
    public boolean player;
    
    public Ship(int direction, int type, int x, int y)
    {
        this.player = true;
        this.x = x;
        this.y = y;
        this.type = type;
        this.direction = direction;
    }
    public Ship(int type)
    {
        this.player = false;
        System.out.println(direction = getRandomN(0, 1));
        System.out.println(this.type = type);
        
        switch (direction)
        {
	        case VERTICAL:
	        	x = getRandomN(1, 8);
	        	y = getRandomN(1, 8 - type);
	        	break;
	        case HORIZONTAL:
	        	x = getRandomN(1, 8 - type);
	        	y = getRandomN(1, 8);
	        	break;
        }
        System.out.println(x + " " + y);
        System.out.println();
    }
    
    public void drawShip(Graphics g)
    {
        //
        int prepared_x = x*64;
        int prepared_y = y*64;
        int prepared_type = (type-1)*64;
        //
    	g.setColor(Color.BLACK);
    	//
        switch (direction)
        {
            case VERTICAL:
                g.fillRect(prepared_x+1, prepared_y+1, prepared_type+63, 63);
                break;
            case HORIZONTAL:
                g.fillRect(prepared_x+1, prepared_y+1, 63, prepared_type+63);
                break;
        }
    }
    
    public boolean hit(int x_coordinate, int y_coordinate)
    {
        boolean hit = false;
        
        if (this.direction == HORIZONTAL)
        {
            if (y == y_coordinate)
            {
                System.out.println("OK, check x");
                for (int x = this.x; x <= this.type; x++)
                {
                    System.out.println(x);
                    
                    if (x == x_coordinate)
                    {
                        hit = true;
                        break;
                    }
                }
            }
        }
        else
        {
            if (x == x_coordinate)
            {
                System.out.println("OK, check y");
                for (int y = this.y; y <= this.type; y++)
                {
                    System.out.println(y);
                    
                    if (y == y_coordinate)
                    {
                        hit = true;
                        break;
                    }
                }
            }
        }
        
        return hit;
    }
}
