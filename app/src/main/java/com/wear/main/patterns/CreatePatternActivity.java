package com.wear.main.patterns;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.CreatePatternRecordBean;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHead;
import com.wear.bean.Toy;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.home.pattern.NewPatternActivity;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.control.multiToys.MultiControlPanel;
import com.wear.widget.control.multiToys.MultiCurveLineView;
import com.wear.widget.velvo.VelvoPreviewView;
import dc.ToyControlBuilder;
import dc.ah4;
import dc.cs3;
import dc.dk2;
import dc.do3;
import dc.ek2;
import dc.fk2;
import dc.ip3;
import dc.is3;
import dc.jp3;
import dc.kd0;
import dc.kn3;
import dc.mk2;
import dc.mp1;
import dc.ou3;
import dc.pc1;
import dc.pj3;
import dc.qq1;
import dc.rf3;
import dc.sg3;
import dc.ue3;
import dc.vg3;
import dc.vu1;
import dc.wq1;
import dc.xe2;
import dc.ye3;
import dc.zt3;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class CreatePatternActivity extends BaseActivity {

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public do3 c;
    public MyApplication d;
    public String e;
    public Handler f;
    public Pattern h;

    @BindView(R.id.multi_control_panel)
    public MultiControlPanel multiControlPanel;
    public Disposable s;
    public boolean t;
    public Dialog v;

    @BindView(R.id.velvo_preview)
    public VelvoPreviewView velvoPreviewView;
    public s w;
    public ProgressDialog x;
    public List<Toy> y;
    public jp3 z;
    public boolean a = false;
    public String b = "";
    public List<String> g = new ArrayList();
    public String i = "";
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public Toy m = null;
    public int n = -1;
    public int o = 0;
    public int p = 0;
    public boolean q = false;
    public int u = ek2.POSITION.ordinal();

    public class a implements kn3.d {
        public final /* synthetic */ do3 a;

        public a(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            CreatePatternActivity.this.multiControlPanel.h0();
            CreatePatternActivity.this.m5();
            ue3.a(this.a.a(), CreatePatternActivity.this);
            CreatePatternActivity.this.t = false;
        }

        @Override // dc.kn3.d
        public void doConfirm() throws IOException {
            ue3.a(this.a.a(), CreatePatternActivity.this);
            CreatePatternActivity.this.t = false;
            CreatePatternActivity.this.g5(this.a.a().getText().toString().trim());
        }
    }

    public class b implements kn3.c {
        public b() {
        }

        @Override // dc.kn3.c
        public boolean a() {
            String strTrim = CreatePatternActivity.this.c.a().getText().toString().trim();
            if (WearUtils.o1(strTrim)) {
                return true;
            }
            sg3.k(CreatePatternActivity.this, WearUtils.l0(CreatePatternActivity.this, strTrim));
            return false;
        }
    }

    public class c implements kn3.d {
        public c() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(CreatePatternActivity.this.c.a(), CreatePatternActivity.this);
            CreatePatternActivity.this.t = false;
            if (!WearUtils.e1(CreatePatternActivity.this.c.a().getText().toString())) {
                CreatePatternActivity createPatternActivity = CreatePatternActivity.this;
                createPatternActivity.b = createPatternActivity.c.a().getText().toString().trim();
            }
            if (CreatePatternActivity.this.q) {
                CreatePatternActivity.this.i5();
            } else {
                CreatePatternActivity.this.multiControlPanel.h0();
                CreatePatternActivity.this.m5();
            }
        }

        @Override // dc.kn3.d
        public void doConfirm() throws IOException {
            ue3.a(CreatePatternActivity.this.c.a(), CreatePatternActivity.this);
            CreatePatternActivity.this.t = false;
            CreatePatternActivity createPatternActivity = CreatePatternActivity.this;
            createPatternActivity.b = createPatternActivity.c.a().getText().toString().trim();
            CreatePatternActivity createPatternActivity2 = CreatePatternActivity.this;
            createPatternActivity2.g5(createPatternActivity2.b);
        }
    }

    public class d implements kn3.d {
        public d() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
            CreatePatternActivity.this.l5();
            ue3.d(CreatePatternActivity.this.c.a(), CreatePatternActivity.this);
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            ue3.a(CreatePatternActivity.this.c.a(), CreatePatternActivity.this);
            CreatePatternActivity.this.setResult(-1, new Intent());
            CreatePatternActivity.this.finish();
        }
    }

    public class e implements kn3.c {
        public final /* synthetic */ do3 a;

        public e(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.c
        public boolean a() {
            String strTrim = this.a.a().getText().toString().trim();
            if (WearUtils.o1(strTrim)) {
                return true;
            }
            sg3.k(CreatePatternActivity.this, WearUtils.l0(CreatePatternActivity.this, strTrim));
            return false;
        }
    }

    public class f implements kn3.d {
        public final /* synthetic */ do3 a;

        public f(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(this.a.a(), CreatePatternActivity.this);
            CreatePatternActivity.this.t = false;
        }

        @Override // dc.kn3.d
        public void doConfirm() throws IOException {
            ue3.a(this.a.a(), CreatePatternActivity.this);
            CreatePatternActivity.this.t = false;
            CreatePatternActivity.this.g5(this.a.a().getText().toString().trim());
        }
    }

    public class g implements rf3.i {
        public final /* synthetic */ String a;

        public g(String str) {
            this.a = str;
        }

        @Override // dc.rf3.i
        public void onError(NetException netException) {
            CreatePatternActivity.this.x.dismiss();
            Intent intent = new Intent();
            intent.putExtra("time", CreatePatternActivity.this.h.getTimer());
            intent.putExtra("name", CreatePatternActivity.this.h.getName());
            intent.putExtra("toyFunc", CreatePatternActivity.this.h.getToyFunc());
            intent.putExtra("patternId", this.a);
            intent.putExtra("localUrl", WearUtils.x0(this.a).getPath());
            CreatePatternActivity.this.setResult(-1, intent);
            CreatePatternActivity.this.finish();
        }

        @Override // dc.rf3.i
        public void onSuccess(String str) {
            NormalResponse normalResponse;
            CreatePatternActivity.this.x.dismiss();
            Pattern patternK = xe2.L0().K(this.a);
            Intent intent = new Intent();
            intent.putExtra("time", patternK.getTimer());
            intent.putExtra("name", patternK.getName());
            intent.putExtra("toyFunc", patternK.getToyFunc());
            intent.putExtra("patternId", this.a);
            intent.putExtra("localUrl", WearUtils.x0(this.a).getPath());
            if (!WearUtils.e1(str) && (normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class)) != null && normalResponse.isResult()) {
                intent.putExtra(ImagesContract.URL, normalResponse.getMessage());
            }
            CreatePatternActivity.this.setResult(-1, intent);
            CreatePatternActivity.this.finish();
        }
    }

    public class h implements MyActionBar.f {
        public h() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (CreatePatternActivity.this.multiControlPanel.getTime() < (CreatePatternActivity.this.n == -1 ? 5 : CreatePatternActivity.this.n)) {
                sg3.i(CreatePatternActivity.this, R.string.chat_pattern_timeShort);
            } else {
                CreatePatternActivity.this.j5();
            }
        }
    }

    public class i implements MyActionBar.f {
        public i() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (CreatePatternActivity.this.multiControlPanel.getTime() < (CreatePatternActivity.this.n == -1 ? 5 : CreatePatternActivity.this.n)) {
                CreatePatternActivity.this.multiControlPanel.b0();
                sg3.i(CreatePatternActivity.this, R.string.chat_pattern_timeShort);
                return;
            }
            Pattern patternK = xe2.L0().K(CreatePatternActivity.this.h.getId());
            if (patternK == null) {
                CreatePatternActivity.this.l5();
            } else {
                CreatePatternActivity.this.h5(patternK.getId());
            }
        }
    }

    public class j implements MyActionBar.f {
        public j() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            CreatePatternActivity.this.finish();
        }
    }

    public class k implements r {
        public k() {
        }

        @Override // com.wear.main.patterns.CreatePatternActivity.r
        public void a(String str) {
            CreatePatternActivity.this.e = str;
            CreatePatternActivity.this.f.sendEmptyMessage(17);
        }
    }

    public class l implements MultiControlPanel.r {
        public l() {
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
        public /* synthetic */ void b(String str) {
            ip3.a(this, str);
        }

        @Override // com.wear.widget.control.multiToys.MultiControlPanel.r
        public void f(List<Ball2CurveEventBean> list) {
            if (CreatePatternActivity.this.z != null) {
                CreatePatternActivity.this.z.k(list);
            }
            CreatePatternActivity.this.w.f(list);
            vg3.b().a(CreatePatternActivity.this.w);
        }
    }

    public class m extends HashMap<String, String> {
        public final /* synthetic */ String val$finalFunctions;

        public m(String str) {
            this.val$finalFunctions = str;
            put("type", str);
            put("time", "10");
        }
    }

    public class n implements Consumer<Long> {
        public n() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) throws Exception {
            CreatePatternActivity.O4(CreatePatternActivity.this);
            if (CreatePatternActivity.this.p / 10 > 3599) {
                CreatePatternActivity.this.q = true;
                if (CreatePatternActivity.this.k) {
                    CreatePatternActivity.this.l5();
                } else {
                    CreatePatternActivity.this.k5(false);
                }
            }
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CreatePatternActivity.this.d.G().u0();
        }
    }

    public class p implements kn3.c {
        public final /* synthetic */ do3 a;

        public p(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.c
        public boolean a() {
            String strTrim = this.a.a().getText().toString().trim();
            if (WearUtils.o1(strTrim)) {
                return true;
            }
            sg3.k(CreatePatternActivity.this, WearUtils.l0(CreatePatternActivity.this, strTrim));
            return false;
        }
    }

    public class q extends Handler {
        public q() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 17 && !CreatePatternActivity.this.q) {
                if ("pos".equals(CreatePatternActivity.this.h.getToyTag()) && WearUtils.n1(CreatePatternActivity.this.e)) {
                    CreatePatternActivity createPatternActivity = CreatePatternActivity.this;
                    createPatternActivity.e = String.valueOf(Integer.parseInt(createPatternActivity.e) / 5);
                }
                CreatePatternActivity.this.g.add(CreatePatternActivity.this.e);
                if (CreatePatternActivity.this.g.size() >= 500) {
                    CreatePatternActivity createPatternActivity2 = CreatePatternActivity.this;
                    CreatePatternActivity.E4(createPatternActivity2, WearUtils.n2(createPatternActivity2.g, CreatePatternActivity.this.h.getId(), true));
                    CreatePatternActivity.this.g = new ArrayList();
                    if (CreatePatternActivity.this.j) {
                        CreatePatternActivity.this.q = true;
                        CreatePatternActivity.this.k5(true);
                    }
                }
            }
        }
    }

    public interface r {
        void a(String str);
    }

    public static class s implements Runnable {
        public r b;
        public Pattern c;
        public List<Ball2CurveEventBean> a = new ArrayList();
        public int d = 5;
        public Map<String, CreatePatternRecordBean> e = new HashMap();

        public s(Pattern pattern, r rVar) {
            this.b = rVar;
            this.c = pattern;
        }

        public final boolean a(String str, ArrayList<String> arrayList) {
            CreatePatternRecordBean createPatternRecordBean = this.e.containsKey(str) ? this.e.get(str) : null;
            if (createPatternRecordBean == null) {
                this.e.put(str, new CreatePatternRecordBean(1, arrayList));
                return true;
            }
            if (createPatternRecordBean.getGroups().size() != arrayList.size()) {
                createPatternRecordBean.reset(1, arrayList);
                return true;
            }
            for (int i = 0; i < createPatternRecordBean.getGroups().size(); i++) {
                if (!TextUtils.equals(createPatternRecordBean.getGroups().get(i), arrayList.get(i))) {
                    createPatternRecordBean.reset(1, arrayList);
                    return true;
                }
            }
            if (createPatternRecordBean.getCount() >= this.d) {
                return false;
            }
            createPatternRecordBean.setCount(createPatternRecordBean.getCount() + 1);
            return true;
        }

        public final void b(Toy toy, List<Ball2CurveEventBean> list, Pattern pattern) throws NumberFormatException {
            String address = toy.getAddress();
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Ball2CurveEventBean ball2CurveEventBean = list.get(i);
                if (ball2CurveEventBean != null) {
                    String function = ball2CurveEventBean.getFunction();
                    if (TextUtils.equals(function, "pos") || TextUtils.equals(function, "t")) {
                        String groups = ball2CurveEventBean.getGroups();
                        if (TextUtils.isEmpty(groups)) {
                            return;
                        }
                        arrayList.add(groups);
                        if (a(address, arrayList)) {
                            int i2 = Integer.parseInt(groups);
                            if (list.get(i).getFunction().equals("pos") && !WearUtils.e1(pattern.getToyTag()) && pattern.getToyTag().equals("pos")) {
                                dk2.a.e(toy.getAddress(), i2, true);
                                return;
                            } else {
                                pc1.a.d0(toy, i2, true, true);
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }

        public final void c(Toy toy, List<Ball2CurveEventBean> list) {
            List<List<String>> motors = toy.getMotors();
            if (motors == null || motors.isEmpty()) {
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < motors.size(); i++) {
                List<String> list2 = motors.get(i);
                toy.isH01Toy();
                for (String str : list2) {
                    for (Ball2CurveEventBean ball2CurveEventBean : list) {
                        if (ball2CurveEventBean != null) {
                            if (ball2CurveEventBean.isRotateChange()) {
                                toy.setDirection(!toy.isDirection());
                            } else if (TextUtils.equals(str, ball2CurveEventBean.getFunction())) {
                                String strC = vu1.c(toy.getAndUpdateDeviceId(), str, Toy.changeSinglefuncLineToTayValue(str, ball2CurveEventBean.getGroups()));
                                if (arrayList.size() == i) {
                                    arrayList.add(i, strC);
                                } else {
                                    arrayList.set(i, strC);
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() == i) {
                    arrayList.add("-1");
                }
            }
            if (a(toy.getAddress(), arrayList)) {
                pc1.a.l0(toy.getAddress(), arrayList, false, false);
            }
        }

        public final void d(Toy toy, List<Ball2CurveEventBean> list) {
            List<List<String>> motors = toy.getMotors();
            if (motors == null || motors.isEmpty()) {
                return;
            }
            String multiplayOrder = toy.getMultiplayOrder();
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i = 0; i < motors.size(); i++) {
                List<String> list2 = motors.get(i);
                String strC = toy.isH01Toy() ? "0" : "-1";
                for (String str : list2) {
                    for (Ball2CurveEventBean ball2CurveEventBean : list) {
                        if (ball2CurveEventBean != null && TextUtils.equals(str, ball2CurveEventBean.getFunction())) {
                            strC = vu1.c(toy.getAndUpdateDeviceId(), str, Toy.changeSinglefuncLineToTayValue(str, ball2CurveEventBean.getGroups()));
                            if (arrayList.size() == i) {
                                arrayList.add(i, strC);
                            } else if (!TextUtils.equals(strC, arrayList.get(i))) {
                                arrayList.set(i, strC);
                            }
                        }
                    }
                }
                if (arrayList.size() == i) {
                    arrayList.add(i, strC);
                }
                multiplayOrder = multiplayOrder + SignatureImpl.INNER_SEP + strC;
            }
            if (a(toy.getAddress(), arrayList)) {
                pc1.a.e(toy.getAddress(), multiplayOrder + ";");
            }
        }

        public final void e(Toy toy, List<Ball2CurveEventBean> list) {
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList arrayList2 = new ArrayList();
            List<List<String>> motors = toy.getMotors();
            for (int i = 0; i < motors.size(); i++) {
                Iterator<String> it = motors.get(i).iterator();
                String str = "";
                String strC = "-1";
                while (it.hasNext()) {
                    String next = it.next();
                    for (Ball2CurveEventBean ball2CurveEventBean : list) {
                        if (ball2CurveEventBean != null && TextUtils.equals(next, ball2CurveEventBean.getFunction())) {
                            if (Toy.getToyFunction(toy.getType()).contains(next)) {
                                str = next;
                            } else if (TextUtils.equals(next, "v1")) {
                                str = PSOProgramService.VS_Key;
                            }
                            Toy.changeSinglefuncLineToTayValue(str, ball2CurveEventBean.getGroups());
                            strC = vu1.c(toy.getAndUpdateDeviceId(), str, Toy.changeSinglefuncLineToTayValue(str, ball2CurveEventBean.getGroups()));
                            if (arrayList.size() == i) {
                                arrayList.add(i, strC);
                            } else if (!TextUtils.equals(strC, arrayList.get(i))) {
                                arrayList.set(i, strC);
                            }
                            next = str;
                        }
                    }
                }
                if (arrayList.size() == i) {
                    arrayList.add("-1");
                }
                String[] strArr = Toy.TOY_OPERATION.get(str);
                if (strArr != null) {
                    arrayList2.add(strArr[0].replace("#", strC));
                }
            }
            if (a(toy.getAddress(), arrayList)) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    pc1.a.i0(toy.getAddress(), (String) it2.next());
                }
            }
        }

        public void f(List<Ball2CurveEventBean> list) {
            this.a.clear();
            this.a.addAll(list);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.a.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.a);
                if (mp1.h()) {
                    wq1.b(arrayList, new ToyControlBuilder(true, true, false, ToyControlBuilder.a.SETTING_FIRST));
                    String strA = qq1.a(arrayList);
                    if (this.b == null || TextUtils.isEmpty(strA)) {
                        return;
                    }
                    this.b.a(strA);
                    return;
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                Iterator<Toy> it = pc1.a.P().iterator();
                while (it.hasNext()) {
                    Toy next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.getAddress())) {
                        if (next.isBAToy() || WearUtils.e1(this.c.getToyTag()) || !this.c.getToyTag().equals("pos")) {
                            if (next.isBAToy()) {
                                b(next, arrayList, this.c);
                            } else if (next.isMultiplyInstruct()) {
                                d(next, arrayList);
                            } else if (next.isSupportLVS()) {
                                c(next, arrayList);
                            } else {
                                e(next, arrayList);
                            }
                        }
                    }
                    return;
                }
                String strA2 = qq1.a(arrayList);
                if (this.b == null || TextUtils.isEmpty(strA2)) {
                    return;
                }
                this.b.a(strA2);
            } catch (Exception e) {
                e.printStackTrace();
                FirebaseCrashlytics.getInstance().recordException(new Throwable("指令处理crash", e));
            }
        }
    }

    public static /* synthetic */ String E4(CreatePatternActivity createPatternActivity, Object obj) {
        String str = createPatternActivity.i + obj;
        createPatternActivity.i = str;
        return str;
    }

    public static /* synthetic */ int O4(CreatePatternActivity createPatternActivity) {
        int i2 = createPatternActivity.p;
        createPatternActivity.p = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W4(Function0 function0) {
        ou3.c();
        X4();
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a5(final Function0 function0) {
        if (this.h != null) {
            if (T4() <= 5) {
                function0.invoke();
                return;
            }
            this.multiControlPanel.W();
            n5();
            if (!this.m.isBAToy() || this.u != ek2.POSITION.ordinal()) {
                this.d.G().u0();
            }
            is3 is3VarD = cs3.d(this, ah4.e(R.string.tip_create_pattern_change_function), ah4.e(R.string.common_yes), ah4.e(R.string.common_no), new is3.d() { // from class: dc.sd2
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.W4(function0);
                }
            }, new is3.c() { // from class: dc.rd2
                @Override // dc.is3.c
                public final void doCancel() {
                    this.a.Y4();
                }
            });
            this.v = is3VarD;
            is3VarD.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e5(String str) {
        this.z.m(str);
    }

    public final void R4() {
        List<String> list = this.g;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.g.clear();
    }

    public final void S4() {
        Disposable disposable = this.s;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.s.dispose();
        this.s = null;
    }

    public final int T4() {
        List<String> list;
        if (this.h == null || (list = this.g) == null) {
            return 0;
        }
        int size = this.p - (list.size() % 10);
        int iFloor = (int) Math.floor(size * 0.1f);
        return size % 10 != 0 ? iFloor + 1 : iFloor;
    }

    /* renamed from: U4, reason: merged with bridge method [inline-methods] */
    public final void c5() throws IOException {
        WearUtils.x.G().u0();
        WearUtils.U1(this.h.getId());
        S4();
        R4();
        this.p = 0;
        m5();
        String realType = this.m.getRealType();
        String str = "pattern的类型===" + realType;
        Toy.TOY_XMACHINE.equalsIgnoreCase(realType);
        String toyFunction = Toy.getToyFunction(this.m.getType());
        if (this.m.isF01Toy()) {
            toyFunction = "t";
        }
        if (this.m.isQ01Toy()) {
            this.h.setToyTag("s");
            toyFunction = "s";
        }
        if (this.m.isBAToy()) {
            ek2 ek2VarC = fk2.a.c(this.m.getAddress());
            ek2 ek2Var = ek2.POSITION;
            int iOrdinal = ek2VarC == ek2Var ? ek2Var.ordinal() : ek2.SPEED.ordinal();
            this.u = iOrdinal;
            String str2 = iOrdinal == ek2Var.ordinal() ? "pos" : "t";
            this.h.setToyTag(str2);
            toyFunction = str2;
        }
        String str3 = "T:" + realType + ";F:" + toyFunction;
        addAnalyticsEventId("pattern_local_create", new m(toyFunction));
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("V:1;T:");
        sb.append(realType);
        sb.append(";F:");
        sb.append(toyFunction);
        sb.append(";S:");
        sb.append(100);
        sb.append(";M:");
        sb.append(PatternHead.P_M_DEF);
        sb.append(this.o == 1 ? ";A:y" : "");
        sb.append(";#");
        sb.append(System.getProperty("line.separator"));
        arrayList.add(sb.toString());
        String strN2 = WearUtils.n2(arrayList, this.h.getId(), false);
        this.i = strN2;
        this.i = strN2.replace(PatternHead.P_M_DEF, PatternHead.P_M);
    }

    public final void f5() {
        this.multiControlPanel.W();
        n5();
        ou3.c();
        this.d.G().u0();
    }

    public final void g5(String str) throws IOException {
        int size = this.g.size() % 10;
        for (int i2 = 0; i2 < size; i2++) {
            this.g.remove(this.g.size() - 1);
        }
        int i3 = this.p - size;
        this.i += WearUtils.n2(this.g, this.h.getId(), true);
        String str2 = "patternString===" + this.i;
        String str3 = "dataString===" + this.g;
        this.h.setName(str);
        this.h.setEmail(WearUtils.y.r());
        this.h.setCreator(WearUtils.y.r());
        this.h.setToyName(this.m.getShowName());
        String generationVersion = this.m.getGenerationVersion();
        this.h.setToyVersion(String.valueOf(WearUtils.e1(generationVersion) ? 1 : Integer.parseInt(generationVersion)));
        List<String> symbol = this.m.getToyConfigDataBean().getSymbol();
        if (symbol != null && symbol.size() > 0) {
            this.h.setToySymbol(symbol.get(0));
        }
        MyApplication myApplication = WearUtils.x;
        if (MyApplication.Z) {
            this.h.setAuthor("");
        } else if (WearUtils.y.u() == null) {
            this.h.setAuthor(zt3.k);
        } else {
            this.h.setAuthor(WearUtils.y.u().getUserName());
        }
        Pattern pattern = this.h;
        pattern.setTimer(pattern.calculateTime(i3, 100));
        this.h.setToyFunc(Toy.getToyFunction(this.m.getType()));
        if (this.m.isF01Toy()) {
            this.h.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
            this.h.setToyFunc(PSOProgramService.VS_Key);
        }
        if (this.m.isQ01Toy()) {
            this.h.setToyFeature(Toy.TOY_FEATURE_TENERA);
            this.h.setToyTag("s");
            this.h.setToyFunc("s");
        }
        if (this.m.isBAToy()) {
            ek2 ek2VarC = fk2.a.c(this.m.getAddress());
            ek2 ek2Var = ek2.POSITION;
            int iOrdinal = ek2VarC == ek2Var ? ek2Var.ordinal() : ek2.SPEED.ordinal();
            this.u = iOrdinal;
            String str4 = iOrdinal == ek2Var.ordinal() ? "pos" : "t";
            this.h.setToyFunc(str4);
            this.h.setToyTag(str4);
        }
        this.g = new ArrayList();
        if (this.j) {
            WearUtils.l2(this.h.getId(), WearUtils.r0(this.i));
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("program_pattern", this.h);
            intent.putExtra("program_pattern_id", this.h.getId());
            intent.putExtras(bundle);
            setResult(24, intent);
        } else {
            if (this.o == 1) {
                this.h.setAllFun(true);
            } else {
                this.h.setAllFun(false);
            }
            WearUtils.l2(this.h.getId(), WearUtils.r0(this.i));
            this.h.setAnony(true);
            xe2.L0().t(this.h, true);
            if (this.k) {
                h5(this.h.getId());
                return;
            } else if (this.l) {
                rf3.l(false);
                pj3.f(this.activity, NewPatternActivity.class);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("program_pattern_id", this.h.getId());
                setResult(24, intent2);
            }
        }
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Toy> it = pc1.a.P().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getDeviceId());
        }
        map.put("type", 1);
        map.put("toy_mac", arrayList);
        ye3.d("M0034", WearUtils.A.toJson(map));
        finish();
    }

    public final void h5(String str) {
        if (rf3.c(str)) {
            this.x = ProgressDialog.show(this, "", ah4.e(R.string.common_loading), false, true);
            rf3.s(WearUtils.x0(str), new g(str));
        }
    }

    public final void i5() {
        new kn3((Context) this, ah4.e(R.string.send_program_max_size_notice), ah4.e(R.string.common_delete), ah4.e(R.string.common_cancel), false, (kn3.d) new d(), true).show();
    }

    public final void j5() {
        f5();
        this.delayHandler.postDelayed(new o(), 100L);
        do3 do3Var = new do3(this, ah4.e(R.string.common_save), ah4.e(R.string.common_cancel));
        do3Var.g(ah4.e(R.string.pattern_save));
        do3Var.i(ah4.e(R.string.pattern_name));
        do3Var.h("");
        do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        do3Var.b(new p(do3Var));
        do3Var.e();
        do3Var.c(new a(do3Var));
        this.t = true;
    }

    public final void k5(boolean z) {
        f5();
        do3 do3Var = new do3(this, ah4.e(R.string.common_save), ah4.e(R.string.common_cancel), false, ah4.e(R.string.pattern_save), ah4.e(z ? R.string.program_max_size_notice : R.string.record_max_size_notice));
        do3Var.i(ah4.e(R.string.pattern_name));
        do3Var.h("");
        do3Var.a().setFilters(new InputFilter[]{new WearUtils.g(), new InputFilter.LengthFilter(30)});
        do3Var.b(new e(do3Var));
        do3Var.f();
        do3Var.c(new f(do3Var));
        this.t = true;
    }

    public final void l5() {
        f5();
        if (this.q) {
            this.c = new do3(this, ah4.e(R.string.common_send), ah4.e(R.string.common_cancel), true, ah4.e(R.string.send_program_record_title), ah4.e(R.string.record_max_size_notice));
        } else {
            this.c = new do3(this, ah4.e(R.string.common_yes), ah4.e(R.string.common_no));
        }
        this.c.g(ah4.e(R.string.send_program_record_title));
        this.c.i(ah4.e(R.string.pattern_name));
        this.c.h(this.b);
        this.c.a().setFilters(new InputFilter[]{new WearUtils.g(), new InputFilter.LengthFilter(30)});
        this.c.b(new b());
        this.c.e();
        this.c.j();
        this.c.c(new c());
        this.t = true;
    }

    public final void m5() {
        Disposable disposable = this.s;
        if (disposable == null || disposable.isDisposed()) {
            this.s = Observable.interval(0L, 100L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n());
        }
    }

    public final void n5() {
        Disposable disposable = this.s;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.s.dispose();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.l) {
            super.onBackPressed();
            return;
        }
        rf3.l(false);
        pj3.f(this.activity, NewPatternActivity.class);
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IOException {
        super.onCreate(bundle);
        setContentView(R.layout.create_pattern_control);
        ButterKnife.bind(this);
        WearUtils.x.r = null;
        if (getIntent().getIntExtra("is_recording_pattern", 0) > 0) {
            this.actionbar.setTitle(ah4.e(R.string.pattern_createing));
            this.actionbar.setToy(pc1.a.P());
        } else {
            this.actionbar.setTitle(ah4.e(R.string.pattern_recording));
        }
        this.o = getIntent().getIntExtra("into_type", 0);
        this.d = (MyApplication) getApplication();
        boolean z = getIntent().getIntExtra("is_program_pattern", 0) > 0;
        this.j = z;
        if (z) {
            this.actionbar.setTitle(ah4.e(R.string.pattern_createing));
        }
        this.k = getIntent().getIntExtra("is_from_chat_send", 0) > 0;
        this.n = getIntent().getIntExtra("min_scond_time", -1);
        Object objD = kd0.d("extras_toy");
        if (objD != null) {
            this.m = (Toy) objD;
        }
        this.l = getIntent().getBooleanExtra("is_create_home", false);
        Toy toy = this.m;
        if (toy == null) {
            finish();
            return;
        }
        if (toy.isBAToy()) {
            fk2.a.g("pattern:" + this.m.getShowName());
        }
        this.f = new q();
        if (this.k) {
            this.actionbar.setYesAction(R.string.common_send, new i());
        } else {
            this.actionbar.setYesAction(this.j ? R.string.common_save : R.string.common_done, new h());
        }
        this.h = new Pattern();
        this.actionbar.setBackAction(new j());
        ArrayList arrayList = new ArrayList();
        this.y = arrayList;
        arrayList.add(this.m);
        this.multiControlPanel.N(true, "CREATE_PATTERN", this.y);
        b5();
        this.w = new s(this.h, new k());
        this.multiControlPanel.X(new l());
        pc1.a.F();
        EventBus.getDefault().register(this);
        if (mk2.P().h0()) {
            mk2.P().n0(true);
        }
        this.multiControlPanel.setOnVelvoInterceptListener(new MultiControlPanel.u() { // from class: dc.qd2
            @Override // com.wear.widget.control.multiToys.MultiControlPanel.u
            public final void a(Function0 function0) {
                this.a.a5(function0);
            }
        });
        this.multiControlPanel.setOnChangeModelListener(new MultiControlPanel.w() { // from class: dc.od2
            @Override // com.wear.widget.control.multiToys.MultiControlPanel.w
            public final void a() throws IOException {
                this.a.c5();
            }
        });
        this.z = new jp3(this.multiControlPanel, this.velvoPreviewView, "CREATE_PATTERN");
        this.multiControlPanel.u(new MultiCurveLineView.a() { // from class: dc.pd2
            @Override // com.wear.widget.control.multiToys.MultiCurveLineView.a
            public final void a(String str) {
                this.a.e5(str);
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        pc1.a.I();
        this.d.G().u0();
        Pattern pattern = this.h;
        if (pattern != null && pattern.getId() != null) {
            WearUtils.T1(this.h.getId());
        }
        this.multiControlPanel.U();
        EventBus.getDefault().unregister(this);
        if (mk2.P().h0()) {
            mk2.P().n0(false);
        }
        Toy toy = this.m;
        if (toy == null || !toy.isBAToy()) {
            return;
        }
        fk2.a.g("pattern:" + this.m.getShowName());
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        f5();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.multiControlPanel.R() || this.q || this.t) {
            return;
        }
        this.multiControlPanel.h0();
        m5();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.a) {
            return;
        }
        this.a = true;
    }

    /* renamed from: start, reason: merged with bridge method [inline-methods] */
    public void Y4() {
        m5();
        this.multiControlPanel.h0();
    }
}
