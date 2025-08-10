package com.component.dxdatabase.lib.manager;

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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import dc.ax;
import dc.xw;
import dc.yw;
import dc.zw;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* loaded from: classes.dex */
public final class DbCommon_Impl extends DbCommon {
    public volatile zw d;

    public class a extends RoomOpenHelper.Delegate {
        public a(int i) {
            super(i);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AccountDbEntity` (`accountCode` TEXT, `accountCodeMd5` TEXT, `id` TEXT NOT NULL, `created` INTEGER, `updated` INTEGER, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `BILogDbEntity` (`logNo` TEXT, `content` TEXT, `pageName` TEXT, `properties` TEXT, `timeStamp` INTEGER NOT NULL, `openId` TEXT, `appVersion` TEXT, `accountCode` TEXT, `byteSize` INTEGER, `failCount` INTEGER, `nextUploadTime` INTEGER, `id` TEXT NOT NULL, `created` INTEGER, `updated` INTEGER, PRIMARY KEY(`id`))");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c6ee69e5b639572327f0d9e02dbd7cf8')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) throws SQLException {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AccountDbEntity`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `BILogDbEntity`");
            if (DbCommon_Impl.this.mCallbacks != null) {
                int size = DbCommon_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) DbCommon_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (DbCommon_Impl.this.mCallbacks != null) {
                int size = DbCommon_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) DbCommon_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            DbCommon_Impl.this.mDatabase = supportSQLiteDatabase;
            DbCommon_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (DbCommon_Impl.this.mCallbacks != null) {
                int size = DbCommon_Impl.this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    ((RoomDatabase.Callback) DbCommon_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
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
            HashMap map = new HashMap(5);
            map.put("accountCode", new TableInfo.Column("accountCode", "TEXT", false, 0, null, 1));
            map.put("accountCodeMd5", new TableInfo.Column("accountCodeMd5", "TEXT", false, 0, null, 1));
            map.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "TEXT", true, 1, null, 1));
            map.put("created", new TableInfo.Column("created", "INTEGER", false, 0, null, 1));
            map.put("updated", new TableInfo.Column("updated", "INTEGER", false, 0, null, 1));
            TableInfo tableInfo = new TableInfo("AccountDbEntity", map, new HashSet(0), new HashSet(0));
            TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "AccountDbEntity");
            if (!tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(false, "AccountDbEntity(com.component.dxdatabase.lib.bean.AccountDbEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
            HashMap map2 = new HashMap(14);
            map2.put("logNo", new TableInfo.Column("logNo", "TEXT", false, 0, null, 1));
            map2.put(FirebaseAnalytics.Param.CONTENT, new TableInfo.Column(FirebaseAnalytics.Param.CONTENT, "TEXT", false, 0, null, 1));
            map2.put("pageName", new TableInfo.Column("pageName", "TEXT", false, 0, null, 1));
            map2.put(JivePropertiesExtension.ELEMENT, new TableInfo.Column(JivePropertiesExtension.ELEMENT, "TEXT", false, 0, null, 1));
            map2.put("timeStamp", new TableInfo.Column("timeStamp", "INTEGER", true, 0, null, 1));
            map2.put("openId", new TableInfo.Column("openId", "TEXT", false, 0, null, 1));
            map2.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, new TableInfo.Column(RemoteConfigConstants.RequestFieldKey.APP_VERSION, "TEXT", false, 0, null, 1));
            map2.put("accountCode", new TableInfo.Column("accountCode", "TEXT", false, 0, null, 1));
            map2.put("byteSize", new TableInfo.Column("byteSize", "INTEGER", false, 0, null, 1));
            map2.put("failCount", new TableInfo.Column("failCount", "INTEGER", false, 0, null, 1));
            map2.put("nextUploadTime", new TableInfo.Column("nextUploadTime", "INTEGER", false, 0, null, 1));
            map2.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "TEXT", true, 1, null, 1));
            map2.put("created", new TableInfo.Column("created", "INTEGER", false, 0, null, 1));
            map2.put("updated", new TableInfo.Column("updated", "INTEGER", false, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("BILogDbEntity", map2, new HashSet(0), new HashSet(0));
            TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "BILogDbEntity");
            if (tableInfo3.equals(tableInfo4)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "BILogDbEntity(com.component.dxdatabase.lib.bean.BILogDbEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() throws SQLException {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `AccountDbEntity`");
            writableDatabase.execSQL("DELETE FROM `BILogDbEntity`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "AccountDbEntity", "BILogDbEntity");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(2), "c6ee69e5b639572327f0d9e02dbd7cf8", "32d05beea65391fcd269c580db2afa1b")).build());
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
        map.put(xw.class, yw.M());
        map.put(zw.class, ax.W());
        return map;
    }

    @Override // com.component.dxdatabase.lib.manager.DbCommon
    public zw i() {
        zw zwVar;
        if (this.d != null) {
            return this.d;
        }
        synchronized (this) {
            if (this.d == null) {
                this.d = new ax(this);
            }
            zwVar = this.d;
        }
        return zwVar;
    }
}
