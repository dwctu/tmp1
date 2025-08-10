package com.wear.ui.longDistance.officialaccount.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.bean.data.BannerDataBean;
import com.wear.bean.official.OfficialLangInfo;
import com.wear.bean.official.OfficialLinkInfo;
import com.wear.bean.official.OfficialMsg;
import com.wear.bean.official.OfficialVideoInfo;
import com.wear.ui.longDistance.officialaccount.OfficialaCountModel;
import com.wear.ui.longDistance.officialaccount.adapter.ImageNetAdapter;
import com.wear.ui.longDistance.officialaccount.adapter.OfficialSourcesAdapter;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import dc.be3;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OfficialSourcesAdapter.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0015J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/wear/ui/longDistance/officialaccount/adapter/OfficialSourcesAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/wear/bean/official/OfficialMsg;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "(Ljava/util/List;)V", "buttonClickListener", "Lcom/wear/ui/longDistance/officialaccount/adapter/OfficialSourcesAdapter$OfficialButtonClickListener;", "getButtonClickListener", "()Lcom/wear/ui/longDistance/officialaccount/adapter/OfficialSourcesAdapter$OfficialButtonClickListener;", "setButtonClickListener", "(Lcom/wear/ui/longDistance/officialaccount/adapter/OfficialSourcesAdapter$OfficialButtonClickListener;)V", "convert", "", "holder", "item", "setOfficialButtonClickListener", "OfficialButtonClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class OfficialSourcesAdapter extends BaseQuickAdapter<OfficialMsg, BaseViewHolder> {

    @Nullable
    public a z;

    /* compiled from: OfficialSourcesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/wear/ui/longDistance/officialaccount/adapter/OfficialSourcesAdapter$OfficialButtonClickListener;", "", "onClick", "", ImagesContract.URL, "", "onImageClick", "isVideo", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(@NotNull String str, boolean z);

        void b(@NotNull String str);
    }

    /* compiled from: OfficialSourcesAdapter.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/ui/longDistance/officialaccount/adapter/OfficialSourcesAdapter$convert$7", "Lcom/wear/ui/longDistance/officialaccount/adapter/ImageNetAdapter$BannerClickListener;", "onClick", "", ImagesContract.URL, "", "isVideo", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements ImageNetAdapter.a {
        public b() {
        }

        @Override // com.wear.ui.longDistance.officialaccount.adapter.ImageNetAdapter.a
        public void a(@NotNull String url, boolean z) {
            Intrinsics.checkNotNullParameter(url, "url");
            a z2 = OfficialSourcesAdapter.this.getZ();
            if (z2 != null) {
                z2.a(url, z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialSourcesAdapter(@NotNull List<OfficialMsg> list) {
        super(R.layout.item_official_sources, CollectionsKt___CollectionsKt.toMutableList((Collection) list));
        Intrinsics.checkNotNullParameter(list, "list");
    }

    public static final void J0(View view) {
    }

    public static final void K0(OfficialLinkInfo officialLinkInfo, OfficialSourcesAdapter this$0, View view) {
        String linkUrl;
        a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (officialLinkInfo == null || (linkUrl = officialLinkInfo.getLinkUrl()) == null || (aVar = this$0.z) == null) {
            return;
        }
        aVar.b(linkUrl);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @SuppressLint({"NotifyDataSetChanged"})
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull OfficialMsg item) {
        boolean z;
        String content;
        String title;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.ll_pic_num);
        TextView textView = (TextView) holder.getView(R.id.tv_pic_num);
        TextView textView2 = (TextView) holder.getView(R.id.tv_message_time);
        TextView textView3 = (TextView) holder.getView(R.id.tv_official_sources_title);
        TextView textView4 = (TextView) holder.getView(R.id.tv_official_sources_content);
        TextView textView5 = (TextView) holder.getView(R.id.tv_official_sources_button);
        View view = holder.getView(R.id.view_line);
        ((ImageView) holder.getView(R.id.iv_image)).setVisibility(8);
        View view2 = holder.getView(R.id.banner);
        Banner banner = view2 instanceof Banner ? (Banner) view2 : null;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.ba3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                OfficialSourcesAdapter.J0(view3);
            }
        });
        OfficialLangInfo officialLangInfoN = OfficialaCountModel.g.a().n(J(), item.getLang());
        final OfficialLinkInfo link = officialLangInfoN != null ? officialLangInfoN.getLink() : null;
        List<OfficialVideoInfo> videoList = officialLangInfoN != null ? officialLangInfoN.getVideoList() : null;
        List<String> pictureList = officialLangInfoN != null ? officialLangInfoN.getPictureList() : null;
        int size = videoList != null ? videoList.size() : 0;
        int size2 = pictureList != null ? pictureList.size() : 0;
        textView2.setText(be3.g(item.getUserReceiveTime()));
        if (officialLangInfoN == null || (title = officialLangInfoN.getTitle()) == null) {
            z = false;
        } else if (title.length() > 0) {
            textView3.setText(title);
            textView3.setVisibility(0);
            z = true;
        } else {
            textView3.setVisibility(8);
            z = false;
        }
        if (officialLangInfoN != null && (content = officialLangInfoN.getContent()) != null) {
            if (content.length() > 0) {
                textView4.setText(content);
                textView4.setVisibility(0);
                z = true;
            } else {
                textView4.setVisibility(8);
            }
        }
        if (link != null) {
            String linkText = link.getLinkText();
            if (linkText != null) {
                if (linkText.length() > 0) {
                    textView5.setText(linkText);
                    textView5.setVisibility(0);
                    view.setVisibility(0);
                    z = true;
                } else {
                    textView5.setVisibility(8);
                    view.setVisibility(8);
                }
            }
        } else {
            textView5.setVisibility(8);
            view.setVisibility(8);
        }
        int i = size + size2;
        if (i > 0) {
            if (i > 1) {
                textView.setText(String.valueOf(i));
                linearLayout.setVisibility(0);
            } else {
                textView.setText(String.valueOf(i));
                linearLayout.setVisibility(8);
            }
            if (banner != null) {
                banner.setVisibility(0);
            }
        } else {
            linearLayout.setVisibility(8);
            if (banner != null) {
                banner.setVisibility(8);
            }
        }
        LinkedList linkedList = new LinkedList();
        if (videoList != null) {
            for (OfficialVideoInfo officialVideoInfo : videoList) {
                BannerDataBean bannerDataBean = new BannerDataBean(null, null, null, 7, null);
                bannerDataBean.setVideoUrl(officialVideoInfo.getVideoUrl());
                bannerDataBean.setVideoCoverUrl(officialVideoInfo.getVideoCoverUrl());
                linkedList.add(bannerDataBean);
            }
        }
        if (pictureList != null) {
            for (String str : pictureList) {
                BannerDataBean bannerDataBean2 = new BannerDataBean(null, null, null, 7, null);
                bannerDataBean2.setImageurl(str);
                linkedList.add(bannerDataBean2);
            }
        }
        ImageNetAdapter imageNetAdapter = new ImageNetAdapter(linkedList, z, J());
        if (banner != null) {
            banner.setIndicator(new CircleIndicator(J()), true);
            banner.setCurrentItem(0, true);
            banner.setStartPosition(1);
            banner.isAutoLoop(false);
        }
        if (banner != null) {
            banner.setAdapter(imageNetAdapter, true);
        }
        imageNetAdapter.t(new b());
        if (banner != null) {
            banner.start();
        }
        textView5.setOnClickListener(new View.OnClickListener() { // from class: dc.ca3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                OfficialSourcesAdapter.K0(link, this, view3);
            }
        });
    }

    @Nullable
    /* renamed from: L0, reason: from getter */
    public final a getZ() {
        return this.z;
    }

    public final void O0(@NotNull a buttonClickListener) {
        Intrinsics.checkNotNullParameter(buttonClickListener, "buttonClickListener");
        this.z = buttonClickListener;
    }
}
