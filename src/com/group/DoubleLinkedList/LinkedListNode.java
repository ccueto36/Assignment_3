/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.DoubleLinkedList;

/**
 * This class is gonna be used as the node of the Double Linked List. 
 * @author Manuel
 * @param <T> That is the type of element that the node contains
 */
public class LinkedListNode<T> {
    private T data;
    private LinkedListNode next;
    private LinkedListNode previous;

    public LinkedListNode(T item, LinkedListNode previous, LinkedListNode next) {
        this.data = item;
        this.next = next;
        this.previous = previous;
    }

    /**
     * 
     * @return the pinter to the next node 
     */
    public LinkedListNode getNext(){
        return next;
    }

    /**
     * 
     * @return the pointer to the previous node 
     */
    public LinkedListNode getPrevious() {
        return previous;
    }

    /**
     * Sets the value of the next node
     * @param next value to be set
     */
    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    /**
     * Sets the value of the previous node
     * @param previous value to be set
     */
    public void setPrevious(LinkedListNode previous) {
        this.previous = previous;
    }
    
    /**
     * 
     * @return the value of the node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the value of the node
     * @param data new value of the node
     */
    public void setData(T data) {
        this.data = data;
    }
       
}
