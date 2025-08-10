package dc;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.lovense.wear.R;
import com.wear.bean.RecyclerViewStatus;
import com.wear.bean.chat.Message;
import com.wear.bean.chat.MessageBody;
import com.wear.ext.ActivityKt;
import com.wear.ui.chat.adapter.ChatAdapter;
import com.wear.util.HttpTextView;
import com.wear.util.MyApplication;
import com.wear.widget.SkinLottieAnimationView;
import com.wear.widget.dialog.LinkJumpDialog;
import java.io.File;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatRecyclerViewDatabindingAdapter.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007\u001a,\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a,\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0001*\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\u001b"}, d2 = {"bindChatAnimation", "", "Lcom/airbnb/lottie/LottieAnimationView;", "message", "Lcom/wear/bean/chat/Message;", "emojisUtils", "Lcom/wear/util/EmojisUtils;", "emojisType", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/wear/ui/chat/adapter/ChatAdapter$ChatAdapterListener;", "bindChatImage", "Landroid/widget/ImageView;", "animatingView", "Lcom/wear/widget/SkinLottieAnimationView;", "bindChatText", "Lcom/wear/util/HttpTextView;", "isSelf", "", "bindRecyclerViewStatus", "Landroidx/recyclerview/widget/RecyclerView;", "status", "Lcom/wear/bean/RecyclerViewStatus;", "bindSystemText", "Landroid/widget/TextView;", "setChatItemBackground", "Landroid/view/View;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ws2 {
    @BindingAdapter(requireAll = true, value = {"bindChatAnimation", "emojisUtils", "emojisType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER})
    public static final void a(@NotNull LottieAnimationView lottieAnimationView, @NotNull Message message, @NotNull ie3 emojisUtils, int i, @Nullable ChatAdapter.a aVar) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(emojisUtils, "emojisUtils");
        if (lottieAnimationView.o()) {
            lottieAnimationView.setVisibility(0);
            return;
        }
        lottieAnimationView.setVisibility(i != 2 ? 8 : 0);
        if (lottieAnimationView.getVisibility() == 8) {
            return;
        }
        MessageBody messageBody = (MessageBody) message.getContentData(MessageBody.class);
        emojisUtils.O(lottieAnimationView, emojisUtils.s(messageBody != null ? messageBody.getText() : null, false));
        if (aVar != null) {
            aVar.N2(message);
        }
    }

    @BindingAdapter(requireAll = true, value = {"bindChatImage", "emojisUtils", "emojisType", "animatingView"})
    public static final void b(@NotNull ImageView imageView, @NotNull Message message, @NotNull ie3 emojisUtils, int i, @NotNull SkinLottieAnimationView animatingView) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(emojisUtils, "emojisUtils");
        Intrinsics.checkNotNullParameter(animatingView, "animatingView");
        if (animatingView.o()) {
            imageView.setVisibility(8);
            return;
        }
        MessageBody messageBody = (MessageBody) message.getContentData(MessageBody.class);
        imageView.setVisibility(i != 1 ? 8 : 0);
        if (imageView.getVisibility() == 8) {
            return;
        }
        File fileR = emojisUtils.r(messageBody != null ? messageBody.getText() : null);
        if (fileR != null) {
            iu1.a(imageView, fileR);
        } else {
            imageView.setImageBitmap(emojisUtils.F(messageBody != null ? messageBody.getText() : null));
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        float f = fileR != null ? 68.0f : 28.0f;
        layoutParams.width = ce3.a(imageView.getContext(), f);
        layoutParams.height = ce3.a(imageView.getContext(), f);
        imageView.setLayoutParams(layoutParams);
    }

    @BindingAdapter(requireAll = true, value = {"bindChatText", "emojisUtils", "emojisType", "isSelf"})
    public static final void c(@NotNull final HttpTextView httpTextView, @NotNull Message message, @NotNull ie3 emojisUtils, int i, boolean z) {
        Intrinsics.checkNotNullParameter(httpTextView, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(emojisUtils, "emojisUtils");
        MessageBody messageBody = (MessageBody) message.getContentData(MessageBody.class);
        httpTextView.setVisibility(i != 0 ? 8 : 0);
        if (httpTextView.getVisibility() == 8) {
            return;
        }
        mz1 mz1VarD = nz1.e().d();
        httpTextView.setTextColor(z ? mz1VarD.K() : mz1VarD.h0());
        httpTextView.setUrlText(emojisUtils, messageBody != null ? messageBody.getText() : null, z, new HttpTextView.a() { // from class: dc.vs2
            @Override // com.wear.util.HttpTextView.a
            public final void a(boolean z2, String str) throws Exception {
                ws2.d(httpTextView, z2, str);
            }
        });
    }

    public static final void d(final HttpTextView this_bindChatText, boolean z, String str) throws Exception {
        Intrinsics.checkNotNullParameter(this_bindChatText, "$this_bindChatText");
        if (z) {
            ue3.c(ActivityKt.e());
            new LinkJumpDialog(ActivityKt.e(), new LinkJumpDialog.b() { // from class: dc.us2
                @Override // com.wear.widget.dialog.LinkJumpDialog.b
                public final void a(String str2) {
                    ws2.e(this_bindChatText, str2);
                }
            }).d(str);
        } else if (l22.p(str)) {
            sg3.h(R.string.roulette_conflict_toast);
        } else {
            MyApplication.y0(this_bindChatText.getContext(), str);
        }
    }

    public static final void e(HttpTextView this_bindChatText, String str) {
        Intrinsics.checkNotNullParameter(this_bindChatText, "$this_bindChatText");
        MyApplication.y0(this_bindChatText.getContext(), str);
    }

    @BindingAdapter({"bindRecyclerViewStatus"})
    public static final void f(@NotNull RecyclerView recyclerView, @NotNull RecyclerViewStatus status) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.wear.ui.chat.adapter.ChatAdapter");
        ChatAdapter chatAdapter = (ChatAdapter) adapter;
        if (status instanceof RecyclerViewStatus.NewMessage) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int iFindLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            chatAdapter.r(((RecyclerViewStatus.NewMessage) status).getMessage());
            if (iFindLastVisibleItemPosition >= chatAdapter.K().size() - 3) {
                recyclerView.smoothScrollToPosition(chatAdapter.getItemCount() - 1);
                return;
            } else {
                recyclerView.scrollToPosition(chatAdapter.getItemCount() - 1);
                return;
            }
        }
        if (status instanceof RecyclerViewStatus.NewMessages) {
            chatAdapter.y0(((RecyclerViewStatus.NewMessages) status).getMessages());
            recyclerView.scrollToPosition(chatAdapter.getItemCount() - 1);
            return;
        }
        if (status instanceof RecyclerViewStatus.DeleteMessage) {
            chatAdapter.q0(chatAdapter.K().indexOf(((RecyclerViewStatus.DeleteMessage) status).getMessage()));
            return;
        }
        if (status instanceof RecyclerViewStatus.PreMessages) {
            List<Message> messages = ((RecyclerViewStatus.PreMessages) status).getMessages();
            if (messages != null) {
                chatAdapter.q(0, messages);
                return;
            }
            return;
        }
        if (status instanceof RecyclerViewStatus.UpdateMessage) {
            chatAdapter.notifyItemChanged(chatAdapter.K().indexOf(((RecyclerViewStatus.UpdateMessage) status).getMessage()));
        } else {
            Intrinsics.areEqual(status, RecyclerViewStatus.Idle.INSTANCE);
        }
    }

    @BindingAdapter({"bindSystemText"})
    public static final void g(@NotNull TextView textView, @NotNull Message message) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        MessageBody messageBody = (MessageBody) message.getContentData(MessageBody.class);
        textView.setText(messageBody != null ? messageBody.getText() : null);
    }

    @BindingAdapter(requireAll = true, value = {"isSelf", "emojisType"})
    public static final void j(@NotNull View view, boolean z, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        mz1 mz1VarD = nz1.e().d();
        view.setBackground(i == 0 ? th4.d(view.getContext(), z ? mz1VarD.y() : mz1VarD.g0()) : null);
    }
}
