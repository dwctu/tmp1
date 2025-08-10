package dc;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyScanFailedEvent.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/component/dxtoy/core/api/event/ToyScanFailedEvent;", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/String;)V", "getCode", "()Lcom/component/dxbluetooth/lib/data/BleEum$Result;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class o90 {

    @Nullable
    public String a;

    public o90(@NotNull mt code, @Nullable String str) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.a = str;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getA() {
        return this.a;
    }
}
