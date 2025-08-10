package com.wear.main.migrate.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class ChatMigrateQrcodeActivity_ViewBinding implements Unbinder {
    public ChatMigrateQrcodeActivity a;

    @UiThread
    public ChatMigrateQrcodeActivity_ViewBinding(ChatMigrateQrcodeActivity chatMigrateQrcodeActivity, View view) {
        this.a = chatMigrateQrcodeActivity;
        chatMigrateQrcodeActivity.myActionBar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'myActionBar'", MyActionBar.class);
        chatMigrateQrcodeActivity.ivQrCode = (ImageView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_qrcode, "field 'ivQrCode'", ImageView.class);
        chatMigrateQrcodeActivity.ivQrCodeLott = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_qrcode_lott, "field 'ivQrCodeLott'", LottieAnimationView.class);
        chatMigrateQrcodeActivity.batteryTip = (TextView) Utils.findRequiredViewAsType(view, R.id.ac_migrate_qrcode_tv_battery_tip, "field 'batteryTip'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ChatMigrateQrcodeActivity chatMigrateQrcodeActivity = this.a;
        if (chatMigrateQrcodeActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        chatMigrateQrcodeActivity.myActionBar = null;
        chatMigrateQrcodeActivity.ivQrCode = null;
        chatMigrateQrcodeActivity.ivQrCodeLott = null;
        chatMigrateQrcodeActivity.batteryTip = null;
    }
}
