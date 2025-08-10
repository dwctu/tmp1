package io.agora.utils;

import java.net.Proxy;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class HttpAsyncTaskParam {
    public String agent;
    public byte[] body;
    public String fullUrl;
    public HashMap<String, String> headers;
    public Proxy httpProxy;
    public String method;
    public String pass;
    public int timeout_millsec;
    public String user;
}
