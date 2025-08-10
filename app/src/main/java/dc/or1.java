package dc;

import com.wear.bean.Toy;
import com.wear.bean.event.ToyCtrlGameEvent;
import com.wear.bean.event.ToyGserEvent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyFeedback.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/component/dxtoy/command/feedback/ToyFeedback;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class or1 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyFeedback.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0007J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u0012\u001a\u00020\bH\u0007J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0013"}, d2 = {"Lcom/wear/component/dxtoy/command/feedback/ToyFeedback$Companion;", "", "()V", "isSupportGser", "", "toy", "Lcom/wear/bean/Toy;", "sendGserCommand", "", "model", "", "setGser", "mac", "", "value", "setNotify", "turnOn", "startFeedbackMode", "stopFeedbackMode", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Toy toy) {
            int toyVersion = toy.getToyVersion();
            if (toy.isMax()) {
                if (!(332 <= toyVersion && toyVersion < 370)) {
                    if (221 <= toyVersion && toyVersion < 300) {
                    }
                }
                return true;
            }
            if (toy.isNora()) {
                if (!(283 <= toyVersion && toyVersion < 310)) {
                    if (!(143 <= toyVersion && toyVersion < 160)) {
                        if (242 <= toyVersion && toyVersion < 280) {
                        }
                    }
                }
                return true;
            }
            return false;
        }

        @JvmStatic
        public final void b(int i) {
            Iterator<T> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                or1.a.c((Toy) it.next(), i);
            }
        }

        @JvmStatic
        public final void c(@Nullable Toy toy, int i) {
            if (toy != null) {
                a aVar = or1.a;
                if (aVar.a(toy)) {
                    String address = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "it.address");
                    aVar.d(address, i);
                }
            }
        }

        public final void d(String str, int i) {
            if (mp1.a.b()) {
                r00.a.a(str, i);
                return;
            }
            pc1.a.e(str, "Gser:" + i + ';');
        }

        public final void e(String str, boolean z) {
            if (mp1.a.b()) {
                r00.a.b(str, z);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Notify:");
            sb.append(z ? "On" : "Off");
            sb.append(';');
            pc1.a.e(str, sb.toString());
        }

        @JvmStatic
        public final void f() {
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "BtWork.getNowToysConnectList()");
                Toy toy = next;
                if (toy.isFeedbackModeEnable()) {
                    g(toy);
                }
            }
        }

        @JvmStatic
        public final void g(@Nullable Toy toy) {
            if (toy == null) {
                return;
            }
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            e(address, true);
        }

        @JvmStatic
        public final void h() {
            Iterator<Toy> it = pc1.a.P().iterator();
            while (it.hasNext()) {
                Toy next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "BtWork.getNowToysConnectList()");
                Toy toy = next;
                if (toy.isFeedbackModeEnable()) {
                    i(toy);
                }
            }
        }

        @JvmStatic
        public final void i(@Nullable Toy toy) {
            if (toy == null) {
                return;
            }
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            e(address, false);
        }
    }

    static {
        t00.b.d(new ta0() { // from class: dc.mr1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                or1.a((Unit) obj, str, str2, bArr, str3);
            }
        });
        s00.b.d(new ta0() { // from class: dc.nr1
            @Override // dc.ta0
            public final void a(Object obj, String str, String str2, byte[] bArr, String str3) {
                or1.b((Unit) obj, str, str2, bArr, str3);
            }
        });
    }

    public static final void a(Unit unit, String mac, String value, byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bArr, "<anonymous parameter 3>");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 4>");
        EventBus.getDefault().post(new ToyCtrlGameEvent(21, mac, value));
    }

    public static final void b(Unit unit, String mac, String value, byte[] bArr, String str) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(bArr, "<anonymous parameter 3>");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 4>");
        EventBus.getDefault().post(new ToyGserEvent(mac, value));
    }

    @JvmStatic
    public static final void e(int i) {
        a.b(i);
    }

    @JvmStatic
    public static final void f() {
        a.h();
    }
}
