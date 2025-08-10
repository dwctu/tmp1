package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import dc.ox3;

/* loaded from: classes.dex */
public final class SchemaManager_Factory implements Factory<SchemaManager> {
    private final ox3<Context> contextProvider;
    private final ox3<String> dbNameProvider;
    private final ox3<Integer> schemaVersionProvider;

    public SchemaManager_Factory(ox3<Context> ox3Var, ox3<String> ox3Var2, ox3<Integer> ox3Var3) {
        this.contextProvider = ox3Var;
        this.dbNameProvider = ox3Var2;
        this.schemaVersionProvider = ox3Var3;
    }

    public static SchemaManager_Factory create(ox3<Context> ox3Var, ox3<String> ox3Var2, ox3<Integer> ox3Var3) {
        return new SchemaManager_Factory(ox3Var, ox3Var2, ox3Var3);
    }

    public static SchemaManager newInstance(Context context, String str, int i) {
        return new SchemaManager(context, str, i);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public SchemaManager get() {
        return newInstance(this.contextProvider.get(), this.dbNameProvider.get(), this.schemaVersionProvider.get().intValue());
    }
}
