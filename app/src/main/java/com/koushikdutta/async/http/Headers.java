package com.koushikdutta.async.http;

import android.text.TextUtils;
import com.broadcom.bt.util.io.IOUtils;
import com.koushikdutta.async.util.TaggedList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes3.dex */
public class Headers {
    public final Multimap map = new Multimap() { // from class: com.koushikdutta.async.http.Headers.1
        @Override // com.koushikdutta.async.http.Multimap
        public List<String> newList() {
            return new TaggedList();
        }
    };

    public Headers() {
    }

    public static Headers parse(String str) {
        String[] strArrSplit = str.split(IOUtils.LINE_SEPARATOR_UNIX);
        Headers headers = new Headers();
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            if (!TextUtils.isEmpty(strTrim)) {
                headers.addLine(strTrim);
            }
        }
        return headers;
    }

    public Headers add(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.US);
        this.map.add(lowerCase, str2);
        ((TaggedList) this.map.get(lowerCase)).tagNull(str);
        return this;
    }

    public Headers addAll(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            add(str, it.next());
        }
        return this;
    }

    public Headers addAllMap(Map<String, String> map) {
        for (String str : map.keySet()) {
            add(str, map.get(str));
        }
        return this;
    }

    public Headers addLine(String str) {
        if (str != null) {
            String[] strArrSplit = str.trim().split(SignatureImpl.INNER_SEP, 2);
            if (strArrSplit.length == 2) {
                add(strArrSplit[0].trim(), strArrSplit[1].trim());
            } else {
                add(strArrSplit[0].trim(), "");
            }
        }
        return this;
    }

    public String get(String str) {
        return this.map.getString(str.toLowerCase(Locale.US));
    }

    public List<String> getAll(String str) {
        return this.map.get(str.toLowerCase(Locale.US));
    }

    public Multimap getMultiMap() {
        return this.map;
    }

    public String remove(String str) {
        List<String> listRemoveAll = removeAll(str.toLowerCase(Locale.US));
        if (listRemoveAll == null || listRemoveAll.size() == 0) {
            return null;
        }
        return listRemoveAll.get(0);
    }

    public List<String> removeAll(String str) {
        return this.map.remove(str.toLowerCase(Locale.US));
    }

    public Headers set(String str, String str2) {
        if (str2 != null && (str2.contains(IOUtils.LINE_SEPARATOR_UNIX) || str2.contains("\r"))) {
            throw new IllegalArgumentException("value must not contain a new line or line feed");
        }
        String lowerCase = str.toLowerCase(Locale.US);
        this.map.put(lowerCase, str2);
        ((TaggedList) this.map.get(lowerCase)).tagNull(str);
        return this;
    }

    public String toPrefixString(String str) {
        return toStringBuilder().insert(0, str + "\r\n").toString();
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(256);
        Iterator<String> it = this.map.keySet().iterator();
        while (it.hasNext()) {
            TaggedList taggedList = (TaggedList) this.map.get(it.next());
            Iterator<T> it2 = taggedList.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                sb.append((String) taggedList.tag());
                sb.append(": ");
                sb.append(str);
                sb.append("\r\n");
            }
        }
        sb.append("\r\n");
        return sb;
    }

    public Headers removeAll(Collection<String> collection) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return this;
    }

    public Headers(Map<String, List<String>> map) {
        for (String str : map.keySet()) {
            addAll(str, map.get(str));
        }
    }

    public Headers addAll(Map<String, List<String>> map) {
        for (String str : map.keySet()) {
            Iterator<String> it = map.get(str).iterator();
            while (it.hasNext()) {
                add(str, it.next());
            }
        }
        return this;
    }

    public Headers addAll(Headers headers) {
        this.map.putAll(headers.map);
        return this;
    }
}
