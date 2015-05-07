/*
  Reverse a singly linked list.
*/
 
public class Solution {
    public ListNode reverseList(ListNode head) {
		if(head==null || head.next==null) return head;
		
		ListNode pre=head;
		ListNode p=head.next;
		head.next=null;
		
		while(p!=null){
			ListNode pnext=p.next;
			p.next=pre;
			pre=p;
			p=pnext;
		}
		
		head=pre;
        return head;
    }
	
	public static void main(String[] argc){
		ListNode t1=new ListNode(1);
		ListNode t2=new ListNode(2);
		ListNode t3=new ListNode(3);
		ListNode t4=new ListNode(4);
		ListNode t5=new ListNode(5);
		t1.next=t2;
		//t2.next=t3;
		//t3.next=t4;
		//t4.next=t5;
		
		ListNode temp=new Solution().reverseList(t1);
		ListNode p=temp;
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
		
	}
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }