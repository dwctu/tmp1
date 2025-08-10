package dc;

import android.view.View;

/* compiled from: OnClickListener.java */
/* loaded from: classes3.dex */
public final class zu1 implements View.OnClickListener {
    public final a a;
    public final int b;

    /* compiled from: OnClickListener.java */
    public interface a {
        void a(int i, View view);
    }

    public zu1(a aVar, int i) {
        this.a = aVar;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(this.b, view);
    }
}
