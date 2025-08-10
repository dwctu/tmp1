package com.wear.ui.chat;

import android.media.MediaRecorder;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.lovense.wear.R;
import com.wear.bean.Account;
import com.wear.bean.RecyclerViewStatus;
import com.wear.bean.chat.Message;
import com.wear.bean.chat.MessageConfig;
import com.wear.bean.chat.MessageResult;
import com.wear.bean.chat.MessageSelected;
import com.wear.bean.chat.Messages;
import com.wear.bean.chat.ToyInfo;
import com.wear.bean.chat.VoiceFilesBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.dao.DaoUtils;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import com.wear.widget.chatMic.VoiceMessagePanelView;
import dc.a14;
import dc.ah4;
import dc.ch3;
import dc.hr2;
import dc.ie3;
import dc.ir2;
import dc.jr2;
import dc.kr2;
import dc.mu1;
import dc.sg3;
import dc.t34;
import dc.tn2;
import dc.uy3;
import dc.wz3;
import dc.yn2;
import dc.yy3;
import dc.zt1;
import dc.zy3;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: NewChatViewModel.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010K\u001a\u00020$J\u001b\u0010L\u001a\u0004\u0018\u00010$2\u0006\u0010M\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010NJ\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020$J#\u0010U\u001a\u00020$2\u0006\u0010V\u001a\u00020\u000b2\b\u0010W\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010XJ\u0006\u0010Y\u001a\u00020PJ\u000e\u0010Z\u001a\u00020P2\u0006\u0010R\u001a\u00020SJ\u000e\u0010[\u001a\u00020P2\u0006\u0010R\u001a\u00020SJ\u0011\u0010\\\u001a\u00020PH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010]J\u0006\u0010^\u001a\u00020PJ\u0006\u0010_\u001a\u00020PJ\u0006\u0010`\u001a\u00020PJ\u000e\u0010a\u001a\b\u0012\u0004\u0012\u00020S0EH\u0002J!\u0010b\u001a\u00020P2\u0006\u0010R\u001a\u00020S2\u0006\u0010c\u001a\u00020dH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0010\u0010f\u001a\u00020P2\u0006\u0010R\u001a\u00020SH\u0002J\u000e\u0010g\u001a\u00020P2\u0006\u0010h\u001a\u00020\u000bJ\u0006\u0010i\u001a\u00020PJ\u000e\u0010j\u001a\u00020P2\u0006\u0010k\u001a\u00020lJ\u0006\u0010m\u001a\u00020PJ\u0018\u0010n\u001a\u00020P2\u0006\u0010o\u001a\u00020$2\b\b\u0002\u0010p\u001a\u00020/J\u0016\u0010q\u001a\u00020P2\u0006\u0010R\u001a\u00020S2\u0006\u0010r\u001a\u00020$R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u0005018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\t\u001a\u0004\b2\u00103R\"\u00105\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\t\u001a\u0004\bA\u0010BR\"\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006s"}, d2 = {"Lcom/wear/ui/chat/NewChatViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_recyclerViewStatus", "Lcom/wear/ui/chat/ChatMessageObservableData;", "Lcom/wear/bean/RecyclerViewStatus;", "get_recyclerViewStatus", "()Lcom/wear/ui/chat/ChatMessageObservableData;", "_recyclerViewStatus$delegate", "Lkotlin/Lazy;", "audioMessageId", "", "audioRecordAction", "Lcom/wear/ui/chat/action/AudioRecordAction;", "getAudioRecordAction", "()Lcom/wear/ui/chat/action/AudioRecordAction;", "audioRecordAction$delegate", "chatMessageAction", "Lcom/wear/ui/chat/action/ChatMessageAction;", "chatVideoControl", "Lcom/wear/main/longDistance/control/ChatVideoControl;", "getChatVideoControl", "()Lcom/wear/main/longDistance/control/ChatVideoControl;", "chatVideoControl$delegate", "emojisUtils", "Lcom/wear/util/EmojisUtils;", "getEmojisUtils", "()Lcom/wear/util/EmojisUtils;", "setEmojisUtils", "(Lcom/wear/util/EmojisUtils;)V", "encryptionMode", "getEncryptionMode", "()Ljava/lang/String;", "setEncryptionMode", "(Ljava/lang/String;)V", "hasMoreHistoryData", "", "inputText", "Landroidx/databinding/ObservableField;", "getInputText", "()Landroidx/databinding/ObservableField;", "isLoadingMoreData", "isSelectMode", "()Z", "setSelectMode", "(Z)V", "pageNo", "", "recyclerViewStatus", "Lkotlinx/coroutines/flow/Flow;", "getRecyclerViewStatus", "()Lkotlinx/coroutines/flow/Flow;", "recyclerViewStatus$delegate", "selectedList", "Ljava/util/ArrayList;", "Lcom/wear/bean/chat/MessageSelected;", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "userAccountCode", "getUserAccountCode", "setUserAccountCode", "userInfo", "Lcom/wear/bean/Account;", "getUserInfo", "()Lcom/wear/bean/Account;", "userInfo$delegate", "userToys", "", "Lcom/wear/bean/chat/ToyInfo;", "getUserToys", "()Ljava/util/List;", "setUserToys", "(Ljava/util/List;)V", "checkMediaIsBusy", "checkRoomExist", "roomId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearDatabase", "", "deleteMessage", "message", "Lcom/wear/bean/chat/Message;", "isAudioPlaying", "playAudioUrl", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, ImagesContract.URL, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewData", "reSendMessage", "receiverMessage", "removeDatabaseAndAssets", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeDatabaseAndAssetsFromUserAccountCode", "requestData", "requestDataAndRemoveDatabaseAndAssets", "requestDatabaseData", "sendFileMessage", "file", "Ljava/io/File;", "(Lcom/wear/bean/chat/Message;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessage", "sendSystemMessage", "text", "sendTextMessage", "startRecord", "voiceMessagePanelView", "Lcom/wear/widget/chatMic/VoiceMessagePanelView;", "stopPlayAudio", "stopRecord", "isCancel", "countTime", "updateEmojisPlayStateChange", "isPlayed", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NewChatViewModel extends ViewModel {

    @Nullable
    public String c;

    @Nullable
    public List<ToyInfo> d;

    @Nullable
    public String e;
    public int f;
    public boolean l;
    public boolean m;

    @Nullable
    public ArrayList<MessageSelected> n;

    @Nullable
    public ie3 o;

    @Nullable
    public String q;

    @NotNull
    public final Lazy a = LazyKt__LazyJVMKt.lazy(c.a);

    @NotNull
    public final Lazy b = LazyKt__LazyJVMKt.lazy(p.a);

    @NotNull
    public final kr2 g = kr2.c.a(kr2.b.MESSAGE);

    @NotNull
    public final Lazy h = LazyKt__LazyJVMKt.lazy(a.a);

    @NotNull
    public final Lazy i = LazyKt__LazyJVMKt.lazy(new i());

    @NotNull
    public final ObservableField<String> j = new ObservableField<>("");
    public boolean k = true;

    @NotNull
    public final Lazy p = LazyKt__LazyJVMKt.lazy(b.a);

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/wear/ui/chat/ChatMessageObservableData;", "Lcom/wear/bean/RecyclerViewStatus;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<hr2<RecyclerViewStatus>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final hr2<RecyclerViewStatus> invoke() {
            return new hr2<>();
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/ui/chat/action/AudioRecordActionIml;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<jr2> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final jr2 invoke() {
            return new jr2();
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/wear/main/longDistance/control/ChatVideoControl;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<ChatVideoControl> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ChatVideoControl invoke() {
            return ChatVideoControl.a1();
        }
    }

    /* compiled from: HttpCoroutine.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0016¨\u0006\u000b¸\u0006\u0000"}, d2 = {"com/wear/ext/HttpCoroutineKt$requestCoroutineGetForm$2$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/response/BaseResponseBeanNew;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements yn2<BaseResponseBeanNew<Boolean>> {
        public final /* synthetic */ yy3 a;

        public d(yy3 yy3Var) {
            this.a = yy3Var;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull BaseResponseBeanNew<Boolean> response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.code != 0) {
                yy3 yy3Var = this.a;
                Result.Companion companion = Result.INSTANCE;
                yy3Var.resumeWith(Result.m86constructorimpl(null));
            }
            yy3 yy3Var2 = this.a;
            Result.Companion companion2 = Result.INSTANCE;
            yy3Var2.resumeWith(Result.m86constructorimpl(response.data));
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@Nullable NetException e) {
            String str = e != null ? e.message : null;
            if (str == null) {
                str = "network error";
            }
            ToastUtils.z(str, new Object[0]);
            yy3 yy3Var = this.a;
            Result.Companion companion = Result.INSTANCE;
            yy3Var.resumeWith(Result.m86constructorimpl(null));
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatViewModel$clearDatabase$1", f = "NewChatViewModel.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NewChatViewModel.this.new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String c = NewChatViewModel.this.getC();
                if (c != null) {
                    NewChatViewModel newChatViewModel = NewChatViewModel.this;
                    DaoUtils.getRouletteUserDao().delete(c);
                    this.label = 1;
                    if (newChatViewModel.x(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatViewModel$deleteMessage$1", f = "NewChatViewModel.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Message $message;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Message message, Continuation<? super f> continuation) {
            super(2, continuation);
            this.$message = message;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NewChatViewModel.this.new f(this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((f) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                kr2 kr2Var = NewChatViewModel.this.g;
                Message message = this.$message;
                this.label = 1;
                obj = kr2Var.f(message, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((MessageResult) obj) instanceof MessageResult.Success) {
                NewChatViewModel.this.r().b(new RecyclerViewStatus.DeleteMessage(this.$message));
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatViewModel", f = "NewChatViewModel.kt", i = {1, 1, 1}, l = {351, 368, 354}, m = "playAudioUrl", n = {"this", "it", "$completion$iv"}, s = {"L$0", "L$1", "L$2"})
    public static final class g extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
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
            return NewChatViewModel.this.t(null, null, this);
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatViewModel$reSendMessage$1", f = "NewChatViewModel.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Message $message;
        public int label;
        public final /* synthetic */ NewChatViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Message message, NewChatViewModel newChatViewModel, Continuation<? super h> continuation) {
            super(2, continuation);
            this.$message = message;
            this.this$0 = newChatViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new h(this.$message, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.$message.setSendStatus(Boxing.boxInt(0));
                this.this$0.r().b(new RecyclerViewStatus.UpdateMessage(this.$message));
                kr2 kr2Var = this.this$0.g;
                Message message = this.$message;
                this.label = 1;
                obj = kr2Var.n(message, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((MessageResult) obj) instanceof MessageResult.Success) {
                this.$message.setSendStatus(Boxing.boxInt(1));
            } else {
                this.$message.setSendStatus(Boxing.boxInt(2));
            }
            this.this$0.g.o(this.$message);
            this.this$0.r().b(new RecyclerViewStatus.UpdateMessage(this.$message));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/wear/bean/RecyclerViewStatus;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function0<t34<? extends RecyclerViewStatus>> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t34<RecyclerViewStatus> invoke() {
            return NewChatViewModel.this.r().a();
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatViewModel", f = "NewChatViewModel.kt", i = {}, l = {266}, m = "removeDatabaseAndAssets", n = {}, s = {})
    public static final class j extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        public j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NewChatViewModel.this.x(this);
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatViewModel$removeDatabaseAndAssetsFromUserAccountCode$1", f = "NewChatViewModel.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public k(Continuation<? super k> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NewChatViewModel.this.new k(continuation);
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
                kr2 kr2Var = NewChatViewModel.this.g;
                this.label = 1;
                if (kr2Var.g(this) == coroutine_suspended) {
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

    /* compiled from: NewChatViewModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatViewModel", f = "NewChatViewModel.kt", i = {0, 0, 0, 0, 1, 1}, l = {367, 222}, m = "sendFileMessage", n = {"this", "message", "file", "url$iv", "this", "message"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
    public static final class l extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;
        public /* synthetic */ Object result;

        public l(Continuation<? super l> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NewChatViewModel.this.C(null, null, this);
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatViewModel$sendMessage$1", f = "NewChatViewModel.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
    public static final class m extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Message $message;
        public int label;
        public final /* synthetic */ NewChatViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Message message, NewChatViewModel newChatViewModel, Continuation<? super m> continuation) {
            super(2, continuation);
            this.$message = message;
            this.this$0 = newChatViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new m(this.$message, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((m) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.$message.setFromAccountId(ch3.n().o().getAppAccountCode());
                this.$message.setToAccountId(this.this$0.getC());
                this.$message.setSendStatus(Boxing.boxInt(1));
                this.$message.setMessageConfig(new MessageConfig());
                this.$message.setEncryptionMode(this.this$0.getE());
                this.this$0.r().b(new RecyclerViewStatus.NewMessage(this.$message));
                kr2 kr2Var = this.this$0.g;
                Message message = this.$message;
                this.label = 1;
                obj = kr2Var.n(message, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((MessageResult) obj) instanceof MessageResult.Success) {
                this.$message.setSendStatus(Boxing.boxInt(1));
            } else {
                this.$message.setSendStatus(Boxing.boxInt(2));
            }
            this.this$0.g.o(this.$message);
            this.this$0.r().b(new RecyclerViewStatus.UpdateMessage(this.$message));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatViewModel$startRecord$1", f = "NewChatViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class n extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ VoiceMessagePanelView $voiceMessagePanelView;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(VoiceMessagePanelView voiceMessagePanelView, Continuation<? super n> continuation) {
            super(2, continuation);
            this.$voiceMessagePanelView = voiceMessagePanelView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NewChatViewModel.this.new n(this.$voiceMessagePanelView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((n) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NewChatViewModel.this.q = UUID.randomUUID().toString();
            ir2 ir2VarK = NewChatViewModel.this.k();
            String str = NewChatViewModel.this.q;
            Intrinsics.checkNotNull(str);
            if (!ir2VarK.T(str)) {
                sg3.l("audio failed to start");
                return Unit.INSTANCE;
            }
            MediaRecorder mediaRecorderP = NewChatViewModel.this.k().P();
            if (mediaRecorderP != null) {
                this.$voiceMessagePanelView.k(mediaRecorderP);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.NewChatViewModel$stopRecord$1", f = "NewChatViewModel.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
    public static final class o extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ VoiceFilesBean $voiceFilesBean;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(VoiceFilesBean voiceFilesBean, Continuation<? super o> continuation) {
            super(2, continuation);
            this.$voiceFilesBean = voiceFilesBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NewChatViewModel.this.new o(this.$voiceFilesBean, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((o) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Messages messages = Messages.INSTANCE;
                String string = NewChatViewModel.this.q;
                if (string == null) {
                    string = UUID.randomUUID().toString();
                    Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                }
                String absolutePath = this.$voiceFilesBean.getVoiceFile().getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "voiceFilesBean.voiceFile.absolutePath");
                Message messageObtainAudioMessage = messages.obtainAudioMessage(string, absolutePath, this.$voiceFilesBean.getVoiceDuration());
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(WearUtils.x);
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(WearUtils.application)");
                zt1.b(firebaseAnalytics, "chat_voice", null, 2, null);
                NewChatViewModel newChatViewModel = NewChatViewModel.this;
                File voiceFile = this.$voiceFilesBean.getVoiceFile();
                this.label = 1;
                if (newChatViewModel.C(messageObtainAudioMessage, voiceFile, this) == coroutine_suspended) {
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

    /* compiled from: NewChatViewModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/bean/Account;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function0<Account> {
        public static final p a = new p();

        public p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Account invoke() {
            return WearUtils.y.u();
        }
    }

    public static /* synthetic */ void P(NewChatViewModel newChatViewModel, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        newChatViewModel.O(z, i2);
    }

    public final void A() {
        String str = this.c;
        if (str != null) {
            this.g.m(str);
            z();
        }
    }

    public final List<Message> B() {
        List<Message> listI;
        String str = this.c;
        if ((str == null || str.length() == 0) || !this.k) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (this.m) {
            kr2 kr2Var = this.g;
            String str2 = this.c;
            Intrinsics.checkNotNull(str2);
            listI = kr2Var.j(str2, this.n);
        } else {
            kr2 kr2Var2 = this.g;
            String str3 = this.c;
            Intrinsics.checkNotNull(str3);
            int i2 = this.f;
            this.f = i2 + 1;
            listI = kr2Var2.i(str3, i2);
        }
        if (listI.isEmpty()) {
            this.k = false;
        }
        return listI;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object C(com.wear.bean.chat.Message r20, java.io.File r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.chat.NewChatViewModel.C(com.wear.bean.chat.Message, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void D(Message message) {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new m(message, this, null), 3, null);
    }

    public final void E(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() == 0) {
            String strE = ah4.e(R.string.chat_unable_send_blank_message);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.chat_unable_send_blank_message)");
            mu1.a(strE);
        } else {
            Message messageObtainSystemMessage = Messages.INSTANCE.obtainSystemMessage(text);
            messageObtainSystemMessage.setSkipSend(true);
            D(messageObtainSystemMessage);
        }
    }

    public final void F() {
        String str = this.j.get();
        String string = str != null ? StringsKt__StringsKt.trim((CharSequence) str).toString() : null;
        if (string == null || string.length() == 0) {
            String strE = ah4.e(R.string.chat_unable_send_blank_message);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.chat_unable_send_blank_message)");
            mu1.a(strE);
        } else {
            ie3 ie3Var = this.o;
            if (ie3Var != null) {
                ie3Var.M(string);
            }
            D(Messages.INSTANCE.obtainTextMessage(string));
        }
    }

    public final void G(@Nullable ie3 ie3Var) {
        this.o = ie3Var;
    }

    public final void H(@Nullable String str) {
        this.e = str;
    }

    public final void I(boolean z) {
        this.m = z;
    }

    public final void J(@Nullable ArrayList<MessageSelected> arrayList) {
        this.n = arrayList;
    }

    public final void K(@Nullable String str) {
        this.c = str;
    }

    public final void L(@Nullable List<ToyInfo> list) {
        this.d = list;
    }

    public final void M(@NotNull VoiceMessagePanelView voiceMessagePanelView) {
        Intrinsics.checkNotNullParameter(voiceMessagePanelView, "voiceMessagePanelView");
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new n(voiceMessagePanelView, null), 3, null);
    }

    public final void N() {
        k().R();
    }

    public final void O(boolean z, int i2) {
        if (i2 != -1 && i2 < 1) {
            sg3.h(R.string.chat_voice_timeShort);
            k().O();
        } else {
            if (z) {
                k().O();
                return;
            }
            VoiceFilesBean voiceFilesBeanS = k().S();
            if (voiceFilesBeanS == null) {
                return;
            }
            uy3.d(ViewModelKt.getViewModelScope(this), null, null, new o(voiceFilesBeanS, null), 3, null);
        }
    }

    public final void Q(@NotNull Message message, boolean z) throws SQLException {
        Intrinsics.checkNotNullParameter(message, "message");
        MessageConfig messageConfig = new MessageConfig();
        messageConfig.setMessageId(message.getMessageId());
        messageConfig.setShowEmojiAnimation(z);
        DaoUtils.getChatMessageConfigDao().add(messageConfig);
    }

    @Nullable
    public final Object h(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        Map<String, Object> mapMapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("roomId", str));
        zy3 zy3Var = new zy3(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        zy3Var.A();
        tn2.x(WearUtils.x).g("/wear/toyRoulette/check-room-exist", mapMapOf, new d(zy3Var));
        Object objX = zy3Var.x();
        if (objX == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objX;
    }

    public final void i() {
        uy3.d(a14.a, null, null, new e(null), 3, null);
    }

    public final void j(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new f(message, null), 3, null);
    }

    public final ir2 k() {
        return (ir2) this.p.getValue();
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final String getE() {
        return this.e;
    }

    @NotNull
    public final ObservableField<String> m() {
        return this.j;
    }

    @NotNull
    public final t34<RecyclerViewStatus> n() {
        return (t34) this.i.getValue();
    }

    @Nullable
    public final ArrayList<MessageSelected> o() {
        return this.n;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final String getC() {
        return this.c;
    }

    @Nullable
    public final List<ToyInfo> q() {
        return this.d;
    }

    public final hr2<RecyclerViewStatus> r() {
        return (hr2) this.h.getValue();
    }

    public final boolean s() {
        return k().isPlaying();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.Nullable java.lang.String r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.chat.NewChatViewModel.t(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void u() {
        if (this.l) {
            return;
        }
        this.l = true;
        r().b(new RecyclerViewStatus.PreMessages(CollectionsKt___CollectionsKt.toMutableList((Collection) B())));
        this.l = false;
    }

    public final void v(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new h(message, this, null), 3, null);
    }

    public final void w(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        r().b(new RecyclerViewStatus.NewMessage(message));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object x(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.wear.ui.chat.NewChatViewModel.j
            if (r0 == 0) goto L13
            r0 = r5
            com.wear.ui.chat.NewChatViewModel$j r0 = (com.wear.ui.chat.NewChatViewModel.j) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.wear.ui.chat.NewChatViewModel$j r0 = new com.wear.ui.chat.NewChatViewModel$j
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.String r5 = r4.c
            if (r5 == 0) goto L43
            dc.kr2 r2 = r4.g
            r0.label = r3
            java.lang.Object r5 = r2.l(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.chat.NewChatViewModel.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void y() {
        uy3.d(a14.a, null, null, new k(null), 3, null);
    }

    public final void z() {
        r().b(new RecyclerViewStatus.NewMessages(CollectionsKt___CollectionsKt.toMutableList((Collection) B())));
    }
}
