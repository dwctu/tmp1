package dc;

import com.wear.bean.Toy;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BtCommandBusiness.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/lovense/btservice/work/BtCommandBusiness;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class kc1 {

    @NotNull
    public static final a a = new a(null);
    public static int b = 525;

    @Nullable
    public static Timer c = null;
    public static int d = 0;

    @JvmField
    public static int e = -1;

    @JvmField
    public static int f = -1;

    /* compiled from: BtCommandBusiness.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/lovense/btservice/work/BtCommandBusiness$Companion;", "", "()V", "BOOM_PROGRESS_MAX", "", "boomProgress", "boomTimer", "Ljava/util/Timer;", "boomTimerNum", "lastNum", "lastNum2", "rateStep", "reduceStep", "boomLimit", "", "toy", "Lcom/wear/bean/Toy;", "execToyCommand", "", "num", "startBoomTimer", "stopBoomTimer", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* compiled from: BtCommandBusiness.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/lovense/btservice/work/BtCommandBusiness$Companion$startBoomTimer$1", "Ljava/util/TimerTask;", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: dc.kc1$a$a, reason: collision with other inner class name */
        public static final class C0194a extends TimerTask {
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (kc1.d == 101) {
                    a aVar = kc1.a;
                    kc1.b -= 4;
                } else {
                    a aVar2 = kc1.a;
                    kc1.b++;
                }
                a aVar3 = kc1.a;
                kc1.b = Math.min(kc1.b, 525);
                kc1.b = Math.max(kc1.b, 0);
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Toy toy) {
            if (toy.getVersion() != null) {
                Integer version = toy.getVersion();
                Intrinsics.checkNotNullExpressionValue(version, "toy.version");
                if (version.intValue() < 3) {
                    return true;
                }
            }
            return false;
        }

        @JvmStatic
        public final void b(@Nullable Toy toy, int i) {
            if (toy == null) {
                return;
            }
            boolean z = false;
            if (!toy.isConnected()) {
                kc1.d = 0;
                return;
            }
            String type = toy.getType();
            if (i != 101 || (!Intrinsics.areEqual(type, "lush") && !Intrinsics.areEqual(type, "hush"))) {
                kc1.d = i;
                if (toy.isBAToy()) {
                    lc1.a.e(toy, i, true, true);
                    z = true;
                } else if (!toy.isF01Toy()) {
                    String toyFunction = Toy.getToyFunction(toy.getType());
                    Intrinsics.checkNotNullExpressionValue(toyFunction, "getToyFunction(toy.type)");
                    if (StringsKt__StringsKt.contains$default((CharSequence) toyFunction, (CharSequence) "t", false, 2, (Object) null)) {
                        rq1 rq1Var = rq1.d;
                        String address = toy.getAddress();
                        Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                        rq1Var.s(address, i / 5);
                    }
                }
                if (!z) {
                    rq1 rq1Var2 = rq1.d;
                    String address2 = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
                    rq1Var2.t(address2, i / 5);
                }
            } else if (a(toy)) {
                c();
                if ((kc1.d != 101 || kc1.b <= 0) && (kc1.d == 101 || kc1.b <= 60)) {
                    if (!toy.isF01Toy()) {
                        String toyFunction2 = Toy.getToyFunction(toy.getType());
                        Intrinsics.checkNotNullExpressionValue(toyFunction2, "getToyFunction(toy.type)");
                        if (StringsKt__StringsKt.contains$default((CharSequence) toyFunction2, (CharSequence) "t", false, 2, (Object) null)) {
                            rq1 rq1Var3 = rq1.d;
                            String address3 = toy.getAddress();
                            Intrinsics.checkNotNullExpressionValue(address3, "toy.address");
                            rq1Var3.s(address3, 20);
                        }
                    }
                    rq1 rq1Var4 = rq1.d;
                    String address4 = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address4, "toy.address");
                    rq1Var4.t(address4, 20);
                    kc1.d = 100;
                } else {
                    kc1.d = 101;
                    rq1 rq1Var5 = rq1.d;
                    String address5 = toy.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address5, "toy.address");
                    rq1Var5.t(address5, 20);
                }
            } else {
                d();
                if (i == kc1.e && i == kc1.f) {
                    return;
                }
                if (!toy.isF01Toy()) {
                    String toyFunction3 = Toy.getToyFunction(toy.getType());
                    Intrinsics.checkNotNullExpressionValue(toyFunction3, "getToyFunction(toy.type)");
                    if (StringsKt__StringsKt.contains$default((CharSequence) toyFunction3, (CharSequence) "t", false, 2, (Object) null)) {
                        rq1 rq1Var6 = rq1.d;
                        String address6 = toy.getAddress();
                        Intrinsics.checkNotNullExpressionValue(address6, "toy.address");
                        rq1Var6.s(address6, 20);
                    }
                }
                rq1 rq1Var7 = rq1.d;
                String address7 = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address7, "toy.address");
                rq1Var7.t(address7, 20);
            }
            kc1.f = kc1.e;
            kc1.e = i;
        }

        public final void c() {
            if (kc1.c != null) {
                return;
            }
            kc1.c = new Timer();
            Timer timer = kc1.c;
            if (timer != null) {
                timer.schedule(new C0194a(), 100L, 100L);
            }
        }

        public final void d() {
            if (kc1.c != null) {
                Timer timer = kc1.c;
                if (timer != null) {
                    timer.cancel();
                }
                kc1.c = null;
            }
        }
    }
}
