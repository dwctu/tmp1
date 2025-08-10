package com.component.dxhttp.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;
import com.component.dxhttp.NetException;
import com.component.dxhttp.R;
import dc.de0;
import dc.ky;
import dc.ly;
import dc.ny;

/* loaded from: classes.dex */
public class TestJavaActivity extends ComponentActivity {

    public class a implements View.OnClickListener {

        /* renamed from: com.component.dxhttp.test.TestJavaActivity$a$a, reason: collision with other inner class name */
        public class C0012a extends ny<String> {
            public C0012a(a aVar) {
            }

            @Override // dc.ny
            public void b(NetException netException) {
                de0.l("http onError == " + netException.getMessage());
            }

            @Override // dc.ny
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void d(String str) {
                de0.l("http onSuccess response");
            }
        }

        public a(TestJavaActivity testJavaActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ky.b("https://test10.lovense-api.com/surfease/common/dict/config/get?key=special_web_site_logo&type=1", null, new C0012a(this));
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestJavaActivity.this.finish();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ly.activity_test);
        Button button = (Button) findViewById(R.id.btnGetRequest);
        button.setText("executeGet form type");
        button.setOnClickListener(new a(this));
        Button button2 = (Button) findViewById(R.id.btnGoToJavaActivity);
        button2.setText("close activity");
        button2.setOnClickListener(new b());
    }
}
