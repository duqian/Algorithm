import java.util.*;
public class Main {
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n, m;

        while(cin.hasNextInt())
        {
            n = cin.nextInt();
            m = cin.nextInt();
            boolean[][] relation=new boolean[n+1][n+1];  //[a][b]
            int[] task=new int[n+1];
            
            for(int k=0;k<m;k++){
                int i=cin.nextInt();
                int j=cin.nextInt();;
                relation[i][j]=true;
                task[i]++; //记录前提条件数
            }
           
            //judge
            boolean temp=true;
            while(temp){
                temp=false;
                for(int k=1;k<=n;k++){
                   if(task[k]==0){
                       for(int i=1;i<=n;i++){
                           if(relation[i][k]==true && task[i]!=0){
                               temp=true;
                               task[i]--;
                           }
                       } 
                   }
                }
                
            }
            
            boolean flag=true;
            for(int i=1;flag && i<=n;i++){
                if(task[i]!=0){
                    flag=false;
                    break;
                }
            }
            
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            
        }
    }

}