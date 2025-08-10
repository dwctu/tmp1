package com.wear.main.account;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ChatThemeSettingActivity_ViewBinding implements Unbinder {
    public ChatThemeSettingActivity a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChatThemeSettingActivity a;

        public a(ChatThemeSettingActivity_ViewBinding chatThemeSettingActivity_ViewBinding, ChatThemeSettingActivity chatThemeSettingActivity) {
            this.a = chatThemeSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChatThemeSettingActivity a;

        public b(ChatThemeSettingActivity_ViewBinding chatThemeSettingActivity_ViewBinding, ChatThemeSettingActivity chatThemeSettingActivity) {
            this.a = chatThemeSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ChatThemeSettingActivity a;

        public c(ChatThemeSettingActivity_ViewBinding chatThemeSettingActivity_ViewBinding, ChatThemeSettingActivity chatThemeSettingActivity) {
            this.a = chatThemeSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ChatThemeSettingActivity a;

        public d(ChatThemeSettingActivity_ViewBinding chatThemeSettingActivity_ViewBinding, ChatThemeSettingActivity chatThemeSettingActivity) {
            this.a = chatThemeSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public ChatThemeSettingActivity_ViewBinding(ChatThemeSettingActivity chatThemeSettingActivity, View view) {
        this.a = chatThemeSettingActivity;
        chatThemeSettingActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        chatThemeSettingActivity.ivSelect = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_select, "field 'ivSelect'", ImageView.class);
        chatThemeSettingActivity.ivDefault = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_default, "field 'ivDefault'", ImageView.class);
        chatThemeSettingActivity.ivWhats = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_whats, "field 'ivWhats'", ImageView.class);
        chatThemeSettingActivity.ivSkype = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_skype, "field 'ivSkype'", ImageView.class);
        chatThemeSettingActivity.ivWechat = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_wechat, "field 'ivWechat'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rl_default, "method 'onViewClicked'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, chatThemeSettingActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_whats, "method 'onViewClicked'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, chatThemeSettingActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_skype, "method 'onViewClicked'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, chatThemeSettingActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_wechat, "method 'onViewClicked'");
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, chatThemeSettingActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatThemeSettingActivity chatThemeSettingActivity = this.a;
        if (chatThemeSettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatThemeSettingActivity.actionbar = null;
        chatThemeSettingActivity.ivSelect = null;
        chatThemeSettingActivity.ivDefault = null;
        chatThemeSettingActivity.ivWhats = null;
        chatThemeSettingActivity.ivSkype = null;
        chatThemeSettingActivity.ivWechat = null;
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
