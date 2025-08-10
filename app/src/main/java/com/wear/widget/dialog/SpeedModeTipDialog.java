package com.wear.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.lovense.wear.R;
import dc.eg3;
import dc.is3;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class SpeedModeTipDialog extends is3<String> {
    public int f;

    @BindView(R.id.iv_speed_mode_tip_select)
    public ImageView ivSpeedModeTipSelect;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_confirm)
    public TextView tvConfirm;

    @BindView(R.id.tv_speed_mode_tip_select)
    public TextView tvSpeedModeTipSelect;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SpeedModeTipDialog.this.q();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            SpeedModeTipDialog.this.q();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SpeedModeTipDialog.this.dismiss();
            SpeedModeTipDialog.this.d();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SpeedModeTipDialog.this.e();
        }
    }

    public SpeedModeTipDialog(Context context, int i) {
        super(context, i);
        this.f = 0;
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_speed_mode_tip;
    }

    @Override // dc.is3
    public void i() {
        super.i();
        int iF = eg3.f(this.b, "speedModeTip", 0);
        this.f = iF;
        if (iF == 0) {
            this.ivSpeedModeTipSelect.setImageResource(R.drawable.choose_member_unselect);
        } else {
            this.ivSpeedModeTipSelect.setImageResource(R.drawable.choose_member_select);
        }
        this.ivSpeedModeTipSelect.setOnClickListener(new a());
        this.tvSpeedModeTipSelect.setOnClickListener(new b());
        this.tvCancel.setOnClickListener(new c());
        this.tvConfirm.setOnClickListener(new d());
    }

    public final void q() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f == 0) {
            this.f = 1;
            this.ivSpeedModeTipSelect.setImageResource(R.drawable.choose_member_select);
        } else {
            this.f = 0;
            this.ivSpeedModeTipSelect.setImageResource(R.drawable.choose_member_unselect);
        }
        eg3.k(this.b, "speedModeTip", this.f);
    }
}
