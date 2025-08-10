package com.wear.main.account.login;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.lifecycle.MutableLiveData;
import com.lovense.wear.R;
import com.wear.BaseViewModel;
import com.wear.bean.GetBindAccountBean;
import com.wear.net.model.RemoteResponse;
import com.wear.net.model.RemoteResult;
import dc.ah4;
import dc.al2;
import dc.bl2;
import dc.sg3;
import dc.wg3;
import dc.wz3;
import dc.xf3;
import dc.xk2;
import dc.zk2;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThirdBindViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/wear/main/account/login/ThirdBindViewModel;", "Lcom/wear/BaseViewModel;", "()V", "bindingToken", "Landroidx/lifecycle/MutableLiveData;", "", "getBindingToken", "()Landroidx/lifecycle/MutableLiveData;", "setBindingToken", "(Landroidx/lifecycle/MutableLiveData;)V", "bindAccount", "", "email", "passWord", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/wear/main/account/login/ThirdBindAccountActivity;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ThirdBindViewModel extends BaseViewModel {

    @NotNull
    public MutableLiveData<String> a = new MutableLiveData<>();

    /* compiled from: ThirdBindViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.main.account.login.ThirdBindViewModel$bindAccount$1", f = "ThirdBindViewModel.kt", i = {0}, l = {20}, m = "invokeSuspend", n = {"isShowToast$iv$iv"}, s = {"I$0"})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ ThirdBindAccountActivity $activity;
        public final /* synthetic */ String $email;
        public final /* synthetic */ String $passEncrypt;
        public int I$0;
        public int label;
        public final /* synthetic */ ThirdBindViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ThirdBindAccountActivity thirdBindAccountActivity, String str, String str2, ThirdBindViewModel thirdBindViewModel, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$activity = thirdBindAccountActivity;
            this.$email = str;
            this.$passEncrypt = str2;
            this.this$0 = thirdBindViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$activity, this.$email, this.$passEncrypt, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    String str = this.$email;
                    String str2 = this.$passEncrypt;
                    bl2 bl2VarA = xk2.c.a();
                    StringBuilder sb = new StringBuilder();
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                    String lowerCase = str.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    sb.append(lowerCase);
                    sb.append("##");
                    sb.append(str2);
                    Map<String, String> mapMapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("emailOrUsername", str), TuplesKt.to("password", str2), TuplesKt.to("signature", wg3.b(sb.toString())));
                    this.I$0 = 1;
                    this.label = 1;
                    obj = bl2VarA.e(mapMapOf, this);
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
            GetBindAccountBean getBindAccountBean = (GetBindAccountBean) data;
            if (getBindAccountBean != null) {
                ThirdBindViewModel thirdBindViewModel = this.this$0;
                String bindingToken = getBindAccountBean.getBindingToken();
                if (bindingToken != null) {
                    thirdBindViewModel.c().postValue(bindingToken);
                }
            }
            this.$activity.dismissLoadingProgress();
            return Unit.INSTANCE;
        }
    }

    public final void b(@NotNull String email, @NotNull String passWord, @NotNull ThirdBindAccountActivity activity) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(passWord, "passWord");
        Intrinsics.checkNotNullParameter(activity, "activity");
        a(new a(activity, email, xf3.a(passWord, "009b72ee52c67697ee4290955ad91aa52172cf7494ce6cbfd711c4ce76efe9efad4a151174e774165944ba97b6d72934d6f04c53c1aef30b736c7cae8fb2638670efb89cdb4eb40d4ea6264fa3157e711c6d2779ce2cc4146d0cc7af7a2d7e5dec470862efb81bc541348cbb0176f3b75b0d842b36ffeec46070a6517f4330f883", "010001"), this, null));
    }

    @NotNull
    public final MutableLiveData<String> c() {
        return this.a;
    }
}
