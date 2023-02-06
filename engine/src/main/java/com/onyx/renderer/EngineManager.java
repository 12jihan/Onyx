package com.onyx.renderer;

import com.onyx.utils.*;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;

import com.onyx.App;

public class EngineManager {
    public static final long NANOSECOND = 1000000000L;
    public static final float FRAMERATE = 1000;

    private static int fps;
    private static float frametime = 1.0f / FRAMERATE;

    private boolean isRunning;

    private Window window;
    private GLFWErrorCallback errorCallback;

    private void init() throws Exception {
        GLFW.glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));
        window = App.getWindow();
        window.init();
    }

    public void start() throws Exception {
        init();
        if (isRunning)
            return;
        run();
    }

    public void run() {
        this.isRunning = true;
        int frames = 0;
        long framerCounter = 0;
        long lastTime = System.nanoTime();

        double unprocessedTime = 0;

        while(isRunning) {
            boolean render = false;
            long startTime = System.nanoTime();
            long passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime / (double) NANOSECOND;
            framerCounter += passedTime;

            input();

            while(unprocessedTime > frametime) {
                render = true;
                unprocessedTime -= frametime;

                if(window.windowShouldClose())
                    stop();

                if(framerCounter >= NANOSECOND) {
                    setFPS(frames);
                    window.setTitle(Consts.TITLE + "FPS: \t" + getFPS());
                    frames = 0;
                    framerCounter = 0;
                }
            }

            if(render) {
                update();
                render();
                frames++;
            }
        }

        cleanup();
    }

    private void stop() {
        if (!isRunning)
            return;
        isRunning = false;
    }

    private void input() {

    }

    private void render() {
        window.update();
    }

    private void update() {

    }

    private void cleanup() {
        window.cleanup();
        errorCallback.free();
        GLFW.glfwTerminate();
    }

    public static int getFPS() {
        return fps;
    }

    public static void setFPS(int fps) {
        EngineManager.fps = fps;
    }

}
