package com.wear.main.longDistance.scan;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.chrisbanes.photoview.PhotoView;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import dc.ej3;

/* loaded from: classes3.dex */
public class PictureEnlargeActivity extends AppCompatActivity {
    public ImageView a;
    public PhotoView b;
    public Uri c;
    public int d;
    public TextView e;
    public boolean f = false;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PictureEnlargeActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PictureEnlargeActivity.this.finish();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PictureEnlargeActivity.this.c != null) {
                Intent intent = new Intent();
                intent.putExtra("img_uri", PictureEnlargeActivity.this.c.toString());
                PictureEnlargeActivity.this.setResult(-1, intent);
            }
            PictureEnlargeActivity.this.finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_picture_enlarge);
        this.b = (PhotoView) findViewById(R.id.pic_img);
        this.a = (ImageView) findViewById(R.id.iv_back);
        this.e = (TextView) findViewById(R.id.tv_send);
        String stringExtra = getIntent().getStringExtra("picture_uri");
        if (stringExtra != null) {
            this.c = Uri.parse(stringExtra);
        }
        this.d = getIntent().getIntExtra("picture_resources", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("hide_upper_right", false);
        this.f = booleanExtra;
        if (booleanExtra) {
            this.e.setVisibility(8);
            this.a.setVisibility(8);
        }
        if (this.c == null) {
            Drawable drawable = getDrawable(this.d);
            this.a.setVisibility(8);
            this.b.setImageDrawable(drawable);
        } else {
            ej3.a(this).r(this.c).A0(this.b);
        }
        this.b.setOnClickListener(new a());
        this.a.setOnClickListener(new b());
        this.e.setOnClickListener(new c());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MyApplication.N().q0(this);
    }
}
