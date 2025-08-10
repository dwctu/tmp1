package com.wear.ui.me;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.google.android.gms.common.Scopes;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Account;
import com.wear.bean.AvatarReportStatusBean;
import com.wear.bean.PolicyListBean;
import com.wear.bean.ThirdRefreshGToken;
import com.wear.bean.event.VCardChangeEvent;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.main.account.EditNickNameActivity;
import com.wear.main.account.HelpActivity;
import com.wear.network.presenter.bean.GenTokenBean;
import com.wear.network.presenter.bean.LoginUserBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.ui.me.ProfileActivity;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import com.wear.widget.SwitchView;
import com.wear.widget.dialog.NewEmailVerifyDialog;
import com.wear.widget.dialog.VerifyDialog;
import dc.ah4;
import dc.bo3;
import dc.ch3;
import dc.cs3;
import dc.eg3;
import dc.ej3;
import dc.ep1;
import dc.ge3;
import dc.gp1;
import dc.hu3;
import dc.ip1;
import dc.is3;
import dc.kn3;
import dc.kp2;
import dc.lg3;
import dc.me3;
import dc.mp1;
import dc.nd3;
import dc.pj3;
import dc.q61;
import dc.qe3;
import dc.ql2;
import dc.sg3;
import dc.t51;
import dc.tg3;
import dc.th4;
import dc.tn2;
import dc.tr3;
import dc.tz;
import dc.u51;
import dc.vf3;
import dc.vg3;
import dc.wg3;
import dc.xf3;
import dc.ye3;
import dc.yn2;
import dc.zd3;
import dc.zn2;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.NoSuchPaddingException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.roster.packet.RosterVer;

/* loaded from: classes4.dex */
public class ProfileActivity extends BaseActivity implements kp2, View.OnClickListener, ge3.b {
    public final File a;
    public final Handler b;

    @BindView(R.id.birthday_view)
    public TextView birthdayView;
    public ql2 c;

    @BindView(R.id.change_avatar)
    public ImageView changeAvatar;
    public gp1 d;
    public int e;

    @BindView(R.id.email)
    public TextView email;

    @BindView(R.id.email_tip)
    public TextView emailTip;

    @BindView(R.id.email_tip_verify)
    public TextView emailTipVerify;
    public MyApplication f;
    public Uri g;

    @BindView(R.id.gender)
    public TextView gender;

    @BindView(R.id.gender_layout)
    public RelativeLayout genderLayout;
    public boolean h;
    public Account i;

    @BindView(R.id.information_layout)
    public LinearLayout informationLayout;

    @BindView(R.id.iv_back)
    public ImageView ivBack;
    public int j;
    public String k;
    public String l;

    @BindView(R.id.ll_default_avatar)
    public LinearLayout llDefaultAvatar;
    public Dialog m;

    @BindView(R.id.nickname)
    public TextView nickname;

    @BindView(R.id.nickname_layout)
    public LinearLayout nicknameLayout;

    @BindView(R.id.photo_layout)
    public ImageView photoLayout;

    @BindView(R.id.scroll_view)
    public ScrollView scrollView;

    @BindView(R.id.set_birth_day_view)
    public ImageView setBirthDayView;

    @BindView(R.id.set_birthday_layout)
    public RelativeLayout setBirthday;

    @BindView(R.id.birthday_notice_view)
    public TextView set_birthday_notice;

    @BindView(R.id.birthday_swith_button)
    public SwitchView switchButton;

    @BindView(R.id.terms_and_conditions_for_birthday)
    public TextView termsAndConditionsForBirthday;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws Resources.NotFoundException {
            LoginUserBean.Birth birth = WearUtils.y.o().getBirth();
            if (birth.getBirthdayMonth() != 0 || birth.getBirthdayDay() != 0) {
                ProfileActivity.this.c.v(birth.getSubscribeStatus() == 0 ? 1 : 0);
                ProfileActivity.this.switchButton.setEnabled(false);
                return;
            }
            ProfileActivity.this.switchButton.setCheckedImmediatelyNoEvent(false);
            ProfileActivity.this.set_birthday_notice.setVisibility(0);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(ProfileActivity.this, R.anim.jitter_animation);
            animationLoadAnimation.setInterpolator(new CycleInterpolator(5.0f));
            ProfileActivity.this.set_birthday_notice.startAnimation(animationLoadAnimation);
            ProfileActivity.this.scrollView.scrollTo(0, ProfileActivity.this.scrollView.getMaxScrollAmount());
        }
    }

    public class a0 implements zn2<String> {
        public final /* synthetic */ String a;

        public a0(String str) {
            this.a = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            ProfileActivity.this.dissDialog();
            GenTokenBean genTokenBean = (GenTokenBean) new Gson().fromJson(str, GenTokenBean.class);
            if (genTokenBean == null) {
                sg3.j(ProfileActivity.this, R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
                ProfileActivity.this.finish();
            }
            if (!genTokenBean.isResult() || genTokenBean.getData() == null) {
                sg3.k(ProfileActivity.this, genTokenBean.getMessage());
                return;
            }
            eg3.i(ProfileActivity.this.f, "gen_token_Key", nd3.u(genTokenBean.getData().getGtoken()));
            eg3.i(ProfileActivity.this.f, "r_token_Key", nd3.u(genTokenBean.getData().getRtoken()));
            WearUtils.s = nd3.u(genTokenBean.getData().getGtoken());
            WearUtils.t = nd3.u(genTokenBean.getData().getRtoken());
            WearUtils.w2(genTokenBean.getData().getX(), genTokenBean.getData().getY());
            sg3.i(ProfileActivity.this, R.string.comman_saved_successfully);
            zd3.f("userName", this.a.toLowerCase());
            Account accountU = WearUtils.y.u();
            if (accountU != null) {
                accountU.setName(this.a);
                ch3.n().P();
                hu3.w0();
                ProfileActivity.this.k = this.a;
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ProfileActivity.this.dissDialog();
            sg3.k(ProfileActivity.this, netException.getMessage());
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Intent a;

        public class a implements tg3.a {
            public a() {
            }

            @Override // dc.tg3.a
            public void a(Bitmap bitmap, String str) {
                ProfileActivity.this.b5(null);
            }
        }

        public b(Intent intent) {
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            ProfileActivity.this.h = true;
            Uri data = ProfileActivity.this.g;
            Intent intent = this.a;
            if (intent != null && intent.getData() != null) {
                data = this.a.getData();
            }
            tg3.e(ProfileActivity.this.a, ProfileActivity.this, data, new a());
        }
    }

    public class c implements ip1 {
        public c() {
        }

        @Override // dc.ip1
        public void G() {
            ProfileActivity.this.dissDialog();
        }

        @Override // dc.ip1
        public void d() {
            ProfileActivity.this.cancleDelay();
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ Bitmap a;

        public d(Bitmap bitmap) {
            this.a = bitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(Bitmap bitmap) {
            ProfileActivity.this.b5(bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(Bitmap bitmap) throws IOException {
            final Bitmap bitmapI2 = WearUtils.I2(bitmap);
            WearUtils.d2(bitmapI2, ProfileActivity.this.a.getPath());
            ProfileActivity.this.parentHandler.post(new Runnable() { // from class: dc.sb3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(bitmapI2);
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            vg3 vg3VarB = vg3.b();
            final Bitmap bitmap = this.a;
            vg3VarB.a(new Runnable() { // from class: dc.rb3
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.a.d(bitmap);
                }
            });
        }
    }

    public class e implements ip1 {
        public e() {
        }

        @Override // dc.ip1
        public void G() {
            ProfileActivity.this.dissDialog();
        }

        @Override // dc.ip1
        public void d() {
            ProfileActivity.this.cancleDelay();
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
            RequestPermissionActivity.s4(ProfileActivity.this);
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProfileActivity.this.b5(null);
        }
    }

    public class h implements ip1 {
        public h() {
        }

        @Override // dc.ip1
        public void G() {
            ProfileActivity.this.dissDialog();
        }

        @Override // dc.ip1
        public void d() {
            ProfileActivity.this.cancleDelay();
        }
    }

    public class i extends ClickableSpan {
        public i() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            pj3.f(ProfileActivity.this, HelpActivity.class);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(ProfileActivity.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
            textPaint.clearShadowLayer();
        }
    }

    public class j implements is3.d {
        public j(ProfileActivity profileActivity) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
        }
    }

    public class k extends Handler {
        public k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                if (ProfileActivity.this.activity.isDestroyed()) {
                    return;
                }
                ej3.a(ProfileActivity.this).q(th4.d(ProfileActivity.this, R.drawable.light_nav_picture)).A0(ProfileActivity.this.photoLayout);
            } else if (i == 2 && !ProfileActivity.this.activity.isDestroyed()) {
                ej3.a(ProfileActivity.this).q(th4.d(ProfileActivity.this, R.drawable.nav_picture)).A0(ProfileActivity.this.photoLayout);
            }
        }
    }

    public class l implements DialogInterface.OnDismissListener {
        public l() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ProfileActivity.this.setBirthday.setEnabled(true);
        }
    }

    public class m implements tr3.c {
        public final /* synthetic */ tr3 a;

        public class a implements is3.d {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;

            public a(int i, int i2) {
                this.a = i;
                this.b = i2;
            }

            @Override // dc.is3.d
            public void doConfirm() {
                m.this.a.dismiss();
                ProfileActivity.this.showDialog();
                ProfileActivity.this.c.u(this.a, this.b);
            }
        }

        public m(tr3 tr3Var) {
            this.a = tr3Var;
        }

        @Override // dc.tr3.c
        public void a(int i, int i2) {
            Log.println(3, "birthday_picker_selecte", i + "," + i2);
            ProfileActivity profileActivity = ProfileActivity.this;
            cs3.c(profileActivity, profileActivity.getString(R.string.notification_birthday_submit), ProfileActivity.this.getString(R.string.common_ok), ProfileActivity.this.getString(R.string.common_cancel), new a(i, i2)).show();
        }

        @Override // dc.tr3.c
        public void onCancel() {
            this.a.dismiss();
        }
    }

    public class n implements bo3.d {
        public n() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            ProfileActivity.this.K4(R.id.from_camera);
        }
    }

    public class o implements bo3.d {
        public o() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            ProfileActivity.this.K4(R.id.from_album);
        }
    }

    public class p implements u51 {

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(ProfileActivity.this);
            }
        }

        public p() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            t51.a(this, list, z);
            if (z) {
                is3.b bVar = new is3.b(ProfileActivity.this.activity);
                bVar.p(ah4.e(R.string.app_open_camera_permission));
                bVar.o(ah4.e(R.string.common_confirm));
                bVar.n(ah4.e(R.string.common_cancel));
                bVar.d(new a());
                cs3.h(bVar).show();
            }
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                ProfileActivity.this.T4();
            }
        }
    }

    public class q implements bo3.d {
        public q() {
        }

        @Override // dc.bo3.d
        public void a(int i) {
            ProfileActivity.this.j = i;
            if (ProfileActivity.this.j == R.id.common_female) {
                ProfileActivity.this.gender.setText(ah4.e(R.string.common_female));
            } else if (ProfileActivity.this.j == R.id.common_male) {
                ProfileActivity.this.gender.setText(ah4.e(R.string.common_male));
            } else {
                ProfileActivity.this.gender.setText(ah4.e(R.string.common_other));
            }
        }
    }

    public class r implements DialogInterface.OnDismissListener {
        public r() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ProfileActivity.this.m = null;
        }
    }

    public class s implements NewEmailVerifyDialog.c {
        public s() {
        }

        @Override // com.wear.widget.dialog.NewEmailVerifyDialog.c
        public void a() {
            ProfileActivity.this.m.dismiss();
            ProfileActivity.this.V4(true);
            vf3.a("A0024", 2, 2);
        }

        @Override // com.wear.widget.dialog.NewEmailVerifyDialog.c
        public void b(int i) {
            vf3.a("A0024", 2, 3);
        }

        @Override // com.wear.widget.dialog.NewEmailVerifyDialog.c
        public void c() {
            vf3.a("A0024", 2, 4);
        }
    }

    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ProfileActivity.this.finish();
        }
    }

    public class u implements zn2<String> {

        public class a implements zn2<String> {
            public a() {
            }

            @Override // dc.zn2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                NormalResponse normalResponse = (NormalResponse) new Gson().fromJson(str, NormalResponse.class);
                if (normalResponse != null && normalResponse.isResult()) {
                    ProfileActivity.this.i.setUserCode(normalResponse.getMessage());
                    ch3.n().P();
                    hu3.w0();
                }
            }

            @Override // dc.zn2
            public void onError(NetException netException) {
            }
        }

        public u() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            if (WearUtils.e1(str)) {
                return;
            }
            Map map = (Map) new Gson().fromJson(str, Map.class);
            String strA = xf3.a(ProfileActivity.this.i.getPassword(), (String) map.get("modulus"), (String) map.get("exponent"));
            HashMap map2 = new HashMap();
            map2.put("password", strA);
            map2.put("isNewApp", Boolean.TRUE);
            tn2.x(WearUtils.x).l("/toy/getMyUserId", map2, new a());
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
        }
    }

    public class v implements zn2<String> {

        public class a extends TypeReference<BaseResponseBeanNew<AvatarReportStatusBean>> {
            public a(v vVar) {
            }
        }

        public v() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this), new Feature[0]);
            if (baseResponseBeanNew.result) {
                eg3.i(MyApplication.N(), "avatar_report_status", new Gson().toJson(baseResponseBeanNew.data));
                if (((AvatarReportStatusBean) baseResponseBeanNew.data).isRestrict()) {
                    ProfileActivity.this.b.sendEmptyMessage(1);
                } else {
                    ProfileActivity.this.b.sendEmptyMessage(2);
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            netException.printStackTrace();
        }
    }

    public class w extends ClickableSpan {
        public w() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            pj3.f(ProfileActivity.this, BirthDayTermsAndConditions.class);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
        }
    }

    public class x implements zn2<String> {
        public final /* synthetic */ Account a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public class a implements Runnable {
            public final /* synthetic */ NormalResponse a;

            public a(NormalResponse normalResponse) {
                this.a = normalResponse;
            }

            @Override // java.lang.Runnable
            public void run() {
                ProfileActivity.this.h = false;
                WearUtils.r2(this.a.getMessage(), x.this.a);
                ch3.n().P();
                ProfileActivity.this.dissDialog();
                x xVar = x.this;
                Bitmap bitmap = xVar.b;
                if (bitmap == null) {
                    ProfileActivity.this.changeAvatar.setImageURI(null);
                    ProfileActivity profileActivity = ProfileActivity.this;
                    profileActivity.changeAvatar.setImageURI(profileActivity.g);
                } else {
                    ProfileActivity.this.changeAvatar.setImageBitmap(bitmap);
                }
                ProfileActivity.this.llDefaultAvatar.setVisibility(8);
                if (ProfileActivity.this.k.equals(x.this.c)) {
                    sg3.i(ProfileActivity.this, R.string.comman_saved_successfully);
                } else {
                    x xVar2 = x.this;
                    ProfileActivity.this.R4(xVar2.c, xVar2.d);
                }
            }
        }

        public class b implements Runnable {
            public b(x xVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                hu3.w0();
            }
        }

        public x(Account account, Bitmap bitmap, String str, String str2) {
            this.a = account;
            this.b = bitmap;
            this.c = str;
            this.d = str2;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (normalResponse == null) {
                ProfileActivity.this.dissDialog();
                sg3.j(ProfileActivity.this, R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
                return;
            }
            if (normalResponse == null || !normalResponse.isResult()) {
                ProfileActivity.this.dissDialog();
                sg3.k(ProfileActivity.this, normalResponse.getMessage());
            } else {
                ProfileActivity.this.runOnMainThread(new a(normalResponse));
                new Thread(new b(this)).start();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ProfileActivity.this.dissDialog();
            sg3.k(ProfileActivity.this, netException.getMessage());
        }
    }

    public class y implements zn2<String> {
        public final /* synthetic */ String a;

        public y(String str) {
            this.a = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            NormalResponse normalResponse = (NormalResponse) new Gson().fromJson(str, NormalResponse.class);
            if (normalResponse == null) {
                ProfileActivity.this.dissDialog();
                sg3.j(ProfileActivity.this, R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
                ProfileActivity profileActivity = ProfileActivity.this;
                profileActivity.nickname.setText(profileActivity.k);
                return;
            }
            if (normalResponse.isResult()) {
                if (eg3.d(ProfileActivity.this, "is_third_login", false)) {
                    ProfileActivity.this.a5(this.a);
                    return;
                } else {
                    ProfileActivity.this.S4(this.a);
                    return;
                }
            }
            ProfileActivity.this.dissDialog();
            sg3.k(ProfileActivity.this, normalResponse.getMessage());
            ProfileActivity profileActivity2 = ProfileActivity.this;
            profileActivity2.nickname.setText(profileActivity2.k);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ProfileActivity.this.dissDialog();
            sg3.k(ProfileActivity.this, netException.getMessage());
            ProfileActivity profileActivity = ProfileActivity.this;
            profileActivity.nickname.setText(profileActivity.k);
        }
    }

    public class z implements yn2<BaseResponseBeanNew<ThirdRefreshGToken>> {
        public final /* synthetic */ String a;

        public z(String str) {
            this.a = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<ThirdRefreshGToken> baseResponseBeanNew) {
            if (baseResponseBeanNew.code != 0 || baseResponseBeanNew.data == null) {
                return;
            }
            eg3.i(ProfileActivity.this.f, "gen_token_Key", nd3.u(baseResponseBeanNew.data.getGtoken()));
            WearUtils.s = nd3.u(baseResponseBeanNew.data.getGtoken());
            sg3.i(ProfileActivity.this, R.string.comman_saved_successfully);
            zd3.f("userName", this.a.toLowerCase());
            Account accountU = WearUtils.y.u();
            if (accountU != null) {
                accountU.setName(this.a);
                ch3.n().P();
                hu3.w0();
                ProfileActivity.this.k = this.a;
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    public ProfileActivity() {
        File fileE0 = WearUtils.e0("camera.jpg");
        this.a = fileE0;
        this.b = new k(Looper.getMainLooper());
        this.e = -1;
        this.g = Uri.fromFile(fileE0);
        this.h = false;
        this.k = "";
        this.l = "";
    }

    public static /* synthetic */ void P4() {
    }

    public final void K4(int i2) {
        this.e = i2;
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES");
        q61VarM.j(new p());
    }

    public final void L4() {
        tn2.x(this).l("/remote/report-user/avatarReportStatus", new HashMap(), new v());
    }

    public final String M4(int i2) {
        return i2 == 1 ? getString(R.string.birthday_month_jan) : i2 == 2 ? getString(R.string.birthday_month_feb) : i2 == 3 ? getString(R.string.birthday_month_mar) : i2 == 4 ? getString(R.string.birthday_month_apr) : i2 == 5 ? getString(R.string.birthday_month_may) : i2 == 6 ? getString(R.string.birthday_month_jun) : i2 == 7 ? getString(R.string.birthday_month_jul) : i2 == 8 ? getString(R.string.birthday_month_aug) : i2 == 9 ? getString(R.string.birthday_month_sept) : i2 == 10 ? getString(R.string.birthday_month_oct) : i2 == 11 ? getString(R.string.birthday_month_nov) : i2 == 12 ? getString(R.string.birthday_month_dec) : "";
    }

    public final void N4() {
        String strE = ah4.e(R.string.birthday_offer_terms_txt1);
        String str = String.format(ah4.e(R.string.birthday_offer_tip), strE);
        int iIndexOf = str.indexOf(strE);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (iIndexOf != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.diff_select_text_color)), iIndexOf, strE.length() + iIndexOf, 33);
            spannableStringBuilder.setSpan(new w(), iIndexOf, strE.length() + iIndexOf, 33);
        }
        this.termsAndConditionsForBirthday.setMovementMethod(new LinkMovementMethod());
        this.termsAndConditionsForBirthday.setText(spannableStringBuilder);
    }

    @SuppressLint({"SetTextI18n"})
    public final void O4(boolean z2) {
        if (!z2) {
            this.setBirthday.setEnabled(true);
            this.setBirthDayView.setVisibility(0);
            this.birthdayView.setVisibility(8);
            return;
        }
        this.setBirthday.setEnabled(false);
        this.setBirthDayView.setVisibility(8);
        this.birthdayView.setVisibility(0);
        int birthdayMonth = WearUtils.y.o().getBirth().getBirthdayMonth();
        int birthdayDay = WearUtils.y.o().getBirth().getBirthdayDay();
        String strM4 = M4(birthdayMonth);
        this.birthdayView.setText(strM4 + "," + birthdayDay);
    }

    @Override // dc.ge3.b
    public void R1(int i2, String str) {
        dissDialog();
        if (i2 == 50000) {
            sg3.l(ah4.e(R.string.error_verify_reach_limit));
        } else {
            sg3.l(ah4.e(R.string.notif_note2));
        }
    }

    public final void R4(String str, String str2) {
        HashMap map = new HashMap();
        map.put("username", str);
        map.put("gender", (WearUtils.e1(str2) || str2.length() <= 0) ? "o" : Character.valueOf(str2.toLowerCase().charAt(0)));
        tn2.x(WearUtils.x).l("/app/account/modifyProfile", map, new y(str));
    }

    public final void S4(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        String strA = xf3.a(nd3.i(eg3.h(this, "xmpp_password", null)), "009b72ee52c67697ee4290955ad91aa52172cf7494ce6cbfd711c4ce76efe9efad4a151174e774165944ba97b6d72934d6f04c53c1aef30b736c7cae8fb2638670efb89cdb4eb40d4ea6264fa3157e711c6d2779ce2cc4146d0cc7af7a2d7e5dec470862efb81bc541348cbb0176f3b75b0d842b36ffeec46070a6517f4330f883", "010001");
        HashMap map = new HashMap();
        map.put("email", str.toLowerCase());
        map.put("password", strA);
        map.put("pf", wg3.a());
        map.put(RosterVer.ELEMENT, WearUtils.q);
        map.put("signature", wg3.b(str.toLowerCase() + "##" + strA));
        map.put("tag", Scopes.PROFILE);
        map.put("sessionId", ye3.x());
        map.put("deviceId", tz.i());
        map.put("deviceName", Build.MODEL);
        tn2.x(WearUtils.x).l("/api/wear/genGtoken", map, new a0(str));
    }

    public void T4() {
        int i2 = this.e;
        if (i2 == R.id.from_camera) {
            this.g = tg3.l(this, this.a, 16);
        } else if (i2 == R.id.from_album) {
            tg3.k(this.activity, 17);
        }
    }

    public final void U4() {
        Account accountU = WearUtils.y.u();
        if (accountU != null) {
            this.i = accountU;
            this.nickname.setText(accountU.getUserName());
            WearUtils.v2(this.changeAvatar, accountU.getAvatar(), this.llDefaultAvatar);
        }
    }

    public final void V4(boolean z2) {
        if (WearUtils.e1(this.l)) {
            return;
        }
        this.emailTip.setVisibility(z2 ? 8 : 0);
        this.emailTipVerify.setVisibility(z2 ? 8 : 0);
    }

    public final void W4() {
        tr3 tr3Var = new tr3(this, R.style.MaterialDialogSheet);
        tr3Var.show();
        tr3Var.setOnDismissListener(new l());
        tr3Var.i(new m(tr3Var));
    }

    public void X4(String str) {
        is3.b bVar = new is3.b(this);
        bVar.d(new is3.d() { // from class: dc.tb3
            @Override // dc.is3.d
            public final void doConfirm() {
                ProfileActivity.P4();
            }
        });
        bVar.c(new is3.c() { // from class: dc.ub3
            @Override // dc.is3.c
            public final void doCancel() {
                vf3.a("A0024", 2, 1);
            }
        });
        bVar.h(true);
        bVar.u(R.id.tv_confirm);
        bVar.t(R.id.tv_cancel);
        bVar.n(ah4.e(R.string.common_cancel));
        bVar.o(ah4.e(R.string.button_verified));
        bVar.e(str);
        is3 is3VarI = cs3.i(bVar, NewEmailVerifyDialog.class);
        this.m = is3VarI;
        is3VarI.setOnDismissListener(new r());
        ((NewEmailVerifyDialog) this.m).setiVerifyEmailListener(new s());
        ((NewEmailVerifyDialog) this.m).setAutoSend(false);
        this.m.show();
        vf3.a("A0023", 2, -1);
    }

    public final void Y4() {
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_account_gender);
        bo3Var.show();
        q qVar = new q();
        bo3Var.d(R.id.common_male, qVar);
        bo3Var.d(R.id.common_female, qVar);
        bo3Var.d(R.id.common_other, qVar);
    }

    public final void Z4() {
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_account_photo);
        bo3Var.show();
        bo3Var.d(R.id.from_camera, new n());
        bo3Var.d(R.id.from_album, new o());
        bo3Var.d(R.id.delete_avatar, null);
    }

    public final void a5(String str) {
        tn2.x(this.f).d("api/wear/refresh_gtoken_by_gtoken", new z(str));
    }

    public final void b5(Bitmap bitmap) {
        String string = this.nickname.getText().toString();
        if (WearUtils.e1(string) || this.nickname.length() > 20) {
            dissDialog();
            sg3.i(this, R.string.register_name_error);
            return;
        }
        int i2 = this.j;
        String str = i2 == R.id.common_female ? "Female" : i2 == R.id.common_male ? "Male" : "Other";
        Account accountU = WearUtils.y.u();
        if (this.h) {
            tn2.x(WearUtils.x).A("/wear/avatar/add", this.a, null, new x(accountU, bitmap, string, str));
        } else if (this.k.equals(string)) {
            dissDialog();
        } else {
            R4(string, str);
        }
    }

    public final void c5() {
        vf3.a("A0028", -1, -1);
        if (System.currentTimeMillis() - ge3.b < 60000) {
            sg3.l(ah4.e(R.string.notif_note2));
            return;
        }
        String str = this.l;
        ge3.b(str, false, str, this);
        showDialog();
    }

    @Override // dc.kp2
    public void d1() {
        dissDialog();
        O4(true);
        this.set_birthday_notice.setVisibility(8);
    }

    @Override // dc.ge3.b
    public void i0(String str) {
        dissDialog();
        X4(this.l);
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        this.mActivityComponent.j(this);
        this.mPresenter = this.c;
    }

    @Override // dc.kp2
    public void k2(boolean z2) {
        if (z2) {
            LoginUserBean.Birth birth = WearUtils.y.o().getBirth();
            birth.setSubscribeStatus(birth.getSubscribeStatus() == 0 ? 1 : 0);
        } else {
            this.switchButton.setCheckedImmediatelyNoEvent(!r3.isChecked());
        }
        this.switchButton.setEnabled(true);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 16) {
            if (i3 != -1) {
                this.h = false;
                return;
            }
            this.d = new gp1(new b(intent), new c());
            showDialog();
            ep1.b().r(this, this.d);
            return;
        }
        if (i2 != 17) {
            if (i2 != 153) {
                if (i2 == 888 && i3 == -1) {
                    boolean booleanExtra = intent.getBooleanExtra("grant_all", false);
                    intent.getIntArrayExtra("grant_results");
                    if (booleanExtra) {
                        T4();
                        return;
                    } else {
                        new kn3((Context) this, ah4.e(R.string.app_open_camera_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new f()).show();
                        return;
                    }
                }
                return;
            }
            if (i3 != -1 || intent == null || intent.getStringExtra("nickname") == null) {
                return;
            }
            this.nickname.setText(intent.getStringExtra("nickname"));
            this.h = false;
            this.d = new gp1(new g(), new h());
            if (ep1.b().r(this, this.d)) {
                showDialog();
                return;
            }
            return;
        }
        if (i3 != -1 || intent == null || intent.getData() == null) {
            return;
        }
        Uri data = intent.getData();
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = 2;
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(data), null, options);
            Bitmap bitmapL = WearUtils.l(this.f, bitmapDecodeStream, qe3.g(this, data, bitmapDecodeStream));
            if (bitmapL != null) {
                this.h = true;
                this.d = new gp1(new d(bitmapL), new e());
                if (ep1.b().r(this, this.d)) {
                    showDialog();
                }
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
            this.h = false;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.wear.BaseActivity, dc.cs3.b
    public void onCancel() {
        super.onCancel();
        ep1.b().m(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.change_avatar /* 2131362300 */:
            case R.id.ll_default_avatar /* 2131363496 */:
            case R.id.photo_layout /* 2131364091 */:
                Gson gson = new Gson();
                AvatarReportStatusBean avatarReportStatusBean = (AvatarReportStatusBean) gson.fromJson(eg3.h(this.f, "avatar_report_status", ""), AvatarReportStatusBean.class);
                if (avatarReportStatusBean != null) {
                    if (avatarReportStatusBean.isRestrict()) {
                        String str = String.format(ah4.e(R.string.banned_from_changing_profile_pic), DateFormat.getDateInstance(2, lg3.e(this)).format(Long.valueOf(avatarReportStatusBean.getEndRestrictTimestamp()))) + "\n\n";
                        String strE = ah4.e(R.string.clickable_here);
                        String str2 = str + String.format(ah4.e(R.string.notification_contact_us), strE);
                        String str3 = "all====" + str2;
                        ArrayList arrayList = new ArrayList();
                        PolicyListBean policyListBean = (PolicyListBean) gson.fromJson(eg3.h(this.f, "new_argement_list", ""), PolicyListBean.class);
                        if (policyListBean != null && policyListBean.getData() != null && policyListBean.getData().size() > 0) {
                            for (int i2 = 0; i2 < policyListBean.getData().size(); i2++) {
                                arrayList.add(policyListBean.getData().get(i2).getUrl());
                            }
                        }
                        SpannableString spannableString = new SpannableString(str2);
                        int iIndexOf = str2.indexOf(strE);
                        if (iIndexOf != -1) {
                            spannableString.setSpan(new i(), iIndexOf, strE.length() + iIndexOf, 17);
                        }
                        is3.b bVar = new is3.b(MyApplication.H());
                        bVar.p(spannableString);
                        bVar.o(ah4.e(R.string.common_ok));
                        bVar.d(new j(this));
                        bVar.b(false);
                        cs3.h(bVar).show();
                        break;
                    } else {
                        Z4();
                        break;
                    }
                }
                break;
            case R.id.email_tip_verify /* 2131362600 */:
                c5();
                break;
            case R.id.gender_layout /* 2131362830 */:
                Y4();
                break;
            case R.id.information_layout /* 2131362999 */:
                pj3.f(this, MoreInformationActivity.class);
                break;
            case R.id.nickname_layout /* 2131363925 */:
                pj3.q(this, EditNickNameActivity.class, 153, "nickname", this.nickname.getText().toString());
                break;
            case R.id.set_birthday_layout /* 2131364482 */:
                LoginUserBean.Birth birth = WearUtils.y.o().getBirth();
                if (birth.getBirthdayDay() == 0 && birth.getBirthdayMonth() == 0) {
                    W4();
                    this.setBirthday.setEnabled(false);
                    break;
                }
                break;
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IOException {
        super.onCreate(bundle);
        if (bundle != null) {
            this.h = bundle.getBoolean("hasNewPic", this.h);
        }
        me3.c(me3.c.ME_PROFILE_UI_ENTER);
        ye3.c("my profile", "into page", null);
        WearUtils.C(this);
        setContentView(R.layout.account_profile);
        ButterKnife.bind(this);
        this.f = (MyApplication) getApplication();
        Account accountU = WearUtils.y.u();
        this.i = accountU;
        if (accountU == null) {
            finish();
            return;
        }
        this.ivBack.setOnClickListener(new t());
        L4();
        findViewById(R.id.screan_root_layout);
        this.gender = (TextView) findViewById(R.id.gender);
        this.nickname = (TextView) findViewById(R.id.nickname);
        this.email = (TextView) findViewById(R.id.email);
        String userName = !WearUtils.e1(this.i.getUserName()) ? this.i.getUserName() : "";
        if ("a63c9cdc48b3d685226ba85862cabad29e4a0290171578a5852fa917fcff61e8".equals(tz.i()) && mp1.h()) {
            userName = userName + "-new";
        }
        this.nickname.setText(userName);
        this.nickname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.email.setText(!WearUtils.e1(this.i.getId()) ? this.i.getId() : "");
        this.l = WearUtils.e1(this.i.getId()) ? "" : this.i.getId();
        if (!this.a.exists()) {
            try {
                this.a.createNewFile();
            } catch (IOException unused) {
            }
        }
        this.k = this.nickname.getText().toString();
        if (WearUtils.e1(this.i.getUserCode())) {
            tn2.x(WearUtils.x).f("/ajaxSignup", new u());
        }
        this.photoLayout.setOnClickListener(this);
        this.llDefaultAvatar.setOnClickListener(this);
        this.changeAvatar.setOnClickListener(this);
        this.informationLayout.setOnClickListener(this);
        this.nicknameLayout.setOnClickListener(this);
        this.genderLayout.setOnClickListener(this);
        this.emailTipVerify.setOnClickListener(this);
        this.setBirthday.setOnClickListener(this);
        if ("Female".equalsIgnoreCase(this.i.getGender())) {
            this.gender.setText(ah4.e(R.string.common_female));
            this.j = R.id.common_female;
        } else if ("Male".equalsIgnoreCase(this.i.getGender())) {
            this.gender.setText(ah4.e(R.string.common_male));
            this.j = R.id.common_male;
        } else {
            this.gender.setText(ah4.e(R.string.common_other));
            this.j = R.id.common_other;
        }
        hu3.z(this);
        EventBus.getDefault().register(this);
        if (this.h) {
            this.changeAvatar.setImageURI(null);
            this.changeAvatar.setImageURI(this.g);
            this.llDefaultAvatar.setVisibility(8);
        } else {
            WearUtils.v2(this.changeAvatar, this.i.getAvatar(), this.llDefaultAvatar);
        }
        if (!VerifyDialog.h) {
            vf3.a("A0027", -1, -1);
        }
        V4(VerifyDialog.h);
        N4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        me3.c(me3.c.ME_PROFILE_UI_EXIT);
        this.f.s0("avatar", null);
        File file = this.a;
        if (file != null && file.exists()) {
            this.a.delete();
        }
        ep1.b().m(this);
        EventBus.getDefault().unregister(this);
        this.b.removeCallbacksAndMessages(null);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(VCardChangeEvent vCardChangeEvent) {
        U4();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (WearUtils.y.u() == null || WearUtils.y.o() == null) {
            return;
        }
        this.switchButton.setCheckedImmediatelyNoEvent(WearUtils.y.o().getBirth().getSubscribeStatus() == 1);
        this.switchButton.setOnCheckedChangeListener(new a());
        N4();
        LoginUserBean.Birth birth = WearUtils.y.o().getBirth();
        O4((birth.getBirthdayMonth() == 0 && birth.getBirthdayDay() == 0) ? false : true);
        if (WearUtils.y.o().getBirth().isShowBirthdayTip()) {
            this.c.t();
            ye3.e("M0004", new HashMap());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hasNewPic", this.h);
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z2) {
        super.showErrorMsg(str, z2);
        sg3.l(str);
    }
}
