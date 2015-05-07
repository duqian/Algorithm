/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

˼·��ʹ��map��¼key��value��
      ʹ��LinkedHashSet��¼����˳����У���������ʵķ�����β���������������м����µ�Ԫ��ʱ��Ҫɾ����ͷԪ��
	  
	  ���ʲ�֪��Ϊʹ��list����ʱ�䳬ʱ���²�list�ṹ�Ĳ����ض�Ԫ�س������б��еķ���Ч�ʵ͵�Ե�ʣ�
*/

import java.util.*;
public class LRUCache {
    LinkedHashSet<Integer> set;  //key,Խ������������շ��ʹ���
	Map<Integer,Integer> map;  //key value
	int capacity;  //����
	int size;
	
    public LRUCache(int capacity) {
		set=new LinkedHashSet<Integer>();
		map=new HashMap<Integer,Integer>();
		this.capacity=capacity;
		size=0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)||size==0) return -1;  //δ�ҵ�

		set.remove(new Integer(key));
		set.add(key);
		
		
		return map.get(key);
		
    }

    public void set(int key, int value) {
		if(map.containsKey(key)){ //�������ֵ���������
			map.put(key,value);
			set.remove(new Integer(key));
			set.add(key);
		}else{
			if(size<capacity){
				map.put(key,value);
				set.add(key);
				size++;
			}else{  //��������
			
			    Integer fistdelete = set.iterator().next();
                set.remove(fistdelete);
				map.remove(fistdelete);
				
				set.add(key);
				map.put(key,value);
			}
			
		}
  
    }
	
	public static void main(String[] argc){
		LRUCache l=new LRUCache(2);
		System.out.println(l.get(2));
		l.set(2,6);
		System.out.println(l.get(1));
		l.set(1,5);
		l.set(1,2);
		System.out.println(l.get(1));
		System.out.println(l.get(2));
		//out  -1 -1 2 6

	}
	
	
}