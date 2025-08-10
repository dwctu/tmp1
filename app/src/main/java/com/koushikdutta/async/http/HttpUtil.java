package com.koushikdutta.async.http;

import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import com.koushikdutta.async.http.body.JSONObjectBody;
import com.koushikdutta.async.http.body.MultipartFormDataBody;
import com.koushikdutta.async.http.body.StringBody;
import com.koushikdutta.async.http.body.UrlEncodedFormBody;

/* loaded from: classes3.dex */
public class HttpUtil {

    public static class EndEmitter extends FilteredDataEmitter {
        private EndEmitter() {
        }

        public static EndEmitter create(AsyncServer asyncServer, final Exception exc) {
            EndEmitter endEmitter = new EndEmitter();
            asyncServer.post(new Runnable() { // from class: com.koushikdutta.async.http.HttpUtil.EndEmitter.1
                @Override // java.lang.Runnable
                public void run() {
                    EndEmitter.this.report(exc);
                }
            });
            return endEmitter;
        }
    }

    public static long contentLength(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_LENGTH);
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static AsyncHttpRequestBody getBody(DataEmitter dataEmitter, CompletedCallback completedCallback, Headers headers) {
        String str = headers.get("Content-Type");
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(";");
        for (int i = 0; i < strArrSplit.length; i++) {
            strArrSplit[i] = strArrSplit[i].trim();
        }
        for (String str2 : strArrSplit) {
            if ("application/x-www-form-urlencoded".equals(str2)) {
                return new UrlEncodedFormBody();
            }
            if ("application/json".equals(str2)) {
                return new JSONObjectBody();
            }
            if ("text/plain".equals(str2)) {
                return new StringBody();
            }
            if (str2 != null && str2.startsWith("multipart/")) {
                return new MultipartFormDataBody(str);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.koushikdutta.async.DataEmitter getBodyDecoder(com.koushikdutta.async.DataEmitter r5, com.koushikdutta.async.http.Protocol r6, com.koushikdutta.async.http.Headers r7, boolean r8) {
        /*
            r0 = -1
            java.lang.String r6 = "Content-Length"
            java.lang.String r6 = r7.get(r6)     // Catch: java.lang.NumberFormatException -> Lf
            if (r6 == 0) goto Lf
            long r2 = java.lang.Long.parseLong(r6)     // Catch: java.lang.NumberFormatException -> Lf
            goto L10
        Lf:
            r2 = r0
        L10:
            r6 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L45
            r0 = 0
            int r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r8 >= 0) goto L2e
            com.koushikdutta.async.AsyncServer r6 = r5.getServer()
            com.koushikdutta.async.http.BodyDecoderException r7 = new com.koushikdutta.async.http.BodyDecoderException
            java.lang.String r8 = "not using chunked encoding, and no content-length found."
            r7.<init>(r8)
            com.koushikdutta.async.http.HttpUtil$EndEmitter r6 = com.koushikdutta.async.http.HttpUtil.EndEmitter.create(r6, r7)
            r6.setDataEmitter(r5)
            return r6
        L2e:
            if (r8 != 0) goto L3c
            com.koushikdutta.async.AsyncServer r7 = r5.getServer()
            com.koushikdutta.async.http.HttpUtil$EndEmitter r6 = com.koushikdutta.async.http.HttpUtil.EndEmitter.create(r7, r6)
            r6.setDataEmitter(r5)
            return r6
        L3c:
            com.koushikdutta.async.http.filter.ContentLengthFilter r6 = new com.koushikdutta.async.http.filter.ContentLengthFilter
            r6.<init>(r2)
            r6.setDataEmitter(r5)
            goto L5b
        L45:
            java.lang.String r0 = "Transfer-Encoding"
            java.lang.String r0 = r7.get(r0)
            java.lang.String r1 = "chunked"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L5d
            com.koushikdutta.async.http.filter.ChunkedInputFilter r6 = new com.koushikdutta.async.http.filter.ChunkedInputFilter
            r6.<init>()
            r6.setDataEmitter(r5)
        L5b:
            r5 = r6
            goto L6b
        L5d:
            if (r8 == 0) goto L6b
            com.koushikdutta.async.AsyncServer r7 = r5.getServer()
            com.koushikdutta.async.http.HttpUtil$EndEmitter r6 = com.koushikdutta.async.http.HttpUtil.EndEmitter.create(r7, r6)
            r6.setDataEmitter(r5)
            return r6
        L6b:
            java.lang.String r6 = "Content-Encoding"
            java.lang.String r8 = r7.get(r6)
            java.lang.String r0 = "gzip"
            boolean r8 = r0.equals(r8)
            if (r8 == 0) goto L83
            com.koushikdutta.async.http.filter.GZIPInputFilter r6 = new com.koushikdutta.async.http.filter.GZIPInputFilter
            r6.<init>()
            r6.setDataEmitter(r5)
        L81:
            r5 = r6
            goto L98
        L83:
            java.lang.String r6 = r7.get(r6)
            java.lang.String r7 = "deflate"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L98
            com.koushikdutta.async.http.filter.InflaterInputFilter r6 = new com.koushikdutta.async.http.filter.InflaterInputFilter
            r6.<init>()
            r6.setDataEmitter(r5)
            goto L81
        L98:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.HttpUtil.getBodyDecoder(com.koushikdutta.async.DataEmitter, com.koushikdutta.async.http.Protocol, com.koushikdutta.async.http.Headers, boolean):com.koushikdutta.async.DataEmitter");
    }

    public static boolean isKeepAlive(Protocol protocol, Headers headers) {
        String str = headers.get(HttpHeaders.CONNECTION);
        return str == null ? protocol == Protocol.HTTP_1_1 : "keep-alive".equalsIgnoreCase(str);
    }

    public static boolean isKeepAlive(String str, Headers headers) {
        String str2 = headers.get(HttpHeaders.CONNECTION);
        if (str2 == null) {
            return Protocol.get(str) == Protocol.HTTP_1_1;
        }
        return "keep-alive".equalsIgnoreCase(str2);
    }
}
