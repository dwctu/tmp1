package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.QueryInterceptorDatabase;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import dc.o6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: QueryInterceptorDatabase.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000f\u001a\u00020\tH\u0096\u0001J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\\\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n \u0017*\u0004\u0018\u00010\u00130\u00132\u000e\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00130\u00132,\u0010\u0019\u001a(\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u001b0\u001b \u0017*\u0014\u0012\u000e\b\u0001\u0012\n \u0017*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u001a0\u001aH\u0096\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\tH\u0097\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u0096\u0001J\b\u0010 \u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J)\u0010!\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a\"\u00020\u001bH\u0016¢\u0006\u0002\u0010#J\u009e\u0001\u0010$\u001a\u0096\u0001\u0012D\u0012B\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u0013\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u0013 \u0017* \u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u0013\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u0013\u0018\u00010&0& \u0017*J\u0012D\u0012B\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u0013\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u0013 \u0017* \u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u0013\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00130\u0013\u0018\u00010&0&\u0018\u00010'0%H\u0096\u0001J\t\u0010(\u001a\u00020)H\u0096\u0001J\t\u0010*\u001a\u00020)H\u0096\u0001J\u0011\u0010+\u001a\n \u0017*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\t\u0010,\u001a\u00020\u0015H\u0096\u0001J\t\u0010-\u001a\u00020\u001fH\u0096\u0001J1\u0010.\u001a\u00020)2\u000e\u0010\u0016\u001a\n \u0017*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\u0018\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n \u0017*\u0004\u0018\u00010/0/H\u0096\u0001J\t\u00100\u001a\u00020\u001fH\u0096\u0001J\t\u00101\u001a\u00020\u001fH\u0096\u0001J\t\u00102\u001a\u00020\u001fH\u0096\u0001J\t\u00103\u001a\u00020\u001fH\u0096\u0001J\t\u00104\u001a\u00020\u001fH\u0097\u0001J\u0011\u00105\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\u0010\u00106\u001a\u0002072\u0006\u00106\u001a\u000208H\u0016J\u001e\u00106\u001a\u0002072\b\b\u0001\u00106\u001a\u0002082\n\b\u0001\u00109\u001a\u0004\u0018\u00010:H\u0017J\u0010\u00106\u001a\u0002072\u0006\u00106\u001a\u00020\u0013H\u0016J)\u00106\u001a\u0002072\u0006\u00106\u001a\u00020\u00132\u0012\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001a\"\u00020\u001bH\u0016¢\u0006\u0002\u0010;J\u0011\u0010<\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u001fH\u0097\u0001J\u0019\u0010=\u001a\u00020\t2\u000e\u0010\u0016\u001a\n \u0017*\u0004\u0018\u00010>0>H\u0096\u0001J\u0011\u0010?\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010@\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020)H\u0096\u0001J\u0011\u0010A\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020)H\u0096\u0001J\b\u0010B\u001a\u00020\tH\u0016J\u0011\u0010C\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001Jt\u0010D\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n \u0017*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\u0018\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n \u0017*\u0004\u0018\u00010/0/2\u000e\u0010E\u001a\n \u0017*\u0004\u0018\u00010\u00130\u00132,\u0010F\u001a(\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u001b0\u001b \u0017*\u0014\u0012\u000e\b\u0001\u0012\n \u0017*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u001a0\u001aH\u0096\u0001¢\u0006\u0002\u0010GJ\t\u0010H\u001a\u00020\u001fH\u0096\u0001J\u0011\u0010H\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020)H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Landroidx/room/QueryInterceptorDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", Close.ELEMENT, "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "", "delete", "", "p0", "kotlin.jvm.PlatformType", "p1", "p2", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "", "endTransaction", "execSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "getAttachedDbs", "", "Landroid/util/Pair;", "", "getMaximumSize", "", "getPageSize", "getPath", "getVersion", "inTransaction", "insert", "Landroid/content/ContentValues;", "isDatabaseIntegrityOk", "isDbLockedByCurrentThread", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "needUpgrade", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "setLocale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "setMaximumSize", "setPageSize", "setTransactionSuccessful", "setVersion", DiscoverItems.Item.UPDATE_ACTION, "p3", "p4", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "room-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {

    @NotNull
    private final SupportSQLiteDatabase delegate;

    @NotNull
    private final RoomDatabase.QueryCallback queryCallback;

    @NotNull
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(@NotNull SupportSQLiteDatabase delegate, @NotNull Executor queryCallbackExecutor, @NotNull RoomDatabase.QueryCallback queryCallback) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(queryCallbackExecutor, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(queryCallback, "queryCallback");
        this.delegate = delegate;
        this.queryCallbackExecutor = queryCallbackExecutor;
        this.queryCallback = queryCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: beginTransaction$lambda-0, reason: not valid java name */
    public static final void m45beginTransaction$lambda0(QueryInterceptorDatabase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: beginTransactionNonExclusive$lambda-1, reason: not valid java name */
    public static final void m46beginTransactionNonExclusive$lambda1(QueryInterceptorDatabase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: beginTransactionWithListener$lambda-2, reason: not valid java name */
    public static final void m47beginTransactionWithListener$lambda2(QueryInterceptorDatabase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: beginTransactionWithListenerNonExclusive$lambda-3, reason: not valid java name */
    public static final void m48beginTransactionWithListenerNonExclusive$lambda3(QueryInterceptorDatabase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: endTransaction$lambda-4, reason: not valid java name */
    public static final void m49endTransaction$lambda4(QueryInterceptorDatabase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.queryCallback.onQuery("END TRANSACTION", CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: execSQL$lambda-10, reason: not valid java name */
    public static final void m50execSQL$lambda10(QueryInterceptorDatabase this$0, String sql) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sql, "$sql");
        this$0.queryCallback.onQuery(sql, CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: execSQL$lambda-11, reason: not valid java name */
    public static final void m51execSQL$lambda11(QueryInterceptorDatabase this$0, String sql, List inputArguments) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sql, "$sql");
        Intrinsics.checkNotNullParameter(inputArguments, "$inputArguments");
        this$0.queryCallback.onQuery(sql, inputArguments);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: query$lambda-6, reason: not valid java name */
    public static final void m52query$lambda6(QueryInterceptorDatabase this$0, String query) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(query, "$query");
        this$0.queryCallback.onQuery(query, CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: query$lambda-7, reason: not valid java name */
    public static final void m53query$lambda7(QueryInterceptorDatabase this$0, String query, Object[] bindArgs) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(query, "$query");
        Intrinsics.checkNotNullParameter(bindArgs, "$bindArgs");
        this$0.queryCallback.onQuery(query, ArraysKt___ArraysKt.toList(bindArgs));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: query$lambda-8, reason: not valid java name */
    public static final void m54query$lambda8(QueryInterceptorDatabase this$0, SupportSQLiteQuery query, QueryInterceptorProgram queryInterceptorProgram) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(query, "$query");
        Intrinsics.checkNotNullParameter(queryInterceptorProgram, "$queryInterceptorProgram");
        this$0.queryCallback.onQuery(query.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: query$lambda-9, reason: not valid java name */
    public static final void m55query$lambda9(QueryInterceptorDatabase this$0, SupportSQLiteQuery query, QueryInterceptorProgram queryInterceptorProgram) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(query, "$query");
        Intrinsics.checkNotNullParameter(queryInterceptorProgram, "$queryInterceptorProgram");
        this$0.queryCallback.onQuery(query.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setTransactionSuccessful$lambda-5, reason: not valid java name */
    public static final void m56setTransactionSuccessful$lambda5(QueryInterceptorDatabase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.queryCallback.onQuery("TRANSACTION SUCCESSFUL", CollectionsKt__CollectionsKt.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.w5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m45beginTransaction$lambda0(this.a);
            }
        });
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.p5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m46beginTransactionNonExclusive$lambda1(this.a);
            }
        });
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(@NotNull SQLiteTransactionListener transactionListener) {
        Intrinsics.checkNotNullParameter(transactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.l5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m47beginTransactionWithListener$lambda2(this.a);
            }
        });
        this.delegate.beginTransactionWithListener(transactionListener);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(@NotNull SQLiteTransactionListener transactionListener) {
        Intrinsics.checkNotNullParameter(transactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.u5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m48beginTransactionWithListenerNonExclusive$lambda3(this.a);
            }
        });
        this.delegate.beginTransactionWithListenerNonExclusive(transactionListener);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public SupportSQLiteStatement compileStatement(@NotNull String sql) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.delegate.compileStatement(sql);
        Intrinsics.checkNotNullExpressionValue(supportSQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new QueryInterceptorStatement(supportSQLiteStatementCompileStatement, sql, this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String p0, String p1, Object[] p2) {
        return this.delegate.delete(p0, p1, p2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.m5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m49endTransaction$lambda4(this.a);
            }
        });
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
        o6.$default$execPerConnectionSQL(this, str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@NotNull final String sql) throws SQLException {
        Intrinsics.checkNotNullParameter(sql, "sql");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.v5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m50execSQL$lambda10(this.a, sql);
            }
        });
        this.delegate.execSQL(sql);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String p0, int p1, ContentValues p2) {
        return this.delegate.insert(p0, p1, p2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return o6.$default$isExecPerConnectionSQLSupported(this);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int p0) {
        return this.delegate.needUpgrade(p0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull final String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.o5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m52query$lambda6(this.a, query);
            }
        });
        Cursor cursorQuery = this.delegate.query(query);
        Intrinsics.checkNotNullExpressionValue(cursorQuery, "delegate.query(query)");
        return cursorQuery;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean p0) {
        this.delegate.setForeignKeyConstraintsEnabled(p0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale p0) {
        this.delegate.setLocale(p0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int p0) {
        this.delegate.setMaxSqlCacheSize(p0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long p0) {
        return this.delegate.setMaximumSize(p0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long p0) {
        this.delegate.setPageSize(p0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.s5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m56setTransactionSuccessful$lambda5(this.a);
            }
        });
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int p0) {
        this.delegate.setVersion(p0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String p0, int p1, ContentValues p2, String p3, Object[] p4) {
        return this.delegate.update(p0, p1, p2, p3, p4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long p0) {
        return this.delegate.yieldIfContendedSafely(p0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(@NotNull final String sql, @NotNull Object... bindArgs) throws SQLException {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(CollectionsKt__CollectionsJVMKt.listOf(bindArgs));
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.r5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m51execSQL$lambda11(this.a, sql, arrayList);
            }
        });
        this.delegate.execSQL(sql, new List[]{arrayList});
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull final String query, @NotNull final Object... bindArgs) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.n5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m53query$lambda7(this.a, query, bindArgs);
            }
        });
        Cursor cursorQuery = this.delegate.query(query, bindArgs);
        Intrinsics.checkNotNullExpressionValue(cursorQuery, "delegate.query(query, bindArgs)");
        return cursorQuery;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NotNull
    public Cursor query(@NotNull final SupportSQLiteQuery query) {
        Intrinsics.checkNotNullParameter(query, "query");
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.q5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m54query$lambda8(this.a, query, queryInterceptorProgram);
            }
        });
        Cursor cursorQuery = this.delegate.query(query);
        Intrinsics.checkNotNullExpressionValue(cursorQuery, "delegate.query(query)");
        return cursorQuery;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @NonNull
    @NotNull
    public Cursor query(@NonNull @NotNull final SupportSQLiteQuery query, @NonNull @Nullable CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(query, "query");
        final QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        query.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new Runnable() { // from class: dc.t5
            @Override // java.lang.Runnable
            public final void run() {
                QueryInterceptorDatabase.m55query$lambda9(this.a, query, queryInterceptorProgram);
            }
        });
        Cursor cursorQuery = this.delegate.query(query);
        Intrinsics.checkNotNullExpressionValue(cursorQuery, "delegate.query(query)");
        return cursorQuery;
    }
}
