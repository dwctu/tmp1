package com.wear.adapter.patterns;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.control.NewCurveLineView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
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
        patternViewHolder.likeLinear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.like_linear, "field 'likeLinear'", LinearLayout.class);
        patternViewHolder.tvPatternLikeNumber = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_pattern_like_number, "field 'tvPatternLikeNumber'", TextView.class);
        patternViewHolder.downLinear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.down_linear, "field 'downLinear'", LinearLayout.class);
        patternViewHolder.hidenLinear = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.hiden_linear, "field 'hidenLinear'", LinearLayout.class);
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
        patternViewHolder.likeLinear = null;
        patternViewHolder.tvPatternLikeNumber = null;
        patternViewHolder.downLinear = null;
        patternViewHolder.hidenLinear = null;
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
