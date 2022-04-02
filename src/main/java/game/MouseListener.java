package game;

import static org.lwjgl.glfw.GLFW.*;

public class MouseListener {
    
    private static MouseListener mouseListener;
    private double xScroll;
    private double yScroll;
    private double xPos;
    private double yPos;
    private double xLast;
    private double yLast;
    private boolean[] mouseButtonPressed = new boolean[3];
    private boolean isDragging;
    
    private MouseListener() {
        this.xScroll = 0.0;
        this.yScroll = 0.0;
        this.xPos = 0.0;
        this.yPos = 0.0;
        this.xLast = 0.0;
        this.yLast = 0.0;
    }

    public static MouseListener get() {
        if (mouseListener == null) {
            mouseListener = new MouseListener();
        }

        return mouseListener;
    }

    public static void mousePosCallback(long window, double xPos, double yPos) {
        get().xLast = get().xPos;
        get().yLast = get().yLast;
        get().xPos = xPos;
        get().yPos = yPos;
        // if one of the mouse buttons is pressed
        get().isDragging = get().mouseButtonPressed[0] || get().mouseButtonPressed[1] || get().mouseButtonPressed[2];


    }

    public static void mouseButtonCallback(long window, int button, int action, int modes) {
        if (action == GLFW_PRESS) {
            if (button < get().mouseButtonPressed.length) {
                get().mouseButtonPressed[button] = true;
            }
        } else if (action == GLFW_RELEASE) {
            if (button < get().mouseButtonPressed.length) {
                get().mouseButtonPressed[button] = false;
                get().isDragging = false;
            }
        }
    }

    public static void mouseScrollCallback(long window, double xOffset, double yOffset) {
        get().xScroll = xOffset;
        get().yScroll = yOffset;
    }

    public static void endFrame() {
        get().xScroll = 0.0;
        get().yScroll = 0.0;
        get().xLast = get().xPos;
        get().yLast = get().yPos;
    }

    public static float getX() {
        return (float) get().xPos;
    }

    public static float getY() {
        return (float) get().yPos;
    }

    public static float getDx() {
        return (float) (get().xLast - get().xPos);
    }

    public static float getDy() {
        return (float) (get().yLast - get().yPos);
    }

    public static float getXScroll() {
        return (float) get().xScroll;
    }

    public static float getYScroll() {
        return (float) get().yScroll;
    }

    public static boolean isDragging() {
        return get().isDragging;
    }

    public static boolean mouseButtonPressed(int button) {
        if (button < get().mouseButtonPressed.length) {
            return get().mouseButtonPressed[button];
        } else {
            return false;
        }
    }

}
