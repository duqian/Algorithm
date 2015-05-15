/*
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 
 思路：与大数加法相似
 
*/

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result=new StringBuilder();
		int i=a.length()-1;
		int j=b.length()-1;
		int c=0;//进位
		while(i>=0 || j>=0){
			int temp=0;
			temp+=c;
			if(i>=0) temp+=a.charAt(i--)-'0';
			if(j>=0) temp+=b.charAt(j--)-'0';
			result.append(temp%2);
			c=temp/2;
		}
		if(c==1) result.append(1);
		
		return result.reverse().toString();
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().addBinary("11","0"));
		System.out.println(new Solution().addBinary("11","1"));
	}
}