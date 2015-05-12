/*
 Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 
 思路：整数部分单独计算  小数部分借助map<int,int> key为该位置的余数，value为小数后面的位置
 
*/

import java.util.*;
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
		if(denominator==0) return null;
		
        StringBuilder result=new StringBuilder();
		if((numerator<0&&denominator>0) || (numerator>0&&denominator<0)){
			result.append('-');
		}
		long n=Math.abs((long)numerator);
		long d=Math.abs((long)denominator);
		System.out.println("n: "+n+"d: "+d);
		result.append(n/d);
		if(n!=0 && n%d!=0){  //有小数部分
			result.append('.');
			n=n%d;
			int i=result.length();  //记录小数的位置
			Map<Long,Integer> map=new HashMap<Long,Integer>();
			int flag=0;//标记是否有重复
			while(n!=0){
				n*=10;
				long r=n/d;
				long temp=n%d;
				System.out.println("r "+r);
				if(temp!=0 && map.containsKey(temp)){
					flag=map.get(temp);
					if(result.charAt(flag)!=(char)(r+'0')){
						result.append((char)(r+'0'));
						flag++;
					}
					break;
				}
				result.append((char)(r+'0'));
				map.put(temp,i);
				n=temp;
				i++;
			}
			
			if(flag!=0){//有重复
				result.insert(flag,'(');
				result.insert(result.length(),')');
			} 
			
		}
		return result.toString();
    }
	
	public static void main(String[] argc){
		//System.out.println(new Solution().fractionToDecimal(1,2));
		//System.out.println(new Solution().fractionToDecimal(2,1));
		//System.out.println(new Solution().fractionToDecimal(2,3));
		//System.out.println(new Solution().fractionToDecimal(1,6));
		//System.out.println(new Solution().fractionToDecimal(22,7));
		//System.out.println(new Solution().fractionToDecimal(-50,8));
		System.out.println(new Solution().fractionToDecimal(-1,-2147483648));
		
	}
}