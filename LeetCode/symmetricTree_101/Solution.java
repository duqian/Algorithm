/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:
    1
   / \
  2   2
   \   \
   3    3
   
   思路：利用递归  或者层次遍历，每一层的值是对称，回文结构
*/

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null ||(root.left==null && root.right==null)) return true;
		if(root.left!=null && root.right!=null){
			return isSymmetric(root.left,root.right);
		}else{
			return false;
		}
    }
	
	public boolean isSymmetric(TreeNode left,TreeNode right){
		if(left==null && right==null) return true;
		else if(left!=null && right!=null){
			if(left.val==right.val){
				return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
			}
		}
		
		return false;
	}
	
	public static void main(String[] argc){
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(2);
		TreeNode t4=new TreeNode(3);
		TreeNode t5=new TreeNode(4);
		TreeNode t6=new TreeNode(4);
		TreeNode t7=new TreeNode(3);
		
		t1.left=t2;
		t1.right=t3;
		
		t2.left=t4;
		t2.right=t5;
		
		t3.left=t6;
		t3.right=t7;
		
		System.out.println(new Solution().isSymmetric(t1));
		
		
	}
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }