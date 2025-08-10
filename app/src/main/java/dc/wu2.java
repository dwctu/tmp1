package dc;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.component.dxutilcode.lib.utils.ToastUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.lovense.wear.R;
import com.wear.bean.chat.ChatMenuItem;
import com.wear.bean.chat.Message;
import com.wear.bean.chat.MessageBody;
import com.wear.databinding.ItemChatMenuBinding;
import com.wear.databinding.PopupChatItemMenuBinding;
import com.wear.util.WearUtils;
import com.wear.widget.control.FingImageLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import skin.support.widget.SkinTableLayout;

/* compiled from: ChatItemMenuPopup.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/wear/ui/chat/popup/ChatItemMenuPopup;", "Landroid/widget/PopupWindow;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "message", "Lcom/wear/bean/chat/Message;", "onActionCallback", "Lcom/wear/ui/chat/popup/ChatItemMenuPopup$OnActionCallback;", "(Landroid/content/Context;Lcom/wear/bean/chat/Message;Lcom/wear/ui/chat/popup/ChatItemMenuPopup$OnActionCallback;)V", "calculatePopWindowPos", "", "anchorView", "Landroid/view/View;", "initTableLayout", "", "tableLayout", "Landroid/widget/TableLayout;", "onClick", "view", "show", "x", "", FingImageLayout.ObjectAnimatorY, "OnActionCallback", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class wu2 extends PopupWindow implements View.OnClickListener {

    @NotNull
    public final Context a;

    @NotNull
    public final Message b;

    @NotNull
    public final a c;

    /* compiled from: ChatItemMenuPopup.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/ui/chat/popup/ChatItemMenuPopup$OnActionCallback;", "", "onDelete", "", "message", "Lcom/wear/bean/chat/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void K2(@NotNull Message message);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wu2(@NotNull Context context, @NotNull Message message, @NotNull a onActionCallback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(onActionCallback, "onActionCallback");
        this.a = context;
        this.b = message;
        this.c = onActionCallback;
        PopupChatItemMenuBinding popupChatItemMenuBindingC = PopupChatItemMenuBinding.c(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(popupChatItemMenuBindingC, "inflate(LayoutInflater.from(context))");
        setContentView(popupChatItemMenuBindingC.getRoot());
        setOutsideTouchable(true);
        setTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        SkinTableLayout skinTableLayout = popupChatItemMenuBindingC.b;
        Intrinsics.checkNotNullExpressionValue(skinTableLayout, "binding.tableLayout");
        b(skinTableLayout);
    }

    public final int[] a(View view) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int iC = gg3.c(view.getContext());
        getContentView().measure(0, 0);
        int measuredWidth = getContentView().getMeasuredWidth();
        int measuredHeight = getContentView().getMeasuredHeight();
        boolean z = (iC - iArr2[1]) - height < measuredHeight;
        if (this.b.getDirection() == 0) {
            iArr[0] = iArr2[0] + (measuredWidth / 2);
        } else {
            iArr[0] = iArr2[0] - (measuredWidth / 2);
        }
        if (z) {
            iArr[1] = iArr2[1] - measuredHeight;
        } else {
            iArr[1] = iArr2[1] + height;
        }
        return iArr;
    }

    public final void b(TableLayout tableLayout) {
        String strE = ah4.e(R.string.chat_message_item_action_copy);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.chat_message_item_action_copy)");
        String strE2 = ah4.e(R.string.chat_message_item_action_delete);
        Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.chat_…ssage_item_action_delete)");
        List listMutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ChatMenuItem(strE, R.drawable.menu_more_copy), new ChatMenuItem(strE2, R.drawable.menu_more_delete));
        if (this.b.getType() == 3) {
            listMutableListOf.remove(0);
        }
        int size = ((listMutableListOf.size() + 3) - 1) / 3;
        for (int i = 0; i < size; i++) {
            TableRow tableRow = new TableRow(this.a);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(-1, -2));
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = (i * 3) + i2;
                if (i3 < listMutableListOf.size()) {
                    ChatMenuItem chatMenuItem = (ChatMenuItem) listMutableListOf.get(i3);
                    ItemChatMenuBinding itemChatMenuBindingB = ItemChatMenuBinding.b(LayoutInflater.from(this.a));
                    tableRow.addView(itemChatMenuBindingB.getRoot());
                    itemChatMenuBindingB.getRoot().setOnClickListener(this);
                    itemChatMenuBindingB.getRoot().setLayoutParams(new TableRow.LayoutParams(ce3.a(this.a, 80.0f), ce3.a(this.a, 60.0f)));
                    itemChatMenuBindingB.getRoot().setTag(chatMenuItem);
                    itemChatMenuBindingB.d(chatMenuItem);
                    itemChatMenuBindingB.executePendingBindings();
                }
            }
            tableLayout.addView(tableRow);
        }
    }

    public final void c(@NotNull View anchorView, int i, int i2) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        int[] iArrA = a(anchorView);
        iArrA[0] = iArrA[0] - i;
        iArrA[1] = iArrA[1] - i2;
        showAtLocation(anchorView, BadgeDrawable.TOP_START, iArrA[0], iArrA[1]);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        String text;
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.wear.bean.chat.ChatMenuItem");
        String name = ((ChatMenuItem) tag).getName();
        if (Intrinsics.areEqual(name, ah4.e(R.string.chat_message_item_action_copy))) {
            MessageBody messageBody = (MessageBody) this.b.getContentData(MessageBody.class);
            if (messageBody != null && (text = messageBody.getText()) != null) {
                WearUtils.p(text, this.a);
                ToastUtils.x(R.string.chat_message_item_copy_notice);
            }
        } else if (!Intrinsics.areEqual(name, ah4.e(R.string.comman_forward)) && !Intrinsics.areEqual(name, ah4.e(R.string.comman_hide)) && !Intrinsics.areEqual(name, ah4.e(R.string.chat_menu_reply)) && !Intrinsics.areEqual(name, ah4.e(R.string.comman_recall)) && Intrinsics.areEqual(name, ah4.e(R.string.chat_message_item_action_delete))) {
            this.c.K2(this.b);
        }
        dismiss();
    }
}
