package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: ExtensionProfileLevelDescriptor.java */
@s41(tags = {19})
/* loaded from: classes2.dex */
public class v41 extends n41 {
    public byte[] d;

    @Override // dc.n41
    public void e(ByteBuffer byteBuffer) throws IOException {
        if (a() > 0) {
            byte[] bArr = new byte[a()];
            this.d = bArr;
            byteBuffer.get(bArr);
        }
    }

    @Override // dc.n41
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionDescriptor");
        sb.append("{bytes=");
        byte[] bArr = this.d;
        sb.append(bArr == null ? "null" : bf0.a(bArr));
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }
}
