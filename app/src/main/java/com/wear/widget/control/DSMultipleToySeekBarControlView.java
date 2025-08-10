package com.wear.widget.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class DSMultipleToySeekBarControlView extends FrameLayout {

    @BindView(R.id.vseekBar_expansion)
    public VSeekBarView vseekBarExpansion;

    @BindView(R.id.vseekBar_expansion_layout)
    public RelativeLayout vseekBarExpansionLayout;

    @BindView(R.id.vseekBar_left)
    public VSeekBarView vseekBarLeft;

    @BindView(R.id.vseekBar_left_layout)
    public RelativeLayout vseekBarLeftLayout;

    @BindView(R.id.vseekBar_right)
    public VSeekBarView vseekBarRight;

    @BindView(R.id.vseekBar_right_layout)
    public RelativeLayout vseekBarRightLayout;

    public DSMultipleToySeekBarControlView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R.layout.view_ds_toy_seek_bar_control, this);
        ButterKnife.bind(this);
    }

    public VSeekBarView getVseekBarExpansion() {
        return this.vseekBarExpansion;
    }

    public RelativeLayout getVseekBarExpansionLayout() {
        return this.vseekBarExpansionLayout;
    }

    public VSeekBarView getVseekBarLeft() {
        return this.vseekBarLeft;
    }

    public RelativeLayout getVseekBarLeftLayout() {
        return this.vseekBarLeftLayout;
    }

    public VSeekBarView getVseekBarRight() {
        return this.vseekBarRight;
    }

    public RelativeLayout getVseekBarRightLayout() {
        return this.vseekBarRightLayout;
    }

    public void setVseekBarExpansion(VSeekBarView vSeekBarView) {
        this.vseekBarExpansion = vSeekBarView;
    }

    public void setVseekBarExpansionLayout(RelativeLayout relativeLayout) {
        this.vseekBarExpansionLayout = relativeLayout;
    }

    public void setVseekBarLeft(VSeekBarView vSeekBarView) {
        this.vseekBarLeft = vSeekBarView;
    }

    public void setVseekBarLeftLayout(RelativeLayout relativeLayout) {
        this.vseekBarLeftLayout = relativeLayout;
    }

    public void setVseekBarRight(VSeekBarView vSeekBarView) {
        this.vseekBarRight = vSeekBarView;
    }

    public void setVseekBarRightLayout(RelativeLayout relativeLayout) {
        this.vseekBarRightLayout = relativeLayout;
    }
}
