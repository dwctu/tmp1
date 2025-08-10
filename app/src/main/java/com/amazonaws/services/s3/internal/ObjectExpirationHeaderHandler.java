package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class ObjectExpirationHeaderHandler<T extends ObjectExpirationResult> implements HeaderHandler<T> {
    public static final Pattern a = Pattern.compile("expiry-date=\"(.*?)\"");
    public static final Pattern b = Pattern.compile("rule-id=\"(.*?)\"");
    public static final Log c = LogFactory.b(ObjectExpirationHeaderHandler.class);

    @Override // com.amazonaws.services.s3.internal.HeaderHandler
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(T t, HttpResponse httpResponse) {
        String str = httpResponse.c().get("x-amz-expiration");
        if (str != null) {
            t.d(c(str));
            t.c(d(str));
        }
    }

    public final Date c(String str) {
        Matcher matcher = a.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        try {
            return ServiceUtils.f(matcher.group(1));
        } catch (Exception e) {
            c.f("Error parsing expiry-date from x-amz-expiration header.", e);
            return null;
        }
    }

    public final String d(String str) {
        Matcher matcher = b.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
