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
public class ChatMigrateSendActivity_ViewBinding implements Unbinder {
    public ChatMigrateSendActivity a;
    public View b;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ ChatMigrateSendActivity a;

        public a(ChatMigrateSendActivity_ViewBinding chatMigrateSendActivity_ViewBinding, ChatMigrateSendActivity chatMigrateSendActivity) {
            this.a = chatMigrateSendActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.a.onClick(view);
        }
    }

    @UiThread
    public ChatMigrateSendActivity_ViewBinding(ChatMigrateSendActivity chatMigrateSendActivity, View view) {
        this.a = chatMigrateSendActivity;
        chatMigrateSendActivity.ivTransfer = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_transfer_iv, "field 'ivTransfer'", ImageView.class);
        chatMigrateSendActivity.tvStatus = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_transfer_status, "field 'tvStatus'", TextView.class);
        chatMigrateSendActivity.tvInterrupted = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_receive_interrupted, "field 'tvInterrupted'", TextView.class);
        chatMigrateSendActivity.tvScreenTip = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_transfer_screen_tip, "field 'tvScreenTip'", TextView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.ac_migrate_transfer_unzip_ok, "field 'tvMigratedOk' and method 'onClick'");
        chatMigrateSendActivity.tvMigratedOk = (TextView) Utils.castView(viewFindRequiredView, R.id.ac_migrate_transfer_unzip_ok, "field 'tvMigratedOk'", TextView.class);
        this.b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(this, chatMigrateSendActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatMigrateSendActivity chatMigrateSendActivity = this.a;
        if (chatMigrateSendActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatMigrateSendActivity.ivTransfer = null;
        chatMigrateSendActivity.tvStatus = null;
        chatMigrateSendActivity.tvInterrupted = null;
        chatMigrateSendActivity.tvScreenTip = null;
        chatMigrateSendActivity.tvMigratedOk = null;
        this.b.setOnClickListener(null);
        this.b = null;
    }
}
