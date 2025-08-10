package com.wear.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.adapter.longdistance.GroupDSWaitAccpetAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldTextView;
import dc.ah4;
import dc.cg3;
import dc.ch3;
import dc.is3;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class GroupDSWaitAccpetDialog extends is3<g> {

    @BindView(R.id.ds_wait_connect)
    public MediumBoldTextView dsWaitConnect;
    public GroupDSWaitAccpetAdapter f;
    public Handler g;
    public DialogInterface.OnDismissListener h;
    public boolean i;

    @BindView(R.id.iv_user_img)
    public RoundedImageView ivUserImg;
    public boolean j;

    @BindView(R.id.ll_create_control)
    public LinearLayout llCreateControl;

    @BindView(R.id.ll_group_control)
    public LinearLayout llGroupControl;

    @BindView(R.id.rv_member)
    public RecyclerView rvMember;

    @BindView(R.id.tv_confirm)
    public TextView tvConfirm;

    @BindView(R.id.tv_create_cancel)
    public TextView tvCreateCancel;

    @BindView(R.id.tv_decline)
    public TextView tvDecline;

    @BindView(R.id.tv_room_name)
    public MediumBoldTextView tvRoomName;

    @BindView(R.id.tv_s_user_name)
    public TextView tvSUserName;

    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            GroupDSWaitAccpetDialog.this.g.removeCallbacksAndMessages(null);
            DialogInterface.OnDismissListener onDismissListener = GroupDSWaitAccpetDialog.this.h;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupDSWaitAccpetDialog.this.d();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupDSWaitAccpetDialog.this.e();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupDSWaitAccpetDialog.this.d();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                GroupDSWaitAccpetDialog groupDSWaitAccpetDialog = GroupDSWaitAccpetDialog.this;
                if (groupDSWaitAccpetDialog.i || groupDSWaitAccpetDialog.j) {
                    GroupDSWaitAccpetDialog.this.d();
                } else {
                    GroupDSWaitAccpetDialog.this.dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GroupDSWaitAccpetAdapter groupDSWaitAccpetAdapter = GroupDSWaitAccpetDialog.this.f;
            if (groupDSWaitAccpetAdapter != null) {
                groupDSWaitAccpetAdapter.notifyDataSetChanged();
            }
        }
    }

    public static class g {
        public ArrayList<IPeopleInfo> a;
        public GroupMember b;
        public String c;
    }

    public GroupDSWaitAccpetDialog(Context context, int i) {
        super(context, i);
        this.g = new Handler(Looper.getMainLooper());
        this.i = false;
        this.j = false;
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_group_ds_wait_accpet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.is3
    public void i() {
        super.i();
        GroupDSWaitAccpetAdapter groupDSWaitAccpetAdapter = new GroupDSWaitAccpetAdapter(((g) this.c).a, R.layout.item_group_ds_wait_accpet);
        this.f = groupDSWaitAccpetAdapter;
        cg3.b(this.rvMember, groupDSWaitAccpetAdapter, 6);
        WearUtils.t2(this.ivUserImg, ((g) this.c).b);
        Group groupK = ch3.n().k(((g) this.c).c);
        if (groupK != null) {
            this.tvSUserName.setText(((g) this.c).b.getNickName());
            this.tvRoomName.setText(groupK.getShowNickName());
        } else {
            this.tvSUserName.setText(((g) this.c).b.getNickName());
        }
        super.setOnDismissListener(new a());
        this.tvDecline.setOnClickListener(new b());
        this.tvConfirm.setOnClickListener(new c());
        this.tvCreateCancel.setOnClickListener(new d());
    }

    public void p(boolean z) {
        if (z) {
            e();
        } else {
            d();
        }
    }

    public void r() {
        o(new f());
    }

    public void setButtonVisibility(boolean z) {
        if (this.llCreateControl == null) {
            return;
        }
        this.i = z;
        if (!z) {
            this.llGroupControl.setVisibility(0);
            this.llCreateControl.setVisibility(8);
        } else {
            this.llGroupControl.setVisibility(8);
            this.llCreateControl.setVisibility(0);
            this.dsWaitConnect.setText(ah4.e(R.string.ds_creator_waiting_window));
        }
    }

    public void setNotice(boolean z, String str) {
        MediumBoldTextView mediumBoldTextView = this.dsWaitConnect;
        if (mediumBoldTextView == null) {
            return;
        }
        this.j = z;
        if (z) {
            mediumBoldTextView.setText(String.format(ah4.e(R.string.ds_sub_waiting_window), str));
        } else {
            mediumBoldTextView.setText(String.format(ah4.e(R.string.ds_dom_waiting_window), str));
        }
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        this.h = onDismissListener;
    }

    @Override // dc.is3, android.app.Dialog
    public void show() {
        super.show();
        this.g.removeCallbacksAndMessages(null);
        this.g.postDelayed(new e(), 60000L);
    }

    public GroupDSWaitAccpetDialog(Context context) {
        super(context);
        this.g = new Handler(Looper.getMainLooper());
        this.i = false;
        this.j = false;
    }
}
