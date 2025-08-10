package com.wear.ui.me;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.HotView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes4.dex */
public class MeFragment_ViewBinding implements Unbinder {
    public MeFragment a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;
    public View l;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public a(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public b(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public c(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public d(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public e(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class f extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public f(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class g extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public g(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class h extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public h(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class i extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public i(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class j extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public j(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class k extends DebouncingOnClickListener {
        public final /* synthetic */ MeFragment a;

        public k(MeFragment_ViewBinding meFragment_ViewBinding, MeFragment meFragment) {
            this.a = meFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public MeFragment_ViewBinding(MeFragment meFragment, View view) {
        this.a = meFragment;
        meFragment.rivAccountAvatar = (CircleImageView) Utils.findRequiredViewAsType(view, R.id.riv_account_avatar, "field 'rivAccountAvatar'", CircleImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rl_account_avatar, "field 'rl_account_avatar' and method 'onClick'");
        meFragment.rl_account_avatar = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.rl_account_avatar, "field 'rl_account_avatar'", RelativeLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new c(this, meFragment));
        meFragment.tvNickname = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_nickname, "field 'tvNickname'", TextView.class);
        meFragment.vAccountOnlineStatus = (CircleImageView) Utils.findRequiredViewAsType(view, R.id.v_account_online_status, "field 'vAccountOnlineStatus'", CircleImageView.class);
        meFragment.tvAvailable = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_available, "field 'tvAvailable'", TextView.class);
        meFragment.hotCheckUpdate = Utils.findRequiredView(view, R.id.hot_check_update, "field 'hotCheckUpdate'");
        meFragment.orgyLogo = (ImageView) Utils.findRequiredViewAsType(view, R.id.orgy_logo, "field 'orgyLogo'", ImageView.class);
        meFragment.tvOrgyJoin = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.tv_orgy_join, "field 'tvOrgyJoin'", AppCompatTextView.class);
        meFragment.linkOrgyWeb = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.link_orgy_web, "field 'linkOrgyWeb'", LinearLayout.class);
        meFragment.hotCheckOrgy = (HotView) Utils.findRequiredViewAsType(view, R.id.hot_check_orgy, "field 'hotCheckOrgy'", HotView.class);
        meFragment.layoutOrgyIngress = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_orgy_ingress, "field 'layoutOrgyIngress'", LinearLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_toy_1, "field 'rlToy1' and method 'onClick'");
        meFragment.rlToy1 = (AppCompatTextView) Utils.castView(viewFindRequiredView2, R.id.rl_toy_1, "field 'rlToy1'", AppCompatTextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new d(this, meFragment));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_toy_2, "field 'rlToy2' and method 'onClick'");
        meFragment.rlToy2 = (AppCompatTextView) Utils.castView(viewFindRequiredView3, R.id.rl_toy_2, "field 'rlToy2'", AppCompatTextView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new e(this, meFragment));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_not_toy, "field 'ivNotToy' and method 'onClick'");
        meFragment.ivNotToy = (ImageView) Utils.castView(viewFindRequiredView4, R.id.iv_not_toy, "field 'ivNotToy'", ImageView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new f(this, meFragment));
        meFragment.toysNumber = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.toys_number_text, "field 'toysNumber'", AppCompatTextView.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.title_add, "field 'titleAdd' and method 'onClick'");
        meFragment.titleAdd = (ImageView) Utils.castView(viewFindRequiredView5, R.id.title_add, "field 'titleAdd'", ImageView.class);
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new g(this, meFragment));
        View viewFindRequiredView6 = Utils.findRequiredView(view, R.id.ll_available_layout, "field 'llAvailableLayout' and method 'onClick'");
        meFragment.llAvailableLayout = (RelativeLayout) Utils.castView(viewFindRequiredView6, R.id.ll_available_layout, "field 'llAvailableLayout'", RelativeLayout.class);
        this.g = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new h(this, meFragment));
        meFragment.llNicknameAvailable = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_nickname_available, "field 'llNicknameAvailable'", LinearLayout.class);
        meFragment.tvSetting = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_setting, "field 'tvSetting'", TextView.class);
        View viewFindRequiredView7 = Utils.findRequiredView(view, R.id.account_setting, "field 'accountSetting' and method 'onClick'");
        meFragment.accountSetting = (LinearLayout) Utils.castView(viewFindRequiredView7, R.id.account_setting, "field 'accountSetting'", LinearLayout.class);
        this.h = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new i(this, meFragment));
        View viewFindRequiredView8 = Utils.findRequiredView(view, R.id.account_privacy, "field 'accountPrivacy' and method 'onClick'");
        meFragment.accountPrivacy = (LinearLayout) Utils.castView(viewFindRequiredView8, R.id.account_privacy, "field 'accountPrivacy'", LinearLayout.class);
        this.i = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new j(this, meFragment));
        meFragment.tvAbout = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_about, "field 'tvAbout'", TextView.class);
        View viewFindRequiredView9 = Utils.findRequiredView(view, R.id.account_about, "field 'accountAbout' and method 'onClick'");
        meFragment.accountAbout = (LinearLayout) Utils.castView(viewFindRequiredView9, R.id.account_about, "field 'accountAbout'", LinearLayout.class);
        this.j = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new k(this, meFragment));
        View viewFindRequiredView10 = Utils.findRequiredView(view, R.id.account_help, "field 'accountHelp' and method 'onClick'");
        meFragment.accountHelp = (LinearLayout) Utils.castView(viewFindRequiredView10, R.id.account_help, "field 'accountHelp'", LinearLayout.class);
        this.k = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new a(this, meFragment));
        View viewFindRequiredView11 = Utils.findRequiredView(view, R.id.account_logout, "field 'accountLogout' and method 'onClick'");
        meFragment.accountLogout = (LinearLayout) Utils.castView(viewFindRequiredView11, R.id.account_logout, "field 'accountLogout'", LinearLayout.class);
        this.l = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new b(this, meFragment));
        meFragment.dotSettings = Utils.findRequiredView(view, R.id.me_fragment_setting_reddot, "field 'dotSettings'");
        meFragment.meFragmentPrivacyReddot = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.me_fragment_privacy_reddot, "field 'meFragmentPrivacyReddot'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MeFragment meFragment = this.a;
        if (meFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        meFragment.rivAccountAvatar = null;
        meFragment.rl_account_avatar = null;
        meFragment.tvNickname = null;
        meFragment.vAccountOnlineStatus = null;
        meFragment.tvAvailable = null;
        meFragment.hotCheckUpdate = null;
        meFragment.orgyLogo = null;
        meFragment.tvOrgyJoin = null;
        meFragment.linkOrgyWeb = null;
        meFragment.hotCheckOrgy = null;
        meFragment.layoutOrgyIngress = null;
        meFragment.rlToy1 = null;
        meFragment.rlToy2 = null;
        meFragment.ivNotToy = null;
        meFragment.toysNumber = null;
        meFragment.titleAdd = null;
        meFragment.llAvailableLayout = null;
        meFragment.llNicknameAvailable = null;
        meFragment.tvSetting = null;
        meFragment.accountSetting = null;
        meFragment.accountPrivacy = null;
        meFragment.tvAbout = null;
        meFragment.accountAbout = null;
        meFragment.accountHelp = null;
        meFragment.accountLogout = null;
        meFragment.dotSettings = null;
        meFragment.meFragmentPrivacyReddot = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
        this.f.setOnClickListener(null);
        this.f = null;
        this.g.setOnClickListener(null);
        this.g = null;
        this.h.setOnClickListener(null);
        this.h = null;
        this.i.setOnClickListener(null);
        this.i = null;
        this.j.setOnClickListener(null);
        this.j = null;
        this.k.setOnClickListener(null);
        this.k = null;
        this.l.setOnClickListener(null);
        this.l = null;
    }
}
