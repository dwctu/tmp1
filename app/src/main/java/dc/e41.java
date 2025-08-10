package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: AbstractBox.java */
/* loaded from: classes2.dex */
public abstract class e41 implements hf0 {
    public static g51 j = g51.a(e41.class);
    public String a;
    public byte[] b;
    public ByteBuffer e;
    public long f;
    public i41 h;
    public long g = -1;
    public ByteBuffer i = null;
    public boolean d = true;
    public boolean c = true;

    public e41(String str) {
        this.a = str;
    }

    public abstract void a(ByteBuffer byteBuffer);

    @Override // dc.hf0
    public long b() {
        long jLimit;
        if (!this.d) {
            jLimit = this.g;
        } else if (this.c) {
            jLimit = d();
        } else {
            ByteBuffer byteBuffer = this.e;
            jLimit = byteBuffer != null ? byteBuffer.limit() : 0;
        }
        return jLimit + (jLimit >= 4294967288L ? 8 : 0) + 8 + ("uuid".equals(h()) ? 16 : 0) + (this.i != null ? r0.limit() : 0);
    }

    public abstract void c(ByteBuffer byteBuffer);

    public abstract long d();

    @Override // dc.hf0
    public void e(WritableByteChannel writableByteChannel) throws IOException {
        if (!this.d) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((k() ? 8 : 16) + ("uuid".equals(h()) ? 16 : 0));
            g(byteBufferAllocate);
            writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
            this.h.c(this.f, this.g, writableByteChannel);
            return;
        }
        if (!this.c) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((k() ? 8 : 16) + ("uuid".equals(h()) ? 16 : 0));
            g(byteBufferAllocate2);
            writableByteChannel.write((ByteBuffer) byteBufferAllocate2.rewind());
            writableByteChannel.write((ByteBuffer) this.e.position(0));
            return;
        }
        ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(c51.a(b()));
        g(byteBufferAllocate3);
        c(byteBufferAllocate3);
        ByteBuffer byteBuffer = this.i;
        if (byteBuffer != null) {
            byteBuffer.rewind();
            while (this.i.remaining() > 0) {
                byteBufferAllocate3.put(this.i);
            }
        }
        writableByteChannel.write((ByteBuffer) byteBufferAllocate3.rewind());
    }

    @Override // dc.hf0
    public void f(jf0 jf0Var) {
    }

    public final void g(ByteBuffer byteBuffer) {
        if (k()) {
            ef0.g(byteBuffer, b());
            byteBuffer.put(cf0.y(h()));
        } else {
            ef0.g(byteBuffer, 1L);
            byteBuffer.put(cf0.y(h()));
            ef0.h(byteBuffer, b());
        }
        if ("uuid".equals(h())) {
            byteBuffer.put(i());
        }
    }

    public String h() {
        return this.a;
    }

    public byte[] i() {
        return this.b;
    }

    public boolean j() {
        return this.c;
    }

    public final boolean k() {
        int i = "uuid".equals(h()) ? 24 : 8;
        if (!this.d) {
            return this.g + ((long) i) < 4294967296L;
        }
        if (!this.c) {
            return ((long) (this.e.limit() + i)) < 4294967296L;
        }
        long jD = d();
        ByteBuffer byteBuffer = this.i;
        return (jD + ((long) (byteBuffer != null ? byteBuffer.limit() : 0))) + ((long) i) < 4294967296L;
    }

    public final synchronized void l() {
        m();
        j.b("parsing details of " + h());
        ByteBuffer byteBuffer = this.e;
        if (byteBuffer != null) {
            this.c = true;
            byteBuffer.rewind();
            a(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.i = byteBuffer.slice();
            }
            this.e = null;
        }
    }

    public final synchronized void m() {
        if (!this.d) {
            try {
                j.b("mem mapping " + h());
                this.e = this.h.S(this.f, this.g);
                this.d = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
