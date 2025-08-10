package dc;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.viewpager.widget.ViewPager;
import java.util.LinkedList;

/* compiled from: RefreshContentWrapper.java */
/* loaded from: classes3.dex */
public class te1 implements wd1, he1, ValueAnimator.AnimatorUpdateListener {
    public View a;
    public View b;
    public View c;
    public View d;
    public View e;
    public int f = 0;
    public boolean g = true;
    public boolean h = true;
    public qe1 i = new qe1();

    public te1(@NonNull View view) {
        this.c = view;
        this.b = view;
        this.a = view;
    }

    @Override // dc.wd1
    public void a(pe1 pe1Var) {
        if (pe1Var instanceof qe1) {
            this.i = (qe1) pe1Var;
        } else {
            this.i.b = pe1Var;
        }
    }

    @Override // dc.wd1
    public void b(MotionEvent motionEvent) {
        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
        pointF.offset(-this.a.getLeft(), -this.a.getTop());
        View view = this.c;
        View view2 = this.a;
        if (view != view2) {
            this.c = l(view2, pointF, view);
        }
        if (this.c == this.a) {
            this.i.a = null;
        } else {
            this.i.a = pointF;
        }
    }

    @Override // dc.wd1
    public void c(zd1 zd1Var, View view, View view2) {
        k(this.a, zd1Var);
        if (view == null && view2 == null) {
            return;
        }
        this.d = view;
        this.e = view2;
        FrameLayout frameLayout = new FrameLayout(this.a.getContext());
        int iIndexOfChild = zd1Var.d().getLayout().indexOfChild(this.a);
        zd1Var.d().getLayout().removeView(this.a);
        frameLayout.addView(this.a, 0, new ViewGroup.LayoutParams(-1, -1));
        zd1Var.d().getLayout().addView(frameLayout, iIndexOfChild, this.a.getLayoutParams());
        this.a = frameLayout;
        if (view != null) {
            view.setTag(ee1.srl_tag, "fixed-top");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int iIndexOfChild2 = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            layoutParams.height = se1.h(view);
            viewGroup.addView(new Space(this.a.getContext()), iIndexOfChild2, layoutParams);
            frameLayout.addView(view, 1, layoutParams);
        }
        if (view2 != null) {
            view2.setTag(ee1.srl_tag, "fixed-bottom");
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            int iIndexOfChild3 = viewGroup2.indexOfChild(view2);
            viewGroup2.removeView(view2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(layoutParams2);
            layoutParams2.height = se1.h(view2);
            viewGroup2.addView(new Space(this.a.getContext()), iIndexOfChild3, layoutParams2);
            layoutParams3.gravity = 80;
            frameLayout.addView(view2, 1, layoutParams3);
        }
    }

    @Override // dc.wd1
    public void d(boolean z) {
        this.i.c = z;
    }

    @Override // dc.wd1
    public ValueAnimator.AnimatorUpdateListener e(int i) {
        View view = this.c;
        if (view == null || i == 0) {
            return null;
        }
        if ((i >= 0 || !view.canScrollVertically(1)) && (i <= 0 || !this.c.canScrollVertically(-1))) {
            return null;
        }
        this.f = i;
        return this;
    }

    @Override // dc.wd1
    @NonNull
    public View f() {
        return this.c;
    }

    @Override // dc.wd1
    public boolean g() {
        return this.g && this.i.a(this.a);
    }

    @Override // dc.wd1
    @NonNull
    public View getView() {
        return this.a;
    }

    @Override // dc.wd1
    public void h(int i, int i2, int i3) {
        boolean z;
        View viewFindViewById;
        View viewFindViewById2;
        boolean z2 = true;
        if (i2 == -1 || (viewFindViewById2 = this.b.findViewById(i2)) == null) {
            z = false;
        } else if (i > 0) {
            viewFindViewById2.setTranslationY(i);
            z = true;
        } else {
            if (viewFindViewById2.getTranslationY() > 0.0f) {
                viewFindViewById2.setTranslationY(0.0f);
            }
            z = false;
        }
        if (i3 == -1 || (viewFindViewById = this.b.findViewById(i3)) == null) {
            z2 = z;
        } else if (i < 0) {
            viewFindViewById.setTranslationY(i);
        } else {
            if (viewFindViewById.getTranslationY() < 0.0f) {
                viewFindViewById.setTranslationY(0.0f);
            }
            z2 = z;
        }
        if (z2) {
            this.b.setTranslationY(0.0f);
        } else {
            this.b.setTranslationY(i);
        }
        View view = this.d;
        if (view != null) {
            view.setTranslationY(Math.max(0, i));
        }
        View view2 = this.e;
        if (view2 != null) {
            view2.setTranslationY(Math.min(0, i));
        }
    }

    @Override // dc.wd1
    public boolean i() {
        return this.h && this.i.b(this.a);
    }

    @Override // dc.he1
    public void j(boolean z, boolean z2) {
        this.g = z;
        this.h = z2;
    }

    public void k(View view, zd1 zd1Var) {
        boolean zIsInEditMode = this.a.isInEditMode();
        View view2 = null;
        while (true) {
            if (view2 != null && (!(view2 instanceof NestedScrollingParent) || (view2 instanceof NestedScrollingChild))) {
                break;
            }
            view = m(view, view2 == null);
            if (view == view2) {
                break;
            }
            if (!zIsInEditMode) {
                re1.a(view, zd1Var, this);
            }
            view2 = view;
        }
        if (view2 != null) {
            this.c = view2;
        }
    }

    public View l(View view, PointF pointF, View view2) {
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (se1.g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    if (!(childAt instanceof ViewPager) && se1.e(childAt)) {
                        return childAt;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    View viewL = l(childAt, pointF, view2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return viewL;
                }
            }
        }
        return view2;
    }

    public View m(View view, boolean z) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(view);
        View view2 = null;
        while (linkedList.size() > 0 && view2 == null) {
            View view3 = (View) linkedList.poll();
            if (view3 != null) {
                if ((z || view3 != view) && se1.e(view3)) {
                    view2 = view3;
                } else if (view3 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        linkedList.add(viewGroup.getChildAt(i));
                    }
                }
            }
        }
        return view2 == null ? view : view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        try {
            float scaleY = (iIntValue - this.f) * this.c.getScaleY();
            View view = this.c;
            if (view instanceof AbsListView) {
                se1.j((AbsListView) view, (int) scaleY);
            } else {
                view.scrollBy(0, (int) scaleY);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f = iIntValue;
    }
}
