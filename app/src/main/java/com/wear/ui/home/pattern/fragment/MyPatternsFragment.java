package com.wear.ui.home.pattern.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.PatternSutausResponeItems;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.bean.event.PatternListChangeEvent;
import com.wear.dao.DaoUtils;
import com.wear.main.BaseFragment;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.patterns.CreatePatternActivity;
import com.wear.main.patterns.SharePatternActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.presenter.bean.PatternDeleteBean;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.AddToPlayListDialog;
import com.yydcdut.sdlv.SlideAndDragListView;
import dc.ah4;
import dc.ao3;
import dc.be3;
import dc.ch3;
import dc.cs3;
import dc.do3;
import dc.ip2;
import dc.is3;
import dc.kd0;
import dc.kn3;
import dc.n53;
import dc.na2;
import dc.pj3;
import dc.rf3;
import dc.sg3;
import dc.sr3;
import dc.te2;
import dc.th4;
import dc.ue2;
import dc.ue3;
import dc.ve2;
import dc.xe2;
import dc.y12;
import dc.yj1;
import dc.ym2;
import dc.yu3;
import dc.z43;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class MyPatternsFragment extends BaseFragment implements yj1.c, ip2, te2.b {

    @BindView(R.id.create_pattern)
    public LinearLayout createPattern;

    @BindView(R.id.create_pattern_image)
    public ImageView createPatternImage;

    @BindView(R.id.create_pattern_playout)
    public LinearLayout createPatternPlayout;

    @BindView(R.id.create_tv_text)
    public TextView create_tv_text;

    @BindView(R.id.iv_preset_earthquake_selected)
    public ImageView ivPresetEarthquakeSelected;

    @BindView(R.id.iv_preset_fireworks_selected)
    public ImageView ivPresetFireworksSelected;

    @BindView(R.id.iv_preset_pulse_selected)
    public ImageView ivPresetPulseSelected;

    @BindView(R.id.iv_preset_wave_selected)
    public ImageView ivPresetWaveSelected;
    public Pattern k;
    public Unbinder l;

    @BindView(R.id.list_empty_notice)
    public TextView list_empty_notice;

    @BindView(R.id.ll_earthquake_layout)
    public LinearLayout llEarthquakeLayout;

    @BindView(R.id.ll_fireworks_layout)
    public LinearLayout llFireworksLayout;

    @BindView(R.id.ll_pulse_layout)
    public LinearLayout llPulseLayout;

    @BindView(R.id.ll_wave_layout)
    public LinearLayout llWaveLayout;
    public ym2 m;
    public int p;

    @BindView(R.id.pattern_list_empty)
    public LinearLayout patternListEmpty;

    @BindView(R.id.pattern_data_list)
    public SlideAndDragListView pattern_list;

    @BindView(R.id.patterns_preset_earthquake)
    public TextView patternsPresetEarthquake;

    @BindView(R.id.patterns_preset_fireworks)
    public TextView patternsPresetFireworks;

    @BindView(R.id.patterns_preset_pulse)
    public TextView patternsPresetPulse;

    @BindView(R.id.patterns_preset_wave)
    public TextView patternsPresetWave;
    public boolean q;
    public yj1 r;

    @BindView(R.id.rl_preset_earthquake)
    public RelativeLayout rlPresetEarthquake;

    @BindView(R.id.rl_preset_fireworks)
    public RelativeLayout rlPresetFireworks;

    @BindView(R.id.rl_preset_pulse)
    public RelativeLayout rlPresetPulse;

    @BindView(R.id.rl_preset_wave)
    public RelativeLayout rlPresetWave;
    public ue2 n = xe2.L0();
    public ve2 o = (ve2) xe2.L0();
    public final List<Pattern> s = new ArrayList();

    public class a implements SlideAndDragListView.a {
        public Pattern a = null;

        public a() {
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void a(int i, int i2) {
            MyPatternsFragment.this.s.add(i2, (Pattern) MyPatternsFragment.this.s.remove(i));
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void b(int i) {
            MyPatternsFragment.this.s.set(i, this.a);
            LinkedHashMap<String, Pattern> linkedHashMap = new LinkedHashMap<>();
            int size = MyPatternsFragment.this.s.size();
            int i2 = 0;
            for (Pattern pattern : MyPatternsFragment.this.s) {
                i2++;
                int i3 = size - i2;
                if (i3 != pattern.getSortId()) {
                    pattern.setSortId(i3);
                    pattern.setLastUpdTime(be3.r());
                    linkedHashMap.put(pattern.getId(), pattern);
                }
            }
            MyPatternsFragment.this.n.F(linkedHashMap, true);
            MyPatternsFragment.this.r.notifyDataSetChanged();
        }

        @Override // com.yydcdut.sdlv.SlideAndDragListView.a
        public void c(int i) {
            this.a = (Pattern) MyPatternsFragment.this.s.get(i);
        }
    }

    public class b implements ue2.a {

        public class a extends HashMap<String, String> {
            public a() {
                String str;
                if (MyPatternsFragment.this.s == null) {
                    str = "0";
                } else {
                    str = "" + MyPatternsFragment.this.s.size();
                }
                put("count", str);
                put("isSystemPattern", "0");
                put("play_time", MyPatternsFragment.this.k.getTimer());
            }
        }

        public b() {
        }

        @Override // dc.ue2.a
        public void a(int i, String str) {
            if (MyPatternsFragment.this.isAdded()) {
                if (!ch3.n().X()) {
                    MyPatternsFragment.this.U0();
                    return;
                }
                sg3.k(MyPatternsFragment.this.getActivity(), String.format(ah4.e(R.string.pattern_play_failed), MyPatternsFragment.this.k.getName()));
                MyPatternsFragment myPatternsFragment = MyPatternsFragment.this;
                myPatternsFragment.W0(myPatternsFragment.p + 1);
            }
        }

        @Override // dc.ue2.a
        public void b(File file) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("pattern", MyPatternsFragment.this.k);
            bundle.putSerializable("from", "MianActivity");
            ((xe2) xe2.L0()).J1(MyPatternsFragment.this.s);
            pj3.g(MyPatternsFragment.this.getActivity(), PatternPlayActivity.class, bundle);
            MyPatternsFragment.this.t("pattern_local_play", new a());
        }
    }

    public class c extends HashMap<String, String> {
        public c() {
            put("count", "" + MyPatternsFragment.this.s.size());
        }
    }

    public class d implements ao3.a {
        public d(MyPatternsFragment myPatternsFragment) {
        }

        @Override // dc.ao3.a
        public void a(ao3 ao3Var) {
        }

        @Override // dc.ao3.a
        public void b(ao3 ao3Var) {
        }
    }

    public class e implements ue2.a {
        public final /* synthetic */ g a;

        public e(g gVar) {
            this.a = gVar;
        }

        @Override // dc.ue2.a
        public void a(int i, String str) {
            MyPatternsFragment.this.U0();
        }

        @Override // dc.ue2.a
        public void b(File file) {
            if (WearUtils.e1(MyPatternsFragment.this.k.getData())) {
                Pattern pattern = MyPatternsFragment.this.k;
                pattern.setData(WearUtils.N1(pattern.getFile().getPath()));
            }
            if (MyPatternsFragment.this.k.isCheckMd5()) {
                pj3.g(MyPatternsFragment.this.getActivity(), SharePatternActivity.class, this.a.a());
            }
        }
    }

    public class f implements kn3.d {
        public final /* synthetic */ do3 a;

        public class a implements kn3.d {
            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                MyPatternsFragment.this.onResume();
            }
        }

        public f(do3 do3Var) {
            this.a = do3Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(String str) {
            if (str.equals(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY)) {
                rf3.p(MyPatternsFragment.this.getActivity(), new a());
            } else {
                MyPatternsFragment.this.l0();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(String str, boolean z, final String str2) {
            if (z) {
                MyPatternsFragment.this.t("editSharePattern", null);
                sg3.h(R.string.patterns_result_update_name);
                MyPatternsFragment myPatternsFragment = MyPatternsFragment.this;
                Pattern patternK = myPatternsFragment.n.K(myPatternsFragment.k.getId());
                patternK.setName(str);
                patternK.setLastUpdTime(System.currentTimeMillis());
                MyPatternsFragment.this.n.E(patternK, true);
                MyPatternsFragment.this.L(new Runnable() { // from class: dc.b53
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b(str2);
                    }
                });
            }
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(this.a.a(), MyPatternsFragment.this.getActivity());
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            final String strTrim = this.a.a().getText().toString().trim();
            if (!MyPatternsFragment.this.k.isShared() || MyPatternsFragment.this.k.isDownload()) {
                sg3.i(MyPatternsFragment.this.getActivity(), R.string.patterns_result_update_name);
                MyPatternsFragment myPatternsFragment = MyPatternsFragment.this;
                Pattern patternK = myPatternsFragment.n.K(myPatternsFragment.k.getId());
                patternK.setName(strTrim);
                patternK.setLastUpdTime(System.currentTimeMillis());
                MyPatternsFragment.this.n.E(patternK, true);
                MyPatternsFragment.this.l0();
            } else {
                rf3.n(MyPatternsFragment.this.k.getId(), strTrim, null, null, new rf3.h() { // from class: dc.a53
                    @Override // dc.rf3.h
                    public final void a(boolean z, String str) {
                        this.a.d(strTrim, z, str);
                    }
                });
            }
            ue3.a(this.a.a(), MyPatternsFragment.this.getActivity());
            MyPatternsFragment.this.l0();
        }
    }

    public interface g {
        Bundle a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(ao3 ao3Var, View view) {
        i0(ao3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K0(ao3 ao3Var, View view) {
        j0(ao3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P0(AdapterView adapterView, View view, int i, long j) {
        if (na2.m().i()) {
            na2.m().t();
        } else if (y12.c.a().s(y12.c.TYPE_PATTERN)) {
            W0(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R0(sr3 sr3Var, Toy toy) {
        kd0.b("extras_toy", toy);
        Intent intent = new Intent(getActivity(), (Class<?>) CreatePatternActivity.class);
        intent.putExtra("is_recording_pattern", 1);
        intent.putExtra("is_create_home", false);
        startActivity(intent);
        if (sr3Var.isShowing()) {
            sr3Var.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean T0(do3 do3Var) {
        String string = do3Var.a().getText().toString();
        if (WearUtils.o1(string)) {
            return true;
        }
        sg3.k(getActivity(), WearUtils.l0(getActivity(), string));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0() {
        xe2.L0().f(this.k.getId(), this.k.getPath(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Bundle r0() {
        Bundle bundle = new Bundle();
        bundle.putString("patternId", this.k.getId());
        bundle.putBoolean("isUpdate", this.k.isShared());
        if (!WearUtils.e1(this.k.getToyFeature()) && this.k.getToyFeature().equalsIgnoreCase(Toy.TOY_FEATURE_XMACHINE)) {
            bundle.putString("toyFeature", this.k.getToyFeature());
        }
        if (this.k.getToySymbol() != null) {
            bundle.putString("toySymbol", this.k.getToySymbol());
        }
        if (this.k.getToyName() != null) {
            bundle.putString("toyName", this.k.getToyName());
        }
        if (this.k.getToyVersion() != null) {
            bundle.putString("toyVersion", this.k.getToyVersion());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Bundle u0() {
        Bundle bundle = new Bundle();
        bundle.putString("patternId", this.k.getId());
        bundle.putBoolean("isUpdate", this.k.isShared());
        if (!WearUtils.e1(this.k.getToyFeature())) {
            bundle.putString("toyFeature", this.k.getToyFeature());
        }
        if (this.k.getToySymbol() != null) {
            bundle.putString("toySymbol", this.k.getToySymbol());
        }
        if (this.k.getToyName() != null) {
            bundle.putString("toyName", this.k.getToyName());
        }
        if (this.k.getToyVersion() != null) {
            bundle.putString("toyVersion", this.k.getToyVersion());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(ao3 ao3Var, View view) {
        f0(ao3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0(ao3 ao3Var, View view) {
        g0(ao3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0(ao3 ao3Var, View view) {
        h0(ao3Var);
    }

    @Override // com.wear.main.BaseFragment
    public void D() {
        this.g.b(this);
        this.h = this.m;
    }

    @Override // dc.te2.b
    public void G() {
        L(new z43(this));
    }

    @Override // dc.te2.b
    public void I3(te2.a aVar) {
    }

    @Override // dc.ip2
    public void J3(boolean z, BaseResponseBean baseResponseBean) {
        if (getActivity() == null) {
            return;
        }
        if (baseResponseBean == null) {
            sg3.i(getActivity(), R.string.common_serverError);
            return;
        }
        if (!baseResponseBean.isResult() || baseResponseBean.getData() == null) {
            sg3.k(getActivity(), baseResponseBean.getMessage());
            return;
        }
        PatternSutausResponeItems[] patternSutausResponeItemsArr = (PatternSutausResponeItems[]) WearUtils.A.fromJson(baseResponseBean.getData().toString(), PatternSutausResponeItems[].class);
        if (patternSutausResponeItemsArr != null) {
            LinkedHashMap<String, Pattern> linkedHashMap = new LinkedHashMap<>();
            for (PatternSutausResponeItems patternSutausResponeItems : patternSutausResponeItemsArr) {
                Pattern pattern = null;
                Iterator<Pattern> it = this.s.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pattern next = it.next();
                    if (patternSutausResponeItems.getId().equals(next.getId())) {
                        pattern = next;
                        break;
                    }
                }
                if (pattern != null && !WearUtils.e1(patternSutausResponeItems.getStatus()) && !patternSutausResponeItems.getStatus().equals(pattern.getStatus())) {
                    pattern.setLastUpdTime(System.currentTimeMillis());
                    pattern.setStatus(patternSutausResponeItems.getStatus());
                    linkedHashMap.put(pattern.getId(), pattern);
                }
            }
            if (linkedHashMap.size() > 0) {
                this.n.F(linkedHashMap, true);
            }
            this.r.notifyDataSetChanged();
        }
    }

    public final void U0() {
        sg3.i(getActivity(), R.string.file_notfound);
        a1();
    }

    public final void W0(int i) {
        int size = this.s.size();
        if (size == 0) {
            return;
        }
        int i2 = i % size;
        this.p = i2;
        Pattern pattern = this.s.get(i2);
        this.k = pattern;
        b bVar = new b();
        if (pattern.useless()) {
            cs3.c(getActivity(), ah4.e(R.string.pattern_is_broken), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), new n53(this)).show();
            return;
        }
        if (!this.k.getFile().exists()) {
            xe2.L0().f(this.k.getId(), this.k.getPath(), bVar);
            return;
        }
        Pattern pattern2 = this.k;
        if (pattern2.setDataNoCheckFormat(WearUtils.N1(pattern2.getFile().getPath()))) {
            bVar.b(this.k.getFile());
        } else {
            cs3.c(getActivity(), ah4.e(R.string.pattern_format_error_delete), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), new n53(this)).show();
        }
    }

    @Override // dc.te2.b
    public void Y(te2.a aVar) {
    }

    public void a1() {
        Pattern pattern = this.k;
        if (pattern != null) {
            this.n.d(pattern, true);
            ((xe2) this.n).y1(this.k);
            ve2 ve2Var = this.o;
            ve2Var.M(ve2Var.h(WearUtils.y.r(), this.k.getId()), false);
            DaoUtils.getMediaPatternDao().delById(this.k.getId());
            this.s.remove(this.k);
            if (PatternPlayManagerImpl.H && PatternPlayManagerImpl.O().c0() && PatternPlayManagerImpl.O().T() != null) {
                PatternPlayManagerImpl.O().M0(this.k);
            }
        }
        this.r.notifyDataSetChanged();
    }

    public void c1() {
        a1();
        if (this.s.size() == 0) {
            this.createPattern.setVisibility(8);
            this.createPatternPlayout.setVisibility(8);
            this.pattern_list.setVisibility(8);
        } else {
            this.createPattern.setVisibility(0);
            this.createPatternPlayout.setVisibility(0);
            this.pattern_list.setVisibility(0);
        }
    }

    @Override // dc.te2.b
    public void d() {
        L(new z43(this));
    }

    @Override // dc.te2.b
    public void d4(te2.a aVar) {
    }

    public final void e0(ao3 ao3Var, ue2.a aVar) {
        ao3Var.dismiss();
        if (this.k.getFile().exists()) {
            aVar.b(this.k.getFile());
            return;
        }
        if (!this.k.getFile().exists() && TextUtils.isEmpty(this.k.getPath())) {
            aVar.a(-1, null);
            return;
        }
        if (!ch3.n().X()) {
            aVar.a(-1, null);
            return;
        }
        is3.b bVar = new is3.b(getActivity());
        bVar.p(String.format(ah4.e(R.string.pattern_sync_on_share_failed), this.k.getName()));
        bVar.o(ah4.e(R.string.common_ok));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.d(new is3.d() { // from class: dc.i53
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.p0();
            }
        });
    }

    public final void f0(ao3 ao3Var) {
        e0(ao3Var, k0(new g() { // from class: dc.m53
            @Override // com.wear.ui.home.pattern.fragment.MyPatternsFragment.g
            public final Bundle a() {
                return this.a.r0();
            }
        }));
    }

    public final void f1(String str, String str2, String str3) {
        final do3 do3Var = new do3(getActivity(), ah4.e(R.string.common_save), ah4.e(R.string.common_cancel));
        do3Var.g(str);
        do3Var.i(str2);
        do3Var.h(str3);
        do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        do3Var.b(new kn3.c() { // from class: dc.g53
            @Override // dc.kn3.c
            public final boolean a() {
                return this.a.T0(do3Var);
            }
        });
        do3Var.e();
        do3Var.c(new f(do3Var));
        do3Var.a().requestFocus();
        ue3.d(do3Var.a(), getActivity());
    }

    @Override // dc.ip2
    public void f2(boolean z, PatternDeleteBean patternDeleteBean) {
        if (getActivity() == null) {
            return;
        }
        sg3.k(getActivity(), ah4.e(R.string.delete_success));
    }

    public final void g0(ao3 ao3Var) {
        e0(ao3Var, k0(new g() { // from class: dc.l53
            @Override // com.wear.ui.home.pattern.fragment.MyPatternsFragment.g
            public final Bundle a() {
                return this.a.u0();
            }
        }));
    }

    public final void g1(View view, boolean z, boolean z2) {
        ao3 ao3Var = new ao3(getActivity(), R.style.MenuDialogAl, R.layout.select_menu_dialog_item);
        m0(view, z, z2, ao3Var);
        ao3Var.show();
    }

    public final void h0(ao3 ao3Var) {
        ao3Var.dismiss();
        String strE = ah4.e(R.string.pattern_name);
        String strE2 = ah4.e(R.string.pattern_name);
        Pattern pattern = this.k;
        f1(strE, strE2, pattern == null ? "" : pattern.getName());
    }

    public final void i0(ao3 ao3Var) {
        ao3Var.dismiss();
        String strE = ah4.e(R.string.toy_program_delete_pattern);
        if (this.k.isShared() && !this.k.isDownload()) {
            strE = strE + ah4.e(R.string.pattern_shareddelete_warning);
        } else if (ch3.n().X()) {
            strE = ah4.e(R.string.pattern_delete_local_sever);
        }
        cs3.c(getActivity(), strE, ah4.e(R.string.common_yes), ah4.e(R.string.common_no), new is3.d() { // from class: dc.o53
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.c1();
            }
        }).show();
    }

    public final void i1() {
        cs3.k(getActivity(), ah4.e(R.string.offline_unlock_account), null).show();
    }

    public final void j0(ao3 ao3Var) {
        ao3Var.dismiss();
        new AddToPlayListDialog(getContext()).k(this.k);
    }

    public final ue2.a k0(g gVar) {
        return new e(gVar);
    }

    public void l0() {
        this.s.clear();
        List<Pattern> listY = this.n.y(WearUtils.y.r());
        if (listY != null) {
            this.s.addAll(listY);
        }
        String str = "长度===" + this.s.size();
        for (int i = 0; i < this.s.size(); i++) {
            this.s.get(i).setIsNeedReport("1");
        }
        if (!this.q) {
            t("myPatternCount", new c());
        }
        this.r.notifyDataSetChanged();
        if (this.s.size() == 0) {
            this.create_tv_text.setVisibility(8);
            this.createPatternPlayout.setVisibility(8);
        } else {
            this.create_tv_text.setVisibility(0);
            this.createPatternPlayout.setVisibility(0);
        }
        if (this.s.size() == 0) {
            this.createPattern.setVisibility(8);
            this.createPatternPlayout.setVisibility(8);
            this.pattern_list.setVisibility(8);
        } else {
            this.createPattern.setVisibility(0);
            this.createPatternPlayout.setVisibility(0);
            this.pattern_list.setVisibility(0);
        }
    }

    public final void m0(View view, boolean z, boolean z2, final ao3 ao3Var) {
        ao3Var.a(view, 250, 200, 1800, -30, new d(this));
        ao3Var.findViewById(R.id.action_row_0).setOnClickListener(new View.OnClickListener() { // from class: dc.k53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.w0(ao3Var, view2);
            }
        });
        ao3Var.findViewById(R.id.action_row_1).setOnClickListener(new View.OnClickListener() { // from class: dc.f53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.y0(ao3Var, view2);
            }
        });
        ao3Var.findViewById(R.id.action_row_2).setOnClickListener(new View.OnClickListener() { // from class: dc.d53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.A0(ao3Var, view2);
            }
        });
        ao3Var.findViewById(R.id.action_row_3).setOnClickListener(new View.OnClickListener() { // from class: dc.c53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.E0(ao3Var, view2);
            }
        });
        ao3Var.findViewById(R.id.action_row_4).setVisibility(0);
        ao3Var.findViewById(R.id.action_row_4).setOnClickListener(new View.OnClickListener() { // from class: dc.e53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.K0(ao3Var, view2);
            }
        });
        if (!z || MyApplication.Z) {
            ao3Var.findViewById(R.id.action_row_1).setAlpha(0.4f);
            ao3Var.findViewById(R.id.action_row_1).setEnabled(false);
            ao3Var.findViewById(R.id.action_row_1).setOnClickListener(null);
            ((TextView) ao3Var.findViewById(R.id.action_row_1_text)).setText(ah4.e(R.string.common_share));
            return;
        }
        if (z2) {
            ((TextView) ao3Var.findViewById(R.id.action_row_1_text)).setText(ah4.e(R.string.common_reshared));
        } else {
            ((TextView) ao3Var.findViewById(R.id.action_row_1_text)).setText(ah4.e(R.string.common_share));
        }
        ao3Var.findViewById(R.id.action_row_1).setAlpha(1.0f);
        ao3Var.findViewById(R.id.action_row_1).setEnabled(true);
    }

    @Override // dc.yj1.c
    public void o(View view, Pattern pattern) {
        if (!MyApplication.P && !WearUtils.e1(pattern.getAuthor())) {
            cs3.k(getActivity(), ah4.e(R.string.offline_unlock_account), null).show();
            return;
        }
        if (!xe2.L0().l(WearUtils.y.r(), pattern.getEmails(false))) {
            i1();
            return;
        }
        this.k = pattern;
        if (pattern.useless()) {
            cs3.c(getActivity(), ah4.e(R.string.pattern_is_broken), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), new n53(this)).show();
            return;
        }
        if (pattern.neverSync()) {
            cs3.c(getActivity(), ah4.e(R.string.pattern_format_error_delete), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), new n53(this)).show();
            return;
        }
        boolean zIsDownload = true;
        if (pattern.isShared()) {
            boolean z = !pattern.isDownload();
            if (!pattern.getCreator().equals(WearUtils.y.r())) {
                zIsDownload = z;
            }
        } else {
            zIsDownload = true ^ pattern.isDownload();
        }
        g1(view, zIsDownload, pattern.isShared());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_my_patterns, (ViewGroup) null);
        this.l = ButterKnife.bind(this, viewInflate);
        this.create_tv_text.setText(ah4.e(R.string.pattern_create));
        this.list_empty_notice.setText(ah4.e(R.string.pattern_create));
        this.r = new yj1(this.s, getActivity(), R.layout.home_pattern_item);
        this.pattern_list.setMenu(new yu3(false, 0));
        this.pattern_list.setCacheColorHint(th4.b(getContext(), R.color.pattern_item_drag_bg));
        this.pattern_list.setAdapter((ListAdapter) this.r);
        this.pattern_list.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: dc.h53
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.a.P0(adapterView, view, i, j);
            }
        });
        M(WearUtils.x);
        this.pattern_list.setEmptyView(this.patternListEmpty);
        this.pattern_list.setOnDragDropListener(new a());
        this.n = xe2.L0();
        this.r.c(this);
        this.n.k(this);
        return viewInflate;
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.n.D(this);
        this.l.unbind();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(PatternListChangeEvent patternListChangeEvent) {
        this.s.remove(patternListChangeEvent.getPattern());
        this.r.notifyDataSetChanged();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        l0();
    }

    @OnClick({R.id.ll_pulse_layout, R.id.ll_wave_layout, R.id.ll_fireworks_layout, R.id.ll_earthquake_layout, R.id.create_pattern, R.id.create_pattern_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.create_pattern /* 2131362472 */:
            case R.id.create_pattern_image /* 2131362473 */:
                if (!na2.m().i()) {
                    if (y12.c.a().s(y12.c.TYPE_PATTERN)) {
                        if (!MyApplication.Z && !MyApplication.O) {
                            pj3.f(getActivity(), LoginActivity.class);
                            getActivity().finish();
                            break;
                        } else {
                            final sr3 sr3Var = new sr3(getActivity());
                            sr3Var.j(new sr3.c() { // from class: dc.j53
                                @Override // dc.sr3.c
                                public final void a(Toy toy) {
                                    this.a.R0(sr3Var, toy);
                                }
                            });
                            sr3Var.show();
                            break;
                        }
                    }
                } else {
                    na2.m().t();
                    break;
                }
                break;
            case R.id.ll_earthquake_layout /* 2131363503 */:
            case R.id.ll_fireworks_layout /* 2131363512 */:
            case R.id.ll_pulse_layout /* 2131363562 */:
            case R.id.ll_wave_layout /* 2131363636 */:
                if (!na2.m().i()) {
                    if (y12.c.a().s(y12.c.TYPE_PATTERN)) {
                        ArrayList<Pattern> arrayListJ = rf3.j();
                        Pattern patternH = null;
                        switch (view.getId()) {
                            case R.id.ll_earthquake_layout /* 2131363503 */:
                                patternH = rf3.h("Earthquake", arrayListJ);
                                break;
                            case R.id.ll_fireworks_layout /* 2131363512 */:
                                patternH = rf3.h("Fireworks", arrayListJ);
                                break;
                            case R.id.ll_pulse_layout /* 2131363562 */:
                                patternH = rf3.h("Pulse", arrayListJ);
                                break;
                            case R.id.ll_wave_layout /* 2131363636 */:
                                patternH = rf3.h("Wave", arrayListJ);
                                break;
                        }
                        if (patternH != null) {
                            if (!patternH.getFile().exists()) {
                                rf3.l(false);
                                view.performClick();
                                break;
                            } else {
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("pattern", patternH);
                                bundle.putSerializable("from", "MianActivity");
                                ((xe2) xe2.L0()).J1(arrayListJ);
                                bundle.putBoolean("isSysPatterns", true);
                                pj3.g(getActivity(), PatternPlayActivity.class, bundle);
                                break;
                            }
                        }
                    }
                } else {
                    na2.m().t();
                    break;
                }
                break;
        }
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        l0();
    }
}
