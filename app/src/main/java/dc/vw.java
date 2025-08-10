package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.component.dxdatabase.lib.base.bean.DbBaseBean;
import com.component.dxdatabase.lib.base.bean.DbBaseEntity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: DbBaseDaoBridge.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 5*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005:\u00015B\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\nJ\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0004J\u0017\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\nJ\u0018\u0010\r\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0004J\b\u0010\u000e\u001a\u00020\bH\u0004J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0004J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0004J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0019H\u0004J\u0019\u0010\u001a\u001a\u0004\u0018\u00018\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0004¢\u0006\u0002\u0010\u001bJ \u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0004J0\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0004J(\u0010!\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0004J(\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0004J\b\u0010#\u001a\u00020\u001fH\u0004J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0004J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\u0018\u0010&\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\u001c\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020+H\u0002J\u0017\u0010,\u001a\u0004\u0018\u00018\u00012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010-J\u0017\u0010.\u001a\u0004\u0018\u00018\u00002\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010/J\"\u00100\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00192\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00101\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00192\b\u0010)\u001a\u0004\u0018\u00010(J\u0018\u00102\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00192\b\u0010)\u001a\u0004\u0018\u00010(J\u0017\u00103\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\nJ\u0018\u00103\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0004J\u0017\u00104\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0004¢\u0006\u0002\u0010\n¨\u00066"}, d2 = {"Lcom/component/dxdatabase/lib/base/DbBaseDaoBridge;", "B", "Lcom/component/dxdatabase/lib/base/bean/DbBaseBean;", ExifInterface.LONGITUDE_EAST, "Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;", "Lcom/component/dxdatabase/lib/base/DbBaseDao;", "()V", "add", "", "t", "(Lcom/component/dxdatabase/lib/base/bean/DbBaseBean;)V", "ts", "", "delete", "deleteAll", "deleteById", TtmlNode.ATTR_ID, "", "deleteByParams", "key", "value", "deleteQuery", "query", "Lcom/component/dxdatabase/lib/DbQuery;", "findAll", "", "findById", "(Ljava/lang/String;)Lcom/component/dxdatabase/lib/base/bean/DbBaseBean;", "findByKey", "findByLimit", "limit", "", TypedValues.CycleType.S_WAVE_OFFSET, "findByOrderAsc", "findByOrderDesc", "findCount", "findCountByKey", "findCountByQuery", "findQuery", "model2T", "", "model", "type", "Ljava/lang/reflect/Type;", "modelB2E", "(Ljava/lang/Object;)Lcom/component/dxdatabase/lib/base/bean/DbBaseEntity;", "modelE2B", "(Ljava/lang/Object;)Lcom/component/dxdatabase/lib/base/bean/DbBaseBean;", "modelList2T", "modelListB2E", "modelListE2B", DiscoverItems.Item.UPDATE_ACTION, "updateOrAdd", "Companion", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class vw<B extends DbBaseBean, E extends DbBaseEntity> extends uw<E> {

    @NotNull
    public static final a d = new a(null);

    /* compiled from: DbBaseDaoBridge.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¨\u0006\u0006"}, d2 = {"Lcom/component/dxdatabase/lib/base/DbBaseDaoBridge$Companion;", "", "()V", "initId", "", "t", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Object t) {
            Intrinsics.checkNotNullParameter(t, "t");
            if (t instanceof DbBaseBean) {
                DbBaseBean dbBaseBean = (DbBaseBean) t;
                String id = dbBaseBean.getId();
                if (id == null || id.length() == 0) {
                    dbBaseBean.setId(rd0.d());
                }
                if (dbBaseBean.getCreated() == null) {
                    dbBaseBean.setCreated(new Date());
                }
                dbBaseBean.setUpdated(new Date());
                return;
            }
            if (!(t instanceof DbBaseEntity)) {
                if (t instanceof Collection) {
                    for (Object obj : (Iterable) t) {
                        if (obj != null) {
                            vw.d.a(obj);
                        }
                    }
                    return;
                }
                return;
            }
            DbBaseEntity dbBaseEntity = (DbBaseEntity) t;
            String id2 = dbBaseEntity.getId();
            if (id2 == null || id2.length() == 0) {
                String strD = rd0.d();
                Intrinsics.checkNotNullExpressionValue(strD, "getUUID()");
                dbBaseEntity.setId(strD);
            }
            if (dbBaseEntity.getCreated() == null) {
                dbBaseEntity.setCreated(new Date());
            }
            dbBaseEntity.setUpdated(new Date());
        }
    }

    public final void A() {
        b();
    }

    public final void B(@NotNull tw query) {
        Intrinsics.checkNotNullParameter(query, "query");
        e(query);
    }

    @Nullable
    public final List<B> C() {
        return J(h());
    }

    public final int D(@NotNull tw query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return j(query);
    }

    @Nullable
    public final List<B> E(@NotNull tw query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return J(k(query));
    }

    public final Object F(Object obj, Type type) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof String) {
                return (Void) xd0.e((String) obj, type);
            }
            d.a(obj);
            return xd0.e(xd0.j(obj), type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final E G(@Nullable Object obj) {
        Object objF = F(obj, getB());
        if (objF instanceof DbBaseEntity) {
            return (E) objF;
        }
        return null;
    }

    public final List<Object> H(Object obj, Type type) {
        List<Object> list;
        if (obj != null) {
            d.a(obj);
        }
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof String) {
                Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
                list = (List) xd0.e((String) obj, new cx((Class) type));
            } else {
                String strJ = xd0.j(obj);
                Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
                list = (List) xd0.e(strJ, new cx((Class) type));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final List<E> I(@Nullable Object obj) {
        List<E> list = (List<E>) H(obj, getB());
        if (TypeIntrinsics.isMutableList(list)) {
            return list;
        }
        return null;
    }

    @Nullable
    public final List<B> J(@Nullable Object obj) {
        List<B> list = (List<B>) H(obj, getA());
        if (TypeIntrinsics.isMutableList(list)) {
            return list;
        }
        return null;
    }

    public final void K(@Nullable Collection<? extends B> collection) {
        w(I(collection));
    }

    public final void L(@Nullable B b) {
        u(G(b));
    }

    public final void x(@Nullable B b) {
        a(G(b));
    }

    public final void y(@Nullable B b) {
        f(G(b));
    }

    public final void z(@Nullable Collection<? extends B> collection) {
        List<E> listI = I(collection);
        if (!(listI instanceof Collection)) {
            listI = null;
        }
        if (listI != null) {
            g(listI);
        }
    }
}
