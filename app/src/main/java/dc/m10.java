package dc;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import dc.oa0;
import dc.sa0;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCmdAAHandler.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ5\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0002¨\u0006\u0018"}, d2 = {"Lcom/component/dxtoy/business/longc/handler/ToyCmdAAHandler;", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "", "", "()V", "dataToToyAAEvent", "Lcom/component/dxtoy/business/longc/event/ToyAAEvent;", "mac", "", "bytes", "", "handleCommand", ExifInterface.GPS_DIRECTION_TRUE, "value", "sendCommand", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)Ljava/lang/Object;", "isAABytes", "", "isHandle", "sendAA", "", "type", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class m10 implements sa0<List<? extends Integer>> {

    @NotNull
    public static final m10 b = new m10();

    /* compiled from: ToyCmdAAHandler.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<Byte, CharSequence> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @NotNull
        public final CharSequence a(byte b) {
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
            return str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
            return a(b.byteValue());
        }
    }

    @Override // dc.sa0
    public boolean a(@NotNull String mac, @NotNull String value, @NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return e(bytes) && xc0.a.c(bytes);
    }

    @Override // dc.sa0
    public boolean b(@NotNull String str, @NotNull String str2, @NotNull byte[] bArr, @NotNull String str3) {
        return sa0.b.b(this, str, str2, bArr, str3);
    }

    @Override // dc.sa0
    @Nullable
    public <T> T c(@NotNull String mac, @NotNull String value, @NotNull byte[] bytes, @NotNull String sendCommand) {
        l10 l10VarD;
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
        if (yb0.e(mac) == null || (l10VarD = b.d(mac, bytes)) == null) {
            return null;
        }
        wb0.a.a(l10VarD);
        return null;
    }

    @Nullable
    public final l10 d(@NotNull String mac, @NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            byte b2 = bytes[1];
            byte b3 = bytes[2];
            byte b4 = bytes[3];
            byte[] bArrCopyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(bytes, 4, bytes.length - 1);
            if (b4 != bArrCopyOfRange.length) {
                de0.l("AA指令 - 参数解析失败");
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AA指令 - 参数解析成功 - ");
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
            sb.append(str);
            sb.append(" - ");
            String str2 = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b3)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(this, *args)");
            sb.append(str2);
            sb.append(" - ");
            sb.append(ArraysKt___ArraysKt.joinToString$default(bArrCopyOfRange, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) a.a, 30, (Object) null));
            de0.i(sb.toString());
            return new l10(mac, b2, b3, bArrCopyOfRange);
        } catch (Exception e) {
            e.printStackTrace();
            de0.l("AA指令 - 解析异常");
            return null;
        }
    }

    public final boolean e(byte[] bArr) {
        return ((bArr.length == 0) ^ true) && bArr[0] == -86;
    }

    public final void f(@NotNull String mac, byte b2, @NotNull List<byte[]> params) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(params, "params");
        o40 o40Var = new o40(mac, b2, params);
        o40Var.addSendType(new oa0.c(0, 1, null));
        o40Var.addSendType(new oa0.e(false, null, 2, null));
        o40Var.e();
    }

    @Override // dc.sa0
    @Nullable
    public ta0<List<? extends Integer>> getCallback() {
        return sa0.b.a(this);
    }
}
