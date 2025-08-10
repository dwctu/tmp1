package com.component.dxdatabase.lib.manager;

import android.database.SQLException;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import dc.bx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: DbCommonMigration.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/component/dxdatabase/lib/manager/DbCommonMigration;", "", "()V", "Migration_1_2", "Landroidx/room/migration/Migration;", "getBuild", "Lcom/component/dxdatabase/lib/manager/DbCommon;", "dbPath", "", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class DbCommonMigration {

    @NotNull
    public static final Migration a = new Migration() { // from class: com.component.dxdatabase.lib.manager.DbCommonMigration$Migration_1_2$1
        @Override // androidx.room.migration.Migration
        public void migrate(@NotNull SupportSQLiteDatabase database) throws SQLException {
            Intrinsics.checkNotNullParameter(database, "database");
            database.execSQL("ALTER TABLE BILogDbEntity ADD COLUMN openId TEXT");
            database.execSQL("ALTER TABLE BILogDbEntity ADD COLUMN appVersion TEXT");
        }
    };

    /* compiled from: DbCommonMigration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/room/RoomDatabase$Builder;", "Lcom/component/dxdatabase/lib/manager/DbCommon;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<RoomDatabase.Builder<DbCommon>, Unit> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final void a(@NotNull RoomDatabase.Builder<DbCommon> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            it.addMigrations(DbCommonMigration.a);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RoomDatabase.Builder<DbCommon> builder) {
            a(builder);
            return Unit.INSTANCE;
        }
    }

    @JvmStatic
    @NotNull
    public static final DbCommon b(@NotNull String dbPath) {
        Intrinsics.checkNotNullParameter(dbPath, "dbPath");
        return (DbCommon) bx.d(dbPath, DbCommon.class, a.a);
    }
}
