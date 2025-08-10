package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import dc.ox3;

/* loaded from: classes.dex */
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {
    private final ox3<Clock> eventClockProvider;
    private final ox3<WorkInitializer> initializerProvider;
    private final ox3<Scheduler> schedulerProvider;
    private final ox3<Uploader> uploaderProvider;
    private final ox3<Clock> uptimeClockProvider;

    public TransportRuntime_Factory(ox3<Clock> ox3Var, ox3<Clock> ox3Var2, ox3<Scheduler> ox3Var3, ox3<Uploader> ox3Var4, ox3<WorkInitializer> ox3Var5) {
        this.eventClockProvider = ox3Var;
        this.uptimeClockProvider = ox3Var2;
        this.schedulerProvider = ox3Var3;
        this.uploaderProvider = ox3Var4;
        this.initializerProvider = ox3Var5;
    }

    public static TransportRuntime_Factory create(ox3<Clock> ox3Var, ox3<Clock> ox3Var2, ox3<Scheduler> ox3Var3, ox3<Uploader> ox3Var4, ox3<WorkInitializer> ox3Var5) {
        return new TransportRuntime_Factory(ox3Var, ox3Var2, ox3Var3, ox3Var4, ox3Var5);
    }

    public static TransportRuntime newInstance(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public TransportRuntime get() {
        return newInstance(this.eventClockProvider.get(), this.uptimeClockProvider.get(), this.schedulerProvider.get(), this.uploaderProvider.get(), this.initializerProvider.get());
    }
}
