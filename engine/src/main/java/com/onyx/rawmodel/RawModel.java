package com.onyx.rawmodel;

public class RawModel {
    private int vaoID;
    private int vertexCount;

    public RawModel(int vaoID, int vertexCount) {
        this.vaoID = vaoID;
        this.vertexCount = vertexCount;

        System.out.println("RawData: \n");
        System.out.println("vaoID: \n\n\t\t\t" + vaoID);
        System.out.println("vertexCount: \n\n\t\t\t" + vertexCount);

    };

    public int getVaoID() {
        return vaoID;
    };

    public int getVertexCount() {
        return vertexCount;
    };

    
}
