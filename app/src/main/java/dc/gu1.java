package dc;

import com.wear.network.protocol.exception.NetException;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.Nullable;

/* compiled from: HttpCoroutine.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutineUpload$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", "result", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes3.dex */
public final class gu1 implements zn2<String> {
    public final /* synthetic */ yy3<String> a;

    /* JADX WARN: Multi-variable type inference failed */
    public gu1(yy3<? super String> yy3Var) {
        this.a = yy3Var;
    }

    @Override // dc.zn2
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onSuccess(@Nullable String str) {
        NormalResponse normalResponse;
        if (str == null || (normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class)) == null || !normalResponse.isResult()) {
            return;
        }
        yy3<String> yy3Var = this.a;
        Result.Companion companion = Result.INSTANCE;
        yy3Var.resumeWith(Result.m86constructorimpl(normalResponse.getMessage()));
    }

    @Override // dc.zn2
    public void onError(@Nullable NetException e) {
        yy3<String> yy3Var = this.a;
        Result.Companion companion = Result.INSTANCE;
        yy3Var.resumeWith(Result.m86constructorimpl(null));
    }
}
