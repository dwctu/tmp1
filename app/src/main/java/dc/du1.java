package dc;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Collections.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005\u001a.\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b\u001a\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¨\u0006\n"}, d2 = {"contains", "", "", "", "value", "([Ljava/lang/String;Ljava/lang/String;)Z", "toArrayPair", "Lkotlin/Pair;", "", "toStringPair", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class du1 {
    public static final boolean a(@Nullable String[] strArr, @NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (strArr != null) {
            for (String str : strArr) {
                if (Intrinsics.areEqual(str, value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @NotNull
    public static final Pair<String[], String[]> b(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new Pair<>(map.keySet().toArray(new String[0]), map.values().toArray(new String[0]));
    }

    @NotNull
    public static final Pair<String, String> c(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new Pair<>(CollectionsKt___CollectionsKt.joinToString$default(map.keySet(), ",", null, null, 0, null, null, 62, null), CollectionsKt___CollectionsKt.joinToString$default(map.values(), ",", null, null, 0, null, null, 62, null));
    }
}
