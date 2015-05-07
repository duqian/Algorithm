/*
  Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
  
  思路：借助21题Merge Two Sorted Lists，主要思路借鉴合并排序，两两合并
*/

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null) return null;
        if(lists.length==1) return lists[0];
		
		return merge(lists,0,lists.length);
        		
    }
	
	public ListNode merge(ListNode[] lists,int left,int right){
		if(right<=left) return null;
		if(right-left==1) return lists[left];
		
		int mid=(right-left)/2+left;
		ListNode listsleft=merge(lists,left,mid);
		ListNode listsright=merge(lists,mid,right);
		return mergeTwoLists(listsleft,listsright);
		
		
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
		ListNode[] lists=new ListNode[3];
		lists[0]=makelist(new int[]{1,3,7});
		lists[1]=makelist(new int[]{2,4,6});
		lists[2]=makelist(new int[]{5,8,9});
		
		ListNode temp=new Solution().mergeKLists(lists);
		ListNode p=temp;
		while(p!=null){
			System.out.println(p.val);
			p=p.next;
		}
		
	}
	
	public static ListNode makelist(int[] list){ 
		ListNode head=null;
		ListNode pre=null;
		for(int val:list){
		   ListNode temp=new ListNode(val);
           if(head==null){
			  head=temp;			  
		   } else{
			  pre.next=temp;
           }	
            pre=temp;		   
		}
		return head;
	}
}