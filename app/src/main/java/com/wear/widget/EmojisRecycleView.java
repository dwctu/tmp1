package com.wear.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.bean.FavoriteEmojisBean;
import dc.ce3;
import dc.he3;
import dc.ie3;

/* loaded from: classes4.dex */
public class EmojisRecycleView extends RecyclerView {
    public boolean a;
    public EmojisToastView b;
    public ie3 c;
    public String d;
    public FavoriteEmojisBean e;
    public int f;

    public EmojisRecycleView(@NonNull Context context) {
        super(context);
        this.a = false;
    }

    public EmojisRecycleView a(EmojisToastView emojisToastView) {
        this.b = emojisToastView;
        return this;
    }

    public EmojisRecycleView b(ie3 ie3Var) {
        this.c = ie3Var;
        return this;
    }

    public void c() {
        this.b.c();
        this.d = "";
    }

    public final View d(View view, int i, int i2) {
        ViewGroup viewGroup;
        int childCount;
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int width = view.getWidth() + i3;
        int height = view.getHeight() + i4;
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            for (int i5 = childCount - 1; i5 >= 0; i5--) {
                View viewD = d(viewGroup.getChildAt(i5), i, i2);
                if (viewD != null && i2 < height) {
                    return viewD;
                }
            }
        }
        if (i3 >= i || i4 >= i2 || width <= i || height <= i2) {
            return null;
        }
        return view;
    }

    public EmojisRecycleView e(int i) {
        this.f = i;
        return this;
    }

    public void f(FavoriteEmojisBean favoriteEmojisBean, int i, int i2) {
        this.b.setVisibility(0);
        this.b.b(getContext());
        this.b.e(this.c, i, i2, getWidth(), getWidth() / 5, favoriteEmojisBean.getPath(), "", "");
        this.a = true;
        this.e = favoriteEmojisBean;
    }

    public void g(String str, int i, int i2) {
        this.b.setVisibility(0);
        this.b.a(getContext());
        this.b.d(this.c, i, i2, str);
        this.a = true;
        this.d = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        onTouchEvent(motionEvent);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.a) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                View viewD = d(this, (int) motionEvent.getRawX(), (int) motionEvent.getRawY());
                if (viewD == null || !(viewD instanceof ImageView)) {
                    c();
                    this.a = false;
                } else if (this.f == 0) {
                    String str = (String) viewD.getTag(R.id.tag1);
                    if (!TextUtils.equals(str, this.d)) {
                        int[] iArr = new int[2];
                        viewD.getLocationOnScreen(iArr);
                        iArr[0] = iArr[0] + (viewD.getWidth() / 2);
                        iArr[1] = iArr[1] + ce3.a(getContext(), 14.0f);
                        g(str, iArr[0], iArr[1]);
                    }
                } else {
                    FavoriteEmojisBean favoriteEmojisBean = (FavoriteEmojisBean) viewD.getTag(R.id.tag1);
                    if (TextUtils.equals(favoriteEmojisBean.getId(), he3.a)) {
                        c();
                    } else if (this.e != favoriteEmojisBean) {
                        int[] iArr2 = new int[2];
                        viewD.getLocationOnScreen(iArr2);
                        iArr2[0] = iArr2[0] + (viewD.getWidth() / 2);
                        iArr2[1] = (iArr2[1] - (viewD.getHeight() / 2)) + ce3.a(getContext(), 16.0f);
                        f(favoriteEmojisBean, iArr2[0], iArr2[1]);
                    }
                }
            }
        } else if (this.a) {
            this.a = false;
            c();
        } else if (this.f == 0) {
            this.c.x(this.d);
        } else {
            FavoriteEmojisBean favoriteEmojisBean2 = this.e;
            if (favoriteEmojisBean2 != null && !TextUtils.isEmpty(favoriteEmojisBean2.getId()) && !TextUtils.isEmpty(this.e.getFileMd5())) {
                this.c.y(this.e);
            }
        }
        return this.a;
    }

    public EmojisRecycleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = false;
    }

    public EmojisRecycleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
    }
}
