package com.onyx;

import org.lwjgl.*;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import com.onyx.window.*;

/**
 * Hello world!
 *
 */

public class App {
    static Window nwindow = new Window(1280, 720, "Java Sandbox");

    public static void main(String[] args) {
        GLFWErrorCallback.createPrint(System.err).set();
        System.out.println(nwindow.getWindowTitle());

        nwindow.init();
        // if (!glfwInit()) {
        //     System.err.println("Error initializing GLFW");
        //     System.exit(1);
        // }
        // ;
        // // glfwWindowHint(GLFW_SAMPLES, 4);
        // glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        // glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        // glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
        // glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        // glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);

        // glfw window creation
        // --------------------
        // window = glfwCreateWindow(width, height, title, NULL, NULL);
        // glfwMakeContextCurrent(window);
        // if (window == NULL) {
        //     System.err.println("Error creating a window");
        //     System.exit(1);
        // }
        // ;

        // Make the OpenGL context current
		// glfwMakeContextCurrent(window);
		// // Enable v-sync
		// glfwSwapInterval(1);

		// Make the window visible
		// glfwShowWindow(window);
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        GL.createCapabilities();
        glClearColor(0.15f, 0.17f, 0.20f, 1.0f);

        while (!glfwWindowShouldClose(nwindow.getWindow())) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            // SwapBuffers
            glfwSwapBuffers(nwindow.getWindow());
            // Poll the events
            glfwPollEvents();
        }
        // ;
        // glfwDestroyWindow(window);
        // glfwTerminate();
    }

};