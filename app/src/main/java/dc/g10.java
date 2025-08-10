package dc;

import com.component.dxtoy.business.longc.aapattern.bean.AAPatternItemBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyAAPattern.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/business/longc/aapattern/ToyAAPattern;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class g10 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyAAPattern.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0014"}, d2 = {"Lcom/component/dxtoy/business/longc/aapattern/ToyAAPattern$Companion;", "", "()V", "addPattern", "", "mac", "", "pattern", "", "Lcom/component/dxtoy/business/longc/aapattern/bean/AAPatternItemBean;", "isRange100", "", "continuePlay", "pause", "readPatternStatus", "setPatternSpeed", "speed", "", "startPattern", "stop", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String mac, @NotNull List<AAPatternItemBean> pattern, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            h10.a.b(mac, z ? k10.WRITE_PATTERN_JUST_100 : k10.WRITE_PATTERN_JUST_20, pattern);
        }

        public final void b(@NotNull String mac, @NotNull List<AAPatternItemBean> pattern, boolean z) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            h10.a.b(mac, z ? k10.WRITE_PATTERN_CLEAR_RUN_100 : k10.WRITE_PATTERN_CLEAR_RUN_20, pattern);
        }

        public final void c(@NotNull String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            h10.a.a(mac, i10.STOP);
        }
    }
}
