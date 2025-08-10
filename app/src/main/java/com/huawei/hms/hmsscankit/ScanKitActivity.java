package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.OrientationEventListener;
import android.view.ViewGroup;
import android.view.Window;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.R;

/* loaded from: classes3.dex */
public class ScanKitActivity extends Activity {
    private static final String TAG = "ScanKitActivity";
    private int lastRotation = Integer.MAX_VALUE;
    private OrientationEventListener mOrientationListener;
    private RemoteView remoteView;

    private void startOrientationChangeListener() {
        OrientationEventListener orientationEventListener = new OrientationEventListener(this) { // from class: com.huawei.hms.hmsscankit.ScanKitActivity.2
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                try {
                    int rotation = ScanKitActivity.this.getWindowManager().getDefaultDisplay().getRotation();
                    if (Math.abs(ScanKitActivity.this.lastRotation - rotation) == 2) {
                        ScanKitActivity.this.recreate();
                        StringBuilder sb = new StringBuilder();
                        sb.append("onOrientationChanged: currentRotation");
                        sb.append(rotation);
                        sb.toString();
                    }
                    ScanKitActivity.this.lastRotation = rotation;
                } catch (RuntimeException unused) {
                }
            }
        };
        this.mOrientationListener = orientationEventListener;
        orientationEventListener.enable();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.remoteView.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.scankit_layout);
        try {
        } catch (NullPointerException unused) {
            com.huawei.hms.scankit.util.a.c(TAG, "getIntExtra can not get");
        }
        int intExtra = getIntent() != null ? getIntent().getIntExtra(HmsScanBase.SCAN_FORMAT_FLAG, 0) : 0;
        RemoteView remoteView = new RemoteView(this, false, intExtra, null);
        this.remoteView = remoteView;
        remoteView.setOnResultCallback(new OnResultCallback() { // from class: com.huawei.hms.hmsscankit.ScanKitActivity.1
            @Override // com.huawei.hms.hmsscankit.OnResultCallback
            public void onResult(HmsScan[] hmsScanArr) {
                if (hmsScanArr == null || hmsScanArr.length <= 0 || hmsScanArr[0] == null || TextUtils.isEmpty(hmsScanArr[0].originalValue)) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(ScanUtil.RESULT, hmsScanArr[0]);
                ScanKitActivity.this.setResult(-1, intent);
                ScanKitActivity.this.finish();
            }
        });
        this.remoteView.onCreate(bundle);
        ((ViewGroup) findViewById(R.id.ll_top)).addView(this.remoteView);
        int i = Build.VERSION.SDK_INT;
        boolean zIsInMultiWindowMode = i >= 24 ? isInMultiWindowMode() : false;
        if (i >= 19 && (window = getWindow()) != null) {
            window.addFlags(201326592);
            if (zIsInMultiWindowMode) {
                window.clearFlags(134217728);
            }
        }
        if (i >= 28) {
            startOrientationChangeListener();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.remoteView.onDestroy();
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.remoteView.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.remoteView.onRequestPermissionsResult(i, strArr, iArr, this);
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.remoteView.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.remoteView.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.remoteView.onStop();
    }
}
