package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.sun.jna.Callback;
import com.wear.dao.BaseDao;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: LimitOffsetDataSource.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B3\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0002\u0010\rB;\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0002\u0010\u000fB3\b\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0002\u0010\u0011B;\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0002\u0010\u0013J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH$J\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0002J\u001e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*H\u0016J\u001e\u0010+\u001a\u00020&2\u0006\u0010'\u001a\u00020,2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!J\b\u0010.\u001a\u00020&H\u0002R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/room/paging/LimitOffsetDataSource;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PositionalDataSource;", BaseDao.TAG, "Landroidx/room/RoomDatabase;", "query", "Landroidx/sqlite/db/SupportSQLiteQuery;", "inTransaction", "", "tables", "", "", "(Landroidx/room/RoomDatabase;Landroidx/sqlite/db/SupportSQLiteQuery;Z[Ljava/lang/String;)V", "registerObserverImmediately", "(Landroidx/room/RoomDatabase;Landroidx/sqlite/db/SupportSQLiteQuery;ZZ[Ljava/lang/String;)V", "Landroidx/room/RoomSQLiteQuery;", "(Landroidx/room/RoomDatabase;Landroidx/room/RoomSQLiteQuery;Z[Ljava/lang/String;)V", "sourceQuery", "(Landroidx/room/RoomDatabase;Landroidx/room/RoomSQLiteQuery;ZZ[Ljava/lang/String;)V", "countQuery", "isInvalid", "()Z", "limitOffsetQuery", "observer", "Landroidx/room/InvalidationTracker$Observer;", "registeredObserver", "Ljava/util/concurrent/atomic/AtomicBoolean;", "convertRows", "", "cursor", "Landroid/database/Cursor;", "countItems", "", "getSQLiteQuery", "startPosition", "loadCount", "loadInitial", "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "Landroidx/paging/PositionalDataSource$LoadInitialParams;", Callback.METHOD_NAME, "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "loadRange", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "registerObserverIfNecessary", "room-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {

    @NotNull
    private final String countQuery;

    @NotNull
    private final RoomDatabase db;
    private final boolean inTransaction;

    @NotNull
    private final String limitOffsetQuery;

    @NotNull
    private final InvalidationTracker.Observer observer;

    @NotNull
    private final AtomicBoolean registeredObserver;

    @NotNull
    private final RoomSQLiteQuery sourceQuery;

    public LimitOffsetDataSource(@NotNull RoomDatabase db, @NotNull RoomSQLiteQuery sourceQuery, boolean z, boolean z2, @NotNull String... tables) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(sourceQuery, "sourceQuery");
        Intrinsics.checkNotNullParameter(tables, "tables");
        this.db = db;
        this.sourceQuery = sourceQuery;
        this.inTransaction = z;
        this.countQuery = "SELECT COUNT(*) FROM ( " + ((Object) sourceQuery.getSql()) + " )";
        this.limitOffsetQuery = "SELECT * FROM ( " + ((Object) sourceQuery.getSql()) + " ) LIMIT ? OFFSET ?";
        this.registeredObserver = new AtomicBoolean(false);
        this.observer = new InvalidationTracker.Observer(tables, this) { // from class: androidx.room.paging.LimitOffsetDataSource.1
            public final /* synthetic */ String[] $tables;
            public final /* synthetic */ LimitOffsetDataSource<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(tables);
                this.$tables = tables;
                this.this$0 = this;
            }

            @Override // androidx.room.InvalidationTracker.Observer
            public void onInvalidated(@NotNull Set<String> tables2) {
                Intrinsics.checkNotNullParameter(tables2, "tables");
                this.this$0.invalidate();
            }
        };
        if (z2) {
            registerObserverIfNecessary();
        }
    }

    private final RoomSQLiteQuery getSQLiteQuery(int startPosition, int loadCount) {
        RoomSQLiteQuery sqLiteQuery = RoomSQLiteQuery.acquire(this.limitOffsetQuery, this.sourceQuery.getArgCount() + 2);
        sqLiteQuery.copyArgumentsFrom(this.sourceQuery);
        sqLiteQuery.bindLong(sqLiteQuery.getArgCount() - 1, loadCount);
        sqLiteQuery.bindLong(sqLiteQuery.getArgCount(), startPosition);
        Intrinsics.checkNotNullExpressionValue(sqLiteQuery, "sqLiteQuery");
        return sqLiteQuery;
    }

    private final void registerObserverIfNecessary() {
        if (this.registeredObserver.compareAndSet(false, true)) {
            this.db.getInvalidationTracker().addWeakObserver(this.observer);
        }
    }

    @NotNull
    public abstract List<T> convertRows(@NotNull Cursor cursor);

    public final int countItems() {
        registerObserverIfNecessary();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(this.countQuery, this.sourceQuery.getArgCount());
        roomSQLiteQueryAcquire.copyArgumentsFrom(this.sourceQuery);
        Cursor cursorQuery = this.db.query(roomSQLiteQueryAcquire);
        Intrinsics.checkNotNullExpressionValue(cursorQuery, "db.query(sqLiteQuery)");
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.db.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(@NotNull PositionalDataSource.LoadInitialParams params, @NotNull final PositionalDataSource.LoadInitialCallback<T> callback) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        registerObserverIfNecessary();
        this.db.beginTransaction();
        try {
            final int iCountItems = countItems();
            if (iCountItems != 0) {
                final int iComputeInitialLoadPosition = PositionalDataSource.Companion.computeInitialLoadPosition(params, iCountItems);
                Cursor cursor = this.db.query(getSQLiteQuery(iComputeInitialLoadPosition, PositionalDataSource.Companion.computeInitialLoadSize(params, iComputeInitialLoadPosition, iCountItems)));
                try {
                    Intrinsics.checkNotNullExpressionValue(cursor, "cursor");
                    final List<T> listConvertRows = convertRows(cursor);
                    this.db.setTransactionSuccessful();
                    function0 = new Function0<Unit>() { // from class: androidx.room.paging.LimitOffsetDataSource$loadInitial$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            callback.onResult(listConvertRows, iComputeInitialLoadPosition, iCountItems);
                        }
                    };
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            } else {
                function0 = new Function0<Unit>() { // from class: androidx.room.paging.LimitOffsetDataSource.loadInitial.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        callback.onResult(CollectionsKt__CollectionsKt.emptyList(), 0, iCountItems);
                    }
                };
            }
            this.db.endTransaction();
            function0.invoke();
        } catch (Throwable th) {
            this.db.endTransaction();
            throw th;
        }
    }

    public void loadRange(@NotNull PositionalDataSource.LoadRangeParams params, @NotNull PositionalDataSource.LoadRangeCallback<T> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onResult(loadRange(params.startPosition, params.loadSize));
    }

    @NotNull
    public final List<T> loadRange(int startPosition, int loadCount) {
        Cursor cursor;
        RoomSQLiteQuery sQLiteQuery = getSQLiteQuery(startPosition, loadCount);
        try {
            if (this.inTransaction) {
                this.db.beginTransaction();
                try {
                    cursor = this.db.query(sQLiteQuery);
                    try {
                        Intrinsics.checkNotNullExpressionValue(cursor, "cursor");
                        List<T> listConvertRows = convertRows(cursor);
                        this.db.setTransactionSuccessful();
                        CloseableKt.closeFinally(cursor, null);
                        return listConvertRows;
                    } finally {
                    }
                } finally {
                    this.db.endTransaction();
                }
            } else {
                cursor = this.db.query(sQLiteQuery);
                try {
                    Intrinsics.checkNotNullExpressionValue(cursor, "cursor");
                    List<T> listConvertRows2 = convertRows(cursor);
                    CloseableKt.closeFinally(cursor, null);
                    return listConvertRows2;
                } finally {
                }
            }
        } finally {
        }
        sQLiteQuery.release();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LimitOffsetDataSource(@NotNull RoomDatabase db, @NotNull SupportSQLiteQuery query, boolean z, @NotNull String... tables) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(tables, "tables");
        RoomSQLiteQuery roomSQLiteQueryCopyFrom = RoomSQLiteQuery.copyFrom(query);
        Intrinsics.checkNotNullExpressionValue(roomSQLiteQueryCopyFrom, "copyFrom(query)");
        this(db, roomSQLiteQueryCopyFrom, z, (String[]) Arrays.copyOf(tables, tables.length));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LimitOffsetDataSource(@NotNull RoomDatabase db, @NotNull SupportSQLiteQuery query, boolean z, boolean z2, @NotNull String... tables) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(tables, "tables");
        RoomSQLiteQuery roomSQLiteQueryCopyFrom = RoomSQLiteQuery.copyFrom(query);
        Intrinsics.checkNotNullExpressionValue(roomSQLiteQueryCopyFrom, "copyFrom(query)");
        this(db, roomSQLiteQueryCopyFrom, z, z2, (String[]) Arrays.copyOf(tables, tables.length));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LimitOffsetDataSource(@NotNull RoomDatabase db, @NotNull RoomSQLiteQuery query, boolean z, @NotNull String... tables) {
        this(db, query, z, true, (String[]) Arrays.copyOf(tables, tables.length));
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(tables, "tables");
    }
}
