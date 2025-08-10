package dc;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* compiled from: CustomPopWindow.java */
/* loaded from: classes.dex */
public class wg0 implements PopupWindow.OnDismissListener {
    public Context a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public int f;
    public View g;
    public PopupWindow h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;
    public PopupWindow.OnDismissListener m;
    public int n;
    public boolean o;
    public View.OnTouchListener p;
    public Window q;
    public boolean r;
    public float s;
    public boolean t;

    /* compiled from: CustomPopWindow.java */
    public class a implements View.OnKeyListener {
        public a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            wg0.this.h.dismiss();
            return true;
        }
    }

    /* compiled from: CustomPopWindow.java */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() != 0 || (x >= 0 && x < wg0.this.b && y >= 0 && y < wg0.this.c)) {
                return motionEvent.getAction() == 4;
            }
            String str = "width:" + wg0.this.h.getWidth() + "height:" + wg0.this.h.getHeight() + " x:" + x + " y  :" + y;
            return true;
        }
    }

    /* compiled from: CustomPopWindow.java */
    public static class c {
        public wg0 a;

        public c(Context context) {
            this.a = new wg0(context, null);
        }

        public wg0 a() {
            this.a.l();
            return this.a;
        }

        public c b(boolean z) {
            this.a.r = z;
            return this;
        }

        public c c(float f) {
            this.a.s = f;
            return this;
        }

        public c d(PopupWindow.OnDismissListener onDismissListener) {
            this.a.m = onDismissListener;
            return this;
        }

        public c e(boolean z) {
            this.a.e = z;
            return this;
        }

        public c f(View view) {
            this.a.g = view;
            this.a.f = -1;
            return this;
        }
    }

    public /* synthetic */ wg0(Context context, a aVar) {
        this(context);
    }

    public final void k(PopupWindow popupWindow) {
        popupWindow.setClippingEnabled(this.j);
        if (this.k) {
            popupWindow.setIgnoreCheekPress();
        }
        int i = this.l;
        if (i != -1) {
            popupWindow.setInputMethodMode(i);
        }
        int i2 = this.n;
        if (i2 != -1) {
            popupWindow.setSoftInputMode(i2);
        }
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            popupWindow.setOnDismissListener(onDismissListener);
        }
        View.OnTouchListener onTouchListener = this.p;
        if (onTouchListener != null) {
            popupWindow.setTouchInterceptor(onTouchListener);
        }
        popupWindow.setTouchable(this.o);
    }

    public final PopupWindow l() {
        if (this.g == null) {
            this.g = LayoutInflater.from(this.a).inflate(this.f, (ViewGroup) null);
        }
        Activity activity = (Activity) this.g.getContext();
        if (activity != null && this.r) {
            float f = this.s;
            if (f <= 0.0f || f >= 1.0f) {
                f = 0.7f;
            }
            Window window = activity.getWindow();
            this.q = window;
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            this.q.addFlags(2);
            this.q.setAttributes(attributes);
        }
        if (this.b == 0 || this.c == 0) {
            this.h = new PopupWindow(this.g, -2, -2);
        } else {
            this.h = new PopupWindow(this.g, this.b, this.c);
        }
        int i = this.i;
        if (i != -1) {
            this.h.setAnimationStyle(i);
        }
        k(this.h);
        if (this.b == 0 || this.c == 0) {
            this.h.getContentView().measure(0, 0);
            this.b = this.h.getContentView().getMeasuredWidth();
            this.c = this.h.getContentView().getMeasuredHeight();
        }
        this.h.setOnDismissListener(this);
        if (this.t) {
            this.h.setFocusable(this.d);
            this.h.setBackgroundDrawable(new ColorDrawable(0));
            this.h.setOutsideTouchable(this.e);
        } else {
            this.h.setFocusable(true);
            this.h.setOutsideTouchable(false);
            this.h.setBackgroundDrawable(null);
            this.h.getContentView().setFocusable(true);
            this.h.getContentView().setFocusableInTouchMode(true);
            this.h.getContentView().setOnKeyListener(new a());
            this.h.setTouchInterceptor(new b());
        }
        this.h.update();
        return this.h;
    }

    public void m() {
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        Window window = this.q;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 1.0f;
            this.q.setAttributes(attributes);
        }
        PopupWindow popupWindow = this.h;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.h.dismiss();
    }

    public wg0 n(View view, int i, int i2) {
        PopupWindow popupWindow = this.h;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(view, i, i2);
        }
        return this;
    }

    public wg0 o(View view, int i, int i2, int i3) {
        PopupWindow popupWindow = this.h;
        if (popupWindow != null) {
            popupWindow.showAtLocation(view, i, i2, i3);
        }
        return this;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        m();
    }

    public wg0(Context context) {
        this.d = true;
        this.e = true;
        this.f = -1;
        this.i = -1;
        this.j = true;
        this.k = false;
        this.l = -1;
        this.n = -1;
        this.o = true;
        this.r = false;
        this.s = 0.0f;
        this.t = true;
        this.a = context;
    }
}
