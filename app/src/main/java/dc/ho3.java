package dc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.util.WearUtils;
import com.wear.widget.bubble.BubbleLayout;

/* compiled from: BubbleDialog.java */
/* loaded from: classes4.dex */
public class ho3 extends Dialog {
    public BubbleLayout a;
    public int b;
    public int c;
    public int d;
    public View e;
    public Rect f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public f l;
    public f[] m;
    public go3 n;
    public boolean o;
    public boolean p;
    public int[] q;
    public Activity r;
    public ViewTreeObserver.OnGlobalLayoutListener s;
    public Toy t;

    /* compiled from: BubbleDialog.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ho3 ho3Var = ho3.this;
            ho3Var.i = kg3.a(ho3Var.r);
        }
    }

    /* compiled from: BubbleDialog.java */
    public class b implements View.OnTouchListener {
        public final /* synthetic */ WindowManager.LayoutParams a;
        public final /* synthetic */ int b;

        public b(WindowManager.LayoutParams layoutParams, int i) {
            this.a = layoutParams;
            this.b = i;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!ho3.this.o) {
                return false;
            }
            int i = this.a.x;
            float width = i < 0 ? 0.0f : i;
            float width2 = view.getWidth() + width;
            int i2 = this.b;
            if (width2 > i2) {
                width = i2 - view.getWidth();
            }
            motionEvent.setLocation(width + motionEvent.getX(), this.a.y + motionEvent.getY());
            ho3.this.r.getWindow().getDecorView().dispatchTouchEvent(motionEvent);
            return true;
        }
    }

    /* compiled from: BubbleDialog.java */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public int a;
        public int b;
        public int c;
        public int d;

        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.a == ho3.this.a.getMeasuredWidth() && this.b == ho3.this.a.getMeasuredHeight() && this.c == ho3.this.a.getX() && this.d == ho3.this.a.getY()) {
                return;
            }
            ho3.this.g();
            this.a = ho3.this.a.getMeasuredWidth();
            this.b = ho3.this.a.getMeasuredHeight();
        }
    }

    /* compiled from: BubbleDialog.java */
    public class d implements BubbleLayout.c {
        public d() {
        }

        @Override // com.wear.widget.bubble.BubbleLayout.c
        public void a() {
            if (ho3.this.p) {
                ho3.this.dismiss();
            }
        }
    }

    /* compiled from: BubbleDialog.java */
    public static /* synthetic */ class e {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[go3.values().length];
            b = iArr;
            try {
                iArr[go3.AROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[go3.UP_AND_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[go3.LEFT_AND_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[f.values().length];
            a = iArr2;
            try {
                iArr2[f.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[f.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[f.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[f.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: BubbleDialog.java */
    public enum f {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    public ho3(Context context, Toy toy) {
        super(context, R.style.bubble_dialog);
        this.l = f.TOP;
        this.m = new f[4];
        this.o = false;
        this.q = new int[2];
        setCancelable(true);
        this.t = toy;
        this.r = (Activity) context;
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setFlags(32, 32);
        window.setFlags(262144, 262144);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int iE = gg3.e(this.r);
        this.i = gg3.g(this.r);
        this.r.getWindow().getDecorView().post(new a());
        getWindow().getDecorView().setOnTouchListener(new b(attributes, iE));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.k) {
            j(this);
        }
        BubbleLayout bubbleLayout = this.a;
        if (bubbleLayout != null) {
            bubbleLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this.s);
        }
        super.dismiss();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.ho3.g():void");
    }

    public final void h() {
        k();
        if (this.s != null) {
            n();
            g();
        }
    }

    public final boolean i() {
        int i = 0;
        for (f fVar : this.m) {
            if (fVar != null) {
                i++;
            }
        }
        return i > 0;
    }

    public void j(Dialog dialog) {
        View currentFocus = dialog.getCurrentFocus();
        if (currentFocus instanceof TextView) {
            ((InputMethodManager) dialog.getContext().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public final void k() {
        if (this.f != null) {
            if (this.n != null || i()) {
                int[] iArr = this.q;
                int[] iArr2 = {iArr[0], iArr[1], (gg3.e(getContext()) - this.q[0]) - this.f.width(), (gg3.c(getContext()) - this.q[1]) - this.f.height()};
                if (i()) {
                    this.e.measure(0, 0);
                    for (f fVar : this.m) {
                        if (fVar == null) {
                            return;
                        }
                        int i = e.a[fVar.ordinal()];
                        if (i == 1) {
                            if (iArr2[0] > this.e.getMeasuredWidth()) {
                                this.l = f.LEFT;
                                return;
                            }
                        } else if (i == 2) {
                            if (iArr2[1] > this.e.getMeasuredHeight()) {
                                this.l = f.TOP;
                                return;
                            }
                        } else if (i != 3) {
                            if (i == 4 && iArr2[3] > this.e.getMeasuredHeight()) {
                                this.l = f.BOTTOM;
                                return;
                            }
                        } else if (iArr2[2] > this.e.getMeasuredWidth()) {
                            this.l = f.RIGHT;
                            return;
                        }
                    }
                    this.l = this.m[0];
                    return;
                }
                go3 go3Var = this.n;
                if (go3Var != null) {
                    int i2 = e.b[go3Var.ordinal()];
                    if (i2 == 2) {
                        this.l = iArr2[1] > iArr2[3] ? f.TOP : f.BOTTOM;
                        return;
                    } else if (i2 == 3) {
                        this.l = iArr2[0] > iArr2[2] ? f.LEFT : f.RIGHT;
                        return;
                    }
                }
                int i3 = 0;
                for (int i4 = 0; i4 < 4; i4++) {
                    int i5 = iArr2[i4];
                    if (i5 > i3) {
                        i3 = i5;
                    }
                }
                if (i3 == iArr2[0]) {
                    this.l = f.LEFT;
                    return;
                }
                if (i3 == iArr2[1]) {
                    this.l = f.TOP;
                } else if (i3 == iArr2[2]) {
                    this.l = f.RIGHT;
                } else if (i3 == iArr2[3]) {
                    this.l = f.BOTTOM;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ho3> T l(View view) {
        this.f = new Rect(0, 0, view.getWidth(), view.getHeight());
        view.getLocationOnScreen(this.q);
        h();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ho3> T m(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        return this;
    }

    public final void n() {
        int i = e.a[this.l.ordinal()];
        if (i == 1) {
            this.a.setLook(BubbleLayout.b.RIGHT);
        } else if (i == 2) {
            this.a.setLook(BubbleLayout.b.BOTTOM);
        } else if (i == 3) {
            this.a.setLook(BubbleLayout.b.LEFT);
        } else if (i == 4) {
            this.a.setLook(BubbleLayout.b.TOP);
        }
        this.a.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ho3> T o(int i) {
        this.h = ce3.a(getContext(), i);
        return this;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.bubble_ldr_guild, (ViewGroup) null);
        BubbleLayout bubbleLayout = (BubbleLayout) viewInflate;
        this.a = bubbleLayout;
        this.e = bubbleLayout.getChildAt(0);
        setContentView(viewInflate);
        ((TextView) this.e).setText(WearUtils.I(this.t));
        Window window = getWindow();
        if (window == null) {
            return;
        }
        if (this.k) {
            window.setSoftInputMode(18);
        }
        window.setLayout(-2, -2);
        k();
        n();
        this.a.measure(0, 0);
        g();
        this.s = new c();
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(this.s);
        this.a.setOnClickEdgeListener(new d());
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.o || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        dismiss();
        this.r.onBackPressed();
        this.r = null;
        return true;
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Window window = getWindow();
        if (window == null) {
            return false;
        }
        View decorView = window.getDecorView();
        if (!this.p || !isShowing() || !s(motionEvent, decorView)) {
            return false;
        }
        cancel();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ho3> T p(f... fVarArr) {
        if (fVarArr.length != 1 || fVarArr[0] == null) {
            this.m = fVarArr;
            return this;
        }
        this.l = fVarArr[0];
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ho3> T q(boolean z, boolean z2) {
        this.o = z;
        if (z) {
            setCancelable(false);
        } else {
            setCancelable(z2);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ho3> T r() {
        if (getWindow() == null) {
            return this;
        }
        getWindow().clearFlags(2);
        return this;
    }

    public boolean s(MotionEvent motionEvent, View view) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        return x <= 0 || y <= 0 || x > view.getWidth() || y > view.getHeight();
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.p = z;
    }
}
