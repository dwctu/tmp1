package com.wear.main.toy;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import dc.pj3;
import dc.q61;
import dc.t51;
import dc.u51;
import dc.v51;
import java.util.List;

/* loaded from: classes3.dex */
public class ToyConnectActivity extends BaseActivity implements View.OnClickListener {
    public TextView a;
    public TextView b;

    public class a implements u51 {
        public a() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            ToyConnectActivity.this.finish();
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (!z) {
                ToyConnectActivity.this.finish();
                return;
            }
            Intent intent = new Intent(ToyConnectActivity.this, (Class<?>) ToySearchActivity.class);
            intent.putExtra("isFirstConnect", true);
            ToyConnectActivity.this.startActivity(intent);
            ToyConnectActivity.this.finish();
        }
    }

    public class b implements u51 {
        public b() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            ToyConnectActivity.this.finish();
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (!z) {
                ToyConnectActivity.this.finish();
                return;
            }
            Intent intent = new Intent(ToyConnectActivity.this, (Class<?>) ToySearchActivity.class);
            intent.putExtra("isFirstConnect", true);
            ToyConnectActivity.this.startActivity(intent);
            ToyConnectActivity.this.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel_tv) {
            finish();
            return;
        }
        if (id != R.id.connect_tv) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i > 22 && i <= 30) {
            q61 q61VarM = q61.m(this);
            q61VarM.h("android.permission.ACCESS_FINE_LOCATION");
            q61VarM.h("android.permission.ACCESS_COARSE_LOCATION");
            q61VarM.j(new a());
            return;
        }
        if (i < 31) {
            pj3.f(this, ToyActivity.class);
            finish();
        } else {
            q61 q61VarM2 = q61.m(this);
            q61VarM2.h(v51.a.a);
            q61VarM2.j(new b());
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_toy_connect);
        s4();
    }

    public final void s4() {
        this.a = (TextView) findViewById(R.id.connect_tv);
        this.b = (TextView) findViewById(R.id.cancel_tv);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
    }
}
