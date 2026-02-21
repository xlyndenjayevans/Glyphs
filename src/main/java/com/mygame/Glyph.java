/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import com.jme3.texture.Texture2D;

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
    
    
   public Texture2D glyph(){
   
       return null;
   }
   
   public void drawRectangle(Vector2f start, Vector2f end, Vector4f color){
   
   }
   
   public void drawCircle(Vector2f point, short radius, Vector4f color){
   
   }
}
