/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;

/**
 *
 * @author xlyndenjayevans
 */
public class App {
    
    public static Main app;
    
    public App(Main main){
    
        App.app = main;
        Glyph glyph = new Glyph((short)256,(short)256,(short)4);
        glyph.drawCircle(new Vector2f(128,128), (short)10, new Vector4f(255,0,0,255));
        GlyphMesh glyphMesh = new GlyphMesh(new Vector2f(0,0), new Vector2f(1,1), glyph);
        glyphMesh.render();
    }
}
