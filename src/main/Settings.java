package main;

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
    
    private File settings = new File("src", "Settings");
    private FileReader settings_reader;
    private Scanner scan;
    private FileWriter settings_editor;
    
    private JLabel l_nick = new JLabel("��� nickname: ");
    
    private JTextArea t_nick = new JTextArea(getSettingsItem("NickName"));
    
    private Object[][] data =
            {
                    {l_nick, t_nick},
            };
    private JTable table;
    
    private Settings()
    {
        setAll();
        
    }
    
    private void setAll()
    {
        // ������� ������� ������ ��� ������ ����� � �����������
        try
        {
            settings_reader = new FileReader(settings);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        // ������� ��� ��������� ����� � �����������
        scan = new Scanner(settings_reader);
    
        // ������� ������� ������ ��� �������������� ����� � �����������
        try
        {
            settings_editor = new FileWriter(settings);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        // ������ �������
        
    }
    
    private void save()
    {
    
    }
    
    private String getSettingsItem(String item)
    {
        // ��� �� ���� � ������ (��������, NickName)
        String pattern = "(" + item + ")(: )(.*)";
        
        Pattern c_pattern = Pattern.compile(pattern);
        
        Matcher match;
        
        while (scan.hasNextLine())
        {
            match = c_pattern.matcher(scan.nextLine());
            
            if (match.find())
            {
                
                break;
            }
        }
        
        return null;
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
