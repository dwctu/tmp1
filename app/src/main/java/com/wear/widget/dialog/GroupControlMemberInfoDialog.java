package com.wear.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.GroupMember;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.Toy;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.socketio.msg.response.ReceiveGroupMemberStateResponse;
import com.wear.bean.socketio.msg.reuqest.GetGroupMemberStateRequest;
import com.wear.protocol.CommunMessage;
import com.wear.util.WearUtils;
import com.wear.widget.AutoLineFeedLayoutManager;
import dc.is3;
import dc.mf2;
import dc.vb2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class GroupControlMemberInfoDialog extends is3<GroupMember> {
    public boolean f;
    public b g;

    @BindView(R.id.iv_battery_1)
    public ImageView ivBattery1;

    @BindView(R.id.iv_battery_2)
    public ImageView ivBattery2;

    @BindView(R.id.iv_role)
    public ImageView ivRole;

    @BindView(R.id.ll_toy_info)
    public LinearLayout llToyInfo;

    @BindView(R.id.riv_user_img)
    public RoundedImageView rivUserImg;

    @BindView(R.id.toy_recyclerview)
    public RecyclerView toyRecyclerView;

    @BindView(R.id.tv_block_contact)
    public TextView tvBlockContact;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_name)
    public TextView tvName;

    @BindView(R.id.tv_to_control)
    public TextView tvToControl;

    @BindView(R.id.tv_toy_name_1)
    public TextView tvToyName1;

    @BindView(R.id.tv_toy_name_2)
    public TextView tvToyName2;

    public class a implements mf2 {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.mf2
        public void Q(String str) {
            ReceiveGroupMemberStateResponse receiveGroupMemberStateResponse = (ReceiveGroupMemberStateResponse) JSON.parseObject(str, ReceiveGroupMemberStateResponse.class);
            if (GroupControlMemberInfoDialog.this.isShowing()) {
                for (ReceiveGroupMemberStateResponse.PlayerJidListBean playerJidListBean : receiveGroupMemberStateResponse.getPlayerJidList()) {
                    D d = GroupControlMemberInfoDialog.this.c;
                    if (d != 0) {
                        ((GroupMember) d).setOnLine(playerJidListBean.getOnLine() == 1);
                        SyncLinkToy syncLinkToy = !TextUtils.isEmpty(playerJidListBean.getToyJson()) ? (SyncLinkToy) JSON.parseObject(CommunMessage.decrypt(playerJidListBean.getToyJson()), SyncLinkToy.class) : null;
                        if (syncLinkToy == null || syncLinkToy.getToys() == null) {
                            ((GroupMember) GroupControlMemberInfoDialog.this.c).setToys(null);
                        } else {
                            ((GroupMember) GroupControlMemberInfoDialog.this.c).setToys(syncLinkToy.getToys());
                        }
                        ((GroupMember) GroupControlMemberInfoDialog.this.c).setOpenfireStatus(playerJidListBean.getOpenfireStatus());
                        if (((GroupMember) GroupControlMemberInfoDialog.this.c).getOpenfireStatus() != 3) {
                            GroupControlMemberInfoDialog groupControlMemberInfoDialog = GroupControlMemberInfoDialog.this;
                            groupControlMemberInfoDialog.q(((GroupMember) groupControlMemberInfoDialog.c).getToys());
                        } else {
                            GroupControlMemberInfoDialog.this.toyRecyclerView.setVisibility(8);
                        }
                    }
                }
            }
        }

        @Override // dc.mf2
        public void a(Throwable th) {
        }
    }

    public interface b {
        void a(GroupMember groupMember);
    }

    public class c extends BaseAdapter<Toy> {
        public c(GroupControlMemberInfoDialog groupControlMemberInfoDialog, List<Toy> list, int i) {
            super(list, i);
        }

        @Override // com.wear.adapter.BaseAdapter
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public void y(BaseAdapter.ViewHolder viewHolder, Toy toy, int i) {
            viewHolder.a(R.id.tv_toy_name, toy.getToyUINameSpecialForMiniXMachine(1));
            toy.updateToyBattery((ImageView) viewHolder.getView(R.id.iv_battery));
        }
    }

    public GroupControlMemberInfoDialog(Context context) {
        super(context, R.style.MaterialDialogSheet);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_show_group_friend_info_tip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.is3
    public void i() {
        super.i();
        this.tvName.setText(((GroupMember) this.c).getUserName());
        WearUtils.t2(this.rivUserImg, (IPeopleInfo) this.c);
        if (this.f) {
            this.tvToControl.setVisibility(0);
        } else {
            this.tvToControl.setVisibility(8);
        }
        GetGroupMemberStateRequest getGroupMemberStateRequest = new GetGroupMemberStateRequest();
        ArrayList arrayList = new ArrayList();
        arrayList.add(((GroupMember) this.c).getJid());
        getGroupMemberStateRequest.setPlayerJidList(arrayList);
        getGroupMemberStateRequest.setAckId(WearUtils.E());
        vb2.b().a(getGroupMemberStateRequest, new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnClick({R.id.tv_to_control, R.id.tv_block_contact})
    public void onViewClicked(View view) {
        b bVar;
        dismiss();
        if (view.getId() == R.id.tv_to_control && (bVar = this.g) != null) {
            bVar.a((GroupMember) this.c);
        }
    }

    public final void q(ArrayList<Toy> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            this.toyRecyclerView.setVisibility(8);
            return;
        }
        c cVar = new c(this, arrayList, R.layout.item_toy_name_add_battery);
        this.toyRecyclerView.setVisibility(0);
        AutoLineFeedLayoutManager autoLineFeedLayoutManager = new AutoLineFeedLayoutManager();
        autoLineFeedLayoutManager.setAutoMeasureEnabled(true);
        this.toyRecyclerView.setLayoutManager(autoLineFeedLayoutManager);
        this.toyRecyclerView.setAdapter(cVar);
    }

    public void setListener(b bVar) {
        this.g = bVar;
    }

    public void setMasterControl(boolean z) {
        this.f = z;
    }

    @Override // dc.is3, android.app.Dialog
    public void show() {
        super.show();
        setCanceledOnTouchOutside(true);
    }
}
