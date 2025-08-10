package com.koushikdutta.async.http.server;

import com.koushikdutta.async.http.server.AsyncHttpServerRouter;

/* loaded from: classes3.dex */
public interface RouteMatcher {
    AsyncHttpServerRouter.RouteMatch route(String str, String str2);
}
