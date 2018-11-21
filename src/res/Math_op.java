package res;

public class Math_op
{
    public static int getRandomN(int min, int max)
    {
        return min + (int) (Math.random() * (max+1));
    }
}
