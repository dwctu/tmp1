package com.wear.main.longDistance.report;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.main.longDistance.ChatHistorySelectActivity;
import com.wear.main.longDistance.report.BigPictureAdapter;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.gn2;
import dc.kf;
import dc.lp2;
import dc.nd3;
import dc.pj3;
import dc.sg3;
import dc.ue3;
import dc.w83;
import dc.x83;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ReportActivity extends BaseActivity<gn2> implements lp2 {
    public gn2 a;
    public ConstraintLayout c;
    public ConstraintLayout d;
    public ConstraintLayout e;
    public ConstraintLayout f;
    public EditText g;
    public TextView i;
    public TextView j;
    public String t;
    public int b = 0;
    public int h = 0;
    public String[] k = new String[4];
    public String l = "";
    public String m = "";
    public String n = "";
    public String o = "";
    public String p = "";
    public String q = "";
    public String s = "";

    @SuppressLint({"HandlerLeak"})
    public Handler u = new a();

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            ReportActivity.this.P4();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bitmap bitmapC2 = WearUtils.c2(ReportActivity.this.s);
                File fileG2 = bitmapC2 != null ? WearUtils.g2(bitmapC2, System.currentTimeMillis() + ".png") : null;
                String str = "转成的File======" + fileG2;
                if (!TextUtils.isEmpty(fileG2.toString())) {
                    ReportActivity.this.k[0] = fileG2.toString();
                    ReportActivity.this.b = 1;
                }
                Message message = new Message();
                message.what = 0;
                ReportActivity.this.u.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements TextWatcher {
        public final /* synthetic */ TextView a;

        public c(ReportActivity reportActivity, TextView textView) {
            this.a = textView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.setText(String.format("%d/300", Integer.valueOf(charSequence.length())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C4(int i, View view) {
        int i2 = 0;
        boolean z = false;
        while (true) {
            String[] strArr = this.k;
            if (i2 >= strArr.length) {
                this.b--;
                P4();
                return;
            }
            if (i2 == i || z) {
                if (i2 != strArr.length - 1) {
                    int i3 = i2 + 1;
                    strArr[i2] = strArr[i3];
                    strArr[i3] = null;
                } else {
                    strArr[i2] = null;
                }
                z = true;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E4(View view) {
        if (!WearUtils.e1(this.m) && !WearUtils.e1(this.n)) {
            Bundle bundle = new Bundle();
            bundle.putString("roomId", this.n);
            bundle.putInt(ChatHistorySelectActivity.P, 1);
            pj3.p(this, ChatHistorySelectActivity.class, 51, bundle);
            return;
        }
        if (!WearUtils.e1(this.m)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("userId", this.m);
            bundle2.putInt(ChatHistorySelectActivity.P, 0);
            pj3.p(this, ChatHistorySelectActivity.class, 51, bundle2);
            return;
        }
        if (WearUtils.e1(this.n)) {
            return;
        }
        Bundle bundle3 = new Bundle();
        bundle3.putString("roomId", this.n);
        bundle3.putInt(ChatHistorySelectActivity.P, 1);
        pj3.p(this, ChatHistorySelectActivity.class, 51, bundle3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G4(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I4(View view) {
        if (this.g.getText().toString().length() < 15) {
            N4(getString(R.string.help_feedback_content_error));
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            String[] strArr = this.k;
            if (i < strArr.length) {
                if (strArr[i] != null && !strArr[i].isEmpty()) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (!z) {
            N4(getString(R.string.notification_no_image));
            return;
        }
        showDialog();
        if (WearUtils.e1(this.n) || !WearUtils.e1(this.m)) {
            this.a.r(this.k);
        } else {
            this.a.q(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K4(View view) {
        x83.b().g("标题").i(false).j(true).k(false).a(false).h(false).e(4 - this.b).f(false).c(new w83()).l(this, 23, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A4(int i, View view) {
        O4(i);
    }

    @Override // dc.lp2
    public void B1(String str) {
        String string = this.g.getText().toString();
        String str2 = this.m;
        if (str2 != null && !str2.isEmpty()) {
            this.a.p(WearUtils.i0(this.m), this.l, this.o, str, this.t, string);
        } else {
            if (WearUtils.e1(this.n) || !WearUtils.e1(this.m)) {
                return;
            }
            this.a.o(this.p, this.q, this.n, this.l, this.o, str, this.t, string);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void L4(View view) {
        view.findViewById(R.id.picture_display_layout).setVisibility(4);
        View viewFindViewById = view.findViewById(R.id.add_picture_layout);
        TextView textView = (TextView) view.findViewById(R.id.image_add_text);
        if (this.b != 0) {
            textView.setText(this.b + "/4");
        }
        viewFindViewById.setVisibility(0);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: dc.mc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.K4(view2);
            }
        });
    }

    public final void M4(View view) {
        view.findViewById(R.id.picture_display_layout).setVisibility(4);
        view.findViewById(R.id.add_picture_layout).setVisibility(4);
    }

    public final void N4(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = getLayoutInflater().inflate(R.layout.error_message_dialog_layout, (ViewGroup) null);
        builder.setView(viewInflate);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.color.transparent);
        ((TextView) viewInflate.findViewById(R.id.text_view)).setText(str);
        builder.setCancelable(true);
        alertDialogCreate.show();
    }

    public final void O4(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = getLayoutInflater().inflate(R.layout.dialig_big_picture, (ViewGroup) null);
        builder.setView(viewInflate);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getWindow().setBackgroundDrawableResource(R.color.transparent);
        ArrayList arrayList = new ArrayList();
        for (String str : this.k) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        ViewPager2 viewPager2 = (ViewPager2) viewInflate.findViewById(R.id.image_list);
        BigPictureAdapter bigPictureAdapter = new BigPictureAdapter(strArr);
        viewPager2.setAdapter(bigPictureAdapter);
        Objects.requireNonNull(alertDialogCreate);
        bigPictureAdapter.o(new BigPictureAdapter.a() { // from class: dc.uc2
            @Override // com.wear.main.longDistance.report.BigPictureAdapter.a
            public final void a() {
                alertDialogCreate.dismiss();
            }
        });
        viewPager2.setCurrentItem(i, false);
        builder.setCancelable(true);
        alertDialogCreate.show();
    }

    public final void P4() {
        int i = this.b;
        if (i == 0) {
            L4(this.c);
            M4(this.d);
            M4(this.e);
            M4(this.f);
            return;
        }
        if (i == 1) {
            x4(this.c, 0);
            L4(this.d);
            M4(this.e);
            M4(this.f);
            return;
        }
        if (i == 2) {
            x4(this.c, 0);
            x4(this.d, 1);
            L4(this.e);
            M4(this.f);
            return;
        }
        if (i == 3) {
            x4(this.c, 0);
            x4(this.d, 1);
            x4(this.e, 2);
            L4(this.f);
            return;
        }
        if (i == 4) {
            x4(this.c, 0);
            x4(this.d, 1);
            x4(this.e, 2);
            x4(this.f, 3);
        }
    }

    @Override // dc.lp2
    public void R3() {
        dissDialog();
        pj3.f(this, ResultActivity.class);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return getWindow().superDispatchTouchEvent(motionEvent) || onTouchEvent(motionEvent);
        }
        if (y4(getCurrentFocus(), motionEvent) && ((InputMethodManager) getSystemService("input_method")) != null) {
            ue3.a(this.g, this);
            EditText editText = this.g;
            if (editText != null) {
                editText.clearFocus();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.wear.BaseActivity
    public void initInject() {
        super.initInject();
        this.mActivityComponent.t(this);
        this.mPresenter = this.a;
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 23 || i2 != -1 || intent == null) {
            if (i == 51 && i2 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra("result");
                this.t = stringExtra;
                this.t = nd3.w(stringExtra);
                this.h = intent.getIntExtra("number", 0);
                this.i.setText(String.format(ah4.e(R.string.report_message_selected), this.h + ""));
                String str = " onActivityResult ChatHistory_Result =  " + this.t;
                return;
            }
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("selectMediaFile");
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            MediaFile mediaFile = (MediaFile) it.next();
            int i3 = 0;
            while (true) {
                String[] strArr = this.k;
                if (i3 >= strArr.length) {
                    break;
                }
                if (strArr[i3] == null || strArr[i3].isEmpty()) {
                    break;
                } else {
                    i3++;
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.k[i3] = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, mediaFile.e()).toString();
            } else {
                String strF = mediaFile.f();
                String str2 = "相册选择的路径======" + strF;
                this.k[i3] = strF;
            }
        }
        this.b += parcelableArrayListExtra.size();
        P4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_report);
        WearUtils.F.add(this);
        this.m = getIntent().getStringExtra("user_id");
        this.s = getIntent().getStringExtra("user_img");
        this.n = getIntent().getStringExtra(FirebaseAnalytics.Param.GROUP_ID);
        this.p = getIntent().getStringExtra("group_name");
        this.q = getIntent().getStringExtra("group_owner");
        this.l = getIntent().getStringExtra("reason_key");
        this.o = getIntent().getStringExtra("other_reasul_key");
        ((ConstraintLayout) findViewById(R.id.select_chat_history)).setOnClickListener(new View.OnClickListener() { // from class: dc.oc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.E4(view);
            }
        });
        findViewById(R.id.nv_back).setOnClickListener(new View.OnClickListener() { // from class: dc.kc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.G4(view);
            }
        });
        this.i = (TextView) findViewById(R.id.selected_title);
        this.i.setText(String.format(ah4.e(R.string.report_message_selected), this.h + ""));
        this.j = (TextView) findViewById(R.id.save_btn);
        this.c = (ConstraintLayout) findViewById(R.id.selected_picture1);
        this.d = (ConstraintLayout) findViewById(R.id.selected_picture2);
        this.e = (ConstraintLayout) findViewById(R.id.selected_picture3);
        this.f = (ConstraintLayout) findViewById(R.id.selected_picture4);
        if (TextUtils.isEmpty(this.s)) {
            P4();
        } else {
            if (!this.s.startsWith("http")) {
                this.s = WearUtils.e + this.s;
            }
            String str = "传过来的路径======" + this.s;
            new Thread(new b()).start();
        }
        this.g = (EditText) findViewById(R.id.edit_description);
        TextView textView = (TextView) findViewById(R.id.length_content);
        textView.setText("0/300");
        this.g.addTextChangedListener(new c(this, textView));
        this.j.setOnClickListener(new View.OnClickListener() { // from class: dc.nc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.I4(view);
            }
        });
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WearUtils.F.remove(this);
        WearUtils.L.clear();
        this.u.removeCallbacksAndMessages(null);
    }

    @Override // com.wear.BaseActivity, dc.ul2
    public void showErrorMsg(String str, boolean z) {
        dissDialog();
        sg3.l(str);
    }

    public final void x4(View view, final int i) {
        view.findViewById(R.id.add_picture_layout).setVisibility(4);
        View viewFindViewById = view.findViewById(R.id.picture_display_layout);
        viewFindViewById.setVisibility(0);
        if (TextUtils.isEmpty(this.s) || i != 0) {
            viewFindViewById.findViewById(R.id.clean_btn).setVisibility(0);
        } else {
            viewFindViewById.findViewById(R.id.clean_btn).setVisibility(8);
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: dc.pc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.A4(i, view2);
            }
        });
        ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.image_display_view);
        Uri uriFromFile = Build.VERSION.SDK_INT >= 29 ? Uri.parse(this.k[i]) : Uri.fromFile(new File(this.k[i]));
        if (!isDestroyed()) {
            if (TextUtils.isEmpty(this.s) || i != 0) {
                kf.z(this).r(uriFromFile).A0(imageView);
            } else {
                kf.z(this).v(this.s).A0(imageView);
            }
        }
        viewFindViewById.findViewById(R.id.clean_btn).setOnClickListener(new View.OnClickListener() { // from class: dc.lc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.C4(i, view2);
            }
        });
    }

    public boolean y4(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) (view.getWidth() + i)) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) (view.getHeight() + i2));
    }
}
