package dc;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.component.dxdatabase.lib.bean.BILogDbEntity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* compiled from: BILogDaoBridge_Impl.java */
/* loaded from: classes.dex */
public final class ax extends zw {
    public final RoomDatabase f;
    public final EntityInsertionAdapter<BILogDbEntity> g;
    public final ww h = new ww();
    public final EntityDeletionOrUpdateAdapter<BILogDbEntity> i;

    /* compiled from: BILogDaoBridge_Impl.java */
    public class a extends EntityInsertionAdapter<BILogDbEntity> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, BILogDbEntity bILogDbEntity) {
            if (bILogDbEntity.getLogNo() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, bILogDbEntity.getLogNo());
            }
            if (bILogDbEntity.getContent() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, bILogDbEntity.getContent());
            }
            if (bILogDbEntity.getPageName() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, bILogDbEntity.getPageName());
            }
            if (bILogDbEntity.getProperties() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, bILogDbEntity.getProperties());
            }
            supportSQLiteStatement.bindLong(5, bILogDbEntity.getTimeStamp());
            if (bILogDbEntity.getOpenId() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, bILogDbEntity.getOpenId());
            }
            if (bILogDbEntity.getAppVersion() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, bILogDbEntity.getAppVersion());
            }
            if (bILogDbEntity.getAccountCode() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, bILogDbEntity.getAccountCode());
            }
            if (bILogDbEntity.getByteSize() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindLong(9, bILogDbEntity.getByteSize().intValue());
            }
            if (bILogDbEntity.getFailCount() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindLong(10, bILogDbEntity.getFailCount().intValue());
            }
            if (bILogDbEntity.getNextUploadTime() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindLong(11, bILogDbEntity.getNextUploadTime().longValue());
            }
            if (bILogDbEntity.getId() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, bILogDbEntity.getId());
            }
            Long lA = ax.this.h.a(bILogDbEntity.getCreated());
            if (lA == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindLong(13, lA.longValue());
            }
            Long lA2 = ax.this.h.a(bILogDbEntity.getUpdated());
            if (lA2 == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindLong(14, lA2.longValue());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `BILogDbEntity` (`logNo`,`content`,`pageName`,`properties`,`timeStamp`,`openId`,`appVersion`,`accountCode`,`byteSize`,`failCount`,`nextUploadTime`,`id`,`created`,`updated`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: BILogDaoBridge_Impl.java */
    public class b extends EntityDeletionOrUpdateAdapter<BILogDbEntity> {
        public b(ax axVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, BILogDbEntity bILogDbEntity) {
            if (bILogDbEntity.getId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, bILogDbEntity.getId());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `BILogDbEntity` WHERE `id` = ?";
        }
    }

    public ax(RoomDatabase roomDatabase) {
        this.f = roomDatabase;
        this.g = new a(roomDatabase);
        this.i = new b(this, roomDatabase);
    }

    public static List<Class<?>> W() {
        return Collections.emptyList();
    }

    public final BILogDbEntity T(Cursor cursor) {
        int i;
        ax axVar;
        Long lValueOf;
        int columnIndex = CursorUtil.getColumnIndex(cursor, "logNo");
        int columnIndex2 = CursorUtil.getColumnIndex(cursor, FirebaseAnalytics.Param.CONTENT);
        int columnIndex3 = CursorUtil.getColumnIndex(cursor, "pageName");
        int columnIndex4 = CursorUtil.getColumnIndex(cursor, JivePropertiesExtension.ELEMENT);
        int columnIndex5 = CursorUtil.getColumnIndex(cursor, "timeStamp");
        int columnIndex6 = CursorUtil.getColumnIndex(cursor, "openId");
        int columnIndex7 = CursorUtil.getColumnIndex(cursor, RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        int columnIndex8 = CursorUtil.getColumnIndex(cursor, "accountCode");
        int columnIndex9 = CursorUtil.getColumnIndex(cursor, "byteSize");
        int columnIndex10 = CursorUtil.getColumnIndex(cursor, "failCount");
        int columnIndex11 = CursorUtil.getColumnIndex(cursor, "nextUploadTime");
        int columnIndex12 = CursorUtil.getColumnIndex(cursor, TtmlNode.ATTR_ID);
        int columnIndex13 = CursorUtil.getColumnIndex(cursor, "created");
        int columnIndex14 = CursorUtil.getColumnIndex(cursor, "updated");
        BILogDbEntity bILogDbEntity = new BILogDbEntity();
        if (columnIndex != -1) {
            bILogDbEntity.setLogNo(cursor.isNull(columnIndex) ? null : cursor.getString(columnIndex));
        }
        if (columnIndex2 != -1) {
            bILogDbEntity.setContent(cursor.isNull(columnIndex2) ? null : cursor.getString(columnIndex2));
        }
        if (columnIndex3 != -1) {
            bILogDbEntity.setPageName(cursor.isNull(columnIndex3) ? null : cursor.getString(columnIndex3));
        }
        if (columnIndex4 != -1) {
            bILogDbEntity.setProperties(cursor.isNull(columnIndex4) ? null : cursor.getString(columnIndex4));
        }
        if (columnIndex5 != -1) {
            bILogDbEntity.setTimeStamp(cursor.getLong(columnIndex5));
        }
        if (columnIndex6 != -1) {
            bILogDbEntity.setOpenId(cursor.isNull(columnIndex6) ? null : cursor.getString(columnIndex6));
        }
        if (columnIndex7 != -1) {
            bILogDbEntity.setAppVersion(cursor.isNull(columnIndex7) ? null : cursor.getString(columnIndex7));
        }
        if (columnIndex8 != -1) {
            bILogDbEntity.setAccountCode(cursor.isNull(columnIndex8) ? null : cursor.getString(columnIndex8));
        }
        if (columnIndex9 != -1) {
            bILogDbEntity.setByteSize(cursor.isNull(columnIndex9) ? null : Integer.valueOf(cursor.getInt(columnIndex9)));
        }
        if (columnIndex10 != -1) {
            bILogDbEntity.setFailCount(cursor.isNull(columnIndex10) ? null : Integer.valueOf(cursor.getInt(columnIndex10)));
        }
        if (columnIndex11 != -1) {
            bILogDbEntity.setNextUploadTime(cursor.isNull(columnIndex11) ? null : Long.valueOf(cursor.getLong(columnIndex11)));
        }
        if (columnIndex12 != -1) {
            bILogDbEntity.setId(cursor.isNull(columnIndex12) ? null : cursor.getString(columnIndex12));
        }
        if (columnIndex13 != -1) {
            if (cursor.isNull(columnIndex13)) {
                i = -1;
                axVar = this;
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(cursor.getLong(columnIndex13));
                i = -1;
                axVar = this;
            }
            bILogDbEntity.setCreated(axVar.h.b(lValueOf));
        } else {
            i = -1;
            axVar = this;
        }
        if (columnIndex14 != i) {
            bILogDbEntity.setUpdated(axVar.h.b(cursor.isNull(columnIndex14) ? null : Long.valueOf(cursor.getLong(columnIndex14))));
        }
        return bILogDbEntity;
    }

    @Override // dc.uw
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void c(BILogDbEntity bILogDbEntity) {
        this.f.assertNotSuspendingTransaction();
        this.f.beginTransaction();
        try {
            this.i.handle(bILogDbEntity);
            this.f.setTransactionSuccessful();
        } finally {
            this.f.endTransaction();
        }
    }

    @Override // dc.uw
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void o(BILogDbEntity bILogDbEntity) {
        this.f.assertNotSuspendingTransaction();
        this.f.beginTransaction();
        try {
            this.g.insert((EntityInsertionAdapter<BILogDbEntity>) bILogDbEntity);
            this.f.setTransactionSuccessful();
        } finally {
            this.f.endTransaction();
        }
    }

    @Override // dc.uw
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public BILogDbEntity r(SupportSQLiteQuery supportSQLiteQuery) {
        this.f.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f, supportSQLiteQuery, false, null);
        try {
            return cursorQuery.moveToFirst() ? T(cursorQuery) : null;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // dc.uw
    public void d(Collection<? extends BILogDbEntity> collection) {
        this.f.assertNotSuspendingTransaction();
        this.f.beginTransaction();
        try {
            this.i.handleMultiple(collection);
            this.f.setTransactionSuccessful();
        } finally {
            this.f.endTransaction();
        }
    }

    @Override // dc.uw
    public void p(Collection<? extends BILogDbEntity> collection) {
        this.f.assertNotSuspendingTransaction();
        this.f.beginTransaction();
        try {
            this.g.insert(collection);
            this.f.setTransactionSuccessful();
        } finally {
            this.f.endTransaction();
        }
    }

    @Override // dc.uw
    public int s(SupportSQLiteQuery supportSQLiteQuery) {
        this.f.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f, supportSQLiteQuery, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // dc.uw
    public List<BILogDbEntity> t(SupportSQLiteQuery supportSQLiteQuery) {
        this.f.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(T(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }
}
