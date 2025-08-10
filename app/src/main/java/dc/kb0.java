package dc;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.component.dxtoy.core.datacenter.db.bean.ToyDbEntity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: ToyDaoBridge_Impl.java */
/* loaded from: classes.dex */
public final class kb0 extends jb0 {
    public final RoomDatabase f;
    public final EntityInsertionAdapter<ToyDbEntity> g;
    public final ww h = new ww();
    public final EntityDeletionOrUpdateAdapter<ToyDbEntity> i;

    /* compiled from: ToyDaoBridge_Impl.java */
    public class a extends EntityInsertionAdapter<ToyDbEntity> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ToyDbEntity toyDbEntity) {
            if (toyDbEntity.getUuid() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, toyDbEntity.getUuid());
            }
            supportSQLiteStatement.bindLong(2, toyDbEntity.getVersion());
            if (toyDbEntity.getShowName() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, toyDbEntity.getShowName());
            }
            if (toyDbEntity.getType() == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, toyDbEntity.getType());
            }
            if (toyDbEntity.getSymbol() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, toyDbEntity.getSymbol());
            }
            supportSQLiteStatement.bindLong(6, toyDbEntity.getIsSelect() ? 1L : 0L);
            if (toyDbEntity.getMac() == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, toyDbEntity.getMac());
            }
            if (toyDbEntity.getDeviceName() == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, toyDbEntity.getDeviceName());
            }
            if (toyDbEntity.getDeviceType() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, toyDbEntity.getDeviceType());
            }
            supportSQLiteStatement.bindLong(10, toyDbEntity.getIsVirtualToy() ? 1L : 0L);
            if (toyDbEntity.getDefineRename() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, toyDbEntity.getDefineRename());
            }
            supportSQLiteStatement.bindLong(12, toyDbEntity.getIsLedOpen() ? 1L : 0L);
            supportSQLiteStatement.bindLong(13, toyDbEntity.getLedColor());
            if (toyDbEntity.getRmId() == null) {
                supportSQLiteStatement.bindNull(14);
            } else {
                supportSQLiteStatement.bindString(14, toyDbEntity.getRmId());
            }
            supportSQLiteStatement.bindLong(15, toyDbEntity.getUpdateTime());
            if (toyDbEntity.getFormApp() == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, toyDbEntity.getFormApp());
            }
            supportSQLiteStatement.bindLong(17, toyDbEntity.getIsUIInMyToyList() ? 1L : 0L);
            supportSQLiteStatement.bindLong(18, toyDbEntity.getOtherAppConnectState());
            if (toyDbEntity.getId() == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, toyDbEntity.getId());
            }
            Long lA = kb0.this.h.a(toyDbEntity.getCreated());
            if (lA == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindLong(20, lA.longValue());
            }
            Long lA2 = kb0.this.h.a(toyDbEntity.getUpdated());
            if (lA2 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindLong(21, lA2.longValue());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `ToyDbEntity` (`uuid`,`version`,`showName`,`type`,`symbol`,`isSelect`,`mac`,`deviceName`,`deviceType`,`isVirtualToy`,`defineRename`,`isLedOpen`,`ledColor`,`rmId`,`updateTime`,`formApp`,`isUIInMyToyList`,`otherAppConnectState`,`id`,`created`,`updated`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: ToyDaoBridge_Impl.java */
    public class b extends EntityDeletionOrUpdateAdapter<ToyDbEntity> {
        public b(kb0 kb0Var, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ToyDbEntity toyDbEntity) {
            if (toyDbEntity.getId() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, toyDbEntity.getId());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `ToyDbEntity` WHERE `id` = ?";
        }
    }

    public kb0(RoomDatabase roomDatabase) {
        this.f = roomDatabase;
        this.g = new a(roomDatabase);
        this.i = new b(this, roomDatabase);
    }

    public static List<Class<?>> U() {
        return Collections.emptyList();
    }

    public final ToyDbEntity R(Cursor cursor) {
        kb0 kb0Var;
        Long lValueOf;
        int columnIndex = CursorUtil.getColumnIndex(cursor, "uuid");
        int columnIndex2 = CursorUtil.getColumnIndex(cursor, "version");
        int columnIndex3 = CursorUtil.getColumnIndex(cursor, "showName");
        int columnIndex4 = CursorUtil.getColumnIndex(cursor, "type");
        int columnIndex5 = CursorUtil.getColumnIndex(cursor, "symbol");
        int columnIndex6 = CursorUtil.getColumnIndex(cursor, "isSelect");
        int columnIndex7 = CursorUtil.getColumnIndex(cursor, "mac");
        int columnIndex8 = CursorUtil.getColumnIndex(cursor, "deviceName");
        int columnIndex9 = CursorUtil.getColumnIndex(cursor, "deviceType");
        int columnIndex10 = CursorUtil.getColumnIndex(cursor, "isVirtualToy");
        int columnIndex11 = CursorUtil.getColumnIndex(cursor, "defineRename");
        int columnIndex12 = CursorUtil.getColumnIndex(cursor, "isLedOpen");
        int columnIndex13 = CursorUtil.getColumnIndex(cursor, "ledColor");
        int columnIndex14 = CursorUtil.getColumnIndex(cursor, "rmId");
        int columnIndex15 = CursorUtil.getColumnIndex(cursor, "updateTime");
        int columnIndex16 = CursorUtil.getColumnIndex(cursor, "formApp");
        int columnIndex17 = CursorUtil.getColumnIndex(cursor, "isUIInMyToyList");
        int columnIndex18 = CursorUtil.getColumnIndex(cursor, "otherAppConnectState");
        int columnIndex19 = CursorUtil.getColumnIndex(cursor, TtmlNode.ATTR_ID);
        int columnIndex20 = CursorUtil.getColumnIndex(cursor, "created");
        int columnIndex21 = CursorUtil.getColumnIndex(cursor, "updated");
        ToyDbEntity toyDbEntity = new ToyDbEntity();
        if (columnIndex != -1) {
            toyDbEntity.setUuid(cursor.isNull(columnIndex) ? null : cursor.getString(columnIndex));
        }
        if (columnIndex2 != -1) {
            toyDbEntity.setVersion(cursor.getInt(columnIndex2));
        }
        if (columnIndex3 != -1) {
            toyDbEntity.setShowName(cursor.isNull(columnIndex3) ? null : cursor.getString(columnIndex3));
        }
        if (columnIndex4 != -1) {
            toyDbEntity.setType(cursor.isNull(columnIndex4) ? null : cursor.getString(columnIndex4));
        }
        if (columnIndex5 != -1) {
            toyDbEntity.setSymbol(cursor.isNull(columnIndex5) ? null : cursor.getString(columnIndex5));
        }
        if (columnIndex6 != -1) {
            toyDbEntity.setSelect(cursor.getInt(columnIndex6) != 0);
        }
        if (columnIndex7 != -1) {
            toyDbEntity.setMac(cursor.isNull(columnIndex7) ? null : cursor.getString(columnIndex7));
        }
        if (columnIndex8 != -1) {
            toyDbEntity.setDeviceName(cursor.isNull(columnIndex8) ? null : cursor.getString(columnIndex8));
        }
        if (columnIndex9 != -1) {
            toyDbEntity.setDeviceType(cursor.isNull(columnIndex9) ? null : cursor.getString(columnIndex9));
        }
        if (columnIndex10 != -1) {
            toyDbEntity.setVirtualToy(cursor.getInt(columnIndex10) != 0);
        }
        if (columnIndex11 != -1) {
            toyDbEntity.setDefineRename(cursor.isNull(columnIndex11) ? null : cursor.getString(columnIndex11));
        }
        if (columnIndex12 != -1) {
            toyDbEntity.setLedOpen(cursor.getInt(columnIndex12) != 0);
        }
        if (columnIndex13 != -1) {
            toyDbEntity.setLedColor(cursor.getInt(columnIndex13));
        }
        if (columnIndex14 != -1) {
            toyDbEntity.setRmId(cursor.isNull(columnIndex14) ? null : cursor.getString(columnIndex14));
        }
        if (columnIndex15 != -1) {
            toyDbEntity.setUpdateTime(cursor.getLong(columnIndex15));
        }
        if (columnIndex16 != -1) {
            toyDbEntity.setFormApp(cursor.isNull(columnIndex16) ? null : cursor.getString(columnIndex16));
        }
        if (columnIndex17 != -1) {
            toyDbEntity.setUIInMyToyList(cursor.getInt(columnIndex17) != 0);
        }
        if (columnIndex18 != -1) {
            toyDbEntity.setOtherAppConnectState(cursor.getInt(columnIndex18));
        }
        if (columnIndex19 != -1) {
            toyDbEntity.setId(cursor.isNull(columnIndex19) ? null : cursor.getString(columnIndex19));
        }
        if (columnIndex20 != -1) {
            if (cursor.isNull(columnIndex20)) {
                kb0Var = this;
                lValueOf = null;
            } else {
                lValueOf = Long.valueOf(cursor.getLong(columnIndex20));
                kb0Var = this;
            }
            toyDbEntity.setCreated(kb0Var.h.b(lValueOf));
        } else {
            kb0Var = this;
        }
        if (columnIndex21 != -1) {
            toyDbEntity.setUpdated(kb0Var.h.b(cursor.isNull(columnIndex21) ? null : Long.valueOf(cursor.getLong(columnIndex21))));
        }
        return toyDbEntity;
    }

    @Override // dc.uw
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void c(ToyDbEntity toyDbEntity) {
        this.f.assertNotSuspendingTransaction();
        this.f.beginTransaction();
        try {
            this.i.handle(toyDbEntity);
            this.f.setTransactionSuccessful();
        } finally {
            this.f.endTransaction();
        }
    }

    @Override // dc.uw
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void o(ToyDbEntity toyDbEntity) {
        this.f.assertNotSuspendingTransaction();
        this.f.beginTransaction();
        try {
            this.g.insert((EntityInsertionAdapter<ToyDbEntity>) toyDbEntity);
            this.f.setTransactionSuccessful();
        } finally {
            this.f.endTransaction();
        }
    }

    @Override // dc.uw
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public ToyDbEntity r(SupportSQLiteQuery supportSQLiteQuery) {
        this.f.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f, supportSQLiteQuery, false, null);
        try {
            return cursorQuery.moveToFirst() ? R(cursorQuery) : null;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // dc.uw
    public void d(Collection<? extends ToyDbEntity> collection) {
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
    public void p(Collection<? extends ToyDbEntity> collection) {
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
    public List<ToyDbEntity> t(SupportSQLiteQuery supportSQLiteQuery) {
        this.f.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f, supportSQLiteQuery, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(R(cursorQuery));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }
}
