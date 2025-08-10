package com.wear.ui.discover.chatgpt.adapter;

import android.animation.ValueAnimator;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.data.ChatGPTPatternBean;
import com.wear.bean.data.ChatGPTPatternBeanKt;
import dc.ah4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatGPTAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/wear/ui/discover/chatgpt/adapter/ChatGPTAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/wear/bean/data/ChatGPTPatternBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "append", "", "count", "", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatGPTAdapter extends BaseMultiItemQuickAdapter<ChatGPTPatternBean, BaseViewHolder> {
    public ChatGPTAdapter() {
        super(null, 1, null);
        I0(10, R.layout.item_chat_gpt_message);
        I0(ChatGPTPatternBeanKt.ITEM_MY_SELF_MESSAGE, R.layout.item_my_self_message);
        I0(170, R.layout.item_chat_gpt_pattern);
        I0(ChatGPTPatternBeanKt.ITEM_CHAT_GPT_GENERATING, R.layout.item_chat_gpt_generating);
        I0(ChatGPTPatternBeanKt.ITEM_CLEAR_CONTENT, R.layout.item_chat_gpt_clear_context);
    }

    public static final void M0(BaseViewHolder holder, ChatGPTAdapter this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        holder.setText(R.id.tv_chat_gpt_generating, this$0.K0(((Integer) animatedValue).intValue()));
    }

    public final String K0(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(ah4.e(R.string.chatgpt_generating_hint));
        if (i == 0) {
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
            return string;
        }
        for (int i2 = 1; i2 <= i; i2++) {
            sb.append(".");
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "builder.toString()");
        return string2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00e8  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C(@org.jetbrains.annotations.NotNull final com.chad.library.adapter.base.viewholder.BaseViewHolder r19, @org.jetbrains.annotations.NotNull com.wear.bean.data.ChatGPTPatternBean r20) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.chatgpt.adapter.ChatGPTAdapter.C(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.wear.bean.data.ChatGPTPatternBean):void");
    }
}
