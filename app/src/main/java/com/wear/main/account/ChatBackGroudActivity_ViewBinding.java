package com.wear.main.account;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ChatBackGroudActivity_ViewBinding implements Unbinder {
    public ChatBackGroudActivity a;
    public View b;
    public View c;
    public View d;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChatBackGroudActivity a;

        public a(ChatBackGroudActivity_ViewBinding chatBackGroudActivity_ViewBinding, ChatBackGroudActivity chatBackGroudActivity) {
            this.a = chatBackGroudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChatBackGroudActivity a;

        public b(ChatBackGroudActivity_ViewBinding chatBackGroudActivity_ViewBinding, ChatBackGroudActivity chatBackGroudActivity) {
            this.a = chatBackGroudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    public class c extends DebouncingOnClickListener {
        public final /* synthetic */ ChatBackGroudActivity a;

        public c(ChatBackGroudActivity_ViewBinding chatBackGroudActivity_ViewBinding, ChatBackGroudActivity chatBackGroudActivity) {
            this.a = chatBackGroudActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onViewClicked(view);
        }
    }

    @UiThread
    public ChatBackGroudActivity_ViewBinding(ChatBackGroudActivity chatBackGroudActivity, View view) {
        this.a = chatBackGroudActivity;
        chatBackGroudActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        chatBackGroudActivity.screanRootLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.screan_root_layout, "field 'screanRootLayout'", LinearLayout.class);
        chatBackGroudActivity.ivBg = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_bg, "field 'ivBg'", ImageView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rl_sys_chat_bg, "method 'onViewClicked'");
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, chatBackGroudActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rl_chat_bg_photo, "method 'onViewClicked'");
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, chatBackGroudActivity));
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rl_chat_bg_camar, "method 'onViewClicked'");
        this.d = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new c(this, chatBackGroudActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatBackGroudActivity chatBackGroudActivity = this.a;
        if (chatBackGroudActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatBackGroudActivity.actionbar = null;
        chatBackGroudActivity.screanRootLayout = null;
        chatBackGroudActivity.ivBg = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
        this.d.setOnClickListener(null);
        this.d = null;
    }
}
