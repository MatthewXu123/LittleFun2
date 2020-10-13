package com.matthewxu.leetcode;

public class _24两两交换链表中的节点 {

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
