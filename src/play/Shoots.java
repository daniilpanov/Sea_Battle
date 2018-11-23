package play;

public class Shoots
{
    public static final String PLAYER = "PLAYER", BOT = "BOT";
    public static Shoots[] botShoots = null,
            playerShoots = null;

    public int x, y;
    public boolean hit = false;

    public Shoots(String whose, int x, int y)
    {
        this.x = x;
        this.y = y;

        switch (whose)
        {
            case PLAYER:
                botShoots = rewriting(botShoots);
                break;
            case BOT:
                playerShoots = rewriting(playerShoots);
                break;
        }
    }
    
    private Shoots[] rewriting(Shoots[] shoots)
    {
        // Осуществляем перезапись массива
        Shoots[] last_DATA = shoots;
        shoots = new Shoots[shoots.length];
        if (last_DATA.length - 1 >= 0)
        {
            System.arraycopy(last_DATA, 0, shoots, 0, last_DATA.length);
        }
        shoots[shoots.length-1] = this;
        
        return shoots;
    }
}
