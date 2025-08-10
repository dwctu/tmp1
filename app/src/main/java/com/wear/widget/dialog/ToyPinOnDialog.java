package com.wear.widget.dialog;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.lovense.wear.R;
import dc.ah4;
import dc.is3;

/* loaded from: classes4.dex */
public class ToyPinOnDialog extends is3 {
    public int f;
    public Handler g;
    public Runnable h;
    public c i;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_confirm_time)
    public TextView tvConfirmTime;

    @BindView(R.id.tv_text)
    public TextView tvText;

    @BindView(R.id.tv_title)
    public TextView tvTitle;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ToyPinOnDialog toyPinOnDialog = ToyPinOnDialog.this;
            int i = toyPinOnDialog.f - 1;
            toyPinOnDialog.f = i;
            if (i <= 0) {
                toyPinOnDialog.tvConfirmTime.setText(ah4.e(R.string.common_ok));
                ToyPinOnDialog.this.tvConfirmTime.getBackground().setAlpha(255);
                ToyPinOnDialog.this.tvConfirmTime.setTextColor(Color.parseColor("#ffffff"));
                return;
            }
            toyPinOnDialog.tvConfirmTime.setText(ah4.e(R.string.common_ok) + " (" + ToyPinOnDialog.this.f + ")");
            ToyPinOnDialog toyPinOnDialog2 = ToyPinOnDialog.this;
            toyPinOnDialog2.g.postDelayed(toyPinOnDialog2.h, 1000L);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar;
            ToyPinOnDialog toyPinOnDialog = ToyPinOnDialog.this;
            if (toyPinOnDialog.f > 0 || (cVar = toyPinOnDialog.i) == null) {
                return;
            }
            cVar.doConfirm();
        }
    }

    public interface c {
        void doConfirm();
    }

    public ToyPinOnDialog(Context context, int i) {
        super(context, i);
        this.f = 8;
        this.g = new Handler();
        this.h = new a();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.f = 10;
        this.g.removeCallbacksAndMessages(null);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_toy_pin_on;
    }

    public void setConfirmListener(c cVar) {
        this.i = cVar;
    }

    @Override // dc.is3, android.app.Dialog
    public void show() {
        super.show();
        this.tvConfirmTime.setText(ah4.e(R.string.common_ok) + " (" + this.f + ")");
        this.g.postDelayed(this.h, 1000L);
        this.tvConfirmTime.getBackground().setAlpha(126);
        this.tvConfirmTime.setTextColor(Color.parseColor("#80ffffff"));
        this.tvConfirmTime.setOnClickListener(new b());
    }

    public ToyPinOnDialog(Context context) {
        super(context);
        this.f = 8;
        this.g = new Handler();
        this.h = new a();
    }
}
