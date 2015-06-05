/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

*/

import java.util.*;
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<Integer>(rowIndex);
		for(int i=0;i<=rowIndex;i++){
			for(int j=i;j>=0;j--){
				if(j==i) result.add(1);
				else if(j!=0){
					result.set(j,result.get(j)+result.get(j-1));
				}
			}
		}
		return result;
    }
	
	public static void main(String[] argc){
		List<Integer> result=new Solution().getRow(3);
		for(int a:result){
			System.out.print(a+" ");
		}
	}
}