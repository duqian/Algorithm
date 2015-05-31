/*
Given an array of integers and an integer k, return true if and only if there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

思路：借助map结构  <nums[i] ,i>
*/

import java.util.*;
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || k==0 ||nums.length<2) return false;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				int index=map.get(nums[i]);
				if(i-index<=k) return true;
				else map.put(nums[i],i);
			}else{
				map.put(nums[i],i);
			}
		}
		return false;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().containsNearbyDuplicate(new int[]{2,2},3));
	}
}