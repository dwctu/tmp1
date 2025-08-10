package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.bean.RouletteSettingBean;
import com.wear.widget.SwitchView;
import skin.support.widget.SkinCompatLinearLayout;

/* loaded from: classes3.dex */
public class DialogFragmentRouletteSettingsBindingImpl extends DialogFragmentRouletteSettingsBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts k = null;

    @Nullable
    public static final SparseIntArray l;

    @NonNull
    public final SkinCompatLinearLayout g;

    @NonNull
    public final EditText h;
    public InverseBindingListener i;
    public long j;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(DialogFragmentRouletteSettingsBindingImpl.this.h);
            RouletteSettingBean rouletteSettingBean = DialogFragmentRouletteSettingsBindingImpl.this.f;
            if (rouletteSettingBean != null) {
                rouletteSettingBean.setIntro(textString);
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l = sparseIntArray;
        sparseIntArray.put(R.id.btn_close, 4);
        sparseIntArray.put(R.id.gender_recyclerview, 5);
        sparseIntArray.put(R.id.submit_btn, 6);
    }

    public DialogFragmentRouletteSettingsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, k, l));
    }

    @Override // com.wear.databinding.DialogFragmentRouletteSettingsBinding
    public void d(@Nullable RouletteSettingBean rouletteSettingBean) {
        this.f = rouletteSettingBean;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String intro;
        boolean z;
        Boolean sendFriendRequest;
        Boolean receiveFriendRequest;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        RouletteSettingBean rouletteSettingBean = this.f;
        long j2 = 3 & j;
        boolean zSafeUnbox = false;
        if (j2 != 0) {
            if (rouletteSettingBean != null) {
                sendFriendRequest = rouletteSettingBean.getSendFriendRequest();
                receiveFriendRequest = rouletteSettingBean.getReceiveFriendRequest();
                intro = rouletteSettingBean.getIntro();
            } else {
                intro = null;
                sendFriendRequest = null;
                receiveFriendRequest = null;
            }
            boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(sendFriendRequest);
            zSafeUnbox = ViewDataBinding.safeUnbox(receiveFriendRequest);
            z = zSafeUnbox2;
        } else {
            intro = null;
            z = false;
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.h, intro);
            this.c.setChecked(zSafeUnbox);
            this.d.setChecked(z);
        }
        if ((j & 2) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.h, null, null, null, this.i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (19 != i) {
            return false;
        }
        d((RouletteSettingBean) obj);
        return true;
    }

    public DialogFragmentRouletteSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[4], (RecyclerView) objArr[5], (SwitchView) objArr[3], (SwitchView) objArr[2], (TextView) objArr[6]);
        this.i = new a();
        this.j = -1L;
        SkinCompatLinearLayout skinCompatLinearLayout = (SkinCompatLinearLayout) objArr[0];
        this.g = skinCompatLinearLayout;
        skinCompatLinearLayout.setTag(null);
        EditText editText = (EditText) objArr[1];
        this.h = editText;
        editText.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
