package com.wear.ui.me.adapter;

import android.net.Uri;
import android.os.Build;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import com.wear.bean.ReportChooseImageBean;
import com.wear.databinding.ItemReportAddImgBinding;
import com.wear.util.MyApplication;
import dc.kf;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReportChooseImgAdapter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002¨\u0006\r"}, d2 = {"Lcom/wear/ui/me/adapter/ReportChooseImgAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/wear/bean/ReportChooseImageBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "datas", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "handleAddImageItem", "handleImageItem", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ReportChooseImgAdapter extends BaseMultiItemQuickAdapter<ReportChooseImageBean, BaseViewHolder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReportChooseImgAdapter(@NotNull List<ReportChooseImageBean> datas) {
        super(datas);
        Intrinsics.checkNotNullParameter(datas, "datas");
        I0(0, R.layout.item_report_add_img);
        I0(1, R.layout.item_report_choose_img);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull ReportChooseImageBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemType = item.getItemType();
        if (itemType == 0) {
            L0(holder, item);
        } else {
            if (itemType != 1) {
                return;
            }
            M0(holder, item);
        }
    }

    public final void L0(BaseViewHolder baseViewHolder, ReportChooseImageBean reportChooseImageBean) {
        ItemReportAddImgBinding itemReportAddImgBindingA = ItemReportAddImgBinding.a(baseViewHolder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemReportAddImgBindingA, "bind(holder.itemView)");
        if (baseViewHolder.getAdapterPosition() == 4) {
            itemReportAddImgBindingA.b.setVisibility(8);
        } else {
            itemReportAddImgBindingA.b.setVisibility(0);
        }
    }

    public final void M0(BaseViewHolder baseViewHolder, ReportChooseImageBean reportChooseImageBean) {
        Uri uriFromFile;
        if (Build.VERSION.SDK_INT >= 29) {
            uriFromFile = Uri.parse(reportChooseImageBean.getUrl());
        } else {
            String url = reportChooseImageBean.getUrl();
            uriFromFile = Uri.fromFile(url != null ? new File(url) : null);
        }
        kf.z(MyApplication.H()).r(uriFromFile).A0((ImageView) baseViewHolder.getView(R.id.img_report));
    }
}
