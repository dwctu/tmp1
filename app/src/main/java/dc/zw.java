package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.Dao;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import com.component.dxdatabase.lib.bean.BILogDbEntity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: BILogDaoBridge.kt */
@Dao
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 \u00052\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/component/dxdatabase/lib/dao/BILogDaoBridge;", "Lcom/component/dxdatabase/lib/base/DbBaseDaoBridge;", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "Lcom/component/dxdatabase/lib/bean/BILogDbEntity;", "()V", "Companion", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class zw extends vw<BILogDbBean, BILogDbEntity> {

    @NotNull
    public static final a e = new a(null);

    /* compiled from: BILogDaoBridge.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\t\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\f\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\u0014\u0010\r\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\u0014\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001cJ\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010!\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\bJ\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fJ\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000fJ\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\u0006\u0010'\u001a\u00020%J\u0012\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0012\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J.\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010'\u001a\u00020%2\u0006\u0010-\u001a\u00020%J.\u0010.\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010'\u001a\u00020%2\u0006\u0010-\u001a\u00020%J&\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010'\u001a\u00020%2\u0006\u0010-\u001a\u00020%J&\u00100\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010'\u001a\u00020%2\u0006\u0010-\u001a\u00020%J&\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010'\u001a\u00020%2\u0006\u0010-\u001a\u00020%J&\u00102\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010'\u001a\u00020%2\u0006\u0010-\u001a\u00020%J\u0006\u00103\u001a\u00020%J\u0016\u00104\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\u000e\u00105\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u00106\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u00107\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0016\u0010:\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\u0010\u0010;\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010<\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010=\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010=\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¨\u0006>"}, d2 = {"Lcom/component/dxdatabase/lib/dao/BILogDaoBridge$Companion;", "", "()V", "add", "", "bean", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "ts", "", "addToEntity", "t", "Lcom/component/dxdatabase/lib/bean/BILogDbEntity;", "delete", "deleteAccountCodeList", "removeList", "", "deleteAll", "deleteAllToEntity", "deleteById", TtmlNode.ATTR_ID, "", "deleteByIdToEntity", "deleteByParams", "key", "value", "deleteByParamsToEntity", "deleteLogNoBlackList", "logNoBlackList", "", "deleteQuery", "query", "Lcom/component/dxdatabase/lib/DbQuery;", "deleteQueryToEntity", "deleteToEntity", "findAll", "findAllToEntity", "findAllowUploadCount", "", "findAllowUploadData", "limit", "findById", "findByIdToEntity", "findByKey", "findByKeyToEntity", "findByLimit", TypedValues.CycleType.S_WAVE_OFFSET, "findByLimitToEntity", "findByOrderAsc", "findByOrderAscToEntity", "findByOrderDesc", "findByOrderDescToEntity", "findCount", "findCountByKey", "findCountByQuery", "findQuery", "findQueryToEntity", "getDao", "Lcom/component/dxdatabase/lib/dao/BILogDaoBridge;", DiscoverItems.Item.UPDATE_ACTION, "updateOrAdd", "updateOrAddToEntity", "updateToEntity", "hytto-apps.android.components.base.dxdatabase"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull BILogDbBean bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            k().x(bean);
        }

        public final void b(@Nullable Collection<BILogDbBean> collection) {
            k().z(collection);
        }

        public final void c(@NotNull List<BILogDbBean> removeList) {
            Intrinsics.checkNotNullParameter(removeList, "removeList");
            if (removeList.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(removeList, 10));
            Iterator<T> it = removeList.iterator();
            while (it.hasNext()) {
                arrayList.add(((BILogDbBean) it.next()).getAccountCode());
            }
            Object[] array = arrayList.toArray(new Object[0]);
            tw twVar = new tw();
            twVar.h("accountCode", array);
            f(twVar);
        }

        public final void d() {
            k().A();
        }

        public final void e(@NotNull List<String> logNoBlackList) {
            Intrinsics.checkNotNullParameter(logNoBlackList, "logNoBlackList");
            tw twVar = new tw();
            twVar.h("logNo", logNoBlackList.toArray(new Object[0]));
            f(twVar);
        }

        public final void f(@NotNull tw query) {
            Intrinsics.checkNotNullParameter(query, "query");
            k().B(query);
        }

        public final int g() {
            tw twVar = new tw();
            twVar.i("nextUploadTime", Long.valueOf(System.currentTimeMillis()));
            return i(twVar);
        }

        @Nullable
        public final List<BILogDbBean> h(int i) {
            tw twVar = new tw();
            twVar.i("nextUploadTime", Long.valueOf(System.currentTimeMillis()));
            twVar.j(Integer.valueOf(i));
            return j(twVar);
        }

        public final int i(@NotNull tw query) {
            Intrinsics.checkNotNullParameter(query, "query");
            return k().D(query);
        }

        @Nullable
        public final List<BILogDbBean> j(@NotNull tw query) {
            Intrinsics.checkNotNullParameter(query, "query");
            return k().E(query);
        }

        public final zw k() {
            return bx.c().i();
        }

        public final void l(@Nullable Collection<BILogDbBean> collection) {
            k().K(collection);
        }
    }
}
