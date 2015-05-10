/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

˼·������map<character,character> �洢���е�ӳ�䣬�����µ���֮ǰ�ĳ�ͻ��ʧ��
ab aa  false  a-a  b-a (��������ĸӳ�䵽ͬһ����ĸ)
aa ab  false  a-a  a-b (һ����ĸӳ�䵽������ĸ)
ab ca  true  a-c  b-a
*/

import java.util.*;
public class Solution {
    public boolean isIsomorphic(String s, String t) {
		if(s==null) return false; 
        Map<Character,Character> map=new  HashMap<Character,Character>();
		for(int i=0;i<s.length();i++){
			char s1=s.charAt(i);
			char t1=t.charAt(i);
			if(map.containsKey(s1)){  //����һ�Զ�
			   if(map.get(s1)!=t1)	return false;
			}else{
				if(map.containsValue(t1)) return false;  //���ܶ���һ
				map.put(s1,t1);
			}
		}
		return true;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().isIsomorphic("ab","aa"));
		System.out.println(new Solution().isIsomorphic("aa","ab"));
		System.out.println(new Solution().isIsomorphic("ab","ca"));
	}
}