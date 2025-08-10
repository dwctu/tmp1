package dc;

import com.broadcom.bt.util.io.IOUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import okhttp3.internal.Util;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: Headers.java */
/* loaded from: classes5.dex */
public final class qc4 {
    public final String[] a;

    /* compiled from: Headers.java */
    public static final class a {
        public final List<String> a = new ArrayList(20);

        public a a(String str, String str2) {
            qc4.a(str);
            qc4.b(str2, str);
            d(str, str2);
            return this;
        }

        public a b(qc4 qc4Var) {
            int iH = qc4Var.h();
            for (int i = 0; i < iH; i++) {
                d(qc4Var.e(i), qc4Var.j(i));
            }
            return this;
        }

        public a c(String str) {
            int iIndexOf = str.indexOf(SignatureImpl.INNER_SEP, 1);
            if (iIndexOf != -1) {
                d(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
                return this;
            }
            if (str.startsWith(SignatureImpl.INNER_SEP)) {
                d("", str.substring(1));
                return this;
            }
            d("", str);
            return this;
        }

        public a d(String str, String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }

        public a e(String str, String str2) {
            qc4.a(str);
            d(str, str2);
            return this;
        }

        public qc4 f() {
            return new qc4(this);
        }

        public String g(String str) {
            for (int size = this.a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.a.get(size))) {
                    return this.a.get(size + 1);
                }
            }
            return null;
        }

        public a h(String str) {
            int i = 0;
            while (i < this.a.size()) {
                if (str.equalsIgnoreCase(this.a.get(i))) {
                    this.a.remove(i);
                    this.a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public a i(String str, String str2) {
            qc4.a(str);
            qc4.b(str2, str);
            h(str);
            d(str, str2);
            return this;
        }
    }

    public qc4(a aVar) {
        List<String> list = aVar.a;
        this.a = (String[]) list.toArray(new String[list.size()]);
    }

    public static void a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= ' ' || cCharAt >= 127) {
                throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
            }
        }
    }

    public static void b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str));
            }
        }
    }

    public static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static qc4 g(String... strArr) {
        Objects.requireNonNull(strArr, "namesAndValues == null");
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            a(str);
            b(str2, str);
        }
        return new qc4(strArr2);
    }

    public String c(String str) {
        return d(this.a, str);
    }

    public String e(int i) {
        return this.a[i * 2];
    }

    public boolean equals(Object obj) {
        return (obj instanceof qc4) && Arrays.equals(((qc4) obj).a, this.a);
    }

    public a f() {
        a aVar = new a();
        Collections.addAll(aVar.a, this.a);
        return aVar;
    }

    public int h() {
        return this.a.length / 2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public Map<String, List<String>> i() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iH = h();
        for (int i = 0; i < iH; i++) {
            String lowerCase = e(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(j(i));
        }
        return treeMap;
    }

    public String j(int i) {
        return this.a[(i * 2) + 1];
    }

    public List<String> k(String str) {
        int iH = h();
        ArrayList arrayList = null;
        for (int i = 0; i < iH; i++) {
            if (str.equalsIgnoreCase(e(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(j(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iH = h();
        for (int i = 0; i < iH; i++) {
            sb.append(e(i));
            sb.append(": ");
            sb.append(j(i));
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        return sb.toString();
    }

    public qc4(String[] strArr) {
        this.a = strArr;
    }
}
