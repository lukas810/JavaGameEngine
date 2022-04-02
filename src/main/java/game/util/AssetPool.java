package game.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import game.components.Spritesheet;
import game.renderer.Shader;
import game.renderer.Texture;

public class AssetPool {
    
    private static Map<String, Shader> shaders = new HashMap<>();
    private static Map<String, Texture> textures = new HashMap<>();
    private static Map<String, Spritesheet> spritesheets = new HashMap<>();

    private AssetPool() {
        throw new IllegalStateException("Utility class");
    }

    public static Shader getShader(String resourceName) {
        File file = new File(resourceName);
        if(shaders.containsKey(file.getAbsolutePath())) {
            return shaders.get(file.getAbsolutePath());
        } else {
            Shader shader = new Shader(resourceName);
            shader.compile();
            shader.link();
            shaders.put(file.getAbsolutePath(), shader);
            return shader;
        }
    }

    public static Texture getTexture(String resourceName) {
        File file = new File(resourceName);
        if(textures.containsKey(file.getAbsolutePath())) {
            return textures.get(file.getAbsolutePath());
        } else {
            Texture texture = new Texture(resourceName);
            textures.put(file.getAbsolutePath(), texture);
            return texture;
        }
    }

    public static void addSpriteSheet(String resourceName, Spritesheet spritesheet) {
        File file = new File(resourceName);
        if(!spritesheets.containsKey(file.getAbsolutePath())) {
            spritesheets.put(file.getAbsolutePath(), spritesheet);
        } 
    }

    public static Spritesheet getSpritesheet(String resourceName) {
        File file = new File(resourceName);
        if(!spritesheets.containsKey(file.getAbsolutePath())) {
            throw new IllegalStateException("No Spritesheet has been added " + resourceName);
        }
        return spritesheets.getOrDefault(file.getAbsolutePath(), null);
    }

}
