package dc;

import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: IBtData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H&J\u0018\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\nH&J\u0018\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\nH&¨\u0006\f"}, d2 = {"Lcom/wear/component/dxtoy/bluetooth/data/IBtDataNowLinked;", "", "getNowLinkedToysMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/wear/bean/Toy;", "getNowToyAddress", "", "getNowToys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNowToysSelectedList", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface vp1 {
    @NotNull
    ConcurrentHashMap<String, Toy> g();

    @NotNull
    List<String> m();

    @NotNull
    ArrayList<Toy> o();

    @NotNull
    ArrayList<Toy> p();
}
