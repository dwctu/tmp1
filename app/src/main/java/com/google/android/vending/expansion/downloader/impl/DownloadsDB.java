package com.google.android.vending.expansion.downloader.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.provider.BaseColumns;
import com.j256.ormlite.field.FieldType;

/* loaded from: classes2.dex */
public class DownloadsDB {
    private static final int CONTROL_IDX = 7;
    private static final int CURRENTBYTES_IDX = 4;
    private static final String DATABASE_NAME = "DownloadsDB";
    private static final int DATABASE_VERSION = 7;
    private static final String[] DC_PROJECTION = {DownloadColumns.FILENAME, DownloadColumns.URI, DownloadColumns.ETAG, DownloadColumns.TOTALBYTES, DownloadColumns.CURRENTBYTES, DownloadColumns.LASTMOD, "STATUS", DownloadColumns.CONTROL, DownloadColumns.NUM_FAILED, DownloadColumns.RETRY_AFTER, DownloadColumns.REDIRECT_COUNT, DownloadColumns.INDEX};
    private static final int ETAG_IDX = 2;
    private static final int FILENAME_IDX = 0;
    private static final int INDEX_IDX = 11;
    private static final int LASTMOD_IDX = 5;
    public static final String LOG_TAG = "com.google.android.vending.expansion.downloader.impl.DownloadsDB";
    private static final int NUM_FAILED_IDX = 8;
    private static final int REDIRECT_COUNT_IDX = 10;
    private static final int RETRY_AFTER_IDX = 9;
    private static final int STATUS_IDX = 6;
    private static final int TOTALBYTES_IDX = 3;
    private static final int URI_IDX = 1;
    private static DownloadsDB mDownloadsDB;
    public int mFlags;
    public SQLiteStatement mGetDownloadByIndex;
    public final SQLiteOpenHelper mHelper;
    public long mMetadataRowID;
    public int mStatus;
    public SQLiteStatement mUpdateCurrentBytes;
    public int mVersionCode;

    public static class DownloadColumns implements BaseColumns {
        public static final String STATUS = "STATUS";
        public static final String TABLE_NAME = "DownloadColumns";
        public static final String _ID = "DownloadColumns._id";
        public static final String INDEX = "FILEIDX";
        public static final String URI = "URI";
        public static final String FILENAME = "FN";
        public static final String ETAG = "ETAG";
        public static final String TOTALBYTES = "TOTALBYTES";
        public static final String CURRENTBYTES = "CURRENTBYTES";
        public static final String LASTMOD = "LASTMOD";
        public static final String CONTROL = "CONTROL";
        public static final String NUM_FAILED = "FAILCOUNT";
        public static final String RETRY_AFTER = "RETRYAFTER";
        public static final String REDIRECT_COUNT = "REDIRECTCOUNT";
        public static final String[][] SCHEMA = {new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "INTEGER PRIMARY KEY"}, new String[]{INDEX, "INTEGER UNIQUE"}, new String[]{URI, "TEXT"}, new String[]{FILENAME, "TEXT UNIQUE"}, new String[]{ETAG, "TEXT"}, new String[]{TOTALBYTES, "INTEGER"}, new String[]{CURRENTBYTES, "INTEGER"}, new String[]{LASTMOD, "INTEGER"}, new String[]{"STATUS", "INTEGER"}, new String[]{CONTROL, "INTEGER"}, new String[]{NUM_FAILED, "INTEGER"}, new String[]{RETRY_AFTER, "INTEGER"}, new String[]{REDIRECT_COUNT, "INTEGER"}};
    }

    public static class DownloadsContentDBHelper extends SQLiteOpenHelper {
        private static final String[][][] sSchemas = {DownloadColumns.SCHEMA, MetadataColumns.SCHEMA};
        private static final String[] sTables = {DownloadColumns.TABLE_NAME, MetadataColumns.TABLE_NAME};

        public DownloadsContentDBHelper(Context context) {
            super(context, DownloadsDB.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 7);
        }

        private String createTableQueryFromArray(String str, String[][] strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(str);
            sb.append(" (");
            for (String[] strArr2 : strArr) {
                sb.append(' ');
                sb.append(strArr2[0]);
                sb.append(' ');
                sb.append(strArr2[1]);
                sb.append(',');
            }
            sb.setLength(sb.length() - 1);
            sb.append(");");
            return sb.toString();
        }

        private void dropTables(SQLiteDatabase sQLiteDatabase) throws SQLException {
            for (String str : sTables) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
            int length = sSchemas.length;
            for (int i = 0; i < length; i++) {
                try {
                    sQLiteDatabase.execSQL(createTableQueryFromArray(sTables[i], sSchemas[i]));
                } catch (Exception e) {
                    while (true) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
            String str = "Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data";
            dropTables(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    public static class MetadataColumns implements BaseColumns {
        public static final String APKVERSION = "APKVERSION";
        public static final String DOWNLOAD_STATUS = "DOWNLOADSTATUS";
        public static final String FLAGS = "DOWNLOADFLAGS";
        public static final String[][] SCHEMA = {new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "INTEGER PRIMARY KEY"}, new String[]{APKVERSION, "INTEGER"}, new String[]{DOWNLOAD_STATUS, "INTEGER"}, new String[]{FLAGS, "INTEGER"}};
        public static final String TABLE_NAME = "MetadataColumns";
        public static final String _ID = "MetadataColumns._id";
    }

    private DownloadsDB(Context context) {
        this.mMetadataRowID = -1L;
        this.mVersionCode = -1;
        this.mStatus = -1;
        DownloadsContentDBHelper downloadsContentDBHelper = new DownloadsContentDBHelper(context);
        this.mHelper = downloadsContentDBHelper;
        Cursor cursorRawQuery = downloadsContentDBHelper.getReadableDatabase().rawQuery("SELECT APKVERSION,_id,DOWNLOADSTATUS,DOWNLOADFLAGS FROM MetadataColumns LIMIT 1", null);
        if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
            this.mVersionCode = cursorRawQuery.getInt(0);
            this.mMetadataRowID = cursorRawQuery.getLong(1);
            this.mStatus = cursorRawQuery.getInt(2);
            this.mFlags = cursorRawQuery.getInt(3);
            cursorRawQuery.close();
        }
        mDownloadsDB = this;
    }

    public static synchronized DownloadsDB getDB(Context context) {
        DownloadsDB downloadsDB = mDownloadsDB;
        if (downloadsDB != null) {
            return downloadsDB;
        }
        return new DownloadsDB(context);
    }

    private SQLiteStatement getDownloadByIndexStatement() {
        if (this.mGetDownloadByIndex == null) {
            this.mGetDownloadByIndex = this.mHelper.getReadableDatabase().compileStatement("SELECT _id FROM DownloadColumns WHERE FILEIDX = ?");
        }
        return this.mGetDownloadByIndex;
    }

    private SQLiteStatement getUpdateCurrentBytesStatement() {
        if (this.mUpdateCurrentBytes == null) {
            this.mUpdateCurrentBytes = this.mHelper.getReadableDatabase().compileStatement("UPDATE DownloadColumns SET CURRENTBYTES = ? WHERE FILEIDX = ?");
        }
        return this.mUpdateCurrentBytes;
    }

    public void close() {
        this.mHelper.close();
    }

    public DownloadInfo getDownloadInfoByFileName(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        try {
            cursorQuery = this.mHelper.getReadableDatabase().query(DownloadColumns.TABLE_NAME, DC_PROJECTION, "FN = ?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        DownloadInfo downloadInfoFromCursor = getDownloadInfoFromCursor(cursorQuery);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return downloadInfoFromCursor;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    public DownloadInfo getDownloadInfoFromCursor(Cursor cursor) {
        DownloadInfo downloadInfo = new DownloadInfo(cursor.getInt(11), cursor.getString(0), getClass().getPackage().getName());
        setDownloadInfoFromCursor(downloadInfo, cursor);
        return downloadInfo;
    }

    public DownloadInfo[] getDownloads() throws Throwable {
        Cursor cursorQuery;
        Throwable th;
        try {
            cursorQuery = this.mHelper.getReadableDatabase().query(DownloadColumns.TABLE_NAME, DC_PROJECTION, null, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        DownloadInfo[] downloadInfoArr = new DownloadInfo[cursorQuery.getCount()];
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            downloadInfoArr[i] = getDownloadInfoFromCursor(cursorQuery);
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            i = i2;
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return downloadInfoArr;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            cursorQuery = null;
            th = th3;
        }
    }

    public int getFlags() {
        return this.mFlags;
    }

    public long getIDByIndex(int i) {
        SQLiteStatement downloadByIndexStatement = getDownloadByIndexStatement();
        downloadByIndexStatement.clearBindings();
        downloadByIndexStatement.bindLong(1, i);
        try {
            return downloadByIndexStatement.simpleQueryForLong();
        } catch (SQLiteDoneException unused) {
            return -1L;
        }
    }

    public long getIDForDownloadInfo(DownloadInfo downloadInfo) {
        return getIDByIndex(downloadInfo.mIndex);
    }

    public int getLastCheckedVersionCode() {
        return this.mVersionCode;
    }

    public boolean isDownloadRequired() {
        Cursor cursorRawQuery = this.mHelper.getReadableDatabase().rawQuery("SELECT Count(*) FROM DownloadColumns WHERE STATUS <> 0", null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getInt(0) == 0;
                }
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return true;
    }

    public void setDownloadInfoFromCursor(DownloadInfo downloadInfo, Cursor cursor) {
        downloadInfo.mUri = cursor.getString(1);
        downloadInfo.mETag = cursor.getString(2);
        downloadInfo.mTotalBytes = cursor.getLong(3);
        downloadInfo.mCurrentBytes = cursor.getLong(4);
        downloadInfo.mLastMod = cursor.getLong(5);
        downloadInfo.mStatus = cursor.getInt(6);
        downloadInfo.mControl = cursor.getInt(7);
        downloadInfo.mNumFailed = cursor.getInt(8);
        downloadInfo.mRetryAfter = cursor.getInt(9);
        downloadInfo.mRedirectCount = cursor.getInt(10);
    }

    public boolean updateDownload(DownloadInfo downloadInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadColumns.INDEX, Integer.valueOf(downloadInfo.mIndex));
        contentValues.put(DownloadColumns.FILENAME, downloadInfo.mFileName);
        contentValues.put(DownloadColumns.URI, downloadInfo.mUri);
        contentValues.put(DownloadColumns.ETAG, downloadInfo.mETag);
        contentValues.put(DownloadColumns.TOTALBYTES, Long.valueOf(downloadInfo.mTotalBytes));
        contentValues.put(DownloadColumns.CURRENTBYTES, Long.valueOf(downloadInfo.mCurrentBytes));
        contentValues.put(DownloadColumns.LASTMOD, Long.valueOf(downloadInfo.mLastMod));
        contentValues.put("STATUS", Integer.valueOf(downloadInfo.mStatus));
        contentValues.put(DownloadColumns.CONTROL, Integer.valueOf(downloadInfo.mControl));
        contentValues.put(DownloadColumns.NUM_FAILED, Integer.valueOf(downloadInfo.mNumFailed));
        contentValues.put(DownloadColumns.RETRY_AFTER, Integer.valueOf(downloadInfo.mRetryAfter));
        contentValues.put(DownloadColumns.REDIRECT_COUNT, Integer.valueOf(downloadInfo.mRedirectCount));
        return updateDownload(downloadInfo, contentValues);
    }

    public void updateDownloadCurrentBytes(DownloadInfo downloadInfo) {
        SQLiteStatement updateCurrentBytesStatement = getUpdateCurrentBytesStatement();
        updateCurrentBytesStatement.clearBindings();
        updateCurrentBytesStatement.bindLong(1, downloadInfo.mCurrentBytes);
        updateCurrentBytesStatement.bindLong(2, downloadInfo.mIndex);
        updateCurrentBytesStatement.execute();
    }

    public boolean updateFlags(int i) {
        if (this.mFlags == i) {
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MetadataColumns.FLAGS, Integer.valueOf(i));
        if (!updateMetadata(contentValues)) {
            return false;
        }
        this.mFlags = i;
        return true;
    }

    public boolean updateFromDb(DownloadInfo downloadInfo) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.mHelper.getReadableDatabase().query(DownloadColumns.TABLE_NAME, DC_PROJECTION, "FN= ?", new String[]{downloadInfo.mFileName}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                setDownloadInfoFromCursor(downloadInfo, cursorQuery);
                return true;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return false;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public boolean updateMetadata(ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
        if (-1 != this.mMetadataRowID) {
            StringBuilder sb = new StringBuilder();
            sb.append("_id = ");
            sb.append(this.mMetadataRowID);
            return writableDatabase.update(MetadataColumns.TABLE_NAME, contentValues, sb.toString(), null) != 0;
        }
        long jInsert = writableDatabase.insert(MetadataColumns.TABLE_NAME, MetadataColumns.APKVERSION, contentValues);
        if (-1 == jInsert) {
            return false;
        }
        this.mMetadataRowID = jInsert;
        return true;
    }

    public boolean updateStatus(int i) {
        if (this.mStatus == i) {
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MetadataColumns.DOWNLOAD_STATUS, Integer.valueOf(i));
        if (!updateMetadata(contentValues)) {
            return false;
        }
        this.mStatus = i;
        return true;
    }

    public boolean updateMetadata(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MetadataColumns.APKVERSION, Integer.valueOf(i));
        contentValues.put(MetadataColumns.DOWNLOAD_STATUS, Integer.valueOf(i2));
        if (!updateMetadata(contentValues)) {
            return false;
        }
        this.mVersionCode = i;
        this.mStatus = i2;
        return true;
    }

    public boolean updateDownload(DownloadInfo downloadInfo, ContentValues contentValues) {
        SQLiteDatabase writableDatabase;
        long iDForDownloadInfo = downloadInfo == null ? -1L : getIDForDownloadInfo(downloadInfo);
        try {
            writableDatabase = this.mHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (iDForDownloadInfo == -1) {
            return -1 != writableDatabase.insert(DownloadColumns.TABLE_NAME, DownloadColumns.URI, contentValues);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadColumns._id = ");
        sb.append(iDForDownloadInfo);
        return 1 != writableDatabase.update(DownloadColumns.TABLE_NAME, contentValues, sb.toString(), null) ? false : false;
    }
}
