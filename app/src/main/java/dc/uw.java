package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.component.dxdatabase.lib.base.bean.DbBaseEntity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DbBaseDao.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016H\u0004J\b\u0010\u0017\u001a\u00020\u0012H\u0004J\u0015\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H%¢\u0006\u0002\u0010\u0014J!\u0010\u0018\u001a\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019\"\u00028\u0000H%¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u0018\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016H%J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\fH\u0004J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0004J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0004J\u0017\u0010#\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\u0014J\u0016\u0010#\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0004J\u0010\u0010$\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%H\u0004J\u0019\u0010&\u001a\u0004\u0018\u00018\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0004¢\u0006\u0002\u0010'J \u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0004J0\u0010)\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0004J(\u0010-\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0004J(\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0004J\u0018\u0010/\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0004J\u0010\u00100\u001a\u00020+2\u0006\u0010!\u001a\u00020\"H\u0004J\b\u00101\u001a\u00020+H\u0004J\u0018\u00102\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%2\u0006\u0010!\u001a\u00020\"H\u0004J\u0017\u00103\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u0014J\u0015\u00104\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H%¢\u0006\u0002\u0010\u0014J!\u00104\u001a\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0019\"\u00028\u0000H%¢\u0006\u0002\u0010\u001aJ\u0018\u00104\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016H%J\u0018\u00105\u001a\u00020\f2\u0006\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\fH\u0002J\u0015\u00107\u001a\u00028\u00002\u0006\u0010!\u001a\u000208H%¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020;2\u0006\u0010!\u001a\u000208H%J\u0010\u0010<\u001a\u00020+2\u0006\u0010!\u001a\u000208H%J\u0018\u0010=\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%2\u0006\u0010!\u001a\u000208H%J\u0017\u0010>\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\u0014J\u0017\u0010?\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\u0014J\u0018\u0010?\u001a\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016H\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006@"}, d2 = {"Lcom/component/dxdatabase/lib/base/DbBaseDao;", ExifInterface.LONGITUDE_EAST, "Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;", "", "()V", "beanType", "Ljava/lang/reflect/Type;", "getBeanType", "()Ljava/lang/reflect/Type;", "entityType", "getEntityType", "tableName", "", "getTableName", "()Ljava/lang/String;", "setTableName", "(Ljava/lang/String;)V", "addToEntity", "", "t", "(Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;)V", "ts", "", "deleteAllToEntity", "deleteBean", "", "([Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;)V", "deleteByIdToEntity", TtmlNode.ATTR_ID, "deleteByParamsToEntity", "key", "value", "deleteQueryToEntity", "query", "Lcom/component/dxdatabase/lib/DbQuery;", "deleteToEntity", "findAllToEntity", "", "findByIdToEntity", "(Ljava/lang/String;)Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;", "findByKeyToEntity", "findByLimitToEntity", "limit", "", TypedValues.CycleType.S_WAVE_OFFSET, "findByOrderAscToEntity", "findByOrderDescToEntity", "findCountByKeyToEntity", "findCountByQueryToEntity", "findCountToEntity", "findQueryToEntity", "initAddToEntity", "insertBean", "queryAppend", "querySql", "queryBySql", "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;", "queryCursorBySql", "Landroid/database/Cursor;", "queryIntBySql", "queryListBySql", "updateOrAddToEntity", "updateToEntity", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class uw<E extends DbBaseEntity> {

    @NotNull
    public final Type a;

    @NotNull
    public final Type b;

    @Nullable
    public String c;

    public uw() {
        Type genericSuperclass = getClass().getSuperclass().getGenericSuperclass();
        Intrinsics.checkNotNullExpressionValue(genericSuperclass, "this.javaClass.superclass.genericSuperclass");
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        Intrinsics.checkNotNullExpressionValue(type, "params[0]");
        this.a = type;
        Type type2 = actualTypeArguments[1];
        Intrinsics.checkNotNullExpressionValue(type2, "params[1]");
        this.b = type2;
        Intrinsics.checkNotNull(type2, "null cannot be cast to non-null type java.lang.Class<E of com.component.dxdatabase.lib.base.DbBaseDao>");
        this.c = ((Class) type2).getSimpleName();
    }

    public final void a(@Nullable E e) {
        if (e == null) {
            return;
        }
        n(e);
        o(e);
    }

    public final void b() {
        s(new SimpleSQLiteQuery("DELETE FROM " + this.c));
    }

    @Delete
    public abstract void c(@NotNull E e);

    @Delete
    public abstract void d(@Nullable Collection<? extends E> collection);

    public final void e(@NotNull tw query) {
        Intrinsics.checkNotNullParameter(query, "query");
        String a = query.getA();
        if (a == null || a.length() == 0) {
            return;
        }
        s(new SimpleSQLiteQuery("DELETE FROM " + this.c + " WHERE " + query.getA(), query.f()));
    }

    public final void f(@Nullable E e) {
        if (e == null) {
            return;
        }
        c(e);
    }

    public final void g(@NotNull Collection<? extends E> ts) {
        Intrinsics.checkNotNullParameter(ts, "ts");
        if (ts.isEmpty()) {
            return;
        }
        d(ts);
    }

    @Nullable
    public final List<E> h() {
        try {
            List<E> listT = t(new SimpleSQLiteQuery("SELECT * FROM " + this.c));
            if (listT == null) {
                return null;
            }
            if (listT.isEmpty()) {
                return null;
            }
            return listT;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final E i(@Nullable String str) {
        if (fe0.a(str)) {
            return null;
        }
        return (E) r(new SimpleSQLiteQuery("SELECT * FROM " + this.c + " WHERE id = '" + str + '\''));
    }

    public final int j(@NotNull tw query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return s(new SimpleSQLiteQuery(q(query, "SELECT COUNT(id) FROM " + this.c), query.f()));
    }

    @Nullable
    public final List<E> k(@NotNull tw query) {
        Intrinsics.checkNotNullParameter(query, "query");
        String a = query.getA();
        if (a == null || a.length() == 0) {
            return null;
        }
        return t(new SimpleSQLiteQuery(q(query, "SELECT * FROM " + this.c), query.f()));
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final Type getA() {
        return this.a;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final Type getB() {
        return this.b;
    }

    public final void n(E e) {
        if (e == null) {
            return;
        }
        String id = e.getId();
        if (id == null || id.length() == 0) {
            String strD = rd0.d();
            Intrinsics.checkNotNullExpressionValue(strD, "getUUID()");
            e.setId(strD);
        }
        if (e.getCreated() == null) {
            e.setCreated(new Date());
        }
        e.setUpdated(new Date());
    }

    @Insert(onConflict = 1)
    public abstract void o(@NotNull E e);

    @Insert(onConflict = 1)
    public abstract void p(@Nullable Collection<? extends E> collection);

    public final String q(tw twVar, String str) {
        String a = twVar.getA();
        if (a != null) {
            str = str + " WHERE " + a;
        }
        String d = twVar.getD();
        if (d != null) {
            str = str + " GROUP BY " + d;
        }
        String e = twVar.getE();
        if (e != null) {
            str = str + " ORDER BY " + e;
        }
        String c = twVar.getC();
        if (c != null) {
            str = str + " HAVING " + c;
        }
        Integer f = twVar.getF();
        if (f != null) {
            str = str + " LIMIT " + f.intValue();
        }
        Integer g = twVar.getG();
        if (g == null) {
            return str;
        }
        return str + " OFFSET " + g.intValue();
    }

    @RawQuery
    @NotNull
    public abstract E r(@NotNull SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery
    public abstract int s(@NotNull SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery
    @Nullable
    public abstract List<E> t(@NotNull SupportSQLiteQuery supportSQLiteQuery);

    public final void u(@Nullable E e) {
        if (e == null) {
            return;
        }
        String id = e.getId();
        if ((id == null || id.length() == 0) || i(e.getId()) == null) {
            a(e);
        } else {
            v(e);
        }
    }

    public final void v(@Nullable E e) {
        if (e == null) {
            return;
        }
        n(e);
        o(e);
    }

    public final void w(@Nullable Collection<? extends E> collection) {
        if (collection != null) {
            try {
                if (collection.isEmpty()) {
                    return;
                }
                Iterator<? extends E> it = collection.iterator();
                while (it.hasNext()) {
                    n(it.next());
                }
                p(collection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
