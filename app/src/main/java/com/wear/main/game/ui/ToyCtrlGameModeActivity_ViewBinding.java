package com.wear.main.game.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class ToyCtrlGameModeActivity_ViewBinding implements Unbinder {
    public ToyCtrlGameModeActivity a;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ToyCtrlGameModeActivity a;

        public a(ToyCtrlGameModeActivity_ViewBinding toyCtrlGameModeActivity_ViewBinding, ToyCtrlGameModeActivity toyCtrlGameModeActivity) {
            this.a = toyCtrlGameModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.OnClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ToyCtrlGameModeActivity a;

        public b(ToyCtrlGameModeActivity_ViewBinding toyCtrlGameModeActivity_ViewBinding, ToyCtrlGameModeActivity toyCtrlGameModeActivity) {
            this.a = toyCtrlGameModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.OnClick(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ToyCtrlGameModeActivity a;

        public c(ToyCtrlGameModeActivity_ViewBinding toyCtrlGameModeActivity_ViewBinding, ToyCtrlGameModeActivity toyCtrlGameModeActivity) {
            this.a = toyCtrlGameModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.OnClick(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ToyCtrlGameModeActivity a;

        public d(ToyCtrlGameModeActivity_ViewBinding toyCtrlGameModeActivity_ViewBinding, ToyCtrlGameModeActivity toyCtrlGameModeActivity) {
            this.a = toyCtrlGameModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.OnClick(view);
        }
    }

    public class e extends DebouncingOnClickListener {
        public final /* synthetic */ ToyCtrlGameModeActivity a;

        public e(ToyCtrlGameModeActivity_ViewBinding toyCtrlGameModeActivity_ViewBinding, ToyCtrlGameModeActivity toyCtrlGameModeActivity) {
            this.a = toyCtrlGameModeActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.OnClick(view);
        }
    }

    @UiThread
    public ToyCtrlGameModeActivity_ViewBinding(ToyCtrlGameModeActivity toyCtrlGameModeActivity, View view) {
        this.a = toyCtrlGameModeActivity;
        toyCtrlGameModeActivity.mainTitleBar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.main_title_bar, "field 'mainTitleBar'", RelativeLayout.class);
        toyCtrlGameModeActivity.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_back, "field 'ivBack' and method 'OnClick'");
        toyCtrlGameModeActivity.ivBack = (ImageView) Utils.castView(viewFindRequiredView, R.id.iv_back, "field 'ivBack'", ImageView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, toyCtrlGameModeActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_toy_1, "field 'rlToy1' and method 'OnClick'");
        toyCtrlGameModeActivity.rlToy1 = (AppCompatTextView) Utils.castView(viewFindRequiredView2, R.id.rl_toy_1, "field 'rlToy1'", AppCompatTextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, toyCtrlGameModeActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_toy_2, "field 'rlToy2' and method 'OnClick'");
        toyCtrlGameModeActivity.rlToy2 = (AppCompatTextView) Utils.castView(viewFindRequiredView3, R.id.rl_toy_2, "field 'rlToy2'", AppCompatTextView.class);
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, toyCtrlGameModeActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.iv_not_toy, "field 'ivNotToy' and method 'OnClick'");
        toyCtrlGameModeActivity.ivNotToy = (ImageView) Utils.castView(viewFindRequiredView4, R.id.iv_not_toy, "field 'ivNotToy'", ImageView.class);
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, toyCtrlGameModeActivity));
        toyCtrlGameModeActivity.tvIpTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ip_title, "field 'tvIpTitle'", TextView.class);
        toyCtrlGameModeActivity.tvIpContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ip_content, "field 'tvIpContent'", TextView.class);
        toyCtrlGameModeActivity.tvHttpPortTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_http_port_title, "field 'tvHttpPortTitle'", TextView.class);
        toyCtrlGameModeActivity.tvHttpPortContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_http_port_content, "field 'tvHttpPortContent'", TextView.class);
        toyCtrlGameModeActivity.tvSslPortTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ssl_port_title, "field 'tvSslPortTitle'", TextView.class);
        toyCtrlGameModeActivity.tvSslPortContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ssl_port_content, "field 'tvSslPortContent'", TextView.class);
        toyCtrlGameModeActivity.rvGameConnected = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_game_connected, "field 'rvGameConnected'", RecyclerView.class);
        toyCtrlGameModeActivity.tvId = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_id, "field 'tvId'", TextView.class);
        View viewFindRequiredView5 = Utils.findRequiredView(view, R.id.tv_exit, "method 'OnClick'");
        this.f = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new e(this, toyCtrlGameModeActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ToyCtrlGameModeActivity toyCtrlGameModeActivity = this.a;
        if (toyCtrlGameModeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        toyCtrlGameModeActivity.mainTitleBar = null;
        toyCtrlGameModeActivity.tvTitle = null;
        toyCtrlGameModeActivity.ivBack = null;
        toyCtrlGameModeActivity.rlToy1 = null;
        toyCtrlGameModeActivity.rlToy2 = null;
        toyCtrlGameModeActivity.ivNotToy = null;
        toyCtrlGameModeActivity.tvIpTitle = null;
        toyCtrlGameModeActivity.tvIpContent = null;
        toyCtrlGameModeActivity.tvHttpPortTitle = null;
        toyCtrlGameModeActivity.tvHttpPortContent = null;
        toyCtrlGameModeActivity.tvSslPortTitle = null;
        toyCtrlGameModeActivity.tvSslPortContent = null;
        toyCtrlGameModeActivity.rvGameConnected = null;
        toyCtrlGameModeActivity.tvId = null;
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
    }
}
