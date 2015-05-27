/*
  使用set去重复
  匹配.的时候需要使用转义符
*/
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        int t;

        while(cin.hasNextInt()){
            t=cin.nextInt();
            for(int i=1;i<=t;i++){
            	int n=cin.nextInt();
            	int m=cin.nextInt();
            	String[] ips=new String[n];
            	
            	for(int j=0;j<n;j++){
            		ips[j]=cin.next();
            	}
            	System.out.println("Case #"+i+":");
            	for(int k=0;k<m;k++){
            		String mask=cin.next();
            		Set<String> set=new HashSet<String>();
            		for(String ip:ips){
            			set.add(internet(ip,mask));
            		}
            		System.out.println(set.size());
            	}

            }
            
        }
    }
    
    public static String internet(String ip,String mask){
    	String[] iptemp=ip.split("\\.");
    	String[] masktemp=mask.split("\\.");
    	StringBuilder result=new StringBuilder();
    	for(int i=0;i<4;i++){
    		int temp=Integer.parseInt(iptemp[i])&Integer.parseInt(masktemp[i]);
    	    if(i!=0) result.append('.');
    		result.append(temp);
    	}
    	
    	return result.toString();
    }
}