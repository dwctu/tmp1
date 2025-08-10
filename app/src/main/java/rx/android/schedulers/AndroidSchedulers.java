package rx.android.schedulers;

import android.os.Looper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.annotations.Experimental;

/* loaded from: classes5.dex */
public final class AndroidSchedulers {
    private static final AtomicReference<AndroidSchedulers> INSTANCE = new AtomicReference<>();
    private final Scheduler mainThreadScheduler;

    private AndroidSchedulers() {
        Scheduler mainThreadScheduler = RxAndroidPlugins.getInstance().getSchedulersHook().getMainThreadScheduler();
        if (mainThreadScheduler != null) {
            this.mainThreadScheduler = mainThreadScheduler;
        } else {
            this.mainThreadScheduler = new LooperScheduler(Looper.getMainLooper());
        }
    }

    public static Scheduler from(Looper looper) {
        Objects.requireNonNull(looper, "looper == null");
        return new LooperScheduler(looper);
    }

    private static AndroidSchedulers getInstance() {
        AtomicReference<AndroidSchedulers> atomicReference;
        AndroidSchedulers androidSchedulers;
        do {
            atomicReference = INSTANCE;
            AndroidSchedulers androidSchedulers2 = atomicReference.get();
            if (androidSchedulers2 != null) {
                return androidSchedulers2;
            }
            androidSchedulers = new AndroidSchedulers();
        } while (!atomicReference.compareAndSet(null, androidSchedulers));
        return androidSchedulers;
    }

    public static Scheduler mainThread() {
        return getInstance().mainThreadScheduler;
    }

    @Experimental
    public static void reset() {
        INSTANCE.set(null);
    }
}
