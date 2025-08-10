package com.wear.vibematevideo.ui.fragment.adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lovense.wear.R;
import com.sun.jna.Callback;
import com.tencent.qgame.animplayer.AnimView;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHead;
import com.wear.bean.vb.VbPatternAdBean;
import com.wear.bean.vb.VbPatternBean;
import com.wear.bean.vb.VideoAdBean;
import com.wear.bean.vb.VideoBean;
import com.wear.databinding.ItemInteractivePatternDataAdBinding;
import com.wear.databinding.ItemInteractivePatternDataBinding;
import com.wear.databinding.ItemInteractiveVideoDataAdBinding;
import com.wear.databinding.ItemInteractiveVideoDataBinding;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.WearUtils;
import com.wear.vibematevideo.ui.fragment.adapter.RecommendedAdapter;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.control.NewCurveLineView;
import dc.ah4;
import dc.bn3;
import dc.ce3;
import dc.ff3;
import dc.ii;
import dc.ij3;
import dc.kf;
import dc.kk3;
import dc.ll3;
import dc.mk3;
import dc.mm;
import dc.nk3;
import dc.of;
import dc.qo;
import dc.tq;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RecommendedAdapter.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002J3\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0016\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002J\u0016\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020+H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/wear/vibematevideo/ui/fragment/adapter/RecommendedAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "curPage", "", "(Ljava/lang/String;)V", "getCurPage", "()Ljava/lang/String;", "isFistShowBottom", "", "()Z", "setFistShowBottom", "(Z)V", "topAdVapFile", "Ljava/io/File;", "checkPatternData", "", "holder", "item", "convert", "getLevel", "", FirebaseAnalytics.Param.LEVEL, "getPoint", "", "mediaPatternDatas", "", "mediaMillis", "curveLineView", "Lcom/wear/widget/control/NewCurveLineView;", "(Ljava/util/List;ILcom/wear/widget/control/NewCurveLineView;)[Ljava/lang/String;", "handleAdItem", "handleDataItem", "handlePatternAdItem", "handlePatternItem", "initPatternData", "loadAdImg", "imageView", "Landroid/widget/ImageView;", "path", "playVap", "playerView", "Lcom/tencent/qgame/animplayer/AnimView;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class RecommendedAdapter extends BaseMultiItemQuickAdapter<tq, BaseViewHolder> {

    @NotNull
    public final String A;
    public boolean B;

    @Nullable
    public File C;

    /* compiled from: RecommendedAdapter.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/vibematevideo/ui/fragment/adapter/RecommendedAdapter$checkPatternData$1$2", "Lcom/wear/util/MyListener;", Callback.METHOD_NAME, "", "result", "", "message", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ RecommendedAdapter b;
        public final /* synthetic */ BaseViewHolder c;

        public a(Pattern pattern, RecommendedAdapter recommendedAdapter, BaseViewHolder baseViewHolder) {
            this.a = pattern;
            this.b = recommendedAdapter;
            this.c = baseViewHolder;
        }

        public static final void e(RecommendedAdapter this$0, BaseViewHolder holder) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            this$0.notifyItemChanged(holder.getLayoutPosition());
        }

        @Override // dc.ff3
        public void b(boolean z, @Nullable Object obj) {
            if (z) {
                File file = obj instanceof File ? (File) obj : null;
                if (file != null) {
                    Pattern pattern = this.a;
                    final RecommendedAdapter recommendedAdapter = this.b;
                    final BaseViewHolder baseViewHolder = this.c;
                    String str = "callback: " + pattern.getPath();
                    pattern.setDataNoCheckFormat(WearUtils.N1(file.getPath()));
                    WearUtils.x.l.post(new Runnable() { // from class: dc.an3
                        @Override // java.lang.Runnable
                        public final void run() {
                            RecommendedAdapter.a.e(recommendedAdapter, baseViewHolder);
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendedAdapter(@NotNull String curPage) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(curPage, "curPage");
        this.A = curPage;
        this.B = true;
        I0(1, R.layout.item_interactive_video_data);
        I0(2, R.layout.item_interactive_video_data_ad);
        I0(3, R.layout.item_interactive_pattern_data);
        I0(4, R.layout.item_interactive_pattern_data_ad);
        n(R.id.pattern_play);
        n(R.id.pattern_ad_tv);
    }

    public static final void L0(View view) {
    }

    public static final void M0(ItemInteractivePatternDataBinding binding, Pattern pattern, int i, boolean z, String str, String str2, int i2, String[] strArr) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        binding.g.f();
        String data = pattern.getData();
        if (!(data == null || data.length() == 0)) {
            if (pattern.getHead() == null) {
                NewCurveLineView newCurveLineView = binding.g;
                String data2 = pattern.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "pattern.data");
                newCurveLineView.setInitData(null, (String[]) StringsKt__StringsKt.split$default((CharSequence) data2, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]), true);
            } else {
                NewCurveLineView newCurveLineView2 = binding.g;
                PatternHead head = pattern.getHead();
                String data3 = pattern.getData();
                Intrinsics.checkNotNullExpressionValue(data3, "pattern.data");
                newCurveLineView2.setInitData(head, (String[]) StringsKt__StringsKt.split$default((CharSequence) data3, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]), false);
            }
        }
        boolean zD0 = PatternPlayManagerImpl.O().d0();
        binding.g.setShowBothLine(z);
        binding.g.a(i2, pattern, strArr);
        binding.h.setText(str);
        binding.g.setBothLinePoint(str2);
        if (zD0) {
            binding.f.setImageResource(R.drawable.home_pattern_play);
        } else {
            binding.f.setImageResource(R.drawable.home_pattern_pause);
        }
    }

    public static final void S0(VideoBean videoData, RecommendedAdapter this$0, BaseViewHolder holder, View view) {
        Intrinsics.checkNotNullParameter(videoData, "$videoData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        videoData.setStaticVideoUserIsLike(!videoData.getStaticVideoUserIsLike());
        videoData.setLikeTimestamp(System.currentTimeMillis());
        this$0.notifyItemChanged(holder.getAdapterPosition());
        mk3.a.A(videoData.getWebUrl(), videoData.getStaticVideoUserIsLike());
    }

    public static final void V0(VbPatternBean videoAdData, ItemInteractivePatternDataBinding binding, View view) {
        Intrinsics.checkNotNullParameter(videoAdData, "$videoAdData");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        videoAdData.setStaticVideoUserIsLike(!videoAdData.getStaticVideoUserIsLike());
        videoAdData.setLikeTimestamp(System.currentTimeMillis());
        binding.c.setImageResource(videoAdData.getStaticVideoUserIsLike() ? R.drawable.patterns_patternlist_favorite_click : R.drawable.patterns_patternlist_favorite);
        mk3.a.z(videoAdData.getId(), videoAdData.getStaticVideoUserIsLike(), videoAdData.getStaticPatternId());
    }

    public final void K0(BaseViewHolder baseViewHolder, tq tqVar) {
        Intrinsics.checkNotNull(tqVar, "null cannot be cast to non-null type com.wear.bean.vb.VbPatternBean");
        final ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(baseViewHolder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(holder.itemView)");
        itemInteractivePatternDataBindingA.g.f();
        Pattern pattern = ((VbPatternBean) tqVar).getPattern();
        if (pattern != null) {
            String data = pattern.getData();
            if (data == null || data.length() == 0) {
                itemInteractivePatternDataBindingA.b.setVisibility(0);
                itemInteractivePatternDataBindingA.b.setOnClickListener(new View.OnClickListener() { // from class: dc.ym3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RecommendedAdapter.L0(view);
                    }
                });
                WearUtils.E0(false, pattern.getCdnPath(), new a(pattern, this, baseViewHolder));
                return;
            }
            itemInteractivePatternDataBindingA.b.setVisibility(8);
            if (pattern.getHead() == null || !pattern.getHead().isMulFunction()) {
                itemInteractivePatternDataBindingA.g.setShowBothLine(false);
            } else {
                itemInteractivePatternDataBindingA.g.setShowBothLine(true);
            }
            int iF0 = PatternPlayManagerImpl.O().f0(pattern);
            if (iF0 <= 0) {
                W0(baseViewHolder, tqVar);
            } else if (iF0 == 1) {
                PatternPlayManagerImpl.O().h0("vibemate", new PatternPlayManagerImpl.f() { // from class: dc.zm3
                    @Override // com.wear.ui.home.pattern.control.PatternPlayManagerImpl.f
                    public final void a(Pattern pattern2, int i, boolean z, String str, String str2, int i2, String[] strArr) {
                        RecommendedAdapter.M0(itemInteractivePatternDataBindingA, pattern2, i, z, str, str2, i2, strArr);
                    }
                });
            } else {
                itemInteractivePatternDataBindingA.f.setImageResource(R.drawable.home_pattern_pause);
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull tq item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemType = item.getItemType();
        if (itemType == 1) {
            R0(holder, item);
            return;
        }
        if (itemType == 2) {
            Q0(holder, item);
            return;
        }
        if (itemType == 3) {
            U0(holder, item);
            K0(holder, item);
        } else {
            if (itemType != 4) {
                return;
            }
            T0(holder, item);
        }
    }

    public final int O0(String str) {
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    public final String[] P0(List<String> list, int i, NewCurveLineView newCurveLineView) {
        int i2;
        int size = list.size();
        int size2 = list.size();
        int iCeil = (int) Math.ceil((size2 + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) / 200);
        if (iCeil < 1) {
            iCeil = 1;
        }
        ArrayList arrayList = new ArrayList();
        if (size > 60000) {
            int i3 = -1;
            for (int i4 = 0; i4 < size2; i4 += iCeil) {
                if (i4 < size) {
                    arrayList.add(list.get(i4));
                } else {
                    if (i3 == -1) {
                        i3 = i4 / iCeil;
                    }
                    arrayList.add("0");
                }
            }
        } else {
            int i5 = (size / iCeil) + 1;
            int i6 = (size2 / iCeil) + 1;
            int i7 = 0;
            while (i7 < i5) {
                int i8 = i7 * iCeil;
                int iO0 = O0(list.get(Math.min(i8, size - 1)));
                int i9 = iO0;
                while (true) {
                    i2 = i7 + 1;
                    if (i8 >= i2 * iCeil || i8 >= size) {
                        break;
                    }
                    int iO02 = O0(list.get(i8));
                    if (iO0 < iO02) {
                        iO0 = iO02;
                    }
                    if (i9 > iO02) {
                        i9 = iO02;
                    }
                    i8++;
                }
                arrayList.add(String.valueOf(iO0));
                arrayList.add(String.valueOf(i9));
                i7 = i2;
            }
            if (i6 > i5) {
                arrayList.size();
                int i10 = i6 - i5;
                for (int i11 = 0; i11 < i10; i11++) {
                    arrayList.add("0");
                    arrayList.add("0");
                }
            }
        }
        newCurveLineView.setPointMax(arrayList.size());
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final void Q0(BaseViewHolder baseViewHolder, tq tqVar) {
        Intrinsics.checkNotNull(tqVar, "null cannot be cast to non-null type com.wear.bean.vb.VideoAdBean");
        VideoAdBean videoAdBean = (VideoAdBean) tqVar;
        ItemInteractiveVideoDataAdBinding itemInteractiveVideoDataAdBindingA = ItemInteractiveVideoDataAdBinding.a(baseViewHolder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemInteractiveVideoDataAdBindingA, "bind(holder.itemView)");
        itemInteractiveVideoDataAdBindingA.b.setVisibility(videoAdBean.getAdType() == 3 ? 0 : 8);
        itemInteractiveVideoDataAdBindingA.d.setVisibility(videoAdBean.getAdType() == 2 ? 0 : 8);
        itemInteractiveVideoDataAdBindingA.g.setVisibility(videoAdBean.getAdType() == 1 ? 0 : 8);
        if (videoAdBean.getAdType() == 1) {
            AnimView animView = itemInteractiveVideoDataAdBindingA.h;
            Intrinsics.checkNotNullExpressionValue(animView, "binding.videoTopAdVap");
            c1(animView);
        } else if (videoAdBean.getAdType() == 2) {
            ImageView imageView = itemInteractiveVideoDataAdBindingA.e;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.videoDownloadMiddleIvAd");
            b1(imageView, nk3.a.c("img_video_middle_ad1.png"));
        } else if (videoAdBean.getAdType() == 3) {
            ImageView imageView2 = itemInteractiveVideoDataAdBindingA.c;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.videoBottomIvAd");
            b1(imageView2, nk3.a.c("img_video_bottom_ad1.png"));
        }
        itemInteractiveVideoDataAdBindingA.f.setVisibility(videoAdBean.getAdType() == 4 ? 0 : 8);
        if (videoAdBean.getAdType() == 3 && this.B) {
            this.B = false;
            ll3.E().e0("Interactive video", "open", "bottom text", null, null);
        }
    }

    public final void R0(final BaseViewHolder baseViewHolder, tq tqVar) {
        Intrinsics.checkNotNull(tqVar, "null cannot be cast to non-null type com.wear.bean.vb.VideoBean");
        final VideoBean videoBean = (VideoBean) tqVar;
        ItemInteractiveVideoDataBinding itemInteractiveVideoDataBindingA = ItemInteractiveVideoDataBinding.a(baseViewHolder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemInteractiveVideoDataBindingA, "bind(holder.itemView)");
        itemInteractiveVideoDataBindingA.g.setText(videoBean.getTitle());
        itemInteractiveVideoDataBindingA.f.setText(videoBean.getDurationFormat());
        TextView textView = itemInteractiveVideoDataBindingA.e;
        Integer localNewFlag = videoBean.getLocalNewFlag();
        textView.setVisibility((localNewFlag != null && localNewFlag.intValue() == 1) ? 0 : 8);
        ij3.c(J(), itemInteractiveVideoDataBindingA.h, videoBean.getCoverPicture());
        ij3.c(J(), itemInteractiveVideoDataBindingA.c, "https://m.youtube.com/static/favicon.ico");
        StringBuffer stringBuffer = new StringBuffer();
        String uploader = videoBean.getUploader();
        if (!(uploader == null || uploader.length() == 0)) {
            stringBuffer.append(videoBean.getUploader());
            stringBuffer.append(" · ");
        }
        String viewCountShow = videoBean.getViewCountShow();
        if (!(viewCountShow == null || viewCountShow.length() == 0)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strE = ah4.e(R.string.sync_to_media_viewers);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.sync_to_media_viewers)");
            String str = String.format(strE, Arrays.copyOf(new Object[]{videoBean.getViewCountShow()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            stringBuffer.append(str);
            stringBuffer.append(" · ");
        }
        if (StringsKt__StringsKt.endsWith$default((CharSequence) stringBuffer, (CharSequence) " · ", false, 2, (Object) null)) {
            stringBuffer.delete(stringBuffer.length() - 3, stringBuffer.length());
        }
        itemInteractiveVideoDataBindingA.d.setText(stringBuffer);
        itemInteractiveVideoDataBindingA.b.setImageResource(videoBean.getStaticVideoUserIsLike() ? R.drawable.patterns_patternlist_favorite_click : R.drawable.patterns_patternlist_favorite);
        itemInteractiveVideoDataBindingA.b.setOnClickListener(new View.OnClickListener() { // from class: dc.xm3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendedAdapter.S0(videoBean, this, baseViewHolder, view);
            }
        });
    }

    public final void T0(BaseViewHolder baseViewHolder, tq tqVar) {
        int i;
        Intrinsics.checkNotNull(tqVar, "null cannot be cast to non-null type com.wear.bean.vb.VbPatternAdBean");
        VbPatternAdBean vbPatternAdBean = (VbPatternAdBean) tqVar;
        ItemInteractivePatternDataAdBinding itemInteractivePatternDataAdBindingA = ItemInteractivePatternDataAdBinding.a(baseViewHolder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataAdBindingA, "bind(holder.itemView)");
        ConstraintLayout constraintLayout = itemInteractivePatternDataAdBindingA.c;
        int i2 = 8;
        if (vbPatternAdBean.getAdType() == 2) {
            String p = ah4.e(R.string.link_try3);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strE = ah4.e(R.string.common_no_more_data);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.common_no_more_data)");
            String str = String.format(strE, Arrays.copyOf(new Object[]{p}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            TextView textView = itemInteractivePatternDataAdBindingA.e;
            kk3 kk3Var = kk3.a;
            Intrinsics.checkNotNullExpressionValue(p, "p");
            textView.setText(kk3Var.a(str, p, Color.parseColor("#FF2D89")));
            i = 0;
        } else {
            i = 8;
        }
        constraintLayout.setVisibility(i);
        CardView cardView = itemInteractivePatternDataAdBindingA.d;
        if (vbPatternAdBean.getAdType() == 1) {
            String p2 = ah4.e(R.string.button_try_it_now_2);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String strE2 = ah4.e(R.string.intvideo_ads_patterns);
            Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.intvideo_ads_patterns)");
            String str2 = String.format(strE2, Arrays.copyOf(new Object[]{p2}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            MediumBoldTextView mediumBoldTextView = itemInteractivePatternDataAdBindingA.b;
            kk3 kk3Var2 = kk3.a;
            Intrinsics.checkNotNullExpressionValue(p2, "p");
            mediumBoldTextView.setText(kk3Var2.a(str2, p2, Color.parseColor("#FF2D89")));
            i2 = 0;
        }
        cardView.setVisibility(i2);
        if (vbPatternAdBean.getAdType() == 2 && this.B) {
            this.B = false;
            ll3.E().e0(this.A, "open", "bottom text", null, null);
        }
    }

    public final void U0(@NotNull BaseViewHolder holder, @NotNull tq item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        final VbPatternBean vbPatternBean = (VbPatternBean) item;
        holder.itemView.setTag(vbPatternBean);
        final ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(holder.itemView)");
        itemInteractivePatternDataBindingA.c.setImageResource(vbPatternBean.getStaticVideoUserIsLike() ? R.drawable.patterns_patternlist_favorite_click : R.drawable.patterns_patternlist_favorite);
        itemInteractivePatternDataBindingA.c.setOnClickListener(new View.OnClickListener() { // from class: dc.wm3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendedAdapter.V0(vbPatternBean, itemInteractivePatternDataBindingA, view);
            }
        });
        itemInteractivePatternDataBindingA.e.setText("ID：" + vbPatternBean.getStaticPatternId());
        itemInteractivePatternDataBindingA.i.setText(vbPatternBean.getStaticVideoLikeNumber());
        itemInteractivePatternDataBindingA.h.setText(vbPatternBean.getDurationFormat());
        mk3 mk3Var = mk3.a;
        if (mk3Var.p(vbPatternBean.getId())) {
            mk3Var.c(vbPatternBean.getStaticPatternId(), this.A);
            itemInteractivePatternDataBindingA.d.setVisibility(0);
            String p = ah4.e(R.string.link_try1link_try2);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strE = ah4.e(R.string.pattern_list_ad2);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.pattern_list_ad2)");
            String str = String.format(strE, Arrays.copyOf(new Object[]{p}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            Intrinsics.checkNotNullExpressionValue(p, "p");
            SpannableString spannableStringA = kk3.a.a("   " + str, p, Color.parseColor("#FF2D89"));
            Drawable drawable = ContextCompat.getDrawable(J(), R.drawable.logo_vibemate);
            if (drawable != null) {
                drawable.setBounds(0, 0, ce3.a(J(), 18.0f), ce3.a(J(), 18.0f));
                if (spannableStringA != null) {
                    spannableStringA.setSpan(new bn3(drawable), 0, 1, 33);
                }
            }
            itemInteractivePatternDataBindingA.d.setText(spannableStringA);
        } else {
            itemInteractivePatternDataBindingA.d.setVisibility(8);
        }
        itemInteractivePatternDataBindingA.f.setImageResource(R.drawable.home_pattern_play);
    }

    public final void W0(@NotNull BaseViewHolder holder, @NotNull tq item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        VbPatternBean vbPatternBean = (VbPatternBean) item;
        ItemInteractivePatternDataBinding itemInteractivePatternDataBindingA = ItemInteractivePatternDataBinding.a(holder.itemView);
        Intrinsics.checkNotNullExpressionValue(itemInteractivePatternDataBindingA, "bind(holder.itemView)");
        Pattern pattern = vbPatternBean.getPattern();
        if (pattern != null) {
            String data = pattern.getData();
            if (data == null || data.length() == 0) {
                itemInteractivePatternDataBindingA.g.b();
                return;
            }
            try {
                if (pattern.getHead() == null) {
                    NewCurveLineView newCurveLineView = itemInteractivePatternDataBindingA.g;
                    String data2 = pattern.getData();
                    Intrinsics.checkNotNullExpressionValue(data2, "patternB.data");
                    List<String> listSplit$default = StringsKt__StringsKt.split$default((CharSequence) data2, new String[]{","}, false, 0, 6, (Object) null);
                    NewCurveLineView newCurveLineView2 = itemInteractivePatternDataBindingA.g;
                    Intrinsics.checkNotNullExpressionValue(newCurveLineView2, "binding.patternPlayCurve");
                    newCurveLineView.setInitData(null, P0(listSplit$default, 0, newCurveLineView2), true);
                } else {
                    NewCurveLineView newCurveLineView3 = itemInteractivePatternDataBindingA.g;
                    PatternHead head = pattern.getHead();
                    String data3 = pattern.getData();
                    Intrinsics.checkNotNullExpressionValue(data3, "patternB.data");
                    List<String> listSplit$default2 = StringsKt__StringsKt.split$default((CharSequence) data3, new String[]{";"}, false, 0, 6, (Object) null);
                    NewCurveLineView newCurveLineView4 = itemInteractivePatternDataBindingA.g;
                    Intrinsics.checkNotNullExpressionValue(newCurveLineView4, "binding.patternPlayCurve");
                    newCurveLineView3.setInitData(head, P0(listSplit$default2, 0, newCurveLineView4), false);
                }
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().log("pattern 数据错误: " + vbPatternBean.getPatternUrl());
            }
        }
    }

    public final void b1(ImageView imageView, String str) {
        if (J() == null || imageView == null) {
            return;
        }
        qo qoVarC = new qo().Z(of.NORMAL).f(ii.b).c();
        Intrinsics.checkNotNullExpressionValue(qoVarC, "RequestOptions()\n       …            .centerCrop()");
        kf.w(J()).v(str).a(qoVarC).N0(new mm().e()).A0(imageView);
    }

    public final void c1(AnimView animView) {
        File file = this.C;
        boolean z = false;
        if (!(file != null && file.exists())) {
            this.C = new File(nk3.a.c("img_video_top_ad1.mp4"));
        }
        File file2 = this.C;
        if (file2 != null && file2.exists()) {
            z = true;
        }
        if (z) {
            File file3 = this.C;
            Intrinsics.checkNotNull(file3);
            animView.k(file3);
            animView.setLoop(10000);
            animView.setMute(true);
        }
    }

    public final void d1(boolean z) {
        this.B = z;
    }
}
