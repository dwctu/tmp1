package org.jivesoftware.smackx.disco.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import org.jivesoftware.smack.packet.IQ;

/* loaded from: classes5.dex */
public class BaseRequestIQ extends BaseIQ {
    private static final HashMap<Class, String> apis = new HashMap<>();
    public String api;
    private Object data;

    public BaseRequestIQ(Object obj) {
        this.data = obj;
        if (obj != null) {
            HashMap<Class, String> map = apis;
            String str = map.get(obj.getClass());
            this.api = str;
            if (TextUtils.isEmpty(str)) {
                ApiAnnotation apiAnnotation = (ApiAnnotation) obj.getClass().getAnnotation(ApiAnnotation.class);
                String strApi = apiAnnotation != null ? apiAnnotation.api() : null;
                this.api = strApi;
                if (TextUtils.isEmpty(strApi)) {
                    throw new RuntimeException("api must not null");
                }
                map.put(obj.getClass(), this.api);
            }
        }
    }

    @Override // org.jivesoftware.smack.packet.IQ
    public IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        if (!TextUtils.isEmpty(this.api)) {
            iQChildElementXmlStringBuilder.optAttribute("api", this.api);
        }
        iQChildElementXmlStringBuilder.rightAngleBracket();
        Object obj = this.data;
        if (obj != null) {
            iQChildElementXmlStringBuilder.element("body", JSON.toJSONString(obj));
        }
        return iQChildElementXmlStringBuilder;
    }

    @Override // org.jivesoftware.smack.packet.Stanza, org.jivesoftware.smack.packet.Packet
    public String toString() {
        return this.api;
    }
}
