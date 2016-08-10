package com.java.ds.stack;

public class SpecialStack{
    
	private StackInterface<Integer> actualStack ;
	private StackInterface<Integer> auxilaryStack ;
	
    public SpecialStack(int size) {
	   actualStack = new ArrayStackImplementation<Integer>(size);
	   auxilaryStack = new ArrayStackImplementation<Integer>(size);
	}
    
	public void push(Integer element) throws StackFullException, StackEmptyException {
		 if(auxilaryStack.isEmpty() || element < auxilaryStack.top()){
			 auxilaryStack.push(element);
		 } 
		 actualStack.push(element);
	}

	public void pop() throws StackEmptyException {
	    if(auxilaryStack.top()==actualStack.top()){
	    	auxilaryStack.pop();
	    }
	    actualStack.pop();
	}

	public Integer top() throws StackEmptyException {
		return actualStack.top();
	}

	public boolean isEmpty() {
		return actualStack.isEmpty();
	}

	public int size() {
		return actualStack.size();
	}
	
	public int getMin() throws StackEmptyException {
		return auxilaryStack.top();
	}
	
	public static void main(String[] args){
		SpecialStack stack = new SpecialStack(10);
		try {
			stack.push(25);
			stack.push(24);
			stack.push(23);
			stack.push(22);
			stack.push(21);
		} catch (StackFullException | StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(!stack.isEmpty()){
				System.out.println("popped "+ stack.top());
				stack.pop();
				System.out.println("min value of stack "+ stack.getMin());
			}
			
		} catch (StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
