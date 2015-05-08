/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

思路：每个值nums[i]尝试与其nums[i-2]和nums[i-3]中最大的相加，然后获得nums中的最大值即为结果
        4 3 2 1 5  3
result: 4 3 6 5 11 9
*/

public class Solution {
    public int rob(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return nums[0];
		
        int max=nums[0]>nums[1]?nums[0]:nums[1];
		if(nums.length==2) return max;
		
		nums[2]+=nums[0];
		if(max<nums[2]){
			max=nums[2];
		}
		
		for(int i=3;i<nums.length;i++){
			int temp=nums[i-2]>nums[i-3]?nums[i-2]:nums[i-3];
			nums[i]+=temp;
			if(max<nums[i]){
				max=nums[i];
			}
		}
		
		return max;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().rob(new int[]{4,3,2,1,5,3}));
	}
}