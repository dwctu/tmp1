package dc;

import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

/* compiled from: SmartUtil.java */
/* loaded from: classes3.dex */
public class se1 implements Interpolator {
    public static int b = 0;
    public static int c = 1;
    public static float d = Resources.getSystem().getDisplayMetrics().density;
    public static final float e;
    public static final float f;
    public int a;

    static {
        float fK = 1.0f / k(1.0f);
        e = fK;
        f = 1.0f - (fK * k(1.0f));
    }

    public se1(int i) {
        this.a = i;
    }

    public static boolean a(@NonNull View view, PointF pointF, boolean z) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !f(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(ee1.srl_tag);
                    if ("fixed".equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean zA = a(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return zA;
                }
            }
        }
        return z || view.canScrollVertically(-1);
    }

    public static boolean b(@NonNull View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (g(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                Object tag = childAt.getTag(ee1.srl_tag);
                if ("fixed".equals(tag) || "fixed-bottom".equals(tag)) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean zB = b(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return zB;
            }
        }
        return true;
    }

    public static int c(float f2) {
        return (int) ((f2 * d) + 0.5f);
    }

    public static void d(View view, int i) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i);
            return;
        }
        if (view instanceof AbsListView) {
            if (Build.VERSION.SDK_INT >= 21) {
                ((AbsListView) view).fling(i);
            }
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i);
        }
    }

    public static boolean e(View view) {
        if (view instanceof vd1) {
            return false;
        }
        return f(view) || (view instanceof ViewPager) || (view instanceof NestedScrollingParent);
    }

    public static boolean f(View view) {
        if (view instanceof vd1) {
            return false;
        }
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof WebView) || (view instanceof NestedScrollingChild);
    }

    public static boolean g(@NonNull View view, @NonNull View view2, float f2, float f3, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f2, f3};
        fArr[0] = fArr[0] + (view.getScrollX() - view2.getLeft());
        fArr[1] = fArr[1] + (view.getScrollY() - view2.getTop());
        boolean z = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z && pointF != null) {
            pointF.set(fArr[0] - f2, fArr[1] - f3);
        }
        return z;
    }

    public static int h(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    public static float i(int i) {
        return i / d;
    }

    public static void j(@NonNull AbsListView absListView, int i) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            absListView.scrollListBy(i);
            return;
        }
        if (!(absListView instanceof ListView)) {
            absListView.smoothScrollBy(i, 0);
            return;
        }
        int firstVisiblePosition = absListView.getFirstVisiblePosition();
        if (firstVisiblePosition == -1 || (childAt = absListView.getChildAt(0)) == null) {
            return;
        }
        ((ListView) absListView).setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
    }

    public static float k(float f2) {
        float f3 = f2 * 8.0f;
        return f3 < 1.0f ? f3 - (1.0f - ((float) Math.exp(-f3))) : ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (this.a == c) {
            float f3 = 1.0f - f2;
            return 1.0f - (f3 * f3);
        }
        float fK = e * k(f2);
        return fK > 0.0f ? fK + f : fK;
    }
}
