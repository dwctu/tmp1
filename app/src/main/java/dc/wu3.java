package dc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.yydcdut.sdlv.DragListView;
import com.yydcdut.sdlv.SlideAndDragListView;

/* compiled from: DragManager.java */
/* loaded from: classes4.dex */
public class wu3 implements ru3 {
    public ImageView a;
    public DragListView b;
    public Handler c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float i;
    public Bitmap j;
    public int k;
    public boolean l;
    public boolean m;
    public float n;
    public float o;
    public ViewGroup p;
    public int[] q;
    public xu3 r;
    public boolean h = false;
    public final Runnable s = new a();

    /* compiled from: DragManager.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (wu3.this.g <= wu3.this.d) {
                wu3.this.b.smoothScrollBy(-25, 5);
            } else if (wu3.this.g >= wu3.this.e) {
                wu3.this.b.smoothScrollBy(25, 5);
            }
            wu3.this.c.postDelayed(this, 5L);
        }
    }

    /* compiled from: DragManager.java */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (wu3.this.j != null) {
                wu3.this.j.recycle();
                wu3.this.j = null;
            }
            wu3.this.a.setVisibility(8);
            wu3.this.a.setImageBitmap(null);
            if (wu3.this.r != null) {
                wu3.this.r.c();
                wu3.this.r = null;
            }
        }

        public /* synthetic */ b(wu3 wu3Var, a aVar) {
            this();
        }
    }

    public wu3(Context context, DragListView dragListView, ViewGroup viewGroup) {
        this.i = ViewConfiguration.get(context).getScaledPagingTouchSlop();
        this.b = dragListView;
        dragListView.setListDragDropListener(this);
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        this.p = viewGroup;
        viewGroup.addView(imageView, new FrameLayout.LayoutParams(-2, -2));
        this.q = new int[]{0, 0};
    }

    @Override // dc.ru3
    public void b(int i, int i2, View view, SlideAndDragListView.a aVar) {
        this.a.setX(this.q[0]);
        this.a.setY((i2 - this.k) + this.q[1]);
    }

    @Override // dc.ru3
    public boolean d(int i, int i2, View view) {
        Bitmap bitmapO = o(view);
        this.j = bitmapO;
        if (bitmapO == null) {
            return false;
        }
        if (view instanceof xu3) {
            xu3 xu3Var = (xu3) view;
            this.r = xu3Var;
            xu3Var.b();
        }
        this.a.setImageBitmap(this.j);
        this.a.setVisibility(0);
        this.a.setAlpha(0.7f);
        this.a.setX(this.b.getPaddingLeft());
        this.k = i2 - view.getTop();
        this.a.setY((i2 - r3) + this.q[1]);
        return true;
    }

    @Override // dc.ru3
    public void g(int i, int i2, SlideAndDragListView.a aVar) {
        ImageView imageView = this.a;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, "alpha", 0.7f, 0.0f);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat.addListener(new b(this, null));
        objectAnimatorOfFloat.start();
    }

    public final void n() {
        int height = (int) (this.b.getHeight() * 0.2f);
        this.d = this.b.getTop() + height;
        this.e = this.b.getBottom() - height;
    }

    public final Bitmap o(View view) {
        boolean z = view instanceof xu3;
        if (z) {
            ((xu3) view).b();
        }
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        Bitmap bitmapCopy = null;
        if (drawingCache != null) {
            try {
                bitmapCopy = drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            } catch (OutOfMemoryError unused) {
            }
        }
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        if (z) {
            ((xu3) view).c();
        }
        return bitmapCopy;
    }

    public final void p() {
        if (this.c == null) {
            this.c = new Handler();
        }
    }

    public final void q(View view, View view2, int[] iArr) {
        if (view != view2) {
            r(view, iArr);
            if (view.getParent() != null) {
                q((View) view.getParent(), view2, iArr);
            }
        }
    }

    public final void r(View view, int[] iArr) {
        iArr[0] = iArr[0] + view.getLeft() + view.getPaddingLeft();
        iArr[1] = iArr[1] + view.getTop() + view.getPaddingLeft();
    }

    public final void s() {
        if (this.m || !this.l) {
            return;
        }
        this.b.l((int) this.n, (int) this.o);
        this.m = true;
        n();
    }

    public boolean t() {
        return this.l;
    }

    public boolean u(MotionEvent motionEvent) {
        this.n = motionEvent.getX();
        this.o = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.f = (int) motionEvent.getY();
        }
        s();
        return this.l;
    }

    public void v() {
        int[] iArr = {0, 0};
        this.q = iArr;
        q(this.b, this.p, iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean w(android.view.MotionEvent r6) {
        /*
            r5 = this;
            float r0 = r6.getX()
            r5.n = r0
            float r0 = r6.getY()
            r5.o = r0
            boolean r0 = r5.l
            r1 = 0
            if (r0 != 0) goto L12
            return r1
        L12:
            float r0 = r6.getX()
            int r0 = (int) r0
            float r2 = r6.getY()
            int r2 = (int) r2
            int r6 = r6.getAction()
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r6 == 0) goto L75
            r3 = 1
            if (r6 == r3) goto L5f
            r4 = 2
            if (r6 == r4) goto L2e
            r3 = 3
            if (r6 == r3) goto L5f
            goto L78
        L2e:
            r5.s()
            r5.g = r2
            com.yydcdut.sdlv.DragListView r6 = r5.b
            r6.k(r0, r2)
            boolean r6 = r5.h
            if (r6 != 0) goto L78
            int r6 = r5.g
            int r0 = r5.f
            int r6 = r6 - r0
            int r6 = java.lang.Math.abs(r6)
            float r6 = (float) r6
            r0 = 1082130432(0x40800000, float:4.0)
            float r1 = r5.i
            float r1 = r1 * r0
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 < 0) goto L78
            r5.h = r3
            r5.p()
            android.os.Handler r6 = r5.c
            java.lang.Runnable r0 = r5.s
            r1 = 5
            r6.postDelayed(r0, r1)
            goto L78
        L5f:
            r5.p()
            android.os.Handler r6 = r5.c
            java.lang.Runnable r3 = r5.s
            r6.removeCallbacks(r3)
            r5.h = r1
            com.yydcdut.sdlv.DragListView r6 = r5.b
            r6.j(r0, r2)
            r5.l = r1
            r5.m = r1
            goto L78
        L75:
            r5.s()
        L78:
            boolean r6 = r5.l
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.wu3.w(android.view.MotionEvent):boolean");
    }

    public void x(boolean z) {
        this.l = z;
        s();
    }
}
