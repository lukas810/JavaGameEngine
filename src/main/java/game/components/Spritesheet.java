package game.components;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2f;

import game.renderer.Texture;

public class Spritesheet {
    
    private Texture texture;
    private List<Sprite> sprites;

    public Spritesheet(Texture texture, int spriteWidth, int spriteHeight, int numSprites, int spacing) {
        this.texture = texture;

        sprites = new ArrayList<>();
        int currentX = 0;
        int currentY = texture.getHeight() - spriteHeight;

        for (int i = 0; i < numSprites; i++) {
            float topY = (currentY + spriteHeight) / (float) texture.getHeight();
            float rightX = (currentX + spriteWidth) / (float) texture.getWidth();
            float leftX = currentX / (float) texture.getWidth();
            float bottomY = currentY / (float) texture.getHeight();

            Vector2f[] texCoords = {
                new Vector2f(rightX, topY),
                new Vector2f(rightX, bottomY),
                new Vector2f(leftX, bottomY),
                new Vector2f(leftX, topY)
            };

            Sprite sprite = new Sprite(texture, texCoords);
            sprites.add(sprite);

            currentX += spriteWidth + spacing;
            if(currentX >= texture.getWidth()) {
                currentX = 0;
                currentY -= spriteHeight + spacing; 
            }
        }
    }

    public Sprite getSprite(int index) {
        return sprites.get(index);
    }
}
