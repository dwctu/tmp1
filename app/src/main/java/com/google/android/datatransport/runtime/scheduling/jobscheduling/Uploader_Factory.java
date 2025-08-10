package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import dc.ox3;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class Uploader_Factory implements Factory<Uploader> {
    private final ox3<BackendRegistry> backendRegistryProvider;
    private final ox3<ClientHealthMetricsStore> clientHealthMetricsStoreProvider;
    private final ox3<Clock> clockProvider;
    private final ox3<Context> contextProvider;
    private final ox3<EventStore> eventStoreProvider;
    private final ox3<Executor> executorProvider;
    private final ox3<SynchronizationGuard> guardProvider;
    private final ox3<Clock> uptimeClockProvider;
    private final ox3<WorkScheduler> workSchedulerProvider;

    public Uploader_Factory(ox3<Context> ox3Var, ox3<BackendRegistry> ox3Var2, ox3<EventStore> ox3Var3, ox3<WorkScheduler> ox3Var4, ox3<Executor> ox3Var5, ox3<SynchronizationGuard> ox3Var6, ox3<Clock> ox3Var7, ox3<Clock> ox3Var8, ox3<ClientHealthMetricsStore> ox3Var9) {
        this.contextProvider = ox3Var;
        this.backendRegistryProvider = ox3Var2;
        this.eventStoreProvider = ox3Var3;
        this.workSchedulerProvider = ox3Var4;
        this.executorProvider = ox3Var5;
        this.guardProvider = ox3Var6;
        this.clockProvider = ox3Var7;
        this.uptimeClockProvider = ox3Var8;
        this.clientHealthMetricsStoreProvider = ox3Var9;
    }

    public static Uploader_Factory create(ox3<Context> ox3Var, ox3<BackendRegistry> ox3Var2, ox3<EventStore> ox3Var3, ox3<WorkScheduler> ox3Var4, ox3<Executor> ox3Var5, ox3<SynchronizationGuard> ox3Var6, ox3<Clock> ox3Var7, ox3<Clock> ox3Var8, ox3<ClientHealthMetricsStore> ox3Var9) {
        return new Uploader_Factory(ox3Var, ox3Var2, ox3Var3, ox3Var4, ox3Var5, ox3Var6, ox3Var7, ox3Var8, ox3Var9);
    }

    public static Uploader newInstance(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public Uploader get() {
        return newInstance(this.contextProvider.get(), this.backendRegistryProvider.get(), this.eventStoreProvider.get(), this.workSchedulerProvider.get(), this.executorProvider.get(), this.guardProvider.get(), this.clockProvider.get(), this.uptimeClockProvider.get(), this.clientHealthMetricsStoreProvider.get());
    }
}
