package dc;

import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: NewToyDaoImpl.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0012\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0018"}, d2 = {"Lcom/wear/component/dxtoy/db/impl/NewToyDaoImpl;", "Lcom/wear/component/dxtoy/db/interfaces/IToyDao;", "()V", "add", "", "t", "Lcom/wear/bean/Toy;", "clearTable", "delT", "existToyByEmail", "", "email", "", MultipleAddresses.Address.ELEMENT, "findAll", "", "findByAddress", "findByEmail", DiscoverItems.Item.UPDATE_ACTION, "ts", "updateLedSetting", StreamManagement.Enable.ELEMENT, "", "updateOrAdd", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class qs1 implements us1 {
    @Override // dc.us1
    public void add(@NotNull Toy t) {
        nb0 nb0VarI3;
        Intrinsics.checkNotNullParameter(t, "t");
        if (t.isVirtualToy() || (nb0VarI3 = t.toyProxy.I3()) == null) {
            return;
        }
        nb0VarI3.g0(true);
        String address = t.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "t.address");
        yb0.j(address, nb0VarI3);
    }

    @Override // dc.us1
    public void clearTable() {
    }

    @Override // dc.us1
    public void delT(@NotNull Toy t) {
        Intrinsics.checkNotNullParameter(t, "t");
        nb0 nb0VarI3 = t.toyProxy.I3();
        if (nb0VarI3 != null) {
            if (nb0VarI3.getIsVirtualToy()) {
                String address = t.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "t.address");
                yb0.c(address);
            } else {
                nb0VarI3.g0(false);
                String address2 = t.getAddress();
                Intrinsics.checkNotNullExpressionValue(address2, "t.address");
                yb0.j(address2, nb0VarI3);
            }
        }
    }

    @Override // dc.us1
    public boolean existToyByEmail(@Nullable String email, @NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return yb0.f().containsKey(address);
    }

    @Override // dc.us1
    @NotNull
    public List<Toy> findAll() {
        ConcurrentHashMap<String, nb0> concurrentHashMapF = yb0.f();
        if (concurrentHashMapF.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Collection<nb0> collectionValues = concurrentHashMapF.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "toyMap.values");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(new Toy((nb0) it.next()));
        }
        return arrayList;
    }

    @Override // dc.us1
    @Nullable
    public Toy findByAddress(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        nb0 nb0Var = yb0.f().get(address);
        if (nb0Var != null) {
            return new Toy(nb0Var);
        }
        return null;
    }

    @Override // dc.us1
    @NotNull
    public List<Toy> findByEmail(@Nullable String email) {
        return findAll();
    }

    @Override // dc.us1
    public void update(@NotNull Toy t) {
        Intrinsics.checkNotNullParameter(t, "t");
        if (t.isVirtualToy()) {
            return;
        }
        updateOrAdd(t);
    }

    @Override // dc.us1
    public void update(@NotNull List<? extends Toy> ts) {
        Intrinsics.checkNotNullParameter(ts, "ts");
    }

    @Override // dc.us1
    public void updateLedSetting(@NotNull String address, int enable) {
        Intrinsics.checkNotNullParameter(address, "address");
        nb0 nb0Var = yb0.f().get(address);
        if (nb0Var != null) {
            nb0Var.X(enable == 1);
            if (nb0Var.getIsVirtualToy()) {
                return;
            }
            yb0.j(address, nb0Var);
        }
    }

    @Override // dc.us1
    public void updateOrAdd(@NotNull Toy t) {
        nb0 nb0VarI3;
        Intrinsics.checkNotNullParameter(t, "t");
        if (t.isVirtualToy() || (nb0VarI3 = t.toyProxy.I3()) == null) {
            return;
        }
        nb0VarI3.g0(true);
        String address = t.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "t.address");
        yb0.j(address, nb0VarI3);
    }
}
