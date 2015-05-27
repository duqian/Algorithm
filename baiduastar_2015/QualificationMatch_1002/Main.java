/*
 根据行列关系推导，注意最后一行填写不满的情况
 提交总是超时，改用c完成
*/
import java.util.Scanner;

public class Main {
	public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int t;

        while(cin.hasNextInt())
        {
            t = Integer.parseInt(cin.nextLine());
            for(int i=1;i<=t;i++){
            	String str=cin.nextLine();
            	int c=Integer.parseInt(cin.nextLine());
            	int n=str.length()/c;
            	int m=str.length()%c;
            	System.out.println("Case #"+i+":");
            	for(int k=0;k<n;k++){
            		int sum=k;
            		int index=0;
            		for(int f=0;f<c;f++){
            			sum+=index;
            			System.out.print(str.charAt(sum));
            			index=f<m?n+1:n;
            		}
            	}
            	if(m!=0){
            		for(int f=0;f<m;f++){
            			System.out.print(str.charAt(n+(n+1)*f));
            		}
            	}
            	System.out.println();
            }
        }
    }
}
