package dc;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: IRenderView.java */
/* loaded from: classes5.dex */
public interface ak4 {
    void a(@NonNull sj4 sj4Var);

    View getView();

    void release();

    void setScaleType(int i);

    void setVideoRotation(int i);

    void setVideoSize(int i, int i2);
}
