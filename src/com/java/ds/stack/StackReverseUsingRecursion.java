package com.java.ds.stack;

public class StackReverseUsingRecursion {

	public StackReverseUsingRecursion() {
		// TODO Auto-generated constructor stub
	}
    
	public static void stackReverse(StackInterface<Integer> stack) throws StackEmptyException, StackFullException{
		Integer temp = stack.top();
		stack.pop();
        if(stack.isEmpty()){
		   stack.push(temp);
		   return;
		}
        stackReverse(stack);
        insertElementAtBottom(stack, temp);
	}

	private static void insertElementAtBottom(StackInterface<Integer> stack,
			Integer bottom) throws StackFullException, StackEmptyException {
	  if(stack.isEmpty()){
		  stack.push(bottom);
		  return;
	  }
	  Integer temp = stack.top();
	  stack.pop();
      insertElementAtBottom(stack, bottom);	
      stack.push(temp);
	}
	
	public static void main(String[] args){
		try{
			StackInterface<Integer> stack = new ArrayStackImplementation<Integer>(10);
			for(int i =1; i<=10; i++){
				System.out.println(i);
				stack.push(i);
			}		
			stackReverse(stack);
			while(!stack.isEmpty()){
				System.out.println(stack.top());
				 stack.pop();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
}
