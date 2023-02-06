package com.onyx;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.Version;
import org.lwjgl.opengl.GL;

import com.onyx.renderer.*;

public class App {
    // static Loader loader = new Loader();
    // static Renderer renderer = new Renderer();

    public static void main(String[] args) {
        Window window = new Window("Java Sandbox", 1600, 900, false);
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        window.init();

        while (!window.windowShouldCLose()) {
            window.update();
        }
        window.cleanup();

    };

};