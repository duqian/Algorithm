/*
Given an integer n, return the number of trailing zeroes in n!.
思路：求n的阶乘值后面有多少0  
      0的个数跟这n个数中因子5的个数相同
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