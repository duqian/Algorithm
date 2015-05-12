/*
  Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
  
  思路：遍历字符串上的每一个位置i字母x
        x的前一个字母包含时最长字串的长度为pre
        查看x在之前是否出现过，如果在位置j出现过，则取pre+1和i-j两者的最小值表示x的pre值，否则x的pre值为pre+1
        使用map接口保存char index对，其中index表示该字母之前最后一次出现的位置
  */

import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
		if(s==null) return 0;
		if(s.length()==0 || s.length()==1) return s.length();
        
		Map<Character,Integer> map=new HashMap<Character,Integer>();  //key index
		int max=1;
		int pre=1;
		map.put(s.charAt(0),0);
		for(int i=1;i<s.length();i++){
			char c=s.charAt(i);
			pre+=1;
			if(map.containsKey(c)){
				int index=map.get(c);
				int len=i-index;
                pre=pre>len?len:pre;
			}
			
			max=max>pre?max:pre;
			map.put(c,i);
		}
		
		return max;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().lengthOfLongestSubstring("abcabcdd"));
	}
}