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
import dc.ExpandData;
import dc.ag3;
import dc.is3;

/* loaded from: classes4.dex */
public class ControlExpandDialog extends FullScreenDialog<ExpandData> {

    @BindView(R.id.ll_expand_bg)
    public LinearLayout LLExpandBg;

    @BindView(R.id.fl_root_view)
    public FrameLayout flRootView;
    public c g;
    public View h;

    @BindView(R.id.iv_bg)
    public ImageView ivBg;

    @BindView(R.id.iv_end)
    public ImageView ivEnd;

    @BindView(R.id.iv_icon)
    public ImageView ivIcon;

    @BindView(R.id.tv_time)
    public TextView tvTime;

    @BindView(R.id.tv_user_name)
    public TextView tvUserName;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            Animation animationLoadAnimation;
            ControlExpandDialog.this.LLExpandBg.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ControlExpandDialog.this.LLExpandBg.getLayoutParams();
            int y = ((ExpandData) ControlExpandDialog.this.c).getY();
            layoutParams.topMargin = y;
            if (y < 0) {
                layoutParams.topMargin = 0;
            } else if (y > ControlExpandDialog.this.flRootView.getHeight() - ControlExpandDialog.this.LLExpandBg.getHeight()) {
                layoutParams.topMargin = ControlExpandDialog.this.flRootView.getHeight() - ControlExpandDialog.this.LLExpandBg.getHeight();
            }
            if (((ExpandData) ControlExpandDialog.this.c).getLeft()) {
                layoutParams.gravity = 3;
                ControlExpandDialog.this.LLExpandBg.setBackgroundResource(R.drawable.minimize_expand_left);
                animationLoadAnimation = AnimationUtils.loadAnimation(ControlExpandDialog.this.LLExpandBg.getContext(), R.anim.slide_left);
            } else {
                layoutParams.gravity = 5;
                ControlExpandDialog.this.LLExpandBg.setBackgroundResource(R.drawable.minimize_expand_right);
                animationLoadAnimation = AnimationUtils.loadAnimation(ControlExpandDialog.this.LLExpandBg.getContext(), R.anim.slide_right);
            }
            ControlExpandDialog controlExpandDialog = ControlExpandDialog.this;
            controlExpandDialog.tvUserName.setText(((ExpandData) controlExpandDialog.c).getName());
            ControlExpandDialog controlExpandDialog2 = ControlExpandDialog.this;
            controlExpandDialog2.ivIcon.setImageResource(((ExpandData) controlExpandDialog2.c).getIcon());
            ControlExpandDialog.this.LLExpandBg.setLayoutParams(layoutParams);
            ControlExpandDialog.this.LLExpandBg.startAnimation(animationLoadAnimation);
        }
    }

    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = ControlExpandDialog.this.a.i;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
            try {
                View view = ControlExpandDialog.this.h;
                if (view != null) {
                    view.setDrawingCacheEnabled(false);
                    ControlExpandDialog.this.h.destroyDrawingCache();
                }
            } catch (Exception unused) {
            }
        }
    }

    public interface c {
        void end();
    }

    public ControlExpandDialog(Context context) {
        super(context);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_control_expand;
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
            c cVar2 = this.g;
            if (cVar2 != null) {
                cVar2.end();
                return;
            }
            return;
        }
        if (id != R.id.ll_expand_bg) {
            return;
        }
        is3.a aVar = this.a;
        if (aVar.h != null) {
            aVar.g.doConfirm();
        }
    }

    public void setListener(c cVar) {
        this.g = cVar;
    }
}
