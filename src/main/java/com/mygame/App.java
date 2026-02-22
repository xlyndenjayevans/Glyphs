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
        GlyphMesh glyphMesh = new GlyphMesh(new Vector2f(0f,0f), new Vector2f(.5f,.75f), glyph){
        
            @Override
            public void onClick(Vector2f location){
               // 1. Calculate the total size of the bounding box in world/UI units
    float boxWidth = this.end.x - this.start.x;
    float boxHeight = this.end.y - this.start.y;

    // 2. Normalize the click: (Click - Start) / (End - Start)
    // This gives us a 0.0 to 1.0 range relative to the box itself
    float relativeX = (location.x - this.start.x) / boxWidth;
    float relativeY = (location.y - this.start.y) / boxHeight;

    // 3. Map to Glyph Pixel Space
    // Multiply the 0-1 ratio by the actual pixel dimensions of the texture
    float pixelX = relativeX * this.glyph.width;
    float pixelY = relativeY * this.glyph.height;

    Vector2f drawPos = new Vector2f(pixelX, pixelY);

    // 4. Draw and Render
    this.glyph.drawCircle(drawPos, (short)10, new Vector4f(255, 255, 255, 255));
    this.render();
                
            }
            
        };
        glyphMesh.render();
        App.allGlyphMeshes = new HashMap<>();
        App.allGlyphMeshes.put("Glyph", glyphMesh);
        App.app.getInputManager().addRawInputListener(new OmniInputListener());
        
    }
}
