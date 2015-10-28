package com.group.test;


import com.group.BST.BST;
import com.group.graphics.TreeDrawingPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import com.group.graphics.GUIJFrame;

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

    static GUIJFrame frame;
    static TreeDrawingPanel drawingPanel = new TreeDrawingPanel();;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //init();
                frame = new GUIJFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                
            }
        });
        
        BST tree = new BST();

        
       tree.insert(50);
       
         for (int i = 0; i < 100; i++) {
            tree.insert((int) (Math.random() * 100));
            
        }
        
//       tree.insert(25);
//       tree.insert(15);
//       tree.insert(30);
//       tree.insert(75);
//       tree.insert(65);
//       tree.insert(85);
       drawingPanel.clear(Color.BLUE); 
        drawingPanel.setXscale(0,30);
        drawingPanel.setYscale(0,30);
        drawingPanel.paintTree(tree);
    }

        
//    protected static void init(){
//        frame = new JFrame();
//        
//        
//        
//        //Frame stuff
//        frame.setLayout(new BorderLayout());
//        frame.add(drawingPanel, BorderLayout.CENTER);
//        frame.setResizable(false);
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        
//    }
}

