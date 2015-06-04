/*
Write a function to find the longest common prefix string amongst an array of strings.

思想：归并，递归解答
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null) return null;
		if(strs.length==0) return "";
		if(strs.length==1) return strs[0];
		
		return CommonPrefix(strs,0,strs.length-1);
    }
	
	public String CommonPrefix(String[] strs,int start,int end){
		if(start==end) return strs[start];
		if(start+1==end){  //返回两个字符串的最长公共前缀的大小
			return TwoCommon(strs[start],strs[end]);
		}
		
		int mid=(end-start)/2+start;
		return TwoCommon(CommonPrefix(strs,start,mid),CommonPrefix(strs,mid+1,end));
	}
	public String TwoCommon(String str1,String str2){
		    int len;
		    if(str1.length()>str2.length()){
				len=str2.length();
			}else{
				len=str1.length();
			}
			
			int i;
			for(i=0;i<len;i++){
				if(str1.charAt(i)!=str2.charAt(i)) break;
			}
			return str1.substring(0,i);	
	}
	
	
	public static void main(String[] argc){
		String[] strs={"ab","aa"};
		System.out.println(new Solution().longestCommonPrefix(strs));
	}
}