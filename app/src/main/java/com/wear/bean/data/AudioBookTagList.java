package com.wear.bean.data;

import dc.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioBookTagBean.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/wear/bean/data/AudioBookTagList;", "", "list", "", "Lcom/wear/bean/data/TagList;", "lastUpdateTimestamp", "", "(Ljava/util/List;J)V", "getLastUpdateTimestamp", "()J", "getList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AudioBookTagList {
    private final long lastUpdateTimestamp;

    @NotNull
    private final List<TagList> list;

    public AudioBookTagList(@NotNull List<TagList> list, long j) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.lastUpdateTimestamp = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AudioBookTagList copy$default(AudioBookTagList audioBookTagList, List list, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = audioBookTagList.list;
        }
        if ((i & 2) != 0) {
            j = audioBookTagList.lastUpdateTimestamp;
        }
        return audioBookTagList.copy(list, j);
    }

    @NotNull
    public final List<TagList> component1() {
        return this.list;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }

    @NotNull
    public final AudioBookTagList copy(@NotNull List<TagList> list, long lastUpdateTimestamp) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new AudioBookTagList(list, lastUpdateTimestamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioBookTagList)) {
            return false;
        }
        AudioBookTagList audioBookTagList = (AudioBookTagList) other;
        return Intrinsics.areEqual(this.list, audioBookTagList.list) && this.lastUpdateTimestamp == audioBookTagList.lastUpdateTimestamp;
    }

    public final long getLastUpdateTimestamp() {
        return this.lastUpdateTimestamp;
    }

    @NotNull
    public final List<TagList> getList() {
        return this.list;
    }

    public int hashCode() {
        return (this.list.hashCode() * 31) + g.a(this.lastUpdateTimestamp);
    }

    @NotNull
    public String toString() {
        return "AudioBookTagList(list=" + this.list + ", lastUpdateTimestamp=" + this.lastUpdateTimestamp + ')';
    }
}
