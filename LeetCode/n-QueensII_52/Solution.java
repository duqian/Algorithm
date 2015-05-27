/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

参考：51题
*/

public class Solution {
	
	public int totalNQueens(int n) {  //第n行的情况
	    int count=0;
	    int[] solve=new int[n+1];  //初始为0
		int i=1;
        while(i>=1){
			solve[i]++;
			while(solve[i]<n+1 && !isAgree(i,solve)){
				solve[i]++;
			}
			
			if(i==n && solve[i]<n+1){  //找到一个结果
				count++;
			}
			
			if(solve[i]<=n && i+1<=n){//没有到最后一行,
				i++;
			}else{
				solve[i]=0;
				i--;   //回溯
			}
		}
		
		return count;
    }

    public boolean isAgree(int k,int[] solve){
		for(int i=1;i<k;i++){
			if(solve[i]==solve[k] || Math.abs(solve[i]-solve[k])==Math.abs(i-k)) return false;
		}
		return true;
	}
	
	public static void main(String[] argc){
		System.out.println(new Solution().totalNQueens(4));
	}
}