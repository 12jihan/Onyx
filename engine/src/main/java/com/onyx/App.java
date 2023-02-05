package com.onyx;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.Version;
import com.onyx.renderer.*;

public class App {
    static Window window = new Window(1280, 720, "Java Sandbox");
    static Loader loader = new Loader();
    static Renderer renderer = new Renderer();

    public static void main(String[] args) {

        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        window.init();

        // ------------------------------------------------------------------------------------------------

        float[] vertices = {
                -0.5f,  0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                 0.0f, -0.5f, 0.0f,
                 0.5f,  0.5f, 0.0f
        };

        int[] indices = {
            0, 1, 3, 
            3, 1, 2
        };

        RawModel model = loader.loadToVAO(vertices, indices);
        // ------------------------------------------------------------------------------------------------
        System.out.println("model created: " + model + "\n");
        while (!glfwWindowShouldClose(window.getWindow())) {
            renderer.prepare();
            renderer.render(model);
            window.runWindow();
        }
        ;
        loader.cleanUp();
        window.kill();

    };

};