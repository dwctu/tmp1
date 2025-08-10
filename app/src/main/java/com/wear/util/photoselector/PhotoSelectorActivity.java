package com.wear.util.photoselector;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.wear.util.clipImage.ClipImageActivity;
import com.wear.util.photoselector.PhotoItem;
import dc.lj3;
import dc.nj3;
import dc.oj3;
import dc.pj3;
import dc.rj3;
import dc.sj3;
import dc.tj3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class PhotoSelectorActivity extends Activity implements PhotoItem.b, AdapterView.OnItemClickListener, View.OnClickListener {
    public GridView a;
    public ListView b;
    public TextView c;
    public TextView d;
    public tj3 e;
    public sj3 f;
    public lj3 g;
    public RelativeLayout h;
    public c i = new a();
    public d j = new b();

    public class a implements c {
        public a() {
        }

        @Override // com.wear.util.photoselector.PhotoSelectorActivity.c
        public void a(List<nj3> list) {
            PhotoSelectorActivity.this.g.a(list);
        }
    }

    public class b implements d {
        public b() {
        }

        @Override // com.wear.util.photoselector.PhotoSelectorActivity.d
        public void a(List<rj3> list) {
            if (PhotoSelectorActivity.this.c.getText().equals("最近照片")) {
                list.add(0, new rj3());
            }
            PhotoSelectorActivity.this.f.a(list);
            PhotoSelectorActivity.this.a.smoothScrollToPosition(0);
        }
    }

    public interface c {
        void a(List<nj3> list);
    }

    public interface d {
        void a(List<rj3> list);
    }

    @Override // com.wear.util.photoselector.PhotoItem.b
    public void a(String str) {
        pj3.j(this, ClipImageActivity.class, "path", str);
        finish();
    }

    public final void f() {
        if (this.h.getVisibility() == 8) {
            i();
        } else {
            h();
        }
    }

    public final void g() {
        pj3.n(this, new Intent("android.media.action.IMAGE_CAPTURE"), 1);
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    public final void h() {
        oj3 oj3Var = new oj3(getApplicationContext(), R.anim.translate_down);
        oj3Var.a();
        oj3Var.b(this.h);
        this.h.setVisibility(8);
    }

    public final void i() {
        this.h.setVisibility(0);
        oj3 oj3Var = new oj3(getApplicationContext(), R.anim.translate_up_current);
        oj3Var.a();
        oj3Var.b(this.h);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            a(new rj3(pj3.x(getApplicationContext(), intent.getData())).a());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.h.getVisibility() == 0) {
            h();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_album_ar) {
            f();
        } else if (view.getId() == R.id.tv_camera_vc) {
            g();
        } else if (view.getId() == R.id.bv_back_lh) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.account_photoselector);
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(new DisplayImageOptions.Builder().considerExifParams(true).resetViewBeforeLoading(true).showImageOnLoading(R.drawable.ic_picture_loading).showImageOnFail(R.drawable.ic_picture_loadfailed).delayBeforeLoading(0).build()).memoryCacheExtraOptions(480, 800).threadPoolSize(5).build());
        this.e = new tj3(getApplicationContext());
        this.d = (TextView) findViewById(R.id.tv_title_lh);
        this.a = (GridView) findViewById(R.id.gv_photos_ar);
        this.b = (ListView) findViewById(R.id.lv_ablum_ar);
        this.c = (TextView) findViewById(R.id.tv_album_ar);
        this.h = (RelativeLayout) findViewById(R.id.layout_album_ar);
        this.c.setOnClickListener(this);
        sj3 sj3Var = new sj3(getApplicationContext(), new ArrayList(), pj3.c(this), this, this);
        this.f = sj3Var;
        this.a.setAdapter((ListAdapter) sj3Var);
        lj3 lj3Var = new lj3(getApplicationContext(), new ArrayList());
        this.g = lj3Var;
        this.b.setAdapter((ListAdapter) lj3Var);
        this.b.setOnItemClickListener(this);
        findViewById(R.id.bv_back_lh).setOnClickListener(this);
        this.e.c(this.j);
        this.e.d(this.i);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        nj3 nj3Var = (nj3) adapterView.getItemAtPosition(i);
        for (int i2 = 0; i2 < adapterView.getCount(); i2++) {
            nj3 nj3Var2 = (nj3) adapterView.getItemAtPosition(i2);
            if (i2 == i) {
                nj3Var2.f(true);
            } else {
                nj3Var2.f(false);
            }
        }
        this.g.notifyDataSetChanged();
        h();
        this.c.setText(nj3Var.b());
        this.d.setText(nj3Var.b());
        if (nj3Var.b().equals("最近照片")) {
            this.e.c(this.j);
        } else {
            this.e.b(nj3Var.b(), this.j);
        }
    }
}
