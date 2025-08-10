package org.jivesoftware.smackx.pubsub;

import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes5.dex */
public enum SubscribeOptionFields {
    deliver,
    digest,
    digest_frequency,
    expire,
    include_body,
    show_values,
    subscription_type,
    subscription_depth;

    public static SubscribeOptionFields valueOfFromElement(String str) {
        String strSubstring = str.substring(str.lastIndexOf(36));
        return "show-values".equals(strSubstring) ? show_values : valueOf(strSubstring);
    }

    public String getFieldName() {
        if (this == show_values) {
            return "pubsub#" + toString().replace('_', SignatureImpl.SEP);
        }
        return "pubsub#" + toString();
    }
}
