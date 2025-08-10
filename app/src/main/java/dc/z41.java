package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: SLConfigDescriptor.java */
@s41(tags = {6})
/* loaded from: classes2.dex */
public class z41 extends n41 {
    public int d;

    @Override // dc.n41
    public void e(ByteBuffer byteBuffer) throws IOException {
        this.d = df0.l(byteBuffer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && z41.class == obj.getClass() && this.d == ((z41) obj).d;
    }

    public ByteBuffer f() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(3);
        ef0.i(byteBufferAllocate, 6);
        ef0.i(byteBufferAllocate, 1);
        ef0.i(byteBufferAllocate, this.d);
        return byteBufferAllocate;
    }

    public int g() {
        return 3;
    }

    public void h(int i) {
        this.d = i;
    }

    public int hashCode() {
        return this.d;
    }

    @Override // dc.n41
    public String toString() {
        return "SLConfigDescriptor{predefined=" + this.d + MessageFormatter.DELIM_STOP;
    }
}
