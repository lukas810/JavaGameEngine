package game.renderer;

import java.util.ArrayList;
import java.util.List;

import game.GameObject;
import game.components.SpriteRenderer;

public class Renderer {
    
    private final int MAX_BATCH_SIZE = 1000;
    private List<RenderBatch> batches;

    public Renderer() {
        batches = new ArrayList<>();
    }

    public void add(GameObject go) {
        SpriteRenderer sprite = go.getComponent(SpriteRenderer.class);
        if(sprite != null) {
            add(sprite);
        }
    }

    private void add(SpriteRenderer sprite) {
        boolean added = false;
        for(RenderBatch batch : batches) {
            if(batch.hasSpace()) {
                Texture texture = sprite.getTexture();
                if(texture == null || (batch.hasTexture(texture) || batch.hasTextureSpace())) {
                    batch.addSprite(sprite);
                    added = true;
                    break;
                }
            }
        }

        if(!added) {
            RenderBatch newBatch = new RenderBatch(MAX_BATCH_SIZE);
            newBatch.start();
            batches.add(newBatch);
            newBatch.addSprite(sprite);
        }
    }

    public void render() {
        for (RenderBatch batch : batches) {
            batch.render();
        }
    }
}
