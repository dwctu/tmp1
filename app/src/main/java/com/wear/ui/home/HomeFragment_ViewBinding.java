package com.wear.ui.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.llong.CircularProgressView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public class HomeFragment_ViewBinding implements Unbinder {
    public HomeFragment a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public a(HomeFragment_ViewBinding homeFragment_ViewBinding, HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.doClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public b(HomeFragment_ViewBinding homeFragment_ViewBinding, HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.doClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ HomeFragment a;

        public c(HomeFragment_ViewBinding homeFragment_ViewBinding, HomeFragment homeFragment) {
            this.a = homeFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.doClick(view);
        }
    }

    @UiThread
    public HomeFragment_ViewBinding(HomeFragment homeFragment, View view) {
        this.a = homeFragment;
        homeFragment.rlToy1 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_1, "field 'rlToy1'", AppCompatTextView.class);
        homeFragment.rlToy2 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_2, "field 'rlToy2'", AppCompatTextView.class);
        homeFragment.ivNotToy = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_not_toy, "field 'ivNotToy'", ImageView.class);
        homeFragment.toysNumber = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.toys_number_text, "field 'toysNumber'", AppCompatTextView.class);
        homeFragment.titleAdd = (ImageView) Utils.findRequiredViewAsType(view, R.id.title_add, "field 'titleAdd'", ImageView.class);
        homeFragment.homeFragmentTitleLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_fragment_title_layout, "field 'homeFragmentTitleLayout'", LinearLayout.class);
        homeFragment.minimizeAlartNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.minimize_alart_notice, "field 'minimizeAlartNotice'", TextView.class);
        homeFragment.minimizeAlartClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.minimize_alart_close, "field 'minimizeAlartClose'", ImageView.class);
        homeFragment.minimizeAlartLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.minimize_alart_layout, "field 'minimizeAlartLayout'", LinearLayout.class);
        homeFragment.tvConnectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_connect_tip, "field 'tvConnectTip'", TextView.class);
        homeFragment.toyDisconnectedTip = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.toy_disconnected_tip, "field 'toyDisconnectedTip'", RelativeLayout.class);
        homeFragment.toyAlartTip = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.toy_alart_tip, "field 'toyAlartTip'", LinearLayout.class);
        homeFragment.tvLanApiPlatform = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_lan_api_platform, "field 'tvLanApiPlatform'", TextView.class);
        homeFragment.lanApiControlStop = (TextView) Utils.findRequiredViewAsType(view, R.id.lan_api_control_stop, "field 'lanApiControlStop'", TextView.class);
        homeFragment.lanApiControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lan_api_control, "field 'lanApiControl'", LinearLayout.class);
        homeFragment.llVideoPatternControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_video_pattern_control, "field 'llVideoPatternControl'", LinearLayout.class);
        homeFragment.tvVideoPatternControlTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_video_pattern_control_tip, "field 'tvVideoPatternControlTip'", TextView.class);
        homeFragment.tvVideoPatternControlUnsync = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_video_pattern_control_unsync, "field 'tvVideoPatternControlUnsync'", TextView.class);
        homeFragment.rlHomeTop = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_home_top, "field 'rlHomeTop'", RelativeLayout.class);
        homeFragment.ivBanner = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_banner, "field 'ivBanner'", ImageView.class);
        homeFragment.ivClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_close, "field 'ivClose'", ImageView.class);
        homeFragment.homeFragmentRootLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_fragment_root_layout, "field 'homeFragmentRootLayout'", LinearLayout.class);
        homeFragment.remoteControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.remoteControl, "field 'remoteControl'", LinearLayout.class);
        homeFragment.alarmSpaceLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.alarm_space_layout, "field 'alarmSpaceLayout'", LinearLayout.class);
        homeFragment.soundSpaceLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.sound_space_layout, "field 'soundSpaceLayout'", LinearLayout.class);
        homeFragment.lanApiControlUpdate = (TextView) Utils.findRequiredViewAsType(view, R.id.lan_api_control_update, "field 'lanApiControlUpdate'", TextView.class);
        homeFragment.composeLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_fra_compose_layout, "field 'composeLayout'", LinearLayout.class);
        homeFragment.patternSpaceLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_pattern_ll, "field 'patternSpaceLayout'", LinearLayout.class);
        homeFragment.ivPatternAdd = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_add, "field 'ivPatternAdd'", ImageView.class);
        homeFragment.musicSpaceLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_music_ll, "field 'musicSpaceLayout'", LinearLayout.class);
        homeFragment.paternContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_pattern_ll_content, "field 'paternContent'", LinearLayout.class);
        homeFragment.paternPure = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_pattern_ll_pure, "field 'paternPure'", LinearLayout.class);
        homeFragment.musicContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_item_music_ll_content, "field 'musicContent'", LinearLayout.class);
        homeFragment.musicPure = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_item_music_ll_pure, "field 'musicPure'", LinearLayout.class);
        homeFragment.musicTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.home_item_music_title, "field 'musicTitle'", TextView.class);
        homeFragment.musicMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.home_item_music_content, "field 'musicMsg'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.home_music_previous, "field 'musicIvPrevious' and method 'doClick'");
        homeFragment.musicIvPrevious = (ImageView) Utils.castView(viewFindRequiredView, R.id.home_music_previous, "field 'musicIvPrevious'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, homeFragment));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.home_music_play, "field 'musicIvPlay' and method 'doClick'");
        homeFragment.musicIvPlay = (ImageView) Utils.castView(viewFindRequiredView2, R.id.home_music_play, "field 'musicIvPlay'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, homeFragment));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.home_music_next, "field 'musicIvNext' and method 'doClick'");
        homeFragment.musicIvNext = (ImageView) Utils.castView(viewFindRequiredView3, R.id.home_music_next, "field 'musicIvNext'", ImageView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, homeFragment));
        homeFragment.musicIvPic = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_music_play_pic, "field 'musicIvPic'", ImageView.class);
        homeFragment.musicIvPicMask = Utils.findRequiredView(view, R.id.home_music_play_pic_mask, "field 'musicIvPicMask'");
        homeFragment.musicCPV = (CircularProgressView) Utils.findRequiredViewAsType(view, R.id.home_music_cpv, "field 'musicCPV'", CircularProgressView.class);
        homeFragment.patternCPV = (CircularProgressView) Utils.findRequiredViewAsType(view, R.id.home_pattern_cpv, "field 'patternCPV'", CircularProgressView.class);
        homeFragment.homePatternTitle = (MediumBoldTextView) Utils.findRequiredViewAsType(view, R.id.home_pattern_title, "field 'homePatternTitle'", MediumBoldTextView.class);
        homeFragment.homePatternToyType1 = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_toy_type_1, "field 'homePatternToyType1'", ImageView.class);
        homeFragment.homePatternToyType2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_toy_type_2, "field 'homePatternToyType2'", ImageView.class);
        homeFragment.homePatternLlType = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_pattern_ll_type, "field 'homePatternLlType'", LinearLayout.class);
        homeFragment.homePatternPrevious = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_previous, "field 'homePatternPrevious'", ImageView.class);
        homeFragment.homePatternPlay = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_play, "field 'homePatternPlay'", ImageView.class);
        homeFragment.homePatternNext = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_pattern_next, "field 'homePatternNext'", ImageView.class);
        homeFragment.mIvHomeControlLinkAdd = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_controllink_add, "field 'mIvHomeControlLinkAdd'", ImageView.class);
        homeFragment.mIvHomeItemControlLinkOperate = (ImageView) Utils.findRequiredViewAsType(view, R.id.home_item_control_link_operate, "field 'mIvHomeItemControlLinkOperate'", ImageView.class);
        homeFragment.mTvHomeControlLinkState = (TextView) Utils.findRequiredViewAsType(view, R.id.home_control_link_state, "field 'mTvHomeControlLinkState'", TextView.class);
        homeFragment.mLlHomeControlLinkActivate = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_home_control_link_activate, "field 'mLlHomeControlLinkActivate'", LinearLayout.class);
        homeFragment.mTvHomeControlLinkCountdown = (TextView) Utils.findRequiredViewAsType(view, R.id.home_control_link_countdown, "field 'mTvHomeControlLinkCountdown'", TextView.class);
        homeFragment.mTvHomeControlLinkTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.home_control_link_title, "field 'mTvHomeControlLinkTitle'", TextView.class);
        homeFragment.mTvHomeItemControlLinkFunction = (TextView) Utils.findRequiredViewAsType(view, R.id.home_item_control_link_function, "field 'mTvHomeItemControlLinkFunction'", TextView.class);
        homeFragment.mTvHomeItemControlLink = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.home_item_control_link, "field 'mTvHomeItemControlLink'", LinearLayout.class);
        homeFragment.mLlControlLinkState = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_link_state, "field 'mLlControlLinkState'", LinearLayout.class);
        homeFragment.mViewState = (CircleImageView) Utils.findRequiredViewAsType(view, R.id.view_state, "field 'mViewState'", CircleImageView.class);
        homeFragment.link_lly = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.link_lly, "field 'link_lly'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        HomeFragment homeFragment = this.a;
        if (homeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        homeFragment.rlToy1 = null;
        homeFragment.rlToy2 = null;
        homeFragment.ivNotToy = null;
        homeFragment.toysNumber = null;
        homeFragment.titleAdd = null;
        homeFragment.homeFragmentTitleLayout = null;
        homeFragment.minimizeAlartNotice = null;
        homeFragment.minimizeAlartClose = null;
        homeFragment.minimizeAlartLayout = null;
        homeFragment.tvConnectTip = null;
        homeFragment.toyDisconnectedTip = null;
        homeFragment.toyAlartTip = null;
        homeFragment.tvLanApiPlatform = null;
        homeFragment.lanApiControlStop = null;
        homeFragment.lanApiControl = null;
        homeFragment.llVideoPatternControl = null;
        homeFragment.tvVideoPatternControlTip = null;
        homeFragment.tvVideoPatternControlUnsync = null;
        homeFragment.rlHomeTop = null;
        homeFragment.ivBanner = null;
        homeFragment.ivClose = null;
        homeFragment.homeFragmentRootLayout = null;
        homeFragment.remoteControl = null;
        homeFragment.alarmSpaceLayout = null;
        homeFragment.soundSpaceLayout = null;
        homeFragment.lanApiControlUpdate = null;
        homeFragment.composeLayout = null;
        homeFragment.patternSpaceLayout = null;
        homeFragment.ivPatternAdd = null;
        homeFragment.musicSpaceLayout = null;
        homeFragment.paternContent = null;
        homeFragment.paternPure = null;
        homeFragment.musicContent = null;
        homeFragment.musicPure = null;
        homeFragment.musicTitle = null;
        homeFragment.musicMsg = null;
        homeFragment.musicIvPrevious = null;
        homeFragment.musicIvPlay = null;
        homeFragment.musicIvNext = null;
        homeFragment.musicIvPic = null;
        homeFragment.musicIvPicMask = null;
        homeFragment.musicCPV = null;
        homeFragment.patternCPV = null;
        homeFragment.homePatternTitle = null;
        homeFragment.homePatternToyType1 = null;
        homeFragment.homePatternToyType2 = null;
        homeFragment.homePatternLlType = null;
        homeFragment.homePatternPrevious = null;
        homeFragment.homePatternPlay = null;
        homeFragment.homePatternNext = null;
        homeFragment.mIvHomeControlLinkAdd = null;
        homeFragment.mIvHomeItemControlLinkOperate = null;
        homeFragment.mTvHomeControlLinkState = null;
        homeFragment.mLlHomeControlLinkActivate = null;
        homeFragment.mTvHomeControlLinkCountdown = null;
        homeFragment.mTvHomeControlLinkTitle = null;
        homeFragment.mTvHomeItemControlLinkFunction = null;
        homeFragment.mTvHomeItemControlLink = null;
        homeFragment.mLlControlLinkState = null;
        homeFragment.mViewState = null;
        homeFragment.link_lly = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
