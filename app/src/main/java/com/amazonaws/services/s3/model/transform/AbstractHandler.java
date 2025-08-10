package com.amazonaws.services.s3.model.transform;

import java.util.Iterator;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes.dex */
public abstract class AbstractHandler extends DefaultHandler {
    public final StringBuilder a = new StringBuilder();
    public final LinkedList<String> b = new LinkedList<>();

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i, int i2) {
        this.a.append(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        this.b.removeLast();
        i(str, str2, str3);
    }

    public final boolean h() {
        return this.b.isEmpty();
    }

    public abstract void i(String str, String str2, String str3);

    public abstract void j(String str, String str2, String str3, Attributes attributes);

    public final String k() {
        return this.a.toString();
    }

    public final boolean l(String... strArr) {
        if (strArr.length != this.b.size()) {
            return false;
        }
        Iterator<String> it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            String str = strArr[i];
            if (!str.equals("*") && !str.equals(next)) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        this.a.setLength(0);
        j(str, str2, str3, attributes);
        this.b.add(str2);
    }
}
