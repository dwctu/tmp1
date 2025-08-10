package dc;

import com.google.android.exoplayer2.upstream.DataSpec;

/* compiled from: CacheKeyFactory.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class ny0 {
    public static /* synthetic */ String a(DataSpec dataSpec) {
        String str = dataSpec.key;
        return str != null ? str : dataSpec.uri.toString();
    }
}
