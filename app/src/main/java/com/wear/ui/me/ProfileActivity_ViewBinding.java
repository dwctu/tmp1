package com.wear.ui.me;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.widget.SwitchView;

/* loaded from: classes4.dex */
public class ProfileActivity_ViewBinding implements Unbinder {
    public ProfileActivity a;

    @UiThread
    public ProfileActivity_ViewBinding(ProfileActivity profileActivity, View view) {
        this.a = profileActivity;
        profileActivity.changeAvatar = (ImageView) Utils.findRequiredViewAsType(view, R.id.change_avatar, "field 'changeAvatar'", ImageView.class);
        profileActivity.photoLayout = (ImageView) Utils.findRequiredViewAsType(view, R.id.photo_layout, "field 'photoLayout'", ImageView.class);
        profileActivity.nickname = (TextView) Utils.findRequiredViewAsType(view, R.id.nickname, "field 'nickname'", TextView.class);
        profileActivity.nicknameLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.nickname_layout, "field 'nicknameLayout'", LinearLayout.class);
        profileActivity.gender = (TextView) Utils.findRequiredViewAsType(view, R.id.gender, "field 'gender'", TextView.class);
        profileActivity.genderLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.gender_layout, "field 'genderLayout'", RelativeLayout.class);
        profileActivity.email = (TextView) Utils.findRequiredViewAsType(view, R.id.email, "field 'email'", TextView.class);
        profileActivity.informationLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.information_layout, "field 'informationLayout'", LinearLayout.class);
        profileActivity.ivBack = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
        profileActivity.emailTip = (TextView) Utils.findRequiredViewAsType(view, R.id.email_tip, "field 'emailTip'", TextView.class);
        profileActivity.emailTipVerify = (TextView) Utils.findRequiredViewAsType(view, R.id.email_tip_verify, "field 'emailTipVerify'", TextView.class);
        profileActivity.llDefaultAvatar = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_default_avatar, "field 'llDefaultAvatar'", LinearLayout.class);
        profileActivity.setBirthday = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.set_birthday_layout, "field 'setBirthday'", RelativeLayout.class);
        profileActivity.setBirthDayView = (ImageView) Utils.findRequiredViewAsType(view, R.id.set_birth_day_view, "field 'setBirthDayView'", ImageView.class);
        profileActivity.birthdayView = (TextView) Utils.findRequiredViewAsType(view, R.id.birthday_view, "field 'birthdayView'", TextView.class);
        profileActivity.switchButton = (SwitchView) Utils.findRequiredViewAsType(view, R.id.birthday_swith_button, "field 'switchButton'", SwitchView.class);
        profileActivity.set_birthday_notice = (TextView) Utils.findRequiredViewAsType(view, R.id.birthday_notice_view, "field 'set_birthday_notice'", TextView.class);
        profileActivity.termsAndConditionsForBirthday = (TextView) Utils.findRequiredViewAsType(view, R.id.terms_and_conditions_for_birthday, "field 'termsAndConditionsForBirthday'", TextView.class);
        profileActivity.scrollView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.scroll_view, "field 'scrollView'", ScrollView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ProfileActivity profileActivity = this.a;
        if (profileActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.a = null;
        profileActivity.changeAvatar = null;
        profileActivity.photoLayout = null;
        profileActivity.nickname = null;
        profileActivity.nicknameLayout = null;
        profileActivity.gender = null;
        profileActivity.genderLayout = null;
        profileActivity.email = null;
        profileActivity.informationLayout = null;
        profileActivity.ivBack = null;
        profileActivity.emailTip = null;
        profileActivity.emailTipVerify = null;
        profileActivity.llDefaultAvatar = null;
        profileActivity.setBirthday = null;
        profileActivity.setBirthDayView = null;
        profileActivity.birthdayView = null;
        profileActivity.switchButton = null;
        profileActivity.set_birthday_notice = null;
        profileActivity.termsAndConditionsForBirthday = null;
        profileActivity.scrollView = null;
    }
}
