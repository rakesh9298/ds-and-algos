package com.java.ds.stack;

import java.util.Currency;

import com.java.mock.Node;

public class IterativeTreeTraversal {

	public IterativeTreeTraversal() {
		// TODO Auto-generated constructor stub
	}
	
	private static void traversePreorder1(Node root) throws StackFullException, StackEmptyException{
		StackInterface<Node> stack = new GrowingStackGrowthStrategy<Node>(10);
		Node currentNode = null;
		stack.push(root);
		while(!stack.isEmpty()){
				currentNode = stack.top();
				stack.pop();
				
			System.out.println(currentNode.getValue());
			if(currentNode.getRight()!=null){
				stack.push(currentNode.getRight());
			}
			if(currentNode.getLeft()!=null){
				stack.push(currentNode.getLeft());
			}
			currentNode = null;
		}
	}
	
	private static void traversePreorder2(Node root) throws StackFullException, StackEmptyException{
		StackInterface<Node> stack = new GrowingStackGrowthStrategy<Node>(10);
		Node currentNode = root;
		while(!stack.isEmpty() || currentNode!=null){
		     if(currentNode==null){
		    	 currentNode = stack.top().getRight();
		    	 stack.pop();
		    	 continue;		    	 
		     }
		    System.out.println(currentNode.getValue()); 
		    stack.push(currentNode);
		    currentNode = currentNode.left;
		}
	}
	
	private static void traverseInorder1(Node root) throws StackFullException, StackEmptyException{
		StackInterface<Node> stack = new GrowingStackGrowthStrategy<Node>(10);
		Node currentNode = root.getLeft();
		stack.push(root);
		while(!stack.isEmpty()){
			if(currentNode==null){
				currentNode = stack.top().getRight();
				System.out.println(stack.top().getValue());
				stack.pop();
			}
			if(currentNode.getLeft()!=null){
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
				continue;
			} else {
				System.out.println(currentNode.getValue());
			}
			
			if(currentNode.getRight()!=null){
				stack.push(currentNode);
				currentNode = currentNode.getRight();
				continue;
			} else{
				currentNode = null;
			}
		}
	}
	
	private static void traverseInorder2(Node root) throws StackFullException, StackEmptyException{
		StackInterface<Node> stack = new GrowingStackGrowthStrategy<Node>(10);
		Node currentNode = root;
		while(!stack.isEmpty() || currentNode!=null){
			if(currentNode==null){
				currentNode = stack.top().getRight();
				System.out.println(stack.top().getValue());
				stack.pop();
				continue;
			}    
			
			   stack.push(currentNode);
			   currentNode = currentNode.left;
		}
	}
	
	
	private static void postOrderTraversal1(Node root) throws StackEmptyException, StackFullException{
		StackInterface<Node> stack = new GrowingStackGrowthStrategy<Node>(10);
		StackInterface<Node> visitedStack = new GrowingStackGrowthStrategy<Node>(10);
		Node current = root;
		boolean fromStack = false;
		while(current!=null || !stack.isEmpty()){
			if(current==null){
				current = stack.top();
				fromStack = true;
			}
			if(fromStack){
				if(!visitedStack.isEmpty() && current.getValue()==visitedStack.top().getValue()){
					System.out.println(current.getValue());
					visitedStack.pop();
					stack.pop();
					current = null;
					continue;
				}
					current = stack.top().right;
					visitedStack.push(stack.top());
					fromStack = false;
			} 
			if(!fromStack){
				if(current!=null){
					stack.push(current);
					current = current.left;
				}
			}
		}
	}
	
	private static void postOrderTraversal1(Node root) throws StackEmptyException, StackFullException{
		StackInterface<Node> stack = new GrowingStackGrowthStrategy<Node>(10);
		StackInterface<Node> visitedStack = new GrowingStackGrowthStrategy<Node>(10);
		Node current = root;
		boolean fromStack = false;
		while(current!=null || !stack.isEmpty()){
			if(current==null){
				current = stack.top();
				fromStack = true;
			}
			if(fromStack){
				if(!visitedStack.isEmpty() && current.getValue()==visitedStack.top().getValue()){
					System.out.println(current.getValue());
					visitedStack.pop();
					stack.pop();
					current = null;
					continue;
				}
					current = stack.top().right;
					visitedStack.push(stack.top());
					fromStack = false;
			} 
			if(!fromStack){
				if(current!=null){
					stack.push(current);
					current = current.left;
				}
			}
		}
	}
	
	private static void postOrderTraversal1(Node root) throws StackEmptyException, StackFullException{
		StackInterface<Node> stack = new GrowingStackGrowthStrategy<Node>(10);
		Node current = root;
		while(current!=null || !stack.isEmpty()){
			if(current==null){
				current = stack.top();
				System.out.println(current.getValue());
			}
			
			if(!stack.isEmpty() && stack.top().right==current){
				System.out.println(current.getValue());
				current = stack.top();
				stack.pop();
			} else {
				Node temp = stack.top();
				stack.push(current);
				current = stack.top();
				
			}
		}
	}
	

	public static void main(String[] args) {
		 Node rootNode =new Node(40);  
		  Node node20=new Node(20);  
		  Node node10=new Node(10);  
		  Node node30=new Node(30);  
		  Node node60=new Node(60);  
		  Node node50=new Node(50);  
		  Node node70=new Node(70);  
		    
		  rootNode.left=node20;  
		  rootNode.right=node60;  
		    
		  node20.left=node10;  
		  node20.right=node30;  
		    
		  node60.left=node50;  
		  node60.right=node70;  
		  
		  try {
			postOrderTraversal(rootNode);
		} catch (StackFullException | StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

