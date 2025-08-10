package com.wear.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Account;
import com.wear.main.MainActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ep1;
import dc.gp1;
import dc.ip1;
import dc.nv1;
import dc.ov1;
import dc.th4;
import dc.ue3;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes4.dex */
public class EditMoodMessageActivity extends BaseActivity {
    public ov1 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.current_mood_message)
    public EditText currentMoodMessage;

    @BindView(R.id.tv_count)
    public TextView tvCount;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            EditMoodMessageActivity.this.t4();
        }
    }

    public class b extends nv1 {
        public b() {
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            EditMoodMessageActivity.this.tvCount.setText(editable.length() + "/30");
            EditMoodMessageActivity.this.actionbar.getYesBtn().setTextColor(th4.b(EditMoodMessageActivity.this, editable.length() > 0 ? R.drawable.action_bar_text_selector : R.color.text_color_45));
        }

        @Override // dc.nv1, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() <= 0) {
                EditMoodMessageActivity.this.actionbar.getYesBtn().setEnabled(false);
            } else {
                EditMoodMessageActivity.this.actionbar.getYesBtn().setEnabled(true);
            }
        }
    }

    public class c implements ov1.b {
        public c() {
        }

        @Override // dc.ov1.b
        public void a(int i) {
            if (EditMoodMessageActivity.this.isFinishing()) {
                return;
            }
            EditMoodMessageActivity.this.currentMoodMessage.setCursorVisible(false);
            EditMoodMessageActivity.this.tvCount.setVisibility(4);
            EditMoodMessageActivity editMoodMessageActivity = EditMoodMessageActivity.this;
            editMoodMessageActivity.currentMoodMessage.setHint(editMoodMessageActivity.getString(R.string.me_share_mood_des));
            EditMoodMessageActivity editMoodMessageActivity2 = EditMoodMessageActivity.this;
            editMoodMessageActivity2.currentMoodMessage.setTextColor(th4.b(editMoodMessageActivity2, R.color.diff_editmood_done));
        }

        @Override // dc.ov1.b
        public void b(int i) {
            if (EditMoodMessageActivity.this.isFinishing()) {
                return;
            }
            EditMoodMessageActivity.this.currentMoodMessage.setCursorVisible(true);
            EditMoodMessageActivity.this.tvCount.setVisibility(0);
            EditMoodMessageActivity.this.currentMoodMessage.setHint("");
            EditMoodMessageActivity editMoodMessageActivity = EditMoodMessageActivity.this;
            editMoodMessageActivity.currentMoodMessage.setTextColor(th4.b(editMoodMessageActivity, R.color.diff_editmood_editing));
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ Account a;
        public final /* synthetic */ String b;

        public d(EditMoodMessageActivity editMoodMessageActivity, Account account, String str) {
            this.a = account;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setMoodMessage(this.b);
            WearUtils.x.l.post(new Runnable() { // from class: dc.fb3
                @Override // java.lang.Runnable
                public final void run() {
                    hu3.v0(true);
                }
            });
        }
    }

    public class e implements ip1 {
        public final /* synthetic */ MainActivity a;

        public e(MainActivity mainActivity) {
            this.a = mainActivity;
        }

        @Override // dc.ip1
        public void G() {
            this.a.dissDialog();
        }

        @Override // dc.ip1
        public void d() {
            this.a.cancleDelay();
            String string = EditMoodMessageActivity.this.currentMoodMessage.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("moodMessage", string);
            EditMoodMessageActivity.this.setResult(-1, intent);
            EditMoodMessageActivity.this.finish();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.discover_edit_mood_message);
        ButterKnife.bind(this);
        this.application = (MyApplication) getApplication();
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.actionbar = myActionBar;
        myActionBar.setYesAction(R.string.common_save, new a());
        u4(findViewById(R.id.screan_root_layout));
        this.currentMoodMessage.addTextChangedListener(new b());
        Bundle extras = getIntent().getExtras();
        this.actionbar.setTitle(getString(R.string.page_edit_mood_message));
        if (extras != null) {
            this.currentMoodMessage.setText(extras.getString("moodMessage"));
        }
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
        ue3.a(this.currentMoodMessage, this);
    }

    public final void t4() {
        Account accountU = WearUtils.y.u();
        MainActivity mainActivity = MyApplication.M;
        if (mainActivity == null || mainActivity.isFinishing() || mainActivity.isDestroyed() || accountU == null) {
            return;
        }
        String moodMessage = accountU.getMoodMessage();
        String string = this.currentMoodMessage.getText().toString();
        if (string.equals(moodMessage)) {
            return;
        }
        if (ep1.b().r(this, new gp1(new d(this, accountU, string), new e(mainActivity)))) {
            mainActivity.showDialog();
        }
    }

    public final void u4(View view) {
        this.currentMoodMessage.setCursorVisible(false);
        ov1 ov1Var = new ov1(view);
        this.a = ov1Var;
        ov1Var.b(new c());
    }
}
