package com.wear.phonertc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import com.wear.util.MyApplication;
import dc.gg3;

/* loaded from: classes3.dex */
public class RequestPermissionActivity extends AppCompatActivity {
    public static int c = 111;
    public ImageView a;
    public String[] b = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.INTERNET"};

    public static boolean r4(Context context, String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void s4(Activity activity) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        int i = Build.VERSION.SDK_INT;
        if (i >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        } else if (i <= 8) {
            intent.setAction("android.intent.action.VIEW");
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", activity.getPackageName());
        }
        activity.overridePendingTransition(0, 0);
        activity.startActivity(intent);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        super.onCreate(bundle);
        setContentView(R.layout.request_camer_activity);
        this.a = (ImageView) findViewById(R.id.background_image);
        this.b = getIntent().getStringArrayExtra("permission_perms");
        Bitmap bitmap = gg3.d;
        if (bitmap != null) {
            this.a.setImageBitmap(bitmap);
        }
        if (Build.VERSION.SDK_INT <= 22) {
            finish();
        } else if (r4(this, this.b)) {
            finish();
        } else {
            ActivityCompat.requestPermissions(this, this.b, c);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        gg3.d = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == c) {
            if (iArr.length <= 0 || !q4(iArr)) {
                t4(false, iArr);
            } else {
                t4(true, iArr);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MyApplication.N().q0(this);
    }

    public final boolean q4(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public void t4(boolean z, int[] iArr) {
        Intent intent = new Intent();
        intent.putExtra("grant_all", z);
        intent.putExtra("grant_results", iArr);
        setResult(-1, intent);
        finish();
    }
}
