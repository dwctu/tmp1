package dc;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LanApiOfPatternV2.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/wear/main/server/PatternItem;", "", "ts", "", "pos", "(II)V", "getPos", "()I", "getTs", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: dc.jf2, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class PatternItem {

    /* renamed from: a, reason: from toString */
    public final int ts;

    /* renamed from: b, reason: from toString */
    public final int pos;

    public PatternItem(int i, int i2) {
        this.ts = i;
        this.pos = i2;
    }

    /* renamed from: a, reason: from getter */
    public final int getPos() {
        return this.pos;
    }

    /* renamed from: b, reason: from getter */
    public final int getTs() {
        return this.ts;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) other;
        return this.ts == patternItem.ts && this.pos == patternItem.pos;
    }

    public int hashCode() {
        return (this.ts * 31) + this.pos;
    }

    @NotNull
    public String toString() {
        return "PatternItem(ts=" + this.ts + ", pos=" + this.pos + ')';
    }
}
