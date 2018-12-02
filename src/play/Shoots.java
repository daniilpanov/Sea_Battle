package play;

import java.util.ArrayList;

public class Shoots
{
    public static final String PLAYER = "PLAYER", BOT = "BOT";
    public static ArrayList<Shoots> botShoots = new ArrayList<>(),
            playerShoots = new ArrayList<>();

    public int x, y;
    public boolean hit;

    public Shoots(String whose, int x, int y, boolean hit)
    {
        this.x = x;
        this.y = y;

        switch (whose)
        {
            case PLAYER:
                botShoots.add(this);
                break;
            case BOT:
                playerShoots.add(this);
                break;
        }
        
        this.hit = hit;
    }
}
