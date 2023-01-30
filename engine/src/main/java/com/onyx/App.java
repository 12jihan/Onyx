package com.onyx;

import org.lwjgl.*;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import com.onyx.window.*;

public class App {
    static Window nwindow = new Window(1280, 720, "Java Sandbox");

    public static void main(String[] args) {
        GLFWErrorCallback.createPrint(System.err).set();
        System.out.println(nwindow.getWindowTitle());

        nwindow.init();
        
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        GL.createCapabilities();
        glClearColor(0.15f, 0.17f, 0.20f, 1.0f);

        while (!glfwWindowShouldClose(nwindow.getWindow())) {
            // clear the framebuffer
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 

            // SwapBuffers
            glfwSwapBuffers(nwindow.getWindow());

            // Poll the events
            glfwPollEvents();
        };
    }

};