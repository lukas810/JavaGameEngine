package game.scenes;

import java.util.ArrayList;
import java.util.List;

import game.Camera;
import game.GameObject;
import game.renderer.Renderer;

public abstract class Scene {

    protected Camera camera;
    protected Renderer renderer = new Renderer();
    private boolean isRunning = false;
    protected List<GameObject> gameObjects = new ArrayList<>();
    
    protected Scene() {

    }

    public void start() {
        for(GameObject go : gameObjects) {
            go.start();
            renderer.add(go);
        }
        isRunning = true;
    }

    public void addGameObjectToScene(GameObject go) {
        if(!isRunning) {
            gameObjects.add(go);
        } else {
            gameObjects.add(go);
            go.start();
            renderer.add(go);
        }
    }

    public Camera getCamera() {
        return camera;
    }

    public abstract void init();

    public abstract void update(float dt);
}
