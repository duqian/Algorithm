/*
  Sort a linked list in O(n log n) time using constant space complexity.
*/

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
		ListNode slow=head;
		ListNode fast=head;
		ListNode pre=null;
		while(fast!=null && fast.next!=null){
			pre=slow;
			slow=slow.next;
			fast=fast.next;
			fast=fast.next;
		}
		
	    pre.next=null;
		
		return mergeTwoLists(sortList(head),sortList(slow));
    }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		
	    ListNode p=l1,ppre=null;
	    ListNode q=l2;
	    
	    while(q!=null){
	    	l2=q.next;
	    	while(p!=null&&q.val>=p.val){
	    		ppre=p;
	    		p=p.next;
	    	}
	    	if(ppre==null){
	    		l1=q;
	    	 }else{
	    		ppre.next=q;
	    	 }
	    	ppre=q;
	    	ppre.next=p;
	    	q=l2;
	    }
        return l1;
    }
	
	public static void main(String[] argc){
		ListNode t1=new ListNode(2);
		ListNode t2=new ListNode(1);
		ListNode t3=new ListNode(4);
		ListNode t4=new ListNode(3);
		ListNode t5=new ListNode(5);
		t1.next=t2;
		//t2.next=t3;
		//t3.next=t4;
		//t4.next=t5;
		
		ListNode temp=new Solution().sortList(t1);
		ListNode p=temp;
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
		
	}
		
}