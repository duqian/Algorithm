/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

循环反转数组
思路：先整体反转，再分前后两部分反转

*/

public class Solution {
    public void rotate(int[] nums, int k) {
		if(nums==null || nums.length==0|| k==0 || k%nums.length==0) return;
	    
		k=k%nums.length;
		reverse(nums,0,nums.length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);
	
    }
	
	public void reverse(int[] nums,int start,int end){
		while(start<end){
			int temp=nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] argc){
		int[] nums={1,2,3,4,5,6};
		new Solution().rotate(nums,2);
		for(int a:nums){
			System.out.print(a+" ");
		}
	}
}