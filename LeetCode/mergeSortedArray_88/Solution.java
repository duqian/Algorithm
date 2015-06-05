/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

思路：倒序比较两个数组，大的放入到nums1的数组中，直到nums2的数组中数据放完为止
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1=n-1;
		int m1=m-1;
		int i=m+n-1;
		while(n1>=0 && m1>=0){
			if(nums2[n1]>=nums1[m1]){
				nums1[i--]=nums2[n1--];
			}else{
				nums1[i--]=nums1[m1--];
			}
		}
		while(n1>=0){
			nums1[i--]=nums2[n1--];
		}
    }
	
	public static void main(String[] argc){
		int[] nums1={2,3,4,6,0,0};
		int[] nums2={1,5};
		new Solution().merge(nums1,4,nums2,2);
		for(int a:nums1){
			System.out.print(a+" ");
		}
	}
}

