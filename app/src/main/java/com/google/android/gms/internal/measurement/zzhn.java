package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import androidx.collection.SimpleArrayMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzhn {
    private static volatile zzif zza;

    private zzhn() {
    }

    public static zzif zza(Context context) {
        zzif zzifVar;
        zzif zzifVarZzc;
        zzif zzifVarZzc2;
        synchronized (zzhn.class) {
            zzifVar = zza;
            if (zzifVar == null) {
                String str = Build.TYPE;
                String str2 = Build.TAGS;
                if ((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys"))) {
                    if (zzha.zzb() && !context.isDeviceProtectedStorage()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        StrictMode.allowThreadDiskWrites();
                        try {
                            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                            zzifVarZzc = file.exists() ? zzif.zzd(file) : zzif.zzc();
                        } catch (RuntimeException unused) {
                            zzifVarZzc = zzif.zzc();
                        }
                        if (zzifVarZzc.zzb()) {
                            File file2 = (File) zzifVarZzc.zza();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                try {
                                    SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                                    HashMap map = new HashMap();
                                    while (true) {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        String[] strArrSplit = line.split(" ", 3);
                                        if (strArrSplit.length != 3) {
                                            String str3 = "Invalid: " + line;
                                        } else {
                                            String str4 = new String(strArrSplit[0]);
                                            String strDecode = Uri.decode(new String(strArrSplit[1]));
                                            String strDecode2 = (String) map.get(strArrSplit[2]);
                                            if (strDecode2 == null) {
                                                String str5 = new String(strArrSplit[2]);
                                                strDecode2 = Uri.decode(str5);
                                                if (strDecode2.length() < 1024 || strDecode2 == str5) {
                                                    map.put(str5, strDecode2);
                                                }
                                            }
                                            if (!simpleArrayMap.containsKey(str4)) {
                                                simpleArrayMap.put(str4, new SimpleArrayMap());
                                            }
                                            ((SimpleArrayMap) simpleArrayMap.get(str4)).put(strDecode, strDecode2);
                                        }
                                    }
                                    String str6 = "Parsed " + file2.toString() + " for Android package " + context.getPackageName();
                                    zzhg zzhgVar = new zzhg(simpleArrayMap);
                                    bufferedReader.close();
                                    zzifVarZzc2 = zzif.zzd(zzhgVar);
                                } catch (Throwable th) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th2) {
                                        try {
                                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            zzifVarZzc2 = zzif.zzc();
                        }
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    } catch (Throwable th3) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th3;
                    }
                } else {
                    zzifVarZzc2 = zzif.zzc();
                }
                zzifVar = zzifVarZzc2;
                zza = zzifVar;
            }
        }
        return zzifVar;
    }
}
