package com.wear.main.closeRange.localMusic;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public class MusicHodler_ViewBinding implements Unbinder {
    public MusicHodler a;

    @UiThread
    public MusicHodler_ViewBinding(MusicHodler musicHodler, View view) {
        this.a = musicHodler;
        musicHodler.tvUserName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvUserName'", TextView.class);
        musicHodler.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        musicHodler.ivPlayOrPause = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_play_or_pause, "field 'ivPlayOrPause'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MusicHodler musicHodler = this.a;
        if (musicHodler == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        musicHodler.tvUserName = null;
        musicHodler.tvTime = null;
        musicHodler.ivPlayOrPause = null;
    }
}
