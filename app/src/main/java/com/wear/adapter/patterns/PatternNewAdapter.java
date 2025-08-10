package com.wear.adapter.patterns;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.bean.event.PatternDownloadEvent;
import com.wear.bean.event.PatternFavoriteChangeEvent;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.closeRange.PatternPlayActivity;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.ForwardMessageActivity;
import com.wear.main.patterns.SharePatternActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.discover.pattern.PatternStoreActivity;
import com.wear.ui.discover.pattern.PatternsItemFragment;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.control.NewCurveLineView;
import dc.ah4;
import dc.ao3;
import dc.db2;
import dc.ek2;
import dc.ff3;
import dc.h12;
import dc.kf;
import dc.kn3;
import dc.na2;
import dc.nf3;
import dc.ng3;
import dc.pj3;
import dc.qo;
import dc.rf3;
import dc.sg3;
import dc.th4;
import dc.tn2;
import dc.uu1;
import dc.xe2;
import dc.y12;
import dc.yn3;
import dc.zn2;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class PatternNewAdapter extends RecyclerView.Adapter<PatternViewHolder> {
    public PatternsItemFragment a;
    public List<Pattern> b;
    public Context c;
    public qo d = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);

    public class a implements ao3.a {
        public a(PatternNewAdapter patternNewAdapter) {
        }

        @Override // dc.ao3.a
        public void a(ao3 ao3Var) {
        }

        @Override // dc.ao3.a
        public void b(ao3 ao3Var) {
        }
    }

    public class b extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ PatternViewHolder b;

        public b(Pattern pattern, PatternViewHolder patternViewHolder) {
            this.a = pattern;
            this.b = patternViewHolder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(Pattern pattern) {
            PatternPlayManagerImpl.O().X(PatternNewAdapter.this.b, 1);
            PatternPlayManagerImpl.O().G0(pattern);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h() {
            PatternPlayManagerImpl.O().U0();
            sg3.i(PatternNewAdapter.this.a.getActivity(), R.string.file_notfound);
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws Throwable {
            if (!z) {
                if (PatternNewAdapter.this.a.getActivity() != null) {
                    PatternNewAdapter.this.a.getActivity().runOnUiThread(new Runnable() { // from class: dc.hm1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.h();
                        }
                    });
                    return;
                }
                return;
            }
            String strN1 = WearUtils.N1(((File) obj).getPath());
            if (rf3.o(strN1)) {
                strN1 = rf3.r(strN1);
                WearUtils.m2(strN1, this.a.getId());
            }
            this.a.setData(strN1);
            if (PatternNewAdapter.this.a.getActivity() != null) {
                FragmentActivity activity = PatternNewAdapter.this.a.getActivity();
                final Pattern pattern = this.a;
                activity.runOnUiThread(new Runnable() { // from class: dc.im1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.f(pattern);
                    }
                });
            }
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, this.b.a);
            map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            tn2.x(WearUtils.x).l("/wear/pattern/play", map, null);
            WearUtils.x.q("pattern_cloud_play", null);
        }
    }

    public class c implements yn3.c {
        public final /* synthetic */ PatternViewHolder a;
        public final /* synthetic */ Pattern b;

        public c(PatternViewHolder patternViewHolder, Pattern pattern) {
            this.a = patternViewHolder;
            this.b = pattern;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(String str, String str2, Pattern pattern, PatternViewHolder patternViewHolder, String str3) throws IOException {
            if (WearUtils.e1(str3)) {
                sg3.i(PatternNewAdapter.this.a.getActivity(), R.string.file_notfound);
                return;
            }
            if (str3.contains("result")) {
                sg3.i(PatternNewAdapter.this.a.getActivity(), R.string.file_notfound);
                return;
            }
            if (rf3.o(str3)) {
                str3 = rf3.r(str3);
            }
            WearUtils.m2(str3, str);
            Pattern pattern2 = new Pattern(str);
            pattern2.setName(str2);
            pattern2.setData(str3);
            pattern2.setCreator(pattern.getEmail());
            pattern2.setEmail(WearUtils.y.r());
            pattern2.setAuthor(pattern.getAuthor());
            pattern2.setTimer(pattern.getTimer());
            pattern2.setToyFunc(pattern.getToyTag());
            pattern2.setToyName(pattern.getToyName());
            pattern2.setToySymbol(pattern.getToySymbol());
            pattern2.setToyVersion(pattern.getToyVersion());
            if (pattern2.getHead() != null && !WearUtils.e1(pattern2.getHead().getToys()) && pattern2.getHead().getToys().equalsIgnoreCase(Toy.TOY_XMACHINE)) {
                pattern2.setToyFeature(Toy.TOY_FEATURE_XMACHINE);
            }
            pattern2.setStatus(Pattern.DOWNLOAD);
            pattern2.setShared(false);
            xe2.L0().t(pattern2, true);
            EventBus.getDefault().post(new PatternDownloadEvent(str, pattern.getToyTag()));
            if (MyApplication.Z) {
                return;
            }
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, patternViewHolder.a);
            tn2.x(WearUtils.x).l("/wear/pattern/liked", map, null);
        }

        @Override // dc.yn3.c
        public void a(String str, final String str2) {
            final PatternViewHolder patternViewHolder = this.a;
            final String str3 = patternViewHolder.a;
            final Pattern pattern = this.b;
            nf3.b(str, new nf3.d() { // from class: dc.jm1
                @Override // dc.nf3.d
                public final void onRequestComplete(String str4) throws IOException {
                    this.a.c(str3, str2, pattern, patternViewHolder, str4);
                }
            });
        }

        @Override // dc.yn3.c
        public void doCancel() {
        }
    }

    public class d extends ff3 {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ PatternViewHolder b;

        public d(Pattern pattern, PatternViewHolder patternViewHolder) {
            this.a = pattern;
            this.b = patternViewHolder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void f(Pattern pattern) {
            PatternPlayManagerImpl.O().X(PatternNewAdapter.this.b, 1);
            PatternPlayManagerImpl.O().G0(pattern);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void h() {
            PatternPlayManagerImpl.O().U0();
            sg3.i(PatternNewAdapter.this.a.getActivity(), R.string.file_notfound);
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws Throwable {
            if (!z) {
                if (PatternNewAdapter.this.a.getActivity() != null) {
                    PatternNewAdapter.this.a.getActivity().runOnUiThread(new Runnable() { // from class: dc.km1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.h();
                        }
                    });
                    return;
                }
                return;
            }
            String strN1 = WearUtils.N1(((File) obj).getPath());
            if (rf3.o(strN1)) {
                strN1 = rf3.r(strN1);
                WearUtils.m2(strN1, this.a.getId());
            }
            this.a.setData(strN1);
            if (PatternNewAdapter.this.a.getActivity() != null) {
                FragmentActivity activity = PatternNewAdapter.this.a.getActivity();
                final Pattern pattern = this.a;
                activity.runOnUiThread(new Runnable() { // from class: dc.lm1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.f(pattern);
                    }
                });
            }
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, this.b.a);
            map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
            tn2.x(WearUtils.x).l("/wear/pattern/play", map, null);
            WearUtils.x.q("pattern_cloud_play", null);
        }
    }

    public class e implements kn3.d {
        public e() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            pj3.t(PatternNewAdapter.this.c, LoginActivity.class, 2);
        }
    }

    public class f implements zn2<String> {
        public f() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(PatternNewAdapter.this.c, netException.getMessage());
        }
    }

    public class g implements zn2<String> {
        public g() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (normalResponse == null) {
                sg3.i(PatternNewAdapter.this.c, R.string.patterns_result_remove_failed);
            } else {
                if (normalResponse.isResult()) {
                    return;
                }
                sg3.i(PatternNewAdapter.this.c, R.string.patterns_result_remove_failed);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(PatternNewAdapter.this.c, netException.getMessage());
        }
    }

    public PatternNewAdapter(List<Pattern> list, MyApplication myApplication, Context context, PatternsItemFragment patternsItemFragment) {
        this.b = list;
        this.c = context;
        this.a = patternsItemFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(PatternViewHolder patternViewHolder, Pattern pattern, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("patternId", patternViewHolder.a);
        bundle.putBoolean("isUpdate", true);
        if (!WearUtils.e1(pattern.getToyFeature()) && pattern.getToyFeature().equalsIgnoreCase(Toy.TOY_FEATURE_XMACHINE)) {
            bundle.putString("toyFeature", pattern.getToyFeature());
        }
        pj3.p((Activity) this.c, SharePatternActivity.class, 48, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(ao3 ao3Var, PatternViewHolder patternViewHolder, View view) {
        ao3Var.dismiss();
        if (WearUtils.y.u() == null) {
            Y(R.string.pattern_store_hide_offline_notification);
        } else {
            this.a.k0(patternViewHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(final Pattern pattern, final int i, final PatternViewHolder patternViewHolder, View view) {
        final ao3 ao3Var = new ao3(this.a.getActivity(), R.style.MenuDialogAl, R.layout.select_pattern_more_type);
        ao3Var.a(view, 250, pattern.getEmail().contains(WearUtils.y.r()) ? 200 : CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 5160, -30, new a(this));
        ao3Var.findViewById(R.id.action_row_2).setOnClickListener(new View.OnClickListener() { // from class: dc.om1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.x(ao3Var, i, view2);
            }
        });
        if ("Lovense-pick".equals(pattern.getTagName()) || AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(pattern.getStatus())) {
            LinearLayout linearLayout = (LinearLayout) ao3Var.findViewById(R.id.action_row_3);
            linearLayout.setAlpha(0.5f);
            linearLayout.setClickable(false);
        } else {
            ao3Var.findViewById(R.id.action_row_3).setOnClickListener(new View.OnClickListener() { // from class: dc.um1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.z(ao3Var, patternViewHolder, view2);
                }
            });
        }
        if (MyApplication.Z || WearUtils.e1(pattern.getEmail()) || !pattern.getEmail().equals(WearUtils.y.r())) {
            ao3Var.findViewById(R.id.ll_row_1).setVisibility(8);
        } else {
            ao3Var.findViewById(R.id.ll_row_1).setVisibility(0);
            ao3Var.findViewById(R.id.ll_row_1).setOnClickListener(new View.OnClickListener() { // from class: dc.mm1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.B(patternViewHolder, pattern, view2);
                }
            });
        }
        ao3Var.findViewById(R.id.action_row_4).setOnClickListener(new View.OnClickListener() { // from class: dc.tm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.D(ao3Var, patternViewHolder, view2);
            }
        });
        ao3Var.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(Pattern pattern, PatternViewHolder patternViewHolder, Pattern pattern2, int i, boolean z, String str, String str2, int i2, String[] strArr) {
        if (!WearUtils.e1(pattern2.getData())) {
            X(pattern, patternViewHolder.patternPlayCurve);
            if (pattern2.getHead() == null) {
                patternViewHolder.patternPlayCurve.setInitData(null, pattern2.getData().split(","), true);
            } else {
                patternViewHolder.patternPlayCurve.setInitData(pattern2.getHead(), pattern2.getData().split(";"), false);
            }
        }
        boolean zD0 = PatternPlayManagerImpl.O().d0();
        patternViewHolder.patternPlayCurve.setShowBothLine(z);
        patternViewHolder.patternPlayCurve.a(i2, pattern2, strArr);
        patternViewHolder.patternTimes.setText(str);
        patternViewHolder.patternPlayCurve.setBothLinePoint(str2);
        if (zD0) {
            patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_play);
        } else {
            patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_pause);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(Pattern pattern, PatternViewHolder patternViewHolder) {
        if (!na2.m().t() && y12.c.a().s(y12.c.TYPE_PATTERN)) {
            PatternPlayManagerImpl.O().C0();
            PatternPlayManagerImpl.O().G(this.a);
            if (!pattern.getToyTag().equals("pos") || MusicControl.h0().u) {
                MusicControl.h0().S();
            }
            String path = pattern.getPath();
            if (pattern.getData() != null && pattern.getData().contains("result")) {
                PatternPlayManagerImpl.O().U0();
                sg3.i(this.a.getActivity(), R.string.file_notfound);
                return;
            }
            h12.D.isPlayPatternOnHomePattern = true;
            if (MusicControl.h0().O()) {
                EventBus.getDefault().post(h12.D);
            }
            if (WearUtils.e1(pattern.getData())) {
                WearUtils.E0(true, path, new d(pattern, patternViewHolder));
            } else {
                int iF0 = PatternPlayManagerImpl.O().f0(pattern);
                if (iF0 <= 0) {
                    PatternPlayManagerImpl.O().X(this.b, 1);
                    PatternPlayManagerImpl.O().G0(pattern);
                } else if (iF0 == 1) {
                    PatternPlayManagerImpl.O().E0();
                    h12.D.isPlayPatternOnHomePattern = false;
                }
            }
            patternViewHolder.patternSingleTitle.setVisibility(0);
            Bundle bundle = new Bundle();
            Pattern patternT = PatternPlayManagerImpl.O().T();
            Iterator<Pattern> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pattern next = it.next();
                if (next.getId().equals(patternT.getId())) {
                    bundle.putSerializable("pattern", next);
                    break;
                }
            }
            if (PatternPlayManagerImpl.O().T() == null || PatternPlayManagerImpl.O().f0(pattern) == 0) {
                bundle.putSerializable("intoType", 1);
            } else {
                bundle.putSerializable("intoType", 1);
                bundle.putSerializable("isFlow", 1);
            }
            bundle.putString("from", "pattern_select_page");
            ((xe2) xe2.L0()).J1(this.b);
            pj3.g(this.c, PatternPlayActivity.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(final Pattern pattern, final PatternViewHolder patternViewHolder, View view) {
        db2.A().q(new db2.s() { // from class: dc.wm1
            @Override // dc.db2.s
            public final void a() {
                this.a.J(pattern, patternViewHolder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(PatternViewHolder patternViewHolder, Pattern pattern, View view) {
        V(patternViewHolder, pattern.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(Pattern pattern, PatternViewHolder patternViewHolder) {
        if (!na2.m().t() && y12.c.a().s(y12.c.TYPE_PATTERN)) {
            if (!Toy.isContainFunction(pattern.getToyFunc())) {
                sg3.h(R.string.pattern_unsupporte);
                return;
            }
            PatternPlayManagerImpl.O().C0();
            PatternPlayManagerImpl.O().G(this.a);
            MusicControl.h0().S();
            if (PatternPlayManagerImpl.O().f0(pattern) > 0) {
                PatternPlayManagerImpl.O().E0();
                WearUtils.x.q("pattern_cloud_play_duation", null);
                h12.D.isPlayPatternOnHomePattern = false;
                return;
            }
            String path = pattern.getPath();
            if (pattern.getData() != null && pattern.getData().contains("result")) {
                PatternPlayManagerImpl.O().U0();
                sg3.i(this.a.getActivity(), R.string.file_notfound);
                return;
            }
            h12.D.isPlayPatternOnHomePattern = true;
            if (MusicControl.h0().O()) {
                EventBus.getDefault().post(h12.D);
            }
            PatternPlayManagerImpl.O().E = false;
            if (WearUtils.e1(pattern.getData())) {
                WearUtils.E0(true, path, new b(pattern, patternViewHolder));
            } else {
                PatternPlayManagerImpl.O().X(this.b, 1);
                PatternPlayManagerImpl.O().G0(pattern);
            }
            patternViewHolder.patternSingleTitle.setVisibility(0);
        }
    }

    public static void W(@NonNull PatternViewHolder patternViewHolder, Pattern pattern) {
        String[] strArrSplit = pattern.getToyTag().split(",");
        int i = 0;
        patternViewHolder.toyType2.setVisibility(strArrSplit.length > 1 ? 0 : 8);
        patternViewHolder.toyType3.setVisibility(strArrSplit.length > 2 ? 0 : 8);
        while (i < strArrSplit.length) {
            ImageView imageView = i == 0 ? patternViewHolder.toyType1 : patternViewHolder.toyType2;
            if (i == 2) {
                imageView = patternViewHolder.toyType3;
            }
            boolean zEquals = TextUtils.equals(strArrSplit[i], PSOProgramService.VS_Key);
            int i2 = R.drawable.icon_label_toy_function_speed;
            if (zEquals || TextUtils.equals(strArrSplit[i], "v1")) {
                if (uu1.b(pattern.getToySymbol())) {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_speed);
                } else {
                    imageView.setImageResource(R.drawable.icon_label_toy_function_vibration);
                }
            }
            if (TextUtils.equals(strArrSplit[i], "v2")) {
                imageView.setImageResource(R.drawable.icon_label_toy_function_vibration_2);
            }
            if (TextUtils.equals(strArrSplit[i], "v3")) {
                imageView.setImageResource(R.drawable.dark_home_wave);
            }
            if (TextUtils.equals(strArrSplit[i], "p")) {
                imageView.setImageResource(R.drawable.icon_label_toy_function_contraction);
            }
            if (TextUtils.equals(strArrSplit[i], StreamManagement.AckRequest.ELEMENT)) {
                imageView.setImageResource(R.drawable.icon_label_toy_function_rotation);
            }
            if (TextUtils.equals(strArrSplit[i], "t")) {
                if (i == 0) {
                    i2 = R.drawable.icon_label_toy_function_thrusting;
                }
                imageView.setImageResource(i2);
            }
            if (TextUtils.equals(strArrSplit[i], "s")) {
                imageView.setImageResource(R.drawable.icon_white_function_suction);
            }
            if (TextUtils.equals(strArrSplit[i], "f")) {
                imageView.setImageResource(R.drawable.icon_label_toy_function_fingering);
            }
            if (TextUtils.equals(strArrSplit[i], GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG)) {
                imageView.setImageResource(R.drawable.icon_label_toy_function_depth);
            }
            if (TextUtils.equals(strArrSplit[i], "pos")) {
                imageView.setImageResource(R.drawable.icon_velvo_position);
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(PatternViewHolder patternViewHolder, Pattern pattern, View view) {
        if ("Like".equals(this.a.l)) {
            V(patternViewHolder, pattern.getId());
            WearUtils.x.q("pattern_cloud_remove_favorite", null);
        } else if (pattern.isFavorite()) {
            V(patternViewHolder, pattern.getId());
            WearUtils.x.q("pattern_cloud_remove_favorite", null);
        } else {
            l(patternViewHolder, pattern.getId());
            WearUtils.x.q("pattern_cloud_add_favorite", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(Pattern pattern, PatternViewHolder patternViewHolder, View view) {
        U(pattern, patternViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Pattern pattern, PatternViewHolder patternViewHolder, View view) {
        if (pattern.getFile().exists() && xe2.L0().O(WearUtils.y.r(), pattern.getId())) {
            if (MyApplication.Z) {
                sg3.i(this.a.getActivity(), R.string.pattern_store_offline_redownload_toast);
                return;
            }
            return;
        }
        WearUtils.x.q("pattern_cloud_down", null);
        String str = "";
        String name = TextUtils.isEmpty(pattern.getName()) ? "" : pattern.getName();
        if ((WearUtils.e1(pattern.getIsShowReview()) || !pattern.getIsShowReview().equals("1")) && (WearUtils.e1(pattern.getStatus()) || !pattern.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
            str = name;
        }
        Z(patternViewHolder, pattern, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(ao3 ao3Var, int i, View view) {
        ao3Var.dismiss();
        if (WearUtils.y.u() == null) {
            Y(R.string.pattern_store_share_offline_notification);
            return;
        }
        Pattern pattern = this.b.get(i);
        if (pattern == null || WearUtils.e1(pattern.getData()) || !pattern.isCheckMd5() || WearUtils.e1(pattern.getPath())) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("choose_pattern", pattern);
        pj3.g(this.c, ForwardMessageActivity.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(ao3 ao3Var, PatternViewHolder patternViewHolder, View view) {
        ao3Var.dismiss();
        if (WearUtils.y.u() == null) {
            Y(R.string.pattern_store_report_offline_notification);
        } else {
            this.a.z0(patternViewHolder);
            WearUtils.x.q("pattern_cloud_report", null);
        }
    }

    public final void Q(final PatternViewHolder patternViewHolder, final Pattern pattern) {
        patternViewHolder.llPattern.setOnClickListener(new View.OnClickListener() { // from class: dc.qm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.L(pattern, patternViewHolder, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull final PatternViewHolder patternViewHolder, int i) {
        final Pattern pattern = this.b.get(i);
        patternViewHolder.a = pattern.getId();
        patternViewHolder.b = pattern;
        if ((WearUtils.e1(pattern.getIsShowReview()) || !pattern.getIsShowReview().equals("1")) && (WearUtils.e1(pattern.getStatus()) || !pattern.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
            patternViewHolder.iv_under_preview.setVisibility(8);
            patternViewHolder.patternSingleTitle.setText(TextUtils.isEmpty(pattern.getName()) ? "" : pattern.getName());
        } else {
            patternViewHolder.iv_under_preview.setVisibility(0);
            patternViewHolder.patternSingleTitle.setText(R.string.patterns_under_review);
        }
        patternViewHolder.patternTimes.setText(pattern.getTimer());
        if (WearUtils.e1(pattern.getAuthor()) || "Anonymous".equals(pattern.getAuthor())) {
            patternViewHolder.rvPatternAuth.setText(ah4.e(R.string.common_anonymous));
        } else {
            patternViewHolder.rvPatternAuth.setText(pattern.getAuthor());
        }
        if (WearUtils.e1(pattern.getToyTag())) {
            patternViewHolder.toyType1.setImageResource(R.drawable.icon_label_toy_function_vibration);
            patternViewHolder.toyType2.setVisibility(8);
            patternViewHolder.toyType3.setVisibility(8);
        } else {
            W(patternViewHolder, pattern);
        }
        if (WearUtils.e1(pattern.getToyName())) {
            String strD = ng3.d(pattern.getToyTag(), pattern.getCdtTime(), pattern.getToyFeature());
            if (WearUtils.e1(Toy.getFullName(strD))) {
                patternViewHolder.mTvPatternToyName.setVisibility(8);
            } else {
                patternViewHolder.mTvPatternToyName.setVisibility(0);
                patternViewHolder.mTvPatternToyName.setText(ng3.c(Toy.getFullName(strD), pattern.getToyVersion()));
            }
        } else {
            patternViewHolder.mTvPatternToyName.setText(ng3.c(pattern.getToyName(), pattern.getToyVersion()));
            patternViewHolder.mTvPatternToyName.setVisibility(0);
        }
        if (pattern.getCreated() != null) {
            patternViewHolder.tvPatternSendTime.setText(WearUtils.F0(pattern.getCreated()));
        }
        patternViewHolder.removedTopView.setVisibility(8);
        if (!WearUtils.e1(pattern.getStatus()) && (pattern.getStatus().equalsIgnoreCase("report") || pattern.getStatus().equalsIgnoreCase("removed"))) {
            patternViewHolder.removedTopView.setVisibility(0);
            if (WearUtils.e1(pattern.getData())) {
                patternViewHolder.patternPlayCurve.b();
            } else {
                X(pattern, patternViewHolder.patternPlayCurve);
                if (pattern.getHead() == null) {
                    patternViewHolder.patternPlayCurve.setInitData(null, pattern.getData().split(","), true);
                } else {
                    patternViewHolder.patternPlayCurve.setInitData(pattern.getHead(), pattern.getData().split(";"), false);
                }
            }
            patternViewHolder.ivRemovedAction.setOnClickListener(new View.OnClickListener() { // from class: dc.sm1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.N(patternViewHolder, pattern, view);
                }
            });
            return;
        }
        patternViewHolder.patternPlay.setTag(Boolean.FALSE);
        patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_play);
        o(patternViewHolder, pattern);
        n(patternViewHolder, pattern);
        p(patternViewHolder, pattern);
        m(patternViewHolder, i, pattern);
        String tagAvatarUrl = pattern.getTagAvatarUrl();
        if (TextUtils.isEmpty(tagAvatarUrl)) {
            patternViewHolder.patternIcon.setImageResource(R.drawable.home_pattern_avatar);
        } else {
            if (!tagAvatarUrl.startsWith("http")) {
                tagAvatarUrl = WearUtils.e + tagAvatarUrl;
            }
            kf.w(patternViewHolder.patternIcon.getContext()).v(tagAvatarUrl).a(this.d).A0(patternViewHolder.patternIcon);
        }
        String tagName = pattern.getTagName();
        if (TextUtils.isEmpty(tagName)) {
            patternViewHolder.iv_lovense_pick.setVisibility(8);
        } else {
            patternViewHolder.iv_lovense_pick.setVisibility("Lovense-pick".equals(tagName) ? 0 : 8);
        }
        Q(patternViewHolder, pattern);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull PatternViewHolder patternViewHolder, int i, @NonNull List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(patternViewHolder, i);
            return;
        }
        Pattern pattern = this.b.get(i);
        for (Object obj : list) {
            if (TextUtils.equals(Pattern.DOWNLOAD, obj.toString())) {
                o(patternViewHolder, pattern);
            } else if (TextUtils.equals("like", obj.toString())) {
                p(patternViewHolder, pattern);
            } else if (TextUtils.equals("getServerFile", obj.toString())) {
                n(patternViewHolder, pattern);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public PatternViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PatternViewHolder(LayoutInflater.from(this.c).inflate(R.layout.item_pattern_item_layout, viewGroup, false), this.c);
    }

    public final void U(final Pattern pattern, final PatternViewHolder patternViewHolder) {
        db2.A().q(new db2.s() { // from class: dc.rm1
            @Override // dc.db2.s
            public final void a() {
                this.a.P(pattern, patternViewHolder);
            }
        });
    }

    public final void V(PatternViewHolder patternViewHolder, String str) {
        if (WearUtils.y.u() == null) {
            Y(R.string.pattern_store_like_offline_notification);
            return;
        }
        HashMap map = new HashMap();
        map.put("ids", patternViewHolder.a);
        EventBus.getDefault().post(new PatternFavoriteChangeEvent(false, str, patternViewHolder.b.getToyTag()));
        patternViewHolder.ivPatternLike.setImageResource(R.drawable.patterns_patternlist_favorite);
        PatternPlayManagerImpl.O().P0(str, false);
        tn2.x(WearUtils.x).l("/wear/pattern/removeFavorites", map, new g());
    }

    public final void X(Pattern pattern, NewCurveLineView newCurveLineView) {
        if (pattern == null) {
            return;
        }
        if (TextUtils.isEmpty(pattern.getToyTag()) || !pattern.getToyTag().contains("pos")) {
            newCurveLineView.setPaintModel(ek2.SPEED.ordinal());
        } else {
            newCurveLineView.setPaintModel(ek2.POSITION.ordinal());
        }
    }

    public final void Y(int i) {
        kn3 kn3Var = new kn3((Context) this.a.getActivity(), ah4.e(i), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), true, (kn3.d) new e());
        kn3Var.show();
        kn3Var.p();
    }

    public final void Z(@NonNull PatternViewHolder patternViewHolder, Pattern pattern, String str) {
        new yn3(this.a.getActivity(), pattern.getCdnPath(), str, new c(patternViewHolder, pattern));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public final void l(PatternViewHolder patternViewHolder, String str) {
        if (WearUtils.y.u() == null) {
            Y(R.string.pattern_store_like_offline_notification);
            return;
        }
        patternViewHolder.ivPatternLike.setImageResource(R.drawable.patterns_patternlist_favorite_click);
        EventBus.getDefault().post(new PatternFavoriteChangeEvent(true, str, patternViewHolder.b.getToyTag()));
        PatternPlayManagerImpl.O().P0(str, true);
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, patternViewHolder.a);
        tn2.x(WearUtils.x).l("/wear/pattern/addFavorites", map, new f());
    }

    public final void m(@NonNull final PatternViewHolder patternViewHolder, final int i, final Pattern pattern) {
        patternViewHolder.likeLinear.setOnClickListener(new View.OnClickListener() { // from class: dc.ym1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.r(patternViewHolder, pattern, view);
            }
        });
        patternViewHolder.patternPlay.setOnClickListener(new View.OnClickListener() { // from class: dc.nm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.t(pattern, patternViewHolder, view);
            }
        });
        patternViewHolder.downLinear.setOnClickListener(new View.OnClickListener() { // from class: dc.vm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v(pattern, patternViewHolder, view);
            }
        });
        patternViewHolder.hidenLinear.setOnClickListener(new View.OnClickListener() { // from class: dc.xm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.F(pattern, i, patternViewHolder, view);
            }
        });
    }

    public final void n(final PatternViewHolder patternViewHolder, final Pattern pattern) {
        patternViewHolder.dataLoadingView.setVisibility(0);
        patternViewHolder.dataLoadingView.setOnClickListener(null);
        if (patternViewHolder.removedTopView.getVisibility() == 0 || !WearUtils.e1(pattern.getData())) {
            patternViewHolder.dataLoadingView.setVisibility(8);
        }
        patternViewHolder.patternPlayCurve.setShowBothLine(pattern.getHead() != null && pattern.getHead().isMulFunction());
        int iF0 = PatternPlayManagerImpl.O().f0(pattern);
        if (iF0 > 0) {
            if (iF0 == 1) {
                PatternPlayManagerImpl.O().h0(this.a.l, new PatternPlayManagerImpl.f() { // from class: dc.pm1
                    @Override // com.wear.ui.home.pattern.control.PatternPlayManagerImpl.f
                    public final void a(Pattern pattern2, int i, boolean z, String str, String str2, int i2, String[] strArr) {
                        this.a.H(pattern, patternViewHolder, pattern2, i, z, str, str2, i2, strArr);
                    }
                });
                return;
            } else {
                patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_pause);
                patternViewHolder.patternSingleTitle.setVisibility(0);
                return;
            }
        }
        if (WearUtils.e1(pattern.getData())) {
            patternViewHolder.patternPlayCurve.b();
            return;
        }
        X(pattern, patternViewHolder.patternPlayCurve);
        if (pattern.getHead() == null) {
            patternViewHolder.patternPlayCurve.setInitData(null, pattern.getData().split(","), true);
        } else {
            patternViewHolder.patternPlayCurve.setInitData(pattern.getHead(), pattern.getData().split(";"), false);
        }
    }

    public final void o(PatternViewHolder patternViewHolder, Pattern pattern) {
        if (WearUtils.x0(pattern.getId()).exists()) {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.c, R.drawable.pattern_download_done));
        } else {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.c, R.drawable.patterns_patternlist_download));
        }
        patternViewHolder.tvPatternDownloadNumber.setText("" + pattern.getLikeCount());
        patternViewHolder.tvPatternDownloadNumber.setTextColor(th4.b(this.c, R.color.text_color_85));
        patternViewHolder.patternHiden.setVisibility(0);
        patternViewHolder.tvPatternDownloadNumber.setVisibility(0);
        if (WearUtils.e1(pattern.getEmail()) || !pattern.getEmail().equals(WearUtils.y.r())) {
            if (pattern.getFile().exists() && xe2.L0().O(WearUtils.y.r(), pattern.getId())) {
                patternViewHolder.ivPatternDownload.setVisibility(0);
                patternViewHolder.ivPatternDownload.setBackground(th4.d(this.c, R.drawable.pattern_download_done));
            } else {
                patternViewHolder.ivPatternDownload.setVisibility(0);
                patternViewHolder.ivPatternDownload.setBackground(th4.d(this.c, R.drawable.patterns_patternlist_download));
            }
        } else if ("Like".equals(this.a.l)) {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.tvPatternDownloadNumber.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.c, R.drawable.pattern_download_done));
        }
        patternViewHolder.tvPatternDownloadNumber.setText("" + pattern.getLikeCount());
        patternViewHolder.tvPatternDownloadNumber.setTextColor(th4.b(this.c, R.color.text_color_85));
    }

    public final void p(PatternViewHolder patternViewHolder, Pattern pattern) {
        patternViewHolder.tvPatternLikeNumber.setText(pattern.getFavoritesCount() + "");
        if (!WearUtils.e1(PatternStoreActivity.l.get(patternViewHolder.a))) {
            patternViewHolder.ivPatternLike.setVisibility(8);
            patternViewHolder.ivPatternLikeLoading.setVisibility(0);
            patternViewHolder.ivPatternLikeLoading.setImageResource(R.drawable.pattern_like_loading);
            return;
        }
        patternViewHolder.ivPatternLikeLoading.setVisibility(8);
        patternViewHolder.ivPatternLike.setVisibility(0);
        if (pattern.isFavorite() || "Like".equals(this.a.l)) {
            patternViewHolder.ivPatternLike.setImageResource(R.drawable.patterns_patternlist_favorite_click);
        } else {
            patternViewHolder.ivPatternLike.setImageResource(R.drawable.patterns_patternlist_favorite);
        }
    }
}
