package com.google.android.play.core.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import com.spotify.sdk.android.player.Config;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzcf {
    private final Context zza;

    public zzcf(Context context) {
        this.zza = context;
    }

    private static String zzb(Locale locale) {
        String strConcat;
        String strValueOf = String.valueOf(locale.getLanguage());
        if (locale.getCountry().isEmpty()) {
            strConcat = "";
        } else {
            String strValueOf2 = String.valueOf(locale.getCountry());
            strConcat = strValueOf2.length() != 0 ? Config.IN_FIELD_SEPARATOR.concat(strValueOf2) : new String(Config.IN_FIELD_SEPARATOR);
        }
        String strValueOf3 = String.valueOf(strConcat);
        return strValueOf3.length() != 0 ? strValueOf.concat(strValueOf3) : new String(strValueOf);
    }

    public final List zza() {
        Configuration configuration = this.zza.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT < 24) {
            return Collections.singletonList(zzb(configuration.locale));
        }
        LocaleList locales = configuration.getLocales();
        ArrayList arrayList = new ArrayList(locales.size());
        for (int i = 0; i < locales.size(); i++) {
            arrayList.add(zzb(locales.get(i)));
        }
        return arrayList;
    }
}
