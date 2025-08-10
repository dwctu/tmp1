package com.wear.widget.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public final class NewLDRPanel_ViewBinding implements Unbinder {
    public NewLDRPanel a;

    @UiThread
    public NewLDRPanel_ViewBinding(NewLDRPanel newLDRPanel, View view) {
        this.a = newLDRPanel;
        newLDRPanel.llPanel = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_panel, "field 'llPanel'", LinearLayout.class);
        newLDRPanel.rvFriend = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_friend, "field 'rvFriend'", RecyclerView.class);
        newLDRPanel.rvSelf = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_self, "field 'rvSelf'", RecyclerView.class);
        newLDRPanel.ivLdrControlStates = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_ldr_control_states, "field 'ivLdrControlStates'", ImageView.class);
        newLDRPanel.tvFriendName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_friend_name, "field 'tvFriendName'", TextView.class);
        newLDRPanel.tvMe = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_me, "field 'tvMe'", TextView.class);
        newLDRPanel.divider = Utils.findRequiredView(view, R.id.divider, "field 'divider'");
        newLDRPanel.leftView = Utils.findRequiredView(view, R.id.left_view, "field 'leftView'");
        newLDRPanel.rightView = Utils.findRequiredView(view, R.id.right_view, "field 'rightView'");
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewLDRPanel newLDRPanel = this.a;
        if (newLDRPanel == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        newLDRPanel.llPanel = null;
        newLDRPanel.rvFriend = null;
        newLDRPanel.rvSelf = null;
        newLDRPanel.ivLdrControlStates = null;
        newLDRPanel.tvFriendName = null;
        newLDRPanel.tvMe = null;
        newLDRPanel.divider = null;
        newLDRPanel.leftView = null;
        newLDRPanel.rightView = null;
    }
}
