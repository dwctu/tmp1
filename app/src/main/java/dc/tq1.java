package dc;

import com.wear.bean.Toy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToyControlBuilder.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001:\u0001&B%\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B\u0011\b\u0016\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J1\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0010HÖ\u0001J,\u0010$\u001a\u00020\u00002$\u0010\u0011\u001a \u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0004\u0012\u00020\u00030\fJ\t\u0010%\u001a\u00020\u000fHÖ\u0001R^\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0014\"\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\t¨\u0006'"}, d2 = {"Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder;", "", "isRange100", "", "isStrength", "isMotorIgnoreFunction", "(ZZZ)V", "solaceProType", "Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder$SolaceProType;", "(Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder$SolaceProType;)V", "(ZZZLcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder$SolaceProType;)V", "<set-?>", "Lkotlin/Function2;", "Lcom/wear/bean/Toy;", "", "", "", "interceptor", "getInterceptor", "()Lkotlin/jvm/functions/Function2;", "()Z", "setMotorIgnoreFunction", "(Z)V", "setRange100", "setStrength", "getSolaceProType", "()Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder$SolaceProType;", "setSolaceProType", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "setInterceptor", "toString", "SolaceProType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: dc.tq1, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ToyControlBuilder {

    /* renamed from: a, reason: from toString */
    public boolean isRange100;

    /* renamed from: b, reason: from toString */
    public boolean isStrength;

    /* renamed from: c, reason: from toString */
    public boolean isMotorIgnoreFunction;

    /* renamed from: d, reason: from toString */
    @NotNull
    public a solaceProType;

    @Nullable
    public Function2<? super Toy, ? super Map<String, Integer>, Boolean> e;

    /* compiled from: ToyControlBuilder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/wear/component/dxtoy/command/control/bean/ToyControlBuilder$SolaceProType;", "", "(Ljava/lang/String;I)V", "SPEED", "POSITION", "SETTING_ONLY", "SETTING_FIRST", "PATTERN_LONG", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: dc.tq1$a */
    public enum a {
        SPEED,
        POSITION,
        SETTING_ONLY,
        SETTING_FIRST,
        PATTERN_LONG
    }

    public ToyControlBuilder() {
        this(false, false, false, null, 15, null);
    }

    public ToyControlBuilder(boolean z, boolean z2, boolean z3, @NotNull a solaceProType) {
        Intrinsics.checkNotNullParameter(solaceProType, "solaceProType");
        this.isRange100 = z;
        this.isStrength = z2;
        this.isMotorIgnoreFunction = z3;
        this.solaceProType = solaceProType;
    }

    @Nullable
    public final Function2<Toy, Map<String, Integer>, Boolean> a() {
        return this.e;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final a getSolaceProType() {
        return this.solaceProType;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsMotorIgnoreFunction() {
        return this.isMotorIgnoreFunction;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsRange100() {
        return this.isRange100;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsStrength() {
        return this.isStrength;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToyControlBuilder)) {
            return false;
        }
        ToyControlBuilder toyControlBuilder = (ToyControlBuilder) other;
        return this.isRange100 == toyControlBuilder.isRange100 && this.isStrength == toyControlBuilder.isStrength && this.isMotorIgnoreFunction == toyControlBuilder.isMotorIgnoreFunction && this.solaceProType == toyControlBuilder.solaceProType;
    }

    @NotNull
    public final ToyControlBuilder f(@NotNull Function2<? super Toy, ? super Map<String, Integer>, Boolean> interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.e = interceptor;
        return this;
    }

    public final void g(boolean z) {
        this.isRange100 = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.isRange100;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.isStrength;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z2 = this.isMotorIgnoreFunction;
        return ((i3 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.solaceProType.hashCode();
    }

    @NotNull
    public String toString() {
        return "ToyControlBuilder(isRange100=" + this.isRange100 + ", isStrength=" + this.isStrength + ", isMotorIgnoreFunction=" + this.isMotorIgnoreFunction + ", solaceProType=" + this.solaceProType + ')';
    }

    public /* synthetic */ ToyControlBuilder(boolean z, boolean z2, boolean z3, a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? a.SPEED : aVar);
    }

    public ToyControlBuilder(boolean z, boolean z2, boolean z3) {
        this(z, z2, z3, a.SPEED);
    }

    public /* synthetic */ ToyControlBuilder(a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? a.SPEED : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ToyControlBuilder(@NotNull a solaceProType) {
        this(false, true, false, solaceProType);
        Intrinsics.checkNotNullParameter(solaceProType, "solaceProType");
    }
}
