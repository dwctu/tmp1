package dc;

import com.component.dxbilog.lib.manual.bean.response.BILogServerCodeResBean;
import com.component.dxbilog.lib.manual.bean.response.BaseResponse;
import com.component.dxdatabase.lib.bean.BILogDbBean;
import com.component.dxhttp.NetException;
import dc.ss;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: BILogMultiUserUploadStrategy.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J+\u0010\u0011\u001a\u00020\u00072\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0013H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J)\u0010\u0015\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogMultiUserUploadStrategy;", "Lcom/component/dxbilog/lib/manual/strategy/handler/BaseStrategyHandler;", "()V", "isEnable", "", "()Z", "continuationEnd", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "accountCode", "", "isSuccess", "handle", "beanList", "", "Lcom/component/dxdatabase/lib/bean/BILogDbBean;", "handlerUpload", "userMap", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadLog", "list", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class xs extends bt {

    @NotNull
    public static final a b = new a(null);

    @NotNull
    public static final Map<String, Boolean> c = new LinkedHashMap();

    /* compiled from: BILogMultiUserUploadStrategy.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/component/dxbilog/lib/manual/strategy/BILogMultiUserUploadStrategy$Companion;", "", "()V", "uploadMap", "", "", "", "getUploadMap", "()Ljava/util/Map;", "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Map<String, Boolean> a() {
            return xs.c;
        }
    }

    /* compiled from: BILogMultiUserUploadStrategy.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.component.dxbilog.lib.manual.strategy.BILogMultiUserUploadStrategy$handle$2", f = "BILogMultiUserUploadStrategy.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Map<String, List<BILogDbBean>> $userMap;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Map<String, List<BILogDbBean>> map, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$userMap = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return xs.this.new b(this.$userMap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                xs xsVar = xs.this;
                Map<String, List<BILogDbBean>> map = this.$userMap;
                this.label = 1;
                if (xsVar.k(map, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: BILogMultiUserUploadStrategy.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.component.dxbilog.lib.manual.strategy.BILogMultiUserUploadStrategy$handlerUpload$2", f = "BILogMultiUserUploadStrategy.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Map<String, List<BILogDbBean>> $userMap;
        private /* synthetic */ Object L$0;
        public int label;
        public final /* synthetic */ xs this$0;

        /* compiled from: BILogMultiUserUploadStrategy.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "com.component.dxbilog.lib.manual.strategy.BILogMultiUserUploadStrategy$handlerUpload$2$deferred$1", f = "BILogMultiUserUploadStrategy.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ List<BILogDbBean> $list;
            public final /* synthetic */ Map.Entry<String, List<BILogDbBean>> $user;
            public int label;
            public final /* synthetic */ xs this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(xs xsVar, Map.Entry<String, List<BILogDbBean>> entry, List<BILogDbBean> list, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = xsVar;
                this.$user = entry;
                this.$list = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, this.$user, this.$list, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    xs xsVar = this.this$0;
                    String key = this.$user.getKey();
                    List<BILogDbBean> list = this.$list;
                    this.label = 1;
                    if (xsVar.l(key, list, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Map<String, List<BILogDbBean>> map, xs xsVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$userMap = map;
            this.this$0 = xsVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            c cVar = new c(this.$userMap, this.this$0, continuation);
            cVar.L$0 = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                wz3 wz3Var = (wz3) this.L$0;
                ms.a.a(Intrinsics.stringPlus("BILogMultiUserUploadStrategy-----分用户上传: ", this.$userMap.keySet()));
                xs.b.a().clear();
                Set<String> setKeySet = this.$userMap.keySet();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(setKeySet, 10));
                Iterator<T> it2 = setKeySet.iterator();
                while (it2.hasNext()) {
                    xs.b.a().put((String) it2.next(), Boxing.boxBoolean(false));
                    arrayList.add(Unit.INSTANCE);
                }
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry<String, List<BILogDbBean>> entry : this.$userMap.entrySet()) {
                    List<BILogDbBean> value = entry.getValue();
                    if (!(value == null || value.isEmpty())) {
                        new zs().b(value);
                        arrayList2.add(uy3.b(wz3Var, null, null, new a(this.this$0, entry, value, null), 3, null));
                    }
                }
                it = arrayList2.iterator();
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                e04 e04Var = (e04) it.next();
                this.L$0 = it;
                this.label = 1;
                if (e04Var.p(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            ms.a.a("BILogMultiUserUploadStrategy-----上传结束", xd0.j(xs.b.a()));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: BILogMultiUserUploadStrategy.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/component/dxbilog/lib/manual/strategy/BILogMultiUserUploadStrategy$uploadLog$2$1", "Lcom/component/dxhttp/callback/ResponseCallback;", "Lcom/component/dxbilog/lib/manual/bean/response/BaseResponse;", "Lcom/component/dxbilog/lib/manual/bean/response/BILogServerCodeResBean;", "handlerError", "", "onError", "e", "Lcom/component/dxhttp/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends ny<BaseResponse<BILogServerCodeResBean>> {
        public final /* synthetic */ List<BILogDbBean> a;
        public final /* synthetic */ xs b;
        public final /* synthetic */ yy3<Unit> c;
        public final /* synthetic */ String d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(List<BILogDbBean> list, xs xsVar, yy3<? super Unit> yy3Var, String str) {
            this.a = list;
            this.b = xsVar;
            this.c = yy3Var;
            this.d = str;
        }

        @Override // dc.ny
        public void b(@Nullable NetException netException) {
            e();
            this.b.j(this.c, this.d, false);
        }

        public final void e() {
            ws.a.b(this.a);
        }

        @Override // dc.ny
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull BaseResponse<BILogServerCodeResBean> response) {
            Intrinsics.checkNotNullParameter(response, "response");
            String code = response.getCode();
            Intrinsics.checkNotNullExpressionValue(code, "response.code");
            if (code.contentEquals("0")) {
                zw.e.b(this.a);
            } else {
                e();
            }
            this.b.j(this.c, this.d, true);
        }
    }

    @Override // dc.bt, dc.ct
    public void a(@Nullable List<BILogDbBean> list) throws InterruptedException {
        if (!(list == null || list.isEmpty())) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (BILogDbBean bILogDbBean : list) {
                String accountCode = bILogDbBean.getAccountCode();
                if (accountCode == null || accountCode.length() == 0) {
                    bILogDbBean.setAccountCode("");
                }
                String accountCode2 = bILogDbBean.getAccountCode();
                if (accountCode2 != null) {
                    if (linkedHashMap.containsKey(accountCode2)) {
                        List list2 = (List) linkedHashMap.get(accountCode2);
                        if (list2 != null) {
                            list2.add(bILogDbBean);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bILogDbBean);
                        linkedHashMap.put(accountCode2, arrayList);
                    }
                }
            }
            ty3.b(null, new b(linkedHashMap, null), 1, null);
        }
        rs.c.h();
        ct a2 = getA();
        if (a2 == null) {
            return;
        }
        a2.b(list);
    }

    @Override // dc.bt
    public boolean d() {
        return true;
    }

    public final void j(yy3<? super Unit> yy3Var, String str, boolean z) {
        Map<String, Boolean> map = c;
        map.put(str == null ? "" : str, Boolean.TRUE);
        ms.a.a("分用户上传___单用户___结束挂起: " + ((Object) str) + " 是否成功：" + z, xd0.j(map));
        yy3Var.i(Unit.INSTANCE, null);
    }

    public final Object k(Map<String, List<BILogDbBean>> map, Continuation<? super Unit> continuation) {
        Object objG = sy3.g(n04.a(), new c(map, this, null), continuation);
        return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
    }

    public final Object l(String str, List<BILogDbBean> list, Continuation<? super Unit> continuation) {
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        if (list == null || list.isEmpty()) {
            j(zy3Var, str, true);
        } else {
            ss.a aVar = ss.a;
            List<BILogDbBean> listF = aVar.f(list);
            ms.a.a("BILogMultiUserUploadStrategy----上传数据", Intrinsics.stringPlus("accountCode: ", str), "sendList.size: " + listF.size() + MessageFormatter.DELIM_STOP);
            aVar.d(str, listF, true, new d(list, this, zy3Var, str));
        }
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objX : Unit.INSTANCE;
    }
}
