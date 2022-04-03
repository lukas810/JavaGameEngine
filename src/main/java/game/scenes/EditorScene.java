package game.scenes;

import org.joml.Vector2f;

import game.Camera;
import game.GameObject;
import game.Transform;
import game.components.SpriteRenderer;
import game.components.Spritesheet;
import game.util.AssetPool;

public class EditorScene extends Scene{


    @Override
    public void init() {
        loadResources();

        camera = new Camera(new Vector2f());

        Spritesheet spritesheet = AssetPool.getSpritesheet("assets/images/spritesheet.png");

        GameObject obj1 = new GameObject("obj1", new Transform(new Vector2f(100, 100), new Vector2f(256, 256)), 1);
        obj1.addComponent(new SpriteRenderer(spritesheet.getSprite(0)));
        addGameObjectToScene(obj1);

        GameObject obj2 = new GameObject("obj2", new Transform(new Vector2f(100, 100), new Vector2f(256, 256)), 0);
        obj2.addComponent(new SpriteRenderer(spritesheet.getSprite(16)));
        addGameObjectToScene(obj2);

    }

    @Override
    public void update(float dt) {

        for(GameObject go : gameObjects) {
            go.update(dt);
        }

        renderer.render();
        
    }

    private void loadResources() {
        AssetPool.getShader("assets/shaders/default.glsl");
        AssetPool.addSpriteSheet("assets/images/spritesheet.png", 
            new Spritesheet(AssetPool.getTexture("assets/images/spritesheet.png"),
                            16, 16, 26, 0));
    }
    
}
