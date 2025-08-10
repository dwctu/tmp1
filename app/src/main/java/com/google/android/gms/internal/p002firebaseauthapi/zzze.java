package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "MfaInfoCreator")
/* loaded from: classes2.dex */
public final class zzze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzze> CREATOR = new zzzf();

    @Nullable
    @SafeParcelable.Field(getter = "getPhoneInfo", id = 1)
    private final String zza;

    @NonNull
    @SafeParcelable.Field(getter = "getMfaEnrollmentId", id = 2)
    private final String zzb;

    @SafeParcelable.Field(getter = "getDisplayName", id = 3)
    private final String zzc;

    @SafeParcelable.Field(getter = "getEnrolledAtTimestampInSeconds", id = 4)
    private final long zzd;

    @Nullable
    private String zze;

    @SafeParcelable.Constructor
    public zzze(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) long j) {
        this.zza = str;
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = j;
    }

    public static zzze zzb(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        String strOptString = jSONObject.optString("phoneInfo", null);
        String strOptString2 = jSONObject.optString("mfaEnrollmentId", null);
        String strOptString3 = jSONObject.optString("displayName", null);
        long jOptLong = 0;
        if (jSONObject != null && jSONObject.has("enrolledAt") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("enrolledAt")) != null && jSONObjectOptJSONObject.has("seconds")) {
            jOptLong = jSONObjectOptJSONObject.optLong("seconds", 0L);
        }
        zzze zzzeVar = new zzze(strOptString, strOptString2, strOptString3, jOptLong);
        zzzeVar.zze = jSONObject.optString("unobfuscatedPhoneInfo");
        return zzzeVar;
    }

    public static List zzf(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zzb(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final long zza() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }

    @Nullable
    public final String zze() {
        return this.zza;
    }
}
