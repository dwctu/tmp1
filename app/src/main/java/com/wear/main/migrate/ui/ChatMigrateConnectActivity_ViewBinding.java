package com.wear.main.migrate.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ChatMigrateConnectActivity_ViewBinding implements Unbinder {
    public ChatMigrateConnectActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChatMigrateConnectActivity a;

        public a(ChatMigrateConnectActivity_ViewBinding chatMigrateConnectActivity_ViewBinding, ChatMigrateConnectActivity chatMigrateConnectActivity) {
            this.a = chatMigrateConnectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChatMigrateConnectActivity a;

        public b(ChatMigrateConnectActivity_ViewBinding chatMigrateConnectActivity_ViewBinding, ChatMigrateConnectActivity chatMigrateConnectActivity) {
            this.a = chatMigrateConnectActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ChatMigrateConnectActivity_ViewBinding(ChatMigrateConnectActivity chatMigrateConnectActivity, View view) {
        this.a = chatMigrateConnectActivity;
        chatMigrateConnectActivity.myActionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'myActionBar'", MyActionBar.class);
        chatMigrateConnectActivity.ivTransfer = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_connect_iv_transfer, "field 'ivTransfer'", ImageView.class);
        chatMigrateConnectActivity.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_connect_tv_tip, "field 'tvTip'", TextView.class);
        chatMigrateConnectActivity.tvAuthFail = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_connect_tv_authfail, "field 'tvAuthFail'", TextView.class);
        chatMigrateConnectActivity.batteryTip = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_connect_tv_battery_tip, "field 'batteryTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ac_migrate_connect_tv_retry, "field 'tvRetry' and method 'onClick'");
        chatMigrateConnectActivity.tvRetry = (TextView) Utils.castView(viewFindRequiredView, R.id.ac_migrate_connect_tv_retry, "field 'tvRetry'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, chatMigrateConnectActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ac_migrate_connect_tv_exit, "field 'tvExit' and method 'onClick'");
        chatMigrateConnectActivity.tvExit = (TextView) Utils.castView(viewFindRequiredView2, R.id.ac_migrate_connect_tv_exit, "field 'tvExit'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, chatMigrateConnectActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatMigrateConnectActivity chatMigrateConnectActivity = this.a;
        if (chatMigrateConnectActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatMigrateConnectActivity.myActionBar = null;
        chatMigrateConnectActivity.ivTransfer = null;
        chatMigrateConnectActivity.tvTip = null;
        chatMigrateConnectActivity.tvAuthFail = null;
        chatMigrateConnectActivity.batteryTip = null;
        chatMigrateConnectActivity.tvRetry = null;
        chatMigrateConnectActivity.tvExit = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
