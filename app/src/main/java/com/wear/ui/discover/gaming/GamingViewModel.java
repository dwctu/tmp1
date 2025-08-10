package com.wear.ui.discover.gaming;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.wear.bean.GamingAdBean;
import com.wear.bean.NewGalleryList;
import com.wear.bean.NewGalleryListBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.net.model.RemoteResponse;
import com.wear.net.model.RemoteResult;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.al2;
import dc.bl2;
import dc.ro2;
import dc.sg3;
import dc.t23;
import dc.tn2;
import dc.uy3;
import dc.wz3;
import dc.xk2;
import dc.ye3;
import dc.zk2;
import dc.zn2;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: GamingViewModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u001a\u0010\u0012\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u000f0\u0013J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0015R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/wear/ui/discover/gaming/GamingViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "galleryDetailsV3", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/bean/NewGalleryList;", "getGalleryDetailsV3", "()Landroidx/lifecycle/MutableLiveData;", "setGalleryDetailsV3", "(Landroidx/lifecycle/MutableLiveData;)V", "galleryList", "", "getGalleryList", "setGalleryList", "getAdGamingLogoList", "", "context", "Landroid/content/Context;", Callback.METHOD_NAME, "Lkotlin/Function1;", "", "", "getGalleryListV2", "getGameDetail", "applicationId", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "postEmail", "email", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GamingViewModel extends ViewModel {

    @NotNull
    public MutableLiveData<List<NewGalleryList>> a = new MutableLiveData<>();

    @NotNull
    public MutableLiveData<NewGalleryList> b = new MutableLiveData<>();

    /* compiled from: GamingViewModel.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/wear/ui/discover/gaming/GamingViewModel$getAdGamingLogoList$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "Lcom/wear/bean/GamingAdBean;", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements zn2<BaseResponseBeanNew<GamingAdBean>> {
        public final /* synthetic */ Function1<List<String>, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super List<String>, Unit> function1) {
            this.a = function1;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable BaseResponseBeanNew<GamingAdBean> baseResponseBeanNew) {
            if (baseResponseBeanNew != null) {
                Function1<List<String>, Unit> function1 = this.a;
                GamingAdBean gamingAdBean = baseResponseBeanNew.data;
                function1.invoke(gamingAdBean != null ? gamingAdBean.getLogo() : null);
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: GamingViewModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/gaming/GamingViewModel$getGalleryListV2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements zn2<String> {
        public b() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            List<NewGalleryList> data;
            NewGalleryListBean newGalleryListBean = (NewGalleryListBean) WearUtils.A.fromJson(str, NewGalleryListBean.class);
            if (newGalleryListBean != null && (data = newGalleryListBean.getData()) != null) {
                GamingViewModel.this.c().postValue(data);
            }
            String str2 = "onSuccess===数据请求时间" + System.currentTimeMillis();
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            String str = "onError===数据请求时间" + System.currentTimeMillis();
        }
    }

    /* compiled from: GamingViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.gaming.GamingViewModel$getGameDetail$1", f = "GamingViewModel.kt", i = {0}, l = {78}, m = "invokeSuspend", n = {"isShowToast$iv$iv"}, s = {"I$0"})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ HashMap<String, String> $params;
        public int I$0;
        public int label;
        public final /* synthetic */ GamingViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HashMap<String, String> map, GamingViewModel gamingViewModel, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$params = map;
            this.this$0 = gamingViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(this.$params, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            RemoteResponse remoteResponseA;
            RemoteResult remoteResult;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    HashMap<String, String> map = this.$params;
                    bl2 bl2VarA = xk2.c.a();
                    this.I$0 = 1;
                    this.label = 1;
                    obj = bl2VarA.c(map, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i2 = this.I$0;
                    ResultKt.throwOnFailure(obj);
                }
                RemoteResult remoteResult2 = (RemoteResult) obj;
                if (remoteResult2.isSuccess()) {
                    remoteResponseA = new RemoteResponse.Success(remoteResult2);
                } else {
                    String message = remoteResult2.getMessage();
                    if (message == null) {
                        message = ah4.e(R.string.common_netError);
                    }
                    if (i2 != 0) {
                        sg3.l(message);
                    }
                    zk2.a.a(remoteResult2.getCode(), message);
                    remoteResponseA = new RemoteResponse.Error(Boxing.boxInt(remoteResult2.getCode()), message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                remoteResponseA = al2.a.a(e);
            }
            Object data = null;
            if ((remoteResponseA instanceof RemoteResponse.Success) && (remoteResult = (RemoteResult) ((RemoteResponse.Success) remoteResponseA).getData()) != null) {
                data = remoteResult.getData();
            }
            this.this$0.b().postValue((NewGalleryList) data);
            return Unit.INSTANCE;
        }
    }

    public final void a(@NotNull Context context, @NotNull Function1<? super List<String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        String strS = ye3.s();
        Intrinsics.checkNotNullExpressionValue(strS, "getAppVersionName()");
        linkedHashMap.put("version", strS);
        tn2.x(context).k("/discover/games/advertise", linkedHashMap, new a(callback));
    }

    @NotNull
    public final MutableLiveData<NewGalleryList> b() {
        return this.b;
    }

    @NotNull
    public final MutableLiveData<List<NewGalleryList>> c() {
        return this.a;
    }

    public final void d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap map = new HashMap();
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        String strS = ye3.s();
        Intrinsics.checkNotNullExpressionValue(strS, "getAppVersionName()");
        map.put("version", strS);
        map.put("supportXremoteApiVersion", t23.a.d());
        tn2.x(context).m("/api/remote/app_gallery/v3/select_application", ro2.c(map), new b());
    }

    public final void e(@Nullable String str, @Nullable String str2) {
        if (str == null || str.length() == 0) {
            return;
        }
        HashMap map = new HashMap();
        map.put("applicationId", str);
        if (str2 == null) {
            str2 = "";
        }
        map.put("applicationVersion", str2);
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new c(map, this, null), 3, null);
    }
}
