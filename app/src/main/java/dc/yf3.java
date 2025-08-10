package dc;

import android.app.Activity;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.bean.FeatureConfig;
import com.wear.bean.RateConfigBean;
import com.wear.bean.RateFeature;
import com.wear.bean.RateInfoBean;
import com.wear.bean.RateRecordBean;
import com.wear.ext.ActivityKt;
import com.wear.main.closeRange.RemoteMultiControlActivity;
import com.wear.main.longDistance.ChatActivity;
import com.wear.main.longDistance.ChatRoomActivity;
import com.wear.net.model.RemoteResponse;
import com.wear.net.model.RemoteResult;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.ui.chat.NewChatActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkEndActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RateUtil.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020\u0014J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\u0017J\u0010\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010\u0017J\u0006\u0010(\u001a\u00020\u0014J\u001f\u0010)\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/wear/util/RateUtil;", "", "()V", "SP_LOCAL_RATE_INFO_KEY", "", "TAG", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isReported", "", "isShowedDialog", "rateConfigBean", "Lcom/wear/bean/RateConfigBean;", "rateRecordBean", "Lcom/wear/bean/RateRecordBean;", "scorePopupWindow", "Lcom/wear/widget/dialog/RatePopupWindow;", "checkTask", "name", "clearLocalRateInfo", "", "getConfig", "getLocalRateInfo", "Lcom/wear/bean/RateInfoBean;", "init", "isGoogleServiceAvailable", "isShowRateDialog", "rateFeature", "Lcom/wear/bean/RateFeature;", TypedValues.TransitionType.S_DURATION, "", "notifyDismissPopup", "notifyPopup", "onActivityDestroyed", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "putLocalRateInfo", "rateInfoBean", "reportAction", "retaInfo", "reset", "setRecordRateBean", "(Lcom/wear/bean/RateFeature;Ljava/lang/Integer;)V", "showRatePopupWindow", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class yf3 {

    @NotNull
    public static final b i = new b(null);

    @NotNull
    public static final Lazy<yf3> j = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) a.a);

    @NotNull
    public final String a;

    @NotNull
    public final String b;

    @NotNull
    public final wz3 c;

    @Nullable
    public RateConfigBean d;

    @Nullable
    public RateRecordBean e;
    public boolean f;
    public boolean g;

    @Nullable
    public ks3 h;

    /* compiled from: RateUtil.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/util/RateUtil;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<yf3> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final yf3 invoke() {
            return new yf3(null);
        }
    }

    /* compiled from: RateUtil.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/wear/util/RateUtil$Companion;", "", "()V", DefaultSettingsSpiCall.INSTANCE_PARAM, "Lcom/wear/util/RateUtil;", "getInstance", "()Lcom/wear/util/RateUtil;", "instance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final yf3 a() {
            return (yf3) yf3.j.getValue();
        }
    }

    /* compiled from: RateUtil.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RateFeature.values().length];
            iArr[RateFeature.Live.ordinal()] = 1;
            iArr[RateFeature.Sync.ordinal()] = 2;
            iArr[RateFeature.Video.ordinal()] = 3;
            iArr[RateFeature.Voice.ordinal()] = 4;
            iArr[RateFeature.GroupSync.ordinal()] = 5;
            iArr[RateFeature.GroupDS.ordinal()] = 6;
            iArr[RateFeature.ControlLink.ordinal()] = 7;
            iArr[RateFeature.ControlRoulette.ordinal()] = 8;
            a = iArr;
        }
    }

    /* compiled from: RateUtil.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.util.RateUtil$getConfig$1", f = "RateUtil.kt", i = {0}, l = {75}, m = "invokeSuspend", n = {"isShowToast$iv$iv"}, s = {"I$0"})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int I$0;
        public Object L$0;
        public int label;

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return yf3.this.new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0041 A[Catch: Exception -> 0x0015, TryCatch #0 {Exception -> 0x0015, blocks: (B:6:0x0011, B:17:0x0039, B:19:0x0041, B:20:0x0047, B:22:0x004d, B:24:0x0056, B:25:0x0059), top: B:37:0x0011 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0047 A[Catch: Exception -> 0x0015, TryCatch #0 {Exception -> 0x0015, blocks: (B:6:0x0011, B:17:0x0039, B:19:0x0041, B:20:0x0047, B:22:0x004d, B:24:0x0056, B:25:0x0059), top: B:37:0x0011 }] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                int r2 = r5.I$0
                java.lang.Object r0 = r5.L$0
                dc.yf3 r0 = (dc.yf3) r0
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L15
                goto L39
            L15:
                r6 = move-exception
                goto L75
            L17:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1f:
                kotlin.ResultKt.throwOnFailure(r6)
                dc.yf3 r6 = dc.yf3.this
                dc.xk2$a r1 = dc.xk2.c     // Catch: java.lang.Exception -> L71
                dc.bl2 r1 = r1.a()     // Catch: java.lang.Exception -> L71
                r5.L$0 = r6     // Catch: java.lang.Exception -> L71
                r5.I$0 = r2     // Catch: java.lang.Exception -> L71
                r5.label = r2     // Catch: java.lang.Exception -> L71
                java.lang.Object r1 = r1.a(r5)     // Catch: java.lang.Exception -> L71
                if (r1 != r0) goto L37
                return r0
            L37:
                r0 = r6
                r6 = r1
            L39:
                com.wear.net.model.RemoteResult r6 = (com.wear.net.model.RemoteResult) r6     // Catch: java.lang.Exception -> L15
                boolean r1 = r6.isSuccess()     // Catch: java.lang.Exception -> L15
                if (r1 == 0) goto L47
                com.wear.net.model.RemoteResponse$Success r1 = new com.wear.net.model.RemoteResponse$Success     // Catch: java.lang.Exception -> L15
                r1.<init>(r6)     // Catch: java.lang.Exception -> L15
                goto L7e
            L47:
                java.lang.String r1 = r6.getMessage()     // Catch: java.lang.Exception -> L15
                if (r1 != 0) goto L54
                r1 = 2131886634(0x7f12022a, float:1.9407852E38)
                java.lang.String r1 = dc.ah4.e(r1)     // Catch: java.lang.Exception -> L15
            L54:
                if (r2 == 0) goto L59
                dc.sg3.l(r1)     // Catch: java.lang.Exception -> L15
            L59:
                dc.zk2 r2 = dc.zk2.a     // Catch: java.lang.Exception -> L15
                int r3 = r6.getCode()     // Catch: java.lang.Exception -> L15
                r2.a(r3, r1)     // Catch: java.lang.Exception -> L15
                com.wear.net.model.RemoteResponse$Error r2 = new com.wear.net.model.RemoteResponse$Error     // Catch: java.lang.Exception -> L15
                int r6 = r6.getCode()     // Catch: java.lang.Exception -> L15
                java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch: java.lang.Exception -> L15
                r2.<init>(r6, r1)     // Catch: java.lang.Exception -> L15
                r1 = r2
                goto L7e
            L71:
                r0 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
            L75:
                r6.printStackTrace()
                dc.al2 r1 = dc.al2.a
                com.wear.net.model.RemoteResponse$Error r1 = r1.a(r6)
            L7e:
                boolean r6 = r1 instanceof com.wear.net.model.RemoteResponse.Success
                r2 = 0
                if (r6 == 0) goto L91
                com.wear.net.model.RemoteResponse$Success r1 = (com.wear.net.model.RemoteResponse.Success) r1
                java.lang.Object r6 = r1.getData()
                com.wear.net.model.RemoteResult r6 = (com.wear.net.model.RemoteResult) r6
                if (r6 == 0) goto L91
                java.lang.Object r2 = r6.getData()
            L91:
                com.wear.bean.RateConfigBean r2 = (com.wear.bean.RateConfigBean) r2
                dc.yf3.e(r0, r2)
                dc.yf3 r6 = dc.yf3.this
                dc.yf3.d(r6)
                dc.yf3 r6 = dc.yf3.this
                com.wear.bean.RateConfigBean r6 = dc.yf3.c(r6)
                java.lang.String.valueOf(r6)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.yf3.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: RateUtil.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.util.RateUtil$reportAction$1$1", f = "RateUtil.kt", i = {0}, l = {108}, m = "invokeSuspend", n = {"isShowToast$iv"}, s = {"I$0"})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Map<String, String> $params;
        public int I$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Map<String, String> map, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$params = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return yf3.this.new e(this.$params, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            RemoteResponse remoteResponseA;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Map<String, String> map = this.$params;
                    bl2 bl2VarA = xk2.c.a();
                    this.I$0 = 1;
                    this.label = 1;
                    obj = bl2VarA.b(map, this);
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
                RemoteResult remoteResult = (RemoteResult) obj;
                if (remoteResult.isSuccess()) {
                    remoteResponseA = new RemoteResponse.Success(remoteResult);
                } else {
                    String message = remoteResult.getMessage();
                    if (message == null) {
                        message = ah4.e(R.string.common_netError);
                    }
                    if (i2 != 0) {
                        sg3.l(message);
                    }
                    zk2.a.a(remoteResult.getCode(), message);
                    remoteResponseA = new RemoteResponse.Error(Boxing.boxInt(remoteResult.getCode()), message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                remoteResponseA = al2.a.a(e);
            }
            if (remoteResponseA instanceof RemoteResponse.Success) {
                yf3.this.g();
                String unused = yf3.this.a;
            } else {
                String unused2 = yf3.this.a;
                String str = "report error" + ((RemoteResponse.Error) remoteResponseA).getMessage();
            }
            return Unit.INSTANCE;
        }
    }

    public yf3() {
        this.a = "RateUtil";
        this.b = "rate_info";
        this.c = xz3.a(n04.c());
    }

    public /* synthetic */ yf3(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean f(String str) {
        Iterator<T> it = ActivityKt.d().iterator();
        while (it.hasNext()) {
            String localClassName = ((Activity) it.next()).getLocalClassName();
            Intrinsics.checkNotNullExpressionValue(localClassName, "it.localClassName");
            if (StringsKt__StringsKt.contains$default((CharSequence) localClassName, (CharSequence) str, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public final void g() {
        LoginUserBean loginUserBean = ch3.n().a;
        if (loginUserBean != null) {
            eg3.m(WearUtils.x, this.b + '_' + loginUserBean.getRemoteAccountId());
        }
    }

    public final void h() {
        if (k()) {
            uy3.d(this.c, n04.b(), null, new d(null), 2, null);
        }
    }

    public final RateInfoBean i() {
        LoginUserBean loginUserBean = ch3.n().a;
        if (loginUserBean == null) {
            return null;
        }
        Object objB = eg3.b(WearUtils.x, this.b + '_' + loginUserBean.getRemoteAccountId(), "");
        Intrinsics.checkNotNull(objB, "null cannot be cast to non-null type kotlin.String");
        String str = (String) objB;
        if (!(str.length() > 0)) {
            return null;
        }
        RateInfoBean rateInfoBean = (RateInfoBean) WearUtils.A.fromJson(str, RateInfoBean.class);
        String str2 = "getLocalRateInfo: " + rateInfoBean;
        return rateInfoBean;
    }

    public final void j() {
        h();
        RateInfoBean rateInfoBeanI = i();
        String str = "init: " + rateInfoBeanI;
        if (rateInfoBeanI != null) {
            q(rateInfoBeanI);
        }
    }

    public final boolean k() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Intrinsics.checkNotNullExpressionValue(googleApiAvailability, "getInstance()");
        return googleApiAvailability.isGooglePlayServicesAvailable(WearUtils.x) == 0;
    }

    public final boolean l(RateFeature rateFeature, int i2) {
        RateConfigBean rateConfigBean;
        ArrayList arrayList;
        List<FeatureConfig> featureConfigs;
        if (!k() || !MyApplication.P || this.f || this.g || (rateConfigBean = this.d) == null) {
            return false;
        }
        if ((rateConfigBean == null || rateConfigBean.getNeedShowDialog()) ? false : true) {
            return false;
        }
        RateConfigBean rateConfigBean2 = this.d;
        if (rateConfigBean2 == null || (featureConfigs = rateConfigBean2.getFeatureConfigs()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj : featureConfigs) {
                if (Intrinsics.areEqual(((FeatureConfig) obj).getFeature(), rateFeature.getFeature())) {
                    arrayList.add(obj);
                }
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        FeatureConfig featureConfig = (FeatureConfig) arrayList.get(0);
        return featureConfig.getRatingEnable() && featureConfig.getDuration() <= ((long) i2) && i() == null;
    }

    public final void m() {
        ks3 ks3Var = this.h;
        if (ks3Var == null || !ks3Var.isShowing()) {
            return;
        }
        ks3Var.dismiss();
    }

    public final void n() {
        t();
    }

    public final void o(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if ((activity instanceof RemoteMultiControlActivity) || (activity instanceof ChatActivity) || (activity instanceof ChatRoomActivity) || (activity instanceof NewChatActivity) || (activity instanceof ControlLinkEndActivity)) {
            n();
        }
    }

    public final void p(@Nullable RateInfoBean rateInfoBean) {
        LoginUserBean loginUserBean;
        if (rateInfoBean == null || (loginUserBean = ch3.n().a) == null) {
            return;
        }
        eg3.i(WearUtils.x, this.b + '_' + loginUserBean.getRemoteAccountId(), WearUtils.A.toJson(rateInfoBean));
        StringBuilder sb = new StringBuilder();
        sb.append("putLocalRateInfo: ");
        sb.append(rateInfoBean);
        sb.toString();
    }

    public final void q(@Nullable RateInfoBean rateInfoBean) {
        this.g = true;
        if (rateInfoBean != null) {
            String str = "reportAction: " + rateInfoBean;
            uy3.d(this.c, n04.b(), null, new e(MapsKt__MapsKt.mapOf(TuplesKt.to("operationTime", String.valueOf(rateInfoBean.getOperationTime())), TuplesKt.to("dialogFeature", rateInfoBean.getDialogFeature()), TuplesKt.to("rateApp", String.valueOf(rateInfoBean.getRateApp()))), null), 2, null);
        }
    }

    public final void r() {
        this.f = false;
        this.g = false;
        this.e = null;
        this.d = null;
        m();
        this.h = null;
    }

    public final void s(@Nullable RateFeature rateFeature, @Nullable Integer num) {
        if (rateFeature == null || num == null || this.e != null || !l(rateFeature, num.intValue())) {
            return;
        }
        this.e = new RateRecordBean(rateFeature, num.intValue());
        String str = "setRecordRateBean:" + this.e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t() {
        /*
            r7 = this;
            java.util.LinkedList r0 = com.wear.ext.ActivityKt.d()
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r0)
            android.app.Activity r0 = (android.app.Activity) r0
            if (r0 != 0) goto Ld
            return
        Ld:
            boolean r1 = r0.isFinishing()
            if (r1 != 0) goto L9d
            boolean r1 = r0.isDestroyed()
            if (r1 == 0) goto L1b
            goto L9d
        L1b:
            com.wear.bean.RateRecordBean r1 = r7.e
            if (r1 == 0) goto L9d
            com.wear.bean.RateFeature r2 = r1.getRateFeature()
            int[] r3 = dc.yf3.c.a
            int r2 = r2.ordinal()
            r2 = r3[r2]
            java.lang.String r3 = "ChatRoomActivity"
            r4 = 0
            java.lang.String r5 = "ChatActivity"
            r6 = 1
            switch(r2) {
                case 1: goto L4b;
                case 2: goto L4b;
                case 3: goto L4b;
                case 4: goto L4b;
                case 5: goto L4b;
                case 6: goto L4b;
                case 7: goto L4b;
                case 8: goto L36;
                default: goto L34;
            }
        L34:
            r4 = 1
            goto L58
        L36:
            boolean r2 = r7.f(r5)
            if (r2 == 0) goto L58
            boolean r2 = r7.f(r3)
            if (r2 == 0) goto L58
            java.lang.String r2 = "NewChatActivity"
            boolean r2 = r7.f(r2)
            if (r2 == 0) goto L58
            goto L34
        L4b:
            boolean r2 = r7.f(r5)
            if (r2 == 0) goto L58
            boolean r2 = r7.f(r3)
            if (r2 == 0) goto L58
            goto L34
        L58:
            if (r4 == 0) goto L9d
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L78
            dc.ks3 r2 = new dc.ks3     // Catch: java.lang.Throwable -> L78
            com.wear.bean.RateFeature r1 = r1.getRateFeature()     // Catch: java.lang.Throwable -> L78
            r2.<init>(r0, r1)     // Catch: java.lang.Throwable -> L78
            r7.h = r2     // Catch: java.lang.Throwable -> L78
            if (r2 == 0) goto L6c
            r2.v()     // Catch: java.lang.Throwable -> L78
        L6c:
            r7.f = r6     // Catch: java.lang.Throwable -> L78
            r0 = 0
            r7.e = r0     // Catch: java.lang.Throwable -> L78
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L78
            java.lang.Object r0 = kotlin.Result.m86constructorimpl(r0)     // Catch: java.lang.Throwable -> L78
            goto L83
        L78:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m86constructorimpl(r0)
        L83:
            java.lang.Throwable r0 = kotlin.Result.m89exceptionOrNullimpl(r0)
            if (r0 == 0) goto L9d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "showRatePopupWindow error: "
            r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            r1.toString()
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.yf3.t():void");
    }
}
