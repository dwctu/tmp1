package com.wear.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import com.lovense.wear.R;
import dc.is3;
import dc.pj3;

/* loaded from: classes4.dex */
public class VideoPatternConnectToyDialog extends is3 {

    @BindView(R.id.buy_toys)
    public TextView buyToys;
    public d f;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_confirm)
    public TextView tvConfirm;

    @BindView(R.id.tv_text)
    public TextView tvText;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPatternConnectToyDialog videoPatternConnectToyDialog = VideoPatternConnectToyDialog.this;
            if (videoPatternConnectToyDialog.f != null) {
                pj3.w(videoPatternConnectToyDialog.getContext(), "https://www.lovense.com/public/store?_utm_pro=2106231922");
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPatternConnectToyDialog.this.dismiss();
            d dVar = VideoPatternConnectToyDialog.this.f;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPatternConnectToyDialog.this.dismiss();
            d dVar = VideoPatternConnectToyDialog.this.f;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public interface d {
        void a();

        void b();
    }

    public VideoPatternConnectToyDialog(Context context) {
        super(context);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_lan_api;
    }

    @Override // dc.is3
    public void i() {
        super.i();
        this.buyToys.setOnClickListener(new a());
        this.tvConfirm.setOnClickListener(new b());
        this.tvCancel.setOnClickListener(new c());
    }

    public VideoPatternConnectToyDialog p(d dVar) {
        this.f = dVar;
        return this;
    }
}
