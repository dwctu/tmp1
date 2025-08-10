package com.wear.main.account;

import android.view.View;
import android.widget.ListView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public class SettingLanguageActivity_ViewBinding implements Unbinder {
    public SettingLanguageActivity a;

    @UiThread
    public SettingLanguageActivity_ViewBinding(SettingLanguageActivity settingLanguageActivity, View view) {
        this.a = settingLanguageActivity;
        settingLanguageActivity.actionbar = (MyActionBar) Utils.findRequiredViewAsType(view, R.id.actionbar, "field 'actionbar'", MyActionBar.class);
        settingLanguageActivity.lvLanguage = (ListView) Utils.findRequiredViewAsType(view, R.id.lv_language, "field 'lvLanguage'", ListView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SettingLanguageActivity settingLanguageActivity = this.a;
        if (settingLanguageActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        settingLanguageActivity.actionbar = null;
        settingLanguageActivity.lvLanguage = null;
    }
}
