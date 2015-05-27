/*
The n-queens puzzle is the problem of placing n queens on an n��n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

˼·��ʹ�û��ݵ�˼·��ÿ����̽

*/

import java.util.*;

public class Solution {
	
    public List<String[]> solveNQueens(int n) {  //��n�е����
	    List<String[]> result=new ArrayList<String[]>();
	    int[] solve=new int[n+1];  //��ʼΪ0
		int i=1;
        while(i>=1){
			solve[i]++;
			while(solve[i]<n+1 && !isAgree(i,solve)){
				solve[i]++;
			}
			
			if(i==n && solve[i]<n+1){  //�ҵ�һ�����
				String[] str=new String[n];
				
			    for(int m=0;m<n;m++){
				    StringBuilder b=new StringBuilder();
					for(int j=0;j<n;j++)
						b.append('.');
					b.setCharAt(solve[m+1]-1, 'Q');
					str[m]=b.toString();
				}				
				result.add(str);
			}
			
			if(solve[i]<=n && i+1<=n){//û�е����һ��,
				i++;
			}else{
				solve[i]=0;
				i--;   //����
			}
		}
		
		return result;
    }

    public boolean isAgree(int k,int[] solve){
		for(int i=1;i<k;i++){
			if(solve[i]==solve[k] || Math.abs(solve[i]-solve[k])==Math.abs(i-k)) return false;
		}
		return true;
	}
	
	
	public static void main(String[] argc){
		List<String[]> result=new Solution().solveNQueens(4);
		System.out.println(result.size());
		for(String[] temp:result){
			for(String a:temp)
				System.out.println(a);
			System.out.println();
		}
	}
}