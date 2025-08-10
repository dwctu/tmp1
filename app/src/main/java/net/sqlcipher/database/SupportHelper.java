package net.sqlcipher.database;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import dc.fb4;
import dc.hb4;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes5.dex */
public class SupportHelper implements SupportSQLiteOpenHelper {
    public hb4 a;
    public byte[] b;
    public final boolean c;

    public class a extends hb4 {
        public final /* synthetic */ SupportSQLiteOpenHelper.Configuration k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SupportHelper supportHelper, Context context, String str, SQLiteDatabase.f fVar, int i, fb4 fb4Var, SupportSQLiteOpenHelper.Configuration configuration) {
            super(context, str, fVar, i, fb4Var);
            this.k = configuration;
        }

        @Override // dc.hb4
        public void d(SQLiteDatabase sQLiteDatabase) {
            this.k.callback.onConfigure(sQLiteDatabase);
        }

        @Override // dc.hb4
        public void e(SQLiteDatabase sQLiteDatabase) {
            this.k.callback.onCreate(sQLiteDatabase);
        }

        @Override // dc.hb4
        public void f(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.k.callback.onDowngrade(sQLiteDatabase, i, i2);
        }

        @Override // dc.hb4
        public void g(SQLiteDatabase sQLiteDatabase) {
            this.k.callback.onOpen(sQLiteDatabase);
        }

        @Override // dc.hb4
        public void h(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.k.callback.onUpgrade(sQLiteDatabase, i, i2);
        }
    }

    public SupportHelper(SupportSQLiteOpenHelper.Configuration configuration, byte[] bArr, fb4 fb4Var, boolean z) {
        SQLiteDatabase.l0(configuration.context);
        this.b = bArr;
        this.c = z;
        this.a = new a(this, configuration.context, configuration.name, null, configuration.callback.version, fb4Var, configuration);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.a();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.a.b();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        try {
            SQLiteDatabase sQLiteDatabaseC = this.a.c(this.b);
            if (this.c && this.b != null) {
                int i = 0;
                while (true) {
                    byte[] bArr = this.b;
                    if (i >= bArr.length) {
                        break;
                    }
                    bArr[i] = 0;
                    i++;
                }
            }
            return sQLiteDatabaseC;
        } catch (SQLiteException e) {
            byte[] bArr2 = this.b;
            if (bArr2 != null) {
                boolean z = true;
                for (byte b : bArr2) {
                    z = z && b == 0;
                }
                if (z) {
                    throw new IllegalStateException("The passphrase appears to be cleared. This happens by default the first time you use the factory to open a database, so we can remove the cleartext passphrase from memory. If you close the database yourself, please use a fresh SupportFactory to reopen it. If something else (e.g., Room) closed the database, and you cannot control that, use SupportFactory boolean constructor option to opt out of the automatic password clearing step. See the project README for more information.", e);
                }
            }
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.a.i(z);
    }
}
