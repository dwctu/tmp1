package dc;

import com.wear.bean.Toy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BtWork.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2 = {"getConnectingMacs", "", "", "Lcom/lovense/btservice/work/BtWork;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class cu1 {
    @NotNull
    public static final List<String> a(@NotNull pc1 pc1Var) {
        Intrinsics.checkNotNullParameter(pc1Var, "<this>");
        ArrayList<Toy> arrayListP = pc1Var.P();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListP, 10));
        Iterator<T> it = arrayListP.iterator();
        while (it.hasNext()) {
            arrayList.add(((Toy) it.next()).getAddress());
        }
        return arrayList;
    }
}
