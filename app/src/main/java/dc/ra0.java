package dc;

import androidx.exifinterface.media.ExifInterface;
import com.sun.jna.Callback;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IToyCommandHandler.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u0006\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005J*\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u0006R>\u0010\u0003\u001a2\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0004j\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/component/dxtoy/core/commandcore/dispatcher/base/CallbackStorage;", "", "()V", "callbackHashMap", "Ljava/util/HashMap;", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandler;", "Lcom/component/dxtoy/core/commandcore/dispatcher/base/IToyCommandHandlerCallback;", "Lkotlin/collections/HashMap;", "getCallback", ExifInterface.GPS_DIRECTION_TRUE, "handler", "setCallback", "", Callback.METHOD_NAME, "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ra0 {

    @NotNull
    public static final ra0 a = new ra0();

    @NotNull
    public static final HashMap<sa0<?>, ta0<?>> b = new HashMap<>();

    @Nullable
    public final <T> ta0<T> a(@NotNull sa0<T> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Object obj = b.get(handler);
        if (obj instanceof ta0) {
            return (ta0) obj;
        }
        return null;
    }

    public final <T> void b(@NotNull sa0<T> handler, @Nullable ta0<T> ta0Var) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (ta0Var == null) {
            b.remove(handler);
        } else {
            b.put(handler, ta0Var);
        }
    }
}
