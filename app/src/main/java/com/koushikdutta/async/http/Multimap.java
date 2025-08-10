package com.koushikdutta.async.http;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Multimap extends LinkedHashMap<String, List<String>> implements Iterable<NameValuePair> {
    public static final StringDecoder QUERY_DECODER = new StringDecoder() { // from class: com.koushikdutta.async.http.Multimap.1
        @Override // com.koushikdutta.async.http.Multimap.StringDecoder
        public String decode(String str) {
            return Uri.decode(str);
        }
    };
    public static final StringDecoder URL_DECODER = new StringDecoder() { // from class: com.koushikdutta.async.http.Multimap.2
        @Override // com.koushikdutta.async.http.Multimap.StringDecoder
        public String decode(String str) {
            return URLDecoder.decode(str);
        }
    };

    public interface StringDecoder {
        String decode(String str);
    }

    public Multimap() {
    }

    public static Multimap parse(String str, String str2, boolean z, StringDecoder stringDecoder) {
        return parse(str, str2, "=", z, stringDecoder);
    }

    public static Multimap parseCommaDelimited(String str) {
        return parse(str, ",", true, null);
    }

    public static Multimap parseQuery(String str) {
        return parse(str, ContainerUtils.FIELD_DELIMITER, false, QUERY_DECODER);
    }

    public static Multimap parseSemicolonDelimited(String str) {
        return parse(str, ";", true, null);
    }

    public static Multimap parseUrlEncoded(String str) {
        return parse(str, ContainerUtils.FIELD_DELIMITER, false, URL_DECODER);
    }

    public void add(String str, String str2) {
        ensure(str).add(str2);
    }

    public List<String> ensure(String str) {
        List<String> list = get(str);
        if (list != null) {
            return list;
        }
        List<String> listNewList = newList();
        put((Multimap) str, (String) listNewList);
        return listNewList;
    }

    public String getAllString(String str, String str2) {
        List<String> list = get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str3 : list) {
            if (!z) {
                sb.append(str2);
            }
            sb.append(str3);
            z = false;
        }
        return sb.toString();
    }

    public String getString(String str) {
        List<String> list = get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override // java.lang.Iterable
    public Iterator<NameValuePair> iterator() {
        ArrayList arrayList = new ArrayList();
        for (String str : keySet()) {
            Iterator it = ((List) get(str)).iterator();
            while (it.hasNext()) {
                arrayList.add(new BasicNameValuePair(str, (String) it.next()));
            }
        }
        return arrayList.iterator();
    }

    public List<String> newList() {
        return new ArrayList();
    }

    public void put(String str, String str2) {
        List<String> listNewList = newList();
        listNewList.add(str2);
        put((Multimap) str, (String) listNewList);
    }

    public Map<String, String> toSingleMap() {
        HashMap map = new HashMap();
        for (String str : keySet()) {
            map.put(str, getString(str));
        }
        return map;
    }

    public Multimap(List<NameValuePair> list) {
        for (NameValuePair nameValuePair : list) {
            add(nameValuePair.getName(), nameValuePair.getValue());
        }
    }

    public static Multimap parse(String str, String str2, String str3, boolean z, StringDecoder stringDecoder) {
        Multimap multimap = new Multimap();
        if (str == null) {
            return multimap;
        }
        for (String str4 : str.split(str2)) {
            String[] strArrSplit = str4.split(str3, 2);
            String strTrim = strArrSplit[0].trim();
            if (!TextUtils.isEmpty(strTrim)) {
                String strDecode = strArrSplit.length > 1 ? strArrSplit[1] : null;
                if (strDecode != null && z && strDecode.endsWith("\"") && strDecode.startsWith("\"")) {
                    strDecode = strDecode.substring(1, strDecode.length() - 1);
                }
                if (strDecode != null && stringDecoder != null) {
                    strTrim = stringDecoder.decode(strTrim);
                    strDecode = stringDecoder.decode(strDecode);
                }
                multimap.add(strTrim, strDecode);
            }
        }
        return multimap;
    }

    public Multimap(Multimap multimap) {
        putAll(multimap);
    }
}
