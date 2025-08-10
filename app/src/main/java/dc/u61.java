package dc;

import android.R;
import android.view.View;
import android.widget.TextView;

/* compiled from: CustomToast.java */
/* loaded from: classes2.dex */
public abstract class u61 implements i71 {
    public View a;
    public TextView b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public float h;
    public int i = R.style.Animation.Toast;
    public int j = 2000;
    public int k = 3500;

    @Override // dc.i71
    public /* synthetic */ TextView a(View view) {
        return h71.a(this, view);
    }

    public int b() {
        return this.i;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public float e() {
        return this.g;
    }

    public int f() {
        return this.k;
    }

    public int g() {
        return this.j;
    }

    public float h() {
        return this.h;
    }

    public View i() {
        return this.a;
    }

    public int j() {
        return this.e;
    }

    public int k() {
        return this.f;
    }

    @Override // dc.i71
    public void setDuration(int i) {
        this.d = i;
    }

    @Override // dc.i71
    public void setGravity(int i, int i2, int i3) {
        this.c = i;
        this.e = i2;
        this.f = i3;
    }

    @Override // dc.i71
    public void setMargin(float f, float f2) {
        this.g = f;
        this.h = f2;
    }

    @Override // dc.i71
    public void setText(CharSequence charSequence) {
        TextView textView = this.b;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // dc.i71
    public void setView(View view) {
        this.a = view;
        if (view == null) {
            this.b = null;
        } else {
            this.b = a(view);
        }
    }
}
