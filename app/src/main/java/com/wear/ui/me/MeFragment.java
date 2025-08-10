package com.wear.ui.me;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.activity.orgySetting.OrgyHotView;
import com.wear.bean.Account;
import com.wear.bean.AvatarReportStatusBean;
import com.wear.bean.ManagerRDBean;
import com.wear.bean.PolicyListBean;
import com.wear.bean.Setting;
import com.wear.bean.Toy;
import com.wear.bean.event.ApiisWeakPasswordEvent;
import com.wear.bean.event.LoginOrOfflineEvent;
import com.wear.bean.event.LoginStatusActionEvent;
import com.wear.bean.event.VCardChangeEvent;
import com.wear.bean.event.VersionUpdataEvent;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.date.request.AppUserStatusBean;
import com.wear.main.BaseFragment;
import com.wear.main.account.HelpActivity;
import com.wear.main.account.WebViewActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.main.toy.ToyActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.thirdlogin.ThirdLoginSuccessBottomDialog;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.HotView;
import dc.ah4;
import dc.ch3;
import dc.cs3;
import dc.eg3;
import dc.ep1;
import dc.hg3;
import dc.is3;
import dc.kf;
import dc.kn3;
import dc.lg3;
import dc.me3;
import dc.ob2;
import dc.pj3;
import dc.qq2;
import dc.re3;
import dc.tn2;
import dc.tq2;
import dc.wg3;
import dc.xc1;
import dc.ye3;
import dc.zd3;
import dc.zn2;
import de.hdodenhof.circleimageview.CircleImageView;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.offline.packet.OfflineMessageRequest;

/* loaded from: classes4.dex */
public class MeFragment extends BaseFragment {
    public static int m = -1;

    @BindView(R.id.account_about)
    public LinearLayout accountAbout;

    @BindView(R.id.account_help)
    public LinearLayout accountHelp;

    @BindView(R.id.account_logout)
    public LinearLayout accountLogout;

    @BindView(R.id.account_privacy)
    public LinearLayout accountPrivacy;

    @BindView(R.id.account_setting)
    public LinearLayout accountSetting;

    @BindView(R.id.me_fragment_setting_reddot)
    public View dotSettings;

    @BindView(R.id.hot_check_orgy)
    public HotView hotCheckOrgy;

    @BindView(R.id.hot_check_update)
    public View hotCheckUpdate;

    @BindView(R.id.iv_not_toy)
    public ImageView ivNotToy;
    public View k;
    public MyApplication l;

    @BindView(R.id.layout_orgy_ingress)
    public LinearLayout layoutOrgyIngress;

    @BindView(R.id.link_orgy_web)
    public LinearLayout linkOrgyWeb;

    @BindView(R.id.ll_available_layout)
    public RelativeLayout llAvailableLayout;

    @BindView(R.id.ll_nickname_available)
    public LinearLayout llNicknameAvailable;

    @BindView(R.id.me_fragment_privacy_reddot)
    public LinearLayout meFragmentPrivacyReddot;

    @BindView(R.id.orgy_logo)
    public ImageView orgyLogo;

    @BindView(R.id.riv_account_avatar)
    public CircleImageView rivAccountAvatar;

    @BindView(R.id.rl_toy_1)
    public AppCompatTextView rlToy1;

    @BindView(R.id.rl_toy_2)
    public AppCompatTextView rlToy2;

    @BindView(R.id.rl_account_avatar)
    public RelativeLayout rl_account_avatar;

    @BindView(R.id.title_add)
    public ImageView titleAdd;

    @BindView(R.id.toys_number_text)
    public AppCompatTextView toysNumber;

    @BindView(R.id.tv_about)
    public TextView tvAbout;

    @BindView(R.id.tv_available)
    public TextView tvAvailable;

    @BindView(R.id.tv_nickname)
    public TextView tvNickname;

    @BindView(R.id.tv_orgy_join)
    public AppCompatTextView tvOrgyJoin;

    @BindView(R.id.tv_setting)
    public TextView tvSetting;

    @BindView(R.id.v_account_online_status)
    public CircleImageView vAccountOnlineStatus;

    public class a implements is3.d {
        public a(MeFragment meFragment) {
        }

        @Override // dc.is3.d
        public void doConfirm() {
        }
    }

    public class b implements zn2<String> {

        public class a extends TypeReference<BaseResponseBeanNew<AvatarReportStatusBean>> {
            public a(b bVar) {
            }
        }

        public b(MeFragment meFragment) {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this), new Feature[0]);
            if (baseResponseBeanNew.result) {
                eg3.i(MyApplication.N(), "avatar_report_status", new Gson().toJson(baseResponseBeanNew.data));
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            netException.printStackTrace();
        }
    }

    public class c extends ClickableSpan {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;

        public c(List list, String str) {
            this.a = list;
            this.b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.a.size() >= 2) {
                Intent intent = new Intent(MeFragment.this.l, (Class<?>) WebViewActivity.class);
                if (this.a.size() > 0) {
                    intent.putExtra(ImagesContract.URL, ((String) this.a.get(1)) + "?pf=" + wg3.a() + "&lang=" + this.b);
                } else {
                    intent.putExtra(ImagesContract.URL, "https://hyttoapps.bandnana.com/remote/privacy-policy?pf=" + wg3.a() + "&lang=" + this.b);
                }
                intent.setFlags(268435456);
                intent.putExtra(MessageBundle.TITLE_ENTRY, ah4.e(R.string.privacy_policy));
                MeFragment.this.startActivity(intent);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(MeFragment.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
        }
    }

    public class d extends ClickableSpan {
        public d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            pj3.f(MeFragment.this.getActivity(), HelpActivity.class);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(MeFragment.this.getResources().getColor(R.color.color_accent));
            textPaint.setUnderlineText(true);
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
            pj3.s(MeFragment.this.getActivity(), LoginActivity.class);
        }
    }

    public class f implements is3.d {
        public final /* synthetic */ Activity a;

        public class a implements qq2 {
            public a(f fVar) {
            }

            @Override // dc.qq2
            public void a() {
            }
        }

        public f(Activity activity) {
            this.a = activity;
        }

        @Override // dc.is3.d
        public void doConfirm() {
            if (eg3.d(this.a, "is_third_login", false)) {
                tq2.a().d(this.a, new a(this));
            }
            ye3.I("logoutNormally", "click logout");
            eg3.m(MeFragment.this.requireContext(), "firstPatternChatGPT");
            eg3.m(MeFragment.this.requireContext(), "firstStoryChatGPT");
            ep1.b().h(1);
            MeFragment.this.g0();
        }
    }

    public MeFragment() {
        new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e0(View view) {
        pj3.f(getContext(), ToyActivity.class);
    }

    @Override // com.wear.main.BaseFragment
    public void J() {
        super.J();
        me3.c(me3.c.ME_UI_ENTER);
        ye3.c("me", "into page", null);
        t("me", null);
    }

    @Override // com.wear.main.BaseFragment
    public void K(Intent intent) {
        intent.getIntExtra("requestCode", 0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ManagerRDBean(ManagerRDBean managerRDBean) {
        i0();
    }

    @Override // com.wear.main.BaseFragment
    public void Q() {
        MyApplication myApplication = WearUtils.x;
        if (myApplication == null || this.rlToy1 == null) {
            return;
        }
        ArrayList<Toy> arrayListO = myApplication.G().o();
        if (arrayListO.size() == 0) {
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.toysNumber.setVisibility(8);
            this.ivNotToy.setVisibility(0);
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < arrayListO.size(); i2++) {
            Toy toy = arrayListO.get(i2);
            if (toy != null && toy.isConnected()) {
                if (i == 0) {
                    this.rlToy1.setVisibility(0);
                    this.rlToy1.setText(toy.getToyUINameSpecialForMiniXMachine(2));
                } else {
                    this.rlToy2.setVisibility(0);
                    this.rlToy2.setText(toy.getToyUINameSpecialForMiniXMachine(2));
                }
                i++;
                this.ivNotToy.setVisibility(8);
            }
        }
        if (i == 0) {
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.ivNotToy.setVisibility(0);
            this.toysNumber.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.rlToy1.setVisibility(0);
            this.rlToy2.setVisibility(8);
            this.toysNumber.setVisibility(8);
        } else {
            if (i == 2) {
                this.rlToy1.setVisibility(0);
                this.rlToy2.setVisibility(0);
                this.toysNumber.setVisibility(8);
                return;
            }
            this.rlToy1.setVisibility(8);
            this.rlToy2.setVisibility(8);
            this.toysNumber.setOnClickListener(new View.OnClickListener() { // from class: dc.gb3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.e0(view);
                }
            });
            this.toysNumber.setVisibility(0);
            this.toysNumber.setText(String.format(ah4.c(R.string.multiple_toys), Integer.valueOf(i)));
        }
    }

    public final void a0() {
        tn2.x(getActivity()).l("/remote/report-user/avatarReportStatus", new HashMap(), new b(this));
    }

    public final SpannableString b0(AvatarReportStatusBean avatarReportStatusBean, Gson gson) {
        String strE = ah4.e(R.string.profile_picture_deleted);
        String strE2 = ah4.e(R.string.terms_and_conditions);
        Locale localeE = lg3.e(getActivity());
        String str = DateFormat.getDateInstance(2, localeE).format(Long.valueOf(avatarReportStatusBean.getEndRestrictTimestamp()));
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        sb.append(String.format(ah4.e(R.string.banned_from_changing_profile_pic), str));
        sb.append("\n\n");
        String string = sb.toString();
        String strE3 = ah4.e(R.string.clickable_here);
        String str2 = strE + strE2 + string + String.format(ah4.e(R.string.notification_contact_us), strE3);
        String str3 = "all====" + str2;
        ArrayList arrayList = new ArrayList();
        PolicyListBean policyListBean = (PolicyListBean) gson.fromJson(eg3.h(this.l, "new_argement_list", ""), PolicyListBean.class);
        if (policyListBean != null && policyListBean.getData() != null && policyListBean.getData().size() > 0) {
            for (int i = 0; i < policyListBean.getData().size(); i++) {
                arrayList.add(policyListBean.getData().get(i).getUrl());
            }
        }
        String strC = lg3.c(localeE);
        SpannableString spannableString = new SpannableString(str2);
        int iIndexOf = str2.indexOf(strE2);
        if (iIndexOf != -1) {
            spannableString.setSpan(new c(arrayList, strC), iIndexOf, strE2.length() + iIndexOf, 17);
        }
        int iIndexOf2 = str2.indexOf(strE3);
        if (iIndexOf2 != -1) {
            spannableString.setSpan(new d(), iIndexOf2, strE3.length() + iIndexOf2, 17);
        }
        return spannableString;
    }

    public final void c0() {
        Setting settingS = this.l.S();
        boolean z = false;
        if (settingS != null && settingS.getWeakPasswordV() > settingS.getWeakPasswordRed()) {
            z = true;
        }
        ManagerRDBean.getManager().setShowChangePassword(z);
        ManagerRDBean.saveManager();
    }

    public void f0(LoginOrOfflineEvent loginOrOfflineEvent) {
        if (!loginOrOfflineEvent.isLogin()) {
            this.llAvailableLayout.setVisibility(8);
            this.accountLogout.setVisibility(8);
        } else {
            this.llAvailableLayout.setVisibility(0);
            re3.t();
            this.accountLogout.setVisibility(0);
        }
    }

    public final void g0() {
        Account accountU = WearUtils.y.u();
        if (accountU == null) {
            String strB = zd3.b(WearUtils.x, "xmpp_email_simple_name");
            if (MyApplication.O) {
                if (!WearUtils.e1(strB)) {
                    this.tvNickname.setText(strB);
                }
                this.llAvailableLayout.setVisibility(0);
            } else {
                this.tvNickname.setText(ah4.e(R.string.welcome_login));
                this.rivAccountAvatar.setImageResource(R.drawable.icon_default_new);
                this.llAvailableLayout.setVisibility(8);
            }
        } else {
            if (MyApplication.O) {
                this.tvNickname.setText(accountU.getUserName());
                this.llAvailableLayout.setVisibility(0);
            } else {
                this.tvNickname.setText(ah4.e(R.string.welcome_login));
                this.llAvailableLayout.setVisibility(8);
            }
            String str = "头像====" + accountU.getAvatar();
            String avatar = accountU.getAvatar();
            if (WearUtils.e1(avatar)) {
                this.rivAccountAvatar.setImageResource(R.drawable.icon_default_new);
            } else {
                if (!avatar.startsWith("http")) {
                    avatar = WearUtils.e + avatar;
                }
                kf.y(this).v(avatar).A0(this.rivAccountAvatar);
            }
        }
        this.tvAvailable.setText(ah4.e(R.string.user_profile_status_available));
        if (MyApplication.P) {
            this.vAccountOnlineStatus.setBackgroundResource(R.drawable.status_online);
            if (accountU != null) {
                Presence.Mode statusMode = accountU.getStatusMode();
                this.vAccountOnlineStatus.setVisibility(0);
                if (statusMode == Presence.Mode.chat) {
                    this.tvAvailable.setText(ah4.e(R.string.user_profile_status_available));
                    this.vAccountOnlineStatus.setBackgroundResource(R.drawable.status_online);
                    AppUserStatusBean.onlineStatus = "status_available";
                } else if (statusMode == Presence.Mode.dnd) {
                    this.tvAvailable.setText(ah4.e(R.string.user_profile_status_busy));
                    this.vAccountOnlineStatus.setBackgroundResource(R.drawable.status_busy_xml);
                    AppUserStatusBean.onlineStatus = "status_busy";
                } else if (statusMode == Presence.Mode.away) {
                    this.tvAvailable.setText(ah4.e(R.string.user_profile_status_invisible));
                    this.vAccountOnlineStatus.setBackgroundResource(R.drawable.status_invisible_xml);
                    AppUserStatusBean.onlineStatus = "status_invisible";
                }
            } else {
                AppUserStatusBean.onlineStatus = OfflineMessageRequest.ELEMENT;
                this.tvAvailable.setText(ah4.e(R.string.user_profile_status_offline));
                this.vAccountOnlineStatus.setVisibility(8);
            }
        } else {
            AppUserStatusBean.onlineStatus = OfflineMessageRequest.ELEMENT;
            this.tvAvailable.setText(ah4.e(R.string.user_profile_status_offline));
            this.vAccountOnlineStatus.setVisibility(8);
        }
        ob2.o().I();
    }

    public final void h0(VersionUpdataEvent versionUpdataEvent) {
        this.hotCheckUpdate.setVisibility(8);
        if (versionUpdataEvent == null || !versionUpdataEvent.isShowHotView) {
            return;
        }
        this.hotCheckUpdate.setVisibility(0);
    }

    public final void i0() {
        this.dotSettings.setVisibility(ManagerRDBean.getManager().isShowSettings() ? 0 : 8);
    }

    public final void j0() {
        this.meFragmentPrivacyReddot.setVisibility(WearUtils.I1(getActivity(), "key_show_red_by_connections") ? 0 : 8);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @OnClick({R.id.iv_not_toy, R.id.rl_toy_1, R.id.rl_toy_2, R.id.title_add, R.id.rl_account_avatar, R.id.ll_available_layout, R.id.account_setting, R.id.account_privacy, R.id.account_about, R.id.account_help, R.id.account_logout})
    public void onClick(View view) {
        FragmentActivity activity = getActivity();
        switch (view.getId()) {
            case R.id.account_about /* 2131361946 */:
                t("me_about", null);
                pj3.f(getActivity(), AboutActivity.class);
                break;
            case R.id.account_help /* 2131361947 */:
                t("me_help", null);
                pj3.f(getActivity(), HelpActivity.class);
                break;
            case R.id.account_logout /* 2131361948 */:
                me3.c(me3.c.LOGOUT_CLICK);
                is3.b bVar = new is3.b(activity);
                bVar.p(ah4.e(R.string.log_out_notification));
                bVar.d(new f(activity));
                cs3.h(bVar).show();
                break;
            case R.id.account_privacy /* 2131361949 */:
                if (!MyApplication.Z) {
                    t("me_privacy", null);
                    pj3.f(getActivity(), PrivacyActivity.class);
                    break;
                } else {
                    kn3 kn3Var = new kn3((Context) getActivity(), ah4.e(R.string.offline_notification), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), true, (kn3.d) new e());
                    kn3Var.show();
                    kn3Var.p();
                    break;
                }
            case R.id.account_setting /* 2131361950 */:
                t("me_settings", null);
                pj3.f(getActivity(), SettingActivity.class);
                break;
            case R.id.iv_not_toy /* 2131363221 */:
            case R.id.rl_toy_1 /* 2131364313 */:
            case R.id.rl_toy_2 /* 2131364314 */:
                pj3.f(getActivity(), ToyActivity.class);
                break;
            case R.id.ll_available_layout /* 2131363445 */:
                Account accountU = ch3.n().u();
                if (activity != null && accountU != null) {
                    OnlineStatusActivity.d.a(requireContext());
                    break;
                }
                break;
            case R.id.rl_account_avatar /* 2131364241 */:
                if (!MyApplication.O) {
                    pj3.s(getActivity(), LoginActivity.class);
                    break;
                } else {
                    startActivity(new Intent(this.l, (Class<?>) ProfileActivity.class));
                    break;
                }
            case R.id.title_add /* 2131364761 */:
                if (WearUtils.y.u() != null) {
                    new hg3().h(this.ivNotToy, getContext());
                    break;
                } else {
                    V(R.string.common_login_first);
                    break;
                }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        MyApplication myApplication = (MyApplication) getActivity().getApplication();
        this.l = myApplication;
        M(myApplication);
        View viewInflate = layoutInflater.inflate(R.layout.me_fragment, (ViewGroup) null, false);
        this.k = viewInflate;
        ButterKnife.bind(this, viewInflate);
        EventBus.getDefault().register(this);
        if (MyApplication.Z) {
            this.accountLogout.setVisibility(8);
        } else {
            this.accountLogout.setVisibility(0);
            re3.t();
        }
        if (WearUtils.y.u() != null) {
            a0();
        }
        this.ivNotToy.setOnClickListener(new View.OnClickListener() { // from class: dc.na3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onClick(view);
            }
        });
        return this.k;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(OrgyHotView orgyHotView) {
        if (orgyHotView != null) {
            if (orgyHotView.isShow) {
                this.hotCheckOrgy.setVisibility(0);
            } else {
                this.hotCheckOrgy.setVisibility(8);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isVisible()) {
            Account accountU = WearUtils.y.u();
            String avatar = accountU != null ? accountU.getAvatar() : "";
            int i = m;
            if (i == 1) {
                m = -1;
                new ThirdLoginSuccessBottomDialog(MyApplication.H(), String.format(ah4.e(R.string.des_create_account_successful), "Google"), avatar).show();
            } else if (i == 2) {
                m = -1;
                new ThirdLoginSuccessBottomDialog(MyApplication.H(), String.format(ah4.e(R.string.des_bind_account_successful), "Google", "Google"), avatar).show();
            }
        }
        g0();
        c0();
        i0();
        j0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.wear.main.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || TextUtils.isEmpty(ch3.n().r())) {
            return;
        }
        Gson gson = new Gson();
        boolean zD = eg3.d(this.l, "AvatarReport_" + ch3.n().r(), false);
        String str = "isShow====" + zD;
        AvatarReportStatusBean avatarReportStatusBean = (AvatarReportStatusBean) gson.fromJson(eg3.h(this.l, "avatar_report_status", ""), AvatarReportStatusBean.class);
        if (avatarReportStatusBean != null) {
            if (!avatarReportStatusBean.isRestrict()) {
                eg3.i(this.l, "AvatarReport_" + ch3.n().r(), Boolean.FALSE);
                return;
            }
            if (zD) {
                return;
            }
            is3.b bVar = new is3.b(MyApplication.H());
            bVar.p(b0(avatarReportStatusBean, gson));
            bVar.o(ah4.e(R.string.common_ok));
            bVar.d(new a(this));
            bVar.b(false);
            cs3.h(bVar).show();
            eg3.i(this.l, "AvatarReport_" + ch3.n().r(), Boolean.TRUE);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(LoginStatusActionEvent loginStatusActionEvent) {
        g0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(VCardChangeEvent vCardChangeEvent) {
        g0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(VersionUpdataEvent versionUpdataEvent) {
        h0(versionUpdataEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ApiisWeakPasswordEvent apiisWeakPasswordEvent) {
        c0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(xc1 xc1Var) {
        Q();
    }
}
