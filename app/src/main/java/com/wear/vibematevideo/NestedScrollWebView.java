package com.wear.vibematevideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import wendu.dsbridge.DWebView;

/* loaded from: classes4.dex */
public class NestedScrollWebView extends DWebView {
    public static final String r = NestedScrollWebView.class.getSimpleName();
    public int k;
    public int l;
    public int m;
    public double n;
    public double o;
    public boolean p;
    public Integer q;

    public NestedScrollWebView(Context context) {
        super(context);
        this.n = 200.0d;
        this.o = 200.0d;
        this.p = true;
        this.q = null;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Integer num = this.q;
        if (num != null) {
            i2 = View.MeasureSpec.makeMeasureSpec(num.intValue(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    @Override // android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r10)
            int r2 = androidx.core.view.MotionEventCompat.getActionMasked(r10)
            if (r2 != 0) goto L12
            r9.k = r1
        L12:
            r3 = 0
            int r4 = r9.k
            float r4 = (float) r4
            r10.offsetLocation(r3, r4)
            if (r2 == 0) goto Lc4
            r3 = 1
            if (r2 == r3) goto L35
            r3 = 2
            if (r2 == r3) goto L2c
            r0 = 3
            if (r2 == r0) goto L35
            r0 = 5
            if (r2 == r0) goto L35
            r0 = 6
            if (r2 == r0) goto L35
            goto Ld6
        L2c:
            boolean r1 = super.onTouchEvent(r0)
            r0.recycle()
            goto Ld6
        L35:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onTouchEvent : canGoBack："
            r0.append(r1)
            boolean r1 = r9.canGoBack()
            r0.append(r1)
            r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onTouchEvent : canGoForward："
            r0.append(r1)
            boolean r1 = r9.canGoForward()
            r0.append(r1)
            r0.toString()
            float r0 = r10.getX()
            int r0 = (int) r0
            float r1 = r10.getY()
            int r1 = (int) r1
            int r2 = r9.l
            r3 = 100
            if (r0 <= r2) goto L92
            boolean r2 = r9.canGoBack()
            if (r2 == 0) goto L92
            int r2 = r9.l
            int r4 = r0 - r2
            double r4 = (double) r4
            double r6 = r9.n
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L92
            if (r2 >= r3) goto L92
            int r0 = r9.m
            int r1 = r1 - r0
            int r0 = java.lang.Math.abs(r1)
            double r0 = (double) r0
            double r2 = r9.o
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto Lbf
            r9.goBack()
            goto Lbf
        L92:
            int r2 = r9.l
            if (r0 >= r2) goto Lbf
            boolean r2 = r9.canGoForward()
            if (r2 == 0) goto Lbf
            int r2 = r9.l
            int r0 = r2 - r0
            double r4 = (double) r0
            double r6 = r9.n
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto Lbf
            int r0 = dc.oe0.d()
            int r0 = r0 - r3
            if (r2 <= r0) goto Lbf
            int r0 = r9.m
            int r1 = r1 - r0
            int r0 = java.lang.Math.abs(r1)
            double r0 = (double) r0
            double r2 = r9.o
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto Lbf
            r9.goForward()
        Lbf:
            boolean r1 = super.onTouchEvent(r10)
            goto Ld6
        Lc4:
            float r0 = r10.getX()
            int r0 = (int) r0
            r9.l = r0
            float r0 = r10.getY()
            int r0 = (int) r0
            r9.m = r0
            boolean r1 = super.onTouchEvent(r10)
        Ld6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.vibematevideo.NestedScrollWebView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setTempHeight(int i) {
        this.q = Integer.valueOf(i);
        requestLayout();
    }

    public void setTouchEnable(boolean z) {
        this.p = z;
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 200.0d;
        this.o = 200.0d;
        this.p = true;
        this.q = null;
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.n = 200.0d;
        this.o = 200.0d;
        this.p = true;
        this.q = null;
    }
}
