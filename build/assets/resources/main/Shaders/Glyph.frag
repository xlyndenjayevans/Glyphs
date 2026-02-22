//#version 150

uniform sampler2D m_ColorMap;
uniform vec4 m_Color;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    vec4 color = m_Color;

    #ifdef HAS_COLORMAP
        color *= texture(m_ColorMap, texCoord);
    #endif

    if (color.a < 0.01) discard; // Optimization for transparency
    fragColor = color;
}