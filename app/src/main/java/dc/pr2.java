package dc;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.chat.Message;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatAdapter.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"compareTimeUi", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "adapter", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/wear/bean/chat/Message;", "app_marketRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class pr2 {
    public static final void a(@NotNull BaseViewHolder baseViewHolder, @NotNull BaseProviderMultiAdapter<Message> adapter) {
        TextView textView;
        Intrinsics.checkNotNullParameter(baseViewHolder, "<this>");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        int i = R.id.avatar;
        ImageView imageView = (ImageView) baseViewHolder.getViewOrNull(R.id.avatar);
        if (imageView == null || (textView = (TextView) baseViewHolder.getViewOrNull(R.id.chat_item_time_create)) == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.chat_system_message_bg);
        boolean z = baseViewHolder.getItemViewType() % 2 == 0;
        float fA = textView.getVisibility() == 0 ? qu1.a(24) : qu1.a(6);
        if (baseViewHolder.getLayoutPosition() > 0) {
            if ((adapter.getItemViewType(baseViewHolder.getLayoutPosition() - 1) % 2 == 0) == z) {
                imageView.setVisibility(z ? 8 : textView.getVisibility() == 0 ? 0 : 4);
            } else {
                imageView.setVisibility(z ? 8 : 0);
            }
        } else {
            imageView.setVisibility(z ? 8 : 0);
        }
        baseViewHolder.itemView.setPadding(0, (int) fA, 0, 0);
        if (z) {
            ViewGroup viewGroup = (ViewGroup) baseViewHolder.getViewOrNull(R.id.content_container);
            if (viewGroup == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = textView.getVisibility() == 0 ? (int) qu1.a(24) : 0;
            viewGroup.setLayoutParams(layoutParams2);
        }
        ImageView imageView2 = (ImageView) baseViewHolder.getViewOrNull(R.id.checkbox);
        if (imageView2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = imageView2.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        if (!(imageView.getVisibility() == 0)) {
            i = R.id.content_container;
        }
        layoutParams4.topToTop = i;
        layoutParams4.bottomToBottom = i;
        imageView2.setLayoutParams(layoutParams4);
    }
}
