package stackAndQueue_3;

public class ArrayQueue<E> {

	private Object[] elements;
	private int head;
	private int tail;

	public ArrayQueue() {
		elements = new Object[16];
	}

	public ArrayQueue(int size) {
		elements = new Object[size];
	}

	public boolean offer(E item) {
		return offerLast(item);
	}

	private boolean offerLast(E item) {
		
		if (((tail+1) & (elements.length - 1)) == head) {
			return false;
		} else {
			elements[tail++] = item;
			return true;
		}
	}

	public E poll() {
		return pollFirst();
	}

	private E pollFirst() {
		int h = head;
		E result = (E) elements[h];
		if (result == null) {
			return null;
		}
		elements[h] = null;
		head = (h + 1) & (elements.length - 1);
		return result;
	}

	public int size() {
		return (tail - head) & (elements.length - 1);
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public static void main(String args[]) {
		ArrayQueue<String> queue = new ArrayQueue<String>();
		for( int i=0; i<20; i++){
			if(queue.offer("item" + i)){
				System.out.println("offer-->item" + i);
			}
		}
		for( int i=0; i<3; i++){
			System.out.println("poll-->" + queue.poll());
		}
		System.out.println("head=" + queue.head);
		System.out.println("tail=" + queue.tail);
			
		
	}

}
