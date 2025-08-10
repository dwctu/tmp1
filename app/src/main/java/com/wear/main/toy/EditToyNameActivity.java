package com.wear.main.toy;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.ExoPlayer;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.bean.ToyRename;
import com.wear.dao.DaoUtils;
import com.wear.dao.ToyRenameDao;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.xtremeprog.sdk.ble.BleService;
import dc.ToyChangeNameEvent;
import dc.ah4;
import dc.kn3;
import dc.pc1;
import dc.rp1;
import dc.sg3;
import dc.ue3;
import dc.vc1;
import dc.ye3;
import dc.yr1;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes3.dex */
public class EditToyNameActivity extends BaseActivity {
    public static String f = "ec";
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public MyApplication b;

    @BindView(R.id.current_nickname)
    public EditText currentNickname;
    public Toy d;

    @BindView(R.id.tv_toy_note)
    public TextView tvToyNote;
    public pc1 c = null;
    public Handler e = new Handler();

    public class a implements MyActionBar.f {

        /* renamed from: com.wear.main.toy.EditToyNameActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0134a implements Runnable {
            public RunnableC0134a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                sg3.l(ah4.e(R.string.comman_save_failed));
            }
        }

        public class b implements kn3.d {
            public b() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
                EditToyNameActivity.this.finish();
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                EditToyNameActivity.this.finish();
            }
        }

        public class c implements Runnable {
            public c(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                sg3.l(ah4.e(R.string.comman_save_failed));
            }
        }

        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            String string = EditToyNameActivity.this.currentNickname.getText().toString();
            ye3.k("toys", "toy_name_save_click", "click", "toy_name_save", "button", string, "", -1L, EditToyNameActivity.this.d.getAddress());
            if (string.contains(DfuBaseService.NOTIFICATION_CHANNEL_DFU) || string.contains("lvs") || string.contains("new")) {
                sg3.i(EditToyNameActivity.this, R.string.profile_name_error);
                return;
            }
            if (!WearUtils.e1(string) && WearUtils.S0(string)) {
                sg3.i(EditToyNameActivity.this, R.string.profile_name_error);
                return;
            }
            EditToyNameActivity editToyNameActivity = EditToyNameActivity.this;
            editToyNameActivity.z4(string, editToyNameActivity.d.getAddress());
            EditToyNameActivity editToyNameActivity2 = EditToyNameActivity.this;
            rp1.t(editToyNameActivity2.w4(editToyNameActivity2.d.getAddress(), EditToyNameActivity.this.d.getFormApp()));
            if (EditToyNameActivity.this.d.supportChangeName()) {
                String strTrim = string.trim();
                if (WearUtils.e1(strTrim)) {
                    yr1.b(EditToyNameActivity.this.d.getAddress());
                    EditToyNameActivity.this.e.postDelayed(new RunnableC0134a(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    return;
                }
                if (!strTrim.matches("^[0-9a-zA-Z_\\s]{0,12}$")) {
                    sg3.h(R.string.toy_name_error);
                    return;
                }
                EditToyNameActivity editToyNameActivity3 = EditToyNameActivity.this;
                if (editToyNameActivity3.c.a(editToyNameActivity3.d.getAddress())) {
                    yr1.a(EditToyNameActivity.this.d.getAddress(), strTrim);
                    EditToyNameActivity.this.e.postDelayed(new c(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    return;
                } else {
                    kn3 kn3Var = new kn3((Context) EditToyNameActivity.this, ah4.e(R.string.toy_program_disconnected), ah4.e(R.string.common_back), false, false, (kn3.d) new b());
                    kn3Var.show();
                    kn3Var.n();
                    return;
                }
            }
            EditToyNameActivity.this.addAnalyticsEventId("toy_rename", null);
            ToyRename toyRenameFindToyName = DaoUtils.getToyRenameDao().findToyName(WearUtils.y.r(), EditToyNameActivity.this.d.getAddress());
            if (toyRenameFindToyName != null) {
                toyRenameFindToyName.setName(string);
                toyRenameFindToyName.setUpdateTime(System.currentTimeMillis());
                DaoUtils.getToyRenameDao().update((ToyRenameDao) toyRenameFindToyName);
            } else {
                ToyRename toyRename = new ToyRename();
                toyRename.setEmail(WearUtils.y.r());
                toyRename.setName(string);
                toyRename.setUpdateTime(System.currentTimeMillis());
                toyRename.setAddress(EditToyNameActivity.this.d.getAddress());
                DaoUtils.getToyRenameDao().add((ToyRenameDao) toyRename);
            }
            EditToyNameActivity.this.d.setDefineRename(string);
            EventBus.getDefault().post(new vc1(EditToyNameActivity.this.d.getAddress(), EditToyNameActivity.this.d.getBattery()));
            EditToyNameActivity editToyNameActivity4 = EditToyNameActivity.this;
            ue3.a(editToyNameActivity4.currentNickname, editToyNameActivity4.b);
            sg3.l(ah4.e(R.string.comman_saved_successfully));
            EditToyNameActivity.this.finish();
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            EditToyNameActivity editToyNameActivity = EditToyNameActivity.this;
            ue3.a(editToyNameActivity.currentNickname, editToyNameActivity.b);
            EditToyNameActivity.this.finish();
        }
    }

    public class c implements TextWatcher {
        public c(EditToyNameActivity editToyNameActivity) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            editable.toString().length();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            charSequence.toString();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y4() {
        if (this.currentNickname.isAttachedToWindow()) {
            ue3.d(this.currentNickname, this.b);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_edit_toy_nickname);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.b = (MyApplication) getApplication();
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.actionbar = myActionBar;
        myActionBar.setTitle(ah4.e(R.string.toy_defind_name_title));
        this.actionbar.setYesAction(R.string.common_save, new a());
        this.actionbar.setBackAction(new b());
        this.c = this.b.G();
        String stringExtra = getIntent().getStringExtra("program_toy_address_Id");
        this.a = stringExtra;
        Toy toyQ = this.c.Q(stringExtra);
        this.d = toyQ;
        if (toyQ == null) {
            finish();
            return;
        }
        if (toyQ.supportChangeName()) {
            this.tvToyNote.setVisibility(0);
        } else {
            this.tvToyNote.setVisibility(8);
        }
        this.currentNickname.addTextChangedListener(new c(this));
        String defineRename = this.d.getDefineRename();
        boolean zE1 = WearUtils.e1(defineRename);
        if (this.d.supportChangeName()) {
            if (!zE1 && defineRename.length() > 13) {
                defineRename = defineRename.substring(0, 13);
            }
            this.currentNickname.setText(zE1 ? "" : defineRename);
            EditText editText = this.currentNickname;
            editText.setSelection(editText.getText().length());
            this.currentNickname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
        } else {
            if (!zE1 && defineRename.length() > 20) {
                defineRename = defineRename.substring(0, 20);
            }
            this.currentNickname.setText(zE1 ? "" : defineRename);
            EditText editText2 = this.currentNickname;
            editText2.setSelection(editText2.getText().length());
            this.currentNickname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        }
        this.currentNickname.requestFocus();
        this.currentNickname.postDelayed(new Runnable() { // from class: dc.kg2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y4();
            }
        }, 300L);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ToyChangeNameEvent toyChangeNameEvent) {
        this.e.removeCallbacksAndMessages(null);
        if (!toyChangeNameEvent.getIsOk()) {
            sg3.l(ah4.e(R.string.comman_save_failed));
            return;
        }
        String strTrim = this.currentNickname.getText().toString().trim();
        ToyRename toyRenameFindToyName = DaoUtils.getToyRenameDao().findToyName(WearUtils.y.r(), this.d.getAddress());
        addAnalyticsEventId("toy_rename", null);
        if (toyRenameFindToyName != null) {
            toyRenameFindToyName.setName(strTrim);
            DaoUtils.getToyRenameDao().update((ToyRenameDao) toyRenameFindToyName);
        } else {
            ToyRename toyRename = new ToyRename();
            toyRename.setEmail(WearUtils.y.r());
            toyRename.setName(strTrim);
            toyRename.setAddress(this.d.getAddress());
            DaoUtils.getToyRenameDao().add((ToyRenameDao) toyRename);
        }
        this.d.setDefineRename(strTrim);
        this.d.setDeviceName(strTrim);
        EventBus.getDefault().post(new vc1(this.d.getAddress(), this.d.getBattery()));
        ue3.a(this.currentNickname, this.b);
        sg3.l(ah4.e(R.string.comman_saved_successfully));
        finish();
    }

    public final String w4(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("toy_mac", (Object) str.replace(SignatureImpl.INNER_SEP, ""));
        if (!TextUtils.equals("Lovense Remote", str2)) {
            jSONObject.put("connected_app", (Object) str2);
        }
        return jSONObject.toJSONString();
    }

    public final void z4(String str, String str2) {
        Uri uri = Uri.parse("content://com.lovense.vibemate.provider.VbTopContentProvider/TOY_RENAME");
        if (getContentResolver().getType(uri) == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(BleService.EXTRA_ADDR, str2);
        contentValues.put("NAME", str);
        contentValues.put("UPDATE_TIME", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("FORM_APP", "Lovense Remote");
        getContentResolver().update(uri, contentValues, null, null);
    }
}
