package stackAndQueue_3;

import java.util.Arrays;

/**
 * 栈的数组实现
 * @author ethan
 *
 * @param <E>
 */
public class ArrayStack<E>{
	private Object[] stack;
	private int size = 0;
	private int capacity = 10;
	
	public ArrayStack(){
		stack = new Object[capacity];
	}
	
	public ArrayStack(int capacity){
		this.capacity = capacity;
		stack = new Object[capacity];
	}
	
	public E pop(){
		if( size != 0 ){
			size--;
			return (E) stack[size-1];//注意数组的末尾为第size-1位
		}
		return null;
	}
	
	public E push(E item){
		size++;
		ensureCapacity(size);
		stack[size-1] = item;
		return item;
	}
	

	public E peek(){
		if( size == 0){
			return null;
		}
		return (E) stack[size-1];
	}

	public int size(){
		return size;
	}
	
	private void ensureCapacity(int size) {
		if( size > capacity){
			capacity = capacity<<1;
			System.out.println("new capacity is " + capacity);
			stack = Arrays.copyOf(stack, capacity);
		}
		
	}
	
	
}
