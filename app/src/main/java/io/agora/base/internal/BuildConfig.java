package io.agora.base.internal;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class BuildConfig {
    public static final boolean FEATURE_ENABLE_VIDEO = true;
    public static final List<String> so_list = Arrays.asList("agora-core", "agora-ffmpeg", "agora-fdkaac", "agora-soundtouch");

    private BuildConfig() {
        throw new IllegalStateException("Utility class");
    }
}
