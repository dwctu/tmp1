package com.wear.util.clipImage;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import com.wear.widget.MyActionBar;
import java.io.ByteArrayOutputStream;
import org.jivesoftware.smack.util.stringencoder.Base64;

/* loaded from: classes4.dex */
public class ClipImageActivity extends Activity {
    public MyActionBar a;
    public ClipImageLayout b;
    public MyApplication c;

    public class a implements MyActionBar.f {
        public a() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            Bitmap bitmapC = ClipImageActivity.this.b.c();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapC.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            ClipImageActivity.this.c.s0("avatar", Base64.encodeToString(byteArrayOutputStream.toByteArray()));
            ClipImageActivity.this.finish();
        }
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

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_clip_image);
        this.c = (MyApplication) getApplication();
        this.b = (ClipImageLayout) findViewById(R.id.id_clipImageLayout);
        this.a = (MyActionBar) findViewById(R.id.actionbar);
        this.b.setImage(getIntent().getExtras().getString("path"));
        this.a.setIconAction(Integer.valueOf(R.drawable.actionbar_clip_icon), new a());
    }
}
