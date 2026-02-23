/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame;

import com.jme3.export.binary.BinaryExporter;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import java.io.File;
import java.io.IOException;
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
        Glyph container = new Glyph((short)1,(short)1,(short)4);
        container.drawCircle(new Vector2f(), (short)1, new Vector4f(255,255,255,255));
     
      //  glyph.drawCircle(new Vector2f(128,128), (short)10, new Vector4f(255,0,0,255));
        GlyphMesh containerMeshLeft = new GlyphMesh(new Vector2f(-0.27f,-0.6f), new Vector2f(-0.26f,0.6f), container);
        containerMeshLeft.render();
        GlyphMesh containerMeshRight = new GlyphMesh(new Vector2f(0.26f,-0.6f), new Vector2f(0.27f,0.6f), container);
        containerMeshRight.render();
        GlyphMesh containerMeshUp = new GlyphMesh(new Vector2f(-0.27f,0.5f), new Vector2f(0.26f,0.6f), container);
        containerMeshUp.render();
        GlyphMesh containerMeshDown = new GlyphMesh(new Vector2f(-0.27f,-0.6f), new Vector2f(0.26f,-0.5f), container);
        containerMeshDown.render();
        Glyph glyph = new Glyph((short)256,(short)256,(short)4);
      //  glyph.drawCircle(new Vector2f(128,128), (short)10, new Vector4f(255,0,0,255));
        GlyphMesh glyphMesh = new GlyphMesh(new Vector2f(-0.25f,-0.5f), new Vector2f(0.25f,0.5f), glyph){
        
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
        
        
        glyphMesh.glyph.drawCircle(new Vector2f(128,128), (short)256, new Vector4f(0,0,0,255));
        glyphMesh.render();
        
        Glyph saveGlyph = new Glyph((short)1, (short)1,(short)4);
        saveGlyph.drawCircle(new Vector2f(), (short)1, new Vector4f(0,255,0,255));
        GlyphMesh saveGlyphMesh = new GlyphMesh(new Vector2f(-0.25f,-0.85f), new Vector2f(0.25f,-0.65f), saveGlyph){
        
            @Override
              public void onClick(Vector2f location){
                  
                  // Define where to save the file
    File file = new File(System.getProperty("user.home") + "/" + "ForeSlash" + ".glyph");
    
    BinaryExporter exporter = BinaryExporter.getInstance();
    try {
        exporter.save(glyphMesh.glyph, file);
        System.out.println("Save successful!");
    } catch (IOException ex) {
        System.err.println("Failed to save game: " + ex.getMessage());
    }
              }
        };
        saveGlyphMesh.render();
                
        App.allGlyphMeshes = new HashMap<>();
        App.allGlyphMeshes.put("Glyph", glyphMesh);
        App.allGlyphMeshes.put("Save", saveGlyphMesh);
        App.app.getInputManager().addRawInputListener(new OmniInputListener());
        
    }
}
