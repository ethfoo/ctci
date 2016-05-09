package com.ethfoo.algo;

public class LinkListTest {
	//单链表node
	private class Node{
		private int value;
		private Node next;
		
		public Node(int value){
			this.value = value;
		}
		
	}
	
	public Node buildLinkList(int[] a){
		if( a == null) {
			throw new RuntimeException("array is null");
		}
		
		Node head = new Node(a[0]);

		Node last = head;
		for(int i=1; i<a.length; i++){
			Node n = new Node(a[i]);
			last.next = n;
			last = n;
		}
		
		return head; 
	}
	
	/*
	 * 从尾到头打印链表
	 */
	public void printFromTail(Node head){
		if( head == null){
			return;
		}
		
		printFromTail(head.next);
		System.out.println(head.value);
	}
	
	/*
	 * 找到链表的中间节点
	 */
	public Node findMidNode(Node head){
		if( head == null || head.next == null ){
			return head;
		}
		
		Node slow = head;
		Node fast = head;
		while( fast.next!=null && fast.next.next!=null ){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	/*
	 * 找出单链表中的倒数第k个数
	 */
	public Node findLastKth(Node head, int k){
		Node left = head;
		Node right = head;
		
		for(int i=0; i<k; i++){
			right = right.next;
		}
		
		while( right != null){
			left = left.next;
			right = right.next;
		}
		
		return left;
	}
	
	/*
	 * 反转单向链表!!!注意三个指针的使用
	 */
	public Node reverseList(Node head){
		Node prev = null;
		Node next = null;
		while( head != null ){
			next = head.next;
			head.next = prev;
			
			prev = head;
			head = next;
		}
		return prev;
	}
	
	/*
	 * 反转单向链表，递归???
	 */
	public Node revList(Node head){
		if(head == null || head.next == null)
			return head;
		
		Node newHead = revList(head.next);
		head.next.next = head; 
		head.next = null;
		return newHead; 
	}
	
	/*
	 * 合并两个排序链表
	 */
	public Node mergeList(Node head1, Node head2){
		if( head1 == null) return head2;
		if( head2 == null) return head1;
		
		Node head = head1.value < head2.value ? head1 : head2;
		Node cur1 = (head==head1)?head1.next:head1;
		Node cur2 = (head==head2)?head2.next:head2;
		
		Node pre = head;
		while( cur1!=null && cur2!=null ){
			if( cur1.value < cur2.value ){
				pre.next = cur1;
				pre = cur1;
				cur1 = cur1.next;
			}else{
				pre.next = cur2;
				pre = cur2;
				cur2 = cur2.next;
			}
		}
		
		if( cur1 == null ){
			pre.next = cur2;
		}else{
			pre.next = cur1;
		}
		
		return head;
	}
	
	/*
	 * 合并两个排序链表,递归
	 * 
	 */
	
	
	
	
	public static void main(String[] args) {

		LinkListTest test = new LinkListTest();
		
		int a[] = {4, 6, 7, 8, 10, 24};
		int b[] = {3, 5, 9, 20};
		
		Node head = test.buildLinkList(a);
		System.out.println(test.findMidNode(head).value);
		
		//Node head2 = test.buildLinkList(b); 
		
		//Node head = test.mergeList(head1, head2);
		
		//test.printFromTail(head);
		//System.out.println(test.findLastKth(head, 3).value);
		/*while(head != null){
			System.out.println(head.value);
			head = head.next;
		}*/

		
		
	}

}
