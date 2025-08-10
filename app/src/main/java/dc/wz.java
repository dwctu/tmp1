package dc;

import com.component.dxhyttoutils.lib.protect.P;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: DXValueBaseUtils.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0002¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00042\n\u0010\f\u001a\u00020\r\"\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\f\u001a\u00020\r\"\u00020\u000eJ\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0002¨\u0006\u0014"}, d2 = {"Lcom/component/dxhyttoutils/lib/utils/dxvalue/DXValueBaseUtils;", "", "()V", "appendValue", "", "time", "", "values", "", "", "(J[[B)Ljava/lang/String;", "getValue", UserMetadata.KEYDATA_FILENAME, "", "", "getValueWithCode", "appCode", "Lcom/component/dxhyttoutils/lib/data/HyttoEum$AppCode;", "offsetValue", "value", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class wz {

    /* compiled from: DXValueBaseUtils.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function1<byte[], CharSequence> {
        public final /* synthetic */ long $time;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j) {
            super(1);
            this.$time = j;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(@NotNull byte[] it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return wz.this.d(this.$time, it);
        }
    }

    public final String b(long j, byte[]... bArr) {
        return ArraysKt___ArraysKt.joinToString$default(bArr, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new a(j), 30, (Object) null);
    }

    @NotNull
    public final String c(@NotNull int... keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        ArrayList arrayList = new ArrayList(keys.length);
        int length = keys.length;
        int i = 0;
        while (i < length) {
            int i2 = keys[i];
            i++;
            byte[] bArr_free = P.INSTANCE._free(gz.a.c().b().getCode(), i2, jCurrentTimeMillis);
            if (bArr_free == null) {
                bArr_free = new byte[0];
            }
            arrayList.add(bArr_free);
        }
        Object[] array = arrayList.toArray(new byte[0][]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        byte[][] bArr = (byte[][]) array;
        String strA = qx.a(b(jCurrentTimeMillis, (byte[][]) Arrays.copyOf(bArr, bArr.length)));
        return strA == null ? "" : strA;
    }

    public final String d(long j, byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        try {
            byte[] bArrArray = ByteBuffer.allocate(8).putLong(j).array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "allocate(8).putLong(time).array()");
            byte[] bArrReversedArray = ArraysKt___ArraysKt.reversedArray(bArrArray);
            int length = bArrReversedArray.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                byte b = (byte) (bArr[i] ^ bArrReversedArray[i]);
                if (b != 0) {
                    bArr[i] = b;
                }
                i = i2;
            }
            bArr[bArr.length - 1] = (byte) (bArr[bArr.length - 1] - 1);
            return new String(bArr, Charsets.UTF_8);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            de0.l(new String(bArr, Charsets.UTF_8), Long.valueOf(j));
            return "";
        }
    }
}
