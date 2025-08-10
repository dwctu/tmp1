package rx.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public class LooperScheduler extends Scheduler {
    private final Handler handler;

    public static final class ScheduledAction implements Runnable, Subscription {
        private final Action0 action;
        private final Handler handler;
        private volatile boolean unsubscribed;

        public ScheduledAction(Action0 action0, Handler handler) {
            this.action = action0;
            this.handler = handler;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.unsubscribed;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.action.call();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = th instanceof OnErrorNotImplementedException ? new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th) : new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                RxJavaPlugins.getInstance().getErrorHandler().handleError(illegalStateException);
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.unsubscribed = true;
            this.handler.removeCallbacks(this);
        }
    }

    public LooperScheduler(Looper looper) {
        this.handler = new Handler(looper);
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new HandlerWorker(this.handler);
    }

    public LooperScheduler(Handler handler) {
        this.handler = handler;
    }

    public static class HandlerWorker extends Scheduler.Worker {
        private final Handler handler;
        private final RxAndroidSchedulersHook hook = RxAndroidPlugins.getInstance().getSchedulersHook();
        private volatile boolean unsubscribed;

        public HandlerWorker(Handler handler) {
            this.handler = handler;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.unsubscribed;
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.unsubscribed) {
                return Subscriptions.unsubscribed();
            }
            ScheduledAction scheduledAction = new ScheduledAction(this.hook.onSchedule(action0), this.handler);
            Message messageObtain = Message.obtain(this.handler, scheduledAction);
            messageObtain.obj = this;
            this.handler.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.unsubscribed) {
                return scheduledAction;
            }
            this.handler.removeCallbacks(scheduledAction);
            return Subscriptions.unsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.unsubscribed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            return schedule(action0, 0L, TimeUnit.MILLISECONDS);
        }
    }
}
