package com.wear.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.lovense.wear.R;
import com.wear.adapter.longdistance.GroupControlWaitAccpetAdapter;
import com.wear.bean.GroupMember;
import dc.ce3;
import dc.is3;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class GroupControlWaitAccpetDialog extends is3<ArrayList<GroupMember>> {
    public GroupControlWaitAccpetAdapter f;
    public Handler g;
    public DialogInterface.OnDismissListener h;
    public GridLayoutManager i;
    public int j;

    @BindView(R.id.rv_member)
    public RecyclerView rvMember;

    public static class CenterSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
        public int a;

        public CenterSpanSizeLookup(int i) {
            this.a = 0;
            this.a = i;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            int[][] iArr = {new int[]{60, 0, 0, 0, 0, 0}, new int[]{30, 30, 0, 0, 0, 0}, new int[]{20, 20, 20, 0, 0, 0}, new int[]{15, 15, 15, 15, 0, 0}, new int[]{12, 12, 12, 12, 12, 0}, new int[]{10, 10, 10, 10, 10, 10}};
            int i2 = this.a;
            return iArr[i2 - 1][i % i2];
        }
    }

    public class a implements DialogInterface.OnDismissListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            GroupControlWaitAccpetDialog.this.g.removeCallbacksAndMessages(null);
            DialogInterface.OnDismissListener onDismissListener = GroupControlWaitAccpetDialog.this.h;
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
            GroupControlWaitAccpetAdapter groupControlWaitAccpetAdapter = GroupControlWaitAccpetDialog.this.f;
            if (groupControlWaitAccpetAdapter != null) {
                groupControlWaitAccpetAdapter.notifyDataSetChanged();
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                GroupControlWaitAccpetDialog.this.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public GroupControlWaitAccpetDialog(Context context, int i) {
        super(context, i);
        this.g = new Handler(Looper.getMainLooper());
        this.j = 60;
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_group_control_wait_accpet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.is3
    public void i() {
        super.i();
        this.f = new GroupControlWaitAccpetAdapter((ArrayList) this.c, R.layout.item_group_control_wait_accpet);
        this.i = new GridLayoutManager(getContext(), 60);
        int size = ((ArrayList) this.c).size() < 6 ? ((ArrayList) this.c).size() : 6;
        this.j = size;
        this.i.setSpanSizeLookup(new CenterSpanSizeLookup(size));
        this.rvMember.setLayoutManager(this.i);
        this.rvMember.setAdapter(this.f);
        D d = this.c;
        if (d != 0 && ((ArrayList) d).size() > 15) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.rvMember.getLayoutParams();
            layoutParams.height = ce3.a(getContext(), 135.0f);
            this.rvMember.setLayoutParams(layoutParams);
        }
        super.setOnDismissListener(new a());
    }

    public void p() {
        o(new b());
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        this.h = onDismissListener;
    }

    @Override // dc.is3, android.app.Dialog
    public void show() {
        super.show();
        this.g.removeCallbacksAndMessages(null);
        this.g.postDelayed(new c(), 60000L);
    }

    public GroupControlWaitAccpetDialog(Context context) {
        super(context);
        this.g = new Handler(Looper.getMainLooper());
        this.j = 60;
    }
}
