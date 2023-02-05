package com.onyx;

import org.lwjgl.opengl.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

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
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.0f, 0.5f, 0.0f
        };

        RawModel model = loader.loadToVAO(vertices);
        // ------------------------------------------------------------------------------------------------
        System.out.println("model created: " + model + "\n");
        while (!glfwWindowShouldClose(window.getWindow())) {
            // renderer.prepare();
            // Clear with color
            // glClearColor(0.15f, 0.17f, 0.20f, 1.0f);
            // clear the framebuffer
            GL11.glClear(GL_COLOR_BUFFER_BIT);
            GL11.glClearColor(1, 0, 0, 1);
            // SwapBuffers
            glfwSwapBuffers(window.getWindow());

            GL30.glBindVertexArray(model.getVaoID());
            GL20.glEnableVertexAttribArray(model.getVaoID());
            GL11.glDrawArrays(GL_TRIANGLES, 0, model.getVertexCount());
            GL20.glDisableVertexAttribArray(0);
            GL30.glBindVertexArray(0);
            // // render:
            // renderer.render(model);
            // Poll the events
            glfwPollEvents();
        }
        ;
        loader.cleanUp();
        window.kill();

    };

};