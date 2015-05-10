/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

思路：将每个单词的所有字母从小到大排列放入map<string,int> 排序好的单词  第一次出现的下标（如果已放入结果链表中则将下标改为-1）


*/

import java.util.*;
public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        List<String> list=new LinkedList<String>();		
		for(int i=0;i<strs.length;i++){
			String temp=sort(strs[i]);
			if(map.containsKey(temp)){ 
				list.add(strs[i]);
				int index=map.get(temp);
				if(index!=-1) list.add(strs[index]);
                map.put(temp,-1);				
			}else{
				map.put(temp,i);
			}
			
		}
		return list;
    }
	
	public String sort(String str){
		int[] result=new int[26];
		for(int i=0;i<str.length();i++){
			result[str.charAt(i)-'a']++;
		}
		StringBuilder r=new StringBuilder();
		
		for(int i=0;i<26;i++){
			while(result[i]!=0){
				r.append((char)('a'+i));
				result[i]--;
			}
		}
		return r.toString();
	}
	
	public static void main(String[] argc){
		String[] strs={"eat","ate","help","tea","ok"};
		List<String> list=new Solution().anagrams(strs);
		for(String c:list){
			System.out.println(c);
		}
		System.out.println();
	}
}