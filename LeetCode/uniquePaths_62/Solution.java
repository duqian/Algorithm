/*
   A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

   The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

   How many possible unique paths are there?
   
   ˼·��ʹ�õݹ��uniquePaths(m,n)=uniquePaths(m-1,n)+uniquePaths(m,n-1)  ��ʱ 
         �ı�˼·�����м����ļ���Ҳչ�֣�ʹ������ͬ�Ķ�ά���鱣���м���
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