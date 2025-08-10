package dc;

import androidx.annotation.NonNull;
import dc.jh;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder.java */
/* loaded from: classes.dex */
public class im implements jh<ByteBuffer> {
    public final ByteBuffer a;

    /* compiled from: ByteBufferRewinder.java */
    public static class a implements jh.a<ByteBuffer> {
        @Override // dc.jh.a
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public jh<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new im(byteBuffer);
        }

        @Override // dc.jh.a
        @NonNull
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }
    }

    public im(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // dc.jh
    public void a() {
    }

    @Override // dc.jh
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer b() {
        this.a.position(0);
        return this.a;
    }
}
