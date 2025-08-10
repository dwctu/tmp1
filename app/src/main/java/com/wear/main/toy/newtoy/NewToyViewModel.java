package com.wear.main.toy.newtoy;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.wear.BaseViewModel;
import com.wear.bean.StrengthBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyStrength;
import com.wear.dao.DaoUtils;
import com.wear.main.toy.newtoy.NewToyViewModel;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.a14;
import dc.ch3;
import dc.fk2;
import dc.h14;
import dc.pc1;
import dc.tn2;
import dc.uy3;
import dc.vu1;
import dc.wz3;
import dc.yn2;
import dc.zt3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: NewToyViewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bJ\b\u0010 \u001a\u00020\u001eH\u0002J\u0006\u0010!\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020\u001eH\u0002J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u001eJ\u0010\u0010'\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010(J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020%H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/wear/main/toy/newtoy/NewToyViewModel;", "Lcom/wear/BaseViewModel;", "()V", "countdownJob", "Lkotlinx/coroutines/Job;", "getSearchToyList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/wear/bean/Toy;", "getGetSearchToyList", "()Landroidx/lifecycle/MutableLiveData;", "setGetSearchToyList", "(Landroidx/lifecycle/MutableLiveData;)V", "isBtDisable", "", "setBtDisable", "isSearchScan", "setSearchScan", "isShowBtDisable", "setShowBtDisable", "isShowConnectToyList", "setShowConnectToyList", "isShowEmpty", "setShowEmpty", "isShowNoToyList", "Landroidx/lifecycle/MediatorLiveData;", "()Landroidx/lifecycle/MediatorLiveData;", "setShowNoToyList", "(Landroidx/lifecycle/MediatorLiveData;)V", "addSearchToyToLinkedToy", "", "bean", "countdownFinished", "getNowToyLists", "setServerToyStrength", "startCountdown", "seconds", "", "stopCountdown", "updateStrength", "Lcom/wear/bean/StrengthBean;", "updateUI", "remainingSeconds", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NewToyViewModel extends BaseViewModel {

    @NotNull
    public static final a h = new a(null);

    @NotNull
    public MutableLiveData<Boolean> a = new MutableLiveData<>();

    @NotNull
    public MutableLiveData<Boolean> b;

    @NotNull
    public MutableLiveData<Boolean> c;

    @NotNull
    public MutableLiveData<Boolean> d;

    @NotNull
    public MediatorLiveData<Boolean> e;

    @NotNull
    public MutableLiveData<List<Toy>> f;

    @Nullable
    public h14 g;

    /* compiled from: NewToyViewModel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/wear/main/toy/newtoy/NewToyViewModel$Companion;", "", "()V", "saveToyStrengthToNet", "", "bean", "Lcom/wear/bean/StrengthBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* compiled from: NewToyViewModel.kt */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/wear/main/toy/newtoy/NewToyViewModel$Companion$saveToyStrengthToNet$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/network/presenter/bean/BaseResponseBean;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.wear.main.toy.newtoy.NewToyViewModel$a$a, reason: collision with other inner class name */
        public static final class C0138a implements yn2<BaseResponseBean> {
            @Override // dc.yn2, dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@Nullable BaseResponseBean baseResponseBean) {
                String str = "onSuccess: " + baseResponseBean;
            }

            @Override // dc.yn2
            public void onCompleted() {
            }

            @Override // dc.yn2, dc.zn2
            public void onError(@NotNull NetException e) {
                Intrinsics.checkNotNullParameter(e, "e");
                String str = "onError: " + e.message;
            }

            @Override // dc.yn2
            public void onStart() {
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull StrengthBean bean) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            tn2.x(WearUtils.x).h("/api/user/saveToyStrength", WearUtils.A.toJson(bean), new C0138a());
        }
    }

    /* compiled from: NewToyViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.main.toy.newtoy.NewToyViewModel$startCountdown$1", f = "NewToyViewModel.kt", i = {}, l = {92, 95, 99}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Ref.IntRef $remainingSeconds;
        public int label;
        public final /* synthetic */ NewToyViewModel this$0;

        /* compiled from: NewToyViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.main.toy.newtoy.NewToyViewModel$startCountdown$1$1", f = "NewToyViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Ref.IntRef $remainingSeconds;
            public int label;
            public final /* synthetic */ NewToyViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(NewToyViewModel newToyViewModel, Ref.IntRef intRef, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = newToyViewModel;
                this.$remainingSeconds = intRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$remainingSeconds, continuation);
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
                this.this$0.s(this.$remainingSeconds.element);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: NewToyViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.main.toy.newtoy.NewToyViewModel$startCountdown$1$2", f = "NewToyViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.wear.main.toy.newtoy.NewToyViewModel$b$b, reason: collision with other inner class name */
        public static final class C0139b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;
            public final /* synthetic */ NewToyViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0139b(NewToyViewModel newToyViewModel, Continuation<? super C0139b> continuation) {
                super(2, continuation);
                this.this$0 = newToyViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0139b(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((C0139b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.e();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, NewToyViewModel newToyViewModel, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$remainingSeconds = intRef;
            this.this$0 = newToyViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$remainingSeconds, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0050 -> B:21:0x0053). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L27
                if (r1 == r4) goto L22
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r10)
                goto L70
            L15:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1d:
                kotlin.ResultKt.throwOnFailure(r10)
                r10 = r9
                goto L53
            L22:
                kotlin.ResultKt.throwOnFailure(r10)
                r10 = r9
                goto L48
            L27:
                kotlin.ResultKt.throwOnFailure(r10)
                r10 = r9
            L2b:
                kotlin.jvm.internal.Ref$IntRef r1 = r10.$remainingSeconds
                int r1 = r1.element
                r5 = 0
                if (r1 <= 0) goto L5c
                dc.s14 r1 = dc.n04.c()
                com.wear.main.toy.newtoy.NewToyViewModel$b$a r6 = new com.wear.main.toy.newtoy.NewToyViewModel$b$a
                com.wear.main.toy.newtoy.NewToyViewModel r7 = r10.this$0
                kotlin.jvm.internal.Ref$IntRef r8 = r10.$remainingSeconds
                r6.<init>(r7, r8, r5)
                r10.label = r4
                java.lang.Object r1 = dc.sy3.g(r1, r6, r10)
                if (r1 != r0) goto L48
                return r0
            L48:
                r5 = 1000(0x3e8, double:4.94E-321)
                r10.label = r3
                java.lang.Object r1 = dc.h04.a(r5, r10)
                if (r1 != r0) goto L53
                return r0
            L53:
                kotlin.jvm.internal.Ref$IntRef r1 = r10.$remainingSeconds
                int r5 = r1.element
                int r5 = r5 + (-1)
                r1.element = r5
                goto L2b
            L5c:
                dc.s14 r1 = dc.n04.c()
                com.wear.main.toy.newtoy.NewToyViewModel$b$b r3 = new com.wear.main.toy.newtoy.NewToyViewModel$b$b
                com.wear.main.toy.newtoy.NewToyViewModel r4 = r10.this$0
                r3.<init>(r4, r5)
                r10.label = r2
                java.lang.Object r10 = dc.sy3.g(r1, r3, r10)
                if (r10 != r0) goto L70
                return r0
            L70:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.newtoy.NewToyViewModel.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public NewToyViewModel() {
        new MutableLiveData();
        this.b = new MutableLiveData<>();
        this.c = new MutableLiveData<>();
        this.d = new MutableLiveData<>();
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(this.a, new Observer() { // from class: dc.xj2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NewToyViewModel.m(this.a, (Boolean) obj);
            }
        });
        this.e = mediatorLiveData;
        this.f = new MutableLiveData<>();
    }

    public static final void m(NewToyViewModel this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool.booleanValue() || !Intrinsics.areEqual(this$0.b.getValue(), Boolean.TRUE)) {
            return;
        }
        this$0.q();
        this$0.d.postValue(Boolean.FALSE);
    }

    public final void d(@NotNull Toy bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        bean.setIsSelect(1);
        if (bean.isSelect()) {
            String deviceType = bean.getDeviceType();
            Intrinsics.checkNotNullExpressionValue(deviceType, "bean.deviceType");
            List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) StringsKt__StringsKt.split$default((CharSequence) deviceType, new String[]{";"}, false, 0, 6, (Object) null).get(0), new String[]{SignatureImpl.INNER_SEP}, false, 0, 6, (Object) null);
            ch3 ch3Var = WearUtils.y;
            if (!DaoUtils.getToyDao().existToyByEmail(ch3Var != null ? ch3Var.o().getEmail() : "", bean.getAddress()) && Toy.NAME_MAP.containsKey(bean.getType())) {
                bean.setId(System.currentTimeMillis() + "");
                bean.setVersion(Integer.valueOf(Integer.parseInt((String) listSplit$default.get(1))));
                bean.setEmail("");
                bean.setUuid(bean.getUuid());
                bean.setF01IsNotice(true);
                bean.setIsSelect(1);
                WearUtils.x.G().v(bean, true);
            }
        }
        bean.setRenameDeviceName();
        WearUtils.x.G().s(bean);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            r3 = this;
            com.wear.util.MyApplication r0 = com.wear.util.WearUtils.x
            dc.pc1 r0 = r0.G()
            java.util.ArrayList r0 = r0.q()
            int r0 = r0.size()
            r1 = 0
            if (r0 > 0) goto L32
            com.wear.util.MyApplication r0 = com.wear.util.WearUtils.x
            dc.pc1 r0 = r0.G()
            java.util.ArrayList r0 = r0.o()
            if (r0 == 0) goto L26
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L24
            goto L26
        L24:
            r0 = 0
            goto L27
        L26:
            r0 = 1
        L27:
            if (r0 != 0) goto L2a
            goto L32
        L2a:
            androidx.lifecycle.MediatorLiveData<java.lang.Boolean> r0 = r3.e
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.postValue(r2)
            goto L39
        L32:
            androidx.lifecycle.MediatorLiveData<java.lang.Boolean> r0 = r3.e
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.postValue(r2)
        L39:
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r0 = r3.d
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.postValue(r2)
            com.wear.util.MyApplication r0 = com.wear.util.WearUtils.x
            dc.pc1 r0 = r0.G()
            r0.i(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.newtoy.NewToyViewModel.e():void");
    }

    @NotNull
    public final MutableLiveData<List<Toy>> f() {
        return this.f;
    }

    public final void g() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----");
        ArrayList<Toy> arrayListQ = WearUtils.x.G().q();
        boolean z = false;
        sb.append(arrayListQ == null || arrayListQ.isEmpty());
        ArrayList<Toy> arrayListO = WearUtils.x.G().o();
        sb.append(arrayListO == null || arrayListO.isEmpty());
        sb.toString();
        MutableLiveData<Boolean> mutableLiveData = this.a;
        ArrayList<Toy> arrayListQ2 = WearUtils.x.G().q();
        if (arrayListQ2 == null || arrayListQ2.isEmpty()) {
            ArrayList<Toy> arrayListO2 = WearUtils.x.G().o();
            if (arrayListO2 == null || arrayListO2.isEmpty()) {
                z = true;
            }
        }
        mutableLiveData.postValue(Boolean.valueOf(z));
        o();
        ArrayList<Toy> arrayListP = pc1.a.P();
        ArrayList<Toy> arrayList = new ArrayList();
        for (Object obj : arrayListP) {
            if (((Toy) obj).isBAToy()) {
                arrayList.add(obj);
            }
        }
        for (Toy toy : arrayList) {
            fk2 fk2Var = fk2.a;
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "it.address");
            fk2Var.i(address, fk2Var.c(toy.getAddress()));
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> h() {
        return this.d;
    }

    @NotNull
    public final MutableLiveData<Boolean> i() {
        return this.b;
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.c;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.a;
    }

    @NotNull
    public final MediatorLiveData<Boolean> l() {
        return this.e;
    }

    public final void o() {
        StrengthBean.Data data;
        for (Toy toy : pc1.a.o()) {
            StrengthBean strengthBeanC = vu1.a.c(toy.getAndUpdateDeviceId());
            if (strengthBeanC != null && (data = strengthBeanC.getData()) != null) {
                Intrinsics.checkNotNullExpressionValue(data, "data");
                ToyStrength toyStrengthFindToyStrength = DaoUtils.getToyStrengthDao().findToyStrength(zt3.k, toy.getAndUpdateDeviceId());
                if (toyStrengthFindToyStrength == null) {
                    toyStrengthFindToyStrength = new ToyStrength(zt3.k, toy.getAndUpdateDeviceId());
                }
                toyStrengthFindToyStrength.setStrength(data.getV(), data.getV1(), data.getV2(), data.getV3(), data.getR(), data.getP(), data.getS(), data.getT(), data.getF(), data.getD(), data.getStrokeMin(), data.getStrokeMax());
                DaoUtils.getToyStrengthDao().updateOrAdd(toyStrengthFindToyStrength);
            }
        }
    }

    public final void p(int i) {
        h14 h14Var = this.g;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        h14 h14VarD = uy3.d(a14.a, null, null, new b(intRef, this, null), 3, null);
        this.g = h14VarD;
        if (h14VarD != null) {
            h14VarD.start();
        }
    }

    public final void q() {
        h14 h14Var = this.g;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
    }

    public final void r(@Nullable StrengthBean strengthBean) {
        if (MyApplication.O && strengthBean != null) {
            h.a(strengthBean);
        }
    }

    public final void s(int i) {
        MediatorLiveData<Boolean> mediatorLiveData = this.e;
        Boolean bool = Boolean.FALSE;
        mediatorLiveData.postValue(bool);
        String str = "倒计时时间===" + i;
        String str2 = "搜索到的玩具" + WearUtils.x.G().q().size();
        if (WearUtils.x.G().q().size() > 0) {
            this.f.postValue(WearUtils.x.G().q());
            this.c.postValue(Boolean.TRUE);
            this.e.postValue(bool);
        }
    }
}
