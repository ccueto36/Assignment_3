package com.group.graphics;


import com.group.BST.BSTreeNode;
import com.group.Tools.Location;
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
    public final static String BRIGHT_GREEN_ICON = "icons\\brightGreen_dot.png";
    
    /*
    * The dark blue icon path
    */
    public final static String DARK_BLUE_ICON = "icons\\darkBlue_dot.png";
    
    /*
    * The dark purple icon path
    */
    public final static String DARK_PURPLE_ICON = "icons\\darkPurple_dot.png";
    
    /*
    * The light blue icon path
    */
    public final static String LIGHT_BLUE_ICON = "icons\\lightBlue_dot.png";
    
    /*
    * The light green icon path
    */
    public final static String LIGHT_GREEN_ICON = "icons\\lightGreen_dot.png";
    
    /*
    * The orange icon path
    */
    public final static String ORANGE_ICON = "icons\\orange_dot.png";
    
    /*
    * The red icon path
    */
    public final static String RED_ICON = "icons\\red_dot.png";
    
    /*
    * The yellow icon path
    */
    public final static String YELLOW_ICON = "icons\\yellow_dot.png";
    
    /*
    * The yellow icon pressed path
    */
    public final static String YELLOW_ICON_PRESSED = "icons\\yellow_dot_pressed.png";
    
    /*
    * The bright green icon pressed path
    */
    public final static String BRIGHT_GREEN_ICON_PRESSED = "icons\\brightGreen_dot_pressed.png";
    
    /*
    * The dark blue icon pressed path
    */
    public final static String DARK_BLUE_ICON_PRESSED = "icons\\darkBlue_dot_pressed.png";
    
    /*
    * The dark purple icon pressed path
    */
    public final static String DARK_PURPLE_ICON_PRESSED = "icons\\darkPurple_dot_pressed.png";
    
    /*
    * The light blue icon pressed path
    */
    public final static String LIGHT_BLUE_ICON_PRESSED = "icons\\lightBlue_dot_pressed.png";
    
    /*
    * The light green icon pressed path
    */
    public final static String LIGHT_GREEN_ICON_PRESSED= "icons\\lightGreen_dot_pressed.png";
    
    /*
    * The orange icon pressed path
    */
    public final static String ORANGE_ICON_PRESSED = "icons\\orange_dot_pressed.png";
    
    /*
    * The red icon pressed path
    */
    public final static String RED_ICON_PRESSED = "icons\\red_dot_pressed.png";
    
    public TreeDrawingPanel() {
        super();
    }
    
    /**
     * 
     * @param location the location in the panel where we want to paint the icon
     * @param icon the path of the dot to be painted
     * @throws IllegalArgumentException if the location is not in the scale
     */
    
    public void paintDot(Location location, String value){        
        //if ((location.x >= getMaxX()) || (location.y >= getMaxY())) throw new IllegalArgumentException("The specified location is invalid");
        picture(location.x, location.y, TreeDrawingPanel.BRIGHT_GREEN_ICON_PRESSED ,1.7,1.7);
        setPenColor(Color.BLACK);
        Font font = new Font("SansSerif", Font.PLAIN, 25);
        setFont(font);
        text(location.x, location.y, value);
    }
    public void paintLine(double x0, double y0, double x1, double y1) {
        setPenColor(Color.BLACK);
        setPenRadius();
        line(x0, y0, x1, y1);
    }
    
     public void draw_node(BSTreeNode node, Location pos, double offset) {
        paintDot(pos, Integer.toString((int) node.getData()));
        if (node.getLeft() != null) {
            Location loc = new Location(pos.x - offset, pos.y - 2);
            paintLine(pos.x, pos.y, loc.x, loc.y);
            paintDot(pos, Integer.toString((int)node.getData())); // redraws circle over the line
            draw_node(node.getLeft(), loc, offset / 2);
        }

        if (node.getRight() != null) {
            Location loc = new Location(pos.x + offset, pos.y - 2);
            paintLine(pos.x, pos.y, loc.x, loc.y);
            paintDot(pos, Integer.toString((int) node.getData())); // redraws circle over the line
            draw_node(node.getRight(), loc, offset / 2);
        }
    }
    
    
}
