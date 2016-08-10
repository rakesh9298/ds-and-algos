package com.java.ds.stack;

import com.java.mock.MockObject;


public class StackUsingTwoQueues<T> implements StackInterface<T> {
    private QueueUsingStack<T> queue1;
    private QueueUsingStack<T> queue2;

    private int length;
    
	public StackUsingTwoQueues(int size) {
		queue1 = new QueueUsingStack<T>(size);
		queue2 = new QueueUsingStack<T>(size);				
	}

	@Override
	public void push(T element) throws StackFullException {
		try{
		if(queue1.isEmpty()){
			queue1.enQueue(element);
			return;
		}
		queue2.enQueue(element);
		while(!queue1.isEmpty()){
			queue2.enQueue(queue1.front());
			queue1.dQueue();
		}
		QueueUsingStack<T> temp = queue2;
		queue2 = queue1;
		queue1 = temp;
		length++;
		} catch(Exception e){
			new StackFullException(e);
		}
	}

	@Override
	public void pop() throws StackEmptyException {
		try {
			queue1.dQueue();
			length--;
		} catch (Exception e) {
			throw new StackEmptyException(e);
		}
		
	}

	@Override
	public T top() throws StackEmptyException {
		try {
			return queue1.front();
		} catch (Exception e) {
			throw new StackEmptyException(e);
		}
	}

	@Override
	public boolean isEmpty() {
		return queue1.isEmpty();
	}

	@Override
	public int size() {
		return length;
	}
	
	public static void main(String[] args) {
		StackInterface<MockObject> stack = new StackUsingTwoQueues<MockObject>(5);
        try {
			stack.push(new MockObject(1));
			stack.push(new MockObject(2));
			stack.push(new MockObject(3));
			stack.push(new MockObject(4));
			stack.push(new MockObject(5));
			//stack.push(new MockObject(7));
			
			while(!stack.isEmpty()){
				System.out.println(stack.top().getId());
				stack.pop();
			}
			stack.pop();
		} catch (StackFullException e) {
			e.printStackTrace();
		} catch (StackEmptyException e) {
			e.printStackTrace();
		}

	}

}
