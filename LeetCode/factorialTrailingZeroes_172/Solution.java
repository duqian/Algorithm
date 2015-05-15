/*
Given an integer n, return the number of trailing zeroes in n!.
˼·����n�Ľ׳�ֵ�����ж���0  
      0�ĸ�������n����������5�ĸ�����ͬ
*/

public class Solution {
    public int trailingZeroes(int n) {
       int k=5;
       int sum=0;
       while(n>0){
		   sum+=n/k;
		   n/=5;
	   }
       return sum;	   
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().trailingZeroes(100));
	}
}