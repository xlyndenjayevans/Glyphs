/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame;

import com.jme3.input.MouseInput;
import com.jme3.input.RawInputListener;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;

/**
 *
 * @author xlyndenjayevans
 */
public class OmniInputListener implements RawInputListener {

    public boolean isLeftMouseDown;
    
    @Override
    public void beginInput() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void endInput() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onJoyAxisEvent(JoyAxisEvent jae) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onJoyButtonEvent(JoyButtonEvent jbe) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onMouseMotionEvent(MouseMotionEvent mme) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
        if (isLeftMouseDown){
        
            System.out.println(mme.getX() + " " + mme.getY());
                    
        }
    }

   @Override
    public void onMouseButtonEvent(MouseButtonEvent evt) {
        // evt.getButtonIndex() -> 0 is Left, 1 is Right, 2 is Middle
        // evt.isPressed() -> true if button went down, false if it went up
        
        if (evt.getButtonIndex() == MouseInput.BUTTON_LEFT) { // Left Mouse Button
            if (evt.isPressed()) {
                isLeftMouseDown = true;
                System.out.println("Mouse Pressed at: " + evt.getX() + ", " + evt.getY());
            } else {
                isLeftMouseDown = false;
                System.out.println("Mouse Released!");
            }
        }
    }

    @Override
    public void onKeyEvent(KeyInputEvent kie) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onTouchEvent(TouchEvent te) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
