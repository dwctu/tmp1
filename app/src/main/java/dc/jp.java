package dc;

import android.content.Context;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: AndroidResourceSignature.java */
/* loaded from: classes.dex */
public final class jp implements xg {
    public final int b;
    public final xg c;

    public jp(int i, xg xgVar) {
        this.b = i;
        this.c = xgVar;
    }

    @NonNull
    public static xg c(@NonNull Context context) {
        return new jp(context.getResources().getConfiguration().uiMode & 48, kp.c(context));
    }

    @Override // dc.xg
    public void b(@NonNull MessageDigest messageDigest) {
        this.c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // dc.xg
    public boolean equals(Object obj) {
        if (!(obj instanceof jp)) {
            return false;
        }
        jp jpVar = (jp) obj;
        return this.b == jpVar.b && this.c.equals(jpVar.c);
    }

    @Override // dc.xg
    public int hashCode() {
        return wp.o(this.c, this.b);
    }
}
