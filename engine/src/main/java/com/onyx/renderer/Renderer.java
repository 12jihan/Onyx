package com.onyx.renderer;

import org.lwjgl.opengl.*;
import com.onyx.App;
import com.onyx.Entity.Model;
import com.onyx.utils.Utils;

public class Renderer {
    private final Window window;
    private ShaderManager shader;
    public Renderer() {
        window = App.getWindow();
    }

    public void init() throws Exception {
        shader = new ShaderManager();
        shader.createVertexShader(Utils.loadResource("../resources/shaders/vertex.vs"));
        shader.createFragmentShader(Utils.loadResource("../resources/shaders/fragment.fs"));
        shader.link();
        shader.createUniform("textureSampler");
    }

    public void render(Model model) {
        clear();
        shader.bind();
        shader.setUniform("textureSampler", 0);
        GL30.glBindVertexArray(model.getId());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getId());
        GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL30.glBindVertexArray(0);
        shader.unbind();
    }

    public void clear() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    public void cleanup() {
        shader.cleanup();
    }
}
