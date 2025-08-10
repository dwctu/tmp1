package net.sqlcipher.database;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import dc.fb4;

/* loaded from: classes5.dex */
public class SupportFactory implements SupportSQLiteOpenHelper.Factory {
    public final byte[] a;
    public final fb4 b;
    public final boolean c;

    public SupportFactory(byte[] bArr) {
        this(bArr, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new SupportHelper(configuration, this.a, this.b, this.c);
    }

    public SupportFactory(byte[] bArr, fb4 fb4Var) {
        this(bArr, fb4Var, true);
    }

    public SupportFactory(byte[] bArr, fb4 fb4Var, boolean z) {
        this.a = bArr;
        this.b = fb4Var;
        this.c = z;
    }
}
