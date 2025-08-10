package dc;

import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: IBtData.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0004H&J\u0018\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\nH&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/data/IBtDataSearch;", "", "getSearchLinkToyMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/wear/bean/Toy;", "getSearchToy", MultipleAddresses.Address.ELEMENT, "getSearchToys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "removeAllSearchToys", "", "removeSearchToy", "toy", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface wp1 {
    @NotNull
    ConcurrentHashMap<String, Toy> d();

    void h();

    @Nullable
    Toy n(@NotNull String str);

    @NotNull
    ArrayList<Toy> q();

    void s(@NotNull Toy toy);
}
