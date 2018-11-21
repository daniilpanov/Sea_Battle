package main;

import javax.swing.*;
import static javax.swing.JOptionPane.*;

public class Exit
{
    public static void showExitDialog(JFrame frame)
    {
        int res = showConfirmDialog(
                    frame,
                    "Are you sure you want to exit this game?",
                    "Confirm exit",
                    YES_NO_OPTION
                );
        if (res == YES_OPTION)
        {
            System.exit(0);
        }
    }
}
