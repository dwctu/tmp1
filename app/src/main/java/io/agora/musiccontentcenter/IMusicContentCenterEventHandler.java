package io.agora.musiccontentcenter;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public interface IMusicContentCenterEventHandler {
    @CalledByNative
    void onLyricResult(String str, String str2, int i);

    @CalledByNative
    void onMusicChartsResult(String str, MusicChartInfo[] musicChartInfoArr, int i);

    @CalledByNative
    void onMusicCollectionResult(String str, int i, int i2, int i3, Music[] musicArr, int i4);

    @CalledByNative
    void onPreLoadEvent(long j, int i, String str, int i2, int i3);
}
