package com.wear.ui.longDistance.imagepicker.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.ui.longDistance.imagepicker.adapter.ImageFoldersAdapter;
import com.wear.ui.longDistance.imagepicker.adapter.ImagePickerAdapter;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.ui.longDistance.imagepicker.provider.ImagePickerProvider;
import com.wear.util.WearUtils;
import dc.a93;
import dc.eg3;
import dc.f93;
import dc.g93;
import dc.h93;
import dc.i93;
import dc.j93;
import dc.k93;
import dc.ke3;
import dc.kg3;
import dc.m93;
import dc.p93;
import dc.q61;
import dc.sg3;
import dc.u51;
import dc.ur3;
import dc.y83;
import dc.ye3;
import dc.z83;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class ImagePickerActivity extends BaseActivity implements ImagePickerAdapter.f, ImageFoldersAdapter.b {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public TextView f;
    public TextView g;
    public TextView h;
    public LinearLayout i;
    public RecyclerView j;
    public TextView k;
    public p93 l;
    public ProgressDialog m;
    public RelativeLayout n;
    public LinearLayout o;
    public ImageView p;
    public GridLayoutManager q;
    public ImagePickerAdapter s;
    public List<MediaFile> t;
    public List<y83> u;
    public int v;
    public boolean w;
    public boolean x;
    public String y;

    public class a implements u51 {
        public a() {
        }

        @Override // dc.u51
        public void a(List<String> list, boolean z) {
            sg3.l(ImagePickerActivity.this.getString(R.string.app_open_must_permission));
            ImagePickerActivity.this.finish();
        }

        @Override // dc.u51
        public void b(List<String> list, boolean z) {
            ImagePickerActivity.this.Q4();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            int[] iArr = new int[2];
            ImagePickerActivity.this.p.getLocationOnScreen(iArr);
            iArr[1] = (iArr[1] + ImagePickerActivity.this.p.getHeight()) - kg3.a(ImagePickerActivity.this);
            new ur3(ImagePickerActivity.this, iArr).show();
            eg3.j(ImagePickerActivity.this, "burn_after_reading_tip", false);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePickerActivity.this.setResult(0);
            ImagePickerActivity.this.finish();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList = new ArrayList();
            LinkedHashMap<String, MediaFile> linkedHashMapF = g93.c().f();
            Iterator<String> it = linkedHashMapF.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(linkedHashMapF.get(it.next()));
            }
            k93.a().e(arrayList);
            ImagePickerActivity.this.K4(0);
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePickerActivity.this.x = !r2.x;
            ImagePickerActivity.this.p.setImageResource(ImagePickerActivity.this.x ? R.drawable.chat_burn_choose_select : R.drawable.chat_burn_choose_unselect);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePickerActivity.this.I4();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImagePickerActivity.this.l != null) {
                ImagePickerActivity.this.O4(0);
                ImagePickerActivity.this.l.showAsDropDown(ImagePickerActivity.this.n, 0, 0);
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ImagePickerActivity.this.l != null) {
                ImagePickerActivity.this.O4(0);
                ImagePickerActivity.this.l.showAsDropDown(ImagePickerActivity.this.n, 0, 0);
            }
        }
    }

    public class i extends RecyclerView.OnScrollListener {
        public i(ImagePickerActivity imagePickerActivity) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    }

    public class j implements a93 {

        public class a implements Runnable {
            public final /* synthetic */ List a;

            /* renamed from: com.wear.ui.longDistance.imagepicker.ui.ImagePickerActivity$j$a$a, reason: collision with other inner class name */
            public class C0152a implements PopupWindow.OnDismissListener {
                public C0152a() {
                }

                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ImagePickerActivity.this.O4(1);
                }
            }

            public a(List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!this.a.isEmpty()) {
                    ImagePickerActivity.this.t.addAll(((y83) this.a.get(0)).d());
                    ImagePickerActivity.this.s.notifyDataSetChanged();
                    ImagePickerActivity.this.u = new ArrayList(this.a);
                    ImagePickerActivity imagePickerActivity = ImagePickerActivity.this;
                    ImagePickerActivity imagePickerActivity2 = ImagePickerActivity.this;
                    imagePickerActivity.l = new p93(imagePickerActivity2, imagePickerActivity2.u);
                    ImagePickerActivity.this.l.a().p(ImagePickerActivity.this);
                    ImagePickerActivity.this.l.setOnDismissListener(new C0152a());
                    ImagePickerActivity.this.R4();
                }
                if (ImagePickerActivity.this.isFinishing() || ImagePickerActivity.this.isDestroyed()) {
                    return;
                }
                ImagePickerActivity.this.m.cancel();
            }
        }

        public j() {
        }

        @Override // dc.a93
        public void a(List<y83> list) {
            ImagePickerActivity.this.runOnUiThread(new a(list));
        }
    }

    public ImagePickerActivity() {
        new Handler();
    }

    public final void I4() {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap<String, MediaFile> linkedHashMapF = g93.c().f();
        Iterator<String> it = linkedHashMapF.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(linkedHashMapF.get(it.next()));
        }
        ArrayList<String> arrayList2 = new ArrayList<>(g93.c().e());
        ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>(arrayList);
        if (this.x) {
            HashMap map = new HashMap();
            map.put("chat_type", Integer.valueOf(this.v));
            Iterator<String> it2 = arrayList2.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it2.hasNext()) {
                if (m93.d(it2.next())) {
                    z2 = true;
                } else {
                    z = true;
                }
                if (z && z2) {
                    break;
                }
            }
            if (z2) {
                map.put("type", 2);
                ye3.e("M0018", map);
            }
            if (z) {
                map.put("type", 1);
                ye3.e("M0018", map);
            }
        }
        Intent intent = new Intent();
        intent.putStringArrayListExtra("selectItems", arrayList2);
        intent.putParcelableArrayListExtra("selectMediaFile", arrayList3);
        intent.putExtra("isBurnAfterReading", this.x);
        setResult(-1, intent);
        finish();
    }

    public void J4() {
        String[] strArr = {"android.permission.CAMERA", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"};
        if (q61.f(this, strArr)) {
            Q4();
            return;
        }
        q61 q61VarM = q61.m(this);
        q61VarM.h(strArr);
        q61VarM.j(new a());
    }

    public final void K4(int i2) {
        Intent intent = new Intent(this, (Class<?>) ImagePreViewActivity.class);
        intent.putExtra("imagePosition", i2);
        startActivityForResult(intent, 1);
    }

    public void L4() {
        f93.b().d();
        this.a = f93.b().g();
        this.b = f93.b().h();
        this.c = f93.b().i();
        this.d = f93.b().j();
        this.e = f93.b().c();
        this.w = f93.b().f();
        g93.c().k(this.e);
    }

    public void M4() {
        findViewById(R.id.iv_actionBar_back).setOnClickListener(new c());
        this.g.setOnClickListener(new d());
        this.o.setOnClickListener(new e());
        this.f.setOnClickListener(new f());
        this.k.setOnClickListener(new g());
        this.i.setOnClickListener(new h());
        this.j.addOnScrollListener(new i(this));
    }

    public void N4() {
        this.m = ProgressDialog.show(this, null, getString(R.string.scanner_image));
        TextView textView = (TextView) findViewById(R.id.ac_imagepicker_tv_send);
        this.f = textView;
        textView.setAlpha(0.5f);
        TextView textView2 = (TextView) findViewById(R.id.ac_imagepicker_tv_preview);
        this.g = textView2;
        textView2.setAlpha(0.5f);
        this.i = (LinearLayout) findViewById(R.id.ll_main_imageFolders);
        this.h = (TextView) findViewById(R.id.tv_image_time);
        this.n = (RelativeLayout) findViewById(R.id.layout_actionBar);
        this.k = (TextView) findViewById(R.id.tv_main_imageFolders);
        this.o = (LinearLayout) findViewById(R.id.ll_burn_after_reading);
        this.p = (ImageView) findViewById(R.id.iv_burn_after_reading);
        this.o.setEnabled(true);
        if (this.w) {
            this.o.setVisibility(0);
            if (ke3.a("new_user", "burn_after_reading_tip")) {
                this.p.post(new b());
            }
        }
        this.j = (RecyclerView) findViewById(R.id.rv_main_images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        this.q = gridLayoutManager;
        this.j.setLayoutManager(gridLayoutManager);
        this.j.setHasFixedSize(true);
        this.j.setItemViewCacheSize(60);
        ArrayList arrayList = new ArrayList();
        this.t = arrayList;
        ImagePickerAdapter imagePickerAdapter = new ImagePickerAdapter(this, arrayList);
        this.s = imagePickerAdapter;
        imagePickerAdapter.q(this);
        this.j.setAdapter(this.s);
    }

    public final void O4(int i2) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (i2 == 0) {
            attributes.alpha = 0.7f;
        } else if (i2 == 1) {
            attributes.alpha = 1.0f;
        }
        getWindow().setAttributes(attributes);
    }

    public final void P4() {
        if (this.d) {
            ArrayList<String> arrayListE = g93.c().e();
            if (!arrayListE.isEmpty() && m93.d(arrayListE.get(0))) {
                sg3.l(getString(R.string.single_type_choose));
                return;
            }
        }
        this.y = WearUtils.c0(WearUtils.d0() + ".jpg").getAbsolutePath();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(this, ImagePickerProvider.a(this), new File(this.y)) : Uri.fromFile(new File(this.y)));
        startActivityForResult(intent, 2);
    }

    public final void Q4() {
        Runnable i93Var = (this.b && this.c) ? new i93(this, new j()) : null;
        if (!this.b && this.c) {
            i93Var = new j93(this, new j());
        }
        if (this.b && !this.c) {
            i93Var = new h93(this, new j());
        }
        if (i93Var == null) {
            i93Var = new i93(this, new j());
        }
        z83.b().a(i93Var);
    }

    public final void R4() {
        int size = g93.c().e().size();
        if (size == 0) {
            this.f.setEnabled(false);
            this.g.setEnabled(false);
            this.f.setText(getString(R.string.common_send));
            this.f.setAlpha(0.5f);
            this.g.setAlpha(0.5f);
            return;
        }
        int i2 = this.e;
        if (size < i2) {
            this.f.setEnabled(true);
            this.g.setEnabled(true);
            this.f.setText(String.format(getString(R.string.confirm_msg2), Integer.valueOf(size)));
            this.f.setAlpha(1.0f);
            this.g.setAlpha(1.0f);
            return;
        }
        if (size == i2) {
            this.f.setEnabled(true);
            this.g.setEnabled(true);
            this.f.setText(String.format(getString(R.string.confirm_msg2), Integer.valueOf(size)));
            this.f.setAlpha(1.0f);
            this.g.setAlpha(1.0f);
        }
    }

    @Override // com.wear.ui.longDistance.imagepicker.adapter.ImagePickerAdapter.f
    public void h3(View view, int i2) {
        boolean z = this.a;
        if (z && i2 == 0) {
            if (g93.c().h()) {
                P4();
                return;
            }
            return;
        }
        List<MediaFile> list = this.t;
        if (list != null) {
            String strF = list.get(z ? i2 - 1 : i2).f();
            if (TextUtils.isEmpty(strF) || !g93.c().i(strF)) {
                w2(view, i2);
                return;
            }
            ArrayList arrayList = new ArrayList();
            LinkedHashMap<String, MediaFile> linkedHashMapF = g93.c().f();
            Iterator<String> it = linkedHashMapF.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(linkedHashMapF.get(it.next()));
            }
            k93.a().e(arrayList);
            int i3 = 0;
            while (true) {
                if (i3 >= arrayList.size()) {
                    break;
                }
                if (strF.equals(((MediaFile) arrayList.get(i3)).f())) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                    i2 = 0;
                }
            }
            K4(i2);
        }
    }

    public final void init() {
        this.v = getIntent().getIntExtra("chatType", 1);
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1) {
            if (i2 == 2) {
                sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + this.y)));
                g93.c().a(this.y);
                ArrayList<String> arrayList = new ArrayList<>(g93.c().e());
                Intent intent2 = new Intent();
                intent2.putStringArrayListExtra("selectItems", arrayList);
                setResult(-1, intent2);
                g93.c().j();
                finish();
            }
            if (i2 == 1) {
                I4();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_imagepicker);
        ButterKnife.bind(this);
        init();
        L4();
        N4();
        M4();
        J4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        g93.c().j();
        try {
            f93.b().a().V();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 3) {
            if (iArr.length >= 1) {
                int i3 = iArr[0];
                int i4 = iArr[1];
                boolean z = i3 == 0;
                boolean z2 = i4 == 0;
                if (z && z2) {
                    Q4();
                } else {
                    sg3.l(getString(R.string.app_open_must_permission));
                    finish();
                }
            }
        }
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.s.notifyDataSetChanged();
        R4();
    }

    @Override // com.wear.ui.longDistance.imagepicker.adapter.ImageFoldersAdapter.b
    public void u2(View view, int i2) {
        y83 y83Var = this.u.get(i2);
        String strC = y83Var.c();
        if (!TextUtils.isEmpty(strC)) {
            this.k.setText(strC);
        }
        this.t.clear();
        this.t.addAll(y83Var.d());
        this.s.notifyDataSetChanged();
        this.l.dismiss();
    }

    @Override // com.wear.ui.longDistance.imagepicker.adapter.ImagePickerAdapter.f
    public void w2(View view, int i2) {
        if (this.a && i2 == 0) {
            if (!g93.c().h()) {
                return;
            } else {
                P4();
            }
        }
        MediaFile mediaFile = this.t.get(this.a ? i2 - 1 : i2);
        if (mediaFile.b() > 90000) {
            sg3.k(this, getString(R.string.video_limit_notification2));
            return;
        }
        if (mediaFile != null) {
            String strF = mediaFile.f();
            if (this.d) {
                ArrayList<String> arrayListE = g93.c().e();
                if (!arrayListE.isEmpty() && !g93.g(strF, arrayListE.get(0))) {
                    sg3.l(getString(R.string.single_type_choose));
                    return;
                }
            }
            if (g93.c().b(strF, mediaFile)) {
                if (g93.c().e().size() == f93.b().c() || g93.c().e().size() == f93.b().c() - 1) {
                    this.s.notifyDataSetChanged();
                } else {
                    this.s.notifyItemChanged(i2);
                }
            }
        }
        R4();
    }
}
