package dc;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import dc.qt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BleNotifyResponse.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&¨\u0006\t"}, d2 = {"Lcom/component/dxbluetooth/lib/response/BleNotifyResponse;", "Lcom/component/dxbluetooth/lib/listener/IBaseBleResponse;", "", "onNotify", "", NotificationCompat.CATEGORY_SERVICE, "Ljava/util/UUID;", FirebaseAnalytics.Param.CHARACTER, "value", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface bw extends qt<byte[]> {

    /* compiled from: BleNotifyResponse.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static void a(@NotNull bw bwVar, @NotNull mt code, @Nullable String str) {
            Intrinsics.checkNotNullParameter(bwVar, "this");
            Intrinsics.checkNotNullParameter(code, "code");
            qt.a.a(bwVar, code, str);
        }
    }

    void c(@Nullable UUID uuid, @Nullable UUID uuid2, @Nullable byte[] bArr);
}
