package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.main.game.ui.NewGameVideModel;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public class ActivityNewGameModeBindingImpl extends ActivityNewGameModeBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts B = null;

    @Nullable
    public static final SparseIntArray C;
    public long A;

    @NonNull
    public final SkinCompatConstraintLayout z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        C = sparseIntArray;
        sparseIntArray.put(R.id.actionbar, 1);
        sparseIntArray.put(R.id.tv_connect_toy_tip, 2);
        sparseIntArray.put(R.id.ll_lan_info, 3);
        sparseIntArray.put(R.id.tv_lan_enable, 4);
        sparseIntArray.put(R.id.tv_lan_tip, 5);
        sparseIntArray.put(R.id.switch_lan_enable, 6);
        sparseIntArray.put(R.id.cl_info, 7);
        sparseIntArray.put(R.id.divider, 8);
        sparseIntArray.put(R.id.tv_local_ip, 9);
        sparseIntArray.put(R.id.tv_local_ip_value, 10);
        sparseIntArray.put(R.id.tv_port, 11);
        sparseIntArray.put(R.id.tv_port_value, 12);
        sparseIntArray.put(R.id.tv_ssl_port, 13);
        sparseIntArray.put(R.id.tv_ssl_port_value, 14);
        sparseIntArray.put(R.id.ll_accept_control, 15);
        sparseIntArray.put(R.id.iv_accept_control, 16);
        sparseIntArray.put(R.id.tv_accept_control_title, 17);
        sparseIntArray.put(R.id.tv_accept_control_content, 18);
        sparseIntArray.put(R.id.ll_accept_control_info, 19);
        sparseIntArray.put(R.id.tv_accept_control_msg, 20);
        sparseIntArray.put(R.id.ll_control, 21);
        sparseIntArray.put(R.id.iv_control, 22);
        sparseIntArray.put(R.id.tv_control_title, 23);
        sparseIntArray.put(R.id.tv_control_content, 24);
        sparseIntArray.put(R.id.ll_control_info, 25);
        sparseIntArray.put(R.id.tv_control_tip, 26);
        sparseIntArray.put(R.id.cl_control_info_detail, 27);
        sparseIntArray.put(R.id.tv_third_party_name, 28);
        sparseIntArray.put(R.id.v_status, 29);
        sparseIntArray.put(R.id.tv_third_party_status, 30);
        sparseIntArray.put(R.id.v_control_info_line, 31);
        sparseIntArray.put(R.id.rv_control_toys, 32);
    }

    public ActivityNewGameModeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 33, B, C));
    }

    public void b(@Nullable NewGameVideModel newGameVideModel) {
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.A = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.A != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.A = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (27 != i) {
            return false;
        }
        b((NewGameVideModel) obj);
        return true;
    }

    public ActivityNewGameModeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MyActionBar) objArr[1], (ConstraintLayout) objArr[27], (SkinCompatConstraintLayout) objArr[7], (View) objArr[8], (ImageView) objArr[16], (ImageView) objArr[22], (LinearLayout) objArr[15], (LinearLayout) objArr[19], (LinearLayout) objArr[21], (LinearLayout) objArr[25], (LinearLayout) objArr[3], (RecyclerView) objArr[32], (SwitchView) objArr[6], (TextView) objArr[18], (TextView) objArr[20], (TextView) objArr[17], (TextView) objArr[2], (TextView) objArr[24], (TextView) objArr[26], (TextView) objArr[23], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[12], (TextView) objArr[13], (TextView) objArr[14], (TextView) objArr[28], (TextView) objArr[30], (View) objArr[31], (View) objArr[29]);
        this.A = -1L;
        SkinCompatConstraintLayout skinCompatConstraintLayout = (SkinCompatConstraintLayout) objArr[0];
        this.z = skinCompatConstraintLayout;
        skinCompatConstraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
