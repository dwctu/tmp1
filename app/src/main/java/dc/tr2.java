package dc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.chat.Message;
import com.wear.databinding.ItemChatAudioLeftBinding;
import dc.vr2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AudioLeftItemProvider.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/wear/ui/chat/adapter/provoder/AudioLeftItemProvider;", "Lcom/wear/ui/chat/adapter/provoder/BaseAudioProvider;", "onAudioPlayListener", "Lcom/wear/ui/chat/adapter/provoder/BaseAudioProvider$OnAudioPlayListener;", "(Lcom/wear/ui/chat/adapter/provoder/BaseAudioProvider$OnAudioPlayListener;)V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/wear/bean/chat/Message;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class tr2 extends vr2 {
    public tr2(@Nullable vr2.b bVar) {
        super(bVar);
    }

    @Override // dc.lr
    public int g() {
        return 7;
    }

    @Override // dc.lr
    public int h() {
        return R.layout.item_chat_audio_left;
    }

    @Override // dc.lr
    @NotNull
    public BaseViewHolder m(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemChatAudioLeftBinding itemChatAudioLeftBindingB = ItemChatAudioLeftBinding.b(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(itemChatAudioLeftBindingB, "inflate(LayoutInflater.f….context), parent, false)");
        itemChatAudioLeftBindingB.a.setOnClickListener(new View.OnClickListener() { // from class: dc.rr2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.x(view);
            }
        });
        View root = itemChatAudioLeftBindingB.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return new BaseDataBindingHolder(root);
    }

    @Override // dc.vr2, dc.wr2
    /* renamed from: t */
    public void a(@NotNull BaseViewHolder helper, @NotNull Message item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        super.a(helper, item);
        ItemChatAudioLeftBinding itemChatAudioLeftBinding = (ItemChatAudioLeftBinding) DataBindingUtil.getBinding(helper.itemView);
        if (itemChatAudioLeftBinding == null) {
            return;
        }
        itemChatAudioLeftBinding.a.setDirection(1);
        itemChatAudioLeftBinding.d(item);
        itemChatAudioLeftBinding.executePendingBindings();
        BaseProviderMultiAdapter<Message> baseProviderMultiAdapterC = c();
        if (baseProviderMultiAdapterC != null) {
            pr2.a(helper, baseProviderMultiAdapterC);
        }
    }
}
