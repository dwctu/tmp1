package dc;

import com.google.android.exoplayer2.ExoPlayer;
import com.wear.bean.event.NinjaLockTimeEvent;
import dc.md2;
import dc.q90;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NinjaLockUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/wear/main/ninja/utils/NinjaLockUtils;", "", "()V", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class md2 {

    @NotNull
    public static final a a = new a(null);

    @Nullable
    public static q90.b b;

    /* compiled from: NinjaLockUtils.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/wear/main/ninja/utils/NinjaLockUtils$Companion;", "", "()V", "task", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "getTask", "()Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "startLockTime", "", "stopLockTime", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void a() {
            wb0.a.a(new NinjaLockTimeEvent());
        }

        public final q90.b b() {
            if (md2.b == null) {
                md2.b = new q90.b() { // from class: dc.ld2
                    @Override // dc.q90.b
                    public final void execute() {
                        md2.a.a();
                    }
                };
            }
            return md2.b;
        }

        @JvmStatic
        public final void d() {
            q90.b bVarB;
            if (mp1.a.b() && (bVarB = b()) != null) {
                f90.a.a(bVarB, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        }

        @JvmStatic
        public final void e() {
            if (mp1.a.b()) {
                q90.b bVarB = b();
                if (bVarB != null) {
                    f90.a.i(bVarB);
                }
                md2.b = null;
            }
        }
    }

    @JvmStatic
    public static final void c() {
        a.d();
    }

    @JvmStatic
    public static final void d() {
        a.e();
    }
}
