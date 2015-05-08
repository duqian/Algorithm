/*
  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
  reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

  You must do this in-place without altering the nodes' values.

  For example,
  Given {1,2,3,4}, reorder it to {1,4,2,3}.
  
  思路：链表分成前后两部分，后边一半先是链表逆向，然后挨个插入到前半个链表中
*/

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class Solution {
    public ListNode reorderList(ListNode head) {
		if(head==null || head.next==null) return head;
		
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next;
			fast=fast.next;
		}
		
		ListNode newhead=slow.next;
		slow.next=null;
	    if(newhead!=null){
			newhead=reverseList(newhead);
		
			ListNode q=head;
			while(newhead!=null&&q!=null){
			  ListNode p=newhead;
			  newhead=p.next;
			  
			  p.next=q.next;
			  q.next=p;
			  q=p.next;
				
			}
		}
		
        return head;
    }
	
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
		t2.next=t3;
		//t3.next=t4;
		//t4.next=t5;
		
		ListNode temp=new Solution().reorderList(t1);
		ListNode p=temp;
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
		
	}
}