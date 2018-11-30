package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Settings
{
    private static Settings ourInstance = new Settings();
    public static Settings getInstance()
    {
        return ourInstance;
    }
    
    private JFrame menu = Main.frame,
            frame = new JFrame("Settings");
    private JPanel panel = new JPanel();
    
    private File settings;
    private FileReader settings_reader;
    private Scanner scan;
    private FileWriter settings_editor;
    
    private JLabel l_nick = new JLabel("Ваш nickname: ");
    private JTextArea t_nick = new JTextArea();
    
    private int rows;
    
    private ArrayList<String> settings_list = new ArrayList<>();
    
    private Settings()
    {
        update();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
        JPanel for_save = new JPanel(new GridLayout(1, 1));
        JButton save = new JButton("Save");
        
        save.setFont(new Font("Arial", Font.BOLD, 20));
        
        panel.add(l_nick); panel.add(t_nick);
        for_save.add(save);
        
        save.addActionListener(e -> save());
    
        frame.add(panel, BorderLayout.NORTH);
        frame.add(for_save, BorderLayout.SOUTH);
    }
    
    private void update()
    {
        // Перезаписываем всё, что необходимо
        try
        {
            // Файл с настройками
            settings = new File("src", "Settings.txt");
            // Кол-во строчек в этом файле
            rows = 0;
            // Строки из этого файла
            settings_list.clear();
            // "Читатель"
            settings_reader = new FileReader(settings);
            // Сканнер для просмотра файла с настройками
            scan = new Scanner(settings_reader);
            // Сохраняем настройки в свойстве
            getAllSettings();
            // И создаём объект для редактирования настроек
            settings_editor = new FileWriter(settings);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        // Обновляем текст в JTextArea
        t_nick.setText(getSettingsItem("NickName"));
        // и layout панели
        panel.setLayout(new GridLayout(rows, 2));
    }
    
    private void  getAllSettings()
    {
        while (scan.hasNextLine())
        {
            settings_list.add(scan.nextLine());
        }
    }
    
    private String getSettingsItem(String item)
    {
        rows++;
        
        // Объявляем переменную для результата
        String result = null;
        // Что мы ищем в строке (например, NickName)
        String pattern = "(" + item + ")(: )(.*)";
        
        Pattern c_pattern = Pattern.compile(pattern);
        
        Matcher match;
    
        for (String one_setting : settings_list)
        {
            match = c_pattern.matcher(one_setting);
        
            if (match.find())
            {
                result = match.group(3);
                break;
            }
        }
        
        return result;
    }
    
    private void save()
    {
        String[] all_settings = new String[rows];
        
        all_settings[0] = "NickName: " + t_nick.getText();
        
        try
        {
            for (String one_setting : all_settings)
            {
                settings_editor.write(one_setting + "\n");
            }
            
            settings_editor.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        update();
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
