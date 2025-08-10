package com.wear.ui.longDistance.imagepicker.ui;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.ui.longDistance.imagepicker.adapter.ImagePreViewAdapter;
import com.wear.ui.longDistance.imagepicker.data.MediaFile;
import com.wear.ui.longDistance.imagepicker.provider.ImagePickerProvider;
import com.wear.ui.longDistance.imagepicker.view.HackyViewPager;
import dc.f93;
import dc.g93;
import dc.k93;
import dc.sg3;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class ImagePreActivity extends BaseActivity {
    public List<MediaFile> a;
    public int b = 0;
    public TextView c;
    public ImageView d;
    public HackyViewPager e;
    public LinearLayout f;
    public ImageView g;
    public ImagePreViewAdapter h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePreActivity.this.finish();
        }
    }

    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ImagePreActivity imagePreActivity = ImagePreActivity.this;
            imagePreActivity.B4((MediaFile) imagePreActivity.a.get(i));
            ImagePreActivity imagePreActivity2 = ImagePreActivity.this;
            imagePreActivity2.E4(((MediaFile) imagePreActivity2.a.get(i)).f());
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f93.b().j()) {
                ArrayList<String> arrayListE = g93.c().e();
                if (!arrayListE.isEmpty() && !g93.g(((MediaFile) ImagePreActivity.this.a.get(ImagePreActivity.this.e.getCurrentItem())).f(), arrayListE.get(0))) {
                    sg3.l(ImagePreActivity.this.getString(R.string.single_type_choose));
                    return;
                }
            }
            if (g93.c().b(((MediaFile) ImagePreActivity.this.a.get(ImagePreActivity.this.e.getCurrentItem())).f(), (MediaFile) ImagePreActivity.this.a.get(ImagePreActivity.this.e.getCurrentItem()))) {
                ImagePreActivity imagePreActivity = ImagePreActivity.this;
                imagePreActivity.E4(((MediaFile) imagePreActivity.a.get(ImagePreActivity.this.e.getCurrentItem())).f());
                ImagePreActivity.this.D4();
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePreActivity.this.setResult(-1, new Intent());
            ImagePreActivity.this.finish();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePreActivity.this.C4();
        }
    }

    public void A4() {
        this.c = (TextView) findViewById(R.id.ac_preview_tv_send);
        this.d = (ImageView) findViewById(R.id.iv_main_play);
        this.e = (HackyViewPager) findViewById(R.id.vp_main_preImage);
        this.f = (LinearLayout) findViewById(R.id.ll_pre_select);
        this.g = (ImageView) findViewById(R.id.iv_item_check);
    }

    public final void B4(MediaFile mediaFile) {
        if (mediaFile.b() > 0) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
    }

    public final void C4() {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri uriForFile = FileProvider.getUriForFile(this, ImagePickerProvider.a(this), new File(this.a.get(this.e.getCurrentItem()).f()));
        intent.setDataAndType(uriForFile, "video/*");
        Iterator<ResolveInfo> it = getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            grantUriPermission(it.next().activityInfo.packageName, uriForFile, 3);
        }
        startActivity(intent);
    }

    public final void D4() {
        int iD = g93.c().d();
        int size = g93.c().e().size();
        if (size == 0) {
            this.c.setEnabled(false);
            this.c.setText(getString(R.string.confirm));
        } else if (size < iD) {
            this.c.setEnabled(true);
            this.c.setText(String.format(getString(R.string.confirm_msg2), Integer.valueOf(size)));
        } else if (size == iD) {
            this.c.setEnabled(true);
            this.c.setText(String.format(getString(R.string.confirm_msg2), Integer.valueOf(size)));
        }
    }

    public final void E4(String str) {
        if (g93.c().i(str)) {
            this.g.setImageDrawable(getResources().getDrawable(R.drawable.icon_image_checked));
        } else {
            this.g.setImageDrawable(getResources().getDrawable(R.drawable.icon_image_check));
        }
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pre_image);
        ButterKnife.bind(this);
        A4();
        z4();
        y4();
    }

    public void y4() throws Resources.NotFoundException {
        this.a = k93.a().c();
        this.b = getIntent().getIntExtra("imagePosition", 0);
        ImagePreViewAdapter imagePreViewAdapter = new ImagePreViewAdapter(this, this.a);
        this.h = imagePreViewAdapter;
        this.e.setAdapter(imagePreViewAdapter);
        this.e.setCurrentItem(this.b);
        B4(this.a.get(this.b));
        E4(this.a.get(this.b).f());
        D4();
    }

    public void z4() {
        findViewById(R.id.iv_actionBar_back).setOnClickListener(new a());
        this.e.addOnPageChangeListener(new b());
        this.f.setOnClickListener(new c());
        this.c.setOnClickListener(new d());
        this.d.setOnClickListener(new e());
    }
}
