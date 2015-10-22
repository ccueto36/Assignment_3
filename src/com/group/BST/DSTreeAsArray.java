package com.group.BST;


import com.group.Tools.Location;
import com.group.Tools.Location;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  This class takes a regular binary search tree and transform it into a 
 * array like representation of the tree. It storages the tree in to arrays:
 * one containing the values and the other containing the connections in the Tree.
 * It also provides a "selectedLocation" property to identify what element its being
 * selected
 * @author Manuel Garcia
 */

public class DSTreeAsArray<T> {
    private T[][] valuesArray;
    private Location[][] connectionsArray;
    private ArrayLocation selectedLocation;

    /**
     * 
     */
    public DSTreeAsArray(BSTree<T> tree) {
        selectedLocation = null; //No element selected
    }

    /**
     * 
     * @return the array containing the connections between nodes. Each array
     * value storages the location of the position he is pointing to. if null, 
     * means that it is not pointing to anyone
     */
    public Location[][] getConnectionsArray() {
        return connectionsArray;
    }

    /**
    * 
    * @return the array containing the tree's values in a array-like form.
    * if null, means that there is no value to be shown
    */
    public T[][] getValuesArray() {
        return valuesArray;
    }

    /**
     * 
     * @return the selected position. if null, means that no value has been 
     * selected
     */
    public ArrayLocation getSelectedLocation() {
        return selectedLocation;
    }

    /**
     * 
     * @param selectedLocation sets the location of the selected value in the 
     * array
     */
    public void setSelectedLocation(ArrayLocation selectedLocation) {
        this.selectedLocation = selectedLocation;
    }
    
    /**
     * Clear the the selectedLocation.
     */
    public void clearSelectedLocation(){
        this.selectedLocation = null;
    }
    
    private class ArrayLocation{
        private Location target;
        private Location caller;

        public ArrayLocation() {
            target = null;
            caller = null;
        }
        
        public Location getTarget(){
            return this.target;
        }
        
        public Location getCaller(){
            return this.caller;
        }
        
        public void setTarget(Location location){
            this.target = location;
        }
        
        public void setCaller(Location location){
            this.caller = location;
        }
        
    }
    
}
