/*
  Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
  
  ˼·�������ַ����ϵ�ÿһ��λ��i��ĸx
        x��ǰһ����ĸ����ʱ��ִ��ĳ���Ϊpre
        �鿴x��֮ǰ�Ƿ���ֹ��������λ��j���ֹ�����ȡpre+1��i-j���ߵ���Сֵ��ʾx��preֵ������x��preֵΪpre+1
        ʹ��map�ӿڱ���char index�ԣ�����index��ʾ����ĸ֮ǰ���һ�γ��ֵ�λ��
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