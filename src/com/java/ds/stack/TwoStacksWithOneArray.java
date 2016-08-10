package com.java.ds.stack;

public class TwoStacksWithOneArray<T> {
    private static int leftPointer;
    private static int rightPointer;
    private static Object[] array;
	public TwoStacksWithOneArray() {
		array = new Object[10];
		leftPointer  = -1;
		rightPointer = 10;
	}
	
	public static <T> void push1(T element) {
		if(leftPointer+1 == rightPointer){
			array = resize(array);
		}
		leftPointer++;
		array[leftPointer] = element;
	}
	
    private static Object[] resize(Object[] array2) {
		Object[] newArr = new Object[array2.length*2];
		for(int i=0; i<=leftPointer; i++){
			newArr[i] = array2[i];
		}
		
		for(int j= newArr.length-1, i= array2.length-1; i>=rightPointer; j--,i--){
			newArr[j] = array2[i];
		}
		
		rightPointer = newArr.length - (array2.length-rightPointer);
		return newArr;
	}

	public static <T> void push2(T element) {
		if(rightPointer-1 == leftPointer){
			array = resize(array);
		}
		rightPointer--;
		array[rightPointer] = element;
	}
    
    public static void pop1() throws StackEmptyException {
		if(leftPointer==-1){
			throw new StackEmptyException("Stack is empty");
		}
		array[leftPointer] = null;
		leftPointer--;
   	}
    
    public static void pop2() throws StackEmptyException {
		if(rightPointer==array.length){
			throw new StackEmptyException("Stack is empty");
		}
		array[rightPointer] = null;
		rightPointer++;
   	}
    
    public static <T> T top1() throws StackEmptyException {
    	if(leftPointer==-1){
			throw new StackEmptyException("Stack is empty");
		}
    	return (T)array[leftPointer];
   	}
    
    public static <T> T top2() throws StackEmptyException {
    	if(rightPointer==array.length){
			throw new StackEmptyException("Stack is empty");
		}
    	return (T)array[rightPointer];
   	}


	public static void main(String[] args) {
		TwoStacksWithOneArray<String> stacks = new TwoStacksWithOneArray<String>();
		
		stacks.push1("a");
		stacks.push1("b");
		stacks.push1("c");
		stacks.push2("1");
		stacks.push2("2");
		stacks.push2("3");
		stacks.push2("4");
		stacks.push2("5");
		stacks.push2("6");
		stacks.push2("7");
		
		try {
			System.out.println("Stack 1 top :" + stacks.top1());
			System.out.println("Stack 2 top :" + stacks.top2());
		} catch (StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stacks.push1("d");
		stacks.push1("e");
		stacks.push2("8");
		stacks.push2("9");
		
		try {
			System.out.println("Stack 1 top :" + stacks.top1());
			System.out.println("Stack 2 top :" + stacks.top2());
		} catch (StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stacks.pop1();
			stacks.pop1();
			stacks.pop2();
			stacks.pop2();
			System.out.println("Stack 1 top :" + stacks.top1());
			System.out.println("Stack 2 top :" + stacks.top2());
		} catch (StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
