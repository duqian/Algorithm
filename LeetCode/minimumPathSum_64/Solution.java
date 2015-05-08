/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

˼·����62����Ψһ·������  ֻ��ÿ��ѡ�����ڣ���߻��ϱߣ�����Сֵ�ӵ�����

*/

public class Solution {
    public int minPathSum(int[][] grid) {
		if(grid==null || grid.length==0) return 0;
		
        int m=grid.length;  //row
		int n=grid[0].length;  //column
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0 && j==0) {}
				else if(i==0){
					grid[i][j]+=grid[i][j-1];
				}
				else if(j==0){
					grid[i][j]+=grid[i-1][j];
				}else{
					int min=grid[i-1][j]>grid[i][j-1]?grid[i][j-1]:grid[i-1][j];
					grid[i][j]+=min;
				}
			}
		}
		
		return grid[m-1][n-1];
    }
	
	public static void main(String[] argc){
		int[][] grid={{1,2,1,4},
			          {2,1,3,5},
					  {4,2,2,3}
		             };
		System.out.println(new Solution().minPathSum(new int[][]{{1},{2},{4}}));
	}
}