package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@SafeParcelable.Class(creator = "GetAccountInfoResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzyr extends AbstractSafeParcelable implements zzwp<zzyr> {

    @SafeParcelable.Field(getter = "getUserList", id = 2)
    private zzyv zzb;
    private static final String zza = zzyr.class.getSimpleName();
    public static final Parcelable.Creator<zzyr> CREATOR = new zzys();

    public zzyr() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzwp
    public final /* bridge */ /* synthetic */ zzwp zza(String str) throws JSONException, zzui {
        zzyv zzyvVar;
        int i;
        zzyt zzytVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("users")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("users");
                Parcelable.Creator<zzyv> creator = zzyv.CREATOR;
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    zzyvVar = new zzyv(new ArrayList());
                } else {
                    ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                    boolean z = false;
                    int i2 = 0;
                    while (i2 < jSONArrayOptJSONArray.length()) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                        if (jSONObject2 == null) {
                            zzytVar = new zzyt();
                            i = i2;
                        } else {
                            i = i2;
                            zzytVar = new zzyt(Strings.emptyToNull(jSONObject2.optString("localId", null)), Strings.emptyToNull(jSONObject2.optString("email", null)), jSONObject2.optBoolean("emailVerified", z), Strings.emptyToNull(jSONObject2.optString("displayName", null)), Strings.emptyToNull(jSONObject2.optString("photoUrl", null)), zzzi.zza(jSONObject2.optJSONArray("providerUserInfo")), Strings.emptyToNull(jSONObject2.optString("rawPassword", null)), Strings.emptyToNull(jSONObject2.optString("phoneNumber", null)), jSONObject2.optLong("createdAt", 0L), jSONObject2.optLong("lastLoginAt", 0L), false, null, zzze.zzf(jSONObject2.optJSONArray("mfaInfo")));
                        }
                        arrayList.add(zzytVar);
                        i2 = i + 1;
                        z = false;
                    }
                    zzyvVar = new zzyv(arrayList);
                }
                this.zzb = zzyvVar;
            } else {
                this.zzb = new zzyv();
            }
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzaam.zza(e, zza, str);
        }
    }

    public final List zzb() {
        return this.zzb.zzb();
    }

    @SafeParcelable.Constructor
    public zzyr(@SafeParcelable.Param(id = 2) zzyv zzyvVar) {
        this.zzb = zzyvVar == null ? new zzyv() : zzyv.zza(zzyvVar);
    }
}
