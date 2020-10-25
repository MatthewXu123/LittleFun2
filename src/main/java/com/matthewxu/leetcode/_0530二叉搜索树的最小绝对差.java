package com.matthewxu.leetcode;

public class _0530二叉搜索树的最小绝对差 {

	static int pre;
    static int min;

    public static int getMinimumDifference(TreeNode root) {
        pre = -1;
        min = Integer.MAX_VALUE;
        dfs(root);
        return min;
    }
    
    public static void dfs(TreeNode node){
    	if(node == null)
    		return;
    	dfs(node.left);
    	if(pre == -1)
    		pre = node.val;
    	else{
    		min = Math.min(min, node.val - pre);
    		pre = node.val;
    	}
    	dfs(node.right);
    	
    }

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		//[1, null, 2, 4]
//		 1
//	      \
//	       2
//	      /
//	     4
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(2);

		node1.left = null;
		node1.right = node2;
		node2.left = node3;
		node2.right = null;
		System.out.println(getMinimumDifference(node1));
	}
}
