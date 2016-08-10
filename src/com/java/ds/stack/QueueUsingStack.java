package com.java.ds.stack;

public class QueueUsingStack<T> {
   private StackInterface<T> pushStack;
   private StackInterface<T> popStack;
   private T front;
   private int size;
   public QueueUsingStack(int size) {
	   pushStack = new ArrayStackImplementation<T>(size);
	   popStack = new ArrayStackImplementation<T>(size);
	   this.size = size;
   }
   
   public void enQueue(T i) throws Exception{
	   if(pushStack.size()==size){
		   throw new Exception("queue full");
	   }
	   if(pushStack.size()==0){
		   front= i;
	   }
	   pushStack.push(i);
   }
   
   public void dQueue() throws Exception{
	   if(pushStack.isEmpty()){
		   throw new Exception("queue empty");
	   }
	   if(pushStack.size()==1){
		   pushStack.pop();
		   front = null;
		   return;
	   }
	   while(!pushStack.isEmpty()){
		   popStack.push(pushStack.top());
		   pushStack.pop();
	   }
	   popStack.pop();
	   front = popStack.top();
	   while(!popStack.isEmpty()){
		   pushStack.push(popStack.top());
		   popStack.pop();
	   }	
   }
   
   public T front() throws Exception{
	   if(front==null){
		   throw new Exception("queue empty");
	   }
	   return front;	   
   }
   
   public boolean isEmpty(){
	   return pushStack.isEmpty();
   }
	public static void main(String[] args) throws Exception {
		QueueUsingStack<Integer> queue = new QueueUsingStack<Integer>(5);
		queue.enQueue(5);
		queue.enQueue(7);
		queue.enQueue(9);
		queue.enQueue(11);
		queue.enQueue(13);
		
		try{
			queue.enQueue(15);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(queue.front());
		queue.dQueue();
		System.out.println(queue.front());
		queue.dQueue();
		System.out.println(queue.front());
		queue.dQueue();
		System.out.println(queue.front());
		queue.dQueue();
		System.out.println(queue.front());
		queue.dQueue();
		try{
			System.out.println(queue.front());
		} catch(Exception e){
			e.printStackTrace();
		}		

		try{
			queue.dQueue();
		} catch(Exception e){
			e.printStackTrace();
		}		
	}

}
