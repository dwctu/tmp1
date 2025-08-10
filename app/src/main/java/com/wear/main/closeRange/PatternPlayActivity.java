package com.wear.main.closeRange;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.GroupPatternSaveMemberAdapter;
import com.wear.bean.Pattern;
import com.wear.bean.PatternHiddenSuccBean;
import com.wear.bean.SyncWsProtocol;
import com.wear.bean.Toy;
import com.wear.bean.event.HidePatternEvent;
import com.wear.bean.event.PatternDownloadEvent;
import com.wear.bean.event.PatternFavoriteChangeEvent;
import com.wear.bean.event.PatternListChangeEvent;
import com.wear.bean.event.PatternOrAlarmSaveEvent;
import com.wear.bean.event.ReSendPatternEvent;
import com.wear.dao.DaoUtils;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.PatternPlayButtomDialogActionItemAdapter;
import com.wear.main.closeRange.PatternPlaySpeedOptionsAdapter;
import com.wear.main.longDistance.ForwardMessageActivity;
import com.wear.main.patterns.SharePatternActivity;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.EntityPattern;
import com.wear.ui.discover.pattern.ReportReasonActivity;
import com.wear.ui.home.pattern.NewPatternActivity;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.control.NewCurveLineView;
import dc.ah4;
import dc.ao3;
import dc.bk1;
import dc.bo3;
import dc.cg3;
import dc.ch3;
import dc.cs3;
import dc.do3;
import dc.eg3;
import dc.ek2;
import dc.hv1;
import dc.is3;
import dc.kk3;
import dc.kn3;
import dc.kv1;
import dc.ll3;
import dc.me3;
import dc.mk3;
import dc.nf3;
import dc.pc1;
import dc.pj3;
import dc.rf3;
import dc.sg3;
import dc.sz1;
import dc.tn2;
import dc.tz1;
import dc.u02;
import dc.ue2;
import dc.ue3;
import dc.ve2;
import dc.xe2;
import dc.y12;
import dc.ye3;
import dc.yn2;
import dc.yn3;
import dc.zb2;
import dc.zn2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.disco.bean.request.RequestPatternOrAlarmList;
import org.jivesoftware.smackx.disco.bean.response.ResponsePatternOrAlarmMessage;

/* loaded from: classes3.dex */
public class PatternPlayActivity extends BaseActivity implements tz1, hv1 {
    public String A;
    public Pattern B;
    public TextView C;
    public LinearLayout D;
    public TextView G;
    public TextView K;
    public TextView L;
    public TextView M;
    public ConstraintLayout N;
    public ImageView O;
    public TextView P;
    public String Q;
    public String R;
    public RecyclerView S;
    public SlidingUpPanelLayout T;
    public CommunMessage U;
    public EntityPattern V;
    public ImageView W;
    public ImageView X;
    public View Y;
    public boolean Z;
    public List<Pattern> a;
    public RelativeLayout a0;
    public int b;
    public Activity c;
    public ImageView c0;
    public long d0;
    public long e0;
    public MyActionBar f;
    public TextView g;
    public NewCurveLineView h;
    public bk1 i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public LinearLayout m;
    public LinearLayout n;
    public LinearLayout o;
    public ImageView p;
    public TextView q;
    public ImageView u;
    public TextView v;
    public SeekBar w;
    public boolean x;
    public int y;
    public int z;
    public String d = "";
    public ve2 e = (ve2) xe2.L0();
    public List<String> s = Arrays.asList("loop", "random", "repeat");
    public int t = 100;
    public double[] E = {4.0d, 2.0d, 1.0d, 0.5d, 0.25d};
    public String F = "1";
    public ArrayList<ResponsePatternOrAlarmMessage.DataBean> b0 = new ArrayList<>();

    public class a implements View.OnClickListener {
        public final /* synthetic */ ao3 a;
        public final /* synthetic */ Pattern b;

        /* renamed from: com.wear.main.closeRange.PatternPlayActivity$a$a, reason: collision with other inner class name */
        public class C0089a implements ue2.a {
            public C0089a() {
            }

            @Override // dc.ue2.a
            public void a(int i, String str) {
                sg3.i(PatternPlayActivity.this, R.string.file_notfound);
                PatternPlayActivity.this.i6();
            }

            @Override // dc.ue2.a
            public void b(File file) {
                if (a.this.b.getData() == null) {
                    Pattern pattern = a.this.b;
                    pattern.setData(WearUtils.N1(pattern.getFile().getPath()));
                }
                if (a.this.b.isCheckMd5()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("patternId", a.this.b.getId());
                    bundle.putBoolean("isUpdate", a.this.b.isShared());
                    if (!WearUtils.e1(PatternPlayActivity.this.B.getToyFeature()) && PatternPlayActivity.this.B.getToyFeature().equalsIgnoreCase(Toy.TOY_FEATURE_XMACHINE)) {
                        bundle.putString("toyFeature", PatternPlayActivity.this.B.getToyFeature());
                    }
                    pj3.g(PatternPlayActivity.this, SharePatternActivity.class, bundle);
                }
            }
        }

        public class b implements is3.d {
            public b() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                xe2.L0().f(a.this.b.getId(), a.this.b.getPath(), null);
            }
        }

        public a(ao3 ao3Var, Pattern pattern) {
            this.a = ao3Var;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            C0089a c0089a = new C0089a();
            if (this.b.getFile().exists()) {
                c0089a.b(this.b.getFile());
                return;
            }
            if (!this.b.getFile().exists() && TextUtils.isEmpty(this.b.getPath())) {
                c0089a.a(-1, null);
                return;
            }
            if (!ch3.n().X()) {
                c0089a.a(-1, null);
                return;
            }
            is3.b bVar = new is3.b(PatternPlayActivity.this);
            bVar.p(String.format(ah4.e(R.string.pattern_sync_on_share_failed), this.b.getName()));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new b());
        }
    }

    public class a0 implements yn3.c {
        public a0() {
        }

        @Override // dc.yn3.c
        public void a(String str, String str2) {
            PatternPlayActivity.this.B.setName(str2);
            xe2.L0().t(PatternPlayActivity.this.B, true);
            pj3.f(PatternPlayActivity.this, NewPatternActivity.class);
        }

        @Override // dc.yn3.c
        public void doCancel() {
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ ao3 a;
        public final /* synthetic */ Pattern b;

        public class a implements ue2.a {
            public a() {
            }

            @Override // dc.ue2.a
            public void a(int i, String str) {
                sg3.i(PatternPlayActivity.this, R.string.file_notfound);
                PatternPlayActivity.this.i6();
            }

            @Override // dc.ue2.a
            public void b(File file) {
                if (b.this.b.getData() == null) {
                    Pattern pattern = b.this.b;
                    pattern.setData(WearUtils.N1(pattern.getFile().getPath()));
                }
                if (b.this.b.isCheckMd5()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("patternId", b.this.b.getId());
                    bundle.putBoolean("isUpdate", b.this.b.isShared());
                    if (!WearUtils.e1(PatternPlayActivity.this.B.getToyFeature()) && PatternPlayActivity.this.B.getToyFeature().equalsIgnoreCase(Toy.TOY_FEATURE_XMACHINE)) {
                        bundle.putString("toyFeature", PatternPlayActivity.this.B.getToyFeature());
                    }
                    pj3.g(PatternPlayActivity.this, SharePatternActivity.class, bundle);
                }
            }
        }

        /* renamed from: com.wear.main.closeRange.PatternPlayActivity$b$b, reason: collision with other inner class name */
        public class C0090b implements is3.d {
            public C0090b() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                xe2.L0().f(b.this.b.getId(), b.this.b.getPath(), null);
            }
        }

        public b(ao3 ao3Var, Pattern pattern) {
            this.a = ao3Var;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            a aVar = new a();
            if (this.b.getFile().exists()) {
                aVar.b(this.b.getFile());
                return;
            }
            if (!this.b.getFile().exists() && TextUtils.isEmpty(this.b.getPath())) {
                aVar.a(-1, null);
                return;
            }
            if (!ch3.n().X()) {
                aVar.a(-1, null);
                return;
            }
            is3.b bVar = new is3.b(PatternPlayActivity.this);
            bVar.p(String.format(ah4.e(R.string.pattern_sync_on_share_failed), this.b.getName()));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.n(ah4.e(R.string.common_cancel));
            bVar.d(new C0090b());
        }
    }

    public class b0 implements SlidingUpPanelLayout.d {
        public b0() {
        }

        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.d
        public void a(View view, SlidingUpPanelLayout.e eVar, SlidingUpPanelLayout.e eVar2) {
            if (eVar2 == SlidingUpPanelLayout.e.EXPANDED) {
                PatternPlayActivity.this.f6();
            }
        }

        @Override // com.sothree.slidinguppanel.SlidingUpPanelLayout.d
        public void onPanelSlide(View view, float f) {
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ ao3 a;
        public final /* synthetic */ Pattern b;

        public c(ao3 ao3Var, Pattern pattern) {
            this.a = ao3Var;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            PatternPlayActivity patternPlayActivity = PatternPlayActivity.this;
            String strE = ah4.e(R.string.pattern_name);
            String strE2 = ah4.e(R.string.pattern_name);
            Pattern pattern = this.b;
            patternPlayActivity.t6(strE, strE2, pattern == null ? "" : pattern.getName(), this.b);
        }
    }

    public class c0 implements PatternPlayManagerImpl.f {
        public c0() {
        }

        @Override // com.wear.ui.home.pattern.control.PatternPlayManagerImpl.f
        public void a(Pattern pattern, int i, boolean z, String str, String str2, int i2, String[] strArr) {
            PatternPlayActivity.this.k.setImageResource(R.drawable.pattern_play_pause);
            PatternPlayActivity.this.k.setTag("s");
            int i3 = 0;
            if (!WearUtils.e1(pattern.getData())) {
                PatternPlayActivity.this.p5();
                if (pattern.getHead() == null) {
                    PatternPlayActivity.this.h.setInitData(null, pattern.getData().split(","), true);
                } else {
                    PatternPlayActivity.this.h.setInitData(pattern.getHead(), pattern.getData().split(";"), false);
                }
            }
            if (PatternPlayManagerImpl.O().d0()) {
                PatternPlayActivity.this.c0.setImageResource(R.drawable.icon_chat_gpt_play);
                PatternPlayActivity.this.k.setImageResource(R.drawable.pattern_play_play);
                y12.c.a().e();
            } else {
                PatternPlayActivity.this.c0.setImageResource(R.drawable.icon_chat_gpt_pause);
                PatternPlayActivity.this.k.setImageResource(R.drawable.pattern_play_pause);
            }
            if (!WearUtils.g1(PatternPlayActivity.this.a)) {
                Iterator<Pattern> it = PatternPlayActivity.this.a.iterator();
                while (it.hasNext()) {
                    if (it.next().getId().equals(pattern.getId())) {
                        PatternPlayActivity.this.b = i3;
                    }
                    i3++;
                }
            }
            PatternPlayActivity.this.notifyDataSetChanged();
            PatternPlayActivity.this.g.setText(str);
            PatternPlayActivity.this.h.setShowBothLine(z);
            PatternPlayActivity.this.h.a(i2, pattern, strArr);
            PatternPlayActivity.this.h.setBothLinePoint(str2);
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ ao3 a;
        public final /* synthetic */ Pattern b;

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                d dVar = d.this;
                PatternPlayActivity.this.k6(dVar.b);
            }
        }

        public d(ao3 ao3Var, Pattern pattern) {
            this.a = ao3Var;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            String strE = ah4.e(R.string.toy_program_delete_pattern);
            if (this.b.isShared() && !this.b.isDownload()) {
                strE = ah4.e(R.string.pattern_shareddelete_warning);
            } else if (ch3.n().X()) {
                strE = ah4.e(R.string.pattern_delete_local_sever);
            }
            cs3.c(PatternPlayActivity.this, strE, ah4.e(R.string.common_yes), ah4.e(R.string.common_no), new a()).show();
        }
    }

    public class d0 implements kv1 {
        public d0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(ResponsePatternOrAlarmMessage responsePatternOrAlarmMessage) {
            ArrayList arrayList = (ArrayList) responsePatternOrAlarmMessage.getData();
            if (!PatternPlayActivity.this.b0.containsAll(arrayList)) {
                PatternPlayActivity.this.b0 = arrayList;
                cg3.f(PatternPlayActivity.this.S, new GroupPatternSaveMemberAdapter((ArrayList) responsePatternOrAlarmMessage.getData(), R.layout.item_group_pattern_save_member));
            }
            PatternPlayActivity.this.P.setText(String.format(ah4.e(R.string.common_saved) + ": %s " + ah4.e(R.string.search_chat_type_members), responsePatternOrAlarmMessage.getData().size() + ""));
        }

        @Override // dc.kv1
        public void a(String str) {
            try {
                final ResponsePatternOrAlarmMessage responsePatternOrAlarmMessage = (ResponsePatternOrAlarmMessage) JSON.parseObject(str, ResponsePatternOrAlarmMessage.class);
                if (responsePatternOrAlarmMessage.getCode() == 1) {
                    for (ResponsePatternOrAlarmMessage.DataBean dataBean : responsePatternOrAlarmMessage.getData()) {
                        String photo = dataBean.getPhoto();
                        if (!TextUtils.isEmpty(photo) && !photo.contains("UploadFiles/wear/avatar")) {
                            try {
                                String str2 = new String(Base64.decode(photo), "ISO-8859-1");
                                photo = (TextUtils.isEmpty(str2) || str2.length() > 512) ? "" : str2;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        dataBean.setPhoto(photo);
                    }
                    PatternPlayActivity.this.parentHandler.post(new Runnable() { // from class: dc.c02
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.c(responsePatternOrAlarmMessage);
                        }
                    });
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // dc.kv1
        public void onError(Exception exc) {
        }
    }

    public class e implements ao3.a {
        public e(PatternPlayActivity patternPlayActivity) {
        }

        @Override // dc.ao3.a
        public void a(ao3 ao3Var) {
        }

        @Override // dc.ao3.a
        public void b(ao3 ao3Var) {
        }
    }

    public class e0 implements zn2<String> {
        public e0() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            ((NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class)).isResult();
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(PatternPlayActivity.this, netException.getMessage());
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ ao3 a;
        public final /* synthetic */ Pattern b;

        public f(ao3 ao3Var, Pattern pattern) {
            this.a = ao3Var;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            if (WearUtils.y.u() == null) {
                PatternPlayActivity.this.u6(R.string.pattern_store_share_offline_notification);
                return;
            }
            Pattern pattern = this.b;
            if (pattern == null || WearUtils.e1(pattern.getData()) || !pattern.isCheckMd5() || WearUtils.e1(pattern.getPath())) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("choose_pattern", pattern);
            pj3.g(PatternPlayActivity.this, ForwardMessageActivity.class, bundle);
        }
    }

    public class f0 implements zn2<String> {
        public f0() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (normalResponse == null) {
                sg3.i(PatternPlayActivity.this, R.string.patterns_result_remove_failed);
            } else {
                if (normalResponse.isResult()) {
                    return;
                }
                sg3.i(PatternPlayActivity.this, R.string.patterns_result_remove_failed);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(PatternPlayActivity.this, netException.getMessage());
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ ao3 a;
        public final /* synthetic */ Pattern b;

        public g(ao3 ao3Var, Pattern pattern) {
            this.a = ao3Var;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            if (WearUtils.y.u() == null) {
                PatternPlayActivity.this.u6(R.string.pattern_store_report_offline_notification);
            } else {
                PatternPlayActivity.this.l6(this.b.getId());
                WearUtils.x.q("pattern_cloud_report", null);
            }
        }
    }

    public class g0 implements ao3.a {
        public g0(PatternPlayActivity patternPlayActivity) {
        }

        @Override // dc.ao3.a
        public void a(ao3 ao3Var) {
        }

        @Override // dc.ao3.a
        public void b(ao3 ao3Var) {
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ Pattern a;

        public h(Pattern pattern) {
            this.a = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putString("patternId", this.a.getId());
            bundle.putBoolean("isUpdate", true);
            if (!WearUtils.e1(this.a.getToyFeature()) && this.a.getToyFeature().toLowerCase().equals(Toy.TOY_FEATURE_XMACHINE.toLowerCase())) {
                bundle.putString("toyFeature", this.a.getToyFeature());
            }
            pj3.p(PatternPlayActivity.this, SharePatternActivity.class, 48, bundle);
        }
    }

    public class i implements View.OnClickListener {
        public final /* synthetic */ ao3 a;
        public final /* synthetic */ Pattern b;

        public i(ao3 ao3Var, Pattern pattern) {
            this.a = ao3Var;
            this.b = pattern;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            if (WearUtils.y.u() == null) {
                PatternPlayActivity.this.u6(R.string.pattern_store_hide_offline_notification);
            } else {
                PatternPlayActivity.this.h5(this.b);
            }
        }
    }

    public class j implements kn3.c {
        public final /* synthetic */ do3 a;

        public j(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.c
        public boolean a() {
            if (!WearUtils.e1(this.a.a().getText().toString())) {
                return true;
            }
            sg3.i(PatternPlayActivity.this.c, R.string.pattern_name_empty);
            return false;
        }
    }

    public class k implements MyActionBar.f {
        public k() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            PatternPlayActivity.this.onBackPressed();
        }
    }

    public class l implements kn3.d {
        public final /* synthetic */ do3 a;
        public final /* synthetic */ Pattern b;

        public class a implements rf3.h {
            public final /* synthetic */ String a;

            /* renamed from: com.wear.main.closeRange.PatternPlayActivity$l$a$a, reason: collision with other inner class name */
            public class RunnableC0091a implements Runnable {
                public final /* synthetic */ String a;

                /* renamed from: com.wear.main.closeRange.PatternPlayActivity$l$a$a$a, reason: collision with other inner class name */
                public class C0092a implements kn3.d {
                    public C0092a() {
                    }

                    @Override // dc.kn3.d
                    public void doCancel() {
                    }

                    @Override // dc.kn3.d
                    public void doConfirm() {
                        PatternPlayActivity.this.onResume();
                    }
                }

                public RunnableC0091a(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.a.equals(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY)) {
                        rf3.p(PatternPlayActivity.this.c, new C0092a());
                    } else {
                        PatternPlayActivity.this.onResume();
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
                    Pattern patternK = xe2.L0().K(l.this.b.getId());
                    patternK.setName(this.a);
                    xe2.L0().E(patternK, true);
                    l lVar = l.this;
                    PatternPlayActivity.this.d = lVar.b.getId();
                    l.this.b.setName(this.a);
                    PatternPlayActivity.this.runOnUiThread(new RunnableC0091a(str));
                }
            }
        }

        public l(do3 do3Var, Pattern pattern) {
            this.a = do3Var;
            this.b = pattern;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(this.a.a(), PatternPlayActivity.this.c);
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            String string = this.a.a().getText().toString();
            if (this.b.isShared()) {
                rf3.n(this.b.getId(), string, null, null, new a(string));
            } else {
                sg3.i(PatternPlayActivity.this.c, R.string.patterns_result_update_name);
                Pattern patternK = xe2.L0().K(this.b.getId());
                if (patternK != null) {
                    patternK.setName(string);
                    xe2.L0().E(patternK, true);
                }
                PatternPlayActivity.this.d = this.b.getId();
                this.b.setName(string);
                PatternPlayActivity.this.onResume();
            }
            ue3.a(this.a.a(), PatternPlayActivity.this.c);
            if (this.b.equals(PatternPlayActivity.this.B)) {
                PatternPlayActivity.this.G.setText(this.b.getName());
            }
        }
    }

    public class m implements yn2<BaseResponseBean> {
        public m() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBean baseResponseBean) {
            if (baseResponseBean != null) {
                if (baseResponseBean.isResult()) {
                    sg3.i(WearUtils.x, R.string.delete_success);
                    return;
                } else {
                    sg3.k(WearUtils.x, baseResponseBean.getMessage());
                    return;
                }
            }
            sg3.j(WearUtils.x, R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            sg3.k(PatternPlayActivity.this.c, netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class n implements PatternPlayButtomDialogActionItemAdapter.d {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ u02 b;

        public n(boolean z, u02 u02Var) {
            this.a = z;
            this.b = u02Var;
        }

        @Override // com.wear.main.closeRange.PatternPlayButtomDialogActionItemAdapter.d
        public void a(PatternPlayButtomDialogActionItemAdapter.b bVar) {
            if (bVar == PatternPlayButtomDialogActionItemAdapter.b.RENAME) {
                if (PatternPlayActivity.this.B.isSystemPattern()) {
                    sg3.l(ah4.e(R.string.default_patterns_error1));
                    return;
                }
                PatternPlayActivity.this.s6(ah4.e(R.string.pattern_name), ah4.e(R.string.pattern_name), PatternPlayActivity.this.B == null ? "" : PatternPlayActivity.this.B.getName());
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.SHARE || bVar == PatternPlayButtomDialogActionItemAdapter.b.EDIT || bVar == PatternPlayButtomDialogActionItemAdapter.b.RESHARE) {
                if (!this.a) {
                    return;
                } else {
                    PatternPlayActivity.this.m6();
                }
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.DELETE) {
                PatternPlayActivity.this.X4();
            }
            this.b.dismiss();
        }
    }

    public class o implements PatternPlayButtomDialogActionItemAdapter.d {
        public final /* synthetic */ u02 a;

        public o(u02 u02Var) {
            this.a = u02Var;
        }

        @Override // com.wear.main.closeRange.PatternPlayButtomDialogActionItemAdapter.d
        public void a(PatternPlayButtomDialogActionItemAdapter.b bVar) {
            if (bVar == PatternPlayButtomDialogActionItemAdapter.b.RENAME) {
                PatternPlayActivity.this.s6(ah4.e(R.string.pattern_name), ah4.e(R.string.pattern_name), PatternPlayActivity.this.B == null ? "" : PatternPlayActivity.this.B.getName());
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.SHARE || bVar == PatternPlayButtomDialogActionItemAdapter.b.RESHARE) {
                PatternPlayActivity.this.q6();
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.DELETE) {
                PatternPlayActivity.this.X4();
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.EDIT) {
                PatternPlayActivity.this.m6();
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.DOWNLOAD) {
                PatternPlayActivity.this.n6();
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.HIDE) {
                PatternPlayActivity patternPlayActivity = PatternPlayActivity.this;
                patternPlayActivity.h5(patternPlayActivity.B);
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.REPORT) {
                if (WearUtils.y.u() == null) {
                    PatternPlayActivity.this.u6(R.string.pattern_store_report_offline_notification);
                    return;
                } else {
                    PatternPlayActivity patternPlayActivity2 = PatternPlayActivity.this;
                    patternPlayActivity2.l6(patternPlayActivity2.B.getId());
                }
            }
            this.a.dismiss();
        }
    }

    public class p implements PatternPlayButtomDialogActionItemAdapter.d {
        public final /* synthetic */ u02 a;

        public p(u02 u02Var) {
            this.a = u02Var;
        }

        @Override // com.wear.main.closeRange.PatternPlayButtomDialogActionItemAdapter.d
        public void a(PatternPlayButtomDialogActionItemAdapter.b bVar) {
            if (bVar == PatternPlayButtomDialogActionItemAdapter.b.RESEND) {
                PatternPlayActivity.this.g6();
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.SAVE) {
                EventBus.getDefault().post(new PatternOrAlarmSaveEvent(PatternPlayActivity.this.U, 1, PatternPlayActivity.this.Q));
                sg3.h(R.string.comman_saved_successfully);
            }
            this.a.dismiss();
        }
    }

    public class q implements PatternPlayButtomDialogActionItemAdapter.d {
        public final /* synthetic */ u02 a;

        public q(u02 u02Var) {
            this.a = u02Var;
        }

        @Override // com.wear.main.closeRange.PatternPlayButtomDialogActionItemAdapter.d
        public void a(PatternPlayButtomDialogActionItemAdapter.b bVar) {
            if (bVar == PatternPlayButtomDialogActionItemAdapter.b.RENAME) {
                PatternPlayActivity.this.s6(ah4.e(R.string.pattern_name), ah4.e(R.string.pattern_name), PatternPlayActivity.this.B == null ? "" : PatternPlayActivity.this.B.getName());
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.SHARE || bVar == PatternPlayButtomDialogActionItemAdapter.b.RESHARE) {
                PatternPlayActivity.this.m6();
            } else if (bVar == PatternPlayButtomDialogActionItemAdapter.b.DELETE) {
                PatternPlayActivity.this.X4();
            }
            this.a.dismiss();
        }
    }

    public class r implements zn2<PatternHiddenSuccBean> {
        public final /* synthetic */ String a;

        public r(String str) {
            this.a = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PatternHiddenSuccBean patternHiddenSuccBean) {
            if (patternHiddenSuccBean.isResult()) {
                EventBus.getDefault().post(new HidePatternEvent(this.a));
            }
            PatternPlayManagerImpl.O().U0();
            PatternPlayActivity.this.a5();
            PatternPlayActivity.this.dissDialog();
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(WearUtils.x, netException.getMessage());
            PatternPlayActivity.this.dissDialog();
        }
    }

    public class s implements yn3.c {
        public final /* synthetic */ Pattern a;

        public class a implements nf3.d {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;

            public a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // dc.nf3.d
            public void onRequestComplete(String str) throws IOException {
                if (WearUtils.e1(str)) {
                    sg3.i(PatternPlayActivity.this, R.string.file_notfound);
                    return;
                }
                if (str.contains("result")) {
                    sg3.i(PatternPlayActivity.this, R.string.file_notfound);
                    return;
                }
                if (rf3.o(str)) {
                    str = rf3.r(str);
                }
                WearUtils.m2(str, this.a);
                Pattern pattern = new Pattern(this.a);
                pattern.setName(this.b);
                pattern.setData(str);
                pattern.setCreator(s.this.a.getEmail());
                pattern.setEmail(WearUtils.y.r());
                pattern.setAuthor(s.this.a.getAuthor());
                pattern.setTimer(s.this.a.getTimer());
                pattern.setToyFunc(s.this.a.getToyTag());
                if (pattern.getHead() != null && !WearUtils.e1(pattern.getHead().getToys()) && pattern.getHead().getToys().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                    pattern.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
                }
                pattern.setStatus(Pattern.DOWNLOAD);
                pattern.setShared(false);
                xe2.L0().t(pattern, true);
                EventBus.getDefault().post(new PatternDownloadEvent(this.a, s.this.a.getToyTag()));
                if (MyApplication.Z) {
                    return;
                }
                HashMap map = new HashMap();
                map.put(TtmlNode.ATTR_ID, this.a);
                tn2.x(WearUtils.x).l("/wear/pattern/liked", map, null);
            }
        }

        public s(Pattern pattern) {
            this.a = pattern;
        }

        @Override // dc.yn3.c
        public void a(String str, String str2) {
            nf3.b(str, new a(PatternPlayActivity.this.B.getId(), str2));
        }

        @Override // dc.yn3.c
        public void doCancel() {
        }
    }

    public class t implements kn3.d {
        public t() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            pj3.t(PatternPlayActivity.this, LoginActivity.class, 2);
            PatternPlayActivity.this.onBackPressed();
        }
    }

    public class u implements kn3.c {
        public final /* synthetic */ do3 a;

        public u(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.c
        public boolean a() {
            String string = this.a.a().getText().toString();
            if (WearUtils.o1(string)) {
                return true;
            }
            sg3.k(PatternPlayActivity.this, WearUtils.l0(PatternPlayActivity.this, string));
            return false;
        }
    }

    public class v implements SeekBar.OnSeekBarChangeListener {
        public v() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                PatternPlayActivity.this.Z4(i);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            PatternPlayActivity.this.Z = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            PatternPlayActivity.this.Z = false;
            PatternPlayManagerImpl.O().Q0(seekBar.getProgress());
        }
    }

    public class w implements kn3.d {
        public final /* synthetic */ do3 a;

        public class a implements rf3.h {
            public final /* synthetic */ String a;

            /* renamed from: com.wear.main.closeRange.PatternPlayActivity$w$a$a, reason: collision with other inner class name */
            public class RunnableC0093a implements Runnable {
                public final /* synthetic */ String a;

                /* renamed from: com.wear.main.closeRange.PatternPlayActivity$w$a$a$a, reason: collision with other inner class name */
                public class C0094a implements kn3.d {
                    public C0094a() {
                    }

                    @Override // dc.kn3.d
                    public void doCancel() {
                    }

                    @Override // dc.kn3.d
                    public void doConfirm() {
                        PatternPlayActivity.this.onResume();
                    }
                }

                public RunnableC0093a(String str) {
                    this.a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.a.equals(SyncWsProtocol.CONTROL_BEGIN_TYPE_KEY)) {
                        rf3.p(PatternPlayActivity.this, new C0094a());
                    } else {
                        PatternPlayActivity.this.l5();
                    }
                }
            }

            public a(String str) {
                this.a = str;
            }

            @Override // dc.rf3.h
            public void a(boolean z, String str) {
                if (z) {
                    PatternPlayActivity.this.addAnalyticsEventId("editSharePattern", null);
                    sg3.h(R.string.patterns_result_update_name);
                    ue2 ue2VarL0 = xe2.L0();
                    Pattern patternK = ue2VarL0.K(PatternPlayActivity.this.B.getId());
                    patternK.setName(this.a);
                    patternK.setLastUpdTime(System.currentTimeMillis());
                    ue2VarL0.E(patternK, true);
                    PatternPlayActivity.this.runOnMainThread(new RunnableC0093a(str));
                }
            }
        }

        public w(do3 do3Var) {
            this.a = do3Var;
        }

        @Override // dc.kn3.d
        public void doCancel() {
            ue3.a(this.a.a(), PatternPlayActivity.this);
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            if (PatternPlayActivity.this.B.isSystemPattern()) {
                sg3.l(ah4.e(R.string.default_patterns_error1));
                return;
            }
            String strTrim = this.a.a().getText().toString().trim();
            if (!PatternPlayActivity.this.B.isShared() || PatternPlayActivity.this.B.isDownload()) {
                sg3.i(PatternPlayActivity.this, R.string.patterns_result_update_name);
                ue2 ue2VarL0 = xe2.L0();
                Pattern patternK = ue2VarL0.K(PatternPlayActivity.this.B.getId());
                patternK.setName(strTrim);
                patternK.setLastUpdTime(System.currentTimeMillis());
                ue2VarL0.E(patternK, true);
            } else {
                rf3.n(PatternPlayActivity.this.B.getId(), strTrim, null, null, new a(strTrim));
            }
            PatternPlayActivity.this.G.setText(strTrim);
            ue3.a(this.a.a(), PatternPlayActivity.this);
        }
    }

    public class x implements ue2.a {
        public x() {
        }

        @Override // dc.ue2.a
        public void a(int i, String str) {
            sg3.i(PatternPlayActivity.this, R.string.file_notfound);
            PatternPlayActivity.this.i6();
        }

        @Override // dc.ue2.a
        public void b(File file) {
            if (PatternPlayActivity.this.B.getData() == null) {
                PatternPlayActivity.this.B.setData(WearUtils.N1(PatternPlayActivity.this.B.getFile().getPath()));
            }
            if (PatternPlayActivity.this.B.isCheckMd5()) {
                Bundle bundle = new Bundle();
                bundle.putString("patternId", PatternPlayActivity.this.B.getId());
                bundle.putBoolean("isUpdate", PatternPlayActivity.this.B.isShared());
                if (!WearUtils.e1(PatternPlayActivity.this.B.getToyFeature()) && PatternPlayActivity.this.B.getToyFeature().toLowerCase().equals(Toy.TOY_FEATURE_XMACHINE.toLowerCase())) {
                    bundle.putString("toyFeature", PatternPlayActivity.this.B.getToyFeature());
                }
                pj3.g(PatternPlayActivity.this, SharePatternActivity.class, bundle);
            }
        }
    }

    public class y implements is3.d {
        public y() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            xe2.L0().f(PatternPlayActivity.this.B.getId(), PatternPlayActivity.this.B.getPath(), null);
        }
    }

    public class z implements is3.d {
        public z() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (PatternPlayActivity.this.B.isSystemPattern()) {
                sg3.l(ah4.e(R.string.default_patterns_error2));
            } else {
                PatternPlayActivity patternPlayActivity = PatternPlayActivity.this;
                patternPlayActivity.k6(patternPlayActivity.B);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D5(View view) {
        new yn3(this, this.B.getPath(), this.B.getName(), new a0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F5(View view) {
        SlidingUpPanelLayout slidingUpPanelLayout = this.T;
        if (slidingUpPanelLayout != null) {
            if (slidingUpPanelLayout.getPanelState() == SlidingUpPanelLayout.e.EXPANDED || this.T.getPanelState() == SlidingUpPanelLayout.e.ANCHORED) {
                this.T.setPanelState(SlidingUpPanelLayout.e.COLLAPSED);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H5(View view) {
        if (this.B.isFavorite()) {
            h6(this.B.getId());
            WearUtils.x.q("pattern_cloud_remove_favorite", null);
        } else {
            W4(this.B.getId());
            WearUtils.x.q("pattern_cloud_add_favorite", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J5(View view) {
        ll3.E().e0("Pattern Play", "click", "ad", this.B.getName(), null);
        mk3.a.B(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M5(View view) {
        r6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R5(View view) {
        this.y = 1;
        PatternPlayManagerImpl.O().E0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V5(AdapterView adapterView, View view, int i2, long j2) {
        Pattern pattern = this.a.get(i2);
        this.B = pattern;
        if (pattern.isSystemPattern() || TextUtils.equals("ChatGPT", this.A) || TextUtils.equals("is_from_vibeMate_pattern", this.A)) {
            this.X.setVisibility(8);
        } else {
            this.X.setVisibility(0);
        }
        this.i.c(i2);
        PatternPlayManagerImpl.O().G0(this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void X5(View view) {
        final bo3 bo3Var = new bo3(this.c, R.layout.layout_patterns_play_list, this.o.getWidth(), this.o.getHeight());
        bo3Var.show();
        this.u = (ImageView) bo3Var.findViewById(R.id.music_play_type);
        this.v = (TextView) bo3Var.findViewById(R.id.music_play_name);
        PatternPlayManagerImpl.O().W0(false);
        this.u.setOnClickListener(new View.OnClickListener() { // from class: dc.l02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PatternPlayManagerImpl.O().W0(true);
            }
        });
        ((ImageView) bo3Var.findViewById(R.id.music_play_close)).setOnClickListener(new View.OnClickListener() { // from class: dc.yz1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bo3Var.dismiss();
            }
        });
        ListView listView = (ListView) bo3Var.findViewById(R.id.music_play_list_choose);
        listView.setAdapter((ListAdapter) this.i);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: dc.a02
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i2, long j2) {
                this.a.V5(adapterView, view2, i2, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z5(View view) {
        x6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b6(View view) {
        x6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d6(u02 u02Var, double d2, int i2) {
        int i3 = (int) (100.0d / d2);
        PatternPlayManagerImpl.O().R0(i3);
        PatternPlayManagerImpl.O().S0(i3);
        this.F = i2 + "";
        eg3.i(this.c, "patternPlaySpeed", i2 + "");
        if (d2 == 1.0d) {
            this.C.setText(R.string.common_pattern_speed_normal);
        } else if (d2 == 0.5d) {
            this.C.setText(String.format("%.1fx", Double.valueOf(d2)));
        } else if (d2 < 1.0d) {
            this.C.setText(String.format("%.2fx", Double.valueOf(d2)));
        } else {
            this.C.setText(String.format("%.0fx", Double.valueOf(d2)));
        }
        u02Var.dismiss();
    }

    @Override // dc.hv1
    public void A3(Pattern pattern, int i2) {
        if (!WearUtils.g1(this.a)) {
            Iterator<Pattern> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().getId().equals(pattern.getId());
            }
        }
        this.B = pattern;
        if (pattern.isFavorite()) {
            this.O.setBackgroundResource(R.drawable.favorite);
        } else {
            this.O.setBackgroundResource(R.drawable.favorite_normal);
        }
        if (pattern.isSystemPattern() || TextUtils.equals("ChatGPT", this.A) || TextUtils.equals("is_from_vibeMate_pattern", this.A)) {
            this.X.setVisibility(8);
        } else {
            this.X.setVisibility(0);
        }
        this.G.setText(pattern.getName());
        this.K.setText(pattern.getAuthor());
        this.L.setText("00:00");
        this.M.setText(String.format("-%s", pattern.getTimer()));
        notifyDataSetChanged();
    }

    public final void A5() {
        this.D = (LinearLayout) findViewById(R.id.ll_speed_view);
        this.C = (TextView) findViewById(R.id.current_speed_view);
        double d2 = this.E[Integer.parseInt(this.F)];
        if (d2 == 1.0d) {
            this.C.setText(R.string.common_pattern_speed_normal);
        } else if (d2 == 0.5d) {
            this.C.setText(String.format("%.1fx", Double.valueOf(d2)));
        } else if (d2 < 1.0d) {
            this.C.setText(String.format("%.2fx", Double.valueOf(d2)));
        } else {
            this.C.setText(String.format("%.0fx", Double.valueOf(d2)));
        }
        this.C.setOnClickListener(new View.OnClickListener() { // from class: dc.d02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.b6(view);
            }
        });
        this.D.setOnClickListener(new View.OnClickListener() { // from class: dc.m02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Z5(view);
            }
        });
    }

    @Override // dc.hv1
    public void B3(String str) {
        str.hashCode();
        switch (str) {
            case "random":
                this.p.setImageResource(R.drawable.playmode_random);
                this.q.setText(ah4.e(R.string.common_random));
                ImageView imageView = this.u;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.playmode_random);
                }
                TextView textView = this.v;
                if (textView != null) {
                    textView.setText(ah4.e(R.string.common_random) + " (" + this.i.getCount() + ")");
                    break;
                }
                break;
            case "repeat":
                this.p.setImageResource(R.drawable.playmode_cycle_single);
                this.q.setText(ah4.e(R.string.common_loop));
                ImageView imageView2 = this.u;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.playmode_cycle_single);
                }
                TextView textView2 = this.v;
                if (textView2 != null) {
                    textView2.setText(ah4.e(R.string.common_loop) + " (" + this.i.getCount() + ")");
                    break;
                }
                break;
            case "loop":
                this.p.setImageResource(R.drawable.playmode_cycle);
                this.q.setText(ah4.e(R.string.pattern_play_loop));
                ImageView imageView3 = this.u;
                if (imageView3 != null) {
                    imageView3.setImageResource(R.drawable.playmode_cycle);
                }
                TextView textView3 = this.v;
                if (textView3 != null) {
                    textView3.setText(ah4.e(R.string.pattern_play_loop) + " (" + this.i.getCount() + ")");
                    break;
                }
                break;
        }
    }

    public final void B5() {
        i5();
        o5();
        v5();
        w5();
        s5();
        u5();
        x5();
        y5();
        A5();
        n5();
        r5();
        q5();
        k5();
        z5();
        j5();
        this.p = (ImageView) findViewById(R.id.play_mode_icon);
        this.q = (TextView) findViewById(R.id.play_mode_text);
        this.o = (LinearLayout) findViewById(R.id.ll_control_layout);
        this.h = (NewCurveLineView) findViewById(R.id.pattern_line);
        this.N = (ConstraintLayout) findViewById(R.id.drawer_layout);
        this.Y = findViewById(R.id.rl_view);
        this.P = (TextView) findViewById(R.id.member_text_view);
        this.S = (RecyclerView) findViewById(R.id.member_list_view);
        this.T = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        this.a0 = (RelativeLayout) findViewById(R.id.rl_control);
        this.W = (ImageView) findViewById(R.id.play_list_icon);
        this.g = (TextView) findViewById(R.id.play_times);
        p5();
    }

    @Override // dc.hv1
    public void D2(Pattern pattern, int i2) {
        this.k.setImageResource(R.drawable.pattern_play_pause);
        this.k.setTag("s");
        this.i.c(this.a.indexOf(pattern));
        this.h.b();
    }

    @Override // dc.hv1
    public void O2(int i2, Pattern pattern, String[] strArr) {
        this.h.a(i2, pattern, strArr);
    }

    @Override // dc.hv1
    public void T3(String str, int i2, String str2) {
        this.h.setBothLinePoint(str);
    }

    @Override // dc.hv1
    public void V1(boolean z2, int i2) {
        this.y = i2;
        if (z2) {
            this.c0.setImageResource(R.drawable.icon_chat_gpt_play);
            this.k.setImageResource(R.drawable.pattern_play_play);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.d0;
            this.e0 = jCurrentTimeMillis;
            if (jCurrentTimeMillis > 5000 && "ChatGPT".equals(this.A)) {
                this.d0 = System.currentTimeMillis();
                HashMap map = new HashMap();
                map.put("page_name", "chatgpt pattern");
                map.put("event_id", "end_play_chatgpt_pattern");
                map.put("element_id", "play_chatgpt_pattern");
                try {
                    String[] strArrSplit = this.B.getTimer().split(SignatureImpl.INNER_SEP);
                    map.put("element_name", Integer.valueOf((Integer.parseInt(strArrSplit[0]) * 60) + Integer.parseInt(strArrSplit[1])));
                    map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(this.e0 / 1000));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                map.put("toys", WearUtils.x.G().m());
                ye3.e("S0009", map);
            }
        } else {
            this.c0.setImageResource(R.drawable.icon_chat_gpt_pause);
            this.k.setImageResource(R.drawable.pattern_play_pause);
        }
        this.d0 = System.currentTimeMillis();
    }

    public final void W4(String str) {
        if (WearUtils.y.u() == null) {
            u6(R.string.pattern_store_like_offline_notification);
            return;
        }
        this.B.setFavorite(true);
        this.O.setBackgroundResource(R.drawable.favorite);
        EventBus.getDefault().post(new PatternFavoriteChangeEvent(true, str, this.B.getToyTag()));
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, str);
        tn2.x(WearUtils.x).l("/wear/pattern/addFavorites", map, new e0());
    }

    @Override // dc.hv1
    public void X3(String str, int i2, int i3, String str2) {
        if (this.Z) {
            return;
        }
        this.g.setText(str);
        this.M.setText(String.format("-%s", str));
        this.L.setText(PatternPlayManagerImpl.O().U());
        this.w.setProgress(i2);
    }

    public final void X4() {
        String strE = ah4.e(R.string.toy_program_delete_pattern);
        if (this.B.isShared() && !this.B.isDownload()) {
            strE = strE + ah4.e(R.string.pattern_shareddelete_warning);
        } else if (ch3.n().X()) {
            strE = ah4.e(R.string.pattern_delete_local_sever);
        }
        cs3.c(this, strE, ah4.e(R.string.common_yes), ah4.e(R.string.common_no), new z()).show();
    }

    public final void Y4() {
        if (TextUtils.equals("ChatGPT", this.A)) {
            c5();
        }
        if (TextUtils.equals("ChatActivity", this.A)) {
            e5();
        }
        if (TextUtils.equals("group_chat", this.A)) {
            d5();
        }
        if (TextUtils.equals("is_from_vibeMate_pattern", this.A)) {
            g5();
        }
        if (TextUtils.equals("pattern_select_page", this.A)) {
            f5();
        }
    }

    public final void Z4(int i2) {
        this.L.setText(WearUtils.Q((i2 * WearUtils.C0(this.B.getTimer())) / 100));
        this.M.setText(String.format("-%s", WearUtils.Q(r0 - r5)));
    }

    public final void a5() {
        PatternPlayManagerImpl.O().F0();
        onBackPressed();
    }

    public final void b5() {
        Intent intent = getIntent();
        this.A = intent.getExtras().getString("from");
        this.B = (Pattern) intent.getExtras().getSerializable("pattern");
        this.y = intent.getIntExtra("intoType", 0);
        this.z = intent.getIntExtra("isFlow", 0);
    }

    public final void c5() {
        this.d0 = System.currentTimeMillis();
        ye3.i("chatgpt pattern", "start_play_chatgpt_pattern", "", "play_chatgpt_pattern", "");
        this.a0.setVisibility(8);
        this.c0.setVisibility(0);
        this.X.setVisibility(8);
        this.f.setYesAction(R.string.common_save, new MyActionBar.f() { // from class: dc.h02
            @Override // com.wear.widget.MyActionBar.f
            public final void performAction(View view) {
                this.a.D5(view);
            }
        });
    }

    public final void d5() {
        e5();
        this.Q = getIntent().getExtras().getString("roomId");
        this.R = getIntent().getExtras().getString("msgId");
        this.N.setVisibility(0);
        f6();
        this.T.o(new b0());
        this.Y.setOnClickListener(new View.OnClickListener() { // from class: dc.k02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.F5(view);
            }
        });
    }

    public final void e5() {
        this.n.setEnabled(false);
        this.W.setEnabled(false);
        this.V = (EntityPattern) getIntent().getExtras().getSerializable("itemPattern");
        this.U = (CommunMessage) getIntent().getExtras().getSerializable("message");
    }

    public final boolean e6() {
        if (this.y == 0) {
            if (!Toy.isContainFunction(this.B.getToyFunc())) {
                sg3.h(R.string.pattern_unsupporte);
                finish();
                return false;
            }
            PatternPlayManagerImpl.O().G0(this.B);
        } else if (PatternPlayManagerImpl.O().T() != null || this.z == 1) {
            PatternPlayManagerImpl.O().R(this.B, new c0());
        } else {
            PatternPlayManagerImpl.O().G0(this.B);
        }
        return true;
    }

    public final void f5() {
        this.O.setVisibility(0);
        if (this.B.isFavorite()) {
            this.O.setBackgroundResource(R.drawable.favorite);
        } else {
            this.O.setBackgroundResource(R.drawable.favorite_normal);
        }
        this.O.setOnClickListener(new View.OnClickListener() { // from class: dc.f02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.H5(view);
            }
        });
    }

    public final void f6() {
        CommunMessage communMessageFindById;
        if (WearUtils.e1(this.R) && (communMessageFindById = DaoUtils.getCommunMessageDao().findById(this.U.getId())) != null) {
            this.U.setMsgId(communMessageFindById.getMsgId());
            this.R = communMessageFindById.getMsgId();
        }
        zb2.O().C0(new RequestPatternOrAlarmList(this.Q, this.R, 1), WearUtils.j0(this.Q), new d0());
    }

    public final void g5() {
        this.X.setVisibility(8);
        ll3.E().e0("Pattern Play", "open", null, this.B.getName(), null);
        TextView textView = (TextView) findViewById(R.id.vb_pattern_play_tv);
        String strE = ah4.e(R.string.vibemate_ad_title);
        String str = String.format(ah4.e(R.string.group_chat_sync_from), strE) + IOUtils.LINE_SEPARATOR_UNIX + ah4.e(R.string.vibemate_slogan);
        textView.setVisibility(0);
        textView.setText(kk3.a.a(str, strE, Color.parseColor("#FF2D89")));
        textView.setOnClickListener(new View.OnClickListener() { // from class: dc.p02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.J5(view);
            }
        });
    }

    public final void g6() {
        ReSendPatternEvent reSendPatternEvent = new ReSendPatternEvent();
        reSendPatternEvent.setMessage(this.U);
        reSendPatternEvent.setEntity(this.V);
        EventBus.getDefault().post(reSendPatternEvent);
    }

    @Override // dc.tz1
    public int getPriority() {
        return 4;
    }

    public final void h5(Pattern pattern) {
        if (WearUtils.y.u() == null) {
            u6(R.string.pattern_store_hide_offline_notification);
        } else {
            showDialog();
            o6(pattern.getId());
        }
    }

    public final void h6(String str) {
        if (WearUtils.y.u() == null) {
            u6(R.string.pattern_store_like_offline_notification);
            return;
        }
        HashMap map = new HashMap();
        map.put("ids", str);
        EventBus.getDefault().post(new PatternFavoriteChangeEvent(false, str, this.B.getToyTag()));
        this.O.setBackgroundResource(R.drawable.favorite_normal);
        this.B.setFavorite(false);
        tn2.x(WearUtils.x).l("/wear/pattern/removeFavorites", map, new f0());
    }

    public final void i5() {
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.f = myActionBar;
        myActionBar.setToy(pc1.a.P());
        this.f.setBackAction(new k());
        this.f.setTitle(ah4.e(R.string.common_pattern_play));
    }

    public void i6() {
        if (this.B != null) {
            xe2.L0().d(this.B, true);
            ve2 ve2Var = this.e;
            ve2Var.M(ve2Var.h(WearUtils.y.r(), this.B.getId()), false);
            DaoUtils.getMediaPatternDao().delById(this.B.getId());
            this.a.remove(this.B);
        }
        this.i.notifyDataSetChanged();
    }

    public final void j5() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_chat_gpt_play);
        this.c0 = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.zz1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PatternPlayManagerImpl.O().E0();
            }
        });
    }

    public void j6(Pattern pattern) {
        DaoUtils.getMediaPatternDao().delById(pattern.getId());
        this.a.remove(pattern);
        EventBus.getDefault().post(new PatternListChangeEvent(pattern));
        notifyDataSetChanged();
        if (pattern.isShared() && !WearUtils.e1(pattern.getEmail()) && pattern.getEmail().equals(WearUtils.y.r())) {
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, pattern.getId());
            tn2.x(WearUtils.x).i("/wear/pattern/delete", map, new m());
        }
    }

    public final void k5() {
        TextView textView = (TextView) findViewById(R.id.current_titme_view);
        this.L = textView;
        textView.setText("00:00");
    }

    public void k6(Pattern pattern) {
        j6(pattern);
        xe2.L0().d(pattern, true);
        ve2 ve2Var = this.e;
        ve2Var.M(ve2Var.h(WearUtils.y.r(), pattern.getId()), true);
        p6();
        if (this.a.size() == 0) {
            a5();
        } else {
            PatternPlayManagerImpl.O().H0(1);
        }
    }

    public final void l5() {
        this.a.clear();
        List<Pattern> listY = xe2.L0().y(WearUtils.y.r());
        if (listY != null) {
            this.a.addAll(listY);
        }
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).setIsNeedReport("1");
        }
        this.i.notifyDataSetChanged();
    }

    public final void l6(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(TtmlNode.ATTR_ID, str);
        pj3.g(this, ReportReasonActivity.class, bundle);
    }

    public final void m5(String str, String str2) {
        FirebaseCrashlytics.getInstance().setCustomKey(str, str2);
        FirebaseCrashlytics.getInstance().recordException(new Throwable());
        a5();
    }

    public final void m6() {
        x xVar = new x();
        if (this.B.getFile().exists()) {
            xVar.b(this.B.getFile());
            return;
        }
        if (!this.B.getFile().exists() && TextUtils.isEmpty(this.B.getPath())) {
            xVar.a(-1, null);
            return;
        }
        if (!ch3.n().X()) {
            xVar.a(-1, null);
            return;
        }
        is3.b bVar = new is3.b(this);
        bVar.p(String.format(ah4.e(R.string.pattern_sync_on_share_failed), this.B.getName()));
        bVar.o(ah4.e(R.string.common_ok));
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.d(new y());
    }

    public final void n5() {
        this.O = (ImageView) findViewById(R.id.favorite_view);
        if (this.B.isFavorite()) {
            this.O.setBackgroundResource(R.drawable.favorite);
        } else {
            this.O.setBackgroundResource(R.drawable.favorite_normal);
        }
    }

    public final void n6() {
        if (this.B.getFile().exists() && xe2.L0().O(WearUtils.y.r(), this.B.getId())) {
            if (MyApplication.Z) {
                sg3.i(this, R.string.pattern_store_offline_redownload_toast);
                return;
            }
            return;
        }
        WearUtils.x.q("pattern_cloud_down", null);
        String str = "";
        String name = TextUtils.isEmpty(this.B.getName()) ? "" : this.B.getName();
        if ((WearUtils.e1(this.B.getIsShowReview()) || !this.B.getIsShowReview().equals("1")) && (WearUtils.e1(this.B.getStatus()) || !this.B.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
            str = name;
        }
        Pattern pattern = this.B;
        new yn3(this, pattern.getCdnPath(), str, new s(pattern));
    }

    public final void notifyDataSetChanged() {
        bk1 bk1Var = this.i;
        if (bk1Var != null) {
            bk1Var.notifyDataSetChanged();
        }
    }

    public final void o5() {
        this.X = (ImageView) findViewById(R.id.menu_actions);
        if (this.B.isSystemPattern()) {
            this.X.setVisibility(8);
        } else {
            this.X.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.A)) {
            this.X.setVisibility(8);
        }
        this.X.setOnClickListener(new View.OnClickListener() { // from class: dc.e02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.M5(view);
            }
        });
    }

    public final void o6(String str) {
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, str);
        tn2.x(WearUtils.x).k("/hide-pattern/save", map, new r(str));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!WearUtils.e1(this.A) && (("ChatActivity".equals(this.A) || "group_chat".equals(this.A) || "ChatGPT".equals(this.A)) && PatternPlayManagerImpl.H)) {
            PatternPlayManagerImpl.O().B0();
            finish();
        } else if (!PatternPlayManagerImpl.H) {
            finish();
        } else if (checkFloatWindowsPermission()) {
            finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.c = this;
        super.onCreate(bundle);
        setContentView(R.layout.remote_pattern_play);
        me3.c(me3.c.MY_PATTERNS_PLAY_UI_ENTER);
        ye3.c("play pattern", "into page", null);
        b5();
        if (this.B == null) {
            m5("pattern error", "error_single_pattern_null");
            return;
        }
        List<Pattern> listO0 = ((xe2) xe2.L0()).O0();
        this.a = listO0;
        if (listO0 == null) {
            m5("patterns error", "error");
            return;
        }
        PatternPlayManagerImpl.O().E = false;
        String strH = eg3.h(this, "patternPlaySpeed", "2");
        this.F = strH;
        if (Double.parseDouble(strH) < 1.0d) {
            this.F = "2";
            eg3.i(this, "patternPlaySpeed", "2");
        }
        this.t = (int) ((1.0d / this.E[Integer.parseInt(this.F)]) * 100.0d);
        if (this.A == null) {
            this.A = "";
        }
        B5();
        Y4();
        this.x = this.B.isSystemPattern();
        this.i = new bk1(this, this.application, this.A);
        this.i.c(this.a.indexOf(this.B));
        this.i.b(this.x);
        t5();
        if (e6()) {
            pc1.a.F();
            EventBus.getDefault().register(this);
            sz1.d().n(this);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.MY_PATTERNS_PLAY_UI_EXIT);
        pc1.a.I();
        EventBus.getDefault().unregister(this);
        sz1.d().s(this);
        PatternPlayManagerImpl.O().N0(this);
        rf3.e();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Pattern patternK;
        super.onResume();
        if (!WearUtils.e1(this.d) && (patternK = xe2.L0().K(this.d)) != null) {
            z6(patternK);
        }
        this.d = "";
        notifyDataSetChanged();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public final void p5() {
        if (!WearUtils.e1(this.B.getToyFunc()) && this.B.getToyFunc().equals("pos")) {
            this.h.setPaintModel(ek2.POSITION.ordinal());
        } else if (WearUtils.e1(this.B.getToyTag()) || !this.B.getToyTag().equals("pos")) {
            this.h.setPaintModel(ek2.SPEED.ordinal());
        } else {
            this.h.setPaintModel(ek2.POSITION.ordinal());
        }
    }

    public final void p6() {
        String strQ = PatternPlayManagerImpl.O().Q();
        strQ.hashCode();
        switch (strQ) {
            case "random":
                TextView textView = this.v;
                if (textView != null) {
                    textView.setText(ah4.e(R.string.common_random) + "( " + this.i.getCount() + " )");
                    break;
                }
                break;
            case "repeat":
                TextView textView2 = this.v;
                if (textView2 != null) {
                    textView2.setText(ah4.e(R.string.common_loop) + "( " + this.i.getCount() + " )");
                    break;
                }
                break;
            case "loop":
                TextView textView3 = this.v;
                if (textView3 != null) {
                    textView3.setText(ah4.e(R.string.pattern_play_loop) + "( " + this.i.getCount() + " )");
                    break;
                }
                break;
        }
    }

    @Override // dc.tz1
    public void pauseConnon(int i2) {
    }

    public final void q5() {
        TextView textView = (TextView) findViewById(R.id.author_text_view);
        this.K = textView;
        textView.setText(this.B.getAuthor());
    }

    public final void q6() {
        if (WearUtils.y.u() == null) {
            u6(R.string.pattern_store_share_offline_notification);
            return;
        }
        Pattern pattern = this.B;
        if (pattern == null || WearUtils.e1(pattern.getData()) || !this.B.isCheckMd5() || WearUtils.e1(this.B.getPath())) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("choose_pattern", this.B);
        pj3.g(this, ForwardMessageActivity.class, bundle);
    }

    public final void r5() {
        TextView textView = (TextView) findViewById(R.id.pattern_name_view);
        this.G = textView;
        textView.setText(this.B.getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r6() {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.closeRange.PatternPlayActivity.r6():void");
    }

    @Override // dc.tz1
    public void recovery() {
    }

    public final void s5() {
        ImageView imageView = (ImageView) findViewById(R.id.pattern_next);
        this.l = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.o02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PatternPlayManagerImpl.O().H0(1);
            }
        });
    }

    public final void s6(String str, String str2, String str3) {
        do3 do3Var = new do3(this, ah4.e(R.string.common_save), ah4.e(R.string.common_cancel));
        do3Var.g(str);
        do3Var.i(str2);
        do3Var.h(str3);
        do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(30)});
        do3Var.b(new u(do3Var));
        do3Var.e();
        do3Var.c(new w(do3Var));
        do3Var.a().requestFocus();
        ue3.d(do3Var.a(), this);
    }

    @Override // dc.tz1
    public void stop(int i2) {
        y6();
    }

    public final void t5() {
        PatternPlayManagerImpl.O().G(this);
        if (TextUtils.equals("is_from_vibeMate_pattern", this.A)) {
            PatternPlayManagerImpl.O().X(this.a, 2);
        } else {
            String str = this.A;
            if (str == null || !("MianActivity".equals(str) || "ChatActivity".equals(this.A))) {
                PatternPlayManagerImpl.O().X(this.a, 1);
            } else {
                PatternPlayManagerImpl.O().X(this.a, 0);
            }
        }
        PatternPlayManagerImpl.O().R0(this.t);
    }

    public final void t6(String str, String str2, String str3, Pattern pattern) {
        do3 do3Var = new do3(this, ah4.e(R.string.common_save), ah4.e(R.string.common_cancel));
        do3Var.g(str);
        do3Var.i(str2);
        do3Var.h(str3);
        do3Var.a().setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        do3Var.b(new j(do3Var));
        do3Var.e();
        do3Var.c(new l(do3Var, pattern));
        do3Var.a().requestFocus();
        ue3.d(do3Var.a(), this.c);
    }

    @Override // dc.hv1
    public void u3(boolean z2) {
        p5();
        this.h.setShowBothLine(true);
    }

    public final void u5() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.play_mode);
        this.m = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.j02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PatternPlayManagerImpl.O().W0(true);
            }
        });
    }

    public final void u6(int i2) {
        kn3 kn3Var = new kn3((Context) this, ah4.e(i2), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), true, (kn3.d) new t());
        kn3Var.show();
        kn3Var.p();
    }

    public final void v5() {
        ImageView imageView = (ImageView) findViewById(R.id.pattern_pre);
        this.j = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.b02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PatternPlayManagerImpl.O().H0(-1);
            }
        });
    }

    public void v6(Pattern pattern, View view) {
        boolean z2 = false;
        if (this.A.equals("MianActivity")) {
            if (!MyApplication.Z && !pattern.isDownload() && pattern.getCreator().equals(WearUtils.y.r())) {
                z2 = true;
            }
            w6(view, z2, pattern.isShared(), pattern);
            return;
        }
        ao3 ao3Var = new ao3(this, R.style.MenuDialogAl, R.layout.select_pattern_more_type);
        ao3Var.a(view, 250, pattern.getEmail().contains(WearUtils.y.r()) ? 200 : CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 5160, -30, new e(this));
        ao3Var.findViewById(R.id.action_row_2).setOnClickListener(new f(ao3Var, pattern));
        if ("Lovense-pick".equals(pattern.getTagName()) || AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(pattern.getStatus())) {
            LinearLayout linearLayout = (LinearLayout) ao3Var.findViewById(R.id.action_row_3);
            linearLayout.setAlpha(0.5f);
            linearLayout.setClickable(false);
        } else {
            ao3Var.findViewById(R.id.action_row_3).setOnClickListener(new g(ao3Var, pattern));
        }
        if (MyApplication.Z || WearUtils.e1(pattern.getEmail()) || !pattern.getEmail().equals(WearUtils.y.r())) {
            ((LinearLayout) ao3Var.findViewById(R.id.ll_row_1)).setVisibility(8);
        } else {
            ((LinearLayout) ao3Var.findViewById(R.id.ll_row_1)).setVisibility(0);
            ((LinearLayout) ao3Var.findViewById(R.id.ll_row_1)).setOnClickListener(new h(pattern));
        }
        ao3Var.findViewById(R.id.action_row_4).setOnClickListener(new i(ao3Var, pattern));
        ao3Var.show();
    }

    public final void w5() {
        ImageView imageView = (ImageView) findViewById(R.id.pattern_stop);
        this.k = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.n02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R5(view);
            }
        });
    }

    public final void w6(View view, boolean z2, boolean z3, Pattern pattern) {
        ao3 ao3Var = new ao3(this, R.style.MenuDialogAl, R.layout.select_menu_dialog_item);
        ao3Var.a(view, 250, 200, 5160, -30, new g0(this));
        ao3Var.findViewById(R.id.action_row_0).setOnClickListener(new a(ao3Var, pattern));
        ao3Var.findViewById(R.id.action_row_1).setOnClickListener(new b(ao3Var, pattern));
        ao3Var.findViewById(R.id.action_row_2).setOnClickListener(new c(ao3Var, pattern));
        ao3Var.findViewById(R.id.action_row_3).setOnClickListener(new d(ao3Var, pattern));
        if (!z2 || MyApplication.Z) {
            ao3Var.findViewById(R.id.action_row_1).setAlpha(0.4f);
            ao3Var.findViewById(R.id.action_row_1).setEnabled(false);
            ao3Var.findViewById(R.id.action_row_1).setOnClickListener(null);
            ((TextView) ao3Var.findViewById(R.id.action_row_1_text)).setText(ah4.e(R.string.common_share));
        } else {
            if (z3) {
                ((TextView) ao3Var.findViewById(R.id.action_row_1_text)).setText(ah4.e(R.string.common_reshared));
            } else {
                ((TextView) ao3Var.findViewById(R.id.action_row_1_text)).setText(ah4.e(R.string.common_share));
            }
            ao3Var.findViewById(R.id.action_row_1).setAlpha(1.0f);
            ao3Var.findViewById(R.id.action_row_1).setEnabled(true);
        }
        ao3Var.show();
    }

    public final void x5() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.play_list);
        this.n = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.i02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.X5(view);
            }
        });
    }

    public final void x6() {
        final u02 u02Var = new u02(this, R.style.MaterialDialogSheet);
        PatternPlaySpeedOptionsAdapter patternPlaySpeedOptionsAdapter = new PatternPlaySpeedOptionsAdapter(this.E, this.F);
        patternPlaySpeedOptionsAdapter.p(new PatternPlaySpeedOptionsAdapter.a() { // from class: dc.g02
            @Override // com.wear.main.closeRange.PatternPlaySpeedOptionsAdapter.a
            public final void a(double d2, int i2) {
                this.a.d6(u02Var, d2, i2);
            }
        });
        u02Var.c(patternPlaySpeedOptionsAdapter);
        u02Var.show();
    }

    public final void y5() {
        SeekBar seekBar = (SeekBar) findViewById(R.id.play_seek_bar);
        this.w = seekBar;
        seekBar.setOnSeekBarChangeListener(new v());
    }

    public void y6() {
        this.application.G().u0();
        a5();
    }

    @Override // dc.hv1
    public void z1() {
        this.k.setImageResource(R.drawable.pattern_play_play);
        this.c0.setImageResource(R.drawable.icon_chat_gpt_play);
        if (!"ChatGPT".equals(this.A) || PatternPlayManagerImpl.O().e0() || System.currentTimeMillis() - this.d0 <= 5000) {
            return;
        }
        HashMap map = new HashMap();
        map.put("page_name", "chatgpt pattern");
        map.put("event_id", "end_play_chatgpt_pattern");
        map.put("element_id", "play_chatgpt_pattern");
        try {
            String[] strArrSplit = this.B.getTimer().split(SignatureImpl.INNER_SEP);
            map.put("element_name", Integer.valueOf((Integer.parseInt(strArrSplit[0]) * 60) + Integer.parseInt(strArrSplit[1])));
            String[] strArrSplit2 = PatternPlayManagerImpl.O().U().split(SignatureImpl.INNER_SEP);
            map.put(TypedValues.TransitionType.S_DURATION, Integer.valueOf((Integer.parseInt(strArrSplit2[0]) * 60) + Integer.parseInt(strArrSplit2[1])));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        map.put("toys", WearUtils.x.G().m());
        ye3.e("S0009", map);
    }

    @Override // dc.hv1
    public void z3(float f2) {
        this.h.setFirstLinePoint(f2);
    }

    public final void z5() {
        String str = String.format("-%s", this.B.getTimer());
        TextView textView = (TextView) findViewById(R.id.remain_time_view);
        this.M = textView;
        textView.setText(str);
    }

    public final void z6(Pattern pattern) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.a.size()) {
                i2 = -1;
                break;
            } else if (this.a.get(i2).getId().equals(pattern.getId())) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            this.a.set(i2, pattern);
        }
    }
}
