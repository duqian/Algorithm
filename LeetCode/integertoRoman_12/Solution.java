/*
  Given an integer, convert it to a roman numeral.
  Input is guaranteed to be within the range from 1 to 3999.
  
  �������ֵĹ���
  �������ֹ���7������I��1����V��5����X��10����L��50����C��100����D��500����M��1000�������������Ĺ�����Ա�ʾ��������������Ҫע���������������û�С�0�������λ���޹ء�һ����Ϊ��������ֻ�������������������㡣
  ԭ��
	�ظ����Σ�һ�����������ظ����Σ��ͱ�ʾ������ļ�����
	�Ҽ������
	�ڽϴ���������ֵ��ұ߼��Ͻ�С���������֣���ʾ�����ּ�С���֡�
	�ڽϴ���������ֵ���߼��Ͻ�С���������֣���ʾ�����ּ�С���֡�
	��������������ƣ�������I��X��C������45������д��VL��ֻ����XLV
	���ǣ����ʱ���ɿ�Խһ��λ�������磬99��������IC��100 - 1����ʾ��������XCIX��[100 - 10] + [10 - 1]����ʾ������ͬ�ڰ���������ÿλ���ֱַ��ʾ����
	������ֱ���Ϊһλ������8д��VIII������IIX��
	�Ҽ����ֲ�������������λ������14д��XIV������XIIII�������·����������ơ�һ���
	���߳�ǧ��
	���������ֵ��Ϸ�����һ�����߻��߼����±��?����ʾ�����������1000������ԭ����1000����
	ͬ������Ϸ����������ߣ�����ԭ����1000000��1000^{2}������
	�������ƣ�
	ͬһ�������ֻ�ܳ������Σ���40���ɱ�ʾΪXXXX����Ҫ��ʾΪXL��
	���⣺����IV�ǹ���������������أ���IVPITER����������ĸ��û��J��U�������֣������ʱ��IIII����IV��
	
	˼·��ʹ�������¼ÿ���������ı�ʾ
	String[][] s={};  //s[0]��ǧλ  s[1]����λ  s[2]:ʮλ  s[3]:��λ
*/

public class Solution {
    public String intToRoman(int num) {
       if(num==0) return "";
       
	   String[][] s={
		   {"","M","MM","MMM"},//1000-3000
		   {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},//100-900
		   {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"}, //10-90
		   {"","I","II","III","IV","V","VI","VII","VIII","IX"} //1-9
	   };   
	    
		StringBuilder result=new StringBuilder();
		int k=1000;
		for(int i=0;i<s.length;i++){
			int index=num/k;
			result.append(s[i][index]);
			num=num%k;
			k=k/10;
		}
		
		return result.toString();
    }
	
	public static void main(String[] argc){
		System.out.println(new Solution().intToRoman(3333));
		System.out.println(new Solution().intToRoman(99));
		System.out.println(new Solution().intToRoman(4));
		System.out.println(new Solution().intToRoman(1));
	}
	
}