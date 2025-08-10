package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzay {
    private final com.google.android.play.core.splitcompat.zze zza;
    private final zzau zzb;
    private final Context zzc;
    private final zzax zzd;

    @Nullable
    private PackageInfo zze;

    public zzay(Context context, com.google.android.play.core.splitcompat.zze zzeVar, zzau zzauVar) {
        zzax zzaxVar = new zzax(new com.google.android.play.core.splitcompat.zza(zzeVar));
        this.zza = zzeVar;
        this.zzb = zzauVar;
        this.zzc = context;
        this.zzd = zzaxVar;
    }

    @Nullable
    private final PackageInfo zzd() {
        if (this.zze == null) {
            try {
                this.zze = this.zzc.getPackageManager().getPackageInfo(this.zzc.getPackageName(), 64);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return this.zze;
    }

    @Nullable
    private static X509Certificate zze(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException unused) {
            return null;
        }
    }

    public final boolean zza(File[] fileArr) throws XmlPullParserException, IOException {
        long longVersionCode = Build.VERSION.SDK_INT >= 28 ? zzd().getLongVersionCode() : r0.versionCode;
        AssetManager assetManager = (AssetManager) zzbw.zzc(AssetManager.class);
        int length = fileArr.length;
        do {
            length--;
            if (length < 0) {
                return true;
            }
            this.zzd.zzb(assetManager, fileArr[length]);
        } while (longVersionCode == this.zzd.zza());
        return false;
    }

    public final boolean zzb(List list) throws IOException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!this.zza.zzg(((Intent) it.next()).getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0076, code lost:
    
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 32);
        r2.append("Downloaded split ");
        r2.append(r5);
        r2.append(" is not signed.");
        r2.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzc(java.io.File[] r12) {
        /*
            r11 = this;
            java.lang.String r0 = " is not signed."
            java.lang.String r1 = "Downloaded split "
            android.content.pm.PackageInfo r2 = r11.zzd()
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L2a
            android.content.pm.Signature[] r5 = r2.signatures
            if (r5 != 0) goto L11
            goto L2a
        L11:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            android.content.pm.Signature[] r2 = r2.signatures
            int r5 = r2.length
            r6 = 0
        L1a:
            if (r6 >= r5) goto L2a
            r7 = r2[r6]
            java.security.cert.X509Certificate r7 = zze(r7)
            if (r7 == 0) goto L27
            r3.add(r7)
        L27:
            int r6 = r6 + 1
            goto L1a
        L2a:
            if (r3 == 0) goto Lb0
            boolean r2 = r3.isEmpty()
            if (r2 == 0) goto L34
            goto Lb0
        L34:
            int r2 = r12.length
        L35:
            int r2 = r2 + (-1)
            if (r2 < 0) goto Lae
            r5 = r12[r2]
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.lang.Exception -> Lad
            java.security.cert.X509Certificate[][] r6 = com.google.android.play.core.internal.zzi.zza(r5)     // Catch: java.lang.Exception -> L92
            if (r6 == 0) goto L76
            int r7 = r6.length     // Catch: java.lang.Exception -> Lad
            if (r7 == 0) goto L76
            r7 = r6[r4]     // Catch: java.lang.Exception -> Lad
            int r7 = r7.length     // Catch: java.lang.Exception -> Lad
            if (r7 != 0) goto L4e
            goto L76
        L4e:
            boolean r5 = r3.isEmpty()     // Catch: java.lang.Exception -> Lad
            if (r5 == 0) goto L55
            goto Lad
        L55:
            java.util.Iterator r5 = r3.iterator()     // Catch: java.lang.Exception -> Lad
        L59:
            boolean r7 = r5.hasNext()     // Catch: java.lang.Exception -> Lad
            if (r7 == 0) goto L35
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Exception -> Lad
            java.security.cert.X509Certificate r7 = (java.security.cert.X509Certificate) r7     // Catch: java.lang.Exception -> Lad
            int r8 = r6.length     // Catch: java.lang.Exception -> Lad
            r9 = 0
        L67:
            if (r9 >= r8) goto Lad
            r10 = r6[r9]     // Catch: java.lang.Exception -> Lad
            r10 = r10[r4]     // Catch: java.lang.Exception -> Lad
            boolean r10 = r10.equals(r7)     // Catch: java.lang.Exception -> Lad
            if (r10 != 0) goto L59
            int r9 = r9 + 1
            goto L67
        L76:
            java.lang.String r12 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> Lad
            int r12 = r12.length()     // Catch: java.lang.Exception -> Lad
            int r12 = r12 + 32
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lad
            r2.<init>(r12)     // Catch: java.lang.Exception -> Lad
            r2.append(r1)     // Catch: java.lang.Exception -> Lad
            r2.append(r5)     // Catch: java.lang.Exception -> Lad
            r2.append(r0)     // Catch: java.lang.Exception -> Lad
            r2.toString()     // Catch: java.lang.Exception -> Lad
            goto Lad
        L92:
            java.lang.String r12 = java.lang.String.valueOf(r5)     // Catch: java.lang.Exception -> Lad
            int r12 = r12.length()     // Catch: java.lang.Exception -> Lad
            int r12 = r12 + 32
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lad
            r2.<init>(r12)     // Catch: java.lang.Exception -> Lad
            r2.append(r1)     // Catch: java.lang.Exception -> Lad
            r2.append(r5)     // Catch: java.lang.Exception -> Lad
            r2.append(r0)     // Catch: java.lang.Exception -> Lad
            r2.toString()     // Catch: java.lang.Exception -> Lad
        Lad:
            return r4
        Lae:
            r12 = 1
            return r12
        Lb0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.zzay.zzc(java.io.File[]):boolean");
    }
}
