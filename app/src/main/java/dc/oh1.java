package dc;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.MotionEvent;
import dc.th1;
import dc.wh1;
import io.agora.rtm2.RtmConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: MixAnimPlugin.kt */
/* loaded from: classes3.dex */
public final class oh1 implements wh1 {
    public static final /* synthetic */ KProperty[] m = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(oh1.class), "mixTouch", "getMixTouch()Lcom/tencent/qgame/animplayer/mix/MixTouch;"))};

    @Nullable
    public eh1 a;

    @Nullable
    public fh1 b;

    @Nullable
    public uh1 c;

    @Nullable
    public lh1 d;
    public int e;
    public int f;
    public ph1 g;
    public final Lazy h;
    public boolean i;
    public final Object j;
    public boolean k;

    @NotNull
    public final pg1 l;

    /* compiled from: MixAnimPlugin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/graphics/Bitmap;", "it", "", "a", "(Landroid/graphics/Bitmap;)V", "com/tencent/qgame/animplayer/mix/MixAnimPlugin$fetchResourceSync$2$1"}, k = 3, mv = {1, 4, 0})
    public static final class a extends Lambda implements Function1<Bitmap, Unit> {
        public final /* synthetic */ th1 $src;
        public final /* synthetic */ oh1 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(th1 th1Var, oh1 oh1Var) {
            super(1);
            this.$src = th1Var;
            this.this$0 = oh1Var;
        }

        public final void a(@Nullable Bitmap bitmap) {
            Bitmap bitmapA;
            th1 th1Var = this.$src;
            if (bitmap == null) {
                xh1.c.b("AnimPlayer.MixAnimPlugin", "fetch image " + this.$src.i() + " bitmap return null");
                bitmapA = yh1.a.a();
            } else {
                bitmapA = bitmap;
            }
            th1Var.p(bitmapA);
            xh1 xh1Var = xh1.c;
            StringBuilder sb = new StringBuilder();
            sb.append("fetch image ");
            sb.append(this.$src.i());
            sb.append(" finish bitmap is ");
            sb.append(bitmap != null ? Integer.valueOf(bitmap.hashCode()) : null);
            xh1Var.d("AnimPlayer.MixAnimPlugin", sb.toString());
            this.this$0.u();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
            a(bitmap);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: MixAnimPlugin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)V", "com/tencent/qgame/animplayer/mix/MixAnimPlugin$fetchResourceSync$2$2", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ th1 $src;
        public final /* synthetic */ oh1 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(th1 th1Var, oh1 oh1Var) {
            super(1);
            this.$src = th1Var;
            this.this$0 = oh1Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable String str) {
            this.$src.r(str != null ? str : "");
            xh1.c.d("AnimPlayer.MixAnimPlugin", "fetch text " + this.$src.i() + " finish txt is " + str);
            this.this$0.u();
        }
    }

    /* compiled from: MixAnimPlugin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ldc/rh1;", "a", "()Ldc/rh1;"}, k = 3, mv = {1, 4, 0})
    public static final class c extends Lambda implements Function0<rh1> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final rh1 invoke() {
            return new rh1(oh1.this);
        }
    }

    /* compiled from: MixAnimPlugin.kt */
    public static final class d implements Runnable {
        public final /* synthetic */ sh1 a;
        public final /* synthetic */ oh1 b;

        public d(sh1 sh1Var, oh1 oh1Var) {
            this.a = sh1Var;
            this.b = oh1Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            fh1 fh1VarQ = this.b.q();
            if (fh1VarQ != null) {
                fh1VarQ.a(this.a);
            }
        }
    }

    public oh1(@NotNull pg1 player) {
        Intrinsics.checkParameterIsNotNull(player, "player");
        this.l = player;
        this.e = -1;
        this.h = LazyKt__LazyJVMKt.lazy(new c());
        this.i = true;
        this.j = new Object();
    }

    @Override // dc.wh1
    public void a(int i) {
        SparseArray<mh1> sparseArrayA;
        mh1 mh1Var;
        ArrayList<kh1> arrayListB;
        HashMap<String, th1> mapA;
        th1 th1Var;
        ng1 ng1VarB = this.l.d().b();
        if (ng1VarB == null || !ng1VarB.l()) {
            return;
        }
        this.e = i;
        lh1 lh1Var = this.d;
        if (lh1Var == null || (sparseArrayA = lh1Var.a()) == null || (mh1Var = sparseArrayA.get(i)) == null || (arrayListB = mh1Var.b()) == null) {
            return;
        }
        for (kh1 kh1Var : arrayListB) {
            uh1 uh1Var = this.c;
            if (uh1Var != null && (mapA = uh1Var.a()) != null && (th1Var = mapA.get(kh1Var.d())) != null) {
                Intrinsics.checkExpressionValueIsNotNull(th1Var, "srcMap?.map?.get(frame.srcId) ?: return@forEach");
                ph1 ph1Var = this.g;
                if (ph1Var != null) {
                    ph1Var.d(ng1VarB, kh1Var, th1Var);
                }
            }
        }
    }

    @Override // dc.wh1
    public boolean b(@NotNull MotionEvent ev) {
        Intrinsics.checkParameterIsNotNull(ev, "ev");
        ng1 ng1VarB = this.l.d().b();
        if ((ng1VarB != null && !ng1VarB.l()) || this.b == null) {
            return wh1.a.b(this, ev);
        }
        sh1 sh1VarB = o().b(ev);
        if (sh1VarB == null) {
            return true;
        }
        new Handler(Looper.getMainLooper()).post(new d(sh1VarB, this));
        return true;
    }

    @Override // dc.wh1
    public void c() {
        i();
    }

    @Override // dc.wh1
    public void d(int i) {
        wh1.a.a(this, i);
    }

    @Override // dc.wh1
    public void e() {
        ng1 ng1VarB = this.l.d().b();
        if (ng1VarB == null || ng1VarB.l()) {
            xh1.c.d("AnimPlayer.MixAnimPlugin", "mix render init");
            ph1 ph1Var = new ph1(this);
            this.g = ph1Var;
            if (ph1Var != null) {
                ph1Var.b();
            }
        }
    }

    @Override // dc.wh1
    public int f(@NotNull ng1 config) {
        HashMap<String, th1> mapA;
        Collection<th1> collectionValues;
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (!config.l()) {
            return 0;
        }
        if (this.a == null) {
            xh1.c.b("AnimPlayer.MixAnimPlugin", "IFetchResource is empty");
            return 0;
        }
        t(config);
        s(config);
        j();
        if (!h()) {
            return RtmConstants.RTM_ERR_EXCEED_USER_LIMITATION;
        }
        xh1.c.d("AnimPlayer.MixAnimPlugin", "load resource " + this.f);
        uh1 uh1Var = this.c;
        if (uh1Var != null && (mapA = uh1Var.a()) != null && (collectionValues = mapA.values()) != null) {
            for (th1 th1Var : collectionValues) {
                if (th1Var.b() == null) {
                    xh1.c.b("AnimPlayer.MixAnimPlugin", "missing src " + th1Var);
                    return RtmConstants.RTM_ERR_EXCEED_USER_LIMITATION;
                }
                Bitmap bitmapB = th1Var.b();
                if ((bitmapB != null ? bitmapB.getConfig() : null) == Bitmap.Config.ALPHA_8) {
                    xh1.c.b("AnimPlayer.MixAnimPlugin", "src " + th1Var + " bitmap must not be ALPHA_8");
                    return RtmConstants.RTM_ERR_EXCEED_USER_LIMITATION;
                }
            }
        }
        return 0;
    }

    public final boolean h() {
        HashMap<String, th1> mapA;
        Collection<th1> collectionValues;
        try {
            uh1 uh1Var = this.c;
            if (uh1Var != null && (mapA = uh1Var.a()) != null && (collectionValues = mapA.values()) != null) {
                for (th1 src : collectionValues) {
                    if (src.l() == th1.c.TXT) {
                        yh1 yh1Var = yh1.a;
                        Intrinsics.checkExpressionValueIsNotNull(src, "src");
                        src.p(yh1Var.b(src));
                    }
                }
            }
            return true;
        } catch (OutOfMemoryError e) {
            xh1.c.c("AnimPlayer.MixAnimPlugin", "draw text OOM " + e, e);
            return false;
        }
    }

    public final void i() {
        SparseArray<mh1> sparseArrayA;
        HashMap<String, th1> mapA;
        HashMap<String, th1> mapA2;
        Collection<th1> collectionValues;
        Bitmap bitmapB;
        k();
        ng1 ng1VarB = this.l.d().b();
        if (ng1VarB == null || ng1VarB.l()) {
            ArrayList arrayList = new ArrayList();
            uh1 uh1Var = this.c;
            if (uh1Var != null && (mapA2 = uh1Var.a()) != null && (collectionValues = mapA2.values()) != null) {
                for (th1 src : collectionValues) {
                    ph1 ph1Var = this.g;
                    if (ph1Var != null) {
                        ph1Var.c(src.k());
                    }
                    int i = nh1.a[src.l().ordinal()];
                    if (i == 1) {
                        Intrinsics.checkExpressionValueIsNotNull(src, "src");
                        arrayList.add(new sh1(src));
                    } else if (i == 2 && (bitmapB = src.b()) != null) {
                        bitmapB.recycle();
                    }
                }
            }
            eh1 eh1Var = this.a;
            if (eh1Var != null) {
                eh1Var.b(arrayList);
            }
            this.e = -1;
            uh1 uh1Var2 = this.c;
            if (uh1Var2 != null && (mapA = uh1Var2.a()) != null) {
                mapA.clear();
            }
            lh1 lh1Var = this.d;
            if (lh1Var == null || (sparseArrayA = lh1Var.a()) == null) {
                return;
            }
            sparseArrayA.clear();
        }
    }

    public final void j() {
        HashMap<String, th1> mapA;
        Collection<th1> collectionValues;
        HashMap<String, th1> mapA2;
        synchronized (this.j) {
            this.k = false;
            Unit unit = Unit.INSTANCE;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        uh1 uh1Var = this.c;
        int size = (uh1Var == null || (mapA2 = uh1Var.a()) == null) ? 0 : mapA2.size();
        xh1.c.d("AnimPlayer.MixAnimPlugin", "load resource totalSrc = " + size);
        this.f = 0;
        uh1 uh1Var2 = this.c;
        if (uh1Var2 != null && (mapA = uh1Var2.a()) != null && (collectionValues = mapA.values()) != null) {
            for (th1 src : collectionValues) {
                if (src.l() == th1.c.IMG) {
                    xh1.c.d("AnimPlayer.MixAnimPlugin", "fetch image " + src.i());
                    eh1 eh1Var = this.a;
                    if (eh1Var != null) {
                        Intrinsics.checkExpressionValueIsNotNull(src, "src");
                        eh1Var.a(new sh1(src), new a(src, this));
                    }
                } else if (src.l() == th1.c.TXT) {
                    xh1.c.d("AnimPlayer.MixAnimPlugin", "fetch txt " + src.i());
                    eh1 eh1Var2 = this.a;
                    if (eh1Var2 != null) {
                        Intrinsics.checkExpressionValueIsNotNull(src, "src");
                        eh1Var2.c(new sh1(src), new b(src, this));
                    }
                }
            }
        }
        synchronized (this.j) {
            while (this.f < size && !this.k) {
                this.j.wait();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        xh1.c.d("AnimPlayer.MixAnimPlugin", "fetchResourceSync cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms");
    }

    public final void k() {
        synchronized (this.j) {
            this.k = true;
            this.j.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean l() {
        return this.i;
    }

    public final int m() {
        return this.e;
    }

    @Nullable
    public final lh1 n() {
        return this.d;
    }

    public final rh1 o() {
        Lazy lazy = this.h;
        KProperty kProperty = m[0];
        return (rh1) lazy.getValue();
    }

    @Override // dc.wh1
    public void onDestroy() {
        i();
    }

    @NotNull
    public final pg1 p() {
        return this.l;
    }

    @Nullable
    public final fh1 q() {
        return this.b;
    }

    @Nullable
    public final uh1 r() {
        return this.c;
    }

    public final void s(ng1 ng1Var) {
        JSONObject jSONObjectE = ng1Var.e();
        if (jSONObjectE != null) {
            this.d = new lh1(jSONObjectE);
        }
    }

    public final void t(ng1 ng1Var) {
        JSONObject jSONObjectE = ng1Var.e();
        if (jSONObjectE != null) {
            this.c = new uh1(jSONObjectE);
        }
    }

    public final void u() {
        synchronized (this.j) {
            this.f++;
            this.j.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void v(@Nullable fh1 fh1Var) {
        this.b = fh1Var;
    }

    public final void w(@Nullable eh1 eh1Var) {
        this.a = eh1Var;
    }
}
