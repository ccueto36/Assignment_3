package com.group.graphics;


import com.group.BST.BSTree;
import com.group.BST.BSTreeNode;
import com.group.BST.DSTreeAsArray;
import com.group.BST.DSTreeAsArray.*;
import com.group.Tools.Location;
import com.group.Tools.ArrayLocation;
import java.awt.Color;
import java.awt.Font;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class TreeDrawingPanel extends StdDrawJPanel {

    /***************************************************************************
     * Regular icons
     ***************************************************************************/
    
    /*
    * The bright green icon path
    */
    public static String BRIGHT_GREEN_ICON = "icons\\brightGreen_dot.png";
    
    /*
    * The dark blue icon path
    */
    public static String DARK_BLUE_ICON = "icons\\darkBlue_dot.png";
    
    /*
    * The dark purple icon path
    */
    public static String DARK_PURPLE_ICON = "icons\\darkPurple_dot.png";
    
    /*
    * The light blue icon path
    */
    public static String LIGHT_BLUE_ICON = "icons\\lightBlue_dot.png";
    
    /*
    * The light green icon path
    */
    public static String LIGHT_GREEN_ICON = "icons\\lightGreen_dot.png";
    
    /*
    * The orange icon path
    */
    public static String ORANGE_ICON = "icons\\orange_dot.png";
    
    /*
    * The red icon path
    */
    public static String RED_ICON = "icons\\red_dot.png";
    
    /*
    * The yellow icon path
    */
    public static String YELLOW_ICON = "icons\\yellow_dot.png";
    
    /*
    * The yellow icon pressed path
    */
    public static String YELLOW_ICON_PRESSED = "icons\\yellow_dot_pressed.png";
    
    /*
    * The bright green icon pressed path
    */
    public static String BRIGHT_GREEN_ICON_PRESSED = "icons\\brightGreen_dot_pressed.png";
    
    /*
    * The dark blue icon pressed path
    */
    public static String DARK_BLUE_ICON_PRESSED = "icons\\darkBlue_dot_pressed.png";
    
    /*
    * The dark purple icon pressed path
    */
    public static String DARK_PURPLE_ICON_PRESSED = "icons\\darkPurple_dot_pressed.png";
    
    /*
    * The light blue icon pressed path
    */
    public static String LIGHT_BLUE_ICON_PRESSED = "icons\\lightBlue_dot_pressed.png";
    
    /*
    * The light green icon pressed path
    */
    public static String LIGHT_GREEN_ICON_PRESSED= "icons\\lightGreen_dot_pressed.png";
    
    /*
    * The orange icon pressed path
    */
    public static String ORANGE_ICON_PRESSED = "icons\\orange_dot_pressed.png";
    
    /*
    * The red icon pressed path
    */
    public static String RED_ICON_PRESSED = "icons\\red_dot_pressed.png";
    
    public TreeDrawingPanel() {
        super();
    }
    
    /**
     * 
     * @param location the location in the panel where we want to paint the icon.
     * @param icon the path of the dot to be painted.
     * @throws IllegalArgumentException if the location is not in the scale.
     */
    private void paintDot(Location location, String icon, String value){        
         //if ((location.x >= getMaxX()) || (location.y >= getMaxY())) throw new IllegalArgumentException("The specified location is invalid");
        picture(location.x, location.y, icon ,1,1);
        setPenColor(Color.BLACK);
        Font font = new Font("SansSerif", Font.PLAIN, 25);
        setFont(font);
        text(location.x, location.y, value);
        }
    
    public void draw_node(BSTreeNode node, Location position, double offset) {
        paintDot(position, RED_ICON,Integer.toString((int) node.getData()));
        if (node.getLeft() != null) {
            Location location = new Location(position.x - offset, position.y - 2);
            paintLine(position, location);
            paintDot(position, RED_ICON ,Integer.toString((int)node.getData())); // redraws circle over the line
            draw_node(node.getLeft(), location, offset / 2);
        }
        if (node.getRight() != null) {
            Location location = new Location(position.x + offset, position.y - 2);
            paintLine(position, location);
            paintDot(position, RED_ICON, Integer.toString((int) node.getData())); // redraws circle over the line
            draw_node(node.getRight(), location, offset / 2);
        }
    }
    
    /**
     * Although the StdDrawJPanel class is able to paint lines
     * this implementation also change the color of the Pen
     * @param position
     * @param location 
     */
    public void paintLine(Location position, Location location) {
        setPenColor(Color.BLACK);
        setPenRadius();
        line(position.getX(), position.getY(), location.getX(), location.getY());
    }

    /**
     * This functions paint a tree structure in the JPanel  
     * @param tree the tree to be painted
     */
     public void paintTree(BSTree tree){
         draw_node(tree.getRoot(), new Location(getMaxX()/2.0, getMaxY() -1), WIDTH); //in this line we start 
                                                                                      //the recursive call
     }
}
