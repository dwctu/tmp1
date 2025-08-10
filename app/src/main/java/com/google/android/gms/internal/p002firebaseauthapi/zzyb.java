package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.firebase.FirebaseApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzyb {
    private static final Map zza = new ArrayMap();
    private static final Map zzb = new ArrayMap();

    @NonNull
    public static String zza(String str) {
        zzxz zzxzVar;
        Map map = zza;
        synchronized (map) {
            zzxzVar = (zzxz) map.get(str);
        }
        if (zzxzVar != null) {
            return zzh(zzxzVar.zzb(), zzxzVar.zza(), zzxzVar.zzb().contains(SignatureImpl.INNER_SEP)).concat("emulator/auth/handler");
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    @NonNull
    public static String zzb(String str) {
        zzxz zzxzVar;
        Map map = zza;
        synchronized (map) {
            zzxzVar = (zzxz) map.get(str);
        }
        return (zzxzVar != null ? "".concat(zzh(zzxzVar.zzb(), zzxzVar.zza(), zzxzVar.zzb().contains(SignatureImpl.INNER_SEP))) : "https://").concat("www.googleapis.com/identitytoolkit/v3/relyingparty");
    }

    @NonNull
    public static String zzc(String str) {
        zzxz zzxzVar;
        Map map = zza;
        synchronized (map) {
            zzxzVar = (zzxz) map.get(str);
        }
        return (zzxzVar != null ? "".concat(zzh(zzxzVar.zzb(), zzxzVar.zza(), zzxzVar.zzb().contains(SignatureImpl.INNER_SEP))) : "https://").concat("identitytoolkit.googleapis.com/v2");
    }

    @NonNull
    public static String zzd(String str) {
        zzxz zzxzVar;
        Map map = zza;
        synchronized (map) {
            zzxzVar = (zzxz) map.get(str);
        }
        return (zzxzVar != null ? "".concat(zzh(zzxzVar.zzb(), zzxzVar.zza(), zzxzVar.zzb().contains(SignatureImpl.INNER_SEP))) : "https://").concat("securetoken.googleapis.com/v1");
    }

    public static void zze(String str, zzya zzyaVar) {
        Map map = zzb;
        synchronized (map) {
            if (map.containsKey(str)) {
                ((List) map.get(str)).add(new WeakReference(zzyaVar));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference(zzyaVar));
                map.put(str, arrayList);
            }
        }
    }

    public static void zzf(@NonNull FirebaseApp firebaseApp, @NonNull String str, int i) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map map = zza;
        synchronized (map) {
            map.put(apiKey, new zzxz(str, i));
        }
        Map map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(apiKey)) {
                Iterator it = ((List) map2.get(apiKey)).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    zzya zzyaVar = (zzya) ((WeakReference) it.next()).get();
                    if (zzyaVar != null) {
                        zzyaVar.zzi();
                        z = true;
                    }
                }
                if (!z) {
                    zza.remove(apiKey);
                }
            }
        }
    }

    public static boolean zzg(@NonNull FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }

    private static String zzh(String str, int i, boolean z) {
        if (z) {
            return "http://[" + str + "]:" + i + "/";
        }
        return "http://" + str + SignatureImpl.INNER_SEP + i + "/";
    }
}
