package rx.android.schedulers;

import android.os.Handler;
import java.util.Objects;
import rx.Scheduler;

@Deprecated
/* loaded from: classes5.dex */
public final class HandlerScheduler extends LooperScheduler {
    private HandlerScheduler(Handler handler) {
        super(handler);
    }

    @Deprecated
    public static HandlerScheduler from(Handler handler) {
        Objects.requireNonNull(handler, "handler == null");
        return new HandlerScheduler(handler);
    }

    @Override // rx.android.schedulers.LooperScheduler, rx.Scheduler
    public /* bridge */ /* synthetic */ Scheduler.Worker createWorker() {
        return super.createWorker();
    }
}
