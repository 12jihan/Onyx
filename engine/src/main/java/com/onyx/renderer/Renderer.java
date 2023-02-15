package com.onyx.renderer;

import javax.xml.crypto.dsig.Transform;

import org.lwjgl.opengl.*;
import com.onyx.App;
import com.onyx.Camera;
import com.onyx.Entity.Entity;
import com.onyx.Entity.Model;
import com.onyx.utils.Transformation;
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
        shader.createUniform("transformationMatrix");
        shader.createUniform("projectionMatrix");
        shader.createUniform("viewMatrix");
    }

    public void render(Entity entity, Camera camera) {
        clear();
        shader.bind();
        shader.setUniform("textureSampler", 0);
        shader.setUniform("transformationMatrix", Transformation.createTranformationMatrix(entity));
        shader.setUniform("projectionMatrix", window.updateProjectionMatrix());
        shader.setUniform("viewMatrix", Transformation.getViewMatrix(camera));

        GL30.glBindVertexArray(entity.getModel().getId());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, entity.getModel().getTexture().getId());
        GL11.glDrawElements(GL11.GL_TRIANGLES, entity.getModel().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(2);
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
