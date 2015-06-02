/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

思路：循环从字符串的结尾倒序开始  要考虑"a "这种情况

*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0) return 0;
		
		int len=0;
		s=s.trim();
		for(int i=s.length()-1;i>=0;i--){
			if(s.charAt(i)==' ') break;
			len++;
		}
		
		return len;	
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().lengthOfLastWord("a "));
	}
}