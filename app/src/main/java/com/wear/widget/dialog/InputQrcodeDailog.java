package com.wear.widget.dialog;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.lovense.wear.R;
import dc.ce3;
import dc.is3;

/* loaded from: classes4.dex */
public class InputQrcodeDailog extends is3 {

    @BindView(R.id.et_text)
    public EditText etText;
    public b f;

    @BindView(R.id.tv_confirm)
    public TextView tvConfirm;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string = InputQrcodeDailog.this.etText.getText().toString();
            b bVar = InputQrcodeDailog.this.f;
            if (bVar != null) {
                bVar.a(string);
            }
        }
    }

    public interface b {
        void a(String str);
    }

    public InputQrcodeDailog(Context context, int i) {
        super(context, i);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_input_qrcode;
    }

    @Override // dc.is3
    public void h() {
        this.d.setSoftInputMode(16);
        WindowManager.LayoutParams attributes = this.d.getAttributes();
        attributes.width = ce3.a(getContext(), 310.0f);
        attributes.height = -2;
        this.d.setAttributes(attributes);
    }

    @Override // dc.is3
    public void i() {
        this.etText.setFocusable(true);
        this.etText.setFocusableInTouchMode(true);
        this.etText.requestFocus();
        this.tvConfirm.setOnClickListener(new a());
    }

    public void setListener(b bVar) {
        this.f = bVar;
    }
}
