package dc;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import dc.dh1;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Decoder.kt */
/* loaded from: classes3.dex */
public abstract class sg1 implements dh1 {
    public static final /* synthetic */ KProperty[] k = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(sg1.class), "speedControlUtil", "getSpeedControlUtil()Lcom/tencent/qgame/animplayer/util/SpeedControlUtil;"))};
    public static final a l = new a(null);

    @Nullable
    public xg1 a;

    @NotNull
    public final ug1 b;

    @NotNull
    public final ug1 c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;

    @NotNull
    public final Lazy i;

    @NotNull
    public final pg1 j;

    /* compiled from: Decoder.kt */
    public static final class a {
        public a() {
        }

        public final boolean a(@NotNull ug1 handlerHolder, @NotNull String name) {
            HandlerThread handlerThreadB;
            Intrinsics.checkParameterIsNotNull(handlerHolder, "handlerHolder");
            Intrinsics.checkParameterIsNotNull(name, "name");
            try {
                if (handlerHolder.b() != null && ((handlerThreadB = handlerHolder.b()) == null || handlerThreadB.isAlive())) {
                    return true;
                }
                HandlerThread handlerThread = new HandlerThread(name);
                handlerThread.start();
                handlerHolder.c(new Handler(handlerThread.getLooper()));
                handlerHolder.d(handlerThread);
                return true;
            } catch (OutOfMemoryError e) {
                xh1.c.c("AnimPlayer.Decoder", "createThread OOM", e);
                return false;
            }
        }

        @Nullable
        public final HandlerThread b(@Nullable HandlerThread handlerThread) {
            if (handlerThread == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
                return null;
            }
            handlerThread.quit();
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Decoder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ldc/ki1;", "a", "()Ldc/ki1;"}, k = 3, mv = {1, 4, 0})
    public static final class b extends Lambda implements Function0<ki1> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ki1 invoke() {
            return new ki1();
        }
    }

    public sg1(@NotNull pg1 player) {
        Intrinsics.checkParameterIsNotNull(player, "player");
        this.j = player;
        this.b = new ug1(null, null);
        this.c = new ug1(null, null);
        this.i = LazyKt__LazyJVMKt.lazy(b.a);
    }

    public final void A() {
        this.h = true;
    }

    @Override // dc.dh1
    public void a() {
        xh1.c.d("AnimPlayer.Decoder", "onVideoComplete");
        dh1 dh1VarB = this.j.b();
        if (dh1VarB != null) {
            dh1VarB.a();
        }
    }

    @Override // dc.dh1
    public void b() {
        xh1.c.d("AnimPlayer.Decoder", "onVideoDestroy");
        dh1 dh1VarB = this.j.b();
        if (dh1VarB != null) {
            dh1VarB.b();
        }
    }

    @Override // dc.dh1
    public void c(int i, @Nullable String str) {
        xh1.c.b("AnimPlayer.Decoder", "onFailed errorType=" + i + ", errorMsg=" + str);
        dh1 dh1VarB = this.j.b();
        if (dh1VarB != null) {
            dh1VarB.c(i, str);
        }
    }

    @Override // dc.dh1
    public void d() {
        xh1.c.d("AnimPlayer.Decoder", "onVideoStart");
        dh1 dh1VarB = this.j.b();
        if (dh1VarB != null) {
            dh1VarB.d();
        }
    }

    @Override // dc.dh1
    public void e(int i, @Nullable ng1 ng1Var) {
        xh1.c.a("AnimPlayer.Decoder", "onVideoRender");
        dh1 dh1VarB = this.j.b();
        if (dh1VarB != null) {
            dh1VarB.e(i, ng1Var);
        }
    }

    @Override // dc.dh1
    public boolean f(@NotNull ng1 config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        return dh1.a.a(this, config);
    }

    public abstract void g();

    public final void h() {
        if (this.j.n()) {
            xh1.c.d("AnimPlayer.Decoder", "destroyThread");
            Handler handlerA = this.b.a();
            if (handlerA != null) {
                handlerA.removeCallbacksAndMessages(null);
            }
            Handler handlerA2 = this.c.a();
            if (handlerA2 != null) {
                handlerA2.removeCallbacksAndMessages(null);
            }
            ug1 ug1Var = this.b;
            a aVar = l;
            ug1Var.d(aVar.b(ug1Var.b()));
            ug1 ug1Var2 = this.c;
            ug1Var2.d(aVar.b(ug1Var2.b()));
            this.b.c(null);
            this.c.c(null);
        }
    }

    @NotNull
    public final ug1 i() {
        return this.c;
    }

    public final int j() {
        return this.f;
    }

    @NotNull
    public final pg1 k() {
        return this.j;
    }

    @Nullable
    public final xg1 l() {
        return this.a;
    }

    @NotNull
    public final ug1 m() {
        return this.b;
    }

    @NotNull
    public final ki1 n() {
        Lazy lazy = this.i;
        KProperty kProperty = k[0];
        return (ki1) lazy.getValue();
    }

    public final boolean o() {
        return this.g;
    }

    public final boolean p() {
        return this.h;
    }

    public final void q(int i, int i2) {
        this.d = i;
        this.e = i2;
        xg1 xg1Var = this.a;
        if (xg1Var != null) {
            xg1Var.a(i, i2);
        }
    }

    public final void r(int i, int i2) {
        xg1 xg1Var;
        this.j.d().a(i, i2);
        ng1 ng1VarB = this.j.d().b();
        if (ng1VarB != null && (xg1Var = this.a) != null) {
            xg1Var.f(ng1VarB);
        }
        this.j.j().h();
    }

    public final boolean s(boolean z) {
        if (this.a == null) {
            xh1 xh1Var = xh1.c;
            xh1Var.d("AnimPlayer.Decoder", "prepareRender");
            SurfaceTexture surfaceTexture = this.j.c().getSurfaceTexture();
            if (surfaceTexture != null) {
                if (z) {
                    xh1Var.d("AnimPlayer.Decoder", "use yuv render");
                    this.a = new ah1(surfaceTexture);
                } else {
                    zg1 zg1Var = new zg1(surfaceTexture);
                    zg1Var.a(this.d, this.e);
                    this.a = zg1Var;
                }
            }
        }
        return this.a != null;
    }

    public final boolean t() {
        a aVar = l;
        return aVar.a(this.b, "anim_render_thread") && aVar.a(this.c, "anim_decode_thread");
    }

    public final void u(int i) {
        n().c(i);
    }

    public final void v(int i) {
        this.f = i;
    }

    public final void w(@Nullable xg1 xg1Var) {
        this.a = xg1Var;
    }

    public final void x(boolean z) {
        this.g = z;
    }

    public final void y(boolean z) {
        this.h = z;
    }

    public abstract void z(@NotNull ch1 ch1Var);
}
