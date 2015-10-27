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

    static JFrame jframe;
    static GUIJFrame frame;
    static TreeDrawingPanel drawingPanel = new TreeDrawingPanel();;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
        BST tree = new BST();

        
      
       for(int i = 1; i < 17; i++)
       {
          int random = (int)(Math.random() * 100);
          tree.insert(random);
           
       }
         
         
//        drawingPanel.clear(Color.BLUE); 
//        drawingPanel.setXscale(0,20);
//        drawingPanel.setYscale(0,20);
//        drawingPanel.paintTree(tree);
        
            SwingUtilities.invokeLater(() -> {
                //init();
                frame = new GUIJFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUIJFrame.drawPanel.paintTree(tree);
        });
        
        
        
        
    }

        
    protected static void init(){
        jframe = new JFrame();
        
        
       
        //Frame stuff
        jframe.setLayout(new BorderLayout());
        jframe.add(drawingPanel, BorderLayout.CENTER);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
       
    }
}

