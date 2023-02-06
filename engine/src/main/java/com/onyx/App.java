package com.onyx;

import com.onyx.renderer.*;
import com.onyx.sandbox.SandBox;
import com.onyx.utils.Consts;

public class App {
    private static Window window;
    private static SandBox game;

    public static void main(String[] args) {
        window = new Window(Consts.TITLE, 1600, 900, false);
        game = new SandBox();
        EngineManager engine = new EngineManager();

        try {
            engine.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    };

    public static Window getWindow() {
        return window;
    };

    public static SandBox getGame() {
        return game;
    }

};