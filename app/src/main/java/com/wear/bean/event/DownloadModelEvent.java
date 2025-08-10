package com.wear.bean.event;

import dc.x03;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DownloadModelEvent.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/wear/bean/event/DownloadModelEvent;", "", "status", "Lcom/wear/ui/discover/voicecontrol/ModelStorageService$DownloadStatus;", "(Lcom/wear/ui/discover/voicecontrol/ModelStorageService$DownloadStatus;)V", "getStatus", "()Lcom/wear/ui/discover/voicecontrol/ModelStorageService$DownloadStatus;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DownloadModelEvent {

    @NotNull
    private final x03.b status;

    public DownloadModelEvent(@NotNull x03.b status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
    }

    public static /* synthetic */ DownloadModelEvent copy$default(DownloadModelEvent downloadModelEvent, x03.b bVar, int i, Object obj) {
        if ((i & 1) != 0) {
            bVar = downloadModelEvent.status;
        }
        return downloadModelEvent.copy(bVar);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final x03.b getStatus() {
        return this.status;
    }

    @NotNull
    public final DownloadModelEvent copy(@NotNull x03.b status) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new DownloadModelEvent(status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DownloadModelEvent) && this.status == ((DownloadModelEvent) other).status;
    }

    @NotNull
    public final x03.b getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.status.hashCode();
    }

    @NotNull
    public String toString() {
        return "DownloadModelEvent(status=" + this.status + ')';
    }
}
