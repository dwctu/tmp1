package com.wear.main.closeRange.alarm;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.sg3;
import dc.th4;
import org.bouncycastle.i18n.MessageBundle;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class EditAlarmNameActivity extends BaseActivity {

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.current_nickname)
    public EditText currentNickname;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            String strTrim = EditAlarmNameActivity.this.currentNickname.getText().toString().trim();
            if (WearUtils.e1(strTrim)) {
                return;
            }
            if (WearUtils.S0(strTrim)) {
                sg3.i(EditAlarmNameActivity.this, R.string.profile_name_error);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(MessageBundle.TITLE_ENTRY, strTrim);
            EditAlarmNameActivity.this.setResult(-1, intent);
            EditAlarmNameActivity.this.finish();
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            EditAlarmNameActivity.this.actionbar.getYesBtn().setTextColor(th4.b(EditAlarmNameActivity.this, editable.length() > 0 ? R.color.text_color_85 : R.color.text_color_45));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() <= 0) {
                EditAlarmNameActivity.this.actionbar.getYesBtn().setEnabled(false);
            } else {
                EditAlarmNameActivity.this.actionbar.getYesBtn().setEnabled(true);
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_edit_alarm_name);
        ButterKnife.bind(this);
        this.actionbar.setTitle(ah4.e(R.string.alarm_name));
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.actionbar = myActionBar;
        myActionBar.setYesAction(R.string.common_save, new a());
        this.currentNickname.addTextChangedListener(new b());
        if (getIntent() != null && getIntent().getExtras() != null) {
            String string = getIntent().getExtras().getString(MessageBundle.TITLE_ENTRY);
            if (WearUtils.e1(string)) {
                String strE = ah4.e(R.string.message_notification_type_alarm);
                this.currentNickname.setText(strE);
                this.currentNickname.setSelection(strE.length());
            } else {
                this.currentNickname.setText(string);
                this.currentNickname.setSelection(string.length());
            }
        }
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
