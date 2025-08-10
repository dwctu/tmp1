package dc;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;

/* compiled from: BaseTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class uo<Z> implements cp<Z> {
    public mo a;

    @Override // dc.cp
    public void a(@Nullable Drawable drawable) {
    }

    @Override // dc.cp
    public void e(@Nullable Drawable drawable) {
    }

    @Override // dc.cp
    public void g(@Nullable mo moVar) {
        this.a = moVar;
    }

    @Override // dc.cp
    @Nullable
    public mo getRequest() {
        return this.a;
    }

    @Override // dc.cp
    public void h(@Nullable Drawable drawable) {
    }

    @Override // dc.qn
    public void onDestroy() {
    }

    @Override // dc.qn
    public void onStart() {
    }

    @Override // dc.qn
    public void onStop() {
    }
}
