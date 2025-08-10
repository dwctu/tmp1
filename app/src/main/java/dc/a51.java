package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: UnknownDescriptor.java */
/* loaded from: classes2.dex */
public class a51 extends n41 {
    public ByteBuffer d;

    static {
        Logger.getLogger(a51.class.getName());
    }

    @Override // dc.n41
    public void e(ByteBuffer byteBuffer) throws IOException {
        this.d = (ByteBuffer) byteBuffer.slice().limit(c());
    }

    @Override // dc.n41
    public String toString() {
        return "UnknownDescriptor{tag=" + this.a + ", sizeOfInstance=" + this.b + ", data=" + this.d + MessageFormatter.DELIM_STOP;
    }
}
