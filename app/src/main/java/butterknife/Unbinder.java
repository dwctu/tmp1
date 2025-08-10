package butterknife;

import androidx.annotation.UiThread;

/* loaded from: classes.dex */
public interface Unbinder {
    public static final Unbinder EMPTY = new Unbinder() { // from class: dc.z6
        @Override // butterknife.Unbinder
        public final void unbind() {
            a7.a();
        }
    };

    @UiThread
    void unbind();
}
