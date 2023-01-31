package com.onyx;
import com.onyx.renderer.*;
import com.onyx.loader.*;

public class App {
    static Loader loader = new Loader();
    static Renderer render = new Renderer();

    public static void main(String[] args) {
        render.gameLoop();
        
    };

};