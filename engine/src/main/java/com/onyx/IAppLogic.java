package com.onyx;

public interface IAppLogic {
    
    
    void init() throws Exception;

    void input();

    void update();

    void render();

    void cleanup();
}