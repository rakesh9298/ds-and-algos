package com.java.ds.stack;

public class StockSpanService {

	public StockSpanService() {
		// TODO Auto-generated constructor stub
	}
	
	public void calculateStockSpansByStack(Integer[] stocks) throws StackEmptyException, StackFullException{
		 StackInterface<Integer> stack = new ArrayStackImplementation<Integer>(stocks.length);
		 
		 for(int i=0; i<stocks.length; i++){
			 int span = 1;
			 while(!stack.isEmpty()){
				 if(stocks[stack.top()]>=stocks[i]){
				    break;
				 }
				 stack.pop();
			 }
			 if(stack.isEmpty()){
				 span = i+1;
			 } else{
				 span = i-stack.top();
			 }
			 stack.push(i);
			 System.out.println("Span of "+ stocks[i] + " is "+ span);			 
		 }
	}
	
	public void calculateStockSpans(Integer[] stocks){
		for(int i =0; i<stocks.length; i++){
			int span = 1;
			for(int j = i-1; j>=0; j--){
				if(stocks[i]>stocks[j]){
					span++;
				} else{
					break;
				}				
			}
		System.out.println("Span of "+ stocks[i] + " is "+ span);		
		}
	}
	
	public static void main(String[] args){
		StockSpanService stockSpanService = new StockSpanService();
		/*try {
			System.out.println("1,2,3,4,5,6,7,8");
			stockSpanService.calculateStockSpansByStack(new Integer[]{1,2,3,4,5,6,7,8});
			System.out.println("8,7,6,5,4,3,2,1");
			stockSpanService.calculateStockSpansByStack(new Integer[]{8,7,6,5,4,3,2,1});
			System.out.println("7,9,21,3,4,5,6,35,1");
			stockSpanService.calculateStockSpansByStack(new Integer[]{7,9,21,3,4,5,6,35,1});
		} catch (StackEmptyException | StackFullException e) {
			e.printStackTrace();
		}*/
		
			System.out.println("1,2,3,4,5,6,7,8");
			stockSpanService.calculateStockSpans(new Integer[]{1,2,3,4,5,6,7,8});
			System.out.println("8,7,6,5,4,3,2,1");
			stockSpanService.calculateStockSpans(new Integer[]{8,7,6,5,4,3,2,1});
			System.out.println("7,9,21,3,4,5,6,35,1");
			stockSpanService.calculateStockSpans(new Integer[]{7,9,21,3,4,5,6,35,1});
		
	}

}
