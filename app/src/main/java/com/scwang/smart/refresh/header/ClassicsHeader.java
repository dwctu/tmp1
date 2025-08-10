package com.scwang.smart.refresh.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import dc.ae1;
import dc.ce1;
import dc.de1;
import dc.ld1;
import dc.md1;
import dc.rd1;
import dc.sd1;
import dc.se1;
import dc.td1;
import dc.ud1;
import dc.yd1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ClassicsHeader extends ClassicsAbstract<ClassicsHeader> implements yd1 {
    public static String E = null;
    public static String F = null;
    public static String G = null;
    public static String K = null;
    public static String L = null;
    public static String M = null;
    public static String N = null;
    public static String O = null;
    public String A;
    public String B;
    public String C;
    public String D;
    public String q;
    public Date r;
    public TextView s;
    public SharedPreferences t;
    public DateFormat u;
    public boolean v;
    public String w;
    public String x;
    public String y;
    public String z;

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
                a[ce1.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ce1.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ce1.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ce1.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ce1.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ce1.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ClassicsHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract, com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.vd1
    public int f(@NonNull ae1 ae1Var, boolean z) {
        if (z) {
            this.d.setText(this.A);
            if (this.r != null) {
                v(new Date());
            }
        } else {
            this.d.setText(this.B);
        }
        return super.f(ae1Var, z);
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, dc.oe1
    public void h(@NonNull ae1 ae1Var, @NonNull ce1 ce1Var, @NonNull ce1 ce1Var2) {
        ImageView imageView = this.e;
        TextView textView = this.s;
        switch (a.a[ce1Var2.ordinal()]) {
            case 1:
                textView.setVisibility(this.v ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.d.setText(this.x);
                imageView.setVisibility(8);
                return;
            case 5:
                this.d.setText(this.z);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.d.setText(this.D);
                imageView.animate().rotation(0.0f);
                return;
            case 7:
                imageView.setVisibility(8);
                textView.setVisibility(this.v ? 4 : 8);
                this.d.setText(this.y);
                return;
            default:
                return;
        }
        this.d.setText(this.w);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    @Override // com.scwang.smart.refresh.classics.ClassicsAbstract
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public ClassicsHeader s(@ColorInt int i) {
        this.s.setTextColor((16777215 & i) | (-872415232));
        super.s(i);
        return this;
    }

    public ClassicsHeader v(Date date) {
        this.r = date;
        this.s.setText(this.u.format(date));
        if (this.t != null && !isInEditMode()) {
            this.t.edit().putLong(this.q, date.getTime()).apply();
        }
        return this;
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        FragmentManager supportFragmentManager;
        super(context, attributeSet, 0);
        this.q = "LAST_UPDATE_TIME";
        this.v = true;
        View.inflate(context, sd1.srl_classics_header, this);
        ImageView imageView = (ImageView) findViewById(rd1.srl_classics_arrow);
        this.e = imageView;
        TextView textView = (TextView) findViewById(rd1.srl_classics_update);
        this.s = textView;
        ImageView imageView2 = (ImageView) findViewById(rd1.srl_classics_progress);
        this.f = imageView2;
        this.d = (TextView) findViewById(rd1.srl_classics_title);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ud1.ClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        new LinearLayout.LayoutParams(-2, -2).topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(ud1.ClassicsHeader_srlTextTimeMarginTop, se1.c(0.0f));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(ud1.ClassicsHeader_srlDrawableMarginRight, se1.c(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i = ud1.ClassicsHeader_srlDrawableArrowSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i, layoutParams.height);
        int i2 = ud1.ClassicsHeader_srlDrawableProgressSize;
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i2, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i2, layoutParams2.height);
        int i3 = ud1.ClassicsHeader_srlDrawableSize;
        layoutParams.width = typedArrayObtainStyledAttributes.getLayoutDimension(i3, layoutParams.width);
        layoutParams.height = typedArrayObtainStyledAttributes.getLayoutDimension(i3, layoutParams.height);
        layoutParams2.width = typedArrayObtainStyledAttributes.getLayoutDimension(i3, layoutParams2.width);
        layoutParams2.height = typedArrayObtainStyledAttributes.getLayoutDimension(i3, layoutParams2.height);
        this.m = typedArrayObtainStyledAttributes.getInt(ud1.ClassicsHeader_srlFinishDuration, this.m);
        this.v = typedArrayObtainStyledAttributes.getBoolean(ud1.ClassicsHeader_srlEnableLastTime, this.v);
        this.b = de1.i[typedArrayObtainStyledAttributes.getInt(ud1.ClassicsHeader_srlClassicsSpinnerStyle, this.b.a)];
        int i4 = ud1.ClassicsHeader_srlDrawableArrow;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            this.e.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i4));
        } else if (this.e.getDrawable() == null) {
            md1 md1Var = new md1();
            this.h = md1Var;
            md1Var.a(-10066330);
            this.e.setImageDrawable(this.h);
        }
        int i5 = ud1.ClassicsHeader_srlDrawableProgress;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            this.f.setImageDrawable(typedArrayObtainStyledAttributes.getDrawable(i5));
        } else if (this.f.getDrawable() == null) {
            ld1 ld1Var = new ld1();
            this.i = ld1Var;
            ld1Var.a(-10066330);
            this.f.setImageDrawable(this.i);
        }
        if (typedArrayObtainStyledAttributes.hasValue(ud1.ClassicsHeader_srlTextSizeTitle)) {
            this.d.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(r4, se1.c(16.0f)));
        }
        if (typedArrayObtainStyledAttributes.hasValue(ud1.ClassicsHeader_srlTextSizeTime)) {
            this.s.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(r4, se1.c(12.0f)));
        }
        int i6 = ud1.ClassicsHeader_srlPrimaryColor;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            super.t(typedArrayObtainStyledAttributes.getColor(i6, 0));
        }
        int i7 = ud1.ClassicsHeader_srlAccentColor;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            s(typedArrayObtainStyledAttributes.getColor(i7, 0));
        }
        int i8 = ud1.ClassicsHeader_srlTextPulling;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            this.w = typedArrayObtainStyledAttributes.getString(i8);
        } else {
            String str = E;
            if (str != null) {
                this.w = str;
            } else {
                this.w = context.getString(td1.srl_header_pulling);
            }
        }
        int i9 = ud1.ClassicsHeader_srlTextLoading;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            this.y = typedArrayObtainStyledAttributes.getString(i9);
        } else {
            String str2 = G;
            if (str2 != null) {
                this.y = str2;
            } else {
                this.y = context.getString(td1.srl_header_loading);
            }
        }
        int i10 = ud1.ClassicsHeader_srlTextRelease;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            this.z = typedArrayObtainStyledAttributes.getString(i10);
        } else {
            String str3 = K;
            if (str3 != null) {
                this.z = str3;
            } else {
                this.z = context.getString(td1.srl_header_release);
            }
        }
        int i11 = ud1.ClassicsHeader_srlTextFinish;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.A = typedArrayObtainStyledAttributes.getString(i11);
        } else {
            String str4 = L;
            if (str4 != null) {
                this.A = str4;
            } else {
                this.A = context.getString(td1.srl_header_finish);
            }
        }
        int i12 = ud1.ClassicsHeader_srlTextFailed;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            this.B = typedArrayObtainStyledAttributes.getString(i12);
        } else {
            String str5 = M;
            if (str5 != null) {
                this.B = str5;
            } else {
                this.B = context.getString(td1.srl_header_failed);
            }
        }
        int i13 = ud1.ClassicsHeader_srlTextSecondary;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            this.D = typedArrayObtainStyledAttributes.getString(i13);
        } else {
            String str6 = O;
            if (str6 != null) {
                this.D = str6;
            } else {
                this.D = context.getString(td1.srl_header_secondary);
            }
        }
        int i14 = ud1.ClassicsHeader_srlTextRefreshing;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            this.x = typedArrayObtainStyledAttributes.getString(i14);
        } else {
            String str7 = F;
            if (str7 != null) {
                this.x = str7;
            } else {
                this.x = context.getString(td1.srl_header_refreshing);
            }
        }
        int i15 = ud1.ClassicsHeader_srlTextUpdate;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            this.C = typedArrayObtainStyledAttributes.getString(i15);
        } else {
            String str8 = N;
            if (str8 != null) {
                this.C = str8;
            } else {
                this.C = context.getString(td1.srl_header_update);
            }
        }
        this.u = new SimpleDateFormat(this.C, Locale.getDefault());
        typedArrayObtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        textView.setVisibility(this.v ? 0 : 8);
        this.d.setText(isInEditMode() ? this.x : this.w);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && supportFragmentManager.getFragments().size() > 0) {
                v(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.q += context.getClass().getName();
        this.t = context.getSharedPreferences("ClassicsHeader", 0);
        v(new Date(this.t.getLong(this.q, System.currentTimeMillis())));
    }
}
