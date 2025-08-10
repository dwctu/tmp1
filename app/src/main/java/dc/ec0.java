package dc;

import com.sun.jna.Callback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: INetworkEngine.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/component/dxtoy/turnover/listener/INetworkEngine;", "", "networkReportToyInfo", "", "data", "", "httpUrl", Callback.METHOD_NAME, "Lcom/component/dxtoy/turnover/listener/INetworkEngine$ICallback;", "ICallback", "turnover_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ec0 {

    /* compiled from: INetworkEngine.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/component/dxtoy/turnover/listener/INetworkEngine$ICallback;", "", "onError", "", XHTMLText.CODE, "", "error", "onSuccess", SaslStreamElements.Response.ELEMENT, "turnover_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a(@Nullable String str, @Nullable String str2);

        void b(@Nullable String str, @Nullable String str2);
    }

    void a(@NotNull String str, @Nullable String str2, @Nullable a aVar);
}
