package butterknife.internal;

import android.view.View;
import butterknife.internal.DebouncingOnClickListener;

/* loaded from: classes.dex */
public abstract class DebouncingOnClickListener implements View.OnClickListener {
    private static final Runnable ENABLE_AGAIN = new Runnable() { // from class: dc.b7
        @Override // java.lang.Runnable
        public final void run() {
            DebouncingOnClickListener.enabled = true;
        }
    };
    public static boolean enabled = true;

    public abstract void doClick(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (enabled) {
            enabled = false;
            view.post(ENABLE_AGAIN);
            doClick(view);
        }
    }
}
