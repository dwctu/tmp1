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
public class ChatBackGroudSysActivity_ViewBinding implements Unbinder {
    public ChatBackGroudSysActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChatBackGroudSysActivity a;

        public a(ChatBackGroudSysActivity_ViewBinding chatBackGroudSysActivity_ViewBinding, ChatBackGroudSysActivity chatBackGroudSysActivity) {
            this.a = chatBackGroudSysActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChatBackGroudSysActivity a;

        public b(ChatBackGroudSysActivity_ViewBinding chatBackGroudSysActivity_ViewBinding, ChatBackGroudSysActivity chatBackGroudSysActivity) {
            this.a = chatBackGroudSysActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public ChatBackGroudSysActivity_ViewBinding(ChatBackGroudSysActivity chatBackGroudSysActivity, View view) {
        this.a = chatBackGroudSysActivity;
        chatBackGroudSysActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        chatBackGroudSysActivity.ivDefaultSelect = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_default_select, "field 'ivDefaultSelect'", ImageView.class);
        chatBackGroudSysActivity.ivWhatsSelect = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_whats_select, "field 'ivWhatsSelect'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.iv_default, "method 'onViewClicked'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, chatBackGroudSysActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.iv_whats, "method 'onViewClicked'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, chatBackGroudSysActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatBackGroudSysActivity chatBackGroudSysActivity = this.a;
        if (chatBackGroudSysActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatBackGroudSysActivity.actionbar = null;
        chatBackGroudSysActivity.ivDefaultSelect = null;
        chatBackGroudSysActivity.ivWhatsSelect = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
