package com.java.ds.stack;

public class NextGreaterElement {

    public static Integer[] nextGreaterElements(Integer[] list) throws StackFullException, StackEmptyException{
    	Integer[] results = new Integer[list.length];
    	StackInterface<Integer> stack = new ArrayStackImplementation<Integer>(list.length);
    	stack.push(0);
    	for(int i=1; i < list.length; i++){
    		while(!stack.isEmpty()){
	    		if(list[i]>list[stack.top()]){
	    			results[stack.top()]=list[i];
	    			stack.pop();
	    		} else{
	    			break;
	    		}
	     	}   
    		stack.push(i);
    	}
    	while(!stack.isEmpty()){
    		results[stack.top()] = -1;
    		stack.pop();
    	}
    	return results;
    }
    
    public static void nextGreaterElementsReverseOrder(Integer[] list) throws StackFullException, StackEmptyException{
        StackInterface<Integer> stack = new ArrayStackImplementation<Integer>(list.length);
        for(int i= list.length-1; i>=0; i--){
        	Integer result = -1;
        		while(!stack.isEmpty()){
        			if(list[i]>stack.top()){
        				 stack.pop();
        			}else{
        				 result =stack.top();
        				 break;
        			}
        		}
        	stack.push(list[i]);
        	 System.out.println("next greater for "+ list[i] + " is "+ result);
        }
    }
    
    
	public static void main(String[] args) {
		
	     Integer[] list = new Integer[]{5,4,3,2,1};
	     Integer[] results;
		try {
			results = nextGreaterElements(list);		
	     for(int i = 0; i<results.length; i++){
	    	 System.out.println("next greater for "+ list[i] + " is "+ results[i]);
	     }
		} catch (StackFullException | StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			nextGreaterElementsReverseOrder(list);
		} catch (StackFullException | StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
