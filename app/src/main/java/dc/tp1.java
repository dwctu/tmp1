package dc;

import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: BtDataProxy.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0016J\u0018\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\fH\u0016J\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\fH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u000e\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/data/BtDataProxy;", "Lcom/wear/component/dxtoy/bluetooth/data/IBtData;", "()V", "btData", "getNowLinkedToysMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/wear/bean/Toy;", "getNowToyAddress", "", "getNowToys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNowToysSelectedList", "getSearchLinkToyMap", "getSearchToy", MultipleAddresses.Address.ELEMENT, "getSearchToys", "removeAllSearchToys", "", "removeSearchToy", "toy", "resetUseNew", "isUseNew", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class tp1 implements up1 {

    @NotNull
    public up1 a = a(mp1.a.b());

    @NotNull
    public final up1 a(boolean z) {
        up1 xp1Var = z ? new xp1() : new yp1();
        this.a = xp1Var;
        return xp1Var;
    }

    @Override // dc.wp1
    @NotNull
    public ConcurrentHashMap<String, Toy> d() {
        return this.a.d();
    }

    @Override // dc.vp1
    @NotNull
    public ConcurrentHashMap<String, Toy> g() {
        return this.a.g();
    }

    @Override // dc.wp1
    public void h() {
        this.a.h();
    }

    @Override // dc.vp1
    @NotNull
    public List<String> m() {
        return this.a.m();
    }

    @Override // dc.wp1
    @Nullable
    public Toy n(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return this.a.n(address);
    }

    @Override // dc.vp1
    @NotNull
    public ArrayList<Toy> o() {
        return this.a.o();
    }

    @Override // dc.vp1
    @NotNull
    public ArrayList<Toy> p() {
        return this.a.p();
    }

    @Override // dc.wp1
    @NotNull
    public ArrayList<Toy> q() {
        return this.a.q();
    }

    @Override // dc.wp1
    public void s(@NotNull Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        this.a.s(toy);
    }
}
