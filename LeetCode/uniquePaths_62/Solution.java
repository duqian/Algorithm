/*
   A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

   The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

   How many possible unique paths are there?
   
   思路：使用递归的uniquePaths(m,n)=uniquePaths(m-1,n)+uniquePaths(m,n-1)  超时 
         改变思路，将中间结果的计算也展现，使用其相同的二维数组保存中间结果
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] metrix=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0 || j==0){
					metrix[i][j]=1;
				} else{
					metrix[i][j]=metrix[i-1][j]+metrix[i][j-1];
				}
			}
		}
		
		return metrix[m-1][n-1];
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().uniquePaths(3,7));
	}
}