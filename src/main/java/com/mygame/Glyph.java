/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import com.jme3.texture.Image;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture2D;
import com.jme3.texture.image.ColorSpace;
import com.jme3.util.BufferUtils;
import java.nio.ByteBuffer;

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
    
        
       // 1. Wrap the byte array in a ByteBuffer
ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * depth);
  
System.out.println(layer[128][128][0]);
System.out.println(layer[128][128][1]);
System.out.println(layer[128][128][2]);
System.out.println(layer[128][128][3]);


    for (short y = 0; y < height; y++){
    for (short x = 0; x < width; x++){
        for (short z = 0; z < depth; z++){
       
          
            buffer.put(layer[x][y][z]);
        }
    }
}
buffer.flip();

// 2. Create the Image object
// Specify width, height, and the Format (e.g., Luminance, RGB8, or RGBA8)
Image image = new Image(Image.Format.RGBA8, width, height, buffer, ColorSpace.sRGB);

// 3. Create the Texture2D
Texture2D texture = new Texture2D(image);
texture.setMinFilter(Texture.MinFilter.BilinearNoMipMaps);
texture.setMagFilter(Texture.MagFilter.Bilinear);
          
return texture;
   }
   
   public void drawRectangle(Vector2f start, Vector2f end, Vector4f color){
   
       for (int y = (int)start.y; y < end.y; y++){
        
           for (int x = (int)start.x; x < end.x; x++){
       
               if (x >= 0 && x < width && y >= 0 && y < height){
               
                   drawPixel(new Vector2f(x,y), color);
               }
          
           }
           
       }
   }
   
   public void drawCircle(Vector2f point, short radius, Vector4f color){
   
        for (int y = (int)point.y - radius; y <= point.y + radius; y++){
        
           for (int x = (int)point.x - radius; x <= point.x + radius; x++){
       
               if (x >= 0 && x < width && y >= 0 && y < height){
               
                   if (point.distance(new Vector2f(x,y)) <= radius){
                   drawPixel(new Vector2f(x,y), color);
                   }
               }
          
           }
           
       }
   }
   
   public void drawPixel(Vector2f point, Vector4f color){
   
       this.layer[(int)point.x][(int)point.y][0] = (byte) (color.x);
       this.layer[(int)point.x][(int)point.y][1] = (byte) (color.y);
       this.layer[(int)point.x][(int)point.y][2] = (byte) (color.z);
       this.layer[(int)point.x][(int)point.y][3] = (byte) (color.w);
       
   }
}
