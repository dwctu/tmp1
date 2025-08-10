package dc;

import android.view.MotionEvent;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnimPluginManager.kt */
/* loaded from: classes3.dex */
public final class vh1 {
    public final oh1 a;
    public final gh1 b;
    public final List<wh1> c;
    public int d;
    public int e;
    public int f;

    @NotNull
    public final pg1 g;

    public vh1(@NotNull pg1 player) {
        Intrinsics.checkParameterIsNotNull(player, "player");
        this.g = player;
        oh1 oh1Var = new oh1(player);
        this.a = oh1Var;
        gh1 gh1Var = new gh1(player);
        this.b = gh1Var;
        this.c = CollectionsKt__CollectionsKt.listOf((Object[]) new wh1[]{oh1Var, gh1Var});
    }

    @Nullable
    public final oh1 a() {
        return this.a;
    }

    public final int b(@NotNull ng1 config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        xh1.c.d("AnimPlayer.AnimPluginManager", "onConfigCreate");
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            int iF = ((wh1) it.next()).f(config);
            if (iF != 0) {
                return iF;
            }
        }
        return 0;
    }

    public final void c(int i) {
        xh1.c.a("AnimPlayer.AnimPluginManager", "onDecoding decodeIndex=" + i);
        this.e = i;
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            ((wh1) it.next()).d(i);
        }
    }

    public final void d() {
        xh1.c.d("AnimPlayer.AnimPluginManager", "onDestroy");
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            ((wh1) it.next()).onDestroy();
        }
    }

    public final boolean e(@NotNull MotionEvent ev) {
        Intrinsics.checkParameterIsNotNull(ev, "ev");
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            if (((wh1) it.next()).b(ev)) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        xh1.c.d("AnimPlayer.AnimPluginManager", "onLoopStart");
        this.d = 0;
        this.e = 0;
    }

    public final void g() {
        xh1.c.d("AnimPlayer.AnimPluginManager", "onRelease");
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            ((wh1) it.next()).c();
        }
    }

    public final void h() {
        xh1.c.d("AnimPlayer.AnimPluginManager", "onRenderCreate");
        this.d = 0;
        this.e = 0;
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            ((wh1) it.next()).e();
        }
    }

    public final void i() {
        if (this.e > this.d + 1 || this.f >= 4) {
            xh1.c.d("AnimPlayer.AnimPluginManager", "jump frameIndex= " + this.d + ",decodeIndex=" + this.e + ",frameDiffTimes=" + this.f);
            this.d = this.e;
        }
        if (this.e != this.d) {
            this.f++;
        } else {
            this.f = 0;
        }
        xh1.c.a("AnimPlayer.AnimPluginManager", "onRendering frameIndex=" + this.d);
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            ((wh1) it.next()).a(this.d);
        }
        this.d++;
    }
}
