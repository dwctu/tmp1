package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import dc.ox3;

/* loaded from: classes.dex */
public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {
    private final ox3<Clock> clockProvider;
    private final ox3<EventStoreConfig> configProvider;
    private final ox3<String> packageNameProvider;
    private final ox3<SchemaManager> schemaManagerProvider;
    private final ox3<Clock> wallClockProvider;

    public SQLiteEventStore_Factory(ox3<Clock> ox3Var, ox3<Clock> ox3Var2, ox3<EventStoreConfig> ox3Var3, ox3<SchemaManager> ox3Var4, ox3<String> ox3Var5) {
        this.wallClockProvider = ox3Var;
        this.clockProvider = ox3Var2;
        this.configProvider = ox3Var3;
        this.schemaManagerProvider = ox3Var4;
        this.packageNameProvider = ox3Var5;
    }

    public static SQLiteEventStore_Factory create(ox3<Clock> ox3Var, ox3<Clock> ox3Var2, ox3<EventStoreConfig> ox3Var3, ox3<SchemaManager> ox3Var4, ox3<String> ox3Var5) {
        return new SQLiteEventStore_Factory(ox3Var, ox3Var2, ox3Var3, ox3Var4, ox3Var5);
    }

    public static SQLiteEventStore newInstance(Clock clock, Clock clock2, Object obj, Object obj2, Lazy<String> lazy) {
        return new SQLiteEventStore(clock, clock2, (EventStoreConfig) obj, (SchemaManager) obj2, lazy);
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public SQLiteEventStore get() {
        return newInstance(this.wallClockProvider.get(), this.clockProvider.get(), this.configProvider.get(), this.schemaManagerProvider.get(), DoubleCheck.lazy(this.packageNameProvider));
    }
}
