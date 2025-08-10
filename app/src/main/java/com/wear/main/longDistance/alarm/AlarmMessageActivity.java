package com.wear.main.longDistance.alarm;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class AlarmMessageActivity extends BaseActivity {

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.message_text)
    public EditText messageText;

    @BindView(R.id.message_text_number)
    public TextView messageTextNumber;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            String string = AlarmMessageActivity.this.messageText.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("message", string);
            AlarmMessageActivity.this.setResult(-1, intent);
            AlarmMessageActivity.this.finish();
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = charSequence.length();
            AlarmMessageActivity.this.messageTextNumber.setText(length + "/" + CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.alarm_edit_message);
        ButterKnife.bind(this);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.actionbar = myActionBar;
        myActionBar.setYesAction(R.string.common_save, new a());
        this.messageText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA)});
        this.messageTextNumber.setText("0/140");
        this.messageText.addTextChangedListener(new b());
        if (getIntent() != null && getIntent().getExtras() != null) {
            String string = getIntent().getExtras().getString("message");
            if (!WearUtils.e1(string)) {
                this.messageText.setText(string);
                this.messageText.setSelection(string.length());
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
