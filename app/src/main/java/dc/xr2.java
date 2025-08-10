package dc;

import android.view.ViewGroup;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.firebase.messaging.Constants;
import com.lovense.wear.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BaseTextItemProvider.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/wear/ui/chat/adapter/provoder/BaseTextItemProvider;", "Lcom/wear/ui/chat/adapter/provoder/BaseProvider;", "emojisUtils", "Lcom/wear/util/EmojisUtils;", "(Lcom/wear/util/EmojisUtils;)V", "emojisType", "", "getEmojisType", "()I", "setEmojisType", "(I)V", "calculateContainerWidth", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "convert", "item", "Lcom/wear/bean/chat/Message;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class xr2 extends wr2 {

    @NotNull
    public final ie3 d;
    public int e;

    public xr2(@NotNull ie3 emojisUtils) {
        Intrinsics.checkNotNullParameter(emojisUtils, "emojisUtils");
        this.d = emojisUtils;
    }

    public static final void w(ViewGroup containerView, float f, String str) {
        Intrinsics.checkNotNullParameter(containerView, "$containerView");
        int width = containerView.getWidth();
        ViewGroup.LayoutParams layoutParams = containerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        if (width > f) {
            width = (int) f;
        }
        layoutParams.width = width;
        containerView.setTag(R.id.tag_chat_message_id, str);
        containerView.setTag(R.id.tag_chat_container_width, Integer.valueOf(layoutParams.width));
        containerView.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    @Override // dc.wr2
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(@org.jetbrains.annotations.NotNull com.chad.library.adapter.base.viewholder.BaseViewHolder r7, @org.jetbrains.annotations.NotNull com.wear.bean.chat.Message r8) {
        /*
            r6 = this;
            java.lang.String r0 = "helper"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            super.a(r7, r8)
            java.lang.Class<com.wear.bean.chat.MessageBody> r0 = com.wear.bean.chat.MessageBody.class
            java.lang.Object r0 = r8.getContentData(r0)
            com.wear.bean.chat.MessageBody r0 = (com.wear.bean.chat.MessageBody) r0
            if (r0 != 0) goto L18
            return
        L18:
            r1 = 2131365472(0x7f0a0e60, float:1.835081E38)
            android.view.View r1 = r7.getViewOrNull(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = r8.getMessageId()
            r6.v(r7, r2)
            dc.ie3 r7 = r6.d
            java.lang.String r2 = r0.getText()
            boolean r7 = r7.D(r2)
            com.wear.bean.chat.MessageConfig r8 = r8.getMessageConfig()
            dc.ie3 r2 = r6.d
            java.lang.String r3 = r0.getText()
            java.io.File r2 = r2.r(r3)
            dc.ie3 r3 = r6.d
            java.lang.String r0 = r0.getText()
            r4 = 0
            java.lang.String r0 = r3.s(r0, r4)
            r3 = 1
            if (r2 == 0) goto L56
            boolean r2 = r2.exists()
            if (r2 != 0) goto L56
            r2 = 1
            goto L57
        L56:
            r2 = 0
        L57:
            if (r2 == 0) goto L69
            if (r0 == 0) goto L64
            int r2 = r0.length()
            if (r2 != 0) goto L62
            goto L64
        L62:
            r2 = 0
            goto L65
        L64:
            r2 = 1
        L65:
            if (r2 == 0) goto L69
            r2 = 1
            goto L6a
        L69:
            r2 = 0
        L6a:
            r5 = 2
            if (r7 == 0) goto L90
            if (r2 == 0) goto L70
            goto L90
        L70:
            if (r8 == 0) goto L7a
            boolean r7 = r8.getIsShowEmojiAnimation()
            if (r7 != r3) goto L7a
            r7 = 1
            goto L7b
        L7a:
            r7 = 0
        L7b:
            if (r7 != 0) goto L8e
            if (r0 == 0) goto L88
            int r7 = r0.length()
            if (r7 != 0) goto L86
            goto L88
        L86:
            r7 = 0
            goto L89
        L88:
            r7 = 1
        L89:
            if (r7 == 0) goto L8c
            goto L8e
        L8c:
            r7 = 2
            goto L91
        L8e:
            r7 = 1
            goto L91
        L90:
            r7 = 0
        L91:
            r6.e = r7
            if (r1 == 0) goto La2
            int r7 = r6.g()
            int r7 = r7 % r5
            if (r7 != 0) goto L9d
            r4 = 1
        L9d:
            int r7 = r6.e
            dc.ws2.j(r1, r4, r7)
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.xr2.a(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.wear.bean.chat.Message):void");
    }

    public final void v(BaseViewHolder baseViewHolder, final String str) {
        final ViewGroup viewGroup = (ViewGroup) baseViewHolder.getViewOrNull(R.id.content_container);
        if (viewGroup == null) {
            return;
        }
        Object tag = viewGroup.getTag(R.id.tag_chat_message_id);
        String str2 = tag instanceof String ? (String) tag : null;
        Object tag2 = viewGroup.getTag(R.id.tag_chat_container_width);
        Integer num = tag2 instanceof Integer ? (Integer) tag2 : null;
        if (Intrinsics.areEqual(str, str2) && num != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.width = num.intValue();
            viewGroup.setLayoutParams(layoutParams);
            return;
        }
        TextView textView = (TextView) baseViewHolder.getViewOrNull(R.id.user_message);
        ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams2.width = -2;
        viewGroup.setLayoutParams(layoutParams2);
        final float fE = gg3.e(viewGroup.getContext()) - qu1.a(132);
        if (textView != null) {
            textView.setMaxWidth((int) fE);
        }
        viewGroup.post(new Runnable() { // from class: dc.qr2
            @Override // java.lang.Runnable
            public final void run() {
                xr2.w(viewGroup, fE, str);
            }
        });
    }

    /* renamed from: x, reason: from getter */
    public final int getE() {
        return this.e;
    }
}
