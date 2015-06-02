/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

思路：使用两个指针i,j  i指向当前位置，j指向下一个不重复的位置
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null) return 0;
		if(nums.length<=1) return nums.length;
		
		int i=0;
		int j=1;
		while(j<nums.length){
			while(j<nums.length && nums[j]==nums[i]){
				j++;
			}
			if(j<nums.length &&  nums[j]!=nums[i]){
				if(i+1!=j)nums[++i]=nums[j++];
				else{i++;j++;}
			}
			
		}
		return i+1;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().removeDuplicates(new int[]{1,1}));
	}
}