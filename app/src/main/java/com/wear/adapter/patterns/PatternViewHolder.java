package com.wear.adapter.patterns;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.ui.discover.pattern.PatternUserActivity;
import com.wear.util.WearUtils;
import com.wear.widget.control.NewCurveLineView;
import dc.pj3;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public class PatternViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public String a;
    public Pattern b;
    public final Context c;

    @BindView(R.id.data_loading_view)
    public RelativeLayout dataLoadingView;

    @BindView(R.id.down_linear)
    public LinearLayout downLinear;

    @BindView(R.id.hiden_linear)
    public LinearLayout hidenLinear;

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

    @BindView(R.id.like_linear)
    public LinearLayout likeLinear;

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

    public PatternViewHolder(View view, Context context) {
        super(view);
        this.c = context;
        ButterKnife.bind(this, view);
        this.rvPatternAuth.setOnClickListener(this);
        this.patternIcon.setOnClickListener(this);
        this.tvPatternSendTime.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if ((id != R.id.pattern_icon && id != R.id.rv_pattern_auth && id != R.id.tv_pattern_send_time) || WearUtils.e1(this.b.getAuthor()) || "Anonymous".equals(this.b.getAuthor())) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("userName", this.b.getAuthor());
        pj3.g(this.c, PatternUserActivity.class, bundle);
    }
}
