package com.java.ds.stack;

public class PreOrderIdentifier {

	public PreOrderIdentifier() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean verifyPreOrderTraversal(Integer[] list) throws StackFullException, StackEmptyException{
	    return rescursive(list, 0,list.length);
	}

	private static boolean rescursive(Integer[] list, int min, int max) {
		System.out.println(min +" "+ max);
		if(min==max || min+1==max){
			return true;
		} 
		
	    int leftMax = 0;
		for(int i=min+1; i<max; i++){
			if(list[i]>list[min]){
				leftMax=i;
				break;
			}
		}
		
		for(int i = leftMax+1; i<max; i++){
			if(list[i]<list[leftMax]){
				return false;
			}
		}
		boolean result = rescursive(list, min+1, leftMax);
		if(!result){
			return false;
		} else	return rescursive(list, leftMax+1, max);
	}

	public static void main(String[] args) {
		try {
			System.out.println(verifyPreOrderTraversalUsingStack(new Integer[]{2, 4, 1}));
		} catch (StackFullException | StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean verifyPreOrderTraversalUsingStack(Integer[] list) throws StackFullException, StackEmptyException {
		StackInterface<Integer> stack = new ArrayStackImplementation<Integer>(list.length);
		stack.push(list[list.length-1]);
		Integer parentPointer = 0;
		Integer maxPointer = list.length;
		do{
			parentPointer = stack.top();
			minPointer = parentPointer+1;
			stack.pop();
			if(stack.isEmpty()){
				maxPointer = list.length;
			} else{
				maxPointer = stack.top();
			}
			
			for(int i=minPointer; i<maxPointer; i++){
                  if(list[i]>list[minPointer]){
                	  stack
                  }
			}
			
		}while(!stack.isEmpty());
		return null;
	}

}
