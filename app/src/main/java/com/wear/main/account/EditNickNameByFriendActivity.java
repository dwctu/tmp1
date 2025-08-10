package com.wear.main.account;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.UserSettingsBean;
import com.wear.bean.event.FinishChatPageEvent;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.be3;
import dc.hp1;
import dc.sg3;
import dc.ue3;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class EditNickNameByFriendActivity extends BaseActivity {
    public UserSettingsBean a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String b;
    public IPeopleInfo c;

    @BindView(R.id.content_delete)
    public ImageView contentDelete;

    @BindView(R.id.current_nickname)
    public EditText currentNickname;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            String string = EditNickNameByFriendActivity.this.currentNickname.getText().toString();
            if (WearUtils.e1(string) || EditNickNameByFriendActivity.this.u4(string.trim())) {
                EditNickNameByFriendActivity.this.v4(string.trim());
            } else if (EditNickNameByFriendActivity.this.c.isGroup()) {
                sg3.i(EditNickNameByFriendActivity.this, R.string.group_remark_restrict_special_note);
            } else {
                sg3.i(EditNickNameByFriendActivity.this, R.string.profile_name_error);
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (WearUtils.e1(EditNickNameByFriendActivity.this.currentNickname.getText().toString())) {
                EditNickNameByFriendActivity.this.contentDelete.setVisibility(8);
            } else {
                EditNickNameByFriendActivity.this.contentDelete.setVisibility(0);
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
            EditNickNameByFriendActivity.this.currentNickname.setText("");
            EditNickNameByFriendActivity.this.contentDelete.setVisibility(8);
        }
    }

    public class d implements hp1.d {
        public d(EditNickNameByFriendActivity editNickNameByFriendActivity) {
        }

        @Override // dc.hp1.d
        public void a() {
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_edit_nickname);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.actionbar = myActionBar;
        myActionBar.setTitle(ah4.e(R.string.partner_profile_nick_name_title));
        this.actionbar.setYesAction(R.string.common_save, new a());
        String stringExtra = getIntent().getStringExtra("userId");
        this.b = stringExtra;
        IPeopleInfo iPeopleInfoS = WearUtils.y.s(stringExtra);
        this.c = iPeopleInfoS;
        if (iPeopleInfoS == null) {
            finish();
            return;
        }
        this.currentNickname.addTextChangedListener(new b());
        this.contentDelete.setOnClickListener(new c());
        UserSettingsBean userSettingsBeanG = WearUtils.x.i.g(this.c.getUserJid());
        this.a = userSettingsBeanG;
        if (userSettingsBeanG != null) {
            String remark = userSettingsBeanG.getRemark();
            if (!WearUtils.e1(remark)) {
                this.currentNickname.setText(remark);
                EditText editText = this.currentNickname;
                editText.setSelection(editText.getText().toString().length());
            }
        }
        if (!this.c.isGroup()) {
            this.currentNickname.setHint(ah4.e(R.string.comman_max_characters_20));
            this.currentNickname.setFilters(new InputFilter[]{new WearUtils.g(), new InputFilter.LengthFilter(20)});
        } else {
            this.actionbar.setTitle(ah4.e(R.string.group_edit_remark));
            this.currentNickname.setHint(ah4.e(R.string.comman_max_characters_30));
            this.currentNickname.setFilters(new InputFilter[]{new WearUtils.g(), new InputFilter.LengthFilter(30)});
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(FinishChatPageEvent finishChatPageEvent) {
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ue3.a(this.currentNickname, this);
    }

    public boolean u4(String str) {
        return this.c.isGroup() ? Pattern.matches("^(?:[\\p{N}\\p{L}\\u0020]){1,30}$", str) : Pattern.matches("^(?:[\\p{N}\\p{L}\\u0020]){1,20}$", str);
    }

    public final void v4(String str) {
        UserSettingsBean userSettingsBean = this.a;
        if (userSettingsBean != null) {
            userSettingsBean.setRemark(str);
        } else {
            WearUtils.x.i.c(this.c.getUserJid(), str);
        }
        String str2 = "jid=" + this.c.getUserJid() + "&remark=" + str + "&time=" + be3.I().getTime();
        HashMap map = new HashMap();
        map.put("nickName", String.valueOf(str).trim());
        map.put("friendEmail", String.valueOf(this.b).trim());
        hp1.a(str2, map, true, new d(this), String.valueOf(this.b).trim());
        IPeopleInfo iPeopleInfoS = WearUtils.y.s(this.b);
        if (iPeopleInfoS != null) {
            iPeopleInfoS.setRemark(str);
        }
        finish();
    }
}
