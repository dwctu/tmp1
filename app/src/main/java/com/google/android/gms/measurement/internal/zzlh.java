package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.j256.ormlite.field.FieldType;
import com.spotify.sdk.android.player.Config;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzlh extends zzgs {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private static final String[] zzb = {"_err"};
    private SecureRandom zzc;
    private final AtomicLong zzd;
    private int zze;
    private Integer zzf;

    public zzlh(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzf = null;
        this.zzd = new AtomicLong(0L);
    }

    public static MessageDigest zzF() throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static ArrayList zzH(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzac zzacVar = (zzac) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzacVar.zza);
            bundle.putString("origin", zzacVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzacVar.zzd);
            bundle.putString("name", zzacVar.zzc.zzb);
            zzgu.zzb(bundle, Preconditions.checkNotNull(zzacVar.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzacVar.zze);
            String str = zzacVar.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzaw zzawVar = zzacVar.zzg;
            if (zzawVar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzawVar.zza);
                zzau zzauVar = zzawVar.zzb;
                if (zzauVar != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzauVar.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzacVar.zzh);
            zzaw zzawVar2 = zzacVar.zzi;
            if (zzawVar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzawVar2.zza);
                zzau zzauVar2 = zzawVar2.zzb;
                if (zzauVar2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzauVar2.zzc());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzacVar.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzacVar.zzj);
            zzaw zzawVar3 = zzacVar.zzk;
            if (zzawVar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzawVar3.zza);
                zzau zzauVar3 = zzawVar3.zzb;
                if (zzauVar3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzauVar3.zzc());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    @WorkerThread
    public static void zzK(zzik zzikVar, Bundle bundle, boolean z) {
        if (bundle != null && zzikVar != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zzikVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzikVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzikVar.zzc);
                return;
            }
            z = false;
        }
        if (bundle != null && zzikVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static boolean zzah(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(Config.IN_FIELD_SEPARATOR);
    }

    public static boolean zzai(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean zzaj(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean zzak(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return Build.VERSION.SDK_INT >= 24 ? zzat(context, "com.google.android.gms.measurement.AppMeasurementJobService") : zzat(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean zzal(String str) {
        return !zzb[0].equals(str);
    }

    public static final boolean zzao(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    @VisibleForTesting
    public static final boolean zzap(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private final int zzaq(String str) {
        if ("_ldl".equals(str)) {
            this.zzs.zzf();
            return 2048;
        }
        if (FieldType.FOREIGN_ID_FIELD_SUFFIX.equals(str)) {
            this.zzs.zzf();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            this.zzs.zzf();
            return 100;
        }
        this.zzs.zzf();
        return 36;
    }

    private final Object zzar(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return zzD(obj.toString(), i, z);
        }
        if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleZzt = zzt((Bundle) parcelable);
                if (!bundleZzt.isEmpty()) {
                    arrayList.add(bundleZzt);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private static boolean zzas(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (zzlf.zza(str, str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzat(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    @VisibleForTesting
    public static long zzp(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        Preconditions.checkState(length > 0);
        long j = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (bArr[i2] & 255) << i;
            i += 8;
        }
        return j;
    }

    public final Object zzA(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            this.zzs.zzf();
            return zzar(256, obj, true, true);
        }
        if (zzah(str)) {
            this.zzs.zzf();
        } else {
            this.zzs.zzf();
            i = 100;
        }
        return zzar(i, obj, false, true);
    }

    public final Object zzB(String str, Object obj) {
        return "_ldl".equals(str) ? zzar(zzaq(str), obj, true, false) : zzar(zzaq(str), obj, false, false);
    }

    public final String zzC() {
        byte[] bArr = new byte[16];
        zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final String zzD(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public final URL zzE(long j, String str, String str2, long j2) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 73000L, Integer.valueOf(zzm())), str2, str, Long.valueOf(j2));
            if (str.equals(this.zzs.zzf().zzm())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException | MalformedURLException e) {
            this.zzs.zzay().zzd().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    @EnsuresNonNull({"this.secureRandom"})
    @WorkerThread
    public final SecureRandom zzG() {
        zzg();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    @WorkerThread
    public final void zzI(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzs.zzay().zzk().zzb("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzJ(Bundle bundle, int i, String str, String str2, Object obj) {
        if (zzao(bundle, i)) {
            this.zzs.zzf();
            bundle.putString("_ev", zzD(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final void zzL(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.zzs.zzv().zzO(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void zzM(zzep zzepVar, int i) {
        int i2 = 0;
        for (String str : new TreeSet(zzepVar.zzd.keySet())) {
            if (zzai(str) && (i2 = i2 + 1) > i) {
                this.zzs.zzay().zze().zzc("Event can't contain more than " + i + " params", this.zzs.zzj().zzd(zzepVar.zza), this.zzs.zzj().zzb(zzepVar.zzd));
                zzao(zzepVar.zzd, 5);
                zzepVar.zzd.remove(str);
            }
        }
    }

    public final void zzN(zzlg zzlgVar, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzao(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        zzlgVar.zza(str, "_err", bundle);
    }

    public final void zzO(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            this.zzs.zzay().zzl().zzc("Not putting event parameter. Invalid value type. name, type", this.zzs.zzj().zze(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void zzP(com.google.android.gms.internal.measurement.zzcf zzcfVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(StreamManagement.AckRequest.ELEMENT, z);
        try {
            zzcfVar.zzd(bundle);
        } catch (RemoteException e) {
            this.zzs.zzay().zzk().zzb("Error returning boolean value to wrapper", e);
        }
    }

    public final void zzQ(com.google.android.gms.internal.measurement.zzcf zzcfVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(StreamManagement.AckRequest.ELEMENT, arrayList);
        try {
            zzcfVar.zzd(bundle);
        } catch (RemoteException e) {
            this.zzs.zzay().zzk().zzb("Error returning bundle list to wrapper", e);
        }
    }

    public final void zzR(com.google.android.gms.internal.measurement.zzcf zzcfVar, Bundle bundle) {
        try {
            zzcfVar.zzd(bundle);
        } catch (RemoteException e) {
            this.zzs.zzay().zzk().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public final void zzS(com.google.android.gms.internal.measurement.zzcf zzcfVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(StreamManagement.AckRequest.ELEMENT, bArr);
        try {
            zzcfVar.zzd(bundle);
        } catch (RemoteException e) {
            this.zzs.zzay().zzk().zzb("Error returning byte array to wrapper", e);
        }
    }

    public final void zzT(com.google.android.gms.internal.measurement.zzcf zzcfVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(StreamManagement.AckRequest.ELEMENT, i);
        try {
            zzcfVar.zzd(bundle);
        } catch (RemoteException e) {
            this.zzs.zzay().zzk().zzb("Error returning int value to wrapper", e);
        }
    }

    public final void zzU(com.google.android.gms.internal.measurement.zzcf zzcfVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong(StreamManagement.AckRequest.ELEMENT, j);
        try {
            zzcfVar.zzd(bundle);
        } catch (RemoteException e) {
            this.zzs.zzay().zzk().zzb("Error returning long value to wrapper", e);
        }
    }

    public final void zzV(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(StreamManagement.AckRequest.ELEMENT, str);
        try {
            zzcfVar.zzd(bundle);
        } catch (RemoteException e) {
            this.zzs.zzay().zzk().zzb("Error returning string value to wrapper", e);
        }
    }

    public final void zzW(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int i;
        String str4;
        int iZza;
        if (bundle == null) {
            return;
        }
        this.zzs.zzf();
        int i2 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                int iZzj = !z ? zzj(str5) : 0;
                if (iZzj == 0) {
                    iZzj = zzi(str5);
                }
                i = iZzj;
            } else {
                i = 0;
            }
            if (i != 0) {
                zzJ(bundle, i, str5, str5, i == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (zzaf(bundle.get(str5))) {
                    this.zzs.zzay().zzl().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    str4 = str5;
                    iZza = 22;
                } else {
                    str4 = str5;
                    iZza = zza(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                }
                if (iZza != 0 && !"_ev".equals(str4)) {
                    zzJ(bundle, iZza, str4, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (zzai(str4) && !zzas(str4, zzgw.zzd) && (i2 = i2 + 1) > 0) {
                    this.zzs.zzay().zze().zzc("Item cannot contain custom parameters", this.zzs.zzj().zzd(str2), this.zzs.zzj().zzb(bundle));
                    zzao(bundle, 23);
                    bundle.remove(str4);
                }
            }
        }
    }

    public final boolean zzX(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (zzap(str)) {
                return true;
            }
            if (this.zzs.zzL()) {
                this.zzs.zzay().zze().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzeo.zzn(str));
            }
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.zzs.zzL()) {
                this.zzs.zzay().zze().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        if (zzap(str2)) {
            return true;
        }
        this.zzs.zzay().zze().zzb("Invalid admob_app_id. Analytics disabled.", zzeo.zzn(str2));
        return false;
    }

    public final boolean zzY(String str, int i, String str2) {
        if (str2 == null) {
            this.zzs.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        this.zzs.zzay().zze().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    public final boolean zzZ(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzs.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zza;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzs.zzay().zze().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzas(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zzas(str2, strArr2)) {
            return true;
        }
        this.zzs.zzay().zze().zzc("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.zza(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    @WorkerThread
    public final void zzaA() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                this.zzs.zzay().zzk().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(jNextLong);
    }

    public final boolean zzaa(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String string = obj.toString();
            if (string.codePointCount(0, string.length()) > i) {
                this.zzs.zzay().zzl().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean zzab(String str, String str2) {
        if (str2 == null) {
            this.zzs.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzs.zzay().zze().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                this.zzs.zzay().zze().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.zzs.zzay().zze().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean zzac(String str, String str2) {
        if (str2 == null) {
            this.zzs.zzay().zze().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.zzs.zzay().zze().zzb("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            this.zzs.zzay().zze().zzc("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.zzs.zzay().zze().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    @WorkerThread
    public final boolean zzad(String str) {
        zzg();
        if (Wrappers.packageManager(this.zzs.zzau()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        this.zzs.zzay().zzc().zzb("Permission not granted", str);
        return false;
    }

    public final boolean zzae(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strZzl = this.zzs.zzf().zzl();
        this.zzs.zzaw();
        return strZzl.equals(str);
    }

    public final boolean zzaf(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    @VisibleForTesting
    public final boolean zzag(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            this.zzs.zzay().zzd().zzb("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            this.zzs.zzay().zzd().zzb("Error obtaining certificate", e2);
            return true;
        }
    }

    public final boolean zzam(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (zIsEmpty) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public final byte[] zzan(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public final int zzd(String str, Object obj) {
        return "_ldl".equals(str) ? zzaa("user property referrer", str, zzaq(str), obj) : zzaa("user property", str, zzaq(str), obj) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final boolean zzf() {
        return true;
    }

    public final int zzh(String str) {
        if (!zzab("event", str)) {
            return 2;
        }
        if (!zzZ("event", zzgv.zza, zzgv.zzb, str)) {
            return 13;
        }
        this.zzs.zzf();
        return !zzY("event", 40, str) ? 2 : 0;
    }

    public final int zzi(String str) {
        if (!zzab("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", null, null, str)) {
            return 14;
        }
        this.zzs.zzf();
        return !zzY("event param", 40, str) ? 3 : 0;
    }

    public final int zzj(String str) {
        if (!zzac("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", null, null, str)) {
            return 14;
        }
        this.zzs.zzf();
        return !zzY("event param", 40, str) ? 3 : 0;
    }

    public final int zzl(String str) {
        if (!zzab("user property", str)) {
            return 6;
        }
        if (!zzZ("user property", zzgx.zza, null, str)) {
            return 15;
        }
        this.zzs.zzf();
        return !zzY("user property", 24, str) ? 6 : 0;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzm() {
        if (this.zzf == null) {
            this.zzf = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzs.zzau()) / 1000);
        }
        return this.zzf.intValue();
    }

    public final int zzo(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzs.zzau(), 12451000);
    }

    public final long zzq() {
        long andIncrement;
        long j;
        if (this.zzd.get() != 0) {
            synchronized (this.zzd) {
                this.zzd.compareAndSet(-1L, 1L);
                andIncrement = this.zzd.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.zzd) {
            long jNextLong = new Random(System.nanoTime() ^ this.zzs.zzav().currentTimeMillis()).nextLong();
            int i = this.zze + 1;
            this.zze = i;
            j = jNextLong + i;
        }
        return j;
    }

    public final long zzr(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    public final Bundle zzs(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    queryParameter = uri.getQueryParameter("utm_campaign");
                    queryParameter2 = uri.getQueryParameter("utm_source");
                    queryParameter3 = uri.getQueryParameter("utm_medium");
                    queryParameter4 = uri.getQueryParameter("gclid");
                    queryParameter5 = uri.getQueryParameter("utm_id");
                    queryParameter6 = uri.getQueryParameter("dclid");
                    queryParameter7 = uri.getQueryParameter("srsltid");
                } else {
                    queryParameter = null;
                    queryParameter2 = null;
                    queryParameter3 = null;
                    queryParameter4 = null;
                    queryParameter5 = null;
                    queryParameter6 = null;
                    queryParameter7 = null;
                }
                if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("campaign", queryParameter);
                }
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("source", queryParameter2);
                }
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString("medium", queryParameter3);
                }
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("gclid", queryParameter4);
                }
                String queryParameter8 = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter8);
                }
                String queryParameter9 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter9)) {
                    bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter9);
                }
                String queryParameter10 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (!TextUtils.isEmpty(queryParameter10)) {
                    bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter10);
                }
                String queryParameter11 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
                if (!TextUtils.isEmpty(queryParameter11)) {
                    bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter11);
                }
                String queryParameter12 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter12)) {
                    bundle.putString("anid", queryParameter12);
                }
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("campaign_id", queryParameter5);
                }
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("dclid", queryParameter6);
                }
                String queryParameter13 = uri.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter13)) {
                    bundle.putString("source_platform", queryParameter13);
                }
                String queryParameter14 = uri.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter14)) {
                    bundle.putString("creative_format", queryParameter14);
                }
                String queryParameter15 = uri.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter15)) {
                    bundle.putString("marketing_tactic", queryParameter15);
                }
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("srsltid", queryParameter7);
                }
                return bundle;
            } catch (UnsupportedOperationException e) {
                this.zzs.zzay().zzk().zzb("Install referrer url isn't a hierarchical URI", e);
            }
        }
        return null;
    }

    public final Bundle zzt(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objZzA = zzA(str, bundle.get(str));
                if (objZzA == null) {
                    this.zzs.zzay().zzl().zzb("Param value can't be null", this.zzs.zzj().zze(str));
                } else {
                    zzO(bundle2, str, objZzA);
                }
            }
        }
        return bundle2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0106 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zzy(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, java.util.List r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlh.zzy(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    public final zzaw zzz(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzh(str2) != 0) {
            this.zzs.zzay().zzd().zzb("Invalid conditional property event name", this.zzs.zzj().zzf(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, str3);
        Bundle bundleZzy = zzy(str, str2, bundle2, CollectionUtils.listOf(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY), true);
        if (z) {
            bundleZzy = zzt(bundleZzy);
        }
        Preconditions.checkNotNull(bundleZzy);
        return new zzaw(str2, new zzau(bundleZzy), str3, j);
    }
}
