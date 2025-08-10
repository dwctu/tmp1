package dc;

import com.wear.bean.InviteLink;
import com.wear.bean.official.OfficialMessageBean;
import com.wear.bean.official.OfficialSetInfo;
import com.wear.net.model.RemoteResult;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: LongDistanceApiService.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005JE\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0019\b\u0001\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\u0002\b\u0013H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J2\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0019\b\u0001\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/wear/net/service/LongDistanceApiService;", "", "getInviteLinkCreate", "Lcom/wear/net/model/RemoteResult;", "Lcom/wear/bean/InviteLink;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOfficialAccountMsgList", "Lcom/wear/bean/official/OfficialMessageBean;", "latestMsgId", "", "oldestMsgId", "userTimezoneOffset", "", "pullNew", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageSettings", "map", "", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySettings", "Lcom/wear/bean/official/OfficialSetInfo;", "reportingInformation", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface cl2 {
    @POST("/api/remote/official-account/report")
    @Nullable
    Object a(@Body @NotNull Map<String, Object> map, @NotNull Continuation<? super RemoteResult<Object>> continuation);

    @GET("/api/remote/official-account/pull-msg")
    @Nullable
    Object b(@Nullable @Query("latestMsgId") String str, @Nullable @Query("oldestMsgId") String str2, @Nullable @Query("userTimezoneOffset") Integer num, @Query("pullNew") boolean z, @NotNull Continuation<? super RemoteResult<OfficialMessageBean>> continuation);

    @GET(" /invite_link/create_new")
    @Nullable
    Object c(@NotNull Continuation<? super RemoteResult<InviteLink>> continuation);

    @POST("/api/remote/official-account/edit-setting")
    @Nullable
    Object d(@Body @NotNull Map<String, Boolean> map, @NotNull Continuation<? super RemoteResult<Object>> continuation);

    @GET("/api/remote/official-account/setting-info")
    @Nullable
    Object e(@NotNull Continuation<? super RemoteResult<OfficialSetInfo>> continuation);
}
