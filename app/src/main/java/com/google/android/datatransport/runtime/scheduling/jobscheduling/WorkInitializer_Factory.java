package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import dc.ox3;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class WorkInitializer_Factory implements Factory<WorkInitializer> {
    private final ox3<Executor> executorProvider;
    private final ox3<SynchronizationGuard> guardProvider;
    private final ox3<WorkScheduler> schedulerProvider;
    private final ox3<EventStore> storeProvider;

    public WorkInitializer_Factory(ox3<Executor> ox3Var, ox3<EventStore> ox3Var2, ox3<WorkScheduler> ox3Var3, ox3<SynchronizationGuard> ox3Var4) {
        this.executorProvider = ox3Var;
        this.storeProvider = ox3Var2;
        this.schedulerProvider = ox3Var3;
        this.guardProvider = ox3Var4;
    }

    public static WorkInitializer_Factory create(ox3<Executor> ox3Var, ox3<EventStore> ox3Var2, ox3<WorkScheduler> ox3Var3, ox3<SynchronizationGuard> ox3Var4) {
        return new WorkInitializer_Factory(ox3Var, ox3Var2, ox3Var3, ox3Var4);
    }

    public static WorkInitializer newInstance(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public WorkInitializer get() {
        return newInstance(this.executorProvider.get(), this.storeProvider.get(), this.schedulerProvider.get(), this.guardProvider.get());
    }
}
