package dc;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.wear.bean.Pattern;
import io.reactivex.Flowable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NetworkClient.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JU\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\f0\u000b2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fJU\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\f0\u000b2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fJ<\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fJ<\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fJU\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\f0\u000b2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fJD\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fJD\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fJX\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fJU\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\f0\u000b2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u0004JD\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fJJ\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0!2\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/component/dxhttp/NetworkClient;", "", "()V", NotificationCompat.CATEGORY_SERVICE, "Lcom/component/dxhttp/NetService;", "delete", "Lio/reactivex/Flowable;", "Lokhttp3/ResponseBody;", ImagesContract.URL, "", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "Lkotlin/jvm/JvmSuppressWildcards;", "headerMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", Pattern.DOWNLOAD, "getFormRequest", "getJsonRequest", "postForm", "postGzip", "body", "Lokhttp3/RequestBody;", "postJson", "postUpload", "file", "Ljava/io/File;", "put", "setNetworkClient", "", "upload", "uploadMulti", "fileList", "", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class iy {

    @Nullable
    public gy a;

    @Nullable
    public final Flowable<bd4> a(@NotNull String url, @NotNull HashMap<String, String> headerMap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headerMap, "headerMap");
        gy gyVar = this.a;
        if (gyVar == null) {
            return null;
        }
        return gyVar.a(url, headerMap);
    }

    @Nullable
    public final Flowable<bd4> b(@NotNull String url, @NotNull HashMap<String, String> headerMap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headerMap, "headerMap");
        gy gyVar = this.a;
        if (gyVar == null) {
            return null;
        }
        return gyVar.b(url, headerMap);
    }

    @Nullable
    public final Flowable<bd4> c(@NotNull String url, @NotNull zc4 body, @NotNull HashMap<String, String> headerMap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(headerMap, "headerMap");
        gy gyVar = this.a;
        if (gyVar == null) {
            return null;
        }
        return gyVar.c(url, body, headerMap);
    }

    @Nullable
    public final Flowable<bd4> d(@NotNull String url, @NotNull zc4 body, @NotNull HashMap<String, String> headerMap) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(headerMap, "headerMap");
        gy gyVar = this.a;
        if (gyVar == null) {
            return null;
        }
        return gyVar.d(url, body, headerMap);
    }

    public final void e(@NotNull gy service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.a = service;
    }
}
