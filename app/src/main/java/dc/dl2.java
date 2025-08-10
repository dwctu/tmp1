package dc;

import com.wear.bean.ReportControlRouleteeBean;
import com.wear.bean.RouletteBan;
import com.wear.bean.RouletteLimit;
import com.wear.net.model.RemoteResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* compiled from: ToyRouletteApiService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J#\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/wear/net/service/ToyRouletteApiService;", "", "queryRouletteReportBanInfo", "Lcom/wear/net/model/RemoteResult;", "Lcom/wear/bean/RouletteBan;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryRouletteReportBanLimit", "Lcom/wear/bean/RouletteLimit;", "reportControlRoueletee", "", "reportControlRouleteeBean", "Lcom/wear/bean/ReportControlRouleteeBean;", "(Lcom/wear/bean/ReportControlRouleteeBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public interface dl2 {
    @POST("/api/remote/control-roulette/report/ban-info")
    @Nullable
    Object a(@NotNull Continuation<? super RemoteResult<RouletteBan>> continuation);

    @POST("/api/remote/control-roulette/report/ban-limit")
    @Nullable
    Object b(@NotNull Continuation<? super RemoteResult<RouletteLimit>> continuation);

    @POST("/api/remote/control-roulette/report/submit")
    @Nullable
    Object c(@Body @NotNull ReportControlRouleteeBean reportControlRouleteeBean, @NotNull Continuation<? super RemoteResult<String>> continuation);
}
