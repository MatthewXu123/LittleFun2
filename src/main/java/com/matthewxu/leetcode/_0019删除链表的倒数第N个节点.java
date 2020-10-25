package com.matthewxu.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _0019删除链表的倒数第N个节点 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head.next == null && n == 1)
			return null;
        List<ListNode> list = new ArrayList<>();
        while(head != null){
        	list.add(head);
        	head = head.next;
        }
        int target = list.size() - n;
        Iterator<ListNode> iterator = list.iterator();
        int i = 0;
        while(iterator.hasNext()){
        	ListNode next = iterator.next();
        	if(i == target)
        		iterator.remove();
        	i++;
        }
        for (int j = 0; j < list.size(); j++) {
			ListNode listNode = list.get(j);
			ListNode listNode2 = null;
			if(j != list.size() - 1)
				listNode2 = list.get(j + 1);
			listNode.next = listNode2;
		}
        return list.get(0);
    }
	
	 public class ListNode {
	      int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
}
