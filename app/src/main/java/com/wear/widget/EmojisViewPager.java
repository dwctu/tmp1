package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.wear.bean.FavoriteEmojisBean;
import com.wear.util.WearUtils;
import dc.ie3;
import java.util.List;

/* loaded from: classes4.dex */
public class EmojisViewPager extends ViewPager {
    public boolean a;
    public ie3 b;
    public EmojisToastView c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public List<String> l;
    public List<FavoriteEmojisBean> m;
    public int n;
    public int o;
    public int p;
    public String q;

    public EmojisViewPager(@NonNull Context context) {
        super(context);
        this.a = false;
        this.d = -1;
        this.e = -1;
        this.f = 0;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = 0;
        this.n = -1;
        this.q = "";
    }

    public final void a() {
        this.q = null;
        this.n = -1;
        this.c.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.EmojisViewPager.b(int, int, int):void");
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = i;
        this.e = i2;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.a) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            this.a = false;
            this.c.setVisibility(8);
            onInterceptTouchEvent(motionEvent);
            if (this.b.h == 0 && !WearUtils.e1(this.q)) {
                ie3 ie3Var = this.b;
                ie3Var.x(ie3Var.u(this.q));
            }
            System.out.println("Emojis.ActionUp");
        } else if (action == 2) {
            if ((motionEvent.getX() > 0.0f) & (motionEvent.getX() < ((float) (this.d + (-10)))) & (motionEvent.getY() > 0.0f) & (motionEvent.getY() < ((float) this.e)) & (this.g > 0) & (this.h > 0) & (this.j >= 0)) {
                int y = (((int) (motionEvent.getY() / this.h)) * this.f) + ((int) (motionEvent.getX() / this.g));
                this.i = y;
                b(y, (int) (motionEvent.getX() / this.g), (int) (motionEvent.getY() / this.h));
            }
        } else if (action == 3) {
            System.out.println("Emojis.ActionCancel");
        }
        return this.a;
    }

    public void setEmojisToastView(ie3 ie3Var, EmojisToastView emojisToastView, int i, int i2, List<String> list, List<FavoriteEmojisBean> list2, int i3) {
        int i4 = ie3Var.h;
        if (i4 == 0) {
            this.f = 7;
            this.g = this.d / 7;
            this.h = this.e / 5;
            this.k = i3 / 5;
        } else {
            if (i4 != 1) {
                return;
            }
            this.f = 5;
            this.g = this.d / 5;
            this.h = this.e / 3;
            this.k = i3 / 3;
        }
        if (list == null && list2 == null) {
            return;
        }
        this.b = ie3Var;
        this.c = emojisToastView;
        this.j = i;
        this.l = list;
        this.m = list2;
        this.q = null;
        this.n = -1;
        emojisToastView.setVisibility(0);
        int i5 = ie3Var.h;
        if (i5 == 0) {
            this.c.a(ie3Var.t);
        } else if (i5 == 1) {
            this.c.b(ie3Var.t);
        }
        this.c.requestFocus();
        this.a = true;
        int i6 = this.f;
        b(i2, i2 % i6, i2 / i6);
    }

    public EmojisViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
        this.d = -1;
        this.e = -1;
        this.f = 0;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = 0;
        this.n = -1;
        this.q = "";
    }
}
