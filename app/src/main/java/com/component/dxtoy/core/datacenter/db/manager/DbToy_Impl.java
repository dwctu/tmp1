package com.component.dxtoy.core.datacenter.db.manager;

import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.jb0;
import dc.kb0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class DbToy_Impl extends DbToy {
    public volatile jb0 d;

    public class a extends RoomOpenHelper.Delegate {
        public a(int i) {
            super(i);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ToyDbEntity` (`uuid` TEXT, `version` INTEGER NOT NULL, `showName` TEXT, `type` TEXT, `symbol` TEXT, `isSelect` INTEGER NOT NULL, `mac` TEXT NOT NULL, `deviceName` TEXT, `deviceType` TEXT, `isVirtualToy` INTEGER NOT NULL, `defineRename` TEXT, `isLedOpen` INTEGER NOT NULL, `ledColor` INTEGER NOT NULL, `rmId` TEXT, `updateTime` INTEGER NOT NULL, `formApp` TEXT, `isUIInMyToyList` INTEGER NOT NULL, `otherAppConnectState` INTEGER NOT NULL, `id` TEXT NOT NULL, `created` INTEGER, `updated` INTEGER, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e552b56332441cbb734cfdfd94feac3e')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ToyDbEntity`");
            if (DbToy_Impl.this.mCallbacks != null) {
                int size = DbToy_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) DbToy_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (DbToy_Impl.this.mCallbacks != null) {
                int size = DbToy_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) DbToy_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            DbToy_Impl.this.mDatabase = supportSQLiteDatabase;
            DbToy_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (DbToy_Impl.this.mCallbacks != null) {
                int size = DbToy_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) DbToy_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap map = new HashMap(21);
            map.put("uuid", new TableInfo.Column("uuid", "TEXT", false, 0, null, 1));
            map.put("version", new TableInfo.Column("version", "INTEGER", true, 0, null, 1));
            map.put("showName", new TableInfo.Column("showName", "TEXT", false, 0, null, 1));
            map.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
            map.put("symbol", new TableInfo.Column("symbol", "TEXT", false, 0, null, 1));
            map.put("isSelect", new TableInfo.Column("isSelect", "INTEGER", true, 0, null, 1));
            map.put("mac", new TableInfo.Column("mac", "TEXT", true, 0, null, 1));
            map.put("deviceName", new TableInfo.Column("deviceName", "TEXT", false, 0, null, 1));
            map.put("deviceType", new TableInfo.Column("deviceType", "TEXT", false, 0, null, 1));
            map.put("isVirtualToy", new TableInfo.Column("isVirtualToy", "INTEGER", true, 0, null, 1));
            map.put("defineRename", new TableInfo.Column("defineRename", "TEXT", false, 0, null, 1));
            map.put("isLedOpen", new TableInfo.Column("isLedOpen", "INTEGER", true, 0, null, 1));
            map.put("ledColor", new TableInfo.Column("ledColor", "INTEGER", true, 0, null, 1));
            map.put("rmId", new TableInfo.Column("rmId", "TEXT", false, 0, null, 1));
            map.put("updateTime", new TableInfo.Column("updateTime", "INTEGER", true, 0, null, 1));
            map.put("formApp", new TableInfo.Column("formApp", "TEXT", false, 0, null, 1));
            map.put("isUIInMyToyList", new TableInfo.Column("isUIInMyToyList", "INTEGER", true, 0, null, 1));
            map.put("otherAppConnectState", new TableInfo.Column("otherAppConnectState", "INTEGER", true, 0, null, 1));
            map.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "TEXT", true, 1, null, 1));
            map.put("created", new TableInfo.Column("created", "INTEGER", false, 0, null, 1));
            map.put("updated", new TableInfo.Column("updated", "INTEGER", false, 0, null, 1));
            TableInfo tableInfo = new TableInfo("ToyDbEntity", map, new HashSet(0), new HashSet(0));
            TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "ToyDbEntity");
            if (tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "ToyDbEntity(com.component.dxtoy.core.datacenter.db.bean.ToyDbEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() throws SQLException {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `ToyDbEntity`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "ToyDbEntity");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(1), "e552b56332441cbb734cfdfd94feac3e", "6994e4017eb8a21223b330782f75cd71")).build());
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(jb0.class, kb0.U());
        return map;
    }

    @Override // com.component.dxtoy.core.datacenter.db.manager.DbToy
    public jb0 i() {
        jb0 jb0Var;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new kb0(this);
            }
            jb0Var = this.d;
        }
        return jb0Var;
    }
}
