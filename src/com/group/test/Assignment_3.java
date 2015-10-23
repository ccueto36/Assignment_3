package com.group.test;


import com.group.BST.BSTree;
import com.group.graphics.TreeDrawingPanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Assignment_3 {

    static JFrame frame;
    static TreeDrawingPanel drawingPanel = new TreeDrawingPanel();;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                init();
            }
        });
        
        BSTree tree = new BSTree();

        
        for (int i = 0; i < 25; i++) {
            tree.add((int) (Math.random() * 10));
        }
        
        drawingPanel.setXscale(0,20);
        drawingPanel.setYscale(0,20);
        drawingPanel.paintTree(tree);
    }

        
    protected static void init(){
        frame = new JFrame();
        
        
        
        //Frame stuff
        frame.setLayout(new BorderLayout());
        frame.add(drawingPanel, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}

