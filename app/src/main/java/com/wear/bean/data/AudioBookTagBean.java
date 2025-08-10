package com.wear.bean.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioBookTagBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/wear/bean/data/AudioBookTagBean;", "", "data", "Lcom/wear/bean/data/AudioBookTagList;", "(Lcom/wear/bean/data/AudioBookTagList;)V", "getData", "()Lcom/wear/bean/data/AudioBookTagList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AudioBookTagBean {

    @NotNull
    private final AudioBookTagList data;

    public AudioBookTagBean(@NotNull AudioBookTagList data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public static /* synthetic */ AudioBookTagBean copy$default(AudioBookTagBean audioBookTagBean, AudioBookTagList audioBookTagList, int i, Object obj) {
        if ((i & 1) != 0) {
            audioBookTagList = audioBookTagBean.data;
        }
        return audioBookTagBean.copy(audioBookTagList);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final AudioBookTagList getData() {
        return this.data;
    }

    @NotNull
    public final AudioBookTagBean copy(@NotNull AudioBookTagList data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new AudioBookTagBean(data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AudioBookTagBean) && Intrinsics.areEqual(this.data, ((AudioBookTagBean) other).data);
    }

    @NotNull
    public final AudioBookTagList getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "AudioBookTagBean(data=" + this.data + ')';
    }
}
