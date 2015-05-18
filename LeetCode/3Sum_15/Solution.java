/*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
	
	思路：先排序，可以使得结果为排好序的，参考第1题（即查找数组中是否有两个数的和等于target）
	      遍历数组中的数，然后在剩余的数据中查找是否有两个数满足
*/

import java.util.*;
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer>> result=new LinkedList<List<Integer>>();
		for(int i=0;i<nums.length-2;i++){
			if(i>0 && nums[i]==nums[i-1]) continue;
			Set<List<Integer>> tworesult=twoSum(i+1,nums,0-nums[i]);
			if(tworesult!=null){
				for(List<Integer> a:tworesult){
					LinkedList<Integer> temp=new LinkedList<Integer>();
				    temp.add(nums[i]);
					temp.addAll(a);
					result.add(temp);
				}
			}
		}
		
		return result;
    }
	
	public Set<List<Integer>> twoSum(int index,int[] nums,int target){
		Set<List<Integer>> tworesult=new HashSet<List<Integer>>();
		Set<Integer> set=new HashSet<Integer>();
		for(int i=index;i<nums.length;i++){
			if(set.contains(target-nums[i])){
				List<Integer> temp=new LinkedList<Integer>();
				temp.add(target-nums[i]);
				temp.add(nums[i]);
				tworesult.add(temp);
			}
			set.add(nums[i]);
		}
		if(tworesult.size()==0) return null;
		else return tworesult;
	}
	
	public static void main(String[] argc){
		List<List<Integer>> result=new Solution().threeSum(new int[]{1,-1,-1,2,1,0,0,0,0,0});
		for(List<Integer> a:result){
			for(Integer b:a){
				System.out.print(b+" ");
			}
		    System.out.println();
		}
		
		
	}
	
	
	
}