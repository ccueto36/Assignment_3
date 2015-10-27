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
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int count;

    public DoubleLinkedList() {
        this.head = new LinkedListNode<T>(null,null,null);
        this.tail = new LinkedListNode<>(null,null,head);
        this.head.setPrevious(tail);
        this.count = 0;
    }
    
    
}
