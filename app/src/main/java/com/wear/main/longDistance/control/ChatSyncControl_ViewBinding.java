package com.wear.main.longDistance.control;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.control.NewLDRPanel;
import com.wear.widget.control.multiToys.MultiControlPanel;

/* loaded from: classes3.dex */
public class ChatSyncControl_ViewBinding implements Unbinder {
    public ChatSyncControl a;

    @UiThread
    public ChatSyncControl_ViewBinding(ChatSyncControl chatSyncControl, View view) {
        this.a = chatSyncControl;
        chatSyncControl.flMasterSyncControl = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_master_sync_control, "field 'flMasterSyncControl'", FrameLayout.class);
        chatSyncControl.llControlLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_layout, "field 'llControlLayout'", LinearLayout.class);
        chatSyncControl.multiControlPanel = (MultiControlPanel) Utils.findRequiredViewAsType(view, R.id.multi_control_panel, "field 'multiControlPanel'", MultiControlPanel.class);
        chatSyncControl.touchControlHorizontalBottom = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.touch_control_horizontal_bottom, "field 'touchControlHorizontalBottom'", LinearLayout.class);
        chatSyncControl.llControlTime = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_time, "field 'llControlTime'", LinearLayout.class);
        chatSyncControl.tvControlTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_time, "field 'tvControlTime'", TextView.class);
        chatSyncControl.ivControlTime = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_control_close, "field 'ivControlTime'", ImageView.class);
        chatSyncControl.tvTochangeControlRemote = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tochange_control_remote, "field 'tvTochangeControlRemote'", TextView.class);
        chatSyncControl.tvTochangeControlDlr = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_tochange_control_dlr, "field 'tvTochangeControlDlr'", TextView.class);
        chatSyncControl.llPattern = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_pattern, "field 'llPattern'", LinearLayout.class);
        chatSyncControl.llSyncPattern = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_pattern_sync, "field 'llSyncPattern'", LinearLayout.class);
        chatSyncControl.tvSyncPattern = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sync_pattern, "field 'tvSyncPattern'", TextView.class);
        chatSyncControl.ivSyncPattern = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_pattern_sync, "field 'ivSyncPattern'", ImageView.class);
        chatSyncControl.ivShowOrCloseMore = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_show_or_close_more, "field 'ivShowOrCloseMore'", ImageView.class);
        chatSyncControl.llControlled = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_controlled, "field 'llControlled'", LinearLayout.class);
        chatSyncControl.llControlTime1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_time_1, "field 'llControlTime1'", LinearLayout.class);
        chatSyncControl.tvControlTime1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_control_time_1, "field 'tvControlTime1'", TextView.class);
        chatSyncControl.llBeControlled1 = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_be_controlled_1, "field 'llBeControlled1'", LinearLayout.class);
        chatSyncControl.chatLiveBottomPatternLayer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.chat_live_bottom_pattern_layer, "field 'chatLiveBottomPatternLayer'", LinearLayout.class);
        chatSyncControl.chatLiveBottomPatternList = (ListView) Utils.findRequiredViewAsType(view, R.id.chat_live_bottom_pattern_list, "field 'chatLiveBottomPatternList'", ListView.class);
        chatSyncControl.patternListEmpty = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.pattern_list_empty, "field 'patternListEmpty'", LinearLayout.class);
        chatSyncControl.syncLdrLayer = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.sync_ldr_layer, "field 'syncLdrLayer'", RelativeLayout.class);
        chatSyncControl.ldrPanel = (NewLDRPanel) Utils.findRequiredViewAsType(view, R.id.ldr_panel, "field 'ldrPanel'", NewLDRPanel.class);
        chatSyncControl.rvSelf = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_self, "field 'rvSelf'", RecyclerView.class);
        chatSyncControl.rvFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_friend, "field 'rvFriend'", RecyclerView.class);
        chatSyncControl.ivLdrControlStates = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ldr_control_states, "field 'ivLdrControlStates'", ImageView.class);
        chatSyncControl.tvFriendName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_friend_name, "field 'tvFriendName'", TextView.class);
        chatSyncControl.ldrSensitivity = (SeekBar) Utils.findRequiredViewAsType(view, R.id.ldr_sensitivity, "field 'ldrSensitivity'", SeekBar.class);
        chatSyncControl.ldrMasterControlLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ldr_master_control_layout, "field 'ldrMasterControlLayout'", LinearLayout.class);
        chatSyncControl.ivLdrControl = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ldr_control, "field 'ivLdrControl'", ImageView.class);
        chatSyncControl.tvLdrControl = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ldr_control, "field 'tvLdrControl'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatSyncControl chatSyncControl = this.a;
        if (chatSyncControl == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatSyncControl.flMasterSyncControl = null;
        chatSyncControl.llControlLayout = null;
        chatSyncControl.multiControlPanel = null;
        chatSyncControl.touchControlHorizontalBottom = null;
        chatSyncControl.llControlTime = null;
        chatSyncControl.tvControlTime = null;
        chatSyncControl.ivControlTime = null;
        chatSyncControl.tvTochangeControlRemote = null;
        chatSyncControl.tvTochangeControlDlr = null;
        chatSyncControl.llPattern = null;
        chatSyncControl.llSyncPattern = null;
        chatSyncControl.tvSyncPattern = null;
        chatSyncControl.ivSyncPattern = null;
        chatSyncControl.ivShowOrCloseMore = null;
        chatSyncControl.llControlled = null;
        chatSyncControl.llControlTime1 = null;
        chatSyncControl.tvControlTime1 = null;
        chatSyncControl.llBeControlled1 = null;
        chatSyncControl.chatLiveBottomPatternLayer = null;
        chatSyncControl.chatLiveBottomPatternList = null;
        chatSyncControl.patternListEmpty = null;
        chatSyncControl.syncLdrLayer = null;
        chatSyncControl.ldrPanel = null;
        chatSyncControl.rvSelf = null;
        chatSyncControl.rvFriend = null;
        chatSyncControl.ivLdrControlStates = null;
        chatSyncControl.tvFriendName = null;
        chatSyncControl.ldrSensitivity = null;
        chatSyncControl.ldrMasterControlLayout = null;
        chatSyncControl.ivLdrControl = null;
        chatSyncControl.tvLdrControl = null;
    }
}
