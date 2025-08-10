package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes5.dex */
public class AsyncExecutor {
    private final EventBus eventBus;
    private final Constructor<?> failureEventConstructor;
    private final Object scope;
    private final Executor threadPool;

    public static class Builder {
        private EventBus eventBus;
        private Class<?> failureEventType;
        private Executor threadPool;

        public AsyncExecutor build() {
            return buildForScope(null);
        }

        public AsyncExecutor buildForScope(Object obj) {
            if (this.eventBus == null) {
                this.eventBus = EventBus.getDefault();
            }
            if (this.threadPool == null) {
                this.threadPool = Executors.newCachedThreadPool();
            }
            if (this.failureEventType == null) {
                this.failureEventType = ThrowableFailureEvent.class;
            }
            return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, obj);
        }

        public Builder eventBus(EventBus eventBus) {
            this.eventBus = eventBus;
            return this;
        }

        public Builder failureEventType(Class<?> cls) {
            this.failureEventType = cls;
            return this;
        }

        public Builder threadPool(Executor executor) {
            this.threadPool = executor;
            return this;
        }

        private Builder() {
        }
    }

    public interface RunnableEx {
        void run() throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(RunnableEx runnableEx) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            runnableEx.run();
        } catch (Exception e) {
            try {
                Object objNewInstance = this.failureEventConstructor.newInstance(e);
                if (objNewInstance instanceof HasExecutionScope) {
                    ((HasExecutionScope) objNewInstance).setExecutionScope(this.scope);
                }
                this.eventBus.post(objNewInstance);
            } catch (Exception e2) {
                this.eventBus.getLogger().log(Level.SEVERE, "Original exception:", e);
                throw new RuntimeException("Could not create failure event", e2);
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static AsyncExecutor create() {
        return new Builder().build();
    }

    public void execute(final RunnableEx runnableEx) {
        this.threadPool.execute(new Runnable() { // from class: dc.ne4
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                this.a.b(runnableEx);
            }
        });
    }

    private AsyncExecutor(Executor executor, EventBus eventBus, Class<?> cls, Object obj) {
        this.threadPool = executor;
        this.eventBus = eventBus;
        this.scope = obj;
        try {
            this.failureEventConstructor = cls.getConstructor(Throwable.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e);
        }
    }
}
