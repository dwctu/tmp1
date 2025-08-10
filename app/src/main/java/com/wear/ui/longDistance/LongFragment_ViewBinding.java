package com.wear.ui.longDistance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.roundwidget.SkinRoundImageView;

/* loaded from: classes3.dex */
public class LongFragment_ViewBinding implements Unbinder {
    public LongFragment a;

    @UiThread
    public LongFragment_ViewBinding(LongFragment longFragment, View view) {
        this.a = longFragment;
        longFragment.btnAdd = (ImageView) Utils.findRequiredViewAsType(view, R.id.btn_add, "field 'btnAdd'", ImageView.class);
        longFragment.pbLoginIng = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_login_ing, "field 'pbLoginIng'", ProgressBar.class);
        longFragment.ivSearch = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_search, "field 'ivSearch'", ImageView.class);
        longFragment.rvOnline = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_online, "field 'rvOnline'", RecyclerView.class);
        longFragment.tvRequestCount = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_request_count, "field 'tvRequestCount'", TextView.class);
        longFragment.rivRequestPhoto = (SkinRoundImageView) Utils.findRequiredViewAsType(view, R.id.riv_request_photo, "field 'rivRequestPhoto'", SkinRoundImageView.class);
        longFragment.clRequest = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.cl_request, "field 'clRequest'", RelativeLayout.class);
        longFragment.rlToy1 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_1, "field 'rlToy1'", AppCompatTextView.class);
        longFragment.rlToy2 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_2, "field 'rlToy2'", AppCompatTextView.class);
        longFragment.ivNotToy = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_not_toy, "field 'ivNotToy'", ImageView.class);
        longFragment.toysNumber = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.toys_number_text, "field 'toysNumber'", AppCompatTextView.class);
        longFragment.loginLongDistance = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.login_long_distance, "field 'loginLongDistance'", LinearLayout.class);
        longFragment.offlineLogin = (TextView) Utils.findRequiredViewAsType(view, R.id.offline_login, "field 'offlineLogin'", TextView.class);
        longFragment.controlRoulette = (TextView) Utils.findRequiredViewAsType(view, R.id.control_roulette, "field 'controlRoulette'", TextView.class);
        longFragment.offlineLongDistance = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.offline_long_distance, "field 'offlineLongDistance'", LinearLayout.class);
        longFragment.mtvTitle = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.mtv_title, "field 'mtvTitle'", MediumBoldTextView.class);
        longFragment.lanApiControlStop = (TextView) Utils.findRequiredViewAsType(view, R.id.lan_api_control_stop, "field 'lanApiControlStop'", TextView.class);
        longFragment.lanApiControlUpdate = (TextView) Utils.findRequiredViewAsType(view, R.id.lan_api_control_update, "field 'lanApiControlUpdate'", TextView.class);
        longFragment.lanApiControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lan_api_control, "field 'lanApiControl'", LinearLayout.class);
        longFragment.tvLanApiPlatform = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_lan_api_platform, "field 'tvLanApiPlatform'", TextView.class);
        longFragment.llVideoPatternControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_video_pattern_control, "field 'llVideoPatternControl'", LinearLayout.class);
        longFragment.tvVideoPatternControlTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_video_pattern_control_tip, "field 'tvVideoPatternControlTip'", TextView.class);
        longFragment.tvVideoPatternControlUnsync = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_video_pattern_control_unsync, "field 'tvVideoPatternControlUnsync'", TextView.class);
        longFragment.mLlSearch = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.ll_search, "field 'mLlSearch'", ViewGroup.class);
        longFragment.frameLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.frameLayout, "field 'frameLayout'", FrameLayout.class);
        longFragment.longDistanceDes = (TextView) Utils.findRequiredViewAsType(view, R.id.long_distance_des, "field 'longDistanceDes'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LongFragment longFragment = this.a;
        if (longFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        longFragment.btnAdd = null;
        longFragment.pbLoginIng = null;
        longFragment.ivSearch = null;
        longFragment.rvOnline = null;
        longFragment.tvRequestCount = null;
        longFragment.rivRequestPhoto = null;
        longFragment.clRequest = null;
        longFragment.rlToy1 = null;
        longFragment.rlToy2 = null;
        longFragment.ivNotToy = null;
        longFragment.toysNumber = null;
        longFragment.loginLongDistance = null;
        longFragment.offlineLogin = null;
        longFragment.controlRoulette = null;
        longFragment.offlineLongDistance = null;
        longFragment.mtvTitle = null;
        longFragment.lanApiControlStop = null;
        longFragment.lanApiControlUpdate = null;
        longFragment.lanApiControl = null;
        longFragment.tvLanApiPlatform = null;
        longFragment.llVideoPatternControl = null;
        longFragment.tvVideoPatternControlTip = null;
        longFragment.tvVideoPatternControlUnsync = null;
        longFragment.mLlSearch = null;
        longFragment.frameLayout = null;
        longFragment.longDistanceDes = null;
    }
}
