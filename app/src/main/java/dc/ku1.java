package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogUtils.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aW\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u000fj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t`\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003\u001a:\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t\u001aG\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0014\u001aG\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0014\u001a2\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¨\u0006\u0017"}, d2 = {"addS0009Log", "", "pageName", "", "eventId", "eventType", "elementId", "elementType", "elementContent", "", "elementName", TypedValues.TransitionType.S_DURATION, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;)V", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "addS0009LogWithAction", "addS0009LogWithActionDuration", "addS0009LogWithButtonClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;)V", "addS0009LogWithClick", "addS0009LogWithPage", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ku1 {
    public static final void a(@NotNull String pageName, @NotNull String eventId, @Nullable String str, @NotNull String elementId, @Nullable String str2, @Nullable Object obj, @Nullable Object obj2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        HashMap map = new HashMap();
        map.put("page_name", pageName);
        map.put("event_id", eventId);
        if (!(str == null || str.length() == 0)) {
            map.put("event_type", str);
        }
        map.put("element_id", elementId);
        if (!(str2 == null || str2.length() == 0)) {
            map.put("element_type", str2);
        }
        if (obj != null) {
            map.put("element_content", obj);
        }
        if (obj2 != null) {
            map.put("element_name", obj2);
        }
        if (num != null) {
            map.put(TypedValues.TransitionType.S_DURATION, num);
        }
        map.put("toys", cu1.a(pc1.a));
        b(map);
    }

    public static final void b(@NotNull HashMap<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        ye3.e("S0009", map);
    }

    public static /* synthetic */ void c(String str, String str2, String str3, String str4, String str5, Object obj, Object obj2, Integer num, int i, Object obj3) {
        a(str, str2, str3, str4, str5, obj, obj2, (i & 128) != 0 ? null : num);
    }

    public static final void d(@NotNull String pageName, @NotNull String eventId, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        c(pageName, eventId, null, elementId, null, null, null, null, 128, null);
    }

    public static final void e(@NotNull String pageName, @NotNull String eventId, @NotNull String elementId, int i, @Nullable Object obj, @Nullable Object obj2) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        a(pageName, eventId, null, elementId, null, obj2, obj, Integer.valueOf(i));
    }

    public static final void f(@NotNull String pageName, @NotNull String eventId, @NotNull String elementId, @Nullable Object obj, @Nullable Object obj2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        a(pageName, eventId, "click", elementId, "button", obj, obj2, num);
    }

    public static final void h(@NotNull String pageName, @NotNull String eventId, @NotNull String elementId, @Nullable Object obj, @Nullable Object obj2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        a(pageName, eventId, "click", elementId, null, obj, obj2, num);
    }

    public static final void i(@NotNull String pageName, @NotNull String eventId, @NotNull String eventType, @NotNull String elementId, @Nullable String str) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        c(pageName, eventId, eventType, elementId, str, null, null, null, 128, null);
    }

    public static /* synthetic */ void j(String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 16) != 0) {
            str5 = null;
        }
        i(str, str2, str3, str4, str5);
    }
}
