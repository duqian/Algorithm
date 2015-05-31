/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

*/

import java.util.*;
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		for(int a:nums){
			if(map.containsKey(a)){
				return true;
			}else{
				map.put(a,false);
			}
		}

		return false;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().containsDuplicate(new int[]{}));
	}
}