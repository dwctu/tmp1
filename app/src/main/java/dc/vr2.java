package dc;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import com.lovense.wear.R;
import com.wear.bean.chat.Message;
import com.wear.bean.chat.MessageBody;
import com.wear.ui.chat.widget.ChatAudioView;
import dc.h14;
import java.lang.ref.WeakReference;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseAudioProvider.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/wear/ui/chat/adapter/provoder/BaseAudioProvider;", "Lcom/wear/ui/chat/adapter/provoder/BaseProvider;", "onAudioPlayListener", "Lcom/wear/ui/chat/adapter/provoder/BaseAudioProvider$OnAudioPlayListener;", "(Lcom/wear/ui/chat/adapter/provoder/BaseAudioProvider$OnAudioPlayListener;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "playJob", "Lkotlinx/coroutines/Job;", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/wear/bean/chat/Message;", "onClickAudio", "view", "Landroid/view/View;", "Companion", "OnAudioPlayListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class vr2 extends wr2 {

    @NotNull
    public static final a g = new a(null);

    @Nullable
    public static WeakReference<ChatAudioView> h;

    @Nullable
    public final b d;

    @NotNull
    public final wz3 e = xz3.a(n04.c());

    @Nullable
    public h14 f;

    /* compiled from: BaseAudioProvider.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/wear/ui/chat/adapter/provoder/BaseAudioProvider$Companion;", "", "()V", "cacheAudioViewWeak", "Ljava/lang/ref/WeakReference;", "Lcom/wear/ui/chat/widget/ChatAudioView;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: BaseAudioProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J#\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/wear/ui/chat/adapter/provoder/BaseAudioProvider$OnAudioPlayListener;", "", "isPlaying", "", "playAudioUrl", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", ImagesContract.URL, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopPlayAudio", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        @Nullable
        Object c3(@NotNull String str, @Nullable String str2, @NotNull Continuation<? super Boolean> continuation);

        boolean isPlaying();

        void t2();
    }

    /* compiled from: BaseAudioProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.chat.adapter.provoder.BaseAudioProvider$onClickAudio$1", f = "BaseAudioProvider.kt", i = {}, l = {63, 72}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ ChatAudioView $cacheAudioView;
        public final /* synthetic */ ChatAudioView $chatAudioView;
        public final /* synthetic */ View $view;
        public int label;
        public final /* synthetic */ vr2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ChatAudioView chatAudioView, ChatAudioView chatAudioView2, vr2 vr2Var, View view, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$chatAudioView = chatAudioView;
            this.$cacheAudioView = chatAudioView2;
            this.this$0 = vr2Var;
            this.$view = view;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(this.$chatAudioView, this.$cacheAudioView, this.this$0, this.$view, continuation);
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
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Intrinsics.areEqual(this.$chatAudioView, this.$cacheAudioView)) {
                    b bVar = this.this$0.d;
                    if (bVar != null && bVar.isPlaying()) {
                        this.$chatAudioView.d();
                        this.this$0.d.t2();
                        return Unit.INSTANCE;
                    }
                    this.$chatAudioView.c();
                    Object tag = ((ChatAudioView) this.$view).getTag();
                    Message message = tag instanceof Message ? (Message) tag : null;
                    if (message == null) {
                        return Unit.INSTANCE;
                    }
                    MessageBody messageBody = (MessageBody) message.getContentData(MessageBody.class);
                    String messageId = message.getMessageId();
                    if (messageId == null || messageId.length() == 0) {
                        return Unit.INSTANCE;
                    }
                    b bVar2 = this.this$0.d;
                    if (bVar2 != null) {
                        String messageId2 = message.getMessageId();
                        Intrinsics.checkNotNull(messageId2);
                        String assetURL = messageBody != null ? messageBody.getAssetURL() : null;
                        this.label = 1;
                        obj = bVar2.c3(messageId2, assetURL, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    this.$chatAudioView.d();
                    a aVar = vr2.g;
                    vr2.h = null;
                } else {
                    this.$chatAudioView.c();
                    Object tag2 = ((ChatAudioView) this.$view).getTag();
                    Message message2 = tag2 instanceof Message ? (Message) tag2 : null;
                    if (message2 == null) {
                        return Unit.INSTANCE;
                    }
                    MessageBody messageBody2 = (MessageBody) message2.getContentData(MessageBody.class);
                    String messageId3 = message2.getMessageId();
                    if (messageId3 != null && messageId3.length() != 0) {
                        z = false;
                    }
                    if (z) {
                        return Unit.INSTANCE;
                    }
                    b bVar3 = this.this$0.d;
                    if (bVar3 != null) {
                        String messageId4 = message2.getMessageId();
                        Intrinsics.checkNotNull(messageId4);
                        String assetURL2 = messageBody2 != null ? messageBody2.getAssetURL() : null;
                        this.label = 2;
                        obj = bVar3.c3(messageId4, assetURL2, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    this.$chatAudioView.d();
                    a aVar2 = vr2.g;
                    vr2.h = null;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                this.$chatAudioView.d();
                a aVar3 = vr2.g;
                vr2.h = null;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$chatAudioView.d();
                a aVar22 = vr2.g;
                vr2.h = null;
            }
            return Unit.INSTANCE;
        }
    }

    public vr2(@Nullable b bVar) {
        this.d = bVar;
    }

    @Override // dc.wr2
    /* renamed from: t */
    public void a(@NotNull BaseViewHolder helper, @NotNull Message item) {
        Integer duration;
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        super.a(helper, item);
        ChatAudioView chatAudioView = (ChatAudioView) helper.getView(R.id.chat_audio_view);
        if (chatAudioView.a()) {
            return;
        }
        MessageBody messageBody = (MessageBody) item.getContentData(MessageBody.class);
        if (messageBody != null && (duration = messageBody.getDuration()) != null) {
            chatAudioView.setDuration(duration.intValue());
        }
        chatAudioView.setTag(item);
    }

    public final void x(@Nullable View view) {
        ChatAudioView chatAudioView = view instanceof ChatAudioView ? (ChatAudioView) view : null;
        if (chatAudioView == null) {
            return;
        }
        h14 h14Var = this.f;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        WeakReference<ChatAudioView> weakReference = h;
        ChatAudioView chatAudioView2 = weakReference != null ? weakReference.get() : null;
        if (chatAudioView2 != null) {
            chatAudioView2.d();
        }
        h = new WeakReference<>(chatAudioView);
        this.f = uy3.d(this.e, null, null, new c(chatAudioView, chatAudioView2, this, view, null), 3, null);
    }
}
