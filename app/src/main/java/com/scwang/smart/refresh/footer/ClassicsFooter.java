package com.scwang.smart.refresh.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import dc.ae1;
import dc.ce1;
import dc.de1;
import dc.ld1;
import dc.md1;
import dc.nd1;
import dc.od1;
import dc.pd1;
import dc.qd1;
import dc.se1;
import dc.xd1;

/* loaded from: classes3.dex */
public class ClassicsFooter extends ClassicsAbstract<ClassicsFooter> implements xd1 {
    public static String A;
    public static String B;
    public static String C;
    public static String D;
    public static String E;
    public static String y;
    public static String z;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public boolean x;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ce1.values().length];
            a = iArr;
            try {
                iArr[ce1.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ce1.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ce1.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ce1.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ce1.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ce1.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ClassicsFooter(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.xd1
    public boolean b(boolean z2) {
        if (this.x == z2) {
            return true;
        }
        this.x = z2;
        ImageView imageView = this.e;
        if (z2) {
            this.d.setText(this.w);
            imageView.setVisibility(8);
            return true;
        }
        this.d.setText(this.q);
        imageView.setVisibility(0);
        return true;
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract, com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.vd1
    public int f(@NonNull ae1 ae1Var, boolean z2) {
        super.f(ae1Var, z2);
        if (this.x) {
            return 0;
        }
        this.d.setText(z2 ? this.u : this.v);
        return this.m;
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.oe1
    public void h(@NonNull ae1 ae1Var, @NonNull ce1 ce1Var, @NonNull ce1 ce1Var2) {
        ImageView imageView = this.e;
        if (this.x) {
            return;
        }
        switch (a.a[ce1Var2.ordinal()]) {
            case 1:
                imageView.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                imageView.setVisibility(8);
                this.d.setText(this.s);
                return;
            case 5:
                this.d.setText(this.r);
                imageView.animate().rotation(0.0f);
                return;
            case 6:
                this.d.setText(this.t);
                imageView.setVisibility(8);
                return;
            default:
                return;
        }
        this.d.setText(this.q);
        imageView.animate().rotation(180.0f);
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract, com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.vd1
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (this.b == de1.f) {
            super.setPrimaryColors(iArr);
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.x = false;
        View.inflate(context, od1.srl_classics_footer, this);
        ImageView imageView = (ImageView) findViewById(nd1.srl_classics_arrow);
        this.e = imageView;
        ImageView imageView2 = (ImageView) findViewById(nd1.srl_classics_progress);
        this.f = imageView2;
        this.d = (TextView) findViewById(nd1.srl_classics_title);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, qd1.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(qd1.ClassicsFooter_srlDrawableMarginRight, se1.c(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i = qd1.ClassicsFooter_srlDrawableArrowSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i, layoutParams.height);
        int i2 = qd1.ClassicsFooter_srlDrawableProgressSize;
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i2, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i2, layoutParams2.height);
        int i3 = qd1.ClassicsFooter_srlDrawableSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i3, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i3, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i3, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i3, layoutParams2.height);
        this.m = typedArrayObtainStyledAttributes.getInt(qd1.ClassicsFooter_srlFinishDuration, this.m);
        this.b = de1.i[typedArrayObtainStyledAttributes.getInt(qd1.ClassicsFooter_srlClassicsSpinnerStyle, this.b.a)];
        int i4 = qd1.ClassicsFooter_srlDrawableArrow;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.e.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i4));
        } else if (this.e.getDrawable() == null) {
            md1 md1Var = new md1();
            this.h = md1Var;
            md1Var.a(-10066330);
            this.e.setImageDrawable(this.h);
        }
        int i5 = qd1.ClassicsFooter_srlDrawableProgress;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            this.f.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i5));
        } else if (this.f.getDrawable() == null) {
            ld1 ld1Var = new ld1();
            this.i = ld1Var;
            ld1Var.a(-10066330);
            this.f.setImageDrawable(this.i);
        }
        if (typedArrayObtainStyledAttributes.hasValue(qd1.ClassicsFooter_srlTextSizeTitle)) {
            this.d.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(r3, se1.c(16.0f)));
        }
        int i6 = qd1.ClassicsFooter_srlPrimaryColor;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            super.t(typedArrayObtainStyledAttributes.getColor(i6, 0));
        }
        int i7 = qd1.ClassicsFooter_srlAccentColor;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            super.s(typedArrayObtainStyledAttributes.getColor(i7, 0));
        }
        int i8 = qd1.ClassicsFooter_srlTextPulling;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.q = typedArrayObtainStyledAttributes.getString(i8);
        } else {
            String str = y;
            if (str != null) {
                this.q = str;
            } else {
                this.q = context.getString(pd1.srl_footer_pulling);
            }
        }
        int i9 = qd1.ClassicsFooter_srlTextRelease;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            this.r = typedArrayObtainStyledAttributes.getString(i9);
        } else {
            String str2 = z;
            if (str2 != null) {
                this.r = str2;
            } else {
                this.r = context.getString(pd1.srl_footer_release);
            }
        }
        int i10 = qd1.ClassicsFooter_srlTextLoading;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            this.s = typedArrayObtainStyledAttributes.getString(i10);
        } else {
            String str3 = A;
            if (str3 != null) {
                this.s = str3;
            } else {
                this.s = context.getString(pd1.srl_footer_loading);
            }
        }
        int i11 = qd1.ClassicsFooter_srlTextRefreshing;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.t = typedArrayObtainStyledAttributes.getString(i11);
        } else {
            String str4 = B;
            if (str4 != null) {
                this.t = str4;
            } else {
                this.t = context.getString(pd1.srl_footer_refreshing);
            }
        }
        int i12 = qd1.ClassicsFooter_srlTextFinish;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            this.u = typedArrayObtainStyledAttributes.getString(i12);
        } else {
            String str5 = C;
            if (str5 != null) {
                this.u = str5;
            } else {
                this.u = context.getString(pd1.srl_footer_finish);
            }
        }
        int i13 = qd1.ClassicsFooter_srlTextFailed;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            this.v = typedArrayObtainStyledAttributes.getString(i13);
        } else {
            String str6 = D;
            if (str6 != null) {
                this.v = str6;
            } else {
                this.v = context.getString(pd1.srl_footer_failed);
            }
        }
        int i14 = qd1.ClassicsFooter_srlTextNothing;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            this.w = typedArrayObtainStyledAttributes.getString(i14);
        } else {
            String str7 = E;
            if (str7 != null) {
                this.w = str7;
            } else {
                this.w = context.getString(pd1.srl_footer_nothing);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        this.d.setText(isInEditMode() ? this.s : this.q);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }
}
