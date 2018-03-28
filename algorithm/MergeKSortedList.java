package edu.bjtu.sse;

import java.awt.List;

/**
 * 已知k个已排序链表头结点的指针，将这K个链表合并，合并后仍未有序的，返回合并后的头结点。
 * @author Administrator
 *
 */

public class MergeKSortedList {

	
	/**
	 * 
	 * @param lists
	 * @return
	 */
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists.length==0){
    		return null;
    	}
    	if(lists.length==1){
    		return lists[0];
    	}
    	if(lists.length==2){
    		return mergeTwoLists(lists[0],lists[1]);
    	}
    	int mid = lists.length/2;
    	ListNode[] subL1 = new ListNode[mid];
    	ListNode[] subL2 = new ListNode[mid+(lists.length%2)];
    	for (int i = 0; i < mid; i++) {
    		subL1[i] = lists[i];
		}
    	for(int i=mid,j=0; i<lists.length; i++){
    		subL2[j++] = lists[i];
    	}
    	
    	ListNode l1 = this.mergeKLists(subL1);
    	ListNode l2 = this.mergeKLists(subL2);
    	
    	return this.mergeTwoLists(l1, l2);
    }
    
    
    /**
     * 
     * @param l1
     * @param l2
     * @return
     */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode tmp = new ListNode(-1);
		ListNode pre = tmp;
		while(l1!=null && l2!=null){
			if(l1.val < l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		if(l1!=null){
			pre.next = l1;
		}
		if(l2!=null){
			pre.next = l2;
		}
		return tmp.next;
	}



	/**
	 * 3->4->5
	 * 3->6->8
	 * 1->7
	 * @param args
	 */
	public static void main(String[] args) {
		
		ListNode[] lists = new ListNode[3];
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		lists[0] = l1;
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(8);
		l4.next = l5;
		l5.next = l6;
		lists[1] = l4;
		ListNode l7 = new ListNode(1);
		ListNode l8 = new ListNode(7);
		l7.next = l8;
		lists[2] = l7;
		MergeKSortedList mksl = new MergeKSortedList();
		ListNode ln = mksl.mergeKLists(lists);
		while(ln!=null){
			System.out.print(ln.val + " ");
			ln = ln.next;
		}
		
		/*MergeKSortedList mksl = new MergeKSortedList();
		ListNode ln = mksl.mergeTwoLists(lists[0],lists[1]);
		while(ln!=null){
			System.out.print(ln.val + " ");
			ln = ln.next;
		}*/
		
		
		
	}

}
