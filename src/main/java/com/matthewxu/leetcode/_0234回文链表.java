package com.matthewxu.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0234回文链表 {

	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null)
			return true;
		List<ListNode> list = new ArrayList<>();
		while(head != null){
			list.add(head);
			head = head.next;
		}
		int size = list.size();
		for(int i = 0 ; i < size / 2 ; i++){
			if(list.get(i).val != list.get(size - 1 - i).val)
				return false;
		}
		return true;
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
