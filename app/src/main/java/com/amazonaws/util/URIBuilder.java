package com.amazonaws.util;

import com.amazonaws.Protocol;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes.dex */
public class URIBuilder {
    public String a;
    public String b;
    public String c;
    public int d;
    public String e;
    public String f;
    public String g;

    static {
        Protocol.HTTPS.toString();
    }

    public URIBuilder(URI uri) {
        this.a = uri.getScheme();
        this.b = uri.getUserInfo();
        this.c = uri.getHost();
        this.d = uri.getPort();
        this.e = uri.getPath();
        this.f = uri.getQuery();
        this.g = uri.getFragment();
    }

    public static URIBuilder b(URI uri) {
        return new URIBuilder(uri);
    }

    public URI a() throws URISyntaxException {
        return new URI(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }

    public URIBuilder c(String str) {
        this.c = str;
        return this;
    }
}
