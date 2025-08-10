package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.broadcom.bt.util.io.FilenameUtils;
import kotlin.Metadata;
import kotlin.SinceKotlin;

/* compiled from: TimeSources.kt */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalTime
/* loaded from: classes4.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    /* renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1571overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt__DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m1486toStringimpl(duration)) + FilenameUtils.EXTENSION_SEPARATOR);
    }

    /* renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1572plusAssignLRDsOJo(long duration) {
        long j;
        long jM1483toLongimpl = Duration.m1483toLongimpl(duration, getUnit());
        if (jM1483toLongimpl == Long.MIN_VALUE || jM1483toLongimpl == Long.MAX_VALUE) {
            double dM1480toDoubleimpl = this.reading + Duration.m1480toDoubleimpl(duration, getUnit());
            if (dM1480toDoubleimpl > 9.223372036854776E18d || dM1480toDoubleimpl < -9.223372036854776E18d) {
                m1571overflowLRDsOJo(duration);
            }
            j = (long) dM1480toDoubleimpl;
        } else {
            long j2 = this.reading;
            j = j2 + jM1483toLongimpl;
            if ((jM1483toLongimpl ^ j2) >= 0 && (j2 ^ j) < 0) {
                m1571overflowLRDsOJo(duration);
            }
        }
        this.reading = j;
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* renamed from: read, reason: from getter */
    public long getReading() {
        return this.reading;
    }
}
