/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

思路：使用两个指针，分别表示前后，但是同样他们都能够跳过非字母的情况
*/ 

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()<=1) return true;
		
		s=s.toLowerCase();
		int i=0;
		int j=s.length()-1;
		while(i<=j){
			while(i<=j && !Character.isLetterOrDigit(s.charAt(i))){
				i++;
			}
			
			while(i<=j && !Character.isLetterOrDigit(s.charAt(j))){
				j--;
			}
			if(i<=j){
				if(s.charAt(i)!=s.charAt(j)) return false;
				else{i++; j--;}
			}
		}
		return true;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().isPalindrome("1a2"));
	}
}