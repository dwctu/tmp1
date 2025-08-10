package dc;

import com.component.dxbilog.lib.manual.bean.response.BILogServerCodeResBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: BILogServerCodeSuspendedStrategy.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u001f\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogServerCodeSuspendedStrategy;", "", "()V", "BILOG_SERVER_CODE", "", "BILOG_SERVER_CODE_ERROR_COUNT", "", "BILOG_SERVER_CODE_TIME_INTERVAL", "value", "errorContinuousCount", "getErrorContinuousCount", "()I", "setErrorContinuousCount", "(I)V", "isServerCodeStop", "", "maybeCodeTimeByErrorContinuousCount", "", "maybeCodeTimeBySuccess", XHTMLText.CODE, "data", "Lcom/component/dxbilog/lib/manual/bean/response/BILogServerCodeResBean;", "(Ljava/lang/Integer;Lcom/component/dxbilog/lib/manual/bean/response/BILogServerCodeResBean;)V", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ys {

    @NotNull
    public static final ys a = new ys();
    public static volatile int b;

    public final boolean a() {
        return System.currentTimeMillis() <= me0.c("bilog_server_code_time_interval", 0L);
    }

    public final synchronized void b() {
        d(b + 1);
        if (b >= 10) {
            long jCurrentTimeMillis = System.currentTimeMillis() + 3600000;
            me0.h("bilog_server_code_time_interval", jCurrentTimeMillis);
            d(0);
            ms.a.a(Intrinsics.stringPlus("maybeCodeTimeByErrorContinuousCount codeTime = ", Long.valueOf(jCurrentTimeMillis)));
        }
    }

    public final void c(@Nullable Integer num, @Nullable BILogServerCodeResBean bILogServerCodeResBean) {
        d(0);
        if (num == null || num.intValue() != 299 || bILogServerCodeResBean == null) {
            return;
        }
        try {
            long timeInterval = bILogServerCodeResBean.getTimeInterval() * 1000;
            me0.h("bilog_server_code_time_interval", System.currentTimeMillis() + timeInterval);
            ms.a.a(Intrinsics.stringPlus("maybeCodeTimeBySuccess codeTime = ", Long.valueOf(timeInterval)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void d(int i) {
        b = i;
        if (ks.a.g()) {
            kd0.b("bilog_server_code_error_count", Integer.valueOf(i));
        }
    }
}
