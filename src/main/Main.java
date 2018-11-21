package main;

import javax.swing.*;
import javax.swing.UIManager.*;

public class Main extends JFrame
{
    public static JFrame frame;
    
    private Main()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Menu(this);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        frame = this;
    }
    
    public static void main(String[] args)
    {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new Main();
    }
}
