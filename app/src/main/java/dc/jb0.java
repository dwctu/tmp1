package dc;

import androidx.room.Dao;
import com.component.dxtoy.core.datacenter.db.bean.ToyDbEntity;
import com.component.dxtoy.core.datacenter.db.manager.DbToy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: ToyDaoBridge.kt */
@Dao
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 \u00052\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/component/dxtoy/core/datacenter/db/ToyDaoBridge;", "Lcom/component/dxdatabase/lib/base/DbBaseDaoBridge;", "Lcom/component/dxtoy/core/toy/ToyInfo;", "Lcom/component/dxtoy/core/datacenter/db/bean/ToyDbEntity;", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class jb0 extends vw<nb0, ToyDbEntity> {

    @NotNull
    public static final a e = new a(null);

    /* compiled from: ToyDaoBridge.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\b\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0014\u0010\u0012\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007¨\u0006\u0014"}, d2 = {"Lcom/component/dxtoy/core/datacenter/db/ToyDaoBridge$Companion;", "", "()V", "add", "", "list", "", "Lcom/component/dxtoy/core/toy/ToyInfo;", "delete", "toy", "deleteAll", "findAll", "getDao", "Lcom/component/dxtoy/core/datacenter/db/ToyDaoBridge;", "queryCursorBySql", "Landroid/database/Cursor;", "query", "Landroidx/sqlite/db/SupportSQLiteQuery;", DiscoverItems.Item.UPDATE_ACTION, "updateOrAdd", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull nb0 toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            d().y(toy);
        }

        public final void b() {
            d().A();
        }

        @Nullable
        public final List<nb0> c() {
            return d().C();
        }

        public final jb0 d() {
            return DbToy.a.a().i();
        }

        public final void e(@NotNull List<nb0> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            d().K(list);
        }

        public final void f(@NotNull nb0 toy) {
            Intrinsics.checkNotNullParameter(toy, "toy");
            d().L(toy);
        }
    }
}
