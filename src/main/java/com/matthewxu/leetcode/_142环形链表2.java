package com.matthewxu.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _142环形链表2 {

	public ListNode detectCycle(ListNode head) {
		Set<ListNode> hashSet = new HashSet<>();
		while(head != null){
			if(!hashSet.add(head))
				return head;
			head = head.next;
		}
		return null;
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
