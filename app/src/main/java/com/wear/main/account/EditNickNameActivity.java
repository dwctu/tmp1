package com.wear.main.account;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.sg3;
import dc.ue3;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class EditNickNameActivity extends BaseActivity {
    public int a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public int b = 20;

    @BindView(R.id.content_delete)
    public ImageView contentDelete;

    @BindView(R.id.current_nickname)
    public EditText currentNickname;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            String string = EditNickNameActivity.this.currentNickname.getText().toString();
            int i = EditNickNameActivity.this.a;
            if (i == 0) {
                if (WearUtils.e1(string) || string.length() < 6 || string.length() > EditNickNameActivity.this.b) {
                    sg3.i(EditNickNameActivity.this, R.string.register_name_error);
                    return;
                }
            } else if (i == 2 && WearUtils.e1(string)) {
                sg3.i(EditNickNameActivity.this, R.string.group_nickname_restrict_note);
                return;
            }
            if (EditNickNameActivity.this.s4(string)) {
                Intent intent = new Intent();
                if (TextUtils.isEmpty(string)) {
                    string = ah4.e(R.string.people_group_chat);
                }
                intent.putExtra("nickname", string);
                EditNickNameActivity.this.setResult(-1, intent);
                EditNickNameActivity.this.finish();
                return;
            }
            EditNickNameActivity editNickNameActivity = EditNickNameActivity.this;
            int i2 = editNickNameActivity.a;
            if (i2 == 1) {
                sg3.k(EditNickNameActivity.this, ah4.e(R.string.group_name_restrict_special_note));
            } else if (i2 == 0) {
                sg3.i(editNickNameActivity, R.string.profile_name_error);
            } else if (i2 == 2) {
                sg3.i(editNickNameActivity, R.string.group_nickname_restrict_special_note);
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (WearUtils.e1(EditNickNameActivity.this.currentNickname.getText().toString())) {
                EditNickNameActivity.this.contentDelete.setVisibility(8);
            } else {
                EditNickNameActivity.this.contentDelete.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditNickNameActivity.this.currentNickname.setText("");
            EditNickNameActivity.this.contentDelete.setVisibility(8);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_edit_nickname);
        ButterKnife.bind(this);
        this.application = (MyApplication) getApplication();
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.actionbar = myActionBar;
        myActionBar.setYesAction(R.string.common_save, new a());
        this.currentNickname.addTextChangedListener(new b());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.a = extras.getInt("flag");
            String string = extras.getString("nickname");
            int i = this.a;
            if (i == 1) {
                this.actionbar.setTitle(ah4.e(R.string.group_edit_group_name));
                this.currentNickname.setHint(ah4.e(R.string.group_edit_group_name));
            } else if (i == 2) {
                this.actionbar.setTitle(ah4.e(R.string.group_edit_nickname));
                this.currentNickname.setHint(ah4.e(R.string.group_edit_nickname));
            }
            if (!WearUtils.e1(string)) {
                this.currentNickname.setText(string);
                this.currentNickname.setSelection(this.currentNickname.getText().toString().length());
            }
        } else {
            this.a = 0;
        }
        int i2 = this.a;
        if (i2 == 0 || i2 == 2) {
            this.b = 20;
        } else {
            this.b = 30;
        }
        this.currentNickname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.b)});
        this.contentDelete.setOnClickListener(new c());
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ue3.a(this.currentNickname, this);
    }

    public boolean s4(String str) {
        int i = this.a;
        return i == 1 ? Pattern.matches("^(?:[\\p{N}\\p{L}\\u0020]){0,30}$", str) : i == 2 ? Pattern.matches("^(?:[\\p{N}\\p{L}\\u0020]){1,20}$", str) : Pattern.matches("[-a-zA-Z0-9_]+$", str);
    }
}
