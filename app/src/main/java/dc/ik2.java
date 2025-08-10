package dc;

import com.component.dxtoy.business.longc.aapattern.bean.AAPatternItemBean;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.wear.bean.Toy;
import dc.g10;
import dc.h14;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SolaceProPatternPlayer.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0006\u0010\u0018\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0006\u0010\u001b\u001a\u00020\u0014J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\u0014J\u0006\u0010\"\u001a\u00020\u0014J\u0006\u0010#\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/wear/main/toy/solacepro/pattern/SolaceProPatternPlayer;", "", "iterator", "Lcom/wear/main/toy/solacepro/pattern/iterator/PatternIterator;", "toy", "Lcom/wear/bean/Toy;", "(Lcom/wear/main/toy/solacepro/pattern/iterator/PatternIterator;Lcom/wear/bean/Toy;)V", "currentBatch", "", "currentSendCmdList", "", "Lcom/component/dxtoy/business/longc/aapattern/bean/AAPatternItemBean;", "isPause", "", "getIterator", "()Lcom/wear/main/toy/solacepro/pattern/iterator/PatternIterator;", "nextSendTimerTick", "timer", "Lkotlinx/coroutines/Job;", "continuePlay", "", "onMessage", "event", "Lcom/component/dxtoy/business/longc/event/ToyAAEvent;", "pause", "processAndSendCommands", "timerIndex", "release", "sendDataAsync", "orderType", "Lcom/component/dxtoy/business/longc/data/AAEum$Type;", "sendPatternIntervalCmd", "interval", "shutdown", TtmlNode.START, "stop", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ik2 {

    @NotNull
    public final kk2 a;

    @NotNull
    public final Toy b;
    public int c;

    @NotNull
    public List<AAPatternItemBean> d;
    public int e;

    @Nullable
    public h14 f;
    public boolean g;

    /* compiled from: SolaceProPatternPlayer.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k10.values().length];
            iArr[k10.WRITE_PATTERN_CLEAR_RUN_100.ordinal()] = 1;
            iArr[k10.WRITE_PATTERN_JUST_100.ordinal()] = 2;
            iArr[k10.WRITE_PATTERN_CLEAR_RUN_20.ordinal()] = 3;
            iArr[k10.WRITE_PATTERN_JUST_20.ordinal()] = 4;
            a = iArr;
        }
    }

    /* compiled from: SolaceProPatternPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.main.toy.solacepro.pattern.SolaceProPatternPlayer$start$1", f = "SolaceProPatternPlayer.kt", i = {1, 1}, l = {83, 96}, m = "invokeSuspend", n = {"$this$launch", "timerTick"}, s = {"L$0", "I$0"})
    public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int I$0;
        private /* synthetic */ Object L$0;
        public int label;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            b bVar = ik2.this.new b(continuation);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            int i;
            wz3 wz3Var;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    i = 0;
                    wz3Var = (wz3) this.L$0;
                } else {
                    if (i2 == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = this.I$0;
                    wz3Var = (wz3) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (xz3.e(wz3Var)) {
                    if (ik2.this.g) {
                        this.L$0 = null;
                        this.label = 1;
                        if (h04.a(100L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (ik2.this.e(i)) {
                        xz3.c(wz3Var, null, 1, null);
                        ik2.this.f = null;
                        return Unit.INSTANCE;
                    }
                    i++;
                    this.L$0 = wz3Var;
                    this.I$0 = i;
                    this.label = 2;
                    if (h04.a(100L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return Unit.INSTANCE;
        }
    }

    public ik2(@NotNull kk2 iterator, @NotNull Toy toy) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        Intrinsics.checkNotNullParameter(toy, "toy");
        this.a = iterator;
        this.b = toy;
        EventBus.getDefault().register(this);
        this.d = CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final kk2 getA() {
        return this.a;
    }

    public final boolean e(int i) {
        Unit unit;
        if (i >= this.e) {
            de0.v("zbf", "next send index = " + this.e + ", current process cmd in " + i);
            List<AAPatternItemBean> listF = this.a.f();
            if (listF != null) {
                k10 k10Var = this.c == 0 ? this.a.getB() ? k10.WRITE_PATTERN_CLEAR_RUN_100 : k10.WRITE_PATTERN_CLEAR_RUN_20 : this.a.getB() ? k10.WRITE_PATTERN_JUST_100 : k10.WRITE_PATTERN_JUST_20;
                this.c++;
                this.d = listF;
                this.e += this.a.c();
                g(k10Var);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        h14 h14Var = this.f;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        this.f = null;
        h();
        this.c = 0;
        this.e = 0;
        this.d = CollectionsKt__CollectionsKt.emptyList();
        this.a.a();
    }

    public final void g(k10 k10Var) {
        if (this.d.isEmpty()) {
            return;
        }
        if (!mp1.a.b()) {
            byte[] bArrD = this.a.getB() ? hk2.a.d(this.b, this.d, k10Var) : hk2.a.c(this.b, this.d, k10Var);
            de0.v("zbf", "批次：" + this.c + "  指令：" + jk2.a(bArrD));
            dk2.a.g(this.b, bArrD);
            return;
        }
        fk2 fk2Var = fk2.a;
        int iE = fk2Var.e(this.b.getDeviceId());
        int iD = fk2Var.d(this.b.getDeviceId());
        for (AAPatternItemBean aAPatternItemBean : this.d) {
            if (this.a.getB()) {
                aAPatternItemBean.setValue(pu1.a(aAPatternItemBean.getValue(), 0, 100, iE, iD));
            } else {
                aAPatternItemBean.setValue(pu1.a(aAPatternItemBean.getValue(), 0, 20, iE / 5, iD / 5));
            }
        }
        int i = a.a[k10Var.ordinal()];
        if (i == 1) {
            g10.a aVar = g10.a;
            String address = this.b.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            aVar.b(address, this.d, true);
            return;
        }
        if (i == 2) {
            g10.a aVar2 = g10.a;
            String address2 = this.b.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
            aVar2.a(address2, this.d, true);
            return;
        }
        if (i == 3) {
            g10.a aVar3 = g10.a;
            String address3 = this.b.getAddress();
            Intrinsics.checkNotNullExpressionValue(address3, "toy.address");
            aVar3.b(address3, this.d, false);
            return;
        }
        if (i != 4) {
            de0.l("zbf", "orderType is not support");
            return;
        }
        g10.a aVar4 = g10.a;
        String address4 = this.b.getAddress();
        Intrinsics.checkNotNullExpressionValue(address4, "toy.address");
        aVar4.a(address4, this.d, false);
    }

    public final void h() {
        EventBus.getDefault().unregister(this);
    }

    public final void i() {
        if (this.f != null || this.a.b() <= 0) {
            return;
        }
        this.f = uy3.d(xz3.a(n04.b()), null, null, new b(null), 3, null);
    }

    public final void j() {
        if (!mp1.a.b()) {
            dk2.a.g(this.b, hk2.a.f(i10.STOP));
        } else {
            g10.a aVar = g10.a;
            String address = this.b.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            aVar.c(address);
        }
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public final void onMessage(@NotNull l10 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.a()) {
            return;
        }
        de0.l("zbf", "指令发送失败， " + event + "  ,批次：" + this.c);
    }
}
