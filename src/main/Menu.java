package main;

import play.Play;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import static java.awt.Color.*;

import java.awt.BorderLayout;

public class Menu extends JPanel
{
    private JFrame frame;
    private JButton play = new JButton("Play"),
            settings = new JButton("Settings"),
            exit = new JButton("Exit");
    
    public Menu(JFrame fr)
    {
    	fr.setUndecorated(true);
        frame = fr;
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        // Создаём меню
        Font menu_font = new Font("Brush Script MT Italic", Font.ITALIC, 25);
    
        play.setFont(menu_font);
        play.setBackground(GRAY);
        settings.setFont(menu_font);
        settings.setBackground(GRAY);
        exit.setFont(menu_font);
        exit.setBackground(GRAY);
        // Добавляем слушатели
        addActionListeners();
    
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addComponent(play).addComponent(settings).addComponent(exit)));
    
        layout.linkSize(SwingConstants.CENTER, play, settings, exit);
    
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(play).addComponent(settings).addComponent(exit));
        
        frame.getContentPane().add(this, BorderLayout.CENTER);
    }
    
    // Метод для добавления слушателей на кнопки меню
    private void addActionListeners()
    {
        play.addActionListener(e -> play());
        settings.addActionListener(e -> settings());
        exit.addActionListener(e -> exit());
    }
    private void play()
    {
        Play.getInstance().showGame();
    }
    private void settings()
    {
        Settings.getInstance().showSettings();
    }
    private void exit()
    {
        Exit.showExitDialog(frame);
    }
}
