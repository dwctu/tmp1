package dc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.yydcdut.sdlv.ItemBackGroundLayout;

/* compiled from: ItemMainLayout.java */
/* loaded from: classes4.dex */
public class xu3 extends FrameLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public ItemBackGroundLayout e;
    public ItemBackGroundLayout f;
    public View g;
    public Scroller h;
    public boolean i;
    public boolean j;
    public int k;
    public e l;
    public d m;
    public Drawable n;
    public Drawable o;
    public Drawable p;
    public Drawable q;

    /* compiled from: ItemMainLayout.java */
    public class a implements Animation.AnimationListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ int b;

        public a(c cVar, int i) {
            this.a = cVar;
            this.b = i;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ViewGroup.LayoutParams layoutParams = xu3.this.getLayoutParams();
            layoutParams.height = this.b;
            xu3.this.setLayoutParams(layoutParams);
            c cVar = this.a;
            if (cVar != null) {
                cVar.f(xu3.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    /* compiled from: ItemMainLayout.java */
    public class b extends Animation {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            ViewGroup.LayoutParams layoutParams = xu3.this.getLayoutParams();
            int i = this.a;
            layoutParams.height = i - ((int) (i * f));
            xu3.this.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: ItemMainLayout.java */
    public interface c {
        void a();

        void f(View view);
    }

    /* compiled from: ItemMainLayout.java */
    public interface d {
        void e(View view);
    }

    /* compiled from: ItemMainLayout.java */
    public interface e {
        void c(View view, int i);

        void h(View view, int i);
    }

    public xu3(Context context, View view) {
        super(context);
        this.a = 0;
        this.b = 0;
        this.i = false;
        this.j = true;
        this.k = 0;
        this.h = new Scroller(context);
        ItemBackGroundLayout itemBackGroundLayout = new ItemBackGroundLayout(context);
        this.f = itemBackGroundLayout;
        addView(itemBackGroundLayout, new FrameLayout.LayoutParams(-1, -1));
        ItemBackGroundLayout itemBackGroundLayout2 = new ItemBackGroundLayout(context);
        this.e = itemBackGroundLayout2;
        addView(itemBackGroundLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.g = view;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            addView(this.g, new FrameLayout.LayoutParams(-1, -1));
        } else {
            addView(this.g, layoutParams);
        }
        this.k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        k();
    }

    public void a(c cVar) {
        m();
        int measuredHeight = getMeasuredHeight();
        a aVar = new a(cVar, measuredHeight);
        b bVar = new b(measuredHeight);
        bVar.setAnimationListener(aVar);
        bVar.setDuration(300L);
        startAnimation(bVar);
    }

    public void b() {
        if (this.n != null) {
            vu3.a(f(), this.n);
        }
        if (this.p != null) {
            vu3.a(g(), this.p);
            vu3.a(h(), this.p);
        }
    }

    public void c() {
        if (this.o != null) {
            vu3.a(f(), this.o);
        }
        if (this.q != null) {
            vu3.a(g(), this.q);
            vu3.a(h(), this.q);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.h.computeScrollOffset()) {
            int currX = this.h.getCurrX();
            View view = this.g;
            view.layout(currX, view.getTop(), this.h.getCurrX() + this.g.getWidth(), this.g.getBottom());
            postInvalidate();
            if (currX == 0) {
                o(false, false);
                c();
                d dVar = this.m;
                if (dVar != null) {
                    dVar.e(this);
                    this.m = null;
                }
            }
        }
        super.computeScroll();
    }

    public final boolean d(MotionEvent motionEvent, float f, float f2) {
        return (motionEvent.getX() - f > ((float) this.k) || motionEvent.getX() - f < ((float) (-this.k))) && motionEvent.getY() - f2 < ((float) this.k) && motionEvent.getY() - f2 > ((float) (-this.k));
    }

    public final boolean e(MotionEvent motionEvent, float f, float f2) {
        return f - motionEvent.getX() < ((float) this.k) && f - motionEvent.getX() > ((float) (-this.k)) && f2 - motionEvent.getY() < ((float) this.k) && f2 - motionEvent.getY() > ((float) (-this.k));
    }

    public View f() {
        return this.g;
    }

    public ItemBackGroundLayout g() {
        return this.e;
    }

    public ItemBackGroundLayout h() {
        return this.f;
    }

    public int i() {
        return this.b;
    }

    public void j(MotionEvent motionEvent, float f, float f2, int i) {
        float f3;
        getParent().requestDisallowInterceptTouchEvent(false);
        int action = motionEvent.getAction() & 255;
        if (action != 1) {
            if (action == 2) {
                if (e(motionEvent, f, f2) && !this.i) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    return;
                }
                if (d(motionEvent, f, f2) || this.i) {
                    b();
                    this.i = true;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    float x = motionEvent.getX() - f;
                    if (x > 0.0f) {
                        if (i == 0) {
                            this.a = 1;
                            o(true, false);
                        } else if (i < 0) {
                            this.a = -2;
                            o(false, true);
                        } else if (i > 0) {
                            this.a = 3;
                            o(true, false);
                        }
                    } else if (x < 0.0f) {
                        if (i == 0) {
                            this.a = -1;
                            o(false, true);
                        } else if (i < 0) {
                            this.a = -3;
                            o(false, true);
                        } else if (i > 0) {
                            this.a = 2;
                            o(true, false);
                        }
                    }
                    int i2 = this.a;
                    if (i2 != -3) {
                        if (i2 == -2) {
                            float f4 = i + x;
                            f3 = f4 <= 0.0f ? f4 : 0.0f;
                            View view = this.g;
                            int i3 = (int) f3;
                            view.layout(i3, view.getTop(), this.g.getWidth() + i3, this.g.getBottom());
                            return;
                        }
                        if (i2 != -1) {
                            if (i2 != 1) {
                                if (i2 == 2) {
                                    float f5 = i + x;
                                    f3 = f5 >= 0.0f ? f5 : 0.0f;
                                    View view2 = this.g;
                                    int i4 = (int) f3;
                                    view2.layout(i4, view2.getTop(), this.g.getWidth() + i4, this.g.getBottom());
                                    return;
                                }
                                if (i2 != 3) {
                                    return;
                                }
                            }
                            if (this.e.b()) {
                                float f6 = i + x;
                                if (!this.j) {
                                    int i5 = this.c;
                                    if (f6 > i5) {
                                        f6 = i5;
                                    }
                                }
                                View view3 = this.g;
                                int i6 = (int) f6;
                                view3.layout(i6, view3.getTop(), this.g.getWidth() + i6, this.g.getBottom());
                                return;
                            }
                            return;
                        }
                    }
                    if (this.f.b()) {
                        float f7 = i + x;
                        if (!this.j) {
                            float f8 = -f7;
                            int i7 = this.d;
                            if (f8 > i7) {
                                f7 = -i7;
                            }
                        }
                        View view4 = this.g;
                        int i8 = (int) f7;
                        view4.layout(i8, view4.getTop(), this.g.getWidth() + i8, this.g.getBottom());
                        return;
                    }
                    return;
                }
                return;
            }
            if (action != 3) {
                return;
            }
        }
        int i9 = this.a;
        if (i9 == -3 || i9 == -2 || i9 == -1) {
            int iAbs = Math.abs(this.g.getLeft());
            int i10 = this.d;
            if (iAbs > i10 / 2) {
                this.a = -1;
                this.h.startScroll(this.g.getLeft(), 0, -(i10 - Math.abs(this.g.getLeft())), 0, 500);
                e eVar = this.l;
                if (eVar != null && this.b != 1) {
                    eVar.c(this, -1);
                }
                this.b = 1;
            } else {
                this.a = -2;
                this.h.startScroll(this.g.getLeft(), 0, -this.g.getLeft(), 0, 500);
                e eVar2 = this.l;
                if (eVar2 != null && this.b != 0) {
                    eVar2.h(this, -1);
                }
                this.b = 0;
            }
        } else if (i9 == 1 || i9 == 2 || i9 == 3) {
            int iAbs2 = Math.abs(this.g.getLeft());
            int i11 = this.c;
            if (iAbs2 > i11 / 2) {
                this.a = 1;
                this.h.startScroll(this.g.getLeft(), 0, i11 - Math.abs(this.g.getLeft()), 0, 500);
                e eVar3 = this.l;
                if (eVar3 != null && this.b != 1) {
                    eVar3.c(this, 1);
                }
                this.b = 1;
            } else {
                this.a = 2;
                this.h.startScroll(this.g.getLeft(), 0, -this.g.getLeft(), 0, 500);
                e eVar4 = this.l;
                if (eVar4 != null && this.b != 0) {
                    eVar4.h(this, 1);
                }
                this.b = 0;
            }
        }
        this.a = 0;
        postInvalidate();
        this.i = false;
    }

    public final void k() {
        Drawable background = f().getBackground();
        if (background != null) {
            if (background instanceof StateListDrawable) {
                this.n = ((StateListDrawable) background).getCurrent();
            } else {
                this.n = background;
            }
            this.o = background;
        }
        Drawable background2 = g().getBackground();
        if (background2 != null) {
            if (background2 instanceof StateListDrawable) {
                this.p = ((StateListDrawable) background2).getCurrent();
            } else {
                this.p = background2;
            }
            this.q = background2;
        }
    }

    public int l(float f) {
        if (this.b == 0) {
            return 2;
        }
        if (this.g.getLeft() > 0) {
            if (f <= this.g.getLeft()) {
                return 3;
            }
            m();
            this.b = 0;
            return 1;
        }
        if (this.g.getLeft() >= 0 || f >= this.g.getRight()) {
            return 3;
        }
        m();
        this.b = 0;
        return 1;
    }

    public void m() {
        this.a = -4;
        this.h.startScroll(this.g.getLeft(), 0, -this.g.getLeft(), 0, 250);
        e eVar = this.l;
        if (eVar != null && this.b != 0) {
            eVar.h(this, f().getLeft() < 0 ? 1 : -1);
        }
        postInvalidate();
        this.b = 0;
        c();
    }

    public void n(d dVar) {
        this.m = dVar;
        this.a = -4;
        this.h.startScroll(this.g.getLeft(), 0, -this.g.getLeft(), 0, 250);
        e eVar = this.l;
        if (eVar != null && this.b != 0) {
            eVar.h(this, f().getLeft() < 0 ? 1 : -1);
        }
        postInvalidate();
        this.b = 0;
        c();
    }

    public final void o(boolean z, boolean z2) {
        if (z) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
        if (z2) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public void p(e eVar) {
        this.l = eVar;
    }

    public void q(int i, int i2, boolean z) {
        requestLayout();
        this.c = i;
        this.d = i2;
        this.j = z;
    }

    public void r(Drawable drawable) {
        vu3.a(this.e, drawable);
        vu3.a(this.f, drawable);
    }
}
