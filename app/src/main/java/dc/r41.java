package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: DecoderSpecificInfo.java */
@s41(tags = {5})
/* loaded from: classes2.dex */
public class r41 extends n41 {
    public byte[] d;

    @Override // dc.n41
    public void e(ByteBuffer byteBuffer) throws IOException {
        int i = this.b;
        if (i > 0) {
            byte[] bArr = new byte[i];
            this.d = bArr;
            byteBuffer.get(bArr);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && r41.class == obj.getClass() && Arrays.equals(this.d, ((r41) obj).d);
    }

    public int hashCode() {
        byte[] bArr = this.d;
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    @Override // dc.n41
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderSpecificInfo");
        sb.append("{bytes=");
        byte[] bArr = this.d;
        sb.append(bArr == null ? "null" : bf0.a(bArr));
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }
}
