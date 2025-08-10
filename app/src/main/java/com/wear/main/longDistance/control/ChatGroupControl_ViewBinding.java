package com.wear.main.longDistance.control;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.widget.control.multiToys.MultiControlPanel;

/* loaded from: classes3.dex */
public class ChatGroupControl_ViewBinding implements Unbinder {
    public ChatGroupControl a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChatGroupControl a;

        public a(ChatGroupControl_ViewBinding chatGroupControl_ViewBinding, ChatGroupControl chatGroupControl) {
            this.a = chatGroupControl;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChatGroupControl a;

        public b(ChatGroupControl_ViewBinding chatGroupControl_ViewBinding, ChatGroupControl chatGroupControl) {
            this.a = chatGroupControl;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ChatGroupControl a;

        public c(ChatGroupControl_ViewBinding chatGroupControl_ViewBinding, ChatGroupControl chatGroupControl) {
            this.a = chatGroupControl;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ChatGroupControl a;

        public d(ChatGroupControl_ViewBinding chatGroupControl_ViewBinding, ChatGroupControl chatGroupControl) {
            this.a = chatGroupControl;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ ChatGroupControl a;

        public e(ChatGroupControl_ViewBinding chatGroupControl_ViewBinding, ChatGroupControl chatGroupControl) {
            this.a = chatGroupControl;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ ChatGroupControl a;

        public f(ChatGroupControl_ViewBinding chatGroupControl_ViewBinding, ChatGroupControl chatGroupControl) {
            this.a = chatGroupControl;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) throws Resources.NotFoundException {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ChatGroupControl_ViewBinding(ChatGroupControl chatGroupControl, View view) {
        this.a = chatGroupControl;
        chatGroupControl.multiControlPanel = (MultiControlPanel) Utils.findRequiredViewAsType(view, R.id.multi_control_panel, "field 'multiControlPanel'", MultiControlPanel.class);
        chatGroupControl.rvMyToysBatteryView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_toy_list, "field 'rvMyToysBatteryView'", RecyclerView.class);
        chatGroupControl.rvMasterToysBatteryView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_master_toy_list, "field 'rvMasterToysBatteryView'", RecyclerView.class);
        chatGroupControl.rvFriendToy = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_friend_toy, "field 'rvFriendToy'", RecyclerView.class);
        chatGroupControl.ivLdrControlStatesTemp = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ldr_control_states_temp, "field 'ivLdrControlStatesTemp'", ImageView.class);
        chatGroupControl.ivLdrControlStates = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ldr_control_states, "field 'ivLdrControlStates'", ImageView.class);
        chatGroupControl.ivFriendAvatar = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_friend_avatar, "field 'ivFriendAvatar'", RoundedImageView.class);
        chatGroupControl.tvFriendUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_friend_user_name, "field 'tvFriendUserName'", TextView.class);
        chatGroupControl.rvSelfToy = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_self_toy, "field 'rvSelfToy'", RecyclerView.class);
        chatGroupControl.ivSelfAvatar = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_self_avatar, "field 'ivSelfAvatar'", RoundedImageView.class);
        chatGroupControl.tvSelfUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_self_user_name, "field 'tvSelfUserName'", TextView.class);
        chatGroupControl.tvMe = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_me, "field 'tvMe'", TextView.class);
        chatGroupControl.tvLdrWaitReconnectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ldr_wait_reconnect_tip, "field 'tvLdrWaitReconnectTip'", TextView.class);
        chatGroupControl.clLdrControlled = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_ldr_controlled, "field 'clLdrControlled'", ConstraintLayout.class);
        chatGroupControl.rvLdrMasterControlToy = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_ldr_master_control_toy, "field 'rvLdrMasterControlToy'", RecyclerView.class);
        chatGroupControl.tvCenter = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_center, "field 'tvCenter'", TextView.class);
        chatGroupControl.clLdrMasterControl = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_ldr_master_control, "field 'clLdrMasterControl'", ConstraintLayout.class);
        chatGroupControl.rvPattern = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_pattern, "field 'rvPattern'", RecyclerView.class);
        chatGroupControl.ivRemoteControled = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_remote_controled, "field 'ivRemoteControled'", ImageView.class);
        chatGroupControl.ivFriendAvatar1 = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_friend_avatar_1, "field 'ivFriendAvatar1'", RoundedImageView.class);
        chatGroupControl.tvFriendUserName1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_friend_user_name_1, "field 'tvFriendUserName1'", TextView.class);
        chatGroupControl.ivIAvatar1 = (RoundedImageView) Utils.findRequiredViewAsType(view, R.id.iv_i_avatar_1, "field 'ivIAvatar1'", RoundedImageView.class);
        chatGroupControl.tvIUserName1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_i_user_name_1, "field 'tvIUserName1'", TextView.class);
        chatGroupControl.tvRemoteWaitReconnectTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_remote_wait_reconnect_tip, "field 'tvRemoteWaitReconnectTip'", TextView.class);
        chatGroupControl.clRemoteControled = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_remote_controled, "field 'clRemoteControled'", ConstraintLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_show_more_friend_1, "field 'ivShowMoreFriend1' and method 'onClick'");
        chatGroupControl.ivShowMoreFriend1 = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_show_more_friend_1, "field 'ivShowMoreFriend1'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, chatGroupControl));
        chatGroupControl.rvFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_friend, "field 'rvFriend'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_show_more_friend, "field 'ivShowMoreFriend' and method 'onClick'");
        chatGroupControl.ivShowMoreFriend = (ImageView) Utils.castView(viewFindRequiredView2, R.id.iv_show_more_friend, "field 'ivShowMoreFriend'", ImageView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, chatGroupControl));
        chatGroupControl.llControlFriends = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_friends, "field 'llControlFriends'", LinearLayout.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.tv_end_control_time, "field 'tvEndControlTime' and method 'onClick'");
        chatGroupControl.tvEndControlTime = (TextView) Utils.castView(viewFindRequiredView3, R.id.tv_end_control_time, "field 'tvEndControlTime'", TextView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, chatGroupControl));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_control_dlr, "field 'tvControlDlr' and method 'onClick'");
        chatGroupControl.tvControlDlr = (TextView) Utils.castView(viewFindRequiredView4, R.id.tv_control_dlr, "field 'tvControlDlr'", TextView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, chatGroupControl));
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_remote_control, "field 'tvRemoteControl' and method 'onClick'");
        chatGroupControl.tvRemoteControl = (TextView) Utils.castView(viewFindRequiredView5, R.id.tv_remote_control, "field 'tvRemoteControl'", TextView.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, chatGroupControl));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.tv_control_pattern, "field 'tvControlPattern' and method 'onClick'");
        chatGroupControl.tvControlPattern = (TextView) Utils.castView(viewFindRequiredView6, R.id.tv_control_pattern, "field 'tvControlPattern'", TextView.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new f(this, chatGroupControl));
        chatGroupControl.llControlBottom = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control_bottom, "field 'llControlBottom'", LinearLayout.class);
        chatGroupControl.llControl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_control, "field 'llControl'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatGroupControl chatGroupControl = this.a;
        if (chatGroupControl == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatGroupControl.multiControlPanel = null;
        chatGroupControl.rvMyToysBatteryView = null;
        chatGroupControl.rvMasterToysBatteryView = null;
        chatGroupControl.rvFriendToy = null;
        chatGroupControl.ivLdrControlStatesTemp = null;
        chatGroupControl.ivLdrControlStates = null;
        chatGroupControl.ivFriendAvatar = null;
        chatGroupControl.tvFriendUserName = null;
        chatGroupControl.rvSelfToy = null;
        chatGroupControl.ivSelfAvatar = null;
        chatGroupControl.tvSelfUserName = null;
        chatGroupControl.tvMe = null;
        chatGroupControl.tvLdrWaitReconnectTip = null;
        chatGroupControl.clLdrControlled = null;
        chatGroupControl.rvLdrMasterControlToy = null;
        chatGroupControl.tvCenter = null;
        chatGroupControl.clLdrMasterControl = null;
        chatGroupControl.rvPattern = null;
        chatGroupControl.ivRemoteControled = null;
        chatGroupControl.ivFriendAvatar1 = null;
        chatGroupControl.tvFriendUserName1 = null;
        chatGroupControl.ivIAvatar1 = null;
        chatGroupControl.tvIUserName1 = null;
        chatGroupControl.tvRemoteWaitReconnectTip = null;
        chatGroupControl.clRemoteControled = null;
        chatGroupControl.ivShowMoreFriend1 = null;
        chatGroupControl.rvFriend = null;
        chatGroupControl.ivShowMoreFriend = null;
        chatGroupControl.llControlFriends = null;
        chatGroupControl.tvEndControlTime = null;
        chatGroupControl.tvControlDlr = null;
        chatGroupControl.tvRemoteControl = null;
        chatGroupControl.tvControlPattern = null;
        chatGroupControl.llControlBottom = null;
        chatGroupControl.llControl = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
    }
}
