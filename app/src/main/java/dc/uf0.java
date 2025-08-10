package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: SampleDescriptionBox.java */
/* loaded from: classes.dex */
public class uf0 extends f41 implements hf0 {
    public int j;
    public int k;

    public uf0() {
        super("stsd");
    }

    @Override // dc.f41, dc.hf0
    public long b() {
        long jP = p() + 8;
        return jP + ((this.i || 8 + jP >= 4294967296L) ? 16 : 8);
    }

    @Override // dc.f41, dc.hf0
    public void e(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(y());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        ef0.i(byteBufferAllocate, this.j);
        ef0.f(byteBufferAllocate, this.k);
        ef0.g(byteBufferAllocate, m().size());
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        x(writableByteChannel);
    }
}
