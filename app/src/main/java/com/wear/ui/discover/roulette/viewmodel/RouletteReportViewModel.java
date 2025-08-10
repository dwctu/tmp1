package com.wear.ui.discover.roulette.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lovense.wear.R;
import com.wear.bean.ReportChooseImageBean;
import com.wear.bean.ReportControlRouleteeBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.net.model.RemoteResponse;
import com.wear.net.model.RemoteResult;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.al2;
import dc.dl2;
import dc.sg3;
import dc.tn2;
import dc.uy3;
import dc.wd3;
import dc.wz3;
import dc.xk2;
import dc.yn2;
import dc.zk2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: RouletteReportViewModel.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J!\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0010\u001a\u00020\u0011R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/wear/ui/discover/roulette/viewmodel/RouletteReportViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "error", "Landroidx/lifecycle/MutableLiveData;", "", "getError", "()Landroidx/lifecycle/MutableLiveData;", "setError", "(Landroidx/lifecycle/MutableLiveData;)V", "result", "Lcom/wear/net/model/RemoteResponse;", "getResult", "setResult", "reportControlRouletee", "", "reportControlRouleteeBean", "Lcom/wear/bean/ReportControlRouleteeBean;", "uploadImage", "images", "", "([Ljava/lang/String;Lcom/wear/bean/ReportControlRouleteeBean;)V", "uploadReportImage", "", "Lcom/wear/bean/ReportChooseImageBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RouletteReportViewModel extends ViewModel {

    @NotNull
    public MutableLiveData<RemoteResponse<?>> a = new MutableLiveData<>();

    @NotNull
    public MutableLiveData<String> b = new MutableLiveData<>();

    /* compiled from: RouletteReportViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.roulette.viewmodel.RouletteReportViewModel$reportControlRouletee$1", f = "RouletteReportViewModel.kt", i = {0}, l = {80}, m = "invokeSuspend", n = {"isShowToast$iv"}, s = {"I$0"})
    public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ ReportControlRouleteeBean $reportControlRouleteeBean;
        public int I$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReportControlRouleteeBean reportControlRouleteeBean, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$reportControlRouleteeBean = reportControlRouleteeBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return RouletteReportViewModel.this.new a(this.$reportControlRouleteeBean, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            RemoteResponse<?> remoteResponseA;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ReportControlRouleteeBean reportControlRouleteeBean = this.$reportControlRouleteeBean;
                    dl2 dl2VarC = xk2.c.c();
                    this.I$0 = 1;
                    this.label = 1;
                    obj = dl2VarC.c(reportControlRouleteeBean, this);
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
                    remoteResponseA = new RemoteResponse.Success<>(remoteResult);
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
            RouletteReportViewModel.this.b().postValue(remoteResponseA);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: RouletteReportViewModel.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"com/wear/ui/discover/roulette/viewmodel/RouletteReportViewModel$uploadImage$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements yn2<BaseResponseBeanNew<String>> {
        public final /* synthetic */ ReportControlRouleteeBean a;
        public final /* synthetic */ RouletteReportViewModel b;

        public b(ReportControlRouleteeBean reportControlRouleteeBean, RouletteReportViewModel rouletteReportViewModel) {
            this.a = reportControlRouleteeBean;
            this.b = rouletteReportViewModel;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable BaseResponseBeanNew<String> baseResponseBeanNew) {
            String str;
            String[] images;
            String str2;
            if ((baseResponseBeanNew == null || (str2 = baseResponseBeanNew.data) == null || !StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) ",", false, 2, (Object) null)) ? false : true) {
                ReportControlRouleteeBean reportControlRouleteeBean = this.a;
                String str3 = baseResponseBeanNew.data;
                Intrinsics.checkNotNullExpressionValue(str3, "response.data");
                reportControlRouleteeBean.setImages((String[]) StringsKt__StringsKt.split$default((CharSequence) str3, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]));
            } else if (baseResponseBeanNew != null && (str = baseResponseBeanNew.data) != null && (images = this.a.getImages()) != null) {
                images[0] = str;
            }
            this.b.c(this.a);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@NotNull NetException e) {
            Intrinsics.checkNotNullParameter(e, "e");
            this.b.a().postValue(e.message);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: RouletteReportViewModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"com/wear/ui/discover/roulette/viewmodel/RouletteReportViewModel$uploadReportImage$1", "Lcom/wear/util/CompressImageUtil$OnCompress;", "onCompress", "", "path", "", "", "([Ljava/lang/String;)V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements wd3.c {
        public final /* synthetic */ ReportControlRouleteeBean b;

        public c(ReportControlRouleteeBean reportControlRouleteeBean) {
            this.b = reportControlRouleteeBean;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x000c  */
        @Override // dc.wd3.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(@org.jetbrains.annotations.Nullable java.lang.String[] r4) {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                if (r4 == 0) goto Lc
                int r2 = r4.length
                if (r2 != 0) goto L9
                r2 = 1
                goto La
            L9:
                r2 = 0
            La:
                if (r2 == 0) goto Ld
            Lc:
                r0 = 1
            Ld:
                if (r0 == 0) goto L10
                return
            L10:
                com.wear.ui.discover.roulette.viewmodel.RouletteReportViewModel r0 = com.wear.ui.discover.roulette.viewmodel.RouletteReportViewModel.this
                com.wear.bean.ReportControlRouleteeBean r1 = r3.b
                r0.d(r4, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.viewmodel.RouletteReportViewModel.c.a(java.lang.String[]):void");
        }
    }

    @NotNull
    public final MutableLiveData<String> a() {
        return this.b;
    }

    @NotNull
    public final MutableLiveData<RemoteResponse<?>> b() {
        return this.a;
    }

    public final void c(@NotNull ReportControlRouleteeBean reportControlRouleteeBean) {
        Intrinsics.checkNotNullParameter(reportControlRouleteeBean, "reportControlRouleteeBean");
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new a(reportControlRouleteeBean, null), 3, null);
    }

    public final void d(@NotNull String[] images, @NotNull ReportControlRouleteeBean reportControlRouleteeBean) {
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(reportControlRouleteeBean, "reportControlRouleteeBean");
        HashMap map = new HashMap();
        map.put("files", Integer.valueOf(images.length));
        tn2.x(WearUtils.x).r("/remote/report-user/uploadMultipicture", map, images, new b(reportControlRouleteeBean, this));
    }

    public final void e(@NotNull List<ReportChooseImageBean> images, @NotNull ReportControlRouleteeBean reportControlRouleteeBean) {
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(reportControlRouleteeBean, "reportControlRouleteeBean");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = images.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ReportChooseImageBean) next).getUrl().length() > 0) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((ReportChooseImageBean) it2.next()).getUrl());
        }
        wd3.b().a((String[]) arrayList2.toArray(new String[0]), new c(reportControlRouleteeBean));
    }
}
