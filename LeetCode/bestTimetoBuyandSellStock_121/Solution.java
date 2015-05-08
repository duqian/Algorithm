/*
  Say you have an array for which the ith element is the price of a given stock on day i.

  If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
  
  ˼·������ÿһ�����֣���������֮ǰ��Сֵ�Ĳ�ֵ�����Ĳ�ֵ��Ϊ���յ��������
*/

public class Solution {
    public int maxProfit(int[] prices) {
		if(prices==null || prices.length<=1) return 0;
		 
		int max=0,min=prices[0];
		for(int i=1;i<prices.length;i++){
			min=min>prices[i]?prices[i]:min;
			int profit=prices[i]-min;
			max=max>profit?max:profit;
		}
		return max;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().maxProfit(new int[]{2,1,4,2,5}));
	}
}