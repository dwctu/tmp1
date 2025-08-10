package com.broadcom.bt.util.mime4j.decoder;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class UnboundedFifoByteBuffer {
    public byte[] buffer;
    public int head;
    public int tail;

    public UnboundedFifoByteBuffer() {
        this(32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int decrement(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.buffer.length - 1 : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int increment(int i) {
        int i2 = i + 1;
        if (i2 >= this.buffer.length) {
            return 0;
        }
        return i2;
    }

    public boolean add(byte b) {
        int size = size() + 1;
        byte[] bArr = this.buffer;
        if (size >= bArr.length) {
            byte[] bArr2 = new byte[((bArr.length - 1) * 2) + 1];
            int i = this.head;
            int i2 = 0;
            while (i != this.tail) {
                byte[] bArr3 = this.buffer;
                bArr2[i2] = bArr3[i];
                bArr3[i] = 0;
                i2++;
                i++;
                if (i == bArr3.length) {
                    i = 0;
                }
            }
            this.buffer = bArr2;
            this.head = 0;
            this.tail = i2;
        }
        byte[] bArr4 = this.buffer;
        int i3 = this.tail;
        bArr4[i3] = b;
        int i4 = i3 + 1;
        this.tail = i4;
        if (i4 >= bArr4.length) {
            this.tail = 0;
        }
        return true;
    }

    public byte get() {
        if (isEmpty()) {
            throw new IllegalStateException("The buffer is already empty");
        }
        return this.buffer[this.head];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator iterator() {
        return new Iterator() { // from class: com.broadcom.bt.util.mime4j.decoder.UnboundedFifoByteBuffer.1
            private int index;
            private int lastReturnedIndex = -1;

            {
                this.index = UnboundedFifoByteBuffer.this.head;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index != UnboundedFifoByteBuffer.this.tail;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i = this.index;
                this.lastReturnedIndex = i;
                this.index = UnboundedFifoByteBuffer.this.increment(i);
                return new Byte(UnboundedFifoByteBuffer.this.buffer[this.lastReturnedIndex]);
            }

            @Override // java.util.Iterator
            public void remove() {
                int i = this.lastReturnedIndex;
                if (i == -1) {
                    throw new IllegalStateException();
                }
                UnboundedFifoByteBuffer unboundedFifoByteBuffer = UnboundedFifoByteBuffer.this;
                if (i == unboundedFifoByteBuffer.head) {
                    unboundedFifoByteBuffer.remove();
                    this.lastReturnedIndex = -1;
                    return;
                }
                int i2 = i + 1;
                while (true) {
                    UnboundedFifoByteBuffer unboundedFifoByteBuffer2 = UnboundedFifoByteBuffer.this;
                    int i3 = unboundedFifoByteBuffer2.tail;
                    if (i2 == i3) {
                        this.lastReturnedIndex = -1;
                        unboundedFifoByteBuffer2.tail = unboundedFifoByteBuffer2.decrement(i3);
                        UnboundedFifoByteBuffer unboundedFifoByteBuffer3 = UnboundedFifoByteBuffer.this;
                        unboundedFifoByteBuffer3.buffer[unboundedFifoByteBuffer3.tail] = 0;
                        this.index = unboundedFifoByteBuffer3.decrement(this.index);
                        return;
                    }
                    byte[] bArr = unboundedFifoByteBuffer2.buffer;
                    if (i2 >= bArr.length) {
                        bArr[i2 - 1] = bArr[0];
                        i2 = 0;
                    } else {
                        bArr[i2 - 1] = bArr[i2];
                        i2++;
                    }
                }
            }
        };
    }

    public byte remove() {
        if (isEmpty()) {
            throw new IllegalStateException("The buffer is already empty");
        }
        byte[] bArr = this.buffer;
        int i = this.head;
        byte b = bArr[i];
        int i2 = i + 1;
        this.head = i2;
        if (i2 >= bArr.length) {
            this.head = 0;
        }
        return b;
    }

    public int size() {
        int i = this.tail;
        int i2 = this.head;
        return i < i2 ? (this.buffer.length - i2) + i : i - i2;
    }

    public UnboundedFifoByteBuffer(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        this.buffer = new byte[i + 1];
        this.head = 0;
        this.tail = 0;
    }
}
