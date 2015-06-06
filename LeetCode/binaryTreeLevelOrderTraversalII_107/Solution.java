/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result=new LinkedList<List<Integer>>(); //addFirst
		if(root==null) return result;
		LinkedList<TreeNode> temp=new LinkedList<TreeNode>();  //╤сап
		temp.add(root);
		int templen=1; 
		while(templen!=0){
			List<Integer> r=new ArrayList<Integer>();
			int newlen=0;
			for(int i=0;i<templen;i++){
				TreeNode node=temp.remove();
				r.add(node.val);
				if(node.left!=null){
					temp.add(node.left);
					newlen++;
				} 
				if(node.right!=null){
					temp.add(node.right);
					newlen++;
				} 
			}
			result.addFirst(r);
			templen=newlen;
		}
       return result;			
    }
	
	public static void main(String[] argc){
		TreeNode t1=new TreeNode(3);
		TreeNode t2=new TreeNode(9);
		TreeNode t3=new TreeNode(20);
		TreeNode t4=new TreeNode(15);
		TreeNode t5=new TreeNode(7);
		
		t1.left=t2;t1.right=t3;
		t3.left=t4;t3.right=t5;
		
		List<List<Integer>> result= new Solution().levelOrderBottom(t1);
		for(List<Integer> list:result){
			for(int a:list){
				System.out.print(a+" ");
			}
			System.out.println();
		}
		
	}
}