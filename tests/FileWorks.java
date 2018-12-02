import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class FileWorks
{
    private ArrayList<String> data = new ArrayList<>();
    
    private FileWorks()
    {
        try
        {
            File test = new File("tests", "test.txt");
            FileReader reader = new FileReader(test);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine())
            {
                data.add(scanner.nextLine());
            }
            FileWriter writer = new FileWriter(test);
    
            for (String text : data)
            {
                writer.write(text + "\n");
            }
            
            writer.write("HELLO!!!\n");
            
            writer.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        new FileWorks();
    }
}
