package dc;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceControlExt.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/VoskResult;", "", FirebaseAnalytics.Param.CONTENT, "", "showAlways", "", "(Ljava/lang/String;Z)V", "getContent", "()Ljava/lang/String;", "getShowAlways", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: dc.d13, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class VoskResult {

    /* renamed from: a, reason: from toString */
    @NotNull
    public final String content;

    /* renamed from: b, reason: from toString */
    public final boolean showAlways;

    public VoskResult(@NotNull String content, boolean z) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.showAlways = z;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getShowAlways() {
        return this.showAlways;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoskResult)) {
            return false;
        }
        VoskResult voskResult = (VoskResult) other;
        return Intrinsics.areEqual(this.content, voskResult.content) && this.showAlways == voskResult.showAlways;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.content.hashCode() * 31;
        boolean z = this.showAlways;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    @NotNull
    public String toString() {
        return "VoskResult(content=" + this.content + ", showAlways=" + this.showAlways + ')';
    }
}
