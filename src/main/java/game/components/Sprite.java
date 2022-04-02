package game.components;

import org.joml.Vector2f;

import game.renderer.Texture;

public class Sprite {

    private Texture texture;
    private Vector2f[] texCoords;

    public Sprite(Texture texture) {
        this.texture = texture;
        Vector2f[] textureCoords = {
            new Vector2f(1, 1),
            new Vector2f(1, 0),
            new Vector2f(0, 0),
            new Vector2f(0, 1)
        };
        this.texCoords = textureCoords;
    }

    public Sprite(Texture texture, Vector2f[] texCoords) {
        this.texture = texture;
        this.texCoords = texCoords;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector2f[] getTexCoords() {
        return texCoords;
    }
    
}
