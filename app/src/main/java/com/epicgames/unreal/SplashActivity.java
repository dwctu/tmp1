package com.epicgames.unreal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import org.apache.commons.codec.language.bm.Rule;

/* loaded from: classes.dex */
public class SplashActivity extends Activity {
    public static Logger Log = new Logger("UE", "SplashActivity");
    private static final int PERMISSION_REQUEST_CODE = 1105;
    private static final int REQUEST_PERMISSION_SETTING = 1;
    private Intent GameActivityIntent;
    private String packageName;
    private PackageManager pm;
    private String[] permissionsRequiredAtStart = new String[0];
    private boolean WaitForPermission = false;

    private String[] filterRequiredPermissions(String str) {
        int i;
        int iIndexOf;
        String strSubstring;
        String str2 = Build.MANUFACTURER;
        ArrayList arrayList = new ArrayList();
        for (String str3 : str.split(",")) {
            String strReplaceAll = str3.replaceAll("\\s", "");
            if (strReplaceAll.length() > 0) {
                int iIndexOf2 = strReplaceAll.indexOf("|");
                if (iIndexOf2 > 1) {
                    String[] strArrSplit = strReplaceAll.substring(1, iIndexOf2 - 1).split(",");
                    int length = strArrSplit.length;
                    while (i < length) {
                        String str4 = strArrSplit[i];
                        try {
                            iIndexOf = str4.indexOf(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION);
                        } catch (Exception unused) {
                            Log.error("Error parsing required permissions: " + str4);
                        }
                        if (iIndexOf > 0) {
                            strSubstring = str4.substring(0, iIndexOf);
                            i = Build.VERSION.SDK_INT > Integer.parseInt(str4.substring(iIndexOf + 1)) ? i + 1 : 0;
                            str4 = strSubstring;
                        } else {
                            int iIndexOf3 = str4.indexOf(SimpleComparison.LESS_THAN_OPERATION);
                            if (iIndexOf3 > 0) {
                                strSubstring = str4.substring(0, iIndexOf3);
                                if (Build.VERSION.SDK_INT >= Integer.parseInt(str4.substring(iIndexOf3 + 1))) {
                                }
                                str4 = strSubstring;
                            } else {
                                int iIndexOf4 = str4.indexOf(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION);
                                if (iIndexOf4 > 0) {
                                    strSubstring = str4.substring(0, iIndexOf4);
                                    if (Build.VERSION.SDK_INT < Integer.parseInt(str4.substring(iIndexOf4 + 1))) {
                                    }
                                    str4 = strSubstring;
                                } else {
                                    int iIndexOf5 = str4.indexOf(SimpleComparison.GREATER_THAN_OPERATION);
                                    if (iIndexOf5 > 0) {
                                        strSubstring = str4.substring(0, iIndexOf5);
                                        if (Build.VERSION.SDK_INT <= Integer.parseInt(str4.substring(iIndexOf5 + 1))) {
                                        }
                                        str4 = strSubstring;
                                    } else {
                                        int iIndexOf6 = str4.indexOf("==");
                                        if (iIndexOf6 > 0) {
                                            strSubstring = str4.substring(0, iIndexOf6);
                                            if (Build.VERSION.SDK_INT != Integer.parseInt(str4.substring(iIndexOf6 + 1))) {
                                            }
                                            str4 = strSubstring;
                                        } else {
                                            int iIndexOf7 = str4.indexOf("!=");
                                            if (iIndexOf7 > 0) {
                                                strSubstring = str4.substring(0, iIndexOf7);
                                                if (Build.VERSION.SDK_INT == Integer.parseInt(str4.substring(iIndexOf7 + 1))) {
                                                    continue;
                                                }
                                                str4 = strSubstring;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (str4.equals(Rule.ALL) || str4.equals(str2)) {
                            arrayList.add(strReplaceAll.substring(iIndexOf2 + 1));
                            break;
                        }
                    }
                } else {
                    arrayList.add(strReplaceAll);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private int getResourceId(String str, String str2, String str3) {
        try {
            return getResources().getIdentifier(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getResourceStringOrDefault(String str, String str2, String str3) {
        int resourceId = getResourceId(str2, TypedValues.Custom.S_STRING, str);
        return resourceId < 1 ? str3 : getString(resourceId);
    }

    public ArrayList<String> getDangerousPermissions(PackageManager packageManager, String str) {
        PackageInfo packageInfo;
        String[] strArr;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            int i = packageManager.getPackageInfo(str, 0).applicationInfo.targetSdkVersion;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23 && i >= 23 && (packageInfo = packageManager.getPackageInfo(str, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length > 0) {
                if (i2 >= 28) {
                    for (String str2 : strArr) {
                        try {
                            if (packageManager.getPermissionInfo(str2, 0).getProtection() == 1) {
                                arrayList.add(str2);
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                    }
                } else {
                    for (String str3 : strArr) {
                        try {
                            if ((packageManager.getPermissionInfo(str3, 0).protectionLevel & 15) == 1) {
                                arrayList.add(str3);
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused3) {
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (arrayList.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
                arrayList.remove("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            if (arrayList.contains("android.permission.READ_EXTERNAL_STORAGE")) {
                arrayList.remove("android.permission.READ_EXTERNAL_STORAGE");
            }
        } else if (arrayList.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
            arrayList.remove("android.permission.READ_EXTERNAL_STORAGE");
        }
        return arrayList;
    }

    public String getRationale(String str) {
        return getResourceStringOrDefault(this.packageName, "PERM_Info_" + str, "This permission is required to start the game:\n" + str);
    }

    public ArrayList<String> getUngrantedPermissions(Context context, ArrayList<String> arrayList, String[] strArr) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (arrayList.size() > 0) {
            for (String str : strArr) {
                if (arrayList.contains(str) && ContextCompat.checkSelfPermission(context, str) != 0) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a8  */
    @Override // android.app.Activity
    @android.annotation.SuppressLint({"ObsoleteSdkInt"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r9) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.unreal.SplashActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.WaitForPermission) {
            return;
        }
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 1105 || strArr.length <= 0) {
            return;
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            String str = strArr[i2];
            if (iArr[i2] == -1) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                    showDialog(getResourceStringOrDefault(this.packageName, "PERM_Caption_PermRequired", "Permissions Required"), getRationale(str), false);
                    return;
                }
                String resourceStringOrDefault = getResourceStringOrDefault(this.packageName, "PERM_Caption_PermRequired", "Permissions Required");
                StringBuilder sb = new StringBuilder();
                sb.append(getResourceStringOrDefault(this.packageName, "PERM_Info_ApproveSettings", "You must approve this permission in App Settings:"));
                sb.append("\n\n");
                sb.append(getResourceStringOrDefault(this.packageName, "PERM_SettingsName_" + str, str));
                showDialog(resourceStringOrDefault, sb.toString(), true);
                return;
            }
        }
        startActivity(this.GameActivityIntent);
        finish();
        overridePendingTransition(0, 0);
    }

    public void showDialog(final String str, final String str2, final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.epicgames.unreal.SplashActivity.1
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setCancelable(false);
                builder.setTitle(str);
                builder.setMessage(str2);
                SplashActivity splashActivity = SplashActivity.this;
                builder.setNegativeButton(splashActivity.getResourceStringOrDefault(splashActivity.packageName, "PERM_Quit", "Quit"), new DialogInterface.OnClickListener() { // from class: com.epicgames.unreal.SplashActivity.1.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        System.exit(0);
                    }
                });
                if (z) {
                    SplashActivity splashActivity2 = SplashActivity.this;
                    builder.setPositiveButton(splashActivity2.getResourceStringOrDefault(splashActivity2.packageName, "PERM_Settings", "Settings"), new DialogInterface.OnClickListener() { // from class: com.epicgames.unreal.SplashActivity.1.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", SplashActivity.this.packageName, null));
                            SplashActivity.this.startActivityForResult(intent, 1);
                            System.exit(0);
                        }
                    });
                } else {
                    SplashActivity splashActivity3 = SplashActivity.this;
                    builder.setPositiveButton(splashActivity3.getResourceStringOrDefault(splashActivity3.packageName, "PERM_OK", "OK"), new DialogInterface.OnClickListener() { // from class: com.epicgames.unreal.SplashActivity.1.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            SplashActivity splashActivity4 = SplashActivity.this;
                            ArrayList<String> ungrantedPermissions = splashActivity4.getUngrantedPermissions(splashActivity4, splashActivity4.getDangerousPermissions(splashActivity4.pm, SplashActivity.this.packageName), SplashActivity.this.permissionsRequiredAtStart);
                            if (ungrantedPermissions.size() > 0) {
                                ActivityCompat.requestPermissions(SplashActivity.this, (String[]) ungrantedPermissions.toArray(new String[ungrantedPermissions.size()]), 1105);
                                return;
                            }
                            SplashActivity splashActivity5 = SplashActivity.this;
                            splashActivity5.startActivity(splashActivity5.GameActivityIntent);
                            SplashActivity.this.finish();
                            SplashActivity.this.overridePendingTransition(0, 0);
                        }
                    });
                }
                builder.create().show();
            }
        });
    }
}
