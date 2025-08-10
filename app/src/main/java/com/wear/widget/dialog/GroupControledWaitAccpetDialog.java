package com.wear.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.lovense.wear.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.wear.adapter.longdistance.GroupControlWaitAccpetAdapter;
import com.wear.bean.Group;
import com.wear.bean.GroupMember;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ce3;
import dc.cg3;
import dc.ch3;
import dc.is3;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class GroupControledWaitAccpetDialog extends is3<c> {
    public GroupControlWaitAccpetAdapter f;
    public Handler g;
    public DialogInterface.OnDismissListener h;

    @BindView(R.id.iv_user_img)
    public RoundedImageView ivUserImg;

    @BindView(R.id.rv_member)
    public RecyclerView rvMember;

    @BindView(R.id.tv_count)
    public TextView tvCount;

    @BindView(R.id.tv_user_name)
    public TextView tvUserName;

    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            GroupControledWaitAccpetDialog.this.g.removeCallbacksAndMessages(null);
            DialogInterface.OnDismissListener onDismissListener = GroupControledWaitAccpetDialog.this.h;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                GroupControledWaitAccpetDialog.this.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class c {
        public ArrayList<GroupMember> a;
        public GroupMember b;
        public String c;
    }

    public GroupControledWaitAccpetDialog(Context context, int i) {
        super(context, i);
        this.g = new Handler(Looper.getMainLooper());
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_group_controled_wait_accpet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.is3
    public void i() {
        super.i();
        GroupControlWaitAccpetAdapter groupControlWaitAccpetAdapter = new GroupControlWaitAccpetAdapter(((c) this.c).a, R.layout.item_group_control_wait_accpet);
        this.f = groupControlWaitAccpetAdapter;
        cg3.d(this.rvMember, groupControlWaitAccpetAdapter);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.rvMember.getLayoutParams();
        layoutParams.height = ce3.a(getContext(), 55.0f);
        this.rvMember.setLayoutParams(layoutParams);
        WearUtils.t2(this.ivUserImg, ((c) this.c).b);
        Group groupK = ch3.n().k(((c) this.c).c);
        if (groupK != null) {
            this.tvUserName.setText(((c) this.c).b.getNickName() + " - " + groupK.getShowNickName());
        } else {
            this.tvUserName.setText(((c) this.c).b.getNickName());
        }
        if (((c) this.c).a.size() > 0) {
            this.rvMember.setVisibility(0);
            this.tvCount.setVisibility(0);
            this.tvCount.setText(String.format(ah4.e(R.string.group_chat_sync_in_call), ((c) this.c).a.size() + ""));
        } else {
            this.rvMember.setVisibility(8);
            this.tvCount.setVisibility(8);
        }
        super.setOnDismissListener(new a());
    }

    public void p(boolean z) {
        if (z) {
            e();
        } else {
            d();
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
        this.g.postDelayed(new b(), 60000L);
    }

    public GroupControledWaitAccpetDialog(Context context) {
        super(context);
        this.g = new Handler(Looper.getMainLooper());
    }
}
