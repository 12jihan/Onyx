package com.onyx;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.Version;
import org.lwjgl.opengl.GL;

import com.onyx.renderer.*;
import com.onyx.utils.Consts;

public class App {
    // static Loader loader = new Loader();
    // static Renderer renderer = new Renderer();
    private static Window window;
    private static EngineManager engine;

    public static void main(String[] args) {
        window = new Window(Consts.TITLE, 1600, 900, false);
        engine = new EngineManager();

        try {
            engine.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    public static Window getWindow() {
        return window;
    };

};