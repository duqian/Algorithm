/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

思路：利用栈
*/

public class Solution {
    public boolean isValid(String s) {
		if(s==null || s.length()==0) return true;
		if(s.length()%2==1) return false;
		
       char[] str=new char[s.length()];
       str[0]=s.charAt(0);
       int top=0;
       for(int i=1;i<s.length();i++){
		   if((s.charAt(i)==')' && str[top]=='(')||
		      (s.charAt(i)==']' && str[top]=='[')||
	          (s.charAt(i)=='}' && str[top]=='{')) 
			  top--;
		   else str[++top]=s.charAt(i);
	   }
       if(top==-1) return true;
       return false;	   
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().isValid("()"));
	}
}