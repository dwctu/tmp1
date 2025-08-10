package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: BaseDescriptor.java */
@s41(tags = {0})
/* loaded from: classes2.dex */
public abstract class n41 {
    public int a;
    public int b;
    public int c;

    public int a() {
        return this.b + 1 + this.c;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public final void d(int i, ByteBuffer byteBuffer) throws IOException {
        this.a = i;
        int iL = df0.l(byteBuffer);
        this.b = iL & 127;
        int i2 = 1;
        while ((iL >>> 7) == 1) {
            iL = df0.l(byteBuffer);
            i2++;
            this.b = (this.b << 7) | (iL & 127);
        }
        this.c = i2;
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.limit(this.b);
        e(byteBufferSlice);
        byteBuffer.position(byteBuffer.position() + this.b);
    }

    public abstract void e(ByteBuffer byteBuffer) throws IOException;

    public String toString() {
        return "BaseDescriptor{tag=" + this.a + ", sizeOfInstance=" + this.b + MessageFormatter.DELIM_STOP;
    }
}
