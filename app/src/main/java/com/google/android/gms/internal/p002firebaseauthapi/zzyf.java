package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "CreateAuthUriResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzyf extends AbstractSafeParcelable implements zzwp<zzyf> {

    @SafeParcelable.Field(getter = "getAuthUri", id = 2)
    private String zzb;

    @SafeParcelable.Field(getter = "isRegistered", id = 3)
    private boolean zzc;

    @SafeParcelable.Field(getter = "getProviderId", id = 4)
    private String zzd;

    @SafeParcelable.Field(getter = "isForExistingProvider", id = 5)
    private boolean zze;

    @SafeParcelable.Field(getter = "getStringList", id = 6)
    private zzzy zzf;

    @SafeParcelable.Field(getter = "getSignInMethods", id = 7)
    private List zzg;
    private static final String zza = zzyf.class.getSimpleName();
    public static final Parcelable.Creator<zzyf> CREATOR = new zzyg();

    public zzyf() {
        this.zzf = new zzzy(null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwp
    public final /* bridge */ /* synthetic */ zzwp zza(String str) throws zzui {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("authUri", null);
            this.zzc = jSONObject.optBoolean("registered", false);
            this.zzd = jSONObject.optString("providerId", null);
            this.zze = jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                this.zzf = new zzzy(1, zzaam.zzb(jSONObject.optJSONArray("allProviders")));
            } else {
                this.zzf = new zzzy(null);
            }
            this.zzg = zzaam.zzb(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzaam.zza(e, zza, str);
        }
    }

    @Nullable
    public final List zzb() {
        return this.zzg;
    }

    @SafeParcelable.Constructor
    public zzyf(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) zzzy zzzyVar, @SafeParcelable.Param(id = 7) List list) {
        zzzy zzzyVarZza;
        this.zzb = str;
        this.zzc = z;
        this.zzd = str2;
        this.zze = z2;
        if (zzzyVar == null) {
            zzzyVarZza = new zzzy(null);
        } else {
            zzzyVarZza = zzzy.zza(zzzyVar);
        }
        this.zzf = zzzyVarZza;
        this.zzg = list;
    }
}
