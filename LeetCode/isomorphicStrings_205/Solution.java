/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

思路：借助map<character,character> 存储已有的映射，出现新的与之前的冲突则失败
ab aa  false  a-a  b-a (两个个字母映射到同一个字母)
aa ab  false  a-a  a-b (一个字母映射到两个字母)
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
			if(map.containsKey(s1)){  //不能一对二
			   if(map.get(s1)!=t1)	return false;
			}else{
				if(map.containsValue(t1)) return false;  //不能二对一
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