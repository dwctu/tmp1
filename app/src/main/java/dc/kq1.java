package dc;

import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import dc.oq1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyCmdBridgeLog.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeLog;", "Lcom/wear/component/dxtoy/command/common/bridge/base/BaseToyCmdBridgeLog;", "()V", "Companion", "LogType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class kq1 extends oq1 {

    @NotNull
    public static final a f = new a(null);

    /* compiled from: ToyCmdBridgeLog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeLog$Companion;", "", "()V", "defaultLog", "", NotificationCompat.CATEGORY_MESSAGE, "", "questionLog", "sendLog", "cmd", "unknownLog", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            oq1.d dVar = oq1.a;
            if (oq1.f()) {
                return;
            }
            oq1.e("ToyCmdBridgeLog", msg, b.DEFAULT);
        }

        public final void b(@Nullable String str) {
            oq1.d dVar = oq1.a;
            if (oq1.f() || str == null) {
                return;
            }
            oq1.e("ToyCmdBridgeLog", str, b.QUESTION);
        }

        public final void c(@NotNull String msg, @NotNull String cmd) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            oq1.d dVar = oq1.a;
            if (oq1.f()) {
                return;
            }
            a(msg);
            oq1.g(cmd);
        }

        public final void d(@NotNull String msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            oq1.d dVar = oq1.a;
            if (oq1.f()) {
                return;
            }
            oq1.e("ToyCmdBridgeLog", msg, b.UNKNOWN);
        }
    }

    /* compiled from: ToyCmdBridgeLog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/wear/component/dxtoy/command/common/bridge/ToyCmdBridgeLog$LogType;", "", "isWithTime", "", "isFileNameDay", "(Ljava/lang/String;IZZ)V", "()Z", "SINGLE", "DEFAULT", GrsBaseInfo.CountryCodeSource.UNKNOWN, "QUESTION", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum b {
        SINGLE(false, false),
        DEFAULT(false, false, 3, null),
        UNKNOWN(false, false, 3, null),
        QUESTION(false, false, 3, null);

        private final boolean isFileNameDay;
        private final boolean isWithTime;

        b(boolean z, boolean z2) {
            this.isWithTime = z;
            this.isFileNameDay = z2;
        }

        /* renamed from: isFileNameDay, reason: from getter */
        public final boolean getIsFileNameDay() {
            return this.isFileNameDay;
        }

        /* renamed from: isWithTime, reason: from getter */
        public final boolean getIsWithTime() {
            return this.isWithTime;
        }

        /* synthetic */ b(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
        }
    }
}
