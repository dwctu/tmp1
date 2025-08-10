package com.component.dxdatabase.lib.manager;

import androidx.room.Database;
import androidx.room.TypeConverters;
import com.component.dxdatabase.lib.base.DbBaseDatabase;
import com.component.dxdatabase.lib.bean.AccountDbEntity;
import com.component.dxdatabase.lib.bean.BILogDbEntity;
import dc.bx;
import dc.ww;
import dc.zw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DbCommon.kt */
@TypeConverters({ww.class})
@Database(entities = {AccountDbEntity.class, BILogDbEntity.class}, exportSchema = true, version = 2)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/component/dxdatabase/lib/manager/DbCommon;", "Lcom/component/dxdatabase/lib/base/DbBaseDatabase;", "()V", "accountDaoBridge", "Lcom/component/dxdatabase/lib/dao/AccountDaoBridge;", "bilogDaoBridge", "Lcom/component/dxdatabase/lib/dao/BILogDaoBridge;", "Companion", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class DbCommon extends DbBaseDatabase {

    @NotNull
    public static final a a = new a(null);

    @Nullable
    public static volatile DbCommon b;

    @Nullable
    public static volatile String c;

    /* compiled from: DbCommon.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/component/dxdatabase/lib/manager/DbCommon$Companion;", "", "()V", "DB_NAME", "", "curPath", "mDb", "Lcom/component/dxdatabase/lib/manager/DbCommon;", "getDb", "getDbPath", "getInstance", "path", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DbCommon a() {
            return c(b());
        }

        public final String b() {
            return bx.a.a("dxDatabase.db");
        }

        public final synchronized DbCommon c(String str) {
            DbCommon dbCommon;
            boolean z = true;
            if (DbCommon.c != null && StringsKt__StringsJVMKt.equals$default(DbCommon.c, str, false, 2, null)) {
                DbCommon dbCommon2 = DbCommon.b;
                if ((dbCommon2 == null || dbCommon2.isOpen()) ? false : true) {
                }
                dbCommon = DbCommon.b;
                Intrinsics.checkNotNull(dbCommon);
            }
            synchronized (DbCommon.class) {
                if (DbCommon.c != null && StringsKt__StringsJVMKt.equals$default(DbCommon.c, str, false, 2, null)) {
                    DbCommon dbCommon3 = DbCommon.b;
                    if (dbCommon3 == null || dbCommon3.isOpen()) {
                        z = false;
                    }
                    if (z) {
                    }
                    Unit unit = Unit.INSTANCE;
                }
                a aVar = DbCommon.a;
                DbCommon.b = DbCommonMigration.b(str);
                DbCommon.c = str;
                Unit unit2 = Unit.INSTANCE;
            }
            dbCommon = DbCommon.b;
            Intrinsics.checkNotNull(dbCommon);
            return dbCommon;
        }
    }

    @NotNull
    public abstract zw i();
}
