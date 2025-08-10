package dc;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* compiled from: Challenge.java */
/* loaded from: classes5.dex */
public final class dc4 {
    public final String a;
    public final Map<String, String> b;

    public dc4(String str, Map<String, String> map) {
        Objects.requireNonNull(str, "scheme == null");
        Objects.requireNonNull(map, "authParams == null");
        this.a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey() == null ? null : entry.getKey().toLowerCase(Locale.US), entry.getValue());
        }
        this.b = Collections.unmodifiableMap(linkedHashMap);
    }

    public boolean equals(Object obj) {
        if (obj instanceof dc4) {
            dc4 dc4Var = (dc4) obj;
            if (dc4Var.a.equals(this.a) && dc4Var.b.equals(this.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.a.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return this.a + " authParams=" + this.b;
    }
}
