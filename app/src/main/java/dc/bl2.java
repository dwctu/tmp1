package dc;

import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.wear.bean.GetBindAccountBean;
import com.wear.bean.LangVersionBean;
import com.wear.bean.LanguageDataBean;
import com.wear.bean.NewGalleryList;
import com.wear.bean.RateConfigBean;
import com.wear.bean.RateInfoBean;
import com.wear.net.model.RemoteResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/* compiled from: CommandApiService.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ5\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/wear/net/service/CommandApiService;", "", "getBindingToken", "Lcom/wear/net/model/RemoteResult;", "Lcom/wear/bean/GetBindAccountBean;", CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY, "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGalleryDetailV3", "Lcom/wear/bean/NewGalleryList;", "getLangV3", "Lcom/wear/bean/LanguageDataBean;", "dtxToken", "cLanguage", "cVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLangVersion", "Lcom/wear/bean/LangVersionBean;", "ua", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRateConfigInfo", "Lcom/wear/bean/RateConfigBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readMessage", "", "Lcom/wear/bean/TestResultData;", "reportRateAction", "Lcom/wear/bean/RateInfoBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface bl2 {
    @GET("/api/remote/rate-dialog/config-info")
    @Nullable
    Object a(@NotNull Continuation<? super RemoteResult<RateConfigBean>> continuation);

    @POST("/api/remote/rate-dialog/operation-report")
    @Nullable
    Object b(@Body @NotNull Map<String, String> map, @NotNull Continuation<? super RemoteResult<RateInfoBean>> continuation);

    @POST("/api/remote/app_gallery/v3/detail")
    @Nullable
    Object c(@Body @NotNull Map<String, String> map, @NotNull Continuation<? super RemoteResult<NewGalleryList>> continuation);

    @GET("/date-web-api/appTranslationV3/remote/getLang")
    @Nullable
    Object d(@Header("dtxToken") @NotNull String str, @Header("cLanguage") @NotNull String str2, @Header("cVersion") @NotNull String str3, @NotNull Continuation<? super RemoteResult<LanguageDataBean>> continuation);

    @POST("api/user/third_login_get_binding_token")
    @Nullable
    Object e(@Body @NotNull Map<String, String> map, @NotNull Continuation<? super RemoteResult<GetBindAccountBean>> continuation);

    @GET("/date-web-api/appTranslationV3/remote/getVersion")
    @Nullable
    Object f(@Header("dtxToken") @NotNull String str, @NotNull Continuation<? super RemoteResult<LangVersionBean>> continuation);
}
