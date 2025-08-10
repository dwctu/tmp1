package io.agora.rtm2.internal;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import io.agora.base.internal.BuildConfig;
import io.agora.rtm2.RtmClient;
import io.agora.rtm2.RtmConfig;
import io.agora.rtm2.StreamChannel;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class RtmClientImpl extends RtmClient {
    private static final String TAG = "RtmClientImpl";
    public static String nativeLibraryName = "agora-rtc-sdk";
    public static String nativeLibraryPrefix = "lib";
    public static String nativeLibrarySurffix = ".so";
    private static boolean sLibLoaded = false;
    private long mNativeHandle = 0;
    private HashSet<StreamChannelImpl> mChannels = new HashSet<>();

    public static String getNativeLibFullPath(String str, String str2) {
        String str3 = nativeLibraryPrefix + str2 + nativeLibrarySurffix;
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        String str4 = File.separator;
        if (str.endsWith(str4)) {
            return str + str3;
        }
        return str + str4 + str3;
    }

    public static synchronized boolean initializeNativeLibs() {
        return initializeNativeLibs(null);
    }

    public static synchronized boolean initializeNativeLibs(String str) {
        if (!sLibLoaded) {
            int i = 0;
            while (true) {
                List<String> list = BuildConfig.so_list;
                if (i >= list.size()) {
                    sLibLoaded = safeLoadLibrary(str, nativeLibraryName);
                    break;
                }
                boolean zSafeLoadLibrary = safeLoadLibrary(str, list.get(i));
                sLibLoaded = zSafeLoadLibrary;
                if (!zSafeLoadLibrary) {
                    return zSafeLoadLibrary;
                }
                i++;
            }
        }
        return sLibLoaded;
    }

    private native long nativeCreateStreamChannel(long j, String str);

    private static native int nativeDestroy(long j);

    private native int nativeInitialize(long j, RtmConfig rtmConfig);

    private native long nativeObjectInit();

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private static boolean safeLoadLibrary(String str, String str2) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                System.loadLibrary(str2);
            } else {
                System.load(getNativeLibFullPath(str, str2));
            }
            z = true;
        } catch (NullPointerException | SecurityException | Exception | UnsatisfiedLinkError unused) {
        }
        if (!z) {
            String str3 = "failed to load library " + str2 + " from " + str;
        }
        return z;
    }

    @Override // io.agora.rtm2.RtmClient
    public synchronized StreamChannel createStreamChannel(String str) throws RuntimeException {
        if (this.mNativeHandle == 0) {
            return null;
        }
        Iterator<StreamChannelImpl> it = this.mChannels.iterator();
        while (it.hasNext()) {
            StreamChannelImpl next = it.next();
            if (next != null && next.getChannelName().equals(str)) {
                return next;
            }
        }
        long jNativeCreateStreamChannel = nativeCreateStreamChannel(this.mNativeHandle, str);
        if (jNativeCreateStreamChannel == 0) {
            return null;
        }
        StreamChannelImpl streamChannelImpl = new StreamChannelImpl(jNativeCreateStreamChannel);
        this.mChannels.add(streamChannelImpl);
        streamChannelImpl.attach(this);
        return streamChannelImpl;
    }

    @Override // io.agora.rtm2.RtmClient
    public int initialize(RtmConfig rtmConfig) {
        String str;
        if (rtmConfig == null || rtmConfig.mEventHandler == null || (str = rtmConfig.mUserId) == null || TextUtils.isEmpty(str)) {
            return -2;
        }
        String str2 = rtmConfig.mAppId;
        if (str2 == null || TextUtils.isEmpty(str2)) {
            return -101;
        }
        if (this.mNativeHandle != 0) {
            return 0;
        }
        long jNativeObjectInit = nativeObjectInit();
        this.mNativeHandle = jNativeObjectInit;
        if (jNativeObjectInit == 0) {
            return -1;
        }
        return nativeInitialize(jNativeObjectInit, rtmConfig);
    }

    @Override // io.agora.rtm2.RtmClient
    public int releaseClient() {
        if (this.mNativeHandle != 0) {
            Iterator<StreamChannelImpl> it = this.mChannels.iterator();
            while (it.hasNext()) {
                StreamChannelImpl next = it.next();
                if (next != null) {
                    next.release();
                }
            }
            nativeDestroy(this.mNativeHandle);
            this.mNativeHandle = 0L;
        }
        this.mChannels.clear();
        return 0;
    }

    public void removeChannel(StreamChannelImpl streamChannelImpl) {
        if (streamChannelImpl != null) {
            this.mChannels.remove(streamChannelImpl);
        }
    }
}
