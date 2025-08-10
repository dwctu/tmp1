package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class MultiCallback implements Drawable.Callback {
    private final CopyOnWriteArrayList<CallbackWeakReference> mCallbacks;
    private final boolean mUseViewInvalidate;

    public static final class CallbackWeakReference extends WeakReference<Drawable.Callback> {
        public CallbackWeakReference(Drawable.Callback callback) {
            super(callback);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && CallbackWeakReference.class == obj.getClass() && get() == ((CallbackWeakReference) obj).get();
        }

        public int hashCode() {
            Drawable.Callback callback = get();
            if (callback != null) {
                return callback.hashCode();
            }
            return 0;
        }
    }

    public MultiCallback() {
        this(false);
    }

    public void addView(Drawable.Callback callback) {
        for (int i = 0; i < this.mCallbacks.size(); i++) {
            CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i);
            if (callbackWeakReference.get() == null) {
                this.mCallbacks.remove(callbackWeakReference);
            }
        }
        this.mCallbacks.addIfAbsent(new CallbackWeakReference(callback));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        for (int i = 0; i < this.mCallbacks.size(); i++) {
            CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i);
            Drawable.Callback callback = callbackWeakReference.get();
            if (callback == null) {
                this.mCallbacks.remove(callbackWeakReference);
            } else if (this.mUseViewInvalidate && (callback instanceof View)) {
                ((View) callback).invalidate();
            } else {
                callback.invalidateDrawable(drawable);
            }
        }
    }

    public void removeView(Drawable.Callback callback) {
        for (int i = 0; i < this.mCallbacks.size(); i++) {
            CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i);
            Drawable.Callback callback2 = callbackWeakReference.get();
            if (callback2 == null || callback2 == callback) {
                this.mCallbacks.remove(callbackWeakReference);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        for (int i = 0; i < this.mCallbacks.size(); i++) {
            CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i);
            Drawable.Callback callback = callbackWeakReference.get();
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            } else {
                this.mCallbacks.remove(callbackWeakReference);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        for (int i = 0; i < this.mCallbacks.size(); i++) {
            CallbackWeakReference callbackWeakReference = this.mCallbacks.get(i);
            Drawable.Callback callback = callbackWeakReference.get();
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            } else {
                this.mCallbacks.remove(callbackWeakReference);
            }
        }
    }

    public MultiCallback(boolean z) {
        this.mCallbacks = new CopyOnWriteArrayList<>();
        this.mUseViewInvalidate = z;
    }
}
