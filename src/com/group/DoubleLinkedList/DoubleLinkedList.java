/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.DoubleLinkedList;

/**
 *
 * @author admin
 */
public class DoubleLinkedList<T> {
    private LinkedListNode<T> front;
    private LinkedListNode<T> back;
    private int size;

    public DoubleLinkedList() {
        this.front = new LinkedListNode<T>(null,null,null);
        this.back = new LinkedListNode<>(null,null,front);
        this.front.setPrevious(back);
        this.size = 0;
    }
    
    /**
     * Inserts elements in the back of the list.
     * 
     * @param value Is the Object to be inserted
     */
    public void addBack(T value) { //This insertion occurs in O(1) --> it is constant.
        LinkedListNode<T> newNode = new LinkedListNode<T>(value, back, back.getNext());
        back.setNext(newNode);
        newNode.getNext().setPrevious(newNode);
        size++;
    }
    
    /**
     * Inserts elements in the front of the List.
     * 
     * @param value Is the Object to be inserted
     */
    public void addFront(T value) {  //This insertion occurs in O(1) --> it is constant.
        LinkedListNode<T> newNode = new LinkedListNode<T>(value, front.getPrevious(), front);
        front.setPrevious(newNode);
        newNode.getPrevious().setNext(newNode);
        size++;
    }
     /**
     * Removes the element closest to the back of the List.
     * 
     * @return a copy of the element stored in the removed Node
     */
    public T removeBack() {  //This removing occurs in O(1) --> it is constant.
        LinkedListNode<T> targetNode = back.getNext();
        if (targetNode == front) {
            return null;
        } else {
            T value = targetNode.getData();
            back.setNext(targetNode.getNext());
            targetNode.getNext().setPrevious(back);
            size--;
            return value;
        }

    }
    
    /**
     * Removes the element closest to the front of the List.
     * 
     * @return a copy of the value stored in the removed Node
     */
    public T removeFront() {  //This removing occurs in O(1) --> it is constant.
        LinkedListNode<T> targetNode = front.getPrevious();
        if (targetNode == back) {
            return null;
        } else {
            T value = targetNode.getData();
            front.setPrevious(targetNode.getPrevious());
            targetNode.getPrevious().setNext(front);
            size--;
            return value;
        }
    }
    
    /**
     * 
     * @return whether the List is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
     /**
     * 
     * @return the number of elements stored in the List.
     */
    public int size(){
        return this.size;
    }
    
    /**
     * 
     * @return The Back Node
     */
    public LinkedListNode<T> getBack(){
        return back;
    }
    
    /**
     * 
     * @return the Front Node
     */
    public LinkedListNode<T> getFront(){
        return front;
    }
    
}
