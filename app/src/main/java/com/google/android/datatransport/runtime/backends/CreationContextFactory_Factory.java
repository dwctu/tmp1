package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import dc.ox3;

/* loaded from: classes.dex */
public final class CreationContextFactory_Factory implements Factory<CreationContextFactory> {
    private final ox3<Context> applicationContextProvider;
    private final ox3<Clock> monotonicClockProvider;
    private final ox3<Clock> wallClockProvider;

    public CreationContextFactory_Factory(ox3<Context> ox3Var, ox3<Clock> ox3Var2, ox3<Clock> ox3Var3) {
        this.applicationContextProvider = ox3Var;
        this.wallClockProvider = ox3Var2;
        this.monotonicClockProvider = ox3Var3;
    }

    public static CreationContextFactory_Factory create(ox3<Context> ox3Var, ox3<Clock> ox3Var2, ox3<Clock> ox3Var3) {
        return new CreationContextFactory_Factory(ox3Var, ox3Var2, ox3Var3);
    }

    public static CreationContextFactory newInstance(Context context, Clock clock, Clock clock2) {
        return new CreationContextFactory(context, clock, clock2);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public CreationContextFactory get() {
        return newInstance(this.applicationContextProvider.get(), this.wallClockProvider.get(), this.monotonicClockProvider.get());
    }
}
