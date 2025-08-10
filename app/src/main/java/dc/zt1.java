package dc;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.util.WearUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: AnalyticeEvent.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0007¨\u0006\b"}, d2 = {"addAnalyticsEventId", "", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "eventId", "", "keyMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class zt1 {
    public static final void a(@NotNull FirebaseAnalytics firebaseAnalytics, @NotNull String eventId, @NotNull HashMap<String, String> keyMap) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "<this>");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(keyMap, "keyMap");
        WearUtils.x.p(firebaseAnalytics, eventId, keyMap);
    }

    public static /* synthetic */ void b(FirebaseAnalytics firebaseAnalytics, String str, HashMap map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = new HashMap();
        }
        a(firebaseAnalytics, str, map);
    }
}
