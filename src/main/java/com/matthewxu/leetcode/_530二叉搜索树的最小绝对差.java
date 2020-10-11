package com.matthewxu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _530二叉搜索树的最小绝对差 {

	public static int getMinimumDifference(TreeNode root) {
		int diff = -1;
		List<Integer> list = new ArrayList<>();
		while (root != null) {
			list.add(root.val);
			root = root.right;
		}
		for(int i = 0; i < list.size(); i++){
			for(int j = i + 1; j < list.size(); j++){
				
				int tempDiff = (list.get(i) == null ? 0 : list.get(i)) - (list.get(j) == null ? 0 : list.get(j));
				if (tempDiff <= 0)
					tempDiff = tempDiff * -1;
				if (diff == -1 || tempDiff < diff)
					diff = tempDiff;
			}
		}
		return diff;
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
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = null;
		TreeNode node3 = new TreeNode(4);

		node1.left = null;
		node1.right = node2;
//		node2.left = node1;
//		node2.right = node3;
		node3.left = node2;
		node3.right = null;
		System.out.println(getMinimumDifference(node1));
	}
}
