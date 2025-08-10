package dc;

import androidx.exifinterface.media.ExifInterface;
import com.sun.jna.Callback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IToyCommandHandler.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\bf\u0018\u0000 \u0014*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0014J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J5\u0010\u0011\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH&¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R4\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandlerCallback;", Callback.METHOD_NAME, "getCallback", "()Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandlerCallback;", "setCallback", "(Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandlerCallback;)V", "handle", "", "mac", "", "bytes", "", "sendCommand", "handleCommand", "(Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;)Ljava/lang/Object;", "isHandle", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public interface sa0<T> {

    @NotNull
    public static final a a = a.a;

    /* compiled from: IToyCommandHandler.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R8\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler$Companion;", "", "()V", "_callbackAll", "Ljava/lang/ref/WeakReference;", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandlerCallback;", "value", "callbackAll", "getCallbackAll", "()Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandlerCallback;", "setCallbackAll", "(Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandlerCallback;)V", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static final /* synthetic */ a a = new a();

        @Nullable
        public static WeakReference<ta0<Object>> b;

        @Nullable
        public final ta0<Object> a() {
            WeakReference<ta0<Object>> weakReference = b;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
    }

    /* compiled from: IToyCommandHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        @Nullable
        public static <T> ta0<T> a(@NotNull sa0<T> sa0Var) {
            return ra0.a.a(sa0Var);
        }

        public static <T> boolean b(@NotNull sa0<T> sa0Var, @NotNull String mac, @NotNull String value, @NotNull byte[] bytes, @NotNull String sendCommand) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            Intrinsics.checkNotNullParameter(sendCommand, "sendCommand");
            boolean zA = sa0Var.a(mac, value, bytes);
            if (zA) {
                T tC = sa0Var.c(mac, value, bytes, sendCommand);
                ta0<T> callback = sa0Var.getCallback();
                if (callback != null) {
                    callback.a(tC, mac, value, bytes, sendCommand);
                }
                ta0<Object> ta0VarA = sa0.a.a();
                if (ta0VarA != null) {
                    ta0VarA.a(tC, mac, value, bytes, sendCommand);
                }
            }
            return zA;
        }

        public static <T> void c(@NotNull sa0<T> sa0Var, @Nullable ta0<T> ta0Var) {
            ra0.a.b(sa0Var, ta0Var);
        }
    }

    boolean a(@NotNull String str, @NotNull String str2, @NotNull byte[] bArr);

    boolean b(@NotNull String str, @NotNull String str2, @NotNull byte[] bArr, @NotNull String str3);

    @Nullable
    <T> T c(@NotNull String str, @NotNull String str2, @NotNull byte[] bArr, @NotNull String str3);

    @Nullable
    ta0<T> getCallback();
}
