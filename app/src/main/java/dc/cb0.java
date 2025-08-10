package dc;

import androidx.core.app.NotificationCompat;
import com.component.dxtoy.core.commandcore.bean.ToyCommandBean;
import dc.oa0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyCommandResendStrategy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandResendStrategy;", "", "()V", "Companion", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class cb0 {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ToyCommandResendStrategy.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bJ*\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\u0006H\u0002¨\u0006\u0013"}, d2 = {"Lcom/component/dxtoy/core/commandcore/strategy/ToyCommandResendStrategy$Companion;", "", "()V", "checkResend", "Lkotlin/Pair;", "", "", "command", "Lcom/component/dxtoy/core/commandcore/bean/ToyCommandBean;", "isCanResend", "resendLimit", "maybeResendHandle", "commandBean", "resend", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* compiled from: ToyCommandResendStrategy.kt */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/component/dxtoy/core/commandcore/strategy/ToyCommandResendStrategy$Companion$maybeResendHandle$1$1", "Lcom/component/dxbluetooth/lib/response/BleWriteResponse;", "onError", "", XHTMLText.CODE, "Lcom/component/dxbluetooth/lib/data/BleEum$Result;", NotificationCompat.CATEGORY_MESSAGE, "", "onResponse", "data", "", "(Lcom/component/dxbluetooth/lib/data/BleEum$Result;Ljava/lang/Integer;)V", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: dc.cb0$a$a, reason: collision with other inner class name */
        public static final class C0166a implements fw {
            public final /* synthetic */ ToyCommandBean a;
            public final /* synthetic */ int b;

            public C0166a(ToyCommandBean toyCommandBean, int i) {
                this.a = toyCommandBean;
                this.b = i;
            }

            @Override // dc.qt
            public void b(@NotNull mt code, @Nullable String str) {
                Intrinsics.checkNotNullParameter(code, "code");
                cb0.a.e(this.a, code, str, this.b);
            }

            @Override // dc.qt
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(@NotNull mt code, @Nullable Integer num) {
                Intrinsics.checkNotNullParameter(code, "code");
                this.a.onResponse(code, num);
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pair<Boolean, Integer> b(ToyCommandBean toyCommandBean) {
            for (oa0 oa0Var : toyCommandBean.getSendTypeList$core_release()) {
                if (oa0Var instanceof oa0.c) {
                    return new Pair<>(Boolean.TRUE, Integer.valueOf(((oa0.c) oa0Var).getA()));
                }
            }
            return new Pair<>(Boolean.FALSE, 0);
        }

        public final boolean c(ToyCommandBean toyCommandBean, int i) {
            return toyCommandBean.getSendCount() <= i;
        }

        public final boolean d(@NotNull ToyCommandBean commandBean) {
            Intrinsics.checkNotNullParameter(commandBean, "commandBean");
            Pair<Boolean, Integer> pairB = b(commandBean);
            boolean zBooleanValue = pairB.component1().booleanValue();
            int iIntValue = pairB.component2().intValue();
            if (!zBooleanValue) {
                return false;
            }
            xa0.c.a(commandBean, new C0166a(commandBean, iIntValue));
            return true;
        }

        public final void e(ToyCommandBean toyCommandBean, mt mtVar, String str, int i) {
            if (!c(toyCommandBean, i)) {
                toyCommandBean.onError(mtVar, str);
            } else {
                toyCommandBean.addSendType(new oa0.d(true));
                ia0.a.d().c(toyCommandBean);
            }
        }
    }
}
