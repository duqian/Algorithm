/*
  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

  push(x) -- Push element x onto stack.
  pop() -- Removes the element on top of the stack.
  top() -- Get the top element.
  getMin() -- Retrieve the minimum element in the stack.
  
  思路：使用list存储数据，使用一个变量min记录最小值，push时需要与当前最小值相比更新，在pop时在最小值remove时需要重新找到最小值（遍历整个list）
*/
import java.util.*;

public class MinStack {
	List<Integer> stack=new ArrayList<Integer>();
	int top=-1;
	int min=Integer.MAX_VALUE;
	
    public void push(int x) {
        stack.add(x);
		top++;
		min=min>x?x:min;
    }

    public void pop() {
       if(top!=-1){
		   int pop=stack.remove(top);
		   top--;
		   if(min==pop){
			   min=Integer.MAX_VALUE;
			   for(Integer c:stack){
				   min=min>c?c:min;
			   }
		   }
	   } 
    }

    public int top() {
        return top==-1?0:stack.get(top);
    }

    public int getMin() {
        return min;
    }
	
	//test
	public static void main(String[] argc){
		MinStack test=new MinStack();
		test.push(2);
		test.push(3);
		test.push(1);
		test.push(4);
		test.push(5);
		
		System.out.println(test.top());
		System.out.println(test.getMin());
		test.pop();
		System.out.println(test.top());
		
		test.pop();
		test.pop();
		System.out.println(test.getMin());

	}
}