package com.wear.ui.longDistance.officialaccount.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.bean.data.BannerDataBean;
import com.wear.ui.longDistance.officialaccount.adapter.ImageNetAdapter;
import com.wear.ui.longDistance.officialaccount.viewholder.ImageHolder;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;
import dc.kf;
import dc.ln3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageNetAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002:\u0001%B'\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ,\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001eH\u0016J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\rR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/wear/ui/longDistance/officialaccount/adapter/ImageNetAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/wear/bean/data/BannerDataBean;", "Lcom/wear/ui/longDistance/officialaccount/viewholder/ImageHolder;", "mDatas", "", "isRightAngle", "", "context", "Landroid/content/Context;", "(Ljava/util/List;ZLandroid/content/Context;)V", "bannerClickListener", "Lcom/wear/ui/longDistance/officialaccount/adapter/ImageNetAdapter$BannerClickListener;", "getBannerClickListener", "()Lcom/wear/ui/longDistance/officialaccount/adapter/ImageNetAdapter$BannerClickListener;", "setBannerClickListener", "(Lcom/wear/ui/longDistance/officialaccount/adapter/ImageNetAdapter$BannerClickListener;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "()Z", "setRightAngle", "(Z)V", "onBindView", "", "holder", "data", "position", "", "size", "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBannerImageClickListener", "BannerClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageNetAdapter<T> extends BannerAdapter<BannerDataBean, ImageHolder> {

    @Nullable
    public a a;
    public boolean b;

    @Nullable
    public Context c;

    /* compiled from: ImageNetAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/wear/ui/longDistance/officialaccount/adapter/ImageNetAdapter$BannerClickListener;", "", "onClick", "", ImagesContract.URL, "", "isVideo", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(@NotNull String str, boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageNetAdapter(@Nullable List<BannerDataBean> list, boolean z, @NotNull Context context) {
        super(list);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = z;
        this.c = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void r(com.wear.bean.data.BannerDataBean r3, com.wear.ui.longDistance.officialaccount.adapter.ImageNetAdapter r4, android.view.View r5) {
        /*
            java.lang.String r5 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            if (r3 == 0) goto L55
            java.lang.String r5 = r3.getVideoUrl()
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L1c
            int r5 = r5.length()
            if (r5 <= 0) goto L17
            r5 = 1
            goto L18
        L17:
            r5 = 0
        L18:
            if (r5 != r0) goto L1c
            r5 = 1
            goto L1d
        L1c:
            r5 = 0
        L1d:
            java.lang.String r2 = ""
            if (r5 == 0) goto L31
            com.wear.ui.longDistance.officialaccount.adapter.ImageNetAdapter$a r4 = r4.a
            if (r4 == 0) goto L55
            java.lang.String r3 = r3.getVideoUrl()
            if (r3 != 0) goto L2c
            goto L2d
        L2c:
            r2 = r3
        L2d:
            r4.a(r2, r0)
            goto L55
        L31:
            java.lang.String r5 = r3.getImageurl()
            if (r5 == 0) goto L43
            int r5 = r5.length()
            if (r5 <= 0) goto L3f
            r5 = 1
            goto L40
        L3f:
            r5 = 0
        L40:
            if (r5 != r0) goto L43
            goto L44
        L43:
            r0 = 0
        L44:
            if (r0 == 0) goto L55
            com.wear.ui.longDistance.officialaccount.adapter.ImageNetAdapter$a r4 = r4.a
            if (r4 == 0) goto L55
            java.lang.String r3 = r3.getImageurl()
            if (r3 != 0) goto L51
            goto L52
        L51:
            r2 = r3
        L52:
            r4.a(r2, r1)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.longDistance.officialaccount.adapter.ImageNetAdapter.r(com.wear.bean.data.BannerDataBean, com.wear.ui.longDistance.officialaccount.adapter.ImageNetAdapter, android.view.View):void");
    }

    @Override // com.youth.banner.holder.IViewHolder
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindView(@Nullable ImageHolder imageHolder, @Nullable final BannerDataBean bannerDataBean, int i, int i2) {
        ImageView imageViewA;
        ImageView a2;
        String realUrl = bannerDataBean != null ? bannerDataBean.getRealUrl() : null;
        if (imageHolder != null && (a2 = imageHolder.getA()) != null) {
            a2.setOnClickListener(new View.OnClickListener() { // from class: dc.aa3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImageNetAdapter.r(bannerDataBean, this, view);
                }
            });
        }
        String imageurl = bannerDataBean != null ? bannerDataBean.getImageurl() : null;
        if (imageurl == null || imageurl.length() == 0) {
            imageViewA = imageHolder != null ? imageHolder.a() : null;
            if (imageViewA != null) {
                imageViewA.setVisibility(0);
            }
        } else {
            String videoUrl = bannerDataBean != null ? bannerDataBean.getVideoUrl() : null;
            if (videoUrl == null || videoUrl.length() == 0) {
                imageViewA = imageHolder != null ? imageHolder.a() : null;
                if (imageViewA != null) {
                    imageViewA.setVisibility(8);
                }
            }
        }
        ln3 ln3Var = new ln3(this.c, 15.0f);
        if (this.b) {
            ln3Var.c(false, false, true, true);
        } else {
            ln3Var.c(false, false, false, false);
        }
        if (imageHolder != null) {
            kf.x(imageHolder.itemView).j().J0(realUrl).X(R.drawable.loading_img_light).h(R.drawable.fail_img_official).h0(true).j0(ln3Var).A0(imageHolder.getA());
        }
    }

    @Override // com.youth.banner.holder.IViewHolder
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public ImageHolder onCreateHolder(@NotNull ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = BannerUtils.getView(parent, R.layout.banner_imageview);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new ImageHolder(view);
    }

    public final void t(@NotNull a bannerClickListener) {
        Intrinsics.checkNotNullParameter(bannerClickListener, "bannerClickListener");
        this.a = bannerClickListener;
    }
}
