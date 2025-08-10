package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: AudioSampleEntry.java */
/* loaded from: classes.dex */
public final class gg0 extends fg0 {
    public int k;
    public int l;
    public long m;
    public int n;
    public int o;
    public int p;
    public long q;
    public long r;
    public long s;
    public long t;
    public int u;
    public long v;
    public byte[] w;

    public gg0(String str) {
        super(str);
    }

    public int C() {
        return this.k;
    }

    public long I() {
        return this.m;
    }

    public void K(int i) {
        this.k = i;
    }

    public void L(long j) {
        this.m = j;
    }

    public void O(int i) {
        this.l = i;
    }

    @Override // dc.f41, dc.hf0
    public long b() {
        int i = this.n;
        int i2 = 16;
        long jP = (i == 1 ? 16 : 0) + 28 + (i == 2 ? 36 : 0) + p();
        if (!this.i && 8 + jP < 4294967296L) {
            i2 = 8;
        }
        return jP + i2;
    }

    @Override // dc.f41, dc.hf0
    public void e(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(y());
        int i = this.n;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((i == 1 ? 16 : 0) + 28 + (i == 2 ? 36 : 0));
        byteBufferAllocate.position(6);
        ef0.e(byteBufferAllocate, this.j);
        ef0.e(byteBufferAllocate, this.n);
        ef0.e(byteBufferAllocate, this.u);
        ef0.g(byteBufferAllocate, this.v);
        ef0.e(byteBufferAllocate, this.k);
        ef0.e(byteBufferAllocate, this.l);
        ef0.e(byteBufferAllocate, this.o);
        ef0.e(byteBufferAllocate, this.p);
        if (this.h.equals("mlpa")) {
            ef0.g(byteBufferAllocate, I());
        } else {
            ef0.g(byteBufferAllocate, I() << 16);
        }
        if (this.n == 1) {
            ef0.g(byteBufferAllocate, this.q);
            ef0.g(byteBufferAllocate, this.r);
            ef0.g(byteBufferAllocate, this.s);
            ef0.g(byteBufferAllocate, this.t);
        }
        if (this.n == 2) {
            ef0.g(byteBufferAllocate, this.q);
            ef0.g(byteBufferAllocate, this.r);
            ef0.g(byteBufferAllocate, this.s);
            ef0.g(byteBufferAllocate, this.t);
            byteBufferAllocate.put(this.w);
        }
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        x(writableByteChannel);
    }

    @Override // dc.h41
    public String toString() {
        return "AudioSampleEntry{bytesPerSample=" + this.t + ", bytesPerFrame=" + this.s + ", bytesPerPacket=" + this.r + ", samplesPerPacket=" + this.q + ", packetSize=" + this.p + ", compressionId=" + this.o + ", soundVersion=" + this.n + ", sampleRate=" + this.m + ", sampleSize=" + this.l + ", channelCount=" + this.k + ", boxes=" + m() + MessageFormatter.DELIM_STOP;
    }
}
