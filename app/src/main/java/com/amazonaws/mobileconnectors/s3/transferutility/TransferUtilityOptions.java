package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.io.Serializable;

/* loaded from: classes.dex */
public class TransferUtilityOptions implements Serializable {
    public static final Log a = LogFactory.b(TransferUtilityOptions.class);
    private static final long serialVersionUID = 1;

    @Deprecated
    private long transferServiceCheckTimeInterval = a();
    private int transferThreadPoolSize = b();
    public TransferNetworkConnectionType transferNetworkConnectionType = c();
    private long minimumUploadPartSizeInBytes = CacheDataSink.DEFAULT_FRAGMENT_SIZE;

    @Deprecated
    public static long a() {
        return 60000L;
    }

    public static int b() {
        return (Runtime.getRuntime().availableProcessors() + 1) * 2;
    }

    public static TransferNetworkConnectionType c() {
        return TransferNetworkConnectionType.ANY;
    }

    public long d() {
        return this.minimumUploadPartSizeInBytes;
    }

    public TransferNetworkConnectionType e() {
        return this.transferNetworkConnectionType;
    }

    public int f() {
        return this.transferThreadPoolSize;
    }
}
