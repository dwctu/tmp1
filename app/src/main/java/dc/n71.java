package dc;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: BlackToastStyle.java */
/* loaded from: classes2.dex */
public class n71 implements m71<View> {
    @Override // dc.m71
    public /* synthetic */ float a() {
        return l71.b(this);
    }

    @Override // dc.m71
    public View b(Context context) {
        TextView textView = new TextView(context);
        textView.setId(R.id.message);
        textView.setGravity(j(context));
        textView.setTextColor(i(context));
        textView.setTextSize(0, k(context));
        int iH = h(context);
        int iM = m(context);
        int i = Build.VERSION.SDK_INT;
        if (i >= 16) {
            textView.setPaddingRelative(iH, iM, iH, iM);
        } else {
            textView.setPadding(iH, iM, iH, iM);
        }
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        Drawable drawableG = g(context);
        if (i >= 16) {
            textView.setBackground(drawableG);
        } else {
            textView.setBackgroundDrawable(drawableG);
        }
        if (i >= 21) {
            textView.setZ(l(context));
        }
        return textView;
    }

    @Override // dc.m71
    public /* synthetic */ float c() {
        return l71.c(this);
    }

    @Override // dc.m71
    public /* synthetic */ int d() {
        return l71.a(this);
    }

    @Override // dc.m71
    public /* synthetic */ int e() {
        return l71.d(this);
    }

    @Override // dc.m71
    public /* synthetic */ int f() {
        return l71.e(this);
    }

    public Drawable g(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1291845632);
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        return gradientDrawable;
    }

    public int h(Context context) {
        return (int) TypedValue.applyDimension(1, 24.0f, context.getResources().getDisplayMetrics());
    }

    public int i(Context context) {
        return -285212673;
    }

    public int j(Context context) {
        return 17;
    }

    public float k(Context context) {
        return TypedValue.applyDimension(2, 14.0f, context.getResources().getDisplayMetrics());
    }

    public float l(Context context) {
        return TypedValue.applyDimension(1, 3.0f, context.getResources().getDisplayMetrics());
    }

    public int m(Context context) {
        return (int) TypedValue.applyDimension(1, 16.0f, context.getResources().getDisplayMetrics());
    }
}
