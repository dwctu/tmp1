package com.wear.widget.velvo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lovense.wear.R;
import com.wear.databinding.ViewVelvoPreviewBinding;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.vi1;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VelvoPreviewView.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001AB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\u0015J\u0012\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0011H\u0002J\b\u0010*\u001a\u00020\u001cH\u0002J\b\u0010+\u001a\u00020\u001cH\u0002J\b\u0010,\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020\u001cH\u0002J\u0006\u0010.\u001a\u00020#J\u001a\u0010/\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u00100\u001a\u00020#H\u0002J0\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u0002022\u0006\u00105\u001a\u0002022\u0006\u00106\u001a\u0002022\u0006\u00107\u001a\u000202H\u0002J\b\u00108\u001a\u00020#H\u0014J\u0010\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020(H\u0017J\u0006\u0010;\u001a\u00020#J\u0006\u0010<\u001a\u00020#J\u0006\u0010=\u001a\u00020#J\u000e\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\u001cJ\u0006\u0010@\u001a\u00020#R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\u001c*\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006B"}, d2 = {"Lcom/wear/widget/velvo/VelvoPreviewView;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/wear/databinding/ViewVelvoPreviewBinding;", "isDarkMode", "", "isDrag", "isDragEnable", "isInit", "isNeedAttach", "isRight", "lastRawX", "", "lastRawY", "onPreviewHiddenListeners", "", "", "Lcom/wear/widget/velvo/VelvoPreviewView$OnPreviewHiddenListener;", "originHeight", "originWidth", "originX", "originY", "rootMeasuredHeight", "", "rootMeasuredWidth", "rootTopY", "dp", "getDp", "(I)I", "addOnPreviewHiddenListener", "", "onPreviewHiddenListener", "multiControlPanel", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getMiddle", "getScaleCapX", "getScaleCapY", "getScreenWidth", "getVelvoExpandImageResource", "hide", "initAttrs", "initListeners", "mapRange", "", "x", "inMin", "inMax", "outMin", "outMax", "onDetachedFromWindow", "onTouchEvent", "event", "reset", "resetDarkMode", "setDarkMode", "setPointY", "pointY", "show", "OnPreviewHiddenListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class VelvoPreviewView extends CardView {

    @NotNull
    public ViewVelvoPreviewBinding a;
    public boolean b;
    public boolean c;
    public boolean d;
    public float e;
    public float f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;

    @NotNull
    public Map<String, a> l;
    public float m;
    public float n;
    public float o;
    public float p;
    public boolean q;

    /* compiled from: VelvoPreviewView.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/wear/widget/velvo/VelvoPreviewView$OnPreviewHiddenListener;", "", "onPreviewHidden", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VelvoPreviewView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VelvoPreviewView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public static final void d(VelvoPreviewView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibility(8);
        this$0.setSelected(false);
        this$0.j = false;
        this$0.setX(this$0.m);
        this$0.setY(this$0.n);
        this$0.setPivotX(this$0.getWidth() / 2.0f);
        this$0.setPivotY(this$0.getHeight() / 2.0f);
        this$0.setScaleX(1.0f);
        this$0.setScaleY(1.0f);
        this$0.setAlpha(1.0f);
        this$0.getLayoutParams().width = (int) this$0.o;
        this$0.getLayoutParams().height = (int) this$0.p;
        this$0.a.e.setScaleX(1.0f);
        this$0.a.e.setScaleY(1.0f);
        this$0.a.d.setScaleX(1.0f);
        this$0.a.d.setScaleY(1.0f);
        this$0.a.f.setScaleX(1.0f);
        this$0.a.f.setScaleY(1.0f);
        this$0.a.d.setImageResource(this$0.getVelvoExpandImageResource());
    }

    public static final void g(VelvoPreviewView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<a> it = this$0.l.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this$0.c();
    }

    private final float getMiddle() {
        return (getX() - getScaleCapX()) + ((getWidth() * getScaleX()) / 2);
    }

    private final int getScaleCapX() {
        if (this.j) {
            return getWidth();
        }
        return 0;
    }

    private final int getScaleCapY() {
        if (!isSelected()) {
            return 0;
        }
        if (getPivotY() == ((float) getHeight())) {
            return getHeight();
        }
        return 0;
    }

    private final int getScreenWidth() {
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }

    private final int getVelvoExpandImageResource() {
        return isSelected() ? this.k ? R.drawable.icon_velvo_preview_shrink_dark : R.drawable.icon_velvo_preview_shrink : this.k ? R.drawable.icon_velvo_preview_expand_dark : R.drawable.icon_velvo_preview_expand;
    }

    public static final void h(VelvoPreviewView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z = this$0.getMiddle() < ((float) ((this$0.getScreenWidth() / 2) + 10));
        this$0.j = !z;
        float height = 0.0f;
        this$0.setPivotX(z ? 0.0f : this$0.getWidth());
        this$0.setX(z ? this$0.b(16) : (this$0.getScreenWidth() - this$0.getWidth()) - this$0.b(16));
        this$0.setSelected(!this$0.isSelected());
        if (this$0.isSelected()) {
            float y = this$0.getY() + (this$0.getHeight() * 2);
            int i = this$0.h;
            boolean z2 = y > ((float) i);
            if (i != 0 && z2) {
                height = this$0.getHeight();
            }
            this$0.setPivotY(height);
        } else {
            this$0.j = false;
        }
        this$0.a.d.setImageResource(this$0.getVelvoExpandImageResource());
        this$0.animate().scaleX(this$0.isSelected() ? 2.0f : 1.0f).scaleY(this$0.isSelected() ? 2.0f : 1.0f).setDuration(200L).start();
        float f = this$0.isSelected() ? 0.68f : 1.0f;
        float f2 = this$0.isSelected() ? 0.85f : 1.0f;
        this$0.a.e.animate().scaleX(f).scaleY(f).setDuration(200L).start();
        this$0.a.d.animate().scaleX(f).scaleY(f).setDuration(200L).start();
        this$0.a.f.animate().scaleX(f2).scaleY(f2).setDuration(200L).start();
    }

    public static final void q(VelvoPreviewView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m = this$0.getX();
        this$0.n = this$0.getY();
        this$0.o = this$0.getWidth();
        this$0.p = this$0.getHeight();
        this$0.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).start();
    }

    public final void a(@NotNull a onPreviewHiddenListener, @Nullable String str) {
        Intrinsics.checkNotNullParameter(onPreviewHiddenListener, "onPreviewHiddenListener");
        if (str == null) {
            return;
        }
        this.l.put(str, onPreviewHiddenListener);
    }

    public final int b(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void c() {
        if (this.q) {
            setPivotX(getWidth() / 2.0f);
            setPivotY(getHeight() / 2.0f);
            animate().scaleX(0.0f).scaleY(0.0f).setDuration(200L).start();
            animate().alpha(0.0f).setDuration(200L).start();
            postDelayed(new Runnable() { // from class: dc.ht3
                @Override // java.lang.Runnable
                public final void run() {
                    VelvoPreviewView.d(this.a);
                }
            }, 350L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev) {
        super.dispatchTouchEvent(ev);
        return true;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.VelvoPreviewView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…yleable.VelvoPreviewView)");
        this.b = typedArrayObtainStyledAttributes.getBoolean(0, true);
        this.c = typedArrayObtainStyledAttributes.getBoolean(1, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void f() {
        this.a.e.setOnClickListener(new View.OnClickListener() { // from class: dc.jt3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VelvoPreviewView.g(this.a, view);
            }
        });
        this.a.d.setOnClickListener(new View.OnClickListener() { // from class: dc.it3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VelvoPreviewView.h(this.a, view);
            }
        });
    }

    public final double m(double d, double d2, double d3, double d4, double d5) {
        return (((d - d2) * (d5 - d4)) / (d3 - d2)) + d4;
    }

    public final void n() {
        setPivotX(getWidth() / 2.0f);
        setPivotY(getHeight() / 2.0f);
        setVisibility(8);
        setSelected(false);
        this.j = false;
        setX(this.m);
        setY(this.n);
        setPivotX(getWidth() / 2.0f);
        setPivotY(getHeight() / 2.0f);
        setScaleX(1.0f);
        setScaleY(1.0f);
        setAlpha(1.0f);
        getLayoutParams().width = (int) this.o;
        getLayoutParams().height = (int) this.p;
        this.a.e.setScaleX(1.0f);
        this.a.e.setScaleY(1.0f);
        this.a.d.setScaleX(1.0f);
        this.a.d.setScaleY(1.0f);
        this.a.f.setScaleX(1.0f);
        this.a.f.setScaleY(1.0f);
        this.a.d.setImageResource(getVelvoExpandImageResource());
    }

    public final void o() {
        this.k = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        for (String str : this.l.keySet()) {
            if (!(str.length() == 0) && !Intrinsics.areEqual(str, "CHAT_VIDEO_CONTROL") && !Intrinsics.areEqual(str, "CHAT_VOICE_CONTROL")) {
                this.l.remove(str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.velvo.VelvoPreviewView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        this.q = true;
        setVisibility(0);
        setScaleX(0.2f);
        setScaleY(0.2f);
        setAlpha(0.0f);
        post(new Runnable() { // from class: dc.gt3
            @Override // java.lang.Runnable
            public final void run() {
                VelvoPreviewView.q(this.a);
            }
        });
    }

    public final void setDarkMode() {
        this.k = true;
        this.a.b.setBackgroundResource(R.drawable.bg_velvo_preview_dark);
        this.a.f.setTextColor(Color.parseColor("#A6FFFFFF"));
        this.a.e.setBackgroundResource(R.drawable.bg_velvo_preview_icon_dark);
        this.a.e.setImageResource(R.drawable.icon_velvo_preview_hidden_dark);
        this.a.d.setBackgroundResource(R.drawable.bg_velvo_preview_icon_dark);
        this.a.d.setImageResource(R.drawable.icon_velvo_preview_expand_dark);
    }

    public final void setPointY(int pointY) {
        double dM = m(pointY, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 100.0d, b(6), b(26));
        if (getVisibility() == 8) {
            this.a.c.setY((float) dM);
        } else {
            this.a.c.animate().y((float) dM).setDuration(100L).start();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VelvoPreviewView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.l = new ConcurrentHashMap();
        ViewVelvoPreviewBinding viewVelvoPreviewBindingC = ViewVelvoPreviewBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(viewVelvoPreviewBindingC, "inflate(LayoutInflater.from(context), this, true)");
        this.a = viewVelvoPreviewBindingC;
        e(context, attributeSet);
        f();
    }
}
