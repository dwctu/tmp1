package com.wear.main.game.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class GameModeActivity_ViewBinding implements Unbinder {
    public GameModeActivity a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ GameModeActivity a;

        public a(GameModeActivity_ViewBinding gameModeActivity_ViewBinding, GameModeActivity gameModeActivity) {
            this.a = gameModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.OnClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ GameModeActivity a;

        public b(GameModeActivity_ViewBinding gameModeActivity_ViewBinding, GameModeActivity gameModeActivity) {
            this.a = gameModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.OnClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ GameModeActivity a;

        public c(GameModeActivity_ViewBinding gameModeActivity_ViewBinding, GameModeActivity gameModeActivity) {
            this.a = gameModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.OnClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ GameModeActivity a;

        public d(GameModeActivity_ViewBinding gameModeActivity_ViewBinding, GameModeActivity gameModeActivity) {
            this.a = gameModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.OnClick(view);
        }
    }

    @UiThread
    public GameModeActivity_ViewBinding(GameModeActivity gameModeActivity, View view) {
        this.a = gameModeActivity;
        gameModeActivity.mainTitleBar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.main_title_bar, "field 'mainTitleBar'", RelativeLayout.class);
        gameModeActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        gameModeActivity.ivBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
        gameModeActivity.rlToy1 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_1, "field 'rlToy1'", AppCompatTextView.class);
        gameModeActivity.rlToy2 = (AppCompatTextView) Utils.findRequiredViewAsType(view, R.id.rl_toy_2, "field 'rlToy2'", AppCompatTextView.class);
        gameModeActivity.ivNotToy = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_not_toy, "field 'ivNotToy'", ImageView.class);
        gameModeActivity.tvNotoy = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_notoy, "field 'tvNotoy'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_connect_toy, "field 'tvConnectToy' and method 'OnClick'");
        gameModeActivity.tvConnectToy = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_connect_toy, "field 'tvConnectToy'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, gameModeActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_manage_now, "field 'tvManageTow' and method 'OnClick'");
        gameModeActivity.tvManageTow = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_manage_now, "field 'tvManageTow'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, gameModeActivity));
        gameModeActivity.tvConnect = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_connect, "field 'tvConnect'", TextView.class);
        gameModeActivity.tvConnectRed = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_connect_red, "field 'tvConnectRed'", TextView.class);
        gameModeActivity.tvConnectWifi = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_connect_wifi, "field 'tvConnectWifi'", TextView.class);
        gameModeActivity.clIpLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.cl_ip_layout, "field 'clIpLayout'", ConstraintLayout.class);
        gameModeActivity.tvIpContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ip_content, "field 'tvIpContent'", TextView.class);
        gameModeActivity.tvHttpPortContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_http_port_content, "field 'tvHttpPortContent'", TextView.class);
        gameModeActivity.tvSslPortContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ssl_port_content, "field 'tvSslPortContent'", TextView.class);
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_enter_toy_ctrl, "field 'rlEnterToyCtrl' and method 'OnClick'");
        gameModeActivity.rlEnterToyCtrl = (RelativeLayout) Utils.castView(viewFindRequiredView3, R.id.rl_enter_toy_ctrl, "field 'rlEnterToyCtrl'", RelativeLayout.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, gameModeActivity));
        gameModeActivity.tvId = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_id, "field 'tvId'", TextView.class);
        gameModeActivity.mTvGameName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_game_name, "field 'mTvGameName'", TextView.class);
        gameModeActivity.platformContainer = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_game_name, "field 'platformContainer'", LinearLayout.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.tv_exit, "method 'OnClick'");
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, gameModeActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GameModeActivity gameModeActivity = this.a;
        if (gameModeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        gameModeActivity.mainTitleBar = null;
        gameModeActivity.tvTitle = null;
        gameModeActivity.ivBack = null;
        gameModeActivity.rlToy1 = null;
        gameModeActivity.rlToy2 = null;
        gameModeActivity.ivNotToy = null;
        gameModeActivity.tvNotoy = null;
        gameModeActivity.tvConnectToy = null;
        gameModeActivity.tvManageTow = null;
        gameModeActivity.tvConnect = null;
        gameModeActivity.tvConnectRed = null;
        gameModeActivity.tvConnectWifi = null;
        gameModeActivity.clIpLayout = null;
        gameModeActivity.tvIpContent = null;
        gameModeActivity.tvHttpPortContent = null;
        gameModeActivity.tvSslPortContent = null;
        gameModeActivity.rlEnterToyCtrl = null;
        gameModeActivity.tvId = null;
        gameModeActivity.mTvGameName = null;
        gameModeActivity.platformContainer = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
        this.e.setOnClickListener(null);
        this.e = null;
    }
}
