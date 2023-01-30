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
    private long Window = NULL;

    public Window(int width, int height, String title) {
        this.Width = width;
        this.Height = height;
        this.setWindowTitle(title);
    }

    public Window() {
        this(1280, 720, "Default Title");
    }

    ~

    Window() {

    };

    public void createWindow() {
        System.out.println("Hello LWJGL" + Version.getVersion() + "!");

        init();
        loop();
    };

    public void init() {
        get
        // Setup and error callback:
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW:
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW...");
        };

        // Configure GLFW:
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);

        // Create the window:
        setWindow(GLFW_NO_WINDOW_CONTEXT);
        setWindow(glfwCreateWindow(this.Width, this.Height, this.Title, NULL, NULL));
        if (this.Window == NULL) {
            throw new IllegalStateException("Failed to create the GLFW window...");
        };
        

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

    // Getters and setters for Window:
    // ----------------------------------------------------------------

    // Set window Width and Height
    private void setWindowSize(int width, int height) {
        this.Width = width;
        this.Height = height;
    };

    // Get window Width and Height
    private int[] getWindowSize() {
        return new int[] {
                this.Width,
                this.Height
        };
    };

    // Set the title
    public void setWindowTitle(String title) {
        this.Title = title;
    };

    // Access title
    public String getWindowTitle() {
        return this.Title;
    };

    // Set the window
    public void setWindow(long window) {
        this.Window = window;
    };

    // Get the current window
    public long getWindow() {
        return this.Window;
    };

    // finalize() for Window:
    // ----------------------------------------------------------------
    protected void finalize() {
        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(this.Window);
        glfwDestroyWindow(this.Window);

        // Terminate GLFW and the free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

        // Print exit message:
        System.out.println("Program Finished!");
    };
}