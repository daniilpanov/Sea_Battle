import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex {
    
    public static void main( String args[] ) {
        // ������ ��� ������������, ����� ����� ������
        String str = "NickName: Den";
        String pattern = "(NickName)(: )(.*)";
        
        // �������� Pattern �������
        Pattern r = Pattern.compile(pattern);
        
        // �������� matcher �������
        Matcher m = r.matcher(str);
        if (m.find( )) {
            System.out.println("������� ��������: " + m.group(1));
            System.out.println("���� ��� - " + m.group(3));
        } else {
            System.out.println("�� ���������");
        }
    }
}