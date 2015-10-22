package com.group.graphics;


import com.group.BST.BSTree;
import com.group.BST.DSTreeAsArray;
import com.group.BST.DSTreeAsArray.*;
import com.group.Tools.Location;
import com.group.Tools.ArrayLocation;
import java.awt.Color;




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
          // if ((location.getX() >= getMaxX()) || (location.getY() >= getMaxY())) throw new IllegalArgumentException("The specified location is invalid");
           
           picture(location.getX() + 0.5, location.getY() + 0.5, icon ,0.9,0.9);
           
           setPenColor(Color.WHITE);
           text(location.getX() + 0.5, location.getY() + 0.5, value);
        }
    
//    public void paintTree(BSTree tree){
     public void paintTree(){
        DSTreeAsArray treeAsArray = new DSTreeAsArray(new BSTree<Integer>());
        
        /**
         * testing purposes
         */
        Object values[][] = new Object[2][3];
        values[0][0] = null;
        values[0][1] = 4;
        values[0][2] = null;
        
        values[1][0] = 6;
        values[1][1] = null;
        values[1][2] = 8;
        
        treeAsArray.setValuesArray(values);
        
        ArrayLocation valuess[][] = new ArrayLocation[3][2];
        
        values[0][0] = null;
        values[0][1] = new ArrayLocation(new Location[]{new Location(1,0), new Location(1,2)},null);
        values[0][2] = null;
        
        values[1][0] = new ArrayLocation(null,new Location(0, 1));
        values[1][1] = null;
        values[1][2] = new ArrayLocation(null,new Location(0, 1));
        
        treeAsArray.setConnectionsArray(valuess);
        /***********************************************************************
         * final insertion value test 
         ***********************************************************************/
        if((treeAsArray.getWitdh() >= 16)){
            setXscale(0, treeAsArray.getWitdh());
            setYscale(0, treeAsArray.getHeight());
        }
        else
        {
            setXscale(0, 15);
            setYscale(0, 15);
        }
        int b = 0;
        for (int i = 0; i < treeAsArray.getWitdh(); i++) {
            for (int j = 0; j < treeAsArray.getHeight(); j++) {
                if(treeAsArray.getValuesArray()[i][j] != null){
                    paintDot(new Location(j, i), ORANGE_ICON, Integer.toString(b));
                    b++;
                }
                    
            }
        }
        
//         paintDot(new Location(0,0), RED_ICON, "1");
//         paintDot(new Location(1,0), DARK_BLUE_ICON, "2");
//         paintDot(new Location(2,0), YELLOW_ICON, "3");
        
        
    }
}
