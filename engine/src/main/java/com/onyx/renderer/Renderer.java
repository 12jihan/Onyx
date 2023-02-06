package com.onyx.renderer;

import org.lwjgl.opengl.*;
import com.onyx.App;
import com.onyx.Entity.Model;

public class Renderer {
    private final Window window;

    public Renderer() {
        window = App.getWindow();
    }

    public void init() throws Exception {

    }

    public void render(Model model) {
        clear();
        GL30.glBindVertexArray(model.getId());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getVertexCount());
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
    }

    public void clear() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void cleanup() {

    }
}
