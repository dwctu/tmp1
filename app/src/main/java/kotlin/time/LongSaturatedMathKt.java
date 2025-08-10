package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;

/* compiled from: longSaturatedMath.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0001H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"checkInfiniteSumDefined", "", "longNs", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "durationNs", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAdd", "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAddInHalves", "saturatingAddInHalves-pTJri5U", "saturatingDiff", "valueNs", "originNs", "saturatingFiniteDiff", "value1Ns", "value2Ns", "saturatingOriginsDiff", "origin1Ns", "origin2Ns", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,75:1\n74#1:76\n74#1:77\n74#1:78\n74#1:79\n74#1:80\n74#1:81\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n15#1:76\n18#1:77\n36#1:78\n45#1:79\n52#1:80\n56#1:81\n*E\n"})
/* loaded from: classes4.dex */
public final class LongSaturatedMathKt {
    /* renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m1564checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m1469isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    private static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == Long.MAX_VALUE;
    }

    /* renamed from: saturatingAdd-pTJri5U, reason: not valid java name */
    public static final long m1565saturatingAddpTJri5U(long j, long j2) {
        long jM1457getInWholeNanosecondsimpl = Duration.m1457getInWholeNanosecondsimpl(j2);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return m1564checkInfiniteSumDefinedPjuGub4(j, j2, jM1457getInWholeNanosecondsimpl);
        }
        if ((1 | (jM1457getInWholeNanosecondsimpl - 1)) == Long.MAX_VALUE) {
            return m1566saturatingAddInHalvespTJri5U(j, j2);
        }
        long j3 = j + jM1457getInWholeNanosecondsimpl;
        return ((j ^ j3) & (jM1457getInWholeNanosecondsimpl ^ j3)) < 0 ? j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j3;
    }

    /* renamed from: saturatingAddInHalves-pTJri5U, reason: not valid java name */
    private static final long m1566saturatingAddInHalvespTJri5U(long j, long j2) {
        long jM1440divUwyO8pc = Duration.m1440divUwyO8pc(j2, 2);
        return (((Duration.m1457getInWholeNanosecondsimpl(jM1440divUwyO8pc) - 1) | 1) > Long.MAX_VALUE ? 1 : (((Duration.m1457getInWholeNanosecondsimpl(jM1440divUwyO8pc) - 1) | 1) == Long.MAX_VALUE ? 0 : -1)) == 0 ? (long) (j + Duration.m1480toDoubleimpl(j2, DurationUnit.NANOSECONDS)) : m1565saturatingAddpTJri5U(m1565saturatingAddpTJri5U(j, jM1440divUwyO8pc), Duration.m1472minusLRDsOJo(j2, jM1440divUwyO8pc));
    }

    public static final long saturatingDiff(long j, long j2) {
        return ((1 | (j2 - 1)) > Long.MAX_VALUE ? 1 : ((1 | (j2 - 1)) == Long.MAX_VALUE ? 0 : -1)) == 0 ? Duration.m1489unaryMinusUwyO8pc(DurationKt.toDuration(j2, DurationUnit.DAYS)) : saturatingFiniteDiff(j, j2);
    }

    private static final long saturatingFiniteDiff(long j, long j2) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) >= 0) {
            Duration.Companion companion = Duration.INSTANCE;
            return DurationKt.toDuration(j3, DurationUnit.NANOSECONDS);
        }
        long j4 = 1000000;
        long j5 = (j / j4) - (j2 / j4);
        long j6 = (j % j4) - (j2 % j4);
        Duration.Companion companion2 = Duration.INSTANCE;
        return Duration.m1473plusLRDsOJo(DurationKt.toDuration(j5, DurationUnit.MILLISECONDS), DurationKt.toDuration(j6, DurationUnit.NANOSECONDS));
    }

    public static final long saturatingOriginsDiff(long j, long j2) {
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            return j == j2 ? Duration.INSTANCE.m1539getZEROUwyO8pc() : Duration.m1489unaryMinusUwyO8pc(DurationKt.toDuration(j2, DurationUnit.DAYS));
        }
        return (1 | (j - 1)) == Long.MAX_VALUE ? DurationKt.toDuration(j, DurationUnit.DAYS) : saturatingFiniteDiff(j, j2);
    }
}
