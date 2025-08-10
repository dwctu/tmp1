package dc;

import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: OldBtData.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\u0018\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\fj\b\u0012\u0004\u0012\u00020\u0006`\rH\u0016J\u0018\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\fj\b\u0012\u0004\u0012\u00020\u0006`\rH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\fj\b\u0012\u0004\u0012\u00020\u0006`\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/data/OldBtData;", "Lcom/wear/component/dxtoy/bluetooth/data/IBtData;", "()V", "nowLinkedToysMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/wear/bean/Toy;", "searchLinkToyMap", "getNowLinkedToysMap", "getNowToyAddress", "", "getNowToys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNowToysSelectedList", "getSearchLinkToyMap", "getSearchToy", MultipleAddresses.Address.ELEMENT, "getSearchToys", "removeAllSearchToys", "", "removeSearchToy", "toy", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class yp1 implements up1 {

    @NotNull
    public final ConcurrentHashMap<String, Toy> a = new ConcurrentHashMap<>();

    @NotNull
    public final ConcurrentHashMap<String, Toy> b = new ConcurrentHashMap<>();

    @Override // dc.wp1
    @NotNull
    public ConcurrentHashMap<String, Toy> d() {
        return this.b;
    }

    @Override // dc.vp1
    @NotNull
    public ConcurrentHashMap<String, Toy> g() {
        return this.a;
    }

    @Override // dc.wp1
    public void h() {
        this.b.clear();
    }

    @Override // dc.vp1
    @NotNull
    public List<String> m() {
        return new ArrayList(this.a.keySet());
    }

    @Override // dc.wp1
    @Nullable
    public Toy n(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return this.b.get(address);
    }

    @Override // dc.vp1
    @NotNull
    public ArrayList<Toy> o() {
        return new ArrayList<>(this.a.values());
    }

    @Override // dc.vp1
    @NotNull
    public ArrayList<Toy> p() {
        Collection<Toy> collectionValues = this.a.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "nowLinkedToysMap.values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((Toy) obj).isSelect()) {
                arrayList.add(obj);
            }
        }
        return new ArrayList<>(arrayList);
    }

    @Override // dc.wp1
    @NotNull
    public ArrayList<Toy> q() {
        return new ArrayList<>(this.b.values());
    }

    @Override // dc.wp1
    public void s(@NotNull Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        this.b.remove(toy.getAddress());
    }
}
