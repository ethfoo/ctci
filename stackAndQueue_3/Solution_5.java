package stackAndQueue_3;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * @author ethan
 *
 */
public class Solution_5 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				Integer tmp = stack1.pop();
				stack2.push(tmp);
			}
			return stack2.pop();
		} else {
			return stack2.pop();
		}
	}

}