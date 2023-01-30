package com.onyx.window;

import org.lwjgl.*;
// import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import org.lwjgl.glfw.GLFWErrorCallback;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.io.IOException;

public class Window {
    private int Width, Height;
    private String Title;

    // The window handle
	private long window = NULL;

    Window(int width, int height, String title) {
        Width = width;
        Height = height;
        Title = title;
    }

    Window() {
        this(1280, 720, "Default Title");
    }

    public void createWindow() {
        System.out.println("Hello LWJGL" + Version.getVersion() + "!");

        init();
        loop();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);

        // Terminate GLFW and the free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void init() {
        // Setup and error callback:
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW:
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW...");
        };

        // Configure GLFW:
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_FALSE);

        // Create the window:
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        if (glfwWindow == NULL) {
            throw new IllegalStateException("Failed to create the GLFW window...");
        }

        // glfwSetCursorPosCallback(glfwWindow, MouseListener::mousePosCallback);
        // glfwSetMouseButtonCallback(glfwWindow, MouseListener::mouseButtonCallback);
        // glfwSetScrollCallback(glfwWindow, MouseListener::mouseScrollCallback);
        // glfwSetKeyCallback(glfwWindow, KeyListener::keyCallback);

        // Make the opengl context current:
        glfwMakeContextCurrent(glfwWindow);
        // Enable v-sync:
        glfwSwapInterval(1);

        // Make the window visible:
        glfwShowWindow(glfwWindow);

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();
    }
}