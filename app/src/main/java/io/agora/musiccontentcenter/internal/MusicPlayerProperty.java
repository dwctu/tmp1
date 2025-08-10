package io.agora.musiccontentcenter.internal;

import io.agora.base.internal.CalledByNative;

/* loaded from: classes4.dex */
public class MusicPlayerProperty {
    public long handler;
    public int id;

    @CalledByNative
    public MusicPlayerProperty(long j, int i) {
        this.handler = j;
        this.id = i;
    }
}
