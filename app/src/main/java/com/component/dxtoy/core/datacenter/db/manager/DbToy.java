package com.component.dxtoy.core.datacenter.db.manager;

import androidx.room.Database;
import androidx.room.TypeConverters;
import com.component.dxdatabase.lib.base.DbBaseDatabase;
import com.component.dxtoy.core.datacenter.db.bean.ToyDbEntity;
import dc.bx;
import dc.jb0;
import dc.lb0;
import dc.ww;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DbToy.kt */
@TypeConverters({ww.class})
@Database(entities = {ToyDbEntity.class}, exportSchema = true, version = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/component/dxtoy/core/datacenter/db/manager/DbToy;", "Lcom/component/dxdatabase/lib/base/DbBaseDatabase;", "()V", "toyDaoBridge", "Lcom/component/dxtoy/core/datacenter/db/ToyDaoBridge;", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class DbToy extends DbBaseDatabase {

    @NotNull
    public static final a a = new a(null);

    @Nullable
    public static volatile DbToy b;

    @Nullable
    public static volatile String c;

    /* compiled from: DbToy.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/core/datacenter/db/manager/DbToy$Companion;", "", "()V", "DB_NAME", "", "dbPath", "toyDb", "Lcom/component/dxtoy/core/datacenter/db/manager/DbToy;", "getDb", "getDbPath", "getInstance", "path", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DbToy a() {
            return c(b());
        }

        public final String b() {
            return bx.a.a("dxToy.db");
        }

        public final synchronized DbToy c(String str) {
            DbToy dbToy;
            boolean z = true;
            if (DbToy.c != null && StringsKt__StringsJVMKt.equals$default(DbToy.c, str, false, 2, null)) {
                DbToy dbToy2 = DbToy.b;
                if ((dbToy2 == null || dbToy2.isOpen()) ? false : true) {
                }
                dbToy = DbToy.b;
                Intrinsics.checkNotNull(dbToy);
            }
            synchronized (DbToy.class) {
                if (DbToy.c != null && StringsKt__StringsJVMKt.equals$default(DbToy.c, str, false, 2, null)) {
                    DbToy dbToy3 = DbToy.b;
                    if (dbToy3 == null || dbToy3.isOpen()) {
                        z = false;
                    }
                    if (z) {
                    }
                    Unit unit = Unit.INSTANCE;
                }
                a aVar = DbToy.a;
                DbToy.b = lb0.a(str);
                DbToy.c = str;
                Unit unit2 = Unit.INSTANCE;
            }
            dbToy = DbToy.b;
            Intrinsics.checkNotNull(dbToy);
            return dbToy;
        }
    }

    @NotNull
    public abstract jb0 i();
}
