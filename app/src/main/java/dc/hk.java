package dc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.net.RFC1522Codec;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class hk implements fk {
    public final Map<String, List<gk>> b;
    public volatile Map<String, String> c;

    /* compiled from: LazyHeaders.java */
    public static final class a {
        public static final String b;
        public static final Map<String, List<gk>> c;
        public Map<String, List<gk>> a = c;

        static {
            String strB = b();
            b = strB;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strB)) {
                map.put("User-Agent", Collections.singletonList(new b(strB)));
            }
            c = Collections.unmodifiableMap(map);
        }

        @VisibleForTesting
        public static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append(RFC1522Codec.SEP);
                }
            }
            return sb.toString();
        }

        public hk a() {
            return new hk(this.a);
        }
    }

    /* compiled from: LazyHeaders.java */
    public static final class b implements gk {

        @NonNull
        public final String a;

        public b(@NonNull String str) {
            this.a = str;
        }

        @Override // dc.gk
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + '\'' + MessageFormatter.DELIM_STOP;
        }
    }

    public hk(Map<String, List<gk>> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    @NonNull
    public final String a(@NonNull List<gk> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String strA = list.get(i).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public final Map<String, String> b() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<gk>> entry : this.b.entrySet()) {
            String strA = a(entry.getValue());
            if (!TextUtils.isEmpty(strA)) {
                map.put(entry.getKey(), strA);
            }
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof hk) {
            return this.b.equals(((hk) obj).b);
        }
        return false;
    }

    @Override // dc.fk
    public Map<String, String> getHeaders() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.c;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.b + MessageFormatter.DELIM_STOP;
    }
}
