/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.

You may assume that the array is non-empty and the majority element always exist in the array.

˼·������ȥ����������ͬ������������µľ������ս��
       ʹ��result�ݴ�Ŀǰ���µ����֣�count������ֱ�������ͬ���ֶ�Ĵ���
	   ÿ��һ���µ����֣������result��ͬ����count��1������count��1
	   ��countΪ0ʱ���³��ֵ�����ֱ��ȡ��result
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