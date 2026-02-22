/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import java.util.HashMap;

/**
 *
 * @author xlyndenjayevans
 */
public class App {
    
    public static Main app;
    public static HashMap<String, GlyphMesh> allGlyphMeshes;
    
    public App(Main main){
    
        App.app = main;
        Glyph glyph = new Glyph((short)256,(short)256,(short)4);
        glyph.drawCircle(new Vector2f(128,128), (short)10, new Vector4f(255,0,0,255));
        GlyphMesh glyphMesh = new GlyphMesh(new Vector2f(-0.5f,-0.5f), new Vector2f(0.5f,0.5f), glyph){
        
            @Override
            public void onClick(Vector2f location){
                Vector2f center = (this.start.add(this.end)).divide(2);
                Vector2f distance = (this.end.subtract(this.start));
                Vector2f glDistance = (new Vector2f(1,1).subtract(new Vector2f(-1,-1)));
                Vector2f multiplyDistance = distance.mult(glDistance.x, glDistance.y);
                
                Vector2f unitPixel = distance.mult(this.glyph.width,this.glyph.height);
                Vector2f adjustedLocation = start.add(location.mult(distance.x, distance.y));
                Vector2f multiply = new Vector2f(distance.x, distance.y).mult(2);
                Vector2f distanceFromCenter = ((location.divide(multiply.x, multiply.y))) ;//.subtract(end.subtract(distance));
                //Vector2f size = new Vector2f(this.glyph.width,this.glyph.height);
                this.glyph.drawCircle(( ((location.mult(multiplyDistance.x, multiplyDistance.y)).add(center.mult(multiplyDistance.x, multiplyDistance.y))).add(start.divide(multiplyDistance.x, multiplyDistance.y))).mult(unitPixel.x, unitPixel.y)  , (short)10, new Vector4f(255,255,255,255));
                this.render();
                
            }
            
        };
        glyphMesh.render();
        App.allGlyphMeshes = new HashMap<>();
        App.allGlyphMeshes.put("Glyph", glyphMesh);
        App.app.getInputManager().addRawInputListener(new OmniInputListener());
        
    }
}
