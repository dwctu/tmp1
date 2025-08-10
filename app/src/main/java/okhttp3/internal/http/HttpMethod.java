package okhttp3.internal.http;

import com.koushikdutta.async.http.AsyncHttpDelete;
import com.koushikdutta.async.http.AsyncHttpHead;
import com.koushikdutta.async.http.AsyncHttpPut;

/* loaded from: classes5.dex */
public final class HttpMethod {
    private HttpMethod() {
    }

    public static boolean invalidatesCache(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals(AsyncHttpPut.METHOD) || str.equals(AsyncHttpDelete.METHOD) || str.equals("MOVE");
    }

    public static boolean permitsRequestBody(String str) {
        return (str.equals("GET") || str.equals(AsyncHttpHead.METHOD)) ? false : true;
    }

    public static boolean redirectsToGet(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean redirectsWithBody(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals("POST") || str.equals(AsyncHttpPut.METHOD) || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
