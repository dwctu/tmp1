package com.koushikdutta.async.http;

import android.os.Build;
import com.google.android.gms.security.ProviderInstaller;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import java.lang.reflect.Field;
import java.util.Hashtable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/* loaded from: classes3.dex */
public class SSLEngineSNIConfigurator implements AsyncSSLEngineConfigurator {
    public Hashtable<String, EngineHolder> holders = new Hashtable<>();

    public static class EngineHolder implements AsyncSSLEngineConfigurator {
        public Field peerHost;
        public Field peerPort;
        public boolean skipReflection;
        public Field sslParameters;
        public Field useSni;

        public EngineHolder(Class cls) throws NoSuchFieldException {
            try {
                Field declaredField = cls.getSuperclass().getDeclaredField("peerHost");
                this.peerHost = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getSuperclass().getDeclaredField("peerPort");
                this.peerPort = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("sslParameters");
                this.sslParameters = declaredField3;
                declaredField3.setAccessible(true);
                Field declaredField4 = this.sslParameters.getType().getDeclaredField("useSni");
                this.useSni = declaredField4;
                declaredField4.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        }

        @Override // com.koushikdutta.async.http.AsyncSSLEngineConfigurator
        public void configureEngine(SSLEngine sSLEngine, AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i) throws IllegalAccessException, IllegalArgumentException {
            if (this.useSni == null || this.skipReflection) {
                return;
            }
            try {
                this.peerHost.set(sSLEngine, str);
                this.peerPort.set(sSLEngine, Integer.valueOf(i));
                this.useSni.set(this.sslParameters.get(sSLEngine), Boolean.TRUE);
            } catch (IllegalAccessException unused) {
            }
        }

        @Override // com.koushikdutta.async.http.AsyncSSLEngineConfigurator
        public SSLEngine createEngine(SSLContext sSLContext, String str, int i) {
            return null;
        }
    }

    @Override // com.koushikdutta.async.http.AsyncSSLEngineConfigurator
    public void configureEngine(SSLEngine sSLEngine, AsyncHttpClientMiddleware.GetSocketData getSocketData, String str, int i) throws IllegalAccessException, IllegalArgumentException {
        ensureHolder(sSLEngine).configureEngine(sSLEngine, getSocketData, str, i);
    }

    @Override // com.koushikdutta.async.http.AsyncSSLEngineConfigurator
    public SSLEngine createEngine(SSLContext sSLContext, String str, int i) {
        return ProviderInstaller.PROVIDER_NAME.equals(sSLContext.getProvider().getName()) || Build.VERSION.SDK_INT >= 23 ? sSLContext.createSSLEngine(str, i) : sSLContext.createSSLEngine();
    }

    public EngineHolder ensureHolder(SSLEngine sSLEngine) {
        String canonicalName = sSLEngine.getClass().getCanonicalName();
        EngineHolder engineHolder = this.holders.get(canonicalName);
        if (engineHolder != null) {
            return engineHolder;
        }
        EngineHolder engineHolder2 = new EngineHolder(sSLEngine.getClass());
        this.holders.put(canonicalName, engineHolder2);
        return engineHolder2;
    }
}
