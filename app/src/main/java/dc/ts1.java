package dc;

import com.wear.bean.ToyType;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* compiled from: OldToyTypeDaoImpl.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/wear/component/dxtoy/db/impl/OldToyTypeDaoImpl;", "Lcom/wear/component/dxtoy/db/interfaces/IToyTypeDao;", "()V", "oldToyTypeDao", "Lcom/wear/component/dxtoy/db/OldToyTypeDao;", "getOldToyTypeDao", "()Lcom/wear/component/dxtoy/db/OldToyTypeDao;", "oldToyTypeDao$delegate", "Lkotlin/Lazy;", "add", "", "t", "Lcom/wear/bean/ToyType;", "clearTable", "findAll", "", "findToyType", MultipleAddresses.Address.ELEMENT, "", "isExistToyType", "", "totalNumber", "", DiscoverItems.Item.UPDATE_ACTION, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ts1 implements vs1 {

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: OldToyTypeDaoImpl.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/component/dxtoy/db/OldToyTypeDao;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<os1> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final os1 invoke() {
            return new os1();
        }
    }

    public final os1 a() {
        return (os1) this.a.getValue();
    }

    @Override // dc.vs1
    public void add(@NotNull ToyType t) {
        Intrinsics.checkNotNullParameter(t, "t");
        a().add((os1) t);
    }

    @Override // dc.vs1
    public void clearTable() {
        a().cleanDefine();
    }

    @Override // dc.vs1
    @Nullable
    public List<ToyType> findAll() {
        return a().findAll();
    }

    @Override // dc.vs1
    @Nullable
    public ToyType findToyType(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return a().a(address);
    }

    @Override // dc.vs1
    public boolean isExistToyType(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return a().b(address);
    }

    @Override // dc.vs1
    public int totalNumber() {
        return a().c();
    }

    @Override // dc.vs1
    public void update(@NotNull ToyType t) {
        Intrinsics.checkNotNullParameter(t, "t");
        a().update((os1) t);
    }
}
