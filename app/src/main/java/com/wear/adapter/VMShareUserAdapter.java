package com.wear.adapter;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.bean.Group;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import dc.ii;
import dc.kf;
import dc.qo;
import dc.tg3;
import dc.th4;
import dc.yv3;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: VMShareUserAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/wear/adapter/VMShareUserAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "getItemCount", "", "showImageBitmap", "user", "user_img", "Landroid/widget/ImageView;", ImagesContract.URL, "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class VMShareUserAdapter extends BaseQuickAdapter<IPeopleInfo, BaseViewHolder> {
    public VMShareUserAdapter() {
        super(R.layout.item_vm_share_user, null, 2, 0 == true ? 1 : 0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull IPeopleInfo item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        TextView textView = (TextView) holder.getView(R.id.tv_num);
        if (K().size() <= 5) {
            ImageView imageView = (ImageView) holder.getView(R.id.iv_user_head);
            String avatar = item.getAvatar();
            Intrinsics.checkNotNullExpressionValue(avatar, "item.avatar");
            J0(item, imageView, avatar);
            textView.setVisibility(8);
            textView.setBackgroundResource(0);
        } else if (holder.getAdapterPosition() == 4) {
            textView.setVisibility(0);
            if (K().size() > 103) {
                textView.setText("");
                textView.setBackgroundResource(R.drawable.icon_more);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append('+');
                sb.append(K().size() - 4);
                textView.setText(sb.toString());
                textView.setBackgroundResource(0);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.eraseColor(th4.b(J(), R.color.lvs_ui_standard_systemFillRegular));
            kf.w(J()).p(bitmapCreateBitmap).A0((ImageView) holder.getView(R.id.iv_user_head));
        } else {
            textView.setVisibility(8);
            textView.setBackgroundResource(0);
            ImageView imageView2 = (ImageView) holder.getView(R.id.iv_user_head);
            String avatar2 = item.getAvatar();
            Intrinsics.checkNotNullExpressionValue(avatar2, "item.avatar");
            J0(item, imageView2, avatar2);
        }
        yv3.e(holder.itemView);
    }

    public final void J0(IPeopleInfo iPeopleInfo, ImageView imageView, String str) {
        if (iPeopleInfo.isGroup()) {
            Intrinsics.checkNotNull(iPeopleInfo, "null cannot be cast to non-null type com.wear.bean.Group");
            tg3.i(imageView, (Group) iPeopleInfo);
            return;
        }
        if (!StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null)) {
            str = WearUtils.e + str;
        }
        qo qoVarX = new qo().h(R.drawable.chat_avatar_default).f(ii.a).X(R.drawable.chat_avatar_default);
        Intrinsics.checkNotNullExpressionValue(qoVarX, "RequestOptions()\n       …able.chat_avatar_default)");
        kf.w(J()).v(str).a(qoVarX).A0(imageView);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return RangesKt___RangesKt.coerceAtMost(K().size(), 5);
    }
}
