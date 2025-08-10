package dc;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Languages;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.iqregister.packet.Registration;

/* compiled from: EventUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/utils/EventUtils;", "", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class wb0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: EventUtils.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001H\u0007¨\u0006\t"}, d2 = {"Lcom/component/dxtoy/core/utils/EventUtils$Companion;", "", "()V", "post", "", "event", Registration.Feature.ELEMENT, Languages.ANY, "unregister", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Object event) {
            Intrinsics.checkNotNullParameter(event, "event");
            EventBus.getDefault().post(event);
        }

        @JvmStatic
        public final void b(@NotNull Object any) {
            Intrinsics.checkNotNullParameter(any, "any");
            try {
                EventBus.getDefault().register(any);
            } catch (Exception unused) {
            }
        }

        @JvmStatic
        public final void c(@NotNull Object any) {
            Intrinsics.checkNotNullParameter(any, "any");
            try {
                EventBus.getDefault().unregister(any);
            } catch (Exception unused) {
            }
        }
    }

    @JvmStatic
    public static final void a(@NotNull Object obj) {
        a.a(obj);
    }

    @JvmStatic
    public static final void b(@NotNull Object obj) {
        a.b(obj);
    }
}
