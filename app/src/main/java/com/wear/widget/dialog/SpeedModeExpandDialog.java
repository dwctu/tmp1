package com.wear.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.lovense.wear.R;
import com.wear.ui.discover.speedMode.SpeedModeControl;
import dc.ExpandData;
import dc.ag3;
import dc.is3;

/* loaded from: classes4.dex */
public class SpeedModeExpandDialog extends FullScreenDialog<ExpandData> {

    @BindView(R.id.ll_expand_bg)
    public LinearLayout LLExpandBg;

    @BindView(R.id.fl_root_view)
    public FrameLayout flRootView;

    @BindView(R.id.iv_icon)
    public ImageView ivIcon;

    @BindView(R.id.tv_pattern_name)
    public TextView tvPatternName;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            Animation animationLoadAnimation;
            SpeedModeExpandDialog.this.LLExpandBg.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SpeedModeExpandDialog.this.LLExpandBg.getLayoutParams();
            int y = ((ExpandData) SpeedModeExpandDialog.this.c).getY();
            layoutParams.topMargin = y;
            if (y < 0) {
                layoutParams.topMargin = 0;
            } else if (y > SpeedModeExpandDialog.this.flRootView.getHeight() - SpeedModeExpandDialog.this.LLExpandBg.getHeight()) {
                layoutParams.topMargin = SpeedModeExpandDialog.this.flRootView.getHeight() - SpeedModeExpandDialog.this.LLExpandBg.getHeight();
            }
            if (((ExpandData) SpeedModeExpandDialog.this.c).getLeft()) {
                layoutParams.gravity = 3;
                SpeedModeExpandDialog.this.LLExpandBg.setBackgroundResource(R.drawable.minimize_expand_left);
                animationLoadAnimation = AnimationUtils.loadAnimation(SpeedModeExpandDialog.this.LLExpandBg.getContext(), R.anim.slide_left);
            } else {
                layoutParams.gravity = 5;
                SpeedModeExpandDialog.this.LLExpandBg.setBackgroundResource(R.drawable.minimize_expand_right);
                animationLoadAnimation = AnimationUtils.loadAnimation(SpeedModeExpandDialog.this.LLExpandBg.getContext(), R.anim.slide_right);
            }
            SpeedModeExpandDialog speedModeExpandDialog = SpeedModeExpandDialog.this;
            speedModeExpandDialog.tvPatternName.setText(((ExpandData) speedModeExpandDialog.c).getName());
            SpeedModeExpandDialog speedModeExpandDialog2 = SpeedModeExpandDialog.this;
            speedModeExpandDialog2.ivIcon.setImageResource(((ExpandData) speedModeExpandDialog2.c).getIcon());
            SpeedModeExpandDialog.this.LLExpandBg.setLayoutParams(layoutParams);
            SpeedModeExpandDialog.this.LLExpandBg.startAnimation(animationLoadAnimation);
        }
    }

    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = SpeedModeExpandDialog.this.a.i;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
        }
    }

    public SpeedModeExpandDialog(Context context) {
        super(context);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_speed_mode_expand;
    }

    @Override // dc.is3
    public void i() {
        super.i();
        new ag3(this.f);
        this.flRootView.post(new a());
        setOnDismissListener(new b());
    }

    @OnClick({R.id.iv_bg, R.id.iv_end, R.id.ll_expand_bg})
    public void onClick(View view) {
        is3.d dVar;
        dismiss();
        int id = view.getId();
        if (id == R.id.iv_bg) {
            is3.c cVar = this.a.h;
            if (cVar != null) {
                cVar.doCancel();
                return;
            }
            return;
        }
        if (id == R.id.iv_end) {
            SpeedModeControl.C().a0();
        } else if (id == R.id.ll_expand_bg && (dVar = this.a.g) != null) {
            dVar.doConfirm();
        }
    }
}
