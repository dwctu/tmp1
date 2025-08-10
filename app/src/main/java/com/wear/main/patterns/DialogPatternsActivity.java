package com.wear.main.patterns;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.User;
import com.wear.dao.DaoUtils;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.be3;
import dc.do3;
import dc.hf3;
import dc.kn3;
import dc.na2;
import dc.pj3;
import dc.rf3;
import dc.sg3;
import dc.th4;
import dc.tn2;
import dc.ue3;
import dc.xe2;
import dc.yn2;
import dc.zj1;
import dc.zn2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class DialogPatternsActivity extends BaseActivity {
    public ProgressDialog a;
    public MyApplication b;
    public String d;

    @BindView(R.id.iv_back)
    public TextView ivBack;

    @BindView(R.id.pattern_list)
    public ListView patternList;

    @BindView(R.id.pattern_list_empty)
    public LinearLayout patternListEmpty;

    @BindView(R.id.tv_send)
    public TextView tvSend;
    public HashMap<Integer, String> c = new HashMap<>();
    public User e = null;
    public boolean f = false;
    public List<Pattern> g = new ArrayList();

    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            DialogPatternsActivity dialogPatternsActivity = DialogPatternsActivity.this;
            if (dialogPatternsActivity.f) {
                dialogPatternsActivity.c.clear();
                if (DialogPatternsActivity.this.c.containsKey(Integer.valueOf(i))) {
                    DialogPatternsActivity.this.c.remove(Integer.valueOf(i));
                } else {
                    DialogPatternsActivity.this.c.put(Integer.valueOf(i), DialogPatternsActivity.this.g.get(i).getId());
                }
            } else {
                if (na2.m().i()) {
                    na2.m().t();
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("pattern", DialogPatternsActivity.this.g.get(i));
                bundle.putString("from", "play_back");
                ((xe2) xe2.L0()).J1(DialogPatternsActivity.this.g);
                pj3.g(DialogPatternsActivity.this, PatternPlayActivity.class, bundle);
            }
            DialogPatternsActivity.this.notifyDataSetChanged();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogPatternsActivity dialogPatternsActivity = DialogPatternsActivity.this;
            dialogPatternsActivity.f = true;
            dialogPatternsActivity.c.clear();
            DialogPatternsActivity.this.x4();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogPatternsActivity.this.finish();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ChatLiveControl.q0().r() || ChatSyncControl.N0().r()) {
                na2.m().t();
                return;
            }
            if (DialogPatternsActivity.this.c.entrySet().size() == 0) {
                sg3.i(DialogPatternsActivity.this, R.string.pattern_selectOne);
                return;
            }
            DialogPatternsActivity dialogPatternsActivity = DialogPatternsActivity.this;
            dialogPatternsActivity.a = ProgressDialog.show(dialogPatternsActivity, "", ah4.e(R.string.common_loading), true, false);
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<Integer, String>> it = DialogPatternsActivity.this.c.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            DialogPatternsActivity.this.z4((String) arrayList.get(0));
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogPatternsActivity dialogPatternsActivity = DialogPatternsActivity.this;
            dialogPatternsActivity.f = false;
            dialogPatternsActivity.x4();
        }
    }

    public class f implements kn3.c {
        public final /* synthetic */ do3 a;

        public f(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.c
        public boolean a() {
            String strTrim = this.a.a().getText().toString().trim();
            if (WearUtils.o1(strTrim)) {
                return true;
            }
            sg3.k(DialogPatternsActivity.this, WearUtils.l0(DialogPatternsActivity.this, strTrim));
            return false;
        }
    }

    public class g implements kn3.d {
        public final /* synthetic */ do3 a;
        public final /* synthetic */ Pattern b;

        public class a implements rf3.h {
            public final /* synthetic */ String a;

            /* renamed from: com.wear.main.patterns.DialogPatternsActivity$g$a$a, reason: collision with other inner class name */
            public class RunnableC0132a implements Runnable {
                public final /* synthetic */ String a;

                /* renamed from: com.wear.main.patterns.DialogPatternsActivity$g$a$a$a, reason: collision with other inner class name */
                public class C0133a implements kn3.d {
                    public C0133a() {
                    }

                    @Override // dc.kn3.d
                    public void doCancel() {
                    }

                    @Override // dc.kn3.d
                    public void doConfirm() {
                        DialogPatternsActivity.this.onResume();
                    }
                }

                public RunnableC0132a(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.a.equals(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY)) {
                        rf3.p(DialogPatternsActivity.this, new C0133a());
                    } else {
                        DialogPatternsActivity.this.notifyDataSetChanged();
                    }
                }
            }

            public a(String str) {
                this.a = str;
            }

            @Override // dc.rf3.h
            public void a(boolean z, String str) {
                if (z) {
                    sg3.h(R.string.patterns_result_update_name);
                    g.this.b.setName(this.a);
                    xe2.L0().E(g.this.b, true);
                    DialogPatternsActivity.this.runOnUiThread(new RunnableC0132a(str));
                }
            }
        }

        public g(do3 do3Var, Pattern pattern) {
            this.a = do3Var;
            this.b = pattern;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(this.a.a(), DialogPatternsActivity.this);
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            String strTrim = this.a.a().getText().toString().trim();
            if (this.b.isShared()) {
                rf3.n(this.b.getId(), strTrim, null, null, new a(strTrim));
            } else {
                sg3.i(DialogPatternsActivity.this, R.string.patterns_result_update_name);
                this.b.setName(strTrim);
                xe2.L0().E(this.b, true);
                DialogPatternsActivity.this.notifyDataSetChanged();
            }
            ue3.a(this.a.a(), DialogPatternsActivity.this);
        }
    }

    public class h implements yn2<BaseResponseBean> {
        public h() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBean baseResponseBean) {
            if (baseResponseBean != null) {
                if (baseResponseBean.isResult()) {
                    sg3.i(DialogPatternsActivity.this, R.string.delete_success);
                    return;
                } else {
                    sg3.k(DialogPatternsActivity.this, baseResponseBean.getMessage());
                    return;
                }
            }
            sg3.j(DialogPatternsActivity.this, R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            sg3.k(DialogPatternsActivity.this, netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class i implements zn2<String> {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ String b;

        public i(Pattern pattern, String str) {
            this.a = pattern;
            this.b = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse;
            Intent intent = new Intent();
            intent.putExtra("time", this.a.getTimer());
            intent.putExtra("name", this.a.getName());
            intent.putExtra("toyFunc", this.a.getToyFunc());
            intent.putExtra("patternId", this.b);
            intent.putExtra("localUrl", WearUtils.x0(this.b).getPath());
            if (!WearUtils.e1(str) && (normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class)) != null && normalResponse.isResult()) {
                intent.putExtra(ImagesContract.URL, normalResponse.getMessage());
            }
            DialogPatternsActivity.this.setResult(-1, intent);
            DialogPatternsActivity.this.addAnalyticsEventId("chat_media", null);
            DialogPatternsActivity.this.finish();
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            Intent intent = new Intent();
            intent.putExtra("time", this.a.getTimer());
            intent.putExtra("name", this.a.getName());
            intent.putExtra("toyFunc", this.a.getToyFunc());
            intent.putExtra("patternId", this.b);
            intent.putExtra("localUrl", WearUtils.x0(this.b).getPath());
            DialogPatternsActivity.this.setResult(-1, intent);
            DialogPatternsActivity.this.finish();
        }
    }

    public void A4(String str, String str2, String str3, Pattern pattern) {
        do3 do3Var = new do3(this, ah4.e(R.string.common_save), ah4.e(R.string.common_cancel));
        do3Var.g(str);
        do3Var.i(str2);
        do3Var.h(str3);
        do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        do3Var.b(new f(do3Var));
        do3Var.e();
        do3Var.c(new g(do3Var, pattern));
        do3Var.a().requestFocus();
        ue3.d(do3Var.a(), this);
    }

    public final void notifyDataSetChanged() {
        ((zj1) this.patternList.getAdapter()).notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_dialog_pattern);
        ButterKnife.bind(this);
        this.b = (MyApplication) getApplication();
        String stringExtra = getIntent().getStringExtra("userId");
        this.d = stringExtra;
        String str = WearUtils.e1(stringExtra) ? "" : this.d;
        this.d = str;
        User userV = WearUtils.y.v(str);
        this.e = userV;
        if (userV == null) {
            finish();
            return;
        }
        be3.J();
        this.patternList.setAdapter((ListAdapter) new zj1(this, this.b));
        this.patternList.setOnItemClickListener(new a());
        this.patternList.setEmptyView(this.patternListEmpty);
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        rf3.e();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        List<Pattern> listFindPatternsByEmail = DaoUtils.getMediaPatternDao().findPatternsByEmail(WearUtils.y.r(), this.d);
        this.g = listFindPatternsByEmail;
        if (listFindPatternsByEmail == null) {
            this.g = new ArrayList();
        }
        x4();
    }

    public final void x4() {
        if (this.f) {
            this.ivBack.setText(ah4.e(R.string.common_cancel));
            this.ivBack.setBackground(null);
            this.tvSend.setText(ah4.e(R.string.common_send));
            this.tvSend.setOnClickListener(new d());
            this.ivBack.setOnClickListener(new e());
            if (this.g.size() > 0 && this.c.size() == 0) {
                this.f = true;
                this.c.put(0, this.g.get(0).getId());
            }
        } else {
            this.tvSend.setText(ah4.e(R.string.common_select));
            this.tvSend.setOnClickListener(new b());
            this.ivBack.setOnClickListener(new c());
            this.ivBack.setText("");
            this.ivBack.setBackground(th4.d(this, R.drawable.nav_back));
        }
        if (this.g.size() == 0) {
            this.tvSend.setEnabled(false);
        } else {
            this.tvSend.setEnabled(true);
        }
        notifyDataSetChanged();
    }

    public void y4(Pattern pattern) {
        if (pattern != null) {
            if ((pattern == null || !WearUtils.e1(pattern.getId())) && !WearUtils.e1(WearUtils.y.r())) {
                if (pattern.isShared() && !hf3.d(this)) {
                    sg3.h(R.string.net_connect_error_tip);
                    return;
                }
                xe2.L0().d(pattern, true);
                DaoUtils.getMediaPatternDao().delById(pattern.getId());
                this.g.remove(pattern);
                x4();
                if (pattern.isShared() && !WearUtils.e1(pattern.getCreator()) && pattern.getCreator().equals(WearUtils.y.r())) {
                    HashMap map = new HashMap();
                    map.put(TtmlNode.ATTR_ID, pattern.getId());
                    tn2.x(WearUtils.x).i("/wear/pattern/delete", map, new h());
                }
            }
        }
    }

    public final void z4(String str) {
        Pattern patternK = xe2.L0().K(str);
        tn2.x(WearUtils.x).A("/wear/chat/saveFile/pattern", WearUtils.x0(str), new HashMap(), new i(patternK, str));
    }
}
