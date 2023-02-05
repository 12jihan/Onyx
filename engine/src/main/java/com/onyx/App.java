package com.onyx;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.Version;
import com.onyx.renderer.*;

public class App {
    // static Loader loader = new Loader();
    // static Renderer renderer = new Renderer();

    public static void main(String[] args) {
        Window window = new Window("Java Sandbox", 1920, 1080, false);

        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        window.init();


        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.0f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f
        };

        int[] indices = {
                0, 1, 3,
                3, 1, 2
        };

        while (!window.windowShouldCLose()) {
            window.update();
        }
        window.cleanup();

    };

};