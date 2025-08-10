package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: ProfileLevelIndicationDescriptor.java */
@s41(tags = {20})
/* loaded from: classes2.dex */
public class y41 extends n41 {
    public int d;

    @Override // dc.n41
    public void e(ByteBuffer byteBuffer) throws IOException {
        this.d = df0.l(byteBuffer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && y41.class == obj.getClass() && this.d == ((y41) obj).d;
    }

    public int hashCode() {
        return this.d;
    }

    @Override // dc.n41
    public String toString() {
        return "ProfileLevelIndicationDescriptor{profileLevelIndicationIndex=" + Integer.toHexString(this.d) + MessageFormatter.DELIM_STOP;
    }
}
