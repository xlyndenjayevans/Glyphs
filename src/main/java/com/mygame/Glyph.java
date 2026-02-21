/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame;

/**
 *
 * @author xlyndenjayevans
 */
public class Glyph {
    
    public byte[][][] layer;
    public byte[] saveLayer;
    
    public short width;
    public short height;
    public short depth;
    
    
    public Glyph(short width, short height, short depth){
    
        this.width = width;
        this.height = height;
        this.depth = depth;
        
        this.layer = new byte[width][height][depth];
        this.saveLayer = new byte [width * height * depth];
        
    }
}
