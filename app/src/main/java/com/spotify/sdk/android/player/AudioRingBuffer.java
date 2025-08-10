package com.spotify.sdk.android.player;

/* loaded from: classes3.dex */
public class AudioRingBuffer {
    private final int mCapacity;
    private final short[] mData;
    private int mReadPosition;
    private int mSize;
    private int mWritePosition;

    public AudioRingBuffer(int i) {
        this.mCapacity = i;
        this.mData = new short[i];
    }

    public synchronized int capacity() {
        return this.mCapacity;
    }

    public synchronized void clear() {
        this.mReadPosition = 0;
        this.mWritePosition = 0;
        this.mSize = 0;
    }

    public synchronized int getReadPosition() {
        return this.mReadPosition;
    }

    public synchronized int getWritePosition() {
        return this.mWritePosition;
    }

    public synchronized int peek(short[] sArr) {
        int i = this.mSize;
        if (i == 0) {
            return 0;
        }
        int iMin = Math.min(i, sArr.length);
        int i2 = this.mReadPosition;
        int i3 = i2 + iMin;
        int i4 = this.mCapacity;
        if (i3 > i4) {
            int i5 = i4 - i2;
            System.arraycopy(this.mData, i2, sArr, 0, i5);
            System.arraycopy(this.mData, 0, sArr, i5, iMin - i5);
        } else {
            System.arraycopy(this.mData, i2, sArr, 0, iMin);
        }
        return iMin;
    }

    public synchronized void remove(int i) {
        if (i <= 0) {
            return;
        }
        int iMin = Math.min(i, this.mSize);
        this.mReadPosition = (this.mReadPosition + iMin) % this.mCapacity;
        this.mSize -= iMin;
    }

    public synchronized int size() {
        return this.mSize;
    }

    public int write(short[] sArr) {
        return write(sArr, sArr.length);
    }

    public synchronized int write(short[] sArr, int i) {
        int iMin = Math.min(i, sArr.length);
        int i2 = this.mSize + iMin;
        int i3 = this.mCapacity;
        if (i2 > i3) {
            return 0;
        }
        int i4 = this.mWritePosition;
        if (i4 + iMin > i3) {
            int i5 = i3 - i4;
            System.arraycopy(sArr, 0, this.mData, i4, i5);
            System.arraycopy(sArr, i5, this.mData, 0, iMin - i5);
        } else {
            System.arraycopy(sArr, 0, this.mData, i4, iMin);
        }
        this.mWritePosition = (this.mWritePosition + iMin) % this.mCapacity;
        this.mSize += iMin;
        return iMin;
    }
}
