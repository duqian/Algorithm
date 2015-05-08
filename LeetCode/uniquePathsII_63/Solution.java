/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

  思路：参考62题
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null || obstacleGrid.length==0) return 0;
		if(obstacleGrid[0][0]==1) return 0;
		
		int m=obstacleGrid.length;  //row
		int n=obstacleGrid[0].length;  //column
		int[][] grid=new int[m][n];
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(obstacleGrid[i][j]==1){
					grid[i][j]=0;
				}else if(i==0&&j==0){
					grid[i][j]=1;
				}else if(i==0){
					grid[i][j]=grid[i][j-1];
				}else if(j==0){
					grid[i][j]=grid[i-1][j];
				}else{
					grid[i][j]=grid[i-1][j]+grid[i][j-1];
				}
			}
		}
		
		return grid[m-1][n-1];
    }
	
	public static void main(String[] argc){
		int[][] obstacleGrid={
			{0,0},
			{1,1},
			{0,0}
		};
		System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));
	}
}