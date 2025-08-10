package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: AbstractContainerBox.java */
/* loaded from: classes2.dex */
public class f41 extends h41 implements hf0 {
    public String h;
    public boolean i;

    public f41(String str) {
        this.h = str;
    }

    @Override // dc.hf0
    public long b() {
        long jP = p();
        return jP + ((this.i || 8 + jP >= 4294967296L) ? 16 : 8);
    }

    @Override // dc.hf0
    public void e(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(y());
        x(writableByteChannel);
    }

    @Override // dc.hf0
    public void f(jf0 jf0Var) {
    }

    public ByteBuffer y() {
        ByteBuffer byteBufferWrap;
        if (this.i || b() >= 4294967296L) {
            byte[] bArr = new byte[16];
            bArr[3] = 1;
            bArr[4] = this.h.getBytes()[0];
            bArr[5] = this.h.getBytes()[1];
            bArr[6] = this.h.getBytes()[2];
            bArr[7] = this.h.getBytes()[3];
            byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.position(8);
            ef0.h(byteBufferWrap, b());
        } else {
            byteBufferWrap = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, this.h.getBytes()[0], this.h.getBytes()[1], this.h.getBytes()[2], this.h.getBytes()[3]});
            ef0.g(byteBufferWrap, b());
        }
        byteBufferWrap.rewind();
        return byteBufferWrap;
    }
}
