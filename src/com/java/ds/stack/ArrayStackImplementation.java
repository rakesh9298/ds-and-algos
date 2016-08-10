package com.java.ds.stack;

import com.java.mock.MockObject;


public class ArrayStackImplementation<T> implements StackInterface<T> {

	private int topIndex;
	private Object[] stackArray;
	
	
	public ArrayStackImplementation(Integer size) {
		 stackArray = new Object[size];
		 topIndex=-1;
	}
	
	
	@Override
	public void push(T element) throws StackFullException {
		if(stackArray.length==topIndex+1){
			throw new StackFullException();
		}
		stackArray[topIndex+1] = element;
		topIndex++;
	}

	@Override
	public void pop() throws StackEmptyException {
		if(topIndex==-1){
			throw new StackEmptyException();
		}
		stackArray[topIndex]=null;
		topIndex--;
	}

	@Override
	public  T top() throws StackEmptyException {
		if(topIndex==-1){
			throw new StackEmptyException();
		}
		return  (T) stackArray[topIndex];
	}
	
	@Override
	public boolean isEmpty() {
		return topIndex == -1;
	}


	@Override
	public int size() {
		return topIndex+1;
	}
	
	public static void main(String[] args){
		StackInterface<MockObject> stack = new ArrayStackImplementation<MockObject>(5);
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
