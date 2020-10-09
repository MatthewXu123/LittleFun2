package com.matthewxu.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _141环形链表 {

	public boolean hasCycle(ListNode head) {
		Set<ListNode> hashSet = new HashSet<>();
		while(head != null){
			if(!hashSet.add(head))
				return true;
			head = head.next;
		}
		return false;
	}
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
}
