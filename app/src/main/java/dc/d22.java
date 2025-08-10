package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.widget.control.FingImageLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExpandData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003Jc\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\u0013\u00103\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\tHÖ\u0001R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0015\"\u0004\b\u0018\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017¨\u00067"}, d2 = {"Lcom/wear/main/control/ExpandData;", "", "x", "", FingImageLayout.ObjectAnimatorY, TtmlNode.LEFT, "", "icon", "name", "", "isUnderPreview", TypedValues.TransitionType.S_DURATION, "", "position", "status", "(IIZILjava/lang/String;IJJZ)V", "getDuration", "()J", "setDuration", "(J)V", "getIcon", "()I", "setIcon", "(I)V", "setUnderPreview", "getLeft", "()Z", "setLeft", "(Z)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPosition", "setPosition", "getStatus", "setStatus", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: dc.d22, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ExpandData {

    /* renamed from: a, reason: from toString */
    public int x;

    /* renamed from: b, reason: from toString */
    public int y;

    /* renamed from: c, reason: from toString */
    public boolean left;

    /* renamed from: d, reason: from toString */
    public int icon;

    /* renamed from: e, reason: from toString */
    @NotNull
    public String name;

    /* renamed from: f, reason: from toString */
    public int isUnderPreview;

    /* renamed from: g, reason: from toString */
    public long duration;

    /* renamed from: h, reason: from toString */
    public long position;

    /* renamed from: i, reason: from toString */
    public boolean status;

    public ExpandData() {
        this(0, 0, false, 0, null, 0, 0L, 0L, false, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public ExpandData(int i, int i2, boolean z, int i3, @NotNull String name, int i4, long j, long j2, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.x = i;
        this.y = i2;
        this.left = z;
        this.icon = i3;
        this.name = name;
        this.isUnderPreview = i4;
        this.duration = j;
        this.position = j2;
        this.status = z2;
    }

    /* renamed from: a, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: b, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getLeft() {
        return this.left;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final long getPosition() {
        return this.position;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpandData)) {
            return false;
        }
        ExpandData expandData = (ExpandData) other;
        return this.x == expandData.x && this.y == expandData.y && this.left == expandData.left && this.icon == expandData.icon && Intrinsics.areEqual(this.name, expandData.name) && this.isUnderPreview == expandData.isUnderPreview && this.duration == expandData.duration && this.position == expandData.position && this.status == expandData.status;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* renamed from: g, reason: from getter */
    public final int getY() {
        return this.y;
    }

    /* renamed from: h, reason: from getter */
    public final int getIsUnderPreview() {
        return this.isUnderPreview;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = ((this.x * 31) + this.y) * 31;
        boolean z = this.left;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int iHashCode = (((((((((((i + i2) * 31) + this.icon) * 31) + this.name.hashCode()) * 31) + this.isUnderPreview) * 31) + g.a(this.duration)) * 31) + g.a(this.position)) * 31;
        boolean z2 = this.status;
        return iHashCode + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final void i(long j) {
        this.duration = j;
    }

    public final void j(int i) {
        this.icon = i;
    }

    public final void k(boolean z) {
        this.left = z;
    }

    public final void l(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void m(long j) {
        this.position = j;
    }

    public final void n(boolean z) {
        this.status = z;
    }

    public final void o(int i) {
        this.isUnderPreview = i;
    }

    public final void p(int i) {
        this.x = i;
    }

    public final void q(int i) {
        this.y = i;
    }

    @NotNull
    public String toString() {
        return "ExpandData(x=" + this.x + ", y=" + this.y + ", left=" + this.left + ", icon=" + this.icon + ", name=" + this.name + ", isUnderPreview=" + this.isUnderPreview + ", duration=" + this.duration + ", position=" + this.position + ", status=" + this.status + ')';
    }

    public /* synthetic */ ExpandData(int i, int i2, boolean z, int i3, String str, int i4, long j, long j2, boolean z2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? false : z, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? "" : str, (i5 & 32) == 0 ? i4 : 0, (i5 & 64) != 0 ? 0L : j, (i5 & 128) == 0 ? j2 : 0L, (i5 & 256) != 0 ? true : z2);
    }
}
