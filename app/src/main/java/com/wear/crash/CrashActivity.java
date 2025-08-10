package com.wear.crash;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.broadcom.bt.util.io.IOUtils;
import com.lovense.wear.R;
import com.wear.main.MainActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.dialog.CrashDialog;
import com.wear.widget.dialog.CrashMessageDialog;
import dc.ah4;
import dc.be3;
import dc.cs3;
import dc.gg3;
import dc.is3;
import dc.ye3;
import dc.zn2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class CrashActivity extends Activity {
    public String a = "";
    public String b = "";
    public String c = "";
    public boolean d = false;
    public int e = 0;
    public long f = 0;
    public String g = "";

    public class a implements is3.c {
        public a() {
        }

        @Override // dc.is3.c
        public void doCancel() {
            WearUtils.P1(WearUtils.B0(), false);
            CrashActivity.this.finish();
            MyApplication.D();
        }
    }

    public class b implements is3.d {

        public class a implements zn2<String> {

            /* renamed from: com.wear.crash.CrashActivity$b$a$a, reason: collision with other inner class name */
            public class RunnableC0081a implements Runnable {
                public RunnableC0081a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    CrashActivity.this.e();
                }
            }

            /* renamed from: com.wear.crash.CrashActivity$b$a$b, reason: collision with other inner class name */
            public class RunnableC0082b implements Runnable {
                public RunnableC0082b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    CrashActivity.this.e();
                }
            }

            public a() {
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                CrashActivity.this.runOnUiThread(new RunnableC0081a());
            }

            @Override // dc.zn2
            public void onError(NetException netException) {
                CrashActivity.this.runOnUiThread(new RunnableC0082b());
            }
        }

        public b() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            File file = new File(WearUtils.B0(), CrashActivity.this.a);
            if (file.exists()) {
                ye3.P(CrashActivity.this.c, file, new a());
            } else {
                CrashActivity.this.e();
            }
            CrashActivity.this.finish();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            CrashActivity crashActivity = CrashActivity.this;
            if (jCurrentTimeMillis - crashActivity.f > 1000) {
                crashActivity.e = 0;
                crashActivity.f = System.currentTimeMillis();
                return;
            }
            int i = crashActivity.e + 1;
            crashActivity.e = i;
            if (i < 3 || crashActivity.d) {
                return;
            }
            crashActivity.d = true;
            crashActivity.f();
        }
    }

    public class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            CrashActivity.this.d = false;
        }
    }

    public final void e() {
        WearUtils.P1(WearUtils.B0(), false);
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.addFlags(268435456);
        startActivity(intent);
        MyApplication.D();
    }

    public final void f() {
        String str = this.b;
        if (str == null || str.trim().equals("")) {
            return;
        }
        int iE = gg3.e(this);
        int iC = (gg3.c(this) * 2) / 3;
        String str2 = "filePath:" + WearUtils.P() + "/" + this.a + IOUtils.LINE_SEPARATOR_UNIX + this.b;
        is3.b bVar = new is3.b(this);
        bVar.p(str2);
        bVar.l(true);
        bVar.m(true);
        bVar.x(iE);
        bVar.j(iC);
        CrashMessageDialog crashMessageDialog = (CrashMessageDialog) cs3.i(bVar, CrashMessageDialog.class);
        crashMessageDialog.show();
        crashMessageDialog.setCanceledOnTouchOutside(true);
        crashMessageDialog.setOnCancelListener(new d());
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.d = false;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IOException {
        super.onCreate(bundle);
        this.a = getIntent().getStringExtra("fileName");
        this.b = getIntent().getStringExtra("crashMsg");
        this.c = getIntent().getStringExtra("email");
        this.g = getIntent().getStringExtra("logId");
        this.g = "<br><br>LogId:<font color='#FF2D89'>" + this.g + "</font>";
        if (WearUtils.e1(this.a)) {
            this.a = String.valueOf(be3.I().getTime());
        }
        if (WearUtils.e1(this.c)) {
            this.c = "";
        }
        String str = ah4.e(R.string.crash_tip) + this.g;
        is3.b bVar = new is3.b(this);
        bVar.p(str);
        bVar.d(new b());
        bVar.c(new a());
        bVar.n(ah4.e(R.string.common_exit));
        bVar.o(ah4.e(R.string.common_restartApp));
        CrashDialog crashDialog = (CrashDialog) cs3.i(bVar, CrashDialog.class);
        crashDialog.show();
        crashDialog.setText();
        if (crashDialog.p() != null) {
            crashDialog.p().setOnClickListener(new c());
        }
        File fileP = WearUtils.P();
        if (fileP != null) {
            if (!fileP.exists()) {
                fileP.mkdir();
            }
            File file = new File(WearUtils.P(), this.a);
            if (file.exists() || WearUtils.e1(this.b)) {
                return;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(this.b.getBytes());
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
