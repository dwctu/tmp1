package dc;

import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import java.util.concurrent.Executor;

/* compiled from: Future.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class z91 {
    public static Future $default$executorThread(final Future _this, Executor executor) {
        final SimpleFuture simpleFuture = new SimpleFuture();
        executor.execute(new Runnable() { // from class: dc.j91
            @Override // java.lang.Runnable
            public final void run() {
                simpleFuture.setComplete(_this);
            }
        });
        return simpleFuture;
    }
}
