package xyz.doikki.videoplayer.player;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import dc.ak4;
import dc.ck4;
import dc.fk4;
import dc.gk4;
import dc.lj4;
import dc.qj4;
import dc.sj4;
import dc.vj4;
import dc.wj4;
import dc.xj4;
import dc.yj4;
import dc.zj4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xyz.doikki.videoplayer.controller.BaseVideoController;

/* loaded from: classes5.dex */
public class BaseVideoView<P extends sj4> extends FrameLayout implements qj4, sj4.a {
    public P a;
    public wj4<P> b;

    @Nullable
    public BaseVideoController c;
    public FrameLayout d;
    public ak4 e;
    public ck4 f;
    public int g;
    public int[] h;
    public boolean i;
    public String j;
    public Map<String, String> k;
    public AssetFileDescriptor l;
    public long m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;

    @Nullable
    public vj4 s;
    public List<a> t;

    @Nullable
    public xj4 u;
    public boolean v;
    public final int w;

    public interface a {
        void a(int i);

        void b(int i);
    }

    public static class b implements a {
        @Override // xyz.doikki.videoplayer.player.BaseVideoView.a
        public void b(int i) {
        }
    }

    public BaseVideoView(@NonNull Context context) {
        this(context, null);
    }

    public boolean A() {
        BaseVideoController baseVideoController;
        return (q() || (baseVideoController = this.c) == null || !baseVideoController.E()) ? false : true;
    }

    public final void B(ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility() & (-3);
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility &= -4097;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        getActivity().getWindow().clearFlags(1024);
    }

    public void C() {
        this.a.t();
        setPlayState(3);
        if (this.s != null && !r()) {
            this.s.d();
        }
        this.d.setKeepScreenOn(true);
    }

    public boolean D() {
        if (A()) {
            setPlayState(8);
            return false;
        }
        if (this.r) {
            this.s = new vj4(this);
        }
        xj4 xj4Var = this.u;
        if (xj4Var != null) {
            this.m = xj4Var.a(this.j);
        }
        l();
        h();
        E(false);
        return true;
    }

    public void E(boolean z) {
        if (z) {
            this.a.k();
            z();
        }
        if (t()) {
            this.a.i();
            setPlayState(1);
            setPlayerState(c() ? 11 : s() ? 12 : 10);
        }
    }

    @Override // dc.sj4.a
    public void a() {
        this.d.setKeepScreenOn(false);
        setPlayState(-1);
    }

    @Override // dc.sj4.a
    public void b(int i, int i2) {
        if (i == 3) {
            setPlayState(3);
            this.d.setKeepScreenOn(true);
            return;
        }
        if (i == 10001) {
            ak4 ak4Var = this.e;
            if (ak4Var != null) {
                ak4Var.setVideoRotation(i2);
                return;
            }
            return;
        }
        if (i == 701) {
            setPlayState(6);
        } else {
            if (i != 702) {
                return;
            }
            setPlayState(7);
        }
    }

    public boolean c() {
        return this.p;
    }

    @Override // dc.qj4
    public void d(boolean z) {
        if (z) {
            this.m = 0L;
        }
        h();
        E(true);
    }

    @Override // dc.sj4.a
    public void e(int i, int i2) {
        int[] iArr = this.h;
        iArr[0] = i;
        iArr[1] = i2;
        ak4 ak4Var = this.e;
        if (ak4Var != null) {
            ak4Var.setScaleType(this.g);
            this.e.setVideoSize(i, i2);
        }
    }

    @Override // dc.qj4
    public void f() {
        ViewGroup decorView;
        if (this.p && (decorView = getDecorView()) != null) {
            this.p = false;
            B(decorView);
            decorView.removeView(this.d);
            addView(this.d);
            setPlayerState(10);
        }
    }

    @Override // dc.sj4.a
    public void g() {
        this.d.setKeepScreenOn(false);
        this.m = 0L;
        xj4 xj4Var = this.u;
        if (xj4Var != null) {
            xj4Var.b(this.j, 0L);
        }
        setPlayState(5);
    }

    public Activity getActivity() {
        BaseVideoController baseVideoController = this.c;
        if (baseVideoController == null) {
            return gk4.l(getContext());
        }
        Activity activityL = gk4.l(baseVideoController.getContext());
        return activityL == null ? gk4.l(getContext()) : activityL;
    }

    @Override // dc.qj4
    public int getBufferedPercentage() {
        P p = this.a;
        if (p != null) {
            return p.a();
        }
        return 0;
    }

    public ViewGroup getContentView() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.findViewById(R.id.content);
    }

    public int getCurrentPlayState() {
        return this.n;
    }

    public int getCurrentPlayerState() {
        return this.o;
    }

    @Override // dc.qj4
    public long getCurrentPosition() {
        if (!o()) {
            return 0L;
        }
        long jB = this.a.b();
        this.m = jB;
        return jB;
    }

    public ViewGroup getDecorView() {
        Activity activity = getActivity();
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.getWindow().getDecorView();
    }

    @Override // dc.qj4
    public long getDuration() {
        if (o()) {
            return this.a.c();
        }
        return 0L;
    }

    @Override // dc.qj4
    public float getSpeed() {
        if (o()) {
            return this.a.d();
        }
        return 1.0f;
    }

    public long getTcpSpeed() {
        P p = this.a;
        if (p != null) {
            return p.e();
        }
        return 0L;
    }

    public int[] getVideoSize() {
        return this.h;
    }

    public void h() {
        ak4 ak4Var = this.e;
        if (ak4Var != null) {
            this.d.removeView(ak4Var.getView());
            this.e.release();
        }
        ak4 ak4VarA = this.f.a(getContext());
        this.e = ak4VarA;
        ak4VarA.a(this.a);
        this.d.addView(this.e.getView(), 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void i(@NonNull a aVar) {
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(aVar);
    }

    @Override // dc.qj4
    public boolean isPlaying() {
        return o() && this.a.g();
    }

    @Override // dc.qj4
    public void j() {
        ViewGroup decorView;
        if (this.p || (decorView = getDecorView()) == null) {
            return;
        }
        this.p = true;
        k(decorView);
        removeView(this.d);
        decorView.addView(this.d);
        setPlayerState(11);
    }

    public final void k(ViewGroup viewGroup) {
        int systemUiVisibility = viewGroup.getSystemUiVisibility() | 2;
        if (Build.VERSION.SDK_INT >= 19) {
            systemUiVisibility |= 4096;
        }
        viewGroup.setSystemUiVisibility(systemUiVisibility);
        getActivity().getWindow().setFlags(1024, 1024);
    }

    public void l() {
        P p = (P) this.b.a(getContext());
        this.a = p;
        p.p(this);
        y();
        this.a.f();
        z();
    }

    public void m() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.d = frameLayout;
        frameLayout.setBackgroundColor(this.w);
        addView(this.d, new FrameLayout.LayoutParams(-1, -1));
    }

    public boolean n() {
        return this.n == 0;
    }

    public boolean o() {
        int i;
        return (this.a == null || (i = this.n) == -1 || i == 0 || i == 1 || i == 8 || i == 5) ? false : true;
    }

    @Override // dc.sj4.a
    public void onPrepared() {
        vj4 vj4Var;
        setPlayState(2);
        if (!r() && (vj4Var = this.s) != null) {
            vj4Var.d();
        }
        long j = this.m;
        if (j > 0) {
            seekTo(j);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        fk4.a("onSaveInstanceState: " + this.m);
        x();
        return super.onSaveInstanceState();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.p) {
            k(getDecorView());
        }
    }

    public final boolean p() {
        return this.n == 8;
    }

    @Override // dc.qj4
    public void pause() {
        if (o() && this.a.g()) {
            this.a.h();
            setPlayState(4);
            if (this.s != null && !r()) {
                this.s.a();
            }
            this.d.setKeepScreenOn(false);
        }
    }

    public boolean q() {
        if (this.l != null) {
            return true;
        }
        if (TextUtils.isEmpty(this.j)) {
            return false;
        }
        Uri uri = Uri.parse(this.j);
        return "android.resource".equals(uri.getScheme()) || "file".equals(uri.getScheme()) || RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(uri.getScheme());
    }

    public boolean r() {
        return this.i;
    }

    public boolean s() {
        return this.q;
    }

    @Override // dc.qj4
    public void seekTo(long j) {
        if (o()) {
            this.a.l(j);
        }
    }

    public void setAssetFileDescriptor(AssetFileDescriptor assetFileDescriptor) {
        this.j = null;
        this.l = assetFileDescriptor;
    }

    public void setEnableAudioFocus(boolean z) {
        this.r = z;
    }

    public void setLooping(boolean z) {
        this.v = z;
        P p = this.a;
        if (p != null) {
            p.o(z);
        }
    }

    public void setMirrorRotation(boolean z) {
        ak4 ak4Var = this.e;
        if (ak4Var != null) {
            ak4Var.getView().setScaleX(z ? -1.0f : 1.0f);
        }
    }

    public void setMute(boolean z) {
        this.i = z;
        P p = this.a;
        if (p != null) {
            float f = z ? 0.0f : 1.0f;
            p.s(f, f);
        }
    }

    public void setOnStateChangeListener(@NonNull a aVar) {
        List<a> list = this.t;
        if (list == null) {
            this.t = new ArrayList();
        } else {
            list.clear();
        }
        this.t.add(aVar);
    }

    public void setPlayState(int i) {
        this.n = i;
        BaseVideoController baseVideoController = this.c;
        if (baseVideoController != null) {
            baseVideoController.setPlayState(i);
        }
        List<a> list = this.t;
        if (list != null) {
            for (a aVar : gk4.g(list)) {
                if (aVar != null) {
                    aVar.a(i);
                }
            }
        }
    }

    public void setPlayerBackgroundColor(int i) {
        this.d.setBackgroundColor(i);
    }

    public void setPlayerFactory(wj4 wj4Var) {
        if (wj4Var == null) {
            throw new IllegalArgumentException("PlayerFactory can not be null!");
        }
        this.b = wj4Var;
    }

    public void setPlayerState(int i) {
        this.o = i;
        BaseVideoController baseVideoController = this.c;
        if (baseVideoController != null) {
            baseVideoController.setPlayerState(i);
        }
        List<a> list = this.t;
        if (list != null) {
            for (a aVar : gk4.g(list)) {
                if (aVar != null) {
                    aVar.b(i);
                }
            }
        }
    }

    public void setProgressManager(@Nullable xj4 xj4Var) {
    }

    public void setRenderViewFactory(ck4 ck4Var) {
        if (ck4Var == null) {
            throw new IllegalArgumentException("RenderViewFactory can not be null!");
        }
        this.f = ck4Var;
    }

    @Override // android.view.View
    public void setRotation(float f) {
        ak4 ak4Var = this.e;
        if (ak4Var != null) {
            ak4Var.setVideoRotation((int) f);
        }
    }

    public void setScreenScaleType(int i) {
        this.g = i;
        ak4 ak4Var = this.e;
        if (ak4Var != null) {
            ak4Var.setScaleType(i);
        }
    }

    public void setSpeed(float f) {
        if (o()) {
            this.a.q(f);
        }
    }

    public void setTinyScreenSize(int[] iArr) {
    }

    public void setUrl(String str) {
        setUrl(str, null);
    }

    public void setVideoController(@Nullable BaseVideoController baseVideoController) {
        this.d.removeView(this.c);
        this.c = baseVideoController;
        if (baseVideoController != null) {
            baseVideoController.setMediaPlayer(this);
            this.d.addView(this.c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void setVolume(float f, float f2) {
        P p = this.a;
        if (p != null) {
            p.s(f, f2);
        }
    }

    @Override // dc.qj4
    public void start() {
        if (n() || p()) {
            D();
        } else if (o()) {
            C();
        }
    }

    public boolean t() {
        AssetFileDescriptor assetFileDescriptor = this.l;
        if (assetFileDescriptor != null) {
            this.a.m(assetFileDescriptor);
            return true;
        }
        if (TextUtils.isEmpty(this.j)) {
            return false;
        }
        this.a.n(this.j, this.k);
        return true;
    }

    public void u() throws IOException {
        if (n()) {
            return;
        }
        P p = this.a;
        if (p != null) {
            p.j();
            this.a = null;
        }
        ak4 ak4Var = this.e;
        if (ak4Var != null) {
            this.d.removeView(ak4Var.getView());
            this.e.release();
            this.e = null;
        }
        AssetFileDescriptor assetFileDescriptor = this.l;
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        vj4 vj4Var = this.s;
        if (vj4Var != null) {
            vj4Var.a();
            this.s = null;
        }
        this.d.setKeepScreenOn(false);
        x();
        this.m = 0L;
        setPlayState(0);
    }

    public void v(@NonNull a aVar) {
        List<a> list = this.t;
        if (list != null) {
            list.remove(aVar);
        }
    }

    public void w() {
        if (!o() || this.a.g()) {
            return;
        }
        this.a.t();
        setPlayState(3);
        if (this.s != null && !r()) {
            this.s.d();
        }
        this.d.setKeepScreenOn(true);
    }

    public void x() {
        if (this.u == null || this.m <= 0) {
            return;
        }
        fk4.a("saveProgress: " + this.m);
        this.u.b(this.j, this.m);
    }

    public void y() {
    }

    public void z() {
        this.a.o(this.v);
        float f = this.i ? 0.0f : 1.0f;
        this.a.s(f, f);
    }

    public BaseVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setUrl(String str, Map<String, String> map) {
        this.l = null;
        this.j = str;
        this.k = map;
    }

    public BaseVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = new int[]{0, 0};
        this.n = 0;
        this.o = 10;
        yj4 yj4VarC = zj4.c();
        this.r = yj4VarC.c;
        xj4 xj4Var = yj4VarC.e;
        this.b = yj4VarC.f;
        this.g = yj4VarC.g;
        this.f = yj4VarC.h;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, lj4.BaseVideoView);
        this.r = typedArrayObtainStyledAttributes.getBoolean(lj4.BaseVideoView_enableAudioFocus, this.r);
        this.v = typedArrayObtainStyledAttributes.getBoolean(lj4.BaseVideoView_looping, false);
        this.g = typedArrayObtainStyledAttributes.getInt(lj4.BaseVideoView_screenScaleType, this.g);
        this.w = typedArrayObtainStyledAttributes.getColor(lj4.BaseVideoView_playerBackgroundColor, ViewCompat.MEASURED_STATE_MASK);
        typedArrayObtainStyledAttributes.recycle();
        m();
    }
}
