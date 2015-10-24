/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.Tools;

/**
 *
 * @author admin
 */
public class ArrayLocation{
        private Location[] target;
        private Location caller;

        public ArrayLocation() {
            target = null;
            caller = null;
        }

    public ArrayLocation(Location[] target, Location caller) {
        this.target = target;
        this.caller = caller;
    }
        
        
        
        public Location[] getTarget(){
            return this.target;
        }
        
        public Location getCaller(){
            return this.caller;
        }
        
        public void setTarget(Location[] location) //When is only one location
        {
            this.target = location;
        }
        
        public void setCaller(Location location){
            this.caller = location;
        }
        
    } //change to private! 
