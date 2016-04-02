package stackAndQueue_3;

public class ListStack<E> {

	private class Node<E> {
		E data;
		Node<E> next;
	}

	private Node<E> head;
	private int size = 0;

	public void push(E item) {
		Node<E> newNode = new Node<E>();
		newNode.data = item;
		if (head != null) {
			newNode.next = head;
		}
		head = newNode;
		size++;
	}

	public E pop() {
		if (head != null) {
			Node<E> ret = head;
			ret.next = null;
			head = head.next;
			size--;
			return ret.data;
		}
		return null;
	}

	public E peek() {
		if (head != null) {
			return head.data;
		}
		return null;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		ListStack<String> stack = new ListStack<String>();
		for (int i = 0; i < 11; i++) {
			stack.push("item" + i);
		}
		System.out.println(stack.peek());
		System.out.println(stack.size());

	}
		

}
