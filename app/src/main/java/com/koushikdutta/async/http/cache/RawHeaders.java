package com.koushikdutta.async.http.cache;

import android.text.TextUtils;
import com.broadcom.bt.util.io.IOUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public final class RawHeaders {
    private static final Comparator<String> FIELD_NAME_COMPARATOR = new Comparator<String>() { // from class: com.koushikdutta.async.http.cache.RawHeaders.1
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    };
    private String responseMessage;
    private String statusLine;
    private final List<String> namesAndValues = new ArrayList(20);
    private int httpMinorVersion = 1;
    private int responseCode = -1;

    public RawHeaders() {
    }

    public static RawHeaders fromMultimap(Map<String, List<String>> map) {
        RawHeaders rawHeaders = new RawHeaders();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (key != null) {
                rawHeaders.addAll(key, value);
            } else if (!value.isEmpty()) {
                rawHeaders.setStatusLine(value.get(value.size() - 1));
            }
        }
        return rawHeaders;
    }

    public static RawHeaders parse(String str) {
        String[] strArrSplit = str.split(IOUtils.LINE_SEPARATOR_UNIX);
        RawHeaders rawHeaders = new RawHeaders();
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            if (!TextUtils.isEmpty(strTrim)) {
                if (rawHeaders.getStatusLine() == null) {
                    rawHeaders.setStatusLine(strTrim);
                } else {
                    rawHeaders.addLine(strTrim);
                }
            }
        }
        return rawHeaders;
    }

    public void add(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("fieldName == null");
        }
        if (str2 != null) {
            this.namesAndValues.add(str);
            this.namesAndValues.add(str2.trim());
            return;
        }
        System.err.println("Ignoring HTTP header field '" + str + "' because its value is null");
    }

    public void addAll(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            add(str, it.next());
        }
    }

    public void addLine(String str) {
        int iIndexOf = str.indexOf(SignatureImpl.INNER_SEP);
        if (iIndexOf == -1) {
            add("", str);
        } else {
            add(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        }
    }

    public void copy(RawHeaders rawHeaders) {
        this.namesAndValues.addAll(rawHeaders.namesAndValues);
        this.statusLine = rawHeaders.statusLine;
        this.httpMinorVersion = rawHeaders.httpMinorVersion;
        this.responseCode = rawHeaders.responseCode;
        this.responseMessage = rawHeaders.responseMessage;
    }

    public String get(String str) {
        for (int size = this.namesAndValues.size() - 2; size >= 0; size -= 2) {
            if (str.equalsIgnoreCase(this.namesAndValues.get(size))) {
                return this.namesAndValues.get(size + 1);
            }
        }
        return null;
    }

    public RawHeaders getAll(Set<String> set) {
        RawHeaders rawHeaders = new RawHeaders();
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            String str = this.namesAndValues.get(i);
            if (set.contains(str)) {
                rawHeaders.add(str, this.namesAndValues.get(i + 1));
            }
        }
        return rawHeaders;
    }

    public String getFieldName(int i) {
        int i2 = i * 2;
        if (i2 < 0 || i2 >= this.namesAndValues.size()) {
            return null;
        }
        return this.namesAndValues.get(i2);
    }

    public int getHttpMinorVersion() {
        int i = this.httpMinorVersion;
        if (i != -1) {
            return i;
        }
        return 1;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String getStatusLine() {
        return this.statusLine;
    }

    public String getValue(int i) {
        int i2 = (i * 2) + 1;
        if (i2 < 0 || i2 >= this.namesAndValues.size()) {
            return null;
        }
        return this.namesAndValues.get(i2);
    }

    public int length() {
        return this.namesAndValues.size() / 2;
    }

    public void removeAll(String str) {
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            if (str.equalsIgnoreCase(this.namesAndValues.get(i))) {
                this.namesAndValues.remove(i);
                this.namesAndValues.remove(i);
            }
        }
    }

    public void set(String str, String str2) {
        removeAll(str);
        add(str, str2);
    }

    public void setStatusLine(String str) {
        String strTrim = str.trim();
        this.statusLine = strTrim;
        if (strTrim == null || !strTrim.startsWith("HTTP/")) {
            return;
        }
        String strTrim2 = strTrim.trim();
        int iIndexOf = strTrim2.indexOf(" ") + 1;
        if (iIndexOf == 0) {
            return;
        }
        if (strTrim2.charAt(iIndexOf - 2) != '1') {
            this.httpMinorVersion = 0;
        }
        int length = iIndexOf + 3;
        if (length > strTrim2.length()) {
            length = strTrim2.length();
        }
        this.responseCode = Integer.parseInt(strTrim2.substring(iIndexOf, length));
        int i = length + 1;
        if (i <= strTrim2.length()) {
            this.responseMessage = strTrim2.substring(i);
        }
    }

    public String toHeaderString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append(this.statusLine);
        sb.append("\r\n");
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            sb.append(this.namesAndValues.get(i));
            sb.append(": ");
            sb.append(this.namesAndValues.get(i + 1));
            sb.append("\r\n");
        }
        sb.append("\r\n");
        return sb.toString();
    }

    public Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(FIELD_NAME_COMPARATOR);
        for (int i = 0; i < this.namesAndValues.size(); i += 2) {
            String str = this.namesAndValues.get(i);
            String str2 = this.namesAndValues.get(i + 1);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(str);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(str2);
            treeMap.put(str, Collections.unmodifiableList(arrayList));
        }
        String str3 = this.statusLine;
        if (str3 != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str3)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public RawHeaders(RawHeaders rawHeaders) {
        copy(rawHeaders);
    }
}
