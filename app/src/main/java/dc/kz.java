package dc;

import kotlin.Metadata;

/* compiled from: TimeEum.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/component/dxhyttoutils/lib/data/TimeEum;", "", "millisecond", "", "(Ljava/lang/String;IJ)V", "getMillisecond", "()J", "ONE_SECOND", "FIVE_SECOND", "TEN_SECOND", "THIRTY_SECOND", "ONE_MINUTE", "FIVE_MINUTE", "TEN_MINUTE", "THIRTY_MINUTE", "ONE_HOUR", "ONE_DAY", "ONE_WEEK", "ONE_MONTH", "ONE_YEAR", "UNLIMITED", "hytto-apps.android.components.base:dxhyttoutils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public enum kz {
    ONE_SECOND(1000),
    FIVE_SECOND(5000),
    TEN_SECOND(10000),
    THIRTY_SECOND(30000),
    ONE_MINUTE(60000),
    FIVE_MINUTE(300000),
    TEN_MINUTE(600000),
    THIRTY_MINUTE(1800000),
    ONE_HOUR(3600000),
    ONE_DAY(86400000),
    ONE_WEEK(604800000),
    ONE_MONTH(-1702967296),
    ONE_YEAR(1492828928),
    UNLIMITED(0);

    private final long millisecond;

    kz(long j) {
        this.millisecond = j;
    }

    public final long getMillisecond() {
        return this.millisecond;
    }
}
