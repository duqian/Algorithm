/*
   递归的方式求解，容易超时，应想办法减少分支
*/

import java.util.*;
public class AnotherSolution {
    public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		if(nums.length<3) return null;
		Set<List<Integer>> set=Sum(0,nums,0,3);
		if(set!=null)return new LinkedList<List<Integer>>(set);
		else return null;
	}
	
	public Set<List<Integer>> Sum(int index,int[] nums,int target,int remain){//开始的下标值，数组，目标结果，还剩下的数字个数（几个数相加为目标结果）
	    if(index>nums.length-remain) return null;
		
		if(remain==1){
			for(int i=index;i<nums.length;i++){
				if(nums[i]==target){
					Set<List<Integer>> set=new HashSet<List<Integer>>();
					List<Integer> list=new LinkedList<Integer>();
					list.add(nums[i]);
					set.add(list);
					return set;
				}
			}
			return null;
		}

		Set<List<Integer>> result=new HashSet<List<Integer>>();
        Set<List<Integer>> temp1=Sum(index+1,nums,target-nums[index],remain-1);
        if(temp1!=null){
			for(List<Integer> a:temp1){
				LinkedList<Integer> list=new LinkedList<Integer>();
		        list.add(nums[index]);
				list.addAll(a);
				result.add(list);
			}
		}
		
		
		Set<List<Integer>> temp2=Sum(index+1,nums,target,remain);
		if(temp2!=null) result.addAll(temp2);
		
		if(result.size()!=0) return result;
		return null;
	}
	
	
	
	public static void main(String[] argc){
		List<List<Integer>> result=new AnotherSolution().threeSum(new int[]{0,0,0});
		
		for(List<Integer> a:result){
			System.out.print("list:");
			for(Integer b:a){
				System.out.print(b+" ");
			}
		    System.out.println();
		}
		
		
	}
	
	
}