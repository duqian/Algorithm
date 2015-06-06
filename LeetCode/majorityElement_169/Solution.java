/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.

You may assume that the array is non-empty and the majority element always exist in the array.

思路：不断去除两个不相同的数，最后留下的就是最终结果
       使用result暂存目前留下的数字，count是其出现比其他不同数字多的次数
	   每次一个新的数字，如果与result相同，则count加1，否则count减1
	   当count为0时，新出现的数字直接取代result
*/

public class Solution {
    public int majorityElement(int[] nums) {
		if(nums.length==1) return nums[0];
        int result=nums[0];
		int count=1;
		for(int i=1;i<nums.length;i++){
			if(nums[i]==result){
				count++;
			}else{
				if(count==0){
					result=nums[i];
					count++;
				}else{
					count--;
				}
			}
		}
		
		return result;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().majorityElement(new int[]{1,2,3,1,1,1}));
	}
}