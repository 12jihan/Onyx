package com.onyx.renderer;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/**
 * Handles the loading of geometry data into VAOs. It also keeps track of all
 * the created VAOs and VBOs so that they can all be deleted when the game
 * closes.
 */

public class Loader {

    private List<Integer> vaos = new ArrayList<Integer>();
    private List<Integer> vbos = new ArrayList<Integer>();

    /**
     * 
     * @param positions
     *                  - The 3D positions of each vertex in the geometry (in this
     *                  example a quad).
     * @return
     *         returns a RawModel object with the position length and the arttribute
     *         number of the created VAO passed in to the object constructor.
     */
    public RawModel loadToVAO(float[] positions, int[] indices) {
        System.out.println("Positions: \n\t" + positions + "\n");
        int vaoID = createVAO();
        bindIndicesBuffer(indices);
        storeDataInAttributeList(0, positions);
        unbindVAO();
        return new RawModel(vaoID, indices.length);
    };

    /**
     * Delete all the VAOS and VBOs when the game is closed. VAOs and VBOs are
     * located in video memory.
     */
    public void cleanUp() {
        for (int vao : vaos) {
            GL30.glDeleteVertexArrays(vao);
        }
        ;
        for (int vbo : vbos) {
            GL15.glDeleteBuffers(vbo);
        }
        ;
    };

    private int createVAO() {
        int vaoID = GL30.glGenVertexArrays();
        vaos.add(vaoID);
        System.out.println("binding vertex array..." + vaoID);
        GL30.glBindVertexArray(vaoID);

        return vaoID;
    };

    private void storeDataInAttributeList(int attributeNumber, float[] data) {
        int vboID = GL15.glGenBuffers();
        vbos.add(vboID);
        System.out.println("Bounding to vbo with id: " + vboID);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
        System.out.println("Buffer has been created...");
        FloatBuffer buffer = storeDataInFloatBuffer(data);
        System.out.println("Stored buffer data...");
        GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        GL20.glVertexAttribPointer(attributeNumber, 3, GL11.GL_FLOAT, false, 0, 0);
        System.out.println("Unbinding bufferd data..." + vboID);
        GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    };

    private void unbindVAO() {
        System.out.println("Unibinding vertex array...");
        GL30.glBindVertexArray(0);
    };

    private void bindIndicesBuffer(int[] indices) {
        int vboID = GL15.glGenBuffers();
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
        IntBuffer buffer = storeDataInIntBuffer(indices);
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
    };

    private IntBuffer storeDataInIntBuffer(int[] data) {
        IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
        buffer.put(data);
        return buffer;
    };

    private FloatBuffer storeDataInFloatBuffer(float[] data) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        System.out.println("Buffer length created: " + data.length);
        buffer.put(data);
        System.out.println("Flipping data...");
        buffer.flip();
        return buffer;
    }
}
