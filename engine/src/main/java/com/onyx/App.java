package com.onyx;

import org.lwjgl.opengl.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.Version;
import com.onyx.window.*;
import com.onyx.renderer.*;
import com.onyx.loader.*;
import com.onyx.rawmodel.RawModel;

public class App {
    static Window window = new Window(1280, 720, "Java Sandbox");
    static Loader loader = new Loader();
    static Renderer renderer = new Renderer();
    
    public static void main(String[] args) {
        
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        
        window.init();
        
        // ------------------------------------------------------------------------------------------------
        
        float[] vertices = {
            // left bottom triangle
            -0.5f, 0.5f, 0f,
            -0.5f, -0.5f, 0f,
            0.5f, -0.5f, 0f,
            
            // right top triangle
            0.5f, -0.5f, 0f,
            0.5f, 0.5f, 0f,
            -0.5f, 0.5f, 0f,
        };
        RawModel model = loader.loadToVAO(vertices);
        // ------------------------------------------------------------------------------------------------
        
        while (!glfwWindowShouldClose(window.getWindow())) {
            renderer.prepare();
            // Clear with color
            // glClearColor(0.15f, 0.17f, 0.20f, 1.0f);
            // clear the framebuffer
            glClear(GL_COLOR_BUFFER_BIT);

            // SwapBuffers
            glfwSwapBuffers(window.getWindow());

            // // render:
            renderer.render(model);
            // Poll the events
            glfwPollEvents();
        }
        ;
        loader.cleanUp();
        window.kill();

    };

};