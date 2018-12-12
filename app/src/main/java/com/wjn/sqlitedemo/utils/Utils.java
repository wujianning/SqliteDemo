package com.wjn.sqlitedemo.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Utils {

    /**
     * 获取浮点形缓冲数据 float 数组
     */

    public static FloatBuffer getFloatBuffer(float[] vertexs) {
        FloatBuffer buffer;
        ByteBuffer qbb = ByteBuffer.allocateDirect(vertexs.length * 4);
        qbb.order(ByteOrder.nativeOrder());
        buffer = qbb.asFloatBuffer();
        buffer.put(vertexs);
        buffer.position(0);
        return buffer;
    }

    /**
     * 获取字节型缓冲数据 Byte 数组
     */

    public static ShortBuffer getShortBuffer(short[] vertexs) {
        ShortBuffer buffer;
        ByteBuffer qbb = ByteBuffer.allocateDirect(vertexs.length * 2);
        qbb.order(ByteOrder.nativeOrder());
        buffer = qbb.asShortBuffer();
        buffer.put(vertexs);
        buffer.position(0);
        return buffer;
    }

}