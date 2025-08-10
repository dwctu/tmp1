package dc;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceControlExt.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/ScaleVolume;", "", "command", "", "value", "", "(Ljava/lang/String;I)V", "getCommand", "()Ljava/lang/String;", "getValue", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: dc.z03, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ScaleVolume {

    /* renamed from: a, reason: from toString */
    @NotNull
    public final String command;

    /* renamed from: b, reason: from toString */
    public final int value;

    public ScaleVolume(@NotNull String command, int i) {
        Intrinsics.checkNotNullParameter(command, "command");
        this.command = command;
        this.value = i;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCommand() {
        return this.command;
    }

    /* renamed from: b, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScaleVolume)) {
            return false;
        }
        ScaleVolume scaleVolume = (ScaleVolume) other;
        return Intrinsics.areEqual(this.command, scaleVolume.command) && this.value == scaleVolume.value;
    }

    public int hashCode() {
        return (this.command.hashCode() * 31) + this.value;
    }

    @NotNull
    public String toString() {
        return "ScaleVolume(command=" + this.command + ", value=" + this.value + ')';
    }
}
