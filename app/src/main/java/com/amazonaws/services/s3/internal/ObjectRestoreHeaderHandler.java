package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.ObjectRestoreResult;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class ObjectRestoreHeaderHandler<T extends ObjectRestoreResult> implements HeaderHandler<T> {
    public static final Pattern a = Pattern.compile("expiry-date=\"(.*?)\"");
    public static final Pattern b = Pattern.compile("ongoing-request=\"(.*?)\"");
    public static final Log c = LogFactory.b(ObjectRestoreHeaderHandler.class);

    @Override // com.amazonaws.services.s3.internal.HeaderHandler
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(T t, HttpResponse httpResponse) {
        String str = httpResponse.c().get("x-amz-restore");
        if (str != null) {
            t.a(d(str));
            Boolean boolC = c(str);
            if (boolC != null) {
                t.h(boolC.booleanValue());
            }
        }
    }

    public final Boolean c(String str) {
        Matcher matcher = b.matcher(str);
        if (matcher.find()) {
            return Boolean.valueOf(Boolean.parseBoolean(matcher.group(1)));
        }
        return null;
    }

    public final Date d(String str) {
        Matcher matcher = a.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        try {
            return ServiceUtils.f(matcher.group(1));
        } catch (Exception e) {
            c.f("Error parsing expiry-date from x-amz-restore header.", e);
            return null;
        }
    }
}
