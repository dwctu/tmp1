package dc;

import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: OldToyDaoImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\u0018\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/wear/component/dxtoy/db/impl/OldToyDaoImpl;", "Lcom/wear/component/dxtoy/db/interfaces/IToyDao;", "()V", "oldToyDao", "Lcom/wear/component/dxtoy/db/OldToyDao;", "getOldToyDao", "()Lcom/wear/component/dxtoy/db/OldToyDao;", "oldToyDao$delegate", "Lkotlin/Lazy;", "add", "", "t", "Lcom/wear/bean/Toy;", "clearTable", "delT", "existToyByEmail", "", "email", "", MultipleAddresses.Address.ELEMENT, "findAll", "", "findByAddress", "findByEmail", DiscoverItems.Item.UPDATE_ACTION, "ts", "updateLedSetting", StreamManagement.Enable.ELEMENT, "", "updateOrAdd", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ss1 implements us1 {

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: OldToyDaoImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/component/dxtoy/db/OldToyDao;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<ns1> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ns1 invoke() {
            return new ns1();
        }
    }

    public final ns1 a() {
        return (ns1) this.a.getValue();
    }

    @Override // dc.us1
    public void add(@NotNull Toy t) {
        Intrinsics.checkNotNullParameter(t, "t");
        a().add((ns1) t.toyProxy.J3());
    }

    @Override // dc.us1
    public void clearTable() {
        a().a();
    }

    @Override // dc.us1
    public void delT(@NotNull Toy t) {
        Intrinsics.checkNotNullParameter(t, "t");
        a().delT(t.toyProxy.J3());
    }

    @Override // dc.us1
    public boolean existToyByEmail(@Nullable String email, @NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return a().b(email, address);
    }

    @Override // dc.us1
    @NotNull
    public List<Toy> findAll() {
        List<ws1> oldToyList = a().findAll();
        if (oldToyList == null || oldToyList.isEmpty()) {
            return new ArrayList();
        }
        Intrinsics.checkNotNullExpressionValue(oldToyList, "oldToyList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(oldToyList, 10));
        Iterator<T> it = oldToyList.iterator();
        while (it.hasNext()) {
            arrayList.add(new Toy((ws1) it.next()));
        }
        return arrayList;
    }

    @Override // dc.us1
    @Nullable
    public Toy findByAddress(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        ws1 ws1VarC = a().c(address);
        if (ws1VarC != null) {
            return new Toy(ws1VarC);
        }
        return null;
    }

    @Override // dc.us1
    @NotNull
    public List<Toy> findByEmail(@Nullable String email) {
        List<ws1> oldToyList = a().findByEmail(email);
        if (oldToyList == null || oldToyList.isEmpty()) {
            return new ArrayList();
        }
        Intrinsics.checkNotNullExpressionValue(oldToyList, "oldToyList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(oldToyList, 10));
        Iterator<T> it = oldToyList.iterator();
        while (it.hasNext()) {
            arrayList.add(new Toy((ws1) it.next()));
        }
        return arrayList;
    }

    @Override // dc.us1
    public void update(@NotNull Toy t) {
        Intrinsics.checkNotNullParameter(t, "t");
        a().update((ns1) t.toyProxy.J3());
    }

    @Override // dc.us1
    public void updateLedSetting(@NotNull String address, int enable) {
        Intrinsics.checkNotNullParameter(address, "address");
        a().e(address, enable);
    }

    @Override // dc.us1
    public void updateOrAdd(@NotNull Toy t) {
        Intrinsics.checkNotNullParameter(t, "t");
        a().updateOrAdd(t.toyProxy.J3());
    }

    @Override // dc.us1
    public void update(@NotNull List<? extends Toy> ts) {
        Intrinsics.checkNotNullParameter(ts, "ts");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(ts, 10));
        Iterator<T> it = ts.iterator();
        while (it.hasNext()) {
            arrayList.add(((Toy) it.next()).toyProxy.J3());
        }
        a().update(arrayList);
    }
}
