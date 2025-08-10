package dc;

import com.google.gson.reflect.TypeToken;
import com.wear.bean.chat.Message;
import com.wear.bean.chat.MessageResult;
import com.wear.bean.chat.MessageSelected;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* compiled from: ChatMessageAction.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0002*+B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082\u0010J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0012J0\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u001a\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\"\u0018\u00010!j\n\u0012\u0004\u0012\u00020\"\u0018\u0001`#J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0019\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0019\u0010(\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u000e\u0010)\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/wear/ui/chat/action/ChatMessageAction;", "", "databaseType", "Lcom/wear/ui/chat/action/ChatMessageAction$DatabaseType;", "(Lcom/wear/ui/chat/action/ChatMessageAction$DatabaseType;)V", "iChatMessageStrategy", "Lcom/wear/ui/chat/action/IChatMessageStrategy;", "messageDatabase", "Lcom/wear/ui/chat/db/MessageDatabase;", "getMessageDatabase", "()Lcom/wear/ui/chat/db/MessageDatabase;", "messageDatabase$delegate", "Lkotlin/Lazy;", "deleteAssets", "", "accountCode", "", "pageNo", "", "deleteMessage", "Lcom/wear/bean/chat/MessageResult;", "message", "Lcom/wear/bean/chat/Message;", "(Lcom/wear/bean/chat/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exitRouletteRoom", "Lcom/wear/bean/response/BaseResponseBeanNew;", "Lcom/wear/network/presenter/bean/BaseResponseBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMessageFromDatabase", "", DataLayout.ELEMENT, "queryMessageFromDatabaseFilterText", "selectedList", "Ljava/util/ArrayList;", "Lcom/wear/bean/chat/MessageSelected;", "Lkotlin/collections/ArrayList;", "removeAudioAssets", "removeDatabaseAndAssetsFromUserAccountCode", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSyncDatabaseAndAssetsFromUserAccountCode", "sendMessage", "updateDatabase", "Companion", "DatabaseType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class kr2 {

    @NotNull
    public static final a c = new a(null);

    @Nullable
    public static kr2 d;

    @Nullable
    public static kr2 e;

    @NotNull
    public final nr2 a;

    @NotNull
    public final Lazy b;

    /* compiled from: ChatMessageAction.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/wear/ui/chat/action/ChatMessageAction$Companion;", "", "()V", "chatMessageActionWithNewDatabase", "Lcom/wear/ui/chat/action/ChatMessageAction;", "chatMessageActionWithOldDatabase", "getInstance", "databaseType", "Lcom/wear/ui/chat/action/ChatMessageAction$DatabaseType;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final kr2 a(@NotNull b databaseType) {
            kr2 kr2Var;
            Intrinsics.checkNotNullParameter(databaseType, "databaseType");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (databaseType == b.COLUMN_MESSAGE) {
                kr2Var = kr2.e;
                if (kr2Var == null) {
                    synchronized (this) {
                        kr2Var = kr2.e;
                        if (kr2Var == null) {
                            kr2Var = new kr2(databaseType, defaultConstructorMarker);
                        }
                    }
                }
            } else {
                kr2Var = kr2.d;
                if (kr2Var == null) {
                    synchronized (this) {
                        kr2Var = kr2.d;
                        if (kr2Var == null) {
                            kr2Var = new kr2(databaseType, defaultConstructorMarker);
                        }
                    }
                }
            }
            return kr2Var;
        }
    }

    /* compiled from: ChatMessageAction.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/wear/ui/chat/action/ChatMessageAction$DatabaseType;", "", "(Ljava/lang/String;I)V", "MESSAGE", "COLUMN_MESSAGE", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum b {
        MESSAGE,
        COLUMN_MESSAGE
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements zn2<String> {
        public final /* synthetic */ yy3 a;

        /* compiled from: HttpCoroutine.kt */
        @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutinePost$2$1$onSuccess$type$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<BaseResponseBeanNew<BaseResponseBean>> {
        }

        public c(yy3 yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull String response) {
            Intrinsics.checkNotNullParameter(response, "response");
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) WearUtils.A.fromJson(response, new a().getType());
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(baseResponseBeanNew));
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(null));
        }
    }

    /* compiled from: ChatMessageAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lcom/wear/ui/chat/db/MessageDatabase;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<xs2> {
        public final /* synthetic */ b $databaseType;

        /* compiled from: ChatMessageAction.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[b.values().length];
                iArr[b.MESSAGE.ordinal()] = 1;
                iArr[b.COLUMN_MESSAGE.ordinal()] = 2;
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar) {
            super(0);
            this.$databaseType = bVar;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final xs2 invoke() {
            int i = a.a[this.$databaseType.ordinal()];
            if (i == 1) {
                return ys2.b.a();
            }
            if (i == 2) {
                return zs2.a.a();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: ChatMessageAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.action.ChatMessageAction$removeDatabaseAndAssetsFromUserAccountCode$2", f = "ChatMessageAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $accountCode;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$accountCode = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return kr2.this.new e(this.$accountCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            kr2.this.e(this.$accountCode, 0);
            kr2.this.h().f(this.$accountCode);
            return Unit.INSTANCE;
        }
    }

    public kr2(b bVar) {
        this.b = LazyKt__LazyJVMKt.lazy(new d(bVar));
        mr2 mr2Var = new mr2();
        lr2 lr2Var = new lr2(h());
        this.a = lr2Var;
        lr2Var.f(mr2Var);
    }

    public /* synthetic */ kr2(b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar);
    }

    public final void e(String str, int i) {
        while (true) {
            List<Message> listE = h().e(str, i);
            if (listE.isEmpty()) {
                return;
            }
            Iterator<Message> it = listE.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
            i++;
        }
    }

    @Nullable
    public final Object f(@NotNull Message message, @NotNull Continuation<? super MessageResult> continuation) {
        k(message);
        return this.a.b(message, continuation);
    }

    @Nullable
    public final Object g(@NotNull Continuation<? super BaseResponseBeanNew<BaseResponseBean>> continuation) {
        Object obj = new Object();
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        tn2.x(WearUtils.x).m("/wear/toyRoulette/exit-room", WearUtils.A.toJson(obj), new c(zy3Var));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    public final xs2 h() {
        return (xs2) this.b.getValue();
    }

    @NotNull
    public final List<Message> i(@NotNull String accountCode, int i) {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        return h().e(accountCode, i);
    }

    @NotNull
    public final List<Message> j(@NotNull String accountCode, @Nullable ArrayList<MessageSelected> arrayList) {
        ArrayList arrayList2;
        Integer receiveStatus;
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        xs2 xs2VarH = h();
        if (arrayList != null) {
            arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((MessageSelected) it.next()).getMsgId());
            }
        } else {
            arrayList2 = null;
        }
        List<Message> listD = xs2VarH.d(accountCode, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : listD) {
            Message message = (Message) obj;
            Integer sendStatus = message.getSendStatus();
            boolean z = true;
            if ((sendStatus == null || sendStatus.intValue() != 1 || message.getDirection() != 0) && ((receiveStatus = message.getReceiveStatus()) == null || receiveStatus.intValue() != 1 || message.getDirection() != 1)) {
                z = false;
            }
            if (z) {
                arrayList3.add(obj);
            }
        }
        return arrayList3;
    }

    public final void k(Message message) {
        if (message.getType() != 3) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(WearUtils.T("mic").getAbsolutePath());
        sb.append(File.separator);
        sb.append(WearUtils.B(message.getMessageId() + ".acc"));
        File file = new File(sb.toString());
        if (file.exists()) {
            file.delete();
        }
    }

    @Nullable
    public final Object l(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objG = sy3.g(n04.b(), new e(str, null), continuation);
        return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : Unit.INSTANCE;
    }

    public final void m(@NotNull String accountCode) {
        Intrinsics.checkNotNullParameter(accountCode, "accountCode");
        e(accountCode, 0);
        h().f(accountCode);
    }

    @Nullable
    public final Object n(@NotNull Message message, @NotNull Continuation<? super MessageResult> continuation) {
        return this.a.e(message, continuation);
    }

    public final void o(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        h().b(message);
    }
}
