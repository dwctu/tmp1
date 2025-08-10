package com.wear.bean.chat;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceFilesBean.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/wear/bean/chat/VoiceFilesBean;", "", "voiceFile", "Ljava/io/File;", "voiceDuration", "", "(Ljava/io/File;I)V", "getVoiceDuration", "()I", "getVoiceFile", "()Ljava/io/File;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VoiceFilesBean {
    private final int voiceDuration;

    @NotNull
    private final File voiceFile;

    public VoiceFilesBean(@NotNull File voiceFile, int i) {
        Intrinsics.checkNotNullParameter(voiceFile, "voiceFile");
        this.voiceFile = voiceFile;
        this.voiceDuration = i;
    }

    public static /* synthetic */ VoiceFilesBean copy$default(VoiceFilesBean voiceFilesBean, File file, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            file = voiceFilesBean.voiceFile;
        }
        if ((i2 & 2) != 0) {
            i = voiceFilesBean.voiceDuration;
        }
        return voiceFilesBean.copy(file, i);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final File getVoiceFile() {
        return this.voiceFile;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVoiceDuration() {
        return this.voiceDuration;
    }

    @NotNull
    public final VoiceFilesBean copy(@NotNull File voiceFile, int voiceDuration) {
        Intrinsics.checkNotNullParameter(voiceFile, "voiceFile");
        return new VoiceFilesBean(voiceFile, voiceDuration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceFilesBean)) {
            return false;
        }
        VoiceFilesBean voiceFilesBean = (VoiceFilesBean) other;
        return Intrinsics.areEqual(this.voiceFile, voiceFilesBean.voiceFile) && this.voiceDuration == voiceFilesBean.voiceDuration;
    }

    public final int getVoiceDuration() {
        return this.voiceDuration;
    }

    @NotNull
    public final File getVoiceFile() {
        return this.voiceFile;
    }

    public int hashCode() {
        return (this.voiceFile.hashCode() * 31) + this.voiceDuration;
    }

    @NotNull
    public String toString() {
        return "VoiceFilesBean(voiceFile=" + this.voiceFile + ", voiceDuration=" + this.voiceDuration + ')';
    }
}
