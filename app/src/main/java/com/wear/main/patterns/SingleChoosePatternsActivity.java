package com.wear.main.patterns;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.main.toy.ToyActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.eo3;
import dc.kd0;
import dc.kn3;
import dc.na2;
import dc.pj3;
import dc.rf3;
import dc.sg3;
import dc.sr3;
import dc.tl1;
import dc.xe2;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class SingleChoosePatternsActivity extends BaseActivity {
    public View a;
    public ListView b;
    public RelativeLayout c;
    public TextView d;
    public TextView e;
    public String f;
    public MyApplication g;

    @BindView(R.id.iv_back)
    public ImageView ivBack;

    @BindView(R.id.tv_send)
    public TextView tvSend;
    public List<Pattern> h = new ArrayList();
    public eo3 i = null;
    public boolean j = true;
    public int k = 0;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WearUtils.e1(SingleChoosePatternsActivity.this.f)) {
                sg3.i(SingleChoosePatternsActivity.this, R.string.pattern_selectOne);
                return;
            }
            if (rf3.c(SingleChoosePatternsActivity.this.f)) {
                Pattern patternK = xe2.L0().K(SingleChoosePatternsActivity.this.f);
                if (WearUtils.C0(patternK.getTimer()) < 120) {
                    sg3.k(SingleChoosePatternsActivity.this, ah4.e(R.string.campaign_pattern_too_short));
                    return;
                }
                Intent intent = new Intent(SingleChoosePatternsActivity.this, (Class<?>) SharePatternActivity.class);
                intent.putExtra("patternId", SingleChoosePatternsActivity.this.f);
                intent.putExtra("into_type", SingleChoosePatternsActivity.this.k);
                if (!WearUtils.e1(patternK.getToyFeature()) && patternK.getToyFeature().toLowerCase().equals(Toy.TOY_FEATURE_XMACHINE.toLowerCase())) {
                    intent.putExtra("toyFeature", patternK.getToyFeature());
                }
                SingleChoosePatternsActivity.this.startActivityForResult(intent, 1231);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WearUtils.e1(SingleChoosePatternsActivity.this.f)) {
                sg3.i(SingleChoosePatternsActivity.this, R.string.pattern_selectOne);
            } else if (rf3.c(SingleChoosePatternsActivity.this.f)) {
                Intent intent = new Intent();
                intent.putExtra("choose_patterns", SingleChoosePatternsActivity.this.f);
                SingleChoosePatternsActivity.this.setResult(22, intent);
                SingleChoosePatternsActivity.this.finish();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SingleChoosePatternsActivity.this.finish();
        }
    }

    public class d implements AdapterView.OnItemClickListener {
        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SingleChoosePatternsActivity singleChoosePatternsActivity = SingleChoosePatternsActivity.this;
            singleChoosePatternsActivity.f = singleChoosePatternsActivity.h.get(i).getId();
            SingleChoosePatternsActivity.this.notifyDataSetChanged();
            if (SingleChoosePatternsActivity.this.j) {
                SingleChoosePatternsActivity.this.i.c();
            }
        }
    }

    public class e implements View.OnClickListener {

        public class a implements kn3.d {
            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
                Intent intent = new Intent(SingleChoosePatternsActivity.this, (Class<?>) CreatePatternActivity.class);
                Toy toy = new Toy();
                toy.setName("Ambi");
                toy.synNameToType();
                intent.putExtra("into_type", SingleChoosePatternsActivity.this.k);
                kd0.b("extras_toy", toy);
                intent.putExtra("is_recording_pattern", 1);
                intent.putExtra("min_scond_time", 5);
                SingleChoosePatternsActivity.this.startActivity(intent);
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                pj3.f(SingleChoosePatternsActivity.this, ToyActivity.class);
            }
        }

        public class b implements sr3.c {
            public final /* synthetic */ sr3 a;

            public b(sr3 sr3Var) {
                this.a = sr3Var;
            }

            @Override // dc.sr3.c
            public void a(Toy toy) {
                Intent intent = new Intent(SingleChoosePatternsActivity.this, (Class<?>) CreatePatternActivity.class);
                kd0.b("extras_toy", toy);
                intent.putExtra("is_recording_pattern", 1);
                intent.putExtra("is_create_home", false);
                SingleChoosePatternsActivity.this.startActivity(intent);
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (na2.m().t()) {
                return;
            }
            if (SingleChoosePatternsActivity.this.k != 1) {
                sr3 sr3Var = new sr3(SingleChoosePatternsActivity.this);
                sr3Var.j(new b(sr3Var));
                sr3Var.show();
            } else {
                if (SingleChoosePatternsActivity.this.g.G().P().size() <= 0) {
                    kn3 kn3Var = new kn3((Context) SingleChoosePatternsActivity.this, ah4.e(R.string.notification_create_pattern_no_toy), ah4.e(R.string.connect_now), ah4.e(R.string.button_not_now_1), true, (kn3.d) new a());
                    kn3Var.show();
                    kn3Var.p();
                    return;
                }
                Intent intent = new Intent(SingleChoosePatternsActivity.this, (Class<?>) CreatePatternActivity.class);
                Toy toy = new Toy();
                toy.setName("Ambi");
                toy.synNameToType();
                intent.putExtra("into_type", SingleChoosePatternsActivity.this.k);
                kd0.b("extras_toy", toy);
                intent.putExtra("is_recording_pattern", 1);
                intent.putExtra("min_scond_time", 5);
                SingleChoosePatternsActivity.this.startActivity(intent);
            }
        }
    }

    public class f implements eo3.a {
        public f() {
        }

        @Override // dc.eo3.a
        public void a() {
            SingleChoosePatternsActivity singleChoosePatternsActivity = SingleChoosePatternsActivity.this;
            singleChoosePatternsActivity.f = singleChoosePatternsActivity.i.b().getId();
            SingleChoosePatternsActivity.this.notifyDataSetChanged();
        }
    }

    public final void notifyDataSetChanged() {
        ((tl1) this.b.getAdapter()).notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1231 && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.long_pattern_send);
        ButterKnife.bind(this);
        this.g = (MyApplication) getApplication();
        findViewById(R.id.new_pattern_layout);
        this.a = findViewById(R.id.new_pattern_root);
        this.f = getIntent().getStringExtra("current_pattern_id");
        this.j = getIntent().getBooleanExtra("show_system_patterns", true);
        if (WearUtils.e1(this.f)) {
            this.f = "";
        }
        this.b = (ListView) findViewById(R.id.pattern_list);
        this.c = (RelativeLayout) findViewById(R.id.pattern_list_empty);
        this.d = (TextView) findViewById(R.id.no_pattern_text_content);
        TextView textView = (TextView) findViewById(R.id.choose_patterns_notice);
        this.e = textView;
        textView.setVisibility(8);
        int intExtra = getIntent().getIntExtra("into_type", 0);
        this.k = intExtra;
        if (intExtra == 1) {
            this.j = false;
            this.tvSend.setText(ah4.e(R.string.common_share));
            this.d.setVisibility(8);
            this.tvSend.setOnClickListener(new a());
        } else {
            this.tvSend.setText(ah4.e(R.string.common_done));
            this.d.setVisibility(0);
            this.tvSend.setOnClickListener(new b());
        }
        this.ivBack.setOnClickListener(new c());
        this.b.setAdapter((ListAdapter) new tl1(this, this.g));
        this.b.setOnItemClickListener(new d());
        this.b.setEmptyView(this.c);
        this.a.setOnClickListener(new e());
        if (this.j) {
            this.i = new eo3(this, new f());
        }
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
        if (this.k == 1) {
            this.h = xe2.L0().w(WearUtils.y.r());
        } else {
            this.h = xe2.L0().m(WearUtils.y.r());
        }
        if (this.h == null) {
            this.h = new ArrayList();
        }
        if (this.h.size() > 0 && TextUtils.isEmpty(this.f)) {
            this.f = this.h.get(0).getId();
        }
        notifyDataSetChanged();
    }
}
