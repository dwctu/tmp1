package dc;

import android.view.View;
import android.widget.TextView;

/* compiled from: IToast.java */
/* loaded from: classes2.dex */
public interface i71 {
    TextView a(View view);

    void cancel();

    void setDuration(int i);

    void setGravity(int i, int i2, int i3);

    void setMargin(float f, float f2);

    void setText(CharSequence charSequence);

    void setView(View view);

    void show();
}
