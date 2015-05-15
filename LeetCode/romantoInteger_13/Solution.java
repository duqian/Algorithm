/*
  Given a roman numeral, convert it to an integer.

  Input is guaranteed to be within the range from 1 to 3999.
  
  参考12题的罗马数字规则
  
*/

import java.util.*;
public class Solution {
    public int romanToInt(String s) {
       Map<Character,Integer> map=new HashMap<Character,Integer>();
       map.put('M',1000); 
	   map.put('C',100); 
	   map.put('D',500); 
	   map.put('X',10); 
	   map.put('L',50); 
	   map.put('I',1); 
	   map.put('V',5); 
	   
	   int sum=0;
	   for(int i=0;i<s.length();i++){
		  int temp=map.get(s.charAt(i));
          if(i+1<s.length() && map.get(s.charAt(i+1))>temp) temp*=(-1);
          sum+=temp;		  
	   } 
	   return sum;
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().romanToInt("MMMCCCXXXIII"));
		System.out.println(new Solution().romanToInt("MDCCCLXXX"));
		System.out.println(new Solution().romanToInt("CM"));
	}
}