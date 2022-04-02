package game.scenes;

import org.joml.Vector2f;
import org.joml.Vector4f;

import game.Camera;
import game.GameObject;
import game.Transform;
import game.components.SpriteRenderer;
import game.util.AssetPool;

public class EditorScene extends Scene{


    @Override
    public void init() {
        camera = new Camera(new Vector2f());

        GameObject obj1 = new GameObject("obj1", new Transform(new Vector2f(100, 100), new Vector2f(256, 256)));
        obj1.addComponent(new SpriteRenderer(AssetPool.getTexture("assets/images/testImage.png")));
        addGameObjectToScene(obj1);

        GameObject obj2 = new GameObject("obj2", new Transform(new Vector2f(400, 100), new Vector2f(256, 256)));
        obj2.addComponent(new SpriteRenderer(AssetPool.getTexture("assets/images/testImage2.png")));
        addGameObjectToScene(obj2);

        loadResources();
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
    }
    
}
