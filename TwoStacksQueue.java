package com.ethfoo.algo;

import java.util.Stack;

public class TwoStacksQueue {
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	
	public TwoStacksQueue(){
		stackPush = new Stack<>();
		stackPop = new Stack<>();
	}
	
	public void add(int pushInt){
		stackPush.push(pushInt);
	}
	
	public int poll(){
		if( stackPop.isEmpty() ){
			
			if( stackPush.isEmpty() ){
				throw new RuntimeException("stack is empty");
			}else{
				while( !stackPush.isEmpty() ){
					int value = stackPush.pop();
					stackPop.push(value);
				}
			}
			
		}
		return stackPop.pop();
	}
	

	public static void main(String[] args) {

		TwoStacksQueue queue = new TwoStacksQueue();
		for(int i=0; i<9; i++){
			queue.add(i);
		}
		for(int i=0; i<9; i++){
			System.out.println(queue.poll());
		}
	}

}
