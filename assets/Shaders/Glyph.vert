#version 150

uniform mat4 g_WorldViewProjectionMatrix;
in vec3 inPosition;
in vec2 inTexCoord;

out vec2 texCoord;

void main() {
    texCoord = inTexCoord;
    // Standard transformation for 2D/UI elements
    //gl_Position = g_WorldViewProjectionMatrix * vec4(inPosition, 1.0);
    gl_Position =  vec4(inPosition.x, inPosition.y, 0.0, 1.0);
}