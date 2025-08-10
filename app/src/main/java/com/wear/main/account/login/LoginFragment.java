package com.wear.main.account.login;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.activity.orgySetting.OrgySetting;
import com.wear.activity.orgySetting.OrgyWebViewActivity;
import com.wear.adapter.TestValueAdapter;
import com.wear.bean.Account;
import com.wear.bean.ManagerRDBean;
import com.wear.bean.OpenAppBean;
import com.wear.bean.TestValue;
import com.wear.bean.ThirdCheckBindBean;
import com.wear.bean.ThirdLoginBean;
import com.wear.bean.User;
import com.wear.bean.XYBean;
import com.wear.bean.event.EditEmailEvent;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.bean.event.NotificationCloseEvent;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.msg.response.FrozenAccountResponse;
import com.wear.dao.DaoUtils;
import com.wear.dao.TestValueDao;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginFragment;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.ninja.service.PlayService;
import com.wear.network.presenter.bean.AccountConfigBean;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.presenter.bean.QueryRemoteAccountInfoBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.thirdlogin.ThirdCheckBindBottomDialog;
import com.wear.ui.longDistance.officialaccount.OfficialaCountModel;
import com.wear.ui.me.MeFragment;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.AnimationButton;
import com.wear.widget.dialog.NewUserVerifyDialog;
import com.wear.widget.dialog.VerifyDialog;
import com.wear.widget.loading.Loading;
import com.wear.widget.roundwidget.SkinRoundAutoRelativeLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import dc.ah4;
import dc.be3;
import dc.bh0;
import dc.bu3;
import dc.ce3;
import dc.ch0;
import dc.ch3;
import dc.co3;
import dc.cs3;
import dc.dp2;
import dc.eg3;
import dc.ep1;
import dc.gg3;
import dc.hu3;
import dc.is3;
import dc.jl2;
import dc.kl2;
import dc.kn3;
import dc.l12;
import dc.lg3;
import dc.me3;
import dc.nd3;
import dc.ol2;
import dc.om2;
import dc.pj3;
import dc.pq2;
import dc.qq2;
import dc.ro2;
import dc.rp1;
import dc.sg3;
import dc.sq2;
import dc.ti3;
import dc.tn2;
import dc.tq2;
import dc.ue3;
import dc.vc2;
import dc.vr3;
import dc.y12;
import dc.ye3;
import dc.yn2;
import dc.zb2;
import dc.zd3;
import dc.zt3;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class LoginFragment extends BottomSheetDialogFragment implements View.OnClickListener, dp2, l12.k, bu3 {
    public s B;
    public String c;
    public om2 d;

    @BindView(R.id.email)
    public EditText email;

    @BindView(R.id.email_content_delete)
    public ImageView emailContentDelete;

    @BindView(R.id.error_tip)
    public TextView errorTip;

    @BindView(R.id.explore_btn)
    public TextView exploreBtn;
    public String f;

    @BindView(R.id.forgetPassword_btn)
    public TextView forgetPasswordBtn;
    public String g;

    @BindView(R.id.google_sign_iv)
    public ImageView googleSignIv;
    public String h;
    public boolean i;

    @BindView(R.id.iv_delete_psw)
    public ImageView ivDeletePsw;
    public hu3 l;

    @BindView(R.id.ll_password)
    public LinearLayout llPassword;

    @BindView(R.id.login_above_layout)
    public LinearLayout loginAboveLayout;

    @BindView(R.id.login_btn)
    public TextView loginBtn;

    @BindView(R.id.login_btn_loading)
    public AnimationButton loginBtnLoading;

    @BindView(R.id.login_btn_Progress)
    public Loading loginBtnProgress;

    @BindView(R.id.login_close)
    public ImageView loginClose;
    public String m;
    public String n;
    public Runnable p;

    @BindView(R.id.password)
    public EditText password;

    @BindView(R.id.password_content_show)
    public ImageView passwordContentShow;
    public ch0 s;

    @BindView(R.id.screan_root_layout)
    public SkinRoundAutoRelativeLayout screanRootLayout;

    @BindView(R.id.signUp_btn)
    public TextView signUpBtn;
    public Dialog t;

    @BindView(R.id.top_view)
    public View topView;
    public vr3 u;

    @BindView(R.id.web_link)
    public TextView webLink;
    public kl2 y;
    public om2 z;
    public int a = -1;
    public boolean b = false;
    public Handler e = new Handler();
    public int j = 0;
    public boolean k = false;
    public co3 o = null;
    public int q = 0;
    public int r = 0;
    public final Handler v = new Handler(Looper.getMainLooper());
    public ThirdLoginBean w = new ThirdLoginBean();
    public sq2 x = new sq2();
    public boolean A = false;

    public class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (LoginFragment.this.getActivity() == null || LoginFragment.this.getActivity().isFinishing() || LoginFragment.this.getActivity().isDestroyed()) {
                return;
            }
            pj3.w(LoginFragment.this.getActivity(), WearUtils.e + "/app/terms-conditions?app=wearables&lang=" + lg3.b(LoginFragment.this.getContext()));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(LoginFragment.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
        }
    }

    public class b implements pq2 {
        public b() {
        }

        public static /* synthetic */ void c() {
        }

        public static /* synthetic */ void d() {
        }

        @Override // dc.pq2
        public void a(String str) {
            LoginFragment.this.L();
            LoginFragment.this.password.setEnabled(true);
            LoginFragment.this.email.setEnabled(true);
            sg3.l(LoginFragment.this.getString(R.string.toast_login_failed));
            tq2.a().d(LoginFragment.this.getActivity(), new qq2() { // from class: dc.fy1
                @Override // dc.qq2
                public final void a() {
                    LoginFragment.b.d();
                }
            });
        }

        @Override // dc.pq2
        public void b(sq2 sq2Var) {
            LoginFragment.this.x = sq2Var;
            LoginFragment.this.M0();
            LoginFragment.this.Q0(sq2Var);
        }

        @Override // dc.pq2
        public void onCancel() {
            LoginFragment.this.L();
            LoginFragment.this.password.setEnabled(true);
            LoginFragment.this.email.setEnabled(true);
            sg3.l(LoginFragment.this.getString(R.string.toast_login_failed));
            tq2.a().d(LoginFragment.this.getActivity(), new qq2() { // from class: dc.ey1
                @Override // dc.qq2
                public final void a() {
                    LoginFragment.b.c();
                }
            });
        }
    }

    public class c implements is3.c {
        public final /* synthetic */ GenTokenBean.DataBean a;

        public c(GenTokenBean.DataBean dataBean) {
            this.a = dataBean;
        }

        @Override // dc.is3.c
        public void doCancel() {
            WearUtils.x.q("login_verifyemail_edit_click", null);
            LoginFragment.this.L();
            Intent intent = new Intent(LoginFragment.this.getContext(), (Class<?>) EditEmailActivity.class);
            intent.putExtra("userName", LoginFragment.this.email.getText().toString());
            intent.putExtra("password", LoginFragment.this.password.getText().toString());
            intent.putExtra("oldEmail", this.a.getUserEmail());
            LoginFragment.this.startActivity(intent);
        }
    }

    public class d implements is3.d {
        public d() {
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (LoginFragment.this.A) {
                LoginFragment.this.A0(2);
            } else {
                pj3.h(LoginFragment.this.getContext(), LoginActivity.class, "isChange", 2);
            }
            LoginFragment.this.L();
        }
    }

    public class e implements DialogInterface.OnDismissListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            LoginFragment.this.t = null;
        }
    }

    public class f implements kn3.d {
        public f() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            pj3.f(LoginFragment.this.getContext(), ForgetPassActivity.class);
        }
    }

    public class g implements kn3.d {
        public g() {
        }

        @Override // dc.kn3.d
        public void doCancel() {
        }

        @Override // dc.kn3.d
        public void doConfirm() {
            RequestPermissionActivity.s4(LoginFragment.this.getActivity());
        }
    }

    public class h implements yn2<BaseResponseBeanNew<ThirdCheckBindBean>> {
        public final /* synthetic */ sq2 a;

        public class a implements ThirdCheckBindBottomDialog.a {
            public a() {
            }

            public static /* synthetic */ void c() {
            }

            @Override // com.wear.thirdlogin.ThirdCheckBindBottomDialog.a
            public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                LoginFragment.this.M0();
                MeFragment.m = 1;
                h hVar = h.this;
                LoginFragment.this.R0(hVar.a, false);
            }

            @Override // com.wear.thirdlogin.ThirdCheckBindBottomDialog.a
            public void b() {
                pj3.o(LoginFragment.this.getActivity(), ThirdBindAccountActivity.class, 20240407);
            }

            @Override // com.wear.thirdlogin.ThirdCheckBindBottomDialog.a
            public void doCancel() {
                tq2.a().d(LoginFragment.this.getActivity(), new qq2() { // from class: dc.gy1
                    @Override // dc.qq2
                    public final void a() {
                        LoginFragment.h.a.c();
                    }
                });
            }
        }

        public h(sq2 sq2Var) {
            this.a = sq2Var;
        }

        public static /* synthetic */ void b() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<ThirdCheckBindBean> baseResponseBeanNew) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            ThirdCheckBindBean thirdCheckBindBean = baseResponseBeanNew.data;
            if (thirdCheckBindBean != null) {
                if (thirdCheckBindBean.getExistLovenseAccount()) {
                    LoginFragment.this.R0(this.a, false);
                    return;
                }
                LoginFragment.this.L();
                if (LoginFragment.this.getActivity() == null || LoginFragment.this.getActivity().isFinishing() || LoginFragment.this.getActivity().isDestroyed()) {
                    return;
                }
                new ThirdCheckBindBottomDialog(LoginFragment.this.getActivity(), new a()).show();
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            LoginFragment.this.L();
            eg3.j(WearUtils.x, "is_third_login", false);
            tq2.a().d(LoginFragment.this.getActivity(), new qq2() { // from class: dc.hy1
                @Override // dc.qq2
                public final void a() {
                    LoginFragment.h.b();
                }
            });
            sg3.l(LoginFragment.this.getString(R.string.toast_login_failed));
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class i implements yn2<ThirdLoginBean> {
        public i() {
        }

        public static /* synthetic */ void b() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ThirdLoginBean thirdLoginBean) {
            LoginFragment.this.w = thirdLoginBean;
            if (LoginFragment.this.w != null) {
                ye3.K(2);
                eg3.i(MyApplication.N(), "gen_token_Key", nd3.u(LoginFragment.this.w.getData().getGtoken()));
                eg3.i(MyApplication.N(), "r_token_Key", nd3.u(LoginFragment.this.w.getData().getRtoken()));
                WearUtils.s = nd3.u(LoginFragment.this.w.getData().getGtoken());
                WearUtils.t = nd3.u(LoginFragment.this.w.getData().getRtoken());
                WearUtils.w2(LoginFragment.this.w.getData().getX(), LoginFragment.this.w.getData().getY());
                ye3.K(4);
                LoginFragment.this.d.j(true);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            LoginFragment.this.L();
            if (eg3.d(MyApplication.N(), "is_third_login", false)) {
                tq2.a().d(LoginFragment.this.getActivity(), new qq2() { // from class: dc.iy1
                    @Override // dc.qq2
                    public final void a() {
                        LoginFragment.i.b();
                    }
                });
            }
            eg3.j(MyApplication.N(), "is_third_login", false);
            sg3.l(LoginFragment.this.getString(R.string.toast_login_failed));
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public class j extends Dialog {
        public j(LoginFragment loginFragment, Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            if (getWindow() != null) {
                getWindow().getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.height = -2;
                attributes.width = -1;
                attributes.gravity = 17;
                getWindow().setAttributes(attributes);
            }
        }
    }

    public class k implements TextView.OnEditorActionListener {
        public k() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            LoginFragment loginFragment = LoginFragment.this;
            if (loginFragment.b) {
                return false;
            }
            loginFragment.a = loginFragment.loginBtnLoading.getId();
            LoginFragment.this.K();
            return false;
        }
    }

    public class l implements TextWatcher {
        public l() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (LoginFragment.this.errorTip.getVisibility() == 0) {
                LoginFragment.this.errorTip.setVisibility(8);
            }
            if (WearUtils.e1(LoginFragment.this.email.getText().toString())) {
                LoginFragment.this.emailContentDelete.setVisibility(8);
            } else {
                LoginFragment.this.emailContentDelete.setVisibility(0);
            }
            if (WearUtils.e1(LoginFragment.this.password.getText().toString())) {
                LoginFragment.this.llPassword.setVisibility(8);
            } else {
                LoginFragment.this.llPassword.setVisibility(0);
            }
            if (WearUtils.e1(LoginFragment.this.password.getText().toString()) || WearUtils.e1(LoginFragment.this.email.getText().toString())) {
                LoginFragment.this.loginBtn.setEnabled(false);
            } else {
                LoginFragment.this.loginBtn.setEnabled(true);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class m implements AnimationButton.h {
        public m() {
        }

        @Override // com.wear.widget.AnimationButton.h
        public void a() {
            LoginFragment loginFragment = LoginFragment.this;
            if (!loginFragment.b) {
                loginFragment.a = loginFragment.loginBtnLoading.getId();
                LoginFragment.this.K();
            } else {
                WearUtils.x.l.removeCallbacks(loginFragment.p);
                LoginFragment.this.d.m();
                LoginFragment.this.L();
            }
        }

        @Override // com.wear.widget.AnimationButton.h
        public void b() {
            LoginFragment loginFragment = LoginFragment.this;
            loginFragment.b = false;
            loginFragment.password.setEnabled(true);
            LoginFragment.this.email.setEnabled(true);
            if (WearUtils.e1(LoginFragment.this.password.getText().toString()) || WearUtils.e1(LoginFragment.this.email.getText().toString())) {
                LoginFragment.this.loginBtnLoading.setColor(false);
            } else {
                LoginFragment.this.loginBtnLoading.setColor(true);
            }
            LoginFragment.this.loginBtnProgress.setVisibility(8);
        }

        @Override // com.wear.widget.AnimationButton.h
        public void c() {
            LoginFragment.this.loginBtnProgress.setVisibility(0);
        }
    }

    public class n implements ch0.b {
        public n() {
        }

        @Override // dc.ch0.b
        public void a(int i) {
            if (LoginFragment.this.email.hasFocus()) {
                bh0.a aVar = bh0.h;
                if (aVar.a() > 0 && i >= aVar.a() * 2) {
                    i -= aVar.a();
                }
                if (i > (gg3.c(WearUtils.x) / 3) * 2) {
                    return;
                }
                DaoUtils.getTestValueDao().save(TestValueDao.CHAT_KEYBOARD_HEIGHT_KEY, String.valueOf(i), TestValueDao.CHAT_KEYBOARD_HEIGHT_TYPE);
            }
        }

        @Override // dc.ch0.b
        public void b(int i) {
        }

        @Override // dc.ch0.b
        public void onClosed() {
        }
    }

    public class o implements TestValueAdapter.c {
        public o() {
        }

        @Override // com.wear.adapter.TestValueAdapter.c
        public void a(TestValue testValue) {
            LoginFragment.this.email.setText(WearUtils.e1(testValue.getKey()) ? "" : nd3.i(testValue.getKey()));
            LoginFragment.this.password.setText(WearUtils.e1(testValue.getValue()) ? "" : nd3.i(testValue.getValue()));
            EditText editText = LoginFragment.this.email;
            editText.setSelection(editText.getText().length());
            LoginFragment.this.o.dismiss();
        }

        @Override // com.wear.adapter.TestValueAdapter.c
        public void b(TestValue testValue) {
            DaoUtils.getTestValueDao().delById(testValue.getId());
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginFragment.this.o.dismiss();
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DaoUtils.getTestValueDao().cleanRecords();
            LoginFragment.this.o.dismiss();
            LoginFragment.this.o = null;
        }
    }

    public class r extends ClickableSpan {
        public r() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (LoginFragment.this.getActivity() == null || LoginFragment.this.getActivity().isFinishing() || LoginFragment.this.getActivity().isDestroyed()) {
                return;
            }
            pj3.w(LoginFragment.this.getActivity(), WearUtils.e + "/app/privacy-policy?app=wearables&lang=" + lg3.b(LoginFragment.this.getContext()));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(LoginFragment.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
        }
    }

    public interface s {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e0() {
        String str;
        OpenAppBean openAppBean = MyApplication.U;
        if (openAppBean == null || (str = openAppBean.selfId) == null) {
            return;
        }
        this.d.k(openAppBean.datingId, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g0() {
        this.d.i(false, this.f, this.g);
    }

    public static /* synthetic */ boolean h0(View view) {
        WearUtils.x.c0();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j0(View view) {
        P0();
    }

    public static /* synthetic */ void k0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m0(List list, List list2) {
        if (list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                XYBean xYBeanQ0 = WearUtils.Q0();
                if (WearUtils.e1(((User) list.get(i2)).getRemoteAccountId()) && !WearUtils.e1(nd3.x(((User) list.get(i2)).getId(), xYBeanQ0.x, xYBeanQ0.y))) {
                    list2.add(nd3.x(((User) list.get(i2)).getId(), xYBeanQ0.x, xYBeanQ0.y));
                }
            }
        }
        String str = "email====" + list2.size();
        if (list2.size() > 0) {
            this.d.l((String[]) list2.toArray(new String[list2.size()]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(View view) {
        ue3.a(this.password, view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r0(View view) throws SecurityException {
        ue3.a(this.password, getContext());
        EventBus.getDefault().post(new LoginOrOfflineEvent(false));
        if (getActivity() != null) {
            ActivityManager activityManager = (ActivityManager) getActivity().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (activityManager == null) {
                O();
                return;
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks == null || runningTasks.size() <= 0) {
                return;
            }
            if (runningTasks.get(0).numActivities > 1) {
                O();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isOffline", true);
            pj3.r(getActivity(), MainActivity.class, bundle);
        }
    }

    public static LoginFragment x0(Bundle bundle) {
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setArguments(bundle);
        return loginFragment;
    }

    public void A0(int i2) {
        this.q = i2;
        if (i2 != 0) {
            this.password.setText("");
            this.loginBtnLoading.setColor(false);
        }
    }

    public final void C0() {
        this.forgetPasswordBtn.setOnClickListener(this);
        this.emailContentDelete.setOnClickListener(this);
        this.passwordContentShow.setOnClickListener(this);
        this.ivDeletePsw.setOnClickListener(this);
        this.signUpBtn.setOnClickListener(this);
        TextView textView = this.signUpBtn;
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        this.exploreBtn.setOnClickListener(this);
        this.screanRootLayout.setOnClickListener(new View.OnClickListener() { // from class: dc.ly1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.p0(view);
            }
        });
        this.loginClose.setOnClickListener(new View.OnClickListener() { // from class: dc.oy1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws SecurityException {
                this.a.r0(view);
            }
        });
    }

    public final void E0() {
        if (ce3.c(MyApplication.N())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.loginAboveLayout.getLayoutParams();
            float f2 = getResources().getDisplayMetrics().density;
            layoutParams.width = ce3.a(MyApplication.N(), 300.0f * f2);
            layoutParams.setMargins(0, ce3.a(MyApplication.N(), f2 * 60.0f), 0, 0);
            this.loginAboveLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // dc.dp2
    public void H(boolean z, GenTokenBean genTokenBean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ye3.K(2);
        eg3.j(WearUtils.x, "is_third_login", false);
        eg3.i(MyApplication.N(), "gen_token_Key", nd3.u(genTokenBean.getData().getGtoken()));
        eg3.i(MyApplication.N(), "r_token_Key", nd3.u(genTokenBean.getData().getRtoken()));
        WearUtils.s = nd3.u(genTokenBean.getData().getGtoken());
        WearUtils.t = nd3.u(genTokenBean.getData().getRtoken());
        WearUtils.w2(genTokenBean.getData().getX(), genTokenBean.getData().getY());
        ye3.K(4);
        V(genTokenBean.getData());
        this.email.setEnabled(true);
        this.password.setEnabled(true);
    }

    @Override // dc.bu3
    public void I1(String str) throws IllegalAccessException, SecurityException, IOException, IllegalArgumentException, InvocationTargetException {
        ThirdLoginBean thirdLoginBean;
        if (getActivity() == null || (getActivity() instanceof LoginActivity) || (getActivity() instanceof OrgyWebViewActivity)) {
            ch3.n().u().setUid(this.h);
            if (eg3.e(MyApplication.N(), "isShowDSGuide") != 2) {
                eg3.k(MyApplication.N(), "isShowDSGuide", 1);
            }
            if (eg3.d(MyApplication.N(), "is_third_login", false) && (thirdLoginBean = this.w) != null && thirdLoginBean.getData() != null) {
                Account accountU = WearUtils.y.u();
                if (this.x != null && this.w.getData().isNewRegist()) {
                    WearUtils.r2(this.x.b().toString(), accountU);
                    ch3.n().P();
                    hu3.w0();
                }
                HashMap map = new HashMap();
                map.put("type", this.w.getData().getLoginType() + "");
                ye3.e("A0032", map);
            }
            MyApplication.a0 = this.i;
            if (this.r == 1) {
                ActivityManager activityManager = (ActivityManager) MyApplication.N().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                if (activityManager == null) {
                    O();
                    return;
                }
                List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                if (runningTasks != null) {
                    if (runningTasks.get(0).numActivities > 1) {
                        O();
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("email", this.c);
                        bundle.putInt("isChange", this.q);
                        pj3.r(MyApplication.N(), MainActivity.class, bundle);
                    }
                }
            } else {
                Intent intent = new Intent(getContext(), (Class<?>) MainActivity.class);
                intent.putExtra("email", this.c);
                intent.putExtra("isChange", this.q);
                intent.setFlags(268468224);
                startActivity(intent);
            }
            MyApplication.Z = false;
            s sVar = this.B;
            if (sVar != null) {
                sVar.a();
            }
            EventBus.getDefault().post(new LoginOrOfflineEvent(true));
            String strF = ti3.f(MyApplication.N(), "uploadLog.json");
            String str2 = "savedJson11111===" + strF;
            if (!WearUtils.e1(strF) && !strF.equals("{\"data\":[]}") && ch3.n().o() != null && !WearUtils.g1(WearUtils.x.G().o())) {
                rp1.v(strF);
                ti3.a(new File(MyApplication.N().getFilesDir(), "uploadLog.json"));
                String str3 = "savedJson22222===" + ti3.f(MyApplication.N(), "uploadLog.json");
            }
            z0();
            L();
            O();
        }
    }

    public final void J(LoginUserBean loginUserBean, String str, String str2) {
        if (loginUserBean.isVerify()) {
            w0(loginUserBean, str, str2);
            return;
        }
        if (loginUserBean.isNewUser()) {
            w0(loginUserBean, str, str2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTimeNow = LocalDateTime.now();
            String str3 = localDateTimeNow.format(dateTimeFormatterOfPattern);
            LocalDateTime localDateTimeOfInstant = LocalDateTime.ofInstant(Instant.ofEpochSecond(loginUserBean.getVerifyExpiredTime() / 1000), ZoneId.systemDefault());
            System.out.println("转换后的 LocalDateTime：" + localDateTimeOfInstant);
            if (!localDateTimeNow.plusSeconds(1L).isBefore(localDateTimeOfInstant)) {
                Q(loginUserBean.getVerifyEmailUrl());
                L();
                this.password.setEnabled(true);
                this.email.setEnabled(true);
                sg3.l(ah4.e(R.string.email_not_verify_toast1));
                return;
            }
            String strH = eg3.h(getContext(), "open_verify_email", "");
            if (WearUtils.e1(strH)) {
                eg3.i(getContext(), "open_verify_email", str3);
                Q(loginUserBean.getVerifyEmailUrl());
                w0(loginUserBean, str, str2);
                return;
            }
            if (ChronoUnit.SECONDS.between(LocalDateTime.parse(strH, dateTimeFormatterOfPattern), localDateTimeNow) < loginUserBean.getVerifyEmailTipIntervalDays() * 24 * 60 * 60) {
                w0(loginUserBean, str, str2);
                return;
            }
            Q(loginUserBean.getVerifyEmailUrl());
            w0(loginUserBean, str, str2);
            eg3.i(getContext(), "open_verify_email", str3);
        }
    }

    public void J0(s sVar) {
        this.B = sVar;
    }

    public final void K() {
        M();
    }

    public final void K0(Activity activity, long j2) {
        final j jVar = new j(this, activity, R.style.dialog);
        jVar.setContentView(R.layout.dialog_account_frozen);
        jVar.setCancelable(false);
        jVar.setCanceledOnTouchOutside(false);
        Button button = (Button) jVar.findViewById(R.id.button);
        ((TextView) jVar.findViewById(R.id.text_1)).setText(String.format(ah4.e(R.string.notification_account_deleted1), be3.i(be3.j, new Date(j2))));
        button.setOnClickListener(new View.OnClickListener() { // from class: dc.ky1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                jVar.dismiss();
            }
        });
        jVar.show();
    }

    public void L() {
        vr3 vr3Var;
        if (getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed() || (vr3Var = this.u) == null || !vr3Var.isShowing()) {
            return;
        }
        this.u.dismiss();
    }

    public final void M() {
        ue3.a(this.password, getContext());
        int i2 = this.a;
        if (i2 != -1) {
            if (i2 == R.id.login_btn || i2 == R.id.login_btn_loading) {
                if (this.errorTip.getVisibility() == 0) {
                    this.errorTip.setVisibility(8);
                }
                v0();
            } else if (i2 == R.id.forgetPassword_btn) {
                pj3.f(getContext(), ForgetPassActivity.class);
            } else if (i2 == R.id.signUp_btn) {
                pj3.f(getContext(), SignUpActivity.class);
            }
        }
    }

    public void M0() {
        vr3 vr3Var;
        if (getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed() || (vr3Var = this.u) == null || vr3Var.isShowing()) {
            return;
        }
        this.u.show();
    }

    @Override // dc.dp2
    public void N(AccountConfigBean accountConfigBean) {
        ch3.n().o().setEnableAgoraIO(accountConfigBean.getData().isEnableAgoraIO());
        eg3.i(MyApplication.N(), "is_enable_cold_restart", Boolean.valueOf(accountConfigBean.getData().isEnableColdRestart()));
    }

    public final void O() {
        if (getActivity() != null) {
            if (getActivity() instanceof LoginActivity) {
                getActivity().finish();
            } else {
                dismiss();
            }
        }
    }

    @NonNull
    public final TextWatcher P() {
        return new l();
    }

    public final void P0() {
        List<TestValue> allType = DaoUtils.getTestValueDao().getAllType("0");
        if (allType == null || allType.size() <= 0) {
            return;
        }
        TestValueAdapter testValueAdapter = new TestValueAdapter(getActivity(), allType, new o());
        co3 co3Var = this.o;
        if (co3Var != null) {
            if (co3Var.isShowing()) {
                this.o.dismiss();
            }
            this.o = null;
        }
        if (getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed()) {
            return;
        }
        co3 co3Var2 = new co3(getActivity(), testValueAdapter);
        this.o = co3Var2;
        co3Var2.show();
        this.o.a(R.id.sheet_left_btn).setOnClickListener(new p());
        this.o.a(R.id.sheet_right_btn).setOnClickListener(new q());
        ((TextView) this.o.a(R.id.sheet_title)).setText("<<Login>>");
    }

    public final void Q(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final void Q0(sq2 sq2Var) {
        HashMap map = new HashMap();
        map.put("thirdType", "Google");
        map.put("sessionId", ye3.x());
        map.put("deviceName", Build.MODEL);
        String language = lg3.e(WearUtils.x).getLanguage();
        if (WearUtils.e1(language)) {
            language = "en";
        }
        map.put("language", language);
        map.put("idToken", sq2Var.a());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String string = entry.getValue().toString();
            System.out.println("Key: " + str + ", Value: " + string);
        }
        tn2.x(WearUtils.x).h("api/user/check_third_account", ro2.c(map), new h(sq2Var));
    }

    public void R(int i2, int i3, Intent intent) {
        if (i2 == 1) {
            tq2.a().e(i2, i3, intent);
            return;
        }
        if (i2 != 777) {
            if (i2 == 20240407 && i3 == -1) {
                M0();
                MeFragment.m = 2;
                R0(this.x, true);
                return;
            }
            return;
        }
        if (i3 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("grant_all", false);
            intent.getIntArrayExtra("grant_results");
            if (!booleanExtra) {
                new kn3((Context) getActivity(), ah4.e(R.string.app_open_must_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new g()).show();
            } else {
                ye3.d = ye3.r(MyApplication.N());
                M();
            }
        }
    }

    public final void R0(sq2 sq2Var, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        eg3.j(WearUtils.x, "is_third_login", true);
        HashMap map = new HashMap();
        map.put("thirdType", "Google");
        if (z) {
            map.put("doBinding", Boolean.TRUE);
        }
        map.put("sessionId", ye3.x());
        map.put("deviceName", Build.MODEL);
        String language = lg3.e(WearUtils.x).getLanguage();
        if (WearUtils.e1(language)) {
            language = "en";
        }
        map.put("language", language);
        map.put("idToken", sq2Var.a());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String string = entry.getValue().toString();
            System.out.println("Key: " + str + ", Value: " + string);
        }
        tn2.x(WearUtils.x).h("api/user/third_login", ro2.c(map), new i());
    }

    public final void V(GenTokenBean.DataBean dataBean) {
        zd3.c(nd3.r("popupVer" + dataBean.getUserEmail()));
        if (dataBean.isVerify()) {
            VerifyDialog.h = true;
            this.d.j(true);
            return;
        }
        VerifyDialog.h = false;
        is3.b bVar = new is3.b(getContext());
        bVar.e(dataBean.getUserEmail());
        if (!dataBean.isNewUser()) {
            this.d.j(true);
            return;
        }
        bVar.d(new d());
        bVar.c(new c(dataBean));
        bVar.g(true);
        bVar.u(R.id.tv_confirm);
        bVar.t(R.id.tv_skip);
        bVar.n(ah4.e(R.string.button_edit));
        bVar.o(ah4.e(R.string.button_login));
        is3 is3VarI = cs3.i(bVar, NewUserVerifyDialog.class);
        this.t = is3VarI;
        is3VarI.show();
        this.t.setOnDismissListener(new e());
    }

    public final void W() {
        TextWatcher textWatcherP = P();
        this.email.addTextChangedListener(textWatcherP);
        this.password.addTextChangedListener(textWatcherP);
        this.email.setEnabled(true);
        String strB = zd3.b(getContext(), "xmpp_email_simple_name");
        if (!WearUtils.e1(strB)) {
            this.email.setText(strB);
            EditText editText = this.email;
            editText.setSelection(editText.getText().length());
        }
        this.password.setEnabled(true);
        this.g = zd3.b(MyApplication.N(), "xmpp_password");
        if (this.q == 1) {
            this.password.setText("");
            this.loginBtnLoading.setColor(false);
            this.g = null;
            eg3.m(MyApplication.N(), "xmpp_password");
        }
        if (!WearUtils.e1(this.g)) {
            this.password.setText(this.g);
            EditText editText2 = this.password;
            editText2.setSelection(editText2.getText().length());
        }
        this.password.setOnEditorActionListener(new k());
        if (!TextUtils.isEmpty(this.c)) {
            this.email.setText(this.c);
            this.password.setText("");
            this.v.postDelayed(new Runnable() { // from class: dc.ny1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e0();
                }
            }, 60000L);
        }
        this.loginBtn.setOnClickListener(this);
        this.googleSignIv.setOnClickListener(this);
    }

    public void X() {
        jl2.b bVarE = jl2.e();
        bVarE.a(MyApplication.F());
        bVarE.c(new ol2(this));
        kl2 kl2VarB = bVarE.b();
        this.y = kl2VarB;
        kl2VarB.a(this);
        om2 om2Var = this.d;
        this.z = om2Var;
        if (om2Var != null) {
            om2Var.c(this);
        }
        om2 om2Var2 = this.z;
        if (om2Var2 != null) {
            om2Var2.onCreate();
        }
    }

    public final void a0() {
        try {
            if (getActivity() == null) {
                return;
            }
            ch0 ch0Var = new ch0(getActivity(), this.screanRootLayout);
            this.s = ch0Var;
            ch0Var.d(new n());
        } catch (Exception e2) {
            e2.printStackTrace();
            FirebaseCrashlytics.getInstance().recordException(new Throwable("LoginActivity KeyboardStatePopupWindow 异常：", e2));
        }
    }

    public final void b0() {
        this.loginBtnProgress.setVisibility(8);
        if (WearUtils.e1(this.password.getText().toString()) || WearUtils.e1(this.email.getText().toString())) {
            this.loginBtnLoading.setColor(false);
        } else {
            this.loginBtnLoading.setColor(true);
        }
        this.loginBtnLoading.setAnimationButtonListener(new m());
    }

    public final void c0() {
        String strE = ah4.e(R.string.privacy_policy);
        String strE2 = ah4.e(R.string.terms_and_conditions);
        String str = String.format(ah4.e(R.string.offline_terms_note), strE, strE2);
        SpannableString spannableString = new SpannableString(str);
        int iIndexOf = str.indexOf(strE);
        if (iIndexOf != -1) {
            spannableString.setSpan(new r(), iIndexOf, strE.length() + iIndexOf, 17);
        }
        int iIndexOf2 = str.indexOf(strE2);
        if (iIndexOf2 != -1) {
            spannableString.setSpan(new a(), iIndexOf2, strE2.length() + iIndexOf2, 17);
        }
        this.webLink.setMovementMethod(LinkMovementMethod.getInstance());
        this.webLink.setText(spannableString);
    }

    @Override // dc.dp2
    public void f(boolean z, String str, String str2) {
        zd3.d(MyApplication.N(), "xmpp_email_simple_name", this.f);
        L();
        this.password.setEnabled(true);
        this.email.setEnabled(true);
        this.j++;
        if (str.contains("[5007]")) {
            int i2 = this.j;
            if (i2 <= 2 || i2 % 2 != 1) {
                sg3.l(ah4.e(R.string.lvs_login_password_error));
            } else {
                kn3 kn3Var = new kn3(getContext(), ah4.e(R.string.login_username_or_password_error_more), ah4.e(R.string.common_ok), ah4.e(R.string.common_cancel), true, (kn3.d) new f());
                kn3Var.show();
                kn3Var.p();
                this.errorTip.setVisibility(8);
            }
        } else if (str2.equals("10022")) {
            vc2.b(getContext(), null);
        } else if (str2.equals("500413")) {
            cs3.j(getContext(), ah4.e(R.string.notification_change_email2)).show();
        } else if (!TextUtils.equals("500413", str2)) {
            sg3.l(str);
        }
        WearUtils.f(this.f);
        ye3.p(0, z ? 6 : 3, str2, str);
    }

    @Override // dc.dp2
    public void h(boolean z, QueryRemoteAccountInfoBean queryRemoteAccountInfoBean) {
        if (queryRemoteAccountInfoBean.getData() == null || queryRemoteAccountInfoBean.getData().getList() == null || queryRemoteAccountInfoBean.getData().getList().size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < queryRemoteAccountInfoBean.getData().getList().size(); i2++) {
            XYBean xYBeanQ0 = WearUtils.Q0();
            String str = "解密后的邮箱：" + nd3.k(queryRemoteAccountInfoBean.getData().getList().get(i2).getEmail(), xYBeanQ0.x, xYBeanQ0.y);
            arrayList.add(nd3.k(queryRemoteAccountInfoBean.getData().getList().get(i2).getEmail(), xYBeanQ0.x, xYBeanQ0.y));
            arrayList2.add(queryRemoteAccountInfoBean.getData().getList().get(i2).getRemoteAccountId());
        }
        List<User> listFindAll = DaoUtils.getUserDao().findAll();
        for (int i3 = 0; i3 < listFindAll.size(); i3++) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                if (WearUtils.e1(listFindAll.get(i3).getRemoteAccountId())) {
                    if (Objects.equals(listFindAll.get(i3).getId(), arrayList.get(i4))) {
                        listFindAll.get(i3).setRemoteAccountId((String) arrayList2.get(i4));
                        DaoUtils.getUserDao().update(listFindAll.get(i3));
                    }
                } else if (listFindAll.get(i3).getRemoteAccountId().equals(arrayList2.get(i4))) {
                    String str2 = "RealId====111" + listFindAll.get(i3).getId() + "   getRemoteAccountId= " + listFindAll.get(i3).getRemoteAccountId();
                    String str3 = "friendEmail====111" + ((String) arrayList.get(i4)) + "   friendAccountIdList= " + ((String) arrayList2.get(i4));
                    if (!Objects.equals(listFindAll.get(i3).getId(), arrayList.get(i4))) {
                        DaoUtils.updateFriendEmail(listFindAll.get(i3).getId(), (String) arrayList.get(i4));
                        DaoUtils.getUserDao().delT(listFindAll.get(i3));
                        listFindAll.get(i3).setId((String) arrayList.get(i4));
                        listFindAll.get(i3).setRemoteAccountId((String) arrayList2.get(i4));
                        DaoUtils.getUserDao().add(listFindAll.get(i3));
                    }
                }
            }
        }
    }

    @Override // dc.l12.k
    public void i(boolean z) {
    }

    @Override // dc.l12.k
    public void l(boolean z) {
    }

    @Override // dc.bu3
    public void l3(String str) {
        sg3.l(str);
        L();
        this.password.setEnabled(true);
        this.email.setEnabled(true);
        MyApplication.Q = 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.email_content_delete /* 2131362596 */:
                this.email.setText("");
                this.emailContentDelete.setVisibility(8);
                break;
            case R.id.explore_btn /* 2131362704 */:
                ue3.a(this.password, getContext());
                zt3.k = "";
                eg3.m(MyApplication.N(), "gen_token_Key");
                eg3.m(MyApplication.N(), "r_token_Key");
                WearUtils.s = "";
                WearUtils.t = "";
                Bundle bundle = new Bundle();
                bundle.putBoolean("isOffline", true);
                pj3.r(getContext(), MainActivity.class, bundle);
                break;
            case R.id.forgetPassword_btn /* 2131362797 */:
            case R.id.login_btn /* 2131363662 */:
            case R.id.signUp_btn /* 2131364557 */:
                this.a = view.getId();
                K();
                break;
            case R.id.google_sign_iv /* 2131362859 */:
                tq2.a().c(getActivity(), tq2.a.Google, new b());
                break;
            case R.id.iv_delete_psw /* 2131363147 */:
                this.password.setText("");
                this.llPassword.setVisibility(8);
                break;
            case R.id.password_content_show /* 2131364007 */:
                this.k = !this.k;
                EditText editText = this.password;
                editText.setText(editText.getText());
                EditText editText2 = this.password;
                editText2.setSelection(editText2.length());
                if (!this.k) {
                    this.password.setInputType(TsExtractor.TS_STREAM_TYPE_AC3);
                    this.passwordContentShow.setImageResource(R.drawable.icon_eye_close);
                    break;
                } else {
                    this.password.setInputType(CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA);
                    this.passwordContentShow.setImageResource(R.drawable.icon_eye_open);
                    break;
                }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialog);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (getArguments() != null) {
            this.q = getArguments().getInt("isChange", 0);
            this.r = getArguments().getInt("intoType", 0);
            this.c = getArguments().getString("email", "");
            this.A = getArguments().getBoolean("isDialogTheme", false);
            if (!WearUtils.e1(getArguments().getString("gotoVerify"))) {
                sg3.l(ah4.e(R.string.email_not_verify_toast1));
                Q(getArguments().getString("gotoVerify"));
            }
        }
        View viewInflate = layoutInflater.inflate(R.layout.login_new, (ViewGroup) null, false);
        ButterKnife.bind(this, viewInflate);
        X();
        me3.c(me3.c.LOGIN_UI_ENTER);
        WearUtils.z2();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        MyApplication.O = false;
        MyApplication.Z = true;
        EventBus.getDefault().post(ManagerRDBean.getManager());
        EventBus.getDefault().post(new LoginOrOfflineEvent(false));
        OrgySetting.getInstance().loginOutRemoveData();
        W();
        b0();
        C0();
        a0();
        E0();
        viewInflate.findViewById(R.id.lovense_icon).setOnLongClickListener(new View.OnLongClickListener() { // from class: dc.jy1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return LoginFragment.h0(view);
            }
        });
        if (WearUtils.b1()) {
            viewInflate.findViewById(R.id.lovense_icon).setOnClickListener(new View.OnClickListener() { // from class: dc.qy1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.j0(view);
                }
            });
        }
        ep1.b().l();
        if (PlayService.R) {
            EventBus.getDefault().post(new NotificationCloseEvent());
        }
        hu3.z(getContext()).l(this);
        c0();
        EventBus.getDefault().register(this);
        tq2.a().d(getActivity(), new qq2() { // from class: dc.ry1
            @Override // dc.qq2
            public final void a() {
                LoginFragment.k0();
            }
        });
        if (getActivity() != null) {
            this.u = new vr3(getActivity());
        }
        if (this.A) {
            this.loginClose.setVisibility(8);
            this.topView.setVisibility(0);
            this.screanRootLayout.setRadiusTop(16.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.signUpBtn.getLayoutParams();
            layoutParams.addRule(3, R.id.login_above_layout);
            layoutParams.removeRule(12);
            layoutParams.setMargins(0, ce3.a(MyApplication.N(), 128.0f), 0, ce3.a(MyApplication.N(), 18.0f));
            this.signUpBtn.setLayoutParams(layoutParams);
            AutoRelativeLayout.LayoutParams layoutParams2 = new AutoRelativeLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, ce3.a(MyApplication.N(), 49.0f), 0, 0);
            this.loginAboveLayout.setLayoutParams(layoutParams2);
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ch0 ch0Var = this.s;
        if (ch0Var != null) {
            ch0Var.dismiss();
            this.s.c();
        }
        this.e.removeCallbacksAndMessages(null);
        hu3.z(getContext()).c0(this);
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EditEmailEvent editEmailEvent) {
        Dialog dialog;
        if (editEmailEvent == null || (dialog = this.t) == null) {
            return;
        }
        dialog.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MyApplication.Z = true;
        FrozenAccountResponse frozenAccountResponseN = zb2.O().N();
        if (frozenAccountResponseN != null) {
            K0(getActivity(), frozenAccountResponseN.getFrozenTimestamp());
            zb2.O().O0(null);
        }
    }

    @Override // dc.ul2
    public void showErrorMsg(String str, boolean z) {
    }

    public final void u0(String str, String str2, String str3, LoginUserBean loginUserBean) {
        this.m = str2;
        if (WearUtils.e1(str2)) {
            sg3.h(R.string.system_email_error);
            return;
        }
        if (WearUtils.e1(str3) && !eg3.d(MyApplication.N(), "is_third_login", false)) {
            sg3.h(R.string.account_password_empty);
            return;
        }
        ue3.a(this.password, getContext());
        if (WearUtils.b1() && !eg3.d(MyApplication.N(), "is_third_login", false)) {
            DaoUtils.getTestValueDao().save(this.n, str3, "0");
        }
        MyApplication.b0 = new Date().getTime() + "";
        DaoUtils.getTestValueDao().save(TestValueDao.SAVE_KEY_LAST_LI_KEY, this.m, TestValueDao.SAVE_KEY_LAST_LI_TYPE);
        this.l = hu3.z(getContext());
        DaoUtils.upDateEmail(loginUserBean);
        synchronized (this) {
            y0();
            if (eg3.d(MyApplication.N(), "is_third_login", false)) {
                this.l.s(this.m, nd3.i(WearUtils.s), str, str2);
            } else {
                this.l.s(this.m, str3, str, str2);
            }
        }
    }

    @Override // dc.bu3
    public void u1(String str) {
        l3(str);
    }

    public final void v0() {
        M0();
        this.f = this.email.getText().toString().trim();
        this.g = this.password.getText().toString();
        if (WearUtils.e1(this.f)) {
            sg3.h(R.string.account_username_empty);
            return;
        }
        if (WearUtils.e1(this.g)) {
            sg3.h(R.string.account_password_empty);
            return;
        }
        this.b = true;
        this.password.setEnabled(false);
        this.email.setEnabled(false);
        this.p = null;
        Runnable runnable = new Runnable() { // from class: dc.my1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g0();
            }
        };
        this.p = runnable;
        WearUtils.x.l.postDelayed(runnable, 1500L);
    }

    @Override // dc.dp2
    public void w(boolean z, LoginUserBean loginUserBean) {
        ye3.K(5);
        if (MusicControl.h0().O()) {
            MusicControl.h0().S();
        }
        this.d.h();
        y12.c.a().t();
        this.f = loginUserBean.getUsername();
        zd3.d(MyApplication.N(), "xmpp_email_simple_name", this.f);
        WearUtils.k2(this.f);
        String email = loginUserBean.getEmail();
        String username = loginUserBean.getUsername();
        this.i = loginUserBean.isIsTest();
        if (WearUtils.e1(email)) {
            L();
            this.password.setEnabled(true);
            this.email.setEnabled(true);
            return;
        }
        this.m = email + WearUtils.F(this.f);
        this.n = this.f;
        this.h = loginUserBean.getUid();
        if (eg3.d(MyApplication.N(), "is_third_login", false)) {
            zd3.f("userName", loginUserBean.getUsername());
        }
        J(loginUserBean, email, username);
    }

    public final void w0(LoginUserBean loginUserBean, String str, String str2) {
        ye3.L(loginUserBean);
        u0(str2, str, this.g, loginUserBean);
        EventBus.getDefault().post(new LoginStatusActionEvent());
    }

    public final void y0() {
        final List<User> listFindAll = DaoUtils.getUserDao().findAll();
        if (listFindAll == null || listFindAll.size() == 0) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        new Thread(new Runnable() { // from class: dc.py1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m0(listFindAll, arrayList);
            }
        }).start();
    }

    public final void z0() {
        OfficialaCountModel.g.a().E(lg3.b(getContext()));
    }
}
