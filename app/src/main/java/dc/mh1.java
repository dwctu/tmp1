package dc;

import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Comparator;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Frame.kt */
/* loaded from: classes3.dex */
public final class mh1 {
    public int a;

    @NotNull
    public final ArrayList<kh1> b;

    /* compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((kh1) t).e()), Integer.valueOf(((kh1) t2).e()));
        }
    }

    public mh1(@NotNull JSONObject json) throws JSONException {
        JSONObject jSONObject;
        Intrinsics.checkParameterIsNotNull(json, "json");
        this.b = new ArrayList<>();
        this.a = json.getInt("i");
        JSONArray jSONArray = json.getJSONArray(IconCompat.EXTRA_OBJ);
        int length = jSONArray != null ? jSONArray.length() : 0;
        for (int i = 0; i < length; i++) {
            if (jSONArray != null && (jSONObject = jSONArray.getJSONObject(i)) != null) {
                this.b.add(new kh1(this.a, jSONObject));
            }
        }
        ArrayList<kh1> arrayList = this.b;
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new a());
        }
    }

    public final int a() {
        return this.a;
    }

    @NotNull
    public final ArrayList<kh1> b() {
        return this.b;
    }
}
