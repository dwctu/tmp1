package com.wear.ui.longDistance.controlLink;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.NewDpgEventConfigBean;
import com.wear.bean.SurveyInfoBean;
import com.wear.bean.event.RefreshControlLinkList;
import com.wear.bean.socketio.controlLink.response.ControlLinkListResponse;
import com.wear.util.WearUtils;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.am2;
import dc.c83;
import dc.de3;
import dc.eg3;
import dc.gg3;
import dc.hp;
import dc.kf;
import dc.ku1;
import dc.l22;
import dc.sg3;
import dc.th4;
import dc.xo2;
import dc.ye3;
import dc.zg3;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes4.dex */
public class ControlLinkEndActivity extends BaseActivity<am2> implements xo2 {
    public am2 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionbar;

    @BindView(R.id.ad_rly)
    public RelativeLayout adRly;
    public ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO b;
    public String c;

    @BindView(R.id.cl_survey_banner)
    public ConstraintLayout cl_survey_banner;

    @BindView(R.id.close_iv)
    public ImageView closeIv;

    @BindView(R.id.dpgIv)
    public ImageView dpgIv;

    @BindView(R.id.iv_end_image)
    public ImageView mIvEndImage;

    @BindView(R.id.tv_end_describe)
    public TextView mTvEndDescribe;

    @BindView(R.id.repeat_text)
    public MediumBoldTextView repeatText;

    @BindView(R.id.tv_reactivate)
    public MediumBoldTextView tvReactivate;

    @BindView(R.id.tv_confirm)
    public MediumBoldTextView tv_confirm;

    @BindView(R.id.tv_content)
    public MediumBoldTextView tv_content;

    @BindView(R.id.tv_title)
    public MediumBoldTextView tv_title;
    public boolean d = false;
    public CountDownTimer e = new a(30000, 1000);

    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ControlLinkEndActivity.this.d = true;
            String str = String.format(ah4.e(R.string.reactive_notice2), "0");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(th4.b(ControlLinkEndActivity.this, R.color.wish_list_guild_text_color_2));
            SpannableString spannableString = new SpannableString(str);
            int iIndexOf = str.indexOf("0");
            String str2 = "onTick: time index=" + iIndexOf;
            if (iIndexOf != -1) {
                spannableString.setSpan(foregroundColorSpan, iIndexOf, iIndexOf + 1, 33);
            }
            ControlLinkEndActivity.this.repeatText.setText(spannableString);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            String strValueOf = String.valueOf(j / 1000);
            ControlLinkEndActivity.this.d = false;
            String str = String.format(ah4.e(R.string.reactive_notice2), strValueOf);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(th4.b(ControlLinkEndActivity.this, R.color.control_link_end_countdown_text_color));
            SpannableString spannableString = new SpannableString(str);
            int iIndexOf = str.indexOf(strValueOf);
            String str2 = "onTick: time index=" + iIndexOf;
            if (iIndexOf != -1) {
                spannableString.setSpan(foregroundColorSpan, iIndexOf, strValueOf.length() + iIndexOf, 33);
            }
            ControlLinkEndActivity.this.repeatText.setText(spannableString);
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            ControlLinkEndActivity.this.finish();
        }
    }

    public class c extends zg3 {
        public final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ImageView imageView, int i) {
            super(imageView);
            this.j = i;
        }

        @Override // dc.yo, dc.cp
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void f(Bitmap bitmap, @Nullable hp hpVar) {
            super.f(bitmap, hpVar);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            ViewGroup.LayoutParams layoutParams = ControlLinkEndActivity.this.dpgIv.getLayoutParams();
            int i = this.j;
            layoutParams.height = (height * i) / width;
            layoutParams.width = i;
            ControlLinkEndActivity.this.dpgIv.setLayoutParams(layoutParams);
        }
    }

    public class d extends zg3 {
        public final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ImageView imageView, int i) {
            super(imageView);
            this.j = i;
        }

        @Override // dc.yo, dc.cp
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void f(Bitmap bitmap, @Nullable hp hpVar) {
            super.f(bitmap, hpVar);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            ViewGroup.LayoutParams layoutParams = ControlLinkEndActivity.this.dpgIv.getLayoutParams();
            int i = this.j;
            layoutParams.height = (height * i) / width;
            layoutParams.width = i;
            ControlLinkEndActivity.this.dpgIv.setLayoutParams(layoutParams);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ControlLinkEndActivity.this.application.G().u0();
        }
    }

    public static Bitmap v4(byte[] bArr, BitmapFactory.Options options) {
        if (bArr != null) {
            return options != null ? BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options) : BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x4(NewDpgEventConfigBean newDpgEventConfigBean, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(newDpgEventConfigBean.getData().getAndroidClickUrl())));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        C4(newDpgEventConfigBean, "M0059");
        if (TextUtils.equals(newDpgEventConfigBean.getData().getEventType(), "tophy")) {
            return;
        }
        eg3.j(this, "sp_is_close", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z4(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.adRly.setVisibility(8);
        eg3.j(this, "sp_is_close", true);
    }

    public final void A4(String str, int i) {
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, str);
        map.put("type", Integer.valueOf(i));
        ye3.d("M0054", WearUtils.A.toJson(map));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void B4(String str) {
        String strE;
        String str2 = l22.n().i;
        this.tvReactivate.setVisibility(8);
        str.hashCode();
        int i = 0;
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1213329806:
                if (str.equals("5009101")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1213329807:
                if (str.equals("5009102")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1213329808:
                if (str.equals("5009103")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1213329809:
                if (str.equals("5009104")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1213329810:
                if (str.equals("5009105")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        String strE2 = "";
        switch (c2) {
            case 0:
                strE2 = ah4.e(R.string.fail_to_open_link1);
                strE = ah4.e(R.string.fail_to_open_link_des3);
                u4(str2, "4");
                i = R.drawable.img_failed;
                break;
            case 1:
                strE2 = ah4.e(R.string.fail_to_open_link1);
                strE = ah4.e(R.string.banned_opening_link_des);
                u4(str2, "5");
                i = R.drawable.img_failed;
                break;
            case 2:
                i = R.drawable.img_expired;
                strE2 = ah4.e(R.string.fail_to_open_link3);
                strE = ah4.e(R.string.fail_to_open_link_des2);
                u4(str2, ExifInterface.GPS_MEASUREMENT_3D);
                break;
            case 3:
                i = R.drawable.img_istaken;
                strE2 = ah4.e(R.string.fail_to_open_link2);
                strE = ah4.e(R.string.fail_to_open_link_des1);
                u4(str2, "2");
                break;
            case 4:
                strE2 = ah4.e(R.string.fail_to_open_link1);
                strE = ah4.e(R.string.fail_to_open_link_des3);
                i = R.drawable.img_failed;
                break;
            default:
                strE = "";
                break;
        }
        this.mIvEndImage.setImageResource(i);
        this.tv_title.setText(strE2);
        this.tv_content.setText(strE);
    }

    public final void C4(NewDpgEventConfigBean newDpgEventConfigBean, String str) {
        HashMap map = new HashMap();
        map.put("reason", newDpgEventConfigBean.getData().getEventType());
        map.put("func_type", c83.R1().e2() ? "Controller" : "Controllee");
        map.put("type", newDpgEventConfigBean.getData().getAbtestType());
        ye3.e(str, map);
    }

    @Override // dc.xo2
    public void I0(String str) {
        dissDialog();
        finish();
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        super.initInject();
        this.mActivityComponent.c(this);
        this.mPresenter = this.a;
    }

    @Override // dc.xo2
    public void m(SurveyInfoBean surveyInfoBean) {
        if (surveyInfoBean == null || surveyInfoBean.getOpenStatus() != 1) {
            return;
        }
        this.cl_survey_banner.setVisibility(0);
        this.c = surveyInfoBean.getOnlineUrl();
    }

    @OnClick({R.id.tv_confirm, R.id.tv_reactivate, R.id.tv_survey_check})
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int id = view.getId();
        if (id == R.id.tv_confirm) {
            ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO = this.b;
            if (longTimeControlLinkListDTO != null) {
                A4(longTimeControlLinkListDTO.getLongTimeControlLinkId(), 2);
                this.b = null;
            }
            finish();
            return;
        }
        if (id == R.id.tv_reactivate) {
            ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO2 = this.b;
            if (longTimeControlLinkListDTO2 != null) {
                A4(longTimeControlLinkListDTO2.getLongTimeControlLinkId(), 1);
                showDialog();
                this.a.i(this.b.getLongTimeControlLinkId());
                this.b = null;
                return;
            }
            return;
        }
        if (id == R.id.tv_survey_check && !TextUtils.isEmpty(this.c)) {
            if (this.c.startsWith("http://") || this.c.startsWith("https://")) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.c)));
                eg3.j(this, "show_survey_control_link", false);
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c83.R1().D1();
        setContentView(R.layout.control_link_end_activity);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        this.actionbar.setTitle(ah4.e(R.string.create_link_pop));
        this.actionbar.setImageBackAction(Integer.valueOf(R.drawable.nav_back), new b(), 8);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(FirebaseAnalytics.Param.CONTENT);
        String stringExtra2 = intent.getStringExtra("endType");
        String stringExtra3 = intent.getStringExtra("control_link_error_code");
        String stringExtra4 = intent.getStringExtra("linkId");
        boolean booleanExtra = intent.getBooleanExtra("isBanned", false);
        boolean booleanExtra2 = intent.getBooleanExtra("fromHttpDisable", false);
        final NewDpgEventConfigBean newDpgEventConfigBean = (NewDpgEventConfigBean) intent.getSerializableExtra("dpgEventConfigBean");
        boolean z = WearUtils.D;
        if (newDpgEventConfigBean == null || z) {
            this.adRly.setVisibility(8);
        } else if (!eg3.d(this, "sp_is_close", false) || TextUtils.equals(newDpgEventConfigBean.getData().getEventType(), "tophy")) {
            this.adRly.setVisibility(0);
            if (TextUtils.equals(newDpgEventConfigBean.getData().getEventType(), "tophy")) {
                this.closeIv.setVisibility(8);
            } else {
                this.closeIv.setVisibility(0);
                this.closeIv.bringToFront();
            }
            int iE = gg3.e(this) - de3.a(this, 15.0f);
            try {
                if (getIntent().getParcelableExtra("bitmap") != null) {
                    kf.z(this).j().D0(v4(getIntent().getByteArrayExtra("bitmap"), null)).x0(new c(this.dpgIv, iE));
                } else {
                    kf.z(this).j().J0(newDpgEventConfigBean.getData().getAppEventImgUrl()).x0(new d(this.dpgIv, iE));
                }
                C4(newDpgEventConfigBean, "M0058");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.dpgIv.setOnClickListener(new View.OnClickListener() { // from class: dc.x73
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    this.a.x4(newDpgEventConfigBean, view);
                }
            });
            this.closeIv.setOnClickListener(new View.OnClickListener() { // from class: dc.y73
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    this.a.z4(view);
                }
            });
        } else {
            this.adRly.setVisibility(8);
        }
        if (booleanExtra) {
            this.tv_title.setText(ah4.e(R.string.link_auto_end_title));
        }
        this.tv_content.setText(stringExtra);
        this.parentHandler.postDelayed(new e(), 1000L);
        if (eg3.d(this, "show_survey_control_link", true)) {
            this.a.h("CONTROL_LINK");
        }
        if (TextUtils.isEmpty(stringExtra4)) {
            this.repeatText.setVisibility(8);
        } else {
            List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO> listK = l22.n().k();
            for (int i = 0; i < listK.size(); i++) {
                if (TextUtils.equals(listK.get(i).getLastActiveSessionId(), stringExtra4)) {
                    this.b = listK.get(i);
                }
            }
        }
        ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO = this.b;
        if (longTimeControlLinkListDTO != null) {
            this.repeatText.setVisibility(longTimeControlLinkListDTO.getRepeat().booleanValue() ? 0 : 8);
        } else {
            this.repeatText.setVisibility(8);
        }
        if (c83.R1().d2() || booleanExtra2) {
            this.tvReactivate.setVisibility(8);
            this.repeatText.setVisibility(8);
        } else {
            this.e.start();
            if (c83.R1().e2()) {
                this.tvReactivate.setVisibility(8);
            } else {
                this.tvReactivate.setVisibility(0);
            }
        }
        if (TextUtils.isEmpty(stringExtra3)) {
            if (booleanExtra2) {
                this.mIvEndImage.setImageResource(R.drawable.img_failed);
                this.tv_content.setText(ah4.e(R.string.banned_opening_link_des));
            }
            if (TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            String str = l22.n().l() > 2 ? "2" : "1";
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            ku1.a("Control Link", "control_link_closed_page_exposure", "exposure", stringExtra4, "1", str, null, null);
        } else {
            B4(stringExtra3);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.tv_confirm.getLayoutParams();
        if (this.tvReactivate.getVisibility() == 0) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = de3.a(this, 155.0f);
            this.tv_confirm.setLayoutParams(layoutParams);
            this.tv_confirm.requestLayout();
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = de3.a(this, 200.0f);
            this.tv_confirm.setLayoutParams(layoutParams);
            this.tv_confirm.requestLayout();
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        RefreshControlLinkList refreshControlLinkList = new RefreshControlLinkList();
        refreshControlLinkList.setRefreshControl(true);
        EventBus.getDefault().post(refreshControlLinkList);
        l22.n().y(0);
        this.e.cancel();
        super.onDestroy();
    }

    @Override // dc.xo2
    public void onError(String str) {
        sg3.l(ah4.e(R.string.toast_reactivation_failed));
        if (this.d) {
            finish();
        }
        dissDialog();
    }

    public final void u4(String str, String str2) {
        ku1.a("Control Link", "control_link_closed_page_exposure", "exposure", str, str2, "", null, null);
    }
}
