/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

思路：杨辉三角的性质
*/

import java.util.*;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(numRows==0) return result;
		List<Integer> temp1=new ArrayList<Integer>();
		temp1.add(1);
		result.add(temp1);
		for(int i=2;i<=numRows;i++){
			List<Integer> temp2=new ArrayList<Integer>();
			temp2.add(1);
			for(int j=1;j<i-1;j++){
				temp2.add(temp1.get(j-1)+temp1.get(j));
			}
			temp2.add(1);
			result.add(temp2);
			temp1=temp2;
		}
		
		return result;
    }
	
	public static void main(String[] argc){
		List<List<Integer>> result=new Solution().generate(5);
		for(List<Integer> a:result){
			for(int b:a){
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
}
