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

/* loaded from: classes3.dex */
public class ChatMigrateReceiveActivity_ViewBinding implements Unbinder {
    public ChatMigrateReceiveActivity a;
    public View b;
    public View c;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChatMigrateReceiveActivity a;

        public a(ChatMigrateReceiveActivity_ViewBinding chatMigrateReceiveActivity_ViewBinding, ChatMigrateReceiveActivity chatMigrateReceiveActivity) {
            this.a = chatMigrateReceiveActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ ChatMigrateReceiveActivity a;

        public b(ChatMigrateReceiveActivity_ViewBinding chatMigrateReceiveActivity_ViewBinding, ChatMigrateReceiveActivity chatMigrateReceiveActivity) {
            this.a = chatMigrateReceiveActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ChatMigrateReceiveActivity_ViewBinding(ChatMigrateReceiveActivity chatMigrateReceiveActivity, View view) {
        this.a = chatMigrateReceiveActivity;
        chatMigrateReceiveActivity.ivTransfer = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_receive_iv_transfer, "field 'ivTransfer'", ImageView.class);
        chatMigrateReceiveActivity.tvStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_receive_status, "field 'tvStatus'", TextView.class);
        chatMigrateReceiveActivity.tvInterrupted = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_receive_interrupted, "field 'tvInterrupted'", TextView.class);
        chatMigrateReceiveActivity.tvTrying = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_receive_trying, "field 'tvTrying'", TextView.class);
        chatMigrateReceiveActivity.tvScreenTip = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_receive_screen_tip, "field 'tvScreenTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ac_migrate_receive_stop, "field 'tvStop' and method 'onClick'");
        chatMigrateReceiveActivity.tvStop = (TextView) Utils.castView(viewFindRequiredView, R.id.ac_migrate_receive_stop, "field 'tvStop'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, chatMigrateReceiveActivity));
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.ac_migrate_receive_ok, "field 'tvMigratedOk' and method 'onClick'");
        chatMigrateReceiveActivity.tvMigratedOk = (TextView) Utils.castView(viewFindRequiredView2, R.id.ac_migrate_receive_ok, "field 'tvMigratedOk'", TextView.class);
        this.c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new b(this, chatMigrateReceiveActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatMigrateReceiveActivity chatMigrateReceiveActivity = this.a;
        if (chatMigrateReceiveActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatMigrateReceiveActivity.ivTransfer = null;
        chatMigrateReceiveActivity.tvStatus = null;
        chatMigrateReceiveActivity.tvInterrupted = null;
        chatMigrateReceiveActivity.tvTrying = null;
        chatMigrateReceiveActivity.tvScreenTip = null;
        chatMigrateReceiveActivity.tvStop = null;
        chatMigrateReceiveActivity.tvMigratedOk = null;
        this.b.setOnClickListener(null);
        this.b = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }
}
