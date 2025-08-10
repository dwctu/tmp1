package com.wear.ui.discover.xremote.model;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.wear.bean.XRemoteAppUserBean;
import com.wear.bean.XRemoteCreateUserBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.sg3;
import dc.tn2;
import dc.uy3;
import dc.wz3;
import dc.zn2;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Subscription;

/* compiled from: XRemoteCreateCustomUserModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/wear/ui/discover/xremote/model/XRemoteCreateCustomUserModel;", "Landroidx/lifecycle/ViewModel;", "()V", "account", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "getAccount", "()Landroidx/lifecycle/MutableLiveData;", "account$delegate", "Lkotlin/Lazy;", "createCustomUser", "Lrx/Subscription;", "username", "", "context", "Landroid/content/Context;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class XRemoteCreateCustomUserModel extends ViewModel {

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: XRemoteCreateCustomUserModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<MutableLiveData<XRemoteAppUserBean.DataBean.ApplicationAccount>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<XRemoteAppUserBean.DataBean.ApplicationAccount> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: XRemoteCreateCustomUserModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/xremote/model/XRemoteCreateCustomUserModel$createCustomUser$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", "data", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements zn2<String> {

        /* compiled from: XRemoteCreateCustomUserModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.xremote.model.XRemoteCreateCustomUserModel$createCustomUser$1$onSuccess$1$1", f = "XRemoteCreateCustomUserModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ XRemoteCreateUserBean $xRemoteCreateUserBean;
            public int label;
            public final /* synthetic */ XRemoteCreateCustomUserModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(XRemoteCreateUserBean xRemoteCreateUserBean, XRemoteCreateCustomUserModel xRemoteCreateCustomUserModel, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$xRemoteCreateUserBean = xRemoteCreateUserBean;
                this.this$0 = xRemoteCreateCustomUserModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$xRemoteCreateUserBean, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.$xRemoteCreateUserBean.getResult()) {
                    this.this$0.b().postValue(this.$xRemoteCreateUserBean.getData());
                } else {
                    sg3.l(this.$xRemoteCreateUserBean.getMessage());
                }
                return Unit.INSTANCE;
            }
        }

        public b() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            if (str != null) {
                XRemoteCreateCustomUserModel xRemoteCreateCustomUserModel = XRemoteCreateCustomUserModel.this;
                uy3.d(ViewModelKt.getViewModelScope(xRemoteCreateCustomUserModel), null, null, new a((XRemoteCreateUserBean) WearUtils.A.fromJson(str, XRemoteCreateUserBean.class), xRemoteCreateCustomUserModel, null), 3, null);
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            sg3.l(e != null ? e.message : null);
        }
    }

    @NotNull
    public final Subscription a(@NotNull String username, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap map = new HashMap();
        map.put("username", username);
        Subscription subscriptionM = tn2.x(context).m("/api/remote/application/set_custom_username", WearUtils.A.toJson(map), new b());
        Intrinsics.checkNotNullExpressionValue(subscriptionM, "fun createCustomUser(use…\n                })\n    }");
        return subscriptionM;
    }

    @NotNull
    public final MutableLiveData<XRemoteAppUserBean.DataBean.ApplicationAccount> b() {
        return (MutableLiveData) this.a.getValue();
    }
}
