package dc;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Event.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/wear/main/control/Event;", "", "name", "Lcom/wear/main/control/EventType;", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "(Lcom/wear/main/control/EventType;Ljava/util/Map;)V", "getName", "()Lcom/wear/main/control/EventType;", "setName", "(Lcom/wear/main/control/EventType;)V", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: dc.b22, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class Event {

    /* renamed from: a, reason: from toString */
    @Nullable
    public c22 name;

    /* renamed from: b, reason: from toString */
    @Nullable
    public Map<String, ? extends Object> params;

    public Event() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Event(@Nullable c22 c22Var, @Nullable Map<String, ? extends Object> map) {
        this.name = c22Var;
        this.params = map;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final c22 getName() {
        return this.name;
    }

    @Nullable
    public final Map<String, Object> b() {
        return this.params;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Event)) {
            return false;
        }
        Event event = (Event) other;
        return this.name == event.name && Intrinsics.areEqual(this.params, event.params);
    }

    public int hashCode() {
        c22 c22Var = this.name;
        int iHashCode = (c22Var == null ? 0 : c22Var.hashCode()) * 31;
        Map<String, ? extends Object> map = this.params;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Event(name=" + this.name + ", params=" + this.params + ')';
    }

    public /* synthetic */ Event(c22 c22Var, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : c22Var, (i & 2) != 0 ? new LinkedHashMap() : map);
    }
}
