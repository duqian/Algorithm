import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n, m;

        while(cin.hasNextInt())
        {
            n = cin.nextInt();
            m = cin.nextInt();
            int k=m%n;
            if(k==0){
                System.out.println(n-1);
            }else{
                System.out.println(k-1);
            }
        }
    }
}