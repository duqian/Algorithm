/*
  Count the number of prime numbers less than a non-negative number, n
  
  思路：素数筛选法，最后统计还剩下的即为素数个数
*/

public class Solution {
    public int countPrimes(int n) {
		if(n==0 || n==1) return 0;
        boolean[] flag=new boolean[n];
		flag[1]=true;
		
		for(int i=2;i<Math.sqrt(n);i++){
			if(!flag[i]){
				for(int k=2*i;k<n;k+=i){
					flag[k]=true;
				}
			}
		}
		
		int num=0;
		for(int i=2;i<n;i++){
			if(!flag[i]) num++;
		}

		return num;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().countPrimes(4));
	}
}

