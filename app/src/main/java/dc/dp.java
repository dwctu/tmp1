package dc;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ViewTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class dp<T extends View, Z> extends uo<Z> {
    public static int g = pf.glide_custom_view_target_tag;
    public final T b;
    public final a c;

    @Nullable
    public View.OnAttachStateChangeListener d;
    public boolean e;
    public boolean f;

    /* compiled from: ViewTarget.java */
    @VisibleForTesting
    public static final class a {

        @Nullable
        @VisibleForTesting
        public static Integer e;
        public final View a;
        public final List<bp> b = new ArrayList();
        public boolean c;

        @Nullable
        public ViewTreeObserverOnPreDrawListenerC0171a d;

        /* compiled from: ViewTarget.java */
        /* renamed from: dc.dp$a$a, reason: collision with other inner class name */
        public static final class ViewTreeObserverOnPreDrawListenerC0171a implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference<a> a;

            public ViewTreeObserverOnPreDrawListenerC0171a(@NonNull a aVar) {
                this.a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    String str = "OnGlobalLayoutListener called attachStateListener=" + this;
                }
                a aVar = this.a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        public a(@NonNull View view) {
            this.a = view;
        }

        public static int c(@NonNull Context context) {
            if (e == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                vp.d(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return e.intValue();
        }

        public void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                j(iG, iF);
                b();
            }
        }

        public void b() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = null;
            this.b.clear();
        }

        public void d(@NonNull bp bpVar) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                bpVar.d(iG, iF);
                return;
            }
            if (!this.b.contains(bpVar)) {
                this.b.add(bpVar);
            }
            if (this.d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0171a viewTreeObserverOnPreDrawListenerC0171a = new ViewTreeObserverOnPreDrawListenerC0171a(this);
                this.d = viewTreeObserverOnPreDrawListenerC0171a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0171a);
            }
        }

        public final int e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            Log.isLoggable("ViewTarget", 4);
            return c(this.a.getContext());
        }

        public final int f() {
            int paddingTop = this.a.getPaddingTop() + this.a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return e(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        public final int g() {
            int paddingLeft = this.a.getPaddingLeft() + this.a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return e(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        public final boolean h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        public final boolean i(int i, int i2) {
            return h(i) && h(i2);
        }

        public final void j(int i, int i2) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                ((bp) it.next()).d(i, i2);
            }
        }

        public void k(@NonNull bp bpVar) {
            this.b.remove(bpVar);
        }
    }

    public dp(@NonNull T t) {
        vp.d(t);
        this.b = t;
        this.c = new a(t);
    }

    @Override // dc.uo, dc.cp
    @CallSuper
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        k();
    }

    @Override // dc.cp
    @CallSuper
    public void b(@NonNull bp bpVar) {
        this.c.k(bpVar);
    }

    @Override // dc.uo, dc.cp
    @CallSuper
    public void e(@Nullable Drawable drawable) {
        super.e(drawable);
        this.c.b();
        if (this.e) {
            return;
        }
        l();
    }

    @Override // dc.uo, dc.cp
    public void g(@Nullable mo moVar) {
        m(moVar);
    }

    @Override // dc.uo, dc.cp
    @Nullable
    public mo getRequest() {
        Object objJ = j();
        if (objJ == null) {
            return null;
        }
        if (objJ instanceof mo) {
            return (mo) objJ;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // dc.cp
    @CallSuper
    public void i(@NonNull bp bpVar) {
        this.c.d(bpVar);
    }

    @Nullable
    public final Object j() {
        return this.b.getTag(g);
    }

    public final void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
        if (onAttachStateChangeListener == null || this.f) {
            return;
        }
        this.b.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f = true;
    }

    public final void l() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
        if (onAttachStateChangeListener == null || !this.f) {
            return;
        }
        this.b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f = false;
    }

    public final void m(@Nullable Object obj) {
        this.b.setTag(g, obj);
    }

    public String toString() {
        return "Target for: " + this.b;
    }
}
