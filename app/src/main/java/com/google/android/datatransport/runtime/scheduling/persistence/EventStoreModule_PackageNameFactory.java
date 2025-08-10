package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import dc.ox3;

/* loaded from: classes.dex */
public final class EventStoreModule_PackageNameFactory implements Factory<String> {
    private final ox3<Context> contextProvider;

    public EventStoreModule_PackageNameFactory(ox3<Context> ox3Var) {
        this.contextProvider = ox3Var;
    }

    public static EventStoreModule_PackageNameFactory create(ox3<Context> ox3Var) {
        return new EventStoreModule_PackageNameFactory(ox3Var);
    }

    public static String packageName(Context context) {
        return (String) Preconditions.checkNotNull(EventStoreModule.packageName(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public String get() {
        return packageName(this.contextProvider.get());
    }
}
