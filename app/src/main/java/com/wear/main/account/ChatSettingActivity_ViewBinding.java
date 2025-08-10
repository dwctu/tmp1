package com.wear.main.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ChatSettingActivity_ViewBinding implements Unbinder {
    public ChatSettingActivity a;
    public View b;
    public View c;
    public View d;
    public View e;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChatSettingActivity a;

        public a(ChatSettingActivity_ViewBinding chatSettingActivity_ViewBinding, ChatSettingActivity chatSettingActivity) {
            this.a = chatSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChatSettingActivity a;

        public b(ChatSettingActivity_ViewBinding chatSettingActivity_ViewBinding, ChatSettingActivity chatSettingActivity) {
            this.a = chatSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ChatSettingActivity a;

        public c(ChatSettingActivity_ViewBinding chatSettingActivity_ViewBinding, ChatSettingActivity chatSettingActivity) {
            this.a = chatSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class d extends DebouncingOnClickListener {
        public final /* synthetic */ ChatSettingActivity a;

        public d(ChatSettingActivity_ViewBinding chatSettingActivity_ViewBinding, ChatSettingActivity chatSettingActivity) {
            this.a = chatSettingActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public ChatSettingActivity_ViewBinding(ChatSettingActivity chatSettingActivity, View view) {
        this.a = chatSettingActivity;
        chatSettingActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        chatSettingActivity.clearAllMessageText = (TextView) Utils.findRequiredViewAsType(view, R.id.clear_all_message_text, "field 'clearAllMessageText'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.clear_all_message, "field 'clearAllMessage' and method 'onViewClicked'");
        chatSettingActivity.clearAllMessage = (RelativeLayout) Utils.castView(viewFindRequiredView, R.id.clear_all_message, "field 'clearAllMessage'", RelativeLayout.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, chatSettingActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_theme, "method 'onViewClicked'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, chatSettingActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_chat_bg, "method 'onViewClicked'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, chatSettingActivity));
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.rl_chat_migrate, "method 'onViewClicked'");
        this.e = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new d(this, chatSettingActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatSettingActivity chatSettingActivity = this.a;
        if (chatSettingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatSettingActivity.actionbar = null;
        chatSettingActivity.clearAllMessageText = null;
        chatSettingActivity.clearAllMessage = null;
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
