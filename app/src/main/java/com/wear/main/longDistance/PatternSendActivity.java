package com.wear.main.longDistance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.eo3;
import dc.je3;
import dc.kd0;
import dc.na2;
import dc.pj3;
import dc.rf3;
import dc.sg3;
import dc.sl1;
import dc.sr3;
import dc.xe2;
import dc.ye3;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class PatternSendActivity extends BaseActivity {
    public ListView a;
    public RelativeLayout b;
    public String c;
    public ProgressDialog d;
    public int e = -1;
    public List<Pattern> f = new ArrayList();
    public eo3 g = null;
    public TextView h;

    public class a implements View.OnClickListener {

        /* renamed from: com.wear.main.longDistance.PatternSendActivity$a$a, reason: collision with other inner class name */
        public class C0121a implements rf3.i {
            public C0121a() {
            }

            @Override // dc.rf3.i
            public void onError(NetException netException) {
                ye3.d("S0003", "pattern 文件上传失败啦" + je3.a(netException));
                PatternSendActivity.this.d.dismiss();
                Intent intent = new Intent();
                Pattern patternK = xe2.L0().K(PatternSendActivity.this.c);
                intent.putExtra("time", patternK.getTimer());
                intent.putExtra("name", patternK.getName());
                intent.putExtra("toyFunc", patternK.getToyFunc());
                intent.putExtra("patternId", PatternSendActivity.this.c);
                intent.putExtra("localUrl", WearUtils.x0(PatternSendActivity.this.c).getPath());
                PatternSendActivity.this.setResult(-1, intent);
                PatternSendActivity.this.finish();
            }

            @Override // dc.rf3.i
            public void onSuccess(String str) {
                NormalResponse normalResponse;
                PatternSendActivity.this.d.dismiss();
                Intent intent = new Intent();
                Pattern patternK = xe2.L0().K(PatternSendActivity.this.c);
                intent.putExtra("time", patternK.getTimer());
                intent.putExtra("name", patternK.getName());
                intent.putExtra("toyFunc", patternK.getToyFunc());
                intent.putExtra("patternId", PatternSendActivity.this.c);
                intent.putExtra("localUrl", WearUtils.x0(PatternSendActivity.this.c).getPath());
                intent.putExtra("toyVersion", patternK.getToyVersion());
                if (!WearUtils.e1(str) && (normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class)) != null && normalResponse.isResult()) {
                    intent.putExtra(ImagesContract.URL, normalResponse.getMessage());
                }
                PatternSendActivity.this.setResult(-1, intent);
                PatternSendActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WearUtils.e1(PatternSendActivity.this.c)) {
                sg3.i(PatternSendActivity.this, R.string.pattern_selectOne);
                return;
            }
            if (PatternSendActivity.this.g.b() != null) {
                PatternSendActivity patternSendActivity = PatternSendActivity.this;
                patternSendActivity.c = patternSendActivity.g.b().getId();
            }
            if (rf3.c(PatternSendActivity.this.c)) {
                PatternSendActivity patternSendActivity2 = PatternSendActivity.this;
                patternSendActivity2.d = ProgressDialog.show(patternSendActivity2, "", ah4.e(R.string.common_loading), false, true);
                rf3.s(WearUtils.x0(PatternSendActivity.this.c), new C0121a());
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PatternSendActivity.this.finish();
        }
    }

    public class c implements View.OnClickListener {

        public class a implements sr3.c {
            public final /* synthetic */ sr3 a;

            public a(sr3 sr3Var) {
                this.a = sr3Var;
            }

            @Override // dc.sr3.c
            public void a(Toy toy) {
                kd0.b("extras_toy", toy);
                Intent intent = new Intent(PatternSendActivity.this, (Class<?>) CreatePatternActivity.class);
                intent.putExtra("is_recording_pattern", 1);
                intent.putExtra("is_create_home", false);
                PatternSendActivity.this.startActivity(intent);
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WearUtils.y.u() == null) {
                pj3.f(PatternSendActivity.this, LoginActivity.class);
                PatternSendActivity.this.finish();
            } else {
                if (na2.m().i()) {
                    na2.m().t();
                    return;
                }
                sr3 sr3Var = new sr3(PatternSendActivity.this);
                sr3Var.j(new a(sr3Var));
                sr3Var.show();
            }
        }
    }

    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PatternSendActivity patternSendActivity = PatternSendActivity.this;
            patternSendActivity.c = patternSendActivity.f.get(i).getId();
            PatternSendActivity patternSendActivity2 = PatternSendActivity.this;
            patternSendActivity2.e = i;
            patternSendActivity2.notifyDataSetChanged();
            PatternSendActivity.this.g.c();
        }
    }

    public class e implements eo3.a {
        public e() {
        }

        @Override // dc.eo3.a
        public void a() {
            PatternSendActivity patternSendActivity = PatternSendActivity.this;
            patternSendActivity.c = patternSendActivity.g.b().getId();
            PatternSendActivity patternSendActivity2 = PatternSendActivity.this;
            patternSendActivity2.e = -1;
            patternSendActivity2.notifyDataSetChanged();
        }
    }

    public final void notifyDataSetChanged() {
        if (WearUtils.e1(this.c)) {
            this.h.setEnabled(false);
        } else {
            this.h.setEnabled(true);
        }
        ((sl1) this.a.getAdapter()).notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 4130 && i2 == -1 && intent != null) {
            try {
                String stringExtra = intent.getStringExtra(ImagesContract.URL);
                String stringExtra2 = intent.getStringExtra("time");
                String stringExtra3 = intent.getStringExtra("name");
                String stringExtra4 = intent.getStringExtra("toyFunc");
                String stringExtra5 = intent.getStringExtra("patternId");
                String stringExtra6 = intent.getStringExtra("localUrl");
                if (rf3.c(stringExtra5)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra(ImagesContract.URL, stringExtra);
                    intent2.putExtra("time", stringExtra2);
                    intent2.putExtra("name", stringExtra3);
                    intent2.putExtra("toyFunc", stringExtra4);
                    intent2.putExtra("patternId", stringExtra5);
                    intent2.putExtra("isFromChat", 1);
                    intent2.putExtra("localUrl", stringExtra6);
                    setResult(-1, intent2);
                    finish();
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.long_pattern_send);
        this.application = (MyApplication) getApplication();
        TextView textView = (TextView) findViewById(R.id.tv_send);
        this.h = textView;
        textView.setOnClickListener(new a());
        findViewById(R.id.iv_back).setOnClickListener(new b());
        this.a = (ListView) findViewById(R.id.pattern_list);
        this.b = (RelativeLayout) findViewById(R.id.pattern_list_empty);
        findViewById(R.id.new_pattern_layout).setOnClickListener(new c());
        this.a.setAdapter((ListAdapter) new sl1(this));
        this.a.setOnItemClickListener(new d());
        this.a.setEmptyView(this.b);
        this.g = new eo3(this, new e());
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<Pattern> listM = xe2.L0().m(WearUtils.y.r());
        this.f = listM;
        if (listM == null) {
            this.f = new ArrayList();
        }
        if (this.f.size() > 0 && WearUtils.e1(this.c)) {
            this.e = 0;
            this.c = this.f.get(0).getId();
        }
        notifyDataSetChanged();
    }
}
