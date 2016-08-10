package com.java.ds.stack;

import com.java.mock.MockObject;

public class GrowingStackGrowthStrategy<T>  implements StackInterface<T> {
    private Object[] stackArray;
    private int size = 0;
   
	
	public GrowingStackGrowthStrategy(int size) {
		stackArray =  new Object[size];	 
	}

	@Override
	public void push(T element) throws StackFullException {
	   if(size==stackArray.length){
		   Object[] newArray = new Object[2*stackArray.length];
		   for(int i=0; i<stackArray.length; i++){
			   newArray[i] = stackArray[i];
		   }
		   stackArray = newArray;
	   }
	   stackArray[size] = element;
	   size++;
		
	}

	@Override
	public void pop() throws StackEmptyException {
		if(size == 0){
			throw new StackEmptyException();
		}
		stackArray[size-1] = null;
		size--;
	}

	@Override
	public T top() throws StackEmptyException {
		if(size == 0){
			throw new StackEmptyException();
		}
		return (T) stackArray[size-1];
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public int size() {
		return stackArray.length;
	}

	public static void main(String[] args) {
		GrowingStackGrowthStrategy<MockObject> stack = new GrowingStackGrowthStrategy<MockObject>(3);
		try {
			stack.push(new MockObject(1));
			stack.push(new MockObject(2));
			stack.push(new MockObject(3));
			System.out.println(stack.size());
			stack.push(new MockObject(4));
			System.out.println(stack.size());
		} catch (StackFullException e) {
			e.printStackTrace();
		}
	}
}
