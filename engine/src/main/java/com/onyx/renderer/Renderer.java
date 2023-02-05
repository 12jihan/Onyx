package com.onyx.renderer;

// import org.lwjgl.*;
// import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.*;
// import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Renderer {

    // static Window window = new Window(1280, 720, "Java Sandbox");
    // static Loader loader = new Loader();
    
    // public Renderer() {

        // GLFWErrorCallback.createPrint(System.err).set();

        // window.init();

        // System.out.println("Hello LWJGL " + Version.getVersion() + "!");
        // GL.createCapabilities();
        
    // };

    public void prepare() {
        GL11.glClear(GL_COLOR_BUFFER_BIT);
        GL11.glClearColor(1, 0, 0, 1);
    };

    public void render(RawModel model) {
        GL30.glBindVertexArray(model.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
    };

    // public void gameLoop() {
    //     while (!glfwWindowShouldClose(window.getWindow())) {
    //         // Clear with color
    //         glClearColor(0.15f, 0.17f, 0.20f, 1.0f);
    //         // clear the framebuffer
    //         glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        
    //         // SwapBuffers
    //         glfwSwapBuffers(window.getWindow());

    //         // Poll the events
    //         glfwPollEvents();
    //     };
    //     loader.cleanUp();
    // }
}
