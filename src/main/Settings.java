package main;

import javax.swing.*;

public class Settings
{
    private static Settings ourInstance = new Settings();
    
    public static Settings getInstance()
    {
        return ourInstance;
    }
    
    private JFrame menu = Main.frame,
            frame = new JFrame();
    
    private Settings()
    {
    
    }
    
    public void showSettings()
    {
        menu.setVisible(false);
        frame.setVisible(true);
    }
    
    private void hideSettings()
    {
        frame.setVisible(false);
        menu.setVisible(true);
    }
}
