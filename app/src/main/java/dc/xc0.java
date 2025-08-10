package dc;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Crc8Utils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/utils/Crc8Utils;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class xc0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: Crc8Utils.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/utils/Crc8Utils$Companion;", "", "()V", "createCrc8", "", "data", "", "reverseBits", "", "value", "verifyCrc8", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final byte a(@NotNull byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            int iB = 0;
            for (byte b : data) {
                iB ^= xc0.a.b(b) >>> 24;
                for (int i = 0; i < 8; i++) {
                    int i2 = iB & 128;
                    iB <<= 1;
                    if (i2 != 0) {
                        iB ^= 177;
                    }
                }
            }
            return (byte) ((b(iB & 255) >>> 24) ^ 53);
        }

        public final int b(int i) {
            int i2 = (i << 16) | (i >>> 16);
            int i3 = ((i2 & 16711935) << 8) | (((-16711936) & i2) >>> 8);
            int i4 = ((i3 & 252645135) << 4) | (((-252645136) & i3) >>> 4);
            int i5 = ((i4 & 858993459) << 2) | (((-858993460) & i4) >>> 2);
            return ((i5 & 1431655765) << 1) | (((-1431655766) & i5) >>> 1);
        }

        public final boolean c(@NotNull byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.length == 0) {
                return false;
            }
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length - 1);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
            return a(bArrCopyOf) == ArraysKt___ArraysKt.last(data);
        }
    }
}
