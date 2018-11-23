package play;

import javax.swing.*;

import main.Main;
import res.Ship;

public class Play
{
	// SINGLETON
    private static Play ourInstance = new Play();
    
    public static Play getInstance()
    {
        return ourInstance;
    }
    
    private JFrame menu = Main.frame,
            frame = new JFrame();
    
    // Конструктор будет вызываться ОДИН РАЗ
    private Play()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Bot bot = new Bot();
        
        new Player(frame, bot.getArea());
        
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public void showGame()
    {
        menu.setVisible(false);
        frame.setVisible(true);
    }
    
    private void hideGame()
    {
        frame.setVisible(false);
        menu.setVisible(true);
    }
}
