package com.wear.adapter.patterns;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.bean.event.PatternDownloadEvent;
import com.wear.bean.event.PatternFavoriteChangeEvent;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.longDistance.ForwardMessageActivity;
import com.wear.main.patterns.SharePatternActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.discover.pattern.PatternStoreActivity;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.control.NewCurveLineView;
import dc.ah4;
import dc.ao3;
import dc.db2;
import dc.kf;
import dc.kn3;
import dc.na2;
import dc.nf3;
import dc.ng3;
import dc.pj3;
import dc.qo;
import dc.rf3;
import dc.sg3;
import dc.th4;
import dc.tn2;
import dc.uu1;
import dc.xe2;
import dc.y12;
import dc.yn3;
import dc.zn2;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class UserPatternAdapter extends RecyclerView.Adapter<PatternViewHolder> {
    public List<Pattern> a;
    public Context b;
    public qo c = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    public f d;

    public static class PatternViewHolder extends RecyclerView.ViewHolder {
        public String a;
        public Pattern b;

        @BindView(R.id.data_loading_view)
        public RelativeLayout dataLoadingView;

        @BindView(R.id.iv_pattern_download)
        public ImageView ivPatternDownload;

        @BindView(R.id.iv_pattern_like)
        public ImageView ivPatternLike;

        @BindView(R.id.iv_pattern_like_loading)
        public ImageView ivPatternLikeLoading;

        @BindView(R.id.iv_removed_action)
        public ImageView ivRemovedAction;

        @BindView(R.id.iv_lovense_pick)
        public ImageView iv_lovense_pick;

        @BindView(R.id.iv_under_preview)
        public ImageView iv_under_preview;

        @BindView(R.id.ll_pattern)
        public LinearLayout llPattern;

        @BindView(R.id.pattern_toy_name)
        public TextView mTvPatternToyName;

        @BindView(R.id.pattern_hiden)
        public ImageView patternHiden;

        @BindView(R.id.pattern_icon)
        public CircleImageView patternIcon;

        @BindView(R.id.pattern_play)
        public ImageView patternPlay;

        @BindView(R.id.pattern_play_curve)
        public NewCurveLineView patternPlayCurve;

        @BindView(R.id.pattern_single_title)
        public TextView patternSingleTitle;

        @BindView(R.id.pattern_times)
        public TextView patternTimes;

        @BindView(R.id.removed_top_view)
        public RelativeLayout removedTopView;

        @BindView(R.id.rv_pattern_auth)
        public TextView rvPatternAuth;

        @BindView(R.id.toy_type_1)
        public ImageView toyType1;

        @BindView(R.id.toy_type_2)
        public ImageView toyType2;

        @BindView(R.id.toy_type_3)
        public ImageView toyType3;

        @BindView(R.id.tv_pattern_download_number)
        public TextView tvPatternDownloadNumber;

        @BindView(R.id.tv_pattern_like_number)
        public TextView tvPatternLikeNumber;

        @BindView(R.id.tv_pattern_send_time)
        public TextView tvPatternSendTime;

        public PatternViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class PatternViewHolder_ViewBinding implements Unbinder {
        public PatternViewHolder a;

        @UiThread
        public PatternViewHolder_ViewBinding(PatternViewHolder patternViewHolder, View view) {
            this.a = patternViewHolder;
            patternViewHolder.patternIcon = (CircleImageView) Utils.findRequiredViewAsType(view, R.id.pattern_icon, "field 'patternIcon'", CircleImageView.class);
            patternViewHolder.rvPatternAuth = (TextView) Utils.findRequiredViewAsType(view, R.id.rv_pattern_auth, "field 'rvPatternAuth'", TextView.class);
            patternViewHolder.tvPatternSendTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pattern_send_time, "field 'tvPatternSendTime'", TextView.class);
            patternViewHolder.patternPlayCurve = (NewCurveLineView) Utils.findRequiredViewAsType(view, R.id.pattern_play_curve, "field 'patternPlayCurve'", NewCurveLineView.class);
            patternViewHolder.patternPlay = (ImageView) Utils.findRequiredViewAsType(view, R.id.pattern_play, "field 'patternPlay'", ImageView.class);
            patternViewHolder.iv_under_preview = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_under_preview, "field 'iv_under_preview'", ImageView.class);
            patternViewHolder.iv_lovense_pick = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_lovense_pick, "field 'iv_lovense_pick'", ImageView.class);
            patternViewHolder.patternTimes = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_times, "field 'patternTimes'", TextView.class);
            patternViewHolder.patternSingleTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_single_title, "field 'patternSingleTitle'", TextView.class);
            patternViewHolder.toyType1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_type_1, "field 'toyType1'", ImageView.class);
            patternViewHolder.toyType2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_type_2, "field 'toyType2'", ImageView.class);
            patternViewHolder.toyType3 = (ImageView) Utils.findRequiredViewAsType(view, R.id.toy_type_3, "field 'toyType3'", ImageView.class);
            patternViewHolder.ivPatternLike = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pattern_like, "field 'ivPatternLike'", ImageView.class);
            patternViewHolder.tvPatternLikeNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pattern_like_number, "field 'tvPatternLikeNumber'", TextView.class);
            patternViewHolder.ivPatternDownload = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pattern_download, "field 'ivPatternDownload'", ImageView.class);
            patternViewHolder.tvPatternDownloadNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pattern_download_number, "field 'tvPatternDownloadNumber'", TextView.class);
            patternViewHolder.patternHiden = (ImageView) Utils.findRequiredViewAsType(view, R.id.pattern_hiden, "field 'patternHiden'", ImageView.class);
            patternViewHolder.llPattern = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_pattern, "field 'llPattern'", LinearLayout.class);
            patternViewHolder.ivRemovedAction = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_removed_action, "field 'ivRemovedAction'", ImageView.class);
            patternViewHolder.removedTopView = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.removed_top_view, "field 'removedTopView'", RelativeLayout.class);
            patternViewHolder.dataLoadingView = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.data_loading_view, "field 'dataLoadingView'", RelativeLayout.class);
            patternViewHolder.ivPatternLikeLoading = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pattern_like_loading, "field 'ivPatternLikeLoading'", ImageView.class);
            patternViewHolder.mTvPatternToyName = (TextView) Utils.findRequiredViewAsType(view, R.id.pattern_toy_name, "field 'mTvPatternToyName'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            PatternViewHolder patternViewHolder = this.a;
            if (patternViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            patternViewHolder.patternIcon = null;
            patternViewHolder.rvPatternAuth = null;
            patternViewHolder.tvPatternSendTime = null;
            patternViewHolder.patternPlayCurve = null;
            patternViewHolder.patternPlay = null;
            patternViewHolder.iv_under_preview = null;
            patternViewHolder.iv_lovense_pick = null;
            patternViewHolder.patternTimes = null;
            patternViewHolder.patternSingleTitle = null;
            patternViewHolder.toyType1 = null;
            patternViewHolder.toyType2 = null;
            patternViewHolder.toyType3 = null;
            patternViewHolder.ivPatternLike = null;
            patternViewHolder.tvPatternLikeNumber = null;
            patternViewHolder.ivPatternDownload = null;
            patternViewHolder.tvPatternDownloadNumber = null;
            patternViewHolder.patternHiden = null;
            patternViewHolder.llPattern = null;
            patternViewHolder.ivRemovedAction = null;
            patternViewHolder.removedTopView = null;
            patternViewHolder.dataLoadingView = null;
            patternViewHolder.ivPatternLikeLoading = null;
            patternViewHolder.mTvPatternToyName = null;
        }
    }

    public class a implements kn3.d {
        public a() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            pj3.t(UserPatternAdapter.this.b, LoginActivity.class, 2);
        }
    }

    public class b implements zn2<String> {
        public b() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(UserPatternAdapter.this.b, netException.getMessage());
        }
    }

    public class c implements zn2<String> {
        public c() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (normalResponse == null) {
                sg3.i(UserPatternAdapter.this.b, R.string.patterns_result_remove_failed);
            } else {
                if (normalResponse.isResult()) {
                    return;
                }
                sg3.i(UserPatternAdapter.this.b, R.string.patterns_result_remove_failed);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(UserPatternAdapter.this.b, netException.getMessage());
        }
    }

    public class d implements ao3.a {
        public d(UserPatternAdapter userPatternAdapter) {
        }

        @Override // dc.ao3.a
        public void a(ao3 ao3Var) {
        }

        @Override // dc.ao3.a
        public void b(ao3 ao3Var) {
        }
    }

    public class e implements yn3.c {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ Pattern b;

        public e(Pattern pattern, Pattern pattern2) {
            this.a = pattern;
            this.b = pattern2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(String str, String str2, Pattern pattern, String str3) throws IOException {
            if (WearUtils.e1(str3)) {
                sg3.i(UserPatternAdapter.this.b, R.string.file_notfound);
                return;
            }
            if (str3.contains("result")) {
                sg3.i(UserPatternAdapter.this.b, R.string.file_notfound);
                return;
            }
            if (rf3.o(str3)) {
                str3 = rf3.r(str3);
            }
            WearUtils.m2(str3, str);
            Pattern pattern2 = new Pattern(str);
            pattern2.setName(str2);
            pattern2.setData(str3);
            pattern2.setCreator(pattern.getEmail());
            pattern2.setEmail(WearUtils.y.r());
            pattern2.setAuthor(pattern.getAuthor());
            pattern2.setTimer(pattern.getTimer());
            pattern2.setToyFunc(pattern.getToyTag());
            if (pattern2.getHead() != null && !WearUtils.e1(pattern2.getHead().getToys()) && pattern2.getHead().getToys().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                pattern2.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
            }
            pattern2.setStatus(Pattern.DOWNLOAD);
            pattern2.setShared(false);
            xe2.L0().t(pattern2, true);
            EventBus.getDefault().post(new PatternDownloadEvent(str, pattern.getToyTag()));
            if (MyApplication.Z) {
                return;
            }
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, pattern2.getId());
            tn2.x(WearUtils.x).l("/wear/pattern/liked", map, null);
        }

        @Override // dc.yn3.c
        public void a(String str, final String str2) {
            final String id = this.a.getId();
            final Pattern pattern = this.b;
            nf3.b(str, new nf3.d() { // from class: dc.xn1
                @Override // dc.nf3.d
                public final void onRequestComplete(String str3) throws IOException {
                    this.a.c(id, str2, pattern, str3);
                }
            });
        }

        @Override // dc.yn3.c
        public void doCancel() {
        }
    }

    public interface f {
        void g(Pattern pattern);

        void k(Pattern pattern);

        void y0(PatternViewHolder patternViewHolder, Pattern pattern);
    }

    public UserPatternAdapter(List<Pattern> list, Context context) {
        this.a = list;
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(Pattern pattern, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("patternId", pattern.getId());
        bundle.putBoolean("isUpdate", true);
        if (!WearUtils.e1(pattern.getToyFeature())) {
            bundle.putString("toyFeature", pattern.getToyFeature());
        }
        pj3.p((Activity) this.b, SharePatternActivity.class, 48, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(ao3 ao3Var, Pattern pattern, View view) {
        ao3Var.dismiss();
        if (WearUtils.y.u() == null) {
            R(R.string.pattern_store_hide_offline_notification);
            return;
        }
        f fVar = this.d;
        if (fVar != null) {
            fVar.g(pattern);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(final Pattern pattern, final int i, View view) {
        final ao3 ao3Var = new ao3(this.b, R.style.MenuDialogAl, R.layout.select_pattern_more_type);
        ao3Var.a(view, 250, pattern.getEmail().contains(WearUtils.y.r()) ? 200 : CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 5160, -30, new d(this));
        ao3Var.findViewById(R.id.action_row_2).setOnClickListener(new View.OnClickListener() { // from class: dc.ao1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.x(ao3Var, i, view2);
            }
        });
        if ("Lovense-pick".equals(pattern.getTagName()) || AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(pattern.getStatus())) {
            LinearLayout linearLayout = (LinearLayout) ao3Var.findViewById(R.id.action_row_3);
            linearLayout.setAlpha(0.5f);
            linearLayout.setClickable(false);
        } else {
            ao3Var.findViewById(R.id.action_row_3).setOnClickListener(new View.OnClickListener() { // from class: dc.do1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.z(ao3Var, pattern, view2);
                }
            });
        }
        if (MyApplication.Z || WearUtils.e1(pattern.getEmail()) || !pattern.getEmail().equals(WearUtils.y.r())) {
            ao3Var.findViewById(R.id.ll_row_1).setVisibility(8);
        } else {
            ao3Var.findViewById(R.id.ll_row_1).setVisibility(0);
            ao3Var.findViewById(R.id.ll_row_1).setOnClickListener(new View.OnClickListener() { // from class: dc.zn1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.B(pattern, view2);
                }
            });
        }
        ao3Var.findViewById(R.id.action_row_4).setOnClickListener(new View.OnClickListener() { // from class: dc.eo1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.D(ao3Var, pattern, view2);
            }
        });
        ao3Var.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(Pattern pattern, View view) {
        O(pattern);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(PatternViewHolder patternViewHolder, Pattern pattern) {
        if (!na2.m().t() && y12.c.a().s(y12.c.TYPE_PATTERN)) {
            PatternPlayManagerImpl.O().C0();
            f fVar = this.d;
            if (fVar != null) {
                fVar.y0(patternViewHolder, pattern);
            }
        }
    }

    public static void Q(@NonNull PatternViewHolder patternViewHolder, Pattern pattern) {
        String[] strArrSplit = pattern.getToyTag().split(",");
        int i = 0;
        patternViewHolder.toyType2.setVisibility(strArrSplit.length > 1 ? 0 : 8);
        patternViewHolder.toyType3.setVisibility(strArrSplit.length > 2 ? 0 : 8);
        while (i < strArrSplit.length) {
            ImageView imageView = i == 0 ? patternViewHolder.toyType1 : patternViewHolder.toyType2;
            if (i == 2) {
                imageView = patternViewHolder.toyType3;
            }
            boolean zEquals = TextUtils.equals(strArrSplit[i], PSOProgramService.VS_Key);
            int i2 = R.drawable.icon_label_toy_function_speed;
            if (zEquals || TextUtils.equals(strArrSplit[i], "v1")) {
                if (uu1.b(pattern.getToySymbol())) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_speed);
                } else {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_vibration);
                }
            }
            if (TextUtils.equals(strArrSplit[i], "v2")) {
                imageView.setImageResource(R.drawable.icon_label_toy_function_vibration_2);
            }
            if (TextUtils.equals(strArrSplit[i], "p")) {
                imageView.setImageResource(R.drawable.icon_label_toy_function_contraction);
            }
            if (TextUtils.equals(strArrSplit[i], StreamManagement.AckRequest.ELEMENT)) {
                imageView.setImageResource(R.drawable.icon_label_toy_function_rotation);
            }
            if (TextUtils.equals(strArrSplit[i], "t")) {
                if (i == 0) {
                    i2 = R.drawable.icon_label_toy_function_thrusting;
                }
                imageView.setImageResource(i2);
            }
            if (TextUtils.equals(strArrSplit[i], "s")) {
                imageView.setImageResource(R.drawable.icon_white_function_suction);
            }
            if (TextUtils.equals(strArrSplit[i], "f")) {
                imageView.setImageResource(R.drawable.icon_label_toy_function_fingering);
            }
            if (TextUtils.equals(strArrSplit[i], GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                imageView.setImageResource(R.drawable.icon_label_toy_function_depth);
            }
            if (TextUtils.equals(strArrSplit[i], "pos")) {
                imageView.setImageResource(R.drawable.icon_velvo_position);
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(Pattern pattern, View view) {
        if (pattern.isFavorite()) {
            O(pattern);
            WearUtils.x.q("pattern_cloud_remove_favorite", null);
        } else {
            l(pattern);
            WearUtils.x.q("pattern_cloud_add_favorite", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(PatternViewHolder patternViewHolder, Pattern pattern, View view) {
        N(patternViewHolder, pattern);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Pattern pattern, View view) {
        if (pattern.getFile().exists() && xe2.L0().O(WearUtils.y.r(), pattern.getId())) {
            if (MyApplication.Z) {
                sg3.i(this.b, R.string.pattern_store_offline_redownload_toast);
                return;
            }
            return;
        }
        WearUtils.x.q("pattern_cloud_down", null);
        String str = "";
        String name = TextUtils.isEmpty(pattern.getName()) ? "" : pattern.getName();
        if ((WearUtils.e1(pattern.getIsShowReview()) || !pattern.getIsShowReview().equals("1")) && (WearUtils.e1(pattern.getStatus()) || !pattern.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
            str = name;
        }
        S(pattern, str, pattern);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(ao3 ao3Var, int i, View view) {
        ao3Var.dismiss();
        if (WearUtils.y.u() == null) {
            R(R.string.pattern_store_share_offline_notification);
            return;
        }
        Pattern pattern = this.a.get(i);
        if (pattern == null || WearUtils.e1(pattern.getData()) || !pattern.isCheckMd5() || WearUtils.e1(pattern.getPath())) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("choose_pattern", pattern);
        pj3.g(this.b, ForwardMessageActivity.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(ao3 ao3Var, Pattern pattern, View view) {
        ao3Var.dismiss();
        if (WearUtils.y.u() == null) {
            R(R.string.pattern_store_report_offline_notification);
            return;
        }
        f fVar = this.d;
        if (fVar != null) {
            fVar.k(pattern);
        }
        WearUtils.x.q("pattern_cloud_report", null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull PatternViewHolder patternViewHolder, int i) {
        final Pattern pattern = this.a.get(i);
        patternViewHolder.b = pattern;
        patternViewHolder.a = pattern.getId();
        if ((WearUtils.e1(pattern.getIsShowReview()) || !pattern.getIsShowReview().equals("1")) && (WearUtils.e1(pattern.getStatus()) || !pattern.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
            patternViewHolder.iv_under_preview.setVisibility(8);
            patternViewHolder.patternSingleTitle.setText(TextUtils.isEmpty(pattern.getName()) ? "" : pattern.getName());
        } else {
            patternViewHolder.iv_under_preview.setVisibility(0);
            patternViewHolder.patternSingleTitle.setText(R.string.patterns_under_review);
        }
        patternViewHolder.patternTimes.setText(pattern.getTimer());
        if (WearUtils.e1(pattern.getAuthor()) || "Anonymous".equals(pattern.getAuthor())) {
            patternViewHolder.rvPatternAuth.setText(ah4.e(R.string.common_anonymous));
        } else {
            patternViewHolder.rvPatternAuth.setText(pattern.getAuthor());
        }
        if (WearUtils.e1(pattern.getToyTag())) {
            patternViewHolder.toyType1.setImageResource(R.drawable.label_toy_function_vibration);
            patternViewHolder.toyType2.setVisibility(8);
            patternViewHolder.toyType3.setVisibility(8);
        } else {
            Q(patternViewHolder, pattern);
        }
        if (WearUtils.e1(pattern.getToyName())) {
            String strD = ng3.d(pattern.getToyTag(), pattern.getCdtTime(), pattern.getToyFeature());
            if (WearUtils.e1(Toy.getFullName(strD))) {
                patternViewHolder.mTvPatternToyName.setVisibility(8);
            } else {
                patternViewHolder.mTvPatternToyName.setVisibility(0);
                patternViewHolder.mTvPatternToyName.setText(ng3.c(Toy.getFullName(strD), pattern.getToyVersion()));
            }
        } else {
            patternViewHolder.mTvPatternToyName.setText(ng3.c(pattern.getToyName(), pattern.getToyVersion()));
            patternViewHolder.mTvPatternToyName.setVisibility(0);
        }
        if (pattern.getCreated() != null) {
            patternViewHolder.tvPatternSendTime.setText(WearUtils.F0(pattern.getCreated()));
        }
        patternViewHolder.removedTopView.setVisibility(8);
        if (!WearUtils.e1(pattern.getStatus()) && (pattern.getStatus().equalsIgnoreCase("report") || pattern.getStatus().equalsIgnoreCase("removed"))) {
            patternViewHolder.removedTopView.setVisibility(0);
            if (WearUtils.e1(pattern.getData())) {
                patternViewHolder.patternPlayCurve.b();
            } else if (pattern.getHead() == null) {
                patternViewHolder.patternPlayCurve.setInitData(null, pattern.getData().split(","), true);
            } else {
                patternViewHolder.patternPlayCurve.setInitData(pattern.getHead(), pattern.getData().split(";"), false);
            }
            patternViewHolder.ivRemovedAction.setOnClickListener(new View.OnClickListener() { // from class: dc.yn1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.H(pattern, view);
                }
            });
            return;
        }
        n(patternViewHolder, pattern);
        patternViewHolder.patternPlay.setTag(Boolean.FALSE);
        patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_play);
        o(patternViewHolder, pattern);
        p(patternViewHolder, pattern);
        m(patternViewHolder, i, pattern);
        String tagAvatarUrl = pattern.getTagAvatarUrl();
        if (TextUtils.isEmpty(tagAvatarUrl)) {
            patternViewHolder.patternIcon.setImageResource(R.drawable.home_pattern_avatar);
        } else {
            if (!tagAvatarUrl.startsWith("http")) {
                tagAvatarUrl = WearUtils.e + tagAvatarUrl;
            }
            kf.w(patternViewHolder.patternIcon.getContext()).v(tagAvatarUrl).a(this.c).A0(patternViewHolder.patternIcon);
        }
        String tagName = pattern.getTagName();
        if (TextUtils.isEmpty(tagName)) {
            patternViewHolder.iv_lovense_pick.setVisibility(8);
        } else {
            patternViewHolder.iv_lovense_pick.setVisibility("Lovense-pick".equals(tagName) ? 0 : 8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull PatternViewHolder patternViewHolder, int i, @NonNull List list) {
        if (list.isEmpty()) {
            onBindViewHolder(patternViewHolder, i);
            return;
        }
        Pattern pattern = this.a.get(i);
        for (Object obj : list) {
            if (TextUtils.equals(Pattern.DOWNLOAD, obj.toString())) {
                o(patternViewHolder, pattern);
            } else if (TextUtils.equals("like", obj.toString())) {
                p(patternViewHolder, pattern);
            } else if (TextUtils.equals("getServerFile", obj.toString())) {
                n(patternViewHolder, pattern);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public PatternViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PatternViewHolder(LayoutInflater.from(this.b).inflate(R.layout.item_pattern_item_layout, viewGroup, false));
    }

    public final void N(@NonNull final PatternViewHolder patternViewHolder, final Pattern pattern) {
        db2.A().q(new db2.s() { // from class: dc.co1
            @Override // dc.db2.s
            public final void a() {
                this.a.J(patternViewHolder, pattern);
            }
        });
    }

    public final void O(Pattern pattern) {
        HashMap map = new HashMap();
        map.put("ids", pattern.getId());
        EventBus.getDefault().post(new PatternFavoriteChangeEvent(false, pattern.getId(), pattern.getToyTag()));
        tn2.x(WearUtils.x).l("/wear/pattern/removeFavorites", map, new c());
    }

    public void P(f fVar) {
        this.d = fVar;
    }

    public final void R(int i) {
        kn3 kn3Var = new kn3(this.b, ah4.e(i), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), true, (kn3.d) new a());
        kn3Var.show();
        kn3Var.p();
    }

    public final void S(Pattern pattern, String str, Pattern pattern2) {
        new yn3(this.b, pattern2.getCdnPath(), str, new e(pattern2, pattern));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public final void l(Pattern pattern) {
        if (WearUtils.y.u() == null) {
            R(R.string.pattern_store_like_offline_notification);
            return;
        }
        EventBus.getDefault().post(new PatternFavoriteChangeEvent(true, pattern.getId(), pattern.getToyTag()));
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, pattern.getId());
        tn2.x(WearUtils.x).l("/wear/pattern/addFavorites", map, new b());
    }

    public final void m(@NonNull final PatternViewHolder patternViewHolder, final int i, final Pattern pattern) {
        patternViewHolder.ivPatternLike.setOnClickListener(new View.OnClickListener() { // from class: dc.wn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.r(pattern, view);
            }
        });
        patternViewHolder.patternPlay.setOnClickListener(new View.OnClickListener() { // from class: dc.bo1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t(patternViewHolder, pattern, view);
            }
        });
        patternViewHolder.ivPatternDownload.setOnClickListener(new View.OnClickListener() { // from class: dc.vn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v(pattern, view);
            }
        });
        patternViewHolder.patternHiden.setOnClickListener(new View.OnClickListener() { // from class: dc.fo1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.F(pattern, i, view);
            }
        });
    }

    public final void n(PatternViewHolder patternViewHolder, Pattern pattern) {
        patternViewHolder.dataLoadingView.setVisibility(0);
        patternViewHolder.dataLoadingView.setOnClickListener(null);
        if (patternViewHolder.removedTopView.getVisibility() == 0 || !WearUtils.e1(pattern.getData())) {
            patternViewHolder.dataLoadingView.setVisibility(8);
        }
        patternViewHolder.patternPlayCurve.setShowBothLine(pattern.getHead() != null && pattern.getHead().isMulFunction());
        patternViewHolder.patternPlayCurve.setTag(pattern.getId());
        if (WearUtils.e1(pattern.getData())) {
            patternViewHolder.patternPlayCurve.b();
        } else if (pattern.getHead() == null) {
            patternViewHolder.patternPlayCurve.setInitData(null, pattern.getData().split(","), true);
        } else {
            patternViewHolder.patternPlayCurve.setInitData(pattern.getHead(), pattern.getData().split(";"), false);
        }
    }

    public final void o(PatternViewHolder patternViewHolder, Pattern pattern) {
        if (WearUtils.x0(pattern.getId()).exists()) {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.b, R.drawable.pattern_download_done));
        } else {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.b, R.drawable.patterns_patternlist_download));
        }
        patternViewHolder.tvPatternDownloadNumber.setText("" + pattern.getLikeCount());
        patternViewHolder.tvPatternDownloadNumber.setTextColor(th4.b(this.b, R.color.text_color_85));
        patternViewHolder.patternHiden.setVisibility(0);
        patternViewHolder.tvPatternDownloadNumber.setVisibility(0);
        if (!WearUtils.e1(pattern.getEmail()) && pattern.getEmail().equals(WearUtils.y.r())) {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.tvPatternDownloadNumber.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.b, R.drawable.pattern_download_done));
        } else if (pattern.getFile().exists() && xe2.L0().O(WearUtils.y.r(), pattern.getId())) {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.b, R.drawable.pattern_download_done));
        } else {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.b, R.drawable.patterns_patternlist_download));
        }
        patternViewHolder.tvPatternDownloadNumber.setText("" + pattern.getLikeCount());
        patternViewHolder.tvPatternDownloadNumber.setTextColor(th4.b(this.b, R.color.text_color_85));
    }

    public final void p(PatternViewHolder patternViewHolder, Pattern pattern) {
        patternViewHolder.tvPatternLikeNumber.setText(pattern.getFavoritesCount() + "");
        if (!WearUtils.e1(PatternStoreActivity.l.get(pattern.getId()))) {
            patternViewHolder.ivPatternLike.setVisibility(8);
            patternViewHolder.ivPatternLikeLoading.setVisibility(0);
            patternViewHolder.ivPatternLikeLoading.setImageResource(R.drawable.pattern_like_loading);
        } else {
            patternViewHolder.ivPatternLikeLoading.setVisibility(8);
            patternViewHolder.ivPatternLike.setVisibility(0);
            if (pattern.isFavorite()) {
                patternViewHolder.ivPatternLike.setImageResource(R.drawable.patterns_patternlist_favorite_click);
            } else {
                patternViewHolder.ivPatternLike.setImageResource(R.drawable.patterns_patternlist_favorite);
            }
        }
    }
}
