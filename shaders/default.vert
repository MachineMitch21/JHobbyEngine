#version 330 core

layout (location = 0) in vec3 vertPos;
layout (location = 1) in vec2 texCoord;

out vec3 VertexPosition;
out vec2 TexCoord;

void main() {
	gl_Position = vec4(vertPos, 1.0);
	VertexPosition = vertPos;
	TexCoord = texCoord;
}