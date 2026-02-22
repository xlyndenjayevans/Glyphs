/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.util.BufferUtils;

/**
 *
 * @author xlyndenjayevans
 */
public class GlyphMesh {
   
    public Geometry geom;
    public Glyph glyph;
    public Material mat;
    public Vector2f start;
    public Vector2f end;
    
    public GlyphMesh(Vector2f start, Vector2f end, Glyph glyph){
    
        this.glyph = glyph;
        this.start = start;
        this.end = end;
        Mesh mesh = new Mesh();

// 1. Define the vertices
Vector3f[] vertices = new Vector3f[4];
vertices[0] = new Vector3f(start.x, start.y, 0);
vertices[1] = new Vector3f(end.x, start.y, 0);
vertices[2] = new Vector3f(start.x, end.y, 0);
vertices[3] = new Vector3f(end.x, end.y, 0);

// 2. Define the texture coordinates (UV)
Vector2f[] texCoord = new Vector2f[4];
texCoord[0] = new Vector2f(0, 0);
texCoord[1] = new Vector2f(1, 0);
texCoord[2] = new Vector2f(0, 1);
texCoord[3] = new Vector2f(1, 1);

// 3. Define the triangles (Indices)
// We need two triangles to make a square: (0, 1, 2) and (1, 3, 2)
int[] indexes = { 0, 1, 2, 1, 3, 2 };

// 4. Load data into the mesh
mesh.setBuffer(Type.Position, 3, BufferUtils.createFloatBuffer(vertices));
mesh.setBuffer(Type.TexCoord, 2, BufferUtils.createFloatBuffer(texCoord));
mesh.setBuffer(Type.Index, 3, BufferUtils.createIntBuffer(indexes));

// 5. Calculate normals automatically for lighting
mesh.updateBound();
mesh.updateCounts();

geom = new Geometry("Glyph", mesh);

 mat = new Material(App.app.getAssetManager(), "MatDefs/Glyph.j3md");

    // 3. Set parameters defined in the .j3md file
    mat.setColor("Color", ColorRGBA.White);
    mat.setTexture("ColorMap", glyph.glyph());
    
    geom.setMaterial(mat);
    App.app.getRootNode().attachChild(geom);
// Optional: If you don't define normals manually, use this:
// Generator.generateNormals(mesh);
    }
    
    public void render(){
    mat.setColor("Color", ColorRGBA.White);
    mat.setTexture("ColorMap", glyph.glyph());
    
     
    
    }
    
    public void onClick(Vector2f location){
    
    }
}
