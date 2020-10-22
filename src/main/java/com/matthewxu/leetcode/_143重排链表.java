
package com.matthewxu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * 
 * @author Matthew Xu
 * @date Oct 20, 2020
 */
public class _143重排链表 {

	public class ListNode {
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

	public void reorderList(ListNode head) {
		List<ListNode> list = new ArrayList<>();
		while(head != null){
			list.add(head);
			head = head.next;
		}
		int length = list.size();
		for(int i = 0; i < length / 2;){
			list.get(i).next = list.get(length - 1 -i);
		}
		
	}
	
}
