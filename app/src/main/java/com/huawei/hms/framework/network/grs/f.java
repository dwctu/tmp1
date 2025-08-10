package com.huawei.hms.framework.network.grs;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.restclient.hianalytics.RCEventListener;
import com.huawei.hms.framework.network.restclient.hwhttp.Interceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.RealInterceptorChain;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.Response;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import com.huawei.hms.framework.network.restclient.hwhttp.url.HttpUrl;

/* loaded from: classes2.dex */
public class f implements PluginInterceptor {
    private static final String a = "f";

    public Response intercept(Interceptor.Chain chain) {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request();
        String url = request.getUrl().getUrl();
        if (!GrsManager.isGRSSchema(url)) {
            return realInterceptorChain.proceed(request);
        }
        String str = a;
        Logger.v(str, "request url is grs schema.");
        RCEventListener rCEventListener = realInterceptorChain.getRCEventListener();
        rCEventListener.convertGrsStart(url);
        String grs = GrsManager.getInstance().parseGrs(url);
        Request requestBuild = request.newBuilder().url(new HttpUrl(grs)).build();
        Logger.v(str, "origin url is grs schema and by intercepted,and now request is:%s", requestBuild.toString());
        rCEventListener.convertGrsEnd(grs);
        return realInterceptorChain.proceed(requestBuild);
    }

    public String pluginName() {
        return f.class.getSimpleName();
    }
}
