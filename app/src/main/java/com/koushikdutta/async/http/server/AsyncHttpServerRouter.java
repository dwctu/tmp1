package com.koushikdutta.async.http.server;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.http.AsyncHttpHead;
import com.koushikdutta.async.http.WebSocket;
import com.koushikdutta.async.http.WebSocketImpl;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.AsyncHttpServerRouter;
import com.koushikdutta.async.util.StreamUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;

/* loaded from: classes3.dex */
public class AsyncHttpServerRouter implements RouteMatcher {
    private Callback callback;
    public final ArrayList<RouteInfo> routes = new ArrayList<>();
    public static Hashtable<String, String> mContentTypes = new Hashtable<>();
    public static Hashtable<String, Future<Manifest>> AppManifests = new Hashtable<>();

    public static class Asset {
        public int available;
        public InputStream inputStream;
        public String path;

        public Asset(int i, InputStream inputStream, String str) {
            this.available = i;
            this.inputStream = inputStream;
            this.path = str;
        }
    }

    public abstract class AsyncHttpServerRequestImpl extends com.koushikdutta.async.http.server.AsyncHttpServerRequestImpl {
        public Matcher matcher;

        public AsyncHttpServerRequestImpl() {
        }

        @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
        public Matcher getMatcher() {
            return this.matcher;
        }

        @Override // com.koushikdutta.async.http.server.AsyncHttpServerRequest
        public void setMatcher(Matcher matcher) {
            this.matcher = matcher;
        }
    }

    public class Callback implements HttpServerRequestCallback, RouteMatcher {
        public Callback() {
        }

        @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
        public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
            RouteMatch routeMatchRoute = route(asyncHttpServerRequest.getMethod(), asyncHttpServerRequest.getPath());
            if (routeMatchRoute != null) {
                routeMatchRoute.callback.onRequest(asyncHttpServerRequest, asyncHttpServerResponse);
            } else {
                asyncHttpServerResponse.code(404);
                asyncHttpServerResponse.end();
            }
        }

        @Override // com.koushikdutta.async.http.server.RouteMatcher
        public RouteMatch route(String str, String str2) {
            return AsyncHttpServerRouter.this.route(str, str2);
        }
    }

    public static class RouteInfo {
        public AsyncHttpRequestBodyProvider bodyCallback;
        public HttpServerRequestCallback callback;
        public String method;
        public Pattern regex;

        private RouteInfo() {
        }
    }

    public static class RouteMatch {
        public final AsyncHttpRequestBodyProvider bodyCallback;
        public final HttpServerRequestCallback callback;
        public final Matcher matcher;
        public final String method;
        public final String path;

        private RouteMatch(String str, String str2, Matcher matcher, HttpServerRequestCallback httpServerRequestCallback, AsyncHttpRequestBodyProvider asyncHttpRequestBodyProvider) {
            this.method = str;
            this.path = str2;
            this.matcher = matcher;
            this.callback = httpServerRequestCallback;
            this.bodyCallback = asyncHttpRequestBodyProvider;
        }
    }

    public AsyncHttpServerRouter() {
        mContentTypes.put("js", FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE);
        mContentTypes.put("json", "application/json");
        mContentTypes.put("png", "image/png");
        mContentTypes.put("jpg", MimeTypes.IMAGE_JPEG);
        mContentTypes.put("jpeg", MimeTypes.IMAGE_JPEG);
        mContentTypes.put(XHTMLExtension.ELEMENT, "text/html");
        mContentTypes.put("css", "text/css");
        mContentTypes.put("mp4", MimeTypes.VIDEO_MP4);
        mContentTypes.put("mov", "video/quicktime");
        mContentTypes.put("wmv", "video/x-ms-wmv");
        mContentTypes.put("txt", "text/plain");
        this.callback = new Callback();
    }

    public static /* synthetic */ void a(AssetManager assetManager, String str, Context context, AsyncHttpServerRequest asyncHttpServerRequest, final AsyncHttpServerResponse asyncHttpServerResponse) throws IOException {
        final Asset assetStream = getAssetStream(assetManager, str + asyncHttpServerRequest.getMatcher().replaceAll(""));
        if (assetStream == null || assetStream.inputStream == null) {
            asyncHttpServerResponse.code(404);
            asyncHttpServerResponse.end();
        } else if (isClientCached(context, asyncHttpServerRequest, asyncHttpServerResponse, assetStream.path)) {
            StreamUtility.closeQuietly(assetStream.inputStream);
            asyncHttpServerResponse.code(304);
            asyncHttpServerResponse.end();
        } else {
            asyncHttpServerResponse.getHeaders().set(HttpHeaders.CONTENT_LENGTH, String.valueOf(assetStream.available));
            asyncHttpServerResponse.getHeaders().add("Content-Type", getContentType(assetStream.path));
            asyncHttpServerResponse.code(200);
            Util.pump(assetStream.inputStream, assetStream.available, asyncHttpServerResponse, new CompletedCallback() { // from class: dc.za1
                @Override // com.koushikdutta.async.callback.CompletedCallback
                public final void onCompleted(Exception exc) throws IOException {
                    AsyncHttpServerRouter.c(asyncHttpServerResponse, assetStream, exc);
                }
            });
        }
    }

    public static /* synthetic */ void b(AssetManager assetManager, String str, Context context, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) throws IOException {
        InputStream inputStream;
        Asset assetStream = getAssetStream(assetManager, str + asyncHttpServerRequest.getMatcher().replaceAll(""));
        if (assetStream == null || (inputStream = assetStream.inputStream) == null) {
            asyncHttpServerResponse.code(404);
            asyncHttpServerResponse.end();
            return;
        }
        StreamUtility.closeQuietly(inputStream);
        if (isClientCached(context, asyncHttpServerRequest, asyncHttpServerResponse, assetStream.path)) {
            asyncHttpServerResponse.code(304);
        } else {
            asyncHttpServerResponse.getHeaders().set(HttpHeaders.CONTENT_LENGTH, String.valueOf(assetStream.available));
            asyncHttpServerResponse.getHeaders().add("Content-Type", getContentType(assetStream.path));
            asyncHttpServerResponse.code(200);
        }
        asyncHttpServerResponse.end();
    }

    public static /* synthetic */ void c(AsyncHttpServerResponse asyncHttpServerResponse, Asset asset, Exception exc) throws IOException {
        asyncHttpServerResponse.end();
        StreamUtility.closeQuietly(asset.inputStream);
    }

    public static WebSocket checkWebSocketUpgrade(String str, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        String str2 = asyncHttpServerRequest.getHeaders().get(HttpHeaders.CONNECTION);
        boolean z = false;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",");
            int length = strArrSplit.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (HttpHeaders.UPGRADE.equalsIgnoreCase(strArrSplit[i].trim())) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        if ("websocket".equalsIgnoreCase(asyncHttpServerRequest.getHeaders().get(HttpHeaders.UPGRADE)) && z && TextUtils.equals(str, asyncHttpServerRequest.getHeaders().get("Sec-WebSocket-Protocol"))) {
            return new WebSocketImpl(asyncHttpServerRequest, asyncHttpServerResponse);
        }
        return null;
    }

    public static /* synthetic */ void d(String str, AsyncHttpServer.WebSocketRequestCallback webSocketRequestCallback, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
        WebSocket webSocketCheckWebSocketUpgrade = checkWebSocketUpgrade(str, asyncHttpServerRequest, asyncHttpServerResponse);
        if (webSocketCheckWebSocketUpgrade != null) {
            webSocketRequestCallback.onConnected(webSocketCheckWebSocketUpgrade, asyncHttpServerRequest);
        } else {
            asyncHttpServerResponse.code(404);
            asyncHttpServerResponse.end();
        }
    }

    public static synchronized Manifest ensureManifest(Context context) {
        ZipFile zipFile;
        Throwable th;
        Future<Manifest> future = AppManifests.get(context.getPackageName());
        if (future != null) {
            return future.tryGet();
        }
        SimpleFuture simpleFuture = new SimpleFuture();
        try {
            zipFile = new ZipFile(context.getPackageResourcePath());
        } catch (Exception e) {
            e = e;
            zipFile = null;
        } catch (Throwable th2) {
            zipFile = null;
            th = th2;
            StreamUtility.closeQuietly(zipFile);
            AppManifests.put(context.getPackageName(), simpleFuture);
            throw th;
        }
        try {
            try {
                Manifest manifest = new Manifest(zipFile.getInputStream(zipFile.getEntry("META-INF/MANIFEST.MF")));
                simpleFuture.setComplete((SimpleFuture) manifest);
                StreamUtility.closeQuietly(zipFile);
                AppManifests.put(context.getPackageName(), simpleFuture);
                return manifest;
            } catch (Throwable th3) {
                th = th3;
                StreamUtility.closeQuietly(zipFile);
                AppManifests.put(context.getPackageName(), simpleFuture);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            simpleFuture.setComplete(e);
            StreamUtility.closeQuietly(zipFile);
            AppManifests.put(context.getPackageName(), simpleFuture);
            return null;
        }
    }

    public static Asset getAssetStream(Context context, String str) {
        return getAssetStream(context.getAssets(), str);
    }

    public static String getContentType(String str) {
        return tryGetContentType(str);
    }

    public static boolean isClientCached(Context context, AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse, String str) {
        Manifest manifestEnsureManifest = ensureManifest(context);
        if (manifestEnsureManifest == null) {
            return false;
        }
        try {
            String value = manifestEnsureManifest.getEntries().get("assets/" + str).getValue("SHA-256-Digest");
            if (TextUtils.isEmpty(value)) {
                return false;
            }
            String str2 = String.format("\"%s\"", value);
            asyncHttpServerResponse.getHeaders().set(HttpHeaders.ETAG, str2);
            return TextUtils.equals(asyncHttpServerRequest.getHeaders().get(HttpHeaders.IF_NONE_MATCH), str2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static String tryGetContentType(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf == -1) {
            return null;
        }
        String str2 = mContentTypes.get(str.substring(iLastIndexOf + 1));
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    public void addAction(String str, String str2, HttpServerRequestCallback httpServerRequestCallback, AsyncHttpRequestBodyProvider asyncHttpRequestBodyProvider) {
        RouteInfo routeInfo = new RouteInfo();
        routeInfo.regex = Pattern.compile("^" + str2);
        routeInfo.callback = httpServerRequestCallback;
        routeInfo.method = str;
        routeInfo.bodyCallback = asyncHttpRequestBodyProvider;
        synchronized (this.routes) {
            this.routes.add(routeInfo);
        }
    }

    public void directory(final Context context, String str, final String str2) {
        final AssetManager assets = context.getAssets();
        addAction("GET", str, new HttpServerRequestCallback() { // from class: dc.ya1
            @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
            public final void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) throws IOException {
                AsyncHttpServerRouter.a(assets, str2, context, asyncHttpServerRequest, asyncHttpServerResponse);
            }
        });
        addAction(AsyncHttpHead.METHOD, str, new HttpServerRequestCallback() { // from class: dc.ab1
            @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
            public final void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) throws IOException {
                AsyncHttpServerRouter.b(assets, str2, context, asyncHttpServerRequest, asyncHttpServerResponse);
            }
        });
    }

    public void get(String str, HttpServerRequestCallback httpServerRequestCallback) {
        addAction("GET", str, httpServerRequestCallback);
    }

    public HttpServerRequestCallback getCallback() {
        return this.callback;
    }

    public void post(String str, HttpServerRequestCallback httpServerRequestCallback) {
        addAction("POST", str, httpServerRequestCallback);
    }

    public void removeAction(String str, String str2) {
        for (int i = 0; i < this.routes.size(); i++) {
            RouteInfo routeInfo = this.routes.get(i);
            if (TextUtils.equals(routeInfo.method, str) && str2.equals(routeInfo.regex.toString())) {
                this.routes.remove(i);
                return;
            }
        }
    }

    @Override // com.koushikdutta.async.http.server.RouteMatcher
    public RouteMatch route(String str, String str2) {
        synchronized (this.routes) {
            Iterator<RouteInfo> it = this.routes.iterator();
            while (it.hasNext()) {
                RouteInfo next = it.next();
                if (TextUtils.equals(str, next.method) || next.method == null) {
                    Matcher matcher = next.regex.matcher(str2);
                    if (matcher.matches()) {
                        HttpServerRequestCallback httpServerRequestCallback = next.callback;
                        if (!(httpServerRequestCallback instanceof RouteMatcher)) {
                            return new RouteMatch(str, str2, matcher, httpServerRequestCallback, next.bodyCallback);
                        }
                        return ((RouteMatcher) next.callback).route(str, matcher.group(1));
                    }
                }
            }
            return null;
        }
    }

    public void websocket(String str, AsyncHttpServer.WebSocketRequestCallback webSocketRequestCallback) {
        websocket(str, null, webSocketRequestCallback);
    }

    public static Asset getAssetStream(AssetManager assetManager, String str) throws IOException {
        try {
            InputStream inputStreamOpen = assetManager.open(str);
            return new Asset(inputStreamOpen.available(), inputStreamOpen, str);
        } catch (IOException unused) {
            String[] strArr = {"/index.htm", "/index.html", "index.htm", "index.html", ".htm", ".html"};
            for (int i = 0; i < 6; i++) {
                String str2 = strArr[i];
                try {
                    InputStream inputStreamOpen2 = assetManager.open(str + str2);
                    return new Asset(inputStreamOpen2.available(), inputStreamOpen2, str + str2);
                } catch (IOException unused2) {
                }
            }
            return null;
        }
    }

    public void websocket(String str, final String str2, final AsyncHttpServer.WebSocketRequestCallback webSocketRequestCallback) {
        get(str, new HttpServerRequestCallback() { // from class: dc.bb1
            @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
            public final void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, AsyncHttpServerResponse asyncHttpServerResponse) {
                AsyncHttpServerRouter.d(str2, webSocketRequestCallback, asyncHttpServerRequest, asyncHttpServerResponse);
            }
        });
    }

    public void directory(String str, File file) {
        directory(str, file, false);
    }

    public void directory(String str, final File file, final boolean z) {
        addAction("GET", str, new HttpServerRequestCallback() { // from class: com.koushikdutta.async.http.server.AsyncHttpServerRouter.1
            @Override // com.koushikdutta.async.http.server.HttpServerRequestCallback
            public void onRequest(AsyncHttpServerRequest asyncHttpServerRequest, final AsyncHttpServerResponse asyncHttpServerResponse) {
                File file2 = new File(file, asyncHttpServerRequest.getMatcher().replaceAll(""));
                if (!file2.isDirectory() || !z) {
                    if (!file2.isFile()) {
                        asyncHttpServerResponse.code(404);
                        asyncHttpServerResponse.end();
                        return;
                    }
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        asyncHttpServerResponse.code(200);
                        Util.pump(fileInputStream, fileInputStream.available(), asyncHttpServerResponse, new CompletedCallback() { // from class: com.koushikdutta.async.http.server.AsyncHttpServerRouter.1.2
                            @Override // com.koushikdutta.async.callback.CompletedCallback
                            public void onCompleted(Exception exc) {
                                asyncHttpServerResponse.end();
                            }
                        });
                        return;
                    } catch (IOException unused) {
                        asyncHttpServerResponse.code(404);
                        asyncHttpServerResponse.end();
                        return;
                    }
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (File file3 : file2.listFiles()) {
                    if (file3.isDirectory()) {
                        arrayList.add(file3);
                    } else {
                        arrayList2.add(file3);
                    }
                }
                Comparator<File> comparator = new Comparator<File>() { // from class: com.koushikdutta.async.http.server.AsyncHttpServerRouter.1.1
                    @Override // java.util.Comparator
                    public int compare(File file4, File file5) {
                        return file4.getName().compareTo(file5.getName());
                    }
                };
                Collections.sort(arrayList, comparator);
                Collections.sort(arrayList2, comparator);
                arrayList2.addAll(0, arrayList);
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    File file4 = (File) it.next();
                    sb.append(String.format("<div><a href='%s'>%s</a></div>", new File(asyncHttpServerRequest.getPath(), file4.getName()).getAbsolutePath(), file4.getName()));
                }
                asyncHttpServerResponse.send(sb.toString());
            }
        });
    }

    public void addAction(String str, String str2, HttpServerRequestCallback httpServerRequestCallback) {
        addAction(str, str2, httpServerRequestCallback, null);
    }
}
