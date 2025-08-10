package com.component.dxutilcode.lib.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackException;
import dc.oe0;
import dc.pd0;
import dc.rt1;
import dc.st1;
import dc.ve0;
import dc.xe0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import org.bouncycastle.crypto.tls.CipherSuite;

/* loaded from: classes.dex */
public final class ToastUtils {
    public static final ToastUtils m = o();
    public static final e n = new e();
    public static WeakReference<f> o;
    public String a;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public int e = -16777217;
    public int f = -1;
    public int g = -16777217;
    public int h = -1;
    public Drawable[] i = new Drawable[4];
    public int j = -1;
    public int k = -1;
    public boolean l = false;

    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {
        public static final int a = xe0.g(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(xe0.n() - a, Integer.MIN_VALUE), i2);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (ToastUtils.o != null) {
                f fVar = (f) ToastUtils.o.get();
                if (fVar != null) {
                    fVar.cancel();
                }
                WeakReference unused = ToastUtils.o = null;
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ View b;
        public final /* synthetic */ CharSequence c;
        public final /* synthetic */ int d;

        public b(View view, CharSequence charSequence, int i) {
            this.b = view;
            this.c = charSequence;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ToastUtils.m();
            f fVarP = ToastUtils.p(ToastUtils.this);
            WeakReference unused = ToastUtils.o = new WeakReference(fVarP);
            View view = this.b;
            if (view != null) {
                fVarP.a(view);
            } else {
                fVarP.c(this.c);
            }
            fVarP.b(this.d);
        }
    }

    public static abstract class c implements f {
        public Toast a = new Toast(ve0.a());
        public WeakReference<ToastUtils> b;
        public View c;

        public c(ToastUtils toastUtils) {
            this.b = new WeakReference<>(toastUtils);
            if (toastUtils.b == -1 && toastUtils.c == -1 && toastUtils.d == -1) {
                g();
            } else {
                this.a.setGravity(toastUtils.b, toastUtils.c, toastUtils.d);
            }
        }

        @Override // com.component.dxutilcode.lib.utils.ToastUtils.f
        public void a(View view) {
            this.c = view;
            this.a.setView(view);
        }

        @Override // com.component.dxutilcode.lib.utils.ToastUtils.f
        public void c(CharSequence charSequence) {
            WeakReference<ToastUtils> weakReference = this.b;
            if (weakReference != null && weakReference.get() != null) {
                View viewA = this.b.get().A(charSequence);
                if (viewA != null) {
                    a(viewA);
                    e();
                    return;
                }
                View view = this.a.getView();
                this.c = view;
                if (view == null || view.findViewById(R.id.message) == null) {
                    a(xe0.L(st1.utils_toast_view));
                }
                TextView textView = (TextView) this.c.findViewById(R.id.message);
                textView.setText(charSequence);
                if (this.b.get().g != -16777217) {
                    textView.setTextColor(this.b.get().g);
                }
                if (this.b.get().h != -1) {
                    textView.setTextSize(this.b.get().h);
                }
                f(textView);
            }
            e();
        }

        @Override // com.component.dxutilcode.lib.utils.ToastUtils.f
        @CallSuper
        public void cancel() {
            Toast toast = this.a;
            if (toast != null) {
                toast.cancel();
            }
            this.a = null;
            this.c = null;
        }

        public View d(int i) {
            Bitmap bitmapU = xe0.U(this.c);
            ImageView imageView = new ImageView(ve0.a());
            imageView.setTag("TAG_TOAST" + i);
            imageView.setImageBitmap(bitmapU);
            return imageView;
        }

        public final void e() {
            if (xe0.I()) {
                a(d(-1));
            }
        }

        public final void f(TextView textView) {
            WeakReference<ToastUtils> weakReference = this.b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if (this.b.get().f != -1) {
                this.c.setBackgroundResource(this.b.get().f);
                textView.setBackgroundColor(0);
                return;
            }
            if (this.b.get().e != -16777217) {
                Drawable background = this.c.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.b.get().e, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.b.get().e, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.b.get().e, PorterDuff.Mode.SRC_IN));
                } else {
                    this.c.setBackgroundColor(this.b.get().e);
                }
            }
        }

        public final void g() {
            if (ToastUtils.n.c() != 17) {
                this.a.setGravity(80, 0, 192);
            } else {
                this.a.setGravity(17, 0, 0);
            }
        }
    }

    public static final class d extends c {
        public static int f;
        public ve0.a d;
        public f e;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.cancel();
            }
        }

        public class b extends ve0.a {
            public final /* synthetic */ int a;

            public b(int i) {
                this.a = i;
            }

            @Override // dc.ve0.a
            public void a(@NonNull Activity activity) {
                if (d.this.j()) {
                    d.this.m(activity, this.a, false);
                }
            }
        }

        public d(ToastUtils toastUtils) {
            super(toastUtils);
        }

        @Override // com.component.dxutilcode.lib.utils.ToastUtils.f
        public void b(int i) {
            if (this.a == null) {
                return;
            }
            if (!xe0.F()) {
                this.e = l(i);
                return;
            }
            boolean z = false;
            for (WeakReference<Activity> weakReference : xe0.m()) {
                if (xe0.E(weakReference.get())) {
                    if (z) {
                        m(weakReference.get(), f, true);
                    } else {
                        this.e = n(weakReference.get(), i);
                        z = true;
                    }
                }
            }
            if (!z) {
                this.e = l(i);
                return;
            }
            k();
            xe0.R(new a(), i == 0 ? ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS : 3500L);
            f++;
        }

        @Override // com.component.dxutilcode.lib.utils.ToastUtils.c, com.component.dxutilcode.lib.utils.ToastUtils.f
        public void cancel() {
            Window window;
            if (j()) {
                o();
                for (WeakReference<Activity> weakReference : xe0.m()) {
                    if (xe0.E(weakReference.get()) && (window = weakReference.get().getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb = new StringBuilder();
                        sb.append("TAG_TOAST");
                        sb.append(f - 1);
                        View viewFindViewWithTag = viewGroup.findViewWithTag(sb.toString());
                        if (viewFindViewWithTag != null) {
                            try {
                                viewGroup.removeView(viewFindViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            f fVar = this.e;
            if (fVar != null) {
                fVar.cancel();
                this.e = null;
            }
            super.cancel();
        }

        public final boolean j() {
            return this.d != null;
        }

        public final void k() {
            b bVar = new b(f);
            this.d = bVar;
            xe0.a(bVar);
        }

        public final f l(int i) {
            WeakReference<ToastUtils> weakReference = this.b;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            g gVar = new g(this.b.get());
            gVar.a = this.a;
            gVar.b(i);
            return gVar;
        }

        public final void m(Activity activity, int i, boolean z) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.a.getGravity();
                layoutParams.bottomMargin = this.a.getYOffset() + xe0.v();
                layoutParams.topMargin = this.a.getYOffset() + xe0.y();
                layoutParams.leftMargin = this.a.getXOffset() + 100;
                layoutParams.rightMargin = 100;
                View viewD = d(i);
                if (z) {
                    viewD.setAlpha(0.0f);
                    viewD.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(viewD, layoutParams);
            }
        }

        public final f n(Activity activity, int i) {
            WeakReference<ToastUtils> weakReference = this.b;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            h hVar = new h(this.b.get(), activity.getWindowManager(), 99);
            hVar.c = this.c;
            hVar.b(i);
            return hVar;
        }

        public final void o() {
            xe0.O(this.d);
            this.d = null;
        }
    }

    public static final class e {
        public int a = 80;
        public String b = "dark";
        public int c = R.color.black;
        public int d = R.color.white;
        public int e = R.color.white;
        public int f = R.color.black;
        public int g = -1;
        public int h = -1;

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.h;
        }

        public int e() {
            return this.g;
        }

        public int f() {
            return this.e;
        }

        public int g() {
            return this.f;
        }

        public String h() {
            return this.b;
        }
    }

    public interface f {
        void a(View view);

        void b(int i);

        void c(CharSequence charSequence);

        void cancel();
    }

    public static final class g extends c {

        public static class a extends Handler {
            public Handler a;

            public a(Handler handler) {
                this.a = handler;
            }

            @Override // android.os.Handler
            public void dispatchMessage(@NonNull Message message) {
                try {
                    this.a.dispatchMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.os.Handler
            public void handleMessage(@NonNull Message message) {
                this.a.handleMessage(message);
            }
        }

        public g(ToastUtils toastUtils) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.a);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new a((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.component.dxutilcode.lib.utils.ToastUtils.f
        public void b(int i) {
            Toast toast = this.a;
            if (toast == null) {
                return;
            }
            toast.setDuration(i);
            this.a.show();
        }
    }

    public static void m() {
        xe0.Q(new a());
    }

    public static CharSequence n(CharSequence charSequence) {
        return charSequence == null ? "toast null" : charSequence.length() == 0 ? "toast nothing" : charSequence;
    }

    @NonNull
    public static ToastUtils o() {
        return new ToastUtils();
    }

    public static f p(ToastUtils toastUtils) {
        if (!toastUtils.l && NotificationManagerCompat.from(ve0.a()).areNotificationsEnabled()) {
            if (Build.VERSION.SDK_INT < 23) {
                return new g(toastUtils);
            }
            if (!xe0.H()) {
                return new g(toastUtils);
            }
        }
        int i = Build.VERSION.SDK_INT;
        return i < 25 ? new h(toastUtils, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND) : xe0.H() ? i >= 26 ? new h(toastUtils, 2038) : new h(toastUtils, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT) : new d(toastUtils);
    }

    public static void r(View view, TextView textView, String str) {
        if (str == null) {
            str = n.h();
        }
        GradientDrawable gradientDrawable = (GradientDrawable) view.getBackground().mutate();
        if ("dark".equals(str)) {
            e eVar = n;
            gradientDrawable.setColor(pd0.a(eVar.a()));
            textView.setTextColor(pd0.a(eVar.b()));
        } else {
            e eVar2 = n;
            gradientDrawable.setColor(pd0.a(eVar2.f()));
            textView.setTextColor(pd0.a(eVar2.g()));
        }
    }

    public static void t(View view, int i, int i2, int i3) {
        if (i2 < 0) {
            i2 = n.e();
        }
        if (i2 >= 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
        if (i3 < 0) {
            i3 = n.d();
        }
        if (i3 >= 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (i == 0) {
                marginLayoutParams.leftMargin = i3;
            } else if (i == 1) {
                marginLayoutParams.topMargin = i3;
            } else if (i == 2) {
                marginLayoutParams.rightMargin = i3;
            } else if (i == 3) {
                marginLayoutParams.bottomMargin = i3;
            }
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public static void u(@Nullable View view, @Nullable CharSequence charSequence, int i, @NonNull ToastUtils toastUtils) {
        xe0.Q(toastUtils.new b(view, charSequence, i));
    }

    public static void v(@Nullable CharSequence charSequence, int i, ToastUtils toastUtils) {
        u(null, n(charSequence), i, toastUtils);
    }

    public static void w(@Nullable String str, Object... objArr) {
        v(xe0.j(str, objArr), 1, m);
    }

    public static void x(@StringRes int i) {
        v(xe0.z(i), 0, m);
    }

    public static void y(@Nullable CharSequence charSequence) {
        v(charSequence, 0, m);
    }

    public static void z(@Nullable String str, Object... objArr) {
        v(xe0.j(str, objArr), 0, m);
    }

    public final View A(CharSequence charSequence) {
        String str = this.a;
        if (str != null && !"dark".equals(str) && !"light".equals(this.a)) {
            Drawable[] drawableArr = this.i;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View viewL = xe0.L(st1.utils_toast_view);
        TextView textView = (TextView) viewL.findViewById(R.id.message);
        r(viewL, textView, this.a);
        int i = this.g;
        if (i != -16777217) {
            textView.setTextColor(i);
        }
        int i2 = this.h;
        if (i2 != -1) {
            textView.setTextSize(i2);
        }
        q(viewL, textView);
        textView.setText(charSequence);
        if (this.i[0] != null) {
            View viewFindViewById = viewL.findViewById(rt1.utvLeftIconView);
            s(viewFindViewById, 2);
            ViewCompat.setBackground(viewFindViewById, this.i[0]);
            viewFindViewById.setVisibility(0);
        }
        if (this.i[1] != null) {
            View viewFindViewById2 = viewL.findViewById(rt1.utvTopIconView);
            s(viewFindViewById2, 3);
            ViewCompat.setBackground(viewFindViewById2, this.i[1]);
            viewFindViewById2.setVisibility(0);
        }
        if (this.i[2] != null) {
            View viewFindViewById3 = viewL.findViewById(rt1.utvRightIconView);
            s(viewFindViewById3, 0);
            ViewCompat.setBackground(viewFindViewById3, this.i[2]);
            viewFindViewById3.setVisibility(0);
        }
        if (this.i[3] != null) {
            View viewFindViewById4 = viewL.findViewById(rt1.utvBottomIconView);
            s(viewFindViewById4, 1);
            ViewCompat.setBackground(viewFindViewById4, this.i[3]);
            viewFindViewById4.setVisibility(0);
        }
        return viewL;
    }

    public final void q(View view, TextView textView) {
        int i = this.f;
        if (i != -1) {
            view.setBackgroundResource(i);
            textView.setBackgroundColor(0);
            return;
        }
        if (this.e != -16777217) {
            Drawable background = view.getBackground();
            Drawable background2 = textView.getBackground();
            if (background != null && background2 != null) {
                background.mutate().setColorFilter(new PorterDuffColorFilter(this.e, PorterDuff.Mode.SRC_IN));
                textView.setBackgroundColor(0);
            } else if (background != null) {
                background.mutate().setColorFilter(new PorterDuffColorFilter(this.e, PorterDuff.Mode.SRC_IN));
            } else if (background2 != null) {
                background2.mutate().setColorFilter(new PorterDuffColorFilter(this.e, PorterDuff.Mode.SRC_IN));
            } else {
                view.setBackgroundColor(this.e);
            }
        }
    }

    public final void s(View view, int i) {
        t(view, i, this.j, this.k);
    }

    public static final class h extends c {
        public WindowManager d;
        public WindowManager.LayoutParams e;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.cancel();
            }
        }

        public h(ToastUtils toastUtils, int i) {
            super(toastUtils);
            this.e = new WindowManager.LayoutParams();
            this.d = (WindowManager) ve0.a().getSystemService("window");
            this.e.type = i;
        }

        @Override // com.component.dxutilcode.lib.utils.ToastUtils.f
        public void b(int i) {
            if (this.a == null) {
                return;
            }
            WindowManager.LayoutParams layoutParams = this.e;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation.Toast;
            layoutParams.setTitle("ToastWithoutNotification");
            WindowManager.LayoutParams layoutParams2 = this.e;
            layoutParams2.flags = CipherSuite.TLS_DH_RSA_WITH_SEED_CBC_SHA;
            layoutParams2.packageName = ve0.a().getPackageName();
            this.e.gravity = this.a.getGravity();
            WindowManager.LayoutParams layoutParams3 = this.e;
            int i2 = layoutParams3.gravity;
            if ((i2 & 7) == 7) {
                layoutParams3.horizontalWeight = 1.0f;
            }
            if ((i2 & 112) == 112) {
                layoutParams3.verticalWeight = 1.0f;
            }
            layoutParams3.x = this.a.getXOffset();
            this.e.y = this.a.getYOffset();
            WindowManager.LayoutParams layoutParams4 = this.e;
            layoutParams4.height = -2;
            layoutParams4.width = h();
            this.e.horizontalMargin = this.a.getHorizontalMargin();
            this.e.verticalMargin = this.a.getVerticalMargin();
            try {
                WindowManager windowManager = this.d;
                if (windowManager != null) {
                    windowManager.addView(this.c, this.e);
                }
            } catch (Exception unused) {
            }
            xe0.R(new a(), i == 0 ? ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS : 3500L);
        }

        @Override // com.component.dxutilcode.lib.utils.ToastUtils.c, com.component.dxutilcode.lib.utils.ToastUtils.f
        public void cancel() {
            try {
                WindowManager windowManager = this.d;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(this.c);
                    this.d = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }

        public final int h() {
            this.c.measure(0, 0);
            double measuredWidth = ((r0 - 100) - 100) / this.c.getMeasuredWidth();
            if (measuredWidth >= 0.85d) {
                return (int) (oe0.d() * measuredWidth);
            }
            return -2;
        }

        public h(ToastUtils toastUtils, WindowManager windowManager, int i) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.e = layoutParams;
            this.d = windowManager;
            layoutParams.type = i;
        }
    }
}
