package com.wear.ui.discover.chatgpt.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.wear.bean.BaseEntity;
import com.wear.bean.data.AskingData;
import com.wear.bean.data.ChatGPTMsgExtKt;
import com.wear.bean.data.ChatGPTPatternBean;
import com.wear.bean.data.ChatGPTPatternBeanKt;
import com.wear.bean.data.ChatGPTPatternResponse;
import com.wear.bean.data.ChatGPTStoryBean;
import com.wear.bean.data.LeftTimesResponse;
import com.wear.bean.event.ChatGPTEvent;
import com.wear.bean.event.ChatGPTType;
import com.wear.bean.request.CreatePatternRequest;
import com.wear.bean.request.CreatePatternRequestKt;
import com.wear.bean.request.LeftTimesRequest;
import com.wear.bean.request.PullChatGPTRequest;
import com.wear.dao.DaoUtils;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.ad4;
import dc.bd4;
import dc.ch3;
import dc.eg3;
import dc.h04;
import dc.h14;
import dc.n04;
import dc.qz3;
import dc.ro2;
import dc.s14;
import dc.sy3;
import dc.tn2;
import dc.tq;
import dc.u34;
import dc.uy3;
import dc.v34;
import dc.vc4;
import dc.wz3;
import dc.yc4;
import dc.ye3;
import dc.zn2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ChatGPTViewModel.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 P2\u00020\u0001:\u0001PB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&JT\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00152\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\"\u0018\u00010*2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010,2\u0018\b\u0002\u0010-\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\"\u0018\u00010*H\u0002J\"\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020$2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020&H\u0002J)\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020&H\u0082@ø\u0001\u0000¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020&H\u0002J\u000e\u0010<\u001a\u00020\"2\u0006\u0010%\u001a\u00020&J\u0006\u0010=\u001a\u00020\"J\u001f\u0010>\u001a\u00020\"2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050@H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020\"H\u0014J\u0010\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020EH\u0007J\u001f\u0010F\u001a\u00020\"2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050@H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u001b\u0010G\u001a\u00020\"2\b\u0010H\u001a\u0004\u0018\u00010IH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010JJ3\u0010K\u001a\u00020\"2\u0006\u00101\u001a\u00020$2\u0006\u00104\u001a\u00020&2\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\u00020\"2\u0006\u0010O\u001a\u00020\u000bR!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\u0007R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0016\u0010\u0007R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0019\u0010\u0007R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001d\u0010\u0007R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Q"}, d2 = {"Lcom/wear/ui/discover/chatgpt/viewmodel/ChatGPTViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "chatGPTPattern", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/bean/data/ChatGPTPatternBean;", "getChatGPTPattern", "()Landroidx/lifecycle/MutableLiveData;", "chatGPTPattern$delegate", "Lkotlin/Lazy;", "generatingPattern", "", "getGeneratingPattern", "()Z", "setGeneratingPattern", "(Z)V", "isPatternClearContent", "isPatternClearContent$delegate", "patternCoroutines", "Lkotlinx/coroutines/Job;", "patternLeftTimes", "", "getPatternLeftTimes", "patternLeftTimes$delegate", "sendPatternEnable", "getSendPatternEnable", "sendPatternEnable$delegate", "showLeftTimeDialog", "Lcom/wear/bean/event/ChatGPTType;", "getShowLeftTimeDialog", "showLeftTimeDialog$delegate", "startPatternTime", "", "clearPatternContext", "", "context", "Landroid/content/Context;", "msgType", "", "countDownCoroutines", "total", "onTick", "Lkotlin/Function1;", "onStart", "Lkotlin/Function0;", "onFinish", "", "createPatternRequest", "Lcom/wear/bean/request/CreatePatternRequest;", FirebaseAnalytics.Param.CONTENT, "askingData", "Lcom/wear/bean/data/AskingData;", "message", "downloadPattern", ImagesContract.URL, TtmlNode.ATTR_ID, "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "featChatGPTPattern", "sessionTaskId", "getLeftTimes", "initChatGPTPatternMessage", "initPatternMsg", "mutableList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCleared", "onEventMsg", "event", "Lcom/wear/bean/event/ChatGPTEvent;", "prepareChatGPTPatten", "saveToDataBase", "bean", "Lcom/wear/bean/BaseEntity;", "(Lcom/wear/bean/BaseEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPatternMessageToChatGPT", FirebaseAnalytics.Param.INDEX, "(Landroid/content/Context;Ljava/lang/String;Lcom/wear/bean/data/AskingData;Ljava/lang/Integer;)V", "setSendPatternEnable", StreamManagement.Enable.ELEMENT, "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatGPTViewModel extends ViewModel {

    @Nullable
    public h14 a;
    public long b;

    @NotNull
    public final Lazy c = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public final Lazy d = LazyKt__LazyJVMKt.lazy(r.a);

    @NotNull
    public final Lazy e = LazyKt__LazyJVMKt.lazy(n.a);

    @NotNull
    public final Lazy f = LazyKt__LazyJVMKt.lazy(t.a);

    @NotNull
    public final Lazy g = LazyKt__LazyJVMKt.lazy(m.a);
    public boolean h;

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ChatGPTType.values().length];
            iArr[ChatGPTType.PATTERN.ordinal()] = 1;
            iArr[ChatGPTType.STORY.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/bean/data/ChatGPTPatternBean;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<MutableLiveData<ChatGPTPatternBean>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<ChatGPTPatternBean> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$clearPatternContext$1", f = "ChatGPTViewModel.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Object $msgEntity;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$msgEntity = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ChatGPTViewModel.this.new c(this.$msgEntity, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ChatGPTViewModel chatGPTViewModel = ChatGPTViewModel.this;
                BaseEntity baseEntity = (BaseEntity) this.$msgEntity;
                this.label = 1;
                if (chatGPTViewModel.y(baseEntity, this) == coroutine_suspended) {
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

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$countDownCoroutines$1", f = "ChatGPTViewModel.kt", i = {0, 0, 1, 1}, l = {471, 472}, m = "invokeSuspend", n = {"$this$flow", "i", "$this$flow", "i"}, s = {"L$0", "I$0", "L$0", "I$0"})
    public static final class d extends SuspendLambda implements Function2<u34<? super Integer>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ int $total;
        public int I$0;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, Continuation<? super d> continuation) {
            super(2, continuation);
            this.$total = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            d dVar = new d(this.$total, continuation);
            dVar.L$0 = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull u34<? super Integer> u34Var, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(u34Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0058 -> B:18:0x005b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = -1
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2f
                if (r1 == r4) goto L23
                if (r1 != r3) goto L1b
                int r1 = r8.I$0
                java.lang.Object r5 = r8.L$0
                dc.u34 r5 = (dc.u34) r5
                kotlin.ResultKt.throwOnFailure(r9)
                r9 = r5
                r5 = r8
                goto L5b
            L1b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L23:
                int r1 = r8.I$0
                java.lang.Object r5 = r8.L$0
                dc.u34 r5 = (dc.u34) r5
                kotlin.ResultKt.throwOnFailure(r9)
                r9 = r5
                r5 = r8
                goto L4c
            L2f:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                dc.u34 r9 = (dc.u34) r9
                int r1 = r8.$total
                r5 = r8
            L39:
                if (r2 >= r1) goto L5d
                java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
                r5.L$0 = r9
                r5.I$0 = r1
                r5.label = r4
                java.lang.Object r6 = r9.emit(r6, r5)
                if (r6 != r0) goto L4c
                return r0
            L4c:
                r6 = 1000(0x3e8, double:4.94E-321)
                r5.L$0 = r9
                r5.I$0 = r1
                r5.label = r3
                java.lang.Object r6 = dc.h04.a(r6, r5)
                if (r6 != r0) goto L5b
                return r0
            L5b:
                int r1 = r1 + r2
                goto L39
            L5d:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$countDownCoroutines$2", f = "ChatGPTViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<u34<? super Integer>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function0<Unit> $onStart;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Function0<Unit> function0, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$onStart = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new e(this.$onStart, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull u34<? super Integer> u34Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(u34Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Function0<Unit> function0 = this.$onStart;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$countDownCoroutines$3", f = "ChatGPTViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function3<u34<? super Integer>, Throwable, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1<Throwable, Unit> $onFinish;
        public /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(Function1<? super Throwable, Unit> function1, Continuation<? super f> continuation) {
            super(3, continuation);
            this.$onFinish = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull u34<? super Integer> u34Var, @Nullable Throwable th, @Nullable Continuation<? super Unit> continuation) {
            f fVar = new f(this.$onFinish, continuation);
            fVar.L$0 = th;
            return fVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Throwable th = (Throwable) this.L$0;
            Function1<Throwable, Unit> function1 = this.$onFinish;
            if (function1 != null) {
                function1.invoke(th);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$countDownCoroutines$4", f = "ChatGPTViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1<Integer, Unit> $onTick;
        public /* synthetic */ int I$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(Function1<? super Integer, Unit> function1, Continuation<? super g> continuation) {
            super(2, continuation);
            this.$onTick = function1;
        }

        @Nullable
        public final Object c(int i, @Nullable Continuation<? super Unit> continuation) {
            return ((g) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            g gVar = new g(this.$onTick, continuation);
            gVar.I$0 = ((Number) obj).intValue();
            return gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
            return c(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = this.I$0;
            Function1<Integer, Unit> function1 = this.$onTick;
            if (function1 != null) {
                function1.invoke(Boxing.boxInt(i));
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$downloadPattern$2", f = "ChatGPTViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $id;
        public final /* synthetic */ String $type;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, String str2, String str3, Continuation<? super h> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$type = str2;
            this.$id = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(this.$url, this.$type, this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws IOException {
            File file;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            vc4 vc4VarB = new vc4.b().b();
            yc4.a aVar = new yc4.a();
            aVar.d();
            aVar.k(this.$url);
            ad4 ad4VarExecute = vc4VarB.a(aVar.b()).execute();
            if (ad4VarExecute.isSuccessful()) {
                if (TextUtils.equals("pattern", this.$type)) {
                    file = WearUtils.e0("pattern/" + this.$id);
                } else {
                    file = new File(WearUtils.x.getExternalFilesDir("wear/audioBook"), this.$id + ".json");
                }
                bd4 bd4VarB = ad4VarExecute.b();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bd4VarB != null ? bd4VarB.byteStream() : null));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                String line = bufferedReader.readLine();
                while (line != null) {
                    bufferedWriter.write(line);
                    line = bufferedReader.readLine();
                    bufferedWriter.newLine();
                }
                bufferedReader.close();
                bufferedWriter.close();
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/chatgpt/viewmodel/ChatGPTViewModel$featChatGPTPattern$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class i implements zn2<String> {
        public final /* synthetic */ String b;

        /* compiled from: ChatGPTViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$featChatGPTPattern$1$onError$1", f = "ChatGPTViewModel.kt", i = {}, l = {395}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ String $sessionTaskId;
            public int label;
            public final /* synthetic */ ChatGPTViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, ChatGPTViewModel chatGPTViewModel, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$sessionTaskId = str;
                this.this$0 = chatGPTViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$sessionTaskId, this.this$0, continuation);
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
                    ChatGPTPatternBean chatGPTPatternBeanGeneratePatternErrorMsg = ChatGPTMsgExtKt.generatePatternErrorMsg(this.$sessionTaskId);
                    chatGPTPatternBeanGeneratePatternErrorMsg.setId(chatGPTPatternBeanGeneratePatternErrorMsg.getLocalMsgId());
                    ChatGPTViewModel chatGPTViewModel = this.this$0;
                    this.label = 1;
                    if (chatGPTViewModel.y(chatGPTPatternBeanGeneratePatternErrorMsg, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.this$0.B(false);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: ChatGPTViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$featChatGPTPattern$1$onSuccess$1$1", f = "ChatGPTViewModel.kt", i = {0, 0, 1, 1, 2, 3}, l = {361, 375, 377, 383}, m = "invokeSuspend", n = {"jsonBean", "enjoyMsg", "data", "bean", "bean", "bean"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
        public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ String $it;
            public final /* synthetic */ String $sessionTaskId;
            public Object L$0;
            public Object L$1;
            public int label;
            public final /* synthetic */ ChatGPTViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, ChatGPTViewModel chatGPTViewModel, String str2, Continuation<? super b> continuation) {
                super(2, continuation);
                this.$it = str;
                this.this$0 = chatGPTViewModel;
                this.$sessionTaskId = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.$it, this.this$0, this.$sessionTaskId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:38:0x010b A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x011c A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
                /*
                    Method dump skipped, instructions count: 348
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel.i.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public i(String str) {
            this.b = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            if (str != null) {
                ChatGPTViewModel chatGPTViewModel = ChatGPTViewModel.this;
                uy3.d(ViewModelKt.getViewModelScope(chatGPTViewModel), null, null, new b(str, chatGPTViewModel, this.b, null), 3, null);
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            uy3.d(ViewModelKt.getViewModelScope(ChatGPTViewModel.this), null, null, new a(this.b, ChatGPTViewModel.this, null), 3, null);
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/chatgpt/viewmodel/ChatGPTViewModel$getLeftTimes$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class j implements zn2<String> {
        public final /* synthetic */ String b;

        /* compiled from: ChatGPTViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$getLeftTimes$1$onError$1", f = "ChatGPTViewModel.kt", i = {}, l = {PsExtractor.PACK_START_CODE}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;
            public final /* synthetic */ ChatGPTViewModel this$0;

            /* compiled from: ChatGPTViewModel.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
            @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$getLeftTimes$1$onError$1$1", f = "ChatGPTViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$j$a$a, reason: collision with other inner class name */
            public static final class C0140a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
                public int label;
                public final /* synthetic */ ChatGPTViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0140a(ChatGPTViewModel chatGPTViewModel, Continuation<? super C0140a> continuation) {
                    super(2, continuation);
                    this.this$0 = chatGPTViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C0140a(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                    return ((C0140a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.this$0.r().setValue(Boxing.boxInt(eg3.f(WearUtils.x, "patternLefts", 10)));
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ChatGPTViewModel chatGPTViewModel, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = chatGPTViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
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
                    s14 s14VarC = n04.c();
                    C0140a c0140a = new C0140a(this.this$0, null);
                    this.label = 1;
                    if (sy3.g(s14VarC, c0140a, this) == coroutine_suspended) {
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

        /* compiled from: ChatGPTViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$getLeftTimes$1$onSuccess$1$1", f = "ChatGPTViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ String $it;
            public final /* synthetic */ String $msgType;
            public int label;
            public final /* synthetic */ ChatGPTViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, String str2, ChatGPTViewModel chatGPTViewModel, Continuation<? super b> continuation) {
                super(2, continuation);
                this.$it = str;
                this.$msgType = str2;
                this.this$0 = chatGPTViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.$it, this.$msgType, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((b) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                LeftTimesResponse leftTimesResponse = (LeftTimesResponse) ro2.a(this.$it, LeftTimesResponse.class);
                if ((leftTimesResponse != null ? Intrinsics.areEqual(leftTimesResponse.getResult(), Boxing.boxBoolean(true)) : false) && leftTimesResponse.getData() != null && Intrinsics.areEqual(this.$msgType, "pattern")) {
                    this.this$0.r().postValue(leftTimesResponse.getData().getLeftTimes());
                }
                return Unit.INSTANCE;
            }
        }

        public j(String str) {
            this.b = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            if (str != null) {
                ChatGPTViewModel chatGPTViewModel = ChatGPTViewModel.this;
                uy3.d(ViewModelKt.getViewModelScope(chatGPTViewModel), null, null, new b(str, this.b, chatGPTViewModel, null), 3, null);
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            if (Intrinsics.areEqual(this.b, "pattern")) {
                uy3.d(ViewModelKt.getViewModelScope(ChatGPTViewModel.this), null, null, new a(ChatGPTViewModel.this, null), 3, null);
            }
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$initChatGPTPatternMessage$1", f = "ChatGPTViewModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: ChatGPTViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$initChatGPTPatternMessage$1$1", f = "ChatGPTViewModel.kt", i = {1}, l = {87, 106, 107}, m = "invokeSuspend", n = {"mutableList"}, s = {"L$0"})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public Object L$0;
            public int label;
            public final /* synthetic */ ChatGPTViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ChatGPTViewModel chatGPTViewModel, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = chatGPTViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:33:0x00be A[RETURN] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
                /*
                    r9 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r9.label
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L2b
                    if (r1 == r4) goto L27
                    if (r1 == r3) goto L1e
                    if (r1 != r2) goto L16
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto Lbf
                L16:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L1e:
                    java.lang.Object r1 = r9.L$0
                    java.util.List r1 = (java.util.List) r1
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto Lb1
                L27:
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto L39
                L2b:
                    kotlin.ResultKt.throwOnFailure(r10)
                    r5 = 200(0xc8, double:9.9E-322)
                    r9.label = r4
                    java.lang.Object r10 = dc.h04.a(r5, r9)
                    if (r10 != r0) goto L39
                    return r0
                L39:
                    dc.ch3 r10 = dc.ch3.n()
                    com.wear.network.presenter.bean.LoginUserBean r10 = r10.o()
                    java.lang.String r10 = r10.getRemoteAccountId()
                    com.wear.util.MyApplication r1 = com.wear.util.WearUtils.x
                    java.lang.String r5 = ""
                    java.lang.String r10 = dc.eg3.h(r1, r10, r5)
                    com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel r1 = r9.this$0
                    androidx.lifecycle.MutableLiveData r1 = r1.w()
                    java.lang.String r5 = "patternTopicId"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r5)
                    int r10 = r10.length()
                    r5 = 0
                    if (r10 <= 0) goto L61
                    r10 = 1
                    goto L62
                L61:
                    r10 = 0
                L62:
                    java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
                    r1.postValue(r10)
                    com.wear.dao.ChatGPTPatternDao r10 = com.wear.dao.DaoUtils.getChatGPTPatternDao()
                    java.util.List r1 = r10.findChatGPTPatternMsgByAccount()
                    com.wear.util.MyApplication r6 = com.wear.util.WearUtils.x
                    java.lang.String r7 = "firstPatternChatGPT"
                    boolean r6 = dc.eg3.d(r6, r7, r4)
                    if (r1 == 0) goto L83
                    boolean r8 = r1.isEmpty()
                    if (r8 == 0) goto L82
                    goto L83
                L82:
                    r4 = 0
                L83:
                    if (r4 == 0) goto La4
                    if (r6 == 0) goto Lbf
                    com.wear.bean.data.ChatGPTPatternBean r0 = com.wear.bean.data.ChatGPTMsgExtKt.createFirstChatGPTMsg()
                    com.wear.util.MyApplication r1 = com.wear.util.WearUtils.x
                    dc.eg3.j(r1, r7, r5)
                    java.lang.String r1 = r0.getLocalMsgId()
                    r0.setId(r1)
                    r10.add(r0)
                    com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel r10 = r9.this$0
                    androidx.lifecycle.MutableLiveData r10 = r10.o()
                    r10.postValue(r0)
                    goto Lbf
                La4:
                    com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel r10 = r9.this$0
                    r9.L$0 = r1
                    r9.label = r3
                    java.lang.Object r10 = com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel.d(r10, r1, r9)
                    if (r10 != r0) goto Lb1
                    return r0
                Lb1:
                    com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel r10 = r9.this$0
                    r3 = 0
                    r9.L$0 = r3
                    r9.label = r2
                    java.lang.Object r10 = com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel.e(r10, r1, r9)
                    if (r10 != r0) goto Lbf
                    return r0
                Lbf:
                    kotlin.Unit r10 = kotlin.Unit.INSTANCE
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel.k.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public k(Continuation<? super k> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ChatGPTViewModel.this.new k(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((k) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                qz3 qz3VarB = n04.b();
                a aVar = new a(ChatGPTViewModel.this, null);
                this.label = 1;
                if (sy3.g(qz3VarB, aVar, this) == coroutine_suspended) {
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

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$initPatternMsg$2", f = "ChatGPTViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class l extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ List<ChatGPTPatternBean> $mutableList;
        public int label;
        public final /* synthetic */ ChatGPTViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(List<ChatGPTPatternBean> list, ChatGPTViewModel chatGPTViewModel, Continuation<? super l> continuation) {
            super(2, continuation);
            this.$mutableList = list;
            this.this$0 = chatGPTViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new l(this.$mutableList, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((l) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<ChatGPTPatternBean> list = this.$mutableList;
            ChatGPTViewModel chatGPTViewModel = this.this$0;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                chatGPTViewModel.o().setValue((ChatGPTPatternBean) it.next());
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function0<MutableLiveData<Boolean>> {
        public static final m a = new m();

        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<Boolean> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function0<MutableLiveData<Integer>> {
        public static final n a = new n();

        public n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<Integer> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "throwable", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ ChatGPTPatternBean $last;
        public final /* synthetic */ ChatGPTViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ChatGPTPatternBean chatGPTPatternBean, ChatGPTViewModel chatGPTViewModel) {
            super(1);
            this.$last = chatGPTPatternBean;
            this.this$0 = chatGPTViewModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable r3) {
            /*
                r2 = this;
                if (r3 != 0) goto L26
                com.wear.bean.data.ChatGPTPatternBean r3 = r2.$last
                java.lang.String r3 = r3.getSessionTaskId()
                r0 = 1
                r1 = 0
                if (r3 == 0) goto L18
                int r3 = r3.length()
                if (r3 <= 0) goto L14
                r3 = 1
                goto L15
            L14:
                r3 = 0
            L15:
                if (r3 != r0) goto L18
                goto L19
            L18:
                r0 = 0
            L19:
                if (r0 == 0) goto L26
                com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel r3 = r2.this$0
                com.wear.bean.data.ChatGPTPatternBean r0 = r2.$last
                java.lang.String r0 = r0.getSessionTaskId()
                com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel.b(r3, r0)
            L26:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel.o.invoke2(java.lang.Throwable):void");
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$prepareChatGPTPatten$2$2", f = "ChatGPTViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class p extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ ChatGPTPatternBean $this_run;
        public int label;
        public final /* synthetic */ ChatGPTViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(ChatGPTPatternBean chatGPTPatternBean, ChatGPTViewModel chatGPTViewModel, Continuation<? super p> continuation) {
            super(2, continuation);
            this.$this_run = chatGPTPatternBean;
            this.this$0 = chatGPTViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new p(this.$this_run, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((p) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String sessionTaskId = this.$this_run.getSessionTaskId();
            if (sessionTaskId == null) {
                return null;
            }
            this.this$0.n(sessionTaskId);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$saveToDataBase$2", f = "ChatGPTViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class q extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ BaseEntity $bean;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(BaseEntity baseEntity, Continuation<? super q> continuation) {
            super(2, continuation);
            this.$bean = baseEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new q(this.$bean, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((q) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BaseEntity baseEntity = this.$bean;
            if (baseEntity instanceof ChatGPTPatternBean) {
                DaoUtils.getChatGPTPatternDao().updateOrAdd(this.$bean);
            } else if (baseEntity instanceof ChatGPTStoryBean) {
                DaoUtils.getChatGPTStoryDao().updateOrAdd(this.$bean);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r extends Lambda implements Function0<MutableLiveData<Boolean>> {
        public static final r a = new r();

        public r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<Boolean> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/chatgpt/viewmodel/ChatGPTViewModel$sendPatternMessageToChatGPT$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class s implements zn2<String> {
        public final /* synthetic */ AskingData a;
        public final /* synthetic */ Integer b;
        public final /* synthetic */ ChatGPTViewModel c;
        public final /* synthetic */ CreatePatternRequest d;

        /* compiled from: ChatGPTViewModel.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "throwable", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a extends Lambda implements Function1<Throwable, Unit> {
            public final /* synthetic */ ChatGPTPatternBean $bean;
            public final /* synthetic */ ChatGPTViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ChatGPTPatternBean chatGPTPatternBean, ChatGPTViewModel chatGPTViewModel) {
                super(1);
                this.$bean = chatGPTPatternBean;
                this.this$0 = chatGPTViewModel;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Throwable r3) {
                /*
                    r2 = this;
                    if (r3 != 0) goto L26
                    com.wear.bean.data.ChatGPTPatternBean r3 = r2.$bean
                    java.lang.String r3 = r3.getSessionTaskId()
                    r0 = 1
                    r1 = 0
                    if (r3 == 0) goto L18
                    int r3 = r3.length()
                    if (r3 <= 0) goto L14
                    r3 = 1
                    goto L15
                L14:
                    r3 = 0
                L15:
                    if (r3 != r0) goto L18
                    goto L19
                L18:
                    r0 = 0
                L19:
                    if (r0 == 0) goto L26
                    com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel r3 = r2.this$0
                    com.wear.bean.data.ChatGPTPatternBean r0 = r2.$bean
                    java.lang.String r0 = r0.getSessionTaskId()
                    com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel.b(r3, r0)
                L26:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel.s.a.invoke2(java.lang.Throwable):void");
            }
        }

        /* compiled from: ChatGPTViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.chatgpt.viewmodel.ChatGPTViewModel$sendPatternMessageToChatGPT$1$onSuccess$1$3", f = "ChatGPTViewModel.kt", i = {}, l = {252, 253}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public final /* synthetic */ ChatGPTPatternBean $bean;
            public int label;
            public final /* synthetic */ ChatGPTViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(ChatGPTViewModel chatGPTViewModel, ChatGPTPatternBean chatGPTPatternBean, Continuation<? super b> continuation) {
                super(2, continuation);
                this.this$0 = chatGPTViewModel;
                this.$bean = chatGPTPatternBean;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.this$0, this.$bean, continuation);
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
                    ChatGPTViewModel chatGPTViewModel = this.this$0;
                    ChatGPTPatternBean chatGPTPatternBean = this.$bean;
                    this.label = 1;
                    if (chatGPTViewModel.y(chatGPTPatternBean, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.this$0.o().postValue(ChatGPTMsgExtKt.chatGPTGeneratingMsg());
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.label = 2;
                if (h04.a(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.this$0.o().postValue(ChatGPTMsgExtKt.chatGPTGeneratingMsg());
                return Unit.INSTANCE;
            }
        }

        public s(AskingData askingData, Integer num, ChatGPTViewModel chatGPTViewModel, CreatePatternRequest createPatternRequest) {
            this.a = askingData;
            this.b = num;
            this.c = chatGPTViewModel;
            this.d = createPatternRequest;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            String string;
            if (str != null) {
                AskingData askingData = this.a;
                Integer num = this.b;
                ChatGPTViewModel chatGPTViewModel = this.c;
                CreatePatternRequest createPatternRequest = this.d;
                ChatGPTPatternResponse responseBean = (ChatGPTPatternResponse) ro2.a(str, ChatGPTPatternResponse.class);
                String str2 = askingData == null ? "send_click" : "default_question_send_click";
                String str3 = askingData == null ? "send" : "default_question_send";
                boolean z = false;
                String str4 = responseBean != null && responseBean.getResult() ? "1" : "0";
                if (num == null || (string = num.toString()) == null) {
                    string = "";
                }
                ye3.j("chatgpt pattern", str2, "click", str3, "button", str4, string, -1L);
                if (responseBean != null && responseBean.getResult()) {
                    z = true;
                }
                if (!z || responseBean.getData() == null) {
                    Intrinsics.checkNotNullExpressionValue(responseBean, "responseBean");
                    ChatGPTPatternBeanKt.addFailedS0009(responseBean);
                    chatGPTViewModel.o().postValue(CreatePatternRequestKt.toChatGPTErrorBean(createPatternRequest));
                    return;
                }
                ChatGPTPatternBean data = responseBean.getData();
                MutableLiveData<ChatGPTPatternBean> mutableLiveDataO = chatGPTViewModel.o();
                data.setRemoteAccountId(ch3.n().o().getRemoteAccountId());
                data.setContentType(Integer.valueOf(ChatGPTPatternBeanKt.ITEM_MY_SELF_MESSAGE));
                data.setGoneSendError(Boolean.TRUE);
                data.setId(data.getLocalMsgId());
                mutableLiveDataO.postValue(data);
                chatGPTViewModel.B(true);
                Integer sessionTimeoutSeconds = data.getSessionTimeoutSeconds();
                if (sessionTimeoutSeconds != null) {
                    chatGPTViewModel.a = ChatGPTViewModel.k(chatGPTViewModel, sessionTimeoutSeconds.intValue(), null, null, new a(data, chatGPTViewModel), 6, null);
                }
                uy3.d(ViewModelKt.getViewModelScope(chatGPTViewModel), null, null, new b(chatGPTViewModel, data, null), 3, null);
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            String string;
            this.c.o().postValue(CreatePatternRequestKt.toChatGPTErrorBean(this.d));
            AskingData askingData = this.a;
            String str = askingData == null ? "send_click" : "default_question_send_click";
            String str2 = askingData == null ? "send" : "default_question_send";
            Integer num = this.b;
            if (num == null || (string = num.toString()) == null) {
                string = "";
            }
            ye3.j("chatgpt pattern", str, "click", str2, "button", "0", string, -1L);
        }
    }

    /* compiled from: ChatGPTViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/bean/event/ChatGPTType;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t extends Lambda implements Function0<MutableLiveData<ChatGPTType>> {
        public static final t a = new t();

        public t() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<ChatGPTType> invoke() {
            return new MutableLiveData<>();
        }
    }

    public ChatGPTViewModel() {
        EventBus.getDefault().register(this);
    }

    public static /* synthetic */ void A(ChatGPTViewModel chatGPTViewModel, Context context, String str, AskingData askingData, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            askingData = null;
        }
        if ((i2 & 8) != 0) {
            num = null;
        }
        chatGPTViewModel.z(context, str, askingData, num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ h14 k(ChatGPTViewModel chatGPTViewModel, int i2, Function1 function1, Function0 function0, Function1 function12, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        if ((i3 & 8) != 0) {
            function12 = null;
        }
        return chatGPTViewModel.j(i2, function1, function0, function12);
    }

    public final void B(boolean z) {
        this.h = z;
    }

    public final void C(boolean z) {
        s().setValue(Boolean.valueOf(z));
    }

    public final void i(@NotNull Context context, @NotNull String msgType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        tq tqVarGenerateClearPatternContextMsg = Intrinsics.areEqual(msgType, "pattern") ? ChatGPTMsgExtKt.generateClearPatternContextMsg() : ChatGPTMsgExtKt.generateClearStoryContentMsg();
        if (Intrinsics.areEqual(msgType, "pattern")) {
            eg3.m(context, ch3.n().o().getRemoteAccountId());
            MutableLiveData<ChatGPTPatternBean> mutableLiveDataO = o();
            Intrinsics.checkNotNull(tqVarGenerateClearPatternContextMsg, "null cannot be cast to non-null type com.wear.bean.data.ChatGPTPatternBean");
            mutableLiveDataO.setValue((ChatGPTPatternBean) tqVarGenerateClearPatternContextMsg);
            w().setValue(Boolean.FALSE);
        } else {
            LoginUserBean loginUserBeanO = ch3.n().o();
            Intrinsics.checkNotNullExpressionValue(loginUserBeanO, "getInstance().loginUserBean");
            eg3.m(context, ChatGPTMsgExtKt.toTopicId(loginUserBeanO));
        }
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new c(tqVarGenerateClearPatternContextMsg, null), 3, null);
    }

    public final h14 j(int i2, Function1<? super Integer, Unit> function1, Function0<Unit> function0, Function1<? super Throwable, Unit> function12) {
        return v34.n(v34.q(v34.p(v34.r(v34.m(v34.k(new d(i2, null)), n04.c()), new e(function0, null)), new f(function12, null)), new g(function1, null)), ViewModelKt.getViewModelScope(this));
    }

    public final CreatePatternRequest l(Context context, AskingData askingData, String str) {
        String remoteAccountId = ch3.n().o().getRemoteAccountId();
        String topicId = eg3.h(context, remoteAccountId, "");
        Intrinsics.checkNotNullExpressionValue(topicId, "topicId");
        if (topicId.length() == 0) {
            topicId = WearUtils.E();
            eg3.i(context, remoteAccountId, topicId);
            w().setValue(Boolean.TRUE);
        }
        String topicId2 = topicId;
        String id = askingData != null ? askingData.getId() : null;
        String strE = WearUtils.E();
        Intrinsics.checkNotNullExpressionValue(strE, "generateUUID()");
        String string = StringsKt__StringsKt.trim((CharSequence) str).toString();
        String strX = ye3.x();
        Intrinsics.checkNotNullExpressionValue(strX, "getSessionId()");
        Intrinsics.checkNotNullExpressionValue(topicId2, "topicId");
        return new CreatePatternRequest(strE, string, strX, topicId2, Boolean.valueOf(askingData != null), id);
    }

    public final Object m(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        Object objG = sy3.g(n04.b(), new h(str, str3, str2, null), continuation);
        return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
    }

    public final void n(String str) {
        s().setValue(Boolean.TRUE);
        tn2.x(WearUtils.x).m("/chatgpt_create_pattern_pull_msg", ro2.c(new PullChatGPTRequest(str)), new i(str));
    }

    @NotNull
    public final MutableLiveData<ChatGPTPatternBean> o() {
        return (MutableLiveData) this.c.getValue();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        h14 h14Var = this.a;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMsg(@NotNull ChatGPTEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.getSessionTaskId();
        String str = "socket " + event.getSessionTaskId();
        if (a.a[event.getEventType().ordinal()] != 1) {
            return;
        }
        h14 h14Var = this.a;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        n(event.getSessionTaskId());
    }

    /* renamed from: p, reason: from getter */
    public final boolean getH() {
        return this.h;
    }

    public final void q(@NotNull String msgType) {
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        tn2.x(WearUtils.x).m("/chatgpt_send_msg_left_times", ro2.c(new LeftTimesRequest(msgType)), new j(msgType));
    }

    @NotNull
    public final MutableLiveData<Integer> r() {
        return (MutableLiveData) this.e.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> s() {
        return (MutableLiveData) this.d.getValue();
    }

    @NotNull
    public final MutableLiveData<ChatGPTType> t() {
        return (MutableLiveData) this.f.getValue();
    }

    public final void u() {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new k(null), 3, null);
    }

    public final Object v(List<ChatGPTPatternBean> list, Continuation<? super Unit> continuation) {
        Object objG = sy3.g(n04.c(), new l(list, this, null), continuation);
        return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
    }

    @NotNull
    public final MutableLiveData<Boolean> w() {
        return (MutableLiveData) this.g.getValue();
    }

    public final Object x(List<ChatGPTPatternBean> list, Continuation<? super Unit> continuation) {
        Object next;
        Integer contentType;
        Integer contentType2;
        ChatGPTPatternBean chatGPTPatternBean = (ChatGPTPatternBean) CollectionsKt___CollectionsKt.last((List) list);
        Integer contentType3 = chatGPTPatternBean.getContentType();
        if (contentType3 == null || contentType3.intValue() != 2730) {
            return Unit.INSTANCE;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ChatGPTPatternBean chatGPTPatternBean2 = (ChatGPTPatternBean) next;
            if (Intrinsics.areEqual(chatGPTPatternBean2.getSessionTaskId(), chatGPTPatternBean.getSessionTaskId()) && (((contentType = chatGPTPatternBean2.getContentType()) != null && contentType.intValue() == 170) || ((contentType2 = chatGPTPatternBean2.getContentType()) != null && contentType2.intValue() == 10))) {
                break;
            }
        }
        ChatGPTPatternBean chatGPTPatternBean3 = (ChatGPTPatternBean) next;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long time = chatGPTPatternBean.getCreated().getTime() + ((chatGPTPatternBean.getSessionTimeoutSeconds() != null ? r1.intValue() : 0) * 1000);
        if (chatGPTPatternBean3 == null) {
            if (jCurrentTimeMillis <= time) {
                o().postValue(ChatGPTMsgExtKt.chatGPTGeneratingMsg());
                this.h = true;
                this.a = k(this, (int) ((time - jCurrentTimeMillis) / 1000), null, null, new o(chatGPTPatternBean, this), 6, null);
            } else {
                Object objG = sy3.g(n04.c(), new p(chatGPTPatternBean, this, null), continuation);
                if (objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return objG;
                }
            }
        }
        return Unit.INSTANCE;
    }

    public final Object y(BaseEntity baseEntity, Continuation<? super Unit> continuation) {
        Object objG = sy3.g(n04.b(), new q(baseEntity, null), continuation);
        return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
    }

    public final void z(@NotNull Context content, @NotNull String message, @Nullable AskingData askingData, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(message, "message");
        Integer value = r().getValue();
        if (value != null && value.intValue() == 0) {
            t().setValue(ChatGPTType.PATTERN);
            return;
        }
        CreatePatternRequest createPatternRequestL = l(content, askingData, message);
        this.b = System.currentTimeMillis();
        tn2.x(content).m("/chatgpt_create_pattern_send_msg", ro2.c(createPatternRequestL), new s(askingData, num, this, createPatternRequestL));
    }
}
