package com.koushikdutta.async.util;

import com.koushikdutta.async.ByteBufferList;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class Allocator {
    public int currentAlloc;
    public final int maxAlloc;
    public int minAlloc;

    public Allocator(int i) {
        this.currentAlloc = 0;
        this.minAlloc = 4096;
        this.maxAlloc = i;
    }

    public ByteBuffer allocate() {
        return allocate(this.currentAlloc);
    }

    public int getMaxAlloc() {
        return this.maxAlloc;
    }

    public int getMinAlloc() {
        return this.minAlloc;
    }

    public void setCurrentAlloc(int i) {
        this.currentAlloc = i;
    }

    public Allocator setMinAlloc(int i) {
        this.minAlloc = Math.max(0, i);
        return this;
    }

    public void track(long j) {
        this.currentAlloc = ((int) j) * 2;
    }

    public ByteBuffer allocate(int i) {
        return ByteBufferList.obtain(Math.min(Math.max(i, this.minAlloc), this.maxAlloc));
    }

    public Allocator() {
        this.currentAlloc = 0;
        this.minAlloc = 4096;
        this.maxAlloc = ByteBufferList.MAX_ITEM_SIZE;
    }
}
