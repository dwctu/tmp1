package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import io.agora.rtc2.internal.CommonUtility;

/* loaded from: classes.dex */
public class TransferDBBase {
    public static final Log f = LogFactory.b(TransferDBBase.class);
    public static final Object g = new Object();
    public final Context a;
    public final Uri b;
    public final UriMatcher c;
    public final TransferDatabaseHelper d;
    public SQLiteDatabase e;

    public TransferDBBase(Context context) {
        this.a = context;
        String packageName = context.getApplicationContext().getPackageName();
        TransferDatabaseHelper transferDatabaseHelper = new TransferDatabaseHelper(context);
        this.d = transferDatabaseHelper;
        this.e = transferDatabaseHelper.getWritableDatabase();
        this.b = Uri.parse(CommonUtility.PREFIX_URI + packageName + "/transfers");
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.c = uriMatcher;
        uriMatcher.addURI(packageName, "transfers", 10);
        uriMatcher.addURI(packageName, "transfers/#", 20);
        uriMatcher.addURI(packageName, "transfers/part/#", 30);
        uriMatcher.addURI(packageName, "transfers/state/*", 40);
    }

    public int a(Uri uri, ContentValues[] contentValuesArr) {
        int iMatch = this.c.match(uri);
        c();
        if (iMatch != 10) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        int iInsertOrThrow = 0;
        try {
            try {
                this.e.beginTransaction();
                iInsertOrThrow = (int) this.e.insertOrThrow("awstransfer", null, contentValuesArr[0]);
                for (int i = 1; i < contentValuesArr.length; i++) {
                    contentValuesArr[i].put("main_upload_id", Integer.valueOf(iInsertOrThrow));
                    this.e.insertOrThrow("awstransfer", null, contentValuesArr[i]);
                }
                this.e.setTransactionSuccessful();
            } catch (Exception e) {
                f.c("bulkInsert error : ", e);
            }
            return iInsertOrThrow;
        } finally {
            this.e.endTransaction();
        }
    }

    public int b(Uri uri, String str, String[] strArr) {
        int iMatch = this.c.match(uri);
        c();
        if (iMatch == 10) {
            return this.e.delete("awstransfer", str, strArr);
        }
        if (iMatch != 20) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (TextUtils.isEmpty(str)) {
            return this.e.delete("awstransfer", "_id=" + lastPathSegment, null);
        }
        return this.e.delete("awstransfer", "_id=" + lastPathSegment + " and " + str, strArr);
    }

    public final void c() {
        synchronized (g) {
            if (!this.e.isOpen()) {
                this.e = this.d.getWritableDatabase();
            }
        }
    }

    public Uri d() {
        return this.b;
    }

    public Uri e(Uri uri, ContentValues contentValues) throws SQLException {
        int iMatch = this.c.match(uri);
        c();
        if (iMatch != 10) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return Uri.parse("transfers/" + this.e.insertOrThrow("awstransfer", null, contentValues));
    }

    public Cursor f(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("awstransfer");
        int iMatch = this.c.match(uri);
        if (iMatch == 10) {
            sQLiteQueryBuilder.appendWhere("part_num=0");
        } else if (iMatch == 20) {
            sQLiteQueryBuilder.appendWhere("_id=" + uri.getLastPathSegment());
        } else if (iMatch == 30) {
            sQLiteQueryBuilder.appendWhere("main_upload_id=" + uri.getLastPathSegment());
        } else {
            if (iMatch != 40) {
                throw new IllegalArgumentException("Unknown URI: " + uri);
            }
            sQLiteQueryBuilder.appendWhere("state=");
            sQLiteQueryBuilder.appendWhereEscapeString(uri.getLastPathSegment());
        }
        c();
        return sQLiteQueryBuilder.query(this.e, strArr, str, strArr2, null, null, str2);
    }

    public synchronized int g(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iUpdate;
        int iMatch = this.c.match(uri);
        c();
        if (iMatch == 10) {
            iUpdate = this.e.update("awstransfer", contentValues, str, strArr);
        } else {
            if (iMatch != 20) {
                throw new IllegalArgumentException("Unknown URI: " + uri);
            }
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.isEmpty(str)) {
                iUpdate = this.e.update("awstransfer", contentValues, "_id=" + lastPathSegment, null);
            } else {
                iUpdate = this.e.update("awstransfer", contentValues, "_id=" + lastPathSegment + " and " + str, strArr);
            }
        }
        return iUpdate;
    }
}
