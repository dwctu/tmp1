package dc;

import android.view.View;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: IControlComponent.java */
/* loaded from: classes5.dex */
public interface nj4 {
    void a(int i);

    void b(int i);

    void d(boolean z, Animation animation);

    void e(@NonNull mj4 mj4Var);

    @Nullable
    View getView();

    void i(boolean z);

    void setProgress(int i, int i2);
}
