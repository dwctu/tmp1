package dc;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: BtUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/utils/BtUtils;", "", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class fa0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: BtUtils.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/component/dxtoy/core/bluetooth/utils/BtUtils$Companion;", "", "()V", "checkPermissionBtScan", "", "checkPermissionBtScanAndLocation", "checkPermissionLocation", "requestPermissionLocation", "", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return Build.VERSION.SDK_INT < 31 || ve0.a().getPackageManager().checkPermission("android.permission.BLUETOOTH_SCAN", ve0.a().getPackageName()) == 0;
        }

        public final boolean b() {
            return a();
        }
    }
}
