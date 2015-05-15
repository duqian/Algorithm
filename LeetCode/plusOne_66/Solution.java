/*
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
       int c=0;
       for(int i=digits.length-1;i>=0;i--){
		   int temp=(digits[i]+1)%10;
		   c=(digits[i]+1)/10;
		   digits[i]=temp;
		   if(c==0) return digits;
	   }
	   
	   int[] newdigits=new int[digits.length+1];
       newdigits[0]=1;
       return newdigits;	   
    }
	
	public static void main(String[] argc){
		int[] temp=new Solution().plusOne(new int[]{9,9,9});
		for(int a:temp){
			System.out.print(a);
		}
		System.out.println();
	}
}