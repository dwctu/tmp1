package dc;

import com.component.dxtoy.business.longc.aapattern.bean.AAPatternItemBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ToyCmdAAPattern.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/business/longc/aapattern/ToyCmdAAPattern;", "", "()V", "Companion", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class h10 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCmdAAPattern.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¨\u0006\u0013"}, d2 = {"Lcom/component/dxtoy/business/longc/aapattern/ToyCmdAAPattern$Companion;", "", "()V", "readPatternStatus", "", "mac", "", "setPatternPlayAction", "state", "Lcom/component/dxtoy/business/longc/data/AAEum$PlayState;", "setPatternSpeed", "speed", "", "writePattern", "type", "Lcom/component/dxtoy/business/longc/data/AAEum$Type;", "pattern", "", "Lcom/component/dxtoy/business/longc/aapattern/bean/AAPatternItemBean;", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String mac, @NotNull i10 state) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(state, "state");
            m10.b.f(mac, k10.PLAY_PATTERN_ACTION.getCode(), CollectionsKt__CollectionsJVMKt.listOf(new byte[]{state.getCode()}));
        }

        public final void b(@NotNull String mac, @NotNull k10 type, @NotNull List<AAPatternItemBean> pattern) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = pattern.iterator();
            while (it.hasNext()) {
                arrayList.add(((AAPatternItemBean) it.next()).toElement(type));
            }
            m10.b.f(mac, type.getCode(), arrayList);
        }
    }
}
