package com.wear.widget.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import com.lovense.wear.R;
import dc.is3;
import java.util.List;

/* loaded from: classes4.dex */
public class LanApiUpdateToyDailog extends is3 {
    public AppCompatTextView f;
    public AppCompatTextView g;
    public b h;

    @BindView(R.id.tv_cancel)
    public TextView tvCancel;

    @BindView(R.id.tv_confirm)
    public TextView tvConfirm;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = LanApiUpdateToyDailog.this.h;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();
    }

    public LanApiUpdateToyDailog(Context context) {
        super(context);
    }

    @Override // dc.is3
    public int g() {
        return R.layout.dialog_lan_api_toy_update;
    }

    @Override // dc.is3
    public void i() {
        super.i();
        this.tvCancel.setOnClickListener(new a());
        this.f = (AppCompatTextView) findViewById(R.id.toy_1);
        this.g = (AppCompatTextView) findViewById(R.id.toy_2);
    }

    public void setListener(b bVar) {
        this.h = bVar;
    }

    public void setShowToyName(List<String> list) {
        if (list.size() <= 1) {
            this.f.setVisibility(0);
            this.g.setVisibility(8);
            this.f.setText(list.get(0));
        } else {
            this.f.setVisibility(0);
            this.g.setVisibility(0);
            this.f.setText(list.get(0));
            this.g.setText(list.get(1));
        }
    }
}
