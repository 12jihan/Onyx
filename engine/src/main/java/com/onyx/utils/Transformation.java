package com.onyx.utils;

import org.joml.Matrix4f;

import com.onyx.Entity.Entity;

public class Transformation {

    public static Matrix4f createTranformationMatrix(Entity entity) {
        Matrix4f matrix = new Matrix4f();
        matrix.identity().translate(entity.getPos()).
            rotateX((float) Math.toRadians(entity.getRotation().x)).
            rotateY((float) Math.toRadians(entity.getRotation().y)).
            rotateZ((float) Math.toRadians(entity.getRotation().z)).
            scale(entity.getScale());

        return matrix;
    }
}
