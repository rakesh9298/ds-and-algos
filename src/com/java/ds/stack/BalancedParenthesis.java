package com.java.ds.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BalancedParenthesis {

	static Set<Character> specialOpenChars = new HashSet<Character>(Arrays.asList('{','(','['));
	static Set<Character> specialClosingChars = new HashSet<Character>(Arrays.asList('}',')',']'));
	
	
	
	private static Character getClosing(Character ch){
		switch(ch) {
		case '{' : return '}';
		case '(' : return ')';
		case '[' : return ']';
		};
		return null;
	}
	public BalancedParenthesis() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean checkBalance(String str) throws StackFullException, StackEmptyException{
		StackInterface<Character> stack = new ArrayStackImplementation<Character>(str.length());
	    for(int i = 0; i<str.length();i++){
	    	if(specialOpenChars.contains(str.charAt(i))){
	    		stack.push(str.charAt(i));
	    	}
	    	if(specialClosingChars.contains(str.charAt(i))){
	    		if(stack.isEmpty() || str.charAt(i)!=getClosing(stack.top())){
	    			return false;
	    		}
	    		stack.pop();
	    	}
	    }
	     return stack.isEmpty();
	}

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		args = new String[]{"dfgjsf}sfhks",
				            "dgsf{fsdmhf}fhksjd", 
				            "fgs{sfjg}sbf(bsf)asdas[dasda]dad",
				            "gfjh{skfh{bdsf{dhf}hs}",
				            "ghdkgf}fhs}hgfkjfs}",
				            "hfdks{skjdf{fsdkj{sdf",
				            "fhksf(sdf{hjasdfg}fsdhjf)shfk",
				            "fskhf[jsdgf{dagdus(gjdahf)sjf}dskhfj]skf",
				            "sbfhjs[gfjs{hgdsf(sbgf}hsgf}gshfj]jfs"};
         for(int i=0; i <args.length; i++){
        	 System.out.println(args[i] + " : " + checkBalance(args[i]));
         }
	}

}
