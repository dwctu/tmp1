package com.google.android.datatransport.runtime.scheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import dc.ox3;

/* loaded from: classes.dex */
public final class SchedulingModule_WorkSchedulerFactory implements Factory<WorkScheduler> {
    private final ox3<Clock> clockProvider;
    private final ox3<SchedulerConfig> configProvider;
    private final ox3<Context> contextProvider;
    private final ox3<EventStore> eventStoreProvider;

    public SchedulingModule_WorkSchedulerFactory(ox3<Context> ox3Var, ox3<EventStore> ox3Var2, ox3<SchedulerConfig> ox3Var3, ox3<Clock> ox3Var4) {
        this.contextProvider = ox3Var;
        this.eventStoreProvider = ox3Var2;
        this.configProvider = ox3Var3;
        this.clockProvider = ox3Var4;
    }

    public static SchedulingModule_WorkSchedulerFactory create(ox3<Context> ox3Var, ox3<EventStore> ox3Var2, ox3<SchedulerConfig> ox3Var3, ox3<Clock> ox3Var4) {
        return new SchedulingModule_WorkSchedulerFactory(ox3Var, ox3Var2, ox3Var3, ox3Var4);
    }

    public static WorkScheduler workScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler) Preconditions.checkNotNull(SchedulingModule.workScheduler(context, eventStore, schedulerConfig, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public WorkScheduler get() {
        return workScheduler(this.contextProvider.get(), this.eventStoreProvider.get(), this.configProvider.get(), this.clockProvider.get());
    }
}
