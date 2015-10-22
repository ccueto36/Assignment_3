package com.group.test;

import com.group.graphics.TreeDrawingPanel;
import com.group.Tools.Location;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import com.group.BST.BSTree;
import com.group.BST.BSTreeNode;

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

    public static void draw_node(TreeDrawingPanel t, BSTreeNode n, Location pos, double o) {
        t.paintDot(pos, Integer.toString((int) n.getData()));

        if (n.getLeft() != null) {
            Location l = new Location(pos.x - o, pos.y - 2);
            t.paintLine(pos.x, pos.y, l.x, l.y);
            t.paintDot(pos, Integer.toString((int) n.getData())); // redraws circle over the line
            draw_node(t, n.getLeft(), l, o / 2);
        }

        if (n.getRight() != null) {
            Location l = new Location(pos.x + o, pos.y - 2);
            t.paintLine(pos.x, pos.y, l.x, l.y);
            t.paintDot(pos, Integer.toString((int) n.getData())); // redraws circle over the line
            draw_node(t, n.getRight(), l, o / 2);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeDrawingPanel stdDrawJPanel = new TreeDrawingPanel();
        JFrame frame = new JFrame();

        stdDrawJPanel.clear(Color.BLUE);
        stdDrawJPanel.clear(Color.WHITE);

        frame.setResizable(true);

        frame.add(stdDrawJPanel, BorderLayout.CENTER);

        //frame.setSize(1000, 1000);
        frame.pack();
        frame.setVisible(true);

//        frame.setLayout(new GridBagLayout());
//
//        GridBagConstraints constrains = new GridBagConstraints();
//        constrains.gridx = 0;
//        constrains.gridy = 0;
//
        double screenWidth = 30.0;
        double screenHeight = 30.0;
        stdDrawJPanel.setXscale(0, screenWidth);
        stdDrawJPanel.setYscale(0, screenHeight);
        stdDrawJPanel.setSize(1000, 1000);

        BSTree tree = new BSTree();

        tree.add(50);
        for (int i = 0; i < 17; i++) {
            tree.add((int) (Math.random() * 100));
        }
        draw_node(stdDrawJPanel, tree.root, new Location(screenWidth / 2.0, screenHeight - 1.0), screenWidth / 4.0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
       //stdDrawJPanel.picture(5, 9, TreeDrawingPanel.BRIGHT_GREEN_ICON,0.9,0.9);
    //stdDrawJPanel.picture(5.5, 5.5, TreeDrawingPanel.DARK_PURPLE_ICON,0.9,0.9);
    //stdDrawJPanel.picture(6.5, 6.5, TreeDrawingPanel.LIGHT_GREEN_ICON ,0.9,0.9);
    //stdDrawJPanel.setPenColor(Color.WHITE);
    //stdDrawJPanel.text(5.5, 5.5, "25");
    //stdDrawJPanel.setPenColor(Color.BLACK);
    //stdDrawJPanel.setPenRadius();
    //stdDrawJPanel.line(5.8,5.8, 6.2, 6.2);

       //stdDrawJPanel.paintDot(new Location(10, 10), "5");
    //stdDrawJPanel.paintDot(new Location(10, 19), "7");
    //stdDrawJPanel.paintDot(new Location(6, 16), "8");
//
//        frame.add(stdDrawJPanel, constrains);
//        frame.setVisible(true);
//        frame.setSize(500, 500);
    /**
     * *************************************************************************
     *
     **************************************************************************
     */
}
