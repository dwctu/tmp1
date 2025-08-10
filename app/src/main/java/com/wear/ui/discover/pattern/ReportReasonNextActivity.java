package com.wear.ui.discover.pattern;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.event.ReportSuccEvent;
import com.wear.bean.response.ReportResponse;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.MyActionBar;
import com.wear.widget.SwitchView;
import dc.ah4;
import dc.sg3;
import dc.tn2;
import dc.ue3;
import dc.zn2;
import java.util.HashMap;
import org.bouncycastle.crypto.tls.CipherSuite;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class ReportReasonNextActivity extends BaseActivity {
    public String a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;
    public String b;
    public int c = -1;
    public boolean d = true;
    public String e;
    public int f;
    public boolean g;

    @BindView(R.id.ll_edt_bg)
    public LinearLayout ll_edt_bg;

    @BindView(R.id.message_text)
    public EditText messageText;

    @BindView(R.id.message_text_number)
    public TextView messageTextNumber;

    @BindView(R.id.submit_btn)
    public MediumBoldTextView submit_btn;

    @BindView(R.id.swbtn_is_hidden)
    public SwitchView swbtn_is_hidden;

    @BindView(R.id.tv_ednum_tip)
    public TextView tv_ednum_tip;

    @BindView(R.id.tv_selected_reason)
    public MediumBoldTextView tv_selected_reason;

    public class a implements View.OnKeyListener {
        public a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 66 || keyEvent.getAction() != 1) {
                return false;
            }
            ReportReasonNextActivity reportReasonNextActivity = ReportReasonNextActivity.this;
            ue3.a(reportReasonNextActivity.messageText, reportReasonNextActivity);
            return false;
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
            ReportReasonNextActivity.this.f = charSequence.toString().trim().length();
            if (ReportReasonNextActivity.this.f > 0 && ReportReasonNextActivity.this.g) {
                ReportReasonNextActivity.this.ll_edt_bg.setBackgroundResource(R.drawable.report_input_message_bg);
                ReportReasonNextActivity.this.g = false;
            }
            if (ReportReasonNextActivity.this.f < 15 || ReportReasonNextActivity.this.f <= 140) {
                ReportReasonNextActivity.this.submit_btn.setEnabled(true);
                ReportReasonNextActivity.this.tv_ednum_tip.setVisibility(4);
            } else {
                ReportReasonNextActivity.this.submit_btn.setEnabled(true);
                ReportReasonNextActivity.this.tv_ednum_tip.setVisibility(4);
            }
            ReportReasonNextActivity.this.messageTextNumber.setText(ReportReasonNextActivity.this.f + "/" + CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA);
        }
    }

    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ReportReasonNextActivity.this.d = z;
        }
    }

    public class d implements zn2<String> {
        public d() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            ReportReasonNextActivity.this.dissDialog();
            ReportResponse reportResponse = (ReportResponse) WearUtils.A.fromJson(str, ReportResponse.class);
            if (reportResponse == null) {
                sg3.j(ReportReasonNextActivity.this, R.string.patterns_result_report_failed, " [" + NetException.SERVICE_DATA_ERROR + "]");
                return;
            }
            if (reportResponse.isResult()) {
                sg3.i(ReportReasonNextActivity.this, R.string.patterns_result_report_summitted);
                ReportSuccEvent reportSuccEvent = new ReportSuccEvent();
                String status = "";
                reportSuccEvent.setIsShowReview((reportResponse.getData() == null || WearUtils.e1(reportResponse.getData().getIsShowReview())) ? "" : reportResponse.getData().getIsShowReview());
                if (reportResponse.getData() != null && !WearUtils.e1(reportResponse.getData().getStatus())) {
                    status = reportResponse.getData().getStatus();
                }
                reportSuccEvent.setStatus(status);
                reportSuccEvent.setPatternId(ReportReasonNextActivity.this.a);
                reportSuccEvent.setIsHidePattern(ReportReasonNextActivity.this.d);
                EventBus.getDefault().post(reportSuccEvent);
                ReportReasonNextActivity.this.finish();
                return;
            }
            if (reportResponse.getCode().equals("400")) {
                sg3.j(ReportReasonNextActivity.this, R.string.operate_frequently, " [" + reportResponse.getCode() + "]");
                return;
            }
            sg3.j(ReportReasonNextActivity.this, R.string.patterns_result_report_failed, " [" + reportResponse.getCode() + "]");
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            ReportReasonNextActivity.this.dissDialog();
            sg3.k(ReportReasonNextActivity.this, netException.getMessage());
        }
    }

    public final void A4() {
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, this.a);
        map.put("reportType", this.c + "");
        if (this.b != null) {
            map.put("hidePatternId", this.b + "");
        }
        map.put("detail", this.messageText.getText().toString());
        map.put("isHide", this.d ? "1" : "0");
        showDialog();
        tn2.x(WearUtils.x).l("/wear/pattern/v2/report", map, new d());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return getWindow().superDispatchTouchEvent(motionEvent) || onTouchEvent(motionEvent);
        }
        View currentFocus = getCurrentFocus();
        if (z4(this.messageText, motionEvent) && ((InputMethodManager) getSystemService("input_method")) != null && currentFocus != null) {
            ue3.a(this.messageText, this);
            EditText editText = this.messageText;
            if (editText != null) {
                editText.clearFocus();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @OnClick({R.id.submit_btn})
    public void onClick(View view) {
        if (view.getId() != R.id.submit_btn) {
            return;
        }
        int i = this.f;
        if (i == 0) {
            this.g = true;
            this.ll_edt_bg.setBackgroundResource(R.drawable.report_input_message_red_line_bg);
        } else if (i <= 140 && i >= 15) {
            A4();
        } else {
            this.g = true;
            this.tv_ednum_tip.setVisibility(0);
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_report_reason_next);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        this.a = intent.getStringExtra(TtmlNode.ATTR_ID);
        this.b = intent.getStringExtra("hidePatternId");
        this.e = intent.getStringExtra("reason");
        this.c = intent.getIntExtra("reportType", 0);
        this.actionbar.setTitle(ah4.e(R.string.patterns_menu_report));
        this.submit_btn.setEnabled(true);
        this.tv_selected_reason.setText(TextUtils.isEmpty(this.e) ? "" : this.e);
        this.messageText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA)});
        this.messageTextNumber.setText("0/140");
        this.messageText.setOnKeyListener(new a());
        this.messageText.addTextChangedListener(new b());
        this.swbtn_is_hidden.setOnCheckedChangeListener(new c());
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        ue3.a(this.messageText, this);
    }

    public boolean z4(View view, MotionEvent motionEvent) {
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }
}
