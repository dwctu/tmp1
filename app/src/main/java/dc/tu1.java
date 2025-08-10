package dc;

import com.wear.bean.Toy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"deviceIdToMac", "", "Lcom/wear/bean/Toy;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class tu1 {
    public static final void a(@NotNull Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "<this>");
        String deviceId = toy.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId, "this.deviceId");
        String upperCase = CollectionsKt___CollectionsKt.joinToString$default(StringsKt___StringsKt.chunked(deviceId, 2), SignatureImpl.INNER_SEP, null, null, 0, null, null, 62, null).toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
        toy.setAddress(upperCase);
    }
}
