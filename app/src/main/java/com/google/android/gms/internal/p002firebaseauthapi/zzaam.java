package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzaam {
    @NonNull
    public static zzui zza(@NonNull Exception exc, @NonNull String str, @NonNull String str2) {
        String str3 = "Failed to parse " + str + " for string [" + str2 + "] with exception: " + exc.getMessage();
        return new zzui("Failed to parse " + str + " for string [" + str2 + "]", exc);
    }

    @NonNull
    public static List zzb(@Nullable JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        return arrayList;
    }
}
