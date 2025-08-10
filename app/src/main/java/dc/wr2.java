package dc;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.wear.bean.chat.Message;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BaseProvider.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0002¨\u0006\n"}, d2 = {"Lcom/wear/ui/chat/adapter/provoder/BaseProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/wear/bean/chat/Message;", "()V", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "convertTime", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class wr2 extends lr<Message> {
    @Override // dc.lr
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull BaseViewHolder helper, @NotNull Message item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        u(helper, item);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void u(com.chad.library.adapter.base.viewholder.BaseViewHolder r8, com.wear.bean.chat.Message r9) {
        /*
            r7 = this;
            int r0 = r8.getLayoutPosition()
            r1 = 1
            int r0 = r0 - r1
            com.chad.library.adapter.base.BaseProviderMultiAdapter r2 = r7.c()
            if (r2 == 0) goto L92
            java.util.List r2 = r2.K()
            if (r2 != 0) goto L14
            goto L92
        L14:
            r3 = -1
            r4 = 0
            if (r0 == r3) goto L46
            java.lang.Object r0 = r2.get(r0)
            com.wear.bean.chat.Message r0 = (com.wear.bean.chat.Message) r0
            java.lang.Long r0 = r0.getCreateTime()
            r2 = 0
            if (r0 == 0) goto L2e
            long r5 = r0.longValue()
            java.util.Date r0 = dc.eu1.a(r5)
            goto L2f
        L2e:
            r0 = r2
        L2f:
            java.lang.Long r3 = r9.getCreateTime()
            if (r3 == 0) goto L3d
            long r2 = r3.longValue()
            java.util.Date r2 = dc.eu1.a(r2)
        L3d:
            boolean r0 = dc.be3.B(r0, r2, r1)
            if (r0 != 0) goto L44
            goto L46
        L44:
            r0 = 0
            goto L47
        L46:
            r0 = 1
        L47:
            r2 = 2131362316(0x7f0a020c, float:1.834441E38)
            android.view.View r8 = r8.getViewOrNull(r2)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 != 0) goto L53
            return
        L53:
            r0 = r0 ^ r1
            r2 = 8
            if (r0 == 0) goto L5b
            r0 = 8
            goto L5c
        L5b:
            r0 = 0
        L5c:
            r8.setVisibility(r0)
            int r0 = r8.getVisibility()
            if (r0 != r2) goto L66
            goto L67
        L66:
            r1 = 0
        L67:
            if (r1 == 0) goto L6a
            return
        L6a:
            java.util.Date r0 = new java.util.Date
            java.lang.Long r9 = r9.getCreateTime()
            if (r9 == 0) goto L77
            long r1 = r9.longValue()
            goto L79
        L77:
            r1 = 0
        L79:
            r0.<init>(r1)
            java.lang.String r9 = com.wear.util.WearUtils.u0(r0)
            r8.setText(r9)
            dc.nz1 r9 = dc.nz1.e()
            dc.mz1 r9 = r9.f()
            int r9 = r9.Z()
            r8.setTextColor(r9)
        L92:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.wr2.u(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.wear.bean.chat.Message):void");
    }
}
