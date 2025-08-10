package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import dc.ox3;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {
    private final ox3<BackendRegistry> backendRegistryProvider;
    private final ox3<EventStore> eventStoreProvider;
    private final ox3<Executor> executorProvider;
    private final ox3<SynchronizationGuard> guardProvider;
    private final ox3<WorkScheduler> workSchedulerProvider;

    public DefaultScheduler_Factory(ox3<Executor> ox3Var, ox3<BackendRegistry> ox3Var2, ox3<WorkScheduler> ox3Var3, ox3<EventStore> ox3Var4, ox3<SynchronizationGuard> ox3Var5) {
        this.executorProvider = ox3Var;
        this.backendRegistryProvider = ox3Var2;
        this.workSchedulerProvider = ox3Var3;
        this.eventStoreProvider = ox3Var4;
        this.guardProvider = ox3Var5;
    }

    public static DefaultScheduler_Factory create(ox3<Executor> ox3Var, ox3<BackendRegistry> ox3Var2, ox3<WorkScheduler> ox3Var3, ox3<EventStore> ox3Var4, ox3<SynchronizationGuard> ox3Var5) {
        return new DefaultScheduler_Factory(ox3Var, ox3Var2, ox3Var3, ox3Var4, ox3Var5);
    }

    public static DefaultScheduler newInstance(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public DefaultScheduler get() {
        return newInstance(this.executorProvider.get(), this.backendRegistryProvider.get(), this.workSchedulerProvider.get(), this.eventStoreProvider.get(), this.guardProvider.get());
    }
}
