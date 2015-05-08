/*
   You are climbing a stair case. It takes n steps to reach to the top.

   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
   
   ˼·����¥�����⣬����쳲��������У����õݹ����������ֺܶ��ظ����㣬�������ݱȽ��Ӵ�ʱ��ʱ���
*/

public class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
		if(n==2) return 2;
		
		int a1=1,a2=2;
		for(int i=3;i<=n;i++){
			int temp=a2+a1;
			a1=a2;
			a2=temp;
		}
		return a2;	
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().climbStairs(3));
	}
}