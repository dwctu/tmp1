package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import dc.ox3;

/* loaded from: classes.dex */
public final class MetadataBackendRegistry_Factory implements Factory<MetadataBackendRegistry> {
    private final ox3<Context> applicationContextProvider;
    private final ox3<CreationContextFactory> creationContextFactoryProvider;

    public MetadataBackendRegistry_Factory(ox3<Context> ox3Var, ox3<CreationContextFactory> ox3Var2) {
        this.applicationContextProvider = ox3Var;
        this.creationContextFactoryProvider = ox3Var2;
    }

    public static MetadataBackendRegistry_Factory create(ox3<Context> ox3Var, ox3<CreationContextFactory> ox3Var2) {
        return new MetadataBackendRegistry_Factory(ox3Var, ox3Var2);
    }

    public static MetadataBackendRegistry newInstance(Context context, Object obj) {
        return new MetadataBackendRegistry(context, (CreationContextFactory) obj);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public MetadataBackendRegistry get() {
        return newInstance(this.applicationContextProvider.get(), this.creationContextFactoryProvider.get());
    }
}
