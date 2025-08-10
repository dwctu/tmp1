package com.wear.main.longDistance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.adapter.longdistance.DragEmojisAdapter;
import com.wear.dao.DaoUtils;
import com.wear.phonertc.RequestPermissionActivity;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.draggridview.DragGridView;
import dc.ah4;
import dc.bo3;
import dc.he3;
import dc.kn3;
import dc.q61;
import dc.qe3;
import dc.sg3;
import dc.u51;
import dc.vg3;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes3.dex */
public class EmojisManagerActivity extends BaseActivity {
    public he3.f a;
    public MyActionBar b;
    public RelativeLayout c;
    public TextView d;
    public TextView e;
    public TextView f;
    public DragGridView g;
    public DragEmojisAdapter h;
    public he3 i;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EmojisManagerActivity.this.C4();
            sg3.i(EmojisManagerActivity.this, R.string.comman_save_failed);
        }
    }

    public class b implements MyActionBar.f {
        public b() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (EmojisManagerActivity.this.h.f()) {
                EmojisManagerActivity.this.G4();
            } else {
                EmojisManagerActivity.this.F4();
            }
        }
    }

    public class c implements MyActionBar.f {
        public c() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            if (EmojisManagerActivity.this.h.f()) {
                EmojisManagerActivity.this.G4();
            } else {
                EmojisManagerActivity.this.onBackPressed();
            }
        }
    }

    public class d implements DragGridView.b {
        public d() {
        }

        @Override // com.wear.widget.draggridview.DragGridView.b
        public void a(int i, int i2) {
            if (i == i2) {
                EmojisManagerActivity.this.h.notifyDataSetChanged();
                return;
            }
            if (i < i2) {
                while (i < i2) {
                    int i3 = i + 1;
                    Collections.swap(WearUtils.E, i, i3);
                    i = i3;
                }
            } else if (i > i2) {
                while (i > i2) {
                    Collections.swap(WearUtils.E, i, i - 1);
                    i--;
                }
            }
            EmojisManagerActivity.this.h.notifyDataSetChanged();
        }

        @Override // com.wear.widget.draggridview.DragGridView.b
        public boolean b(int i) {
            if (i == 0 || !EmojisManagerActivity.this.h.f()) {
            }
            return false;
        }
    }

    public class e implements he3.f {

        public class a implements he3.f {

            /* renamed from: com.wear.main.longDistance.EmojisManagerActivity$e$a$a, reason: collision with other inner class name */
            public class RunnableC0117a implements Runnable {
                public RunnableC0117a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    EmojisManagerActivity.this.C4();
                    EmojisManagerActivity.this.I4();
                    EmojisManagerActivity.this.h.b();
                    EmojisManagerActivity.this.f.setText(String.format(ah4.e(R.string.favorite_emojis_delete_notic), String.valueOf(EmojisManagerActivity.this.h.d().size())));
                    EmojisManagerActivity.this.h.notifyDataSetChanged();
                }
            }

            public a() {
            }

            @Override // dc.he3.f
            public void a(Map map) {
                EmojisManagerActivity.this.runOnUiThread(new RunnableC0117a());
            }
        }

        public e() {
        }

        @Override // dc.he3.f
        public void a(Map map) {
            he3.f(new a());
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            List<String> listD = EmojisManagerActivity.this.h.d();
            if (listD == null || listD.size() <= 0) {
                return;
            }
            Iterator<String> it = listD.iterator();
            String strSubstring = "";
            while (it.hasNext()) {
                strSubstring = strSubstring + it.next() + ",";
            }
            if (strSubstring.endsWith(",")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            if (WearUtils.e1(strSubstring)) {
                return;
            }
            EmojisManagerActivity.this.C4();
            if (view.getId() == R.id.emojis_move) {
                EmojisManagerActivity.this.showLoadingProgress();
                EmojisManagerActivity.this.i.h(strSubstring, EmojisManagerActivity.this.a);
            } else if (view.getId() == R.id.emojis_delete) {
                EmojisManagerActivity.this.H4(String.format(ah4.e(R.string.favorite_dialog_delete), new Object[0]), strSubstring);
            }
        }
    }

    public class g implements bo3.d {
        public final /* synthetic */ String a;

        public g(String str) {
            this.a = str;
        }

        @Override // dc.bo3.d
        public void a(int i) {
            EmojisManagerActivity.this.showLoadingProgress();
            EmojisManagerActivity.this.i.d(this.a, EmojisManagerActivity.this.a);
            DaoUtils.getEmojiFavoriteDao().removeEmojiFavorites(EmojisManagerActivity.this.h.c());
        }
    }

    public class h implements u51 {

        public class a implements kn3.d {
            public a() {
            }

            @Override // dc.kn3.d
            public void doCancel() {
            }

            @Override // dc.kn3.d
            public void doConfirm() {
                RequestPermissionActivity.s4(EmojisManagerActivity.this);
            }
        }

        public h() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            if (z) {
                new kn3((Context) EmojisManagerActivity.this, ah4.e(R.string.app_open_must_permission), ah4.e(R.string.common_confirm), ah4.e(R.string.common_cancel), true, (kn3.d) new a()).show();
            }
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            if (z) {
                EmojisManagerActivity.this.B4();
            }
        }
    }

    public class i implements MyActionBar.f {
        public i() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            EmojisManagerActivity.this.onBackPressed();
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ Uri a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                EmojisManagerActivity.this.C4();
            }
        }

        public j(Uri uri) {
            this.a = uri;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                EmojisManagerActivity.this.i.c(new File(qe3.i(EmojisManagerActivity.this, this.a)), "", EmojisManagerActivity.this.a);
            } catch (Exception unused) {
                EmojisManagerActivity.this.runOnUiThread(new a());
            }
        }
    }

    public final void B4() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        intent.putExtra("return-data", false);
        startActivityForResult(intent, 24);
    }

    public final void C4() {
        dismissLoadingProgress();
    }

    public void D4(View view, int i2) {
        Object tag = view.getTag(R.id.imageview_favorite_image);
        if (tag == null || WearUtils.e1(tag.toString())) {
            return;
        }
        if (tag.toString().equals(he3.a)) {
            if (WearUtils.E.size() >= 81) {
                sg3.i(this, R.string.add_favorite_faile_maxcount);
                return;
            } else {
                E4();
                return;
            }
        }
        if (this.h.f()) {
            this.h.getItem(i2).setChoose(!r4.isChoose());
            this.f.setText(String.format(ah4.e(R.string.favorite_emojis_delete_notic), String.valueOf(this.h.d().size())));
        }
    }

    @SuppressLint({"CheckResult"})
    public final void E4() {
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.READ_MEDIA_IMAGES");
        q61VarM.j(new h());
    }

    public final void F4() {
        this.b.setYesActionText(R.string.common_cancel);
        this.h.g(true);
        this.h.notifyDataSetChanged();
        this.f.setText(String.format(ah4.e(R.string.favorite_emojis_delete_notic), String.valueOf(this.h.d().size())));
        this.c.setVisibility(0);
        this.b.setBackVisibility(8);
    }

    public final void G4() {
        this.b.setYesActionText(R.string.common_manage);
        this.h.g(false);
        this.h.notifyDataSetChanged();
        this.c.setVisibility(8);
        this.b.setBackAction(new i());
        this.b.setBackVisibility(0);
    }

    public final void H4(String str, String str2) {
        bo3 bo3Var = new bo3(this, R.layout.bottom_sheet_chat_picture);
        bo3Var.show();
        bo3Var.d(R.id.touch_delete, new g(str2));
        ((TextView) bo3Var.a(R.id.tv_notice)).setText(str);
        bo3Var.d(R.id.touch_cancel, null);
    }

    public final void I4() {
        this.e.setText(String.format(ah4.e(R.string.favorite_emojis_total_notic), "" + (WearUtils.E.size() - 1)));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 24 && intent != null) {
            try {
                if (intent.getData() != null) {
                    Uri data = intent.getData();
                    long jM0 = WearUtils.M0(getContentResolver().openInputStream(data));
                    System.out.println("fileSize:" + jM0 + " availMemory:" + WearUtils.J(this));
                    if (jM0 >= 1048576) {
                        sg3.i(this, R.string.add_favorite_faile_maxzie);
                    } else if (jM0 >= WearUtils.J(this)) {
                        sg3.i(this, R.string.add_favorite_faile_availmemory);
                    } else {
                        try {
                            if (BitmapFactory.decodeStream(getContentResolver().openInputStream(data), null, new BitmapFactory.Options()) != null) {
                                showLoadingProgress();
                                vg3.b().a(new j(data));
                            }
                        } catch (Exception unused) {
                            runOnUiThread(new a());
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(-1);
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.long_emojis_manager_layout);
        this.i = new he3();
        MyActionBar myActionBar = (MyActionBar) findViewById(R.id.actionbar);
        this.b = myActionBar;
        myActionBar.setYesAction(R.string.common_manage, new b());
        this.b.setBackAction(new c());
        this.g = (DragGridView) findViewById(R.id.drag_grid_view);
        this.c = (RelativeLayout) findViewById(R.id.bottom_action_layout);
        this.d = (TextView) findViewById(R.id.emojis_move);
        this.e = (TextView) findViewById(R.id.emojis_total);
        this.f = (TextView) findViewById(R.id.emojis_delete);
        this.c.setVisibility(8);
        DragEmojisAdapter dragEmojisAdapter = new DragEmojisAdapter(this);
        this.h = dragEmojisAdapter;
        this.g.setAdapter((ListAdapter) dragEmojisAdapter);
        this.g.setOnChangeListener(new d());
        this.a = new e();
        f fVar = new f();
        this.d.setOnClickListener(fVar);
        this.f.setOnClickListener(fVar);
        I4();
        EventBus.getDefault().register(this);
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
