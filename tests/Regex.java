import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex {
    
    public static void main( String args[] ) {
        // Строка для сканирования, чтобы найти шаблон
        String str = "NickName: Den";
        String pattern = "(NickName)(: )(.*)";
        
        // Создание Pattern объекта
        Pattern r = Pattern.compile(pattern);
        
        // Создание matcher объекта
        Matcher m = r.matcher(str);
        if (m.find( )) {
            System.out.println("Найдено значение: " + m.group(1));
            System.out.println("Ваше имя - " + m.group(3));
        } else {
            System.out.println("НЕ СОВПАДАЕТ");
        }
    }
}