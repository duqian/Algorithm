/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
	   int result=0;
	   int k=1;
       for(int i=0;i<32;i++){
		  int temp=n&k;
          result+=temp;
          if(i<31){n>>=1;result<<=1;}		  
	   }
	   
       return result;	   
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().reverseBits(43261596));
		System.out.println(new Solution().reverseBits(1));
		
	}
}