package com.wear.ui.longDistance.officialaccount;

import android.content.Context;
import android.os.Build;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.wear.BaseViewModel;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.official.OfficialAcount;
import com.wear.bean.official.OfficialLangInfo;
import com.wear.bean.official.OfficialLangMsgBean;
import com.wear.bean.official.OfficialMsg;
import com.wear.bean.official.OfficialSetInfo;
import com.wear.dao.DaoUtils;
import com.wear.net.model.RemoteResponse;
import com.wear.net.model.RemoteResult;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.protocol.CommunMessage;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.al2;
import dc.ch3;
import dc.cl2;
import dc.eg3;
import dc.n04;
import dc.sg3;
import dc.sy3;
import dc.uy3;
import dc.wz3;
import dc.xk2;
import dc.ye3;
import dc.zk2;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialaCountModel.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 R2\u00020\u0001:\u0001RB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0011\u0010)\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020,0\u00182\u0006\u0010-\u001a\u00020\u0014J\u0010\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201J\b\u00102\u001a\u0004\u0018\u00010\u0019J\u001a\u00103\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00104\u001a\u0004\u0018\u000105J\b\u00106\u001a\u0004\u0018\u00010\u0014J\b\u00107\u001a\u000208H\u0002J\u0006\u00109\u001a\u000208J\u0006\u0010:\u001a\u00020;J\u0018\u0010<\u001a\u00020;2\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010>J\u001e\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020\u0004H\u0002J\n\u0010B\u001a\u0004\u0018\u00010\u0019H\u0002J\u001f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010D\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010EJ'\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010G\u001a\u00020\"2\u0006\u0010A\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010HJ\b\u0010I\u001a\u00020;H\u0002J\b\u0010J\u001a\u00020\nH\u0002J\u000e\u0010K\u001a\u00020;2\u0006\u00104\u001a\u00020\"J\u000e\u0010L\u001a\u00020;2\u0006\u0010D\u001a\u00020\u0004J'\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010G\u001a\u00020\"2\u0006\u0010A\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010HJ\u000e\u0010N\u001a\u00020;2\u0006\u0010A\u001a\u00020\u0004J\u001f\u0010O\u001a\u00020;2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0006\u0010Q\u001a\u00020;R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u001cR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006S"}, d2 = {"Lcom/wear/ui/longDistance/officialaccount/OfficialaCountModel;", "Lcom/wear/BaseViewModel;", "()V", "hasNewMessageNotification", "", "getHasNewMessageNotification", "()Z", "setHasNewMessageNotification", "(Z)V", "lastMsgId", "", "getLastMsgId", "()J", "setLastMsgId", "(J)V", "lastTime", "getLastTime", "setLastTime", "officialCountLivedata", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/bean/official/OfficialAcount;", "getOfficialCountLivedata", "()Landroidx/lifecycle/MutableLiveData;", "officialaMessageList", "", "Lcom/wear/bean/official/OfficialMsg;", "getOfficialaMessageList", "setOfficialaMessageList", "(Landroidx/lifecycle/MutableLiveData;)V", "setting", "Lcom/wear/bean/official/OfficialSetInfo;", "getSetting", "setSetting", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "adjustData", "list", "clearToDB", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compareOfficialCount", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "newOfficialCount", "getLatestLangMessageInfor", "Lcom/wear/bean/official/OfficialLangInfo;", "context", "Landroid/content/Context;", "getLatestMessage", "getMessageInfo", "lang", "Lcom/wear/bean/official/OfficialLangMsgBean;", "getOfficialaCount", "getOffsetTime", "", "getUnreadMessage", "initOfficialaCount", "", "messageSettings", Callback.METHOD_NAME, "Lkotlin/Function0;", "queryDataBase", "pageSize", "pullNew", "queryLatestNews", "queryMessageFromDatabaseAndServer", "isLoding", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMessageFromServer", "msgId", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySettings", "queryUnreadMessage", "reportingInformation", "requestHistoryMessageList", "requestMessageServer", "requestNewMessageList", "saveToDB", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMessageRead", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class OfficialaCountModel extends BaseViewModel {

    @NotNull
    public static final b g = new b(null);

    @NotNull
    public static final Lazy<OfficialaCountModel> h = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) a.a);

    @NotNull
    public MutableLiveData<List<OfficialMsg>> a = new MutableLiveData<>();

    @NotNull
    public MutableLiveData<OfficialSetInfo> b = new MutableLiveData<>();

    @NotNull
    public String c = "";

    @NotNull
    public final MutableLiveData<OfficialAcount> d = new MutableLiveData<>();
    public long e;
    public long f;

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/ui/longDistance/officialaccount/OfficialaCountModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<OfficialaCountModel> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final OfficialaCountModel invoke() {
            return new OfficialaCountModel();
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/wear/ui/longDistance/officialaccount/OfficialaCountModel$Companion;", "", "()V", "sIntance", "Lcom/wear/ui/longDistance/officialaccount/OfficialaCountModel;", "getSIntance", "()Lcom/wear/ui/longDistance/officialaccount/OfficialaCountModel;", "sIntance$delegate", "Lkotlin/Lazy;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OfficialaCountModel a() {
            return (OfficialaCountModel) OfficialaCountModel.h.getValue();
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel", f = "OfficialaCountModel.kt", i = {0}, l = {186}, m = "clearToDB", n = {"this"}, s = {"L$0"})
    public static final class c extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfficialaCountModel.this.j(this);
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel$clearToDB$2", f = "OfficialaCountModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<wz3, Continuation<? super Boolean>, Object> {
        public int label;

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OfficialaCountModel.this.new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Boolean> continuation) {
            return ((d) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Integer numDeleteAll = DaoUtils.getOfficialaMessageDao().deleteAll(OfficialaCountModel.this.getC());
            return Boxing.boxBoolean(numDeleteAll != null && numDeleteAll.intValue() > 0);
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel$messageSettings$1", f = "OfficialaCountModel.kt", i = {0}, l = {398}, m = "invokeSuspend", n = {"isShowToast$iv"}, s = {"I$0"})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function0<Unit> $callback;
        public final /* synthetic */ HashMap<String, Boolean> $params;
        public int I$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Function0<Unit> function0, HashMap<String, Boolean> map, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$callback = function0;
            this.$params = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OfficialaCountModel.this.new e(this.$callback, this.$params, continuation);
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
            int i;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    HashMap<String, Boolean> map = this.$params;
                    cl2 cl2VarB = xk2.c.b();
                    this.I$0 = 1;
                    this.label = 1;
                    obj = cl2VarB.d(map, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i = 1;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = this.I$0;
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
                    if (i != 0) {
                        sg3.l(message);
                    }
                    zk2.a.a(remoteResult.getCode(), message);
                    remoteResponseA = new RemoteResponse.Error(Boxing.boxInt(remoteResult.getCode()), message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                remoteResponseA = al2.a.a(e);
            }
            if (!(remoteResponseA instanceof RemoteResponse.Success)) {
                return Unit.INSTANCE;
            }
            OfficialAcount value = OfficialaCountModel.this.o().getValue();
            if (value != null) {
                OfficialSetInfo value2 = OfficialaCountModel.this.s().getValue();
                value.setSetTop(value2 != null && value2.getStickyToTop() ? 1L : 0L);
            }
            OfficialAcount value3 = OfficialaCountModel.this.o().getValue();
            if (value3 != null) {
                OfficialSetInfo value4 = OfficialaCountModel.this.s().getValue();
                value3.setMuteFlag((value4 == null || !value4.getOfficialMsgMuteNotification()) ? 0 : 1);
            }
            Function0<Unit> function0 = this.$callback;
            if (function0 != null) {
                function0.invoke();
            }
            OfficialaCountModel.this.o().postValue(OfficialaCountModel.this.o().getValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel", f = "OfficialaCountModel.kt", i = {0}, l = {246}, m = "queryMessageFromDatabaseAndServer", n = {"this"}, s = {"L$0"})
    public static final class f extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfficialaCountModel.this.A(false, this);
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel", f = "OfficialaCountModel.kt", i = {0, 0, 1, 1, 1}, l = {277, 279}, m = "queryMessageFromServer", n = {"this", "pullNew", "this", "serverDataList", "pullNew"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0"})
    public static final class g extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfficialaCountModel.this.B(null, false, this);
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel$querySettings$1", f = "OfficialaCountModel.kt", i = {0}, l = {335}, m = "invokeSuspend", n = {"isShowToast$iv$iv"}, s = {"I$0"})
    public static final class h extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int I$0;
        public int label;

        public h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OfficialaCountModel.this.new h(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object error;
            RemoteResult remoteResult;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    cl2 cl2VarB = xk2.c.b();
                    this.I$0 = 1;
                    this.label = 1;
                    obj = cl2VarB.e(this);
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
                    error = new RemoteResponse.Success(remoteResult2);
                } else {
                    String message = remoteResult2.getMessage();
                    if (message == null) {
                        message = ah4.e(R.string.common_netError);
                    }
                    if (i2 != 0) {
                        sg3.l(message);
                    }
                    zk2.a.a(remoteResult2.getCode(), message);
                    error = new RemoteResponse.Error(Boxing.boxInt(remoteResult2.getCode()), message);
                }
            } catch (Exception e) {
                e.printStackTrace();
                error = al2.a.a(e);
            }
            Object data = null;
            if ((error instanceof RemoteResponse.Success) && (remoteResult = (RemoteResult) ((RemoteResponse.Success) error).getData()) != null) {
                data = remoteResult.getData();
            }
            OfficialSetInfo officialSetInfo = (OfficialSetInfo) data;
            if (officialSetInfo == null) {
                return Unit.INSTANCE;
            }
            OfficialaCountModel.this.s().postValue(officialSetInfo);
            OfficialAcount value = OfficialaCountModel.this.o().getValue();
            if (value != null) {
                value.setSetTop(officialSetInfo.getStickyToTop() ? 1L : 0L);
            }
            OfficialAcount value2 = OfficialaCountModel.this.o().getValue();
            if (value2 != null) {
                value2.setMuteFlag(officialSetInfo.getOfficialMsgMuteNotification() ? 1 : 0);
            }
            OfficialaCountModel.this.o().postValue(OfficialaCountModel.this.o().getValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel$reportingInformation$1", f = "OfficialaCountModel.kt", i = {0}, l = {374}, m = "invokeSuspend", n = {"isShowToast$iv$iv"}, s = {"I$0"})
    public static final class i extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ HashMap<String, Object> $params;
        public int I$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(HashMap<String, Object> map, Continuation<? super i> continuation) {
            super(2, continuation);
            this.$params = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new i(this.$params, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((i) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
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
                    HashMap<String, Object> map = this.$params;
                    cl2 cl2VarB = xk2.c.b();
                    this.I$0 = 1;
                    this.label = 1;
                    obj = cl2VarB.a(map, this);
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
            if ((remoteResponseA instanceof RemoteResponse.Success) && (remoteResult = (RemoteResult) ((RemoteResponse.Success) remoteResponseA).getData()) != null) {
                remoteResult.getData();
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel$requestHistoryMessageList$1", f = "OfficialaCountModel.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
    public static final class j extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean $isLoding;
        public Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(boolean z, Continuation<? super j> continuation) {
            super(2, continuation);
            this.$isLoding = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OfficialaCountModel.this.new j(this.$isLoding, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((j) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            OfficialaCountModel officialaCountModel;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                OfficialaCountModel officialaCountModel2 = OfficialaCountModel.this;
                boolean z = this.$isLoding;
                this.L$0 = officialaCountModel2;
                this.label = 1;
                Object objA = officialaCountModel2.A(z, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                officialaCountModel = officialaCountModel2;
                obj = objA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                officialaCountModel = (OfficialaCountModel) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            OfficialaCountModel.b(officialaCountModel, list);
            if (list.size() > 0) {
                OfficialaCountModel officialaCountModel3 = OfficialaCountModel.this;
                OfficialMsg officialMsg = (OfficialMsg) CollectionsKt___CollectionsKt.lastOrNull(list);
                officialaCountModel3.L(officialMsg != null ? officialMsg.getUserReceiveTime() : 0L);
            }
            List<OfficialMsg> value = OfficialaCountModel.this.q().getValue();
            if (value != null) {
                Boxing.boxBoolean(value.addAll(0, list));
            }
            OfficialaCountModel.this.q().postValue(OfficialaCountModel.this.q().getValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel", f = "OfficialaCountModel.kt", i = {0, 0, 0}, l = {300}, m = "requestMessageServer", n = {"this", "pullNew", "isShowToast$iv$iv"}, s = {"L$0", "Z$0", "I$0"})
    public static final class k extends ContinuationImpl {
        public int I$0;
        public Object L$0;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfficialaCountModel.this.G(null, false, this);
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel$requestNewMessageList$1", f = "OfficialaCountModel.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
    public static final class l extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean $pullNew;
        public Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(boolean z, Continuation<? super l> continuation) {
            super(2, continuation);
            this.$pullNew = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OfficialaCountModel.this.new l(this.$pullNew, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((l) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            OfficialaCountModel officialaCountModel;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String strH = eg3.h(MyApplication.N(), "officiala_message_" + OfficialaCountModel.this.getC(), "");
                Intrinsics.checkNotNullExpressionValue(strH, "getString(\n             …         \"\"\n            )");
                OfficialaCountModel officialaCountModel2 = OfficialaCountModel.this;
                boolean z = this.$pullNew;
                this.L$0 = officialaCountModel2;
                this.label = 1;
                obj = officialaCountModel2.B(strH, z, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                officialaCountModel = officialaCountModel2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                officialaCountModel = (OfficialaCountModel) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            OfficialaCountModel.b(officialaCountModel, list);
            if (!list.isEmpty()) {
                OfficialaCountModel.this.J(false);
                OfficialAcount value = OfficialaCountModel.this.o().getValue();
                if (value != null) {
                    value.setMessage(OfficialaCountModel.this.z());
                }
                OfficialaCountModel.this.o().postValue(OfficialaCountModel.this.o().getValue());
                List<OfficialMsg> value2 = OfficialaCountModel.this.q().getValue();
                if (value2 != null) {
                    value2.clear();
                }
                List<OfficialMsg> value3 = OfficialaCountModel.this.q().getValue();
                if (value3 != null) {
                    Boxing.boxBoolean(value3.addAll(list));
                }
                OfficialaCountModel.this.q().postValue(OfficialaCountModel.this.q().getValue());
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: OfficialaCountModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.longDistance.officialaccount.OfficialaCountModel$saveToDB$2", f = "OfficialaCountModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class m extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List<OfficialMsg> $officialaMessages;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(List<OfficialMsg> list, Continuation<? super m> continuation) {
            super(2, continuation);
            this.$officialaMessages = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new m(this.$officialaMessages, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((m) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DaoUtils.getOfficialaMessageDao().addAll(this.$officialaMessages);
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ List b(OfficialaCountModel officialaCountModel, List list) {
        officialaCountModel.i(list);
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void x(OfficialaCountModel officialaCountModel, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function0 = null;
        }
        officialaCountModel.w(function0);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object A(boolean r7, kotlin.coroutines.Continuation<? super java.util.List<com.wear.bean.official.OfficialMsg>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.wear.ui.longDistance.officialaccount.OfficialaCountModel.f
            if (r0 == 0) goto L13
            r0 = r8
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel$f r0 = (com.wear.ui.longDistance.officialaccount.OfficialaCountModel.f) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel$f r0 = new com.wear.ui.longDistance.officialaccount.OfficialaCountModel$f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r7 = r0.L$0
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel r7 = (com.wear.ui.longDistance.officialaccount.OfficialaCountModel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5d
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.List r8 = r6.y(r3, r5)
            boolean r2 = r8.isEmpty()
            if (r2 == 0) goto L6c
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            if (r7 == 0) goto L60
            long r7 = r6.e
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r6.B(r7, r5, r0)
            if (r8 != r1) goto L5c
            return r1
        L5c:
            r7 = r6
        L5d:
            java.util.List r8 = (java.util.List) r8
            goto L61
        L60:
            r7 = r6
        L61:
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L68
            goto L6c
        L68:
            java.util.List r8 = r7.y(r3, r5)
        L6c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.longDistance.officialaccount.OfficialaCountModel.A(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object B(java.lang.String r6, boolean r7, kotlin.coroutines.Continuation<? super java.util.List<com.wear.bean.official.OfficialMsg>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.wear.ui.longDistance.officialaccount.OfficialaCountModel.g
            if (r0 == 0) goto L13
            r0 = r8
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel$g r0 = (com.wear.ui.longDistance.officialaccount.OfficialaCountModel.g) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel$g r0 = new com.wear.ui.longDistance.officialaccount.OfficialaCountModel$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            boolean r6 = r0.Z$0
            java.lang.Object r7 = r0.L$1
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r0 = r0.L$0
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel r0 = (com.wear.ui.longDistance.officialaccount.OfficialaCountModel) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L74
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            boolean r7 = r0.Z$0
            java.lang.Object r6 = r0.L$0
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel r6 = (com.wear.ui.longDistance.officialaccount.OfficialaCountModel) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L59
        L48:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.G(r6, r7, r0)
            if (r8 != r1) goto L58
            return r1
        L58:
            r6 = r5
        L59:
            java.util.List r8 = (java.util.List) r8
            boolean r2 = r8.isEmpty()
            r2 = r2 ^ r4
            if (r2 == 0) goto L77
            r0.L$0 = r6
            r0.L$1 = r8
            r0.Z$0 = r7
            r0.label = r3
            java.lang.Object r0 = r6.I(r8, r0)
            if (r0 != r1) goto L71
            return r1
        L71:
            r0 = r6
            r6 = r7
            r7 = r8
        L74:
            r8 = r7
            r7 = r6
            r6 = r0
        L77:
            androidx.lifecycle.MutableLiveData<com.wear.bean.official.OfficialAcount> r0 = r6.d
            java.lang.Object r0 = r0.getValue()
            com.wear.bean.official.OfficialAcount r0 = (com.wear.bean.official.OfficialAcount) r0
            if (r0 != 0) goto L82
            goto L89
        L82:
            int r1 = r6.t()
            r0.setUnreadMessagesNumber(r1)
        L89:
            androidx.lifecycle.MutableLiveData<com.wear.bean.official.OfficialAcount> r0 = r6.d
            java.lang.Object r1 = r0.getValue()
            r0.postValue(r1)
            if (r7 == 0) goto Lba
            androidx.lifecycle.MutableLiveData<java.util.List<com.wear.bean.official.OfficialMsg>> r7 = r6.a
            java.lang.Object r7 = r7.getValue()
            if (r7 == 0) goto Lb1
            int r7 = r8.size()
            androidx.lifecycle.MutableLiveData<java.util.List<com.wear.bean.official.OfficialMsg>> r8 = r6.a
            java.lang.Object r8 = r8.getValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            java.util.List r8 = (java.util.List) r8
            int r8 = r8.size()
            int r7 = r7 + r8
            goto Lb5
        Lb1:
            int r7 = r8.size()
        Lb5:
            java.util.List r6 = r6.y(r7, r4)
            goto Lc0
        Lba:
            r7 = 5
            r8 = 0
            java.util.List r6 = r6.y(r7, r8)
        Lc0:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.longDistance.officialaccount.OfficialaCountModel.B(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void C() {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new h(null), 3, null);
    }

    public final long D() {
        return DaoUtils.getOfficialaMessageDao().queryUnreadMessage(this.c);
    }

    public final void E(@NotNull String lang) {
        String id;
        Intrinsics.checkNotNullParameter(lang, "lang");
        if (Build.VERSION.SDK_INT >= 26) {
            id = TimeZone.getDefault().toZoneId().getId();
            Intrinsics.checkNotNullExpressionValue(id, "{\n            TimeZone.g…).toZoneId().id\n        }");
        } else {
            id = "";
        }
        HashMap map = new HashMap();
        map.put("lang", lang);
        map.put("userTimezoneUtcOffset", Integer.valueOf(r()));
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || token.length() == 0) {
            map.put("deviceToken", "");
        } else {
            map.put("deviceToken", String.valueOf(FirebaseInstanceId.getInstance().getToken()));
        }
        map.put("userTimeZoneId", id);
        map.put("pf", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        String APP_VERSION = WearUtils.q;
        Intrinsics.checkNotNullExpressionValue(APP_VERSION, "APP_VERSION");
        map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, APP_VERSION);
        String strX = ye3.x();
        Intrinsics.checkNotNullExpressionValue(strX, "getSessionId()");
        map.put("sessionId", strX);
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new i(map, null), 3, null);
    }

    public final void F(boolean z) {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new j(z, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0079 A[Catch: Exception -> 0x0032, TryCatch #1 {Exception -> 0x0032, blocks: (B:12:0x002e, B:35:0x0071, B:37:0x0079, B:38:0x007f, B:40:0x0085, B:42:0x008e, B:43:0x0091), top: B:73:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007f A[Catch: Exception -> 0x0032, TryCatch #1 {Exception -> 0x0032, blocks: (B:12:0x002e, B:35:0x0071, B:37:0x0079, B:38:0x007f, B:40:0x0085, B:42:0x008e, B:43:0x0091), top: B:73:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object G(java.lang.String r9, boolean r10, kotlin.coroutines.Continuation<? super java.util.List<com.wear.bean.official.OfficialMsg>> r11) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.longDistance.officialaccount.OfficialaCountModel.G(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void H(boolean z) {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new l(z, null), 3, null);
    }

    public final Object I(List<OfficialMsg> list, Continuation<? super Unit> continuation) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((OfficialMsg) it.next()).setUserId(this.c);
        }
        Object objG = sy3.g(n04.b(), new m(arrayList, null), continuation);
        return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
    }

    public final void J(boolean z) {
    }

    public final void K(long j2) {
        this.e = j2;
    }

    public final void L(long j2) {
        this.f = j2;
    }

    public final void M() {
        OfficialAcount value = this.d.getValue();
        if (value != null) {
            value.setUnreadMessagesNumber(0);
        }
        DaoUtils.getOfficialaMessageDao().setMessageRead(this.c);
    }

    public final List<OfficialMsg> i(List<OfficialMsg> list) {
        for (OfficialMsg officialMsg : list) {
            if (officialMsg.getLangString().length() > 0) {
                officialMsg.setLang((OfficialLangMsgBean) WearUtils.A.fromJson(officialMsg.getLangString(), OfficialLangMsgBean.class));
            }
        }
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.wear.ui.longDistance.officialaccount.OfficialaCountModel.c
            if (r0 == 0) goto L13
            r0 = r6
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel$c r0 = (com.wear.ui.longDistance.officialaccount.OfficialaCountModel.c) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel$c r0 = new com.wear.ui.longDistance.officialaccount.OfficialaCountModel$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel r0 = (com.wear.ui.longDistance.officialaccount.OfficialaCountModel) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            dc.qz3 r6 = dc.n04.b()
            com.wear.ui.longDistance.officialaccount.OfficialaCountModel$d r2 = new com.wear.ui.longDistance.officialaccount.OfficialaCountModel$d
            r4 = 0
            r2.<init>(r4)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = dc.sy3.g(r6, r2, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            r0 = r5
        L4e:
            r1 = r6
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L61
            androidx.lifecycle.MutableLiveData<java.util.List<com.wear.bean.official.OfficialMsg>> r0 = r0.a
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.postValue(r1)
        L61:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.longDistance.officialaccount.OfficialaCountModel.j(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean k(@NotNull List<IPeopleInfo> list, @NotNull OfficialAcount newOfficialCount) {
        CommunMessage lastMessage;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(newOfficialCount, "newOfficialCount");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof OfficialAcount) {
                arrayList.add(obj);
            }
        }
        OfficialAcount officialAcount = (OfficialAcount) CollectionsKt___CollectionsKt.firstOrNull((List) arrayList);
        CommunMessage lastMessage2 = newOfficialCount.getLastMessage();
        String id = null;
        String id2 = lastMessage2 != null ? lastMessage2.getId() : null;
        if (officialAcount != null && (lastMessage = officialAcount.getLastMessage()) != null) {
            id = lastMessage.getId();
        }
        if (Intrinsics.areEqual(id2, id)) {
            if (officialAcount != null && newOfficialCount.getMuteFlag() == officialAcount.getMuteFlag()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final OfficialLangInfo l(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OfficialMsg officialMsgM = m();
        return n(context, officialMsgM != null ? officialMsgM.getLang() : null);
    }

    @Nullable
    public final OfficialMsg m() {
        return z();
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0116 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0116 A[REMOVE] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.wear.bean.official.OfficialLangInfo n(@org.jetbrains.annotations.NotNull android.content.Context r4, @org.jetbrains.annotations.Nullable com.wear.bean.official.OfficialLangMsgBean r5) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.longDistance.officialaccount.OfficialaCountModel.n(android.content.Context, com.wear.bean.official.OfficialLangMsgBean):com.wear.bean.official.OfficialLangInfo");
    }

    @NotNull
    public final MutableLiveData<OfficialAcount> o() {
        return this.d;
    }

    @Nullable
    public final OfficialAcount p() {
        if (this.d.getValue() == null) {
            MutableLiveData<OfficialAcount> mutableLiveData = this.d;
            String strE = ah4.e(R.string.official_remote);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.official_remote)");
            mutableLiveData.setValue(new OfficialAcount(strE));
            OfficialAcount value = this.d.getValue();
            if (value != null) {
                value.setMessage(z());
            }
        }
        return this.d.getValue();
    }

    @NotNull
    public final MutableLiveData<List<OfficialMsg>> q() {
        return this.a;
    }

    public final int r() {
        TimeZone timeZone = TimeZone.getDefault();
        Calendar calendar = Calendar.getInstance(timeZone);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(localTimeZone)");
        return timeZone.getOffset(calendar.getTimeInMillis());
    }

    @NotNull
    public final MutableLiveData<OfficialSetInfo> s() {
        return this.b;
    }

    public final int t() {
        OfficialAcount value = this.d.getValue();
        if (value != null) {
            value.setUnreadMessagesNumber((int) D());
        }
        return (int) D();
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final String getC() {
        return this.c;
    }

    public final void v() {
        String remoteAccountId;
        LoginUserBean loginUserBeanO = ch3.n().o();
        if (loginUserBeanO != null && (remoteAccountId = loginUserBeanO.getRemoteAccountId()) != null) {
            Intrinsics.checkNotNullExpressionValue(remoteAccountId, "remoteAccountId");
            this.c = remoteAccountId;
        }
        H(true);
        if (this.d.getValue() == null) {
            MutableLiveData<OfficialAcount> mutableLiveData = this.d;
            String strE = ah4.e(R.string.official_remote);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.official_remote)");
            mutableLiveData.setValue(new OfficialAcount(strE));
            OfficialAcount value = this.d.getValue();
            if (value != null) {
                value.setMessage(z());
            }
        }
        this.a.postValue(y(5, false));
        C();
    }

    public final void w(@Nullable Function0<Unit> function0) {
        HashMap map = new HashMap();
        OfficialSetInfo value = this.b.getValue();
        map.put("officialMsgMuteNotification", Boolean.valueOf(value != null ? value.getOfficialMsgMuteNotification() : false));
        OfficialSetInfo value2 = this.b.getValue();
        map.put("stickyToTop", Boolean.valueOf(value2 != null ? value2.getStickyToTop() : false));
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new e(function0, map, null), 3, null);
    }

    public final List<OfficialMsg> y(int i2, boolean z) {
        OfficialMsg officialMsg;
        List<OfficialMsg> listQueryAll = DaoUtils.getOfficialaMessageDao().queryAll(this.c, this.f, i2, z);
        Long officialMsgId = null;
        List<OfficialMsg> mutableList = listQueryAll != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) listQueryAll) : null;
        if (mutableList != null && (officialMsg = (OfficialMsg) CollectionsKt___CollectionsKt.lastOrNull((List) mutableList)) != null) {
            officialMsgId = officialMsg.getOfficialMsgId();
        }
        if (officialMsgId != null && officialMsgId.longValue() != 0) {
            this.e = officialMsgId.longValue();
        }
        if (mutableList != null) {
            i(mutableList);
        }
        return mutableList == null ? new ArrayList() : mutableList;
    }

    public final OfficialMsg z() {
        OfficialMsg officialMsgQueryLatestNews = DaoUtils.getOfficialaMessageDao().queryLatestNews(this.c);
        if (officialMsgQueryLatestNews != null) {
            officialMsgQueryLatestNews.setLang((OfficialLangMsgBean) WearUtils.A.fromJson(officialMsgQueryLatestNews.getLangString(), OfficialLangMsgBean.class));
        }
        return officialMsgQueryLatestNews;
    }
}
