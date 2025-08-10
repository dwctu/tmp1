package com.amazonaws.services.s3.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.util.StringUtils;

/* loaded from: classes.dex */
public class XmlWriter {
    public List<String> a = new ArrayList();
    public StringBuilder b = new StringBuilder();

    public final void a(String str, StringBuilder sb) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            String str2 = cCharAt != '\t' ? cCharAt != '\n' ? cCharAt != '\r' ? cCharAt != '\"' ? cCharAt != '&' ? cCharAt != '<' ? cCharAt != '>' ? null : StringUtils.GT_ENCODE : StringUtils.LT_ENCODE : StringUtils.AMP_ENCODE : StringUtils.QUOTE_ENCODE : "&#13;" : "&#10;" : "&#9;";
            if (str2 != null) {
                if (i2 < i) {
                    sb.append((CharSequence) str, i2, i);
                }
                this.b.append(str2);
                i2 = i + 1;
            }
            i++;
        }
        if (i2 < i) {
            this.b.append((CharSequence) str, i2, i);
        }
    }

    public XmlWriter b() {
        String strRemove = this.a.remove(r0.size() - 1);
        StringBuilder sb = this.b;
        sb.append("</");
        sb.append(strRemove);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return this;
    }

    public byte[] c() {
        return toString().getBytes(com.amazonaws.util.StringUtils.a);
    }

    public XmlWriter d(String str) {
        StringBuilder sb = this.b;
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(str);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        this.a.add(str);
        return this;
    }

    public XmlWriter e(String str) {
        a(str, this.b);
        return this;
    }

    public String toString() {
        return this.b.toString();
    }
}
