package com.group.test;


import com.group.graphics.TreeDrawingPanel;
import com.group.Tools.Location;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeDrawingPanel stdDrawJPanel = new TreeDrawingPanel();
        JFrame frame = new JFrame();
        
        stdDrawJPanel.clear(Color.BLUE);
        frame.add(stdDrawJPanel,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

//        frame.setLayout(new GridBagLayout());
//
//        GridBagConstraints constrains = new GridBagConstraints();
//        constrains.gridx = 0;
//        constrains.gridy = 0;
//
        stdDrawJPanel.setYscale(0, 10);
        stdDrawJPanel.setXscale(0, 10);
        
        
        stdDrawJPanel.clear(Color.WHITE);
        stdDrawJPanel.setPenRadius(0.05);
        stdDrawJPanel.setPenColor(stdDrawJPanel.BLUE);
        stdDrawJPanel.point(0.5, 0.5);
        stdDrawJPanel.setPenColor(stdDrawJPanel.MAGENTA);
        stdDrawJPanel.line(0.2, 0.2, 0.8, 0.2);
       
       stdDrawJPanel.picture(5.5, 5.5, TreeDrawingPanel.DARK_PURPLE_ICON,0.9,0.9);
       stdDrawJPanel.picture(6.5, 6.5, TreeDrawingPanel.LIGHT_GREEN_ICON ,0.9,0.9);
       stdDrawJPanel.setPenColor(Color.WHITE);
       stdDrawJPanel.text(5.5, 5.5, "25");
       stdDrawJPanel.setPenColor(Color.BLACK);
       stdDrawJPanel.setPenRadius();
       stdDrawJPanel.line(5.8,5.8, 6.2, 6.2);
//
//        frame.add(stdDrawJPanel, constrains);
//        frame.setVisible(true);
//        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * *************************************************************************
     *
     **************************************************************************
     */
}
