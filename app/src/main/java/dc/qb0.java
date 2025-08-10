package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ToyCoreEum.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0001\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001a"}, d2 = {"Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$MotorFunction;", "", "rawValue", "", "valueRange", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/ranges/IntRange;)V", "getRawValue", "()Ljava/lang/String;", "getValueRange", "()Lkotlin/ranges/IntRange;", "VIBRATE", "VIBRATE1", "VIBRATE2", "VIBRATE3", "ROTATE", "SUCK", "PUMP", "THRUSTING", "FINGERING", "PAT", "DEPTH", "STROKE_START", "STROKE_END", "POSITION", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public enum qb0 {
    VIBRATE(PSOProgramService.VS_Key, new IntRange(0, 20)),
    VIBRATE1("v1", new IntRange(0, 20)),
    VIBRATE2("v2", new IntRange(0, 20)),
    VIBRATE3("v3", new IntRange(0, 20)),
    ROTATE(StreamManagement.AckRequest.ELEMENT, new IntRange(0, 20)),
    SUCK("s", new IntRange(0, 20)),
    PUMP("p", new IntRange(0, 3)),
    THRUSTING("t", new IntRange(0, 20)),
    FINGERING("f", new IntRange(0, 20)),
    PAT("a", new IntRange(0, 20)),
    DEPTH(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, new IntRange(0, 20)),
    STROKE_START("b", new IntRange(0, 20)),
    STROKE_END("c", new IntRange(0, 20)),
    POSITION("pos", new IntRange(0, 100));


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String rawValue;

    @NotNull
    private final IntRange valueRange;

    /* compiled from: ToyCoreEum.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$MotorFunction$Companion;", "", "()V", "fromRawValue", "Lcom/component/dxtoy/core/toy/constant/ToyCoreEum$MotorFunction;", "rawValue", "", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: dc.qb0$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final qb0 a(@Nullable String str) {
            if (str == null || str.length() == 0) {
                return null;
            }
            for (qb0 qb0Var : qb0.values()) {
                if (Intrinsics.areEqual(qb0Var.getRawValue(), str)) {
                    return qb0Var;
                }
            }
            return null;
        }
    }

    qb0(String str, IntRange intRange) {
        this.rawValue = str;
        this.valueRange = intRange;
    }

    @NotNull
    public final String getRawValue() {
        return this.rawValue;
    }

    @NotNull
    public final IntRange getValueRange() {
        return this.valueRange;
    }
}
