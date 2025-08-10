package com.broadcom.bt.util.mime4j.decoder;

import java.util.Iterator;

/* loaded from: classes.dex */
public class ByteQueue {
    private UnboundedFifoByteBuffer buf;
    private int initialCapacity;

    public ByteQueue() {
        this.initialCapacity = -1;
        this.buf = new UnboundedFifoByteBuffer();
    }

    public void clear() {
        int i = this.initialCapacity;
        if (i != -1) {
            this.buf = new UnboundedFifoByteBuffer(i);
        } else {
            this.buf = new UnboundedFifoByteBuffer();
        }
    }

    public int count() {
        return this.buf.size();
    }

    public byte dequeue() {
        return this.buf.remove();
    }

    public void enqueue(byte b) {
        this.buf.add(b);
    }

    public Iterator iterator() {
        return this.buf.iterator();
    }

    public ByteQueue(int i) {
        this.initialCapacity = -1;
        this.buf = new UnboundedFifoByteBuffer(i);
        this.initialCapacity = i;
    }
}
