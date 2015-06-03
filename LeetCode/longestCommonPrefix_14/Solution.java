/*
Write a function to find the longest common prefix string amongst an array of strings.

思想：归并，递归解答
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null) return null;
		if(strs.length==0) return "";
		if(strs.length==1) return strs[0];
		
		int index=CommonPrefix(strs,0,strs.length-1);
		if(index!=-1) return strs[0].substring(0,index);
		else return "";
    }
	
	public int CommonPrefix(String[] strs,int start,int end){
		if(start==end) return strs[start].length();
		if(start+1==end){  //返回两个字符串的最长公共前缀的大小
			int len;
			String str1=strs[start];
			String str2=strs[end];
			if(str1.length()>str2.length()){
				len=str2.length();
			}else{
				len=str1.length();
			}
			
			for(int i=0;i<len;i++){
				if(str1.charAt(i)!=str2.charAt(i)) return i;
			}
		}
		
		int mid=(end-start)/2+start;
		int len1=CommonPrefix(strs,start,mid);
		int len2=CommonPrefix(strs,mid+1,end);
		return len1>len2?len2:len1;
	}
	
	public static void main(String[] argc){
		String[] strs={"abcd","abcs","abd"};
		System.out.println(new Solution().longestCommonPrefix(strs));
	}
}