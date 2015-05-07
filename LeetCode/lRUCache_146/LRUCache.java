/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

思路：使用map记录key和value对
      使用LinkedHashSet记录访问顺序队列，最近被访问的放入链尾，当超过容量还有加入新的元素时需要删除链头元素
	  
	  疑问不知道为使用list总是时间超时（猜测list结构的查找特定元素出现在列表中的方法效率低的缘故）
*/

import java.util.*;
public class LRUCache {
    LinkedHashSet<Integer> set;  //key,越靠后面是最近刚访问过的
	Map<Integer,Integer> map;  //key value
	int capacity;  //容量
	int size;
	
    public LRUCache(int capacity) {
		set=new LinkedHashSet<Integer>();
		map=new HashMap<Integer,Integer>();
		this.capacity=capacity;
		size=0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)||size==0) return -1;  //未找到

		set.remove(new Integer(key));
		set.add(key);
		
		
		return map.get(key);
		
    }

    public void set(int key, int value) {
		if(map.containsKey(key)){ //插入的新值包含的情况
			map.put(key,value);
			set.remove(new Integer(key));
			set.add(key);
		}else{
			if(size<capacity){
				map.put(key,value);
				set.add(key);
				size++;
			}else{  //超过容量
			
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