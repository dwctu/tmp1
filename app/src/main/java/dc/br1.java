package dc;

import com.wear.bean.Toy;
import dc.zq1;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyControlSingle.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/control/proxyimpl/ToyControlSingle;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class br1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyControlSingle.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017¨\u0006\r"}, d2 = {"Lcom/wear/component/dxtoy/command/control/proxyimpl/ToyControlSingle$Companion;", "Lcom/wear/component/dxtoy/command/control/listener/IToyControlSingle;", "()V", "airLevel", "", "mac", "", "value", "", "rotate", "rotateChange", "thrusting", "vibrate", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements zq1 {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public void a(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                new x40(mac, i).e();
                return;
            }
            pc1.a.e(mac, "Air:Level:" + i + ';');
        }

        @JvmStatic
        public void b(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                new g70(mac, i).e();
                return;
            }
            pc1.a.e(mac, "Rotate:" + i + ';');
        }

        public void c() {
            zq1.a.a(this);
        }

        @JvmStatic
        public void d(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                new p80(mac, i).e();
                return;
            }
            pc1.a.e(mac, "Thrusting:" + i + ';');
        }

        @JvmStatic
        public void e(@NotNull String mac, int i) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            if (mp1.a.b()) {
                new w80(mac, i).e();
                return;
            }
            pc1.a.e(mac, "Vibrate:" + i + ';');
        }

        @Override // dc.zq1
        @JvmStatic
        public void f(@Nullable String str) {
            if (!mp1.a.b()) {
                if (str == null || str.length() == 0) {
                    pc1.a.f("RotateChange;");
                    return;
                } else {
                    pc1.a.e(str, "RotateChange;");
                    return;
                }
            }
            if (!(str == null || str.length() == 0)) {
                new h70(str).e();
                return;
            }
            Iterator<T> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                String address = ((Toy) it.next()).getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "it.address");
                new h70(address).e();
            }
        }
    }
}
