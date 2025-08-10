package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public class zzacp extends IOException {
    private zzadm zza;

    public zzacp(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    public static zzaco zza() {
        return new zzaco("Protocol message tag had invalid wire type.");
    }

    public static zzacp zzb() {
        return new zzacp("Protocol message end-group tag did not match expected tag.");
    }

    public static zzacp zzc() {
        return new zzacp("Protocol message contained an invalid tag (zero).");
    }

    public static zzacp zzd() {
        return new zzacp("Protocol message had invalid UTF-8.");
    }

    public static zzacp zze() {
        return new zzacp("CodedInputStream encountered a malformed varint.");
    }

    public static zzacp zzf() {
        return new zzacp("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzacp zzg() {
        return new zzacp("Failed to parse the message.");
    }

    public static zzacp zzi() {
        return new zzacp("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzacp zzh(zzadm zzadmVar) {
        this.zza = zzadmVar;
        return this;
    }

    public zzacp(String str) {
        super(str);
        this.zza = null;
    }
}
