/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.Slides;

import com.group.BST.BST;

/**
 *
 * @author admin
 */
public class Slide {
    
    //Text to be shown
    private String textToShow;
    
    //Correct answer. ONLY ONE
    private int answer;
    
    //Tree to be shown
    private BST<Integer> tree;
    
    //If answer controls are gonna be visible
    private Boolean showControls;

    public Slide(String textToShow, int answer, BST<Integer> tree, Boolean showControls) {
        this.textToShow = textToShow;
        this.answer = answer;
        this.tree = tree;
        this.showControls = showControls;
    }
    
    
    
}
