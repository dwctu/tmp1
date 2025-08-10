package dc;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import kotlin.Metadata;

/* compiled from: ToyCommandEum.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandEum$Level;", "", FirebaseAnalytics.Param.LEVEL, "", "(Ljava/lang/String;II)V", "getLevel", "()I", GrsBaseInfo.CountryCodeSource.UNKNOWN, "NORMAL", "CTRL_SINGLE", "CTRL_MULTI", "CTRL_LVS", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public enum na0 {
    UNKNOWN(-1),
    NORMAL(0),
    CTRL_SINGLE(101),
    CTRL_MULTI(102),
    CTRL_LVS(103);

    private final int level;

    na0(int i) {
        this.level = i;
    }

    public final int getLevel() {
        return this.level;
    }
}
