package com.wear.main.longDistance.control;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.widget.HotView;
import com.wear.widget.control.NewLDRPanel;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.velvo.VelvoPreviewView;
import org.webrtc.SurfaceViewRenderer;

/* loaded from: classes3.dex */
public class ChatVideoControl_ViewBinding implements Unbinder {
    public ChatVideoControl a;

    @UiThread
    public ChatVideoControl_ViewBinding(ChatVideoControl chatVideoControl, View view) {
        this.a = chatVideoControl;
        chatVideoControl.maxView = (SurfaceViewRenderer) Utils.findRequiredViewAsType(view, R.id.max_view, "field 'maxView'", SurfaceViewRenderer.class);
        chatVideoControl.minView = (SurfaceViewRenderer) Utils.findRequiredViewAsType(view, R.id.min_view, "field 'minView'", SurfaceViewRenderer.class);
        chatVideoControl.ivFriendAvatar = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_friend_avatar, "field 'ivFriendAvatar'", RoundedImageView.class);
        chatVideoControl.tvLinkedToyNotice = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_linked_toy_notice, "field 'tvLinkedToyNotice'", TextView.class);
        chatVideoControl.webrtcFlash = (TextView) Utils.findRequiredViewAsType(view, R.id.webrtc_flash, "field 'webrtcFlash'", TextView.class);
        chatVideoControl.userAvatarLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.user_avatar_layout, "field 'userAvatarLayout'", LinearLayout.class);
        chatVideoControl.tvTochangeVideoControlRemote = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tochange_video_control_remote, "field 'tvTochangeVideoControlRemote'", TextView.class);
        chatVideoControl.tvTochangeVideoControlDlr = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tochange_video_control_dlr, "field 'tvTochangeVideoControlDlr'", TextView.class);
        chatVideoControl.tochangeSwitchControlLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.tochange_switch_control_layout, "field 'tochangeSwitchControlLayout'", LinearLayout.class);
        chatVideoControl.tvRequestFriendName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_request_friend_name, "field 'tvRequestFriendName'", TextView.class);
        chatVideoControl.rvSelf = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_self, "field 'rvSelf'", RecyclerView.class);
        chatVideoControl.ldrSensitivity = (SeekBar) Utils.findRequiredViewAsType(view, R.id.ldr_sensitivity, "field 'ldrSensitivity'", SeekBar.class);
        chatVideoControl.ldrSensitivityLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ldr_sensitivity_layout, "field 'ldrSensitivityLayout'", LinearLayout.class);
        chatVideoControl.ivLdrControl = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ldr_control, "field 'ivLdrControl'", ImageView.class);
        chatVideoControl.tvLdrControl = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ldr_control, "field 'tvLdrControl'", TextView.class);
        chatVideoControl.llLdrControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_ldr_control, "field 'llLdrControl'", LinearLayout.class);
        chatVideoControl.flDlrLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_dlr_layout, "field 'flDlrLayout'", FrameLayout.class);
        chatVideoControl.touchPanel = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.touch_panel, "field 'touchPanel'", ConstraintLayout.class);
        chatVideoControl.ldrPanel = (NewLDRPanel) Utils.findRequiredViewAsType(view, R.id.ldr_panel, "field 'ldrPanel'", NewLDRPanel.class);
        chatVideoControl.multiControlPanel = (MultiControlPanel) Utils.findRequiredViewAsType(view, R.id.multi_control_panel, "field 'multiControlPanel'", MultiControlPanel.class);
        chatVideoControl.videoBottomControlLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.video_bottom_control_layout, "field 'videoBottomControlLayout'", LinearLayout.class);
        chatVideoControl.webrtcClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.webrtc_close, "field 'webrtcClose'", ImageView.class);
        chatVideoControl.webrtcControlTimes = (TextView) Utils.findRequiredViewAsType(view, R.id.webrtc_control_times, "field 'webrtcControlTimes'", TextView.class);
        chatVideoControl.chatVideoCollect = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_video_collect, "field 'chatVideoCollect'", ImageView.class);
        chatVideoControl.chatVoiceSoundModel = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_voice_sound_model, "field 'chatVoiceSoundModel'", ImageView.class);
        chatVideoControl.chatVideoChannelVoice = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_video_channel_voice, "field 'chatVideoChannelVoice'", ImageView.class);
        chatVideoControl.chatVideoSwitchCamera = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_video_switch_camera, "field 'chatVideoSwitchCamera'", ImageView.class);
        chatVideoControl.chatVideoSwitchRecord = (ImageView) Utils.findRequiredViewAsType(view, R.id.chat_video_switch_record, "field 'chatVideoSwitchRecord'", ImageView.class);
        chatVideoControl.chatVideoRecordTimeHit = (HotView) Utils.findRequiredViewAsType(view, R.id.chat_video_record_time_hit, "field 'chatVideoRecordTimeHit'", HotView.class);
        chatVideoControl.chatVideoRecordTimeTime = (TextView) Utils.findRequiredViewAsType(view, R.id.chat_video_record_time_time, "field 'chatVideoRecordTimeTime'", TextView.class);
        chatVideoControl.chatVideoRecordTimeLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.chat_video_record_time_layout, "field 'chatVideoRecordTimeLayout'", LinearLayout.class);
        chatVideoControl.webrtcControlLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.webrtc_control_layout, "field 'webrtcControlLayout'", LinearLayout.class);
        chatVideoControl.rootTouchLayout = Utils.findRequiredView(view, R.id.root_touch_layout, "field 'rootTouchLayout'");
        chatVideoControl.ivReject = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_reject, "field 'ivReject'", ImageView.class);
        chatVideoControl.tvReject = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_reject, "field 'tvReject'", TextView.class);
        chatVideoControl.ivCancel = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_cancel, "field 'ivCancel'", ImageView.class);
        chatVideoControl.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        chatVideoControl.ivAccept = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_accept, "field 'ivAccept'", ImageView.class);
        chatVideoControl.tvAccept = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_accept, "field 'tvAccept'", TextView.class);
        chatVideoControl.layoutReceive = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.layout_receive, "field 'layoutReceive'", ConstraintLayout.class);
        chatVideoControl.flRtcRootView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_rtc_root_view, "field 'flRtcRootView'", FrameLayout.class);
        chatVideoControl.ivVoiceBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_voice_bg, "field 'ivVoiceBg'", ImageView.class);
        chatVideoControl.rvFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_friend, "field 'rvFriend'", RecyclerView.class);
        chatVideoControl.velvoPreviewView = (VelvoPreviewView) Utils.findRequiredViewAsType(view, R.id.velvo_preview, "field 'velvoPreviewView'", VelvoPreviewView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatVideoControl chatVideoControl = this.a;
        if (chatVideoControl == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatVideoControl.maxView = null;
        chatVideoControl.minView = null;
        chatVideoControl.ivFriendAvatar = null;
        chatVideoControl.tvLinkedToyNotice = null;
        chatVideoControl.webrtcFlash = null;
        chatVideoControl.userAvatarLayout = null;
        chatVideoControl.tvTochangeVideoControlRemote = null;
        chatVideoControl.tvTochangeVideoControlDlr = null;
        chatVideoControl.tochangeSwitchControlLayout = null;
        chatVideoControl.tvRequestFriendName = null;
        chatVideoControl.rvSelf = null;
        chatVideoControl.ldrSensitivity = null;
        chatVideoControl.ldrSensitivityLayout = null;
        chatVideoControl.ivLdrControl = null;
        chatVideoControl.tvLdrControl = null;
        chatVideoControl.llLdrControl = null;
        chatVideoControl.flDlrLayout = null;
        chatVideoControl.touchPanel = null;
        chatVideoControl.ldrPanel = null;
        chatVideoControl.multiControlPanel = null;
        chatVideoControl.videoBottomControlLayout = null;
        chatVideoControl.webrtcClose = null;
        chatVideoControl.webrtcControlTimes = null;
        chatVideoControl.chatVideoCollect = null;
        chatVideoControl.chatVoiceSoundModel = null;
        chatVideoControl.chatVideoChannelVoice = null;
        chatVideoControl.chatVideoSwitchCamera = null;
        chatVideoControl.chatVideoSwitchRecord = null;
        chatVideoControl.chatVideoRecordTimeHit = null;
        chatVideoControl.chatVideoRecordTimeTime = null;
        chatVideoControl.chatVideoRecordTimeLayout = null;
        chatVideoControl.webrtcControlLayout = null;
        chatVideoControl.rootTouchLayout = null;
        chatVideoControl.ivReject = null;
        chatVideoControl.tvReject = null;
        chatVideoControl.ivCancel = null;
        chatVideoControl.tvCancel = null;
        chatVideoControl.ivAccept = null;
        chatVideoControl.tvAccept = null;
        chatVideoControl.layoutReceive = null;
        chatVideoControl.flRtcRootView = null;
        chatVideoControl.ivVoiceBg = null;
        chatVideoControl.rvFriend = null;
        chatVideoControl.velvoPreviewView = null;
    }
}
