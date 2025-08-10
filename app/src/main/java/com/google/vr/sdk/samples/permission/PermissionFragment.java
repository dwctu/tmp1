package com.google.vr.sdk.samples.permission;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import androidx.legacy.app.FragmentCompat;

/* loaded from: classes2.dex */
public class PermissionFragment extends Fragment implements FragmentCompat.OnRequestPermissionsResultCallback {
    private static final int PERMISSION_REQUEST_CODE = 1101;
    private static final String PERMISSION_TAG = "TAG_PermissionFragment";
    private static final String TAG = "PermissionFragment";

    public static PermissionFragment getInstance(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        PermissionFragment permissionFragment = (PermissionFragment) fragmentManager.findFragmentByTag(PERMISSION_TAG);
        if (permissionFragment != null) {
            return permissionFragment;
        }
        try {
            PermissionFragment permissionFragment2 = new PermissionFragment();
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.add(permissionFragment2, PERMISSION_TAG);
            fragmentTransactionBeginTransaction.commit();
            fragmentManager.executePendingTransactions();
            return permissionFragment2;
        } catch (Throwable th) {
            String str = "Cannot launch PermissionFragment:" + th.getMessage();
            return null;
        }
    }

    public void acquirePermissions(String[] strArr) {
        FragmentCompat.requestPermissions(this, strArr, 1101);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // android.app.Fragment, androidx.legacy.app.FragmentCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 1101 || strArr.length <= 0) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            String str = "permission not granted for " + strArr[0];
        } else {
            String str2 = "permission granted for " + strArr[0];
        }
        PermissionHelper.onAcquirePermissions(strArr, iArr);
    }
}
