package com.wear.main.longDistance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.common.internal.ImagesContract;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHead;
import com.wear.bean.Toy;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.control.CurveLineTimeView;
import com.wear.widget.control.TouchControlVerticalBarView;
import com.wear.widget.control.TouchControlView;
import dc.ah4;
import dc.do3;
import dc.kn3;
import dc.rq1;
import dc.sg3;
import dc.tn2;
import dc.ue3;
import dc.zn2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class RecordSendPatternActivity extends BaseActivity {
    public MyApplication a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String b;
    public Handler c;

    @BindView(R.id.curveTimeLine)
    public CurveLineTimeView curveTimeLine;
    public Pattern f;
    public ProgressDialog h;

    @BindView(R.id.touchView)
    public TouchControlView touchView;

    @BindView(R.id.touchViewControl)
    public TouchControlVerticalBarView touchViewControl;
    public Toy d = null;
    public List<String> e = new ArrayList();
    public String g = "";
    public boolean i = false;

    public class a implements MyActionBar.f {

        /* renamed from: com.wear.main.longDistance.RecordSendPatternActivity$a$a, reason: collision with other inner class name */
        public class C0122a implements kn3.c {
            public final /* synthetic */ do3 a;

            public C0122a(a aVar, do3 do3Var) {
                this.a = do3Var;
            }

            @Override // dc.kn3.c
            public boolean a() {
                WearUtils.e1(this.a.a().getText().toString());
                return true;
            }
        }

        public class b implements kn3.d {
            public final /* synthetic */ do3 a;

            public b(do3 do3Var) {
                this.a = do3Var;
            }

            @Override // dc.kn3.d
            public void doCancel() {
                ue3.a(this.a.a(), RecordSendPatternActivity.this);
            }

            @Override // dc.kn3.d
            public void doConfirm() throws IOException {
                ue3.a(this.a.a(), RecordSendPatternActivity.this);
                RecordSendPatternActivity.this.f.setName(this.a.a().getText().toString());
                RecordSendPatternActivity.this.F4();
            }
        }

        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (RecordSendPatternActivity.this.touchView.getTime() < 3) {
                sg3.i(RecordSendPatternActivity.this, R.string.chat_pattern_timeShort);
                return;
            }
            RecordSendPatternActivity.this.touchView.P();
            RecordSendPatternActivity.this.a.G().W(0);
            do3 do3Var = new do3(RecordSendPatternActivity.this, ah4.e(R.string.common_yes), ah4.e(R.string.common_no));
            do3Var.g(ah4.e(R.string.chat_pattern_command_send_by_create));
            do3Var.i(ah4.e(R.string.pattern_name));
            do3Var.h("");
            do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
            do3Var.b(new C0122a(this, do3Var));
            do3Var.e();
            do3Var.c(new b(do3Var));
        }
    }

    public class b implements TouchControlView.f {
        public b() {
        }

        @Override // com.wear.widget.control.TouchControlView.f
        public void a(List<Toy> list, String str) {
            Iterator<Toy> it = list.iterator();
            String strSubstring = "";
            while (it.hasNext()) {
                strSubstring = strSubstring + it.next().getRealType() + TouchControlView.O;
            }
            if (strSubstring.indexOf(TouchControlView.O) != -1) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            String str2 = "T:" + strSubstring + ";F:" + str;
            ArrayList arrayList = new ArrayList();
            arrayList.add("V:1;T:" + strSubstring + ";F:" + str + ";S:100;M:" + PatternHead.P_M_DEF + ";#" + System.getProperty("line.separator"));
            RecordSendPatternActivity recordSendPatternActivity = RecordSendPatternActivity.this;
            recordSendPatternActivity.g = WearUtils.n2(arrayList, recordSendPatternActivity.f.getId(), false);
            RecordSendPatternActivity recordSendPatternActivity2 = RecordSendPatternActivity.this;
            recordSendPatternActivity2.g = recordSendPatternActivity2.g.replace(PatternHead.P_M_DEF, PatternHead.P_M);
        }

        @Override // com.wear.widget.control.TouchControlView.f
        public void b(boolean z, String str, String str2, String str3, boolean z2, long j) {
            if (z) {
                if (WearUtils.e1(str2) || str2.indexOf(String.valueOf(TouchControlView.Q)) <= 0) {
                    return;
                }
                rq1.d.i();
                RecordSendPatternActivity.this.b = "0," + String.valueOf(TouchControlView.Q);
                RecordSendPatternActivity.this.c.sendEmptyMessage(17);
                return;
            }
            String strG = RecordSendPatternActivity.this.touchView.G(str, str2);
            String str4 = str + " - " + str2 + " - " + strG;
            RecordSendPatternActivity.this.b = strG;
            RecordSendPatternActivity.this.c.sendEmptyMessage(17);
        }
    }

    public class c implements CurveLineTimeView.c {
        public c() {
        }

        @Override // com.wear.widget.control.CurveLineTimeView.c
        public void a(String str) {
            RecordSendPatternActivity.this.touchView.setTapTimeString(str);
        }
    }

    public class d implements TouchControlVerticalBarView.a {
        public d(RecordSendPatternActivity recordSendPatternActivity) {
        }

        @Override // com.wear.widget.control.TouchControlVerticalBarView.a
        public void a(int i) {
        }

        @Override // com.wear.widget.control.TouchControlVerticalBarView.a
        public void b(int i) {
        }

        @Override // com.wear.widget.control.TouchControlVerticalBarView.a
        public void c() {
        }
    }

    public class e implements zn2<String> {
        public e() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            RecordSendPatternActivity.this.h.dismiss();
            if (WearUtils.e1(str)) {
                return;
            }
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (!normalResponse.isResult()) {
                sg3.k(RecordSendPatternActivity.this, normalResponse.getMessage());
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(ImagesContract.URL, normalResponse.getMessage());
            intent.putExtra("name", RecordSendPatternActivity.this.f.getName());
            intent.putExtra("time", WearUtils.Q(RecordSendPatternActivity.this.touchView.getTime()));
            intent.putExtra("toyFunc", Toy.getToyFunction(RecordSendPatternActivity.this.d.getType()));
            RecordSendPatternActivity.this.setResult(-1, intent);
            RecordSendPatternActivity.this.finish();
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(RecordSendPatternActivity.this, netException.getMessage());
        }
    }

    public class f extends Handler {
        public f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 17) {
                return;
            }
            RecordSendPatternActivity.this.e.add(RecordSendPatternActivity.this.b);
            if (RecordSendPatternActivity.this.e.size() >= 500) {
                RecordSendPatternActivity recordSendPatternActivity = RecordSendPatternActivity.this;
                RecordSendPatternActivity.x4(recordSendPatternActivity, WearUtils.n2(recordSendPatternActivity.e, RecordSendPatternActivity.this.f.getId(), true));
                RecordSendPatternActivity.this.e = new ArrayList();
            }
            if (RecordSendPatternActivity.this.e.size() >= 500) {
                RecordSendPatternActivity recordSendPatternActivity2 = RecordSendPatternActivity.this;
                RecordSendPatternActivity.x4(recordSendPatternActivity2, WearUtils.n2(recordSendPatternActivity2.e, RecordSendPatternActivity.this.f.getId(), true));
                RecordSendPatternActivity.this.e = new ArrayList();
            }
        }
    }

    public static /* synthetic */ String x4(RecordSendPatternActivity recordSendPatternActivity, Object obj) {
        String str = recordSendPatternActivity.g + obj;
        recordSendPatternActivity.g = str;
        return str;
    }

    public final void F4() throws IOException {
        this.h = ProgressDialog.show(this, "", ah4.e(R.string.common_uploading), false, true);
        String id = this.f.getId();
        int size = this.e.size() % 10;
        for (int i = 0; i < size; i++) {
            this.e.remove(this.e.size() - 1);
        }
        String str = this.g + WearUtils.n2(this.e, id, true);
        this.g = str;
        WearUtils.l2(id, WearUtils.r0(str));
        tn2.x(WearUtils.x).A("/wear/chat/saveFile/pattern", WearUtils.x0(id), new HashMap(), new e());
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.create_pattern_control);
        ButterKnife.bind(this);
        this.actionbar.setTitle(ah4.e(R.string.pattern_recording));
        this.a = (MyApplication) getApplication();
        if (getIntent().getExtras() != null) {
            this.d = (Toy) getIntent().getExtras().getSerializable("extras_toy");
        }
        if (this.d == null) {
            finish();
        }
        this.f = new Pattern();
        this.c = new f();
        this.actionbar.setYesAction(R.string.common_send, new a());
        this.touchView.setWidget(this.a, this.curveTimeLine);
        this.touchView.setListener(new b());
        this.touchViewControl.a();
        this.touchViewControl.e(this.touchView);
        this.touchViewControl.setManualVisibility(8);
        this.touchView.setFingerAndNoStart(false, this.d);
        this.touchView.setTapTipVisibility(8);
        this.touchView.setCurveLineTvTimeVisibility(8);
        this.curveTimeLine.setTimeCallBack(new c());
        this.touchViewControl.setListener(new d(this));
        this.touchView.Q(60, 60, 30, 60);
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WearUtils.T1(this.f.getId());
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.touchView.P();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.i) {
            return;
        }
        this.touchView.C();
        this.i = true;
    }
}
