package com.wear.main.account.rate;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.bean.Account;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.tn2;
import dc.yn2;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: RateFeedbackModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/wear/main/account/rate/RateFeedbackModel;", "Landroidx/lifecycle/ViewModel;", "()V", "error", "Landroidx/lifecycle/MutableLiveData;", "", "getError", "()Landroidx/lifecycle/MutableLiveData;", "setError", "(Landroidx/lifecycle/MutableLiveData;)V", "result", "Lcom/wear/network/presenter/bean/BaseResponseBean;", "getResult", "setResult", "submitEnquires", "", FirebaseAnalytics.Param.CONTENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RateFeedbackModel extends ViewModel {

    @NotNull
    public MutableLiveData<BaseResponseBean> a = new MutableLiveData<>();

    @NotNull
    public MutableLiveData<String> b = new MutableLiveData<>();

    /* compiled from: RateFeedbackModel.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/wear/main/account/rate/RateFeedbackModel$submitEnquires$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/network/presenter/bean/BaseResponseBean;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements yn2<BaseResponseBean> {
        public a() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable BaseResponseBean baseResponseBean) {
            RateFeedbackModel.this.b().postValue(baseResponseBean);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@NotNull NetException e) {
            Intrinsics.checkNotNullParameter(e, "e");
            RateFeedbackModel.this.a().postValue(e.message);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    @NotNull
    public final MutableLiveData<String> a() {
        return this.b;
    }

    @NotNull
    public final MutableLiveData<BaseResponseBean> b() {
        return this.a;
    }

    public final void c(@Nullable String str) {
        Account accountU = WearUtils.y.u();
        if (accountU == null) {
            return;
        }
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("name", accountU.getUserName());
        if (str == null) {
            str = "";
        }
        pairArr[1] = TuplesKt.to(FirebaseAnalytics.Param.CONTENT, str);
        pairArr[2] = TuplesKt.to("medias", "");
        pairArr[3] = TuplesKt.to("t", "5000158009");
        pairArr[4] = TuplesKt.to("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        pairArr[5] = TuplesKt.to("appType", "remote");
        pairArr[6] = TuplesKt.to("version", WearUtils.q);
        tn2.x(WearUtils.x).i("/sales/submitEnquires", MapsKt__MapsKt.mapOf(pairArr), new a());
    }
}
