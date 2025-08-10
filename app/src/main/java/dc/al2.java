package dc;

import com.wear.net.model.RemoteResponse;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

/* compiled from: RemoteNetWorkErrorHandler.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fR0\u0010\u0003\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/wear/net/RemoteNetWorkErrorHandler;", "", "()V", "map", "", "", "kotlin.jvm.PlatformType", "getMap", "()Ljava/util/Map;", "setMap", "(Ljava/util/Map;)V", "handle", "Lcom/wear/net/model/RemoteResponse$Error;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class al2 {

    @NotNull
    public static final al2 a = new al2();

    @NotNull
    public static Map<String, String> b = MapsKt__MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(SocketTimeoutException.class).getSimpleName(), NetException.API_REQUEST_TIME_OUT), TuplesKt.to(Reflection.getOrCreateKotlinClass(HttpException.class).getSimpleName(), NetException.API_REQUEST_FAILED), TuplesKt.to(Reflection.getOrCreateKotlinClass(ConnectException.class).getSimpleName(), NetException.SERVER_REQUEST_FAILED), TuplesKt.to(Reflection.getOrCreateKotlinClass(TimeoutException.class).getSimpleName(), NetException.SOCKET_TIME_OUT), TuplesKt.to(Reflection.getOrCreateKotlinClass(SocketException.class).getSimpleName(), NetException.SOCKET_CONNECT_ERROR));

    @NotNull
    public final RemoteResponse.Error a(@NotNull Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!(e instanceof NullPointerException)) {
            ye3.d(b.get(Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName()), e.getMessage());
            String str = b.get(Reflection.getOrCreateKotlinClass(e.getClass()).getSimpleName());
            return new RemoteResponse.Error(Integer.valueOf(str != null ? str.hashCode() : 0), WearUtils.a2());
        }
        if (WearUtils.e1(WearUtils.t)) {
            ye3.d(NetException.LOCAL_UN_DEFINE_ERROR, e.getMessage());
            return new RemoteResponse.Error(Integer.valueOf(NetException.LOCAL_UN_DEFINE_ERROR.hashCode()), WearUtils.b2());
        }
        ye3.d(NetException.NULL_PORINT_ERROR, e.getMessage());
        return new RemoteResponse.Error(Integer.valueOf(NetException.NULL_PORINT_ERROR.hashCode()), WearUtils.b2());
    }
}
