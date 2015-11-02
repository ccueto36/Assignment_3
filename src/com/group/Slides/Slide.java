/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.Slides;

import com.group.BST.BST;
import com.group.Tools.Answer;

/**
 * This class is the core of the tutorial. This class storage each slide to be 
 * shown and the correct answer in case it has one. It storages the text for
 * each slide, the correct answer, whether the controls for answering are gonna
 * be visible or not and also the tree that is gonna be painted.
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
    private Boolean showAllControls;
    
    //if boolean answer are gonna be available
     private Boolean showBooleanControls;
   
    public Slide(String textToShow, int answer, BST<Integer> tree, Boolean showControls, Boolean showBooleanControls) {
        this.textToShow = textToShow;
        this.answer = answer;
        this.tree = tree;
        this.showAllControls = showControls;
        this.showBooleanControls = showBooleanControls;
    }
    
    public Slide(){
        this.textToShow = "";
        this.answer = Answer.NONE;
        this.tree = null;
        this.showAllControls = false;
        this.showBooleanControls = false;
    }

    /**
     * 
     * @return the right answer for this slide
     */
    public int getAnswer() {
        return answer;
    }

    /**
     * 
     * @return the tree that is gonna be shown for this slide
     */
    public BST<Integer> getTree() {
        return tree;
    }
    
    /**
     * 
     * @return whether the answer controls are gonna be shown or not
     */
    public Boolean getShowAllControls() {
        return showAllControls;
    }

    /**
     * 
     * @return whether the Boolean controls are gonna be shown or not
     */
    public Boolean getShowBooleanControls() {
        return showBooleanControls;
    }

    
    
    /**
     * 
     * @return the text that is gonna be displayed
     */
    public String getTextToShow() {
        return textToShow;
    }

    /**
     * 
     * @param answer the correct answer for this slide 
     */
    public void setAnswer(int answer) {
        this.answer = answer;
    }

    /**
     * 
     * @param showControls  whether the answer controls are gonna be visible or not
     */
    public void setShowAllControls(Boolean showControls) {
        this.showAllControls = showControls;
    }

    /**
     * 
     * @param showControls  whether the Boolean controls are gonna be visible or not
     */
    public void setShowBooleanControls(Boolean showBooleanControls) {
        this.showBooleanControls = showBooleanControls;
    }

    
    /**
     * 
     * @param textToShow text that is gonna be shown
     */
    public void setTextToShow(String textToShow) {
        this.textToShow = textToShow;
    }

    /**
     * 
     * @param tree tree that is gonna be drawn
     */
    public void setTree(BST<Integer> tree) {
        this.tree = tree;
    }
}
