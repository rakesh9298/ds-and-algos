package com.java.ds.stack;

public interface StackInterface<T> {
    public  void  push(T element) throws StackFullException;
    public void  pop() throws StackEmptyException;
    public  T top()  throws StackEmptyException;
    
    public boolean isEmpty();
    public int size();
}
