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
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.lovense.wear.R;
import com.wear.bean.Pattern;
import com.wear.bean.Toy;
import com.wear.bean.event.PatternDownloadEvent;
import com.wear.bean.event.PatternFavoriteChangeEvent;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.longDistance.ForwardMessageActivity;
import com.wear.main.patterns.SharePatternActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.ui.discover.pattern.PatternStoreActivity;
import com.wear.ui.discover.pattern.PatternUserActivity;
import com.wear.ui.home.pattern.control.PatternPlayManagerImpl;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.control.NewCurveLineView;
import dc.ah4;
import dc.ao3;
import dc.ce3;
import dc.db2;
import dc.ek2;
import dc.kf;
import dc.kn3;
import dc.mg3;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class PatternSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    public qo a = new qo().h(R.drawable.chat_avatar_default).X(R.drawable.chat_avatar_default);
    public final Context b;
    public final List<Object> c;
    public String d;
    public f e;

    public static class HeadViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_more)
        public TextView tv_more;

        @BindView(R.id.tv_title)
        public TextView tv_title;

        public HeadViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class HeadViewHolder_ViewBinding implements Unbinder {
        public HeadViewHolder a;

        @UiThread
        public HeadViewHolder_ViewBinding(HeadViewHolder headViewHolder, View view) {
            this.a = headViewHolder;
            headViewHolder.tv_title = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tv_title'", TextView.class);
            headViewHolder.tv_more = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_more, "field 'tv_more'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            HeadViewHolder headViewHolder = this.a;
            if (headViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            headViewHolder.tv_title = null;
            headViewHolder.tv_more = null;
        }
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_user_name)
        public TextView tv_user_name;

        public UserViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public class UserViewHolder_ViewBinding implements Unbinder {
        public UserViewHolder a;

        @UiThread
        public UserViewHolder_ViewBinding(UserViewHolder userViewHolder, View view) {
            this.a = userViewHolder;
            userViewHolder.tv_user_name = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_user_name, "field 'tv_user_name'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            UserViewHolder userViewHolder = this.a;
            if (userViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            userViewHolder.tv_user_name = null;
        }
    }

    public class a implements ao3.a {
        public a(PatternSearchAdapter patternSearchAdapter) {
        }

        @Override // dc.ao3.a
        public void a(ao3 ao3Var) {
        }

        @Override // dc.ao3.a
        public void b(ao3 ao3Var) {
        }
    }

    public class b implements yn3.c {
        public final /* synthetic */ Pattern a;
        public final /* synthetic */ Pattern b;

        public b(Pattern pattern, Pattern pattern2) {
            this.a = pattern;
            this.b = pattern2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void c(String str, String str2, Pattern pattern, String str3) throws IOException {
            if (WearUtils.e1(str3)) {
                sg3.i(PatternSearchAdapter.this.b, R.string.file_notfound);
                return;
            }
            if (str3.contains("result")) {
                sg3.i(PatternSearchAdapter.this.b, R.string.file_notfound);
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
            pattern2.setToyVersion(pattern.getToyVersion());
            pattern2.setToySymbol(pattern.getToySymbol());
            pattern2.setToyName(pattern.getToyName());
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
            map.put(TtmlNode.ATTR_ID, pattern2.getId());
            tn2.x(WearUtils.x).l("/wear/pattern/liked", map, null);
        }

        @Override // dc.yn3.c
        public void a(String str, final String str2) {
            final String id = this.a.getId();
            final Pattern pattern = this.b;
            nf3.b(str, new nf3.d() { // from class: dc.zm1
                @Override // dc.nf3.d
                public final void onRequestComplete(String str3) throws IOException {
                    this.a.c(id, str2, pattern, str3);
                }
            });
        }

        @Override // dc.yn3.c
        public void doCancel() {
        }
    }

    public class c implements kn3.d {
        public c() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            pj3.t(PatternSearchAdapter.this.b, LoginActivity.class, 2);
        }
    }

    public class d implements zn2<String> {
        public d() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(PatternSearchAdapter.this.b, netException.getMessage());
        }
    }

    public class e implements zn2<String> {
        public e() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (normalResponse == null) {
                sg3.i(PatternSearchAdapter.this.b, R.string.patterns_result_remove_failed);
            } else {
                if (normalResponse.isResult()) {
                    return;
                }
                sg3.i(PatternSearchAdapter.this.b, R.string.patterns_result_remove_failed);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            sg3.k(PatternSearchAdapter.this.b, netException.getMessage());
        }
    }

    public interface f {
        void S0(PatternViewHolder patternViewHolder, Pattern pattern);

        void g(Pattern pattern);

        void k(Pattern pattern);

        void p2();
    }

    public PatternSearchAdapter(Context context, List<Object> list) {
        this.b = context;
        this.c = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(ao3 ao3Var, Pattern pattern, View view) {
        ao3Var.dismiss();
        if (WearUtils.y.u() == null) {
            U(R.string.pattern_store_share_offline_notification);
            return;
        }
        if (WearUtils.e1(pattern.getData()) || !pattern.isCheckMd5() || WearUtils.e1(pattern.getPath())) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("choose_pattern", pattern);
        pj3.g(this.b, ForwardMessageActivity.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void D(ao3 ao3Var, Pattern pattern, View view) {
        ao3Var.dismiss();
        if (WearUtils.y.u() == null) {
            U(R.string.pattern_store_report_offline_notification);
            return;
        }
        f fVar = this.e;
        if (fVar != null) {
            fVar.k(pattern);
        }
        WearUtils.x.q("pattern_cloud_report", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F(Pattern pattern, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("patternId", pattern.getId());
        bundle.putBoolean("isUpdate", true);
        if (!WearUtils.e1(pattern.getToyFeature()) && pattern.getToyFeature().equalsIgnoreCase(Toy.TOY_FEATURE_XMACHINE)) {
            bundle.putString("toyFeature", pattern.getToyFeature());
        }
        bundle.putString("toyName", pattern.getToyName());
        bundle.putString("toySymblo", pattern.getToySymbol());
        bundle.putString("toyVersion", pattern.getToyVersion());
        pj3.p((Activity) this.b, SharePatternActivity.class, 48, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H(ao3 ao3Var, Pattern pattern, View view) {
        ao3Var.dismiss();
        if (WearUtils.y.u() == null) {
            U(R.string.pattern_store_hide_offline_notification);
            return;
        }
        f fVar = this.e;
        if (fVar != null) {
            fVar.g(pattern);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J(final Pattern pattern, View view) {
        final ao3 ao3Var = new ao3(this.b, R.style.MenuDialogAl, R.layout.select_pattern_more_type);
        ao3Var.a(view, 250, pattern.getEmail().contains(WearUtils.y.r()) ? 200 : CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, 5160, -30, new a(this));
        ao3Var.findViewById(R.id.action_row_2).setOnClickListener(new View.OnClickListener() { // from class: dc.bn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.B(ao3Var, pattern, view2);
            }
        });
        LinearLayout linearLayout = (LinearLayout) ao3Var.findViewById(R.id.action_row_3);
        if ("Lovense-pick".equals(pattern.getTagName()) || AppMeasurementSdk.ConditionalUserProperty.ACTIVE.equals(pattern.getStatus())) {
            linearLayout.setAlpha(0.5f);
            linearLayout.setClickable(false);
        } else {
            ao3Var.findViewById(R.id.action_row_3).setOnClickListener(new View.OnClickListener() { // from class: dc.en1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.D(ao3Var, pattern, view2);
                }
            });
        }
        if (MyApplication.Z || WearUtils.e1(pattern.getEmail()) || !pattern.getEmail().equals(WearUtils.y.r())) {
            ao3Var.findViewById(R.id.ll_row_1).setVisibility(8);
        } else {
            ao3Var.findViewById(R.id.ll_row_1).setVisibility(0);
            ao3Var.findViewById(R.id.ll_row_1).setOnClickListener(new View.OnClickListener() { // from class: dc.dn1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.a.F(pattern, view2);
                }
            });
        }
        ao3Var.findViewById(R.id.action_row_4).setOnClickListener(new View.OnClickListener() { // from class: dc.jn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.H(ao3Var, pattern, view2);
            }
        });
        ao3Var.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(Pattern pattern, View view) {
        P(pattern);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N(Pattern pattern, PatternViewHolder patternViewHolder) {
        if (!na2.m().t() && y12.c.a().s(y12.c.TYPE_PATTERN)) {
            if (!Toy.isContainFunction(pattern.getToyFunc())) {
                sg3.h(R.string.pattern_unsupporte);
                return;
            }
            PatternPlayManagerImpl.O().C0();
            f fVar = this.e;
            if (fVar != null) {
                fVar.S0(patternViewHolder, pattern);
            }
        }
    }

    public static void S(PatternViewHolder patternViewHolder, Pattern pattern) {
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
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Pattern pattern, View view) {
        if (pattern.isFavorite()) {
            P(pattern);
            WearUtils.x.q("pattern_cloud_remove_favorite", null);
        } else {
            m(pattern);
            WearUtils.x.q("pattern_cloud_add_favorite", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(Pattern pattern, PatternViewHolder patternViewHolder, View view) {
        O(pattern, patternViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z(Pattern pattern, View view) {
        if (pattern.getFile().exists() && xe2.L0().O(WearUtils.y.r(), pattern.getId())) {
            if (MyApplication.Z) {
                sg3.i(this.b, R.string.pattern_store_offline_redownload_toast);
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
        V(pattern, pattern, str);
    }

    public final void O(final Pattern pattern, final PatternViewHolder patternViewHolder) {
        db2.A().q(new db2.s() { // from class: dc.an1
            @Override // dc.db2.s
            public final void a() {
                this.a.N(pattern, patternViewHolder);
            }
        });
    }

    public final void P(Pattern pattern) {
        HashMap map = new HashMap();
        map.put("ids", pattern.getId());
        EventBus.getDefault().post(new PatternFavoriteChangeEvent(false, pattern.getId(), pattern.getToyTag()));
        tn2.x(WearUtils.x).l("/wear/pattern/removeFavorites", map, new e());
    }

    public void Q(String str) {
        this.d = str;
    }

    public void R(f fVar) {
        this.e = fVar;
    }

    public void T(Pattern pattern, NewCurveLineView newCurveLineView) {
        if (!WearUtils.e1(pattern.getToyFunc()) && pattern.getToyFunc().equals("pos")) {
            newCurveLineView.setPaintModel(ek2.POSITION.ordinal());
        } else if (WearUtils.e1(pattern.getToyTag()) || !pattern.getToyTag().equals("pos")) {
            newCurveLineView.setPaintModel(ek2.SPEED.ordinal());
        } else {
            newCurveLineView.setPaintModel(ek2.POSITION.ordinal());
        }
    }

    public final void U(int i) {
        kn3 kn3Var = new kn3(this.b, ah4.e(i), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), true, (kn3.d) new c());
        kn3Var.show();
        kn3Var.p();
    }

    public final void V(Pattern pattern, Pattern pattern2, String str) {
        new yn3(this.b, pattern.getCdnPath(), str, new b(pattern, pattern2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Object obj = this.c.get(i);
        if (obj instanceof Pattern) {
            return 2;
        }
        return obj instanceof String ? 1 : 0;
    }

    public final void m(Pattern pattern) {
        if (WearUtils.y.u() == null) {
            U(R.string.pattern_store_like_offline_notification);
            return;
        }
        EventBus.getDefault().post(new PatternFavoriteChangeEvent(true, pattern.getId(), pattern.getToyTag()));
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, pattern.getId());
        tn2.x(WearUtils.x).l("/wear/pattern/addFavorites", map, new d());
    }

    public final void n(HeadViewHolder headViewHolder, int i) {
        int iIntValue = ((Integer) this.c.get(i)).intValue();
        if (iIntValue == 1) {
            headViewHolder.tv_title.setText(ah4.e(R.string.common_users));
            headViewHolder.tv_more.setVisibility(8);
        } else if (iIntValue == 2) {
            headViewHolder.tv_title.setText(ah4.e(R.string.main_patterns));
            headViewHolder.tv_more.setVisibility(8);
        } else {
            headViewHolder.tv_title.setText(ah4.e(R.string.common_users));
            headViewHolder.tv_more.setVisibility(0);
            headViewHolder.tv_more.setOnClickListener(this);
        }
    }

    public final void o(final PatternViewHolder patternViewHolder, final Pattern pattern) {
        patternViewHolder.ivPatternLike.setOnClickListener(new View.OnClickListener() { // from class: dc.gn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.v(pattern, view);
            }
        });
        patternViewHolder.patternPlay.setOnClickListener(new View.OnClickListener() { // from class: dc.hn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.x(pattern, patternViewHolder, view);
            }
        });
        patternViewHolder.ivPatternDownload.setOnClickListener(new View.OnClickListener() { // from class: dc.cn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.z(pattern, view);
            }
        });
        patternViewHolder.patternHiden.setOnClickListener(new View.OnClickListener() { // from class: dc.fn1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.J(pattern, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List list) {
        if (list.isEmpty()) {
            onBindViewHolder(viewHolder, i);
            return;
        }
        if (viewHolder instanceof PatternViewHolder) {
            PatternViewHolder patternViewHolder = (PatternViewHolder) viewHolder;
            Pattern pattern = (Pattern) this.c.get(i);
            for (Object obj : list) {
                if (TextUtils.equals(Pattern.DOWNLOAD, obj.toString())) {
                    s(patternViewHolder, pattern);
                } else if (TextUtils.equals("like", obj.toString())) {
                    t(patternViewHolder, pattern);
                } else if (TextUtils.equals("getServerFile", obj.toString())) {
                    r(patternViewHolder, pattern);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_more) {
            f fVar = this.e;
            if (fVar != null) {
                fVar.p2();
                return;
            }
            return;
        }
        if (id != R.id.tv_user_name) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("userName", (String) view.getTag(R.id.tag1));
        pj3.g(this.b, PatternUserActivity.class, bundle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return i == 1 ? new UserViewHolder(LayoutInflater.from(this.b).inflate(R.layout.item_patterns_search_users, viewGroup, false)) : i == 2 ? new PatternViewHolder(LayoutInflater.from(this.b).inflate(R.layout.item_pattern_item_layout, viewGroup, false), this.b) : new HeadViewHolder(LayoutInflater.from(this.b).inflate(R.layout.item_patterns_search_head, viewGroup, false));
    }

    public final void p(PatternViewHolder patternViewHolder, int i) {
        final Pattern pattern = (Pattern) this.c.get(i);
        patternViewHolder.a = pattern.getId();
        patternViewHolder.b = pattern;
        if ((WearUtils.e1(pattern.getIsShowReview()) || !pattern.getIsShowReview().equals("1")) && (WearUtils.e1(pattern.getStatus()) || !pattern.getStatus().equals(AppMeasurementSdk.ConditionalUserProperty.ACTIVE))) {
            patternViewHolder.iv_under_preview.setVisibility(8);
            patternViewHolder.patternSingleTitle.setText(TextUtils.isEmpty(pattern.getName()) ? "" : mg3.a(this.b, pattern.getName(), this.d));
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
            patternViewHolder.toyType1.setImageResource(R.drawable.label_toy_function_vibration);
            patternViewHolder.toyType2.setVisibility(8);
            patternViewHolder.toyType3.setVisibility(8);
        } else {
            S(patternViewHolder, pattern);
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
                T(pattern, patternViewHolder.patternPlayCurve);
                if (pattern.getHead() == null) {
                    patternViewHolder.patternPlayCurve.setInitData(null, pattern.getData().split(","), true);
                } else {
                    patternViewHolder.patternPlayCurve.setInitData(pattern.getHead(), pattern.getData().split(";"), false);
                }
            }
            patternViewHolder.ivRemovedAction.setOnClickListener(new View.OnClickListener() { // from class: dc.in1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.L(pattern, view);
                }
            });
            return;
        }
        r(patternViewHolder, pattern);
        patternViewHolder.patternPlay.setTag(Boolean.FALSE);
        patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_play);
        s(patternViewHolder, pattern);
        t(patternViewHolder, pattern);
        o(patternViewHolder, pattern);
        String tagAvatarUrl = pattern.getTagAvatarUrl();
        if (TextUtils.isEmpty(tagAvatarUrl)) {
            patternViewHolder.patternIcon.setImageResource(R.drawable.home_pattern_avatar);
        } else {
            if (!tagAvatarUrl.startsWith("http")) {
                tagAvatarUrl = WearUtils.e + tagAvatarUrl;
            }
            kf.w(patternViewHolder.patternIcon.getContext()).v(tagAvatarUrl).a(this.a).A0(patternViewHolder.patternIcon);
        }
        String tagName = pattern.getTagName();
        if (TextUtils.isEmpty(tagName)) {
            patternViewHolder.iv_lovense_pick.setVisibility(8);
        } else {
            patternViewHolder.iv_lovense_pick.setVisibility("Lovense-pick".equals(tagName) ? 0 : 8);
        }
    }

    public final void q(UserViewHolder userViewHolder, int i) {
        String str = (String) this.c.get(i);
        userViewHolder.tv_user_name.setText(mg3.a(this.b, str, this.d));
        userViewHolder.tv_user_name.setTag(R.id.tag1, str);
        userViewHolder.tv_user_name.setOnClickListener(this);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) userViewHolder.itemView.getLayoutParams();
        int i2 = i + 1;
        if (i2 >= this.c.size() || getItemViewType(i2) != 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ce3.a(this.b, 12.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ce3.a(this.b, 20.0f);
        }
        userViewHolder.itemView.setLayoutParams(layoutParams);
    }

    public final void r(PatternViewHolder patternViewHolder, Pattern pattern) {
        patternViewHolder.dataLoadingView.setVisibility(0);
        patternViewHolder.dataLoadingView.setOnClickListener(null);
        if (patternViewHolder.removedTopView.getVisibility() == 0 || !WearUtils.e1(pattern.getData())) {
            patternViewHolder.dataLoadingView.setVisibility(8);
        }
        patternViewHolder.patternPlayCurve.setShowBothLine(pattern.getHead() != null && pattern.getHead().isMulFunction());
        patternViewHolder.patternPlayCurve.setTag(pattern.getId());
        if (PatternPlayManagerImpl.O().f0(pattern) == 2) {
            patternViewHolder.patternPlay.setTag(Boolean.TRUE);
            patternViewHolder.patternPlay.setImageResource(R.drawable.home_pattern_pause);
            patternViewHolder.patternSingleTitle.setVisibility(0);
        } else {
            if (WearUtils.e1(pattern.getData())) {
                patternViewHolder.patternPlayCurve.b();
                return;
            }
            T(pattern, patternViewHolder.patternPlayCurve);
            if (pattern.getHead() == null) {
                patternViewHolder.patternPlayCurve.setInitData(null, pattern.getData().split(","), true);
            } else {
                patternViewHolder.patternPlayCurve.setInitData(pattern.getHead(), pattern.getData().split(";"), false);
            }
        }
    }

    public final void s(PatternViewHolder patternViewHolder, Pattern pattern) {
        if (WearUtils.x0(pattern.getId()).exists()) {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.b, R.drawable.pattern_download_done));
        } else {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.b, R.drawable.patterns_patternlist_download));
        }
        patternViewHolder.tvPatternDownloadNumber.setTextColor(th4.b(this.b, R.color.text_color_85));
        patternViewHolder.tvPatternDownloadNumber.setText("" + pattern.getLikeCount());
        patternViewHolder.patternHiden.setVisibility(0);
        patternViewHolder.tvPatternDownloadNumber.setVisibility(0);
        if (!WearUtils.e1(pattern.getEmail()) && pattern.getEmail().equals(WearUtils.y.r())) {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.tvPatternDownloadNumber.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.b, R.drawable.pattern_download_done));
        } else if (pattern.getFile().exists() && xe2.L0().O(WearUtils.y.r(), pattern.getId())) {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.b, R.drawable.pattern_download_done));
        } else {
            patternViewHolder.ivPatternDownload.setVisibility(0);
            patternViewHolder.ivPatternDownload.setBackground(th4.d(this.b, R.drawable.patterns_patternlist_download));
        }
        patternViewHolder.tvPatternDownloadNumber.setText("" + pattern.getLikeCount());
        patternViewHolder.tvPatternDownloadNumber.setTextColor(th4.b(this.b, R.color.text_color_85));
    }

    public final void t(PatternViewHolder patternViewHolder, Pattern pattern) {
        patternViewHolder.tvPatternLikeNumber.setText(pattern.getFavoritesCount() + "");
        if (!WearUtils.e1(PatternStoreActivity.l.get(pattern.getId()))) {
            patternViewHolder.ivPatternLike.setVisibility(8);
            patternViewHolder.ivPatternLikeLoading.setVisibility(0);
            patternViewHolder.ivPatternLikeLoading.setImageResource(R.drawable.pattern_like_loading);
        } else {
            patternViewHolder.ivPatternLikeLoading.setVisibility(8);
            patternViewHolder.ivPatternLike.setVisibility(0);
            if (pattern.isFavorite()) {
                patternViewHolder.ivPatternLike.setImageResource(R.drawable.patterns_patternlist_favorite_click);
            } else {
                patternViewHolder.ivPatternLike.setImageResource(R.drawable.patterns_patternlist_favorite);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof HeadViewHolder) {
            n((HeadViewHolder) viewHolder, i);
        } else if (viewHolder instanceof UserViewHolder) {
            q((UserViewHolder) viewHolder, i);
        } else {
            p((PatternViewHolder) viewHolder, i);
        }
    }
}
