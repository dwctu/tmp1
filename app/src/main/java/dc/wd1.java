package dc;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: RefreshContent.java */
/* loaded from: classes3.dex */
public interface wd1 {
    void a(pe1 pe1Var);

    void b(MotionEvent motionEvent);

    void c(zd1 zd1Var, View view, View view2);

    void d(boolean z);

    ValueAnimator.AnimatorUpdateListener e(int i);

    @NonNull
    View f();

    boolean g();

    @NonNull
    View getView();

    void h(int i, int i2, int i3);

    boolean i();
}
