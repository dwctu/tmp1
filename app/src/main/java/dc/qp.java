package dc;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: Executors.java */
/* loaded from: classes.dex */
public final class qp {
    public static final Executor a = new a();
    public static final Executor b = new b();

    /* compiled from: Executors.java */
    public class a implements Executor {
        public final Handler a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.a.post(runnable);
        }
    }

    /* compiled from: Executors.java */
    public class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return b;
    }

    public static Executor b() {
        return a;
    }
}
